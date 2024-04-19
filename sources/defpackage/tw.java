package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.bean.eventbus.CameraXPilotEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.NavClose4APReadyEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.NavStartCloseEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.SpeechSuperParkEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingNavGearUpdateEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingNavStartTipUpdateEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.TrainingPageEvent;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.e;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.NavStartGuideDialogUtil;
import com.xiaopeng.autopilot.base.utils.PerformanceTestUnit;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.c;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.model.IParkingModelPro;
import com.xiaopeng.autopilot.parking.model.ParkingModelPro;
import com.xiaopeng.autopilot.parking.view.ParkingViewContainer;
import com.xiaopeng.autopilot.parking.view.ParkingViewPro;
import com.xiaopeng.autopilot.parking.view.g;
import com.xiaopeng.autopilot.parking.view.h;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.sr.bean.ApMapBean;
import com.xiaopeng.xui.app.XToast;
import defpackage.b;
import defpackage.re;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* compiled from: ParkingPresenterPro.java */
/* renamed from: tw  reason: default package */
/* loaded from: classes.dex */
public class tw extends tv implements tn, to {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private long F;
    private int G;
    private int H;
    private int I;
    private int J;
    private float K;
    private float L;
    private int M;
    private int N;
    private boolean O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private Handler X;
    private Runnable Y;
    private Runnable Z;
    private Runnable aa;
    private Runnable ab;
    private Runnable ac;
    private Runnable ad;
    private Runnable ae;
    private int af;
    private int ag;
    private int ah;
    private int ai;
    private int aj;
    h i;
    IParkingModelPro j;
    private int n;
    private int o;
    private int p;
    private int q;
    private int[] r;
    private int s;
    private e t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    public static final String[] g = a.g().getResources().getStringArray(e.a.array_nav_tips);
    public static final String[] h = a.g().getResources().getStringArray(e.a.array_nav_tips_tts);
    private static final String[] m = a.g().getResources().getStringArray(e.a.array_pro_parking);
    public static final String[] k = a.g().getResources().getStringArray(e.a.array_training_tips);
    public static final String[] l = a.g().getResources().getStringArray(e.a.array_training_fail_reason);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.tv
    public void h() {
        super.h();
        if (this.j == null) {
            this.j = new ParkingModelPro();
        }
        this.j.bind(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.tv
    public void a(String str) {
        if (B() || this.i.i()) {
            return;
        }
        super.a(str);
    }

    public tw(ParkingViewContainer parkingViewContainer, g gVar) {
        super(parkingViewContainer);
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = false;
        this.z = true;
        this.A = false;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = 0L;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = -1.0f;
        this.L = -1.0f;
        this.M = 0;
        this.N = 0;
        this.O = false;
        this.P = 0;
        this.Q = false;
        this.R = false;
        this.S = true;
        this.T = true;
        this.U = true;
        this.V = false;
        this.W = false;
        this.X = new Handler(Looper.getMainLooper()) { // from class: tw.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case -16:
                        tw.this.c.h(-16);
                        return;
                    case -15:
                        tw.this.c.h(-15);
                        return;
                    case -14:
                        if (message.arg1 == 0) {
                            tw.this.i.h(0);
                        }
                        tw.this.c.h(-14);
                        if (message.arg1 == 0) {
                            tw.this.i.l(-1);
                            return;
                        }
                        return;
                    case -13:
                        tw.this.i.h(8);
                        tw.this.c.h(-13);
                        return;
                    case -12:
                        tw.this.i.h(8);
                        tw.this.i.a(4);
                        tw.this.c.h(-12);
                        return;
                    case -11:
                        tw.this.c.h(-11);
                        return;
                    case -10:
                        tw.this.c.h(-10);
                        return;
                    case -9:
                        tw.this.c.h(-9);
                        return;
                    case -8:
                        tw.this.c.i(-8);
                        return;
                    case -7:
                        tw.this.c.i(-7);
                        return;
                    case -6:
                    case 1:
                    default:
                        return;
                    case -5:
                        tw.this.c.h(-5);
                        return;
                    case -4:
                        tw.this.c.h(-4);
                        return;
                    case -3:
                        tw.this.c.i(-3);
                        return;
                    case -2:
                        tw.this.c.i(-2);
                        return;
                    case -1:
                        tw.this.c.i(-1);
                        tw.this.i.l(-1);
                        return;
                    case 0:
                        tw.this.c.h(0);
                        return;
                    case 2:
                        tw.this.c.h(2);
                        return;
                }
            }
        };
        this.Y = new Runnable() { // from class: tw.12
            @Override // java.lang.Runnable
            public void run() {
                int intValue = ((i.y) i.a(i.y.class)).d().intValue();
                Log.i("ParkingPresenterPro", "mAVMRRunnable.page = " + intValue);
                if (intValue == 0 || intValue == 1) {
                    return;
                }
                tw.this.L();
                tw.this.i.p(8);
                tw.this.i.d(true);
            }
        };
        this.Z = new Runnable() { // from class: tw.15
            @Override // java.lang.Runnable
            public void run() {
                Log.i("ParkingPresenterPro", "mSavingEightRunnable");
                rd.a().a(a.g().getString(e.i.tts_training_saving_8_seconds));
                rh.a().b(tw.this.ab, 8000L);
            }
        };
        this.aa = new Runnable() { // from class: tw.16
            @Override // java.lang.Runnable
            public void run() {
                Log.i("ParkingPresenterPro", "mSavingTimeOutRunnable");
                tw.this.i.f();
            }
        };
        this.ab = new Runnable() { // from class: tw.17
            @Override // java.lang.Runnable
            public void run() {
                Log.i("ParkingPresenterPro", "mSavingSixteenRunnable");
                rd.a().a(a.g().getString(e.i.tts_training_saving_16_seconds));
                rh.a().b(tw.this.ac, 16000L);
            }
        };
        this.ac = new Runnable() { // from class: tw.18
            @Override // java.lang.Runnable
            public void run() {
                Log.i("ParkingPresenterPro", "mSavingThirtyTwoRunnable");
                rd.a().a(a.g().getString(e.i.tts_training_saving_32_seconds));
                rh.a().b(tw.this.ad, 32000L);
            }
        };
        this.ad = new Runnable() { // from class: tw.19
            @Override // java.lang.Runnable
            public void run() {
                Log.i("ParkingPresenterPro", "mSavingSixtyFourRunnable");
                rd.a().a(a.g().getString(e.i.tts_training_saving_64_seconds));
            }
        };
        this.ae = new Runnable() { // from class: tw.20
            @Override // java.lang.Runnable
            public void run() {
                Log.i("ParkingPresenterPro", "mAPTips79TimeOutRunnable");
                rd.a().a(a.g().getString(e.i.tts_ap_tips_79_15_seconds));
            }
        };
        this.af = -1;
        this.ag = -1;
        this.ah = -1;
        this.ai = -1;
        this.aj = -1;
        Log.i("ParkingPresenterPro", "ParkingPresenterPro");
        if (gVar instanceof ParkingViewPro) {
            this.i = (h) gVar;
        }
    }

    @Override // defpackage.tv
    public void m(int i) {
        int intValue = ((i.y) i.a(i.y.class)).d().intValue();
        Log.i("ParkingPresenterPro", "parseTipData.isStartTraining() = " + B() + ",currentTip = " + i + "," + this.f + "," + this.i.e() + "," + intValue + ",mStatusIndicate = " + this.n);
        this.i.a();
        this.i.c(0, 8);
        this.i.g(false);
        W();
        rh.a().e(this.ae);
        if (B() || this.i.e()) {
            i.a(i.ah.class, false);
            if (this.i.e()) {
                this.i.i(1);
                s(i);
            }
            if (this.p == 2) {
                if (i == 3 || i == 34) {
                    this.i.f(true);
                    i.a(i.ap.class, true);
                    this.i.a(a.g().getString(e.i.start_parking), false, false, a.g().getString(e.i.training_parking_b));
                    this.i.f(true);
                    this.i.g(true);
                    this.i.b(0);
                    c.e(0);
                    o(-10);
                    this.i.a(a.g().getString(e.i.tips_training_parking_b));
                    super.m(this.d);
                } else if (i == 2) {
                    this.i.a(a.g().getString(e.i.start_parking), true, false, a.g().getString(e.i.release_pedal));
                    o(-10);
                    super.m(this.d);
                } else if (i == 4 || i == 13) {
                    this.i.a(a.g().getString(e.i.continue_park), true, true, a.g().getString(e.i.training_parking_b));
                    o(-10);
                    super.m(this.d);
                } else if (i == 6) {
                    this.i.a(a.g().getString(e.i.start_parking), false, false, a.g().getString(e.i.training_parking_b));
                    this.i.i(3);
                    n(2);
                    this.j.resetSlotIdMappingList();
                } else if (i == 7 || i == 5 || i == 35) {
                    this.i.i(3);
                    this.i.a(a.g().getString(e.i.start_parking), false, false, a.g().getString(e.i.training_parking_b));
                    o(-2);
                    this.j.resetSlotIdMappingList();
                    if (i == 7) {
                        super.m(this.d);
                    } else {
                        rd.a().a(a.g().getString(e.i.tts_training_parking_b_cancel_with_xpu));
                    }
                } else if (V()) {
                    if (CarApiUtil.getGear() == 3) {
                        if (this.d == 22) {
                            this.i.a(a.g().getString(e.i.training_in_ready_text_tts));
                            this.i.a(a.g().getString(e.i.start_parking), true, true, a.g().getString(e.i.training_select_park_lots));
                            this.i.b(0);
                            c.e(0);
                            o(-9);
                            return;
                        } else if (this.d == 20 || this.d == 23) {
                            this.i.a(a.g().getString(e.i.training_in_ready_text_tts));
                            this.i.a(a.g().getString(e.i.start_parking), true, false, a.g().getString(e.i.training_has_park_lots));
                            o(-9);
                            return;
                        } else {
                            this.i.i(3);
                            this.i.a(a.g().getString(e.i.start_parking), false, false, "");
                            o(-2);
                            this.j.resetSlotIdMappingList();
                            return;
                        }
                    }
                    this.i.i(3);
                    this.i.a(a.g().getString(e.i.start_parking), false, false, "");
                    o(-2);
                } else {
                    if (CarApiUtil.getGear() == 3) {
                        this.i.a(a.g().getString(e.i.training_with_r));
                    }
                    this.i.i(3);
                    this.i.a(a.g().getString(e.i.start_parking), false, false, "");
                    o(-2);
                }
            }
        } else if (intValue == 2 || (i < 64 && this.n == 3 && this.f < 64)) {
            i.a(i.ah.class, false);
            s(i);
        } else {
            super.m(i);
            if (this.i == null) {
                Log.i("ParkingPresenterPro", "mParkingProView is null");
                return;
            }
            if (this.f == 24 && !this.j.isInNavStartPointProcedure()) {
                this.i.c(false);
                if (this.j.isInNavStartPointProcedure()) {
                    this.j.resetNavStateWhenStart();
                    rh.a().a(new Runnable() { // from class: tw.21
                        @Override // java.lang.Runnable
                        public void run() {
                            tw twVar = tw.this;
                            twVar.r(twVar.af);
                        }
                    }, 200L);
                }
            }
            if (i < 64) {
                this.T = true;
                this.U = true;
                this.i.h(8);
                this.i.b("");
                this.i.i(1);
                if (this.f == 82 && this.Q) {
                    this.i.m();
                }
                if (i == 6) {
                    this.i.setDistanceLayoutVisible(8);
                    boolean booleanValue = ((i.f) i.a(i.f.class)).d().booleanValue();
                    Log.i("ParkingPresenterPro", "parseTipData.hasActive = " + booleanValue);
                    if (booleanValue) {
                        i.a(i.f.class, false);
                        L();
                        i.a(i.h.class, true);
                        this.i.h();
                    }
                } else if (i == 5 || i == 7 || i == 11 || i == 10) {
                    this.i.setDistanceLayoutVisible(8);
                } else if (i == 24) {
                    i.a(i.b.class, 4);
                    if (!((i.w) i.a(i.w.class)).d().booleanValue() && !this.j.isInNavStartPointProcedure()) {
                        this.i.c(true);
                    }
                }
                boolean i2 = this.i.i();
                if (d.c()) {
                    Log.i("ParkingPresenterPro", "parseTipData.result = " + i2);
                }
                i.a(i.ah.class, Boolean.valueOf(!i2));
                return;
            }
            this.i.p(8);
            if (this.n == 7) {
                i.a(i.ah.class, true);
            } else {
                i.a(i.ah.class, false);
            }
            int i3 = i - 64;
            String[] strArr = m;
            String str = i3 < strArr.length ? strArr[i3] : "";
            this.c.a("", 4, null, false);
            this.i.i(2);
            this.i.e(4);
            i.a(i.g.class, false);
            switch (i) {
                case 71:
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_xpilot_3_favorite_parking_tips_71));
                    break;
                case 72:
                    int i4 = this.n;
                    if (i4 == 8 || i4 == 9) {
                        this.i.b(a.g().getString(e.i.parking_ap_pass_ramp_tips_72));
                        break;
                    } else {
                        this.i.b(str);
                        break;
                    }
                    break;
                case 73:
                case 74:
                    rd.a().a(str);
                    this.i.b(str);
                    break;
                case 75:
                    Log.i("ParkingPresenterPro", "CAN_MSG_TURN_STRAIGHT.mFirstShowCrossing = " + this.w);
                    if (this.w) {
                        this.w = false;
                        rd.a().a(str);
                    }
                    SoundPlayer.getInstance().play(e.h.ap_warn_sound_one);
                    this.i.b(str);
                    this.i.c(1, 0);
                    break;
                case 76:
                case 77:
                    SoundPlayer.getInstance().play(e.h.ap_warn_sound_one);
                    this.i.c(3, 0);
                    rd.a().a(str);
                    this.i.b(str);
                    break;
                case 78:
                    this.i.b(str);
                    rd.a().g(str);
                    break;
                case 79:
                    this.i.b(str);
                    rd.a().a(str);
                    break;
                case 81:
                    XToast.showShort(str);
                    break;
                case 82:
                    i.a(i.f.class, false);
                    i.a(i.g.class, true);
                    i.a(i.b.class, 2);
                    SoundPlayer.getInstance().play(e.h.sound_ap_quit);
                    if (this.f != 110 && this.f != 114 && this.f != 115) {
                        this.Q = true;
                        this.i.n();
                        this.i.b(str);
                        rd.a().h(a.g().getString(e.i.tts_xpilot_3_favorite_driving_cancel));
                    } else {
                        this.Q = false;
                    }
                    this.i.h(8);
                    break;
                case 83:
                    i.a(i.f.class, false);
                    i.a(i.g.class, true);
                    SoundPlayer.getInstance().play(e.h.sound_ap_xpu_quit);
                    i.a(i.b.class, 1);
                    this.i.b(str);
                    this.i.n();
                    this.i.h(8);
                    rd.a().h(a.g().getString(e.i.tts_xpilot_3_favorite_parking_error));
                    break;
                case 84:
                    this.i.h(8);
                    org.greenrobot.eventbus.c.a().d(new CameraXPilotEvent(0));
                    this.i.b(str);
                    this.X.removeMessages(-3);
                    this.X.sendEmptyMessageDelayed(-3, 100L);
                    rd.a().a(a.g().getString(e.i.tts_xpilot_3_arrive_favorite_slot));
                    break;
                case 85:
                    i.a(i.f.class, false);
                    i.a(i.g.class, true);
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_xpilot_3_not_find_favorite_slot));
                    break;
                case 88:
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_xpilot_3_waiting_safe));
                    break;
                case 89:
                    this.i.b(str);
                    rd.a().g(a.g().getString(e.i.tts_ap_tips_89));
                    break;
                case 90:
                    this.i.b(str);
                    rd.a().a(str);
                    break;
                case 91:
                    this.i.b(str);
                    rd.a().a(str);
                    break;
                case 92:
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_xpilot_3_round_people));
                    break;
                case 94:
                    this.M++;
                    this.i.b(str);
                    rd.a().a(str);
                    Log.i("ParkingPresenterPro", "CAN_MSG_STOP_WITH_PEOPLE.mFinishRoundPeopleCount = " + this.M);
                    break;
                case 95:
                    this.N++;
                    this.i.b(str);
                    rd.a().a(str);
                    break;
                case 97:
                    this.N++;
                    this.i.b(str);
                    rd.a().a(str);
                    Log.i("ParkingPresenterPro", "CAN_MSG_STOP_WITH_CAR.mPassingCarCount = " + this.N);
                    break;
                case 98:
                    i.a(i.f.class, false);
                    i.a(i.g.class, true);
                    SoundPlayer.getInstance().play(e.h.sound_ap_xpu_quit);
                    i.a(i.b.class, 1);
                    this.i.b(str);
                    this.i.n();
                    this.i.h(8);
                    rd.a().a(a.g().getString(e.i.tts_xpilot_3_favorite_parking_tips_98));
                    break;
                case 99:
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_ap_reversing));
                    break;
                case 100:
                    this.N++;
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_ap_passing_car));
                    Log.i("ParkingPresenterPro", "CAN_MSG_PASSING_CAR.mPassingCarCount = " + this.N);
                    break;
                case 101:
                    i.a(i.f.class, false);
                    i.a(i.g.class, true);
                    SoundPlayer.getInstance().play(e.h.sound_ap_xpu_quit);
                    i.a(i.b.class, 1);
                    this.i.n();
                    this.i.h(8);
                    break;
                case 102:
                    this.N++;
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_ap_tips_102));
                    break;
                case 103:
                    this.M++;
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_ap_with_less_than_5_people));
                    break;
                case 104:
                    this.M++;
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_ap_with_more_than_5_people));
                    break;
                case 105:
                    SoundPlayer.getInstance().play(e.h.sound_ap_xpu_quit);
                    this.i.c(2, 0);
                    i.a(i.b.class, 3);
                    this.i.n();
                    break;
                case 106:
                    this.i.b(str);
                    rd.a().a(str);
                    break;
                case 109:
                    o(-12);
                    this.i.k(this.n);
                    this.i.b(str);
                    break;
                case 110:
                case 114:
                case 115:
                    c.e(0);
                    o(-13);
                    this.i.k(this.n);
                    this.i.b(str);
                    if (i == 115) {
                        this.U = false;
                    }
                    if (!re.a().h()) {
                        if (i != 110) {
                            if (i == 115) {
                                rd.a().a(a.g().getString(e.i.tts_ap_founded_park_lot_arrive_favorite));
                                break;
                            } else {
                                rd.a().a(a.g().getString(e.i.tts_ap_founded_park_lot_near_favorite));
                                break;
                            }
                        } else {
                            rd.a().a(a.g().getString(e.i.tts_ap_founded_park_lot));
                            break;
                        }
                    } else {
                        g(i);
                        break;
                    }
                case 111:
                    i.a(i.f.class, false);
                    i.a(i.g.class, true);
                    this.i.k(this.n);
                    this.i.b(str);
                    rd.a().a(a.g().getString(e.i.tts_ap_not_found_park_lot));
                    break;
                case 112:
                    rd.a().a(a.g().getString(e.i.tts_ap_tips_112));
                    break;
                case 113:
                    i.a(i.f.class, false);
                    i.a(i.g.class, true);
                    rd.a().a(a.g().getString(e.i.tts_ap_tips_113));
                    break;
                case 116:
                    this.i.b(str);
                    rd.a().a(str);
                    break;
                case 118:
                    this.i.b(str);
                    rd.a().a(str);
                    break;
            }
            this.i.b(this.M, this.N);
        }
    }

    private void c(int i, int i2) {
        Log.i("ParkingPresenterPro", "parseFoundParkLotExitFormTips mIsInApFoundParkLotMode = " + this.V + " ; curAPst = " + i2);
        if (i2 == 7) {
            this.V = true;
        } else if (i2 == 8 || i2 == 9 || !this.V) {
        } else {
            re.a().a(false);
            this.V = false;
        }
    }

    private void s(int i) {
        String str = "";
        if (a != null && i < a.length) {
            str = a[i];
        }
        this.i.a(str, -1);
    }

    public int q() {
        return this.M;
    }

    public int r() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.tv
    public void a(int i, int i2) {
        if (B() || this.j.isInNavStartPointProcedure()) {
            return;
        }
        int intValue = ((i.y) i.a(i.y.class)).d().intValue();
        boolean z = (intValue == 4) | (intValue == 2) | (intValue == 3);
        int intValue2 = ((i.ad) i.a(i.ad.class)).d().intValue();
        if (d.c()) {
            Log.i("ParkingPresenterPro", "trySurfaceUpdate.canNotChangeScene = " + z + "," + intValue + ",scene = " + intValue2);
        }
        if (z) {
            return;
        }
        if (!(intValue == 5 && intValue2 == -6) && i2 <= 64) {
            super.a(i, i2);
        }
    }

    public ParkingModelPro s() {
        if (this.j == null) {
            this.j = new ParkingModelPro();
        }
        return (ParkingModelPro) this.j;
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IArrowChangeListener
    public void onArrowChange(final int i) {
        rh.a().b(new Runnable() { // from class: tw.2
            @Override // java.lang.Runnable
            public void run() {
                tw.this.i.j(i);
            }
        });
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.ITipsChangeListener
    public void onTipsChange(int i, int i2) {
        Log.i("ParkingPresenterPro", "onTipsChange.tips = " + i + ",abnormal = " + i2 + ",mLastParseTip =  " + this.f + ",isStartTraining() = " + B());
        l(i);
        k(i2);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IStatusIndicateChangeListener
    public void onStatusIndicateChange(int i) {
        h hVar;
        Log.i("ParkingPresenterPro", "onStatusIndicateChange.preStatusIndicate = " + this.n + " ; curStatusIndicate = " + i + "," + B() + "," + this.i.e() + "," + this.O + "," + this.o);
        c(this.n, i);
        int i2 = this.n;
        this.n = i;
        i.a(i.c.class, Integer.valueOf(i));
        this.i.k(i);
        W();
        if (i == 3) {
            IntentUtil.sendInfoFlowCard(0);
            if (this.W) {
                x();
                this.W = false;
            }
            i.a(i.b.class, 0);
            this.i.p(8);
            i.a(i.ao.class, 0);
            this.i.a(4);
            c.r();
            this.X.removeMessages(-1);
            this.X.sendEmptyMessageDelayed(-1, 100L);
            K();
            this.i.h(0);
        } else if (i != 2 && i != 1) {
            if (i == 7) {
                this.U = true;
                o(-12);
                this.L = this.j.getLocationData().e();
                if (this.T) {
                    this.T = false;
                    rd.a().a(a.g().getString(e.i.tts_ap_start_found_park_lot));
                }
            } else if (i == 8 || i == 9) {
                o(-14);
                this.i.h(0);
                this.i.a(4);
                if (i == 8) {
                    this.i.b(a.g().getString(e.i.parking_ap_status_pass_ramp_down_title));
                } else {
                    this.i.b(a.g().getString(e.i.parking_ap_status_pass_ramp_up_title));
                }
            } else {
                c.b(8);
                if (this.q == 4) {
                    return;
                }
                IntentUtil.sendInfoFlowCard(0);
            }
        } else {
            this.w = true;
            int intValue = ((i.ao) i.a(i.ao.class)).d().intValue();
            if (((i.t) i.a(i.t.class)).d().intValue() < 4 && (hVar = this.i) != null && hVar.e() && intValue == 2 && this.o != 11) {
                this.i.b_(3, i);
            }
            if (i == 2) {
                h hVar2 = this.i;
                if (hVar2 == null || !hVar2.j()) {
                    ApMapBean apMapBean = this.j.getApMapBean();
                    if (apMapBean.getMapType() == 2 || apMapBean.getMapType() == 3) {
                        if (apMapBean.getTerminalAttr() == 1) {
                            IntentUtil.sendInfoFlowCard(5);
                        } else if (apMapBean.getTerminalAttr() == 2) {
                            IntentUtil.sendInfoFlowCard(6);
                        } else if (apMapBean.getTerminalAttr() == 3) {
                            IntentUtil.sendInfoFlowCard(7);
                        } else if (apMapBean.getTerminalAttr() == 4) {
                            IntentUtil.sendInfoFlowCard(8);
                        }
                    } else {
                        IntentUtil.sendInfoFlowCard(1);
                    }
                } else if (!this.i.e() && this.i.j() && this.O) {
                    this.O = false;
                    rd.a().a(a.g().getString(e.i.tts_xpilot_3_favorite_parking_ready));
                }
                if (NavStartGuideDialogUtil.isDialogShown()) {
                    NavStartGuideDialogUtil.dissmissDialog();
                    this.i.o();
                }
            }
        }
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IRemainDistanceListener
    public void onRemainDistance(final float f) {
        rh.a().b(new Runnable() { // from class: tw.3
            @Override // java.lang.Runnable
            public void run() {
                if (tw.this.n == 2 || tw.this.n == 3 || tw.this.n == 7 || tw.this.n == 8 || tw.this.n == 9) {
                    if (tw.this.K < 0.0f) {
                        tw.this.K = f;
                    }
                    if (tw.this.n == 3 && (tw.this.j.getApMapBean().getMapType() == 2 || tw.this.j.getApMapBean().getMapType() == 3)) {
                        float f2 = f;
                        if (f2 > 0.0f && f2 < 20.0f && !tw.this.R) {
                            tw.this.R = true;
                            tw.this.P();
                        }
                    }
                    tw.this.i.b(f);
                }
                PerformanceTestUnit.log("ParkingPresenterPro", "onRemainDistance.mAPDistance = " + tw.this.K + "," + tw.this.n + "," + f, 1000L);
            }
        });
    }

    public float t() {
        Log.i("ParkingPresenterPro", "getAPDistance.mAPDistance = " + this.K + "," + (this.j.getLocationData().e() - this.L));
        if (((i.j) i.a(i.j.class)).d().booleanValue()) {
            return this.j.getLocationData().e() - this.L;
        }
        return this.K;
    }

    public float u() {
        return this.j.getRemainDis();
    }

    @Override // defpackage.tv
    protected void i() {
        if (this.j.isInNavStartPointProcedure()) {
            return;
        }
        this.i.c(true);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IApFailReasonListener
    public void onApFailReason(int i) {
        h hVar;
        this.o = i;
        i.a(i.a.class, Integer.valueOf(i));
        int intValue = ((i.t) i.a(i.t.class)).d().intValue();
        int intValue2 = ((i.ao) i.a(i.ao.class)).d().intValue();
        Log.i("ParkingPresenterPro", "onApFailReason.reason = " + i + "," + intValue + "," + this.n + "," + intValue2);
        if (intValue >= 4 || this.n != 1 || (hVar = this.i) == null || !hVar.e() || intValue2 != 2 || this.o == 11) {
            return;
        }
        this.i.b_(3, this.n);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IVoiceChangeListener
    public void onVoiceChange(final int i) {
        Log.i("ParkingPresenterPro", "onVoiceChange.voice = " + i);
        rh.a().c(new Runnable() { // from class: tw.4
            @Override // java.lang.Runnable
            public void run() {
                if (i == 1) {
                    tw.this.i.q(0);
                } else {
                    tw.this.i.q(8);
                }
            }
        });
    }

    public void v() {
        if (this.n != 7) {
            SoundPlayer.getInstance().play(e.h.sound_ap_start);
        }
        this.j.startAP();
    }

    @Override // defpackage.tv, defpackage.ti, defpackage.tn
    public void a(boolean z) {
        if (z) {
            k();
            l();
            m();
        }
        this.j.routeAp2SrAutoParkReq(1);
        CarApiUtil.autoParkInByXMart(z);
    }

    @Override // defpackage.tv, defpackage.ti
    public void b() {
        Log.i("ParkingPresenterPro", "autoParkInContinueByXMart");
        CarApiUtil.autoParkInContinueByXMart();
        this.j.routeAp2SrAutoParkReq(4);
    }

    @Override // defpackage.tv, defpackage.ti
    public void b(boolean z) {
        CarApiUtil.autoParkOutByXMart(z);
        if (z) {
            k();
            l();
        }
        this.j.routeAp2SrAutoParkReq(3);
    }

    @Override // defpackage.tv, defpackage.ti
    public void a() {
        CarApiUtil.autoParkOutContinueByXMart();
        this.j.routeAp2SrAutoParkReq(4);
    }

    @Override // defpackage.tv
    protected void j() {
        Log.i("ParkingPresenterPro", "updateIndexByParkLotItems.mCurrentTip = " + this.d + "," + this.j.hasAvailableParklot());
        if (this.j.hasAvailableParklot()) {
            this.c.b(0);
        } else {
            this.c.b(7);
        }
    }

    @Override // defpackage.tv, defpackage.ti, defpackage.tn
    public void a(int i) {
        super.a(i);
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.ITrainingMapReqListener
    public void onTrainingTips(int i, int i2, int[] iArr) {
        Log.i("ParkingPresenterPro", "onTrainingTips.st = " + i + ",tips = " + i2 + ",fail = " + iArr + ",mCurrentTip = " + this.d + ",mCurrentTrainingSt = " + this.p);
        i.a(i.at.class, Integer.valueOf(i2));
        i.a(i.as.class, Integer.valueOf(i));
        h hVar = this.i;
        IntentUtil.onTrainingTipsChange(i2, hVar != null && hVar.j());
        int i3 = this.n;
        if (i3 == 3 || i3 == 7) {
            this.p = i;
            this.q = i2;
            this.r = iArr;
            return;
        }
        if ((this.p != 2 && i == 2) || (this.p != 6 && i == 6)) {
            d(true);
            this.i.h(false);
            this.i.i(3);
            this.i.o(0);
            if (i == 2) {
                rd.a().c(a.g().getString(e.i.tts_start_training));
            } else {
                rd.a().c(a.g().getString(e.i.tts_start_training_after_ap));
            }
            F();
            this.i.a(4);
            i.a(i.ah.class, false);
            this.G = 0;
            this.H = 0;
            this.i.m(this.G);
            if (d.j()) {
                this.i.n(this.H);
            }
            this.i.p(8);
        }
        this.p = i;
        this.q = i2;
        this.r = iArr;
        this.i.a();
        com.xiaopeng.autopilot.base.e eVar = this.t;
        if (eVar != null) {
            eVar.a_(i, i2);
        }
        W();
        switch (i2) {
            case 0:
                int i4 = this.n;
                if (i4 == 1 || i4 == 2) {
                    return;
                }
                IntentUtil.sendInfoFlowCard(0);
                return;
            case 1:
                int i5 = this.n;
                if (i5 == 1 || i5 == 2) {
                    return;
                }
                IntentUtil.sendInfoFlowCard(0);
                return;
            case 2:
                int i6 = this.n;
                if (i6 == 1 || i6 == 2) {
                    return;
                }
                IntentUtil.sendInfoFlowCard(0);
                return;
            case 3:
                int i7 = this.n;
                if (i7 == 1 || i7 == 2) {
                    return;
                }
                IntentUtil.sendInfoFlowCard(0);
                return;
            case 4:
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_READY.mFirstTrainingReady = " + this.z);
                if (this.z && this.i.j() && !this.j.isInNavStartPointProcedure()) {
                    this.z = false;
                    rd.a().a(a.g().getString(e.i.tts_training_ready));
                }
                h hVar2 = this.i;
                if (hVar2 == null || !hVar2.j()) {
                    IntentUtil.sendInfoFlowCard(2);
                }
                this.i.h(8);
                int intValue = ((i.ao) i.a(i.ao.class)).d().intValue();
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_READY.finishType = " + intValue);
                if (this.i.e() && intValue == 1) {
                    this.i.b_(3, this.n);
                    rd.a().h(a.g().getString(e.i.tts_training_fail_learn_ready));
                    return;
                }
                return;
            case 5:
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_CREATE_MAP.mFirstShowMap = " + this.v);
                i.a(i.am.class, true);
                this.i.e(false);
                if (i == 6) {
                    this.i.a(a.g().getString(e.i.training_after_ap_start));
                } else {
                    this.i.a(a.g().getString(e.i.training_start));
                }
                this.i.h(4);
                this.c.d(4);
                if (this.v) {
                    this.v = false;
                    this.X.removeMessages(-2);
                    this.X.sendEmptyMessageDelayed(-2, 100L);
                    return;
                }
                return;
            case 6:
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_HIGH_SPEED.mFirstHighSpeed = " + this.u);
                this.i.e(false);
                this.i.a(a.g().getString(e.i.training_high_speed));
                this.c.d(4);
                if (this.u) {
                    this.u = false;
                    rd.a().a(a.g().getString(e.i.tts_training_too_fast));
                    return;
                }
                return;
            case 7:
                this.i.e(false);
                if (i == 6) {
                    this.i.a(a.g().getString(e.i.training_after_ap_start));
                } else {
                    this.i.a(a.g().getString(e.i.training_start));
                }
                this.c.d(4);
                rd.a().a(a.g().getString(e.i.tts_training_new_start));
                com.xiaopeng.autopilot.base.e eVar2 = this.t;
                if (eVar2 != null) {
                    eVar2.g();
                    return;
                }
                return;
            case 8:
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_THROUGH_SPD.mFirstSpd = " + this.x + ",mSpdCount = " + this.G + "," + this.j.getCurrentTrainingSpdBumpCount());
                this.i.e(false);
                if (i == 6) {
                    this.i.a(a.g().getString(e.i.training_after_ap_start));
                } else {
                    this.i.a(a.g().getString(e.i.training_start));
                }
                this.c.d(4);
                this.G++;
                this.i.m(this.j.getCurrentTrainingSpdBumpCount());
                if (this.G == 2 && this.x) {
                    this.x = false;
                    rd.a().a(a.g().getString(e.i.tts_training_through_spd));
                    return;
                }
                return;
            case 9:
            case 37:
                w();
                rd.a().a(a.g().getString(e.i.tts_training_out_of_limit));
                return;
            case 10:
                w();
                rd.a().a(a.g().getString(e.i.tts_training_cancel));
                return;
            case 11:
                w();
                rd.a().a(a.g().getString(e.i.tts_training_out_of_park));
                return;
            case 12:
                U();
                this.i.f(false);
                i.a(i.aq.class, false);
                this.I = this.j.getCurrentTrainingSpdBumpCount();
                this.J = this.i.getDistance();
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_SAVING_MAP.mFinishDistance = " + this.J + "," + this.I);
                this.i.i(3);
                this.i.a(a.g().getString(e.i.tts_training_saving_tips, new Object[]{Integer.valueOf(this.J)}));
                this.i.e(true);
                this.i.o(8);
                this.c.d(4);
                this.i.e(4);
                rh.a().b(this.Z, 8000L);
                return;
            case 13:
            case 35:
                i.a(i.ap.class, false);
                c(true);
                U();
                boolean booleanValue = ((i.aq) i.a(i.aq.class)).d().booleanValue();
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_SUCCESS.isTrainingBackground = " + booleanValue + "," + this.i.j());
                if (!this.i.j() || booleanValue) {
                    XToast.show(e.i.training_save_success_background);
                    rd.a().a(a.g().getString(e.i.training_save_success_background));
                    G();
                    return;
                }
                L();
                this.X.removeMessages(-7);
                this.X.sendEmptyMessageDelayed(-7, 100L);
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_SUCCESS.mFinishDistance = " + this.J + "," + this.I);
                if (i2 == 13) {
                    rd.a().f(a.g().getString(e.i.tts_training_success));
                    this.i.a(this.J, this.I, this.H, 2);
                } else {
                    rd.a().f(a.g().getString(e.i.tts_training_after_ap_success));
                    this.i.a(this.J, this.I, this.H, 3);
                }
                this.i.o(8);
                SoundPlayer.getInstance().play(e.h.sound_training_success);
                return;
            case 14:
            case 36:
                i.a(i.ap.class, false);
                U();
                c(true);
                G();
                boolean booleanValue2 = ((i.aq) i.a(i.aq.class)).d().booleanValue();
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_FAIL.isTrainingBackground = " + booleanValue2 + "," + this.i.j());
                if (!this.i.j() || booleanValue2) {
                    XToast.show(e.i.training_save_fail_background);
                    rd.a().a(a.g().getString(e.i.training_save_fail_background));
                    return;
                }
                this.i.o(8);
                L();
                this.X.removeMessages(-8);
                this.X.sendEmptyMessageDelayed(-8, 100L);
                ArrayList arrayList = new ArrayList();
                if (iArr[0] == 1) {
                    this.s = 0;
                } else if (iArr[1] == 1) {
                    this.s = 1;
                } else if (iArr[2] == 1) {
                    this.s = 2;
                } else if (iArr[3] == 1) {
                    this.s = 3;
                } else if (iArr[4] == 1) {
                    this.s = 4;
                } else if (iArr[5] == 1) {
                    this.s = 5;
                }
                for (int i8 = 0; i8 < iArr.length; i8++) {
                    if (iArr[i8] == 1) {
                        arrayList.add(Integer.valueOf(i8));
                    }
                }
                if (i2 == 14) {
                    rd.a().f(a.g().getString(e.i.tts_training_fail_other));
                    this.i.a(arrayList, 1);
                    return;
                }
                rd.a().f(a.g().getString(e.i.tts_training_fail_other_after_ap));
                this.i.a(arrayList, 4);
                return;
            case 15:
                this.i.h(8);
                int intValue2 = ((i.ao) i.a(i.ao.class)).d().intValue();
                Log.i("ParkingPresenterPro", "TRAINING_TIPS_START_CONFIRM.finishTypeData = " + intValue2);
                if (this.i.e() && intValue2 == 1) {
                    this.i.b_(3, this.n);
                    rd.a().h(a.g().getString(e.i.tts_training_fail_learn_ready));
                    return;
                }
                return;
            case 16:
            case 17:
            case 23:
            case 24:
            case 25:
            case 27:
            case 30:
            case 32:
            case 33:
            case 34:
            case 38:
            default:
                return;
            case 18:
                rd.a().a(a.g().getString(e.i.tts_training_fail_with_r));
                w();
                return;
            case 19:
                rd.a().a(a.g().getString(e.i.tts_training_fail_with_up_down));
                w();
                this.i.g();
                return;
            case 20:
                rd.a().a(a.g().getString(e.i.tts_training_fail_with_up_down));
                w();
                this.i.g();
                return;
            case 21:
                this.i.b_(1, this.n);
                IntentUtil.sendInfoFlowCard(0);
                c.i();
                return;
            case 22:
                this.i.b_(2, this.n);
                IntentUtil.sendInfoFlowCard(0);
                c.i();
                return;
            case 26:
                rd.a().a(a.g().getString(e.i.tts_training_close_door));
                w();
                return;
            case 28:
                this.i.e(false);
                this.i.a(a.g().getString(e.i.tips_training_limit_on_900));
                this.c.d(4);
                rd.a().a(a.g().getString(e.i.tts_training_limit_on_900));
                return;
            case 29:
                rd.a().a(a.g().getString(e.i.tts_training_fail_circle));
                w();
                return;
            case 31:
                rd.a().a(a.g().getString(e.i.tts_training_tips_25));
                w();
                return;
            case 39:
                rd.a().a(a.g().getString(e.i.tts_training_tips_39));
                return;
            case 40:
                this.i.a(a.g().getString(e.i.tts_training_tips_40));
                rd.a().a(a.g().getString(e.i.tts_training_tips_40));
                return;
            case 41:
                this.H++;
                this.i.n(this.H);
                rd.a().a(a.g().getString(e.i.tts_training_tips_41));
                return;
            case 42:
                rd.a().a(a.g().getString(e.i.tts_training_tips_42));
                w();
                return;
        }
    }

    private void U() {
        rh.a().d(this.Z);
        rh.a().d(this.ab);
        rh.a().d(this.ac);
        rh.a().d(this.ad);
    }

    public void w() {
        Log.i("ParkingPresenterPro", "backToA");
        c(false);
        this.i.l();
        G();
        z();
    }

    public void c(boolean z) {
        Log.i("ParkingPresenterPro", "resetTrainingData");
        i.a(i.ap.class, false);
        this.G = 0;
        this.D = true;
        this.C = true;
        this.E = true;
        this.x = true;
        this.v = true;
        this.u = true;
        if (z) {
            this.z = true;
        }
        i.a(i.am.class, false);
    }

    public void x() {
        Log.i("ParkingPresenterPro", "resetAPDistance");
        this.K = -1.0f;
        this.M = 0;
        this.N = 0;
        this.H = 0;
    }

    public void y() {
        Log.i("ParkingPresenterPro", "clearMapData");
        this.j.clearMapData();
    }

    public void z() {
        Log.i("ParkingPresenterPro", "onCurrentTips");
        m(this.d);
        super.a(this.f, this.d);
    }

    public int A() {
        return this.q;
    }

    public void n(int i) {
        this.j.routeAp2SrTrainingCmd(i);
    }

    public void d(boolean z) {
        this.j.setIsStartTraining(z);
    }

    public boolean B() {
        int i = this.p;
        return (i == 2 || i == 3 || i == 6) && this.j.isStartTraining();
    }

    public boolean C() {
        int i = this.p;
        return i == 4 || i == 5;
    }

    public float D() {
        return this.j.getStartTrainingS();
    }

    public float E() {
        return this.j.getCurrentS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.tv
    public void a(Bundle bundle) {
        boolean booleanValue = ((i.f) i.a(i.f.class)).d().booleanValue();
        Log.i("ParkingPresenterPro", "exitAutopilot.isStartTraining = " + B() + ", " + booleanValue);
        if (B() || booleanValue) {
            return;
        }
        super.a(bundle);
    }

    public void a(com.xiaopeng.autopilot.base.e eVar) {
        this.t = eVar;
    }

    public void F() {
        Log.i("ParkingPresenterPro", "onStartTraining.mTrainingStartListener = " + this.t);
        this.I = 0;
        this.J = 0;
        com.xiaopeng.autopilot.base.e eVar = this.t;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void G() {
        this.A = false;
        this.S = true;
        d(false);
        Log.i("ParkingPresenterPro", "onEndTraining.mFinishSpdCount = " + this.I + ",mFinishDistance = " + this.J);
        com.xiaopeng.autopilot.base.e eVar = this.t;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // com.xiaopeng.autopilot.parking.model.IParkingModelPro.IXpuShowToastListener
    public void onShowToast(final int i) {
        if (d.c()) {
            rh.a().b(new Runnable() { // from class: tw.5
                @Override // java.lang.Runnable
                public void run() {
                    XToast.showLong(i);
                }
            });
        }
    }

    private void t(int i) {
        if (i == 3) {
            if (this.af == 2) {
                p(-14);
            } else {
                o(-16);
            }
        } else if (this.af == 2) {
            p(-14);
        } else {
            o(-15);
        }
    }

    @Override // defpackage.tv, defpackage.ti
    public void f(int i) {
        super.f(i);
        if (this.j.isInNavStartPointProcedure()) {
            org.greenrobot.eventbus.c.a().d(new TrainingNavGearUpdateEvent(i));
        }
        boolean B = B();
        int intValue = ((i.y) i.a(i.y.class)).d().intValue();
        Log.i("ParkingPresenterPro", "onGearChange.page = " + intValue + ",isTrainingAPPageVisible = " + this.i.i() + "," + B);
        if (i != 3) {
            if (i == 1) {
                this.i.l();
                if (intValue == 3 || intValue == 5) {
                    this.i.d(false);
                    d.e(1);
                }
                if (B) {
                    if (this.n != 6) {
                        this.i.a(a.g().getString(e.i.start_parking), false, false, "");
                        o(-2);
                        if (this.p == 6) {
                            this.i.a(a.g().getString(e.i.training_after_ap_start));
                        } else {
                            this.i.a(a.g().getString(e.i.training_start));
                        }
                    } else {
                        this.i.a(a.g().getString(e.i.tips_training_parking_b));
                    }
                } else if (this.j.isInNavStartPointProcedure() && this.n < 2) {
                    LogUtils.i("ParkingPresenterPro", "isInNavStartPointProcedure in Gear D");
                    K();
                    if (this.ag != 10) {
                        t(i);
                    }
                }
                if (this.A) {
                    this.A = false;
                    if (this.i.i()) {
                        rh.a().b(this.Y, 1500L);
                        return;
                    } else if (B()) {
                        this.B = true;
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (B) {
                if (this.d > 18 && this.d != 35) {
                    o(-2);
                    this.i.a(a.g().getString(e.i.start_parking), false, false, "");
                }
                if (((i.ap) i.a(i.ap.class)).d().booleanValue()) {
                    Log.i("ParkingPresenterPro", "training has parking b");
                    if (this.d == 6 || this.f == 6) {
                        return;
                    }
                    i.a(i.ap.class, false);
                }
                if (i == 4) {
                    this.A = false;
                    if (this.p == 2 && this.d != 13 && this.d != 4) {
                        i.a(i.ap.class, false);
                    }
                    if (this.p == 2 && this.d != 13 && this.d != 4 && this.d != 5 && this.d != 35) {
                        this.i.k();
                        this.i.a(a.g().getString(e.i.training_with_p));
                        if (this.C) {
                            this.C = false;
                            rd.a().a(a.g().getString(e.i.tts_training_with_p));
                            return;
                        }
                        return;
                    } else if (this.p == 6) {
                        this.i.k();
                        i.a(i.ap.class, false);
                        if (this.C) {
                            this.C = false;
                            rd.a().a(a.g().getString(e.i.tts_training_with_p_after_ap));
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } else if (!this.j.isInNavStartPointProcedure() || this.n >= 2) {
                return;
            } else {
                LogUtils.i("ParkingPresenterPro", "isInNavStartPointProcedure in Gear other");
                K();
                if (this.ag != 10) {
                    t(i);
                    return;
                }
                return;
            }
        }
        this.i.l();
        NavStartGuideDialogUtil.dissmissDialog();
        if (this.i.i()) {
            rh.a().e(this.Y);
            this.i.d(false);
            this.i.a(0);
            J();
            if (this.j.isInNavStartPointProcedure()) {
                if (this.n < 2 && this.ag != 10) {
                    t(i);
                }
                org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(16));
            }
            this.i.i(1);
            if (intValue != 3 && intValue != 5 && intValue != 1 && intValue != 6 && intValue != 7) {
                this.i.p(0);
                this.A = true;
            } else if (this.j.isInNavStartPointProcedure()) {
            } else {
                super.m(this.d);
                super.a(this.f, this.d);
            }
        } else if (B) {
            this.A = true;
            boolean z = V() && this.p == 2;
            Log.i("ParkingPresenterPro", "onGearChange.trainingHasAvailable = " + z + "," + this.d + "," + this.S);
            if (z) {
                if (this.d == 22) {
                    this.i.a(a.g().getString(e.i.start_parking), true, true, a.g().getString(e.i.training_select_park_lots));
                    this.i.b(0);
                    c.e(0);
                    o(-9);
                } else if (this.d == 20 || this.d == 23) {
                    this.i.a(a.g().getString(e.i.start_parking), true, false, a.g().getString(e.i.training_has_park_lots));
                    o(-9);
                }
            }
            rh.a().d(this.Y);
            this.i.p(8);
            J();
            if (this.d > 18 && this.d != 34 && this.S && z) {
                i.a(i.an.class, true);
                this.S = false;
                c.t();
            }
            if (B && this.p == 2) {
                if (z) {
                    if (this.d == 22 || this.d == 20 || this.d == 23) {
                        this.i.a(a.g().getString(e.i.training_in_ready_text_tts));
                        if (this.E) {
                            this.E = false;
                            rd.a().a(a.g().getString(e.i.training_in_ready_text_tts));
                        }
                    } else if (this.n == 6) {
                        this.i.a(a.g().getString(e.i.tips_training_parking_b));
                    } else {
                        this.i.a(a.g().getString(e.i.training_with_r));
                        if (this.D) {
                            this.D = false;
                            rd.a().a(a.g().getString(e.i.tts_training_with_r));
                        }
                    }
                } else if (this.n == 6) {
                    this.i.a(a.g().getString(e.i.tips_training_parking_b));
                } else {
                    this.i.a(a.g().getString(e.i.training_with_r));
                    if (this.D) {
                        this.D = false;
                        rd.a().a(a.g().getString(e.i.tts_training_with_r));
                    }
                }
            }
        }
    }

    private boolean V() {
        List<b.w> slotIdMappingList = this.j.getSlotIdMappingList();
        boolean z = false;
        if (slotIdMappingList != null && slotIdMappingList.size() > 0) {
            z = true;
        }
        Log.i("ParkingPresenterPro", "canShowTrainingAPA.trainingHasAvailable = " + z + "," + slotIdMappingList);
        return z;
    }

    @Override // defpackage.tv, defpackage.ti, defpackage.tn
    public void a(float f) {
        super.a(f);
        if (f > 10.0f) {
            if (this.B) {
                this.B = false;
                if (B()) {
                    K();
                }
            }
            if (!B() || this.S) {
                return;
            }
            this.S = true;
            i.a(i.an.class, false);
            c.u();
        }
    }

    public void H() {
        this.A = false;
        c(true);
        U();
        this.i.p(8);
    }

    public int I() {
        return this.n;
    }

    public void J() {
        Log.i("ParkingPresenterPro", "onAnimatorLeft");
        d.e(1);
    }

    public void K() {
        Log.i("ParkingPresenterPro", "onAnimatorRight");
        d.e(2);
    }

    public void L() {
        Log.i("ParkingPresenterPro", "onAnimatorMiddle");
        d.e(3);
    }

    private void W() {
        org.greenrobot.eventbus.c.a().d(new CameraXPilotEvent(this.n));
    }

    @Override // defpackage.tv, defpackage.ti
    public void g(int i) {
        final int parkLotNum;
        if (!re.a().h() || (parkLotNum = this.j.getParkLotNum()) <= 0) {
            return;
        }
        re.a().a(parkLotNum, new re.b() { // from class: tw.6
            @Override // defpackage.re.b
            public boolean a(int i2) {
                return i2 < parkLotNum && i2 >= 0;
            }
        }, i);
    }

    public void o(int i) {
        this.X.removeMessages(i);
        this.X.sendEmptyMessageDelayed(i, 100L);
    }

    public void p(int i) {
        this.X.removeMessages(i);
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = 1;
        this.X.sendMessageDelayed(obtain, 100L);
    }

    public void q(final int i) {
        rh.a().c(new Runnable() { // from class: tw.7
            @Override // java.lang.Runnable
            public void run() {
                if (i == 2) {
                    Log.i("ParkingPresenterPro", "onMapPosState.mIsHdMap = " + tw.this.P);
                    tw.this.R = false;
                    tw.this.O = true;
                    tw.this.W = true;
                    if (tw.this.i == null || !tw.this.i.j() || tw.this.n == 2 || ((i.ao) i.a(i.ao.class)).d().intValue() == 1 || tw.this.P != 0 || tw.this.j.isStartTraining()) {
                        return;
                    }
                    rd.a().a(a.g().getString(e.i.tts_map_pos_ready));
                }
            }
        });
    }

    public void b(int i, int i2) {
        this.P = i2;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (!this.j.isInNavStartPointProcedure()) {
            if (i == 12 || i == 13) {
                if (this.ag != i) {
                    LogUtils.d("ParkingPresenterPro", "onNavTipsUpdate route 4");
                    N();
                    org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(8));
                    NavStartGuideDialogUtil.dissmissDialog();
                    XToast.show(g[i]);
                    String format = String.format(h[i], Integer.valueOf(i2));
                    if (!TextUtils.isEmpty(format) && this.ag != i) {
                        b(format);
                    }
                    rh.a().a(new Runnable() { // from class: tw.9
                        @Override // java.lang.Runnable
                        public void run() {
                            tw.this.o(2);
                        }
                    }, 200L);
                    if (i == 12) {
                        XToast.show(e.i.nav_fail_tips_missed);
                    }
                    if (i == 3) {
                        XToast.show(e.i.nav_fail_tips);
                    }
                }
                this.ag = i;
                return;
            }
            return;
        }
        if ((i >= 1 && i <= 9) || (i >= 14 && i <= 21)) {
            String str = g[i];
            String format2 = String.format(h[i], Integer.valueOf(i2));
            TextUtils.isEmpty(str);
            if (!TextUtils.isEmpty(format2) && this.ag != i) {
                b(format2);
            }
            if (this.ag != i || i2 != this.ah || i3 != this.ai || this.aj != i4) {
                org.greenrobot.eventbus.c.a().d(new TrainingNavStartTipUpdateEvent(i, i2, i3, i4));
                this.ah = i2;
                this.ai = i3;
                this.aj = i4;
            }
        } else if (i == 10) {
            if (this.ag != i) {
                LogUtils.d("ParkingPresenterPro", "onNavTipsUpdate route 2");
                N();
                M();
            }
        } else if (i == 11) {
            if (this.ag != i) {
                LogUtils.d("ParkingPresenterPro", "onNavTipsUpdate route 3");
                if (this.ag == 10) {
                    org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(8));
                } else {
                    N();
                }
                XToast.show(e.i.nav_fail_tips);
                rd.a().a(String.format(h[i], Integer.valueOf(i2)));
                o(2);
            }
        } else if ((i == 12 || i == 13) && this.ag != i) {
            LogUtils.d("ParkingPresenterPro", "onNavTipsUpdate route 4");
            N();
            org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(8));
            XToast.show(g[i]);
            String format3 = String.format(h[i], Integer.valueOf(i2));
            if (!TextUtils.isEmpty(format3) && this.ag != i) {
                b(format3);
            }
            rh.a().a(new Runnable() { // from class: tw.8
                @Override // java.lang.Runnable
                public void run() {
                    tw.this.o(2);
                }
            }, 200L);
            if (i == 12) {
                XToast.show(e.i.nav_fail_tips_missed);
            }
            if (i == 3) {
                XToast.show(e.i.nav_fail_tips);
            }
        }
        if (this.af != i5) {
            LogUtils.i("ParkingPresenterPro", "hill state change from:" + this.af + " to " + i5);
            if (this.j.isInNavStartPointProcedure() && this.n < 2) {
                u(i5);
            }
            this.af = i5;
        }
        this.ag = i;
        if (this.ag == 9) {
            c.a(false);
        } else {
            c.a(true);
        }
    }

    private void b(String str) {
        if (!this.j.isInNavStartPointProcedure() || CarApiUtil.getGear() == 3) {
            return;
        }
        rd.a().a(str);
    }

    private void u(int i) {
        LogUtils.i("ParkingPresenterPro", "updateHillState:" + i);
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(15, Integer.valueOf(i)));
        if (i == 2) {
            rh.a().c(new Runnable() { // from class: tw.10
                @Override // java.lang.Runnable
                public void run() {
                    tw.this.p(-14);
                }
            });
        } else {
            rh.a().c(new Runnable() { // from class: tw.11
                @Override // java.lang.Runnable
                public void run() {
                    if (CarApiUtil.getGear() == 3) {
                        tw.this.p(-16);
                    } else {
                        tw.this.p(-15);
                    }
                }
            });
        }
    }

    public void M() {
        rh.a().c(new Runnable() { // from class: tw.13
            @Override // java.lang.Runnable
            public void run() {
                tw.this.i.o();
                if (tw.this.O) {
                    tw.this.O = false;
                }
                rd.a().h(a.g().getString(e.i.tts_ap_ready_with_learn));
            }
        });
        ((i.k) i.a(i.k.class)).a(false);
    }

    public void r(int i) {
        ((i.k) i.a(i.k.class)).a(true);
        this.j.resetNavStateWhenStart();
        LogUtils.i("ParkingPresenterPro", "forward2NavStartPage:" + i);
        IntentUtil.sendCloseInfoFlowCard();
        this.X.removeMessages(-15);
        this.X.removeMessages(-16);
        if (CarApiUtil.getGear() == 3) {
            this.X.sendEmptyMessageDelayed(-16, 100L);
        } else {
            this.X.sendEmptyMessageDelayed(-15, 100L);
        }
        this.ag = -1;
        this.aj = -1;
        this.ah = -1;
        this.ai = -1;
        this.af = -1;
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(13, Integer.valueOf(i)));
        h hVar = this.i;
        if (hVar != null) {
            hVar.a();
        }
        rh.a().a(new Runnable() { // from class: tw.14
            @Override // java.lang.Runnable
            public void run() {
                if (CarApiUtil.getGear() == 3) {
                    d.e(1);
                } else {
                    d.e(2);
                }
            }
        }, 200L);
    }

    public void N() {
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(14));
        o(2);
    }

    @m(a = ThreadMode.ASYNC)
    public void onSendCloseNavCommand(NavClose4APReadyEvent navClose4APReadyEvent) {
        if (this.j.isInNavStartPointProcedure()) {
            abg.a().c();
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onCloseNavStart(NavStartCloseEvent navStartCloseEvent) {
        abg.a().c();
        org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(14));
        o(2);
    }

    public void O() {
        this.j.routeAp2SrMapReq();
    }

    @m(a = ThreadMode.MAIN)
    public void onEvent(SpeechSuperParkEvent speechSuperParkEvent) {
        if (speechSuperParkEvent.action == 4) {
            c.a(1);
            this.z = false;
        } else if (speechSuperParkEvent.action == 5) {
            Q();
        } else if (speechSuperParkEvent.action == 6) {
            R();
        } else if (speechSuperParkEvent.action == 7) {
            org.greenrobot.eventbus.c.a().d(new TrainingPageEvent(9));
        }
    }

    public void P() {
        this.j.startFoundParkLot();
    }

    public void Q() {
        Log.i("ParkingPresenterPro", "continueFoundParkLot.mCanContinueSearchParkLots = " + this.U);
        if (!this.U) {
            XToast.show(e.i.ap_founded_park_lot_arrive_favorite);
        } else if (this.n == 7) {
            o(-12);
            this.j.continueFoundParkLot();
            rd.a().a(a.g().getString(e.i.tts_ap_start_found_park_lot));
        }
    }

    public void R() {
        if (this.n == 7) {
            this.j.exitFoundParkLot();
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onSendNavInfoflowOnExit(rb rbVar) {
        ApMapBean apMapBean = this.j.getApMapBean();
        IntentUtil.sendNavStartFlowCard(apMapBean != null ? apMapBean.getMapType() : 4);
    }

    public boolean S() {
        return this.j.isInNavStartPointProcedure();
    }

    public void T() {
        this.ag = -1;
        this.af = -1;
    }
}
