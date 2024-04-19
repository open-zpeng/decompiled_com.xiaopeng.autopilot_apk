package com.xiaopeng.autopilot.parking;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.base.bean.eventbus.CameraStateEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingAPPageRemoveEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingControlBtnEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingFailPageEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingLearnStepEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingNavGearUpdateEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingNavStartTipUpdateEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingPageEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingSuccessPageEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingUpdateVisibleEvent;
import com.xiaopeng.autopilot.base.f;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.view.q;
import com.xiaopeng.autopilot.parking.view.r;
import com.xiaopeng.autopilot.parking.view.s;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.app.XToast;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* loaded from: classes.dex */
public class TrainingAPPageView extends RelativeLayout {
    private s a;
    private r b;
    private q c;
    private com.xiaopeng.autopilot.parking.view.a d;
    private com.xiaopeng.autopilot.parking.view.b e;
    private a f;
    private boolean g;
    private XDialog h;
    private XDialog i;
    private View j;
    private ImageView k;
    private TextView l;
    private f m;
    private Runnable n;
    private Runnable o;

    private void k() {
    }

    public TrainingAPPageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrainingAPPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = true;
        this.n = new Runnable() { // from class: com.xiaopeng.autopilot.parking.TrainingAPPageView.1
            @Override // java.lang.Runnable
            public void run() {
                rd.a().a(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_learn_step_2_go_on));
            }
        };
        this.o = new Runnable() { // from class: com.xiaopeng.autopilot.parking.TrainingAPPageView.2
            @Override // java.lang.Runnable
            public void run() {
                TrainingAPPageView.this.g();
            }
        };
        j();
        k();
        org.greenrobot.eventbus.c.a().a(this);
    }

    private void j() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_parking_training_ap_page_view, (ViewGroup) this, true);
    }

    public void a() {
        l();
    }

    private void l() {
        if (ThemeWatcher.getInstance().isNight()) {
            ImageView imageView = this.k;
            if (imageView != null) {
                if (((Integer) imageView.getTag()).intValue() == 3) {
                    if (com.xiaopeng.autopilot.base.d.j()) {
                        this.k.setImageResource(e.g.training_first_dialog_ramp_icon_night);
                    } else {
                        this.k.setImageResource(e.g.training_first_dialog_icon_night);
                    }
                } else {
                    this.k.setImageResource(e.g.training_after_ap_first_dialog_icon_night);
                }
            }
            TextView textView = this.l;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(e.b.training_first_message_color_night));
                return;
            }
            return;
        }
        ImageView imageView2 = this.k;
        if (imageView2 != null) {
            if (((Integer) imageView2.getTag()).intValue() == 3) {
                if (com.xiaopeng.autopilot.base.d.j()) {
                    this.k.setImageResource(e.g.training_first_dialog_ramp_icon);
                } else {
                    this.k.setImageResource(e.g.training_first_dialog_icon);
                }
            } else {
                this.k.setImageResource(e.g.training_after_ap_first_dialog_icon);
            }
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(e.b.training_first_message_color));
        }
    }

    public void a(int i) {
        Log.i("TrainingAPPageView", "showTrainingFirstPage.showType = " + i);
        setVisibility(0);
        if (this.h == null) {
            this.h = new XDialog(getContext(), com.xiaopeng.autopilot.base.d.i);
            this.j = LayoutInflater.from(getContext()).inflate(e.f.layout_training_first_custom_view, this.h.getContentView(), false);
            this.k = (ImageView) this.j.findViewById(e.C0055e.training_first_bg_img);
            this.l = (TextView) this.j.findViewById(e.C0055e.training_first_warning_text);
            this.h.setCloseVisibility(true);
            this.h.setCustomView(this.j);
            this.h.getDialog().getWindow().setType(2047);
            this.h.setPositiveButton(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_first_page_btn_control_title), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.TrainingAPPageView.3
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog, int i2) {
                    int intValue = ((i.at) i.a(i.at.class)).d().intValue();
                    Log.i("TrainingAPPageView", "mTrainingFirstDialog.trainTips = " + intValue);
                    if (intValue == 4 || intValue == 30 || intValue == 33) {
                        Log.i("TrainingAPPageView", "mTrainingFirstDialog.startTraining.CarApiUtil.getGear() = " + CarApiUtil.getGear());
                        if (CarApiUtil.getGear() == 3) {
                            Log.i("TrainingAPPageView", "mTrainingFirstDialog.startTraining.Constant.REVERSING_R");
                            XToast.showShort(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_button_click_with_r));
                            rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_button_click_with_r));
                            return;
                        }
                        Log.i("TrainingAPPageView", "mTrainingFirstDialog.startTraining.click");
                        TrainingAPPageView.this.h.dismiss();
                        i.a(i.y.class, 0);
                        c.a(1);
                        TrainingAPPageView.this.g();
                    } else if (intValue == 15 || intValue == 34) {
                        TrainingAPPageView.this.m();
                    } else if (intValue == 0) {
                        rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_out_of_park));
                    } else if (intValue == 1) {
                        rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_up_down));
                    } else if (intValue == 2) {
                        rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_with_r));
                    } else if (intValue == 25) {
                        rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_error_click));
                    } else {
                        rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_training_other));
                    }
                }
            });
        }
        if (i == 3) {
            this.h.setTitle(e.i.training_first_dialog_title_text);
            this.k.setTag(3);
            if (ThemeWatcher.getInstance().isNight()) {
                if (com.xiaopeng.autopilot.base.d.j()) {
                    this.k.setImageResource(e.g.training_first_dialog_ramp_icon_night);
                } else {
                    this.k.setImageResource(e.g.training_first_dialog_icon_night);
                }
                this.l.setTextColor(getResources().getColor(e.b.training_first_message_color_night));
            } else {
                if (com.xiaopeng.autopilot.base.d.j()) {
                    this.k.setImageResource(e.g.training_first_dialog_ramp_icon);
                } else {
                    this.k.setImageResource(e.g.training_first_dialog_icon);
                }
                this.l.setTextColor(getResources().getColor(e.b.training_first_message_color));
            }
        } else {
            this.h.setTitle(e.i.training_after_ap_first_dialog_title_text);
            this.k.setTag(9);
            if (ThemeWatcher.getInstance().isNight()) {
                this.k.setImageResource(e.g.training_after_ap_first_dialog_icon_night);
                this.l.setTextColor(getResources().getColor(e.b.training_first_message_color_night));
            } else {
                this.k.setImageResource(e.g.training_after_ap_first_dialog_icon);
                this.l.setTextColor(getResources().getColor(e.b.training_first_message_color));
            }
        }
        this.h.show();
        i.a(i.y.class, 1);
        rd.a().e(com.xiaopeng.autopilot.base.a.g().getString(e.i.training_first_dialog_title_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Log.i("TrainingAPPageView", "showTrainingConfirmDialog");
        if (this.i == null) {
            this.i = new XDialog(getContext(), e.j.XDialogView);
            this.i.setMessage(e.i.confirm_training_dialog_message);
            this.i.getDialog().getWindow().setType(2047);
            this.i.setPositiveButton(getResources().getString(e.i.confirm_training_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.TrainingAPPageView.4
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog, int i) {
                    if (TrainingAPPageView.this.h != null) {
                        TrainingAPPageView.this.h.dismiss();
                    }
                    Log.i("TrainingAPPageView", "showTrainingConfirmDialog.startTraining.CarApiUtil.getGear() = " + CarApiUtil.getGear());
                    if (CarApiUtil.getGear() == 3) {
                        XToast.showShort(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_button_click_with_r));
                        rd.a().d(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_training_button_click_with_r));
                        return;
                    }
                    i.a(i.y.class, 0);
                    c.a(1);
                    TrainingAPPageView.this.i.dismiss();
                    TrainingAPPageView.this.g();
                }
            });
            this.i.setNegativeButton(getResources().getString(e.i.confirm_training_cancel), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.TrainingAPPageView.5
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog, int i) {
                    TrainingAPPageView.this.i.dismiss();
                }
            });
        }
        this.i.show();
    }

    public void b() {
        Log.i("TrainingAPPageView", "showAPFirstPage");
        setVisibility(0);
        if (this.c == null) {
            this.c = new q(getContext());
            this.m = this.c;
        } else {
            removeAllViews();
        }
        addView(this.c);
        this.c.a();
        i.a(i.y.class, 2);
    }

    public void b(int i) {
        Log.i("TrainingAPPageView", "updateLearnViewControlBtnEnable.status = " + i);
        r rVar = this.b;
        if (rVar != null) {
            if (i == 2) {
                rVar.a(true);
            } else {
                rVar.a(false);
            }
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        Log.i("TrainingAPPageView", "updateFinishSuccessView.distance = " + i + "," + i2);
        setVisibility(0);
        if (this.a == null) {
            this.a = new s(getContext());
            this.m = this.a;
        } else {
            removeAllViews();
        }
        addView(this.a);
        i.a(i.y.class, 3);
        this.a.a(i, i2, i3, i4);
    }

    public void a(List<Integer> list, int i) {
        Log.i("TrainingAPPageView", "updateFinishFailView.fail = " + list);
        setVisibility(0);
        if (this.a == null) {
            this.a = new s(getContext());
            this.m = this.a;
        } else {
            removeAllViews();
        }
        addView(this.a);
        i.a(i.y.class, 3);
        this.a.a(list, i);
    }

    public void c() {
        Log.i("TrainingAPPageView", "updateAPFinishPage");
        i.a(i.y.class, 5);
        setVisibility(0);
        if (this.e == null) {
            this.e = new com.xiaopeng.autopilot.parking.view.b(getContext());
        } else {
            removeAllViews();
        }
        addView(this.e);
        this.e.b();
        this.e.c();
        SoundPlayer.getInstance().play(e.h.ap_finish);
    }

    public void a(int i, int i2) {
        r rVar;
        int intValue = ((i.y) i.a(i.y.class)).d().intValue();
        Log.i("TrainingAPPageView", "updateLearnStep.step = " + i + ",status = " + i2 + "," + this.b + ",page = " + intValue);
        if (intValue == 4 && (rVar = this.b) != null) {
            switch (i) {
                case 1:
                    this.g = true;
                    rVar.c();
                    rd.a().h(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_learn_step_2));
                    rh.a().a(this.n, 10000L);
                    return;
                case 2:
                    rh.a().e(this.n);
                    this.b.d();
                    int intValue2 = ((i.ao) i.a(i.ao.class)).d().intValue();
                    Log.i("TrainingAPPageView", "TRAINING_LEARN_STEP_2.finishType = " + intValue2);
                    rd.a().h(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_start_learn_step_3));
                    rh.a().a(this.n, 10000L);
                    return;
                case 3:
                    rh.a().e(this.n);
                    ((i.at) i.a(i.at.class)).d().intValue();
                    if (i2 == 2 && this.g) {
                        this.g = false;
                        if (intValue != 7) {
                            rd.a().h(com.xiaopeng.autopilot.base.a.g().getString(e.i.tts_ap_ready_with_learn));
                        }
                    }
                    this.b.e();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        q qVar = this.c;
        if (qVar != null) {
            qVar.setMiniMapVisibility(i);
        }
    }

    public void a(boolean z) {
        int intValue = ((i.y) i.a(i.y.class)).d().intValue();
        Log.i("TrainingAPPageView", "updatePageVisible.page = " + intValue + ",visible = " + z);
        if (z) {
            if (intValue == 2) {
                setVisibility(0);
                return;
            } else if (intValue != 4) {
                return;
            } else {
                setVisibility(0);
                return;
            }
        }
        switch (intValue) {
            case 1:
                XDialog xDialog = this.h;
                if (xDialog != null) {
                    xDialog.dismiss();
                }
                setVisibility(8);
                return;
            case 2:
            case 4:
                setVisibility(8);
                return;
            case 3:
                this.a.c();
                g();
                if (CarApiUtil.getGear() == 1) {
                    XToast.show(e.i.training_ap_finish_gear_exit);
                    return;
                }
                return;
            case 5:
                g();
                c.f();
                if (CarApiUtil.getGear() == 1) {
                    IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
                    XToast.show(e.i.training_ap_finish_gear_exit);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean d() {
        r rVar = this.b;
        return rVar != null && rVar.getVisibility() == 0;
    }

    public void e() {
        int intValue = ((i.ao) i.a(i.ao.class)).d().intValue();
        Log.i("TrainingAPPageView", "finishType = " + intValue);
        if (intValue == 1 || intValue == 2) {
            setVisibility(0);
            if (this.b == null) {
                this.b = new r(getContext());
                this.m = this.b;
            } else {
                removeAllViews();
            }
            addView(this.b);
            i.a(i.y.class, 4);
            this.b.b();
            return;
        }
        g();
    }

    public boolean f() {
        return ((i.y) i.a(i.y.class)).d().intValue() != 0;
    }

    public void g() {
        Log.i("TrainingAPPageView", "removeTrainingAPView");
        i.a(i.y.class, 0);
        removeAllViews();
        setVisibility(8);
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = null;
        this.m = null;
        this.d = null;
        this.g = true;
        this.f = null;
    }

    public void h() {
        i.a(i.y.class, 6);
        setVisibility(0);
        if (this.d == null) {
            this.d = new com.xiaopeng.autopilot.parking.view.a(getContext());
        } else {
            removeAllViews();
        }
        addView(this.d);
        this.d.d();
        rh.a().e(this.o);
        rh.a().a(this.o, 3000L);
    }

    private void b(boolean z) {
        if (z) {
            setVisibility(0);
            if (this.d == null) {
                this.d = new com.xiaopeng.autopilot.parking.view.a(getContext(), 2);
            } else {
                removeAllViews();
            }
            addView(this.d);
            this.d.d();
            return;
        }
        rh.a().c(this.o);
    }

    @m
    public void onSuccessPageEvent(TrainingSuccessPageEvent trainingSuccessPageEvent) {
        if (trainingSuccessPageEvent != null) {
            a(trainingSuccessPageEvent.mDistance, trainingSuccessPageEvent.mSpdNum, trainingSuccessPageEvent.mRampCount, trainingSuccessPageEvent.mFinishType);
        }
    }

    @m
    public void onFailPageEvent(TrainingFailPageEvent trainingFailPageEvent) {
        if (trainingFailPageEvent != null) {
            a(trainingFailPageEvent.mFail, trainingFailPageEvent.mFinishType);
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onTrainingPageEvent(TrainingPageEvent trainingPageEvent) {
        a aVar;
        if (trainingPageEvent != null) {
            Log.i("TrainingAPPageView", "onTrainingPageEvent.event.mState = " + trainingPageEvent.mState);
            if (trainingPageEvent.mState == 2) {
                c();
            } else if (trainingPageEvent.mState == 1) {
                b();
            } else if (trainingPageEvent.mState == 5) {
                a();
            } else if (trainingPageEvent.mState == 3 || trainingPageEvent.mState == 9) {
                a(trainingPageEvent.mState);
            } else if (trainingPageEvent.mState == 6 || trainingPageEvent.mState == 10) {
                m();
            } else if (trainingPageEvent.mState == 4) {
                e();
            } else if (trainingPageEvent.mState == 7) {
                h();
            } else if (trainingPageEvent.mState == 8) {
                g();
            } else if (trainingPageEvent.mState == 12) {
                b(false);
            } else if (trainingPageEvent.mState == 11) {
                b(true);
            } else if (trainingPageEvent.mState == 13) {
                g();
                if (trainingPageEvent.mData != null) {
                    c(((Integer) trainingPageEvent.mData).intValue());
                } else {
                    c(0);
                }
                a aVar2 = this.f;
                if (aVar2 != null) {
                    aVar2.a(((Integer) trainingPageEvent.mData).intValue());
                }
            } else if (trainingPageEvent.mState == 14) {
                i();
                a aVar3 = this.f;
                if (aVar3 != null) {
                    aVar3.a();
                }
            } else if (trainingPageEvent.mState == 15) {
                a aVar4 = this.f;
                if (aVar4 != null) {
                    aVar4.a(((Integer) trainingPageEvent.mData).intValue());
                }
            } else if (trainingPageEvent.mState != 16 || (aVar = this.f) == null) {
            } else {
                aVar.a();
            }
        }
    }

    @m
    public void onUpdateVisibleEvent(TrainingUpdateVisibleEvent trainingUpdateVisibleEvent) {
        if (trainingUpdateVisibleEvent != null) {
            a(trainingUpdateVisibleEvent.mState);
        }
    }

    @m
    public void onUpdateLearnStepEvent(TrainingLearnStepEvent trainingLearnStepEvent) {
        if (trainingLearnStepEvent != null) {
            a(trainingLearnStepEvent.mStep, trainingLearnStepEvent.mStatus);
        }
    }

    @m
    public void onNavGearUpdate(TrainingNavGearUpdateEvent trainingNavGearUpdateEvent) {
        this.f.b(trainingNavGearUpdateEvent.getGear());
    }

    @m(a = ThreadMode.MAIN)
    public void onCameraStateEvent(CameraStateEvent cameraStateEvent) {
        a aVar = this.f;
        if (aVar == null || aVar.getVisibility() != 0) {
            return;
        }
        this.f.c(cameraStateEvent.mState);
    }

    @m(a = ThreadMode.MAIN)
    public void onControlBtnEvent(TrainingControlBtnEvent trainingControlBtnEvent) {
        if (trainingControlBtnEvent != null) {
            b(trainingControlBtnEvent.mStatus);
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onRemoveEvent(TrainingAPPageRemoveEvent trainingAPPageRemoveEvent) {
        if (trainingAPPageRemoveEvent != null) {
            g();
        }
    }

    public void c(int i) {
        LogUtils.i("TrainingAPPageView", "updateNavStartView hillType:" + i);
        i.a(i.y.class, 7);
        setVisibility(0);
        if (this.f == null) {
            this.f = new a(getContext());
            addView(this.f);
        }
        this.f.setVisibility(0);
        this.f.a(i);
        this.f.b(CarApiUtil.getGear());
        if (CarApiUtil.getGear() == 3) {
            com.xiaopeng.autopilot.base.d.e(1);
        } else {
            com.xiaopeng.autopilot.base.d.e(2);
        }
    }

    public void i() {
        LogUtils.i("TrainingAPPageView", "removeNavStartView");
        i.a(i.y.class, 0);
        this.f.setVisibility(8);
        setVisibility(8);
    }

    @m(a = ThreadMode.MAIN)
    public void onNavTipsUpdateEvent(TrainingNavStartTipUpdateEvent trainingNavStartTipUpdateEvent) {
        this.f.a(trainingNavStartTipUpdateEvent.getTips(), trainingNavStartTipUpdateEvent.getFeatureDistance(), trainingNavStartTipUpdateEvent.getStartPointDistance(), trainingNavStartTipUpdateEvent.getFeaturePercentage());
    }
}
