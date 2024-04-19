package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.r;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.aa;
import com.badlogic.gdx.utils.ai;
import com.badlogic.gdx.utils.f;
import defpackage.oo;
/* compiled from: Actor.java */
/* renamed from: ok  reason: default package */
/* loaded from: classes.dex */
public class ok {
    on a;
    float b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float j;
    private oq l;
    private String p;
    private boolean s;
    private final f<om> m = new f<>(0);
    private final f<om> n = new f<>(0);
    private final a<oj> o = new a<>(0);
    private or q = or.enabled;
    private boolean r = true;
    float h = 1.0f;
    float i = 1.0f;
    final ka k = new ka(1.0f, 1.0f, 1.0f, 1.0f);

    public void a(Batch batch, float f) {
    }

    protected void q() {
    }

    protected void r() {
    }

    public boolean a(ol olVar) {
        if (olVar.h() == null) {
            olVar.a(e());
        }
        olVar.a(this);
        a aVar = (a) aa.b(a.class);
        for (on onVar = this.a; onVar != null; onVar = onVar.a) {
            aVar.a((a) onVar);
        }
        try {
            Object[] objArr = aVar.a;
            for (int i = aVar.b - 1; i >= 0; i--) {
                ((on) objArr[i]).a(olVar, true);
                if (olVar.f()) {
                    return olVar.g();
                }
            }
            a(olVar, true);
            if (olVar.f()) {
                return olVar.g();
            }
            a(olVar, false);
            if (olVar.d()) {
                if (olVar.f()) {
                    return olVar.g();
                }
                int i2 = aVar.b;
                for (int i3 = 0; i3 < i2; i3++) {
                    ((on) objArr[i3]).a(olVar, false);
                    if (olVar.f()) {
                        return olVar.g();
                    }
                }
                return olVar.g();
            }
            return olVar.g();
        } finally {
            aVar.d();
            aa.a(aVar);
        }
    }

    public boolean a(ol olVar, boolean z) {
        if (olVar.b() == null) {
            throw new IllegalArgumentException("The event target cannot be null.");
        }
        f<om> fVar = z ? this.n : this.m;
        if (fVar.b == 0) {
            return olVar.g();
        }
        olVar.b(this);
        olVar.a(z);
        if (olVar.h() == null) {
            olVar.a(this.l);
        }
        fVar.f();
        int i = fVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            om a = fVar.a(i2);
            if (a.a(olVar)) {
                olVar.a();
                if (olVar instanceof oo) {
                    oo ooVar = (oo) olVar;
                    if (ooVar.i() == oo.a.touchDown) {
                        olVar.h().a(a, this, ooVar.b(), ooVar.j(), ooVar.k());
                    }
                }
            }
        }
        fVar.g();
        return olVar.g();
    }

    public ok a(float f, float f2, boolean z) {
        if ((!z || this.q == or.enabled) && j() && f >= 0.0f && f < this.d && f2 >= 0.0f && f2 < this.e) {
            return this;
        }
        return null;
    }

    public boolean a() {
        on onVar = this.a;
        if (onVar != null) {
            return onVar.a(this, true);
        }
        return false;
    }

    public boolean a(om omVar) {
        if (omVar == null) {
            throw new IllegalArgumentException("listener cannot be null.");
        }
        return this.n.c(omVar, true);
    }

    public void a(oj ojVar) {
        ojVar.a(this);
        this.o.a((a<oj>) ojVar);
        oq oqVar = this.l;
        if (oqVar == null || !oqVar.k()) {
            return;
        }
        io.b.requestRendering();
    }

    public void b() {
        for (int i = this.o.b - 1; i >= 0; i--) {
            this.o.a(i).a((ok) null);
        }
        this.o.d();
    }

    public void c() {
        this.m.d();
        this.n.d();
    }

    public void d() {
        b();
        c();
    }

    public oq e() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(oq oqVar) {
        this.l = oqVar;
    }

    public boolean a(ok okVar) {
        if (okVar != null) {
            ok okVar2 = this;
            while (okVar2 != okVar) {
                okVar2 = okVar2.a;
                if (okVar2 == null) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("actor cannot be null.");
    }

    public boolean b(ok okVar) {
        if (okVar != null) {
            while (okVar != this) {
                okVar = okVar.a;
                if (okVar == null) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("actor cannot be null.");
    }

    public boolean f() {
        return this.a != null;
    }

    public on g() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(on onVar) {
        this.a = onVar;
    }

    public boolean h() {
        return this.q == or.enabled;
    }

    public or i() {
        return this.q;
    }

    public void a(or orVar) {
        this.q = orVar;
    }

    public boolean j() {
        return this.r;
    }

    public float k() {
        return this.b;
    }

    public float a(int i) {
        float f = this.b;
        if ((i & 16) != 0) {
            return f + this.d;
        }
        return (i & 8) == 0 ? f + (this.d / 2.0f) : f;
    }

    public void a(float f) {
        if (this.b != f) {
            this.b = f;
            q();
        }
    }

    public float l() {
        return this.c;
    }

    public void b(float f) {
        if (this.c != f) {
            this.c = f;
            q();
        }
    }

    public float b(int i) {
        float f = this.c;
        if ((i & 2) != 0) {
            return f + this.e;
        }
        return (i & 4) == 0 ? f + (this.e / 2.0f) : f;
    }

    public void a(float f, float f2) {
        if (this.b == f && this.c == f2) {
            return;
        }
        this.b = f;
        this.c = f2;
        q();
    }

    public void a(float f, float f2, int i) {
        if ((i & 16) != 0) {
            f -= this.d;
        } else if ((i & 8) == 0) {
            f -= this.d / 2.0f;
        }
        if ((i & 2) != 0) {
            f2 -= this.e;
        } else if ((i & 4) == 0) {
            f2 -= this.e / 2.0f;
        }
        if (this.b == f && this.c == f2) {
            return;
        }
        this.b = f;
        this.c = f2;
        q();
    }

    public void b(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.b += f;
        this.c += f2;
        q();
    }

    public float m() {
        return this.d;
    }

    public void c(float f) {
        if (this.d != f) {
            this.d = f;
            r();
        }
    }

    public float n() {
        return this.e;
    }

    public void d(float f) {
        if (this.e != f) {
            this.e = f;
            r();
        }
    }

    public float o() {
        return this.c + this.e;
    }

    public float p() {
        return this.b + this.d;
    }

    public void c(float f, float f2) {
        if (this.d == f && this.e == f2) {
            return;
        }
        this.d = f;
        this.e = f2;
        r();
    }

    public void a(float f, float f2, float f3, float f4) {
        if (this.b != f || this.c != f2) {
            this.b = f;
            this.c = f2;
            q();
        }
        if (this.d == f3 && this.e == f4) {
            return;
        }
        this.d = f3;
        this.e = f4;
        r();
    }

    public float s() {
        return this.f;
    }

    public float t() {
        return this.g;
    }

    public void d(float f, float f2) {
        this.f = f;
        this.g = f2;
    }

    public float u() {
        return this.h;
    }

    public float v() {
        return this.i;
    }

    public float w() {
        return this.j;
    }

    public ka x() {
        return this.k;
    }

    public void y() {
        c(Integer.MAX_VALUE);
    }

    public boolean c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("ZIndex cannot be < 0.");
        }
        on onVar = this.a;
        if (onVar == null) {
            return false;
        }
        ai<ok> aiVar = onVar.l;
        if (aiVar.b == 1) {
            return false;
        }
        int min = Math.min(i, aiVar.b - 1);
        if (aiVar.a(min) != this && aiVar.c(this, true)) {
            aiVar.b(min, (int) this);
            return true;
        }
        return false;
    }

    public boolean b(float f, float f2, float f3, float f4) {
        if (f3 <= 0.0f || f4 <= 0.0f) {
            return false;
        }
        n nVar = n.tmp;
        nVar.x = f;
        nVar.y = f2;
        nVar.width = f3;
        nVar.height = f4;
        oq oqVar = this.l;
        n nVar2 = (n) aa.b(n.class);
        oqVar.a(nVar, nVar2);
        if (qj.a(nVar2)) {
            return true;
        }
        aa.a(nVar2);
        return false;
    }

    public void z() {
        aa.a(qj.a());
    }

    public o a(o oVar) {
        on onVar = this.a;
        if (onVar != null) {
            onVar.a(oVar);
        }
        b(oVar);
        return oVar;
    }

    public o b(o oVar) {
        float f = this.j;
        float f2 = this.h;
        float f3 = this.i;
        float f4 = this.b;
        float f5 = this.c;
        if (f != 0.0f) {
            double d = f * 0.017453292f;
            float cos = (float) Math.cos(d);
            float sin = (float) Math.sin(d);
            float f6 = this.f;
            float f7 = this.g;
            float f8 = (oVar.d - f4) - f6;
            float f9 = (oVar.e - f5) - f7;
            oVar.d = (((f8 * cos) + (f9 * sin)) / f2) + f6;
            oVar.e = (((f8 * (-sin)) + (f9 * cos)) / f3) + f7;
        } else if (f2 == 1.0f && f3 == 1.0f) {
            oVar.d -= f4;
            oVar.e -= f5;
        } else {
            float f10 = this.f;
            float f11 = this.g;
            oVar.d = (((oVar.d - f4) - f10) / f2) + f10;
            oVar.e = (((oVar.e - f5) - f11) / f3) + f11;
        }
        return oVar;
    }

    public o c(o oVar) {
        return a((ok) null, oVar);
    }

    public o d(o oVar) {
        float f = -this.j;
        float f2 = this.h;
        float f3 = this.i;
        float f4 = this.b;
        float f5 = this.c;
        if (f != 0.0f) {
            double d = f * 0.017453292f;
            float cos = (float) Math.cos(d);
            float sin = (float) Math.sin(d);
            float f6 = this.f;
            float f7 = this.g;
            float f8 = (oVar.d - f6) * f2;
            float f9 = (oVar.e - f7) * f3;
            oVar.d = (f8 * cos) + (f9 * sin) + f6 + f4;
            oVar.e = (f8 * (-sin)) + (f9 * cos) + f7 + f5;
        } else if (f2 == 1.0f && f3 == 1.0f) {
            oVar.d += f4;
            oVar.e += f5;
        } else {
            float f10 = this.f;
            float f11 = this.g;
            oVar.d = ((oVar.d - f10) * f2) + f10 + f4;
            oVar.e = ((oVar.e - f11) * f3) + f11 + f5;
        }
        return oVar;
    }

    public o a(ok okVar, o oVar) {
        ok okVar2 = this;
        do {
            okVar2.d(oVar);
            okVar2 = okVar2.a;
            if (okVar2 != okVar) {
                break;
                break;
            }
            break;
        } while (okVar2 != null);
        return oVar;
    }

    public void a(r rVar) {
        b(rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(r rVar) {
        if (this.s) {
            rVar.b(r.a.Line);
            rVar.a(this.l.l());
            rVar.a(this.b, this.c, this.f, this.g, this.d, this.e, this.h, this.i, this.j);
        }
    }

    public void a(boolean z) {
        this.s = z;
        if (z) {
            oq.a = true;
        }
    }

    public boolean A() {
        return this.s;
    }

    public String toString() {
        String str = this.p;
        if (str == null) {
            String name = getClass().getName();
            int lastIndexOf = name.lastIndexOf(46);
            return lastIndexOf != -1 ? name.substring(lastIndexOf + 1) : name;
        }
        return str;
    }
}
