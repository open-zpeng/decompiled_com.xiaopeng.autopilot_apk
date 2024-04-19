package defpackage;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import defpackage.r;
import java.util.ArrayList;
/* compiled from: SupportActionModeWrapper.java */
/* renamed from: v  reason: default package */
/* loaded from: classes.dex */
public class v extends ActionMode {
    final Context a;
    final r b;

    public v(Context context, r rVar) {
        this.a = context;
        this.b = rVar;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.j();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.d();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.a, (ew) this.b.b());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.b.f();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.a(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b.g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.b(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.i();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.a(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.a();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.k();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.b.a(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.h();
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* renamed from: v$a */
    /* loaded from: classes.dex */
    public static class a implements r.a {
        final ActionMode.Callback a;
        final Context b;
        final ArrayList<v> c = new ArrayList<>();
        final au<Menu, Menu> d = new au<>();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
        }

        @Override // defpackage.r.a
        public boolean a(r rVar, Menu menu) {
            return this.a.onCreateActionMode(b(rVar), a(menu));
        }

        @Override // defpackage.r.a
        public boolean b(r rVar, Menu menu) {
            return this.a.onPrepareActionMode(b(rVar), a(menu));
        }

        @Override // defpackage.r.a
        public boolean a(r rVar, MenuItem menuItem) {
            return this.a.onActionItemClicked(b(rVar), new j(this.b, (ex) menuItem));
        }

        @Override // defpackage.r.a
        public void a(r rVar) {
            this.a.onDestroyActionMode(b(rVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.d.get(menu);
            if (menu2 == null) {
                o oVar = new o(this.b, (ew) menu);
                this.d.put(menu, oVar);
                return oVar;
            }
            return menu2;
        }

        public ActionMode b(r rVar) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                v vVar = this.c.get(i);
                if (vVar != null && vVar.b == rVar) {
                    return vVar;
                }
            }
            v vVar2 = new v(this.b, rVar);
            this.c.add(vVar2);
            return vVar2;
        }
    }
}
