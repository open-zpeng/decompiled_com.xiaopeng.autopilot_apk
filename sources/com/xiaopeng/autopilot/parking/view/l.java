package com.xiaopeng.autopilot.parking.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.autopilot.parking.e;
import com.xiaopeng.lib.themeswitch.ThemeWatcher;
import com.xiaopeng.xui.widget.XImageButton;
/* compiled from: ParkingAttentionView.java */
/* loaded from: classes.dex */
public class l extends t implements ThemeWatcher.OnThemeSwitchListener {
    private RelativeLayout c;
    private XImageButton d;
    private TextView e;
    private a f;
    private com.xiaopeng.autopilot.parking.b g;

    /* compiled from: ParkingAttentionView.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public l(Context context) {
        super(context);
    }

    @Override // com.xiaopeng.autopilot.parking.view.t
    protected void a() {
        LayoutInflater.from(getContext()).inflate(e.f.layout_parking_attention, (ViewGroup) this, true);
        this.c = (RelativeLayout) findViewById(e.C0055e.rl_main);
        this.b = (WebView) this.c.findViewById(e.C0055e.web);
        this.e = (TextView) this.c.findViewById(e.C0055e.title);
        this.d = (XImageButton) this.c.findViewById(e.C0055e.btn_ok);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.f.a();
            }
        });
        this.b.setFocusable(false);
        this.b.setFocusableInTouchMode(false);
        b();
        setOnTouchListener(new View.OnTouchListener() { // from class: com.xiaopeng.autopilot.parking.view.l.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l lVar = l.this;
                if (lVar.a(lVar.c, (int) motionEvent.getX(), (int) motionEvent.getY()) || l.this.g == null) {
                    return true;
                }
                l.this.g.a();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i >= i3 && i <= view.getMeasuredWidth() + i3;
    }

    public void setAttentionListener(com.xiaopeng.autopilot.parking.b bVar) {
        this.g = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.autopilot.parking.view.t
    public void a(int i) {
        String carType = getCarType();
        this.a = "file:///android_asset/key_parking/parking.html?topic=xpilot&initIndex=" + i + "&hideLeftBar=false&carType=" + carType + "&configCode=" + com.xiaopeng.autopilot.base.d.i();
        this.b.loadUrl(this.a);
        Log.i("tyler.tang", this.a);
    }

    private String getCarType() {
        try {
            return com.xiaopeng.autopilot.base.c.a().c().getXpCduType();
        } catch (Exception e) {
            e.printStackTrace();
            return "A1";
        }
    }

    @Override // com.xiaopeng.lib.themeswitch.ThemeWatcher.OnThemeSwitchListener
    public void onSwitchTheme(int i) {
        WebView webView = this.b;
        webView.evaluateJavascript("javascript:onThemeChange(" + i + ")", new ValueCallback<String>() { // from class: com.xiaopeng.autopilot.parking.view.l.3
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                Log.i("onSwitchTheme", str);
            }
        });
        b();
    }

    private void b() {
        if (!ThemeWatcher.getInstance().isNight()) {
            this.c.setBackgroundResource(e.d.attention_big_bg_day);
            this.e.setTextColor(-15788768);
            return;
        }
        this.c.setBackgroundResource(e.d.attention_big_bg_night);
        this.e.setTextColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.autopilot.parking.view.t, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        if (getParent() != null) {
            super.onAttachedToWindow();
        }
        b();
        ThemeWatcher.getInstance().addThemeSwitchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.autopilot.parking.view.t, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().removeThemeListener(this);
        if (this.b != null) {
            this.b.destroy();
            this.b = null;
        }
    }

    public void setOnOkListener(a aVar) {
        this.f = aVar;
    }
}
