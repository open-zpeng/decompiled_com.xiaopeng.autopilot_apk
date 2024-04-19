package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.q;
import com.badlogic.gdx.utils.a;
import defpackage.ko;
import java.util.Iterator;
/* loaded from: classes.dex */
public class DistanceFieldFont extends BitmapFont {
    private float distanceFieldSmoothing;

    public DistanceFieldFont(BitmapFont.BitmapFontData bitmapFontData, a<TextureRegion> aVar, boolean z) {
        super(bitmapFontData, aVar, z);
    }

    public DistanceFieldFont(BitmapFont.BitmapFontData bitmapFontData, TextureRegion textureRegion, boolean z) {
        super(bitmapFontData, textureRegion, z);
    }

    public DistanceFieldFont(jy jyVar, boolean z) {
        super(jyVar, z);
    }

    public DistanceFieldFont(jy jyVar, jy jyVar2, boolean z, boolean z2) {
        super(jyVar, jyVar2, z, z2);
    }

    public DistanceFieldFont(jy jyVar, jy jyVar2, boolean z) {
        super(jyVar, jyVar2, z);
    }

    public DistanceFieldFont(jy jyVar, TextureRegion textureRegion, boolean z) {
        super(jyVar, textureRegion, z);
    }

    public DistanceFieldFont(jy jyVar, TextureRegion textureRegion) {
        super(jyVar, textureRegion);
    }

    public DistanceFieldFont(jy jyVar) {
        super(jyVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.badlogic.gdx.graphics.g2d.BitmapFont
    public void load(BitmapFont.BitmapFontData bitmapFontData) {
        super.load(bitmapFontData);
        Iterator<TextureRegion> it = getRegions().iterator();
        while (it.hasNext()) {
            it.next().getTexture().setFilter(ko.a.Linear, ko.a.Linear);
        }
    }

    @Override // com.badlogic.gdx.graphics.g2d.BitmapFont
    public BitmapFontCache newFontCache() {
        return new DistanceFieldFontCache(this, this.integer);
    }

    public float getDistanceFieldSmoothing() {
        return this.distanceFieldSmoothing;
    }

    public void setDistanceFieldSmoothing(float f) {
        this.distanceFieldSmoothing = f;
    }

    public static q createDistanceFieldShader() {
        q qVar = new q("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tv_color = a_color;\n\tv_color.a = v_color.a * (255.0/254.0);\n\tv_texCoords = a_texCoord0;\n\tgl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n\tprecision mediump float;\n\tprecision mediump int;\n#endif\n\nuniform sampler2D u_texture;\nuniform float u_smoothing;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tif (u_smoothing > 0.0) {\n\t\tfloat smoothing = 0.25 / u_smoothing;\n\t\tfloat distance = texture2D(u_texture, v_texCoords).a;\n\t\tfloat alpha = smoothstep(0.5 - smoothing, 0.5 + smoothing, distance);\n\t\tgl_FragColor = vec4(v_color.rgb, alpha * v_color.a);\n\t} else {\n\t\tgl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n\t}\n}\n");
        if (qVar.c()) {
            return qVar;
        }
        throw new IllegalArgumentException("Error compiling distance field shader: " + qVar.b());
    }

    /* loaded from: classes.dex */
    private static class DistanceFieldFontCache extends BitmapFontCache {
        public DistanceFieldFontCache(DistanceFieldFont distanceFieldFont) {
            super(distanceFieldFont, distanceFieldFont.usesIntegerPositions());
        }

        public DistanceFieldFontCache(DistanceFieldFont distanceFieldFont, boolean z) {
            super(distanceFieldFont, z);
        }

        private float getSmoothingFactor() {
            DistanceFieldFont distanceFieldFont = (DistanceFieldFont) super.getFont();
            return distanceFieldFont.getDistanceFieldSmoothing() * distanceFieldFont.getScaleX();
        }

        private void setSmoothingUniform(Batch batch, float f) {
            batch.flush();
            batch.getShader().a("u_smoothing", f);
        }

        @Override // com.badlogic.gdx.graphics.g2d.BitmapFontCache
        public void draw(Batch batch) {
            setSmoothingUniform(batch, getSmoothingFactor());
            super.draw(batch);
            setSmoothingUniform(batch, 0.0f);
        }

        @Override // com.badlogic.gdx.graphics.g2d.BitmapFontCache
        public void draw(Batch batch, int i, int i2) {
            setSmoothingUniform(batch, getSmoothingFactor());
            super.draw(batch, i, i2);
            setSmoothingUniform(batch, 0.0f);
        }
    }
}
