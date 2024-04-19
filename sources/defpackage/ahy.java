package defpackage;
/* renamed from: ahy  reason: default package */
/* loaded from: classes.dex */
public final class ahy implements ahx {
    private static final boolean[] a = {true, true, true, false, true, false, false, false};
    private static final int[] b = {0, 1, 2, 2, 3, 3, 3, 3};
    private final boolean c;
    private int d;
    private int e = 0;

    public ahy(boolean z, int i) {
        this.c = z;
        this.d = i + 5;
    }

    private static boolean a(byte b2) {
        int i = b2 & 255;
        return i == 0 || i == 255;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (a(r11[(r0 + 4) - defpackage.ahy.b[r1]]) != false) goto L26;
     */
    @Override // defpackage.ahx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(byte[] r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ahy.a(byte[], int, int):int");
    }
}
