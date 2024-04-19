package com.xiaopeng.autopilot.view;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.xiaopeng.autopilot.base.BgActivity;
import com.xiaopeng.autopilot.base.bean.eventbus.FinishBgActivityEvent;
import org.greenrobot.eventbus.c;
/* compiled from: ParkingWindow.java */
/* loaded from: classes.dex */
public class b implements ri {
    private Context a;
    private rj b;
    private int c;
    private int d;

    public b(Context context) {
        this.a = context;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        this.c = displayMetrics.widthPixels;
        this.d = displayMetrics.heightPixels;
    }

    @Override // defpackage.ri
    public void a(rj rjVar) {
        this.b = rjVar;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2042;
        layoutParams.flags = 150996264;
        layoutParams.systemUiVisibility |= 1538;
        layoutParams.format = 1;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = this.c;
        layoutParams.height = this.d;
        this.b.setWidgetAlpha(1.0f);
        ((WindowManager) this.a.getSystemService("window")).addView((View) this.b, layoutParams);
        this.b.d();
        this.b.a();
        rh.a().a(new Runnable() { // from class: com.xiaopeng.autopilot.view.b.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent(com.xiaopeng.autopilot.base.a.g().getBaseContext(), BgActivity.class);
                intent.addFlags(335544320);
                com.xiaopeng.autopilot.base.a.g().startActivity(intent);
            }
        });
    }

    @Override // defpackage.ri
    public void a() {
        this.b.setWidgetAlpha(0.0f);
        this.b.b();
        this.b.c();
        ((WindowManager) this.a.getSystemService("window")).removeView((View) this.b);
        rh.a().a(new Runnable() { // from class: com.xiaopeng.autopilot.view.b.2
            @Override // java.lang.Runnable
            public void run() {
                c.a().d(new FinishBgActivityEvent());
            }
        });
    }
}
