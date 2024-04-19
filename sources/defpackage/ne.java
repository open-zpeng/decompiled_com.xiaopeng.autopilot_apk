package defpackage;

import defpackage.mx;
/* compiled from: DefaultShaderProvider.java */
/* renamed from: ne  reason: default package */
/* loaded from: classes.dex */
public class ne extends nb {
    public final mx.a b;

    public ne(mx.a aVar) {
        this.b = aVar == null ? new mx.a() : aVar;
    }

    public ne(String str, String str2) {
        this(new mx.a(str, str2));
    }

    public ne() {
        this(null);
    }

    @Override // defpackage.nb
    protected ld b(lb lbVar) {
        return new mx(lbVar, this.b);
    }
}
