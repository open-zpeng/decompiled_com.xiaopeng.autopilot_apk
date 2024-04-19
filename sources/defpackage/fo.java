package defpackage;
/* compiled from: Pools.java */
/* renamed from: fo  reason: default package */
/* loaded from: classes.dex */
public final class fo {

    /* compiled from: Pools.java */
    /* renamed from: fo$a */
    /* loaded from: classes.dex */
    public interface a<T> {
        T a();

        boolean a(T t);
    }

    /* compiled from: Pools.java */
    /* renamed from: fo$b */
    /* loaded from: classes.dex */
    public static class b<T> implements a<T> {
        private final Object[] a;
        private int b;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.a = new Object[i];
        }

        @Override // defpackage.fo.a
        public T a() {
            int i = this.b;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.a;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.b = i - 1;
                return t;
            }
            return null;
        }

        @Override // defpackage.fo.a
        public boolean a(T t) {
            if (b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.b;
            Object[] objArr = this.a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.b = i + 1;
                return true;
            }
            return false;
        }

        private boolean b(T t) {
            for (int i = 0; i < this.b; i++) {
                if (this.a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}
