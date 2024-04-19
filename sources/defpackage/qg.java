package defpackage;
/* compiled from: FocusListener.java */
/* renamed from: qg  reason: default package */
/* loaded from: classes.dex */
public abstract class qg implements om {
    public void a(a aVar, ok okVar, boolean z) {
    }

    public void b(a aVar, ok okVar, boolean z) {
    }

    @Override // defpackage.om
    public boolean a(ol olVar) {
        if (olVar instanceof a) {
            a aVar = (a) olVar;
            switch (aVar.j()) {
                case keyboard:
                    a(aVar, olVar.b(), aVar.i());
                    break;
                case scroll:
                    b(aVar, olVar.b(), aVar.i());
                    break;
            }
            return false;
        }
        return false;
    }

    /* compiled from: FocusListener.java */
    /* renamed from: qg$a */
    /* loaded from: classes.dex */
    public static class a extends ol {
        private boolean a;
        private EnumC0066a b;
        private ok c;

        /* compiled from: FocusListener.java */
        /* renamed from: qg$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0066a {
            keyboard,
            scroll
        }

        @Override // defpackage.ol, com.badlogic.gdx.utils.z.a
        public void reset() {
            super.reset();
            this.c = null;
        }

        public boolean i() {
            return this.a;
        }

        public void b(boolean z) {
            this.a = z;
        }

        public EnumC0066a j() {
            return this.b;
        }

        public void a(EnumC0066a enumC0066a) {
            this.b = enumC0066a;
        }

        public void c(ok okVar) {
            this.c = okVar;
        }
    }
}
