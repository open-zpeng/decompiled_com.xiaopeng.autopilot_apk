package defpackage;

import com.badlogic.gdx.utils.k;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: VertexAttributes.java */
/* renamed from: kt  reason: default package */
/* loaded from: classes.dex */
public final class kt implements Comparable<kt>, Iterable<ks> {
    public final int a;
    private final ks[] b;
    private long c = -1;
    private a<ks> d;

    public kt(ks... ksVarArr) {
        if (ksVarArr.length == 0) {
            throw new IllegalArgumentException("attributes must be >= 1");
        }
        ks[] ksVarArr2 = new ks[ksVarArr.length];
        for (int i = 0; i < ksVarArr.length; i++) {
            ksVarArr2[i] = ksVarArr[i];
        }
        this.b = ksVarArr2;
        this.a = d();
    }

    public ks a(int i) {
        int a2 = a();
        for (int i2 = 0; i2 < a2; i2++) {
            if (b(i2).a == i) {
                return b(i2);
            }
        }
        return null;
    }

    private int d() {
        int i = 0;
        int i2 = 0;
        while (true) {
            ks[] ksVarArr = this.b;
            if (i >= ksVarArr.length) {
                return i2;
            }
            ks ksVar = ksVarArr[i];
            ksVar.e = i2;
            i2 += ksVar.h();
            i++;
        }
    }

    public int a() {
        return this.b.length;
    }

    public ks b(int i) {
        return this.b[i];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.b.length; i++) {
            sb.append("(");
            sb.append(this.b[i].f);
            sb.append(", ");
            sb.append(this.b[i].a);
            sb.append(", ");
            sb.append(this.b[i].b);
            sb.append(", ");
            sb.append(this.b[i].e);
            sb.append(")");
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kt)) {
            return false;
        }
        kt ktVar = (kt) obj;
        if (this.b.length != ktVar.b.length) {
            return false;
        }
        int i = 0;
        while (true) {
            ks[] ksVarArr = this.b;
            if (i >= ksVarArr.length) {
                return true;
            }
            if (!ksVarArr[i].a(ktVar.b[i])) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        ks[] ksVarArr;
        long length = this.b.length * 61;
        int i = 0;
        while (true) {
            if (i >= this.b.length) {
                return (int) (length ^ (length >> 32));
            }
            length = (length * 61) + ksVarArr[i].hashCode();
            i++;
        }
    }

    public long b() {
        if (this.c == -1) {
            long j = 0;
            int i = 0;
            while (true) {
                ks[] ksVarArr = this.b;
                if (i >= ksVarArr.length) {
                    break;
                }
                j |= ksVarArr[i].a;
                i++;
            }
            this.c = j;
        }
        return this.c;
    }

    public long c() {
        return b() | (this.b.length << 32);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(kt ktVar) {
        ks[] ksVarArr = this.b;
        int length = ksVarArr.length;
        ks[] ksVarArr2 = ktVar.b;
        if (length != ksVarArr2.length) {
            return ksVarArr.length - ksVarArr2.length;
        }
        int i = (b() > ktVar.b() ? 1 : (b() == ktVar.b() ? 0 : -1));
        if (i != 0) {
            return i < 0 ? -1 : 1;
        }
        for (int length2 = this.b.length - 1; length2 >= 0; length2--) {
            ks ksVar = this.b[length2];
            ks ksVar2 = ktVar.b[length2];
            if (ksVar.a != ksVar2.a) {
                return ksVar.a - ksVar2.a;
            }
            if (ksVar.g != ksVar2.g) {
                return ksVar.g - ksVar2.g;
            }
            if (ksVar.b != ksVar2.b) {
                return ksVar.b - ksVar2.b;
            }
            if (ksVar.c != ksVar2.c) {
                return ksVar.c ? 1 : -1;
            } else if (ksVar.d != ksVar2.d) {
                return ksVar.d - ksVar2.d;
            }
        }
        return 0;
    }

    @Override // java.lang.Iterable
    public Iterator<ks> iterator() {
        if (this.d == null) {
            this.d = new a<>(this.b);
        }
        return this.d.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VertexAttributes.java */
    /* renamed from: kt$b */
    /* loaded from: classes.dex */
    public static class b<T> implements Iterable<T>, Iterator<T> {
        int a;
        boolean b = true;
        private final T[] c;

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this;
        }

        public b(T[] tArr) {
            this.c = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b) {
                return this.a < this.c.length;
            }
            throw new k("#iterator() cannot be used nested.");
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.a;
            T[] tArr = this.c;
            if (i >= tArr.length) {
                throw new NoSuchElementException(String.valueOf(i));
            }
            if (!this.b) {
                throw new k("#iterator() cannot be used nested.");
            }
            this.a = i + 1;
            return tArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new k("Remove not allowed.");
        }
    }

    /* compiled from: VertexAttributes.java */
    /* renamed from: kt$a */
    /* loaded from: classes.dex */
    private static class a<T> implements Iterable<T> {
        private final T[] a;
        private b b;
        private b c;

        public a(T[] tArr) {
            this.a = tArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            if (this.b == null) {
                this.b = new b(this.a);
                this.c = new b(this.a);
            }
            if (!this.b.b) {
                b bVar = this.b;
                bVar.a = 0;
                bVar.b = true;
                this.c.b = false;
                return bVar;
            }
            b bVar2 = this.c;
            bVar2.a = 0;
            bVar2.b = true;
            this.b.b = false;
            return bVar2;
        }
    }
}
