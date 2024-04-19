package defpackage;
/* renamed from: agn  reason: default package */
/* loaded from: classes.dex */
public class agn extends agp {
    static final boolean a;
    static Class b;
    private int c = 1;

    static {
        Class cls = b;
        if (cls == null) {
            cls = a("agn");
            b = cls;
        }
        a = !cls.desiredAssertionStatus();
    }

    public agn() {
    }

    public agn(int i) throws agz {
        a(i);
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public int a() {
        return this.c;
    }

    @Override // defpackage.agp
    public agq a(agq agqVar) {
        return new ago(agqVar, this);
    }

    public void a(int i) throws agz {
        if (i >= 1 && i <= 256) {
            this.c = i;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Delta distance must be in the range [1, 256]: ");
        stringBuffer.append(i);
        throw new agz(stringBuffer.toString());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (a) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }
}
