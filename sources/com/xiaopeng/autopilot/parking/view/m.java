package com.xiaopeng.autopilot.parking.view;

import android.car.Car;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.xiaopeng.autopilot.base.bean.eventbus.ShortcutEvent;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XSwitch;
import com.xiaopeng.xui.widget.XTabLayout;
/* compiled from: SettingsDialog.java */
/* loaded from: classes.dex */
public class m {
    private XDialog a;
    private View b;
    private XImageButton c;
    private XTabLayout d;
    private XSwitch e;
    private XImageButton f;
    private XSwitch g;
    private RelativeLayout h;
    private Runnable i = new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.m.1
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.g != null) {
                int m = com.xiaopeng.autopilot.base.d.m();
                Log.i("SettingsDialog", "mFSDEnableRunnable.fsdSwitch = " + m);
                m.this.a(m);
            }
        }
    };

    public m(final Context context) {
        if (this.a == null) {
            this.a = new XDialog(context, e.j.XDialogView_Large_Custom);
            this.a.getDialog().getWindow().setType(2047);
            this.a.setTitleVisibility(false);
        }
        this.b = LayoutInflater.from(context).inflate(e.f.layout_setting_dialog, this.a.getContentView(), false);
        if (Car.getXpCduType().equalsIgnoreCase("Q3A")) {
            ((XImageView) this.b.findViewById(e.C0055e.id_setting_dialog_bg)).setImageResource(e.d.ic_setting_dialog_bg_d55a);
        }
        this.a.setCustomView(this.b, false);
        this.c = (XImageButton) this.b.findViewById(e.C0055e.ic_setting_close);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.a != null) {
                    m.this.a.dismiss();
                }
            }
        });
        this.a.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.autopilot.parking.view.m.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                rh.a().e(m.this.i);
            }
        });
        this.d = (XTabLayout) this.b.findViewById(e.C0055e.tab_x_pilot_tab);
        this.d.addTab(context.getString(e.i.parking_settings_tts), 0);
        this.d.addTab(context.getString(e.i.parking_settings_sound), 1);
        this.d.setOnTabChangeListener(new XTabLayout.OnTabChangeListenerAdapter() { // from class: com.xiaopeng.autopilot.parking.view.m.4
            @Override // com.xiaopeng.xui.widget.XTabLayout.OnTabChangeListener
            public void onTabChangeEnd(XTabLayout xTabLayout, int i, boolean z, boolean z2) {
                com.xiaopeng.autopilot.base.d.a(i == 0);
                StringBuilder sb = new StringBuilder();
                sb.append("mSoundTab.onTabChangeEnd Constant.switchSoundToSpeechTTS = ");
                sb.append(i == 0);
                Log.i("SettingsDialog", sb.toString());
            }
        });
        this.e = (XSwitch) this.b.findViewById(e.C0055e.tab_reversing_hold);
        this.e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.autopilot.parking.view.m.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.xiaopeng.autopilot.base.d.b(z);
                Log.i("SettingsDialog", "mReversingTab.onCheckedChanged Constant.switchReversingHold = " + z);
                if (z) {
                    return;
                }
                i.u uVar = (i.u) com.xiaopeng.autopilot.base.i.a(i.u.class);
                if (((i.af) com.xiaopeng.autopilot.base.i.a(i.af.class)).d().booleanValue()) {
                    if (uVar.d().intValue() == 1 || uVar.d().intValue() == 2) {
                        com.xiaopeng.autopilot.base.i.a(i.af.class, false);
                        IntentUtil.startAutopilotService(context, "com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK");
                        LogUtils.i("SettingsDialog", "D/N挡，打开设置，关掉影像保持，退出倒车界面");
                    }
                }
            }
        });
        this.f = (XImageButton) this.b.findViewById(e.C0055e.setting_content_reversing_hold_h5);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.c();
                org.greenrobot.eventbus.c.a().d(ShortcutEvent.OPEN_REVERING_HOLD_H5_EVENT);
            }
        });
        if (com.xiaopeng.autopilot.base.d.f()) {
            this.b.findViewById(e.C0055e.rl_sound).setVisibility(8);
        }
        this.g = (XSwitch) this.b.findViewById(e.C0055e.tab_fsd);
        this.h = (RelativeLayout) this.b.findViewById(e.C0055e.rl_fsd);
        com.xiaopeng.autopilot.base.d.h();
        this.h.setVisibility(8);
    }

    public void a() {
        Log.i("SettingsDialog", "updateTab.ttsSwitch Constant.isSwitchSoundToSpeechTTS() = " + com.xiaopeng.autopilot.base.d.a());
        if (com.xiaopeng.autopilot.base.d.a()) {
            this.d.selectTab(0);
        } else {
            this.d.selectTab(1);
        }
        Log.i("SettingsDialog", "updateTab.reversingHold Constant.isSwitchReversingHold() = " + com.xiaopeng.autopilot.base.d.b());
        this.e.setChecked(com.xiaopeng.autopilot.base.d.b());
    }

    public void a(int i) {
        Log.i("SettingsDialog", "updateFSDSwitch.fsdSwitch = " + i + "," + this.g.isChecked());
        this.g.setEnabled(true);
        this.g.setChecked(i == 1);
        rh.a().e(this.i);
    }

    public void b() {
        this.a.show();
        int m = com.xiaopeng.autopilot.base.d.m();
        Log.i("SettingsDialog", "updateFSD.fsdSwitch = " + m);
        a(m);
    }

    public void c() {
        this.a.dismiss();
    }
}
