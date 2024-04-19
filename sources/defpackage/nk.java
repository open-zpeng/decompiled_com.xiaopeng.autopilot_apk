package defpackage;
/* compiled from: RenderContext.java */
/* renamed from: nk  reason: default package */
/* loaded from: classes.dex */
public class nk {
    public final nn a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private float f;
    private float g;
    private boolean h;
    private int i;

    public nk(nn nnVar) {
        this.a = nnVar;
    }

    public void a() {
        io.g.glDisable(2929);
        this.e = 0;
        io.g.glDepthMask(true);
        this.h = true;
        io.g.glDisable(3042);
        this.b = false;
        io.g.glDisable(2884);
        this.d = 0;
        this.c = 0;
        this.i = 0;
        this.a.a();
    }

    public void b() {
        if (this.e != 0) {
            io.g.glDisable(2929);
        }
        if (!this.h) {
            io.g.glDepthMask(true);
        }
        if (this.b) {
            io.g.glDisable(3042);
        }
        if (this.i > 0) {
            io.g.glDisable(2884);
        }
        this.a.b();
    }

    public void a(boolean z) {
        if (this.h != z) {
            kg kgVar = io.g;
            this.h = z;
            kgVar.glDepthMask(z);
        }
    }

    public void a(int i, float f, float f2) {
        boolean z = this.e != 0;
        boolean z2 = i != 0;
        if (this.e != i) {
            this.e = i;
            if (z2) {
                io.g.glEnable(2929);
                io.g.glDepthFunc(i);
            } else {
                io.g.glDisable(2929);
            }
        }
        if (z2) {
            if (!z || this.e != i) {
                kg kgVar = io.g;
                this.e = i;
                kgVar.glDepthFunc(i);
            }
            if (z && this.f == f && this.g == f2) {
                return;
            }
            kg kgVar2 = io.g;
            this.f = f;
            this.g = f2;
            kgVar2.glDepthRangef(f, f2);
        }
    }

    public void a(boolean z, int i, int i2) {
        if (z != this.b) {
            this.b = z;
            if (z) {
                io.g.glEnable(3042);
            } else {
                io.g.glDisable(3042);
            }
        }
        if (z) {
            if (this.c == i && this.d == i2) {
                return;
            }
            io.g.glBlendFunc(i, i2);
            this.c = i;
            this.d = i2;
        }
    }

    public void a(int i) {
        if (i != this.i) {
            this.i = i;
            if (i == 1028 || i == 1029 || i == 1032) {
                io.g.glEnable(2884);
                io.g.glCullFace(i);
                return;
            }
            io.g.glDisable(2884);
        }
    }
}
