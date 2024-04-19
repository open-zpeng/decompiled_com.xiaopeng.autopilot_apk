package defpackage;

import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.lib.utils.LogUtils;
/* compiled from: MultiOpenCloseHelper.java */
/* renamed from: rc  reason: default package */
/* loaded from: classes.dex */
public class rc {
    private b a;
    private int b = 0;
    private int c = 0;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private int g = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiOpenCloseHelper.java */
    /* renamed from: rc$a */
    /* loaded from: classes.dex */
    public static class a {
        private static final rc a = new rc();
    }

    public static rc a() {
        return a.a;
    }

    public boolean a(String str) {
        if ("com.xiaopeng.scu.ACTION_ENTER_AUTO_PARK".equals(str)) {
            if (b()) {
                LogUtils.i("MultiOpenCloseHelper", "isParkingActionAvailable=false. --> isCameraReleaseing()=true");
                rh.a().d(this.a);
                this.a = new b(str);
                rh.a().b(this.a, 500L);
                int i = this.b;
                if (i > 7) {
                    LogUtils.i("MultiOpenCloseHelper", "mParkingEnterTimes > S_SUPPLY_MAX --> setCameraReleaseing(false);");
                    a(false);
                    return false;
                }
                this.b = i + 1;
                return false;
            }
            LogUtils.i("MultiOpenCloseHelper", "isParkingActionAvailable=true");
            rh.a().d(this.a);
            this.b = 0;
        } else if ("com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK".equals(str)) {
            if (c()) {
                LogUtils.i("MultiOpenCloseHelper", "isParkingActionAvailable=false. --> isCameraStarting()=true");
                rh.a().d(this.a);
                this.a = new b(str);
                rh.a().b(this.a, 500L);
                int i2 = this.c;
                if (i2 > 7) {
                    LogUtils.i("MultiOpenCloseHelper", "mParkingExitTimes > S_SUPPLY_MAX --> setCameraStarting(false);");
                    b(false);
                    return false;
                }
                this.c = i2 + 1;
                return false;
            }
            LogUtils.i("MultiOpenCloseHelper", "isParkingActionAvailable=true");
            rh.a().d(this.a);
            this.c = 0;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiOpenCloseHelper.java */
    /* renamed from: rc$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private String b;

        public b(String str) {
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtils.i("MultiOpenCloseHelper", "延迟500ms，重发" + this.b);
            IntentUtil.startAutopilotService(com.xiaopeng.autopilot.base.a.g(), this.b);
        }
    }

    public boolean b() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean c() {
        return this.e;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public boolean d() {
        return this.f;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public int e() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }
}
