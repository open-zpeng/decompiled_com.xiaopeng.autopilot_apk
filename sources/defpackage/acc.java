package defpackage;

import java.util.ArrayList;
/* compiled from: Animator.java */
/* renamed from: acc  reason: default package */
/* loaded from: classes.dex */
public abstract class acc implements Cloneable {
    ArrayList<a> a = null;
    String b = null;

    /* compiled from: Animator.java */
    /* renamed from: acc$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(acc accVar);

        void b(acc accVar);

        void c(acc accVar);

        void d(acc accVar);
    }

    public void a() {
    }

    public void b() {
    }

    public void a(a aVar) {
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.a.add(aVar);
    }

    public void c() {
        ArrayList<a> arrayList = this.a;
        if (arrayList != null) {
            arrayList.clear();
            this.a = null;
        }
    }

    /* renamed from: d */
    public acc clone() {
        try {
            acc accVar = (acc) super.clone();
            if (this.a != null) {
                ArrayList<a> arrayList = this.a;
                accVar.a = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    accVar.a.add(arrayList.get(i));
                }
            }
            return accVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public void a(String str) {
        this.b = "Animator:" + str;
    }

    public String toString() {
        String str = this.b;
        return str != null ? str : super.toString();
    }
}
