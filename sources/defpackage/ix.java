package defpackage;
/* compiled from: AssetDescriptor.java */
/* renamed from: ix  reason: default package */
/* loaded from: classes.dex */
public class ix<T> {
    public final String a;
    public final Class<T> b;
    public final iz c;
    public jy d;

    public ix(String str, Class<T> cls) {
        this(str, cls, (iz) null);
    }

    public ix(jy jyVar, Class<T> cls) {
        this(jyVar, cls, (iz) null);
    }

    public ix(String str, Class<T> cls, iz<T> izVar) {
        this.a = str.replaceAll("\\\\", "/");
        this.b = cls;
        this.c = izVar;
    }

    public ix(jy jyVar, Class<T> cls, iz<T> izVar) {
        this.a = jyVar.path().replaceAll("\\\\", "/");
        this.d = jyVar;
        this.b = cls;
        this.c = izVar;
    }

    public String toString() {
        return this.a + ", " + this.b.getName();
    }
}
