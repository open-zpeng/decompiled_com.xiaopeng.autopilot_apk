package defpackage;

import defpackage.mx;
/* compiled from: ReverseUVShaderProvider.java */
/* renamed from: aco  reason: default package */
/* loaded from: classes.dex */
public class aco extends nb {
    public mx.a b;

    public aco(mx.a aVar) {
        this.b = aVar == null ? new mx.a() : aVar;
    }

    public aco(String str, String str2) {
        mx.a aVar = new mx.a(str, str2);
        aVar.e = 1;
        this.b = aVar;
    }

    public aco() {
        this(null);
    }

    @Override // defpackage.nb
    protected ld b(lb lbVar) {
        return new acn(lbVar, this.b);
    }
}
