package defpackage;
/* compiled from: Pools.java */
/* renamed from: bb  reason: default package */
/* loaded from: classes.dex */
final class bb {

    /* compiled from: Pools.java */
    /* renamed from: bb$a */
    /* loaded from: classes.dex */
    interface a<T> {
        T a();

        void a(T[] tArr, int i);

        boolean a(T t);
    }

    /* compiled from: Pools.java */
    /* renamed from: bb$b */
    /* loaded from: classes.dex */
    static class b<T> implements a<T> {
        private final Object[] a;
        private int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.a = new Object[i];
        }

        @Override // defpackage.bb.a
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

        @Override // defpackage.bb.a
        public boolean a(T t) {
            int i = this.b;
            Object[] objArr = this.a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.b = i + 1;
                return true;
            }
            return false;
        }

        @Override // defpackage.bb.a
        public void a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = this.b;
                Object[] objArr = this.a;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.b = i3 + 1;
                }
            }
        }
    }
}
