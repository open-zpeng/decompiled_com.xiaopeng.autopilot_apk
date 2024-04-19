package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import defpackage.afw;
import java.util.BitSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BlockSort.java */
/* renamed from: afx  reason: default package */
/* loaded from: classes.dex */
public class afx {
    private static final int[] m = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    private int a;
    private int b;
    private boolean c;
    private final int[] d = new int[1000];
    private final int[] e = new int[1000];
    private final int[] f = new int[1000];
    private final int[] g = new int[IRadioController.TEF663x_PCHANNEL];
    private final int[] h = new int[IRadioController.TEF663x_PCHANNEL];
    private final boolean[] i = new boolean[IRadioController.TEF663x_PCHANNEL];
    private final int[] j = new int[65537];
    private final char[] k;
    private int[] l;

    private static byte a(byte b, byte b2, byte b3) {
        if (b < b2) {
            if (b2 >= b3) {
                if (b >= b3) {
                    return b;
                }
                return b3;
            }
            return b2;
        }
        if (b2 <= b3) {
            if (b <= b3) {
                return b;
            }
            return b3;
        }
        return b2;
    }

    private int a(int i, int i2) {
        return i < i2 ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public afx(afw.a aVar) {
        this.k = aVar.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(afw.a aVar, int i) {
        this.b = i * 30;
        this.a = 0;
        this.c = true;
        if (i + 1 < 10000) {
            b(aVar, i);
        } else {
            c(aVar, i);
            if (this.c && this.a > this.b) {
                b(aVar, i);
            }
        }
        int[] iArr = aVar.r;
        aVar.t = -1;
        for (int i2 = 0; i2 <= i; i2++) {
            if (iArr[i2] == 0) {
                aVar.t = i2;
                return;
            }
        }
    }

    final void b(afw.a aVar, int i) {
        int[] iArr;
        int i2 = i + 1;
        aVar.q[0] = aVar.q[i2];
        a(aVar.r, aVar.q, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            aVar.r[i3] = iArr[i3] - 1;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (aVar.r[i4] == -1) {
                aVar.r[i4] = i;
                return;
            }
        }
    }

    private void a(int[] iArr, int[] iArr2, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 - i > 3) {
            for (int i3 = i2 - 4; i3 >= i; i3--) {
                int i4 = iArr[i3];
                int i5 = iArr2[i4];
                int i6 = i3 + 4;
                while (i6 <= i2 && i5 > iArr2[iArr[i6]]) {
                    iArr[i6 - 4] = iArr[i6];
                    i6 += 4;
                }
                iArr[i6 - 4] = i4;
            }
        }
        for (int i7 = i2 - 1; i7 >= i; i7--) {
            int i8 = iArr[i7];
            int i9 = iArr2[i8];
            int i10 = i7 + 1;
            while (i10 <= i2 && i9 > iArr2[iArr[i10]]) {
                iArr[i10 - 1] = iArr[i10];
                i10++;
            }
            iArr[i10 - 1] = i8;
        }
    }

    private void a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    private void a(int[] iArr, int i, int i2, int i3) {
        while (i3 > 0) {
            a(iArr, i, i2);
            i++;
            i2++;
            i3--;
        }
    }

    private void a(int i, int i2, int i3) {
        this.d[i] = i2;
        this.e[i] = i3;
    }

    private int[] a(int i) {
        return new int[]{this.d[i], this.e[i]};
    }

    private void b(int[] iArr, int[] iArr2, int i, int i2) {
        long j;
        int i3;
        char c = 0;
        a(0, i, i2);
        long j2 = 0;
        int i4 = 1;
        long j3 = 0;
        int i5 = 1;
        while (i5 > 0) {
            i5--;
            int[] a = a(i5);
            int i6 = a[c];
            int i7 = a[i4];
            if (i7 - i6 < 10) {
                a(iArr, iArr2, i6, i7);
            } else {
                j3 = ((j3 * 7621) + 1) % 32768;
                long j4 = j3 % 3;
                if (j4 == j2) {
                    j = iArr2[iArr[i6]];
                } else if (j4 == 1) {
                    j = iArr2[iArr[(i6 + i7) >>> i4]];
                } else {
                    j = iArr2[iArr[i7]];
                }
                int i8 = i7;
                int i9 = i8;
                int i10 = i6;
                int i11 = i10;
                while (true) {
                    if (i11 <= i8) {
                        int i12 = iArr2[iArr[i11]] - ((int) j);
                        if (i12 == 0) {
                            a(iArr, i11, i10);
                            i10++;
                            i11++;
                        } else if (i12 <= 0) {
                            i11++;
                        }
                    }
                    i3 = i9;
                    while (i11 <= i8) {
                        int i13 = iArr2[iArr[i8]] - ((int) j);
                        if (i13 == 0) {
                            a(iArr, i8, i3);
                            i3--;
                            i8--;
                        } else if (i13 < 0) {
                            break;
                        } else {
                            i8--;
                        }
                    }
                    if (i11 > i8) {
                        break;
                    }
                    a(iArr, i11, i8);
                    i11++;
                    i8--;
                    i9 = i3;
                    i4 = 1;
                }
                if (i3 < i10) {
                    c = 0;
                    j2 = 0;
                    i4 = 1;
                } else {
                    int a2 = a(i10 - i6, i11 - i10);
                    a(iArr, i6, i11 - a2, a2);
                    int i14 = i7 - i3;
                    int i15 = i3 - i8;
                    int a3 = a(i14, i15);
                    a(iArr, i8 + 1, (i7 - a3) + 1, a3);
                    int i16 = ((i11 + i6) - i10) - 1;
                    int i17 = (i7 - i15) + 1;
                    if (i16 - i6 > i7 - i17) {
                        int i18 = i5 + 1;
                        a(i5, i6, i16);
                        a(i18, i17, i7);
                        i5 = i18 + 1;
                    } else {
                        int i19 = i5 + 1;
                        a(i5, i17, i7);
                        a(i19, i6, i16);
                        i5 = i19 + 1;
                    }
                    i4 = 1;
                    c = 0;
                    j2 = 0;
                }
            }
        }
    }

    private int[] a() {
        int[] iArr = this.l;
        if (iArr == null) {
            int[] iArr2 = new int[this.k.length / 2];
            this.l = iArr2;
            return iArr2;
        }
        return iArr;
    }

    final void a(int[] iArr, byte[] bArr, int i) {
        int i2;
        int[] iArr2 = new int[257];
        int[] a = a();
        for (int i3 = 0; i3 < i; i3++) {
            a[i3] = 0;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = bArr[i4] & 255;
            iArr2[i5] = iArr2[i5] + 1;
        }
        for (int i6 = 1; i6 < 257; i6++) {
            iArr2[i6] = iArr2[i6] + iArr2[i6 - 1];
        }
        for (int i7 = 0; i7 < i; i7++) {
            int i8 = bArr[i7] & 255;
            int i9 = iArr2[i8] - 1;
            iArr2[i8] = i9;
            iArr[i9] = i7;
        }
        BitSet bitSet = new BitSet(i + 64);
        for (int i10 = 0; i10 < 256; i10++) {
            bitSet.set(iArr2[i10]);
        }
        for (int i11 = 0; i11 < 32; i11++) {
            int i12 = (i11 * 2) + i;
            bitSet.set(i12);
            bitSet.clear(i12 + 1);
        }
        int i13 = 1;
        do {
            int i14 = 0;
            for (int i15 = 0; i15 < i; i15++) {
                if (bitSet.get(i15)) {
                    i14 = i15;
                }
                int i16 = iArr[i15] - i13;
                if (i16 < 0) {
                    i16 += i;
                }
                a[i16] = i14;
            }
            int i17 = -1;
            i2 = 0;
            while (true) {
                int nextClearBit = bitSet.nextClearBit(i17 + 1);
                int i18 = nextClearBit - 1;
                if (i18 < i && (i17 = bitSet.nextSetBit(nextClearBit + 1) - 1) < i) {
                    if (i17 > i18) {
                        i2 += (i17 - i18) + 1;
                        b(iArr, a, i18, i17);
                        int i19 = -1;
                        while (i18 <= i17) {
                            int i20 = a[iArr[i18]];
                            if (i19 != i20) {
                                bitSet.set(i18);
                                i19 = i20;
                            }
                            i18++;
                        }
                    }
                }
            }
            i13 *= 2;
            if (i13 > i) {
                return;
            }
        } while (i2 != 0);
    }

    private boolean a(afw.a aVar, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8 = (i2 - i) + 1;
        if (i8 < 2) {
            return this.c && this.a > this.b;
        }
        int i9 = 0;
        while (m[i9] < i8) {
            i9++;
        }
        int[] iArr = aVar.r;
        char[] cArr = this.k;
        byte[] bArr = aVar.q;
        int i10 = i4 + 1;
        boolean z2 = this.c;
        int i11 = this.b;
        int i12 = this.a;
        loop1: while (true) {
            i9--;
            if (i9 < 0) {
                break;
            }
            int i13 = m[i9];
            int i14 = i + i13;
            int i15 = i14 - 1;
            while (i14 <= i2) {
                int i16 = 3;
                while (i14 <= i2) {
                    i16--;
                    if (i16 < 0) {
                        break;
                    }
                    int i17 = iArr[i14];
                    int i18 = i17 + i3;
                    int i19 = i12;
                    int i20 = i14;
                    boolean z3 = false;
                    int i21 = 0;
                    while (true) {
                        if (z3) {
                            iArr[i20] = i21;
                            int i22 = i20 - i13;
                            if (i22 <= i15) {
                                i20 = i22;
                                i7 = i9;
                                i6 = i13;
                                i5 = i15;
                                break;
                            }
                            i20 = i22;
                        } else {
                            z3 = true;
                        }
                        int i23 = iArr[i20 - i13];
                        int i24 = i23 + i3;
                        int i25 = i24 + 1;
                        int i26 = i18 + 1;
                        if (bArr[i25] == bArr[i26]) {
                            int i27 = i24 + 2;
                            int i28 = i18 + 2;
                            i7 = i9;
                            if (bArr[i27] == bArr[i28]) {
                                int i29 = i24 + 3;
                                int i30 = i18 + 3;
                                z = z3;
                                if (bArr[i29] == bArr[i30]) {
                                    int i31 = i24 + 4;
                                    int i32 = i18 + 4;
                                    if (bArr[i31] == bArr[i32]) {
                                        int i33 = i24 + 5;
                                        int i34 = i18 + 5;
                                        if (bArr[i33] == bArr[i34]) {
                                            int i35 = i24 + 6;
                                            int i36 = i18 + 6;
                                            if (bArr[i35] == bArr[i36]) {
                                                int i37 = i4;
                                                while (true) {
                                                    if (i37 <= 0) {
                                                        i6 = i13;
                                                        i5 = i15;
                                                        break;
                                                    }
                                                    int i38 = i37 - 4;
                                                    int i39 = i35 + 1;
                                                    int i40 = i36 + 1;
                                                    if (bArr[i39] == bArr[i40]) {
                                                        if (cArr[i35] == cArr[i36]) {
                                                            int i41 = i35 + 2;
                                                            int i42 = i36 + 2;
                                                            i6 = i13;
                                                            if (bArr[i41] == bArr[i42]) {
                                                                if (cArr[i39] == cArr[i40]) {
                                                                    int i43 = i35 + 3;
                                                                    int i44 = i36 + 3;
                                                                    i5 = i15;
                                                                    if (bArr[i43] == bArr[i44]) {
                                                                        if (cArr[i41] == cArr[i42]) {
                                                                            int i45 = i35 + 4;
                                                                            i36 += 4;
                                                                            if (bArr[i45] == bArr[i36]) {
                                                                                if (cArr[i43] == cArr[i44]) {
                                                                                    i35 = i45 >= i10 ? i45 - i10 : i45;
                                                                                    if (i36 >= i10) {
                                                                                        i36 -= i10;
                                                                                    }
                                                                                    i19++;
                                                                                    i37 = i38;
                                                                                    i13 = i6;
                                                                                    i15 = i5;
                                                                                } else if (cArr[i43] > cArr[i44]) {
                                                                                }
                                                                            } else if ((bArr[i45] & 255) > (bArr[i36] & 255)) {
                                                                            }
                                                                        } else if (cArr[i41] > cArr[i42]) {
                                                                        }
                                                                    } else if ((bArr[i43] & 255) > (bArr[i44] & 255)) {
                                                                    }
                                                                } else {
                                                                    i5 = i15;
                                                                    if (cArr[i39] > cArr[i40]) {
                                                                    }
                                                                }
                                                            } else {
                                                                i5 = i15;
                                                                if ((bArr[i41] & 255) > (bArr[i42] & 255)) {
                                                                }
                                                            }
                                                        } else {
                                                            i6 = i13;
                                                            i5 = i15;
                                                            if (cArr[i35] > cArr[i36]) {
                                                            }
                                                        }
                                                    } else {
                                                        i6 = i13;
                                                        i5 = i15;
                                                        if ((bArr[i39] & 255) > (bArr[i40] & 255)) {
                                                        }
                                                    }
                                                }
                                                i21 = i23;
                                                i9 = i7;
                                                z3 = z;
                                                i13 = i6;
                                                i15 = i5;
                                            } else {
                                                i6 = i13;
                                                i5 = i15;
                                                if ((bArr[i35] & 255) > (bArr[i36] & 255)) {
                                                    i21 = i23;
                                                    i9 = i7;
                                                    z3 = z;
                                                    i13 = i6;
                                                    i15 = i5;
                                                }
                                            }
                                        } else {
                                            i6 = i13;
                                            i5 = i15;
                                            if ((bArr[i33] & 255) > (bArr[i34] & 255)) {
                                                i21 = i23;
                                                i9 = i7;
                                                z3 = z;
                                                i13 = i6;
                                                i15 = i5;
                                            }
                                        }
                                    } else {
                                        i6 = i13;
                                        i5 = i15;
                                        if ((bArr[i31] & 255) > (bArr[i32] & 255)) {
                                            i21 = i23;
                                            i9 = i7;
                                            z3 = z;
                                            i13 = i6;
                                            i15 = i5;
                                        }
                                    }
                                } else {
                                    i6 = i13;
                                    i5 = i15;
                                    if ((bArr[i29] & 255) > (bArr[i30] & 255)) {
                                        i21 = i23;
                                        i9 = i7;
                                        z3 = z;
                                        i13 = i6;
                                        i15 = i5;
                                    }
                                }
                            } else {
                                z = z3;
                                i6 = i13;
                                i5 = i15;
                                if ((bArr[i27] & 255) > (bArr[i28] & 255)) {
                                    i21 = i23;
                                    i9 = i7;
                                    z3 = z;
                                    i13 = i6;
                                    i15 = i5;
                                }
                            }
                        } else {
                            i7 = i9;
                            z = z3;
                            i6 = i13;
                            i5 = i15;
                            if ((bArr[i25] & 255) > (bArr[i26] & 255)) {
                                i21 = i23;
                                i9 = i7;
                                z3 = z;
                                i13 = i6;
                                i15 = i5;
                            }
                        }
                    }
                    i12 = i19;
                    iArr[i20] = i17;
                    i14++;
                    i9 = i7;
                    i13 = i6;
                    i15 = i5;
                }
                int i46 = i9;
                int i47 = i13;
                int i48 = i15;
                if (z2 && i14 <= i2 && i12 > i11) {
                    break loop1;
                }
                i9 = i46;
                i13 = i47;
                i15 = i48;
            }
        }
        this.a = i12;
        return z2 && i12 > i11;
    }

    private static void b(int[] iArr, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            int i5 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i5;
            i2++;
            i++;
        }
    }

    private void b(afw.a aVar, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr = this.d;
        int[] iArr2 = this.e;
        int[] iArr3 = this.f;
        int[] iArr4 = aVar.r;
        byte[] bArr = aVar.q;
        iArr[0] = i;
        iArr2[0] = i2;
        iArr3[0] = i3;
        int i7 = 1;
        int i8 = 1;
        while (true) {
            int i9 = i8 - 1;
            if (i9 < 0) {
                return;
            }
            int i10 = iArr[i9];
            int i11 = iArr2[i9];
            int i12 = iArr3[i9];
            if (i11 - i10 < 20 || i12 > 10) {
                i5 = i7;
                if (a(aVar, i10, i11, i12, i4)) {
                    return;
                }
                i8 = i9;
            } else {
                int i13 = i12 + 1;
                int a = a(bArr[iArr4[i10] + i13], bArr[iArr4[i11] + i13], bArr[iArr4[(i10 + i11) >>> i7] + i13]) & 255;
                int i14 = i10;
                int i15 = i14;
                int i16 = i11;
                int i17 = i16;
                while (true) {
                    if (i14 <= i16) {
                        int i18 = (bArr[iArr4[i14] + i13] & 255) - a;
                        if (i18 == 0) {
                            int i19 = iArr4[i14];
                            iArr4[i14] = iArr4[i15];
                            iArr4[i15] = i19;
                            i15++;
                            i14++;
                        } else if (i18 < 0) {
                            i14++;
                        }
                    }
                    i6 = i17;
                    while (i14 <= i16) {
                        int i20 = (bArr[iArr4[i16] + i13] & 255) - a;
                        if (i20 != 0) {
                            if (i20 <= 0) {
                                break;
                            }
                            i16--;
                        } else {
                            int i21 = iArr4[i16];
                            iArr4[i16] = iArr4[i6];
                            iArr4[i6] = i21;
                            i6--;
                            i16--;
                        }
                    }
                    if (i14 > i16) {
                        break;
                    }
                    int i22 = iArr4[i14];
                    iArr4[i14] = iArr4[i16];
                    iArr4[i16] = i22;
                    i16--;
                    i14++;
                    i17 = i6;
                }
                if (i6 < i15) {
                    iArr[i9] = i10;
                    iArr2[i9] = i11;
                    iArr3[i9] = i13;
                    i8 = i9 + 1;
                    i5 = 1;
                } else {
                    int i23 = i15 - i10;
                    int i24 = i14 - i15;
                    if (i23 >= i24) {
                        i23 = i24;
                    }
                    b(iArr4, i10, i14 - i23, i23);
                    int i25 = i11 - i6;
                    int i26 = i6 - i16;
                    if (i25 >= i26) {
                        i25 = i26;
                    }
                    i5 = 1;
                    b(iArr4, i14, (i11 - i25) + 1, i25);
                    int i27 = ((i14 + i10) - i15) - 1;
                    int i28 = (i11 - i26) + 1;
                    iArr[i9] = i10;
                    iArr2[i9] = i27;
                    iArr3[i9] = i12;
                    int i29 = i9 + 1;
                    iArr[i29] = i27 + 1;
                    iArr2[i29] = i28 - 1;
                    iArr3[i29] = i13;
                    int i30 = i29 + 1;
                    iArr[i30] = i28;
                    iArr2[i30] = i11;
                    iArr3[i30] = i12;
                    i8 = i30 + 1;
                }
            }
            i7 = i5;
        }
    }

    final void c(afw.a aVar, int i) {
        char c;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr2 = this.g;
        int[] iArr3 = this.h;
        boolean[] zArr = this.i;
        int[] iArr4 = this.j;
        byte[] bArr = aVar.q;
        int[] iArr5 = aVar.r;
        char[] cArr = this.k;
        int i8 = this.b;
        boolean z = this.c;
        int i9 = 65537;
        while (true) {
            i9--;
            if (i9 < 0) {
                break;
            }
            iArr4[i9] = 0;
        }
        int i10 = 0;
        while (true) {
            c = 1;
            if (i10 >= 20) {
                break;
            }
            bArr[i + i10 + 2] = bArr[(i10 % (i + 1)) + 1];
            i10++;
        }
        int i11 = i + 20 + 1;
        while (true) {
            i11--;
            if (i11 < 0) {
                break;
            }
            cArr[i11] = 0;
        }
        int i12 = i + 1;
        bArr[0] = bArr[i12];
        int i13 = 255;
        int i14 = bArr[0] & 255;
        int i15 = 0;
        while (i15 <= i) {
            i15++;
            int i16 = bArr[i15] & 255;
            int i17 = (i14 << 8) + i16;
            iArr4[i17] = iArr4[i17] + 1;
            i14 = i16;
        }
        for (int i18 = 1; i18 <= 65536; i18++) {
            iArr4[i18] = iArr4[i18] + iArr4[i18 - 1];
        }
        int i19 = bArr[1] & 255;
        int i20 = 0;
        while (i20 < i) {
            int i21 = bArr[i20 + 2] & 255;
            int i22 = (i19 << 8) + i21;
            int i23 = iArr4[i22] - 1;
            iArr4[i22] = i23;
            iArr5[i23] = i20;
            i20++;
            i19 = i21;
            c = 1;
        }
        int i24 = ((bArr[i12] & 255) << 8) + (bArr[c] & 255);
        int i25 = iArr4[i24] - 1;
        iArr4[i24] = i25;
        iArr5[i25] = i;
        int i26 = 256;
        while (true) {
            i26--;
            if (i26 < 0) {
                break;
            }
            zArr[i26] = false;
            iArr2[i26] = i26;
        }
        int i27 = 364;
        for (int i28 = 1; i27 != i28; i28 = 1) {
            i27 /= 3;
            int i29 = i27;
            while (i29 <= i13) {
                int i30 = iArr2[i29];
                int i31 = iArr4[(i30 + 1) << 8] - iArr4[i30 << 8];
                int i32 = i27 - 1;
                int i33 = iArr2[i29 - i27];
                int i34 = i29;
                while (true) {
                    i6 = i8;
                    if (iArr4[(i33 + 1) << 8] - iArr4[i33 << 8] <= i31) {
                        i7 = i34;
                        break;
                    }
                    iArr2[i34] = i33;
                    i7 = i34 - i27;
                    if (i7 <= i32) {
                        break;
                    }
                    i33 = iArr2[i7 - i27];
                    i34 = i7;
                    i8 = i6;
                }
                iArr2[i7] = i30;
                i29++;
                i8 = i6;
                i13 = 255;
            }
        }
        int i35 = i8;
        int i36 = 0;
        while (i36 <= i13) {
            int i37 = iArr2[i36];
            int i38 = 0;
            while (i38 <= i13) {
                int i39 = (i37 << 8) + i38;
                int i40 = iArr4[i39];
                if ((i40 & 2097152) != 2097152) {
                    int i41 = i40 & (-2097153);
                    int i42 = (iArr4[i39 + 1] & (-2097153)) - 1;
                    if (i42 > i41) {
                        i5 = 2097152;
                        i2 = i38;
                        i3 = i35;
                        iArr = iArr2;
                        i4 = i36;
                        b(aVar, i41, i42, 2, i);
                        if (z && this.a > i3) {
                            return;
                        }
                    } else {
                        i5 = 2097152;
                        i2 = i38;
                        i3 = i35;
                        iArr = iArr2;
                        i4 = i36;
                    }
                    iArr4[i39] = i40 | i5;
                } else {
                    i2 = i38;
                    i3 = i35;
                    iArr = iArr2;
                    i4 = i36;
                }
                i38 = i2 + 1;
                i36 = i4;
                iArr2 = iArr;
                i13 = 255;
                i35 = i3;
            }
            int i43 = i35;
            int[] iArr6 = iArr2;
            int i44 = i36;
            int i45 = 0;
            for (int i46 = i13; i45 <= i46; i46 = 255) {
                iArr3[i45] = iArr4[(i45 << 8) + i37] & (-2097153);
                i45++;
            }
            int i47 = i37 << 8;
            int i48 = iArr4[i47] & (-2097153);
            int i49 = (i37 + 1) << 8;
            int i50 = iArr4[i49] & (-2097153);
            while (i48 < i50) {
                int i51 = iArr5[i48];
                int i52 = i50;
                int i53 = bArr[i51] & 255;
                if (!zArr[i53]) {
                    iArr5[iArr3[i53]] = i51 == 0 ? i : i51 - 1;
                    iArr3[i53] = iArr3[i53] + 1;
                }
                i48++;
                i50 = i52;
            }
            int i54 = 256;
            while (true) {
                i54--;
                if (i54 < 0) {
                    break;
                }
                int i55 = (i54 << 8) + i37;
                iArr4[i55] = iArr4[i55] | 2097152;
            }
            zArr[i37] = true;
            if (i44 < 255) {
                int i56 = iArr4[i47] & (-2097153);
                int i57 = ((-2097153) & iArr4[i49]) - i56;
                int i58 = 0;
                while ((i57 >> i58) > 65534) {
                    i58++;
                }
                int i59 = 0;
                while (i59 < i57) {
                    int i60 = iArr5[i56 + i59];
                    char c2 = (char) (i59 >> i58);
                    cArr[i60] = c2;
                    int i61 = i56;
                    if (i60 < 20) {
                        cArr[i60 + i + 1] = c2;
                    }
                    i59++;
                    i56 = i61;
                }
            }
            i36 = i44 + 1;
            iArr2 = iArr6;
            i13 = 255;
            i35 = i43;
        }
    }
}
