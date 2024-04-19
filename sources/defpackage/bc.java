package defpackage;

import defpackage.ax;
import java.util.Arrays;
import java.util.Comparator;
/* compiled from: PriorityGoalRow.java */
/* renamed from: bc  reason: default package */
/* loaded from: classes.dex */
public class bc extends ax {
    a g;
    ay h;
    private int i;
    private bd[] j;
    private bd[] k;
    private int l;

    /* compiled from: PriorityGoalRow.java */
    /* renamed from: bc$a */
    /* loaded from: classes.dex */
    class a {
        bd a;
        bc b;

        public a(bc bcVar) {
            this.b = bcVar;
        }

        public void a(bd bdVar) {
            this.a = bdVar;
        }

        public boolean a(bd bdVar, float f) {
            boolean z = true;
            if (!this.a.a) {
                for (int i = 0; i < 9; i++) {
                    float f2 = bdVar.h[i];
                    if (f2 != 0.0f) {
                        float f3 = f2 * f;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f3 = 0.0f;
                        }
                        this.a.h[i] = f3;
                    } else {
                        this.a.h[i] = 0.0f;
                    }
                }
                return true;
            }
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.a.h;
                fArr[i2] = fArr[i2] + (bdVar.h[i2] * f);
                if (Math.abs(this.a.h[i2]) < 1.0E-4f) {
                    this.a.h[i2] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (z) {
                bc.this.f(this.a);
            }
            return false;
        }

        public final boolean a() {
            for (int i = 8; i >= 0; i--) {
                float f = this.a.h[i];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean b(bd bdVar) {
            for (int i = 8; i >= 0; i--) {
                float f = bdVar.h[i];
                float f2 = this.a.h[i];
                if (f2 != f) {
                    return f2 < f;
                }
            }
            return false;
        }

        public void b() {
            Arrays.fill(this.a.h, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.a != null) {
                for (int i = 0; i < 9; i++) {
                    str = str + this.a.h[i] + " ";
                }
            }
            return str + "] " + this.a;
        }
    }

    @Override // defpackage.ax, defpackage.az.a
    public void f() {
        this.l = 0;
        this.b = 0.0f;
    }

    public bc(ay ayVar) {
        super(ayVar);
        this.i = 128;
        int i = this.i;
        this.j = new bd[i];
        this.k = new bd[i];
        this.l = 0;
        this.g = new a(this);
        this.h = ayVar;
    }

    @Override // defpackage.ax, defpackage.az.a
    public boolean e() {
        return this.l == 0;
    }

    @Override // defpackage.ax, defpackage.az.a
    public bd a(az azVar, boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.l; i2++) {
            bd bdVar = this.j[i2];
            if (!zArr[bdVar.b]) {
                this.g.a(bdVar);
                if (i == -1) {
                    if (!this.g.a()) {
                    }
                    i = i2;
                } else {
                    if (!this.g.b(this.j[i])) {
                    }
                    i = i2;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.j[i];
    }

    @Override // defpackage.ax, defpackage.az.a
    public void d(bd bdVar) {
        this.g.a(bdVar);
        this.g.b();
        bdVar.h[bdVar.d] = 1.0f;
        e(bdVar);
    }

    private final void e(bd bdVar) {
        int i;
        int i2 = this.l + 1;
        bd[] bdVarArr = this.j;
        if (i2 > bdVarArr.length) {
            this.j = (bd[]) Arrays.copyOf(bdVarArr, bdVarArr.length * 2);
            bd[] bdVarArr2 = this.j;
            this.k = (bd[]) Arrays.copyOf(bdVarArr2, bdVarArr2.length * 2);
        }
        bd[] bdVarArr3 = this.j;
        int i3 = this.l;
        bdVarArr3[i3] = bdVar;
        this.l = i3 + 1;
        int i4 = this.l;
        if (i4 > 1 && bdVarArr3[i4 - 1].b > bdVar.b) {
            int i5 = 0;
            while (true) {
                i = this.l;
                if (i5 >= i) {
                    break;
                }
                this.k[i5] = this.j[i5];
                i5++;
            }
            Arrays.sort(this.k, 0, i, new Comparator<bd>() { // from class: bc.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(bd bdVar2, bd bdVar3) {
                    return bdVar2.b - bdVar3.b;
                }
            });
            for (int i6 = 0; i6 < this.l; i6++) {
                this.j[i6] = this.k[i6];
            }
        }
        bdVar.a = true;
        bdVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(bd bdVar) {
        int i = 0;
        while (i < this.l) {
            if (this.j[i] == bdVar) {
                while (true) {
                    int i2 = this.l;
                    if (i < i2 - 1) {
                        bd[] bdVarArr = this.j;
                        int i3 = i + 1;
                        bdVarArr[i] = bdVarArr[i3];
                        i = i3;
                    } else {
                        this.l = i2 - 1;
                        bdVar.a = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // defpackage.ax
    public void a(az azVar, ax axVar, boolean z) {
        bd bdVar = axVar.a;
        if (bdVar == null) {
            return;
        }
        ax.a aVar = axVar.e;
        int c = aVar.c();
        for (int i = 0; i < c; i++) {
            bd a2 = aVar.a(i);
            float b = aVar.b(i);
            this.g.a(a2);
            if (this.g.a(bdVar, b)) {
                e(a2);
            }
            this.b += axVar.b * b;
        }
        f(bdVar);
    }

    @Override // defpackage.ax
    public String toString() {
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.l; i++) {
            this.g.a(this.j[i]);
            str = str + this.g + " ";
        }
        return str;
    }
}
