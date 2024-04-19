package com.badlogic.gdx.utils;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public class s {
    private final String a;
    private int b;

    public s(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public void a(String str) {
        if (this.b >= 3) {
            io.a.debug(this.a, str);
        }
    }

    public void b(String str) {
        if (this.b >= 2) {
            io.a.log(this.a, str);
        }
    }

    public void c(String str) {
        if (this.b >= 1) {
            io.a.error(this.a, str);
        }
    }

    public void a(String str, Throwable th) {
        if (this.b >= 1) {
            io.a.error(this.a, str, th);
        }
    }

    public int a() {
        return this.b;
    }
}
