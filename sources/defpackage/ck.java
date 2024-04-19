package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ChainRun.java */
/* renamed from: ck  reason: default package */
/* loaded from: classes.dex */
public class ck extends cx {
    ArrayList<cx> a;
    private int b;

    public ck(bz bzVar, int i) {
        super(bzVar);
        this.a = new ArrayList<>();
        this.h = i;
        h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.h == 0 ? "horizontal : " : "vertical : ");
        Iterator<cx> it = this.a.iterator();
        while (it.hasNext()) {
            sb.append("<");
            sb.append(it.next());
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public boolean a() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (!this.a.get(i).a()) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.cx
    public long b() {
        int size = this.a.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            cx cxVar = this.a.get(i);
            j = j + cxVar.j.f + cxVar.b() + cxVar.k.f;
        }
        return j;
    }

    private void h() {
        bz bzVar = this.d;
        bz bzVar2 = bzVar;
        bz y = bzVar.y(this.h);
        while (y != null) {
            bzVar2 = y;
            y = y.y(this.h);
        }
        this.d = bzVar2;
        this.a.add(bzVar2.c(this.h));
        bz z = bzVar2.z(this.h);
        while (z != null) {
            this.a.add(z.c(this.h));
            z = z.z(this.h);
        }
        Iterator<cx> it = this.a.iterator();
        while (it.hasNext()) {
            cx next = it.next();
            if (this.h == 0) {
                next.d.d = this;
            } else if (this.h == 1) {
                next.d.e = this;
            }
        }
        if ((this.h == 0 && ((ca) this.d.A()).ad()) && this.a.size() > 1) {
            ArrayList<cx> arrayList = this.a;
            this.d = arrayList.get(arrayList.size() - 1).d;
        }
        this.b = this.h == 0 ? this.d.U() : this.d.V();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public void c() {
        this.e = null;
        Iterator<cx> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // defpackage.cx
    void d() {
        this.j.j = false;
        this.k.j = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:266:0x0402, code lost:
        r2 = r2 - r9;
     */
    @Override // defpackage.cx, defpackage.cl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(defpackage.cl r24) {
        /*
            Method dump skipped, instructions count: 1067
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ck.a(cl):void");
    }

    @Override // defpackage.cx
    public void e() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).e();
        }
    }

    private bz i() {
        for (int i = 0; i < this.a.size(); i++) {
            cx cxVar = this.a.get(i);
            if (cxVar.d.B() != 8) {
                return cxVar.d;
            }
        }
        return null;
    }

    private bz j() {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            cx cxVar = this.a.get(size);
            if (cxVar.d.B() != 8) {
                return cxVar.d;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.cx
    public void f() {
        Iterator<cx> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        int size = this.a.size();
        if (size < 1) {
            return;
        }
        bz bzVar = this.a.get(0).d;
        bz bzVar2 = this.a.get(size - 1).d;
        if (this.h == 0) {
            by byVar = bzVar.z;
            by byVar2 = bzVar2.B;
            cn a = a(byVar, 0);
            int j = byVar.j();
            bz i = i();
            if (i != null) {
                j = i.z.j();
            }
            if (a != null) {
                a(this.j, a, j);
            }
            cn a2 = a(byVar2, 0);
            int j2 = byVar2.j();
            bz j3 = j();
            if (j3 != null) {
                j2 = j3.B.j();
            }
            if (a2 != null) {
                a(this.k, a2, -j2);
            }
        } else {
            by byVar3 = bzVar.A;
            by byVar4 = bzVar2.C;
            cn a3 = a(byVar3, 1);
            int j4 = byVar3.j();
            bz i2 = i();
            if (i2 != null) {
                j4 = i2.A.j();
            }
            if (a3 != null) {
                a(this.j, a3, j4);
            }
            cn a4 = a(byVar4, 1);
            int j5 = byVar4.j();
            bz j6 = j();
            if (j6 != null) {
                j5 = j6.C.j();
            }
            if (a4 != null) {
                a(this.k, a4, -j5);
            }
        }
        this.j.a = this;
        this.k.a = this;
    }
}
