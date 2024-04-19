package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.utils.aa;
import com.badlogic.gdx.utils.z;
/* compiled from: List.java */
/* renamed from: ph  reason: default package */
/* loaded from: classes.dex */
public class ph<T> extends px implements qe {
    a l;
    final com.badlogic.gdx.utils.a<T> m;
    final qa<T> n;
    float o;
    int p;
    int q;
    private n r;
    private float s;
    private float t;
    private int u;

    /* compiled from: List.java */
    /* renamed from: ph$a */
    /* loaded from: classes.dex */
    public static class a {
        public BitmapFont a;
        public ka b = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        public ka c = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        public qf d;
        public qf e;
        public qf f;
        public qf g;
    }

    @Override // defpackage.px
    public void B() {
        BitmapFont bitmapFont = this.l.a;
        qf qfVar = this.l.d;
        this.o = bitmapFont.getCapHeight() - (bitmapFont.getDescent() * 2.0f);
        this.o += qfVar.c() + qfVar.d();
        this.s = 0.0f;
        z a2 = aa.a(GlyphLayout.class);
        GlyphLayout glyphLayout = (GlyphLayout) a2.obtain();
        for (int i = 0; i < this.m.b; i++) {
            glyphLayout.setText(bitmapFont, a((ph<T>) this.m.a(i)));
            this.s = Math.max(glyphLayout.width, this.s);
        }
        a2.free(glyphLayout);
        this.s += qfVar.a() + qfVar.b();
        this.t = this.m.b * this.o;
        qf qfVar2 = this.l.g;
        if (qfVar2 != null) {
            this.s += qfVar2.a() + qfVar2.b();
            this.t += qfVar2.c() + qfVar2.d();
        }
    }

    @Override // defpackage.px, defpackage.ok
    public void a(Batch batch, float f) {
        float f2;
        float f3;
        int i;
        i_();
        BitmapFont bitmapFont = this.l.a;
        qf qfVar = this.l.d;
        ka kaVar = this.l.b;
        ka kaVar2 = this.l.c;
        ka x = x();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        float k = k();
        float l = l();
        float m = m();
        float n = n();
        qf qfVar2 = this.l.g;
        if (qfVar2 != null) {
            qfVar2.a(batch, k, l, m, n);
            float a2 = qfVar2.a();
            n -= qfVar2.c();
            f2 = k + a2;
            f3 = m - (a2 + qfVar2.b());
        } else {
            f2 = k;
            f3 = m;
        }
        float a3 = qfVar.a();
        float b = (f3 - a3) - qfVar.b();
        float c = qfVar.c() - bitmapFont.getDescent();
        bitmapFont.setColor(kaVar2.J, kaVar2.K, kaVar2.L, kaVar2.M * f);
        int i2 = 0;
        float f4 = n;
        while (i2 < this.m.b) {
            n nVar = this.r;
            if (nVar == null || (f4 - this.o <= nVar.y + this.r.height && f4 >= this.r.y)) {
                T a4 = this.m.a(i2);
                boolean a5 = this.n.a(a4);
                if (a5) {
                    qf qfVar3 = (this.p != i2 || this.l.e == null) ? qfVar : this.l.e;
                    float f5 = this.o;
                    qfVar3.a(batch, f2, (l + f4) - f5, f3, f5);
                    bitmapFont.setColor(kaVar.J, kaVar.K, kaVar.L, kaVar.M * f);
                } else if (this.q == i2 && this.l.f != null) {
                    qf qfVar4 = this.l.f;
                    float f6 = this.o;
                    qfVar4.a(batch, f2, (l + f4) - f6, f3, f6);
                }
                i = i2;
                a(batch, bitmapFont, i2, a4, f2 + a3, (l + f4) - c, b);
                if (a5) {
                    bitmapFont.setColor(kaVar2.J, kaVar2.K, kaVar2.L, kaVar2.M * f);
                }
            } else if (f4 < this.r.y) {
                return;
            } else {
                i = i2;
            }
            f4 -= this.o;
            i2 = i + 1;
        }
    }

    protected GlyphLayout a(Batch batch, BitmapFont bitmapFont, int i, T t, float f, float f2, float f3) {
        String a2 = a((ph<T>) t);
        return bitmapFont.draw(batch, a2, f, f2, 0, a2.length(), f3, this.u, false, "...");
    }

    @Override // defpackage.px, defpackage.qh
    public float L() {
        i_();
        return this.s;
    }

    @Override // defpackage.px, defpackage.qh
    public float M() {
        i_();
        return this.t;
    }

    protected String a(T t) {
        return t.toString();
    }

    @Override // defpackage.qe
    public void a(n nVar) {
        this.r = nVar;
    }
}
