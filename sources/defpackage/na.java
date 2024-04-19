package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.l;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.v;
import com.badlogic.gdx.utils.z;
import java.util.Iterator;
/* compiled from: BaseAnimationController.java */
/* renamed from: na  reason: default package */
/* loaded from: classes.dex */
public class na {
    private static final v<lz, a> b = new v<>();
    private static final a d = new a();
    private final z<a> a = new z<a>() { // from class: na.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.badlogic.gdx.utils.z
        /* renamed from: a */
        public a newObject() {
            return new a();
        }
    };
    private boolean c = false;
    public final la k;

    /* compiled from: BaseAnimationController.java */
    /* renamed from: na$a */
    /* loaded from: classes.dex */
    public static final class a implements z.a {
        public final p a = new p();
        public final l b = new l();
        public final p c = new p(1.0f, 1.0f, 1.0f);

        public a a() {
            this.a.a(0.0f, 0.0f, 0.0f);
            this.b.d();
            this.c.a(1.0f, 1.0f, 1.0f);
            return this;
        }

        public a a(p pVar, l lVar, p pVar2) {
            this.a.a(pVar);
            this.b.a(lVar);
            this.c.a(pVar2);
            return this;
        }

        public a a(a aVar) {
            return a(aVar.a, aVar.b, aVar.c);
        }

        public a a(a aVar, float f) {
            return a(aVar.a, aVar.b, aVar.c, f);
        }

        public a a(p pVar, l lVar, p pVar2, float f) {
            this.a.b(pVar, f);
            this.b.a(lVar, f);
            this.c.b(pVar2, f);
            return this;
        }

        public Matrix4 a(Matrix4 matrix4) {
            return matrix4.a(this.a, this.b, this.c);
        }

        @Override // com.badlogic.gdx.utils.z.a
        public void reset() {
            a();
        }

        public String toString() {
            return this.a.toString() + " - " + this.b.toString() + " - " + this.c.toString();
        }
    }

    public na(la laVar) {
        this.k = laVar;
    }

    protected void a() {
        if (this.c) {
            throw new k("You must call end() after each call to being()");
        }
        this.c = true;
    }

    protected void a(lx lxVar, float f, float f2) {
        if (!this.c) {
            throw new k("You must call begin() before adding an animation");
        }
        a(b, this.a, f2, lxVar, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void b() {
        if (!this.c) {
            throw new k("You must call begin() first");
        }
        v.a<lz, a> it = b.c().iterator();
        while (it.hasNext()) {
            v.b next = it.next();
            ((a) next.b).a(((lz) next.a).g);
            this.a.free(next.b);
        }
        b.a();
        this.k.a();
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(lx lxVar, float f) {
        if (this.c) {
            throw new k("Call end() first");
        }
        a((v<lz, a>) null, (z<a>) null, 1.0f, lxVar, f);
        this.k.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(lx lxVar, float f, lx lxVar2, float f2, float f3) {
        if (lxVar2 == null || f3 == 0.0f) {
            a(lxVar, f);
        } else if (lxVar == null || f3 == 1.0f) {
            a(lxVar2, f2);
        } else if (this.c) {
            throw new k("Call end() first");
        } else {
            a();
            a(lxVar, f, 1.0f);
            a(lxVar2, f2, f3);
            b();
        }
    }

    private static final <T> int a(com.badlogic.gdx.utils.a<mb<T>> aVar, float f) {
        int i = aVar.b - 1;
        for (int i2 = 0; i2 < i; i2++) {
            if (f >= aVar.a(i2).a && f <= aVar.a(i2 + 1).a) {
                return i2;
            }
        }
        return 0;
    }

    private static final p a(ma maVar, float f, p pVar) {
        if (maVar.b == null) {
            return pVar.a(maVar.a.d);
        }
        if (maVar.b.b == 1) {
            return pVar.a(maVar.b.a(0).b);
        }
        int a2 = a(maVar.b, f);
        mb<p> a3 = maVar.b.a(a2);
        pVar.a(a3.b);
        int i = a2 + 1;
        if (i < maVar.b.b) {
            mb<p> a4 = maVar.b.a(i);
            pVar.b(a4.b, (f - a3.a) / (a4.a - a3.a));
        }
        return pVar;
    }

    private static final l a(ma maVar, float f, l lVar) {
        if (maVar.c == null) {
            return lVar.a(maVar.a.e);
        }
        if (maVar.c.b == 1) {
            return lVar.a(maVar.c.a(0).b);
        }
        int a2 = a(maVar.c, f);
        mb<l> a3 = maVar.c.a(a2);
        lVar.a(a3.b);
        int i = a2 + 1;
        if (i < maVar.c.b) {
            mb<l> a4 = maVar.c.a(i);
            lVar.a(a4.b, (f - a3.a) / (a4.a - a3.a));
        }
        return lVar;
    }

    private static final p b(ma maVar, float f, p pVar) {
        if (maVar.d == null) {
            return pVar.a(maVar.a.f);
        }
        if (maVar.d.b == 1) {
            return pVar.a(maVar.d.a(0).b);
        }
        int a2 = a(maVar.d, f);
        mb<p> a3 = maVar.d.a(a2);
        pVar.a(a3.b);
        int i = a2 + 1;
        if (i < maVar.d.b) {
            mb<p> a4 = maVar.d.a(i);
            pVar.b(a4.b, (f - a3.a) / (a4.a - a3.a));
        }
        return pVar;
    }

    private static final a a(ma maVar, float f) {
        a aVar = d;
        a(maVar, f, aVar.a);
        a(maVar, f, aVar.b);
        b(maVar, f, aVar.c);
        return aVar;
    }

    private static final void b(ma maVar, float f) {
        lz lzVar = maVar.a;
        lzVar.c = true;
        a(maVar, f).a(lzVar.g);
    }

    private static final void a(ma maVar, v<lz, a> vVar, z<a> zVar, float f, float f2) {
        lz lzVar = maVar.a;
        lzVar.c = true;
        a a2 = a(maVar, f2);
        a b2 = vVar.b(lzVar, null);
        if (b2 != null) {
            if (f > 0.999999f) {
                b2.a(a2);
            } else {
                b2.a(a2, f);
            }
        } else if (f > 0.999999f) {
            vVar.a((v<lz, a>) lzVar, (lz) zVar.obtain().a(a2));
        } else {
            vVar.a((v<lz, a>) lzVar, (lz) zVar.obtain().a(lzVar.d, lzVar.e, lzVar.f).a(a2, f));
        }
    }

    protected static void a(v<lz, a> vVar, z<a> zVar, float f, lx lxVar, float f2) {
        if (vVar == null) {
            Iterator<ma> it = lxVar.c.iterator();
            while (it.hasNext()) {
                b(it.next(), f2);
            }
            return;
        }
        v.c<lz> it2 = vVar.e().iterator();
        while (it2.hasNext()) {
            it2.next().c = false;
        }
        Iterator<ma> it3 = lxVar.c.iterator();
        while (it3.hasNext()) {
            a(it3.next(), vVar, zVar, f, f2);
        }
        v.a<lz, a> it4 = vVar.c().iterator();
        while (it4.hasNext()) {
            v.b next = it4.next();
            if (!((lz) next.a).c) {
                ((lz) next.a).c = true;
                ((a) next.b).a(((lz) next.a).d, ((lz) next.a).e, ((lz) next.a).f, f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(lx lxVar) {
        Iterator<ma> it = lxVar.c.iterator();
        while (it.hasNext()) {
            it.next().a.c = false;
        }
    }
}
