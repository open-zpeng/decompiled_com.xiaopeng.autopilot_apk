package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
/* compiled from: InputContentInfoCompat.java */
/* renamed from: he  reason: default package */
/* loaded from: classes.dex */
public final class he {
    private final c a;

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: he$c */
    /* loaded from: classes.dex */
    private interface c {
        Uri a();

        ClipDescription b();

        Uri c();

        Object d();

        void e();
    }

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: he$b */
    /* loaded from: classes.dex */
    private static final class b implements c {
        private final Uri a;
        private final ClipDescription b;
        private final Uri c;

        @Override // defpackage.he.c
        public Object d() {
            return null;
        }

        @Override // defpackage.he.c
        public void e() {
        }

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = uri;
            this.b = clipDescription;
            this.c = uri2;
        }

        @Override // defpackage.he.c
        public Uri a() {
            return this.a;
        }

        @Override // defpackage.he.c
        public ClipDescription b() {
            return this.b;
        }

        @Override // defpackage.he.c
        public Uri c() {
            return this.c;
        }
    }

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: he$a */
    /* loaded from: classes.dex */
    private static final class a implements c {
        final InputContentInfo a;

        a(Object obj) {
            this.a = (InputContentInfo) obj;
        }

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        }

        @Override // defpackage.he.c
        public Uri a() {
            return this.a.getContentUri();
        }

        @Override // defpackage.he.c
        public ClipDescription b() {
            return this.a.getDescription();
        }

        @Override // defpackage.he.c
        public Uri c() {
            return this.a.getLinkUri();
        }

        @Override // defpackage.he.c
        public Object d() {
            return this.a;
        }

        @Override // defpackage.he.c
        public void e() {
            this.a.requestPermission();
        }
    }

    public he(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.a = new a(uri, clipDescription, uri2);
        } else {
            this.a = new b(uri, clipDescription, uri2);
        }
    }

    private he(c cVar) {
        this.a = cVar;
    }

    public Uri a() {
        return this.a.a();
    }

    public ClipDescription b() {
        return this.a.b();
    }

    public Uri c() {
        return this.a.c();
    }

    public static he a(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new he(new a(obj));
        }
        return null;
    }

    public Object d() {
        return this.a.d();
    }

    public void e() {
        this.a.e();
    }
}
