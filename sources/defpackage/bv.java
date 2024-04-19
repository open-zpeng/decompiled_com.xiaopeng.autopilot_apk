package defpackage;

import defpackage.by;
import defpackage.bz;
import java.util.HashMap;
/* compiled from: Barrier.java */
/* renamed from: bv  reason: default package */
/* loaded from: classes.dex */
public class bv extends ce {
    private int az = 0;
    private boolean aA = true;
    private int aB = 0;
    boolean a = false;

    @Override // defpackage.bz
    public boolean a() {
        return true;
    }

    public int b() {
        return this.az;
    }

    public void a(int i) {
        this.az = i;
    }

    public void a(boolean z) {
        this.aA = z;
    }

    public boolean c() {
        return this.aA;
    }

    @Override // defpackage.bz
    public boolean d() {
        return this.a;
    }

    @Override // defpackage.bz
    public boolean e() {
        return this.a;
    }

    @Override // defpackage.ce, defpackage.bz
    public void a(bz bzVar, HashMap<bz, bz> hashMap) {
        super.a(bzVar, hashMap);
        bv bvVar = (bv) bzVar;
        this.az = bvVar.az;
        this.aA = bvVar.aA;
        this.aB = bvVar.aB;
    }

    @Override // defpackage.bz
    public String toString() {
        String str = "[Barrier] " + C() + " {";
        for (int i = 0; i < this.ay; i++) {
            bz bzVar = this.ax[i];
            if (i > 0) {
                str = str + ", ";
            }
            str = str + bzVar.C();
        }
        return str + "}";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        for (int i = 0; i < this.ay; i++) {
            bz bzVar = this.ax[i];
            if (this.aA || bzVar.a()) {
                int i2 = this.az;
                if (i2 == 0 || i2 == 1) {
                    bzVar.a(0, true);
                } else if (i2 == 2 || i2 == 3) {
                    bzVar.a(1, true);
                }
            }
        }
    }

    @Override // defpackage.bz
    public void a(az azVar, boolean z) {
        boolean z2;
        this.H[0] = this.z;
        this.H[2] = this.A;
        this.H[1] = this.B;
        this.H[3] = this.C;
        for (int i = 0; i < this.H.length; i++) {
            this.H[i].f = azVar.a(this.H[i]);
        }
        int i2 = this.az;
        if (i2 < 0 || i2 >= 4) {
            return;
        }
        by byVar = this.H[this.az];
        if (!this.a) {
            i();
        }
        if (this.a) {
            this.a = false;
            int i3 = this.az;
            if (i3 == 0 || i3 == 1) {
                azVar.a(this.z.f, this.P);
                azVar.a(this.B.f, this.P);
                return;
            } else if (i3 == 2 || i3 == 3) {
                azVar.a(this.A.f, this.Q);
                azVar.a(this.C.f, this.Q);
                return;
            } else {
                return;
            }
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.ay) {
                z2 = false;
                break;
            }
            bz bzVar = this.ax[i4];
            if (this.aA || bzVar.a()) {
                int i5 = this.az;
                if ((i5 == 0 || i5 == 1) && bzVar.X() == bz.a.MATCH_CONSTRAINT && bzVar.z.c != null && bzVar.B.c != null) {
                    z2 = true;
                    break;
                }
                int i6 = this.az;
                if ((i6 == 2 || i6 == 3) && bzVar.Y() == bz.a.MATCH_CONSTRAINT && bzVar.A.c != null && bzVar.C.c != null) {
                    z2 = true;
                    break;
                }
            }
            i4++;
        }
        boolean z3 = this.z.c() || this.B.c();
        boolean z4 = this.A.c() || this.C.c();
        int i7 = !z2 && ((this.az == 0 && z3) || ((this.az == 2 && z4) || ((this.az == 1 && z3) || (this.az == 3 && z4)))) ? 5 : 4;
        for (int i8 = 0; i8 < this.ay; i8++) {
            bz bzVar2 = this.ax[i8];
            if (this.aA || bzVar2.a()) {
                bd a = azVar.a(bzVar2.H[this.az]);
                bzVar2.H[this.az].f = a;
                int i9 = (bzVar2.H[this.az].c == null || bzVar2.H[this.az].c.a != this) ? 0 : bzVar2.H[this.az].d + 0;
                int i10 = this.az;
                if (i10 == 0 || i10 == 2) {
                    azVar.b(byVar.f, a, this.aB - i9, z2);
                } else {
                    azVar.a(byVar.f, a, this.aB + i9, z2);
                }
                azVar.c(byVar.f, a, this.aB + i9, i7);
            }
        }
        int i11 = this.az;
        if (i11 == 0) {
            azVar.c(this.B.f, this.z.f, 0, 8);
            azVar.c(this.z.f, this.K.B.f, 0, 4);
            azVar.c(this.z.f, this.K.z.f, 0, 0);
        } else if (i11 == 1) {
            azVar.c(this.z.f, this.B.f, 0, 8);
            azVar.c(this.z.f, this.K.z.f, 0, 4);
            azVar.c(this.z.f, this.K.B.f, 0, 0);
        } else if (i11 == 2) {
            azVar.c(this.C.f, this.A.f, 0, 8);
            azVar.c(this.A.f, this.K.C.f, 0, 4);
            azVar.c(this.A.f, this.K.A.f, 0, 0);
        } else if (i11 == 3) {
            azVar.c(this.A.f, this.C.f, 0, 8);
            azVar.c(this.A.f, this.K.A.f, 0, 4);
            azVar.c(this.A.f, this.K.C.f, 0, 0);
        }
    }

    public void b(int i) {
        this.aB = i;
    }

    public int g() {
        return this.aB;
    }

    public int h() {
        switch (this.az) {
            case 0:
            case 1:
                return 0;
            case 2:
            case 3:
                return 1;
            default:
                return -1;
        }
    }

    public boolean i() {
        boolean z = true;
        for (int i = 0; i < this.ay; i++) {
            bz bzVar = this.ax[i];
            if (this.aA || bzVar.a()) {
                int i2 = this.az;
                if ((i2 == 0 || i2 == 1) && !bzVar.d()) {
                    z = false;
                } else {
                    int i3 = this.az;
                    if ((i3 == 2 || i3 == 3) && !bzVar.e()) {
                        z = false;
                    }
                }
            }
        }
        if (!z || this.ay <= 0) {
            return false;
        }
        int i4 = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < this.ay; i5++) {
            bz bzVar2 = this.ax[i5];
            if (this.aA || bzVar2.a()) {
                if (!z2) {
                    int i6 = this.az;
                    if (i6 == 0) {
                        i4 = bzVar2.a(by.a.LEFT).d();
                    } else if (i6 == 1) {
                        i4 = bzVar2.a(by.a.RIGHT).d();
                    } else if (i6 == 2) {
                        i4 = bzVar2.a(by.a.TOP).d();
                    } else if (i6 == 3) {
                        i4 = bzVar2.a(by.a.BOTTOM).d();
                    }
                    z2 = true;
                }
                int i7 = this.az;
                if (i7 == 0) {
                    i4 = Math.min(i4, bzVar2.a(by.a.LEFT).d());
                } else if (i7 == 1) {
                    i4 = Math.max(i4, bzVar2.a(by.a.RIGHT).d());
                } else if (i7 == 2) {
                    i4 = Math.min(i4, bzVar2.a(by.a.TOP).d());
                } else if (i7 == 3) {
                    i4 = Math.max(i4, bzVar2.a(by.a.BOTTOM).d());
                }
            }
        }
        int i8 = i4 + this.aB;
        int i9 = this.az;
        if (i9 == 0 || i9 == 1) {
            a(i8, i8);
        } else {
            b(i8, i8);
        }
        this.a = true;
        return true;
    }
}
