package defpackage;
/* compiled from: DisplayCutoutCompat.java */
/* renamed from: ft  reason: default package */
/* loaded from: classes.dex */
public final class ft {
    private final Object a;

    private ft(Object obj) {
        this.a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return fn.a(this.a, ((ft) obj).a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.a + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ft a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new ft(obj);
    }
}
