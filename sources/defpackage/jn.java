package defpackage;

import com.badlogic.gdx.graphics.glutils.q;
/* compiled from: ShaderProgramLoader.java */
/* renamed from: jn  reason: default package */
/* loaded from: classes.dex */
public class jn extends je<q, a> {
    private String a;
    private String b;

    /* compiled from: ShaderProgramLoader.java */
    /* renamed from: jn$a */
    /* loaded from: classes.dex */
    public static class a extends iz<q> {
        public String a;
        public String b;
        public boolean c = true;
        public String d;
        public String e;
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        return null;
    }

    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, a aVar) {
    }

    public jn(jh jhVar) {
        super(jhVar);
        this.a = ".vert";
        this.b = ".frag";
    }

    @Override // defpackage.je
    public q b(jb jbVar, String str, jy jyVar, a aVar) {
        String str2;
        String str3 = null;
        if (aVar != null) {
            str2 = aVar.a != null ? aVar.a : null;
            if (aVar.b != null) {
                str3 = aVar.b;
            }
        } else {
            str2 = null;
        }
        if (str2 == null && str.endsWith(this.b)) {
            str2 = str.substring(0, str.length() - this.b.length()) + this.a;
        }
        if (str3 == null && str.endsWith(this.a)) {
            str3 = str.substring(0, str.length() - this.a.length()) + this.b;
        }
        jy resolve = str2 == null ? jyVar : resolve(str2);
        if (str3 != null) {
            jyVar = resolve(str3);
        }
        String readString = resolve.readString();
        String readString2 = resolve.equals(jyVar) ? readString : jyVar.readString();
        if (aVar != null) {
            if (aVar.d != null) {
                readString = aVar.d + readString;
            }
            if (aVar.e != null) {
                readString2 = aVar.e + readString2;
            }
        }
        q qVar = new q(readString, readString2);
        if ((aVar == null || aVar.c) && !qVar.c()) {
            jbVar.e().c("ShaderProgram " + str + " failed to compile:\n" + qVar.b());
        }
        return qVar;
    }
}
