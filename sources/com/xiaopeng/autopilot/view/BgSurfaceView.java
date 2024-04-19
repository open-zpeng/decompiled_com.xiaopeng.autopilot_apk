package com.xiaopeng.autopilot.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.xiaopeng.autopilot.R;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
/* loaded from: classes.dex */
public class BgSurfaceView extends SurfaceView implements ThemeWatcher.OnThemeSwitchListener {
    private static Drawable b;
    private static Drawable c;
    private static Drawable d;
    private Rect a;
    private PaintFlagsDrawFilter e;
    private Paint f;
    private final SurfaceHolder g;

    public BgSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BgSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Rect();
        this.g = getHolder();
        a();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
        b();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    private void a() {
        b = com.xiaopeng.autopilot.base.a.g().getResources().getDrawable(R.drawable.bg_light);
        c = com.xiaopeng.autopilot.base.a.g().getResources().getDrawable(R.drawable.bg_night);
        this.e = new PaintFlagsDrawFilter(0, 3);
        this.f = new Paint();
        this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.g.setFormat(2);
        this.g.addCallback(new SurfaceHolder.Callback() { // from class: com.xiaopeng.autopilot.view.BgSurfaceView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                BgSurfaceView.this.c();
            }
        });
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        b();
        c();
    }

    private void b() {
        if (!ThemeWatcher.getInstance().isNight()) {
            d = b;
        } else {
            d = c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Log.i("BgSurfaceView", "drawBg");
        Canvas lockCanvas = this.g.lockCanvas();
        if (lockCanvas != null) {
            b();
            lockCanvas.drawPaint(this.f);
            lockCanvas.setDrawFilter(this.e);
            this.a.set(0, 0, getWidth(), getHeight());
            d.setBounds(this.a);
            d.draw(lockCanvas);
            this.g.unlockCanvasAndPost(lockCanvas);
        }
    }
}
