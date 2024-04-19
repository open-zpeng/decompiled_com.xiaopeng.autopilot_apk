package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.utils.view.UIUtils;
/* loaded from: classes.dex */
public class ParkingHotAreaInterceptView extends FrameLayout {
    private Rect a;
    private int b;

    public ParkingHotAreaInterceptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect(UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), 330.0f), 0, UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), 540.0f), UIUtils.dip2px(com.xiaopeng.autopilot.base.a.g(), 870.0f));
    }

    public boolean a(int i, int i2) {
        boolean z = !this.a.contains(i, i2);
        Log.d("ParkingHotAreaInterceptView", "touchUp.clickable:" + z);
        if (z) {
            Log.d("ParkingHotAreaInterceptView", "ParkingSurfaceView hot area clicked, tips:" + this.b);
            switch (this.b) {
                case 19:
                    SoundPlayer.getInstance().playHotAreaUnClickable(true, com.xiaopeng.autopilot.base.a.g().getString(e.i.hotarea_unclickable_tips_19));
                    break;
                case 20:
                    SoundPlayer.getInstance().playHotAreaUnClickable(true, com.xiaopeng.autopilot.base.a.g().getString(e.i.parking_click_after_stop));
                    break;
            }
        }
        return z;
    }

    public void a(boolean z, int i) {
        this.b = i;
        setVisibility(z ? 0 : 8);
    }
}
