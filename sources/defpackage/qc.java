package defpackage;
/* compiled from: ChangeListener.java */
/* renamed from: qc  reason: default package */
/* loaded from: classes.dex */
public abstract class qc implements om {

    /* compiled from: ChangeListener.java */
    /* renamed from: qc$a */
    /* loaded from: classes.dex */
    public static class a extends ol {
    }

    public abstract void a(a aVar, ok okVar);

    @Override // defpackage.om
    public boolean a(ol olVar) {
        if (olVar instanceof a) {
            a((a) olVar, olVar.b());
            return false;
        }
        return false;
    }
}
