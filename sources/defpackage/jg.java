package defpackage;

import com.badlogic.gdx.graphics.glutils.n;
import defpackage.km;
import defpackage.ko;
/* compiled from: CubemapLoader.java */
/* renamed from: jg  reason: default package */
/* loaded from: classes.dex */
public class jg extends je<kc, b> {
    a a;

    /* compiled from: CubemapLoader.java */
    /* renamed from: jg$a */
    /* loaded from: classes.dex */
    public static class a {
        String a;
        kd b;
        kc c;
    }

    /* compiled from: CubemapLoader.java */
    /* renamed from: jg$b */
    /* loaded from: classes.dex */
    public static class b extends iz<kc> {
        public km.c a = null;
        public kc b = null;
        public kd c = null;
        public ko.a d = ko.a.Nearest;
        public ko.a e = ko.a.Nearest;
        public ko.b f = ko.b.ClampToEdge;
        public ko.b g = ko.b.ClampToEdge;
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, b bVar) {
        return null;
    }

    public jg(jh jhVar) {
        super(jhVar);
        this.a = new a();
    }

    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, b bVar) {
        this.a.a = str;
        if (bVar == null || bVar.c == null) {
            this.a.c = null;
            if (bVar != null) {
                km.c cVar = bVar.a;
                this.a.c = bVar.b;
            }
            if (str.contains(".ktx") || str.contains(".zktx")) {
                this.a.b = new n(jyVar, false);
            }
        } else {
            this.a.b = bVar.c;
            this.a.c = bVar.b;
        }
        if (this.a.b.a()) {
            return;
        }
        this.a.b.b();
    }

    @Override // defpackage.je
    public kc b(jb jbVar, String str, jy jyVar, b bVar) {
        a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        kc kcVar = aVar.c;
        if (kcVar != null) {
            kcVar.a(this.a.b);
        } else {
            kcVar = new kc(this.a.b);
        }
        if (bVar != null) {
            kcVar.setFilter(bVar.d, bVar.e);
            kcVar.setWrap(bVar.f, bVar.g);
        }
        return kcVar;
    }
}
