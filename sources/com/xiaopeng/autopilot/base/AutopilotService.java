package com.xiaopeng.autopilot.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.xiaopeng.autopilot.base.bean.eventbus.ShortcutEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.SpeechSuperParkEvent;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.EcuErrorDialogUtil;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.NavStartGuideDialogUtil;
import com.xiaopeng.autopilot.base.utils.NedcDialogUtil;
import com.xiaopeng.autopilot.base.utils.SoundPlayer;
import com.xiaopeng.autopilot.x.protocol.bean.eventbus.IpcRouterEvent;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.speech.protocol.node.autoparking.AutoParkingNode;
import com.xiaopeng.xui.app.XToast;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* loaded from: classes.dex */
public class AutopilotService extends Service {
    private Object a = new Object();
    private Runnable b = new Runnable() { // from class: com.xiaopeng.autopilot.base.AutopilotService.1
        @Override // java.lang.Runnable
        public void run() {
            rg.a().a(a.g().getString(h.i.apa_off_hint));
            rd.a().a(a.g().getString(h.i.apa_off_hint));
        }
    };
    private Runnable c = new Runnable() { // from class: com.xiaopeng.autopilot.base.AutopilotService.3
        @Override // java.lang.Runnable
        public void run() {
            if (((i.u) i.a(i.u.class)).d().intValue() == 3) {
                LogUtils.i("AutopilotService", "3s内切换到R挡界面保持");
            } else {
                LogUtils.i("AutopilotService", "3s内没操作挡位界面退出");
                AutopilotService.this.a(true);
            }
            IntentUtil.resetExitSuperParkCheckR();
        }
    };

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        CarApiUtil.activeSuperParkMode(false);
        org.greenrobot.eventbus.c.a().a(this);
        SoundPlayer.getInstance().init();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.base.AutopilotService.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AutopilotService.this.a) {
                    AutopilotService.this.a(intent);
                }
            }
        });
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a(intent);
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().c(this);
        SoundPlayer.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        LogUtils.i("AutopilotService", "filterIntent()  action=" + action + " ，当前mCurParkingType=" + rc.a().e());
        if (action.equals("com.xiaopeng.scu.ACTION_ENTER_AUTO_PARK")) {
            if (!rc.a().a(action)) {
                LogUtils.i("AutopilotService", "ACTION_ENTER_AUTO_PARK return!");
                return;
            }
            i.a(i.w.class, Boolean.valueOf(!d.j));
            a();
            c.a().i().statisEnterAutopilotMethod(BuildInfoUtils.BID_WAN);
        } else if (action.equals("com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK")) {
            if (!rc.a().a("com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK")) {
                LogUtils.i("AutopilotService", "ACTION_EXIT_AUTO_PARK return!");
                return;
            }
            i.a(i.ab.class, false);
            i.a(i.w.class, false);
            a(false);
        } else if (action.equals("com.xiaopeng.systemui.ACTION_SYSTEMUI_SUPER_PARK")) {
            if (!d.h() && !d.g()) {
                LogUtils.i("AutopilotService", "ACTION_SYSTEMUI_SUPER_PARK: 低配车手动打开倒车界面.");
                if (d.b()) {
                    if (CarApiUtil.getCurrentSpeed() > 10.0f) {
                        LogUtils.i("AutopilotService", "CarApiUtil.getCurrentSpeed() > 10，影像保持开关打开，提示无法使用");
                        rg.a().a(a.g().getString(h.i.toast_super_park_low_config_open_error));
                        return;
                    }
                    LogUtils.i("AutopilotService", "低配车点击P，影像保持ReversingHoldValue set true");
                    i.a(i.af.class, true);
                    IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.scu.ACTION_ENTER_AUTO_PARK");
                    return;
                }
                IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.scu.ACTION_ENTER_AUTO_PARK");
            } else if (NedcDialogUtil.showDialog()) {
                LogUtils.i("AutopilotService", "NEDC模式开启");
            } else if (rc.a().e() != 1) {
                rg.a().a(false);
                if (d.n() && !c.a().m()) {
                    rg.a().a(getString(h.i.xpu_someip_not_connect_err));
                    LogUtils.i("AutopilotService", "泊车系统启动中，请稍后");
                } else if (rg.a().d()) {
                    String e = rg.a().e();
                    LogUtils.i("AutopilotService", "超级泊车异常AVM_Slot_Attr  " + e);
                    rg.a().a(e);
                } else if (!CarApiUtil.isApaOn()) {
                    LogUtils.i("AutopilotService", "APA switch if off, just toast and exit in ACTION_SYSTEMUI_SUPER_PARK");
                    rh.a().e(this.b);
                    rh.a().b(this.b, 500L);
                } else {
                    IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.action.ACTION_ENTER_SUPER_PARK");
                    c.a().i().statisEnterAutopilotMethod("3");
                }
            } else {
                LogUtils.i("AutopilotService", "mCurParkingType == Constant.PARKING_TYPE_AUTO_PARK，  点击超级泊车入口无效");
            }
        } else if (action.equals("com.xiaopeng.carcontrol.ACTION_CARCONTROL_SUPER_PARK")) {
            if (!d.h() && !d.g()) {
                String string = a.g().getString(h.i.speech_super_park_no_support);
                rg.a().a(string);
                LogUtils.i("AutopilotService", "ACTION_CARCONTROL_SUPER_PARK: " + string);
            } else if (NedcDialogUtil.showDialog()) {
                LogUtils.i("AutopilotService", "NEDC模式开启");
            } else if (rc.a().e() != 1) {
                rg.a().a(false);
                if (d.n() && !c.a().m()) {
                    rg.a().a(getString(h.i.xpu_someip_not_connect_err));
                    LogUtils.i("AutopilotService", "泊车系统启动中，请稍后");
                } else if (rg.a().d()) {
                    String e2 = rg.a().e();
                    LogUtils.i("AutopilotService", "超级泊车异常AVM_Slot_Attr  " + e2);
                    rg.a().a(e2);
                } else if (!CarApiUtil.isApaOn()) {
                    LogUtils.i("AutopilotService", "APA switch if off, just toast and exit in ACTION_CARCONTROL_SUPER_PARK");
                    rh.a().e(this.b);
                    rh.a().b(this.b, 500L);
                } else {
                    IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.action.ACTION_ENTER_SUPER_PARK");
                    c.a().i().statisEnterAutopilotMethod("2");
                }
            } else {
                LogUtils.i("AutopilotService", "mCurParkingType == Constant.PARKING_TYPE_AUTO_PARK，  点击超级泊车入口无效");
            }
        } else if (action.equals("com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_SUPER_PARK") || action.equals("com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_TRAINING_PARK")) {
            if (!d.h() && !d.g()) {
                String string2 = a.g().getString(h.i.speech_super_park_no_support);
                rg.a().a(string2);
                LogUtils.i("AutopilotService", "ACTION_SPEECH_ACTIVE_SUPER_PARK: " + string2);
            } else if (NedcDialogUtil.showDialog()) {
                LogUtils.i("AutopilotService", "NEDC模式开启");
            } else if (rc.a().e() != 1) {
                LogUtils.i("AutopilotService", "ACTION_SPEECH_ACTIVE_SUPER_PARK : isSpeechActived = true");
                if (action.equals("com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_TRAINING_PARK")) {
                    rg.a().a(false);
                } else {
                    rg.a().a(true);
                }
                if (d.n() && !c.a().m()) {
                    rg.a().a(getString(h.i.xpu_someip_not_connect_err));
                    LogUtils.i("AutopilotService", "泊车系统启动中，请稍后");
                } else if (rg.a().d()) {
                    String e3 = rg.a().e();
                    LogUtils.i("AutopilotService", "超级泊车异常AVM_Slot_Attr  " + e3);
                    rg.a().a(e3);
                } else if (!CarApiUtil.isApaOn()) {
                    LogUtils.i("AutopilotService", "APA switch if off, just toast and exit in ACTION_SPEECH_ACTIVE_SUPER_PARK");
                    rh.a().e(this.b);
                    rh.a().b(this.b, 500L);
                } else {
                    IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.action.ACTION_ENTER_SUPER_PARK");
                    if (action.equals("com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_TRAINING_PARK")) {
                        org.greenrobot.eventbus.c.a().d(new SpeechSuperParkEvent(4, -1));
                    }
                    c.a().i().statisEnterAutopilotMethod(BuildInfoUtils.BID_LAN);
                }
            } else {
                LogUtils.i("AutopilotService", "mCurParkingType == Constant.PARKING_TYPE_AUTO_PARK，  语音泊车激活无效");
            }
        } else if (action.equals("com.xiaopeng.aiassitant.ACTION_ENTER_AUTO_PARK")) {
            if (!d.h() && !d.g()) {
                String string3 = a.g().getString(h.i.speech_super_park_no_support);
                rg.a().a(string3);
                LogUtils.i("AutopilotService", "ACTION_ENTER_AUTO_PARK_AI: " + string3);
            } else if (NedcDialogUtil.showDialog()) {
                LogUtils.i("AutopilotService", "NEDC模式开启");
            } else if (rc.a().e() != 1) {
                LogUtils.i("AutopilotService", "ACTION_ENTER_AUTO_PARK_AI : isSpeechActived = true");
                rg.a().a(true);
                if (d.n() && !c.a().m()) {
                    rg.a().a(getString(h.i.xpu_someip_not_connect_err));
                    LogUtils.i("AutopilotService", "泊车系统启动中，请稍后");
                } else if (rg.a().d()) {
                    String e4 = rg.a().e();
                    LogUtils.i("AutopilotService", "超级泊车异常AVM_Slot_Attr  " + e4);
                    rg.a().a(e4);
                } else {
                    LogUtils.i("AutopilotService", "ACTION_ENTER_AUTO_PARK_AI : isSpeechActived = true");
                    IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.action.ACTION_ENTER_SUPER_PARK");
                }
            } else {
                LogUtils.i("AutopilotService", "mCurParkingType == Constant.PARKING_TYPE_AUTO_PARK，  语音泊车激活无效");
            }
        } else if (action.equals("com.xiaopeng.systemui.ACTION_INFOFLOW_SUPER_PARK") || action.equals("com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_MEMORY_PARK") || action.equals("com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_MEMORY_PARK_FOUND_PARKLOT")) {
            if (!d.h() && !d.g()) {
                String string4 = a.g().getString(h.i.speech_super_park_no_support);
                rg.a().a(string4);
                LogUtils.i("AutopilotService", "ACTION_INFOFLOW_SUPER_PARK: " + string4);
            } else if (NedcDialogUtil.showDialog()) {
                LogUtils.i("AutopilotService", "NEDC模式开启");
            } else {
                int intValue = ((i.c) i.a(i.c.class)).d().intValue();
                int intValue2 = ((i.at) i.a(i.at.class)).d().intValue();
                LogUtils.i("AutopilotService", "ACTION_INFOFLOW_SUPER_PARK.apStatus = " + intValue + "," + intValue2);
                if (intValue == 1) {
                    int intValue3 = ((i.a) i.a(i.a.class)).d().intValue();
                    LogUtils.i("AutopilotService", "ACTION_INFOFLOW_SUPER_PARK.apErrorTips = " + intValue3);
                    String[] stringArray = a.g().getResources().getStringArray(h.a.array_no_use);
                    String[] stringArray2 = a.g().getResources().getStringArray(h.a.array_no_use_toast);
                    String str = stringArray[intValue3];
                    XToast.showShort(stringArray2[intValue3]);
                    rd.a().a(str);
                } else if (intValue != 2 && intValue2 != 4) {
                    if (intValue != 3) {
                        String string5 = a.g().getString(h.i.tts_ap_ready_go_not_use);
                        XToast.showShort(string5);
                        rd.a().a(string5);
                    }
                } else if (rc.a().e() != 1) {
                    if (action.equals("com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_MEMORY_PARK_FOUND_PARKLOT")) {
                        LogUtils.i("AutopilotService", "ACTION_SPEECH_ACTIVE_MEMORY_PARK_FOUND_PARKLOT : isSpeechActived = true");
                        rg.a().a(true);
                    }
                    if (d.n() && !c.a().m()) {
                        rg.a().a(getString(h.i.xpu_someip_not_connect_err));
                        LogUtils.i("AutopilotService", "泊车系统启动中，请稍后");
                    } else if (rg.a().d()) {
                        String e5 = rg.a().e();
                        LogUtils.i("AutopilotService", "超级泊车异常AVM_Slot_Attr  " + e5);
                        rg.a().a(e5);
                    } else {
                        LogUtils.i("AutopilotService", "ACTION_INFOFLOW_SUPER_PARK : isSpeechActived = true");
                        IntentUtil.sendCloseInfoFlowCard();
                        if (action.equals("com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_MEMORY_PARK_FOUND_PARKLOT")) {
                            i.a(i.ai.class, 2);
                        } else {
                            i.a(i.ai.class, 1);
                        }
                        IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.action.ACTION_ENTER_SUPER_PARK");
                    }
                } else {
                    LogUtils.i("AutopilotService", "mCurParkingType == Constant.PARKING_TYPE_AUTO_PARK，  语音泊车激活无效");
                }
            }
        } else if (action.equals("ACTION_NAV_START_POINT")) {
            if (!d.h() && !d.g()) {
                String string6 = a.g().getString(h.i.speech_super_park_no_support);
                rg.a().a(string6);
                LogUtils.i("AutopilotService", "ACTION_INFOFLOW_SUPER_PARK: " + string6);
            } else if (NedcDialogUtil.showDialog()) {
                LogUtils.i("AutopilotService", "NEDC模式开启");
            } else if (((i.aj) i.a(i.aj.class)).d().intValue() == 1) {
                i.a(i.ak.class, true);
                IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.action.ACTION_ENTER_SUPER_PARK");
            } else {
                IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.action.ACTION_ENTER_SUPER_PARK");
            }
        } else if (action.equals("com.xiaopeng.action.ACTION_INFOFLOW_LEARNING_SUMMON")) {
        } else {
            if (action.equals("com.xiaopeng.action.ACTION_ENTER_SUPER_PARK")) {
                CarApiUtil.activeSuperParkMode(true);
                rg.a().b();
                i.a(i.x.class, true);
                i.a(i.w.class, false);
                a();
            } else if (action.equals("com.xiaopeng.action.ACTION_EXIT_SUPER_PARK")) {
                CarApiUtil.activeSuperParkMode(false);
                i.a(i.x.class, false);
                i.a(i.w.class, false);
                rg.a().c();
                if (intent.getExtras() == null || !intent.getExtras().getBoolean("isDelayCheckR")) {
                    LogUtils.i("AutopilotService", "非B过程完成退出，不延迟判断挡位");
                    i.a(i.ab.class, false);
                    a(true);
                } else {
                    long j = intent.getExtras().getLong("delayCheckRTime");
                    LogUtils.i("AutopilotService", "B过程完成退出，延迟3s判断挡位");
                    i.a(i.ab.class, true);
                    rh.a().b(this.c, j);
                }
                if (((Boolean) i.a(i.al.class).d()).booleanValue()) {
                    org.greenrobot.eventbus.c.a().d(new rb());
                    i.a(i.al.class, false);
                }
            }
        }
    }

    private synchronized void a() {
        LogUtils.i("AutopilotService", "doParking()");
        if (rc.a().e() != -1) {
            LogUtils.i("AutopilotService", "doParking() 当前已经显示泊车界面，return");
            return;
        }
        rc.a().a(1);
        LogUtils.i("AutopilotService", "doParking() setCameraStarting(true)");
        rc.a().b(true);
        LogUtils.i("AutopilotService", "doParking() IPC让其它摄像头尽早释放， REMOTE_COMMAND_AUTOPILOT_ENTER_AUTO_PARK");
        c.a().a(IpcConfig.AutopilotConfig.REMOTE_COMMAND_AUTOPILOT_ENTER_AUTO_PARK, null, IpcConfig.App.CAR_CAMERA);
        LogUtils.i("AutopilotService", "doParking() mIsWaitingForPreview = true");
        rc.a().c(true);
        IntentUtil.sendInfoFlowCard(0, true);
        a.g().c();
        LogUtils.i("AutopilotService", "界面打开，拦截语音");
        rh.a().a(new Runnable() { // from class: com.xiaopeng.autopilot.base.AutopilotService.4
            @Override // java.lang.Runnable
            public void run() {
                if (wz.b().i().g()) {
                    LogUtils.i("AutopilotService", "子线程，调用语音stopCarSpeech");
                    ((AutoParkingNode) yu.a(AutoParkingNode.class)).g();
                }
            }
        });
        ((AutoParkingNode) yu.a(AutoParkingNode.class)).b(false);
        ((AutoParkingNode) yu.a(AutoParkingNode.class)).f();
        LogUtils.i("AutopilotService", "doParking()  show泊车界面完成");
        if (((Boolean) i.a(i.ak.class).d()).booleanValue()) {
            NavStartGuideDialogUtil.showDialog();
        }
        i.a(i.ak.class).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        rh.a().d(this.c);
        i.a(i.ab.class, false);
        if (z) {
            LogUtils.i("AutopilotService", "cleanParkingJniCache = true ， ShortcutEvent.CLEAN_PARKING_JNI_CACHE_EVENT");
            org.greenrobot.eventbus.c.a().d(ShortcutEvent.CLEAN_PARKING_JNI_CACHE_EVENT);
        }
        if (d.b()) {
            LogUtils.i("AutopilotService", "exitParking界面关闭，影像保持ReversingHoldValue set false");
            i.a(i.af.class, false);
        }
        LogUtils.i("AutopilotService", "exitParking()");
        if (rc.a().e() == -1) {
            LogUtils.i("AutopilotService", "exitParking() 当前界面空闲，return");
            return;
        }
        EcuErrorDialogUtil.hideDialog();
        rc.a().c(false);
        rc.a().a(true);
        c.a().a(IpcConfig.AutopilotConfig.REMOTE_COMMAND_AUTOPILOT_TO_EXIT_BEFORE_WINDOW_CLOSE, null, IpcConfig.App.CAR_CAMERA);
        IntentUtil.sendInfoFlowCard(0, true);
        a.g().d();
        LogUtils.i("AutopilotService", "界面关闭，允许语音");
        ((AutoParkingNode) yu.a(AutoParkingNode.class)).b(true);
        ((AutoParkingNode) yu.a(AutoParkingNode.class)).e();
        rc.a().a(-1);
        LogUtils.i("AutopilotService", "exitParking()  hide泊车界面完成");
    }

    @m(a = ThreadMode.MAIN)
    public void onEvent(IpcRouterEvent ipcRouterEvent) {
        int msgID = ipcRouterEvent.getMsgID();
        String senderPackageName = ipcRouterEvent.getSenderPackageName();
        String stringData = ipcRouterEvent.getStringData();
        LogUtils.i("AutopilotService", "messageId: " + msgID + "  packageName: " + senderPackageName + " payLoadData:" + stringData);
        if (msgID == 90011) {
            LogUtils.i("AutopilotService", "收到SystemUI泊车入口点击ipc  .REMOTE_COMMAND_AUTOPILOT_SYSTEMUI_ACTIVE_SUPER_PARK");
            IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.systemui.ACTION_SYSTEMUI_SUPER_PARK");
        } else if (msgID == 16002) {
            LogUtils.i("AutopilotService", "收到CarControl的方向盘快捷按键点击ipc  .REMOTE_COMMAND_AUTOPILOT");
            IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.carcontrol.ACTION_CARCONTROL_SUPER_PARK");
        } else if (msgID == 10011) {
            LogUtils.i("AutopilotService", "action: " + stringData);
            if (stringData.equals("ACTION_LEARNING_SUMMON")) {
                IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.systemui.ACTION_INFOFLOW_SUPER_PARK");
            } else if (stringData.equals("ACTION_NAV_START_POINT")) {
                IntentUtil.startAutopilotService(a.g(), "ACTION_NAV_START_POINT");
            } else {
                IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.systemui.ACTION_INFOFLOW_SUPER_PARK");
            }
        }
    }
}
