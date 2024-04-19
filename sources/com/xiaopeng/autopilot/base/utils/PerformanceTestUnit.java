package com.xiaopeng.autopilot.base.utils;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public class PerformanceTestUnit {
    private static final String TAG = "PerformanceTest >>";
    private static ScheduledExecutorService mExecutorService = null;
    private static long mLastLogTime = 0;
    private static long sWarrningTime = 25;
    private static StartTimeStack startTimeStack = new StartTimeStack();
    public static Map<String, Long> sLogLastTimeMap = new HashMap();
    public static StringBuffer mTmpSb = new StringBuffer();
    public static StringBuilder mTrainingLog = new StringBuilder();
    public static SimpleDateFormat tempSimpleFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public static void logStart(String str) {
        if (ack.b().a()) {
            startTimeStack.push(Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void logEnd(String str, String str2) {
        try {
            if (ack.b().a()) {
                long currentTimeMillis = System.currentTimeMillis() - startTimeStack.pop().longValue();
                if (currentTimeMillis > sWarrningTime) {
                    Log.w(TAG, TAG + str2 + "\tcost:\t" + currentTimeMillis + "\taffect FPS");
                } else {
                    Log.i(TAG, TAG + str2 + "\tcost:\t" + currentTimeMillis);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            Log.i(TAG, "on error index out!");
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.i(TAG, "exception ");
        }
    }

    public static void log(String str, String str2, long j) {
        if (System.currentTimeMillis() - (sLogLastTimeMap.get(str) != null ? sLogLastTimeMap.get(str).longValue() : 0L) <= j || !ack.b().c()) {
            return;
        }
        Log.i(TAG, str2);
        mLastLogTime = System.currentTimeMillis();
        sLogLastTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void log(String str, String str2, long j, boolean z) {
        if (System.currentTimeMillis() - (sLogLastTimeMap.get(str) != null ? sLogLastTimeMap.get(str).longValue() : 0L) > j) {
            if (ack.b().c() || z) {
                Log.i(TAG, str2);
                mLastLogTime = System.currentTimeMillis();
                sLogLastTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static void log(long j, String str, String str2) {
        if (System.currentTimeMillis() - mLastLogTime <= j || !ack.b().c()) {
            return;
        }
        Log.i(str2, str);
        mLastLogTime = System.currentTimeMillis();
    }

    public static void log(String str, String str2, boolean z) {
        if (ack.b().c() || z) {
            Log.i(str, str2);
        }
    }

    public static void resetStartPerformance() {
        sLogLastTimeMap.put("DrivingCarEntityPro_render", 0L);
    }

    /* loaded from: classes.dex */
    public static class StartTimeStack extends Stack<Long> {
        @Override // java.util.Stack
        public Long push(Long l) {
            return (Long) super.push((StartTimeStack) l);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Stack
        public synchronized Long pop() {
            return (Long) super.pop();
        }
    }
}
