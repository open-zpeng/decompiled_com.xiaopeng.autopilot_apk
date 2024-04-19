package defpackage;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import defpackage.r;
import java.lang.ref.WeakReference;
/* compiled from: StandaloneActionMode.java */
/* renamed from: u  reason: default package */
/* loaded from: classes.dex */
public class u extends r implements g.a {
    private Context a;
    private ActionBarContextView b;
    private r.a c;
    private WeakReference<View> d;
    private boolean e;
    private boolean f;
    private g g;

    public u(Context context, ActionBarContextView actionBarContextView, r.a aVar, boolean z) {
        this.a = context;
        this.b = actionBarContextView;
        this.c = aVar;
        this.g = new g(actionBarContextView.getContext()).a(1);
        this.g.a(this);
        this.f = z;
    }

    @Override // defpackage.r
    public void b(CharSequence charSequence) {
        this.b.setTitle(charSequence);
    }

    @Override // defpackage.r
    public void a(CharSequence charSequence) {
        this.b.setSubtitle(charSequence);
    }

    @Override // defpackage.r
    public void a(int i) {
        b(this.a.getString(i));
    }

    @Override // defpackage.r
    public void b(int i) {
        a((CharSequence) this.a.getString(i));
    }

    @Override // defpackage.r
    public void a(boolean z) {
        super.a(z);
        this.b.setTitleOptional(z);
    }

    @Override // defpackage.r
    public boolean h() {
        return this.b.d();
    }

    @Override // defpackage.r
    public void a(View view) {
        this.b.setCustomView(view);
        this.d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // defpackage.r
    public void d() {
        this.c.b(this, this.g);
    }

    @Override // defpackage.r
    public void c() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.b.sendAccessibilityEvent(32);
        this.c.a(this);
    }

    @Override // defpackage.r
    public Menu b() {
        return this.g;
    }

    @Override // defpackage.r
    public CharSequence f() {
        return this.b.getTitle();
    }

    @Override // defpackage.r
    public CharSequence g() {
        return this.b.getSubtitle();
    }

    @Override // defpackage.r
    public View i() {
        WeakReference<View> weakReference = this.d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // defpackage.r
    public MenuInflater a() {
        return new w(this.b.getContext());
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.c.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void a(g gVar) {
        d();
        this.b.a();
    }
}
