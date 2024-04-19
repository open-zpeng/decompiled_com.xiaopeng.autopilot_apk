package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
/* compiled from: DrawerArrowDrawable.java */
/* renamed from: n  reason: default package */
/* loaded from: classes.dex */
public class n extends Drawable {
    private static final float b = (float) Math.toRadians(45.0d);
    private final Paint a;
    private float c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private final Path h;
    private final int i;
    private boolean j;
    private float k;
    private float l;
    private int m;

    private static float a(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        Rect bounds = getBounds();
        int i = this.m;
        boolean z = false;
        if (i == 3) {
            if (a.g(this) == 0) {
                z = true;
            }
        } else {
            switch (i) {
                case 0:
                    break;
                case 1:
                    z = true;
                    break;
                default:
                    if (a.g(this) == 1) {
                        z = true;
                        break;
                    }
                    break;
            }
        }
        float f2 = this.c;
        float a = a(this.d, (float) Math.sqrt(f2 * f2 * 2.0f), this.k);
        float a2 = a(this.d, this.e, this.k);
        float round = Math.round(a(0.0f, this.l, this.k));
        float a3 = a(0.0f, b, this.k);
        float a4 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.k);
        double d = a;
        double d2 = a3;
        float round2 = (float) Math.round(Math.cos(d2) * d);
        float round3 = (float) Math.round(d * Math.sin(d2));
        this.h.rewind();
        float a5 = a(this.f + this.a.getStrokeWidth(), -this.l, this.k);
        float f3 = (-a2) / 2.0f;
        this.h.moveTo(f3 + round, 0.0f);
        this.h.rLineTo(a2 - (round * 2.0f), 0.0f);
        this.h.moveTo(f3, a5);
        this.h.rLineTo(round2, round3);
        this.h.moveTo(f3, -a5);
        this.h.rLineTo(round2, -round3);
        this.h.close();
        canvas.save();
        float strokeWidth = this.a.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * f))) / 4) * 2) + (strokeWidth * 1.5f) + this.f);
        if (this.g) {
            canvas.rotate(a4 * (this.j ^ z ? -1 : 1));
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.h, this.a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.a.getAlpha()) {
            this.a.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.i;
    }

    public void a(float f) {
        if (this.k != f) {
            this.k = f;
            invalidateSelf();
        }
    }
}
