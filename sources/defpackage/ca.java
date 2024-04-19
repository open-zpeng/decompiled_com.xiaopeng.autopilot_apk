package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import defpackage.bz;
import defpackage.cj;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ConstraintWidgetContainer.java */
/* renamed from: ca  reason: default package */
/* loaded from: classes.dex */
public class ca extends ch {
    static int aS;
    int aB;
    int aC;
    int aD;
    int aE;
    private int aU;
    public ba az;
    cj a = new cj(this);
    public cm ax = new cm(this);
    protected cj.b ay = null;
    private boolean aV = false;
    protected az aA = new az();
    public int aF = 0;
    public int aG = 0;
    bx[] aH = new bx[4];
    bx[] aI = new bx[4];
    public boolean aJ = false;
    public boolean aK = false;
    public boolean aL = false;
    public int aM = 0;
    public int aN = 0;
    private int aW = 257;
    public boolean aO = false;
    private boolean aX = false;
    private boolean aY = false;
    int aP = 0;
    private WeakReference<by> aZ = null;
    private WeakReference<by> ba = null;
    private WeakReference<by> bb = null;
    private WeakReference<by> bc = null;
    HashSet<bz> aQ = new HashSet<>();
    public cj.a aR = new cj.a();

    public boolean af() {
        return false;
    }

    public void b() {
        this.ax.b();
    }

    public void c() {
        this.ax.c();
    }

    public boolean a(boolean z) {
        return this.ax.a(z);
    }

    public boolean f(boolean z) {
        return this.ax.b(z);
    }

    public boolean a(boolean z, int i) {
        return this.ax.a(z, i);
    }

    public long a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aB = i8;
        this.aC = i9;
        return this.a.a(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    public void f() {
        this.a.a(this);
    }

    public void a(cj.b bVar) {
        this.ay = bVar;
        this.ax.a(bVar);
    }

    public cj.b g() {
        return this.ay;
    }

    public void a(ba baVar) {
        this.az = baVar;
        this.aA.a(baVar);
    }

    public void a(int i) {
        this.aW = i;
        az azVar = this.aA;
        az.a = b(IInputController.KEYCODE_BACK_BUTTON);
    }

    public int h() {
        return this.aW;
    }

    public boolean b(int i) {
        return (this.aW & i) == i;
    }

    @Override // defpackage.ch, defpackage.bz
    public void w() {
        this.aA.b();
        this.aB = 0;
        this.aD = 0;
        this.aC = 0;
        this.aE = 0;
        this.aO = false;
        super.w();
    }

    public boolean i() {
        return this.aX;
    }

    public boolean ac() {
        return this.aY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(by byVar) {
        WeakReference<by> weakReference = this.aZ;
        if (weakReference == null || weakReference.get() == null || byVar.d() > this.aZ.get().d()) {
            this.aZ = new WeakReference<>(byVar);
        }
    }

    public void b(by byVar) {
        WeakReference<by> weakReference = this.ba;
        if (weakReference == null || weakReference.get() == null || byVar.d() > this.ba.get().d()) {
            this.ba = new WeakReference<>(byVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(by byVar) {
        WeakReference<by> weakReference = this.bb;
        if (weakReference == null || weakReference.get() == null || byVar.d() > this.bb.get().d()) {
            this.bb = new WeakReference<>(byVar);
        }
    }

    public void d(by byVar) {
        WeakReference<by> weakReference = this.bc;
        if (weakReference == null || weakReference.get() == null || byVar.d() > this.bc.get().d()) {
            this.bc = new WeakReference<>(byVar);
        }
    }

    private void a(by byVar, bd bdVar) {
        this.aA.a(this.aA.a(byVar), bdVar, 0, 5);
    }

    private void b(by byVar, bd bdVar) {
        this.aA.a(bdVar, this.aA.a(byVar), 0, 5);
    }

    public boolean b(az azVar) {
        boolean b = b(64);
        a(azVar, b);
        int size = this.aT.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            bz bzVar = this.aT.get(i);
            bzVar.a(0, false);
            bzVar.a(1, false);
            if (bzVar instanceof bv) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                bz bzVar2 = this.aT.get(i2);
                if (bzVar2 instanceof bv) {
                    ((bv) bzVar2).f();
                }
            }
        }
        this.aQ.clear();
        for (int i3 = 0; i3 < size; i3++) {
            bz bzVar3 = this.aT.get(i3);
            if (bzVar3.ab()) {
                if (bzVar3 instanceof cg) {
                    this.aQ.add(bzVar3);
                } else {
                    bzVar3.a(azVar, b);
                }
            }
        }
        while (this.aQ.size() > 0) {
            int size2 = this.aQ.size();
            Iterator<bz> it = this.aQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                cg cgVar = (cg) it.next();
                if (cgVar.a(this.aQ)) {
                    cgVar.a(azVar, b);
                    this.aQ.remove(cgVar);
                    break;
                }
            }
            if (size2 == this.aQ.size()) {
                Iterator<bz> it2 = this.aQ.iterator();
                while (it2.hasNext()) {
                    it2.next().a(azVar, b);
                }
                this.aQ.clear();
            }
        }
        if (az.a) {
            HashSet<bz> hashSet = new HashSet<>();
            for (int i4 = 0; i4 < size; i4++) {
                bz bzVar4 = this.aT.get(i4);
                if (!bzVar4.ab()) {
                    hashSet.add(bzVar4);
                }
            }
            a(this, azVar, hashSet, X() == bz.a.WRAP_CONTENT ? 0 : 1, false);
            Iterator<bz> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                bz next = it3.next();
                cf.a(this, azVar, next);
                next.a(azVar, b);
            }
        } else {
            for (int i5 = 0; i5 < size; i5++) {
                bz bzVar5 = this.aT.get(i5);
                if (bzVar5 instanceof ca) {
                    bz.a aVar = bzVar5.J[0];
                    bz.a aVar2 = bzVar5.J[1];
                    if (aVar == bz.a.WRAP_CONTENT) {
                        bzVar5.a(bz.a.FIXED);
                    }
                    if (aVar2 == bz.a.WRAP_CONTENT) {
                        bzVar5.b(bz.a.FIXED);
                    }
                    bzVar5.a(azVar, b);
                    if (aVar == bz.a.WRAP_CONTENT) {
                        bzVar5.a(aVar);
                    }
                    if (aVar2 == bz.a.WRAP_CONTENT) {
                        bzVar5.b(aVar2);
                    }
                } else {
                    cf.a(this, azVar, bzVar5);
                    if (!bzVar5.ab()) {
                        bzVar5.a(azVar, b);
                    }
                }
            }
        }
        if (this.aF > 0) {
            bw.a(this, azVar, null, 0);
        }
        if (this.aG > 0) {
            bw.a(this, azVar, null, 1);
        }
        return true;
    }

    public boolean a(az azVar, boolean[] zArr) {
        zArr[2] = false;
        boolean b = b(64);
        b(azVar, b);
        int size = this.aT.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            bz bzVar = this.aT.get(i);
            bzVar.b(azVar, b);
            if (bzVar.y()) {
                z = true;
            }
        }
        return z;
    }

    @Override // defpackage.bz
    public void a(boolean z, boolean z2) {
        super.a(z, z2);
        int size = this.aT.size();
        for (int i = 0; i < size; i++) {
            this.aT.get(i).a(z, z2);
        }
    }

    public void g(boolean z) {
        this.aV = z;
    }

    public boolean ad() {
        return this.aV;
    }

    public static boolean a(int i, bz bzVar, cj.b bVar, cj.a aVar, int i2) {
        int i3;
        int i4;
        if (bVar == null) {
            return false;
        }
        if (bzVar.B() == 8 || (bzVar instanceof cc) || (bzVar instanceof bv)) {
            aVar.h = 0;
            aVar.i = 0;
            return false;
        }
        aVar.d = bzVar.X();
        aVar.e = bzVar.Y();
        aVar.f = bzVar.F();
        aVar.g = bzVar.G();
        aVar.l = false;
        aVar.m = i2;
        boolean z = aVar.d == bz.a.MATCH_CONSTRAINT;
        boolean z2 = aVar.e == bz.a.MATCH_CONSTRAINT;
        boolean z3 = z && bzVar.N > 0.0f;
        boolean z4 = z2 && bzVar.N > 0.0f;
        if (z && bzVar.g(0) && bzVar.m == 0 && !z3) {
            aVar.d = bz.a.WRAP_CONTENT;
            if (z2 && bzVar.n == 0) {
                aVar.d = bz.a.FIXED;
            }
            z = false;
        }
        if (z2 && bzVar.g(1) && bzVar.n == 0 && !z4) {
            aVar.e = bz.a.WRAP_CONTENT;
            if (z && bzVar.m == 0) {
                aVar.e = bz.a.FIXED;
            }
            z2 = false;
        }
        if (bzVar.d()) {
            aVar.d = bz.a.FIXED;
            z = false;
        }
        if (bzVar.e()) {
            aVar.e = bz.a.FIXED;
            z2 = false;
        }
        if (z3) {
            if (bzVar.o[0] == 4) {
                aVar.d = bz.a.FIXED;
            } else if (!z2) {
                if (aVar.e == bz.a.FIXED) {
                    i4 = aVar.g;
                } else {
                    aVar.d = bz.a.WRAP_CONTENT;
                    bVar.a(bzVar, aVar);
                    i4 = aVar.i;
                }
                aVar.d = bz.a.FIXED;
                aVar.f = (int) (bzVar.S() * i4);
            }
        }
        if (z4) {
            if (bzVar.o[1] == 4) {
                aVar.e = bz.a.FIXED;
            } else if (!z) {
                if (aVar.d == bz.a.FIXED) {
                    i3 = aVar.f;
                } else {
                    aVar.e = bz.a.WRAP_CONTENT;
                    bVar.a(bzVar, aVar);
                    i3 = aVar.h;
                }
                aVar.e = bz.a.FIXED;
                if (bzVar.T() == -1) {
                    aVar.g = (int) (i3 / bzVar.S());
                } else {
                    aVar.g = (int) (bzVar.S() * i3);
                }
            }
        }
        bVar.a(bzVar, aVar);
        bzVar.q(aVar.h);
        bzVar.r(aVar.i);
        bzVar.c(aVar.k);
        bzVar.u(aVar.j);
        aVar.m = cj.a.a;
        return aVar.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x033a  */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // defpackage.ch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void ae() {
        /*
            Method dump skipped, instructions count: 861
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ca.ae():void");
    }

    public az ag() {
        return this.aA;
    }

    private void aj() {
        this.aF = 0;
        this.aG = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(bz bzVar, int i) {
        if (i == 0) {
            d(bzVar);
        } else if (i == 1) {
            e(bzVar);
        }
    }

    private void d(bz bzVar) {
        int i = this.aF + 1;
        bx[] bxVarArr = this.aI;
        if (i >= bxVarArr.length) {
            this.aI = (bx[]) Arrays.copyOf(bxVarArr, bxVarArr.length * 2);
        }
        this.aI[this.aF] = new bx(bzVar, 0, ad());
        this.aF++;
    }

    private void e(bz bzVar) {
        int i = this.aG + 1;
        bx[] bxVarArr = this.aH;
        if (i >= bxVarArr.length) {
            this.aH = (bx[]) Arrays.copyOf(bxVarArr, bxVarArr.length * 2);
        }
        this.aH[this.aG] = new bx(bzVar, 1, ad());
        this.aG++;
    }

    public void A(int i) {
        this.aU = i;
    }
}
