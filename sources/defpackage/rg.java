package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.autopilot.base.utils.CarApiUtil;
import com.xiaopeng.autopilot.base.utils.NedcDialogUtil;
import com.xiaopeng.lib.utils.LogUtils;
/* compiled from: SuperParkHelper.java */
/* renamed from: rg  reason: default package */
/* loaded from: classes.dex */
public class rg {
    private boolean a = false;
    private Handler b = new Handler(Looper.getMainLooper());
    private Runnable c = new Runnable() { // from class: rg.1
        @Override // java.lang.Runnable
        public void run() {
            if (rg.this.a) {
                if (!NedcDialogUtil.isNedcStatusIsZero()) {
                    Log.i("SuperParkHelper", "NEDC is not zero");
                    return;
                }
                CarApiUtil.activeSuperParkMode(false);
                rg.this.b(com.xiaopeng.autopilot.base.a.g().getString(h.i.toast_super_park_connect_timeout));
                LogUtils.i("SuperParkHelper", "mConnectTimeOutRunnable 激活握手失败，原因：超时未响应");
                if (re.a().h()) {
                    re.a().j();
                }
                rg.this.a = false;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperParkHelper.java */
    /* renamed from: rg$a */
    /* loaded from: classes.dex */
    public static class a {
        private static final rg a = new rg();
    }

    public static rg a() {
        return a.a;
    }

    public void a(boolean z) {
        if (z) {
            LogUtils.i("SuperParkHelper", "开始语音泊车生命周期");
            re.a().a(true);
        }
        if (this.a) {
            return;
        }
        LogUtils.i("SuperParkHelper", "activeSuperParkConnecting() 激活握手ing");
        this.a = true;
        this.b.removeCallbacks(this.c);
        this.b.postDelayed(this.c, 3000L);
    }

    public void a(String str) {
        this.b.removeCallbacks(this.c);
        b(str);
        if (this.a) {
            LogUtils.i("SuperParkHelper", "activeSuperParkConnectFail() 激活握手失败，原因：" + str);
            if (re.a().h()) {
                re.a().j();
            }
            this.a = false;
        }
    }

    public void b() {
        this.b.removeCallbacks(this.c);
        if (this.a) {
            LogUtils.i("SuperParkHelper", "activeSuperParkConnectSuccess() 激活握手成功");
            this.a = false;
        }
    }

    public void c() {
        this.b.removeCallbacks(this.c);
        this.a = false;
        LogUtils.i("SuperParkHelper", "exitSuperParkSuccess() 退出握手成功");
        if (re.a().h()) {
            re.a().k();
            LogUtils.i("SuperParkHelper", "结束语音泊车生命周期");
        }
    }

    public boolean d() {
        return ((i.z) i.a(i.z.class)).e();
    }

    public String e() {
        return ((i.z) i.a(i.z.class)).f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        d.a(str);
    }
}
