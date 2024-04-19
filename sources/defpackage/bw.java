package defpackage;

import java.util.ArrayList;
/* compiled from: Chain.java */
/* renamed from: bw  reason: default package */
/* loaded from: classes.dex */
public class bw {
    public static void a(ca caVar, az azVar, ArrayList<bz> arrayList, int i) {
        int i2;
        int i3;
        bx[] bxVarArr;
        if (i == 0) {
            i3 = caVar.aF;
            bxVarArr = caVar.aI;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = caVar.aG;
            bxVarArr = caVar.aH;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            bx bxVar = bxVarArr[i4];
            bxVar.a();
            if (arrayList == null || (arrayList != null && arrayList.contains(bxVar.a))) {
                a(caVar, azVar, i, i2, bxVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x057a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void a(defpackage.ca r38, defpackage.az r39, int r40, int r41, defpackage.bx r42) {
        /*
            Method dump skipped, instructions count: 1444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bw.a(ca, az, int, int, bx):void");
    }
}
