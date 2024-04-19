package defpackage;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import defpackage.js;
import java.util.Iterator;
/* compiled from: TextureAtlasLoader.java */
/* renamed from: jr  reason: default package */
/* loaded from: classes.dex */
public class jr extends jq<TextureAtlas, a> {
    TextureAtlas.TextureAtlasData a;

    /* compiled from: TextureAtlasLoader.java */
    /* renamed from: jr$a */
    /* loaded from: classes.dex */
    public static class a extends iz<TextureAtlas> {
        public boolean a = false;
    }

    public jr(jh jhVar) {
        super(jhVar);
    }

    @Override // defpackage.jq
    /* renamed from: a */
    public TextureAtlas load(jb jbVar, String str, jy jyVar, a aVar) {
        Iterator<TextureAtlas.TextureAtlasData.Page> it = this.a.getPages().iterator();
        while (it.hasNext()) {
            TextureAtlas.TextureAtlasData.Page next = it.next();
            next.texture = (ko) jbVar.a(next.textureFile.path().replaceAll("\\\\", "/"), ko.class);
        }
        TextureAtlas textureAtlas = new TextureAtlas(this.a);
        this.a = null;
        return textureAtlas;
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        jy parent = jyVar.parent();
        if (aVar != null) {
            this.a = new TextureAtlas.TextureAtlasData(jyVar, parent, aVar.a);
        } else {
            this.a = new TextureAtlas.TextureAtlasData(jyVar, parent, false);
        }
        com.badlogic.gdx.utils.a<ix> aVar2 = new com.badlogic.gdx.utils.a<>();
        Iterator<TextureAtlas.TextureAtlasData.Page> it = this.a.getPages().iterator();
        while (it.hasNext()) {
            TextureAtlas.TextureAtlasData.Page next = it.next();
            js.b bVar = new js.b();
            bVar.a = next.format;
            bVar.b = next.useMipMaps;
            bVar.e = next.minFilter;
            bVar.f = next.magFilter;
            aVar2.a((com.badlogic.gdx.utils.a<ix>) new ix(next.textureFile, ko.class, bVar));
        }
        return aVar2;
    }
}
