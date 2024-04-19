package defpackage;

import java.io.Serializable;
/* compiled from: SenceConfiguration.java */
/* renamed from: ack  reason: default package */
/* loaded from: classes.dex */
public class ack implements Serializable {
    private static ack a;
    private boolean b = false;
    private boolean c = true;
    private boolean d = true;
    private ka e = new ka(0.0f, 0.0f, 0.0f, 0.0f);
    private boolean f = false;
    private boolean g = false;
    private boolean h = true;
    private boolean i = false;
    private boolean j = true;
    private boolean k = false;

    private ack() {
    }

    public boolean a() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public static ack b() {
        if (a == null) {
            a = new ack();
        }
        return a;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public boolean c() {
        return this.k;
    }

    public boolean d() {
        return this.g;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public boolean e() {
        return this.j;
    }

    public void d(boolean z) {
        this.j = z;
    }

    public boolean f() {
        return this.h;
    }

    public boolean g() {
        return this.c;
    }

    public boolean h() {
        return this.f;
    }

    public void e(boolean z) {
        this.b = z;
    }

    public void f(boolean z) {
        this.c = z;
    }

    public void g(boolean z) {
        this.d = z;
    }

    public boolean i() {
        return this.d;
    }

    public String toString() {
        return "SenceConfiguration{mShowFps=" + this.b + ", mShowAxe=" + this.c + ", mBgColor=" + this.e + ", showLog=" + this.f + ", mShowOpengGL=" + this.g + ", mURevers=" + this.h + ", mDebug=" + this.j + '}';
    }

    public boolean j() {
        return this.b;
    }
}
