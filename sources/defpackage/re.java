package defpackage;

import android.util.Log;
import com.xiaopeng.autopilot.base.bean.eventbus.SpeechSuperParkEvent;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.base.utils.SpeechActiveLearnDialogUtil;
import com.xiaopeng.autopilot.x.protocol.bean.eventbus.SpeechApiRouteEvent;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.speech.protocol.node.autoparking.AutoParkingNode;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.m;
/* compiled from: ParkingSpeechModel.java */
/* renamed from: re  reason: default package */
/* loaded from: classes.dex */
public class re extends yt implements com.xiaopeng.speech.protocol.node.autoparking.a {
    private volatile boolean b;
    private b c;
    private volatile String d;
    private boolean e;
    private volatile int f;
    private int g;

    /* compiled from: ParkingSpeechModel.java */
    /* renamed from: re$b */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(int i);
    }

    private re() {
        this.b = false;
        this.d = "";
        this.e = false;
        this.g = -1;
        c.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ParkingSpeechModel.java */
    /* renamed from: re$a */
    /* loaded from: classes.dex */
    public static class a {
        private static final re a = new re();
    }

    public static re a() {
        return a.a;
    }

    @Override // com.xiaopeng.speech.protocol.node.autoparking.a
    public void b() {
        if (this.b) {
            return;
        }
        if (d.h() || d.g()) {
            LogUtils.i("ParkingSpeechModel", "onActivate(): 启动services--ACTION_SPEECH_ACTIVE_SUPER_PARK");
            IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_SUPER_PARK");
            return;
        }
        String string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_super_park_no_support);
        LogUtils.i("ParkingSpeechModel", "onActivate(): " + string);
        rd.a().b(string);
    }

    @Override // com.xiaopeng.speech.protocol.node.autoparking.a
    public void c() {
        if (this.b) {
            LogUtils.i("ParkingSpeechModel", "onExit（）: SpeechSuperParkEvent.SPEECH_EXIT");
            c.a().d(new SpeechSuperParkEvent(3, -1));
        }
    }

    public void d() {
        if (this.b) {
            LogUtils.i("ParkingSpeechModel", "onParkStart(): SpeechSuperParkEvent.SPEECH_START ");
            c.a().d(new SpeechSuperParkEvent(2, this.f));
        }
    }

    public void a(zf zfVar) {
        if (!this.b || zfVar == null) {
            return;
        }
        LogUtils.i("ParkingSpeechModel", "onParkStart(): positionBean.get Position() = " + zfVar.a());
        if (zfVar.a() == -1) {
            d();
            return;
        }
        int a2 = zfVar.a() - 1;
        b bVar = this.c;
        if (bVar != null) {
            if (bVar.a(a2)) {
                rd.a().a(com.xiaopeng.autopilot.base.a.g().getString(h.i.park_start_tts));
                this.f = a2;
                LogUtils.i("ParkingSpeechModel", "onParkStart(): replySupport = true");
                c.a().d(new SpeechSuperParkEvent(1, a2));
                d();
                return;
            }
            LogUtils.i("ParkingSpeechModel", "onParkStart(): replySupport = false");
            if (((i.c) i.a(i.c.class)).d().intValue() == 7) {
                ((AutoParkingNode) yu.a(AutoParkingNode.class)).a(this.d, true);
            } else {
                ((AutoParkingNode) yu.a(AutoParkingNode.class)).a(this.d, false);
            }
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.autoparking.a
    public void b(zf zfVar) {
        if (!this.b || zfVar == null) {
            return;
        }
        LogUtils.i("ParkingSpeechModel", "onParkCarportCount(): positionBean.getPosition() = " + zfVar.a());
        int a2 = zfVar.a() - 1;
        b bVar = this.c;
        if (bVar != null) {
            if (bVar.a(a2)) {
                this.f = a2;
                LogUtils.i("ParkingSpeechModel", "onParkCarportCount(): replySupport = true");
                c.a().d(new SpeechSuperParkEvent(1, a2));
                yu.a("native://autoparking.park.carport.count", true);
                return;
            }
            LogUtils.i("ParkingSpeechModel", "onParkCarportCount(): replySupport = false");
            yu.a("native://autoparking.park.carport.count", false, this.d);
        }
    }

    @Override // com.xiaopeng.speech.protocol.node.autoparking.a
    public void e() {
        LogUtils.i("ParkingSpeechModel", "onMemoryParkingStart");
        String string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_passive);
        if (!d.n()) {
            rd.a().b(com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_super_park_no_support));
            return;
        }
        int intValue = ((i.c) i.a(i.c.class)).d().intValue();
        LogUtils.i("ParkingSpeechModel", "onMemoryParkingStart apStatus = " + intValue);
        if (intValue == 0) {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_passive);
            int intValue2 = ((i.at) i.a(i.at.class)).d().intValue();
            int xPilotStatus = CarApiUtil.getXPilotStatus();
            LogUtils.i("ParkingSpeechModel", "onMemoryParkingStart memorySwSt = " + xPilotStatus + " trainingTip = " + intValue2);
            if (xPilotStatus == 3 || xPilotStatus == 2) {
                string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_no_lisence);
            } else if (intValue2 == 0 || intValue2 == 22 || intValue2 == 21) {
                string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_out_parking_area);
            }
        } else if (intValue == 1) {
            int intValue3 = ((i.a) i.a(i.a.class)).d().intValue();
            LogUtils.i("ParkingSpeechModel", "onMemoryParkingStart apFailReason = " + intValue3);
            string = com.xiaopeng.autopilot.base.a.g().getResources().getStringArray(h.a.array_no_use)[intValue3];
        } else if (intValue == 2) {
            string = null;
            IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_MEMORY_PARK");
        }
        if (string != null) {
            rd.a().a(string);
        }
    }

    public void f() {
        LogUtils.i("ParkingSpeechModel", "onMemoryParkingFoundParkLotStart");
        String string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_passive);
        if (!d.n()) {
            rd.a().b(com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_super_park_no_support));
            return;
        }
        int intValue = ((i.c) i.a(i.c.class)).d().intValue();
        LogUtils.i("ParkingSpeechModel", "onMemoryParkingFoundParkLotStart apStatus = " + intValue);
        if (intValue == 0) {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_passive);
            int intValue2 = ((i.at) i.a(i.at.class)).d().intValue();
            int xPilotStatus = CarApiUtil.getXPilotStatus();
            LogUtils.i("ParkingSpeechModel", "onMemoryParkingFoundParkLotStart memorySwSt = " + xPilotStatus + " trainingTip = " + intValue2);
            if (xPilotStatus == 3 || xPilotStatus == 2) {
                string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_no_lisence);
            } else if (intValue2 == 0 || intValue2 == 22 || intValue2 == 21) {
                string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_out_parking_area);
            }
        } else if (intValue == 1) {
            int intValue3 = ((i.a) i.a(i.a.class)).d().intValue();
            LogUtils.i("ParkingSpeechModel", "onMemoryParkingFoundParkLotStart apFailReason = " + intValue3);
            string = com.xiaopeng.autopilot.base.a.g().getResources().getStringArray(h.a.array_no_use)[intValue3];
        } else if (intValue == 2) {
            string = null;
            IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_MEMORY_PARK_FOUND_PARKLOT");
        }
        if (string != null) {
            rd.a().a(string);
        }
    }

    public void g() {
        String string;
        LogUtils.i("ParkingSpeechModel", "onParkingTrainingStart");
        com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_passive);
        if (!d.n()) {
            rd.a().b(com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_super_park_no_support));
            return;
        }
        com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_passive);
        int intValue = ((i.at) i.a(i.at.class)).d().intValue();
        int xPilotStatus = CarApiUtil.getXPilotStatus();
        LogUtils.i("ParkingSpeechModel", "onParkingTrainingStart memorySwSt = " + xPilotStatus + " trainingTip = " + intValue);
        if (xPilotStatus == 3 || xPilotStatus == 2) {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_no_lisence);
        } else if (intValue == 4 || intValue == 30) {
            Log.i("ParkingSpeechModel", "CarApiUtil.getGear() = " + CarApiUtil.getGear());
            if (CarApiUtil.getGear() == 3) {
                string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_learning_status_with_r);
            } else {
                string = null;
                IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), "com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_TRAINING_PARK");
            }
        } else if (intValue == 15) {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_learning_status_has_line);
            rh.a().c(new Runnable() { // from class: re.1
                @Override // java.lang.Runnable
                public void run() {
                    SpeechActiveLearnDialogUtil.showDialog();
                }
            });
        } else if (intValue == 17 || intValue == 13 || intValue == 14) {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_learning_status_finish);
        } else if (intValue == 1) {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_go_to_land);
        } else if (intValue == 0 || intValue == 22 || intValue == 21) {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_ap_status_out_parking_area);
        } else if (intValue == 2) {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_learning_status_with_r);
        } else if (intValue == 25) {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_learning_status_error_click);
        } else {
            string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_learning_status_other);
        }
        if (string != null) {
            rd.a().a(string);
        }
    }

    public boolean h() {
        return this.b;
    }

    public void i() {
        Log.i("ParkingSpeechModel", "stopCurrentSpeechTTS");
        ((AutoParkingNode) yu.a(AutoParkingNode.class)).g();
    }

    public void a(boolean z) {
        Log.i("ParkingSpeechModel", "setSpeechActived speechActived = " + z);
        this.b = z;
        if (this.b) {
            return;
        }
        i();
        this.e = false;
    }

    public void j() {
        if (this.b) {
            SoundPlayer.getInstance().playParkDisable();
            a(false);
            LogUtils.i("ParkingSpeechModel", "speechSuperParkConnectFail(): isSpeechActived = " + this.b);
            LogUtils.i("ParkingSpeechModel", "握手失败，结束语音泊车生命周期");
        }
    }

    public void a(int i, b bVar, int i2) {
        String string;
        this.g = i2;
        LogUtils.i("ParkingSpeechModel", "speechSuperParkFindParklotAndStop tips = " + i2);
        if (this.b) {
            int intValue = ((i.c) i.a(i.c.class)).d().intValue();
            this.c = bVar;
            boolean z = true;
            if (intValue == 7) {
                if (i2 == 115) {
                    if (i == 1) {
                        string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_vpa_arrive_favorite_found_one_and_stop);
                    } else {
                        string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_vpa_arrive_favorite_found_more_and_stop, new Object[]{String.valueOf(i)});
                    }
                } else if (i == 1) {
                    string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_vpa_found_one_and_stop);
                } else {
                    string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_vpa_found_more_and_stop, new Object[]{String.valueOf(i)});
                }
            } else if (i == 1) {
                string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_super_park_found_one_and_stop);
                z = false;
            } else {
                string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_super_park_found_more_and_stop, new Object[]{String.valueOf(i)});
                z = false;
            }
            this.d = string;
            LogUtils.i("ParkingSpeechModel", "speechSuperParkFindParklotAndStop(): apStatus = " + intValue + " ; tts = " + string);
            ((AutoParkingNode) yu.a(AutoParkingNode.class)).a(string, z);
        }
    }

    public void k() {
        if (this.b) {
            String string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_super_park_exit);
            LogUtils.i("ParkingSpeechModel", "speechSuperParkExit(): " + string);
            LogUtils.i("ParkingSpeechModel", "语音泊车，退出");
            a(false);
        }
    }

    public void l() {
        if (!this.b || this.e) {
            return;
        }
        String string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_super_park_no_break);
        LogUtils.i("ParkingSpeechModel", "speechSuperParkNoBrake(): 语音泊车生命周期内播报一次， " + string);
        rd.a().a(string);
        this.e = true;
    }

    public void m() {
        String string = com.xiaopeng.autopilot.base.a.g().getString(h.i.speech_park_slot_invalidate);
        LogUtils.i("ParkingSpeechModel", "speechSlotOccupy() ， " + string);
        rd a2 = rd.a();
        LogUtils.i("ParkingSpeechModel", "speechSlotOccupy() is， " + a2.b());
        if (a2.b()) {
            return;
        }
        a2.i(string);
    }

    public void a(int i) {
        this.f = i;
    }

    @m(a = ThreadMode.MAIN)
    public void onEvent(SpeechApiRouteEvent speechApiRouteEvent) {
        int i = speechApiRouteEvent.action;
        Log.i("ParkingSpeechModel", "onEvent " + i);
        switch (i) {
            case 1:
                b();
                return;
            case 2:
                c();
                return;
            case 3:
                a(zf.a(speechApiRouteEvent.data));
                return;
            case 4:
                b(zf.a(speechApiRouteEvent.data));
                return;
            case 5:
                e();
                return;
            case 6:
                g();
                return;
            case 7:
                f();
                return;
            case 8:
                if (this.g == 115) {
                    ((AutoParkingNode) yu.a(AutoParkingNode.class)).a(this.d, true);
                    return;
                } else {
                    c.a().d(new SpeechSuperParkEvent(5, -1));
                    return;
                }
            case 9:
                c.a().d(new SpeechSuperParkEvent(6, -1));
                return;
            default:
                return;
        }
    }
}
