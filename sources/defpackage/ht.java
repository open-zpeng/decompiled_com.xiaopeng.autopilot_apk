package defpackage;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.i;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import defpackage.hs;
import defpackage.hu;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoaderManagerImpl.java */
/* renamed from: ht  reason: default package */
/* loaded from: classes.dex */
public class ht extends hs {
    static boolean a = false;
    private final i b;
    private final c c;

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: ht$a */
    /* loaded from: classes.dex */
    public static class a<D> extends n<D> implements hu.a<D> {
        private final int e;
        private final Bundle f;
        private final hu<D> g;
        private i h;
        private b<D> i;
        private hu<D> j;

        hu<D> e() {
            return this.g;
        }

        @Override // androidx.lifecycle.LiveData
        protected void b() {
            if (ht.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.g.a();
        }

        @Override // androidx.lifecycle.LiveData
        protected void c() {
            if (ht.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.g.e();
        }

        void f() {
            i iVar = this.h;
            b<D> bVar = this.i;
            if (iVar == null || bVar == null) {
                return;
            }
            super.b(bVar);
            a(iVar, bVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void b(o<? super D> oVar) {
            super.b(oVar);
            this.h = null;
            this.i = null;
        }

        hu<D> a(boolean z) {
            if (ht.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.g.c();
            this.g.g();
            b<D> bVar = this.i;
            if (bVar != null) {
                b(bVar);
                if (z) {
                    bVar.b();
                }
            }
            this.g.a((hu.a) this);
            if ((bVar != null && !bVar.a()) || z) {
                this.g.i();
                return this.j;
            }
            return this.g;
        }

        @Override // androidx.lifecycle.n, androidx.lifecycle.LiveData
        public void a(D d) {
            super.a((a<D>) d);
            hu<D> huVar = this.j;
            if (huVar != null) {
                huVar.i();
                this.j = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.e);
            sb.append(" : ");
            fm.a(this.g, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.g);
            hu<D> huVar = this.g;
            huVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i);
                b<D> bVar = this.i;
                bVar.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().a((hu<D>) a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: ht$b */
    /* loaded from: classes.dex */
    public static class b<D> implements o<D> {
        private final hu<D> a;
        private final hs.a<D> b;
        private boolean c;

        @Override // androidx.lifecycle.o
        public void a(D d) {
            if (ht.a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.a((hu<D>) d));
            }
            this.b.a(this.a, d);
            this.c = true;
        }

        boolean a() {
            return this.c;
        }

        void b() {
            if (this.c) {
                if (ht.a) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.b.a(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: ht$c */
    /* loaded from: classes.dex */
    static class c extends t {
        private static final u.b a = new u.b() { // from class: ht.c.1
            @Override // androidx.lifecycle.u.b
            public <T extends t> T a(Class<T> cls) {
                return new c();
            }
        };
        private av<a> b = new av<>();
        private boolean c = false;

        c() {
        }

        static c a(v vVar) {
            return (c) new u(vVar, a).a(c.class);
        }

        void b() {
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.c(i).f();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.t
        public void a() {
            super.a();
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.c(i).a(true);
            }
            this.b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.b.b(); i++) {
                    a c = this.b.c(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.b(i));
                    printWriter.print(": ");
                    printWriter.println(c.toString());
                    c.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ht(i iVar, v vVar) {
        this.b = iVar;
        this.c = c.a(vVar);
    }

    @Override // defpackage.hs
    public void a() {
        this.c.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        fm.a(this.b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // defpackage.hs
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }
}
