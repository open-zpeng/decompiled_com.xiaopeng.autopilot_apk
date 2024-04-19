package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
/* compiled from: CardViewApi21Impl.java */
/* renamed from: ai  reason: default package */
/* loaded from: classes.dex */
class ai implements al {
    @Override // defpackage.al
    public void a() {
    }

    @Override // defpackage.al
    public void a(ak akVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        akVar.a(new am(colorStateList, f));
        View d = akVar.d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        b(akVar, f3);
    }

    @Override // defpackage.al
    public void a(ak akVar, float f) {
        j(akVar).a(f);
    }

    @Override // defpackage.al
    public void b(ak akVar, float f) {
        j(akVar).a(f, akVar.a(), akVar.b());
        f(akVar);
    }

    @Override // defpackage.al
    public float a(ak akVar) {
        return j(akVar).a();
    }

    @Override // defpackage.al
    public float b(ak akVar) {
        return d(akVar) * 2.0f;
    }

    @Override // defpackage.al
    public float c(ak akVar) {
        return d(akVar) * 2.0f;
    }

    @Override // defpackage.al
    public float d(ak akVar) {
        return j(akVar).b();
    }

    @Override // defpackage.al
    public void c(ak akVar, float f) {
        akVar.d().setElevation(f);
    }

    @Override // defpackage.al
    public float e(ak akVar) {
        return akVar.d().getElevation();
    }

    @Override // defpackage.al
    public void f(ak akVar) {
        if (!akVar.a()) {
            akVar.a(0, 0, 0, 0);
            return;
        }
        float a = a(akVar);
        float d = d(akVar);
        int ceil = (int) Math.ceil(an.b(a, d, akVar.b()));
        int ceil2 = (int) Math.ceil(an.a(a, d, akVar.b()));
        akVar.a(ceil, ceil2, ceil, ceil2);
    }

    @Override // defpackage.al
    public void g(ak akVar) {
        b(akVar, a(akVar));
    }

    @Override // defpackage.al
    public void h(ak akVar) {
        b(akVar, a(akVar));
    }

    @Override // defpackage.al
    public void a(ak akVar, ColorStateList colorStateList) {
        j(akVar).a(colorStateList);
    }

    @Override // defpackage.al
    public ColorStateList i(ak akVar) {
        return j(akVar).c();
    }

    private am j(ak akVar) {
        return (am) akVar.c();
    }
}
