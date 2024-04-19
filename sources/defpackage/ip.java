package defpackage;
/* compiled from: Graphics.java */
/* renamed from: ip  reason: default package */
/* loaded from: classes.dex */
public interface ip {

    /* compiled from: Graphics.java */
    /* renamed from: ip$c */
    /* loaded from: classes.dex */
    public enum c {
        AndroidGL,
        LWJGL,
        WebGL,
        iOSGL,
        JGLFW,
        Mock,
        LWJGL3
    }

    int getBackBufferHeight();

    int getBackBufferWidth();

    float getDeltaTime();

    b getDisplayMode();

    int getFramesPerSecond();

    kg getGL20();

    kh getGL30();

    int getHeight();

    int getWidth();

    boolean isContinuousRendering();

    boolean isGL30Available();

    void requestRendering();

    void setGL20(kg kgVar);

    void setGL30(kh khVar);

    boolean supportsExtension(String str);

    /* compiled from: Graphics.java */
    /* renamed from: ip$b */
    /* loaded from: classes.dex */
    public static class b {
        public final int bitsPerPixel;
        public final int height;
        public final int refreshRate;
        public final int width;

        /* JADX INFO: Access modifiers changed from: protected */
        public b(int i, int i2, int i3, int i4) {
            this.width = i;
            this.height = i2;
            this.refreshRate = i3;
            this.bitsPerPixel = i4;
        }

        public String toString() {
            return this.width + "x" + this.height + ", bpp: " + this.bitsPerPixel + ", hz: " + this.refreshRate;
        }
    }

    /* compiled from: Graphics.java */
    /* renamed from: ip$d */
    /* loaded from: classes.dex */
    public static class d {
        public final String name;
        public final int virtualX;
        public final int virtualY;

        /* JADX INFO: Access modifiers changed from: protected */
        public d(int i, int i2, String str) {
            this.virtualX = i;
            this.virtualY = i2;
            this.name = str;
        }
    }

    /* compiled from: Graphics.java */
    /* renamed from: ip$a */
    /* loaded from: classes.dex */
    public static class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final boolean h;

        public a(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = z;
        }

        public String toString() {
            return "r: " + this.a + ", g: " + this.b + ", b: " + this.c + ", a: " + this.d + ", depth: " + this.e + ", stencil: " + this.f + ", num samples: " + this.g + ", coverage sampling: " + this.h;
        }
    }
}
