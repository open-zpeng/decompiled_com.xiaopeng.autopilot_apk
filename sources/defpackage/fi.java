package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import java.util.concurrent.Executor;
/* compiled from: FontsContractCompat.java */
/* renamed from: fi  reason: default package */
/* loaded from: classes.dex */
public class fi {

    /* compiled from: FontsContractCompat.java */
    /* renamed from: fi$c */
    /* loaded from: classes.dex */
    public static class c {
        public void a(int i) {
        }

        public void a(Typeface typeface) {
        }
    }

    public static Typeface a(Context context, fg fgVar, int i, boolean z, int i2, Handler handler, c cVar) {
        fd fdVar = new fd(cVar, handler);
        if (z) {
            return fh.a(context, fgVar, fdVar, i, i2);
        }
        return fh.a(context, fgVar, i, (Executor) null, fdVar);
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: fi$b */
    /* loaded from: classes.dex */
    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        @Deprecated
        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) fp.a(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Uri uri, int i, int i2, boolean z, int i3) {
            return new b(uri, i, i2, z, i3);
        }

        public Uri a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: fi$a */
    /* loaded from: classes.dex */
    public static class a {
        private final int a;
        private final b[] b;

        @Deprecated
        public a(int i, b[] bVarArr) {
            this.a = i;
            this.b = bVarArr;
        }

        public int a() {
            return this.a;
        }

        public b[] b() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(int i, b[] bVarArr) {
            return new a(i, bVarArr);
        }
    }
}
