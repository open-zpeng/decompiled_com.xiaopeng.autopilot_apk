package defpackage;

import android.util.Log;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.camera.view.a;
/* compiled from: CameraModel.java */
/* renamed from: rq  reason: default package */
/* loaded from: classes.dex */
public class rq implements rr {
    @Override // defpackage.rr
    public void a(int i) {
        Log.i("CameraModel", "changeChannel.channel = " + i);
    }

    @Override // defpackage.rr
    public void b(int i) {
        Log.i("CameraModel", "switchCamera.type = " + i);
        CarApiUtil.setCameraDisplayMode(a.getCamera(), i);
    }
}
