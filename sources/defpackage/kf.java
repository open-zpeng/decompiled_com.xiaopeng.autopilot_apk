package defpackage;

import com.badlogic.gdx.utils.ao;
/* compiled from: FPSLogger.java */
/* renamed from: kf  reason: default package */
/* loaded from: classes.dex */
public class kf {
    long a = ao.a();

    public void a() {
        if (ao.a() - this.a > 1000000000) {
            ij ijVar = io.a;
            ijVar.log("FPSLogger", "fps: " + io.b.getFramesPerSecond());
            this.a = ao.a();
        }
    }
}
