package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XProgressBar;
import com.xiaopeng.xui.widget.XTextView;
import java.util.HashMap;
/* loaded from: classes.dex */
public class NavStartPointGuideWidget extends ConstraintLayout {
    private XImageView a;
    private XTextView b;
    private XProgressBar c;
    private String[] d;
    private String e;
    private XTextView f;
    private HashMap<Integer, Integer> g;

    private boolean a(int i) {
        if (i == 2 || i == 4) {
            return true;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    public NavStartPointGuideWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new HashMap<Integer, Integer>() { // from class: com.xiaopeng.autopilot.parking.view.NavStartPointGuideWidget.1
            {
                put(1, Integer.valueOf(h.d.nav_start_straight));
                put(3, Integer.valueOf(h.d.nav_start_left));
                put(2, Integer.valueOf(h.d.nav_start_left));
                put(5, Integer.valueOf(h.d.nav_start_right));
                put(4, Integer.valueOf(h.d.nav_start_right));
                put(8, Integer.valueOf(h.d.nav_start_ramp));
                put(6, Integer.valueOf(h.d.nav_start_ramp));
                put(7, Integer.valueOf(h.d.nav_start_ramp));
                put(15, Integer.valueOf(h.d.nav_start_right_s_turn));
                put(16, Integer.valueOf(h.d.nav_start_left_u_turn));
                put(17, Integer.valueOf(h.d.nav_start_right_u_turn));
                put(14, Integer.valueOf(h.d.nav_start_left_s_turn));
                put(18, Integer.valueOf(h.d.nav_start_left_s_turn));
                put(19, Integer.valueOf(h.d.nav_start_right_s_turn));
                put(20, Integer.valueOf(h.d.nav_start_left_u_turn));
                put(21, Integer.valueOf(h.d.nav_start_right_u_turn));
                put(9, Integer.valueOf(h.d.nav_finish));
            }
        };
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(h.f.widget_nav_startpoint_guide, (ViewGroup) this, true);
        this.a = (XImageView) findViewById(h.e.guide_type);
        this.b = (XTextView) findViewById(h.e.guide_instruction_center);
        this.c = (XProgressBar) findViewById(h.e.guide_progress);
        this.d = getResources().getStringArray(h.a.array_nav_tips);
        this.e = getResources().getString(h.i.nav_guide_instruction_spliter);
        this.f = (XTextView) findViewById(h.e.sub_title_guide);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (getAlpha() < 1.0f) {
            return;
        }
        String format = String.format(this.d[i], Integer.valueOf(i2));
        if (format.indexOf(this.e) > -1) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(45, true);
            SpannableString spannableString = new SpannableString(format);
            int length = format.startsWith(getResources().getString(h.i.nav_guide_instruction_spliter_prefix)) ? getResources().getString(h.i.nav_guide_instruction_spliter_prefix).length() : 0;
            spannableString.setSpan(absoluteSizeSpan, length, format.indexOf(this.e), 33);
            spannableString.setSpan(new StyleSpan(1), length, format.indexOf(this.e), 33);
            this.b.setText(spannableString);
        } else {
            this.b.setText(format);
        }
        if (this.g.containsKey(Integer.valueOf(i))) {
            this.a.setImageResource(this.g.get(Integer.valueOf(i)).intValue());
        } else {
            this.a.setImageDrawable(null);
        }
        if (a(i)) {
            this.c.setAlpha(1.0f);
            this.c.setProgress(i4, false);
        } else {
            this.c.setAlpha(0.0f);
        }
        this.f.setVisibility(0);
    }
}
