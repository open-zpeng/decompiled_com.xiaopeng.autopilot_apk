package com.xiaopeng.xui.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.xui.Xui;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.utils.XDialogUtils;
import com.xiaopeng.xui.utils.XLogUtils;
import com.xiaopeng.xui.vui.IVuiViewScene;
import com.xiaopeng.xui.widget.dialogview.XDialogView;
import com.xiaopeng.xui.widget.dialogview.XDialogViewInterface;
import defpackage.acu;
import java.util.List;
/* loaded from: classes.dex */
public class XDialog implements IVuiViewScene {
    public static final int ID_SCREEN_PRIMARY = 0;
    public static final int ID_SCREEN_SECONDARY = 1;
    private static int sObjectSize;
    private Context mContext;
    private Dialog mDialog;
    private XDialogInterface.OnClickListener mNegativeListener;
    private XDialogViewInterface.OnClickListener mNegativeListenerProxy;
    private XDialogInterface.OnCloseListener mOnCloseListener;
    private XDialogViewInterface.OnCloseListener mOnCloseListenerProxy;
    private XDialogInterface.OnCountDownListener mOnCountDownListener;
    private XDialogViewInterface.OnCountDownListener mOnCountDownListenerProxy;
    private DialogInterface.OnKeyListener mOnKeyListener;
    private XDialogInterface.OnClickListener mPositiveListener;
    private XDialogViewInterface.OnClickListener mPositiveListenerProxy;
    private int mSystemDialogOffsetY;
    private int mWindowBackgroundId;
    private XDialogView mXDialogView;

    public XDialog(Context context) {
        this(context, 0);
    }

    public XDialog(Context context, Parameters parameters) {
        this(context, 0, parameters);
    }

    public XDialog(Context context, int i) {
        this(context, i, null);
    }

    public XDialog(Context context, int i, Parameters parameters) {
        this.mXDialogView = new XDialogView(context, i);
        this.mContext = context;
        parameters = parameters == null ? Parameters.Builder() : parameters;
        if (parameters.mTheme != 0) {
            this.mDialog = new Dialog(context, parameters.mTheme);
        } else {
            this.mDialog = new Dialog(context, acu.k.XAppTheme_XDialog);
        }
        if (parameters.mFullScreen) {
            XDialogUtils.requestFullScreen(this.mDialog);
        }
        this.mDialog.setContentView(this.mXDialogView.getContentView());
        init();
        sObjectSize++;
    }

    private void init() {
        this.mSystemDialogOffsetY = (int) this.mContext.getResources().getDimension(acu.e.x_dialog_system_offset_y);
        this.mXDialogView.setOnDismissListener(new XDialogViewInterface.OnDismissListener() { // from class: com.xiaopeng.xui.app.-$$Lambda$XDialog$9P4fB9VBMHmiGhl_mlGUJko3V2E
            @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnDismissListener
            public final void onDismiss(XDialogView xDialogView) {
                XDialog.this.dismiss();
            }
        });
        this.mXDialogView.setThemeCallback(new ThemeViewModel.OnCallback() { // from class: com.xiaopeng.xui.app.-$$Lambda$XDialog$s3CmKHbTxXoHkg0e6JUBfY_y_-Q
            @Override // com.xiaopeng.libtheme.ThemeViewModel.OnCallback
            public final void onThemeChanged() {
                XDialog.lambda$init$1(XDialog.this);
            }
        });
        this.mXDialogView.setScreenPositionCallback(new XDialogViewInterface.IScreenPositionCallback() { // from class: com.xiaopeng.xui.app.XDialog.1
            @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.IScreenPositionCallback
            public int getScreenPositionInfo() {
                return XDialog.this.getVuiDisplayLocation();
            }
        });
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.xiaopeng.xui.app.-$$Lambda$XDialog$WZ3Q9pXFsK8sg4PXWTmacfC8DAk
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return XDialog.lambda$init$2(XDialog.this, dialogInterface, i, keyEvent);
            }
        });
        TypedArray obtainStyledAttributes = this.mDialog.getContext().obtainStyledAttributes(new int[]{16842836});
        this.mWindowBackgroundId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void lambda$init$1(XDialog xDialog) {
        xDialog.logs("onThemeChanged, mWindowBackgroundId " + xDialog.mWindowBackgroundId);
        if (xDialog.mWindowBackgroundId == 0) {
            xDialog.mWindowBackgroundId = acu.f.x_bg_dialog;
        }
        if (xDialog.mDialog.getWindow() == null || xDialog.mWindowBackgroundId <= 0) {
            return;
        }
        xDialog.mDialog.getWindow().setBackgroundDrawableResource(xDialog.mWindowBackgroundId);
    }

    public static /* synthetic */ boolean lambda$init$2(XDialog xDialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener = xDialog.mOnKeyListener;
        if (onKeyListener != null && onKeyListener.onKey(dialogInterface, i, keyEvent)) {
            xDialog.logs("custom key listener return true  keyCode : " + i + ", event " + keyEvent.getAction());
            return true;
        }
        return xDialog.mXDialogView.onKey(i, keyEvent);
    }

    private void initCloseListenerProxy() {
        if (this.mOnCloseListenerProxy == null) {
            this.mOnCloseListenerProxy = new XDialogViewInterface.OnCloseListener() { // from class: com.xiaopeng.xui.app.-$$Lambda$XDialog$l1LARSaNT8tDepVXLgxNqVdJkkc
                @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnCloseListener
                public final boolean onClose(XDialogView xDialogView) {
                    return XDialog.lambda$initCloseListenerProxy$3(XDialog.this, xDialogView);
                }
            };
            this.mXDialogView.setOnCloseListener(this.mOnCloseListenerProxy);
        }
    }

    public static /* synthetic */ boolean lambda$initCloseListenerProxy$3(XDialog xDialog, XDialogView xDialogView) {
        XDialogInterface.OnCloseListener onCloseListener = xDialog.mOnCloseListener;
        if (onCloseListener != null) {
            return onCloseListener.onClose(xDialog);
        }
        return false;
    }

    private void initCountDownListenerProxy() {
        if (this.mOnCountDownListenerProxy == null) {
            this.mOnCountDownListenerProxy = new XDialogViewInterface.OnCountDownListener() { // from class: com.xiaopeng.xui.app.-$$Lambda$XDialog$fbj-1PFv3EpqSHcLX-8gv1vcQx4
                @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnCountDownListener
                public final boolean onCountDown(XDialogView xDialogView, int i) {
                    return XDialog.lambda$initCountDownListenerProxy$4(XDialog.this, xDialogView, i);
                }
            };
            this.mXDialogView.setOnCountDownListener(this.mOnCountDownListenerProxy);
        }
    }

    public static /* synthetic */ boolean lambda$initCountDownListenerProxy$4(XDialog xDialog, XDialogView xDialogView, int i) {
        XDialogInterface.OnCountDownListener onCountDownListener = xDialog.mOnCountDownListener;
        if (onCountDownListener != null) {
            return onCountDownListener.onCountDown(xDialog, i);
        }
        return false;
    }

    private void initPositiveListenerProxy() {
        if (this.mPositiveListenerProxy == null) {
            this.mPositiveListenerProxy = new XDialogViewInterface.OnClickListener() { // from class: com.xiaopeng.xui.app.-$$Lambda$XDialog$8umUr7E18qQsZk8zQujzHQFIHPY
                @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnClickListener
                public final void onClick(XDialogView xDialogView, int i) {
                    XDialog.lambda$initPositiveListenerProxy$5(XDialog.this, xDialogView, i);
                }
            };
        }
    }

    public static /* synthetic */ void lambda$initPositiveListenerProxy$5(XDialog xDialog, XDialogView xDialogView, int i) {
        XDialogInterface.OnClickListener onClickListener = xDialog.mPositiveListener;
        if (onClickListener != null) {
            onClickListener.onClick(xDialog, i);
        }
    }

    private void initNegativeListenerProxy() {
        if (this.mNegativeListenerProxy == null) {
            this.mNegativeListenerProxy = new XDialogViewInterface.OnClickListener() { // from class: com.xiaopeng.xui.app.-$$Lambda$XDialog$FFTotuu-r5O5A4gt3f42vBsU9o4
                @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnClickListener
                public final void onClick(XDialogView xDialogView, int i) {
                    XDialog.lambda$initNegativeListenerProxy$6(XDialog.this, xDialogView, i);
                }
            };
        }
    }

    public static /* synthetic */ void lambda$initNegativeListenerProxy$6(XDialog xDialog, XDialogView xDialogView, int i) {
        XDialogInterface.OnClickListener onClickListener = xDialog.mNegativeListener;
        if (onClickListener != null) {
            onClickListener.onClick(xDialog, i);
        }
    }

    public ViewGroup getContentView() {
        return this.mXDialogView.getContentView();
    }

    public XDialog setPositiveButtonInterceptDismiss(boolean z) {
        this.mXDialogView.setPositiveButtonInterceptDismiss(z);
        return this;
    }

    public XDialog setNegativeButtonInterceptDismiss(boolean z) {
        this.mXDialogView.setNegativeButtonInterceptDismiss(z);
        return this;
    }

    public XDialog setTitle(CharSequence charSequence) {
        this.mXDialogView.setTitle(charSequence);
        return this;
    }

    public XDialog setTitle(int i) {
        this.mXDialogView.setTitle(i);
        return this;
    }

    public XDialog setIcon(int i) {
        this.mXDialogView.setIcon(i);
        return this;
    }

    public XDialog setIcon(Drawable drawable) {
        this.mXDialogView.setIcon(drawable);
        return this;
    }

    public XDialog setMessage(CharSequence charSequence) {
        this.mXDialogView.setMessage(charSequence);
        return this;
    }

    public XDialog setMessage(int i) {
        this.mXDialogView.setMessage(i);
        return this;
    }

    public XDialog setCustomView(View view) {
        this.mXDialogView.setCustomView(view);
        return this;
    }

    public XDialog setCustomView(View view, boolean z) {
        this.mXDialogView.setCustomView(view, z);
        return this;
    }

    public XDialog setCustomView(int i) {
        this.mXDialogView.setCustomView(i);
        return this;
    }

    public XDialog setCustomView(int i, boolean z) {
        this.mXDialogView.setCustomView(i, z);
        return this;
    }

    public XDialog setCloseVisibility(boolean z) {
        this.mXDialogView.setCloseVisibility(z);
        return this;
    }

    public void setThemeCallback(ThemeViewModel.OnCallback onCallback) {
        this.mXDialogView.setThemeCallback(onCallback);
    }

    public boolean isCloseShowing() {
        return this.mXDialogView.isCloseShowing();
    }

    @Deprecated
    public XDialog setTitleVisibility(boolean z) {
        setTitleBarVisibility(z);
        return this;
    }

    public XDialog setTitleBarVisibility(boolean z) {
        this.mXDialogView.setTitleBarVisibility(z);
        return this;
    }

    public XDialog setPositiveButton(int i) {
        this.mXDialogView.setPositiveButton(i);
        return this;
    }

    public XDialog setPositiveButton(CharSequence charSequence) {
        this.mXDialogView.setPositiveButton(charSequence);
        return this;
    }

    public XDialog setPositiveButtonListener(XDialogInterface.OnClickListener onClickListener) {
        this.mPositiveListener = onClickListener;
        if (onClickListener != null) {
            initPositiveListenerProxy();
        }
        this.mXDialogView.setPositiveButtonListener(this.mPositiveListenerProxy);
        return this;
    }

    public XDialog setPositiveButton(int i, XDialogInterface.OnClickListener onClickListener) {
        setPositiveButton(i);
        setPositiveButtonListener(onClickListener);
        return this;
    }

    public XDialog setPositiveButton(CharSequence charSequence, XDialogInterface.OnClickListener onClickListener) {
        setPositiveButton(charSequence);
        setPositiveButtonListener(onClickListener);
        return this;
    }

    public XDialog setNegativeButton(int i) {
        this.mXDialogView.setNegativeButton(i);
        return this;
    }

    public XDialog setNegativeButton(CharSequence charSequence) {
        this.mXDialogView.setNegativeButton(charSequence);
        return this;
    }

    public XDialog setNegativeButtonListener(XDialogInterface.OnClickListener onClickListener) {
        this.mNegativeListener = onClickListener;
        if (onClickListener != null) {
            initNegativeListenerProxy();
        }
        this.mXDialogView.setNegativeButtonListener(this.mNegativeListenerProxy);
        return this;
    }

    public XDialog setNegativeButton(int i, XDialogInterface.OnClickListener onClickListener) {
        setNegativeButton(i);
        setNegativeButtonListener(onClickListener);
        return this;
    }

    public XDialog setNegativeButton(CharSequence charSequence, XDialogInterface.OnClickListener onClickListener) {
        setNegativeButton(charSequence);
        setNegativeButtonListener(onClickListener);
        return this;
    }

    public XDialog setPositiveButtonEnable(boolean z) {
        this.mXDialogView.setPositiveButtonEnable(z);
        return this;
    }

    public XDialog setNegativeButtonEnable(boolean z) {
        this.mXDialogView.setNegativeButtonEnable(z);
        return this;
    }

    public boolean isPositiveButtonEnable() {
        return this.mXDialogView.isPositiveButtonEnable();
    }

    public boolean isNegativeButtonEnable() {
        return this.mXDialogView.isNegativeButtonEnable();
    }

    public boolean isPositiveButtonShowing() {
        return this.mXDialogView.isPositiveButtonShowing();
    }

    public boolean isNegativeButtonShowing() {
        return this.mXDialogView.isNegativeButtonShowing();
    }

    public void show() {
        show(0, 0);
    }

    public void show(int i, int i2) {
        logs("show");
        if (i > 0 && i2 == 0) {
            this.mXDialogView.startPositiveButtonCountDown(i);
        }
        if (i2 > 0 && i == 0) {
            this.mXDialogView.startNegativeButtonCountDown(i2);
        }
        if (this.mDialog.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.mDialog.getWindow().getAttributes();
            attributes.gravity = 17;
            attributes.y = attributes.type != 9 ? this.mSystemDialogOffsetY : 0;
            this.mDialog.getWindow().setAttributes(attributes);
        }
        this.mDialog.show();
    }

    public void dismiss() {
        logs("dismiss");
        this.mDialog.dismiss();
    }

    public void cancel() {
        logs("cancel");
        this.mDialog.cancel();
    }

    public boolean isShowing() {
        return this.mDialog.isShowing();
    }

    public XDialog setOnCloseListener(XDialogInterface.OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
        if (onCloseListener != null) {
            initCloseListenerProxy();
        }
        return this;
    }

    public XDialog setOnCountDownListener(XDialogInterface.OnCountDownListener onCountDownListener) {
        this.mOnCountDownListener = onCountDownListener;
        if (onCountDownListener != null) {
            initCountDownListenerProxy();
        }
        return this;
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public XDialog setSystemDialog(int i) {
        if (this.mDialog.getWindow() != null) {
            this.mDialog.getWindow().setType(i);
        }
        return this;
    }

    public XDialog setScreenId(int i) {
        XDialogUtils.setScreenId(this.mDialog, i);
        return this;
    }

    public int getScreenId() {
        return XDialogUtils.getScreenId(this.mDialog);
    }

    public XDialog setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDialog.setOnDismissListener(onDismissListener);
        return this;
    }

    public XDialog setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mDialog.setOnCancelListener(onCancelListener);
        return this;
    }

    public XDialog setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.mDialog.setOnShowListener(onShowListener);
        return this;
    }

    public XDialog setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
        return this;
    }

    public XDialog setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
        return this;
    }

    public XDialog setCanceledOnTouchOutside(boolean z) {
        this.mDialog.setCanceledOnTouchOutside(z);
        return this;
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void setVuiSceneId(String str) {
        this.mXDialogView.setVuiSceneId(str);
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void setVuiEngine(abo aboVar) {
        this.mXDialogView.setVuiEngine(aboVar);
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void setVuiElementListener(abn abnVar) {
        this.mXDialogView.setVuiElementListener(abnVar);
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void setCustomViewIdList(List<Integer> list) {
        this.mXDialogView.setCustomViewIdList(list);
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void initVuiScene(String str, abo aboVar) {
        this.mXDialogView.initVuiScene(str, aboVar);
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void initVuiScene(String str, abo aboVar, abp abpVar) {
        this.mXDialogView.initVuiScene(str, aboVar, abpVar);
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public int getVuiDisplayLocation() {
        Dialog dialog = this.mDialog;
        if (dialog == null) {
            return 0;
        }
        int screenId = XDialogUtils.getScreenId(dialog);
        logs("getVuiDisplayLocation   value:  " + screenId);
        return screenId;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        sObjectSize--;
        logs(" finalize object size " + sObjectSize);
    }

    /* loaded from: classes.dex */
    public static class Parameters {
        private boolean mFullScreen = Xui.isDialogFullScreen();
        private int mTheme;

        public static Parameters Builder() {
            return new Parameters();
        }

        private Parameters() {
        }

        public Parameters setTheme(int i) {
            this.mTheme = i;
            return this;
        }

        public Parameters setFullScreen(boolean z) {
            this.mFullScreen = z;
            return this;
        }
    }

    private void logs(String str) {
        XLogUtils.i("XDialog", str + "--hashcode " + hashCode());
    }
}
