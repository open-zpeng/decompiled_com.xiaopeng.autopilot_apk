package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.CarEcuManager;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.condition.CarConditionInfo;
import android.car.hardware.condition.CarConditionManager;
import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.xiaopeng.autopilot.base.c;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.ICarControllerService;
import java.util.Arrays;
import java.util.Collections;
import okio.ByteString;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* compiled from: XpuDataEngineManager.java */
/* renamed from: abg  reason: default package */
/* loaded from: classes.dex */
public class abg {
    private Car a;
    private abk b;
    private CarConditionManager c;
    private int d;
    private byte[] e;
    private long f;
    private CarConditionManager.CarConditionCallback g;
    private CarEcuManager.CarEcuEventCallback h;
    private abe i;

    private abg() {
        this.d = 0;
        this.e = null;
        this.f = 0L;
        this.g = new CarConditionManager.CarConditionCallback() { // from class: abg.1
            public void onChangeEvent(CarPropertyValue carPropertyValue) {
                float floatValue = ((Float) carPropertyValue.getValue()).floatValue();
                Log.d("XpuDataEngineManager", "spd = " + floatValue + "mForeground = " + abg.this.d);
                if (floatValue >= 50.0f && abg.this.d == 0) {
                    abf.a().d();
                } else if (abf.a().b()) {
                } else {
                    abf.a().c();
                }
            }
        };
        this.h = new CarEcuManager.CarEcuEventCallback() { // from class: abg.2
            public void onChangeEvent(CarPropertyValue carPropertyValue) {
                int propertyId = carPropertyValue.getPropertyId();
                if (propertyId != 557856773) {
                    switch (propertyId) {
                        case 561002507:
                            abg.this.a(carPropertyValue);
                            abh.a().b((byte[]) carPropertyValue.getValue());
                            return;
                        case 561002508:
                            abh.a().a((byte[]) carPropertyValue.getValue());
                            return;
                        default:
                            return;
                    }
                }
                boolean z = ((Integer) carPropertyValue.getValue()).intValue() == 1;
                Log.i("XpuDataEngineManager", "xpu_ready: " + z);
                c.a().a(z);
            }

            public void onErrorEvent(int i, int i2) {
                Log.i("XpuDataEngineManager", "CarXpuManager onErrorEvent: " + i + "," + i2);
            }
        };
        this.i = new abe() { // from class: abg.3
            @Override // defpackage.abe
            public void a(String str) {
            }

            @Override // defpackage.abe
            public void a(ByteString byteString) {
                byte[] byteArray = byteString.toByteArray();
                if (byteArray.length > 0) {
                    if (byteArray[0] == 1) {
                        abh.a().b(Arrays.copyOfRange(byteArray, 1, byteArray.length));
                    } else if (byteArray[0] == 2) {
                        abh.a().a(Arrays.copyOfRange(byteArray, 1, byteArray.length));
                    }
                }
            }
        };
        org.greenrobot.eventbus.c.a().a(this);
    }

    /* compiled from: XpuDataEngineManager.java */
    /* renamed from: abg$a */
    /* loaded from: classes.dex */
    private static class a {
        private static final abg a = new abg();
    }

    public static abg a() {
        return a.a;
    }

    public void a(Context context) {
        if (rf.a(context).d()) {
            this.b = new abk();
            this.b.a(this.i);
        }
    }

    public void a(abi abiVar) {
        abh.a().a(abiVar);
    }

    @m(a = ThreadMode.BACKGROUND)
    public void onCarServicesEventMsgBgThread(ICarControllerService.ConnectCarEventMsg connectCarEventMsg) {
        if (d.n() && connectCarEventMsg.getData().booleanValue()) {
            Log.i("XpuDataEngineManager", "car service connected!");
            e();
        }
    }

    private void e() {
        try {
            this.a = c.a().j().getCarApiClient();
            abf.a().a(this.a, this.h, this.b);
            f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void f() {
        try {
            this.c = (CarConditionManager) this.a.getCarManager("xp_condition");
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
        if (this.c != null) {
            try {
                this.c.registerCondition(Collections.singletonList(559944229), new CarConditionInfo.Builder().setCarSpeedLimit(new Float[]{Float.valueOf(20.0f), Float.valueOf(30.0f), Float.valueOf(50.0f)}).build(), this.g);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CarPropertyValue carPropertyValue) {
        long j;
        byte[] bArr = (byte[]) carPropertyValue.getValue();
        boolean z = false;
        if (this.e == null) {
            this.f = System.currentTimeMillis();
            j = 0;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            j = currentTimeMillis - this.f;
            int length = bArr.length;
            byte[] bArr2 = this.e;
            if (length != bArr2.length) {
                this.f = currentTimeMillis;
            } else if (Arrays.equals(bArr, bArr2)) {
                z = true;
            } else {
                this.f = currentTimeMillis;
            }
        }
        if (j > 1000) {
            Log.w("XpuDataEngineManager", "pk_period: " + bArr.length + " " + carPropertyValue.getTimestamp() + ", isSame=" + z + ", interval=" + j);
        } else if (this.d == 1) {
            Log.d("XpuDataEngineManager", "pk_period: " + bArr.length + " " + carPropertyValue.getTimestamp() + ", isSame=" + z + ", interval=" + j);
        }
        this.e = bArr;
    }

    public void a(int i) {
        abf.a().a(i);
    }

    public void b(int i) {
        abf.a().b(i);
    }

    public void a(float f, float f2, float f3) {
        abf.a().a(f, f2, f3);
    }

    public void c(int i) {
        abf.a().c(i);
    }

    public void a(String str) {
        abf.a().a(str);
    }

    public void a(int i, long j) {
        abf.a().a(i, j);
    }

    public void b() {
        abf.a().d(1);
    }

    public void c() {
        abf.a().d(2);
    }

    public void d(int i) {
        this.d = i;
        if (this.d != 1 || abf.a().b()) {
            return;
        }
        abf.a().c();
    }

    public int d() {
        return this.d;
    }
}
