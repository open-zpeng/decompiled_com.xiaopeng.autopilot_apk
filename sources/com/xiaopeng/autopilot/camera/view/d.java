package com.xiaopeng.autopilot.camera.view;

import android.car.Car;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.xiaopeng.autopilot.base.utils.WheelUtil;
import com.xiaopeng.lib.utils.view.UIUtils;
/* compiled from: ParkPathGuideView.java */
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private static final float A;
    private static final float B;
    private static int g;
    private static final float z;
    private Rect C;
    private PorterDuffXfermode D;
    private Paint E;
    private Paint F;
    private Paint G;
    private Paint H;
    private Paint I;
    private Matrix J;
    private Camera K;
    private Path L;
    private Point M;
    private Point N;
    public float a;
    private int b;
    private int e;
    private int f;
    private int h;
    private Point i;
    private Point j;
    private Point k;
    private Point l;
    private Point m;
    private Point n;
    private Point o;
    private Point p;
    private Point q;
    private Point r;
    private Point s;
    private Point t;
    private float u;
    private float v;
    private float w;
    private float x;
    private static final int c = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), 600.0f);
    private static final int d = c * 3;
    private static float y = 18.0f;

    static {
        float f = y;
        z = f;
        A = 2.0f + f;
        B = f + 5.0f;
    }

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new Point();
        this.j = new Point();
        this.k = new Point();
        this.l = new Point();
        this.m = new Point();
        this.n = new Point();
        this.o = new Point();
        this.p = new Point();
        this.q = new Point();
        this.r = new Point();
        this.s = new Point();
        this.t = new Point();
        this.x = -0.07293903f;
        this.C = new Rect();
        this.M = new Point();
        this.N = new Point();
        b();
        boolean equalsIgnoreCase = Car.getXpCduType().equalsIgnoreCase("Q3A");
        int i = SystemProperties.getInt("persist.sys.xiaopeng.camera.module", 0);
        xx.b("ParkGuidePathView", "引导线初始化，摄像头module = " + i);
        if (equalsIgnoreCase) {
            this.b = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), -124.0f);
            this.a = 48.0f;
            this.h = (int) (c * 0.7f);
        } else if (i >= 2) {
            this.b = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), -100.0f);
            this.a = 45.0f;
            this.h = (int) (c * 1.5f);
        } else {
            this.b = UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), -160.0f);
            this.a = 43.0f;
            this.h = (int) (c * 0.7f);
        }
    }

    private void b() {
        this.L = new Path();
        this.E = new Paint();
        this.E.setAntiAlias(true);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth(y);
        this.E.setColor(-1);
        this.F = new Paint();
        this.F.setAntiAlias(true);
        this.F.setStyle(Paint.Style.STROKE);
        this.F.setStrokeWidth(y);
        this.F.setColor(0);
        this.G = new Paint();
        this.G.setAntiAlias(true);
        this.G.setStyle(Paint.Style.STROKE);
        this.G.setStrokeWidth(z);
        this.G.setColor(-16711936);
        this.H = new Paint();
        this.H.setAntiAlias(true);
        this.H.setStyle(Paint.Style.STROKE);
        this.H.setStrokeWidth(A);
        this.H.setColor(-256);
        this.I = new Paint();
        this.I.setAntiAlias(true);
        this.I.setStyle(Paint.Style.STROKE);
        this.I.setStrokeWidth(B);
        this.I.setColor(-65536);
        this.D = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.K = new Camera();
        this.J = new Matrix();
    }

    private void c() {
        d();
        setAngle(this.x);
        a();
        int abs = (int) (this.j.x + (Math.abs(this.b) * 5.0f));
        int i = this.j.y;
        this.C.set((int) (this.i.x - (Math.abs(this.b) * 5.0f)), (int) (this.k.y - (Math.abs(this.b) * 5.0f)), abs, i);
    }

    private void d() {
        this.e = this.b + 0;
        this.f = getBottom();
        g = getWidth() - (this.b * 2);
        Point point = this.i;
        int i = this.e;
        point.x = i;
        point.y = this.f;
        Point point2 = this.j;
        point2.x = i + g;
        point2.y = point.y;
        this.k.x = this.i.x;
        this.k.y = this.i.y - this.h;
        this.l.x = this.k.x + g;
        this.l.y = this.k.y;
        this.m.x = this.i.x;
        this.m.y = this.i.y - (c * 2);
        this.n.x = this.m.x + g;
        this.n.y = this.m.y;
        this.o.x = this.i.x;
        this.o.y = this.i.y - c;
        this.p.x = this.o.x + g;
        this.p.y = this.o.y;
        this.q.x = this.i.x + (g / 2);
        this.q.y = this.i.y;
        this.s.x = this.k.x + (g / 2);
        this.s.y = this.k.y;
    }

    public void setAngle(float f) {
        this.x = f;
        if (Math.abs(this.x) < 0.081f) {
            this.x = 0.081f;
        }
        a();
    }

    public void a() {
        xx.b("ParkGuidePathView", "angle : " + this.x);
        float a = ro.a();
        if (Math.abs(this.x) <= 0.0f || Math.abs(this.x) > a) {
            return;
        }
        this.w = (float) (d * WheelUtil.tan(90.0f - Math.abs(this.x)));
        float f = this.w;
        int i = g;
        this.u = (i / 2) + f;
        this.v = f - (i / 2);
        if (this.x < 0.0f) {
            this.t.x = (int) (this.q.x - this.w);
            this.t.y = this.j.y;
            this.M.x = this.i.x;
            this.M.y = (int) (this.i.y - this.v);
            this.N.x = this.j.x;
            this.N.y = (int) (this.j.y - this.u);
        } else {
            this.t.x = (int) (this.q.x + this.w);
            this.t.y = this.j.y;
            this.M.x = this.i.x;
            this.M.y = (int) (this.i.y - this.u);
            this.N.x = this.j.x;
            this.N.y = (int) (this.j.y - this.v);
        }
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.K.save();
        this.K.rotateX(this.a);
        this.K.getMatrix(this.J);
        this.K.restore();
        this.J.preTranslate(-this.q.x, -this.q.y);
        this.J.postTranslate(this.q.x, this.q.y);
        canvas.setMatrix(this.J);
        this.F.setStyle(Paint.Style.STROKE);
        canvas.drawRect(this.C, this.F);
        int saveLayer = canvas.saveLayer(this.C.left, this.C.top, this.C.right, this.C.bottom, this.E, 31);
        this.F.setStyle(Paint.Style.STROKE);
        canvas.drawRect(this.C, this.F);
        this.F.setXfermode(this.D);
        this.L.reset();
        this.L.moveTo(this.i.x, this.i.y);
        this.L.quadTo(this.M.x, this.M.y, this.t.x, this.M.y);
        canvas.drawPath(this.L, this.E);
        this.L.reset();
        this.L.moveTo(this.j.x, this.j.y);
        this.L.quadTo(this.N.x, this.N.y, this.t.x, this.N.y);
        canvas.drawPath(this.L, this.E);
        this.F.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.r.x = (int) motionEvent.getX();
            this.r.y = (int) motionEvent.getY();
            return true;
        } else if (action != 2) {
            return true;
        } else {
            this.r.x = (int) motionEvent.getX();
            this.r.y = (int) motionEvent.getY();
            return true;
        }
    }
}
