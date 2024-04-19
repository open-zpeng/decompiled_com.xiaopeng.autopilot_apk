package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.CarEcuManager;
import android.car.hardware.xpu.CarXpuManager;
import android.util.Log;
import com.google.gson.Gson;
import com.xiaopeng.autopilot.x.protocol.apirouter.RouteSr2HiddenCamClient;
import com.xiaopeng.autopilot.x.protocol.bean.gson.OneStringBean;
import com.xiaopeng.autopilot.x.protocol.bean.gson.ParkLotChooseBean;
import com.xiaopeng.sr.bean.IntValue;
import com.xiaopeng.sr.bean.JsonMsgBean;
import java.util.Collections;
/* compiled from: XpuClient.java */
/* renamed from: abf  reason: default package */
/* loaded from: classes.dex */
public class abf {
    public CarXpuManager a;
    private CarEcuManager.CarEcuEventCallback b;
    private Gson c;
    private boolean d;
    private abk e;

    private abf() {
        this.a = null;
        this.c = new Gson();
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: XpuClient.java */
    /* renamed from: abf$a */
    /* loaded from: classes.dex */
    public static class a {
        private static final abf a = new abf();
    }

    public static abf a() {
        return a.a;
    }

    public void a(Car car, CarEcuManager.CarEcuEventCallback carEcuEventCallback, abk abkVar) {
        this.e = abkVar;
        try {
            this.a = (CarXpuManager) car.getCarManager("xp_xpu");
            this.b = carEcuEventCallback;
            c();
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
    }

    public boolean b() {
        return this.d;
    }

    public void c() {
        if (this.a == null || this.b == null) {
            return;
        }
        try {
            Log.d("XpuClient", "registerPropCallback");
            this.d = true;
            this.a.registerPropCallback(Collections.singletonList(557856773), this.b);
            this.a.registerPropCallback(Collections.singletonList(561002507), this.b);
            this.a.registerPropCallback(Collections.singletonList(561002508), this.b);
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
    }

    public void d() {
        if (this.a == null || this.b == null) {
            return;
        }
        try {
            Log.d("XpuClient", "unRegisterPropCallback");
            this.d = false;
            this.a.unregisterPropCallback(Collections.singletonList(557856773), this.b);
            this.a.unregisterPropCallback(Collections.singletonList(561002507), this.b);
            this.a.unregisterPropCallback(Collections.singletonList(561002508), this.b);
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
    }

    public void a(int i) {
        a(i, "AutoParkReqMsg");
    }

    public void b(int i) {
        a(i, "APcmdBean");
    }

    public void c(int i) {
        a(i, "TrainingCmd");
    }

    public void d(int i) {
        a(i, "apNavActiveCmd");
    }

    public void a(float f, float f2, float f3) {
        ParkLotChooseBean parkLotChooseBean = new ParkLotChooseBean();
        parkLotChooseBean.setX(f);
        parkLotChooseBean.setY(f2);
        parkLotChooseBean.setZ(f3);
        JsonMsgBean jsonMsgBean = new JsonMsgBean();
        jsonMsgBean.setData(this.c.toJsonTree(parkLotChooseBean));
        a(jsonMsgBean, "ChoseCoordiMsg");
    }

    public void a(String str) {
        OneStringBean oneStringBean = new OneStringBean();
        oneStringBean.setValue(str);
        JsonMsgBean jsonMsgBean = new JsonMsgBean();
        jsonMsgBean.setData(this.c.toJsonTree(oneStringBean));
        a(jsonMsgBean, "MapReqMsg");
    }

    public void a(int i, long j) {
        RouteSr2HiddenCamClient.routeSr2HdPkmapConfirmInfo(i, j);
    }

    private void a(int i, String str) {
        JsonMsgBean jsonMsgBean = new JsonMsgBean();
        jsonMsgBean.setData(this.c.toJsonTree(new IntValue(i)));
        a(jsonMsgBean, str);
    }

    private void a(JsonMsgBean jsonMsgBean, String str) {
        jsonMsgBean.setMsgType(str);
        jsonMsgBean.setId(0);
        jsonMsgBean.setStatus(0);
        jsonMsgBean.setVer("0.0.0.1");
        String json = this.c.toJson(jsonMsgBean, JsonMsgBean.class);
        abk abkVar = this.e;
        if (abkVar != null) {
            abkVar.b(json);
        }
        try {
            if (this.a != null) {
                Log.i("XpuClient", "SetJsonBean " + str + ", " + json.length() + " " + json);
                this.a.sendSrPkCdu2XpuEventData(json.getBytes("UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
