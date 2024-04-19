package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.l;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.b;
import com.badlogic.gdx.utils.z;
import java.util.Iterator;
/* compiled from: ModelInstance.java */
/* renamed from: la  reason: default package */
/* loaded from: classes.dex */
public class la implements lc {
    public static boolean a = true;
    public final a<kx> b;
    public final a<lz> c;
    public final a<lx> d;
    public final ky e;
    public Matrix4 f;
    public Object g;

    public la(ky kyVar) {
        this(kyVar, null);
    }

    public la(ky kyVar, String str, boolean z) {
        this(kyVar, null, str, false, false, z);
    }

    public la(ky kyVar, Matrix4 matrix4, String str, boolean z) {
        this(kyVar, matrix4, str, false, false, z);
    }

    public la(ky kyVar, Matrix4 matrix4, String str, boolean z, boolean z2, boolean z3) {
        this(kyVar, matrix4, str, z, z2, z3, a);
    }

    public la(ky kyVar, Matrix4 matrix4, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        this.b = new a<>();
        this.c = new a<>();
        this.d = new a<>();
        this.e = kyVar;
        this.f = matrix4 == null ? new Matrix4() : matrix4;
        lz a2 = kyVar.a(str, z);
        a<lz> aVar = this.c;
        lz h = a2.h();
        aVar.a((a<lz>) h);
        if (z3) {
            this.f.b(z2 ? a2.h : a2.g);
            h.d.a(0.0f, 0.0f, 0.0f);
            h.e.d();
            h.f.a(1.0f, 1.0f, 1.0f);
        } else if (z2 && h.g()) {
            this.f.b(a2.f().h);
        }
        b();
        a(kyVar.c, z4);
        a();
    }

    public la(ky kyVar, String... strArr) {
        this(kyVar, (Matrix4) null, strArr);
    }

    public la(ky kyVar, Matrix4 matrix4, String... strArr) {
        this.b = new a<>();
        this.c = new a<>();
        this.d = new a<>();
        this.e = kyVar;
        this.f = matrix4 == null ? new Matrix4() : matrix4;
        if (strArr == null) {
            a(kyVar.b);
        } else {
            a(kyVar.b, strArr);
        }
        a(kyVar.c, a);
        a();
    }

    private void a(a<lz> aVar) {
        int i = aVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.c.a((a<lz>) aVar.a(i2).h());
        }
        b();
    }

    private void a(a<lz> aVar, String... strArr) {
        int i = aVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            lz a2 = aVar.a(i2);
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (strArr[i3].equals(a2.a)) {
                    this.c.a((a<lz>) a2.h());
                    break;
                } else {
                    i3++;
                }
            }
        }
        b();
    }

    private void a(lz lzVar) {
        int i = lzVar.i.b;
        for (int i2 = 0; i2 < i; i2++) {
            mc a2 = lzVar.i.a(i2);
            b<lz, Matrix4> bVar = a2.c;
            if (bVar != null) {
                for (int i3 = 0; i3 < bVar.c; i3++) {
                    bVar.a[i3] = c(bVar.a[i3].a);
                }
            }
            if (!this.b.a((a<kx>) a2.b, true)) {
                int b = this.b.b((a<kx>) a2.b, false);
                if (b < 0) {
                    a<kx> aVar = this.b;
                    kx e = a2.b.e();
                    a2.b = e;
                    aVar.a((a<kx>) e);
                } else {
                    a2.b = this.b.a(b);
                }
            }
        }
        int d = lzVar.d();
        for (int i4 = 0; i4 < d; i4++) {
            a(lzVar.a(i4));
        }
    }

    private void b() {
        int i = this.c.b;
        for (int i2 = 0; i2 < i; i2++) {
            a(this.c.a(i2));
        }
    }

    private void a(Iterable<lx> iterable, boolean z) {
        for (lx lxVar : iterable) {
            lx lxVar2 = new lx();
            lxVar2.a = lxVar.a;
            lxVar2.b = lxVar.b;
            Iterator<ma> it = lxVar.c.iterator();
            while (it.hasNext()) {
                ma next = it.next();
                lz c = c(next.a.a);
                if (c != null) {
                    ma maVar = new ma();
                    maVar.a = c;
                    if (z) {
                        maVar.b = next.b;
                        maVar.c = next.c;
                        maVar.d = next.d;
                    } else {
                        if (next.b != null) {
                            maVar.b = new a<>();
                            Iterator<mb<p>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                mb<p> next2 = it2.next();
                                maVar.b.a((a<mb<p>>) new mb<>(next2.a, next2.b));
                            }
                        }
                        if (next.c != null) {
                            maVar.c = new a<>();
                            Iterator<mb<l>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                mb<l> next3 = it3.next();
                                maVar.c.a((a<mb<l>>) new mb<>(next3.a, next3.b));
                            }
                        }
                        if (next.d != null) {
                            maVar.d = new a<>();
                            Iterator<mb<p>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                mb<p> next4 = it4.next();
                                maVar.d.a((a<mb<p>>) new mb<>(next4.a, next4.b));
                            }
                        }
                    }
                    if (maVar.b != null || maVar.c != null || maVar.d != null) {
                        lxVar2.c.a((a<ma>) maVar);
                    }
                }
            }
            if (lxVar2.c.b > 0) {
                this.d.a((a<lx>) lxVar2);
            }
        }
    }

    @Override // defpackage.lc
    public void a(a<lb> aVar, z<lb> zVar) {
        Iterator<lz> it = this.c.iterator();
        while (it.hasNext()) {
            a(it.next(), aVar, zVar);
        }
    }

    public lb a(lb lbVar, lz lzVar, mc mcVar) {
        mcVar.a(lbVar);
        if (mcVar.d == null && this.f != null) {
            lbVar.a.a(this.f).b(lzVar.h);
        } else if (this.f != null) {
            lbVar.a.a(this.f);
        } else {
            lbVar.a.c();
        }
        lbVar.g = this.g;
        return lbVar;
    }

    protected void a(lz lzVar, a<lb> aVar, z<lb> zVar) {
        if (lzVar.i.b > 0) {
            Iterator<mc> it = lzVar.i.iterator();
            while (it.hasNext()) {
                mc next = it.next();
                if (next.e) {
                    aVar.a((a<lb>) a(zVar.obtain(), lzVar, next));
                }
            }
        }
        for (lz lzVar2 : lzVar.e()) {
            a(lzVar2, aVar, zVar);
        }
    }

    public void a() {
        int i = this.c.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.c.a(i2).a(true);
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.c.a(i3).b(true);
        }
    }

    public nz a(nz nzVar) {
        nzVar.a();
        return b(nzVar);
    }

    public nz b(nz nzVar) {
        int i = this.c.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.c.a(i2).a(nzVar);
        }
        return nzVar;
    }

    public lx a(String str) {
        return a(str, false);
    }

    public lx a(String str, boolean z) {
        int i = this.d.b;
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                lx a2 = this.d.a(i2);
                if (a2.a.equalsIgnoreCase(str)) {
                    return a2;
                }
                i2++;
            }
            return null;
        }
        while (i2 < i) {
            lx a3 = this.d.a(i2);
            if (a3.a.equals(str)) {
                return a3;
            }
            i2++;
        }
        return null;
    }

    public kx b(String str) {
        return b(str, true);
    }

    public kx b(String str, boolean z) {
        int i = this.b.b;
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                kx a2 = this.b.a(i2);
                if (a2.d.equalsIgnoreCase(str)) {
                    return a2;
                }
                i2++;
            }
            return null;
        }
        while (i2 < i) {
            kx a3 = this.b.a(i2);
            if (a3.d.equals(str)) {
                return a3;
            }
            i2++;
        }
        return null;
    }

    public lz c(String str) {
        return c(str, true);
    }

    public lz c(String str, boolean z) {
        return a(str, z, false);
    }

    public lz a(String str, boolean z, boolean z2) {
        return lz.a(this.c, str, z, z2);
    }
}
