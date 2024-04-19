package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* compiled from: ActionProvider.java */
/* renamed from: fr  reason: default package */
/* loaded from: classes.dex */
public abstract class fr {
    private final Context a;
    private a b;
    private b c;

    /* compiled from: ActionProvider.java */
    /* renamed from: fr$a */
    /* loaded from: classes.dex */
    public interface a {
        void d(boolean z);
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: fr$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    public abstract View a();

    public void a(SubMenu subMenu) {
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public fr(Context context) {
        this.a = context;
    }

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(boolean z) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.d(z);
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(b bVar) {
        if (this.c != null && bVar != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = bVar;
    }

    public void f() {
        this.c = null;
        this.b = null;
    }
}
