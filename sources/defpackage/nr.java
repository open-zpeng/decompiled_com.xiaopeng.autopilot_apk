package defpackage;

import com.badlogic.gdx.math.p;
import defpackage.ni;
/* compiled from: BoxShapeBuilder.java */
/* renamed from: nr  reason: default package */
/* loaded from: classes.dex */
public class nr extends nq {
    public static void a(ni niVar, ni.a aVar, ni.a aVar2, ni.a aVar3, ni.a aVar4, ni.a aVar5, ni.a aVar6, ni.a aVar7, ni.a aVar8) {
        niVar.a(8);
        short a = niVar.a(aVar);
        short a2 = niVar.a(aVar3);
        short a3 = niVar.a(aVar4);
        short a4 = niVar.a(aVar2);
        short a5 = niVar.a(aVar5);
        short a6 = niVar.a(aVar7);
        short a7 = niVar.a(aVar8);
        short a8 = niVar.a(aVar6);
        int e = niVar.e();
        if (e == 1) {
            niVar.b(24);
            niVar.b(a, a2, a3, a4);
            niVar.b(a6, a5, a8, a7);
            niVar.a(a, a5, a4, a8, a3, a7, a2, a6);
        } else if (e == 0) {
            niVar.c(2);
            niVar.b(a, a2, a3, a4);
            niVar.b(a6, a5, a8, a7);
        } else {
            niVar.c(6);
            niVar.b(a, a2, a3, a4);
            niVar.b(a6, a5, a8, a7);
            niVar.b(a, a4, a8, a5);
            niVar.b(a6, a7, a3, a2);
            niVar.b(a6, a2, a, a5);
            niVar.b(a3, a7, a8, a4);
        }
    }

    public static void a(ni niVar, p pVar, p pVar2, p pVar3, p pVar4, p pVar5, p pVar6, p pVar7, p pVar8) {
        if ((niVar.d().b() & 408) == 0) {
            a(niVar, o.a(pVar, null, null, null), p.a(pVar2, null, null, null), q.a(pVar3, null, null, null), r.a(pVar4, null, null, null), s.a(pVar5, null, null, null), t.a(pVar6, null, null, null), u.a(pVar7, null, null, null), v.a(pVar8, null, null, null));
            return;
        }
        niVar.a(24);
        niVar.c(6);
        p d = g.a(pVar).b(pVar4, 0.5f).c(h.a(pVar5).b(pVar8, 0.5f)).d();
        niVar.a(pVar, pVar2, pVar4, pVar3, d);
        niVar.a(pVar6, pVar5, pVar7, pVar8, d.a(-1.0f));
        p d2 = g.a(pVar).b(pVar7, 0.5f).c(h.a(pVar2).b(pVar8, 0.5f)).d();
        niVar.a(pVar5, pVar, pVar3, pVar7, d2);
        niVar.a(pVar2, pVar6, pVar8, pVar4, d2.a(-1.0f));
        p d3 = g.a(pVar).b(pVar6, 0.5f).c(h.a(pVar3).b(pVar8, 0.5f)).d();
        niVar.a(pVar5, pVar6, pVar2, pVar, d3);
        niVar.a(pVar3, pVar4, pVar8, pVar7, d3.a(-1.0f));
    }

    public static void a(ni niVar, float f, float f2, float f3) {
        a(niVar, 0.0f, 0.0f, 0.0f, f, f2, f3);
    }

    public static void a(ni niVar, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f4 * 0.5f;
        float f8 = f5 * 0.5f;
        float f9 = 0.5f * f6;
        float f10 = f - f7;
        float f11 = f2 - f8;
        float f12 = f3 - f9;
        float f13 = f + f7;
        float f14 = f2 + f8;
        float f15 = f3 + f9;
        a(niVar, a().a(f10, f11, f12), a().a(f10, f14, f12), a().a(f13, f11, f12), a().a(f13, f14, f12), a().a(f10, f11, f15), a().a(f10, f14, f15), a().a(f13, f11, f15), a().a(f13, f14, f15));
        b();
    }
}
