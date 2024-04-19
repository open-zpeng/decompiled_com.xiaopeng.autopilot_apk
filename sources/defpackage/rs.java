package defpackage;

import android.graphics.BitmapFactory;
import android.hardware.Camera;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.camera.view.a;
import com.xiaopeng.autopilot.camera.view.b;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IAvmController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IEpsController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IScuController;
import com.xiaopeng.lib.utils.FileUtils;
import com.xiaopeng.lib.utils.LogUtils;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.m;
/* compiled from: CameraPresenter.java */
/* renamed from: rs  reason: default package */
/* loaded from: classes.dex */
public class rs implements rt {
    private rr a;
    private long c;
    private b e;
    private int b = 0;
    private boolean d = false;
    private Camera.ShutterCallback f = new Camera.ShutterCallback() { // from class: rs.1
        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            LogUtils.i("CameraPresenter", "Shutter, onShutter() was called!");
        }
    };
    private Camera.PictureCallback g = new Camera.PictureCallback() { // from class: rs.2
        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(final byte[] bArr, final Camera camera) {
            rh.a().a(new Runnable() { // from class: rs.2.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.i("CameraPresenter", "onPictureTaken was called : " + bArr + "  camera : " + camera);
                    byte[] bArr2 = bArr;
                    String storePicture = FileUtils.storePicture(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length), "/sdcard/Log/capture", 100);
                    LogUtils.i("CameraPresenter", "onPictureTaken was called, save pic success, path : " + storePicture);
                    LogUtils.i("CameraPresenter", "本次拍照耗时： " + (System.currentTimeMillis() - rs.this.c) + "ms");
                }
            });
        }
    };

    public rs(b bVar) {
        this.e = bVar;
        bVar.a(this);
        a();
    }

    private void a() {
        c.a().a(this);
        this.a = new rq();
    }

    @Override // defpackage.rt
    public void a(int i) {
        this.a.a(1);
        this.a.b(i);
    }

    @Override // defpackage.rt
    public void b(int i) {
        this.a.a(i);
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEventSteeringAngle(IAvmController.CameraSteerAngleEventMsg cameraSteerAngleEventMsg) {
        if (d.f()) {
            if (d.c()) {
                LogUtils.i("CameraPresenter", "CarService 方向盘转角: " + cameraSteerAngleEventMsg.toString());
            }
            this.e.a(ro.a(cameraSteerAngleEventMsg.getData().floatValue()));
        }
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEventSteeringAngle(IEpsController.SteeringAngleEventMsg steeringAngleEventMsg) {
        if (d.f()) {
            if (d.c()) {
                LogUtils.i("CameraPresenter", "CarService 方向盘转角: " + steeringAngleEventMsg.toString());
            }
            this.e.a(ro.a(steeringAngleEventMsg.getData().floatValue()));
        }
    }

    @m(a = ThreadMode.MAIN, b = true)
    public void onCarServicesEvent(IScuController.FactoryScuTest322EventMsg factoryScuTest322EventMsg) {
        int[] data = factoryScuTest322EventMsg.getData();
        if (data == null || data.length <= 0) {
            return;
        }
        int i = data[0];
        int i2 = data[1];
        LogUtils.i("CameraPresenter", "SCU状态信号, SCU_CDU_Log_Data_1=" + i + ", SCU_CDU_Log_Data_2=" + i2);
        if (this.b != i2) {
            this.c = System.currentTimeMillis();
            if (i2 == 255) {
                LogUtils.i("CameraPresenter", "capture(CameraSurfaceView.getCamera())");
                a(a.getCamera());
            }
        }
        this.b = i2;
    }

    private void a(Camera camera) {
        if (camera == null) {
            LogUtils.e("CameraPresenter", "capture error, camera is null!");
            if (this.e.getCameraSurfaceView().getParent() == null) {
                LogUtils.e("CameraPresenter", "拍照失败，当前泊车界面未打开");
                return;
            } else {
                LogUtils.e("CameraPresenter", "拍照失败，泊车界面正在打开或释放camera");
                return;
            }
        }
        camera.enableShutterSound(false);
        camera.takePicture(this.f, null, this.g);
    }
}
