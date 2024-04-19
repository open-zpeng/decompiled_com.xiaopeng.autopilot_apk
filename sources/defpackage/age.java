package defpackage;

import android.os.Bundle;
/* compiled from: ErrorDialogFragmentFactory.java */
/* renamed from: age  reason: default package */
/* loaded from: classes.dex */
public abstract class age<T> {
    protected final agd a;

    protected abstract T a(agi agiVar, Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public T a(agi agiVar, boolean z, Bundle bundle) {
        Bundle bundle2;
        if (agiVar.a()) {
            return null;
        }
        if (bundle != null) {
            bundle2 = (Bundle) bundle.clone();
        } else {
            bundle2 = new Bundle();
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.title")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.title", b(agiVar, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.message")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.message", c(agiVar, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog")) {
            bundle2.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", z);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close") && this.a.i != null) {
            bundle2.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", this.a.i);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.icon_id") && this.a.h != 0) {
            bundle2.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.a.h);
        }
        return a(agiVar, bundle2);
    }

    protected String b(agi agiVar, Bundle bundle) {
        return this.a.a.getString(this.a.b);
    }

    protected String c(agi agiVar, Bundle bundle) {
        return this.a.a.getString(this.a.a(agiVar.a));
    }
}
