package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XCircularProgressBar;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class APAInfoBoardView extends FrameLayout {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private View f;
    private XButton g;
    private ImageView h;
    private XCircularProgressBar i;
    private ParkingHotAreaInterceptView j;
    private ParkingViewPro k;
    private AbsoluteSizeSpan l;

    public APAInfoBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public APAInfoBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new AbsoluteSizeSpan(UIUtils.sp2px(getContext(), getResources().getDimensionPixelSize(e.c.speed_size_span_original)));
        b();
    }

    public void setParkingView(ParkingViewPro parkingViewPro) {
        this.k = parkingViewPro;
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_parking_pro_apa_view, (ViewGroup) this, true);
        this.a = (TextView) findViewById(e.C0055e.apa_tv_speed);
        this.b = (TextView) findViewById(e.C0055e.apa_tv_parking_tip);
        this.c = (TextView) findViewById(e.C0055e.apa_parking_distance);
        this.d = (TextView) findViewById(e.C0055e.apa_distance_unit);
        this.e = (TextView) findViewById(e.C0055e.apa_parking_left_distance);
        this.f = findViewById(e.C0055e.apa_parking_distance_container);
        this.h = (ImageView) findViewById(e.C0055e.apa_iv_gear);
        this.i = (XCircularProgressBar) findViewById(e.C0055e.apa_parking_b_progress);
        this.j = (ParkingHotAreaInterceptView) findViewById(e.C0055e.apa_parking_intercept_view);
        this.g = (XButton) findViewById(e.C0055e.pro_view_btn_parking_control);
    }

    public void a(int i, int i2, String str, int i3) {
        if (i3 != -1) {
            if (i == 24 || i == 36) {
                if (ThemeWatcher.getInstance().isNight()) {
                    this.b.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_cancel_tv_color_night));
                } else {
                    this.b.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.ap_cancel_tv_color));
                }
            } else {
                this.b.setTextColor(i3);
            }
        } else if (!ThemeWatcher.getInstance().isNight()) {
            this.b.setTextColor(getResources().getColor(e.b.tv_parking_tips_day));
        } else {
            this.b.setTextColor(getResources().getColor(e.b.tv_parking_tips_night));
        }
        this.b.setText(str);
        if ((i <= 1 || i >= 15) && (i < 34 || i >= 64)) {
            if (i == 18 || (i == 21 && i2 == 8)) {
                d(32);
            } else if (i == 33) {
                d(29);
            } else {
                d(38);
            }
        } else if (i == 6 || i == 5 || i == 35 || i == 2 || i == 11 || i == 12) {
            d(38);
        } else {
            d(29);
        }
    }

    private void d(int i) {
        if (i == 38) {
            if (this.b.getText().length() > 14) {
                this.b.setTextSize(36.0f);
                return;
            } else {
                this.b.setTextSize(i);
                return;
            }
        }
        this.b.setTextSize(i);
    }

    public void a(int i) {
        this.a.setVisibility(i);
    }

    public void b(int i) {
        this.h.setVisibility(i);
        this.i.setVisibility(i);
    }

    public void a() {
        if (!ThemeWatcher.getInstance().isNight()) {
            this.b.setTextColor(getResources().getColor(e.b.tv_parking_tips_day));
            a(0, ThemeWatcher.getInstance().isNight());
            this.c.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance));
            this.d.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance));
            this.e.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance));
            return;
        }
        this.b.setTextColor(getResources().getColor(e.b.tv_parking_tips_night));
        a(0, ThemeWatcher.getInstance().isNight());
        this.c.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance_night));
        this.d.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance_night));
        this.e.setTextColor(getResources().getColor(e.b.tv_progress_bar_distance_night));
    }

    public void a(int i, boolean z) {
        if (z) {
            if (i >= 25) {
                this.a.setTextColor(getResources().getColor(e.b.speed_over_color));
            } else {
                this.a.setTextColor(getResources().getColor(e.b.speed_color_night));
            }
        } else if (i >= 25) {
            this.a.setTextColor(getResources().getColor(e.b.speed_over_color));
        } else {
            this.a.setTextColor(getResources().getColor(e.b.speed_color));
        }
    }

    public void c(int i) {
        if (!ThemeWatcher.getInstance().isNight()) {
            switch (i) {
                case 1:
                    this.h.setImageResource(e.g.im_gear_d_light);
                    return;
                case 2:
                    this.h.setImageResource(e.g.im_gear_n_light);
                    return;
                case 3:
                    this.h.setImageResource(e.g.im_gear_r_light);
                    return;
                case 4:
                    this.h.setImageResource(e.g.im_gear_p_light);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 1:
                this.h.setImageResource(e.g.im_gear_d_dark);
                return;
            case 2:
                this.h.setImageResource(e.g.im_gear_n_dark);
                return;
            case 3:
                this.h.setImageResource(e.g.im_gear_r_dark);
                return;
            case 4:
                this.h.setImageResource(e.g.im_gear_p_dark);
                return;
            default:
                return;
        }
    }

    public void a(float f) {
        int b = b(f);
        a(b, ThemeWatcher.getInstance().isNight());
        String valueOf = String.valueOf(b);
        int length = valueOf.length();
        SpannableString spannableString = new SpannableString(valueOf + " km/h");
        spannableString.setSpan(this.l, 0, length, 18);
        this.a.setText(spannableString);
    }

    private int b(float f) {
        return (int) Math.abs(Math.ceil(f * 1.05f));
    }

    public void a(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        if (i2 == 0) {
            layoutParams.topMargin = UIUtils.dip2px(getContext(), 140.0f);
            d(29);
        } else if ((i <= 1 || i >= 15) && (i < 34 || i >= 64 || i == 36)) {
            if (i == 33) {
                layoutParams.topMargin = UIUtils.dip2px(getContext(), 140.0f);
            } else {
                layoutParams.topMargin = UIUtils.dip2px(getContext(), 70.0f);
            }
        } else if (i == 6 || i == 5 || i == 35 || i == 2 || i == 11 || i == 12) {
            layoutParams.topMargin = UIUtils.dip2px(getContext(), 70.0f);
        } else {
            layoutParams.topMargin = UIUtils.dip2px(getContext(), 140.0f);
        }
        this.b.setLayoutParams(layoutParams);
    }

    public void a(boolean z, int i) {
        this.j.a(z, i);
    }

    public void a(int i, float f, float f2) {
        if (a(f, f2)) {
            return;
        }
        if (i != 3 && i != 8 && i != 34) {
            if (com.xiaopeng.autopilot.base.d.c()) {
                Log.i("APAInfoBroadView", "setProgress not work");
                return;
            }
            return;
        }
        a(i, f);
        this.i.setProgress((int) f2);
    }

    private boolean a(float f, float f2) {
        View view = this.f;
        if (view != null && f < 0.0f) {
            view.setVisibility(8);
        }
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (!(i == 0 && f2 == 100.0f) && (i != 0 || f2 > 0.0f)) {
            return f < 0.0f;
        }
        this.f.setVisibility(8);
        return true;
    }

    private void a(int i, float f) {
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        this.f.setVisibility(0);
        String format = decimalFormat.format(f);
        if (i == 34) {
            this.e.setText(e.i.distance_pre_b0);
        } else {
            this.e.setText(e.i.distance_pre);
        }
        this.c.setText(format);
        this.d.setText(" m");
    }

    public void b(int i, int i2) {
        this.j.a(i, i2);
    }

    public void a(ParkingViewPro parkingViewPro, boolean z) {
        int i = parkingViewPro.b;
        if (z) {
            if (i < 0 || i >= 7) {
                this.b.setText(e.i.parking_tips_22_select);
                return;
            }
            if (this.b.getText().equals(getResources().getString(e.i.parking_tips_22_drag))) {
                this.b.setText(e.i.parking_tips_22_ready);
            }
        } else if (parkingViewPro.a.e() == 22 || parkingViewPro.a.e() == 1) {
            if (i < 0 || i >= 7) {
                this.b.setText(e.i.parking_tips_22_select);
            } else {
                this.b.setText(e.i.parking_tips_22_ready);
            }
        }
    }

    public void a(boolean z, int i, int i2, String str, View.OnClickListener onClickListener) {
        this.g.setText(str);
        this.g.setVisibility(i2);
        this.g.setOnClickListener(onClickListener);
        if (!z) {
            a(true);
        } else {
            a(false);
        }
        a(i, i2);
    }

    public void a(boolean z) {
        if (z) {
            int parkLotChoseIndex = this.k.getParkLotChoseIndex();
            if (com.xiaopeng.autopilot.base.d.c()) {
                Log.i("APAInfoBroadView", "btnAutoParkEnable.slotIndex = " + parkLotChoseIndex);
            }
            if (parkLotChoseIndex < 0 || parkLotChoseIndex >= 7) {
                this.g.setEnabled(false);
                if (!ThemeWatcher.getInstance().isNight()) {
                    this.g.setTextColor(-7103831);
                    return;
                } else {
                    this.g.setTextColor(-9603694);
                    return;
                }
            }
            this.g.setEnabled(true);
            if (!ThemeWatcher.getInstance().isNight()) {
                this.g.setTextColor(getResources().getColor(e.b.parking_button_text_selector));
                return;
            } else {
                this.g.setTextColor(getResources().getColor(e.b.parking_button_text_selector_night));
                return;
            }
        }
        if (com.xiaopeng.autopilot.base.d.c()) {
            Log.i("APAInfoBroadView", "btnAutoParkEnable.false");
        }
        this.g.setEnabled(false);
        if (!ThemeWatcher.getInstance().isNight()) {
            this.g.setTextColor(-7103831);
        } else {
            this.g.setTextColor(-9603694);
        }
    }

    public void setDistanceLayoutVisible(int i) {
        Log.i("APAInfoBroadView", "setDistanceLayoutVisible.visible = " + i);
        this.f.setVisibility(i);
    }
}
