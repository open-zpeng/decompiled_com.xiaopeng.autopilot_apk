package defpackage;

import defpackage.ki;
import defpackage.ko;
/* compiled from: TextureDescriptor.java */
/* renamed from: no  reason: default package */
/* loaded from: classes.dex */
public class no<T extends ki> implements Comparable<no<T>> {
    public T a;
    public ko.a b;
    public ko.a c;
    public ko.b d;
    public ko.b e;

    public no(T t, ko.a aVar, ko.a aVar2, ko.b bVar, ko.b bVar2) {
        this.a = null;
        a(t, aVar, aVar2, bVar, bVar2);
    }

    public no(T t) {
        this(t, null, null, null, null);
    }

    public no() {
        this.a = null;
    }

    public void a(T t, ko.a aVar, ko.a aVar2, ko.b bVar, ko.b bVar2) {
        this.a = t;
        this.b = aVar;
        this.c = aVar2;
        this.d = bVar;
        this.e = bVar2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T extends ki] */
    public <V extends T> void a(no<V> noVar) {
        this.a = noVar.a;
        this.b = noVar.b;
        this.c = noVar.c;
        this.d = noVar.d;
        this.e = noVar.e;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof no) {
            no noVar = (no) obj;
            return noVar.a == this.a && noVar.b == this.b && noVar.c == this.c && noVar.d == this.d && noVar.e == this.e;
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        long j = (t == null ? 0 : t.glTarget) * 811;
        T t2 = this.a;
        long textureObjectHandle = (j + (t2 == null ? 0 : t2.getTextureObjectHandle())) * 811;
        ko.a aVar = this.b;
        long gLEnum = (textureObjectHandle + (aVar == null ? 0 : aVar.getGLEnum())) * 811;
        ko.a aVar2 = this.c;
        long gLEnum2 = (gLEnum + (aVar2 == null ? 0 : aVar2.getGLEnum())) * 811;
        ko.b bVar = this.d;
        long gLEnum3 = (gLEnum2 + (bVar == null ? 0 : bVar.getGLEnum())) * 811;
        ko.b bVar2 = this.e;
        long gLEnum4 = gLEnum3 + (bVar2 != null ? bVar2.getGLEnum() : 0);
        return (int) ((gLEnum4 >> 32) ^ gLEnum4);
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(no<T> noVar) {
        if (noVar == this) {
            return 0;
        }
        T t = this.a;
        int i = t == null ? 0 : t.glTarget;
        T t2 = noVar.a;
        int i2 = t2 == null ? 0 : t2.glTarget;
        if (i != i2) {
            return i - i2;
        }
        T t3 = this.a;
        int textureObjectHandle = t3 == null ? 0 : t3.getTextureObjectHandle();
        T t4 = noVar.a;
        int textureObjectHandle2 = t4 == null ? 0 : t4.getTextureObjectHandle();
        if (textureObjectHandle != textureObjectHandle2) {
            return textureObjectHandle - textureObjectHandle2;
        }
        ko.a aVar = this.b;
        if (aVar != noVar.b) {
            int gLEnum = aVar == null ? 0 : aVar.getGLEnum();
            ko.a aVar2 = noVar.b;
            return gLEnum - (aVar2 != null ? aVar2.getGLEnum() : 0);
        }
        ko.a aVar3 = this.c;
        if (aVar3 != noVar.c) {
            int gLEnum2 = aVar3 == null ? 0 : aVar3.getGLEnum();
            ko.a aVar4 = noVar.c;
            return gLEnum2 - (aVar4 != null ? aVar4.getGLEnum() : 0);
        }
        ko.b bVar = this.d;
        if (bVar != noVar.d) {
            int gLEnum3 = bVar == null ? 0 : bVar.getGLEnum();
            ko.b bVar2 = noVar.d;
            return gLEnum3 - (bVar2 != null ? bVar2.getGLEnum() : 0);
        }
        ko.b bVar3 = this.e;
        if (bVar3 != noVar.e) {
            int gLEnum4 = bVar3 == null ? 0 : bVar3.getGLEnum();
            ko.b bVar4 = noVar.e;
            return gLEnum4 - (bVar4 != null ? bVar4.getGLEnum() : 0);
        }
        return 0;
    }
}
