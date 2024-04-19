package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.os.Build;
/* loaded from: classes.dex */
public class AndroidInputFactory {
    public static AndroidInput newAndroidInput(ij ijVar, Context context, Object obj, AndroidApplicationConfiguration androidApplicationConfiguration) {
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 12) {
                cls = Class.forName("com.badlogic.gdx.backends.android.AndroidInputThreePlus");
            } else {
                cls = Class.forName("com.badlogic.gdx.backends.android.AndroidInput");
            }
            return (AndroidInput) cls.getConstructor(ij.class, Context.class, Object.class, AndroidApplicationConfiguration.class).newInstance(ijVar, context, obj, androidApplicationConfiguration);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't construct AndroidInput, this should never happen", e);
        }
    }
}
