package defpackage;

import com.badlogic.gdx.graphics.glutils.q;
import defpackage.mx;
/* compiled from: ReverseUVShader.java */
/* renamed from: acn  reason: default package */
/* loaded from: classes.dex */
public class acn extends mx {
    private static final kv aG = new kv();

    public acn(lb lbVar, mx.a aVar) {
        this(lbVar, aVar, b(lbVar, aVar));
    }

    public acn(lb lbVar, mx.a aVar, String str) {
        this(lbVar, aVar, str, aVar.a != null ? aVar.a : c(), aVar.b != null ? aVar.b : d());
    }

    public acn(lb lbVar, mx.a aVar, String str, String str2, String str3) {
        this(lbVar, aVar, new q(str + str2, str + str3));
    }

    public acn(lb lbVar, mx.a aVar, q qVar) {
        super(lbVar, aVar, qVar);
    }

    public static String b(lb lbVar, mx.a aVar) {
        String a = mx.a(lbVar, aVar);
        if (c(lbVar).c(acm.b)) {
            return a + "#define reverseUVFlag\n";
        }
        return a;
    }

    private static final kv c(lb lbVar) {
        aG.c();
        if (lbVar.d != null) {
            aG.a((Iterable<ku>) lbVar.d);
        }
        if (lbVar.c != null) {
            aG.a((Iterable<ku>) lbVar.c);
        }
        return aG;
    }
}
