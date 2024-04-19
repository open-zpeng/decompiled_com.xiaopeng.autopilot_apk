package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ai;
/* loaded from: classes.dex */
public interface AndroidApplicationBase extends ij {
    public static final int MINIMUM_SDK = 9;

    Window getApplicationWindow();

    Context getContext();

    a<Runnable> getExecutedRunnables();

    Handler getHandler();

    AndroidInput getInput();

    ai<iu> getLifecycleListeners();

    a<Runnable> getRunnables();

    WindowManager getWindowManager();

    void runOnUiThread(Runnable runnable);

    void startActivity(Intent intent);

    void useImmersiveMode(boolean z);
}
