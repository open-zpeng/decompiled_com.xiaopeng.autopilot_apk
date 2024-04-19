package defpackage;

import android.util.Log;
import java.util.ArrayList;
/* compiled from: ModelBatchFixed127056.java */
/* renamed from: acj  reason: default package */
/* loaded from: classes.dex */
public class acj extends kz {
    private ArrayList<String> g;
    private a h;

    /* compiled from: ModelBatchFixed127056.java */
    /* renamed from: acj$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public acj(nm nmVar) {
        super(nmVar);
        this.g = new ArrayList<>();
    }

    public acj(String str, String str2) {
        super(str, str2);
        this.g = new ArrayList<>();
    }

    public acj() {
        this.g = new ArrayList<>();
    }

    @Override // defpackage.kz
    public void a() {
        this.f.a(this.a, this.c);
        ld ldVar = null;
        boolean z = false;
        for (int i = 0; i < this.c.b; i++) {
            lb a2 = this.c.a(i);
            if (ldVar != a2.f) {
                if (ldVar != null) {
                    ldVar.b();
                }
                ldVar = a2.f;
                ldVar.a(this.a, this.d);
            }
            if (this.g.contains(a2.b.a)) {
                z = true;
            } else {
                try {
                    ldVar.b(a2);
                } catch (Exception e) {
                    Log.e("ModelBatchFixed127056", "render exception", e);
                    if (a2.b != null) {
                        this.g.add(a2.b.a);
                        Log.e("ModelBatchFixed127056", a2.b.a);
                    }
                    if (a2.c != null) {
                        Log.e("ModelBatchFixed127056", a2.c.d);
                    }
                    if (a2.g != null) {
                        Log.e("ModelBatchFixed127056", a2.g.toString());
                    }
                    a aVar = this.h;
                    if (aVar != null) {
                        aVar.a();
                    }
                    z = true;
                }
            }
        }
        if (!z) {
            c();
        }
        if (ldVar != null) {
            ldVar.b();
        }
        this.b.c();
        this.c.d();
    }

    public void c() {
        this.g.clear();
    }

    public void d() {
        this.a = null;
    }
}
