package defpackage;

import android.content.Context;
import android.os.HandlerThread;
import defpackage.wn;
/* compiled from: SpeechClient.java */
/* renamed from: wz  reason: default package */
/* loaded from: classes.dex */
public class wz implements wn.a {
    private Context a;
    private wx b;
    private xd c;
    private wn d;
    private aax e;
    private aaz f;
    private aaq g;
    private aaw h;
    private aan i;
    private aao j;
    private aav k;
    private aau l;
    private aam m;
    private aat n;
    private wy o;
    private aas p;
    private aba q;
    private xp r;
    private aay s;
    private aap t;
    private xz u;

    @Override // defpackage.wn.a
    public void a() {
    }

    @Override // defpackage.wn.a
    public void a(wu wuVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SpeechClient.java */
    /* renamed from: wz$a */
    /* loaded from: classes.dex */
    public static class a {
        private static final wz a = new wz();
    }

    public static final wz b() {
        return a.a;
    }

    public void a(Context context) {
        a(context, null);
    }

    public void a(Context context, wn.a aVar) {
        xx.b(this, "SpeechClient(%s) Start In %s, connectCallback: %s", "1.0", context.getPackageName(), aVar);
        HandlerThread handlerThread = new HandlerThread("NodeWorker");
        handlerThread.start();
        this.u = new xz(handlerThread.getLooper());
        this.a = context;
        this.d = new wn(context);
        this.d.a(this.u);
        this.b = new wx();
        this.b.a(this.u);
        this.d.a(this.b);
        this.o = new wy();
        this.o.a(this.u);
        this.d.a(this.o);
        this.c = new xd(context);
        this.c.a(this.u);
        this.d.a((wn.a) this.c);
        this.e = new aax();
        this.e.a(this.u);
        this.d.a((wn.a) this.e);
        this.f = new aaz();
        this.f.a(this.u);
        this.d.a((wn.a) this.f);
        this.g = new aaq();
        this.g.a(this.u);
        this.d.a((wn.a) this.g);
        this.i = new aan();
        this.i.a(this.u);
        this.d.a((wn.a) this.i);
        this.h = new aaw();
        this.h.a(this.u);
        this.d.a((wn.a) this.h);
        this.j = new aao(context);
        this.j.a(this.u);
        this.d.a((wn.a) this.j);
        this.k = new aav();
        this.d.a((wn.a) this.k);
        this.l = new aau();
        this.d.a((wn.a) this.l);
        this.m = new aam();
        this.m.a(this.u);
        this.d.a((wn.a) this.m);
        this.n = new aat();
        this.n.a(this.u);
        this.d.a((wn.a) this.n);
        this.p = new aas();
        this.p.a(this.u);
        this.d.a((wn.a) this.p);
        this.q = new aba();
        this.d.a((wn.a) this.q);
        this.r = new xp(this.u);
        this.d.a(this.r.a());
        this.t = new aap();
        this.d.a((wn.a) this.t);
        this.s = new aay();
        this.s.a(this.u);
        this.d.a((wn.a) this.s);
        if (aVar == null) {
            this.d.a(this);
        } else {
            this.d.a(aVar);
        }
        this.d.b();
        this.d.a();
    }

    public void a(String... strArr) {
        for (String str : strArr) {
            h().a(this.a.getPackageName(), str);
        }
    }

    public xd c() {
        return this.c;
    }

    public aax d() {
        return this.e;
    }

    public aaz e() {
        return this.f;
    }

    public aaq f() {
        return this.g;
    }

    public aan g() {
        return this.i;
    }

    public aao h() {
        return this.j;
    }

    public aav i() {
        return this.k;
    }

    public aas j() {
        return this.p;
    }

    public xp k() {
        return this.r;
    }

    public wx l() {
        return this.b;
    }
}
