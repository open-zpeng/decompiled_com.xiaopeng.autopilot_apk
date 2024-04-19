package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import defpackage.i;
/* compiled from: ContextThemeWrapper.java */
/* renamed from: t  reason: default package */
/* loaded from: classes.dex */
public class t extends ContextWrapper {
    private int a;
    private Resources.Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    public t() {
        super(null);
    }

    public t(Context context, int i) {
        super(context);
        this.a = i;
    }

    public t(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void a(Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    private Resources a() {
        if (this.e == null) {
            if (this.d == null) {
                this.e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.e = createConfigurationContext(this.d).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration = new Configuration(resources.getConfiguration());
                configuration.updateFrom(this.d);
                this.e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
            }
        }
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            b();
        }
    }

    public int getThemeResId() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = i.C0065i.Theme_AppCompat_Light;
        }
        b();
        return this.b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.c == null) {
                this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.c;
        }
        return getBaseContext().getSystemService(str);
    }

    protected void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void b() {
        boolean z = this.b == null;
        if (z) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        a(this.b, this.a, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
