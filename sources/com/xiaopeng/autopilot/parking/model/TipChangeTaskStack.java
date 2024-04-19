package com.xiaopeng.autopilot.parking.model;

import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import java.util.Calendar;
import java.util.Stack;
/* loaded from: classes.dex */
public class TipChangeTaskStack extends Stack<TipChangeInfo> {
    private static final String TAG = "TipChangeTaskStack";

    @Override // java.util.Stack
    public TipChangeInfo push(TipChangeInfo tipChangeInfo) {
        PerformanceTestUnit.log(TAG, "TIPS_TASK push tipChangeInfo " + tipChangeInfo.toString() + " into stack", true);
        return (TipChangeInfo) super.push((TipChangeTaskStack) tipChangeInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Stack
    public synchronized TipChangeInfo pop() {
        TipChangeInfo tipChangeInfo;
        tipChangeInfo = (TipChangeInfo) super.pop();
        PerformanceTestUnit.log(TAG, "TIPS_TASK pop tipChangeInfo " + tipChangeInfo.toString() + " from stack", true);
        return tipChangeInfo;
    }

    /* loaded from: classes.dex */
    public static class TipChangeInfo {
        private int currentTip;
        private int lastTip;
        private long occurTime = Calendar.getInstance().getTimeInMillis();
        private Runnable runnable;

        public TipChangeInfo(int i, int i2, Runnable runnable) {
            this.currentTip = i;
            this.lastTip = i2;
            this.runnable = runnable;
        }

        public int getCurrentTip() {
            return this.currentTip;
        }

        public int getLastTip() {
            return this.lastTip;
        }

        public Runnable getRunnable() {
            return this.runnable;
        }

        public long getOccurTime() {
            return this.occurTime;
        }

        public String getOccurTimeStr() {
            return PerformanceTestUnit.tempSimpleFormat.format(Long.valueOf(getOccurTime()));
        }

        public String toString() {
            return "\toccurTime: " + getOccurTimeStr() + "\tcurrentTip: " + this.currentTip + "\tlastTip: " + getLastTip();
        }
    }
}
