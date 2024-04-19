package defpackage;

import com.badlogic.gdx.utils.z;
import java.io.InputStream;
import java.util.Map;
/* compiled from: Net.java */
/* renamed from: iv  reason: default package */
/* loaded from: classes.dex */
public interface iv {

    /* compiled from: Net.java */
    /* renamed from: iv$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    /* compiled from: Net.java */
    /* renamed from: iv$c */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void a(b bVar);

        void a(Throwable th);
    }

    /* compiled from: Net.java */
    /* renamed from: iv$d */
    /* loaded from: classes.dex */
    public enum d {
        TCP
    }

    /* compiled from: Net.java */
    /* renamed from: iv$a */
    /* loaded from: classes.dex */
    public static class a implements z.a {
        private String a;
        private String b;
        private Map<String, String> c;
        private int d;
        private String e;
        private InputStream f;
        private long g;
        private boolean h;

        public int a() {
            return this.d;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.b;
        }

        public String d() {
            return this.e;
        }

        public InputStream e() {
            return this.f;
        }

        public Map<String, String> f() {
            return this.c;
        }

        public boolean g() {
            return this.h;
        }

        @Override // com.badlogic.gdx.utils.z.a
        public void reset() {
            this.a = null;
            this.b = null;
            this.c.clear();
            this.d = 0;
            this.e = null;
            this.f = null;
            this.g = 0L;
            this.h = true;
        }
    }
}
