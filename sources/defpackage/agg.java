package defpackage;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.o;
import org.greenrobot.eventbus.c;
/* compiled from: ErrorDialogManager.java */
/* renamed from: agg  reason: default package */
/* loaded from: classes.dex */
public class agg {
    public static age<?> a;

    /* compiled from: ErrorDialogManager.java */
    /* renamed from: agg$a */
    /* loaded from: classes.dex */
    public static class a extends e {
        protected boolean a;
        protected Bundle b;
        private c c;
        private boolean d;
        private Object e;

        @Override // androidx.fragment.app.e
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.c = agg.a.a.a();
            this.c.a(this);
            this.d = true;
        }

        @Override // androidx.fragment.app.e
        public void onResume() {
            super.onResume();
            if (this.d) {
                this.d = false;
                return;
            }
            this.c = agg.a.a.a();
            this.c.a(this);
        }

        @Override // androidx.fragment.app.e
        public void onPause() {
            this.c.c(this);
            super.onPause();
        }

        public void onEventMainThread(agi agiVar) {
            if (agg.b(this.e, agiVar)) {
                agg.a(agiVar);
                o fragmentManager = getFragmentManager();
                fragmentManager.b();
                d dVar = (d) fragmentManager.b("de.greenrobot.eventbus.error_dialog");
                if (dVar != null) {
                    dVar.dismiss();
                }
                d dVar2 = (d) agg.a.a(agiVar, this.a, this.b);
                if (dVar2 != null) {
                    dVar2.show(fragmentManager, "de.greenrobot.eventbus.error_dialog");
                }
            }
        }
    }

    protected static void a(agi agiVar) {
        if (a.a.f) {
            String str = a.a.g;
            if (str == null) {
                str = c.a;
            }
            Log.i(str, "Error dialog manager received exception", agiVar.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Object obj, agi agiVar) {
        Object b;
        return agiVar == null || (b = agiVar.b()) == null || b.equals(obj);
    }
}
