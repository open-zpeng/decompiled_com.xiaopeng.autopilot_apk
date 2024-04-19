package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.r;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.aa;
import com.badlogic.gdx.utils.ae;
import com.badlogic.gdx.utils.ai;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.z;
import defpackage.oo;
import defpackage.po;
import defpackage.qg;
/* compiled from: Stage.java */
/* renamed from: oq  reason: default package */
/* loaded from: classes.dex */
public class oq extends ir implements g {
    static boolean a;
    private qz b;
    private final Batch c;
    private boolean d;
    private on e;
    private final o f;
    private final ok[] g;
    private final boolean[] h;
    private final int[] i;
    private final int[] j;
    private int k;
    private int l;
    private ok m;
    private ok n;
    private final ai<a> o;
    private boolean p;
    private r q;
    private boolean r;
    private boolean s;
    private boolean t;
    private po.a u;
    private final ka v;

    public oq() {
        this(new qy(ae.stretch, io.b.getWidth(), io.b.getHeight(), new kk()), new SpriteBatch());
        this.d = true;
    }

    public oq(qz qzVar, Batch batch) {
        this.f = new o();
        this.g = new ok[20];
        this.h = new boolean[20];
        this.i = new int[20];
        this.j = new int[20];
        this.o = new ai<>(true, 4, a.class);
        this.p = true;
        this.u = po.a.none;
        this.v = new ka(0.0f, 1.0f, 0.0f, 0.85f);
        if (qzVar == null) {
            throw new IllegalArgumentException("viewport cannot be null.");
        }
        if (batch == null) {
            throw new IllegalArgumentException("batch cannot be null.");
        }
        this.b = qzVar;
        this.c = batch;
        this.e = new on();
        this.e.a(this);
        qzVar.a(io.b.getWidth(), io.b.getHeight(), true);
    }

    public void a() {
        jz a2 = this.b.a();
        a2.a();
        if (this.e.j()) {
            Batch batch = this.c;
            batch.setProjectionMatrix(a2.f);
            batch.begin();
            this.e.a(batch, 1.0f);
            batch.end();
            if (a) {
                m();
            }
        }
    }

    private void m() {
        if (this.q == null) {
            this.q = new r();
            this.q.a(true);
        }
        if (this.s || this.t || this.u != po.a.none) {
            a(this.f.a(io.d.getX(), io.d.getY()));
            ok a2 = a(this.f.d, this.f.e, true);
            if (a2 == null) {
                return;
            }
            if (this.t && a2.a != null) {
                a2 = a2.a;
            }
            if (this.u == po.a.none) {
                a2.a(true);
            } else {
                while (a2 != null && !(a2 instanceof po)) {
                    a2 = a2.a;
                }
                if (a2 == null) {
                    return;
                }
                ((po) a2).a(this.u);
            }
            if (this.r && (a2 instanceof on)) {
                ((on) a2).G();
            }
            a(this.e, a2);
        } else if (this.r) {
            this.e.G();
        }
        io.g.glEnable(3042);
        this.q.a(this.b.a().f);
        this.q.b();
        this.e.a(this.q);
        this.q.c();
    }

    private void a(ok okVar, ok okVar2) {
        if (okVar == okVar2) {
            return;
        }
        okVar.a(false);
        if (okVar instanceof on) {
            ai<ok> aiVar = ((on) okVar).l;
            int i = aiVar.b;
            for (int i2 = 0; i2 < i; i2++) {
                a(aiVar.a(i2), okVar2);
            }
        }
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3, int i4) {
        if (a(i, i2)) {
            this.h[i3] = true;
            this.i[i3] = i;
            this.j[i3] = i2;
            a(this.f.a(i, i2));
            oo ooVar = (oo) aa.b(oo.class);
            ooVar.a(oo.a.touchDown);
            ooVar.a(this);
            ooVar.a(this.f.d);
            ooVar.b(this.f.e);
            ooVar.a(i3);
            ooVar.b(i4);
            ok a2 = a(this.f.d, this.f.e, true);
            if (a2 == null) {
                if (this.e.i() == or.enabled) {
                    this.e.a(ooVar);
                }
            } else {
                a2.a(ooVar);
            }
            boolean e = ooVar.e();
            aa.a(ooVar);
            return e;
        }
        return false;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3) {
        this.i[i3] = i;
        this.j[i3] = i2;
        this.k = i;
        this.l = i2;
        if (this.o.b == 0) {
            return false;
        }
        a(this.f.a(i, i2));
        oo ooVar = (oo) aa.b(oo.class);
        ooVar.a(oo.a.touchDragged);
        ooVar.a(this);
        ooVar.a(this.f.d);
        ooVar.b(this.f.e);
        ooVar.a(i3);
        ai<a> aiVar = this.o;
        a[] f = aiVar.f();
        int i4 = aiVar.b;
        for (int i5 = 0; i5 < i4; i5++) {
            a aVar = f[i5];
            if (aVar.d == i3 && aiVar.a((ai<a>) aVar, true)) {
                ooVar.a(aVar.c);
                ooVar.b(aVar.b);
                if (aVar.a.a(ooVar)) {
                    ooVar.a();
                }
            }
        }
        aiVar.g();
        boolean e = ooVar.e();
        aa.a(ooVar);
        return e;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean b(int i, int i2, int i3, int i4) {
        this.h[i3] = false;
        this.i[i3] = i;
        this.j[i3] = i2;
        if (this.o.b == 0) {
            return false;
        }
        a(this.f.a(i, i2));
        oo ooVar = (oo) aa.b(oo.class);
        ooVar.a(oo.a.touchUp);
        ooVar.a(this);
        ooVar.a(this.f.d);
        ooVar.b(this.f.e);
        ooVar.a(i3);
        ooVar.b(i4);
        ai<a> aiVar = this.o;
        a[] f = aiVar.f();
        int i5 = aiVar.b;
        for (int i6 = 0; i6 < i5; i6++) {
            a aVar = f[i6];
            if (aVar.d == i3 && aVar.e == i4 && aiVar.c(aVar, true)) {
                ooVar.a(aVar.c);
                ooVar.b(aVar.b);
                if (aVar.a.a(ooVar)) {
                    ooVar.a();
                }
                aa.a(aVar);
            }
        }
        aiVar.g();
        boolean e = ooVar.e();
        aa.a(ooVar);
        return e;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean b(int i, int i2) {
        this.k = i;
        this.l = i2;
        if (a(i, i2)) {
            a(this.f.a(i, i2));
            oo ooVar = (oo) aa.b(oo.class);
            ooVar.a(this);
            ooVar.a(oo.a.mouseMoved);
            ooVar.a(this.f.d);
            ooVar.b(this.f.e);
            ok a2 = a(this.f.d, this.f.e, true);
            if (a2 == null) {
                a2 = this.e;
            }
            a2.a(ooVar);
            boolean e = ooVar.e();
            aa.a(ooVar);
            return e;
        }
        return false;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean c(int i) {
        ok okVar = this.n;
        if (okVar == null) {
            okVar = this.e;
        }
        a(this.f.a(this.k, this.l));
        oo ooVar = (oo) aa.b(oo.class);
        ooVar.a(this);
        ooVar.a(oo.a.scrolled);
        ooVar.d(i);
        ooVar.a(this.f.d);
        ooVar.b(this.f.e);
        okVar.a(ooVar);
        boolean e = ooVar.e();
        aa.a(ooVar);
        return e;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(int i) {
        ok okVar = this.m;
        if (okVar == null) {
            okVar = this.e;
        }
        oo ooVar = (oo) aa.b(oo.class);
        ooVar.a(this);
        ooVar.a(oo.a.keyDown);
        ooVar.c(i);
        okVar.a(ooVar);
        boolean e = ooVar.e();
        aa.a(ooVar);
        return e;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean b(int i) {
        ok okVar = this.m;
        if (okVar == null) {
            okVar = this.e;
        }
        oo ooVar = (oo) aa.b(oo.class);
        ooVar.a(this);
        ooVar.a(oo.a.keyUp);
        ooVar.c(i);
        okVar.a(ooVar);
        boolean e = ooVar.e();
        aa.a(ooVar);
        return e;
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(char c) {
        ok okVar = this.m;
        if (okVar == null) {
            okVar = this.e;
        }
        oo ooVar = (oo) aa.b(oo.class);
        ooVar.a(this);
        ooVar.a(oo.a.keyTyped);
        ooVar.a(c);
        okVar.a(ooVar);
        boolean e = ooVar.e();
        aa.a(ooVar);
        return e;
    }

    public void a(om omVar, ok okVar, ok okVar2, int i, int i2) {
        a aVar = (a) aa.b(a.class);
        aVar.b = okVar;
        aVar.c = okVar2;
        aVar.a = omVar;
        aVar.d = i;
        aVar.e = i2;
        this.o.a((ai<a>) aVar);
    }

    public void a(ok okVar) {
        oo ooVar = (oo) aa.b(oo.class);
        ooVar.a(this);
        ooVar.a(oo.a.touchUp);
        ooVar.a(-2.14748365E9f);
        ooVar.b(-2.14748365E9f);
        ai<a> aiVar = this.o;
        a[] f = aiVar.f();
        int i = aiVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            a aVar = f[i2];
            if (aVar.b == okVar && aiVar.c(aVar, true)) {
                ooVar.a(aVar.c);
                ooVar.b(aVar.b);
                ooVar.a(aVar.d);
                ooVar.b(aVar.e);
                aVar.a.a(ooVar);
            }
        }
        aiVar.g();
        aa.a(ooVar);
    }

    public void b() {
        a((om) null, (ok) null);
    }

    public void a(om omVar, ok okVar) {
        oo ooVar = (oo) aa.b(oo.class);
        ooVar.a(this);
        ooVar.a(oo.a.touchUp);
        ooVar.a(-2.14748365E9f);
        ooVar.b(-2.14748365E9f);
        ai<a> aiVar = this.o;
        a[] f = aiVar.f();
        int i = aiVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            a aVar = f[i2];
            if ((aVar.a != omVar || aVar.b != okVar) && aiVar.c(aVar, true)) {
                ooVar.a(aVar.c);
                ooVar.b(aVar.b);
                ooVar.a(aVar.d);
                ooVar.b(aVar.e);
                aVar.a.a(ooVar);
            }
        }
        aiVar.g();
        aa.a(ooVar);
    }

    public void b(ok okVar) {
        this.e.c(okVar);
    }

    public boolean a(om omVar) {
        return this.e.a(omVar);
    }

    public void c() {
        d();
        this.e.d();
    }

    public void d() {
        e(null);
        d(null);
        b();
    }

    public void c(ok okVar) {
        a(okVar);
        ok okVar2 = this.n;
        if (okVar2 != null && okVar2.a(okVar)) {
            e(null);
        }
        ok okVar3 = this.m;
        if (okVar3 == null || !okVar3.a(okVar)) {
            return;
        }
        d(null);
    }

    public boolean d(ok okVar) {
        if (this.m == okVar) {
            return true;
        }
        qg.a aVar = (qg.a) aa.b(qg.a.class);
        aVar.a(this);
        aVar.a(qg.a.EnumC0066a.keyboard);
        ok okVar2 = this.m;
        if (okVar2 != null) {
            aVar.b(false);
            aVar.c(okVar);
            okVar2.a(aVar);
        }
        boolean z = !aVar.g();
        if (z) {
            this.m = okVar;
            if (okVar != null) {
                aVar.b(true);
                aVar.c(okVar2);
                okVar.a(aVar);
                z = !aVar.g();
                if (!z) {
                    this.m = okVar2;
                }
            }
        }
        aa.a(aVar);
        return z;
    }

    public ok e() {
        return this.m;
    }

    public boolean e(ok okVar) {
        if (this.n == okVar) {
            return true;
        }
        qg.a aVar = (qg.a) aa.b(qg.a.class);
        aVar.a(this);
        aVar.a(qg.a.EnumC0066a.scroll);
        ok okVar2 = this.n;
        if (okVar2 != null) {
            aVar.b(false);
            aVar.c(okVar);
            okVar2.a(aVar);
        }
        boolean z = !aVar.g();
        if (z) {
            this.n = okVar;
            if (okVar != null) {
                aVar.b(true);
                aVar.c(okVar2);
                okVar.a(aVar);
                z = !aVar.g();
                if (!z) {
                    this.n = okVar2;
                }
            }
        }
        aa.a(aVar);
        return z;
    }

    public ok f() {
        return this.n;
    }

    public float g() {
        return this.b.b();
    }

    public float h() {
        return this.b.c();
    }

    public jz i() {
        return this.b.a();
    }

    public on j() {
        return this.e;
    }

    public ok a(float f, float f2, boolean z) {
        this.e.b(this.f.a(f, f2));
        return this.e.a(this.f.d, this.f.e, z);
    }

    public o a(o oVar) {
        this.b.a(oVar);
        return oVar;
    }

    public void a(n nVar, n nVar2) {
        Matrix4 transformMatrix;
        this.b.a(this.c.getTransformMatrix(), nVar, nVar2);
        r rVar = this.q;
        if (rVar != null && rVar.e()) {
            transformMatrix = this.q.a();
        } else {
            transformMatrix = this.c.getTransformMatrix();
        }
        this.b.a(transformMatrix, nVar, nVar2);
    }

    public boolean k() {
        return this.p;
    }

    public ka l() {
        return this.v;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        c();
        if (this.d) {
            this.c.dispose();
        }
    }

    protected boolean a(int i, int i2) {
        int d = this.b.d();
        int f = this.b.f() + d;
        int e = this.b.e();
        int g = this.b.g() + e;
        int height = (io.b.getHeight() - 1) - i2;
        return i >= d && i < f && height >= e && height < g;
    }

    /* compiled from: Stage.java */
    /* renamed from: oq$a */
    /* loaded from: classes.dex */
    public static final class a implements z.a {
        om a;
        ok b;
        ok c;
        int d;
        int e;

        @Override // com.badlogic.gdx.utils.z.a
        public void reset() {
            this.b = null;
            this.a = null;
            this.c = null;
        }
    }
}
