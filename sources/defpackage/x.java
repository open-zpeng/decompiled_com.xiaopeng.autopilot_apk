package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* renamed from: x  reason: default package */
/* loaded from: classes.dex */
public class x {
    gs b;
    private Interpolator d;
    private boolean e;
    private long c = -1;
    private final gt f = new gt() { // from class: x.1
        private boolean b = false;
        private int c = 0;

        @Override // defpackage.gt, defpackage.gs
        public void a(View view) {
            if (this.b) {
                return;
            }
            this.b = true;
            if (x.this.b != null) {
                x.this.b.a(null);
            }
        }

        void a() {
            this.c = 0;
            this.b = false;
            x.this.b();
        }

        @Override // defpackage.gt, defpackage.gs
        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == x.this.a.size()) {
                if (x.this.b != null) {
                    x.this.b.b(null);
                }
                a();
            }
        }
    };
    final ArrayList<gr> a = new ArrayList<>();

    public x a(gr grVar) {
        if (!this.e) {
            this.a.add(grVar);
        }
        return this;
    }

    public x a(gr grVar, gr grVar2) {
        this.a.add(grVar);
        grVar2.b(grVar.a());
        this.a.add(grVar2);
        return this;
    }

    public void a() {
        if (this.e) {
            return;
        }
        Iterator<gr> it = this.a.iterator();
        while (it.hasNext()) {
            gr next = it.next();
            long j = this.c;
            if (j >= 0) {
                next.a(j);
            }
            Interpolator interpolator = this.d;
            if (interpolator != null) {
                next.a(interpolator);
            }
            if (this.b != null) {
                next.a(this.f);
            }
            next.c();
        }
        this.e = true;
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator<gr> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    public x a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public x a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public x a(gs gsVar) {
        if (!this.e) {
            this.b = gsVar;
        }
        return this;
    }
}
