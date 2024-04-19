package com.badlogic.gdx.utils;
/* compiled from: GdxNativesLoader.java */
/* loaded from: classes.dex */
public class j {
    public static boolean a = false;
    private static boolean b;

    public static synchronized void a() {
        synchronized (j.class) {
            if (b) {
                return;
            }
            b = true;
            if (a) {
                return;
            }
            new ag().b("gdx");
        }
    }
}
