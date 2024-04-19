package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/* compiled from: HelperWidget.java */
/* renamed from: ce  reason: default package */
/* loaded from: classes.dex */
public class ce extends bz implements cd {
    public bz[] ax = new bz[4];
    public int ay = 0;

    @Override // defpackage.cd
    public void a(ca caVar) {
    }

    @Override // defpackage.cd
    public void a(bz bzVar) {
        if (bzVar == this || bzVar == null) {
            return;
        }
        int i = this.ay + 1;
        bz[] bzVarArr = this.ax;
        if (i > bzVarArr.length) {
            this.ax = (bz[]) Arrays.copyOf(bzVarArr, bzVarArr.length * 2);
        }
        bz[] bzVarArr2 = this.ax;
        int i2 = this.ay;
        bzVarArr2[i2] = bzVar;
        this.ay = i2 + 1;
    }

    @Override // defpackage.bz
    public void a(bz bzVar, HashMap<bz, bz> hashMap) {
        super.a(bzVar, hashMap);
        ce ceVar = (ce) bzVar;
        this.ay = 0;
        int i = ceVar.ay;
        for (int i2 = 0; i2 < i; i2++) {
            a(hashMap.get(ceVar.ax[i2]));
        }
    }

    @Override // defpackage.cd
    public void c_() {
        this.ay = 0;
        Arrays.fill(this.ax, (Object) null);
    }

    public void a(ArrayList<cw> arrayList, int i, cw cwVar) {
        for (int i2 = 0; i2 < this.ay; i2++) {
            cwVar.a(this.ax[i2]);
        }
        for (int i3 = 0; i3 < this.ay; i3++) {
            cq.a(this.ax[i3], i, arrayList, cwVar);
        }
    }

    public int A(int i) {
        for (int i2 = 0; i2 < this.ay; i2++) {
            bz bzVar = this.ax[i2];
            if (i == 0 && bzVar.av != -1) {
                return bzVar.av;
            }
            if (i == 1 && bzVar.aw != -1) {
                return bzVar.aw;
            }
        }
        return -1;
    }
}
