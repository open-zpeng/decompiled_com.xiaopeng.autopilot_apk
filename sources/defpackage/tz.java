package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingSlotBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingSpdBumpBean;
import defpackage.a;
/* compiled from: CoorUtil.java */
/* renamed from: tz  reason: default package */
/* loaded from: classes.dex */
public class tz {
    private static String a = "CoorUtil";
    private static Matrix4 b = new Matrix4();
    private static Matrix4 c = new Matrix4();
    private static Matrix4 d = new Matrix4();
    private static Matrix4 e = new Matrix4();

    public static p a(float f, float f2, float f3) {
        p pVar = new p();
        pVar.a = f;
        pVar.b = f3;
        pVar.c = -f2;
        pVar.a(uc.c);
        if (((i.ad) i.a(i.ad.class)).d().intValue() >= 0) {
            pVar.b = 0.0f;
        }
        return pVar;
    }

    public static p b(float f, float f2, float f3) {
        p pVar = new p();
        pVar.a = f;
        pVar.b = 0.0f;
        pVar.c = -f2;
        pVar.a(uc.c);
        return pVar;
    }

    public static p c(float f, float f2, float f3) {
        p pVar = new p();
        pVar.a = f;
        pVar.b = f3;
        pVar.c = -f2;
        pVar.a(uc.c);
        return pVar;
    }

    public static p d(float f, float f2, float f3) {
        p pVar = new p();
        pVar.a = -f2;
        pVar.b = f3;
        pVar.c = -f;
        pVar.a(uc.c);
        if (((i.ad) i.a(i.ad.class)).d().intValue() >= 0) {
            pVar.b = 0.0f;
        }
        return pVar;
    }

    public static p e(float f, float f2, float f3) {
        p pVar = new p();
        pVar.a = f;
        pVar.b = -f3;
        pVar.c = f2;
        pVar.a(1.0f / uc.c);
        return pVar;
    }

    public static Matrix4 a(a.k kVar, a.c cVar, float f) {
        boolean z = cVar.f() == 1;
        p b2 = z ? b(kVar) : a(kVar);
        Matrix4 d2 = z ? d(kVar) : e(kVar);
        b.c();
        b = d2;
        c.c();
        c.b(b2);
        d.c();
        d.b(c).b(b);
        return d.a();
    }

    public static p a(a.k kVar) {
        a.e a2 = kVar.a();
        kVar.b();
        a.e c2 = kVar.c();
        kVar.d();
        return d(a2.a() + ((c2.a() - a2.a()) / 2.0f), c2.b() + ((a2.b() - c2.b()) / 2.0f), a2.c());
    }

    public static p b(a.k kVar) {
        a.e a2 = kVar.a();
        kVar.b();
        a.e c2 = kVar.c();
        kVar.d();
        return a(a2.a() + ((c2.a() - a2.a()) / 2.0f), c2.b() + ((a2.b() - c2.b()) / 2.0f), a2.c());
    }

    public static p c(a.k kVar) {
        a.e a2 = kVar.a();
        kVar.b();
        a.e c2 = kVar.c();
        kVar.d();
        return new p(a2.a() + ((c2.a() - a2.a()) / 2.0f), c2.b() + ((a2.b() - c2.b()) / 2.0f), a2.c());
    }

    public static Matrix4 d(a.k kVar) {
        p d2 = a(kVar.a().a(), kVar.a().b(), kVar.a().c()).c(a(kVar.b().a(), kVar.b().b(), kVar.b().c())).a().d();
        p d3 = new p(-1.0f, 0.0f, 0.0f).a().d();
        b.c();
        b = b.a(d3, d2);
        return b.a();
    }

    public static Matrix4 e(a.k kVar) {
        p d2 = d(kVar.a().a(), kVar.a().b(), kVar.a().c()).c(d(kVar.b().a(), kVar.b().b(), kVar.b().c())).a().d();
        p d3 = new p(-1.0f, 0.0f, 0.0f).a().d();
        b.c();
        b = b.a(d3, d2);
        return b.a();
    }

    public static Matrix4 a(a.c cVar) {
        if (cVar == null) {
            return d.c();
        }
        cVar.d();
        float a2 = cVar.a().a();
        float b2 = cVar.a().b();
        float c2 = cVar.a().c();
        cVar.b().b();
        cVar.b().c();
        p a3 = a(a2, b2, c2);
        b.c();
        b.c((cVar.b().a() * 57.29578f) - 90.0f, 0.0f, 0.0f);
        c.c();
        c.e(a3.a, a3.b, a3.c);
        d.c();
        d.b(c);
        d.b(b);
        return d.a();
    }

    public static Matrix4 b(a.c cVar) {
        if (cVar == null) {
            return d.c();
        }
        cVar.d();
        p c2 = c(0.0f, 0.0f, cVar.a().c());
        c.c();
        c.e(c2.a, c2.b, c2.c);
        d.c();
        d.b(c);
        return d.a();
    }

    public static Matrix4 c(a.c cVar) {
        if (cVar == null) {
            return d.c();
        }
        p a2 = a(cVar.a().a(), cVar.a().b(), 0.0f);
        b.c();
        b.c((cVar.b().a() * 57.29578f) - 90.0f, 0.0f, 0.0f);
        c.c();
        c.e(a2.a, a2.b, a2.c);
        d.c();
        d.b(c);
        d.b(b);
        return d.a();
    }

    public static Matrix4 a(p pVar, float f) {
        c.c();
        c.e(pVar.a, pVar.b, pVar.c);
        b.c();
        b.c(f - 90.0f, 0.0f, 0.0f);
        d.c();
        d.b(c);
        d.b(b);
        return d.a();
    }

    public static Matrix4 a(TrainingSlotBean trainingSlotBean) {
        p d2 = d(trainingSlotBean);
        c.c();
        c.b(d2);
        b.c();
        b = c(trainingSlotBean);
        d.c();
        d.b(c);
        d.b(b);
        return d.a();
    }

    public static p b(TrainingSlotBean trainingSlotBean) {
        p pVar = new p(trainingSlotBean.b.x, trainingSlotBean.b.y, trainingSlotBean.b.z);
        p pVar2 = new p(trainingSlotBean.d.x, trainingSlotBean.d.y, trainingSlotBean.d.z);
        p pVar3 = new p();
        pVar3.a = pVar.a + ((pVar2.a - pVar.a) / 2.0f);
        pVar3.b = pVar2.b + ((pVar.b - pVar2.b) / 2.0f);
        pVar3.c = pVar2.c;
        return pVar3;
    }

    public static Matrix4 c(TrainingSlotBean trainingSlotBean) {
        p d2 = f(trainingSlotBean.getB().x, trainingSlotBean.getB().y, trainingSlotBean.getB().z).c(f(trainingSlotBean.getC().x, trainingSlotBean.getC().y, trainingSlotBean.getC().z)).a().d();
        p d3 = new p(-1.0f, 0.0f, 0.0f).a().d();
        b.c();
        b = b.a(d3, d2);
        return b.a();
    }

    public static p d(TrainingSlotBean trainingSlotBean) {
        p pVar = new p(trainingSlotBean.b.x, trainingSlotBean.b.y, trainingSlotBean.b.z);
        p pVar2 = new p(trainingSlotBean.d.x, trainingSlotBean.d.y, trainingSlotBean.d.z);
        p f = f(pVar.a, pVar.b, pVar.c);
        p f2 = f(pVar2.a, pVar2.b, pVar2.c);
        p pVar3 = new p();
        pVar3.a = f.a + ((f2.a - f.a) / 2.0f);
        pVar3.c = f2.c + ((f.c - f2.c) / 2.0f);
        pVar3.b = f2.b;
        return pVar3;
    }

    public static Matrix4 d(a.c cVar) {
        if (cVar == null) {
            return null;
        }
        p pVar = new p(cVar.a().a(), cVar.a().b(), cVar.a().c());
        p f = f(pVar.a, pVar.b, pVar.c);
        c.c();
        c.b(f);
        b.c();
        b.c(new p(0.0f, 1.0f, 0.0f), cVar.b().a() - 1.5707964f);
        d.c();
        d.b(c);
        d.b(b);
        return d.a();
    }

    public static Matrix4 a(a.c cVar, p pVar) {
        if (cVar == null) {
            return null;
        }
        c.c();
        c.b(pVar);
        b.c();
        b.c(new p(0.0f, 1.0f, 0.0f), cVar.b().a() - 1.5707964f);
        d.c();
        d.b(c);
        d.b(b);
        return d.a();
    }

    public static p f(float f, float f2, float f3) {
        p pVar = new p();
        pVar.a = f;
        pVar.b = f3;
        pVar.c = -f2;
        p a2 = pVar.a(uc.c);
        if (((i.ad) i.a(i.ad.class)).d().intValue() >= 0) {
            a2.b = 0.0f;
        }
        return a2;
    }

    public static Matrix4 a(TrainingSpdBumpBean trainingSpdBumpBean) {
        p f = f((float) trainingSpdBumpBean.x, (float) trainingSpdBumpBean.y, (float) trainingSpdBumpBean.z);
        c.c();
        c.b(f);
        b.c();
        b.c(((float) (trainingSpdBumpBean.theta * 57.29577951308232d)) - 90.0f, 0.0f, 0.0f);
        d.c();
        d.b(c);
        d.b(b);
        return d.a();
    }
}
