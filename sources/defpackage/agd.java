package defpackage;

import android.content.res.Resources;
import android.util.Log;
import org.greenrobot.eventbus.c;
/* compiled from: ErrorDialogConfig.java */
/* renamed from: agd  reason: default package */
/* loaded from: classes.dex */
public class agd {
    final Resources a;
    final int b;
    final int c;
    final agh d;
    c e;
    boolean f;
    String g;
    int h;
    Class<?> i;

    public int a(Throwable th) {
        Integer a = this.d.a(th);
        if (a != null) {
            return a.intValue();
        }
        String str = c.a;
        Log.d(str, "No specific message ressource ID found for " + th);
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a() {
        c cVar = this.e;
        return cVar != null ? cVar : c.a();
    }
}
