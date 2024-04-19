package defpackage;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/* compiled from: ParticleEffectLoader.java */
/* renamed from: jl  reason: default package */
/* loaded from: classes.dex */
public class jl extends jq<ParticleEffect, a> {

    /* compiled from: ParticleEffectLoader.java */
    /* renamed from: jl$a */
    /* loaded from: classes.dex */
    public static class a extends iz<ParticleEffect> {
        public String a;
        public String b;
        public jy c;
    }

    public jl(jh jhVar) {
        super(jhVar);
    }

    @Override // defpackage.jq
    /* renamed from: a */
    public ParticleEffect load(jb jbVar, String str, jy jyVar, a aVar) {
        ParticleEffect particleEffect = new ParticleEffect();
        if (aVar != null && aVar.a != null) {
            particleEffect.load(jyVar, (TextureAtlas) jbVar.a(aVar.a, TextureAtlas.class), aVar.b);
        } else if (aVar != null && aVar.c != null) {
            particleEffect.load(jyVar, aVar.c);
        } else {
            particleEffect.load(jyVar, jyVar.parent());
        }
        return particleEffect;
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        if (aVar == null || aVar.a == null) {
            return null;
        }
        com.badlogic.gdx.utils.a<ix> aVar2 = new com.badlogic.gdx.utils.a<>();
        aVar2.a((com.badlogic.gdx.utils.a<ix>) new ix(aVar.a, TextureAtlas.class));
        return aVar2;
    }
}
