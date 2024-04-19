package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.r;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.a;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.ai;
import java.util.Iterator;
/* compiled from: Group.java */
/* renamed from: on  reason: default package */
/* loaded from: classes.dex */
public class on extends ok implements qe {
    private static final o n = new o();
    private n r;
    final ai<ok> l = new ai<>(true, 4, ok.class);
    private final a o = new a();
    private final Matrix4 p = new Matrix4();
    private final Matrix4 q = new Matrix4();
    boolean m = true;

    protected void C() {
    }

    @Override // defpackage.ok
    public void a(Batch batch, float f) {
        if (this.m) {
            a(batch, B());
        }
        b(batch, f);
        if (this.m) {
            a(batch);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Batch batch, float f) {
        float f2;
        float f3 = this.k.M * f;
        ai<ok> aiVar = this.l;
        ok[] f4 = aiVar.f();
        n nVar = this.r;
        int i = 0;
        if (nVar != null) {
            float f5 = nVar.x;
            float f6 = nVar.width + f5;
            float f7 = nVar.y;
            float f8 = nVar.height + f7;
            if (this.m) {
                int i2 = aiVar.b;
                while (i < i2) {
                    ok okVar = f4[i];
                    if (okVar.j()) {
                        float f9 = okVar.b;
                        float f10 = okVar.c;
                        if (f9 <= f6 && f10 <= f8 && f9 + okVar.d >= f5 && f10 + okVar.e >= f7) {
                            okVar.a(batch, f3);
                        }
                    }
                    i++;
                }
            } else {
                float f11 = this.b;
                float f12 = this.c;
                this.b = 0.0f;
                this.c = 0.0f;
                int i3 = aiVar.b;
                while (i < i3) {
                    ok okVar2 = f4[i];
                    if (okVar2.j()) {
                        float f13 = okVar2.b;
                        float f14 = okVar2.c;
                        if (f13 > f6 || f14 > f8) {
                            f2 = f8;
                        } else {
                            f2 = f8;
                            if (okVar2.d + f13 >= f5 && okVar2.e + f14 >= f7) {
                                okVar2.b = f13 + f11;
                                okVar2.c = f14 + f12;
                                okVar2.a(batch, f3);
                                okVar2.b = f13;
                                okVar2.c = f14;
                            }
                        }
                    } else {
                        f2 = f8;
                    }
                    i++;
                    f8 = f2;
                }
                this.b = f11;
                this.c = f12;
            }
        } else if (this.m) {
            int i4 = aiVar.b;
            while (i < i4) {
                ok okVar3 = f4[i];
                if (okVar3.j()) {
                    okVar3.a(batch, f3);
                }
                i++;
            }
        } else {
            float f15 = this.b;
            float f16 = this.c;
            this.b = 0.0f;
            this.c = 0.0f;
            int i5 = aiVar.b;
            while (i < i5) {
                ok okVar4 = f4[i];
                if (okVar4.j()) {
                    float f17 = okVar4.b;
                    float f18 = okVar4.c;
                    okVar4.b = f17 + f15;
                    okVar4.c = f18 + f16;
                    okVar4.a(batch, f3);
                    okVar4.b = f17;
                    okVar4.c = f18;
                }
                i++;
            }
            this.b = f15;
            this.c = f16;
        }
        aiVar.g();
    }

    @Override // defpackage.ok
    public void a(r rVar) {
        b(rVar);
        if (this.m) {
            a(rVar, B());
        }
        c(rVar);
        if (this.m) {
            d(rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(r rVar) {
        ai<ok> aiVar = this.l;
        ok[] f = aiVar.f();
        int i = 0;
        if (this.m) {
            int i2 = aiVar.b;
            while (i < i2) {
                ok okVar = f[i];
                if (okVar.j() && (okVar.A() || (okVar instanceof on))) {
                    okVar.a(rVar);
                }
                i++;
            }
            rVar.d();
        } else {
            float f2 = this.b;
            float f3 = this.c;
            this.b = 0.0f;
            this.c = 0.0f;
            int i3 = aiVar.b;
            while (i < i3) {
                ok okVar2 = f[i];
                if (okVar2.j() && (okVar2.A() || (okVar2 instanceof on))) {
                    float f4 = okVar2.b;
                    float f5 = okVar2.c;
                    okVar2.b = f4 + f2;
                    okVar2.c = f5 + f3;
                    okVar2.a(rVar);
                    okVar2.b = f4;
                    okVar2.c = f5;
                }
                i++;
            }
            this.b = f2;
            this.c = f3;
        }
        aiVar.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Matrix4 B() {
        a aVar = this.o;
        float f = this.f;
        float f2 = this.g;
        aVar.a(this.b + f, this.c + f2, this.j, this.h, this.i);
        if (f != 0.0f || f2 != 0.0f) {
            aVar.a(-f, -f2);
        }
        on onVar = this.a;
        while (onVar != null && !onVar.m) {
            onVar = onVar.a;
        }
        if (onVar != null) {
            aVar.c(onVar.o);
        }
        this.p.a(aVar);
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Batch batch, Matrix4 matrix4) {
        this.q.a(batch.getTransformMatrix());
        batch.setTransformMatrix(matrix4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Batch batch) {
        batch.setTransformMatrix(this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar, Matrix4 matrix4) {
        this.q.a(rVar.a());
        rVar.b(matrix4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(r rVar) {
        rVar.b(this.q);
    }

    @Override // defpackage.qe
    public void a(n nVar) {
        this.r = nVar;
    }

    @Override // defpackage.ok
    public ok a(float f, float f2, boolean z) {
        if (!(z && i() == or.disabled) && j()) {
            o oVar = n;
            ok[] okVarArr = this.l.a;
            for (int i = this.l.b - 1; i >= 0; i--) {
                ok okVar = okVarArr[i];
                okVar.b(oVar.a(f, f2));
                ok a = okVar.a(oVar.d, oVar.e, z);
                if (a != null) {
                    return a;
                }
            }
            return super.a(f, f2, z);
        }
        return null;
    }

    public void c(ok okVar) {
        if (okVar.a != null) {
            if (okVar.a == this) {
                return;
            }
            okVar.a.a(okVar, false);
        }
        this.l.a((ai<ok>) okVar);
        okVar.a(this);
        okVar.a(e());
        C();
    }

    public boolean a(ok okVar, boolean z) {
        oq e;
        if (this.l.c(okVar, true)) {
            if (z && (e = e()) != null) {
                e.c(okVar);
            }
            okVar.a((on) null);
            okVar.a((oq) null);
            C();
            return true;
        }
        return false;
    }

    public void D() {
        ok[] f = this.l.f();
        int i = this.l.b;
        for (int i2 = 0; i2 < i; i2++) {
            ok okVar = f[i2];
            okVar.a((oq) null);
            okVar.a((on) null);
        }
        this.l.g();
        this.l.d();
        C();
    }

    @Override // defpackage.ok
    public void d() {
        super.d();
        D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ok
    public void a(oq oqVar) {
        super.a(oqVar);
        ok[] okVarArr = this.l.a;
        int i = this.l.b;
        for (int i2 = 0; i2 < i; i2++) {
            okVarArr[i2].a(oqVar);
        }
    }

    public ai<ok> E() {
        return this.l;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public boolean F() {
        return this.m;
    }

    public void a(boolean z, boolean z2) {
        a(z);
        if (z2) {
            Iterator<ok> it = this.l.iterator();
            while (it.hasNext()) {
                ok next = it.next();
                if (next instanceof on) {
                    ((on) next).a(z, z2);
                } else {
                    next.a(z);
                }
            }
        }
    }

    public on G() {
        a(true, true);
        return this;
    }

    @Override // defpackage.ok
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        a(sb, 1);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    void a(StringBuilder sb, int i) {
        sb.append(super.toString());
        sb.append('\n');
        ok[] f = this.l.f();
        int i2 = this.l.b;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                sb.append("|  ");
            }
            ok okVar = f[i3];
            if (okVar instanceof on) {
                ((on) okVar).a(sb, i + 1);
            } else {
                sb.append(okVar);
                sb.append('\n');
            }
        }
        this.l.g();
    }
}
