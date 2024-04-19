package defpackage;

import com.badlogic.gdx.utils.z;
import defpackage.ok;
/* compiled from: Cell.java */
/* renamed from: pa  reason: default package */
/* loaded from: classes.dex */
public class pa<T extends ok> implements z.a {
    private static final Float J = Float.valueOf(0.0f);
    private static final Float K = Float.valueOf(1.0f);
    private static final Integer L = 0;
    private static final Integer M = 1;
    private static final Integer N = M;
    private static final Integer O = 2;
    private static final Integer P = 4;
    private static final Integer Q = 8;
    private static final Integer R = 16;
    private static in S;
    private static pa T;
    float A;
    boolean B;
    int C;
    int D;
    int E;
    float F;
    float G;
    float H;
    float I;
    private po U;
    pw a;
    pw b;
    pw c;
    pw d;
    pw e;
    pw f;
    pw g;
    pw h;
    pw i;
    pw j;
    pw k;
    pw l;
    pw m;
    pw n;
    Float o;
    Float p;
    Integer q;
    Integer r;
    Integer s;
    Integer t;
    Boolean u;
    Boolean v;
    ok w;
    float x;
    float y;
    float z;

    public pa() {
        reset();
    }

    public void a(po poVar) {
        this.U = poVar;
    }

    public void a(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.A = f4;
    }

    public void a(float f) {
        this.y = f;
    }

    @Override // com.badlogic.gdx.utils.z.a
    public void reset() {
        this.w = null;
        this.U = null;
        this.B = false;
        this.E = -1;
        pa a = a();
        if (a != null) {
            a(a);
        }
    }

    void a(pa paVar) {
        this.a = paVar.a;
        this.b = paVar.b;
        this.c = paVar.c;
        this.d = paVar.d;
        this.e = paVar.e;
        this.f = paVar.f;
        this.g = paVar.g;
        this.h = paVar.h;
        this.i = paVar.i;
        this.j = paVar.j;
        this.k = paVar.k;
        this.l = paVar.l;
        this.m = paVar.m;
        this.n = paVar.n;
        this.o = paVar.o;
        this.p = paVar.p;
        this.q = paVar.q;
        this.r = paVar.r;
        this.s = paVar.s;
        this.t = paVar.t;
        this.u = paVar.u;
        this.v = paVar.v;
    }

    public String toString() {
        ok okVar = this.w;
        return okVar != null ? okVar.toString() : super.toString();
    }

    public static pa a() {
        in inVar = S;
        if (inVar == null || inVar != io.e) {
            S = io.e;
            T = new pa();
            T.a = pw.b;
            T.b = pw.c;
            T.c = pw.d;
            T.d = pw.e;
            T.e = pw.f;
            T.f = pw.g;
            T.g = pw.a;
            T.h = pw.a;
            T.i = pw.a;
            T.j = pw.a;
            T.k = pw.a;
            T.l = pw.a;
            T.m = pw.a;
            T.n = pw.a;
            pa paVar = T;
            Float f = J;
            paVar.o = f;
            paVar.p = f;
            paVar.q = N;
            Integer num = L;
            paVar.r = num;
            paVar.s = num;
            paVar.t = M;
            paVar.u = null;
            paVar.v = null;
        }
        return T;
    }
}
