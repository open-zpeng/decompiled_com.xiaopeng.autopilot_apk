package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.xiaopeng.autopilot.radar.view.a;
/* compiled from: ReversingPresenter.java */
/* renamed from: vg  reason: default package */
/* loaded from: classes.dex */
public class vg implements vf {
    private vd a;
    private a b;
    private Handler c = new Handler(Looper.getMainLooper()) { // from class: vg.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    vg.this.b.a(((Float) message.obj).floatValue());
                    return;
                case 2:
                    vg.this.b.b(((Float) message.obj).floatValue());
                    return;
                case 3:
                    vg.this.b.a((Pair) message.obj);
                    return;
                default:
                    return;
            }
        }
    };

    public vg(a aVar) {
        this.b = aVar;
        aVar.a(this);
        a();
    }

    private void a() {
        this.a = new ve(this);
        this.a.a();
    }

    @Override // defpackage.vf
    public void a(float f, boolean z) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = Float.valueOf(f);
        this.c.sendMessage(obtain);
    }

    @Override // defpackage.vf
    public void b(float f, boolean z) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = Float.valueOf(f);
        this.c.sendMessage(obtain);
    }

    @Override // defpackage.vf
    public void a(boolean z, boolean z2) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = new Pair(Boolean.valueOf(z), Boolean.valueOf(z2));
        this.c.sendMessage(obtain);
    }
}
