package defpackage;

import com.badlogic.gdx.math.o;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.z;
/* compiled from: MeshPartBuilder.java */
/* renamed from: ni  reason: default package */
/* loaded from: classes.dex */
public interface ni {
    short a(a aVar);

    @Deprecated
    void a(float f, float f2, float f3);

    void a(float f, float f2, float f3, float f4, float f5, float f6);

    @Deprecated
    void a(float f, float f2, float f3, int i, int i2);

    void a(int i);

    void a(p pVar, p pVar2, p pVar3, p pVar4, p pVar5);

    void a(p pVar, ka kaVar, p pVar2, ka kaVar2, p pVar3, ka kaVar3);

    void a(ka kaVar);

    void a(a aVar, a aVar2, a aVar3);

    void a(a aVar, a aVar2, a aVar3, a aVar4);

    void a(short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8);

    void b(int i);

    void b(kj kjVar);

    void b(short s, short s2, short s3, short s4);

    void c(int i);

    kt d();

    int e();

    /* compiled from: MeshPartBuilder.java */
    /* renamed from: ni$a */
    /* loaded from: classes.dex */
    public static class a implements z.a {
        public boolean b;
        public boolean d;
        public boolean f;
        public boolean h;
        public final p a = new p();
        public final p c = new p(0.0f, 1.0f, 0.0f);
        public final ka e = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        public final o g = new o();

        @Override // com.badlogic.gdx.utils.z.a
        public void reset() {
            this.a.a(0.0f, 0.0f, 0.0f);
            this.c.a(0.0f, 1.0f, 0.0f);
            this.e.a(1.0f, 1.0f, 1.0f, 1.0f);
            this.g.a(0.0f, 0.0f);
        }

        public a a(p pVar, p pVar2, ka kaVar, o oVar) {
            reset();
            this.b = pVar != null;
            if (this.b) {
                this.a.a(pVar);
            }
            this.d = pVar2 != null;
            if (this.d) {
                this.c.a(pVar2);
            }
            this.f = kaVar != null;
            if (this.f) {
                this.e.a(kaVar);
            }
            this.h = oVar != null;
            if (this.h) {
                this.g.a(oVar);
            }
            return this;
        }

        public a a(float f, float f2, float f3) {
            this.a.a(f, f2, f3);
            this.b = true;
            return this;
        }

        public a a(p pVar) {
            this.b = pVar != null;
            if (this.b) {
                this.a.a(pVar);
            }
            return this;
        }

        public a b(p pVar) {
            this.d = pVar != null;
            if (this.d) {
                this.c.a(pVar);
            }
            return this;
        }

        public a a(ka kaVar) {
            this.f = kaVar != null;
            if (this.f) {
                this.e.a(kaVar);
            }
            return this;
        }

        public a a(float f, float f2) {
            this.g.a(f, f2);
            this.h = true;
            return this;
        }
    }
}
