package com.badlogic.gdx.utils;

import java.util.Comparator;
/* compiled from: Sort.java */
/* loaded from: classes.dex */
public class aj {
    private static aj a;
    private an b;

    public <T> void a(T[] tArr, Comparator<? super T> comparator, int i, int i2) {
        if (this.b == null) {
            this.b = new an();
        }
        this.b.a(tArr, comparator, i, i2);
    }

    public static aj a() {
        if (a == null) {
            a = new aj();
        }
        return a;
    }
}
