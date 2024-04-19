package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.j;
import androidx.core.widget.NestedScrollView;
import defpackage.dt;
import org.xmlpull.v1.XmlPullParser;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TouchResponse.java */
/* renamed from: dw  reason: default package */
/* loaded from: classes.dex */
public class dw {
    private static final float[][] u = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] v = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private float r;
    private float s;
    private final dt t;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private float j = 0.5f;
    private float k = 0.5f;
    float a = 0.5f;
    float b = 0.5f;
    private int l = -1;
    boolean c = false;
    private float m = 0.0f;
    private float n = 1.0f;
    private boolean o = false;
    private float[] p = new float[2];
    private int[] q = new int[2];
    private float w = 4.0f;
    private float x = 1.2f;
    private boolean y = true;
    private float z = 1.0f;
    private int A = 0;
    private float B = 10.0f;
    private float C = 10.0f;
    private float D = 1.0f;
    private float E = Float.NaN;
    private float F = Float.NaN;
    private int G = 0;
    private int H = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(Context context, dt dtVar, XmlPullParser xmlPullParser) {
        this.t = dtVar;
        a(context, Xml.asAttributeSet(xmlPullParser));
    }

    public void a(boolean z) {
        if (z) {
            float[][] fArr = v;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = u;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = v;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = u;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = u;
        int i = this.d;
        this.k = fArr5[i][0];
        this.j = fArr5[i][1];
        int i2 = this.e;
        float[][] fArr6 = v;
        if (i2 >= fArr6.length) {
            return;
        }
        this.m = fArr6[i2][0];
        this.n = fArr6[i2][1];
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.OnSwipe);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void a(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == j.b.OnSwipe_touchAnchorId) {
                this.g = typedArray.getResourceId(index, this.g);
            } else if (index == j.b.OnSwipe_touchAnchorSide) {
                this.d = typedArray.getInt(index, this.d);
                float[][] fArr = u;
                int i2 = this.d;
                this.k = fArr[i2][0];
                this.j = fArr[i2][1];
            } else if (index == j.b.OnSwipe_dragDirection) {
                this.e = typedArray.getInt(index, this.e);
                int i3 = this.e;
                float[][] fArr2 = v;
                if (i3 < fArr2.length) {
                    this.m = fArr2[i3][0];
                    this.n = fArr2[i3][1];
                } else {
                    this.n = Float.NaN;
                    this.m = Float.NaN;
                    this.c = true;
                }
            } else if (index == j.b.OnSwipe_maxVelocity) {
                this.w = typedArray.getFloat(index, this.w);
            } else if (index == j.b.OnSwipe_maxAcceleration) {
                this.x = typedArray.getFloat(index, this.x);
            } else if (index == j.b.OnSwipe_moveWhenScrollAtTop) {
                this.y = typedArray.getBoolean(index, this.y);
            } else if (index == j.b.OnSwipe_dragScale) {
                this.z = typedArray.getFloat(index, this.z);
            } else if (index == j.b.OnSwipe_dragThreshold) {
                this.B = typedArray.getFloat(index, this.B);
            } else if (index == j.b.OnSwipe_touchRegionId) {
                this.h = typedArray.getResourceId(index, this.h);
            } else if (index == j.b.OnSwipe_onTouchUp) {
                this.f = typedArray.getInt(index, this.f);
            } else if (index == j.b.OnSwipe_nestedScrollFlags) {
                this.A = typedArray.getInteger(index, 0);
            } else if (index == j.b.OnSwipe_limitBoundsTo) {
                this.i = typedArray.getResourceId(index, 0);
            } else if (index == j.b.OnSwipe_rotationCenterId) {
                this.l = typedArray.getResourceId(index, this.l);
            } else if (index == j.b.OnSwipe_springDamping) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == j.b.OnSwipe_springMass) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == j.b.OnSwipe_springStiffness) {
                this.E = typedArray.getFloat(index, this.E);
            } else if (index == j.b.OnSwipe_springStopThreshold) {
                this.F = typedArray.getFloat(index, this.F);
            } else if (index == j.b.OnSwipe_springBoundary) {
                this.G = typedArray.getInt(index, this.G);
            } else if (index == j.b.OnSwipe_autoCompleteMode) {
                this.H = typedArray.getInt(index, this.H);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float f2) {
        this.r = f;
        this.s = f2;
        this.o = false;
    }

    void a(MotionEvent motionEvent, dt.d dVar, int i, dv dvVar) {
        float f;
        float rawY;
        float f2;
        float f3;
        float f4;
        float[] fArr;
        View findViewById;
        double atan2;
        float[] fArr2;
        dVar.a(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.r = motionEvent.getRawX();
                this.s = motionEvent.getRawY();
                this.o = false;
                return;
            case 1:
                this.o = false;
                dVar.a(16);
                float b = dVar.b();
                float c = dVar.c();
                float progress = this.t.getProgress();
                float width = this.t.getWidth() / 2.0f;
                float height = this.t.getHeight() / 2.0f;
                int i2 = this.l;
                if (i2 != -1) {
                    View findViewById2 = this.t.findViewById(i2);
                    this.t.getLocationOnScreen(this.q);
                    f = this.q[0] + ((findViewById2.getLeft() + findViewById2.getRight()) / 2.0f);
                    height = this.q[1] + ((findViewById2.getTop() + findViewById2.getBottom()) / 2.0f);
                } else {
                    int i3 = this.g;
                    if (i3 != -1) {
                        View findViewById3 = this.t.findViewById(this.t.a(i3).c());
                        this.t.getLocationOnScreen(this.q);
                        f = this.q[0] + ((findViewById3.getLeft() + findViewById3.getRight()) / 2.0f);
                        height = this.q[1] + ((findViewById3.getTop() + findViewById3.getBottom()) / 2.0f);
                    } else {
                        f = width;
                    }
                }
                float rawX = motionEvent.getRawX() - f;
                double degrees = Math.toDegrees(Math.atan2(motionEvent.getRawY() - height, rawX));
                int i4 = this.g;
                if (i4 != -1) {
                    this.t.a(i4, progress, this.k, this.j, this.p);
                    this.p[1] = (float) Math.toDegrees(fArr[1]);
                } else {
                    this.p[1] = 360.0f;
                }
                float degrees2 = ((float) (Math.toDegrees(Math.atan2(c + rawY, b + rawX)) - degrees)) * 62.5f;
                if (Float.isNaN(degrees2)) {
                    f2 = progress;
                    f3 = 0.0f;
                } else {
                    f2 = (((degrees2 * 3.0f) * this.z) / this.p[1]) + progress;
                    f3 = 0.0f;
                }
                if (f2 == f3 || f2 == 1.0f || this.f == 3) {
                    if (0.0f >= f2 || 1.0f <= f2) {
                        this.t.setState(dt.h.FINISHED);
                        return;
                    }
                    return;
                }
                float f5 = (degrees2 * this.z) / this.p[1];
                float f6 = ((double) f2) < 0.5d ? 0.0f : 1.0f;
                if (this.f == 6) {
                    if (progress + f5 < 0.0f) {
                        f5 = Math.abs(f5);
                    }
                    f4 = 1.0f;
                } else {
                    f4 = f6;
                }
                if (this.f == 7) {
                    if (progress + f5 > 1.0f) {
                        f5 = -Math.abs(f5);
                    }
                    f4 = 0.0f;
                }
                this.t.a(this.f, f4, f5 * 3.0f);
                if (0.0f >= progress || 1.0f <= progress) {
                    this.t.setState(dt.h.FINISHED);
                    return;
                }
                return;
            case 2:
                motionEvent.getRawY();
                float f7 = this.s;
                motionEvent.getRawX();
                float f8 = this.r;
                float width2 = this.t.getWidth() / 2.0f;
                float height2 = this.t.getHeight() / 2.0f;
                int i5 = this.l;
                if (i5 != -1) {
                    View findViewById4 = this.t.findViewById(i5);
                    this.t.getLocationOnScreen(this.q);
                    height2 = ((findViewById4.getTop() + findViewById4.getBottom()) / 2.0f) + this.q[1];
                    width2 = this.q[0] + ((findViewById4.getLeft() + findViewById4.getRight()) / 2.0f);
                } else {
                    int i6 = this.g;
                    if (i6 != -1) {
                        if (this.t.findViewById(this.t.a(i6).c()) == null) {
                            Log.e("TouchResponse", "could not find view to animate to");
                        } else {
                            this.t.getLocationOnScreen(this.q);
                            width2 = this.q[0] + ((findViewById.getLeft() + findViewById.getRight()) / 2.0f);
                            height2 = this.q[1] + ((findViewById.getTop() + findViewById.getBottom()) / 2.0f);
                        }
                    }
                }
                float rawX2 = motionEvent.getRawX() - width2;
                float rawY2 = motionEvent.getRawY() - height2;
                float atan22 = (float) (((Math.atan2(motionEvent.getRawY() - height2, motionEvent.getRawX() - width2) - Math.atan2(this.s - height2, this.r - width2)) * 180.0d) / 3.141592653589793d);
                if (atan22 > 330.0f) {
                    atan22 -= 360.0f;
                } else if (atan22 < -330.0f) {
                    atan22 += 360.0f;
                }
                if (Math.abs(atan22) > 0.01d || this.o) {
                    float progress2 = this.t.getProgress();
                    if (!this.o) {
                        this.o = true;
                        this.t.setProgress(progress2);
                    }
                    int i7 = this.g;
                    if (i7 != -1) {
                        this.t.a(i7, progress2, this.k, this.j, this.p);
                        this.p[1] = (float) Math.toDegrees(fArr2[1]);
                    } else {
                        this.p[1] = 360.0f;
                    }
                    float max = Math.max(Math.min(progress2 + ((atan22 * this.z) / this.p[1]), 1.0f), 0.0f);
                    float progress3 = this.t.getProgress();
                    if (max != progress3) {
                        int i8 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                        if (i8 == 0 || progress3 == 1.0f) {
                            this.t.a(i8 == 0);
                        }
                        this.t.setProgress(max);
                        dVar.a(1000);
                        float b2 = dVar.b();
                        double c2 = dVar.c();
                        double d = b2;
                        this.t.e = (float) Math.toDegrees((float) ((Math.hypot(c2, d) * Math.sin(Math.atan2(c2, d) - atan2)) / Math.hypot(rawX2, rawY2)));
                    } else {
                        this.t.e = 0.0f;
                    }
                    this.r = motionEvent.getRawX();
                    this.s = motionEvent.getRawY();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(MotionEvent motionEvent, dt.d dVar, int i, dv dvVar) {
        float f;
        float f2;
        if (this.c) {
            a(motionEvent, dVar, i, dvVar);
            return;
        }
        dVar.a(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.r = motionEvent.getRawX();
                this.s = motionEvent.getRawY();
                this.o = false;
                return;
            case 1:
                this.o = false;
                dVar.a(1000);
                float b = dVar.b();
                float c = dVar.c();
                float progress = this.t.getProgress();
                int i2 = this.g;
                if (i2 != -1) {
                    this.t.a(i2, progress, this.k, this.j, this.p);
                } else {
                    float min = Math.min(this.t.getWidth(), this.t.getHeight());
                    float[] fArr = this.p;
                    fArr[1] = this.n * min;
                    fArr[0] = min * this.m;
                }
                float f3 = this.m;
                float[] fArr2 = this.p;
                float f4 = fArr2[0];
                float f5 = this.n;
                float f6 = fArr2[1];
                if (f3 != 0.0f) {
                    f = b / fArr2[0];
                } else {
                    f = c / fArr2[1];
                }
                float f7 = !Float.isNaN(f) ? (f / 3.0f) + progress : progress;
                if (f7 == 0.0f || f7 == 1.0f || this.f == 3) {
                    if (0.0f >= f7 || 1.0f <= f7) {
                        this.t.setState(dt.h.FINISHED);
                        return;
                    }
                    return;
                }
                float f8 = ((double) f7) < 0.5d ? 0.0f : 1.0f;
                if (this.f == 6) {
                    if (progress + f < 0.0f) {
                        f = Math.abs(f);
                    }
                    f8 = 1.0f;
                }
                if (this.f == 7) {
                    if (progress + f > 1.0f) {
                        f = -Math.abs(f);
                    }
                    f8 = 0.0f;
                }
                this.t.a(this.f, f8, f);
                if (0.0f >= progress || 1.0f <= progress) {
                    this.t.setState(dt.h.FINISHED);
                    return;
                }
                return;
            case 2:
                float rawY = motionEvent.getRawY() - this.s;
                float rawX = motionEvent.getRawX() - this.r;
                if (Math.abs((this.m * rawX) + (this.n * rawY)) > this.B || this.o) {
                    float progress2 = this.t.getProgress();
                    if (!this.o) {
                        this.o = true;
                        this.t.setProgress(progress2);
                    }
                    int i3 = this.g;
                    if (i3 != -1) {
                        this.t.a(i3, progress2, this.k, this.j, this.p);
                    } else {
                        float min2 = Math.min(this.t.getWidth(), this.t.getHeight());
                        float[] fArr3 = this.p;
                        fArr3[1] = this.n * min2;
                        fArr3[0] = min2 * this.m;
                    }
                    float f9 = this.m;
                    float[] fArr4 = this.p;
                    if (Math.abs(((f9 * fArr4[0]) + (this.n * fArr4[1])) * this.z) < 0.01d) {
                        float[] fArr5 = this.p;
                        fArr5[0] = 0.01f;
                        fArr5[1] = 0.01f;
                    }
                    if (this.m != 0.0f) {
                        f2 = rawX / this.p[0];
                    } else {
                        f2 = rawY / this.p[1];
                    }
                    float max = Math.max(Math.min(progress2 + f2, 1.0f), 0.0f);
                    if (this.f == 6) {
                        max = Math.max(max, 0.01f);
                    }
                    if (this.f == 7) {
                        max = Math.min(max, 0.99f);
                    }
                    float progress3 = this.t.getProgress();
                    if (max != progress3) {
                        int i4 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                        if (i4 == 0 || progress3 == 1.0f) {
                            this.t.a(i4 == 0);
                        }
                        this.t.setProgress(max);
                        dVar.a(1000);
                        this.t.e = this.m != 0.0f ? dVar.b() / this.p[0] : dVar.c() / this.p[1];
                    } else {
                        this.t.e = 0.0f;
                    }
                    this.r = motionEvent.getRawX();
                    this.s = motionEvent.getRawY();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f, float f2) {
        this.r = f;
        this.s = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c(float f, float f2) {
        this.t.a(this.g, this.t.getProgress(), this.k, this.j, this.p);
        if (this.m != 0.0f) {
            float[] fArr = this.p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f * this.m) / this.p[0];
        }
        float[] fArr2 = this.p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f2 * this.n) / this.p[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f, float f2) {
        float f3;
        this.o = false;
        float progress = this.t.getProgress();
        this.t.a(this.g, progress, this.k, this.j, this.p);
        float f4 = this.m;
        float[] fArr = this.p;
        float f5 = fArr[0];
        float f6 = this.n;
        float f7 = fArr[1];
        if (f4 != 0.0f) {
            f3 = (f * f4) / fArr[0];
        } else {
            f3 = (f2 * f6) / fArr[1];
        }
        if (!Float.isNaN(f3)) {
            progress += f3 / 3.0f;
        }
        if (progress != 0.0f) {
            if ((this.f != 3) && (progress != 1.0f)) {
                this.t.a(this.f, ((double) progress) < 0.5d ? 0.0f : 1.0f, f3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f, float f2) {
        float f3;
        float f4 = this.m;
        float f5 = this.n;
        float progress = this.t.getProgress();
        if (!this.o) {
            this.o = true;
            this.t.setProgress(progress);
        }
        this.t.a(this.g, progress, this.k, this.j, this.p);
        float f6 = this.m;
        float[] fArr = this.p;
        if (Math.abs((f6 * fArr[0]) + (this.n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f7 = this.m;
        if (f7 != 0.0f) {
            f3 = (f * f7) / this.p[0];
        } else {
            f3 = (f2 * this.n) / this.p[1];
        }
        float max = Math.max(Math.min(progress + f3, 1.0f), 0.0f);
        if (max != this.t.getProgress()) {
            this.t.setProgress(max);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view;
        int i = this.g;
        if (i != -1) {
            view = this.t.findViewById(i);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + dd.a(this.t.getContext(), this.g));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: dw.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b() { // from class: dw.2
                @Override // androidx.core.widget.NestedScrollView.b
                public void a(NestedScrollView nestedScrollView2, int i2, int i3, int i4, int i5) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.x;
    }

    public float c() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.y;
    }

    public int e() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.h;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF b(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.i;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f(float f, float f2) {
        return (f * this.m) + (f2 * this.n);
    }

    public String toString() {
        if (Float.isNaN(this.m)) {
            return "rotation";
        }
        return this.m + " , " + this.n;
    }

    public int g() {
        return this.A;
    }

    public float h() {
        return this.E;
    }

    public float i() {
        return this.D;
    }

    public float j() {
        return this.C;
    }

    public float k() {
        return this.F;
    }

    public int l() {
        return this.G;
    }
}
