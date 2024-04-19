package com.xiaopeng.autopilot.base;

import android.car.CarNotConnectedException;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.condition.CarConditionInfo;
import android.car.hardware.condition.CarConditionManager;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.xiaopeng.autopilot.base.bean.eventbus.CarConditionVcuSpeedEvent;
import com.xiaopeng.autopilot.base.bean.statis.StatisPresenter;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.x.protocol.bean.eventbus.IpcRouterEvent;
import com.xiaopeng.lib.framework.aiassistantmodule.AiAssistantModuleEntry;
import com.xiaopeng.lib.framework.carcontrollermodule.CarControllerModuleEntry;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.aiassistantmodule.notification.INotification;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IAvmController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IBcmController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.ICarControllerService;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IEpsController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IMcuController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IScuController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IVcuController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IMcuController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IScuController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IXpuController;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import java.util.ArrayList;
import java.util.Collections;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* compiled from: Component.java */
/* loaded from: classes.dex */
public class c {
    private IAvmController a;
    private IMcuController b;
    private IScuController c;
    private IVcuController d;
    private IBcmController e;
    private IEpsController f;
    private IXpuController g;
    private IIpcService h;
    private rl i;
    private CarControllerModuleEntry j;
    private CarConditionManager k;
    private CarConditionManager.CarConditionCallback l = new CarConditionManager.CarConditionCallback() { // from class: com.xiaopeng.autopilot.base.c.1
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            Log.i("CarConditionManager", "carPropertyValue: " + carPropertyValue);
            if (carPropertyValue.getPropertyId() == 559944229) {
                org.greenrobot.eventbus.c.a().e(new CarConditionVcuSpeedEvent((Float) carPropertyValue.getValue()));
                Log.i("CarConditionManager", "postSticky CarConditionVcuSpeedEvent !");
            }
        }
    };
    private boolean m;

    public c() {
        org.greenrobot.eventbus.c.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Component.java */
    /* loaded from: classes.dex */
    public static class a {
        private static final c a = new c();
    }

    public static c a() {
        return a.a;
    }

    public void a(Context context) {
        if (d.c()) {
            CarControllerModuleEntry.setPrintLog(true);
        }
        this.j = new CarControllerModuleEntry(context);
        Module.register(CarControllerModuleEntry.class, this.j);
        Module.register(IpcModuleEntry.class, new IpcModuleEntry(context));
        Module.register(AiAssistantModuleEntry.class, new AiAssistantModuleEntry(context));
        Module.get(CarControllerModuleEntry.class).get(IMcuController.class);
        u();
        v();
    }

    @m(a = ThreadMode.BACKGROUND)
    public void onCarServicesEventMsgBgThread(ICarControllerService.ConnectCarEventMsg connectCarEventMsg) {
        if (connectCarEventMsg.getData().booleanValue()) {
            Log.i("Component", "car service connected!");
            p();
            o();
            q();
            r();
            s();
            n();
            t();
            x();
            CarApiUtil.activeSuperParkMode(false);
            return;
        }
        Log.i("Component", "car service disConnected!");
    }

    private void n() {
        this.f = (IEpsController) Module.get(CarControllerModuleEntry.class).get(IEpsController.class);
    }

    private void o() {
        this.a = (IAvmController) Module.get(CarControllerModuleEntry.class).get(IAvmController.class);
    }

    private void p() {
        this.b = (IMcuController) Module.get(CarControllerModuleEntry.class).get(IMcuController.class);
        try {
            String hardwareCarStage = this.b.getHardwareCarStage();
            String xpCduType = this.b.getXpCduType();
            LogUtils.i("Component", "carStage : " + hardwareCarStage);
            LogUtils.i("Component", "xpCduType : " + xpCduType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(IMcuController.McuIgStatusEventMsg.class);
        a().c().registerCanEventMsg(arrayList);
    }

    private void q() {
        this.c = (IScuController) Module.get(CarControllerModuleEntry.class).get(IScuController.class);
        if (d.f()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!d.n()) {
            arrayList.add(IScuController.ScuOperationTipUpdateEventMsg.class);
            arrayList.add(IScuController.RightAvmDataUpdateEventMsg.class);
            arrayList.add(IScuController.LeftAvmDataUpdateEventMsg.class);
            arrayList.add(IScuController.ErrorTipsUpdateEventMsg.class);
            arrayList.add(IScuController.ScuLocationUpdateEventMsg.class);
            arrayList.add(IScuController.AllParklotDataEventMsg.class);
        }
        this.c.registerCanEventMsg(arrayList);
    }

    private void r() {
        this.d = (IVcuController) Module.get(CarControllerModuleEntry.class).get(IVcuController.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(IVcuController.PureDriveModeFeedbackEventMsg.class);
        arrayList.add(IVcuController.CarGearLevelEventMsg.class);
        this.d.registerCanEventMsg(arrayList);
    }

    private void s() {
        this.e = (IBcmController) Module.get(CarControllerModuleEntry.class).get(IBcmController.class);
    }

    private void t() {
        this.g = (IXpuController) Module.get(CarControllerModuleEntry.class).get(IXpuController.class);
    }

    private void u() {
        this.h = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
        this.h.init();
    }

    private void v() {
        this.i = new StatisPresenter();
    }

    public IAvmController b() {
        return this.a;
    }

    public com.xiaopeng.lib.framework.moduleinterface.carcontroller.IMcuController c() {
        return this.b;
    }

    public com.xiaopeng.lib.framework.moduleinterface.carcontroller.IScuController d() {
        return this.c;
    }

    public IVcuController e() {
        return this.d;
    }

    public IBcmController f() {
        return this.e;
    }

    public IEpsController g() {
        return this.f;
    }

    public IXpuController h() {
        return this.g;
    }

    private IIpcService w() {
        return this.h;
    }

    public rl i() {
        return this.i;
    }

    public CarControllerModuleEntry j() {
        return this.j;
    }

    private void x() {
        try {
            this.k = (CarConditionManager) this.j.getCarApiClient().getCarManager("xp_condition");
        } catch (CarNotConnectedException | IllegalStateException unused) {
            Log.e("Component", "CarConditionManager init error , Car not connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void k() {
        try {
            this.k.registerCondition(Collections.singletonList(559944229), new CarConditionInfo.Builder().setCarSpeedLimit(new Float[]{Float.valueOf(10.0f)}).build(), this.l);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (!d.n()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(IEpsController.SteeringAngleEventMsg.class);
            this.f.registerCanEventMsg(arrayList);
        }
        if (!d.n()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(IVcuController.RawCarSpeedEventMsg.class);
            this.d.registerCanEventMsg(arrayList2);
        }
        if (d.n()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(IScuController.ParkingProcessPathEventMsg.class);
        arrayList3.add(IScuController.SensorDataUpdateEventMsg.class);
        arrayList3.add(IScuController.AllParklotDataEventMsg.class);
        this.c.registerCanEventMsg(arrayList3);
    }

    public void l() {
        try {
            if (this.k != null) {
                this.k.unregisterCondition(this.l);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (!d.n()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(IEpsController.SteeringAngleEventMsg.class);
            this.f.unregisterCanEventMsg(arrayList);
        }
        if (!d.n()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(IVcuController.RawCarSpeedEventMsg.class);
            this.d.unregisterCanEventMsg(arrayList2);
        }
        if (d.n()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(IScuController.ParkingProcessPathEventMsg.class);
        arrayList3.add(IScuController.SensorDataUpdateEventMsg.class);
        this.c.unregisterCanEventMsg(arrayList3);
    }

    public void a(boolean z) {
        this.m = z;
    }

    public boolean m() {
        return (!BuildInfoUtils.isUserVersion() && d.g) || this.m || rf.a(com.xiaopeng.autopilot.base.a.g()).d();
    }

    @m(a = ThreadMode.MAIN)
    public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        IpcRouterEvent ipcRouterEvent = new IpcRouterEvent();
        ipcRouterEvent.setMsgID(ipcMessageEvent.getMsgID());
        ipcRouterEvent.setSenderPackageName(ipcMessageEvent.getSenderPackageName());
        Bundle payloadData = ipcMessageEvent.getPayloadData();
        if (payloadData != null) {
            ipcRouterEvent.setStringData(payloadData.getString(IpcConfig.IPCKey.STRING_MSG));
        }
        if (org.greenrobot.eventbus.c.a().a(IpcRouterEvent.class)) {
            org.greenrobot.eventbus.c.a().d(ipcRouterEvent);
        } else {
            org.greenrobot.eventbus.c.a().e(ipcRouterEvent);
        }
    }

    public void a(int i, Bundle bundle, String str) {
        if (i != 10009) {
            w().sendData(i, bundle, str);
        } else if (bundle != null) {
            ((INotification) Module.get(AiAssistantModuleEntry.class).get(INotification.class)).send(bundle.getString(IpcConfig.IPCKey.STRING_MSG));
        }
    }
}
