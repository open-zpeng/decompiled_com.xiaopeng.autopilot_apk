package defpackage;

import com.badlogic.gdx.utils.a;
import java.util.Comparator;
import java.util.Iterator;
/* compiled from: Attributes.java */
/* renamed from: kv  reason: default package */
/* loaded from: classes.dex */
public class kv implements Comparable<kv>, Iterable<ku>, Comparator<ku> {
    protected long a;
    protected final a<ku> b = new a<>();
    protected boolean c = true;

    public final void a() {
        if (this.c) {
            return;
        }
        this.b.a(this);
        this.c = true;
    }

    public final long b() {
        return this.a;
    }

    public final ku a(long j) {
        if (c(j)) {
            for (int i = 0; i < this.b.b; i++) {
                if (this.b.a(i).a == j) {
                    return this.b.a(i);
                }
            }
            return null;
        }
        return null;
    }

    public final <T extends ku> T a(Class<T> cls, long j) {
        return (T) a(j);
    }

    public void c() {
        this.a = 0L;
        this.b.d();
    }

    private final void e(long j) {
        this.a = j | this.a;
    }

    private final void f(long j) {
        this.a = (~j) & this.a;
    }

    public final void a(ku kuVar) {
        int d = d(kuVar.a);
        if (d < 0) {
            e(kuVar.a);
            this.b.a((a<ku>) kuVar);
            this.c = false;
        } else {
            this.b.a(d, (int) kuVar);
        }
        a();
    }

    public final void a(Iterable<ku> iterable) {
        for (ku kuVar : iterable) {
            a(kuVar);
        }
    }

    public final void b(long j) {
        for (int i = this.b.b - 1; i >= 0; i--) {
            long j2 = this.b.a(i).a;
            if ((j & j2) == j2) {
                this.b.b(i);
                f(j2);
                this.c = false;
            }
        }
        a();
    }

    public final boolean c(long j) {
        return j != 0 && (this.a & j) == j;
    }

    protected int d(long j) {
        if (c(j)) {
            for (int i = 0; i < this.b.b; i++) {
                if (this.b.a(i).a == j) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    public final boolean a(kv kvVar, boolean z) {
        if (kvVar == this) {
            return true;
        }
        if (kvVar == null || this.a != kvVar.a) {
            return false;
        }
        if (z) {
            a();
            kvVar.a();
            for (int i = 0; i < this.b.b; i++) {
                if (!this.b.a(i).a(kvVar.b.a(i))) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public final int compare(ku kuVar, ku kuVar2) {
        return (int) (kuVar.a - kuVar2.a);
    }

    @Override // java.lang.Iterable
    public final Iterator<ku> iterator() {
        return this.b.iterator();
    }

    public int d() {
        a();
        int i = this.b.b;
        long j = this.a + 71;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 7) & 65535;
            j += this.a * this.b.a(i3).hashCode() * i2;
        }
        return (int) (j ^ (j >> 32));
    }

    public int hashCode() {
        return d();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof kv) {
            if (obj == this) {
                return true;
            }
            return a((kv) obj, true);
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(kv kvVar) {
        if (kvVar == this) {
            return 0;
        }
        long j = this.a;
        long j2 = kvVar.a;
        if (j != j2) {
            return j < j2 ? -1 : 1;
        }
        a();
        kvVar.a();
        for (int i = 0; i < this.b.b; i++) {
            int compareTo = this.b.a(i).compareTo(kvVar.b.a(i));
            if (compareTo != 0) {
                if (compareTo < 0) {
                    return -1;
                }
                return compareTo > 0 ? 1 : 0;
            }
        }
        return 0;
    }
}
