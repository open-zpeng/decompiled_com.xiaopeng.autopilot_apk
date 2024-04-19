package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: DependencyNode.java */
/* renamed from: cn  reason: default package */
/* loaded from: classes.dex */
public class cn implements cl {
    cx d;
    int f;
    public int g;
    public cl a = null;
    public boolean b = false;
    public boolean c = false;
    a e = a.UNKNOWN;
    int h = 1;
    co i = null;
    public boolean j = false;
    List<cl> k = new ArrayList();
    List<cn> l = new ArrayList();

    /* compiled from: DependencyNode.java */
    /* renamed from: cn$a */
    /* loaded from: classes.dex */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public cn(cx cxVar) {
        this.d = cxVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.d.C());
        sb.append(":");
        sb.append(this.e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }

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

    @Override // defpackage.cl
    public void a(cl clVar) {
        for (cn cnVar : this.l) {
            if (!cnVar.j) {
                return;
            }
        }
        this.c = true;
        cl clVar2 = this.a;
        if (clVar2 != null) {
            clVar2.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        cn cnVar2 = null;
        int i = 0;
        for (cn cnVar3 : this.l) {
            if (!(cnVar3 instanceof co)) {
                i++;
                cnVar2 = cnVar3;
            }
        }
        if (cnVar2 != null && i == 1 && cnVar2.j) {
            co coVar = this.i;
            if (coVar != null) {
                if (!coVar.j) {
                    return;
                }
                this.f = this.h * this.i.g;
            }
            a(cnVar2.g + this.f);
        }
        cl clVar3 = this.a;
        if (clVar3 != null) {
            clVar3.a(this);
        }
    }

    public void b(cl clVar) {
        this.k.add(clVar);
        if (this.j) {
            clVar.a(clVar);
        }
    }

    public void a() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }
}
