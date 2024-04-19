package defpackage;
/* compiled from: RefCountedContainer.java */
/* renamed from: jc  reason: default package */
/* loaded from: classes.dex */
public class jc {
    Object a;
    int b = 1;

    public jc(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
        this.a = obj;
    }

    public void a() {
        this.b++;
    }

    public void b() {
        this.b--;
    }

    public int c() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public <T> T a(Class<T> cls) {
        return (T) this.a;
    }
}
