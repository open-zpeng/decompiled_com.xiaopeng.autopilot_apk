package defpackage;

import com.badlogic.gdx.utils.aa;
import com.badlogic.gdx.utils.w;
import com.badlogic.gdx.utils.y;
import defpackage.qc;
import java.util.Iterator;
/* compiled from: Selection.java */
/* renamed from: qk  reason: default package */
/* loaded from: classes.dex */
public class qk<T> implements Iterable<T> {
    final y<T> a;
    T b;
    private ok c;
    private final y<T> d;
    private boolean e;

    protected void a() {
    }

    public T b() {
        if (this.a.a == 0) {
            return null;
        }
        return this.a.b();
    }

    void c() {
        this.d.a();
        this.d.a((w) this.a);
    }

    void d() {
        this.a.a();
        this.a.a((w) this.d);
    }

    void e() {
        this.d.b(32);
    }

    public void f() {
        if (this.a.a == 0) {
            return;
        }
        c();
        this.a.a();
        if (this.e && g()) {
            d();
        } else {
            this.b = null;
            a();
        }
        e();
    }

    public boolean g() {
        if (this.c == null) {
            return false;
        }
        qc.a aVar = (qc.a) aa.b(qc.a.class);
        try {
            return this.c.a(aVar);
        } finally {
            aa.a(aVar);
        }
    }

    public boolean a(T t) {
        if (t == null) {
            return false;
        }
        return this.a.d((y<T>) t);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.a.iterator();
    }

    public String toString() {
        return this.a.toString();
    }
}
