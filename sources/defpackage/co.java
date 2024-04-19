package defpackage;

import defpackage.cn;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DimensionDependency.java */
/* renamed from: co  reason: default package */
/* loaded from: classes.dex */
public class co extends cn {
    public int m;

    public co(cx cxVar) {
        super(cxVar);
        if (cxVar instanceof ct) {
            this.e = cn.a.HORIZONTAL_DIMENSION;
        } else {
            this.e = cn.a.VERTICAL_DIMENSION;
        }
    }

    @Override // defpackage.cn
    public void a(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (cl clVar : this.k) {
            clVar.a(clVar);
        }
    }
}
