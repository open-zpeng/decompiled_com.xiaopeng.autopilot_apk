package defpackage;

import defpackage.km;
import defpackage.ko;
import defpackage.kr;
/* compiled from: TextureLoader.java */
/* renamed from: js  reason: default package */
/* loaded from: classes.dex */
public class js extends je<ko, b> {
    a a;

    /* compiled from: TextureLoader.java */
    /* renamed from: js$a */
    /* loaded from: classes.dex */
    public static class a {
        String a;
        kr b;
        ko c;
    }

    /* compiled from: TextureLoader.java */
    /* renamed from: js$b */
    /* loaded from: classes.dex */
    public static class b extends iz<ko> {
        public km.c a = null;
        public boolean b = false;
        public ko c = null;
        public kr d = null;
        public ko.a e = ko.a.Nearest;
        public ko.a f = ko.a.Nearest;
        public ko.b g = ko.b.ClampToEdge;
        public ko.b h = ko.b.ClampToEdge;
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, b bVar) {
        return null;
    }

    public js(jh jhVar) {
        super(jhVar);
        this.a = new a();
    }

    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, b bVar) {
        this.a.a = str;
        if (bVar == null || bVar.d == null) {
            boolean z = false;
            km.c cVar = null;
            this.a.c = null;
            if (bVar != null) {
                cVar = bVar.a;
                z = bVar.b;
                this.a.c = bVar.c;
            }
            this.a.b = kr.a.a(jyVar, cVar, z);
        } else {
            this.a.b = bVar.d;
            this.a.c = bVar.c;
        }
        if (this.a.b.a()) {
            return;
        }
        this.a.b.b();
    }

    @Override // defpackage.je
    public ko b(jb jbVar, String str, jy jyVar, b bVar) {
        a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        ko koVar = aVar.c;
        if (koVar != null) {
            koVar.load(this.a.b);
        } else {
            koVar = new ko(this.a.b);
        }
        if (bVar != null) {
            koVar.setFilter(bVar.e, bVar.f);
            koVar.setWrap(bVar.g, bVar.h);
        }
        return koVar;
    }
}
