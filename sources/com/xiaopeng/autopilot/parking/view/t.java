package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.xui.widget.XLoading;
/* compiled from: WebContainer.java */
/* loaded from: classes.dex */
public abstract class t extends RelativeLayout {
    protected String a;
    protected WebView b;
    private XLoading c;

    protected abstract void a();

    protected abstract void a(int i);

    /* compiled from: WebContainer.java */
    /* loaded from: classes.dex */
    private class a {
        private a() {
        }

        @JavascriptInterface
        public int getCurTheme() {
            int i = ThemeWatcher.getInstance().isNight() ? 2 : 1;
            Log.d("WebContainer", "JS call getCurTheme():" + i);
            return i;
        }
    }

    public t(Context context) {
        this(context, null);
    }

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public t(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
        WebView webView = this.b;
        if (webView == null) {
            return;
        }
        webView.setBackgroundColor(0);
        this.b.setHorizontalScrollBarEnabled(true);
        this.b.setVerticalScrollBarEnabled(true);
        WebSettings settings = this.b.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        WebView webView2 = this.b;
        webView2.evaluateJavascript("window.fontScale = " + getResources().getConfiguration().fontScale, new ValueCallback<String>() { // from class: com.xiaopeng.autopilot.parking.view.t.1
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                Log.i("WebContainer", "fontScale=" + str);
            }
        });
        this.b.addJavascriptInterface(new a(), "xpengBridge");
        this.c = new XLoading(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        this.c.setLayoutParams(layoutParams);
        this.b.setWebViewClient(new WebViewClient() { // from class: com.xiaopeng.autopilot.parking.view.t.2
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView3, String str, Bitmap bitmap) {
                super.onPageStarted(webView3, str, bitmap);
                t tVar = t.this;
                tVar.addView(tVar.c);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView3, String str) {
                super.onPageFinished(webView3, str);
                rh.a().b(new Runnable() { // from class: com.xiaopeng.autopilot.parking.view.t.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (t.this.c == null || t.this.c.getParent() == null) {
                            return;
                        }
                        ((ViewGroup) t.this.c.getParent()).removeView(t.this.c);
                    }
                }, 320L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XLoading xLoading = this.c;
        if (xLoading == null || xLoading.getParent() == null) {
            return;
        }
        ((ViewGroup) this.c.getParent()).removeView(this.c);
    }
}
