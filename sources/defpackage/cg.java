package defpackage;

import defpackage.cj;
import java.util.HashSet;
/* compiled from: VirtualLayout.java */
/* renamed from: cg  reason: default package */
/* loaded from: classes.dex */
public class cg extends ce {
    private int aA = 0;
    private int aB = 0;
    private int aC = 0;
    private int aD = 0;
    private int aE = 0;
    private int aF = 0;
    private int aG = 0;
    private int aH = 0;
    private boolean aI = false;
    private int aJ = 0;
    private int aK = 0;
    protected cj.a a = new cj.a();
    cj.b az = null;

    public int b() {
        return this.aA;
    }

    public int c() {
        return this.aB;
    }

    public int f() {
        return this.aG;
    }

    public int g() {
        return this.aH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.aI = z;
    }

    public boolean h() {
        return this.aI;
    }

    @Override // defpackage.ce, defpackage.cd
    public void a(ca caVar) {
        i();
    }

    public void i() {
        for (int i = 0; i < this.ay; i++) {
            bz bzVar = this.ax[i];
            if (bzVar != null) {
                bzVar.b(true);
            }
        }
    }

    public boolean a(HashSet<bz> hashSet) {
        for (int i = 0; i < this.ay; i++) {
            if (hashSet.contains(this.ax[i])) {
                return true;
            }
        }
        return false;
    }
}
