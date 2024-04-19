package com.xiaopeng.autopilot.base;

import android.app.Application;
import com.xiaopeng.autopilot.base.utils.IntentUtil;
import com.xiaopeng.autopilot.base.utils.WebViewUtil;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.lib.utils.view.UIUtils;
import com.xiaopeng.xui.Xui;
/* compiled from: App.java */
/* loaded from: classes.dex */
public abstract class a extends Application {
    private static a d;
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void d();

    public static a g() {
        return d;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        d = this;
        try {
            org.greenrobot.eventbus.c.b().c(false).b(false).a(false).d();
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.a().a(this);
        IntentUtil.startAutopilotService(this, null);
        ThemeWatcher.getInstance().init(this, new int[0]);
        Xui.init(this);
        wz.b().a(this);
        wz.b().a("Autopilot");
        re.a();
        UIUtils.init(this);
        wc.a(this);
        b();
        WebViewUtil.hookWebView();
    }
}
