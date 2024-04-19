package defpackage;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.k;
import defpackage.js;
import defpackage.ko;
/* compiled from: BitmapFontLoader.java */
/* renamed from: jf  reason: default package */
/* loaded from: classes.dex */
public class jf extends je<BitmapFont, a> {
    BitmapFont.BitmapFontData a;

    /* compiled from: BitmapFontLoader.java */
    /* renamed from: jf$a */
    /* loaded from: classes.dex */
    public static class a extends iz<BitmapFont> {
        public boolean a = false;
        public boolean b = false;
        public ko.a c = ko.a.Nearest;
        public ko.a d = ko.a.Nearest;
        public BitmapFont.BitmapFontData e = null;
        public String f = null;
    }

    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, a aVar) {
    }

    public jf(jh jhVar) {
        super(jhVar);
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        com.badlogic.gdx.utils.a<ix> aVar2 = new com.badlogic.gdx.utils.a<>();
        if (aVar != null && aVar.e != null) {
            this.a = aVar.e;
            return aVar2;
        }
        this.a = new BitmapFont.BitmapFontData(jyVar, aVar != null && aVar.a);
        if (aVar != null && aVar.f != null) {
            aVar2.a((com.badlogic.gdx.utils.a<ix>) new ix(aVar.f, TextureAtlas.class));
        } else {
            for (int i = 0; i < this.a.getImagePaths().length; i++) {
                jy resolve = resolve(this.a.getImagePath(i));
                js.b bVar = new js.b();
                if (aVar != null) {
                    bVar.b = aVar.b;
                    bVar.e = aVar.c;
                    bVar.f = aVar.d;
                }
                aVar2.a((com.badlogic.gdx.utils.a<ix>) new ix(resolve, ko.class, bVar));
            }
        }
        return aVar2;
    }

    @Override // defpackage.je
    public BitmapFont b(jb jbVar, String str, jy jyVar, a aVar) {
        if (aVar != null && aVar.f != null) {
            String str2 = jyVar.sibling(this.a.imagePaths[0]).nameWithoutExtension().toString();
            TextureAtlas.AtlasRegion findRegion = ((TextureAtlas) jbVar.a(aVar.f, TextureAtlas.class)).findRegion(str2);
            if (findRegion == null) {
                throw new k("Could not find font region " + str2 + " in atlas " + aVar.f);
            }
            return new BitmapFont(jyVar, findRegion);
        }
        int length = this.a.getImagePaths().length;
        com.badlogic.gdx.utils.a aVar2 = new com.badlogic.gdx.utils.a(length);
        for (int i = 0; i < length; i++) {
            aVar2.a((com.badlogic.gdx.utils.a) new TextureRegion((ko) jbVar.a(this.a.getImagePath(i), ko.class)));
        }
        return new BitmapFont(this.a, (com.badlogic.gdx.utils.a<TextureRegion>) aVar2, true);
    }
}
