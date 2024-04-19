package defpackage;

import androidx.recyclerview.widget.j;
import defpackage.bd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ConstraintAnchor.java */
/* renamed from: by  reason: default package */
/* loaded from: classes.dex */
public class by {
    public final bz a;
    public final a b;
    public by c;
    bd f;
    private int h;
    private boolean i;
    private HashSet<by> g = null;
    public int d = 0;
    int e = j.UNDEFINED_DURATION;

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: by$a */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public void a(int i, ArrayList<cw> arrayList, cw cwVar) {
        HashSet<by> hashSet = this.g;
        if (hashSet != null) {
            Iterator<by> it = hashSet.iterator();
            while (it.hasNext()) {
                cq.a(it.next().a, i, arrayList, cwVar);
            }
        }
    }

    public HashSet<by> a() {
        return this.g;
    }

    public boolean b() {
        HashSet<by> hashSet = this.g;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean c() {
        HashSet<by> hashSet = this.g;
        if (hashSet == null) {
            return false;
        }
        Iterator<by> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().n().m()) {
                return true;
            }
        }
        return false;
    }

    public void a(int i) {
        this.h = i;
        this.i = true;
    }

    public int d() {
        if (this.i) {
            return this.h;
        }
        return 0;
    }

    public void e() {
        this.i = false;
        this.h = 0;
    }

    public boolean f() {
        return this.i;
    }

    public by(bz bzVar, a aVar) {
        this.a = bzVar;
        this.b = aVar;
    }

    public bd g() {
        return this.f;
    }

    public void a(ay ayVar) {
        bd bdVar = this.f;
        if (bdVar == null) {
            this.f = new bd(bd.a.UNRESTRICTED, null);
        } else {
            bdVar.b();
        }
    }

    public bz h() {
        return this.a;
    }

    public a i() {
        return this.b;
    }

    public int j() {
        by byVar;
        if (this.a.B() == 8) {
            return 0;
        }
        if (this.e != Integer.MIN_VALUE && (byVar = this.c) != null && byVar.a.B() == 8) {
            return this.e;
        }
        return this.d;
    }

    public by k() {
        return this.c;
    }

    public void l() {
        HashSet<by> hashSet;
        by byVar = this.c;
        if (byVar != null && (hashSet = byVar.g) != null) {
            hashSet.remove(this);
            if (this.c.g.size() == 0) {
                this.c.g = null;
            }
        }
        this.g = null;
        this.c = null;
        this.d = 0;
        this.e = j.UNDEFINED_DURATION;
        this.i = false;
        this.h = 0;
    }

    public boolean a(by byVar, int i, int i2, boolean z) {
        if (byVar == null) {
            l();
            return true;
        } else if (z || a(byVar)) {
            this.c = byVar;
            by byVar2 = this.c;
            if (byVar2.g == null) {
                byVar2.g = new HashSet<>();
            }
            HashSet<by> hashSet = this.c.g;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.d = i;
            this.e = i2;
            return true;
        } else {
            return false;
        }
    }

    public boolean a(by byVar, int i) {
        return a(byVar, i, j.UNDEFINED_DURATION, false);
    }

    public boolean m() {
        return this.c != null;
    }

    public boolean a(by byVar) {
        if (byVar == null) {
            return false;
        }
        a i = byVar.i();
        a aVar = this.b;
        if (i == aVar) {
            return aVar != a.BASELINE || (byVar.h().P() && h().P());
        }
        switch (this.b) {
            case CENTER:
                return (i == a.BASELINE || i == a.CENTER_X || i == a.CENTER_Y) ? false : true;
            case LEFT:
            case RIGHT:
                boolean z = i == a.LEFT || i == a.RIGHT;
                return byVar.h() instanceof cc ? z || i == a.CENTER_X : z;
            case TOP:
            case BOTTOM:
                boolean z2 = i == a.TOP || i == a.BOTTOM;
                return byVar.h() instanceof cc ? z2 || i == a.CENTER_Y : z2;
            case BASELINE:
                return (i == a.LEFT || i == a.RIGHT) ? false : true;
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return false;
            default:
                throw new AssertionError(this.b.name());
        }
    }

    public void b(int i) {
        if (m()) {
            this.e = i;
        }
    }

    public String toString() {
        return this.a.C() + ":" + this.b.toString();
    }

    public final by n() {
        switch (this.b) {
            case CENTER:
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
            case LEFT:
                return this.a.B;
            case RIGHT:
                return this.a.z;
            case TOP:
                return this.a.C;
            case BOTTOM:
                return this.a.A;
            default:
                throw new AssertionError(this.b.name());
        }
    }
}
