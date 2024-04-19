package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
/* compiled from: BaseDrawable.java */
/* renamed from: qb  reason: default package */
/* loaded from: classes.dex */
public class qb implements qf {
    private String a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;

    @Override // defpackage.qf
    public void a(Batch batch, float f, float f2, float f3, float f4) {
    }

    public qb() {
    }

    public qb(qf qfVar) {
        if (qfVar instanceof qb) {
            this.a = ((qb) qfVar).g();
        }
        this.b = qfVar.a();
        this.c = qfVar.b();
        this.d = qfVar.c();
        this.e = qfVar.d();
        this.f = qfVar.e();
        this.g = qfVar.f();
    }

    @Override // defpackage.qf
    public float a() {
        return this.b;
    }

    public void a(float f) {
        this.b = f;
    }

    @Override // defpackage.qf
    public float b() {
        return this.c;
    }

    public void b(float f) {
        this.c = f;
    }

    @Override // defpackage.qf
    public float c() {
        return this.d;
    }

    public void c(float f) {
        this.d = f;
    }

    @Override // defpackage.qf
    public float d() {
        return this.e;
    }

    public void d(float f) {
        this.e = f;
    }

    @Override // defpackage.qf
    public float e() {
        return this.f;
    }

    public void e(float f) {
        this.f = f;
    }

    @Override // defpackage.qf
    public float f() {
        return this.g;
    }

    public void f(float f) {
        this.g = f;
    }

    public String g() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String toString() {
        String str = this.a;
        return str == null ? qu.a(getClass()) : str;
    }
}
