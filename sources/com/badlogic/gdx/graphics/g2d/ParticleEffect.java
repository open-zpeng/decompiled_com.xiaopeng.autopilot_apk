package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ak;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.v;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ParticleEffect implements g {
    private nz bounds;
    private final a<ParticleEmitter> emitters;
    protected float motionScale;
    private boolean ownsTexture;
    protected float xSizeScale;
    protected float ySizeScale;

    public ParticleEffect() {
        this.xSizeScale = 1.0f;
        this.ySizeScale = 1.0f;
        this.motionScale = 1.0f;
        this.emitters = new a<>(8);
    }

    public ParticleEffect(ParticleEffect particleEffect) {
        this.xSizeScale = 1.0f;
        this.ySizeScale = 1.0f;
        this.motionScale = 1.0f;
        this.emitters = new a<>(true, particleEffect.emitters.b);
        int i = particleEffect.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a((a<ParticleEmitter>) newEmitter(particleEffect.emitters.a(i2)));
        }
    }

    public void start() {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).start();
        }
    }

    public void reset() {
        reset(true);
    }

    public void reset(boolean z) {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).reset();
        }
        if (z) {
            if (this.xSizeScale == 1.0f && this.ySizeScale == 1.0f && this.motionScale == 1.0f) {
                return;
            }
            scaleEffect(1.0f / this.xSizeScale, 1.0f / this.ySizeScale, 1.0f / this.motionScale);
            this.motionScale = 1.0f;
            this.ySizeScale = 1.0f;
            this.xSizeScale = 1.0f;
        }
    }

    public void update(float f) {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).update(f);
        }
    }

    public void draw(Batch batch) {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).draw(batch);
        }
    }

    public void draw(Batch batch, float f) {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).draw(batch, f);
        }
    }

    public void allowCompletion() {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).allowCompletion();
        }
    }

    public boolean isComplete() {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (!this.emitters.a(i2).isComplete()) {
                return false;
            }
        }
        return true;
    }

    public void setDuration(int i) {
        int i2 = this.emitters.b;
        for (int i3 = 0; i3 < i2; i3++) {
            ParticleEmitter a = this.emitters.a(i3);
            a.setContinuous(false);
            a.duration = i;
            a.durationTimer = 0.0f;
        }
    }

    public void setPosition(float f, float f2) {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).setPosition(f, f2);
        }
    }

    public void setFlip(boolean z, boolean z2) {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).setFlip(z, z2);
        }
    }

    public void flipY() {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).flipY();
        }
    }

    public a<ParticleEmitter> getEmitters() {
        return this.emitters;
    }

    public ParticleEmitter findEmitter(String str) {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            ParticleEmitter a = this.emitters.a(i2);
            if (a.getName().equals(str)) {
                return a;
            }
        }
        return null;
    }

    public void save(Writer writer) throws IOException {
        int i = this.emitters.b;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            ParticleEmitter a = this.emitters.a(i2);
            int i4 = i3 + 1;
            if (i3 > 0) {
                writer.write("\n");
            }
            a.save(writer);
            i2++;
            i3 = i4;
        }
    }

    public void load(jy jyVar, jy jyVar2) {
        loadEmitters(jyVar);
        loadEmitterImages(jyVar2);
    }

    public void load(jy jyVar, TextureAtlas textureAtlas) {
        load(jyVar, textureAtlas, null);
    }

    public void load(jy jyVar, TextureAtlas textureAtlas, String str) {
        loadEmitters(jyVar);
        loadEmitterImages(textureAtlas, str);
    }

    public void loadEmitters(jy jyVar) {
        InputStream read = jyVar.read();
        this.emitters.d();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(read), IInputController.KEYCODE_BACK_BUTTON);
                do {
                    try {
                        this.emitters.a((a<ParticleEmitter>) newEmitter(bufferedReader2));
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        throw new k("Error loading effect: " + jyVar, e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        ak.a(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader2.readLine() != null);
                ak.a(bufferedReader2);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void loadEmitterImages(TextureAtlas textureAtlas) {
        loadEmitterImages(textureAtlas, null);
    }

    public void loadEmitterImages(TextureAtlas textureAtlas, String str) {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            ParticleEmitter a = this.emitters.a(i2);
            if (a.getImagePaths().b != 0) {
                a<Sprite> aVar = new a<>();
                Iterator<String> it = a.getImagePaths().iterator();
                while (it.hasNext()) {
                    String name = new File(it.next().replace('\\', '/')).getName();
                    int lastIndexOf = name.lastIndexOf(46);
                    if (lastIndexOf != -1) {
                        name = name.substring(0, lastIndexOf);
                    }
                    if (str != null) {
                        name = str + name;
                    }
                    Sprite createSprite = textureAtlas.createSprite(name);
                    if (createSprite == null) {
                        throw new IllegalArgumentException("SpriteSheet missing image: " + name);
                    }
                    aVar.a((a<Sprite>) createSprite);
                }
                a.setSprites(aVar);
            }
        }
    }

    public void loadEmitterImages(jy jyVar) {
        this.ownsTexture = true;
        v vVar = new v(this.emitters.b);
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            ParticleEmitter a = this.emitters.a(i2);
            if (a.getImagePaths().b != 0) {
                a<Sprite> aVar = new a<>();
                Iterator<String> it = a.getImagePaths().iterator();
                while (it.hasNext()) {
                    String name = new File(it.next().replace('\\', '/')).getName();
                    Sprite sprite = (Sprite) vVar.a((v) name);
                    if (sprite == null) {
                        sprite = new Sprite(loadTexture(jyVar.child(name)));
                        vVar.a((v) name, (String) sprite);
                    }
                    aVar.a((a<Sprite>) sprite);
                }
                a.setSprites(aVar);
            }
        }
    }

    protected ParticleEmitter newEmitter(BufferedReader bufferedReader) throws IOException {
        return new ParticleEmitter(bufferedReader);
    }

    protected ParticleEmitter newEmitter(ParticleEmitter particleEmitter) {
        return new ParticleEmitter(particleEmitter);
    }

    protected ko loadTexture(jy jyVar) {
        return new ko(jyVar, false);
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        if (this.ownsTexture) {
            int i = this.emitters.b;
            for (int i2 = 0; i2 < i; i2++) {
                Iterator<Sprite> it = this.emitters.a(i2).getSprites().iterator();
                while (it.hasNext()) {
                    it.next().getTexture().dispose();
                }
            }
        }
    }

    public nz getBoundingBox() {
        if (this.bounds == null) {
            this.bounds = new nz();
        }
        nz nzVar = this.bounds;
        nzVar.a();
        Iterator<ParticleEmitter> it = this.emitters.iterator();
        while (it.hasNext()) {
            nzVar.a(it.next().getBoundingBox());
        }
        return nzVar;
    }

    public void scaleEffect(float f) {
        scaleEffect(f, f, f);
    }

    public void scaleEffect(float f, float f2) {
        scaleEffect(f, f, f2);
    }

    public void scaleEffect(float f, float f2, float f3) {
        this.xSizeScale *= f;
        this.ySizeScale *= f2;
        this.motionScale *= f3;
        Iterator<ParticleEmitter> it = this.emitters.iterator();
        while (it.hasNext()) {
            ParticleEmitter next = it.next();
            next.scaleSize(f, f2);
            next.scaleMotion(f3);
        }
    }

    public void setEmittersCleanUpBlendFunction(boolean z) {
        int i = this.emitters.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.a(i2).setCleansUpBlendFunction(z);
        }
    }
}
