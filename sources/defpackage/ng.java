package defpackage;

import defpackage.my;
/* compiled from: DepthShaderProvider.java */
/* renamed from: ng  reason: default package */
/* loaded from: classes.dex */
public class ng extends nb {
    public final my.a b;

    public ng(my.a aVar) {
        this.b = aVar == null ? new my.a() : aVar;
    }

    public ng(String str, String str2) {
        this(new my.a(str, str2));
    }

    public ng() {
        this(null);
    }

    @Override // defpackage.nb
    protected ld b(lb lbVar) {
        return new my(lbVar, this.b);
    }
}
