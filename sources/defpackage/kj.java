package defpackage;

import com.badlogic.gdx.graphics.glutils.j;
import com.badlogic.gdx.graphics.glutils.k;
import com.badlogic.gdx.graphics.glutils.l;
import com.badlogic.gdx.graphics.glutils.m;
import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.graphics.glutils.s;
import com.badlogic.gdx.graphics.glutils.t;
import com.badlogic.gdx.graphics.glutils.u;
import com.badlogic.gdx.graphics.glutils.v;
import com.badlogic.gdx.graphics.glutils.w;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.g;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Mesh.java */
/* renamed from: kj  reason: default package */
/* loaded from: classes.dex */
public class kj implements g {
    static final Map<ij, com.badlogic.gdx.utils.a<kj>> a = new HashMap();
    final w b;
    final m c;
    boolean d;
    final boolean e;
    private final p f;

    /* compiled from: Mesh.java */
    /* renamed from: kj$a */
    /* loaded from: classes.dex */
    public enum a {
        VertexArray,
        VertexBufferObject,
        VertexBufferObjectSubData,
        VertexBufferObjectWithVAO
    }

    public kj(boolean z, int i, int i2, ks... ksVarArr) {
        this.d = true;
        this.f = new p();
        this.b = a(z, i, new kt(ksVarArr));
        this.c = new k(z, i2);
        this.e = false;
        a(io.a, this);
    }

    public kj(boolean z, int i, int i2, kt ktVar) {
        this.d = true;
        this.f = new p();
        this.b = a(z, i, ktVar);
        this.c = new k(z, i2);
        this.e = false;
        a(io.a, this);
    }

    private w a(boolean z, int i, kt ktVar) {
        if (io.i != null) {
            return new v(z, i, ktVar);
        }
        return new t(z, i, ktVar);
    }

    public kj(a aVar, boolean z, int i, int i2, ks... ksVarArr) {
        this(aVar, z, i, i2, new kt(ksVarArr));
    }

    public kj(a aVar, boolean z, int i, int i2, kt ktVar) {
        this.d = true;
        this.f = new p();
        switch (aVar) {
            case VertexBufferObject:
                this.b = new t(z, i, ktVar);
                this.c = new k(z, i2);
                this.e = false;
                break;
            case VertexBufferObjectSubData:
                this.b = new u(z, i, ktVar);
                this.c = new l(z, i2);
                this.e = false;
                break;
            case VertexBufferObjectWithVAO:
                this.b = new v(z, i, ktVar);
                this.c = new l(z, i2);
                this.e = false;
                break;
            default:
                this.b = new s(i, ktVar);
                this.c = new j(i2);
                this.e = true;
                break;
        }
        a(io.a, this);
    }

    public kj a(float[] fArr, int i, int i2) {
        this.b.a(fArr, i, i2);
        return this;
    }

    public float[] a(float[] fArr) {
        return a(0, -1, fArr);
    }

    public float[] a(int i, int i2, float[] fArr) {
        return a(i, i2, fArr, 0);
    }

    public float[] a(int i, int i2, float[] fArr, int i3) {
        int b = (b() * e()) / 4;
        if (i2 == -1 && (i2 = b - i) > fArr.length - i3) {
            i2 = fArr.length - i3;
        }
        if (i < 0 || i2 <= 0 || i + i2 > b || i3 < 0 || i3 >= fArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (fArr.length - i3 < i2) {
            throw new IllegalArgumentException("not enough room in vertices array, has " + fArr.length + " floats, needs " + i2);
        }
        int position = g().position();
        g().position(i);
        g().get(fArr, i3, i2);
        g().position(position);
        return fArr;
    }

    public kj a(short[] sArr) {
        this.c.a(sArr, 0, sArr.length);
        return this;
    }

    public kj a(short[] sArr, int i, int i2) {
        this.c.a(sArr, i, i2);
        return this;
    }

    public void a(int i, int i2, short[] sArr, int i3) {
        int a2 = a();
        if (i2 < 0) {
            i2 = a2 - i;
        }
        if (i < 0 || i >= a2 || i + i2 > a2) {
            throw new IllegalArgumentException("Invalid range specified, offset: " + i + ", count: " + i2 + ", max: " + a2);
        } else if (sArr.length - i3 < i2) {
            throw new IllegalArgumentException("not enough room in indices array, has " + sArr.length + " shorts, needs " + i2);
        } else {
            int position = h().position();
            h().position(i);
            h().get(sArr, i3, i2);
            h().position(position);
        }
    }

    public int a() {
        return this.c.a();
    }

    public int b() {
        return this.b.b();
    }

    public int c() {
        return this.b.c();
    }

    public int d() {
        return this.c.b();
    }

    public int e() {
        return this.b.d().a;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(q qVar) {
        a(qVar, (int[]) null);
    }

    public void a(q qVar, int[] iArr) {
        this.b.a(qVar, iArr);
        if (this.c.a() > 0) {
            this.c.d();
        }
    }

    public void b(q qVar) {
        b(qVar, null);
    }

    public void b(q qVar, int[] iArr) {
        this.b.b(qVar, iArr);
        if (this.c.a() > 0) {
            this.c.e();
        }
    }

    public void a(q qVar, int i) {
        a(qVar, i, 0, this.c.b() > 0 ? a() : b(), this.d);
    }

    public void a(q qVar, int i, int i2, int i3) {
        a(qVar, i, i2, i3, this.d);
    }

    public void a(q qVar, int i, int i2, int i3, boolean z) {
        if (i3 == 0) {
            return;
        }
        if (z) {
            a(qVar);
        }
        if (this.e) {
            if (this.c.a() > 0) {
                ShortBuffer c = this.c.c();
                int position = c.position();
                int limit = c.limit();
                c.position(i2);
                c.limit(i2 + i3);
                io.h.glDrawElements(i, i3, 5123, c);
                c.position(position);
                c.limit(limit);
            } else {
                io.h.glDrawArrays(i, i2, i3);
            }
        } else if (this.c.a() > 0) {
            if (i3 + i2 > this.c.b()) {
                throw new com.badlogic.gdx.utils.k("Mesh attempting to access memory outside of the index buffer (count: " + i3 + ", offset: " + i2 + ", max: " + this.c.b() + ")");
            }
            io.h.glDrawElements(i, i3, 5123, i2 * 2);
        } else {
            io.h.glDrawArrays(i, i2, i3);
        }
        if (z) {
            b(qVar);
        }
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        if (a.get(io.a) != null) {
            a.get(io.a).c(this, true);
        }
        this.b.dispose();
        this.c.dispose();
    }

    public ks a(int i) {
        kt d = this.b.d();
        int a2 = d.a();
        for (int i2 = 0; i2 < a2; i2++) {
            if (d.b(i2).a == i) {
                return d.b(i2);
            }
        }
        return null;
    }

    public kt f() {
        return this.b.d();
    }

    public FloatBuffer g() {
        return this.b.a();
    }

    public nz a(nz nzVar, int i, int i2) {
        return b(nzVar.a(), i, i2);
    }

    public nz b(nz nzVar, int i, int i2) {
        return a(nzVar, i, i2, (Matrix4) null);
    }

    public nz a(nz nzVar, int i, int i2, Matrix4 matrix4) {
        int i3;
        int a2 = a();
        int b = b();
        if (a2 != 0) {
            b = a2;
        }
        if (i < 0 || i2 < 1 || (i3 = i + i2) > b) {
            throw new com.badlogic.gdx.utils.k("Invalid part specified ( offset=" + i + ", count=" + i2 + ", max=" + b + " )");
        }
        FloatBuffer a3 = this.b.a();
        ShortBuffer c = this.c.c();
        ks a4 = a(1);
        int i4 = a4.e / 4;
        int i5 = this.b.d().a / 4;
        switch (a4.b) {
            case 1:
                if (a2 <= 0) {
                    while (i < i3) {
                        this.f.a(a3.get((i * i5) + i4), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.f.a(matrix4);
                        }
                        nzVar.k(this.f);
                        i++;
                    }
                    break;
                } else {
                    while (i < i3) {
                        this.f.a(a3.get((c.get(i) * i5) + i4), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.f.a(matrix4);
                        }
                        nzVar.k(this.f);
                        i++;
                    }
                    break;
                }
            case 2:
                if (a2 <= 0) {
                    while (i < i3) {
                        int i6 = (i * i5) + i4;
                        this.f.a(a3.get(i6), a3.get(i6 + 1), 0.0f);
                        if (matrix4 != null) {
                            this.f.a(matrix4);
                        }
                        nzVar.k(this.f);
                        i++;
                    }
                    break;
                } else {
                    while (i < i3) {
                        int i7 = (c.get(i) * i5) + i4;
                        this.f.a(a3.get(i7), a3.get(i7 + 1), 0.0f);
                        if (matrix4 != null) {
                            this.f.a(matrix4);
                        }
                        nzVar.k(this.f);
                        i++;
                    }
                    break;
                }
            case 3:
                if (a2 <= 0) {
                    while (i < i3) {
                        int i8 = (i * i5) + i4;
                        this.f.a(a3.get(i8), a3.get(i8 + 1), a3.get(i8 + 2));
                        if (matrix4 != null) {
                            this.f.a(matrix4);
                        }
                        nzVar.k(this.f);
                        i++;
                    }
                    break;
                } else {
                    while (i < i3) {
                        int i9 = (c.get(i) * i5) + i4;
                        this.f.a(a3.get(i9), a3.get(i9 + 1), a3.get(i9 + 2));
                        if (matrix4 != null) {
                            this.f.a(matrix4);
                        }
                        nzVar.k(this.f);
                        i++;
                    }
                    break;
                }
        }
        return nzVar;
    }

    public ShortBuffer h() {
        return this.c.c();
    }

    private static void a(ij ijVar, kj kjVar) {
        com.badlogic.gdx.utils.a<kj> aVar = a.get(ijVar);
        if (aVar == null) {
            aVar = new com.badlogic.gdx.utils.a<>();
        }
        aVar.a((com.badlogic.gdx.utils.a<kj>) kjVar);
        a.put(ijVar, aVar);
    }

    public static void a(ij ijVar) {
        com.badlogic.gdx.utils.a<kj> aVar = a.get(ijVar);
        if (aVar == null) {
            return;
        }
        for (int i = 0; i < aVar.b; i++) {
            aVar.a(i).b.e();
            aVar.a(i).c.f();
        }
    }

    public static void b(ij ijVar) {
        a.remove(ijVar);
    }

    public static String i() {
        StringBuilder sb = new StringBuilder();
        sb.append("Managed meshes/app: { ");
        for (ij ijVar : a.keySet()) {
            sb.append(a.get(ijVar).b);
            sb.append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
}
