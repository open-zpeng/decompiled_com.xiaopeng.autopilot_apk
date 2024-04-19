package defpackage;

import defpackage.az;
import defpackage.bd;
import java.util.ArrayList;
/* compiled from: ArrayRow.java */
/* renamed from: ax  reason: default package */
/* loaded from: classes.dex */
public class ax implements az.a {
    public a e;
    bd a = null;
    float b = 0.0f;
    boolean c = false;
    ArrayList<bd> d = new ArrayList<>();
    boolean f = false;

    /* compiled from: ArrayRow.java */
    /* renamed from: ax$a */
    /* loaded from: classes.dex */
    public interface a {
        float a(ax axVar, boolean z);

        float a(bd bdVar, boolean z);

        bd a(int i);

        void a();

        void a(float f);

        void a(bd bdVar, float f);

        void a(bd bdVar, float f, boolean z);

        boolean a(bd bdVar);

        float b(int i);

        float b(bd bdVar);

        void b();

        int c();
    }

    public ax() {
    }

    public ax(ay ayVar) {
        this.e = new aw(this, ayVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        bd bdVar = this.a;
        return bdVar != null && (bdVar.i == bd.a.UNRESTRICTED || this.b >= 0.0f);
    }

    public String toString() {
        return b();
    }

    String b() {
        boolean z;
        float b;
        int i;
        String str = (this.a == null ? "0" : "" + this.a) + " = ";
        if (this.b != 0.0f) {
            str = str + this.b;
            z = true;
        } else {
            z = false;
        }
        int c = this.e.c();
        for (int i2 = 0; i2 < c; i2++) {
            bd a2 = this.e.a(i2);
            if (a2 != null && (this.e.b(i2)) != 0.0f) {
                String bdVar = a2.toString();
                if (z) {
                    if (i > 0) {
                        str = str + " + ";
                    } else {
                        str = str + " - ";
                        b *= -1.0f;
                    }
                } else if (b < 0.0f) {
                    str = str + "- ";
                    b *= -1.0f;
                }
                str = b == 1.0f ? str + bdVar : str + b + " " + bdVar;
                z = true;
            }
        }
        if (z) {
            return str;
        }
        return str + "0.0";
    }

    public void c() {
        this.a = null;
        this.e.a();
        this.b = 0.0f;
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(bd bdVar) {
        return this.e.a(bdVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax a(bd bdVar, int i) {
        this.a = bdVar;
        float f = i;
        bdVar.e = f;
        this.b = f;
        this.f = true;
        return this;
    }

    public ax b(bd bdVar, int i) {
        if (i < 0) {
            this.b = i * (-1);
            this.e.a(bdVar, 1.0f);
        } else {
            this.b = i;
            this.e.a(bdVar, -1.0f);
        }
        return this;
    }

    public ax a(bd bdVar, bd bdVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (!z) {
            this.e.a(bdVar, -1.0f);
            this.e.a(bdVar2, 1.0f);
        } else {
            this.e.a(bdVar, 1.0f);
            this.e.a(bdVar2, -1.0f);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax c(bd bdVar, int i) {
        this.e.a(bdVar, i);
        return this;
    }

    public ax a(bd bdVar, bd bdVar2, bd bdVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (!z) {
            this.e.a(bdVar, -1.0f);
            this.e.a(bdVar2, 1.0f);
            this.e.a(bdVar3, 1.0f);
        } else {
            this.e.a(bdVar, 1.0f);
            this.e.a(bdVar2, -1.0f);
            this.e.a(bdVar3, -1.0f);
        }
        return this;
    }

    public ax b(bd bdVar, bd bdVar2, bd bdVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (!z) {
            this.e.a(bdVar, -1.0f);
            this.e.a(bdVar2, 1.0f);
            this.e.a(bdVar3, -1.0f);
        } else {
            this.e.a(bdVar, 1.0f);
            this.e.a(bdVar2, -1.0f);
            this.e.a(bdVar3, 1.0f);
        }
        return this;
    }

    public ax a(float f, float f2, float f3, bd bdVar, bd bdVar2, bd bdVar3, bd bdVar4) {
        this.b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.e.a(bdVar, 1.0f);
            this.e.a(bdVar2, -1.0f);
            this.e.a(bdVar4, 1.0f);
            this.e.a(bdVar3, -1.0f);
        } else if (f == 0.0f) {
            this.e.a(bdVar, 1.0f);
            this.e.a(bdVar2, -1.0f);
        } else if (f3 == 0.0f) {
            this.e.a(bdVar3, 1.0f);
            this.e.a(bdVar4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.e.a(bdVar, 1.0f);
            this.e.a(bdVar2, -1.0f);
            this.e.a(bdVar4, f4);
            this.e.a(bdVar3, -f4);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax a(bd bdVar, bd bdVar2, int i, float f, bd bdVar3, bd bdVar4, int i2) {
        if (bdVar2 == bdVar3) {
            this.e.a(bdVar, 1.0f);
            this.e.a(bdVar4, 1.0f);
            this.e.a(bdVar2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.e.a(bdVar, 1.0f);
            this.e.a(bdVar2, -1.0f);
            this.e.a(bdVar3, -1.0f);
            this.e.a(bdVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            this.e.a(bdVar, -1.0f);
            this.e.a(bdVar2, 1.0f);
            this.b = i;
        } else if (f >= 1.0f) {
            this.e.a(bdVar4, -1.0f);
            this.e.a(bdVar3, 1.0f);
            this.b = -i2;
        } else {
            float f2 = 1.0f - f;
            this.e.a(bdVar, f2 * 1.0f);
            this.e.a(bdVar2, f2 * (-1.0f));
            this.e.a(bdVar3, (-1.0f) * f);
            this.e.a(bdVar4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.b = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    public ax a(az azVar, int i) {
        this.e.a(azVar.a(i, "ep"), 1.0f);
        this.e.a(azVar.a(i, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax a(bd bdVar, bd bdVar2, float f) {
        this.e.a(bdVar, -1.0f);
        this.e.a(bdVar2, f);
        return this;
    }

    public ax a(bd bdVar, bd bdVar2, bd bdVar3, bd bdVar4, float f) {
        this.e.a(bdVar, -1.0f);
        this.e.a(bdVar2, 1.0f);
        this.e.a(bdVar3, f);
        this.e.a(bdVar4, -f);
        return this;
    }

    public ax b(bd bdVar, bd bdVar2, bd bdVar3, bd bdVar4, float f) {
        this.e.a(bdVar3, 0.5f);
        this.e.a(bdVar4, 0.5f);
        this.e.a(bdVar, -0.5f);
        this.e.a(bdVar2, -0.5f);
        this.b = -f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        float f = this.b;
        if (f < 0.0f) {
            this.b = f * (-1.0f);
            this.e.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(az azVar) {
        boolean z;
        bd b = b(azVar);
        if (b == null) {
            z = true;
        } else {
            b(b);
            z = false;
        }
        if (this.e.c() == 0) {
            this.f = true;
        }
        return z;
    }

    bd b(az azVar) {
        int c = this.e.c();
        bd bdVar = null;
        bd bdVar2 = null;
        boolean z = false;
        boolean z2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < c; i++) {
            float b = this.e.b(i);
            bd a2 = this.e.a(i);
            if (a2.i == bd.a.UNRESTRICTED) {
                if (bdVar == null) {
                    z = a(a2, azVar);
                    f = b;
                    bdVar = a2;
                } else if (f > b) {
                    z = a(a2, azVar);
                    f = b;
                    bdVar = a2;
                } else if (!z && a(a2, azVar)) {
                    f = b;
                    bdVar = a2;
                    z = true;
                }
            } else if (bdVar == null && b < 0.0f) {
                if (bdVar2 == null) {
                    z2 = a(a2, azVar);
                    f2 = b;
                    bdVar2 = a2;
                } else if (f2 > b) {
                    z2 = a(a2, azVar);
                    f2 = b;
                    bdVar2 = a2;
                } else if (!z2 && a(a2, azVar)) {
                    f2 = b;
                    bdVar2 = a2;
                    z2 = true;
                }
            }
        }
        return bdVar != null ? bdVar : bdVar2;
    }

    private boolean a(bd bdVar, az azVar) {
        return bdVar.l <= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(bd bdVar) {
        bd bdVar2 = this.a;
        if (bdVar2 != null) {
            this.e.a(bdVar2, -1.0f);
            this.a.c = -1;
            this.a = null;
        }
        float a2 = this.e.a(bdVar, true) * (-1.0f);
        this.a = bdVar;
        if (a2 == 1.0f) {
            return;
        }
        this.b /= a2;
        this.e.a(a2);
    }

    @Override // defpackage.az.a
    public boolean e() {
        return this.a == null && this.b == 0.0f && this.e.c() == 0;
    }

    public void a(az azVar, ax axVar, boolean z) {
        this.b += axVar.b * this.e.a(axVar, z);
        if (z) {
            axVar.a.b(this);
        }
        if (az.c && this.a != null && this.e.c() == 0) {
            this.f = true;
            azVar.g = true;
        }
    }

    public void a(az azVar, bd bdVar, boolean z) {
        if (bdVar == null || !bdVar.f) {
            return;
        }
        this.b += bdVar.e * this.e.b(bdVar);
        this.e.a(bdVar, z);
        if (z) {
            bdVar.b(this);
        }
        if (az.c && this.e.c() == 0) {
            this.f = true;
            azVar.g = true;
        }
    }

    public void b(az azVar, bd bdVar, boolean z) {
        if (bdVar == null || !bdVar.m) {
            return;
        }
        float b = this.e.b(bdVar);
        this.b += bdVar.o * b;
        this.e.a(bdVar, z);
        if (z) {
            bdVar.b(this);
        }
        this.e.a(azVar.n.d[bdVar.n], b, z);
        if (az.c && this.e.c() == 0) {
            this.f = true;
            azVar.g = true;
        }
    }

    private bd a(boolean[] zArr, bd bdVar) {
        int c = this.e.c();
        bd bdVar2 = null;
        float f = 0.0f;
        for (int i = 0; i < c; i++) {
            float b = this.e.b(i);
            if (b < 0.0f) {
                bd a2 = this.e.a(i);
                if ((zArr == null || !zArr[a2.b]) && a2 != bdVar && ((a2.i == bd.a.SLACK || a2.i == bd.a.ERROR) && b < f)) {
                    f = b;
                    bdVar2 = a2;
                }
            }
        }
        return bdVar2;
    }

    public bd c(bd bdVar) {
        return a((boolean[]) null, bdVar);
    }

    @Override // defpackage.az.a
    public bd a(az azVar, boolean[] zArr) {
        return a(zArr, (bd) null);
    }

    @Override // defpackage.az.a
    public void f() {
        this.e.a();
        this.a = null;
        this.b = 0.0f;
    }

    @Override // defpackage.az.a
    public void a(az.a aVar) {
        if (aVar instanceof ax) {
            ax axVar = (ax) aVar;
            this.a = null;
            this.e.a();
            for (int i = 0; i < axVar.e.c(); i++) {
                this.e.a(axVar.e.a(i), axVar.e.b(i), true);
            }
        }
    }

    @Override // defpackage.az.a
    public void d(bd bdVar) {
        float f = 1.0f;
        if (bdVar.d != 1) {
            if (bdVar.d == 2) {
                f = 1000.0f;
            } else if (bdVar.d == 3) {
                f = 1000000.0f;
            } else if (bdVar.d == 4) {
                f = 1.0E9f;
            } else if (bdVar.d == 5) {
                f = 1.0E12f;
            }
        }
        this.e.a(bdVar, f);
    }

    @Override // defpackage.az.a
    public bd g() {
        return this.a;
    }

    public void c(az azVar) {
        if (azVar.i.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int c = this.e.c();
            for (int i = 0; i < c; i++) {
                bd a2 = this.e.a(i);
                if (a2.c != -1 || a2.f || a2.m) {
                    this.d.add(a2);
                }
            }
            int size = this.d.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    bd bdVar = this.d.get(i2);
                    if (bdVar.f) {
                        a(azVar, bdVar, true);
                    } else if (bdVar.m) {
                        b(azVar, bdVar, true);
                    } else {
                        a(azVar, azVar.i[bdVar.c], true);
                    }
                }
                this.d.clear();
            } else {
                z = true;
            }
        }
        if (az.c && this.a != null && this.e.c() == 0) {
            this.f = true;
            azVar.g = true;
        }
    }
}
