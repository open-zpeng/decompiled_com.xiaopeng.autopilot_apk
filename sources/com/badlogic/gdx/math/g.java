package com.badlogic.gdx.math;
/* compiled from: Intersector.java */
/* loaded from: classes.dex */
public final class g {
    private static final p h = new p();
    private static final p i = new p();
    private static final p j = new p();
    private static final com.badlogic.gdx.utils.h k = new com.badlogic.gdx.utils.h();
    private static final com.badlogic.gdx.utils.h l = new com.badlogic.gdx.utils.h();
    private static final o m = new o();
    private static final o n = new o();
    private static final o o = new o();
    private static final o p = new o();
    private static final o q = new o();
    private static final j r = new j(new p(), 0.0f);
    private static final p s = new p();
    private static final p t = new p();
    private static final p u = new p();
    static p a = new p();
    static p b = new p();
    static p c = new p();
    static p d = new p();
    static p e = new p();
    static o f = new o();
    static p g = new p();

    public static int a(o oVar, o oVar2, o oVar3) {
        return (int) Math.signum(((oVar2.d - oVar.d) * (oVar3.e - oVar.e)) - ((oVar2.e - oVar.e) * (oVar3.d - oVar.d)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f3, code lost:
        if (r4.a(r4.b - 1) != com.badlogic.gdx.math.g.m.e) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(com.badlogic.gdx.math.k r9, com.badlogic.gdx.math.k r10, com.badlogic.gdx.math.k r11) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.math.g.a(com.badlogic.gdx.math.k, com.badlogic.gdx.math.k, com.badlogic.gdx.math.k):boolean");
    }

    public static boolean a(oa oaVar, nz nzVar) {
        return a(oaVar, nzVar.a(c), nzVar.j(d));
    }

    public static boolean a(oa oaVar, p pVar, p pVar2) {
        float f2 = 1.0f / oaVar.b.a;
        float f3 = 1.0f / oaVar.b.b;
        float f4 = 1.0f / oaVar.b.c;
        float f5 = ((pVar.a - (pVar2.a * 0.5f)) - oaVar.a.a) * f2;
        float f6 = f2 * ((pVar.a + (pVar2.a * 0.5f)) - oaVar.a.a);
        if (f5 <= f6) {
            f5 = f6;
            f6 = f5;
        }
        float f7 = ((pVar.b - (pVar2.b * 0.5f)) - oaVar.a.b) * f3;
        float f8 = f3 * ((pVar.b + (pVar2.b * 0.5f)) - oaVar.a.b);
        if (f7 <= f8) {
            f7 = f8;
            f8 = f7;
        }
        float f9 = ((pVar.c - (pVar2.c * 0.5f)) - oaVar.a.c) * f4;
        float f10 = ((pVar.c + (pVar2.c * 0.5f)) - oaVar.a.c) * f4;
        if (f9 <= f10) {
            f9 = f10;
            f10 = f9;
        }
        float max = Math.max(Math.max(f6, f8), f10);
        float min = Math.min(Math.min(f5, f7), f9);
        return min >= 0.0f && min >= max;
    }

    public static boolean a(o oVar, o oVar2, o oVar3, o oVar4, o oVar5) {
        float f2 = oVar.d;
        float f3 = oVar.e;
        float f4 = oVar2.d;
        float f5 = oVar2.e;
        float f6 = oVar3.d;
        float f7 = oVar3.e;
        float f8 = oVar4.d;
        float f9 = oVar4.e - f7;
        float f10 = f4 - f2;
        float f11 = f8 - f6;
        float f12 = f5 - f3;
        float f13 = (f9 * f10) - (f11 * f12);
        if (f13 == 0.0f) {
            return false;
        }
        if (oVar5 != null) {
            float f14 = ((f11 * (f3 - f7)) - (f9 * (f2 - f6))) / f13;
            oVar5.a(f2 + (f10 * f14), f3 + (f12 * f14));
            return true;
        }
        return true;
    }
}
