package defpackage;
/* renamed from: ahg  reason: default package */
/* loaded from: classes.dex */
final class ahg extends ahi {
    static final boolean a;
    static Class b;
    private final ahh i;
    private final int[] j;
    private final ahj k;
    private final int l;
    private final int m;
    private int n;
    private int o;

    static {
        Class cls = b;
        if (cls == null) {
            cls = a("ahg");
            b = cls;
        }
        a = !cls.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ahg(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5);
        this.n = -1;
        this.i = new ahh(i);
        this.m = i + 1;
        int i7 = this.m;
        this.j = new int[i7];
        this.o = i7;
        this.k = new ahj(i4 - 1);
        this.l = i6 <= 0 ? (i4 / 4) + 4 : i6;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private int g() {
        int c = c(4, 4);
        if (c != 0) {
            int i = this.o + 1;
            this.o = i;
            if (i == Integer.MAX_VALUE) {
                int i2 = Integer.MAX_VALUE - this.m;
                this.i.c(i2);
                a(this.j, i2);
                this.o -= i2;
            }
            int i3 = this.n + 1;
            this.n = i3;
            if (i3 == this.m) {
                this.n = 0;
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0144, code lost:
        return r13.k;
     */
    @Override // defpackage.ahi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.ahj a() {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ahg.a():ahj");
    }

    @Override // defpackage.ahi
    public void a(int i) {
        if (!a && i < 0) {
            throw new AssertionError();
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            if (g() != 0) {
                this.i.a(this.e, this.f);
                this.j[this.n] = this.i.c();
                this.i.b(this.o);
            }
            i = i2;
        }
    }
}
