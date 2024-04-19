package defpackage;

import android.graphics.Typeface;
import android.os.Handler;
import defpackage.fh;
import defpackage.fi;
/* compiled from: CallbackWithHandler.java */
/* renamed from: fd  reason: default package */
/* loaded from: classes.dex */
class fd {
    private final fi.c a;
    private final Handler b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(fi.c cVar, Handler handler) {
        this.a = cVar;
        this.b = handler;
    }

    private void a(final Typeface typeface) {
        final fi.c cVar = this.a;
        this.b.post(new Runnable() { // from class: fd.1
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(typeface);
            }
        });
    }

    private void a(final int i) {
        final fi.c cVar = this.a;
        this.b.post(new Runnable() { // from class: fd.2
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(fh.a aVar) {
        if (aVar.a()) {
            a(aVar.a);
        } else {
            a(aVar.b);
        }
    }
}
