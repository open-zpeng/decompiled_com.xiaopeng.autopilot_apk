package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.x.protocol.apirouter.RouteSr2HiddenCamClient;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XCheckBox;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XNumberPicker;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.dialogview.XDialogViewInterface;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ShareMapView.java */
/* loaded from: classes.dex */
public class n extends FrameLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ThemeWatcher.OnThemeSwitchListener {
    private XTextView A;
    private XButton B;
    private XButton C;
    private XButton D;
    private XButton E;
    private XButton F;
    private XNumberPicker G;
    private XImageView H;
    private XTextView I;
    private XTextView J;
    private XButton K;
    private XTextView L;
    private XTextView M;
    private XTextView N;
    private XButton O;
    private XButton P;
    private boolean Q;
    private boolean R;
    private StringBuilder S;
    private List<Integer> T;
    private int U;
    private a V;
    private boolean W;
    private String[] a;
    private boolean aa;
    private XNumberPicker.OnValueChangeListener ab;
    private XDialogViewInterface.OnCloseListener ac;
    private View b;
    private XTextView c;
    private XImageButton d;
    private XImageButton e;
    private XCheckBox f;
    private XTextView g;
    private XTextView h;
    private XButton i;
    private XButton j;
    private XButton k;
    private XButton l;
    private XTextView m;
    private XTextView n;
    private XTextView o;
    private XImageView p;
    private XImageView q;
    private LinearLayout r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private XCheckBox w;
    private XCheckBox x;
    private XCheckBox y;
    private XCheckBox z;

    /* compiled from: ShareMapView.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public n(Context context, boolean z, a aVar) {
        super(context);
        this.a = new String[]{"负一层", "负二层", "负三层", "负四层", "其他"};
        this.S = new StringBuilder();
        this.T = new ArrayList();
        this.U = 1;
        this.W = false;
        this.aa = false;
        this.ab = new XNumberPicker.OnValueChangeListener() { // from class: com.xiaopeng.autopilot.parking.view.n.1
            @Override // com.xiaopeng.xui.widget.XNumberPicker.OnValueChangeListener
            public void onValueChange(XNumberPicker xNumberPicker, int i, int i2) {
                Log.d("ShareMapView", "onValueChange i = " + i + " ; i1 = " + i2);
            }
        };
        this.V = aVar;
        a(z);
    }

    private void a(boolean z) {
        this.W = z;
        if (z) {
            b();
        } else {
            a();
        }
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().removeThemeListener(this);
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.f.layout_share_map_dialog_view, (ViewGroup) this, true);
        this.b = inflate.findViewById(e.C0055e.dialog_share_map_layout);
        this.c = (XTextView) inflate.findViewById(e.C0055e.dialog_share_title_tv);
        this.d = (XImageButton) inflate.findViewById(e.C0055e.dialog_share_title_bt_close);
        this.e = (XImageButton) inflate.findViewById(e.C0055e.dialog_share_title_bt_back);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.r = (LinearLayout) inflate.findViewById(e.C0055e.dialog_share_user_agreement_layout);
        this.f = (XCheckBox) inflate.findViewById(e.C0055e.dialog_user_agreement_cb);
        this.g = (XTextView) inflate.findViewById(e.C0055e.dialog_user_agreement_tv);
        this.h = (XTextView) inflate.findViewById(e.C0055e.dialog_user_agreement_cb_tv);
        this.g.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.f.setOnCheckedChangeListener(this);
        this.i = (XButton) inflate.findViewById(e.C0055e.dialog_user_agreement_negative_btn);
        this.j = (XButton) inflate.findViewById(e.C0055e.dialog_user_agreement_positive_btn);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.j.setEnabled(false);
        this.s = (LinearLayout) inflate.findViewById(e.C0055e.dialog_share_layout);
        this.t = (LinearLayout) inflate.findViewById(e.C0055e.dialog_share_pos_select_layout);
        this.k = (XButton) inflate.findViewById(e.C0055e.dialog_share_map_bt_floor);
        this.l = (XButton) inflate.findViewById(e.C0055e.dialog_share_map_bt_pos);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m = (XTextView) inflate.findViewById(e.C0055e.dialog_share_map_tv);
        this.n = (XTextView) inflate.findViewById(e.C0055e.dialog_share_map_tv_floor);
        this.o = (XTextView) inflate.findViewById(e.C0055e.dialog_share_map_tv_pos);
        this.p = (XImageView) inflate.findViewById(e.C0055e.dialog_share_map_iv_floor);
        this.q = (XImageView) inflate.findViewById(e.C0055e.dialog_share_map_iv_pos);
        this.B = (XButton) inflate.findViewById(e.C0055e.dialog_share_map_commit_btn);
        this.B.setOnClickListener(this);
        this.B.setEnabled(false);
        this.w = (XCheckBox) inflate.findViewById(e.C0055e.dialog_select_pos_charging_pie_ct);
        this.x = (XCheckBox) inflate.findViewById(e.C0055e.dialog_select_pos_elevator_ct);
        this.y = (XCheckBox) inflate.findViewById(e.C0055e.dialog_select_pos_stair_ct);
        this.z = (XCheckBox) inflate.findViewById(e.C0055e.dialog_select_pos_other_ct);
        this.A = (XTextView) inflate.findViewById(e.C0055e.dialog_select_pos_other_tv);
        this.D = (XButton) inflate.findViewById(e.C0055e.dialog_select_pos_positive_btn);
        this.C = (XButton) inflate.findViewById(e.C0055e.dialog_select_pos_negative_btn);
        this.D.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.w.setOnCheckedChangeListener(this);
        this.x.setOnCheckedChangeListener(this);
        this.y.setOnCheckedChangeListener(this);
        this.z.setOnCheckedChangeListener(this);
        this.u = (LinearLayout) inflate.findViewById(e.C0055e.dialog_share_floor_select_layout);
        this.G = (XNumberPicker) inflate.findViewById(e.C0055e.dialog_select_floor_picker);
        this.G.setOnValueChangedListener(this.ab);
        this.G.setMinValue(0);
        this.G.setMaxValue(4);
        this.G.setDisplayedValues(this.a);
        this.E = (XButton) inflate.findViewById(e.C0055e.dialog_select_floor_negative_btn);
        this.F = (XButton) inflate.findViewById(e.C0055e.dialog_select_floor_positive_btn);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.v = (LinearLayout) inflate.findViewById(e.C0055e.dialog_end_layout);
        this.H = (XImageView) inflate.findViewById(e.C0055e.dialog_commit_end_iv);
        this.I = (XTextView) inflate.findViewById(e.C0055e.dialog_end_tv);
        this.J = (XTextView) inflate.findViewById(e.C0055e.dialog_end_tv1);
        this.K = (XButton) inflate.findViewById(e.C0055e.dialog_end_btn);
        this.K.setOnClickListener(this);
        if (rf.a(com.xiaopeng.autopilot.base.a.g().getApplicationContext()).e()) {
            d();
        } else {
            c();
        }
    }

    private void setTitle(int i) {
        this.c.setText(i);
    }

    private void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.f.layout_share_map_comment_dialog_view, (ViewGroup) this, true);
        this.c = (XTextView) inflate.findViewById(e.C0055e.dialog_share_title_tv);
        this.d = (XImageButton) inflate.findViewById(e.C0055e.dialog_share_title_bt_close);
        this.d.setOnClickListener(this);
        this.O = (XButton) inflate.findViewById(e.C0055e.dialog_comment_positive_btn);
        this.P = (XButton) inflate.findViewById(e.C0055e.dialog_comment_negative_btn);
        this.O.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.L = (XTextView) inflate.findViewById(e.C0055e.dialog_comment_tv1);
        this.M = (XTextView) inflate.findViewById(e.C0055e.dialog_comment_tv2);
        this.N = (XTextView) inflate.findViewById(e.C0055e.dialog_comment_tv3);
        setTitle(e.i.dialog_comment_title);
        setCloseVisibility(true);
    }

    private void setCloseVisibility(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }

    private void setBackVisibility(boolean z) {
        this.e.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.C0055e.dialog_share_title_bt_close) {
            XDialogViewInterface.OnCloseListener onCloseListener = this.ac;
            if (onCloseListener != null) {
                onCloseListener.onClose(null);
            }
        } else if (id == e.C0055e.dialog_share_title_bt_back) {
            d();
        } else if (id == e.C0055e.dialog_user_agreement_positive_btn) {
            rf.a(com.xiaopeng.autopilot.base.a.g().getApplicationContext()).d(true);
            d();
        } else if (id == e.C0055e.dialog_user_agreement_negative_btn) {
            XDialogViewInterface.OnCloseListener onCloseListener2 = this.ac;
            if (onCloseListener2 != null) {
                onCloseListener2.onClose(null);
            }
        } else if (id == e.C0055e.dialog_share_map_bt_floor) {
            e();
        } else if (id == e.C0055e.dialog_share_map_bt_pos) {
            f();
        } else if (id == e.C0055e.dialog_select_pos_positive_btn) {
            h();
            d();
        } else if (id == e.C0055e.dialog_select_pos_negative_btn) {
            d();
        } else if (id == e.C0055e.dialog_select_floor_positive_btn) {
            d();
            this.R = true;
            j();
        } else if (id == e.C0055e.dialog_select_floor_negative_btn) {
            d();
        } else if (id == e.C0055e.dialog_share_map_commit_btn) {
            RouteSr2HiddenCamClient.routeSr2HdPkmapShareInfo(-this.U, this.T, com.xiaopeng.autopilot.parking.c.s().getMapTime());
            rf.a(com.xiaopeng.autopilot.base.a.g()).a(com.xiaopeng.autopilot.parking.c.s().getMapId(), true);
            g();
            a aVar = this.V;
            if (aVar != null) {
                aVar.a();
            }
        } else if (id == e.C0055e.dialog_end_btn) {
            XDialogViewInterface.OnCloseListener onCloseListener3 = this.ac;
            if (onCloseListener3 != null) {
                onCloseListener3.onClose(null);
            }
        } else if (id == e.C0055e.dialog_comment_positive_btn) {
            a aVar2 = this.V;
            if (aVar2 != null) {
                aVar2.a();
            }
            RouteSr2HiddenCamClient.routeSr2HdPkmapEvaluation(String.valueOf(com.xiaopeng.autopilot.parking.c.s().getMapId()), 1, com.xiaopeng.autopilot.parking.c.s().getMapType(), com.xiaopeng.autopilot.parking.c.s().getMapTime());
            XDialogViewInterface.OnCloseListener onCloseListener4 = this.ac;
            if (onCloseListener4 != null) {
                onCloseListener4.onClose(null);
            }
            XToast.show(e.i.dialog_comment_positive_toast_text);
        } else if (id == e.C0055e.dialog_comment_negative_btn) {
            a aVar3 = this.V;
            if (aVar3 != null) {
                aVar3.a();
            }
            RouteSr2HiddenCamClient.routeSr2HdPkmapEvaluation(String.valueOf(com.xiaopeng.autopilot.parking.c.s().getMapId()), 3, com.xiaopeng.autopilot.parking.c.s().getMapType(), com.xiaopeng.autopilot.parking.c.s().getMapTime());
            XDialogViewInterface.OnCloseListener onCloseListener5 = this.ac;
            if (onCloseListener5 != null) {
                onCloseListener5.onClose(null);
            }
            XToast.show(e.i.dialog_comment_negative_toast_text);
        }
    }

    private void c() {
        setTitle(e.i.dialog_user_agreement_dialog_title);
        setCloseVisibility(false);
        setBackVisibility(false);
        this.b.setBackground(null);
        this.r.setVisibility(0);
        this.s.setVisibility(8);
        this.u.setVisibility(8);
        this.t.setVisibility(8);
        this.v.setVisibility(8);
    }

    private void d() {
        setTitle(e.i.memory_parking_share_dialog_title);
        setCloseVisibility(true);
        setBackVisibility(false);
        i();
        this.b.setBackground(null);
        this.r.setVisibility(8);
        this.s.setVisibility(0);
        this.u.setVisibility(8);
        this.t.setVisibility(8);
        this.v.setVisibility(8);
    }

    private void e() {
        this.R = true;
        setTitle(e.i.dialog_share_map_tv_floor_text);
        setCloseVisibility(false);
        setBackVisibility(true);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.u.setVisibility(0);
        this.t.setVisibility(8);
        this.v.setVisibility(8);
        this.G.setValue(this.U - 1);
    }

    private void f() {
        setTitle(e.i.dialog_share_map_tv_pos_text);
        setCloseVisibility(false);
        setBackVisibility(true);
        k();
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.u.setVisibility(8);
        this.t.setVisibility(0);
        this.v.setVisibility(8);
        this.w.setChecked(false);
        this.x.setChecked(false);
        this.y.setChecked(false);
        this.z.setChecked(false);
        for (Integer num : this.T) {
            if (num.intValue() == 1) {
                this.w.setChecked(true);
            }
            if (num.intValue() == 2) {
                this.x.setChecked(true);
            }
            if (num.intValue() == 3) {
                this.y.setChecked(true);
            }
            if (num.intValue() == 4) {
                this.z.setChecked(true);
            }
        }
    }

    private void g() {
        this.c.setText(e.i.dialog_end_dialog_title);
        setCloseVisibility(false);
        setBackVisibility(false);
        this.b.setBackground(null);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.u.setVisibility(8);
        this.t.setVisibility(8);
        this.v.setVisibility(0);
        rd.a().a(com.xiaopeng.autopilot.base.a.g().getResources().getString(e.i.dialog_end_tts));
        SoundPlayer.getInstance().play(e.h.share_map_success);
    }

    private void h() {
        boolean isChecked = this.w.isChecked();
        boolean isChecked2 = this.x.isChecked();
        boolean isChecked3 = this.y.isChecked();
        boolean isChecked4 = this.z.isChecked();
        if (isChecked || isChecked2 || isChecked3 || isChecked4) {
            this.T.clear();
            this.Q = true;
            this.S.setLength(0);
            if (isChecked) {
                if (this.S.length() != 0) {
                    this.S.append("，  ");
                }
                this.S.append(com.xiaopeng.autopilot.base.a.g().getResources().getString(e.i.memory_parking_share_type_charging_pie));
                this.T.add(1);
            }
            if (isChecked2) {
                if (this.S.length() != 0) {
                    this.S.append("，  ");
                }
                this.S.append(com.xiaopeng.autopilot.base.a.g().getResources().getString(e.i.memory_parking_share_type_elevator));
                this.T.add(2);
            }
            if (isChecked3) {
                if (this.S.length() != 0) {
                    this.S.append("，  ");
                }
                this.S.append(com.xiaopeng.autopilot.base.a.g().getResources().getString(e.i.memory_parking_share_type_stair));
                this.T.add(3);
            }
            if (isChecked4) {
                if (this.S.length() != 0) {
                    this.S.append("，  ");
                }
                this.S.append(com.xiaopeng.autopilot.base.a.g().getResources().getString(e.i.memory_parking_share_type_other));
                this.T.add(4);
            }
        } else {
            this.T.clear();
            this.Q = false;
            this.S.setLength(0);
            this.S.append(com.xiaopeng.autopilot.base.a.g().getResources().getString(e.i.dialog_share_map_bt_pos_text));
        }
        int length = this.S.length();
        if (length > 16) {
            this.S.replace(16, length, "...");
        }
        this.l.setText(this.S);
    }

    private void i() {
        if (this.R && this.Q) {
            this.B.setEnabled(true);
        } else {
            this.B.setEnabled(false);
        }
    }

    private void j() {
        String charSequence = this.G.getDisplayedValueForCurrentSelection().toString();
        this.U = this.G.getValue() + 1;
        Log.d("ShareMapView", "updateFloorInfo s = " + charSequence + "; mCommitFloorInfo = " + this.U);
        this.k.setText(charSequence);
    }

    private void k() {
        boolean isChecked = this.w.isChecked();
        boolean isChecked2 = this.x.isChecked();
        boolean isChecked3 = this.y.isChecked();
        boolean isChecked4 = this.z.isChecked();
        if (isChecked || isChecked2 || isChecked3 || isChecked4) {
            this.D.setEnabled(true);
        } else {
            this.D.setEnabled(false);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == e.C0055e.dialog_user_agreement_cb) {
            if (z) {
                this.j.setEnabled(true);
            } else {
                this.j.setEnabled(false);
            }
        } else if (compoundButton.getId() == e.C0055e.dialog_select_pos_charging_pie_ct || compoundButton.getId() == e.C0055e.dialog_select_pos_elevator_ct || compoundButton.getId() == e.C0055e.dialog_select_pos_stair_ct || compoundButton.getId() == e.C0055e.dialog_select_pos_other_ct) {
            k();
        }
    }

    public void setOnCloseListener(XDialogViewInterface.OnCloseListener onCloseListener) {
        this.ac = onCloseListener;
    }

    private void l() {
        if (ThemeWatcher.getInstance().isNight()) {
            if (!this.W) {
                this.g.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.h.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.o.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.A.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.I.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.J.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.k.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                Drawable drawable = com.xiaopeng.autopilot.base.a.g().getResources().getDrawable(e.d.ic_small_go_night);
                drawable.setBounds(0, 0, 14, 26);
                this.k.setCompoundDrawables(null, null, drawable, null);
                this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
                this.l.setCompoundDrawables(null, null, drawable, null);
                this.b.getBackground();
                this.p.setImageResource(e.g.dialog_share_map_iv_floor_night);
                this.q.setImageResource(e.g.dialog_share_map_iv_pos_night);
                this.H.setBackgroundResource(e.g.dialog_end_layout_heart_image_night);
                return;
            }
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
            this.L.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
            this.M.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_comment_color_night));
            this.N.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_night));
            this.O.setBackgroundResource(e.d.selector_comment_dialog_positive_btn_night);
            this.P.setBackgroundResource(e.d.selector_comment_dialog_negative_btn_night);
        } else if (!this.W) {
            this.g.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.h.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.m.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.n.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.o.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.A.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.I.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.J.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.k.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            Drawable drawable2 = com.xiaopeng.autopilot.base.a.g().getResources().getDrawable(e.d.ic_small_go);
            drawable2.setBounds(0, 0, 14, 26);
            this.k.setCompoundDrawables(null, null, drawable2, null);
            this.l.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.l.setCompoundDrawables(null, null, drawable2, null);
            this.b.getBackground();
            this.p.setImageResource(e.g.dialog_share_map_iv_floor);
            this.q.setImageResource(e.g.dialog_share_map_iv_pos);
            this.H.setBackgroundResource(e.g.dialog_end_layout_heart_image);
        } else {
            this.c.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.L.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.M.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_comment_color_day));
            this.N.setTextColor(com.xiaopeng.autopilot.base.a.g().getColor(e.b.share_map_dialog_title_color_day));
            this.O.setBackgroundResource(e.d.selector_comment_dialog_positive_btn);
            this.P.setBackgroundResource(e.d.selector_comment_dialog_negative_btn);
        }
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        l();
    }
}
