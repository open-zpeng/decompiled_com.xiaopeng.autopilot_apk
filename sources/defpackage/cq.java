package defpackage;

import defpackage.bz;
import java.util.ArrayList;
/* compiled from: Grouping.java */
/* renamed from: cq  reason: default package */
/* loaded from: classes.dex */
public class cq {
    public static boolean a(bz.a aVar, bz.a aVar2, bz.a aVar3, bz.a aVar4) {
        return (aVar3 == bz.a.FIXED || aVar3 == bz.a.WRAP_CONTENT || (aVar3 == bz.a.MATCH_PARENT && aVar != bz.a.WRAP_CONTENT)) || (aVar4 == bz.a.FIXED || aVar4 == bz.a.WRAP_CONTENT || (aVar4 == bz.a.MATCH_PARENT && aVar2 != bz.a.WRAP_CONTENT));
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03a9 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(defpackage.ca r16, defpackage.cj.b r17) {
        /*
            Method dump skipped, instructions count: 941
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cq.a(ca, cj$b):boolean");
    }

    private static cw a(ArrayList<cw> arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            cw cwVar = arrayList.get(i2);
            if (i == cwVar.c) {
                return cwVar;
            }
        }
        return null;
    }

    public static cw a(bz bzVar, int i, ArrayList<cw> arrayList, cw cwVar) {
        int i2;
        int A;
        if (i == 0) {
            i2 = bzVar.av;
        } else {
            i2 = bzVar.aw;
        }
        if (i2 != -1 && (cwVar == null || i2 != cwVar.c)) {
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                cw cwVar2 = arrayList.get(i3);
                if (cwVar2.b() == i2) {
                    if (cwVar != null) {
                        cwVar.a(i, cwVar2);
                        arrayList.remove(cwVar);
                    }
                    cwVar = cwVar2;
                } else {
                    i3++;
                }
            }
        } else if (i2 != -1) {
            return cwVar;
        }
        if (cwVar == null) {
            if ((bzVar instanceof ce) && (A = ((ce) bzVar).A(i)) != -1) {
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    cw cwVar3 = arrayList.get(i4);
                    if (cwVar3.b() == A) {
                        cwVar = cwVar3;
                        break;
                    }
                    i4++;
                }
            }
            if (cwVar == null) {
                cwVar = new cw(i);
            }
            arrayList.add(cwVar);
        }
        if (cwVar.a(bzVar)) {
            if (bzVar instanceof cc) {
                cc ccVar = (cc) bzVar;
                ccVar.b().a(ccVar.c() == 0 ? 1 : 0, arrayList, cwVar);
            }
            if (i == 0) {
                bzVar.av = cwVar.b();
                bzVar.z.a(i, arrayList, cwVar);
                bzVar.B.a(i, arrayList, cwVar);
            } else {
                bzVar.aw = cwVar.b();
                bzVar.A.a(i, arrayList, cwVar);
                bzVar.D.a(i, arrayList, cwVar);
                bzVar.C.a(i, arrayList, cwVar);
            }
            bzVar.G.a(i, arrayList, cwVar);
        }
        return cwVar;
    }
}
