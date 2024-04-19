package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.utils.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ParticleEmitter {
    private static final int UPDATE_ANGLE = 2;
    private static final int UPDATE_GRAVITY = 32;
    private static final int UPDATE_ROTATION = 4;
    private static final int UPDATE_SCALE = 1;
    private static final int UPDATE_SPRITE = 128;
    private static final int UPDATE_TINT = 64;
    private static final int UPDATE_VELOCITY = 8;
    private static final int UPDATE_WIND = 16;
    private float accumulator;
    private boolean[] active;
    private int activeCount;
    private boolean additive;
    private boolean aligned;
    private boolean allowCompletion;
    private ScaledNumericValue angleValue;
    private boolean attached;
    private boolean behind;
    private nz bounds;
    boolean cleansUpBlendFunction;
    private boolean continuous;
    private float delay;
    private float delayTimer;
    private RangedNumericValue delayValue;
    public float duration;
    public float durationTimer;
    private RangedNumericValue durationValue;
    private int emission;
    private int emissionDelta;
    private int emissionDiff;
    private ScaledNumericValue emissionValue;
    private boolean firstUpdate;
    private boolean flipX;
    private boolean flipY;
    private ScaledNumericValue gravityValue;
    private a<String> imagePaths;
    private int life;
    private int lifeDiff;
    private int lifeOffset;
    private int lifeOffsetDiff;
    private IndependentScaledNumericValue lifeOffsetValue;
    private IndependentScaledNumericValue lifeValue;
    private int maxParticleCount;
    private int minParticleCount;
    private RangedNumericValue[] motionValues;
    private String name;
    private Particle[] particles;
    private boolean premultipliedAlpha;
    private ScaledNumericValue rotationValue;
    private float spawnHeight;
    private float spawnHeightDiff;
    private ScaledNumericValue spawnHeightValue;
    private SpawnShapeValue spawnShapeValue;
    private float spawnWidth;
    private float spawnWidthDiff;
    private ScaledNumericValue spawnWidthValue;
    private SpriteMode spriteMode;
    private a<Sprite> sprites;
    private GradientColorValue tintValue;
    private ScaledNumericValue transparencyValue;
    private int updateFlags;
    private ScaledNumericValue velocityValue;
    private ScaledNumericValue windValue;
    private float x;
    private RangedNumericValue xOffsetValue;
    private ScaledNumericValue xScaleValue;
    private RangedNumericValue[] xSizeValues;
    private float y;
    private RangedNumericValue yOffsetValue;
    private ScaledNumericValue yScaleValue;
    private RangedNumericValue[] ySizeValues;

    /* loaded from: classes.dex */
    public enum SpawnEllipseSide {
        both,
        top,
        bottom
    }

    /* loaded from: classes.dex */
    public enum SpawnShape {
        point,
        line,
        square,
        ellipse
    }

    /* loaded from: classes.dex */
    public enum SpriteMode {
        single,
        random,
        animated
    }

    public ParticleEmitter() {
        this.delayValue = new RangedNumericValue();
        this.lifeOffsetValue = new IndependentScaledNumericValue();
        this.durationValue = new RangedNumericValue();
        this.lifeValue = new IndependentScaledNumericValue();
        this.emissionValue = new ScaledNumericValue();
        this.xScaleValue = new ScaledNumericValue();
        this.yScaleValue = new ScaledNumericValue();
        this.rotationValue = new ScaledNumericValue();
        this.velocityValue = new ScaledNumericValue();
        this.angleValue = new ScaledNumericValue();
        this.windValue = new ScaledNumericValue();
        this.gravityValue = new ScaledNumericValue();
        this.transparencyValue = new ScaledNumericValue();
        this.tintValue = new GradientColorValue();
        this.xOffsetValue = new ScaledNumericValue();
        this.yOffsetValue = new ScaledNumericValue();
        this.spawnWidthValue = new ScaledNumericValue();
        this.spawnHeightValue = new ScaledNumericValue();
        this.spawnShapeValue = new SpawnShapeValue();
        this.spriteMode = SpriteMode.single;
        this.maxParticleCount = 4;
        this.duration = 1.0f;
        this.additive = true;
        this.premultipliedAlpha = false;
        this.cleansUpBlendFunction = true;
        initialize();
    }

    public ParticleEmitter(BufferedReader bufferedReader) throws IOException {
        this.delayValue = new RangedNumericValue();
        this.lifeOffsetValue = new IndependentScaledNumericValue();
        this.durationValue = new RangedNumericValue();
        this.lifeValue = new IndependentScaledNumericValue();
        this.emissionValue = new ScaledNumericValue();
        this.xScaleValue = new ScaledNumericValue();
        this.yScaleValue = new ScaledNumericValue();
        this.rotationValue = new ScaledNumericValue();
        this.velocityValue = new ScaledNumericValue();
        this.angleValue = new ScaledNumericValue();
        this.windValue = new ScaledNumericValue();
        this.gravityValue = new ScaledNumericValue();
        this.transparencyValue = new ScaledNumericValue();
        this.tintValue = new GradientColorValue();
        this.xOffsetValue = new ScaledNumericValue();
        this.yOffsetValue = new ScaledNumericValue();
        this.spawnWidthValue = new ScaledNumericValue();
        this.spawnHeightValue = new ScaledNumericValue();
        this.spawnShapeValue = new SpawnShapeValue();
        this.spriteMode = SpriteMode.single;
        this.maxParticleCount = 4;
        this.duration = 1.0f;
        this.additive = true;
        this.premultipliedAlpha = false;
        this.cleansUpBlendFunction = true;
        initialize();
        load(bufferedReader);
    }

    public ParticleEmitter(ParticleEmitter particleEmitter) {
        this.delayValue = new RangedNumericValue();
        this.lifeOffsetValue = new IndependentScaledNumericValue();
        this.durationValue = new RangedNumericValue();
        this.lifeValue = new IndependentScaledNumericValue();
        this.emissionValue = new ScaledNumericValue();
        this.xScaleValue = new ScaledNumericValue();
        this.yScaleValue = new ScaledNumericValue();
        this.rotationValue = new ScaledNumericValue();
        this.velocityValue = new ScaledNumericValue();
        this.angleValue = new ScaledNumericValue();
        this.windValue = new ScaledNumericValue();
        this.gravityValue = new ScaledNumericValue();
        this.transparencyValue = new ScaledNumericValue();
        this.tintValue = new GradientColorValue();
        this.xOffsetValue = new ScaledNumericValue();
        this.yOffsetValue = new ScaledNumericValue();
        this.spawnWidthValue = new ScaledNumericValue();
        this.spawnHeightValue = new ScaledNumericValue();
        this.spawnShapeValue = new SpawnShapeValue();
        this.spriteMode = SpriteMode.single;
        this.maxParticleCount = 4;
        this.duration = 1.0f;
        this.additive = true;
        this.premultipliedAlpha = false;
        this.cleansUpBlendFunction = true;
        this.sprites = new a<>(particleEmitter.sprites);
        this.name = particleEmitter.name;
        this.imagePaths = new a<>(particleEmitter.imagePaths);
        setMaxParticleCount(particleEmitter.maxParticleCount);
        this.minParticleCount = particleEmitter.minParticleCount;
        this.delayValue.load(particleEmitter.delayValue);
        this.durationValue.load(particleEmitter.durationValue);
        this.emissionValue.load(particleEmitter.emissionValue);
        this.lifeValue.load(particleEmitter.lifeValue);
        this.lifeOffsetValue.load(particleEmitter.lifeOffsetValue);
        this.xScaleValue.load(particleEmitter.xScaleValue);
        this.yScaleValue.load(particleEmitter.yScaleValue);
        this.rotationValue.load(particleEmitter.rotationValue);
        this.velocityValue.load(particleEmitter.velocityValue);
        this.angleValue.load(particleEmitter.angleValue);
        this.windValue.load(particleEmitter.windValue);
        this.gravityValue.load(particleEmitter.gravityValue);
        this.transparencyValue.load(particleEmitter.transparencyValue);
        this.tintValue.load(particleEmitter.tintValue);
        this.xOffsetValue.load(particleEmitter.xOffsetValue);
        this.yOffsetValue.load(particleEmitter.yOffsetValue);
        this.spawnWidthValue.load(particleEmitter.spawnWidthValue);
        this.spawnHeightValue.load(particleEmitter.spawnHeightValue);
        this.spawnShapeValue.load(particleEmitter.spawnShapeValue);
        this.attached = particleEmitter.attached;
        this.continuous = particleEmitter.continuous;
        this.aligned = particleEmitter.aligned;
        this.behind = particleEmitter.behind;
        this.additive = particleEmitter.additive;
        this.premultipliedAlpha = particleEmitter.premultipliedAlpha;
        this.cleansUpBlendFunction = particleEmitter.cleansUpBlendFunction;
        this.spriteMode = particleEmitter.spriteMode;
    }

    private void initialize() {
        this.sprites = new a<>();
        this.imagePaths = new a<>();
        this.durationValue.setAlwaysActive(true);
        this.emissionValue.setAlwaysActive(true);
        this.lifeValue.setAlwaysActive(true);
        this.xScaleValue.setAlwaysActive(true);
        this.transparencyValue.setAlwaysActive(true);
        this.spawnShapeValue.setAlwaysActive(true);
        this.spawnWidthValue.setAlwaysActive(true);
        this.spawnHeightValue.setAlwaysActive(true);
    }

    public void setMaxParticleCount(int i) {
        this.maxParticleCount = i;
        this.active = new boolean[i];
        this.activeCount = 0;
        this.particles = new Particle[i];
    }

    public void addParticle() {
        int i = this.activeCount;
        if (i == this.maxParticleCount) {
            return;
        }
        boolean[] zArr = this.active;
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!zArr[i2]) {
                activateParticle(i2);
                zArr[i2] = true;
                this.activeCount = i + 1;
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        activateParticle(r3);
        r0[r3] = true;
        r2 = r2 + 1;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addParticles(int r7) {
        /*
            r6 = this;
            int r0 = r6.maxParticleCount
            int r1 = r6.activeCount
            int r0 = r0 - r1
            int r7 = java.lang.Math.min(r7, r0)
            if (r7 != 0) goto Lc
            return
        Lc:
            boolean[] r0 = r6.active
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L11:
            if (r2 >= r7) goto L28
        L13:
            if (r3 >= r1) goto L28
            boolean r4 = r0[r3]
            if (r4 != 0) goto L25
            r6.activateParticle(r3)
            int r4 = r3 + 1
            r5 = 1
            r0[r3] = r5
            int r2 = r2 + 1
            r3 = r4
            goto L11
        L25:
            int r3 = r3 + 1
            goto L13
        L28:
            int r0 = r6.activeCount
            int r0 = r0 + r7
            r6.activeCount = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.ParticleEmitter.addParticles(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(float r9) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.ParticleEmitter.update(float):void");
    }

    public void draw(Batch batch) {
        if (this.premultipliedAlpha) {
            batch.setBlendFunction(1, 771);
        } else if (this.additive) {
            batch.setBlendFunction(770, 1);
        } else {
            batch.setBlendFunction(770, 771);
        }
        Particle[] particleArr = this.particles;
        boolean[] zArr = this.active;
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (zArr[i]) {
                particleArr[i].draw(batch);
            }
        }
        if (this.cleansUpBlendFunction) {
            if (this.additive || this.premultipliedAlpha) {
                batch.setBlendFunction(770, 771);
            }
        }
    }

    public void draw(Batch batch, float f) {
        this.accumulator += f * 1000.0f;
        float f2 = this.accumulator;
        if (f2 < 1.0f) {
            draw(batch);
            return;
        }
        int i = (int) f2;
        float f3 = i;
        this.accumulator = f2 - f3;
        if (this.premultipliedAlpha) {
            batch.setBlendFunction(1, 771);
        } else if (this.additive) {
            batch.setBlendFunction(770, 1);
        } else {
            batch.setBlendFunction(770, 771);
        }
        Particle[] particleArr = this.particles;
        boolean[] zArr = this.active;
        int i2 = this.activeCount;
        int length = zArr.length;
        int i3 = i2;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                Particle particle = particleArr[i4];
                if (updateParticle(particle, f, i)) {
                    particle.draw(batch);
                } else {
                    zArr[i4] = false;
                    i3--;
                }
            }
        }
        this.activeCount = i3;
        if (this.cleansUpBlendFunction && (this.additive || this.premultipliedAlpha)) {
            batch.setBlendFunction(770, 771);
        }
        float f4 = this.delayTimer;
        if (f4 < this.delay) {
            this.delayTimer = f4 + f3;
            return;
        }
        if (this.firstUpdate) {
            this.firstUpdate = false;
            addParticle();
        }
        float f5 = this.durationTimer;
        if (f5 < this.duration) {
            this.durationTimer = f5 + f3;
        } else if (!this.continuous || this.allowCompletion) {
            return;
        } else {
            restart();
        }
        this.emissionDelta += i;
        float scale = this.emission + (this.emissionDiff * this.emissionValue.getScale(this.durationTimer / this.duration));
        if (scale > 0.0f) {
            float f6 = 1000.0f / scale;
            int i5 = this.emissionDelta;
            if (i5 >= f6) {
                int min = Math.min((int) (i5 / f6), this.maxParticleCount - i3);
                this.emissionDelta = (int) (this.emissionDelta - (min * f6));
                this.emissionDelta = (int) (this.emissionDelta % f6);
                addParticles(min);
            }
        }
        int i6 = this.minParticleCount;
        if (i3 < i6) {
            addParticles(i6 - i3);
        }
    }

    public void start() {
        this.firstUpdate = true;
        this.allowCompletion = false;
        restart();
    }

    public void reset() {
        this.emissionDelta = 0;
        this.durationTimer = this.duration;
        boolean[] zArr = this.active;
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            zArr[i] = false;
        }
        this.activeCount = 0;
        start();
    }

    private void restart() {
        this.delay = this.delayValue.active ? this.delayValue.newLowValue() : 0.0f;
        this.delayTimer = 0.0f;
        this.durationTimer -= this.duration;
        this.duration = this.durationValue.newLowValue();
        this.emission = (int) this.emissionValue.newLowValue();
        this.emissionDiff = (int) this.emissionValue.newHighValue();
        if (!this.emissionValue.isRelative()) {
            this.emissionDiff -= this.emission;
        }
        if (!this.lifeValue.independent) {
            generateLifeValues();
        }
        if (!this.lifeOffsetValue.independent) {
            generateLifeOffsetValues();
        }
        this.spawnWidth = this.spawnWidthValue.newLowValue();
        this.spawnWidthDiff = this.spawnWidthValue.newHighValue();
        if (!this.spawnWidthValue.isRelative()) {
            this.spawnWidthDiff -= this.spawnWidth;
        }
        this.spawnHeight = this.spawnHeightValue.newLowValue();
        this.spawnHeightDiff = this.spawnHeightValue.newHighValue();
        if (!this.spawnHeightValue.isRelative()) {
            this.spawnHeightDiff -= this.spawnHeight;
        }
        this.updateFlags = 0;
        if (this.angleValue.active && this.angleValue.timeline.length > 1) {
            this.updateFlags |= 2;
        }
        if (this.velocityValue.active) {
            this.updateFlags |= 8;
        }
        if (this.xScaleValue.timeline.length > 1) {
            this.updateFlags |= 1;
        }
        if (this.yScaleValue.active && this.yScaleValue.timeline.length > 1) {
            this.updateFlags |= 1;
        }
        if (this.rotationValue.active && this.rotationValue.timeline.length > 1) {
            this.updateFlags |= 4;
        }
        if (this.windValue.active) {
            this.updateFlags |= 16;
        }
        if (this.gravityValue.active) {
            this.updateFlags |= 32;
        }
        if (this.tintValue.timeline.length > 1) {
            this.updateFlags |= 64;
        }
        if (this.spriteMode == SpriteMode.animated) {
            this.updateFlags |= UPDATE_SPRITE;
        }
    }

    protected Particle newParticle(Sprite sprite) {
        return new Particle(sprite);
    }

    protected Particle[] getParticles() {
        return this.particles;
    }

    private void activateParticle(int i) {
        Sprite c;
        float f;
        float e;
        float e2;
        float f2;
        switch (this.spriteMode) {
            case single:
            case animated:
                c = this.sprites.c();
                break;
            case random:
                c = this.sprites.e();
                break;
            default:
                c = null;
                break;
        }
        Particle[] particleArr = this.particles;
        Particle particle = particleArr[i];
        if (particle == null) {
            particle = newParticle(c);
            particleArr[i] = particle;
            particle.flip(this.flipX, this.flipY);
        } else {
            particle.set(c);
        }
        float f3 = this.durationTimer / this.duration;
        int i2 = this.updateFlags;
        if (this.lifeValue.independent) {
            generateLifeValues();
        }
        if (this.lifeOffsetValue.independent) {
            generateLifeOffsetValues();
        }
        int scale = this.life + ((int) (this.lifeDiff * this.lifeValue.getScale(f3)));
        particle.life = scale;
        particle.currentLife = scale;
        if (this.velocityValue.active) {
            particle.velocity = this.velocityValue.newLowValue();
            particle.velocityDiff = this.velocityValue.newHighValue();
            if (!this.velocityValue.isRelative()) {
                particle.velocityDiff -= particle.velocity;
            }
        }
        particle.angle = this.angleValue.newLowValue();
        particle.angleDiff = this.angleValue.newHighValue();
        if (!this.angleValue.isRelative()) {
            particle.angleDiff -= particle.angle;
        }
        int i3 = i2 & 2;
        if (i3 == 0) {
            f = particle.angle + (particle.angleDiff * this.angleValue.getScale(0.0f));
            particle.angle = f;
            particle.angleCos = h.d(f);
            particle.angleSin = h.c(f);
        } else {
            f = 0.0f;
        }
        float width = c.getWidth();
        float height = c.getHeight();
        particle.xScale = this.xScaleValue.newLowValue() / width;
        particle.xScaleDiff = this.xScaleValue.newHighValue() / width;
        if (!this.xScaleValue.isRelative()) {
            particle.xScaleDiff -= particle.xScale;
        }
        if (this.yScaleValue.active) {
            particle.yScale = this.yScaleValue.newLowValue() / height;
            particle.yScaleDiff = this.yScaleValue.newHighValue() / height;
            if (!this.yScaleValue.isRelative()) {
                particle.yScaleDiff -= particle.yScale;
            }
            particle.setScale(particle.xScale + (particle.xScaleDiff * this.xScaleValue.getScale(0.0f)), particle.yScale + (particle.yScaleDiff * this.yScaleValue.getScale(0.0f)));
        } else {
            particle.setScale(particle.xScale + (particle.xScaleDiff * this.xScaleValue.getScale(0.0f)));
        }
        if (this.rotationValue.active) {
            particle.rotation = this.rotationValue.newLowValue();
            particle.rotationDiff = this.rotationValue.newHighValue();
            if (!this.rotationValue.isRelative()) {
                particle.rotationDiff -= particle.rotation;
            }
            float scale2 = particle.rotation + (particle.rotationDiff * this.rotationValue.getScale(0.0f));
            if (this.aligned) {
                scale2 += f;
            }
            particle.setRotation(scale2);
        }
        if (this.windValue.active) {
            particle.wind = this.windValue.newLowValue();
            particle.windDiff = this.windValue.newHighValue();
            if (!this.windValue.isRelative()) {
                particle.windDiff -= particle.wind;
            }
        }
        if (this.gravityValue.active) {
            particle.gravity = this.gravityValue.newLowValue();
            particle.gravityDiff = this.gravityValue.newHighValue();
            if (!this.gravityValue.isRelative()) {
                particle.gravityDiff -= particle.gravity;
            }
        }
        float[] fArr = particle.tint;
        if (fArr == null) {
            fArr = new float[3];
            particle.tint = fArr;
        }
        float[] color = this.tintValue.getColor(0.0f);
        fArr[0] = color[0];
        fArr[1] = color[1];
        fArr[2] = color[2];
        particle.transparency = this.transparencyValue.newLowValue();
        particle.transparencyDiff = this.transparencyValue.newHighValue() - particle.transparency;
        float f4 = this.x;
        if (this.xOffsetValue.active) {
            f4 += this.xOffsetValue.newLowValue();
        }
        float f5 = this.y;
        if (this.yOffsetValue.active) {
            f5 += this.yOffsetValue.newLowValue();
        }
        switch (this.spawnShapeValue.shape) {
            case square:
                float scale3 = this.spawnWidth + (this.spawnWidthDiff * this.spawnWidthValue.getScale(f3));
                float scale4 = this.spawnHeight + (this.spawnHeightDiff * this.spawnHeightValue.getScale(f3));
                f4 += h.e(scale3) - (scale3 / 2.0f);
                f5 += h.e(scale4) - (scale4 / 2.0f);
                break;
            case ellipse:
                float scale5 = this.spawnWidth + (this.spawnWidthDiff * this.spawnWidthValue.getScale(f3));
                float scale6 = this.spawnHeight + (this.spawnHeightDiff * this.spawnHeightValue.getScale(f3));
                float f6 = scale5 / 2.0f;
                float f7 = scale6 / 2.0f;
                if (f6 != 0.0f && f7 != 0.0f) {
                    float f8 = f6 / f7;
                    if (!this.spawnShapeValue.edges) {
                        float f9 = f6 * f6;
                        do {
                            e = h.e(scale5) - f6;
                            e2 = h.e(scale6) - f7;
                        } while ((e * e) + (e2 * e2) > f9);
                        f4 += e;
                        f5 += e2 / f8;
                        break;
                    } else {
                        switch (this.spawnShapeValue.side) {
                            case top:
                                f2 = -h.e(179.0f);
                                break;
                            case bottom:
                                f2 = h.e(179.0f);
                                break;
                            default:
                                f2 = h.e(360.0f);
                                break;
                        }
                        float d = h.d(f2);
                        float c2 = h.c(f2);
                        f4 += d * f6;
                        f5 += (f6 * c2) / f8;
                        if (i3 == 0) {
                            particle.angle = f2;
                            particle.angleCos = d;
                            particle.angleSin = c2;
                            break;
                        }
                    }
                }
                break;
            case line:
                float scale7 = this.spawnWidth + (this.spawnWidthDiff * this.spawnWidthValue.getScale(f3));
                float scale8 = this.spawnHeight + (this.spawnHeightDiff * this.spawnHeightValue.getScale(f3));
                if (scale7 != 0.0f) {
                    float a = h.a() * scale7;
                    f4 += a;
                    f5 += a * (scale8 / scale7);
                    break;
                } else {
                    f5 += scale8 * h.a();
                    break;
                }
        }
        particle.setBounds(f4 - (width / 2.0f), f5 - (height / 2.0f), width, height);
        int scale9 = (int) (this.lifeOffset + (this.lifeOffsetDiff * this.lifeOffsetValue.getScale(f3)));
        if (scale9 > 0) {
            if (scale9 >= particle.currentLife) {
                scale9 = particle.currentLife - 1;
            }
            updateParticle(particle, scale9 / 1000.0f, scale9);
        }
    }

    private boolean updateParticle(Particle particle, float f, int i) {
        float[] fArr;
        int min;
        float f2;
        float f3;
        int i2 = particle.currentLife - i;
        if (i2 <= 0) {
            return false;
        }
        particle.currentLife = i2;
        float f4 = 1.0f - (particle.currentLife / particle.life);
        int i3 = this.updateFlags;
        if ((i3 & 1) != 0) {
            if (this.yScaleValue.active) {
                particle.setScale(particle.xScale + (particle.xScaleDiff * this.xScaleValue.getScale(f4)), particle.yScale + (particle.yScaleDiff * this.yScaleValue.getScale(f4)));
            } else {
                particle.setScale(particle.xScale + (particle.xScaleDiff * this.xScaleValue.getScale(f4)));
            }
        }
        if ((i3 & 8) != 0) {
            float scale = (particle.velocity + (particle.velocityDiff * this.velocityValue.getScale(f4))) * f;
            if ((i3 & 2) != 0) {
                float scale2 = particle.angle + (particle.angleDiff * this.angleValue.getScale(f4));
                f2 = h.d(scale2) * scale;
                f3 = scale * h.c(scale2);
                if ((i3 & 4) != 0) {
                    float scale3 = particle.rotation + (particle.rotationDiff * this.rotationValue.getScale(f4));
                    if (this.aligned) {
                        scale3 += scale2;
                    }
                    particle.setRotation(scale3);
                }
            } else {
                f2 = scale * particle.angleCos;
                f3 = scale * particle.angleSin;
                if (this.aligned || (i3 & 4) != 0) {
                    float scale4 = particle.rotation + (particle.rotationDiff * this.rotationValue.getScale(f4));
                    if (this.aligned) {
                        scale4 += particle.angle;
                    }
                    particle.setRotation(scale4);
                }
            }
            if ((i3 & 16) != 0) {
                f2 += (particle.wind + (particle.windDiff * this.windValue.getScale(f4))) * f;
            }
            if ((i3 & 32) != 0) {
                f3 += (particle.gravity + (particle.gravityDiff * this.gravityValue.getScale(f4))) * f;
            }
            particle.translate(f2, f3);
        } else if ((i3 & 4) != 0) {
            particle.setRotation(particle.rotation + (particle.rotationDiff * this.rotationValue.getScale(f4)));
        }
        if ((i3 & 64) != 0) {
            fArr = this.tintValue.getColor(f4);
        } else {
            fArr = particle.tint;
        }
        if (this.premultipliedAlpha) {
            float f5 = this.additive ? 0.0f : 1.0f;
            float scale5 = particle.transparency + (particle.transparencyDiff * this.transparencyValue.getScale(f4));
            particle.setColor(fArr[0] * scale5, fArr[1] * scale5, fArr[2] * scale5, scale5 * f5);
        } else {
            particle.setColor(fArr[0], fArr[1], fArr[2], particle.transparency + (particle.transparencyDiff * this.transparencyValue.getScale(f4)));
        }
        if ((i3 & UPDATE_SPRITE) != 0 && particle.frame != (min = Math.min((int) (f4 * this.sprites.b), this.sprites.b - 1))) {
            Sprite a = this.sprites.a(min);
            float width = particle.getWidth();
            float height = particle.getHeight();
            particle.setRegion(a);
            particle.setSize(a.getWidth(), a.getHeight());
            particle.setOrigin(a.getOriginX(), a.getOriginY());
            particle.translate((width - a.getWidth()) / 2.0f, (height - a.getHeight()) / 2.0f);
            particle.frame = min;
        }
        return true;
    }

    private void generateLifeValues() {
        this.life = (int) this.lifeValue.newLowValue();
        this.lifeDiff = (int) this.lifeValue.newHighValue();
        if (this.lifeValue.isRelative()) {
            return;
        }
        this.lifeDiff -= this.life;
    }

    private void generateLifeOffsetValues() {
        this.lifeOffset = this.lifeOffsetValue.active ? (int) this.lifeOffsetValue.newLowValue() : 0;
        this.lifeOffsetDiff = (int) this.lifeOffsetValue.newHighValue();
        if (this.lifeOffsetValue.isRelative()) {
            return;
        }
        this.lifeOffsetDiff -= this.lifeOffset;
    }

    public void setPosition(float f, float f2) {
        if (this.attached) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            boolean[] zArr = this.active;
            int length = zArr.length;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    this.particles[i].translate(f3, f4);
                }
            }
        }
        this.x = f;
        this.y = f2;
    }

    public void setSprites(a<Sprite> aVar) {
        this.sprites = aVar;
        if (aVar.b == 0) {
            return;
        }
        int length = this.particles.length;
        for (int i = 0; i < length; i++) {
            Particle particle = this.particles[i];
            if (particle == null) {
                return;
            }
            Sprite sprite = null;
            switch (this.spriteMode) {
                case single:
                    sprite = aVar.c();
                    break;
                case animated:
                    particle.frame = Math.min((int) ((1.0f - (particle.currentLife / particle.life)) * aVar.b), aVar.b - 1);
                    sprite = aVar.a(particle.frame);
                    break;
                case random:
                    sprite = aVar.e();
                    break;
            }
            particle.setRegion(sprite);
            particle.setOrigin(sprite.getOriginX(), sprite.getOriginY());
        }
    }

    public void setSpriteMode(SpriteMode spriteMode) {
        this.spriteMode = spriteMode;
    }

    public void allowCompletion() {
        this.allowCompletion = true;
        this.durationTimer = this.duration;
    }

    public a<Sprite> getSprites() {
        return this.sprites;
    }

    public SpriteMode getSpriteMode() {
        return this.spriteMode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ScaledNumericValue getLife() {
        return this.lifeValue;
    }

    public ScaledNumericValue getXScale() {
        return this.xScaleValue;
    }

    public ScaledNumericValue getYScale() {
        return this.yScaleValue;
    }

    public ScaledNumericValue getRotation() {
        return this.rotationValue;
    }

    public GradientColorValue getTint() {
        return this.tintValue;
    }

    public ScaledNumericValue getVelocity() {
        return this.velocityValue;
    }

    public ScaledNumericValue getWind() {
        return this.windValue;
    }

    public ScaledNumericValue getGravity() {
        return this.gravityValue;
    }

    public ScaledNumericValue getAngle() {
        return this.angleValue;
    }

    public ScaledNumericValue getEmission() {
        return this.emissionValue;
    }

    public ScaledNumericValue getTransparency() {
        return this.transparencyValue;
    }

    public RangedNumericValue getDuration() {
        return this.durationValue;
    }

    public RangedNumericValue getDelay() {
        return this.delayValue;
    }

    public ScaledNumericValue getLifeOffset() {
        return this.lifeOffsetValue;
    }

    public RangedNumericValue getXOffsetValue() {
        return this.xOffsetValue;
    }

    public RangedNumericValue getYOffsetValue() {
        return this.yOffsetValue;
    }

    public ScaledNumericValue getSpawnWidth() {
        return this.spawnWidthValue;
    }

    public ScaledNumericValue getSpawnHeight() {
        return this.spawnHeightValue;
    }

    public SpawnShapeValue getSpawnShape() {
        return this.spawnShapeValue;
    }

    public boolean isAttached() {
        return this.attached;
    }

    public void setAttached(boolean z) {
        this.attached = z;
    }

    public boolean isContinuous() {
        return this.continuous;
    }

    public void setContinuous(boolean z) {
        this.continuous = z;
    }

    public boolean isAligned() {
        return this.aligned;
    }

    public void setAligned(boolean z) {
        this.aligned = z;
    }

    public boolean isAdditive() {
        return this.additive;
    }

    public void setAdditive(boolean z) {
        this.additive = z;
    }

    public boolean cleansUpBlendFunction() {
        return this.cleansUpBlendFunction;
    }

    public void setCleansUpBlendFunction(boolean z) {
        this.cleansUpBlendFunction = z;
    }

    public boolean isBehind() {
        return this.behind;
    }

    public void setBehind(boolean z) {
        this.behind = z;
    }

    public boolean isPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public void setPremultipliedAlpha(boolean z) {
        this.premultipliedAlpha = z;
    }

    public int getMinParticleCount() {
        return this.minParticleCount;
    }

    public void setMinParticleCount(int i) {
        this.minParticleCount = i;
    }

    public int getMaxParticleCount() {
        return this.maxParticleCount;
    }

    public boolean isComplete() {
        return (!this.continuous || this.allowCompletion) && this.delayTimer >= this.delay && this.durationTimer >= this.duration && this.activeCount == 0;
    }

    public float getPercentComplete() {
        if (this.delayTimer < this.delay) {
            return 0.0f;
        }
        return Math.min(1.0f, this.durationTimer / this.duration);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int getActiveCount() {
        return this.activeCount;
    }

    public a<String> getImagePaths() {
        return this.imagePaths;
    }

    public void setImagePaths(a<String> aVar) {
        this.imagePaths = aVar;
    }

    public void setFlip(boolean z, boolean z2) {
        this.flipX = z;
        this.flipY = z2;
        Particle[] particleArr = this.particles;
        if (particleArr == null) {
            return;
        }
        int length = particleArr.length;
        for (int i = 0; i < length; i++) {
            Particle particle = this.particles[i];
            if (particle != null) {
                particle.flip(z, z2);
            }
        }
    }

    public void flipY() {
        ScaledNumericValue scaledNumericValue = this.angleValue;
        scaledNumericValue.setHigh(-scaledNumericValue.getHighMin(), -this.angleValue.getHighMax());
        ScaledNumericValue scaledNumericValue2 = this.angleValue;
        scaledNumericValue2.setLow(-scaledNumericValue2.getLowMin(), -this.angleValue.getLowMax());
        ScaledNumericValue scaledNumericValue3 = this.gravityValue;
        scaledNumericValue3.setHigh(-scaledNumericValue3.getHighMin(), -this.gravityValue.getHighMax());
        ScaledNumericValue scaledNumericValue4 = this.gravityValue;
        scaledNumericValue4.setLow(-scaledNumericValue4.getLowMin(), -this.gravityValue.getLowMax());
        ScaledNumericValue scaledNumericValue5 = this.windValue;
        scaledNumericValue5.setHigh(-scaledNumericValue5.getHighMin(), -this.windValue.getHighMax());
        ScaledNumericValue scaledNumericValue6 = this.windValue;
        scaledNumericValue6.setLow(-scaledNumericValue6.getLowMin(), -this.windValue.getLowMax());
        ScaledNumericValue scaledNumericValue7 = this.rotationValue;
        scaledNumericValue7.setHigh(-scaledNumericValue7.getHighMin(), -this.rotationValue.getHighMax());
        ScaledNumericValue scaledNumericValue8 = this.rotationValue;
        scaledNumericValue8.setLow(-scaledNumericValue8.getLowMin(), -this.rotationValue.getLowMax());
        RangedNumericValue rangedNumericValue = this.yOffsetValue;
        rangedNumericValue.setLow(-rangedNumericValue.getLowMin(), -this.yOffsetValue.getLowMax());
    }

    public nz getBoundingBox() {
        if (this.bounds == null) {
            this.bounds = new nz();
        }
        Particle[] particleArr = this.particles;
        boolean[] zArr = this.active;
        nz nzVar = this.bounds;
        nzVar.a();
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (zArr[i]) {
                n boundingRectangle = particleArr[i].getBoundingRectangle();
                nzVar.a(boundingRectangle.x, boundingRectangle.y, 0.0f);
                nzVar.a(boundingRectangle.x + boundingRectangle.width, boundingRectangle.y + boundingRectangle.height, 0.0f);
            }
        }
        return nzVar;
    }

    protected RangedNumericValue[] getXSizeValues() {
        if (this.xSizeValues == null) {
            this.xSizeValues = new RangedNumericValue[3];
            RangedNumericValue[] rangedNumericValueArr = this.xSizeValues;
            rangedNumericValueArr[0] = this.xScaleValue;
            rangedNumericValueArr[1] = this.spawnWidthValue;
            rangedNumericValueArr[2] = this.xOffsetValue;
        }
        return this.xSizeValues;
    }

    protected RangedNumericValue[] getYSizeValues() {
        if (this.ySizeValues == null) {
            this.ySizeValues = new RangedNumericValue[3];
            RangedNumericValue[] rangedNumericValueArr = this.ySizeValues;
            rangedNumericValueArr[0] = this.yScaleValue;
            rangedNumericValueArr[1] = this.spawnHeightValue;
            rangedNumericValueArr[2] = this.yOffsetValue;
        }
        return this.ySizeValues;
    }

    protected RangedNumericValue[] getMotionValues() {
        if (this.motionValues == null) {
            this.motionValues = new RangedNumericValue[3];
            RangedNumericValue[] rangedNumericValueArr = this.motionValues;
            rangedNumericValueArr[0] = this.velocityValue;
            rangedNumericValueArr[1] = this.windValue;
            rangedNumericValueArr[2] = this.gravityValue;
        }
        return this.motionValues;
    }

    public void scaleSize(float f) {
        if (f == 1.0f) {
            return;
        }
        scaleSize(f, f);
    }

    public void scaleSize(float f, float f2) {
        if (f == 1.0f && f2 == 1.0f) {
            return;
        }
        for (RangedNumericValue rangedNumericValue : getXSizeValues()) {
            rangedNumericValue.scale(f);
        }
        for (RangedNumericValue rangedNumericValue2 : getYSizeValues()) {
            rangedNumericValue2.scale(f2);
        }
    }

    public void scaleMotion(float f) {
        if (f == 1.0f) {
            return;
        }
        for (RangedNumericValue rangedNumericValue : getMotionValues()) {
            rangedNumericValue.scale(f);
        }
    }

    public void matchSize(ParticleEmitter particleEmitter) {
        matchXSize(particleEmitter);
        matchYSize(particleEmitter);
    }

    public void matchXSize(ParticleEmitter particleEmitter) {
        RangedNumericValue[] xSizeValues = getXSizeValues();
        RangedNumericValue[] xSizeValues2 = particleEmitter.getXSizeValues();
        for (int i = 0; i < xSizeValues.length; i++) {
            xSizeValues[i].set(xSizeValues2[i]);
        }
    }

    public void matchYSize(ParticleEmitter particleEmitter) {
        RangedNumericValue[] ySizeValues = getYSizeValues();
        RangedNumericValue[] ySizeValues2 = particleEmitter.getYSizeValues();
        for (int i = 0; i < ySizeValues.length; i++) {
            ySizeValues[i].set(ySizeValues2[i]);
        }
    }

    public void matchMotion(ParticleEmitter particleEmitter) {
        RangedNumericValue[] motionValues = getMotionValues();
        RangedNumericValue[] motionValues2 = particleEmitter.getMotionValues();
        for (int i = 0; i < motionValues.length; i++) {
            motionValues[i].set(motionValues2[i]);
        }
    }

    public void save(Writer writer) throws IOException {
        writer.write(this.name + "\n");
        writer.write("- Delay -\n");
        this.delayValue.save(writer);
        writer.write("- Duration - \n");
        this.durationValue.save(writer);
        writer.write("- Count - \n");
        writer.write("min: " + this.minParticleCount + "\n");
        writer.write("max: " + this.maxParticleCount + "\n");
        writer.write("- Emission - \n");
        this.emissionValue.save(writer);
        writer.write("- Life - \n");
        this.lifeValue.save(writer);
        writer.write("- Life Offset - \n");
        this.lifeOffsetValue.save(writer);
        writer.write("- X Offset - \n");
        this.xOffsetValue.save(writer);
        writer.write("- Y Offset - \n");
        this.yOffsetValue.save(writer);
        writer.write("- Spawn Shape - \n");
        this.spawnShapeValue.save(writer);
        writer.write("- Spawn Width - \n");
        this.spawnWidthValue.save(writer);
        writer.write("- Spawn Height - \n");
        this.spawnHeightValue.save(writer);
        writer.write("- X Scale - \n");
        this.xScaleValue.save(writer);
        writer.write("- Y Scale - \n");
        this.yScaleValue.save(writer);
        writer.write("- Velocity - \n");
        this.velocityValue.save(writer);
        writer.write("- Angle - \n");
        this.angleValue.save(writer);
        writer.write("- Rotation - \n");
        this.rotationValue.save(writer);
        writer.write("- Wind - \n");
        this.windValue.save(writer);
        writer.write("- Gravity - \n");
        this.gravityValue.save(writer);
        writer.write("- Tint - \n");
        this.tintValue.save(writer);
        writer.write("- Transparency - \n");
        this.transparencyValue.save(writer);
        writer.write("- Options - \n");
        writer.write("attached: " + this.attached + "\n");
        writer.write("continuous: " + this.continuous + "\n");
        writer.write("aligned: " + this.aligned + "\n");
        writer.write("additive: " + this.additive + "\n");
        writer.write("behind: " + this.behind + "\n");
        writer.write("premultipliedAlpha: " + this.premultipliedAlpha + "\n");
        writer.write("spriteMode: " + this.spriteMode.toString() + "\n");
        writer.write("- Image Paths -\n");
        Iterator<String> it = this.imagePaths.iterator();
        while (it.hasNext()) {
            writer.write(it.next() + "\n");
        }
        writer.write("\n");
    }

    public void load(BufferedReader bufferedReader) throws IOException {
        try {
            this.name = readString(bufferedReader, "name");
            bufferedReader.readLine();
            this.delayValue.load(bufferedReader);
            bufferedReader.readLine();
            this.durationValue.load(bufferedReader);
            bufferedReader.readLine();
            setMinParticleCount(readInt(bufferedReader, "minParticleCount"));
            setMaxParticleCount(readInt(bufferedReader, "maxParticleCount"));
            bufferedReader.readLine();
            this.emissionValue.load(bufferedReader);
            bufferedReader.readLine();
            this.lifeValue.load(bufferedReader);
            bufferedReader.readLine();
            this.lifeOffsetValue.load(bufferedReader);
            bufferedReader.readLine();
            this.xOffsetValue.load(bufferedReader);
            bufferedReader.readLine();
            this.yOffsetValue.load(bufferedReader);
            bufferedReader.readLine();
            this.spawnShapeValue.load(bufferedReader);
            bufferedReader.readLine();
            this.spawnWidthValue.load(bufferedReader);
            bufferedReader.readLine();
            this.spawnHeightValue.load(bufferedReader);
            if (bufferedReader.readLine().trim().equals("- Scale -")) {
                this.xScaleValue.load(bufferedReader);
                this.yScaleValue.setActive(false);
            } else {
                this.xScaleValue.load(bufferedReader);
                bufferedReader.readLine();
                this.yScaleValue.load(bufferedReader);
            }
            bufferedReader.readLine();
            this.velocityValue.load(bufferedReader);
            bufferedReader.readLine();
            this.angleValue.load(bufferedReader);
            bufferedReader.readLine();
            this.rotationValue.load(bufferedReader);
            bufferedReader.readLine();
            this.windValue.load(bufferedReader);
            bufferedReader.readLine();
            this.gravityValue.load(bufferedReader);
            bufferedReader.readLine();
            this.tintValue.load(bufferedReader);
            bufferedReader.readLine();
            this.transparencyValue.load(bufferedReader);
            bufferedReader.readLine();
            this.attached = readBoolean(bufferedReader, "attached");
            this.continuous = readBoolean(bufferedReader, "continuous");
            this.aligned = readBoolean(bufferedReader, "aligned");
            this.additive = readBoolean(bufferedReader, "additive");
            this.behind = readBoolean(bufferedReader, "behind");
            String readLine = bufferedReader.readLine();
            if (readLine.startsWith("premultipliedAlpha")) {
                this.premultipliedAlpha = readBoolean(readLine);
                readLine = bufferedReader.readLine();
            }
            if (readLine.startsWith("spriteMode")) {
                this.spriteMode = SpriteMode.valueOf(readString(readLine));
                bufferedReader.readLine();
            }
            a<String> aVar = new a<>();
            while (true) {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 == null || readLine2.isEmpty()) {
                    break;
                }
                aVar.a((a<String>) readLine2);
            }
            setImagePaths(aVar);
        } catch (RuntimeException e) {
            if (this.name == null) {
                throw e;
            }
            throw new RuntimeException("Error parsing emitter: " + this.name, e);
        }
    }

    static String readString(String str) throws IOException {
        return str.substring(str.indexOf(":") + 1).trim();
    }

    static String readString(BufferedReader bufferedReader, String str) throws IOException {
        String readLine = bufferedReader.readLine();
        if (readLine == null) {
            throw new IOException("Missing value: " + str);
        }
        return readString(readLine);
    }

    static boolean readBoolean(String str) throws IOException {
        return Boolean.parseBoolean(readString(str));
    }

    static boolean readBoolean(BufferedReader bufferedReader, String str) throws IOException {
        return Boolean.parseBoolean(readString(bufferedReader, str));
    }

    static int readInt(BufferedReader bufferedReader, String str) throws IOException {
        return Integer.parseInt(readString(bufferedReader, str));
    }

    static float readFloat(BufferedReader bufferedReader, String str) throws IOException {
        return Float.parseFloat(readString(bufferedReader, str));
    }

    /* loaded from: classes.dex */
    public static class Particle extends Sprite {
        protected float angle;
        protected float angleCos;
        protected float angleDiff;
        protected float angleSin;
        protected int currentLife;
        protected int frame;
        protected float gravity;
        protected float gravityDiff;
        protected int life;
        protected float rotation;
        protected float rotationDiff;
        protected float[] tint;
        protected float transparency;
        protected float transparencyDiff;
        protected float velocity;
        protected float velocityDiff;
        protected float wind;
        protected float windDiff;
        protected float xScale;
        protected float xScaleDiff;
        protected float yScale;
        protected float yScaleDiff;

        public Particle(Sprite sprite) {
            super(sprite);
        }
    }

    /* loaded from: classes.dex */
    public static class ParticleValue {
        boolean active;
        boolean alwaysActive;

        public void setAlwaysActive(boolean z) {
            this.alwaysActive = z;
        }

        public boolean isAlwaysActive() {
            return this.alwaysActive;
        }

        public boolean isActive() {
            return this.alwaysActive || this.active;
        }

        public void setActive(boolean z) {
            this.active = z;
        }

        public void save(Writer writer) throws IOException {
            if (!this.alwaysActive) {
                writer.write("active: " + this.active + "\n");
                return;
            }
            this.active = true;
        }

        public void load(BufferedReader bufferedReader) throws IOException {
            if (!this.alwaysActive) {
                this.active = ParticleEmitter.readBoolean(bufferedReader, "active");
            } else {
                this.active = true;
            }
        }

        public void load(ParticleValue particleValue) {
            this.active = particleValue.active;
            this.alwaysActive = particleValue.alwaysActive;
        }
    }

    /* loaded from: classes.dex */
    public static class NumericValue extends ParticleValue {
        private float value;

        public float getValue() {
            return this.value;
        }

        public void setValue(float f) {
            this.value = f;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                writer.write("value: " + this.value + "\n");
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (this.active) {
                this.value = ParticleEmitter.readFloat(bufferedReader, "value");
            }
        }

        public void load(NumericValue numericValue) {
            super.load((ParticleValue) numericValue);
            this.value = numericValue.value;
        }
    }

    /* loaded from: classes.dex */
    public static class RangedNumericValue extends ParticleValue {
        private float lowMax;
        private float lowMin;

        public float newLowValue() {
            float f = this.lowMin;
            return f + ((this.lowMax - f) * h.a());
        }

        public void setLow(float f) {
            this.lowMin = f;
            this.lowMax = f;
        }

        public void setLow(float f, float f2) {
            this.lowMin = f;
            this.lowMax = f2;
        }

        public float getLowMin() {
            return this.lowMin;
        }

        public void setLowMin(float f) {
            this.lowMin = f;
        }

        public float getLowMax() {
            return this.lowMax;
        }

        public void setLowMax(float f) {
            this.lowMax = f;
        }

        public void scale(float f) {
            this.lowMin *= f;
            this.lowMax *= f;
        }

        public void set(RangedNumericValue rangedNumericValue) {
            this.lowMin = rangedNumericValue.lowMin;
            this.lowMax = rangedNumericValue.lowMax;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                writer.write("lowMin: " + this.lowMin + "\n");
                writer.write("lowMax: " + this.lowMax + "\n");
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (this.active) {
                this.lowMin = ParticleEmitter.readFloat(bufferedReader, "lowMin");
                this.lowMax = ParticleEmitter.readFloat(bufferedReader, "lowMax");
            }
        }

        public void load(RangedNumericValue rangedNumericValue) {
            super.load((ParticleValue) rangedNumericValue);
            this.lowMax = rangedNumericValue.lowMax;
            this.lowMin = rangedNumericValue.lowMin;
        }
    }

    /* loaded from: classes.dex */
    public static class ScaledNumericValue extends RangedNumericValue {
        private float highMax;
        private float highMin;
        private boolean relative;
        private float[] scaling = {1.0f};
        float[] timeline = {0.0f};

        public float newHighValue() {
            float f = this.highMin;
            return f + ((this.highMax - f) * h.a());
        }

        public void setHigh(float f) {
            this.highMin = f;
            this.highMax = f;
        }

        public void setHigh(float f, float f2) {
            this.highMin = f;
            this.highMax = f2;
        }

        public float getHighMin() {
            return this.highMin;
        }

        public void setHighMin(float f) {
            this.highMin = f;
        }

        public float getHighMax() {
            return this.highMax;
        }

        public void setHighMax(float f) {
            this.highMax = f;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue
        public void scale(float f) {
            super.scale(f);
            this.highMin *= f;
            this.highMax *= f;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue
        public void set(RangedNumericValue rangedNumericValue) {
            if (rangedNumericValue instanceof ScaledNumericValue) {
                set((ScaledNumericValue) rangedNumericValue);
            } else {
                super.set(rangedNumericValue);
            }
        }

        public void set(ScaledNumericValue scaledNumericValue) {
            super.set((RangedNumericValue) scaledNumericValue);
            this.highMin = scaledNumericValue.highMin;
            this.highMax = scaledNumericValue.highMax;
            float[] fArr = this.scaling;
            int length = fArr.length;
            float[] fArr2 = scaledNumericValue.scaling;
            if (length != fArr2.length) {
                this.scaling = Arrays.copyOf(fArr2, fArr2.length);
            } else {
                System.arraycopy(fArr2, 0, fArr, 0, fArr.length);
            }
            float[] fArr3 = this.timeline;
            int length2 = fArr3.length;
            float[] fArr4 = scaledNumericValue.timeline;
            if (length2 != fArr4.length) {
                this.timeline = Arrays.copyOf(fArr4, fArr4.length);
            } else {
                System.arraycopy(fArr4, 0, fArr3, 0, fArr3.length);
            }
            this.relative = scaledNumericValue.relative;
        }

        public float[] getScaling() {
            return this.scaling;
        }

        public void setScaling(float[] fArr) {
            this.scaling = fArr;
        }

        public float[] getTimeline() {
            return this.timeline;
        }

        public void setTimeline(float[] fArr) {
            this.timeline = fArr;
        }

        public boolean isRelative() {
            return this.relative;
        }

        public void setRelative(boolean z) {
            this.relative = z;
        }

        public float getScale(float f) {
            float[] fArr = this.timeline;
            int length = fArr.length;
            int i = 1;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (fArr[i] > f) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return this.scaling[length - 1];
            }
            float[] fArr2 = this.scaling;
            int i2 = i - 1;
            float f2 = fArr2[i2];
            float f3 = fArr[i2];
            return f2 + ((fArr2[i] - f2) * ((f - f3) / (fArr[i] - f3)));
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue, com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                writer.write("highMin: " + this.highMin + "\n");
                writer.write("highMax: " + this.highMax + "\n");
                writer.write("relative: " + this.relative + "\n");
                writer.write("scalingCount: " + this.scaling.length + "\n");
                for (int i = 0; i < this.scaling.length; i++) {
                    writer.write("scaling" + i + ": " + this.scaling[i] + "\n");
                }
                writer.write("timelineCount: " + this.timeline.length + "\n");
                for (int i2 = 0; i2 < this.timeline.length; i2++) {
                    writer.write("timeline" + i2 + ": " + this.timeline[i2] + "\n");
                }
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue, com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (!this.active) {
                return;
            }
            this.highMin = ParticleEmitter.readFloat(bufferedReader, "highMin");
            this.highMax = ParticleEmitter.readFloat(bufferedReader, "highMax");
            this.relative = ParticleEmitter.readBoolean(bufferedReader, "relative");
            this.scaling = new float[ParticleEmitter.readInt(bufferedReader, "scalingCount")];
            int i = 0;
            int i2 = 0;
            while (true) {
                float[] fArr = this.scaling;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = ParticleEmitter.readFloat(bufferedReader, "scaling" + i2);
                i2++;
            }
            this.timeline = new float[ParticleEmitter.readInt(bufferedReader, "timelineCount")];
            while (true) {
                float[] fArr2 = this.timeline;
                if (i >= fArr2.length) {
                    return;
                }
                fArr2[i] = ParticleEmitter.readFloat(bufferedReader, "timeline" + i);
                i++;
            }
        }

        public void load(ScaledNumericValue scaledNumericValue) {
            super.load((RangedNumericValue) scaledNumericValue);
            this.highMax = scaledNumericValue.highMax;
            this.highMin = scaledNumericValue.highMin;
            this.scaling = new float[scaledNumericValue.scaling.length];
            float[] fArr = scaledNumericValue.scaling;
            float[] fArr2 = this.scaling;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.timeline = new float[scaledNumericValue.timeline.length];
            float[] fArr3 = scaledNumericValue.timeline;
            float[] fArr4 = this.timeline;
            System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            this.relative = scaledNumericValue.relative;
        }
    }

    /* loaded from: classes.dex */
    public static class IndependentScaledNumericValue extends ScaledNumericValue {
        boolean independent;

        public boolean isIndependent() {
            return this.independent;
        }

        public void setIndependent(boolean z) {
            this.independent = z;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue, com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue
        public void set(RangedNumericValue rangedNumericValue) {
            if (rangedNumericValue instanceof IndependentScaledNumericValue) {
                set((IndependentScaledNumericValue) rangedNumericValue);
            } else {
                super.set(rangedNumericValue);
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue
        public void set(ScaledNumericValue scaledNumericValue) {
            if (scaledNumericValue instanceof IndependentScaledNumericValue) {
                set((IndependentScaledNumericValue) scaledNumericValue);
            } else {
                super.set(scaledNumericValue);
            }
        }

        public void set(IndependentScaledNumericValue independentScaledNumericValue) {
            super.set((ScaledNumericValue) independentScaledNumericValue);
            this.independent = independentScaledNumericValue.independent;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue, com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue, com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(Writer writer) throws IOException {
            super.save(writer);
            writer.write("independent: " + this.independent + "\n");
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ScaledNumericValue, com.badlogic.gdx.graphics.g2d.ParticleEmitter.RangedNumericValue, com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            bufferedReader.mark(100);
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                throw new IOException("Missing value: independent");
            }
            if (readLine.contains("independent")) {
                this.independent = Boolean.parseBoolean(ParticleEmitter.readString(readLine));
            } else {
                bufferedReader.reset();
            }
        }

        public void load(IndependentScaledNumericValue independentScaledNumericValue) {
            super.load((ScaledNumericValue) independentScaledNumericValue);
            this.independent = independentScaledNumericValue.independent;
        }
    }

    /* loaded from: classes.dex */
    public static class GradientColorValue extends ParticleValue {
        private static float[] temp = new float[4];
        private float[] colors = {1.0f, 1.0f, 1.0f};
        float[] timeline = {0.0f};

        public GradientColorValue() {
            this.alwaysActive = true;
        }

        public float[] getTimeline() {
            return this.timeline;
        }

        public void setTimeline(float[] fArr) {
            this.timeline = fArr;
        }

        public float[] getColors() {
            return this.colors;
        }

        public void setColors(float[] fArr) {
            this.colors = fArr;
        }

        public float[] getColor(float f) {
            float[] fArr = this.timeline;
            int length = fArr.length;
            int i = 0;
            int i2 = 1;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                } else if (fArr[i2] > f) {
                    break;
                } else {
                    i = i2;
                    i2++;
                }
            }
            float f2 = fArr[i];
            int i3 = i * 3;
            float[] fArr2 = this.colors;
            float f3 = fArr2[i3];
            float f4 = fArr2[i3 + 1];
            float f5 = fArr2[i3 + 2];
            if (i2 == -1) {
                float[] fArr3 = temp;
                fArr3[0] = f3;
                fArr3[1] = f4;
                fArr3[2] = f5;
                return fArr3;
            }
            float f6 = (f - f2) / (fArr[i2] - f2);
            int i4 = i2 * 3;
            float[] fArr4 = temp;
            fArr4[0] = f3 + ((fArr2[i4] - f3) * f6);
            fArr4[1] = f4 + ((fArr2[i4 + 1] - f4) * f6);
            fArr4[2] = f5 + ((fArr2[i4 + 2] - f5) * f6);
            return fArr4;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                writer.write("colorsCount: " + this.colors.length + "\n");
                for (int i = 0; i < this.colors.length; i++) {
                    writer.write("colors" + i + ": " + this.colors[i] + "\n");
                }
                writer.write("timelineCount: " + this.timeline.length + "\n");
                for (int i2 = 0; i2 < this.timeline.length; i2++) {
                    writer.write("timeline" + i2 + ": " + this.timeline[i2] + "\n");
                }
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (!this.active) {
                return;
            }
            this.colors = new float[ParticleEmitter.readInt(bufferedReader, "colorsCount")];
            int i = 0;
            int i2 = 0;
            while (true) {
                float[] fArr = this.colors;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = ParticleEmitter.readFloat(bufferedReader, "colors" + i2);
                i2++;
            }
            this.timeline = new float[ParticleEmitter.readInt(bufferedReader, "timelineCount")];
            while (true) {
                float[] fArr2 = this.timeline;
                if (i >= fArr2.length) {
                    return;
                }
                fArr2[i] = ParticleEmitter.readFloat(bufferedReader, "timeline" + i);
                i++;
            }
        }

        public void load(GradientColorValue gradientColorValue) {
            super.load((ParticleValue) gradientColorValue);
            this.colors = new float[gradientColorValue.colors.length];
            float[] fArr = gradientColorValue.colors;
            float[] fArr2 = this.colors;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.timeline = new float[gradientColorValue.timeline.length];
            float[] fArr3 = gradientColorValue.timeline;
            float[] fArr4 = this.timeline;
            System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
        }
    }

    /* loaded from: classes.dex */
    public static class SpawnShapeValue extends ParticleValue {
        boolean edges;
        SpawnShape shape = SpawnShape.point;
        SpawnEllipseSide side = SpawnEllipseSide.both;

        public SpawnShape getShape() {
            return this.shape;
        }

        public void setShape(SpawnShape spawnShape) {
            this.shape = spawnShape;
        }

        public boolean isEdges() {
            return this.edges;
        }

        public void setEdges(boolean z) {
            this.edges = z;
        }

        public SpawnEllipseSide getSide() {
            return this.side;
        }

        public void setSide(SpawnEllipseSide spawnEllipseSide) {
            this.side = spawnEllipseSide;
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                writer.write("shape: " + this.shape + "\n");
                if (this.shape == SpawnShape.ellipse) {
                    writer.write("edges: " + this.edges + "\n");
                    writer.write("side: " + this.side + "\n");
                }
            }
        }

        @Override // com.badlogic.gdx.graphics.g2d.ParticleEmitter.ParticleValue
        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (this.active) {
                this.shape = SpawnShape.valueOf(ParticleEmitter.readString(bufferedReader, "shape"));
                if (this.shape == SpawnShape.ellipse) {
                    this.edges = ParticleEmitter.readBoolean(bufferedReader, "edges");
                    this.side = SpawnEllipseSide.valueOf(ParticleEmitter.readString(bufferedReader, "side"));
                }
            }
        }

        public void load(SpawnShapeValue spawnShapeValue) {
            super.load((ParticleValue) spawnShapeValue);
            this.shape = spawnShapeValue.shape;
            this.edges = spawnShapeValue.edges;
            this.side = spawnShapeValue.side;
        }
    }
}
