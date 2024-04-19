package defpackage;

import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.math.p;
/* compiled from: MeshPart.java */
/* renamed from: ly  reason: default package */
/* loaded from: classes.dex */
public class ly {
    private static final nz i = new nz();
    public String a;
    public int b;
    public int c;
    public int d;
    public kj e;
    public final p f = new p();
    public final p g = new p();
    public float h = -1.0f;

    public ly() {
    }

    public ly(ly lyVar) {
        a(lyVar);
    }

    public ly a(ly lyVar) {
        this.a = lyVar.a;
        this.e = lyVar.e;
        this.c = lyVar.c;
        this.d = lyVar.d;
        this.b = lyVar.b;
        this.f.a(lyVar.f);
        this.g.a(lyVar.g);
        this.h = lyVar.h;
        return this;
    }

    public ly a(String str, kj kjVar, int i2, int i3, int i4) {
        this.a = str;
        this.e = kjVar;
        this.c = i2;
        this.d = i3;
        this.b = i4;
        this.f.a(0.0f, 0.0f, 0.0f);
        this.g.a(0.0f, 0.0f, 0.0f);
        this.h = -1.0f;
        return this;
    }

    public void a() {
        this.e.a(i, this.c, this.d);
        i.a(this.f);
        i.j(this.g).a(0.5f);
        this.h = this.g.b();
    }

    public boolean b(ly lyVar) {
        return lyVar == this || (lyVar != null && lyVar.e == this.e && lyVar.b == this.b && lyVar.c == this.c && lyVar.d == this.d);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof ly) {
            return b((ly) obj);
        }
        return false;
    }

    public void a(q qVar, boolean z) {
        this.e.a(qVar, this.b, this.c, this.d, z);
    }
}
