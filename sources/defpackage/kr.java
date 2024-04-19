package defpackage;

import com.badlogic.gdx.graphics.glutils.n;
import defpackage.km;
/* compiled from: TextureData.java */
/* renamed from: kr  reason: default package */
/* loaded from: classes.dex */
public interface kr {

    /* compiled from: TextureData.java */
    /* renamed from: kr$b */
    /* loaded from: classes.dex */
    public enum b {
        Pixmap,
        Custom
    }

    void a(int i);

    boolean a();

    void b();

    int d();

    int e();

    boolean f();

    b g();

    km h();

    boolean i();

    km.c j();

    boolean k();

    /* compiled from: TextureData.java */
    /* renamed from: kr$a */
    /* loaded from: classes.dex */
    public static class a {
        public static kr a(jy jyVar, km.c cVar, boolean z) {
            if (jyVar == null) {
                return null;
            }
            if (jyVar.name().endsWith(".cim")) {
                return new com.badlogic.gdx.graphics.glutils.b(jyVar, kn.a(jyVar), cVar, z);
            }
            if (jyVar.name().endsWith(".etc1")) {
                return new com.badlogic.gdx.graphics.glutils.a(jyVar, z);
            }
            if (jyVar.name().endsWith(".ktx") || jyVar.name().endsWith(".zktx")) {
                return new n(jyVar, z);
            }
            return new com.badlogic.gdx.graphics.glutils.b(jyVar, new km(jyVar), cVar, z);
        }
    }
}
