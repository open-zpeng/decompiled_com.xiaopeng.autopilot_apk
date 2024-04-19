package defpackage;

import androidx.recyclerview.widget.j;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.al;
/* compiled from: Label.java */
/* renamed from: pg  reason: default package */
/* loaded from: classes.dex */
public class pg extends px {
    private static final ka l = new ka();
    private static final GlyphLayout m = new GlyphLayout();
    private String B;
    private a n;
    private BitmapFontCache s;
    private boolean v;
    private float w;
    private final GlyphLayout o = new GlyphLayout();
    private final o p = new o();
    private final al q = new al();
    private int r = j.UNDEFINED_DURATION;
    private int t = 8;
    private int u = 8;
    private boolean x = true;
    private float y = 1.0f;
    private float z = 1.0f;
    private boolean A = false;

    public pg(CharSequence charSequence, a aVar) {
        if (charSequence != null) {
            this.q.append(charSequence);
        }
        a(aVar);
        if (charSequence == null || charSequence.length() <= 0) {
            return;
        }
        c(L(), M());
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("style cannot be null.");
        }
        if (aVar.a == null) {
            throw new IllegalArgumentException("Missing LabelStyle font.");
        }
        this.n = aVar;
        this.s = aVar.a.newFontCache();
        g_();
    }

    public a C() {
        return this.n;
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (charSequence instanceof al) {
            if (this.q.equals(charSequence)) {
                return;
            }
            this.q.a(0);
            this.q.a((al) charSequence);
        } else if (b(charSequence)) {
            return;
        } else {
            this.q.a(0);
            this.q.append(charSequence);
        }
        this.r = j.UNDEFINED_DURATION;
        g_();
    }

    public boolean b(CharSequence charSequence) {
        int i = this.q.b;
        char[] cArr = this.q.a;
        if (i != charSequence.length()) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (cArr[i2] != charSequence.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.px
    public void D() {
        super.D();
        this.x = true;
    }

    private void E() {
        BitmapFont font = this.s.getFont();
        float scaleX = font.getScaleX();
        float scaleY = font.getScaleY();
        if (this.A) {
            font.getData().setScale(this.y, this.z);
        }
        F();
        if (this.A) {
            font.getData().setScale(scaleX, scaleY);
        }
    }

    private void F() {
        this.x = false;
        GlyphLayout glyphLayout = m;
        if (this.v && this.B == null) {
            float m2 = m();
            if (this.n.c != null) {
                m2 -= this.n.c.a() + this.n.c.b();
            }
            glyphLayout.setText(this.s.getFont(), this.q, ka.a, m2, 8, true);
        } else {
            glyphLayout.setText(this.s.getFont(), this.q);
        }
        this.p.a(glyphLayout.width, glyphLayout.height);
    }

    @Override // defpackage.px
    public void B() {
        float f;
        float f2;
        float f3;
        float f4;
        GlyphLayout glyphLayout;
        float f5;
        float f6;
        float f7;
        float f8;
        BitmapFont font = this.s.getFont();
        float scaleX = font.getScaleX();
        float scaleY = font.getScaleY();
        if (this.A) {
            font.getData().setScale(this.y, this.z);
        }
        boolean z = this.v && this.B == null;
        if (z) {
            float M = M();
            if (M != this.w) {
                this.w = M;
                g_();
            }
        }
        float m2 = m();
        float n = n();
        qf qfVar = this.n.c;
        if (qfVar != null) {
            float a2 = qfVar.a();
            float d = qfVar.d();
            f = m2 - (qfVar.a() + qfVar.b());
            f2 = n - (qfVar.d() + qfVar.c());
            f3 = a2;
            f4 = d;
        } else {
            f = m2;
            f2 = n;
            f3 = 0.0f;
            f4 = 0.0f;
        }
        GlyphLayout glyphLayout2 = this.o;
        if (z || this.q.b("\n") != -1) {
            al alVar = this.q;
            glyphLayout = glyphLayout2;
            glyphLayout2.setText(font, alVar, 0, alVar.b, ka.a, f, this.u, z, this.B);
            float f9 = glyphLayout.width;
            f5 = glyphLayout.height;
            int i = this.t;
            if ((i & 8) != 0) {
                f6 = f9;
                f7 = f3;
            } else if ((i & 16) != 0) {
                f6 = f9;
                f7 = f3 + (f - f9);
            } else {
                f6 = f9;
                f7 = f3 + ((f - f9) / 2.0f);
            }
        } else {
            f5 = font.getData().capHeight;
            glyphLayout = glyphLayout2;
            f6 = f;
            f7 = f3;
        }
        int i2 = this.t;
        if ((i2 & 2) != 0) {
            f8 = f4 + (this.s.getFont().isFlipped() ? 0.0f : f2 - f5) + this.n.a.getDescent();
        } else if ((i2 & 4) != 0) {
            f8 = (f4 + (this.s.getFont().isFlipped() ? f2 - f5 : 0.0f)) - this.n.a.getDescent();
        } else {
            f8 = f4 + ((f2 - f5) / 2.0f);
        }
        if (!this.s.getFont().isFlipped()) {
            f8 += f5;
        }
        al alVar2 = this.q;
        glyphLayout.setText(font, alVar2, 0, alVar2.b, ka.a, f6, this.u, z, this.B);
        this.s.setText(glyphLayout, f7, f8);
        if (this.A) {
            font.getData().setScale(scaleX, scaleY);
        }
    }

    @Override // defpackage.px, defpackage.ok
    public void a(Batch batch, float f) {
        i_();
        ka a2 = l.a(x());
        a2.M *= f;
        if (this.n.c != null) {
            batch.setColor(a2.J, a2.K, a2.L, a2.M);
            this.n.c.a(batch, k(), l(), m(), n());
        }
        if (this.n.b != null) {
            a2.b(this.n.b);
        }
        this.s.tint(a2);
        this.s.setPosition(k(), l());
        this.s.draw(batch);
    }

    @Override // defpackage.px, defpackage.qh
    public float L() {
        if (this.v) {
            return 0.0f;
        }
        if (this.x) {
            E();
        }
        float f = this.p.d;
        qf qfVar = this.n.c;
        return qfVar != null ? f + qfVar.a() + qfVar.b() : f;
    }

    @Override // defpackage.px, defpackage.qh
    public float M() {
        if (this.x) {
            E();
        }
        float descent = this.p.e - ((this.n.a.getDescent() * (this.A ? this.z / this.n.a.getScaleY() : 1.0f)) * 2.0f);
        qf qfVar = this.n.c;
        return qfVar != null ? descent + qfVar.c() + qfVar.d() : descent;
    }

    public void e(float f) {
        e(f, f);
    }

    public void e(float f, float f2) {
        this.A = true;
        this.y = f;
        this.z = f2;
        g_();
    }

    @Override // defpackage.ok
    public String toString() {
        return super.toString() + ": " + ((Object) this.q);
    }

    /* compiled from: Label.java */
    /* renamed from: pg$a */
    /* loaded from: classes.dex */
    public static class a {
        public BitmapFont a;
        public ka b;
        public qf c;

        public a() {
        }

        public a(BitmapFont bitmapFont, ka kaVar) {
            this.a = bitmapFont;
            this.b = kaVar;
        }
    }
}
