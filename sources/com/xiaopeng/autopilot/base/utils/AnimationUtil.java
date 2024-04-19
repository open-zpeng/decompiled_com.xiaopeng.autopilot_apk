package com.xiaopeng.autopilot.base.utils;

import android.graphics.drawable.AnimationDrawable;
/* loaded from: classes.dex */
public class AnimationUtil {
    private static final String TAG = "AnimationUtil";

    public static void recycleAnimationDrawable(AnimationDrawable animationDrawable) {
        if (animationDrawable == null) {
            return;
        }
        for (int i = 0; i < animationDrawable.getNumberOfFrames(); i++) {
            animationDrawable.getFrame(i).setCallback(null);
        }
        animationDrawable.setCallback(null);
    }
}
