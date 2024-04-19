package defpackage;
/* compiled from: SevenZMethodConfiguration.java */
/* renamed from: afs  reason: default package */
/* loaded from: classes.dex */
public class afs {
    private final afr a;
    private final Object b;

    public afs(afr afrVar) {
        this(afrVar, null);
    }

    public afs(afr afrVar, Object obj) {
        this.a = afrVar;
        this.b = obj;
        if (obj == null || afl.a(afrVar).a(obj)) {
            return;
        }
        throw new IllegalArgumentException("The " + afrVar + " method doesn't support options of type " + obj.getClass());
    }

    public afr a() {
        return this.a;
    }

    public Object b() {
        return this.b;
    }
}
