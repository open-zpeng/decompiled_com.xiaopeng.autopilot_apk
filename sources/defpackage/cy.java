package defpackage;
/* compiled from: StopLogic.java */
/* renamed from: cy  reason: default package */
/* loaded from: classes.dex */
public class cy extends ds {
    private bp b;
    private bs a = new bs();
    private br c = this.a;

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        bs bsVar = this.a;
        this.c = bsVar;
        bsVar.a(f, f2, f3, f4, f5, f6);
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (this.b == null) {
            this.b = new bp();
        }
        bp bpVar = this.b;
        this.c = bpVar;
        bpVar.a(f, f2, f3, f4, f5, f6, f7, i);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.c.a(f);
    }

    @Override // defpackage.ds
    public float a() {
        return this.c.a();
    }

    public boolean b() {
        return this.c.b();
    }
}
