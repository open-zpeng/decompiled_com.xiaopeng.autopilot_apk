package defpackage;

import defpackage.ko;
/* compiled from: TextureProvider.java */
/* renamed from: np  reason: default package */
/* loaded from: classes.dex */
public interface np {
    ko a(String str);

    /* compiled from: TextureProvider.java */
    /* renamed from: np$b */
    /* loaded from: classes.dex */
    public static class b implements np {
        private ko.a a;
        private ko.a b;
        private ko.b c;
        private ko.b d;
        private boolean e;

        public b() {
            ko.a aVar = ko.a.Linear;
            this.b = aVar;
            this.a = aVar;
            ko.b bVar = ko.b.Repeat;
            this.d = bVar;
            this.c = bVar;
            this.e = false;
        }

        @Override // defpackage.np
        public ko a(String str) {
            ko koVar = new ko(io.e.internal(str), this.e);
            koVar.setFilter(this.a, this.b);
            koVar.setWrap(this.c, this.d);
            return koVar;
        }
    }

    /* compiled from: TextureProvider.java */
    /* renamed from: np$a */
    /* loaded from: classes.dex */
    public static class a implements np {
        public final jb a;

        public a(jb jbVar) {
            this.a = jbVar;
        }

        @Override // defpackage.np
        public ko a(String str) {
            return (ko) this.a.a(str, ko.class);
        }
    }
}
