package com.xiaopeng.autopilot.base.utils;

import android.os.Build;
import com.xiaopeng.lib.utils.LogUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class WebViewUtil {
    private static final String TAG = "WebViewUtil";

    public static void hookWebView() {
        Method declaredMethod;
        int i = Build.VERSION.SDK_INT;
        try {
            Class<?> cls = Class.forName("android.webkit.WebViewFactory");
            Field declaredField = cls.getDeclaredField("sProviderInstance");
            declaredField.setAccessible(true);
            if (declaredField.get(null) != null) {
                LogUtils.i(TAG, "sProviderInstance isn't null");
                return;
            }
            if (i > 22) {
                declaredMethod = cls.getDeclaredMethod("getProviderClass", new Class[0]);
            } else if (i == 22) {
                declaredMethod = cls.getDeclaredMethod("getFactoryClass", new Class[0]);
            } else {
                LogUtils.i(TAG, "Don't need to Hook WebView");
                return;
            }
            declaredMethod.setAccessible(true);
            Class cls2 = (Class) declaredMethod.invoke(cls, new Object[0]);
            Class<?> cls3 = Class.forName("android.webkit.WebViewDelegate");
            if (i >= 28) {
                Method method = cls2.getMethod("create", cls3);
                method.setAccessible(true);
                Constructor<?> declaredConstructor = cls3.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                Object invoke = method.invoke(null, declaredConstructor.newInstance(new Object[0]));
                LogUtils.i(TAG, "sProviderInstance:" + invoke);
                declaredField.set("sProviderInstance", invoke);
            } else {
                Constructor constructor = cls2.getConstructor(cls3);
                if (constructor != null) {
                    constructor.setAccessible(true);
                    Constructor<?> declaredConstructor2 = cls3.getDeclaredConstructor(new Class[0]);
                    declaredConstructor2.setAccessible(true);
                    Object newInstance = constructor.newInstance(declaredConstructor2.newInstance(new Object[0]));
                    LogUtils.i(TAG, "sProviderInstance:" + newInstance);
                    declaredField.set("sProviderInstance", newInstance);
                }
            }
            LogUtils.i(TAG, "Hook done!");
        } catch (Throwable th) {
            LogUtils.e(TAG, th);
        }
    }
}
