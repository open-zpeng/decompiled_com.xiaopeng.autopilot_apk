package defpackage;

import defpackage.by;
import defpackage.bz;
import java.util.HashMap;
/* compiled from: Guideline.java */
/* renamed from: cc  reason: default package */
/* loaded from: classes.dex */
public class cc extends bz {
    private boolean aC;
    protected float a = -1.0f;
    protected int ax = -1;
    protected int ay = -1;
    private by az = this.A;
    private int aA = 0;
    private int aB = 0;

    @Override // defpackage.bz
    public boolean a() {
        return true;
    }

    public cc() {
        this.I.clear();
        this.I.add(this.az);
        int length = this.H.length;
        for (int i = 0; i < length; i++) {
            this.H[i] = this.az;
        }
    }

    @Override // defpackage.bz
    public void a(bz bzVar, HashMap<bz, bz> hashMap) {
        super.a(bzVar, hashMap);
        cc ccVar = (cc) bzVar;
        this.a = ccVar.a;
        this.ax = ccVar.ax;
        this.ay = ccVar.ay;
        a(ccVar.aA);
    }

    public void a(int i) {
        if (this.aA == i) {
            return;
        }
        this.aA = i;
        this.I.clear();
        if (this.aA == 1) {
            this.az = this.z;
        } else {
            this.az = this.A;
        }
        this.I.add(this.az);
        int length = this.H.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.H[i2] = this.az;
        }
    }

    public by b() {
        return this.az;
    }

    public int c() {
        return this.aA;
    }

    @Override // defpackage.bz
    public by a(by.a aVar) {
        switch (aVar) {
            case LEFT:
            case RIGHT:
                if (this.aA == 1) {
                    return this.az;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.aA == 0) {
                    return this.az;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        return null;
    }

    public void e(float f) {
        if (f > -1.0f) {
            this.a = f;
            this.ax = -1;
            this.ay = -1;
        }
    }

    public void b(int i) {
        if (i > -1) {
            this.a = -1.0f;
            this.ax = i;
            this.ay = -1;
        }
    }

    public void A(int i) {
        if (i > -1) {
            this.a = -1.0f;
            this.ax = -1;
            this.ay = i;
        }
    }

    public float f() {
        return this.a;
    }

    public int g() {
        return this.ax;
    }

    public int h() {
        return this.ay;
    }

    public void B(int i) {
        this.az.a(i);
        this.aC = true;
    }

    @Override // defpackage.bz
    public boolean d() {
        return this.aC;
    }

    @Override // defpackage.bz
    public boolean e() {
        return this.aC;
    }

    @Override // defpackage.bz
    public void a(az azVar, boolean z) {
        ca caVar = (ca) A();
        if (caVar == null) {
            return;
        }
        by a = caVar.a(by.a.LEFT);
        by a2 = caVar.a(by.a.RIGHT);
        boolean z2 = this.K != null && this.K.J[0] == bz.a.WRAP_CONTENT;
        if (this.aA == 0) {
            a = caVar.a(by.a.TOP);
            a2 = caVar.a(by.a.BOTTOM);
            z2 = this.K != null && this.K.J[1] == bz.a.WRAP_CONTENT;
        }
        if (this.aC && this.az.f()) {
            bd a3 = azVar.a(this.az);
            azVar.a(a3, this.az.d());
            if (this.ax != -1) {
                if (z2) {
                    azVar.a(azVar.a(a2), a3, 0, 5);
                }
            } else if (this.ay != -1 && z2) {
                bd a4 = azVar.a(a2);
                azVar.a(a3, azVar.a(a), 0, 5);
                azVar.a(a4, a3, 0, 5);
            }
            this.aC = false;
        } else if (this.ax != -1) {
            bd a5 = azVar.a(this.az);
            azVar.c(a5, azVar.a(a), this.ax, 8);
            if (z2) {
                azVar.a(azVar.a(a2), a5, 0, 5);
            }
        } else if (this.ay != -1) {
            bd a6 = azVar.a(this.az);
            bd a7 = azVar.a(a2);
            azVar.c(a6, a7, -this.ay, 8);
            if (z2) {
                azVar.a(a6, azVar.a(a), 0, 5);
                azVar.a(a7, a6, 0, 5);
            }
        } else if (this.a != -1.0f) {
            azVar.a(az.a(azVar, azVar.a(this.az), azVar.a(a2), this.a));
        }
    }

    @Override // defpackage.bz
    public void b(az azVar, boolean z) {
        if (A() == null) {
            return;
        }
        int b = azVar.b(this.az);
        if (this.aA == 1) {
            o(b);
            p(0);
            r(A().G());
            q(0);
            return;
        }
        o(0);
        p(b);
        q(A().F());
        r(0);
    }
}
