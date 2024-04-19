package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import defpackage.an;
/* compiled from: CardViewBaseImpl.java */
/* renamed from: aj  reason: default package */
/* loaded from: classes.dex */
class aj implements al {
    final RectF a = new RectF();

    @Override // defpackage.al
    public void g(ak akVar) {
    }

    @Override // defpackage.al
    public void a() {
        an.a = new an.a() { // from class: aj.1
            @Override // defpackage.an.a
            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    float f4 = -f3;
                    aj.this.a.set(f4, f4, f3, f3);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(aj.this.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(aj.this.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(aj.this.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(aj.this.a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, (rectF.right - f3) + 1.0f, rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, (rectF.right - f3) + 1.0f, rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
            }
        };
    }

    @Override // defpackage.al
    public void a(ak akVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        an a = a(context, colorStateList, f, f2, f3);
        a.a(akVar.b());
        akVar.a(a);
        f(akVar);
    }

    private an a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new an(context.getResources(), colorStateList, f, f2, f3);
    }

    @Override // defpackage.al
    public void f(ak akVar) {
        Rect rect = new Rect();
        j(akVar).a(rect);
        akVar.a((int) Math.ceil(b(akVar)), (int) Math.ceil(c(akVar)));
        akVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // defpackage.al
    public void h(ak akVar) {
        j(akVar).a(akVar.b());
        f(akVar);
    }

    @Override // defpackage.al
    public void a(ak akVar, ColorStateList colorStateList) {
        j(akVar).a(colorStateList);
    }

    @Override // defpackage.al
    public ColorStateList i(ak akVar) {
        return j(akVar).f();
    }

    @Override // defpackage.al
    public void a(ak akVar, float f) {
        j(akVar).a(f);
        f(akVar);
    }

    @Override // defpackage.al
    public float d(ak akVar) {
        return j(akVar).a();
    }

    @Override // defpackage.al
    public void c(ak akVar, float f) {
        j(akVar).b(f);
    }

    @Override // defpackage.al
    public float e(ak akVar) {
        return j(akVar).b();
    }

    @Override // defpackage.al
    public void b(ak akVar, float f) {
        j(akVar).c(f);
        f(akVar);
    }

    @Override // defpackage.al
    public float a(ak akVar) {
        return j(akVar).c();
    }

    @Override // defpackage.al
    public float b(ak akVar) {
        return j(akVar).d();
    }

    @Override // defpackage.al
    public float c(ak akVar) {
        return j(akVar).e();
    }

    private an j(ak akVar) {
        return (an) akVar.c();
    }
}
