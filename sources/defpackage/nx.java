package defpackage;

import com.badlogic.gdx.math.d;
/* compiled from: GLProfiler.java */
/* renamed from: nx  reason: default package */
/* loaded from: classes.dex */
public class nx {
    private ip a;
    private nw b;
    private nv c;
    private boolean d = false;

    public nx(ip ipVar) {
        this.a = ipVar;
        if (ipVar.getGL30() != null) {
            this.b = new nu(this, ipVar.getGL30());
        } else {
            this.b = new nt(this, ipVar.getGL20());
        }
        this.c = nv.a;
    }

    public void a() {
        if (this.d) {
            return;
        }
        if (this.a.getGL30() != null) {
            this.a.setGL30((kh) this.b);
        } else {
            this.a.setGL20(this.b);
        }
        this.d = true;
    }

    public void b() {
        if (this.d) {
            if (this.a.getGL30() != null) {
                ip ipVar = this.a;
                ipVar.setGL30(((nu) ipVar.getGL30()).a);
            } else {
                ip ipVar2 = this.a;
                ipVar2.setGL20(((nt) ipVar2.getGL20()).a);
            }
            this.d = false;
        }
    }

    public nv c() {
        return this.c;
    }

    public int d() {
        return this.b.a();
    }

    public int e() {
        return this.b.b();
    }

    public int f() {
        return this.b.c();
    }

    public int g() {
        return this.b.d();
    }

    public d h() {
        return this.b.e();
    }

    public void i() {
        this.b.f();
    }
}
