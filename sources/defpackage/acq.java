package defpackage;

import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.z;
/* compiled from: Pool.java */
/* renamed from: acq  reason: default package */
/* loaded from: classes.dex */
public abstract class acq<T> {
    private final a<T> a;
    public final int c;
    public int d;

    protected abstract T b();

    public a<T> c() {
        return this.a;
    }

    public acq() {
        this(16, Integer.MAX_VALUE);
    }

    public acq(int i, int i2) {
        this.a = new a<>(false, i);
        this.c = i2;
    }

    public T d() {
        return this.a.b == 0 ? b() : this.a.a();
    }

    public void b(T t) {
        if (t == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        if (this.a.b < this.c) {
            this.a.a((a<T>) t);
            this.d = Math.max(this.d, this.a.b);
        }
        a((acq<T>) t);
    }

    protected void a(T t) {
        if (t instanceof z.a) {
            ((z.a) t).reset();
        }
    }

    public void a(a<T> aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("objects cannot be null.");
        }
        a<T> aVar2 = this.a;
        int i = this.c;
        for (int i2 = 0; i2 < aVar.b; i2++) {
            T a = aVar.a(i2);
            if (a != null) {
                if (aVar2.b < i) {
                    aVar2.a((a<T>) a);
                }
                a((acq<T>) a);
            }
        }
        this.d = Math.max(this.d, aVar2.b);
    }

    public void e() {
        this.a.d();
    }
}
