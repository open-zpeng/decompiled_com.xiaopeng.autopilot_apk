package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: WidgetGroup.java */
/* renamed from: cw  reason: default package */
/* loaded from: classes.dex */
public class cw {
    static int b;
    int c;
    int e;
    ArrayList<bz> a = new ArrayList<>();
    boolean d = false;
    ArrayList<a> f = null;
    private int g = -1;

    public cw(int i) {
        this.c = -1;
        this.e = 0;
        int i2 = b;
        b = i2 + 1;
        this.c = i2;
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public int b() {
        return this.c;
    }

    public boolean a(bz bzVar) {
        if (this.a.contains(bzVar)) {
            return false;
        }
        this.a.add(bzVar);
        return true;
    }

    public void a(boolean z) {
        this.d = z;
    }

    private String c() {
        int i = this.e;
        return i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown";
    }

    public String toString() {
        Iterator<bz> it;
        String str = c() + " [" + this.c + "] <";
        while (this.a.iterator().hasNext()) {
            str = str + " " + it.next().C();
        }
        return str + " >";
    }

    public void a(int i, cw cwVar) {
        Iterator<bz> it = this.a.iterator();
        while (it.hasNext()) {
            bz next = it.next();
            cwVar.a(next);
            if (i == 0) {
                next.av = cwVar.b();
            } else {
                next.aw = cwVar.b();
            }
        }
        this.g = cwVar.c;
    }

    public int a(az azVar, int i) {
        if (this.a.size() == 0) {
            return 0;
        }
        return a(azVar, this.a, i);
    }

    private int a(az azVar, ArrayList<bz> arrayList, int i) {
        ca caVar = (ca) arrayList.get(0).A();
        azVar.b();
        caVar.a(azVar, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).a(azVar, false);
        }
        if (i == 0 && caVar.aF > 0) {
            bw.a(caVar, azVar, arrayList, 0);
        }
        if (i == 1 && caVar.aG > 0) {
            bw.a(caVar, azVar, arrayList, 1);
        }
        try {
            azVar.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.f.add(new a(arrayList.get(i3), azVar, i));
        }
        if (i == 0) {
            int b2 = azVar.b(caVar.z);
            int b3 = azVar.b(caVar.B);
            azVar.b();
            return b3 - b2;
        }
        int b4 = azVar.b(caVar.A);
        int b5 = azVar.b(caVar.C);
        azVar.b();
        return b5 - b4;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(ArrayList<cw> arrayList) {
        int size = this.a.size();
        if (this.g != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                cw cwVar = arrayList.get(i);
                if (this.g == cwVar.c) {
                    a(this.e, cwVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WidgetGroup.java */
    /* renamed from: cw$a */
    /* loaded from: classes.dex */
    public class a {
        WeakReference<bz> a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;

        public a(bz bzVar, az azVar, int i) {
            this.a = new WeakReference<>(bzVar);
            this.b = azVar.b(bzVar.z);
            this.c = azVar.b(bzVar.A);
            this.d = azVar.b(bzVar.B);
            this.e = azVar.b(bzVar.C);
            this.f = azVar.b(bzVar.D);
            this.g = i;
        }
    }
}
