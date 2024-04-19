package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
/* compiled from: Flow.java */
/* renamed from: cb  reason: default package */
/* loaded from: classes.dex */
public class cb extends cg {
    private bz[] aX;
    private int aA = -1;
    private int aB = -1;
    private int aC = -1;
    private int aD = -1;
    private int aE = -1;
    private int aF = -1;
    private float aG = 0.5f;
    private float aH = 0.5f;
    private float aI = 0.5f;
    private float aJ = 0.5f;
    private float aK = 0.5f;
    private float aL = 0.5f;
    private int aM = 0;
    private int aN = 0;
    private int aO = 2;
    private int aP = 2;
    private int aQ = 0;
    private int aR = -1;
    private int aS = 0;
    private ArrayList<a> aT = new ArrayList<>();
    private bz[] aU = null;
    private bz[] aV = null;
    private int[] aW = null;
    private int aY = 0;

    @Override // defpackage.ce, defpackage.bz
    public void a(bz bzVar, HashMap<bz, bz> hashMap) {
        super.a(bzVar, hashMap);
        cb cbVar = (cb) bzVar;
        this.aA = cbVar.aA;
        this.aB = cbVar.aB;
        this.aC = cbVar.aC;
        this.aD = cbVar.aD;
        this.aE = cbVar.aE;
        this.aF = cbVar.aF;
        this.aG = cbVar.aG;
        this.aH = cbVar.aH;
        this.aI = cbVar.aI;
        this.aJ = cbVar.aJ;
        this.aK = cbVar.aK;
        this.aL = cbVar.aL;
        this.aM = cbVar.aM;
        this.aN = cbVar.aN;
        this.aO = cbVar.aO;
        this.aP = cbVar.aP;
        this.aQ = cbVar.aQ;
        this.aR = cbVar.aR;
        this.aS = cbVar.aS;
    }

    /* compiled from: Flow.java */
    /* renamed from: cb$a */
    /* loaded from: classes.dex */
    private class a {
        final /* synthetic */ cb a;
        private int b;
        private bz c;
        private by d;
        private by e;
        private by f;
        private by g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;

        public void a(boolean z, int i, boolean z2) {
            bz bzVar;
            char c;
            int i2 = this.m;
            for (int i3 = 0; i3 < i2 && this.l + i3 < this.a.aY; i3++) {
                bz bzVar2 = this.a.aX[this.l + i3];
                if (bzVar2 != null) {
                    bzVar2.W();
                }
            }
            if (i2 == 0 || this.c == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i4 = -1;
            int i5 = -1;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = z ? (i2 - 1) - i6 : i6;
                if (this.l + i7 >= this.a.aY) {
                    break;
                }
                if (this.a.aX[this.l + i7].B() == 0) {
                    if (i4 == -1) {
                        i4 = i6;
                    }
                    i5 = i6;
                }
            }
            if (this.b == 0) {
                bz bzVar3 = this.c;
                bzVar3.w(this.a.aB);
                int i8 = this.i;
                if (i > 0) {
                    i8 += this.a.aN;
                }
                bzVar3.A.a(this.e, i8);
                if (z2) {
                    bzVar3.C.a(this.g, this.k);
                }
                if (i > 0) {
                    this.e.a.C.a(bzVar3.A, 0);
                }
                if (this.a.aP == 3 && !bzVar3.P()) {
                    for (int i9 = 0; i9 < i2; i9++) {
                        int i10 = z ? (i2 - 1) - i9 : i9;
                        if (this.l + i10 >= this.a.aY) {
                            break;
                        }
                        bzVar = this.a.aX[this.l + i10];
                        if (bzVar.P()) {
                            break;
                        }
                    }
                }
                bzVar = bzVar3;
                bz bzVar4 = null;
                int i11 = 0;
                while (i11 < i2) {
                    int i12 = z ? (i2 - 1) - i11 : i11;
                    if (this.l + i12 >= this.a.aY) {
                        return;
                    }
                    bz bzVar5 = this.a.aX[this.l + i12];
                    if (i11 == 0) {
                        bzVar5.a(bzVar5.z, this.d, this.h);
                    }
                    if (i12 == 0) {
                        int i13 = this.a.aA;
                        float f = z ? 1.0f - this.a.aG : this.a.aG;
                        if (this.l != 0 || this.a.aC == -1) {
                            if (z2 && this.a.aE != -1) {
                                i13 = this.a.aE;
                                f = z ? 1.0f - this.a.aK : this.a.aK;
                            }
                        } else {
                            i13 = this.a.aC;
                            f = z ? 1.0f - this.a.aI : this.a.aI;
                        }
                        bzVar5.v(i13);
                        bzVar5.a(f);
                    }
                    if (i11 == i2 - 1) {
                        bzVar5.a(bzVar5.B, this.f, this.j);
                    }
                    if (bzVar4 != null) {
                        bzVar5.z.a(bzVar4.B, this.a.aM);
                        if (i11 == i4) {
                            bzVar5.z.b(this.h);
                        }
                        bzVar4.B.a(bzVar5.z, 0);
                        if (i11 == i5 + 1) {
                            bzVar4.B.b(this.j);
                        }
                    }
                    if (bzVar5 != bzVar3) {
                        c = 3;
                        if (this.a.aP == 3 && bzVar.P() && bzVar5 != bzVar && bzVar5.P()) {
                            bzVar5.D.a(bzVar.D, 0);
                        } else {
                            switch (this.a.aP) {
                                case 0:
                                    bzVar5.A.a(bzVar3.A, 0);
                                    continue;
                                case 1:
                                    bzVar5.C.a(bzVar3.C, 0);
                                    continue;
                                default:
                                    if (z3) {
                                        bzVar5.A.a(this.e, this.i);
                                        bzVar5.C.a(this.g, this.k);
                                        continue;
                                    } else {
                                        bzVar5.A.a(bzVar3.A, 0);
                                        bzVar5.C.a(bzVar3.C, 0);
                                        break;
                                    }
                            }
                        }
                    } else {
                        c = 3;
                    }
                    i11++;
                    bzVar4 = bzVar5;
                }
                return;
            }
            bz bzVar6 = this.c;
            bzVar6.v(this.a.aA);
            int i14 = this.h;
            if (i > 0) {
                i14 += this.a.aM;
            }
            if (z) {
                bzVar6.B.a(this.f, i14);
                if (z2) {
                    bzVar6.z.a(this.d, this.j);
                }
                if (i > 0) {
                    this.f.a.z.a(bzVar6.B, 0);
                }
            } else {
                bzVar6.z.a(this.d, i14);
                if (z2) {
                    bzVar6.B.a(this.f, this.j);
                }
                if (i > 0) {
                    this.d.a.B.a(bzVar6.z, 0);
                }
            }
            bz bzVar7 = null;
            int i15 = 0;
            while (i15 < i2 && this.l + i15 < this.a.aY) {
                bz bzVar8 = this.a.aX[this.l + i15];
                if (i15 == 0) {
                    bzVar8.a(bzVar8.A, this.e, this.i);
                    int i16 = this.a.aB;
                    float f2 = this.a.aH;
                    if (this.l != 0 || this.a.aD == -1) {
                        if (z2 && this.a.aF != -1) {
                            i16 = this.a.aF;
                            f2 = this.a.aL;
                        }
                    } else {
                        i16 = this.a.aD;
                        f2 = this.a.aJ;
                    }
                    bzVar8.w(i16);
                    bzVar8.b(f2);
                }
                if (i15 == i2 - 1) {
                    bzVar8.a(bzVar8.C, this.g, this.k);
                }
                if (bzVar7 != null) {
                    bzVar8.A.a(bzVar7.C, this.a.aN);
                    if (i15 == i4) {
                        bzVar8.A.b(this.i);
                    }
                    bzVar7.C.a(bzVar8.A, 0);
                    if (i15 == i5 + 1) {
                        bzVar7.C.b(this.k);
                    }
                }
                if (bzVar8 != bzVar6) {
                    if (z) {
                        switch (this.a.aO) {
                            case 0:
                                bzVar8.B.a(bzVar6.B, 0);
                                continue;
                            case 1:
                                bzVar8.z.a(bzVar6.z, 0);
                                continue;
                            case 2:
                                bzVar8.z.a(bzVar6.z, 0);
                                bzVar8.B.a(bzVar6.B, 0);
                                continue;
                        }
                    } else {
                        switch (this.a.aO) {
                            case 0:
                                bzVar8.z.a(bzVar6.z, 0);
                                continue;
                            case 1:
                                bzVar8.B.a(bzVar6.B, 0);
                                continue;
                            case 2:
                                if (z3) {
                                    bzVar8.z.a(this.d, this.h);
                                    bzVar8.B.a(this.f, this.j);
                                    continue;
                                } else {
                                    bzVar8.z.a(bzVar6.z, 0);
                                    bzVar8.B.a(bzVar6.B, 0);
                                    break;
                                }
                        }
                    }
                }
                i15++;
                bzVar7 = bzVar8;
            }
        }
    }

    private void f(boolean z) {
        bz bzVar;
        float f;
        int i;
        if (this.aW == null || this.aV == null || this.aU == null) {
            return;
        }
        for (int i2 = 0; i2 < this.aY; i2++) {
            this.aX[i2].W();
        }
        int[] iArr = this.aW;
        int i3 = iArr[0];
        int i4 = iArr[1];
        float f2 = this.aG;
        bz bzVar2 = null;
        int i5 = 0;
        while (i5 < i3) {
            if (z) {
                i = (i3 - i5) - 1;
                f = 1.0f - this.aG;
            } else {
                f = f2;
                i = i5;
            }
            bz bzVar3 = this.aV[i];
            if (bzVar3 != null && bzVar3.B() != 8) {
                if (i5 == 0) {
                    bzVar3.a(bzVar3.z, this.z, f());
                    bzVar3.v(this.aA);
                    bzVar3.a(f);
                }
                if (i5 == i3 - 1) {
                    bzVar3.a(bzVar3.B, this.B, g());
                }
                if (i5 > 0 && bzVar2 != null) {
                    bzVar3.a(bzVar3.z, bzVar2.B, this.aM);
                    bzVar2.a(bzVar2.B, bzVar3.z, 0);
                }
                bzVar2 = bzVar3;
            }
            i5++;
            f2 = f;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            bz bzVar4 = this.aU[i6];
            if (bzVar4 != null && bzVar4.B() != 8) {
                if (i6 == 0) {
                    bzVar4.a(bzVar4.A, this.A, b());
                    bzVar4.w(this.aB);
                    bzVar4.b(this.aH);
                }
                if (i6 == i4 - 1) {
                    bzVar4.a(bzVar4.C, this.C, c());
                }
                if (i6 > 0 && bzVar2 != null) {
                    bzVar4.a(bzVar4.A, bzVar2.C, this.aN);
                    bzVar2.a(bzVar2.C, bzVar4.A, 0);
                }
                bzVar2 = bzVar4;
            }
        }
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = (i8 * i3) + i7;
                if (this.aS == 1) {
                    i9 = (i7 * i4) + i8;
                }
                bz[] bzVarArr = this.aX;
                if (i9 < bzVarArr.length && (bzVar = bzVarArr[i9]) != null && bzVar.B() != 8) {
                    bz bzVar5 = this.aV[i7];
                    bz bzVar6 = this.aU[i8];
                    if (bzVar != bzVar5) {
                        bzVar.a(bzVar.z, bzVar5.z, 0);
                        bzVar.a(bzVar.B, bzVar5.B, 0);
                    }
                    if (bzVar != bzVar6) {
                        bzVar.a(bzVar.A, bzVar6.A, 0);
                        bzVar.a(bzVar.C, bzVar6.C, 0);
                    }
                }
            }
        }
    }

    @Override // defpackage.bz
    public void a(az azVar, boolean z) {
        super.a(azVar, z);
        boolean z2 = A() != null && ((ca) A()).ad();
        switch (this.aQ) {
            case 0:
                if (this.aT.size() > 0) {
                    this.aT.get(0).a(z2, 0, true);
                    break;
                }
                break;
            case 1:
                int size = this.aT.size();
                int i = 0;
                while (i < size) {
                    this.aT.get(i).a(z2, i, i == size + (-1));
                    i++;
                }
                break;
            case 2:
                f(z2);
                break;
        }
        a(false);
    }
}
