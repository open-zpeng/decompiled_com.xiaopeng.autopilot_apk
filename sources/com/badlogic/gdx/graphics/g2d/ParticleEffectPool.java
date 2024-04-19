package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.z;
/* loaded from: classes.dex */
public class ParticleEffectPool extends z<PooledEffect> {
    private final ParticleEffect effect;

    public ParticleEffectPool(ParticleEffect particleEffect, int i, int i2) {
        super(i, i2);
        this.effect = particleEffect;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.badlogic.gdx.utils.z
    public PooledEffect newObject() {
        return new PooledEffect(this.effect);
    }

    @Override // com.badlogic.gdx.utils.z
    public void free(PooledEffect pooledEffect) {
        super.free((ParticleEffectPool) pooledEffect);
        pooledEffect.reset(false);
        if (pooledEffect.xSizeScale == this.effect.xSizeScale && pooledEffect.ySizeScale == this.effect.ySizeScale && pooledEffect.motionScale == this.effect.motionScale) {
            return;
        }
        a<ParticleEmitter> emitters = pooledEffect.getEmitters();
        a<ParticleEmitter> emitters2 = this.effect.getEmitters();
        for (int i = 0; i < emitters.b; i++) {
            ParticleEmitter a = emitters.a(i);
            ParticleEmitter a2 = emitters2.a(i);
            a.matchSize(a2);
            a.matchMotion(a2);
        }
        pooledEffect.xSizeScale = this.effect.xSizeScale;
        pooledEffect.ySizeScale = this.effect.ySizeScale;
        pooledEffect.motionScale = this.effect.motionScale;
    }

    /* loaded from: classes.dex */
    public class PooledEffect extends ParticleEffect {
        PooledEffect(ParticleEffect particleEffect) {
            super(particleEffect);
        }

        public void free() {
            ParticleEffectPool.this.free(this);
        }
    }
}
