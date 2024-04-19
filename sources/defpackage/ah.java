package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import defpackage.an;
/* compiled from: CardViewApi17Impl.java */
/* renamed from: ah  reason: default package */
/* loaded from: classes.dex */
class ah extends aj {
    @Override // defpackage.aj, defpackage.al
    public void a() {
        an.a = new an.a() { // from class: ah.1
            @Override // defpackage.an.a
            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }
}
