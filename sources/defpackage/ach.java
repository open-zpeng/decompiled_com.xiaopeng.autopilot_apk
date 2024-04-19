package defpackage;

import android.util.Log;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.a;
/* compiled from: Base3D.java */
/* renamed from: ach  reason: default package */
/* loaded from: classes.dex */
public abstract class ach extends acg {
    public aca ae;
    public nc af;
    public kw ah;
    protected long ai;
    public a<la> ag = new a<>();
    private float a = 0.0f;
    private float b = 0.0f;
    protected boolean aj = true;

    protected abstract void a(Batch batch);

    protected abstract void a(kz kzVar, a<la> aVar);

    @Override // defpackage.acg
    protected void a(pg pgVar) {
    }

    protected abstract void y();

    @Override // defpackage.acg, defpackage.ik
    public void a() {
        super.a();
        if (this.ae == null) {
            this.ae = new aca();
        }
        e();
        this.ah = new kw();
        io.d.setInputProcessor(new is(this));
    }

    protected void ac() {
        if (ak().e() && ak().i()) {
            this.af = new nc(this.P);
            io.d.setInputProcessor(new is(this, aj(), this.af));
            return;
        }
        io.d.setInputProcessor(new is(this, aj()));
    }

    private void e() {
        this.P = new kl(67.0f, io.b.getWidth(), io.b.getHeight());
        this.P.a.a(0.0f, 12.0f, 0.0f);
        this.P.a(0.0f, 0.0f, 0.0f);
        this.P.h = 5.0f;
        this.P.i = 100.0f;
        this.P.a();
    }

    protected void a(float f) {
        Log.i("cycle", "资源加载进度发生变化......" + this.ae.c());
    }

    @Override // defpackage.acg, defpackage.ik
    public void q_() {
        super.q_();
        this.a = this.ae.c();
        float f = this.a;
        if (f != this.b) {
            a(f);
        }
        this.b = this.a;
        if (this.aj && this.ae.a()) {
            y();
            this.aj = false;
            ac();
        }
        if (this.aj) {
            io.b.requestRendering();
        }
        if (this.af != null && ak().i()) {
            this.af.a();
        }
        a(this.ag);
        al();
    }

    public void a(a<la> aVar) {
        this.L.a(this.P);
        if (aVar != null) {
            a(this.L, aVar);
        }
        try {
            this.L.b();
        } catch (ArrayIndexOutOfBoundsException unused) {
            Log.e("Base3D", "mModelBatch  end ArrayIndexOutOfBoundsException ");
            this.L.d();
        } catch (IllegalArgumentException unused2) {
            Log.i("Base3D", "mModelBatch end IllegalArgumentException ");
        }
        this.H.begin();
        a(this.H);
        this.H.end();
        a(this.Y);
    }

    @Override // defpackage.acg, defpackage.ik
    public void a(int i, int i2) {
        super.a(i, i2);
    }

    @Override // defpackage.acg, defpackage.ik
    public void o_() {
        super.o_();
    }

    @Override // defpackage.acg, defpackage.ik
    public void p_() {
        super.p_();
    }

    @Override // defpackage.acg, defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3, int i4) {
        Log.i("Base3DSence", "touchdown int ");
        return super.a(i, i2, i3, i4);
    }

    @Override // defpackage.acg, defpackage.ny.b
    public boolean a(float f, float f2, int i, int i2) {
        Log.i("Base3DSence", "touchdown float ");
        return super.a(f, f2, i, i2);
    }

    @Override // defpackage.acg, defpackage.ik
    public void dispose() {
        super.dispose();
        if (this.N != null) {
            this.N.dispose();
        }
        if (this.L != null) {
            this.L.dispose();
        }
        aca acaVar = this.ae;
        if (acaVar != null) {
            acaVar.dispose();
        }
    }

    public aca an() {
        if (this.ae == null) {
            this.ae = new aca();
        }
        return this.ae;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        if (!this.aj) {
            this.aj = true;
        }
        this.ai = System.currentTimeMillis();
    }
}
