package com.badlogic.gdx.utils;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.util.Comparator;
/* compiled from: TimSort.java */
/* loaded from: classes.dex */
class an<T> {
    private T[] a;
    private Comparator<? super T> b;
    private int e;
    private int c = 7;
    private int f = 0;
    private T[] d = (T[]) new Object[IRadioController.TEF663x_PCHANNEL];
    private final int[] g = new int[40];
    private final int[] h = new int[40];

    private static int a(int i) {
        int i2 = 0;
        while (i >= 32) {
            i2 |= i & 1;
            i >>= 1;
        }
        return i + i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(T[] tArr, Comparator<T> comparator, int i, int i2) {
        this.f = 0;
        a(tArr.length, i, i2);
        int i3 = i2 - i;
        if (i3 < 2) {
            return;
        }
        if (i3 < 32) {
            a(tArr, i, i2, a(tArr, i, i2, comparator) + i, comparator);
            return;
        }
        this.a = tArr;
        this.b = comparator;
        this.e = 0;
        int a = a(i3);
        do {
            int a2 = a(tArr, i, i2, comparator);
            if (a2 < a) {
                int i4 = i3 <= a ? i3 : a;
                a(tArr, i, i + i4, a2 + i, comparator);
                a2 = i4;
            }
            a(i, a2);
            a();
            i += a2;
            i3 -= a2;
        } while (i3 != 0);
        b();
        this.a = null;
        this.b = null;
        T[] tArr2 = this.d;
        int i5 = this.e;
        for (int i6 = 0; i6 < i5; i6++) {
            tArr2[i6] = null;
        }
    }

    private static <T> void a(T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        if (i3 == i) {
            i3++;
        }
        while (i3 < i2) {
            T t = tArr[i3];
            int i4 = i;
            int i5 = i3;
            while (i4 < i5) {
                int i6 = (i4 + i5) >>> 1;
                if (comparator.compare(t, tArr[i6]) < 0) {
                    i5 = i6;
                } else {
                    i4 = i6 + 1;
                }
            }
            int i7 = i3 - i4;
            switch (i7) {
                case 1:
                    break;
                case 2:
                    tArr[i4 + 2] = tArr[i4 + 1];
                    break;
                default:
                    System.arraycopy(tArr, i4, tArr, i4 + 1, i7);
                    continue;
                    tArr[i4] = t;
                    i3++;
            }
            tArr[i4 + 1] = tArr[i4];
            tArr[i4] = t;
            i3++;
        }
    }

    private static <T> int a(T[] tArr, int i, int i2, Comparator<? super T> comparator) {
        int i3 = i + 1;
        if (i3 == i2) {
            return 1;
        }
        int i4 = i3 + 1;
        if (comparator.compare(tArr[i3], tArr[i]) < 0) {
            while (i4 < i2 && comparator.compare(tArr[i4], tArr[i4 - 1]) < 0) {
                i4++;
            }
            a(tArr, i, i4);
        } else {
            while (i4 < i2 && comparator.compare(tArr[i4], tArr[i4 - 1]) >= 0) {
                i4++;
            }
        }
        return i4 - i;
    }

    private static void a(Object[] objArr, int i, int i2) {
        int i3 = i2 - 1;
        while (i < i3) {
            Object obj = objArr[i];
            objArr[i] = objArr[i3];
            objArr[i3] = obj;
            i3--;
            i++;
        }
    }

    private void a(int i, int i2) {
        int[] iArr = this.g;
        int i3 = this.f;
        iArr[i3] = i;
        this.h[i3] = i2;
        this.f = i3 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r1[r0 - 2] <= (r1[r0] + r1[r0 - 1])) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        r1 = r5.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r1[r0 - 1] >= r1[r0 + 1]) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r1[r0 - 1] > (r1[r0] + r1[r0 + 1])) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a() {
        /*
            r5 = this;
        L0:
            int r0 = r5.f
            r1 = 1
            if (r0 <= r1) goto L48
            int r0 = r0 + (-2)
            if (r0 < r1) goto L18
            int[] r1 = r5.h
            int r2 = r0 + (-1)
            r2 = r1[r2]
            r3 = r1[r0]
            int r4 = r0 + 1
            r1 = r1[r4]
            int r3 = r3 + r1
            if (r2 <= r3) goto L2a
        L18:
            r1 = 2
            if (r0 < r1) goto L39
            int[] r1 = r5.h
            int r2 = r0 + (-2)
            r2 = r1[r2]
            r3 = r1[r0]
            int r4 = r0 + (-1)
            r1 = r1[r4]
            int r3 = r3 + r1
            if (r2 > r3) goto L39
        L2a:
            int[] r1 = r5.h
            int r2 = r0 + (-1)
            r2 = r1[r2]
            int r3 = r0 + 1
            r1 = r1[r3]
            if (r2 >= r1) goto L44
            int r0 = r0 + (-1)
            goto L44
        L39:
            int[] r1 = r5.h
            r2 = r1[r0]
            int r3 = r0 + 1
            r1 = r1[r3]
            if (r2 <= r1) goto L44
            goto L48
        L44:
            r5.b(r0)
            goto L0
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.an.a():void");
    }

    private void b() {
        while (true) {
            int i = this.f;
            if (i <= 1) {
                return;
            }
            int i2 = i - 2;
            if (i2 > 0) {
                int[] iArr = this.h;
                if (iArr[i2 - 1] < iArr[i2 + 1]) {
                    i2--;
                }
            }
            b(i2);
        }
    }

    private void b(int i) {
        int[] iArr = this.g;
        int i2 = iArr[i];
        int[] iArr2 = this.h;
        int i3 = iArr2[i];
        int i4 = i + 1;
        int i5 = iArr[i4];
        int i6 = iArr2[i4];
        iArr2[i] = i3 + i6;
        if (i == this.f - 3) {
            int i7 = i + 2;
            iArr[i4] = iArr[i7];
            iArr2[i4] = iArr2[i7];
        }
        this.f--;
        T[] tArr = this.a;
        int b = b(tArr[i5], tArr, i2, i3, 0, this.b);
        int i8 = i2 + b;
        int i9 = i3 - b;
        if (i9 == 0) {
            return;
        }
        T[] tArr2 = this.a;
        int a = a(tArr2[(i8 + i9) - 1], tArr2, i5, i6, i6 - 1, this.b);
        if (a == 0) {
            return;
        }
        if (i9 <= a) {
            a(i8, i9, i5, a);
        } else {
            b(i8, i9, i5, a);
        }
    }

    private static <T> int a(T t, T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparator.compare(t, tArr[i6]) > 0) {
            int i7 = i2 - i3;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparator.compare(t, tArr[i6 + i9]) > 0) {
                int i10 = (i9 << 1) + 1;
                if (i10 <= 0) {
                    i8 = i9;
                    i9 = i7;
                } else {
                    int i11 = i9;
                    i9 = i10;
                    i8 = i11;
                }
            }
            if (i9 <= i7) {
                i7 = i9;
            }
            int i12 = i8 + i3;
            i5 = i7 + i3;
            i4 = i12;
        } else {
            int i13 = i3 + 1;
            int i14 = 0;
            int i15 = 1;
            while (i15 < i13 && comparator.compare(t, tArr[i6 - i15]) <= 0) {
                int i16 = (i15 << 1) + 1;
                if (i16 <= 0) {
                    i14 = i15;
                    i15 = i13;
                } else {
                    int i17 = i15;
                    i15 = i16;
                    i14 = i17;
                }
            }
            if (i15 <= i13) {
                i13 = i15;
            }
            i4 = i3 - i13;
            i5 = i3 - i14;
        }
        int i18 = i4 + 1;
        while (i18 < i5) {
            int i19 = ((i5 - i18) >>> 1) + i18;
            if (comparator.compare(t, tArr[i + i19]) > 0) {
                i18 = i19 + 1;
            } else {
                i5 = i19;
            }
        }
        return i5;
    }

    private static <T> int b(T t, T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparator.compare(t, tArr[i6]) < 0) {
            int i7 = i3 + 1;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparator.compare(t, tArr[i6 - i9]) < 0) {
                int i10 = (i9 << 1) + 1;
                if (i10 <= 0) {
                    i8 = i9;
                    i9 = i7;
                } else {
                    int i11 = i9;
                    i9 = i10;
                    i8 = i11;
                }
            }
            if (i9 <= i7) {
                i7 = i9;
            }
            i5 = i3 - i7;
            i4 = i3 - i8;
        } else {
            int i12 = i2 - i3;
            int i13 = 0;
            int i14 = 1;
            while (i14 < i12 && comparator.compare(t, tArr[i6 + i14]) >= 0) {
                int i15 = (i14 << 1) + 1;
                if (i15 <= 0) {
                    i13 = i14;
                    i14 = i12;
                } else {
                    int i16 = i14;
                    i14 = i15;
                    i13 = i16;
                }
            }
            if (i14 <= i12) {
                i12 = i14;
            }
            int i17 = i13 + i3;
            i4 = i3 + i12;
            i5 = i17;
        }
        int i18 = i5 + 1;
        while (i18 < i4) {
            int i19 = ((i4 - i18) >>> 1) + i18;
            if (comparator.compare(t, tArr[i + i19]) < 0) {
                i4 = i19;
            } else {
                i18 = i19 + 1;
            }
        }
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        r14 = r2;
        r12 = r4;
        r15 = r5;
        r17 = r6;
        r16 = r13;
        r13 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
        r6 = b(r7[r12], r8, r13, r14, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r6 == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
        java.lang.System.arraycopy(r8, r13, r7, r15, r6);
        r1 = r15 + r6;
        r3 = r13 + r6;
        r2 = r14 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
        if (r2 > r10) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0095, code lost:
        r14 = r2;
        r13 = r3;
        r9 = r10;
        r4 = r12;
        r12 = r16;
        r10 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        r15 = r1;
        r14 = r2;
        r13 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a2, code lost:
        r5 = r15 + 1;
        r4 = r12 + 1;
        r7[r15] = r7[r12];
        r12 = r16 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ac, code lost:
        if (r12 != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ae, code lost:
        r1 = r5;
        r9 = r10;
        r10 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b3, code lost:
        r1 = a(r8[r13], r7, r4, r12, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
        if (r1 == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
        java.lang.System.arraycopy(r7, r4, r7, r5, r1);
        r2 = r5 + r1;
        r4 = r4 + r1;
        r3 = r12 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cd, code lost:
        if (r3 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cf, code lost:
        r1 = r2;
        r12 = r3;
        r10 = r17;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d5, code lost:
        r12 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d7, code lost:
        r4 = r4;
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
        r3 = r2 + 1;
        r5 = r13 + 1;
        r7[r2] = r8[r13];
        r14 = r14 - 1;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e4, code lost:
        if (r14 != 1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e6, code lost:
        r1 = r3;
        r13 = r5;
        r10 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0108, code lost:
        r17 = r17 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010b, code lost:
        if (r6 < 7) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010d, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010f, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0110, code lost:
        if (r1 < 7) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0112, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0114, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0116, code lost:
        if ((r1 | r6) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0118, code lost:
        if (r17 >= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x011a, code lost:
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0129, code lost:
        r15 = r3;
        r13 = r5;
        r10 = 1;
        r16 = r12;
        r12 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0075 A[EDGE_INSN: B:75:0x0075->B:24:0x0075 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.an.a(int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        r16 = r2;
        r17 = r3;
        r12 = r4;
        r14 = r5;
        r15 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
        r6 = r13 - b(r8[r12], r7, r21, r13, r13 - 1, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008d, code lost:
        if (r6 == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008f, code lost:
        r1 = r14 - r6;
        r2 = r15 - r6;
        r13 = r13 - r6;
        java.lang.System.arraycopy(r7, r2 + 1, r7, r1 + 1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
        if (r13 != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009d, code lost:
        r15 = r2;
        r2 = r16;
        r3 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
        r14 = r1;
        r15 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r18 = r14 - 1;
        r19 = r12 - 1;
        r7[r14] = r8[r12];
        r12 = r16 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (r12 != 1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r2 = r12;
        r3 = r17;
        r1 = r18;
        r12 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
        r1 = r12 - a(r7[r15], r8, 0, r12, r12 - 1, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c9, code lost:
        if (r1 == 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cb, code lost:
        r2 = r18 - r1;
        r4 = r19 - r1;
        r3 = r12 - r1;
        java.lang.System.arraycopy(r8, r4 + 1, r7, r2 + 1, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d8, code lost:
        if (r3 > 1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00da, code lost:
        r1 = r2;
        r2 = r3;
        r12 = r4;
        r3 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e0, code lost:
        r18 = r2;
        r16 = r3;
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e6, code lost:
        r16 = r12;
        r12 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ea, code lost:
        r2 = r18 - 1;
        r3 = r15 - 1;
        r7[r18] = r7[r15];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f4, code lost:
        if (r13 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f6, code lost:
        r1 = r2;
        r15 = r3;
        r2 = r16;
        r3 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0121, code lost:
        r17 = r17 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0124, code lost:
        if (r6 < 7) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0126, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0128, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0129, code lost:
        if (r1 < 7) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x012b, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x012d, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x012f, code lost:
        if ((r1 | r5) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0131, code lost:
        if (r17 >= 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0133, code lost:
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0140, code lost:
        r14 = r2;
        r15 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0077 A[EDGE_INSN: B:74:0x0077->B:23:0x0077 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.an.b(int, int, int, int):void");
    }

    private T[] c(int i) {
        this.e = Math.max(this.e, i);
        if (this.d.length < i) {
            int i2 = (i >> 1) | i;
            int i3 = i2 | (i2 >> 2);
            int i4 = i3 | (i3 >> 4);
            int i5 = i4 | (i4 >> 8);
            int i6 = (i5 | (i5 >> 16)) + 1;
            if (i6 >= 0) {
                i = Math.min(i6, this.a.length >>> 1);
            }
            this.d = (T[]) new Object[i];
        }
        return this.d;
    }

    private static void a(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException(i2);
            }
            if (i3 > i) {
                throw new ArrayIndexOutOfBoundsException(i3);
            }
            return;
        }
        throw new IllegalArgumentException("fromIndex(" + i2 + ") > toIndex(" + i3 + ")");
    }
}
