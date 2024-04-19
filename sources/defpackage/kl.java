package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
/* compiled from: PerspectiveCamera.java */
/* renamed from: kl  reason: default package */
/* loaded from: classes.dex */
public class kl extends jz {
    public float m;
    final p n;

    public kl() {
        this.m = 67.0f;
        this.n = new p();
    }

    public kl(float f, float f2, float f3) {
        this.m = 67.0f;
        this.n = new p();
        this.m = f;
        this.j = f2;
        this.k = f3;
        a();
    }

    @Override // defpackage.jz
    public void a() {
        a(true);
    }

    public void a(boolean z) {
        this.d.b(Math.abs(this.h), Math.abs(this.i), this.m, this.j / this.k);
        this.e.a(this.a, this.n.a(this.a).b(this.b), this.c);
        this.f.a(this.d);
        Matrix4.mul(this.f.a, this.e.a);
        if (z) {
            this.g.a(this.f);
            Matrix4.inv(this.g.a);
            this.l.a(this.g);
        }
    }
}
