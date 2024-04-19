package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.gson.GsonBuilder;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.bean.eventbus.CarConditionVcuSpeedEvent;
import com.xiaopeng.autopilot.base.c;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.EcuErrorDialogUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.NedcDialogUtil;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.parking.bean.candata.ParkingProcessData;
import com.xiaopeng.autopilot.parking.bean.draw.ParkLotItem;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.autopilot.parking.model.FavorPosEvent;
import com.xiaopeng.autopilot.parking.model.IParkingModel;
import com.xiaopeng.autopilot.parking.model.ParkingModel;
import com.xiaopeng.autopilot.parking.utils.JniUtil;
import com.xiaopeng.autopilot.parking.view.ParkingViewContainer;
import com.xiaopeng.autopilot.x.protocol.bean.gson.FavorPos;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IScuController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IVcuController;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import defpackage.re;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* compiled from: ParkingPresenter.java */
/* renamed from: tv  reason: default package */
/* loaded from: classes.dex */
public class tv extends ti {
    protected static final String[] a = a.g().getResources().getStringArray(e.a.array_auto_parking);
    private static final String[] g = a.g().getResources().getStringArray(e.a.array_toast_super_park);
    protected IParkingModel b;
    protected ParkingViewContainer c;
    private boolean m;
    private boolean n;
    private GsonBuilder w;
    private Context h = a.g().getApplicationContext();
    private boolean i = false;
    private int j = 4;
    private float k = 0.0f;
    private float l = 0.0f;
    protected int d = -1;
    protected volatile int e = 0;
    protected int f = 0;
    private float o = -1.0f;
    private Handler p = new Handler(Looper.getMainLooper()) { // from class: tv.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            if (tv.this.c == null) {
                return;
            }
            int i = message.what;
            switch (i) {
                case 0:
                    if (d.c()) {
                        LogUtils.i("ParkingPresenter", "MSG_SURFACE_UPDATE_CLEAR");
                    }
                    tv.this.c.h(0);
                    return;
                case 1:
                    if (d.c()) {
                        LogUtils.i("ParkingPresenter", "MSG_SURFACE_UPDATE_PARKING_B");
                    }
                    if ((tv.this.d != 13 && tv.this.d != 14) || tv.this.e <= 0) {
                        tv.this.c.b(0);
                    }
                    tv.this.c.h(1);
                    return;
                case 2:
                    if (d.c()) {
                        LogUtils.i("ParkingPresenter", "MSG_SURFACE_UPDATE_SUPER_PARK_SEARCHING");
                    }
                    tv.this.c.h(2);
                    return;
                case 3:
                    if (d.c()) {
                        LogUtils.i("ParkingPresenter", "MSG_SURFACE_UPDATE_SUPER_PARK_IN_READY");
                    }
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    if (i3 == 23) {
                        tv.this.c.h(3);
                        return;
                    } else if (i3 == 22) {
                        tv.this.b(i2, i3);
                        tv.this.c.h(3);
                        if (re.a().h()) {
                            tv.this.g(-1);
                            return;
                        }
                        return;
                    } else {
                        tv.this.b(i2, i3);
                        tv.this.c.h(3);
                        return;
                    }
                case 4:
                    if (d.c()) {
                        LogUtils.i("ParkingPresenter", "MSG_SURFACE_UPDATE_OUT_SLOT_READY");
                    }
                    tv.this.c.h(4);
                    return;
                case 5:
                    re.a().i();
                    return;
                default:
                    switch (i) {
                        case 21:
                            tv.this.p.removeMessages(22);
                            tv.this.p.removeMessages(24);
                            int i4 = message.arg1;
                            if (d.c()) {
                                LogUtils.i("ParkingPresenter", "MSG_PARSE_TIP_UI_UPDATE.tip = " + i4);
                            }
                            tv.this.m(i4);
                            tv tvVar = tv.this;
                            tvVar.a(tvVar.f, i4);
                            tv.this.f = i4;
                            return;
                        case 22:
                            if (d.c()) {
                                LogUtils.i("ParkingPresenter", "MSG_RESET_CLOSE_BTN , 3秒后tips没变化,关闭按钮复位可点击");
                            }
                            tv.this.c.a(true);
                            tv.this.c.d();
                            return;
                        case 23:
                            if (d.c()) {
                                LogUtils.i("ParkingPresenter", "MSG_RESET_CLCIK_CMD , 3秒后速度没变化,还原点击state");
                            }
                            i.a(i.m.class, false);
                            return;
                        case 24:
                            if (d.c()) {
                                LogUtils.i("ParkingPresenter", "MSG_RESET_CAN_CHOSE_SLOT , 3秒后tips没变化,复位可选车位");
                            }
                            tv.this.c.e(true);
                            return;
                        default:
                            switch (i) {
                                case 31:
                                    int i5 = message.arg1;
                                    if (i5 > 0 && i5 < tv.g.length && d.c(i5)) {
                                        str = tv.g[i5];
                                        tv.this.c.a(str, -1);
                                    } else {
                                        str = tv.a[tv.this.f];
                                        tv.this.c.a(str, -1);
                                    }
                                    if (d.c()) {
                                        LogUtils.i("ParkingPresenter", "MSG_PARK_ATTR_ERROR_A_UPDATE , tips =" + tv.this.f + " ，超级泊车异常AVM_Slot_Attr = " + i5 + " ， " + str);
                                        return;
                                    }
                                    return;
                                case 32:
                                    int i6 = message.arg1;
                                    if (i6 > 0 && i6 < tv.g.length && d.b(i6)) {
                                        str2 = tv.g[i6];
                                        tv.this.c.a(str2, -1);
                                        tv.this.c.a(tv.this.h.getString(e.i.continue_park), 0, tv.this.s, true);
                                    } else {
                                        str2 = tv.a[tv.this.f];
                                        tv.this.c.a(str2, -1);
                                        tv.this.c.a(tv.this.h.getString(e.i.continue_park), 0, tv.this.s, false);
                                    }
                                    if (d.c()) {
                                        LogUtils.i("ParkingPresenter", "MSG_PARK_ATTR_ERROR_B_PAUSE_IN_UPDATE , tips =" + tv.this.f + " ，超级泊车异常AVM_Slot_Attr = " + i6 + " ， " + str2);
                                        return;
                                    }
                                    return;
                                case 33:
                                    int i7 = message.arg1;
                                    if (i7 > 0 && i7 < tv.g.length && d.b(i7)) {
                                        str3 = tv.g[i7];
                                        tv.this.c.a(str3, -1);
                                        tv.this.c.a(tv.this.h.getString(e.i.continue_park_out), 0, tv.this.t, true);
                                    } else {
                                        str3 = tv.a[tv.this.f];
                                        tv.this.c.a(str3, -1);
                                        tv.this.c.a(tv.this.h.getString(e.i.continue_park_out), 0, tv.this.t, false);
                                    }
                                    if (d.c()) {
                                        LogUtils.i("ParkingPresenter", "MSG_PARK_ATTR_ERROR_UPDATE , tips =" + tv.this.f + " ，超级泊车异常AVM_Slot_Attr = " + i7 + " ， " + str3);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
    };
    private View.OnClickListener q = new View.OnClickListener() { // from class: tv.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtils.i("ParkingPresenter", "onClick ---> 泊入开始");
            tv.this.a(true);
            tv.this.c.c();
            c.a().i().statisStartAutopilot(false, false);
        }
    };
    private View.OnClickListener r = new View.OnClickListener() { // from class: tv.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtils.i("ParkingPresenter", "onClick ---> 泊出开始");
            tv.this.b(true);
            tv.this.c.c();
            c.a().i().statisStartAutopilot(false, false);
        }
    };
    private View.OnClickListener s = new View.OnClickListener() { // from class: tv.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtils.i("ParkingPresenter", "onClick ---> 泊入继续");
            tv.this.b();
            c.a().i().statisGoOn();
        }
    };
    private View.OnClickListener t = new View.OnClickListener() { // from class: tv.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtils.i("ParkingPresenter", "onClick ---> 泊出继续");
            tv.this.a();
            c.a().i().statisGoOn();
        }
    };
    private View.OnClickListener u = new View.OnClickListener() { // from class: tv.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtils.i("ParkingPresenter", "onClick ---> 泊入取消");
            tv.this.a(false);
            c.a().i().statisExit();
        }
    };
    private View.OnClickListener v = new View.OnClickListener() { // from class: tv.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtils.i("ParkingPresenter", "onClick ---> 泊出取消");
            tv.this.b(false);
            c.a().i().statisExit();
        }
    };

    public tv(ParkingViewContainer parkingViewContainer) {
        this.c = parkingViewContainer;
        if (parkingViewContainer != null) {
            parkingViewContainer.a(this);
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        this.b = new ParkingModel(this);
        this.b.init();
        org.greenrobot.eventbus.c.a().a(this);
        if (d.f()) {
            this.c.a(a.g().getString(e.i.parking_tips_27_reversing), -1);
        }
    }

    @Override // defpackage.ti, defpackage.tn
    public void a(boolean z) {
        if (z) {
            k();
            l();
            m();
        }
        CarApiUtil.autoParkInByXMart(z);
    }

    @Override // defpackage.ti
    public void b(boolean z) {
        CarApiUtil.autoParkOutByXMart(z);
        if (z) {
            k();
            l();
        }
    }

    @Override // defpackage.ti
    public void a() {
        CarApiUtil.autoParkOutContinueByXMart();
    }

    @Override // defpackage.ti
    public void b() {
        CarApiUtil.autoParkInContinueByXMart();
    }

    @Override // defpackage.ti, defpackage.tn
    public void a(int i) {
        CarApiUtil.sendParkLotChose(i);
    }

    @Override // defpackage.tn
    public ArrayList<ParkLotItem> d() {
        IParkingModel iParkingModel = this.b;
        if (iParkingModel == null) {
            return null;
        }
        return new ArrayList<>(iParkingModel.getParkLotItemList());
    }

    @Override // defpackage.ti
    public void b(int i) {
        Message obtain = Message.obtain();
        obtain.what = 21;
        obtain.arg1 = i;
        this.p.sendMessage(obtain);
    }

    @Override // defpackage.ti
    public void c(int i) {
        Message obtain = Message.obtain();
        obtain.what = 31;
        obtain.arg1 = i;
        this.p.sendMessage(obtain);
    }

    @Override // defpackage.ti
    public void d(int i) {
        Message obtain = Message.obtain();
        obtain.what = 32;
        obtain.arg1 = i;
        this.p.sendMessage(obtain);
    }

    @Override // defpackage.ti
    public void e(int i) {
        Message obtain = Message.obtain();
        obtain.what = 33;
        obtain.arg1 = i;
        this.p.sendMessage(obtain);
    }

    @Override // defpackage.ti
    public void j(int i) {
        this.c.f(i);
    }

    @Override // defpackage.tn
    public int e() {
        return this.d;
    }

    @Override // defpackage.tn
    public int f() {
        return this.e;
    }

    @Override // defpackage.ti
    public void i(int i) {
        this.c.g(i);
    }

    @Override // defpackage.ti
    public void h(int i) {
        this.c.f(i);
    }

    @Override // defpackage.ti
    public void a(float f, float f2) {
        this.c.a(f, f2);
    }

    @Override // defpackage.tn
    public void c(float f) {
        this.o = f;
    }

    @Override // defpackage.ti, defpackage.tn
    public void a(float f) {
        if (d.c()) {
            Log.i("ParkingPresenter", "onCurrentSpeedUpdate.speed = " + f);
        }
        this.c.a(f);
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(CarConditionVcuSpeedEvent carConditionVcuSpeedEvent) {
        Log.i("ParkingPresenter", "receive CarConditionVcuSpeedEvent !");
        float f = carConditionVcuSpeedEvent.mValue;
        i.af afVar = (i.af) i.a(i.af.class);
        i.x xVar = (i.x) i.a(i.x.class);
        StringBuilder sb = new StringBuilder();
        sb.append("isSwitchReversingHold() = ");
        sb.append(d.b());
        sb.append(", !isSuperParkActiveValue = ");
        sb.append(!xVar.d().booleanValue());
        sb.append(", (speed >= 10) =  ");
        int i = (f > 10.0f ? 1 : (f == 10.0f ? 0 : -1));
        sb.append(i >= 0);
        sb.append(", mGearLev = ");
        sb.append(this.j);
        Log.i("ParkingPresenter", sb.toString());
        if (!d.b() || xVar.d().booleanValue() || !afVar.d().booleanValue() || i < 0) {
            return;
        }
        int i2 = this.j;
        if (i2 == 1 || i2 == 2) {
            IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK");
            LogUtils.i("ParkingPresenter", "D挡，速度大于10，关闭倒车界面");
        }
    }

    protected void i() {
        this.c.c(true);
    }

    @Override // defpackage.ti
    public void f(int i) {
        this.c.c(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:103:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(int r11) {
        /*
            Method dump skipped, instructions count: 1944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tv.m(int):void");
    }

    private void a(String str, boolean z) {
        i.s sVar = (i.s) i.a(i.s.class);
        i.s.a d = sVar.d();
        boolean z2 = d.a;
        boolean z3 = d.b;
        Log.i("ParkingPresenter", "isPlayFindVehicel :\t" + z2 + "\tisStartPark:" + z3);
        if (z && !z2) {
            a(str);
            sVar.e();
        }
        if (z || z3) {
            return;
        }
        a(str);
        sVar.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        rd.a().a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2) {
        if (d.c() || !d.n()) {
            Log.i("ParkingPresenter", "trySurfaceUpdate.lastTip = " + i + ",currentTip = " + i2);
        }
        if (re.a().h() && i == 22) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            this.p.sendMessageDelayed(obtain, 100L);
        }
        if (i2 == 1 || i2 == 16 || i2 == 22 || i2 == 23) {
            Message obtain2 = Message.obtain();
            obtain2.what = 3;
            obtain2.arg1 = i;
            obtain2.arg2 = i2;
            if (i2 == 23) {
                this.p.sendMessageDelayed(obtain2, 100L);
                this.c.e(false);
                return;
            }
            this.p.sendMessageDelayed(obtain2, 100L);
            this.c.e(true);
        } else if (i2 == 15) {
            this.p.sendEmptyMessageDelayed(4, 100L);
            this.c.e(false);
            this.c.b(0);
        } else if (i2 == 0 || i2 == 17 || i2 == 27 || i2 == 24 || i2 == 36) {
            if ((i2 == 24 || i2 == 36) && i == 20) {
                this.p.sendEmptyMessageDelayed(0, 100L);
            } else {
                this.p.removeMessages(3);
                this.p.sendEmptyMessage(0);
            }
            this.c.e(false);
            this.c.b(7);
        } else if (i2 == 18 || i2 == 19 || i2 == 20 || i2 == 21) {
            this.p.sendEmptyMessageDelayed(2, 100L);
            this.c.e(false);
            this.c.b(7);
        } else if (i2 != 25) {
            if (i2 == 2 || i2 == 12) {
                this.p.sendEmptyMessageDelayed(1, 100L);
            } else {
                this.p.sendEmptyMessageDelayed(1, 100L);
            }
            this.c.e(false);
        } else if ((i2 == 24 || i2 == 36) && i == 1) {
            a(i2, 17);
        } else if (i != 25) {
            a(i, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        if (i != 23) {
            j();
        } else if (this.c.getParkLotChoseIndex() == 7) {
            j();
        }
    }

    protected void j() {
        if (this.b.getParkLotHighNum() > 0 || this.b.getParkLotNarrowNum() > 0) {
            LogUtils.i("ParkingPresenter", "含有非低置信车位，选中index=0");
            this.c.b(0);
            return;
        }
        LogUtils.i("ParkingPresenter", "不含非低置信车位，默认不选中");
        this.c.b(7);
    }

    @Override // defpackage.ti
    public void g(int i) {
        final int parkLotNum;
        if (!re.a().h() || (parkLotNum = this.b.getParkLotNum()) <= 0) {
            return;
        }
        re.a().a(parkLotNum, new re.b() { // from class: tv.2
            @Override // defpackage.re.b
            public boolean a(int i2) {
                return i2 < parkLotNum && i2 >= 0;
            }
        }, i);
    }

    @Override // defpackage.ti, defpackage.tn
    public boolean c() {
        return this.i;
    }

    @Override // defpackage.tn
    public void l(int i) {
        n(i);
        if (i != this.d) {
            b(i);
        }
        if (i != this.d) {
            if (i == 5 || i == 35) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDelayCheckR", true);
                bundle.putLong("delayCheckRTime", 4000L);
                a(bundle);
                c.a().i().statisParkingError();
            } else if (i == 6 || i == 11) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("isDelayCheckR", true);
                bundle2.putLong("delayCheckRTime", 3500L);
                a(bundle2);
                c.a().i().statisParkingSuccess(i == 6 ? "0" : BuildInfoUtils.BID_WAN);
            } else if (i == 7 || i == 10) {
                a((Bundle) null);
            }
            ((i.ac) i.a(i.ac.class)).a(i);
        }
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bundle bundle) {
        Log.i("ParkingPresenter", "exitAutopilot.bundle = " + bundle);
        IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK", bundle);
    }

    private void n(int i) {
        if (d.c()) {
            Log.i("progressbar", "tip:\t" + i + "\t current" + this.d);
        }
        if (i != this.d) {
            if (i == 4 || i == 9 || i == 13 || i == 14 || i == 26) {
                h(i);
            } else if (i == 3 || i == 34 || i == 33 || i == 8 || i == 2 || i == 12) {
                i(i);
            } else if (i == 5 || i == 35) {
                j(i);
            }
        }
    }

    @Override // defpackage.ti, defpackage.tn
    public void k(int i) {
        if (i != this.e) {
            i.a(i.z.class, Integer.valueOf(i));
            c(i, this.e);
            int i2 = this.d;
            if (i2 == 21) {
                c(i);
            } else if (i2 == 13) {
                d(i);
            } else if (i2 == 14) {
                e(i);
            }
            LogUtils.i("ParkingPresenter", "onResponeParseErrorTips() 泊车状态异常提示 = " + i);
            this.e = i;
        }
    }

    private void c(int i, int i2) {
        int i3 = this.d;
        if (i3 == 13 || i3 == 14) {
            i.ac acVar = (i.ac) i.a(i.ac.class);
            if (i == 21 && i2 != 21) {
                c.a().i().statisBrakeState(2, this.d, acVar.d().intValue());
            } else if (i == 21 || i2 != 21) {
            } else {
                c.a().i().statisBrakeState(1, this.d, acVar.d().intValue());
            }
        }
    }

    @Override // defpackage.ti, defpackage.tn
    public void b(float f) {
        if (this.l != f) {
            float abs = Math.abs(f);
            if (this.l == 0.0f && abs > 0.0f) {
                if (d.c()) {
                    LogUtils.i("ParkingPresenter", "动起来，车速从 " + this.l + " -> " + abs);
                }
                i.m mVar = (i.m) i.a(i.m.class);
                if (!c() && mVar.d().booleanValue()) {
                    if (d.c()) {
                        LogUtils.i("ParkingPresenter", "车动起来(此时，在A过程，点击过热区)，, 移除MSG_RESET_CLCIK_CMD任务");
                    }
                    this.p.removeMessages(23);
                } else {
                    if (d.c()) {
                        LogUtils.i("ParkingPresenter", "车动起来(此时，在B过程 或者 没点击过热区)，移除MSG_RESET_CLCIK_CMD任务");
                    }
                    this.p.removeMessages(23);
                    mVar.a(false);
                }
            } else if (this.l > 0.0f && abs == 0.0f) {
                if (d.c()) {
                    LogUtils.i("ParkingPresenter", "拖刹车，车速从 " + this.l + " -> " + abs);
                }
                i.aa aaVar = (i.aa) i.a(i.aa.class);
                if (aaVar.d().booleanValue()) {
                    LogUtils.i("ParkingPresenter", "溜车报警停止");
                    SoundPlayer.getInstance().stop();
                    aaVar.a(false);
                }
            }
            this.l = abs;
        }
    }

    @Override // defpackage.tn
    public boolean g() {
        return this.m;
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IVcuController.CarGearLevelEventMsg carGearLevelEventMsg) {
        if (carGearLevelEventMsg == null) {
            LogUtils.e("ParkingPresenter", "IVcuController.CarGearLevelEventMsg, msg is null");
            return;
        }
        int intValue = carGearLevelEventMsg.getData().intValue();
        switch (intValue) {
            case 1:
                LogUtils.i("ParkingPresenter", "收到挡位变化，当前挡位 D : " + intValue);
                break;
            case 2:
                LogUtils.i("ParkingPresenter", "收到挡位变化，当前挡位 N : " + intValue);
                break;
            case 3:
                LogUtils.i("ParkingPresenter", "收到挡位变化，当前挡位 R : " + intValue);
                break;
            case 4:
                LogUtils.i("ParkingPresenter", "收到挡位变化，当前挡位 P: " + intValue);
                break;
            default:
                LogUtils.i("ParkingPresenter", "收到挡位变化，违法挡位值 : " + intValue);
                break;
        }
        i.x xVar = (i.x) i.a(i.x.class);
        if (!this.i && !xVar.d().booleanValue()) {
            if (this.j != 3 && intValue == 3) {
                if (d.n() && !c.a().m()) {
                    if (!NedcDialogUtil.isNedcStatusIsZero()) {
                        this.c.a(a[27], -1);
                    } else {
                        this.c.a(this.h.getString(e.i.xpu_someip_not_connect_err), -1);
                    }
                }
                IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.scu.ACTION_ENTER_AUTO_PARK");
                if (d.b()) {
                    LogUtils.i("ParkingPresenter", "非R->R，影像保持ReversingHoldValue set false");
                    i.a(i.af.class, false);
                    if (!d.j) {
                        this.c.a(8);
                        int i = this.d;
                        if (i == 17 || i == 27) {
                            this.c.a(a[this.d], -1);
                        }
                    }
                }
            } else {
                LogUtils.i("ParkingPresenter", "isSwitchReversingHold = " + d.b());
                if (d.b()) {
                    if (intValue == 4) {
                        if (IntentUtil.isRunningExitSuperParkCheckR()) {
                            Log.i("ParkingPresenter", "isRunningExitSuperParkCheckR() = true，正在执行B过程延迟关闭的等待逻辑， 主动模式=0 早于 P挡，本次异步并发P挡不处理");
                        } else {
                            IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK");
                        }
                    } else if (this.j == 3 && intValue != 3) {
                        LogUtils.i("ParkingPresenter", "R->D/N，影像保持ReversingHoldValue set true");
                        i.a(i.af.class, true);
                        if (!d.j) {
                            this.c.a(0);
                            this.c.a(a.g().getString(e.i.parking_tips_27_reversing), -1);
                        }
                    }
                } else if (this.j == 3 && intValue != 3) {
                    if (intValue == 4 && IntentUtil.isRunningExitSuperParkCheckR()) {
                        Log.i("ParkingPresenter", "isRunningExitSuperParkCheckR() = true，正在执行B过程延迟关闭的等待逻辑， 主动模式=0 早于 P挡，本次异步并发P挡不处理");
                    } else {
                        IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK");
                    }
                }
            }
        } else if (!this.i) {
            xVar.d().booleanValue();
        }
        this.j = intValue;
        f(intValue);
        c.a().i().statisGear(intValue);
        i.a(i.u.class, Integer.valueOf(intValue));
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IVcuController.PureDriveModeFeedbackEventMsg pureDriveModeFeedbackEventMsg) {
        if (pureDriveModeFeedbackEventMsg == null) {
            LogUtils.e("ParkingPresenter", "IVcuController.PureDriveModeFeedbackEventMsg, msg is null");
            return;
        }
        LogUtils.i("ParkingPresenter", "主动模式变化 " + pureDriveModeFeedbackEventMsg.toString());
        boolean z = true;
        if (pureDriveModeFeedbackEventMsg.getData().intValue() == 1) {
            return;
        }
        if (pureDriveModeFeedbackEventMsg.getData().intValue() == 2) {
            i.x xVar = (i.x) i.a(i.x.class);
            if (!this.i && !xVar.d().booleanValue() && this.j == 3) {
                LogUtils.i("ParkingPresenter", "钥匙召唤或泊车，P->R->2后，关闭界面ACTION_EXIT_AUTO_PARK");
                IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK");
            }
        }
        if (pureDriveModeFeedbackEventMsg.getData().intValue() != 3 && pureDriveModeFeedbackEventMsg.getData().intValue() != 2) {
            z = false;
        }
        if (this.i != z) {
            this.i = z;
            this.c.b(this.i);
            if (d.b()) {
                i.a(i.af.class, false);
            }
        }
        if (this.i) {
            return;
        }
        this.m = false;
        this.n = false;
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.ParkingProcessPathEventMsg parkingProcessPathEventMsg) {
        if (d.c()) {
            Log.i("progressbar", "onCarServicesEvent ParkingProcessPathEventMsg");
        }
        if (parkingProcessPathEventMsg == null) {
            Log.i("progressbar", "onCarServicesEvent \t ParkingProcessPathEventMsg +\tmsg==null");
            return;
        }
        try {
            ParkingProcessData parkingProcessData = new ParkingProcessData(parkingProcessPathEventMsg.getData());
            parkingProcessPathEventMsg.getData();
            float f = parkingProcessData.SCU_CDU_Tra_ds;
            float f2 = parkingProcessData.SCU_CDU_Tra_Percent;
            if (d.c()) {
                Log.i("progressbar", "数据: ds \t" + f + "\t percent:\t" + f2);
            }
            a(f, f2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void k() {
        i.a(i.m.class, true);
        this.p.removeMessages(23);
        Message obtain = Message.obtain();
        this.p.sendMessageDelayed(obtain, 3000L);
        obtain.what = 23;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        this.c.a(false);
        this.p.removeMessages(22);
        Message obtain = Message.obtain();
        obtain.what = 22;
        this.p.sendMessageDelayed(obtain, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.c.e(false);
        this.p.removeMessages(24);
        Message obtain = Message.obtain();
        obtain.what = 24;
        this.p.sendMessageDelayed(obtain, 3000L);
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.RearMirrorCtrl rearMirrorCtrl) {
        if (rearMirrorCtrl == null) {
            LogUtils.e("ParkingPresenter", "IScuController.RearMirrorCtrl, msg is null");
            return;
        }
        int intValue = rearMirrorCtrl.getData().intValue();
        LogUtils.i("ParkingPresenter", "收到SCU的RearMirrorCtrl = " + intValue);
        if (intValue == 1) {
            try {
                LogUtils.i("ParkingPresenter", "收到SCU的RearMirrorCtrl = " + intValue + " 折叠后视镜");
                c.a().f().setRearViewMirror(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (intValue == 2) {
            try {
                LogUtils.i("ParkingPresenter", "收到SCU的RearMirrorCtrl = " + intValue + " 展开后视镜");
                c.a().f().setRearViewMirror(1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.ScuOperationTipUpdateEventMsg.Error error) {
        if (error != null) {
            Log.i("ParkingPresenter", "onCarServicesEvent : ScuOperationTipUpdateEventMsg.Error ,code = " + error.getCode());
            if (error.getCode() != 6 || rc.a().e() == -1) {
                return;
            }
            Log.i("ParkingPresenter", "EcuErrorDialogUtil.showDialog() ");
            EcuErrorDialogUtil.showDialog();
        }
    }

    public int n() {
        return this.f;
    }

    public GsonBuilder o() {
        if (this.w == null) {
            this.w = new GsonBuilder();
        }
        return this.w;
    }

    @m
    public void onEvent(FavorPosEvent favorPosEvent) {
        if (favorPosEvent == null || TextUtils.isEmpty(favorPosEvent.getInfo())) {
            Log.i("ParkingPresenter", "info is empty!");
            return;
        }
        FavorPos favorPos = (FavorPos) o().create().fromJson(favorPosEvent.getInfo(), (Class<Object>) FavorPos.class);
        Log.i("ParkingPresenter", "send info:\t" + favorPos.toString() + "PID" + Process.myPid());
        JniUtil.sendFavorite(favorPos);
    }
}
