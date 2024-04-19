package defpackage;

import com.badlogic.gdx.math.p;
import defpackage.ni;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DynaGuidelineEntityPro.java */
/* renamed from: rv  reason: default package */
/* loaded from: classes.dex */
public class rv extends aci {
    protected float b = (uc.c * 1.3f) * 0.5f;
    protected ka c = new ka(1.1333333f, 1.1333333f, 0.0f, 1.0f);
    protected List<p> d = new ArrayList();
    protected float e = 0.0f;
    protected ni.a f;
    protected ni.a g;
    protected ni.a h;
    protected ni.a i;
    protected ni.a j;
    protected ni.a k;
    protected ni.a l;
    protected ni.a m;

    public void a(float f) {
        this.e = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ni.a e() {
        if (this.f == null) {
            this.f = new ni.a();
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ni.a f() {
        if (this.g == null) {
            this.g = new ni.a();
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ni.a g() {
        if (this.h == null) {
            this.h = new ni.a();
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ni.a h() {
        if (this.i == null) {
            this.i = new ni.a();
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ni.a i() {
        if (this.j == null) {
            this.j = new ni.a();
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ni.a j() {
        if (this.k == null) {
            this.k = new ni.a();
        }
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ni.a k() {
        if (this.l == null) {
            this.l = new ni.a();
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ni.a l() {
        if (this.m == null) {
            this.m = new ni.a();
        }
        return this.m;
    }

    public void b(float f) {
        this.b = f;
    }

    public void a(float f, float f2, float f3, float f4) {
        ka kaVar = this.c;
        kaVar.J = f;
        kaVar.K = f2;
        kaVar.L = f3;
        kaVar.M = f4;
    }

    @Override // defpackage.aci, defpackage.ik
    public void a() {
        super.a();
    }

    protected List<p> a(List<p> list, int i) {
        this.d.clear();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 % i == 0 || i2 == list.size() - 1 || i2 == list.size() - 2) {
                    this.d.add(list.get(i2));
                }
            }
        }
        return this.d;
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        super.dispose();
        if (this.K != null) {
            this.K.dispose();
        }
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (this.L != null) {
            kzVar.a(this.L);
        }
    }
}
