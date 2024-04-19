package defpackage;
/* compiled from: ObjectHelper.java */
/* renamed from: aeb  reason: default package */
/* loaded from: classes.dex */
public final class aeb {
    static final adq<Object, Object> a = new a();

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int a(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }

    /* compiled from: ObjectHelper.java */
    /* renamed from: aeb$a */
    /* loaded from: classes.dex */
    static final class a implements adq<Object, Object> {
        a() {
        }
    }
}
