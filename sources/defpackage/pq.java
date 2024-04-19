package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.ap;
import com.badlogic.gdx.utils.h;
/* compiled from: TextField.java */
/* renamed from: pq  reason: default package */
/* loaded from: classes.dex */
public class pq extends px {
    private static final o E = new o();
    private static final o F = new o();
    private static final o G = new o();
    public static float l = 0.4f;
    public static float m = 0.1f;
    boolean A;
    float B;
    final ap.a C;
    final a D;
    private String H;
    private int I;
    private float J;
    private float K;
    private int L;
    private int M;
    protected int n;
    protected int o;
    protected boolean p;
    protected final h q;
    b r;
    protected CharSequence s;
    op t;
    boolean u;
    protected float v;
    protected float w;
    protected float x;
    float y;
    boolean z;

    /* compiled from: TextField.java */
    /* renamed from: pq$b */
    /* loaded from: classes.dex */
    public static class b {
        public BitmapFont a;
        public ka b;
        public ka c;
        public ka d;
        public qf e;
        public qf f;
        public qf g;
        public qf h;
        public qf i;
        public BitmapFont j;
        public ka k;
    }

    @Override // defpackage.px, defpackage.qh
    public float L() {
        return 150.0f;
    }

    protected void C() {
        float m2 = m();
        qf E2 = E();
        if (E2 != null) {
            m2 -= E2.a() + E2.b();
        }
        int i = this.q.b;
        float[] fArr = this.q.a;
        float f = fArr[Math.max(0, this.n - 1)];
        float f2 = this.y;
        float f3 = f + f2;
        float f4 = 0.0f;
        if (f3 <= 0.0f) {
            this.y = f2 - f3;
        } else {
            float f5 = fArr[Math.min(i - 1, this.n + 1)] - m2;
            if ((-this.y) < f5) {
                this.y = -f5;
            }
        }
        float f6 = fArr[i - 1];
        int i2 = i - 2;
        float f7 = 0.0f;
        while (i2 >= 0) {
            float f8 = fArr[i2];
            if (f6 - f8 > m2) {
                break;
            }
            i2--;
            f7 = f8;
        }
        if ((-this.y) > f7) {
            this.y = -f7;
        }
        this.L = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                break;
            } else if (fArr[i3] >= (-this.y)) {
                this.L = Math.max(0, i3);
                f4 = fArr[i3];
                break;
            } else {
                i3++;
            }
        }
        int min = Math.min(this.s.length(), fArr.length - 1);
        this.M = Math.min(min, this.n + 1);
        while (true) {
            int i4 = this.M;
            if (i4 > min || fArr[i4] > f4 + m2) {
                break;
            }
            this.M = i4 + 1;
        }
        this.M = Math.max(0, this.M - 1);
        int i5 = this.I;
        if ((i5 & 8) == 0) {
            this.x = m2 - (fArr[this.M] - f4);
            if ((i5 & 1) != 0) {
                this.x = Math.round(this.x * 0.5f);
            }
        } else {
            this.x = f4 + this.y;
        }
        if (this.p) {
            int min2 = Math.min(this.n, this.o);
            int max = Math.max(this.n, this.o);
            float max2 = Math.max(fArr[min2] - fArr[this.L], -this.x);
            float min3 = Math.min(fArr[max] - fArr[this.L], m2 - this.x);
            this.J = max2;
            this.K = (min3 - max2) - this.r.a.getData().cursorX;
        }
    }

    private qf E() {
        oq e = e();
        return (!this.u || this.r.g == null) ? (!(e != null && e.e() == this) || this.r.f == null) ? this.r.e : this.r.f : this.r.g;
    }

    @Override // defpackage.px, defpackage.ok
    public void a(Batch batch, float f) {
        float f2;
        float f3;
        qf qfVar;
        BitmapFont bitmapFont;
        boolean z = e() != null && e().e() == this;
        if (z != this.z) {
            this.z = z;
            this.C.a();
            this.A = z;
            if (z) {
                ap.a aVar = this.C;
                float f4 = this.B;
                ap.b(aVar, f4, f4);
            } else {
                this.D.a();
            }
        }
        BitmapFont bitmapFont2 = this.r.a;
        ka kaVar = (!this.u || this.r.d == null) ? (!z || this.r.c == null) ? this.r.b : this.r.c : this.r.d;
        qf qfVar2 = this.r.i;
        qf qfVar3 = this.r.h;
        qf E2 = E();
        ka x = x();
        float k = k();
        float l2 = l();
        float m2 = m();
        float n = n();
        batch.setColor(x.J, x.K, x.L, x.M * f);
        if (E2 != null) {
            E2.a(batch, k, l2, m2, n);
            f3 = E2.a();
            f2 = E2.b();
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        float a2 = a(bitmapFont2, E2);
        C();
        if (z && this.p && qfVar2 != null) {
            a(qfVar2, batch, bitmapFont2, k + f3, l2 + a2);
        }
        float f5 = bitmapFont2.isFlipped() ? -this.w : 0.0f;
        if (this.s.length() == 0) {
            if (z || this.H == null) {
                qfVar = qfVar3;
                bitmapFont = bitmapFont2;
            } else {
                if (this.r.k != null) {
                    bitmapFont2.setColor(this.r.k.J, this.r.k.K, this.r.k.L, this.r.k.M * x.M * f);
                } else {
                    bitmapFont2.setColor(0.7f, 0.7f, 0.7f, x.M * f);
                }
                BitmapFont bitmapFont3 = this.r.j != null ? this.r.j : bitmapFont2;
                String str = this.H;
                qfVar = qfVar3;
                bitmapFont = bitmapFont2;
                bitmapFont3.draw(batch, str, k + f3, l2 + a2 + f5, 0, str.length(), (m2 - f3) - f2, this.I, false, "...");
            }
        } else {
            qfVar = qfVar3;
            bitmapFont = bitmapFont2;
            bitmapFont.setColor(kaVar.J, kaVar.K, kaVar.L, kaVar.M * x.M * f);
            a(batch, bitmapFont, k + f3, l2 + a2 + f5);
        }
        if (this.u || !this.A || qfVar == null) {
            return;
        }
        b(qfVar, batch, bitmapFont, k + f3, l2 + a2);
    }

    protected float a(BitmapFont bitmapFont, qf qfVar) {
        float f;
        float n = n();
        float descent = (this.w / 2.0f) + bitmapFont.getDescent();
        if (qfVar != null) {
            float d = qfVar.d();
            f = descent + (((n - qfVar.c()) - d) / 2.0f) + d;
        } else {
            f = descent + (n / 2.0f);
        }
        return bitmapFont.usesIntegerPositions() ? (int) f : f;
    }

    protected void a(qf qfVar, Batch batch, BitmapFont bitmapFont, float f, float f2) {
        qfVar.a(batch, f + this.x + this.J + this.v, (f2 - this.w) - bitmapFont.getDescent(), this.K, this.w);
    }

    protected void a(Batch batch, BitmapFont bitmapFont, float f, float f2) {
        bitmapFont.draw(batch, this.s, f + this.x, f2, this.L, this.M, 0.0f, 8, false);
    }

    protected void b(qf qfVar, Batch batch, BitmapFont bitmapFont, float f, float f2) {
        qfVar.a(batch, (((f + this.x) + this.q.a(this.n)) - this.q.a(this.L)) + this.v + bitmapFont.getData().cursorX, (f2 - this.w) - bitmapFont.getDescent(), qfVar.e(), this.w);
    }

    @Override // defpackage.px, defpackage.qh
    public float M() {
        float f;
        float f2 = 0.0f;
        if (this.r.e != null) {
            f = Math.max(0.0f, this.r.e.d() + this.r.e.c());
            f2 = Math.max(0.0f, this.r.e.f());
        } else {
            f = 0.0f;
        }
        if (this.r.f != null) {
            f = Math.max(f, this.r.f.d() + this.r.f.c());
            f2 = Math.max(f2, this.r.f.f());
        }
        if (this.r.g != null) {
            f = Math.max(f, this.r.g.d() + this.r.g.c());
            f2 = Math.max(f2, this.r.g.f());
        }
        return Math.max(f + this.w, f2);
    }

    /* compiled from: TextField.java */
    /* renamed from: pq$a */
    /* loaded from: classes.dex */
    class a extends ap.a {
        int a;
        final /* synthetic */ pq b;

        @Override // com.badlogic.gdx.utils.ap.a, java.lang.Runnable
        public void run() {
            this.b.t.a((oo) null, this.a);
        }
    }
}
