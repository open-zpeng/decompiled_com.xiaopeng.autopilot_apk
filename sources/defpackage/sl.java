package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.p;
import com.xiaopeng.autopilot.parking.view.g3d.d;
import java.util.Iterator;
/* compiled from: DynaObjectEntity.java */
/* renamed from: sl  reason: default package */
/* loaded from: classes.dex */
public abstract class sl extends aci {
    protected String b;
    int c;
    protected p e;
    protected Matrix4 f;
    protected boolean a = false;
    protected boolean d = true;

    public abstract void a(float f);

    public boolean a(p pVar) {
        return true;
    }

    public void e() {
    }

    public void f() {
    }

    public void a(int i) {
        this.c = i;
    }

    public boolean g() {
        return this.d;
    }

    public void b(p pVar) {
        this.e = pVar;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public p h() {
        return this.e;
    }

    public void a(Matrix4 matrix4) {
        this.f = matrix4;
    }

    public Matrix4 i() {
        return this.f;
    }

    @Override // defpackage.aci
    public void a(kz kzVar, kw kwVar) {
        if (d.q) {
            kzVar = ((d) C()).U();
        }
        if (this.L != null) {
            if (kwVar != null) {
                kzVar.a(this.L, kwVar);
            } else {
                kzVar.a(this.L);
            }
        }
    }

    public boolean j() {
        return this.a;
    }

    public void k() {
        Iterator<kx> it;
        if ((this.L == null || this.K == null) && C().an().c(this.J)) {
            this.K = (ky) C().an().a(this.J);
            this.L = new la(this.K);
            String str = "";
            while (this.L.b.iterator().hasNext()) {
                str = str + it.next().d + ", ";
            }
            Log.i("DynaObjectEntity", getClass().getSimpleName() + ": " + str);
            String str2 = this.b;
            if (str2 != null) {
                kx b = this.L.b(str2);
                le leVar = new le(770, 771);
                leVar.f = 0.85f;
                if (b != null) {
                    b.a(leVar);
                    b.a(lj.b(0.05f));
                }
            }
            this.a = true;
        }
    }

    @Override // defpackage.aci, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        super.dispose();
    }
}
