package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
/* compiled from: OrthographicCamera.java */
/* renamed from: kk  reason: default package */
/* loaded from: classes.dex */
public class kk extends jz {
    public float m = 1.0f;
    private final p n = new p();

    public kk() {
        this.h = 0.0f;
    }

    @Override // defpackage.jz
    public void a() {
        a(true);
    }

    public void a(boolean z) {
        this.d.a((this.m * (-this.j)) / 2.0f, this.m * (this.j / 2.0f), this.m * (-(this.k / 2.0f)), (this.m * this.k) / 2.0f, this.h, this.i);
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
