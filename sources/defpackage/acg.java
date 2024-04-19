package defpackage;

import android.os.SystemClock;
import android.util.Log;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.al;
import com.badlogic.gdx.utils.ao;
import com.badlogic.gdx.utils.s;
import defpackage.acf;
import defpackage.ny;
import defpackage.pg;
/* compiled from: AbstractApplication.java */
/* renamed from: acg  reason: default package */
/* loaded from: classes.dex */
public abstract class acg extends ir implements ik, ny.b {
    protected SpriteBatch H;
    protected BitmapFont I;
    protected oq K;
    public acj L;
    public kz M;
    public ky N;
    public la O;
    public kl P;
    protected nx S;
    protected pg T;
    protected pg U;
    protected pg V;
    protected pg W;
    protected pg X;
    protected ack Z;
    protected pg aa;
    private pg c;
    private kf a = new kf();
    public final ka J = new ka(0.0f, 0.0f, 0.0f, 0.0f);
    private s b = new s("Base3DSence.Abs", 2);
    long Q = ao.a();
    int R = 10;
    protected al Y = new al();
    final float ab = -50.0f;
    final float ac = 50.0f;
    final float ad = 1.0f;

    protected abstract void a(pg pgVar);

    @Override // defpackage.ny.b
    public boolean a(float f, float f2) {
        return false;
    }

    @Override // defpackage.ny.b
    public boolean a(float f, float f2, float f3, float f4) {
        return false;
    }

    @Override // defpackage.ny.b
    public boolean a(float f, float f2, int i) {
        return false;
    }

    @Override // defpackage.ny.b
    public boolean a(float f, float f2, int i, int i2) {
        return false;
    }

    @Override // defpackage.ny.b
    public boolean a(o oVar, o oVar2, o oVar3, o oVar4) {
        return false;
    }

    @Override // defpackage.ny.b
    public boolean b(float f, float f2) {
        return false;
    }

    @Override // defpackage.ny.b
    public boolean b(float f, float f2, int i, int i2) {
        return false;
    }

    @Override // defpackage.ny.b
    public boolean c(float f, float f2, int i, int i2) {
        return false;
    }

    @Override // defpackage.ny.b
    public void r_() {
    }

    public oq aj() {
        return this.K;
    }

    public ack ak() {
        if (this.Z == null) {
            this.Z = ack.b();
        }
        return this.Z;
    }

    @Override // defpackage.ik
    public void a() {
        Log.i("Base3DSence.Abs", "create");
        e();
        g();
        f();
        t();
    }

    private void e() {
        this.H = new SpriteBatch();
        this.I = new BitmapFont(io.e.internal("font/arial-15.fnt"), io.e.internal("font/arial-15.png"), false, true);
        if (ak().f()) {
            this.L = new acj(new aco(io.e.internal("shader/vertex.glsl").readString(), io.e.internal("shader/fragment.glsl").readString()));
        } else {
            this.L = new acj(io.e.internal("shader/default.vertex.glsl").readString(), io.e.internal("shader/default.fragment.glsl").readString());
        }
        this.M = new kz(new ng(io.e.internal("shader/depth.vertex.glsl").readString(), io.e.internal("shader/depth.fragment.glsl").readString()));
    }

    private void f() {
        this.K = new oq();
        this.S = new nx(io.b);
        this.S.a();
        if (ak().e()) {
            this.c = new pg("FPS:999", new pg.a(this.I, ka.c));
            this.c.a(0.0f, 50.0f);
        }
    }

    private void g() {
        if (ak().e() && ak().g()) {
            nj njVar = new nj();
            njVar.a();
            ni a = njVar.a("grid", 1, 3L, new kx());
            a.a(ka.b);
            for (float f = -50.0f; f <= 50.0f; f += 1.0f) {
                a.a(f, 0.0f, -50.0f, f, 0.0f, 50.0f);
                a.a(-50.0f, 0.0f, f, 50.0f, 0.0f, f);
            }
            ni a2 = njVar.a("axes", 1, 3L, new kx());
            a2.a(ka.A);
            a2.a(0.0f, 0.0f, 0.0f, 100.0f, 0.0f, 0.0f);
            a2.a(ka.o);
            a2.a(0.0f, 0.0f, 0.0f, 0.0f, 100.0f, 0.0f);
            a2.a(ka.h);
            a2.a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 100.0f);
            this.N = njVar.b();
            this.O = new la(this.N);
            Log.i("Base3DSence.Abs", "initAxes finish ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(al alVar) {
        if (ak().e() && ak().d()) {
            alVar.a(0);
            alVar.c("GL calls: ");
            alVar.b(this.S.d());
            this.X.a(alVar);
            alVar.a(0);
            alVar.c("Draw calls: ");
            alVar.b(this.S.f());
            this.W.a(alVar);
            alVar.a(0);
            alVar.c("Shader switches: ");
            alVar.b(this.S.g());
            this.V.a(alVar);
            alVar.a(0);
            alVar.c("Texture bindings: ");
            alVar.b(this.S.e());
            this.U.a(alVar);
            alVar.a(0);
            alVar.c("Vertices: ");
            alVar.a(this.S.h().b);
            this.T.a(alVar);
            this.S.i();
            alVar.a(0);
        }
    }

    private void t() {
        if (ak().e() && ak().d()) {
            this.T = new pg("Vertices: 999", new pg.a(this.I, ka.a));
            this.T.a(0.0f, this.c.o());
            this.K.b(this.T);
            this.U = new pg("Texture bindings: 999", new pg.a(this.I, ka.a));
            this.U.a(0.0f, this.T.o());
            this.K.b(this.U);
            this.V = new pg("Shader switches: 999", new pg.a(this.I, ka.a));
            this.V.a(0.0f, this.U.o());
            this.K.b(this.V);
            this.W = new pg("Draw calls: 999", new pg.a(this.I, ka.a));
            this.W.a(0.0f, this.V.o());
            this.K.b(this.W);
            this.X = new pg("GL calls: 999", new pg.a(this.I, ka.a));
            this.X.a(0.0f, this.W.o());
            this.K.b(this.X);
        }
    }

    @Override // defpackage.ik
    public void a(int i, int i2) {
        this.b.b("resize");
    }

    @Override // defpackage.ik
    public void q_() {
        io.g.glClear(16640);
        io.g.glClearColor(this.J.J, this.J.K, this.J.L, this.J.M);
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al() {
        oq oqVar;
        if (ak().e() && ak().j()) {
            w();
        }
        if (ak().e() && ak().h()) {
            this.a.a();
        }
        if (ak().e() && (oqVar = this.K) != null) {
            oqVar.a();
        }
        if (ak().e() && ak().g() && this.O != null) {
            this.L.a(this.P);
            io.h.glLineWidth(1.0f);
            this.L.a(this.O);
            this.L.b();
        }
        if (ak().e() && ak().d()) {
            a(this.Y);
        }
        if (ak().e()) {
            am();
        }
        if (ak().e() && ak().c()) {
            this.H.begin();
            a(u());
            u().a(this.H, 1.0f);
            this.H.end();
        }
    }

    private pg u() {
        if (this.aa == null) {
            this.aa = new pg("", new pg.a(this.I, ka.a));
        }
        return this.aa;
    }

    private void v() {
        acf.a aVar = acf.f;
        acf.c = SystemClock.uptimeMillis();
        aVar.run();
    }

    public void am() {
        if (ao.a() - this.Q > this.R * 1000000000) {
            ij ijVar = io.a;
            ijVar.log("Base3DSence.Abs", "Sence Configuration: " + ak().toString());
            io.a.log("Base3DSence.Abs", "render abs");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("position:");
            stringBuffer.append(this.P.a.toString());
            stringBuffer.append("\t");
            stringBuffer.append("direction:");
            stringBuffer.append(this.P.b.toString());
            stringBuffer.append("\t");
            stringBuffer.append("lookat:");
            stringBuffer.append(this.P.c.toString());
            stringBuffer.append("\t");
            io.a.log("Base3DSence.Abs", stringBuffer.toString());
            this.Q = ao.a();
        }
    }

    @Override // defpackage.ik
    public void p_() {
        this.b.b("pause");
    }

    @Override // defpackage.ik
    public void o_() {
        this.b.b("resume");
    }

    @Override // defpackage.ik
    public void dispose() {
        this.b.b("dispose");
        nx nxVar = this.S;
        if (nxVar != null) {
            nxVar.b();
        }
    }

    private void w() {
        if (this.c == null || this.I == null) {
            return;
        }
        this.H.begin();
        BitmapFont bitmapFont = this.I;
        SpriteBatch spriteBatch = this.H;
        bitmapFont.draw(spriteBatch, "FPS: " + io.b.getFramesPerSecond(), io.b.getWidth() - 60, io.b.getHeight() - 20);
        this.c.e(1.2f);
        pg pgVar = this.c;
        pgVar.a("FPS:\t" + io.b.getFramesPerSecond());
        this.c.a(this.H, 1.0f);
        this.H.end();
    }

    @Override // defpackage.ir, defpackage.it
    public boolean b(int i, int i2, int i3, int i4) {
        Log.i("Base3DSence.Abs", "touchup");
        return super.b(i, i2, i3, i4);
    }

    @Override // defpackage.ir, defpackage.it
    public boolean a(int i, int i2, int i3, int i4) {
        Log.i("Base3DSence.Abs", "touchDown");
        return super.a(i, i2, i3, i4);
    }
}
