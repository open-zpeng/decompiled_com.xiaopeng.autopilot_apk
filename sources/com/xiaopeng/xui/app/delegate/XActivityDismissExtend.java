package com.xiaopeng.xui.app.delegate;

import android.app.Activity;
import android.os.Handler;
import com.xiaopeng.xui.app.delegate.XActivityDismiss;
import com.xiaopeng.xui.app.delegate.XActivityDismissExtend;
import com.xiaopeng.xui.utils.XActivityUtils;
import com.xiaopeng.xui.utils.XLogUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class XActivityDismissExtend implements XActivityDismiss, XActivityLifecycle {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnDismissListenerEx {
        void afterDismiss(int i);

        void beforeDismiss(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setOnDismissListenerEx(OnDismissListenerEx onDismissListenerEx);

    XActivityDismissExtend() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static XActivityDismissExtend create(Activity activity) {
        return new XActivityDismissExtendImpl(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class XActivityDismissExtendImpl extends XActivityDismissExtend {
        private static final String TAG = "XActivityDismiss";
        private Activity mActivity;
        private Runnable mDelayRunnable;
        private XActivityDismiss.OnDismissListener mOnDismissListener;
        private OnDismissListenerEx mOnDismissListenerEx;
        private int mDismissType = 0;
        private long mDismissDelay = 0;
        private final Handler mHandler = new Handler();

        private String convertCauseToString(int i) {
            switch (i) {
                case 1:
                    return "back";
                case 2:
                    return "pause";
                case 3:
                    return "outside";
                case 4:
                    return "timeout";
                default:
                    return "user";
            }
        }

        private String convertTypeToString(int i) {
            return i != 1 ? "finish" : "moveToBack";
        }

        XActivityDismissExtendImpl(Activity activity) {
            this.mActivity = activity;
        }

        @Override // com.xiaopeng.xui.app.delegate.XActivityDismiss
        public void setDismissDelay(long j) {
            this.mDismissDelay = j;
            XLogUtils.i(TAG, "setDismissDelay: " + j);
        }

        @Override // com.xiaopeng.xui.app.delegate.XActivityDismiss
        public void setOnDismissListener(XActivityDismiss.OnDismissListener onDismissListener) {
            this.mOnDismissListener = onDismissListener;
        }

        @Override // com.xiaopeng.xui.app.delegate.XActivityDismissExtend
        void setOnDismissListenerEx(OnDismissListenerEx onDismissListenerEx) {
            this.mOnDismissListenerEx = onDismissListenerEx;
        }

        @Override // com.xiaopeng.xui.app.delegate.XActivityDismiss
        public void setDismissType(int i) {
            this.mDismissType = i;
        }

        @Override // com.xiaopeng.xui.app.delegate.XActivityDismiss
        public void dismiss(final int i) {
            XActivityDismiss.OnDismissListener onDismissListener = this.mOnDismissListener;
            if (onDismissListener != null && onDismissListener.onDismiss(i, this.mDismissType)) {
                XLogUtils.i(TAG, "dismiss: intercept for " + convertCauseToString(i));
                return;
            }
            OnDismissListenerEx onDismissListenerEx = this.mOnDismissListenerEx;
            if (onDismissListenerEx != null) {
                onDismissListenerEx.beforeDismiss(i);
            }
            if (this.mDismissDelay == 0) {
                _dismiss(i);
                return;
            }
            XLogUtils.i(TAG, "dismiss: type : " + convertTypeToString(this.mDismissType) + " , cause : " + convertCauseToString(i) + " " + this.mDelayRunnable);
            if (this.mDelayRunnable == null) {
                this.mDelayRunnable = new Runnable() { // from class: com.xiaopeng.xui.app.delegate.-$$Lambda$XActivityDismissExtend$XActivityDismissExtendImpl$tIuePlo6tgyIqeCB2NgnAPhvdYk
                    @Override // java.lang.Runnable
                    public final void run() {
                        XActivityDismissExtend.XActivityDismissExtendImpl.lambda$dismiss$0(XActivityDismissExtend.XActivityDismissExtendImpl.this, i);
                    }
                };
                this.mHandler.postDelayed(this.mDelayRunnable, this.mDismissDelay);
            }
        }

        public static /* synthetic */ void lambda$dismiss$0(XActivityDismissExtendImpl xActivityDismissExtendImpl, int i) {
            xActivityDismissExtendImpl._dismiss(i);
            xActivityDismissExtendImpl.mDelayRunnable = null;
            OnDismissListenerEx onDismissListenerEx = xActivityDismissExtendImpl.mOnDismissListenerEx;
            if (onDismissListenerEx != null) {
                onDismissListenerEx.afterDismiss(i);
            }
        }

        @Override // com.xiaopeng.xui.app.delegate.XActivityLifecycle
        public void onDestroy() {
            Runnable runnable = this.mDelayRunnable;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
                this.mDelayRunnable = null;
            }
        }

        private void _dismiss(int i) {
            XLogUtils.i(TAG, "_dismiss: type : " + convertTypeToString(this.mDismissType) + " , cause : " + convertCauseToString(i));
            switch (this.mDismissType) {
                case 0:
                    XActivityUtils.finish(this.mActivity);
                    return;
                case 1:
                    XActivityUtils.moveTaskToBack(this.mActivity, true);
                    return;
                default:
                    return;
            }
        }

        public String toString() {
            return "{mDismissType=" + this.mDismissType + ", mDismissDelay=" + this.mDismissDelay + '}';
        }
    }
}
