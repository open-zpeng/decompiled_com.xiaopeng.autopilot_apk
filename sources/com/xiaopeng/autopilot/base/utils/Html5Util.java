package com.xiaopeng.autopilot.base.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.JavascriptInterface;
/* loaded from: classes.dex */
public class Html5Util {
    public static final String ACTION_OPEN_SHARE_VIEW = "openShareView";
    public static final String ACTION_SET_PAGE_TITLE = "setPageTitle";
    public static final String ACTION_SET_SHARE_INFO = "setShareInfo";
    protected final Context mApp;
    private IOnActionListener mOnActionListener;

    /* loaded from: classes.dex */
    public interface IOnActionListener {
        void onAction(String str, String str2);
    }

    public Html5Util(Context context) {
        this.mApp = context;
    }

    @JavascriptInterface
    public void setPageTitle(String str) {
        this.mOnActionListener.onAction(ACTION_SET_PAGE_TITLE, str);
    }

    @JavascriptInterface
    public int isInstallApplication(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = this.mApp.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo == null ? 0 : 1;
    }

    @JavascriptInterface
    public int openApplication(String str) {
        Intent launchIntentForPackage;
        if (isInstallApplication(str) != 1 || (launchIntentForPackage = this.mApp.getPackageManager().getLaunchIntentForPackage(str)) == null) {
            return 0;
        }
        IntentUtil.startActivityByApp(this.mApp, launchIntentForPackage);
        return 1;
    }

    @JavascriptInterface
    public void launchBrowser(String str) {
        IntentUtil.startActivityByApp(this.mApp, new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private void doAction(final String str, final String str2) {
        rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.base.utils.Html5Util.1
            @Override // java.lang.Runnable
            public void run() {
                if (Html5Util.this.mOnActionListener != null) {
                    Html5Util.this.mOnActionListener.onAction(str, str2);
                }
            }
        });
    }

    @JavascriptInterface
    public void setShareInfo(String str) {
        doAction(ACTION_SET_SHARE_INFO, str);
    }

    @JavascriptInterface
    public void openShareView() {
        doAction(ACTION_OPEN_SHARE_VIEW, null);
    }

    public void setOnActionListener(IOnActionListener iOnActionListener) {
        this.mOnActionListener = iOnActionListener;
    }
}
