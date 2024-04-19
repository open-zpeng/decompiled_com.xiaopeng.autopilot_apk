package com.xiaopeng.autopilot.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import com.xiaopeng.autopilot.base.bean.eventbus.BackPressedEvent;
import com.xiaopeng.autopilot.base.bean.eventbus.FinishBgActivityEvent;
import com.xiaopeng.lib.utils.LogUtils;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;
/* loaded from: classes.dex */
public class BgActivity extends Activity {
    private String a = "BgActivity";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        LogUtils.i(this.a, "onCreate");
        super.onCreate(bundle);
        org.greenrobot.eventbus.c.a().a(this);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        LogUtils.i(this.a, "onDestroy");
        super.onDestroy();
        org.greenrobot.eventbus.c.a().c(this);
    }

    @m(a = ThreadMode.MAIN_ORDERED)
    public void onEvent(FinishBgActivityEvent finishBgActivityEvent) {
        LogUtils.i(this.a, "onEvent(FinishBgActivityEvent event)");
        if (isFinishing()) {
            return;
        }
        LogUtils.i(this.a, "do finish()");
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        LogUtils.i(this.a, "onResume");
        super.onResume();
        if (rc.a().e() == -1) {
            LogUtils.i(this.a, "BgActivity onResume() PARKING_TYPE_IDLE 当前界面空闲, finish BgActivity");
            if (isFinishing()) {
                return;
            }
            LogUtils.i(this.a, "do finish()");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        LogUtils.i(this.a, "onPause");
        super.onPause();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        LogUtils.i(this.a, "onBackPressed");
        if ("e28".equals("d55")) {
            org.greenrobot.eventbus.c.a().d(new BackPressedEvent());
        }
    }
}
