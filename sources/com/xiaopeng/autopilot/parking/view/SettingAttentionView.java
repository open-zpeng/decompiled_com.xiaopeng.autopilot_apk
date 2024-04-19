package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.l;
import com.xiaopeng.xui.widget.XImageButton;
/* loaded from: classes.dex */
public class SettingAttentionView extends RelativeLayout implements com.xiaopeng.autopilot.parking.b {
    private XImageButton a;
    private XImageButton b;
    private l c;
    private m d;
    private boolean e;

    public void c() {
    }

    public SettingAttentionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
        g();
    }

    private void g() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_setting_attention, (ViewGroup) this, true);
        this.a = (XImageButton) findViewById(e.C0055e.pro_view_parking_attention);
        this.b = (XImageButton) findViewById(e.C0055e.pro_view_parking_settings);
        this.b.setVisibility(0);
        this.d = new m(getContext());
    }

    public void b() {
        m mVar = this.d;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void a(final tw twVar) {
        if (com.xiaopeng.autopilot.base.d.h() || com.xiaopeng.autopilot.base.d.g()) {
            this.a.setVisibility(0);
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.SettingAttentionView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if ((twVar.c() && twVar.e() >= 0 && twVar.e() != 13 && twVar.e() != 14) || twVar.e() == 24 || twVar.e() == 36 || twVar.e() > 64) {
                        SoundPlayer.getInstance().playUnOperated();
                    } else {
                        SettingAttentionView.this.d();
                    }
                }
            });
        } else {
            this.a.setVisibility(8);
        }
        this.b.setVisibility(0);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.SettingAttentionView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("SettingAttentionView", "mParkingSetting");
                if ((twVar.c() && twVar.e() >= 0 && twVar.e() != 13 && twVar.e() != 14) || twVar.e() == 24 || twVar.e() == 36 || twVar.e() > 64) {
                    SoundPlayer.getInstance().playUnOperated();
                    return;
                }
                Log.i("SettingAttentionView", "mParkingSetting.mSettingDialog = " + SettingAttentionView.this.d);
                SettingAttentionView.this.d.b();
            }
        });
    }

    public void d() {
        a(0);
    }

    public void a(int i) {
        if (this.c != null) {
            e();
        }
        this.c = new l(com.xiaopeng.autopilot.base.a.g().getApplicationContext());
        this.c.setAttentionListener(this);
        this.c.a(i);
        this.c.setOnOkListener(new l.a() { // from class: com.xiaopeng.autopilot.parking.view.SettingAttentionView.3
            @Override // com.xiaopeng.autopilot.parking.view.l.a
            public void a() {
                SettingAttentionView.this.e();
            }
        });
        ((ViewGroup) getRootView()).addView(this.c, -1, -1);
        com.xiaopeng.autopilot.base.c.a().i().statisEnterHelp();
        this.e = false;
    }

    public void e() {
        if (this.c != null) {
            ((ViewGroup) getRootView()).removeView(this.c);
            this.c = null;
        }
        m mVar = this.d;
        if (mVar != null) {
            mVar.c();
        }
        this.e = true;
    }

    public void b(int i) {
        m mVar = this.d;
        if (mVar != null) {
            mVar.a(i);
        }
    }

    public void a(boolean z) {
        if (com.xiaopeng.autopilot.base.d.h() || com.xiaopeng.autopilot.base.d.g()) {
            if (!z) {
                this.a.setVisibility(0);
                this.b.setVisibility(0);
                return;
            }
            e();
            this.a.setVisibility(0);
            this.b.setVisibility(0);
        }
    }

    public boolean f() {
        return this.e;
    }

    @Override // com.xiaopeng.autopilot.parking.b
    public void a() {
        e();
    }
}
