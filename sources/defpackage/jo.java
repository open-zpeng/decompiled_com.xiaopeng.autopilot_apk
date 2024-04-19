package defpackage;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.v;
/* compiled from: SkinLoader.java */
/* renamed from: jo  reason: default package */
/* loaded from: classes.dex */
public class jo extends je<pl, a> {
    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, a aVar) {
    }

    public jo(jh jhVar) {
        super(jhVar);
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        com.badlogic.gdx.utils.a<ix> aVar2 = new com.badlogic.gdx.utils.a<>();
        if (aVar == null || aVar.a == null) {
            aVar2.a((com.badlogic.gdx.utils.a<ix>) new ix(jyVar.pathWithoutExtension() + ".atlas", TextureAtlas.class));
        } else if (aVar.a != null) {
            aVar2.a((com.badlogic.gdx.utils.a<ix>) new ix(aVar.a, TextureAtlas.class));
        }
        return aVar2;
    }

    @Override // defpackage.je
    public pl b(jb jbVar, String str, jy jyVar, a aVar) {
        String str2 = jyVar.pathWithoutExtension() + ".atlas";
        v<String, Object> vVar = null;
        if (aVar != null) {
            if (aVar.a != null) {
                str2 = aVar.a;
            }
            if (aVar.b != null) {
                vVar = aVar.b;
            }
        }
        pl a2 = a((TextureAtlas) jbVar.a(str2, TextureAtlas.class));
        if (vVar != null) {
            v.a<String, Object> it = vVar.c().iterator();
            while (it.hasNext()) {
                v.b next = it.next();
                a2.a((String) next.a, next.b);
            }
        }
        a2.a(jyVar);
        return a2;
    }

    protected pl a(TextureAtlas textureAtlas) {
        return new pl(textureAtlas);
    }

    /* compiled from: SkinLoader.java */
    /* renamed from: jo$a */
    /* loaded from: classes.dex */
    public static class a extends iz<pl> {
        public final String a;
        public final v<String, Object> b;

        public a() {
            this(null, null);
        }

        public a(String str, v<String, Object> vVar) {
            this.a = str;
            this.b = vVar;
        }
    }
}
