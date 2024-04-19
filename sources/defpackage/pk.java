package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.f;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.aa;
import com.badlogic.gdx.utils.z;
import defpackage.ph;
import defpackage.pj;
/* compiled from: SelectBox.java */
/* renamed from: pk  reason: default package */
/* loaded from: classes.dex */
public class pk<T> extends px {
    static final o l = new o();
    b m;
    final com.badlogic.gdx.utils.a<T> n;
    final qa<T> o;
    a<T> p;
    boolean q;
    private float r;
    private float s;
    private qd t;
    private int u;

    /* compiled from: SelectBox.java */
    /* renamed from: pk$b */
    /* loaded from: classes.dex */
    public static class b {
        public BitmapFont a;
        public ka b = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        public ka c;
        public qf d;
        public pj.a e;
        public ph.a f;
        public qf g;
        public qf h;
        public qf i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ok
    public void a(oq oqVar) {
        if (oqVar == null) {
            this.p.S();
        }
        super.a(oqVar);
    }

    @Override // defpackage.px
    public void B() {
        qf qfVar = this.m.d;
        BitmapFont bitmapFont = this.m.a;
        if (qfVar != null) {
            this.s = Math.max(((qfVar.c() + qfVar.d()) + bitmapFont.getCapHeight()) - (bitmapFont.getDescent() * 2.0f), qfVar.f());
        } else {
            this.s = bitmapFont.getCapHeight() - (bitmapFont.getDescent() * 2.0f);
        }
        z a2 = aa.a(GlyphLayout.class);
        GlyphLayout glyphLayout = (GlyphLayout) a2.obtain();
        float f = 0.0f;
        for (int i = 0; i < this.n.b; i++) {
            glyphLayout.setText(bitmapFont, a((pk<T>) this.n.a(i)));
            f = Math.max(glyphLayout.width, f);
        }
        a2.free(glyphLayout);
        this.r = f;
        if (qfVar != null) {
            this.r += qfVar.a() + qfVar.b();
        }
        ph.a aVar = this.m.f;
        pj.a aVar2 = this.m.e;
        float a3 = f + aVar.d.a() + aVar.d.b();
        if (aVar2.a != null) {
            a3 += aVar2.a.a() + aVar2.a.b();
        }
        a<T> aVar3 = this.p;
        if (aVar3 == null || !aVar3.J) {
            a3 += Math.max(this.m.e.e != null ? this.m.e.e.e() : 0.0f, this.m.e.f != null ? this.m.e.f.e() : 0.0f);
        }
        this.r = Math.max(this.r, a3);
    }

    @Override // defpackage.px, defpackage.ok
    public void a(Batch batch, float f) {
        qf qfVar;
        float f2;
        float f3;
        i_();
        if (this.q && this.m.i != null) {
            qfVar = this.m.i;
        } else if (this.p.f() && this.m.h != null) {
            qfVar = this.m.h;
        } else if (this.t.d() && this.m.g != null) {
            qfVar = this.m.g;
        } else {
            qfVar = this.m.d != null ? this.m.d : null;
        }
        BitmapFont bitmapFont = this.m.a;
        ka kaVar = (!this.q || this.m.c == null) ? this.m.b : this.m.c;
        ka x = x();
        float k = k();
        float l2 = l();
        float m = m();
        float n = n();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        if (qfVar != null) {
            qfVar.a(batch, k, l2, m, n);
        }
        T b2 = this.o.b();
        if (b2 != null) {
            if (qfVar != null) {
                m -= qfVar.a() + qfVar.b();
                f2 = l2 + ((int) (((n - (qfVar.d() + qfVar.c())) / 2.0f) + qfVar.d() + (bitmapFont.getData().capHeight / 2.0f)));
                f3 = k + qfVar.a();
            } else {
                f2 = l2 + ((int) ((n / 2.0f) + (bitmapFont.getData().capHeight / 2.0f)));
                f3 = k;
            }
            bitmapFont.setColor(kaVar.J, kaVar.K, kaVar.L, kaVar.M * f);
            a(batch, bitmapFont, b2, f3, f2, m);
        }
    }

    protected GlyphLayout a(Batch batch, BitmapFont bitmapFont, T t, float f, float f2, float f3) {
        String a2 = a((pk<T>) t);
        return bitmapFont.draw(batch, a2, f, f2, 0, a2.length(), f3, this.u, false, "...");
    }

    @Override // defpackage.px, defpackage.qh
    public float L() {
        i_();
        return this.r;
    }

    @Override // defpackage.px, defpackage.qh
    public float M() {
        i_();
        return this.s;
    }

    protected String a(T t) {
        return t.toString();
    }

    protected void c(ok okVar) {
        okVar.x().M = 1.0f;
        okVar.a(os.a(os.a(0.15f, f.e), os.a()));
    }

    /* compiled from: SelectBox.java */
    /* renamed from: pk$a */
    /* loaded from: classes.dex */
    static class a<T> extends pj {
        final ph<T> K;
        private final pk<T> L;
        private final o M;
        private op N;
        private ok O;

        public void S() {
            if (this.K.h() && f()) {
                this.K.a(or.disabled);
                oq e = e();
                if (e != null) {
                    e.a(this.N);
                    ok okVar = this.O;
                    if (okVar != null && okVar.e() == null) {
                        this.O = null;
                    }
                    ok f = e.f();
                    if (f == null || b(f)) {
                        e.e(this.O);
                    }
                }
                b();
                this.L.c(this);
            }
        }

        @Override // defpackage.pj, defpackage.py, defpackage.on, defpackage.ok
        public void a(Batch batch, float f) {
            this.L.c(pk.l.a(0.0f, 0.0f));
            if (!pk.l.equals(this.M)) {
                S();
            }
            super.a(batch, f);
        }
    }
}
