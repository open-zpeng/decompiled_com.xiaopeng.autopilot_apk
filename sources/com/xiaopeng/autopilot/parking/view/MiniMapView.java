package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.parking.model.MiniMapModel;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import java.util.List;
/* loaded from: classes.dex */
public class MiniMapView extends SurfaceView implements d, ThemeWatcher.OnThemeSwitchListener {
    private static String o = "MINI_MAP_2D_VIEW";
    private static int p = 19;
    public int a;
    public int b;
    Path c;
    Path d;
    Bitmap e;
    Bitmap f;
    Bitmap g;
    a h;
    Context i;
    tm j;
    Matrix k;
    Matrix l;
    Matrix m;
    com.badlogic.gdx.math.p n;
    private Paint q;
    private boolean r;
    private float[] s;
    private int t;
    private float[] u;
    private com.badlogic.gdx.math.p v;
    private com.badlogic.gdx.math.p w;
    private boolean x;
    private Matrix y;
    private float z;

    public Path getmPathAll() {
        if (this.c == null) {
            this.c = new Path();
        }
        return this.c;
    }

    public Path getmPathFinished() {
        if (this.d == null) {
            this.d = new Path();
        }
        return this.d;
    }

    public void a(tm tmVar) {
        this.j = tmVar;
    }

    public a getmDrawThread() {
        if (this.h == null) {
            this.h = new a(this);
        }
        return this.h;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8 || i == 4) {
            this.r = false;
        } else {
            this.r = true;
        }
        String str = o;
        PerformanceTestUnit.log(str, "MINI_MAP setVisibility:\t" + i, true);
    }

    private void d() {
        Log.i(o, "NIMI_MAP init");
        try {
            ThemeWatcher.getInstance().removeThemeListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        this.q = new Paint();
        this.q.setStyle(Paint.Style.STROKE);
        this.q.setStrokeWidth(5.0f);
        getmDrawThread().start();
        this.r = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public MiniMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 200;
        this.b = 200;
        this.k = new Matrix();
        this.l = new Matrix();
        this.m = new Matrix();
        this.n = new com.badlogic.gdx.math.p();
        this.r = true;
        this.s = new float[9];
        this.t = -1;
        this.u = new float[9];
        this.v = new com.badlogic.gdx.math.p();
        this.w = new com.badlogic.gdx.math.p();
        this.x = false;
        this.y = new Matrix();
        this.z = 1.0f;
        this.i = context;
        d();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        PerformanceTestUnit.logStart(o);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.draw(canvas);
        if (this.r || this.j.a().ismInitFinished()) {
            if (this.x) {
                b(canvas);
                a(canvas, this.q);
            } else {
                b(canvas);
                c(canvas);
                a(canvas);
                a(canvas, this.q);
            }
            PerformanceTestUnit.logEnd(o, "mp_performance_mini_map_draw");
        }
    }

    private void a(Canvas canvas) {
        this.q.setAntiAlias(true);
        this.q.setFilterBitmap(true);
        if (this.j.a().ismInitFinished()) {
            Matrix matrix = this.y;
            this.l.reset();
            this.l.postTranslate(this.n.a - (p / 2), this.n.b - (p / 2));
            Matrix matrix2 = this.l;
            float f = this.z;
            matrix2.postScale(f, f, this.n.a, this.n.b);
            this.l.postConcat(matrix);
            Bitmap bitmap = this.g;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(this.g, this.l, this.q);
        }
    }

    private void a(Canvas canvas, Paint paint) {
        this.q.setAntiAlias(false);
        com.badlogic.gdx.math.p pVar = this.v;
        com.badlogic.gdx.math.p pVar2 = this.w;
        if (pVar == null || pVar2 == null) {
            return;
        }
        Matrix matrix = this.y;
        this.s[0] = pVar.a;
        this.s[1] = pVar.b;
        matrix.mapPoints(this.s);
        float[] fArr = this.s;
        float f = fArr[0];
        float f2 = fArr[1];
        this.k.reset();
        this.k.postScale(0.7f, 0.7f);
        this.k.postTranslate(f - 13.0f, f2 - 13.0f);
        Bitmap bitmap = this.e;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.e, this.k, paint);
        }
        this.s[0] = pVar2.a;
        this.s[1] = pVar2.b;
        matrix.mapPoints(this.s);
        float[] fArr2 = this.s;
        float f3 = fArr2[0];
        float f4 = fArr2[1];
        this.k.reset();
        this.k.postScale(0.7f, 0.7f);
        this.k.postTranslate(f3 - 13.0f, f4 - 13.0f);
        Bitmap bitmap2 = this.f;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f, this.k, paint);
    }

    private void b(Canvas canvas) {
        int i;
        int i2;
        int i3;
        this.q.setAntiAlias(true);
        if (ThemeWatcher.getInstance().isNight()) {
            i = 20;
            i2 = 116;
            i3 = 220;
        } else {
            i = 28;
            i2 = 134;
            i3 = 249;
        }
        this.q.setColor(Color.rgb(i, i2, i3));
        this.q.setStrokeWidth(4.0f);
        canvas.drawPath(getmPathAll(), this.q);
    }

    private void c(Canvas canvas) {
        int i;
        int i2;
        int i3;
        this.q.setAntiAlias(true);
        List<com.badlogic.gdx.math.p> fillFinishedRoadList = this.j.a().fillFinishedRoadList(this.j.a().getmCurrentFloorNum(), this.t);
        Matrix matrix = this.y;
        if (matrix == null || fillFinishedRoadList == null || fillFinishedRoadList.size() == 0) {
            return;
        }
        com.badlogic.gdx.math.p pVar = fillFinishedRoadList.get(fillFinishedRoadList.size() - 1);
        this.n.a = pVar.a;
        this.n.b = pVar.b;
        getmPathFinished().reset();
        getmPathFinished().moveTo(fillFinishedRoadList.get(0).a, fillFinishedRoadList.get(0).b);
        for (com.badlogic.gdx.math.p pVar2 : fillFinishedRoadList) {
            getmPathFinished().lineTo(pVar2.a, pVar2.b);
        }
        getmPathFinished().transform(matrix);
        if (ThemeWatcher.getInstance().isNight()) {
            i = 41;
            i2 = 44;
            i3 = 48;
        } else {
            i = 197;
            i2 = 206;
            i3 = 217;
        }
        this.q.setColor(Color.rgb(i, i2, i3));
        this.q.setStrokeWidth(5.0f);
        canvas.drawPath(getmPathFinished(), this.q);
    }

    public void a(boolean z) {
        PerformanceTestUnit.log(o, "NIMI_MAP oncreate!", true);
        this.x = z;
        if (z) {
            this.a = 210;
            this.b = 210;
        }
        getmDrawThread();
        e();
        if (this.j.a().ismInitFinished()) {
            f();
        }
    }

    private void e() {
        PerformanceTestUnit.log(o, "MINI_MAP initStartEndPic", true);
        final int i = ThemeWatcher.getInstance().isNight() ? h.g.mini_map_start_night : h.g.mini_map_start;
        final int i2 = ThemeWatcher.getInstance().isNight() ? h.g.mini_map_end_night : h.g.mini_map_end;
        final int i3 = ThemeWatcher.getInstance().isNight() ? h.g.mini_map_moving_point_night : h.g.mini_map_moving_point;
        rh.a().f(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.MiniMapView.1
            @Override // java.lang.Runnable
            public void run() {
                MiniMapView miniMapView = MiniMapView.this;
                miniMapView.e = BitmapFactory.decodeResource(miniMapView.i.getResources(), i);
                MiniMapView miniMapView2 = MiniMapView.this;
                miniMapView2.f = BitmapFactory.decodeResource(miniMapView2.i.getResources(), i2);
                MiniMapView miniMapView3 = MiniMapView.this;
                miniMapView3.g = BitmapFactory.decodeResource(miniMapView3.i.getResources(), i3);
                int unused = MiniMapView.p = MiniMapView.this.g.getWidth();
            }
        });
    }

    private void f() {
        PerformanceTestUnit.log(o, "MINI_MAP initAllPath start ", true);
        MiniMapModel.FloorInfo floorInfo = this.j.a().getmMultiFloorInfo().get(-999);
        if (floorInfo == null) {
            String str = o;
            PerformanceTestUnit.log(str, "MINI_MAP currentFloor  is null floorNum:-999", true);
            return;
        }
        String str2 = o;
        PerformanceTestUnit.log(str2, "MINI_MAP currentFloorInfo " + floorInfo.toString(), true);
        List<com.badlogic.gdx.math.p> list = this.j.a().getmAllLineCduScreenPointList();
        if (list == null || list.size() == 0) {
            String str3 = o;
            PerformanceTestUnit.log(str3, "MINI_MAP currentFloor data is null floorNum:-999", true);
            return;
        }
        try {
            com.badlogic.gdx.math.p pVar = list.get(0);
            this.v = pVar.a();
            this.w = list.get(list.size() - 1).a();
            this.t = this.j.a().getmAllLineCduScreenPointList().indexOf(pVar);
        } catch (Exception e) {
            e.printStackTrace();
            PerformanceTestUnit.log(o, "MINI_MAP mCurrentFloorStartIndex  is error:", true);
        }
        getmPathAll().reset();
        getmPathAll().moveTo(list.get(0).a, list.get(0).b);
        for (com.badlogic.gdx.math.p pVar2 : list) {
            getmPathAll().lineTo(pVar2.a, pVar2.b);
        }
        this.y = this.j.a(this.a, this.b, floorInfo);
        g();
        getmPathAll().transform(this.y);
        String str4 = o;
        PerformanceTestUnit.log(str4, "MINI_MAP initAllPath finish index： " + this.t, true);
    }

    private void g() {
        float[] fArr = new float[9];
        this.y.getValues(fArr);
        float f = fArr[0];
        float f2 = fArr[3];
        this.z = 1.0f / ((float) Math.sqrt((f * f) + (f2 * f2)));
    }

    @Override // com.xiaopeng.autopilot.parking.view.d
    public void a() {
        PerformanceTestUnit.log(o, "MINI_MAP dispose", true);
        getmPathAll().reset();
        getmPathFinished().reset();
        this.m.reset();
    }

    @Override // com.xiaopeng.autopilot.parking.view.d
    public void b() {
        Log.d(o, "onMapReady");
        f();
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        c();
    }

    public void c() {
        String str = o;
        PerformanceTestUnit.log(str, "MINI_MAP updateMaterial isNight?" + ThemeWatcher.getInstance().isNight(), true);
        final int i = ThemeWatcher.getInstance().isNight() ? h.g.mini_map_start_night : h.g.mini_map_start;
        final int i2 = ThemeWatcher.getInstance().isNight() ? h.g.mini_map_end_night : h.g.mini_map_end;
        final int i3 = ThemeWatcher.getInstance().isNight() ? h.g.mini_map_moving_point_night : h.g.mini_map_moving_point;
        Bitmap bitmap = this.e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.e.recycle();
        }
        Bitmap bitmap2 = this.f;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f.recycle();
        }
        Bitmap bitmap3 = this.g;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.g.recycle();
        }
        rh.a().f(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.MiniMapView.2
            @Override // java.lang.Runnable
            public void run() {
                MiniMapView miniMapView = MiniMapView.this;
                miniMapView.e = BitmapFactory.decodeResource(miniMapView.i.getResources(), i);
                MiniMapView miniMapView2 = MiniMapView.this;
                miniMapView2.f = BitmapFactory.decodeResource(miniMapView2.i.getResources(), i2);
                MiniMapView miniMapView3 = MiniMapView.this;
                miniMapView3.g = BitmapFactory.decodeResource(miniMapView3.i.getResources(), i3);
                int unused = MiniMapView.p = MiniMapView.this.g.getWidth();
            }
        });
    }

    /* loaded from: classes.dex */
    public class a extends Thread {
        boolean a = true;
        int b = 0;
        long c = System.currentTimeMillis();
        int d = 0;
        private SurfaceView f;
        private SurfaceHolder g;
        private Handler h;

        public a(SurfaceView surfaceView) {
            this.f = surfaceView;
            this.g = surfaceView.getHolder();
            surfaceView.setZOrderOnTop(true);
            this.g.setFormat(-2);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.h = new Handler() { // from class: com.xiaopeng.autopilot.parking.view.MiniMapView.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (a.this.a) {
                        if (message.what == 998) {
                            a.this.b();
                        }
                        a.this.a();
                    }
                }
            };
            a();
            Looper.loop();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.g.getSurface().isValid()) {
                Canvas canvas = null;
                try {
                    try {
                        canvas = this.g.lockCanvas();
                        if (canvas != null) {
                            a(canvas);
                            this.f.draw(canvas);
                        }
                        if (canvas == null) {
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (canvas == null) {
                            return;
                        }
                    }
                    this.g.unlockCanvasAndPost(canvas);
                } catch (Throwable th) {
                    if (canvas != null) {
                        this.g.unlockCanvasAndPost(canvas);
                    }
                    throw th;
                }
            }
        }

        public boolean a() {
            this.a = true;
            new Message().what = 998;
            this.h.sendEmptyMessageDelayed(998, 333L);
            return true;
        }

        private void a(Canvas canvas) {
            this.d++;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.c > 1000) {
                this.b = this.d;
                this.d = 0;
                this.c = currentTimeMillis;
            }
        }
    }
}
