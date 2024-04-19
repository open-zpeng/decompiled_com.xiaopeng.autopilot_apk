package defpackage;

import com.badlogic.gdx.utils.ao;
/* compiled from: ClickListener.java */
/* renamed from: qd  reason: default package */
/* loaded from: classes.dex */
public class qd extends op {
    public static float a = 0.1f;
    private float b;
    private float c;
    private float d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private int m;
    private long n;

    public void b(oo ooVar, float f, float f2) {
    }

    @Override // defpackage.op
    public boolean a(oo ooVar, float f, float f2, int i, int i2) {
        int i3;
        if (this.h) {
            return false;
        }
        if (i != 0 || (i3 = this.g) == -1 || i2 == i3) {
            this.h = true;
            this.e = i;
            this.f = i2;
            this.c = f;
            this.d = f2;
            a(true);
            return true;
        }
        return false;
    }

    @Override // defpackage.op
    public void a(oo ooVar, float f, float f2, int i) {
        if (i != this.e || this.j) {
            return;
        }
        this.h = a(ooVar.c(), f, f2);
        if (this.h) {
            return;
        }
        a();
    }

    @Override // defpackage.op
    public void b(oo ooVar, float f, float f2, int i, int i2) {
        int i3;
        if (i == this.e) {
            if (!this.j) {
                boolean a2 = a(ooVar.c(), f, f2);
                if (a2 && i == 0 && (i3 = this.g) != -1 && i2 != i3) {
                    a2 = false;
                }
                if (a2) {
                    long a3 = ao.a();
                    if (a3 - this.n > this.l) {
                        this.m = 0;
                    }
                    this.m++;
                    this.n = a3;
                    b(ooVar, f, f2);
                }
            }
            this.h = false;
            this.e = -1;
            this.f = -1;
            this.j = false;
        }
    }

    @Override // defpackage.op
    public void a(oo ooVar, float f, float f2, int i, ok okVar) {
        if (i != -1 || this.j) {
            return;
        }
        this.i = true;
    }

    @Override // defpackage.op
    public void b(oo ooVar, float f, float f2, int i, ok okVar) {
        if (i != -1 || this.j) {
            return;
        }
        this.i = false;
    }

    public boolean a(ok okVar, float f, float f2) {
        ok a2 = okVar.a(f, f2, true);
        if (a2 == null || !a2.a(okVar)) {
            return a(f, f2);
        }
        return true;
    }

    public boolean a(float f, float f2) {
        return !(this.c == -1.0f && this.d == -1.0f) && Math.abs(f - this.c) < this.b && Math.abs(f2 - this.d) < this.b;
    }

    public void a() {
        this.c = -1.0f;
        this.d = -1.0f;
    }

    public boolean b() {
        return this.h;
    }

    public boolean c() {
        if (this.h) {
            return true;
        }
        long j = this.k;
        if (j <= 0) {
            return false;
        }
        if (j > ao.b()) {
            return true;
        }
        this.k = 0L;
        return false;
    }

    public void a(boolean z) {
        if (z) {
            this.k = ao.b() + (a * 1000.0f);
        } else {
            this.k = 0L;
        }
    }

    public boolean d() {
        return this.i || this.h;
    }
}
