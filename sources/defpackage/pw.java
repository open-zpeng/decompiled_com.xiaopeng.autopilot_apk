package defpackage;
/* compiled from: Value.java */
/* renamed from: pw  reason: default package */
/* loaded from: classes.dex */
public abstract class pw {
    public static final a a = new a(0.0f);
    public static pw b = new pw() { // from class: pw.1
        @Override // defpackage.pw
        public float a(ok okVar) {
            if (okVar instanceof qh) {
                return ((qh) okVar).N();
            }
            if (okVar == null) {
                return 0.0f;
            }
            return okVar.m();
        }
    };
    public static pw c = new pw() { // from class: pw.2
        @Override // defpackage.pw
        public float a(ok okVar) {
            if (okVar instanceof qh) {
                return ((qh) okVar).O();
            }
            if (okVar == null) {
                return 0.0f;
            }
            return okVar.n();
        }
    };
    public static pw d = new pw() { // from class: pw.3
        @Override // defpackage.pw
        public float a(ok okVar) {
            if (okVar instanceof qh) {
                return ((qh) okVar).L();
            }
            if (okVar == null) {
                return 0.0f;
            }
            return okVar.m();
        }
    };
    public static pw e = new pw() { // from class: pw.4
        @Override // defpackage.pw
        public float a(ok okVar) {
            if (okVar instanceof qh) {
                return ((qh) okVar).M();
            }
            if (okVar == null) {
                return 0.0f;
            }
            return okVar.n();
        }
    };
    public static pw f = new pw() { // from class: pw.5
        @Override // defpackage.pw
        public float a(ok okVar) {
            if (okVar instanceof qh) {
                return ((qh) okVar).I();
            }
            if (okVar == null) {
                return 0.0f;
            }
            return okVar.m();
        }
    };
    public static pw g = new pw() { // from class: pw.6
        @Override // defpackage.pw
        public float a(ok okVar) {
            if (okVar instanceof qh) {
                return ((qh) okVar).J();
            }
            if (okVar == null) {
                return 0.0f;
            }
            return okVar.n();
        }
    };

    public abstract float a(ok okVar);

    /* compiled from: Value.java */
    /* renamed from: pw$a */
    /* loaded from: classes.dex */
    public static class a extends pw {
        private final float h;

        public a(float f) {
            this.h = f;
        }

        @Override // defpackage.pw
        public float a(ok okVar) {
            return this.h;
        }
    }
}
