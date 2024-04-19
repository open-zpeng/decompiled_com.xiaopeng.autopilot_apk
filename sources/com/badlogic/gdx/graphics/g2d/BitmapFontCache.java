package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.aa;
import com.badlogic.gdx.utils.h;
import com.badlogic.gdx.utils.m;
import com.badlogic.gdx.utils.t;
/* loaded from: classes.dex */
public class BitmapFontCache {
    private static final ka tempColor = new ka(1.0f, 1.0f, 1.0f, 1.0f);
    private final ka color;
    private float currentTint;
    private final BitmapFont font;
    private int glyphCount;
    private int[] idx;
    private boolean integer;
    private final a<GlyphLayout> layouts;
    private m[] pageGlyphIndices;
    private float[][] pageVertices;
    private final a<GlyphLayout> pooledLayouts;
    private int[] tempGlyphCount;
    private float x;
    private float y;

    public BitmapFontCache(BitmapFont bitmapFont) {
        this(bitmapFont, bitmapFont.usesIntegerPositions());
    }

    public BitmapFontCache(BitmapFont bitmapFont, boolean z) {
        this.layouts = new a<>();
        this.pooledLayouts = new a<>();
        this.color = new ka(1.0f, 1.0f, 1.0f, 1.0f);
        this.font = bitmapFont;
        this.integer = z;
        int i = bitmapFont.regions.b;
        if (i == 0) {
            throw new IllegalArgumentException("The specified font must contain at least one texture page.");
        }
        this.pageVertices = new float[i];
        this.idx = new int[i];
        if (i > 1) {
            this.pageGlyphIndices = new m[i];
            int length = this.pageGlyphIndices.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.pageGlyphIndices[i2] = new m();
            }
        }
        this.tempGlyphCount = new int[i];
    }

    public void setPosition(float f, float f2) {
        translate(f - this.x, f2 - this.y);
    }

    public void translate(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        if (this.integer) {
            f = Math.round(f);
            f2 = Math.round(f2);
        }
        this.x += f;
        this.y += f2;
        float[][] fArr = this.pageVertices;
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            float[] fArr2 = fArr[i];
            int i2 = this.idx[i];
            for (int i3 = 0; i3 < i2; i3 += 5) {
                fArr2[i3] = fArr2[i3] + f;
                int i4 = i3 + 1;
                fArr2[i4] = fArr2[i4] + f2;
            }
        }
    }

    public void tint(ka kaVar) {
        float b = kaVar.b();
        if (this.currentTint == b) {
            return;
        }
        this.currentTint = b;
        int[] iArr = this.tempGlyphCount;
        int length = iArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = 0;
        }
        int i3 = this.layouts.b;
        int i4 = 0;
        while (i4 < i3) {
            GlyphLayout a = this.layouts.a(i4);
            int i5 = a.runs.b;
            int i6 = i;
            while (i6 < i5) {
                GlyphLayout.GlyphRun a2 = a.runs.a(i6);
                a<BitmapFont.Glyph> aVar = a2.glyphs;
                float b2 = tempColor.a(a2.color).b(kaVar).b();
                int i7 = aVar.b;
                for (int i8 = i; i8 < i7; i8++) {
                    int i9 = aVar.a(i8).page;
                    int i10 = (iArr[i9] * 20) + 2;
                    iArr[i9] = iArr[i9] + 1;
                    float[] fArr = this.pageVertices[i9];
                    for (int i11 = 0; i11 < 20; i11 += 5) {
                        fArr[i10 + i11] = b2;
                    }
                }
                i6++;
                i = 0;
            }
            i4++;
            i = 0;
        }
    }

    public void setAlphas(float f) {
        int i = ((int) (f * 254.0f)) << 24;
        int length = this.pageVertices.length;
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        while (i2 < length) {
            float[] fArr = this.pageVertices[i2];
            int i3 = this.idx[i2];
            float f4 = f3;
            float f5 = f2;
            for (int i4 = 2; i4 < i3; i4 += 5) {
                float f6 = fArr[i4];
                if (f6 == f5 && i4 != 2) {
                    fArr[i4] = f4;
                } else {
                    f4 = t.a((t.c(f6) & 16777215) | i);
                    fArr[i4] = f4;
                    f5 = f6;
                }
            }
            i2++;
            f2 = f5;
            f3 = f4;
        }
    }

    public void setColors(float f) {
        int length = this.pageVertices.length;
        for (int i = 0; i < length; i++) {
            float[] fArr = this.pageVertices[i];
            int i2 = this.idx[i];
            for (int i3 = 2; i3 < i2; i3 += 5) {
                fArr[i3] = f;
            }
        }
    }

    public void setColors(ka kaVar) {
        setColors(kaVar.b());
    }

    public void setColors(float f, float f2, float f3, float f4) {
        int i = ((int) (f2 * 255.0f)) << 8;
        int i2 = (int) (f * 255.0f);
        setColors(t.a(i2 | i | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 24)));
    }

    public void setColors(ka kaVar, int i, int i2) {
        setColors(kaVar.b(), i, i2);
    }

    public void setColors(float f, int i, int i2) {
        float[][] fArr = this.pageVertices;
        if (fArr.length == 1) {
            float[] fArr2 = fArr[0];
            int i3 = i2 * 20;
            for (int i4 = (i * 20) + 2; i4 < i3; i4 += 5) {
                fArr2[i4] = f;
            }
            return;
        }
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            float[] fArr3 = this.pageVertices[i5];
            m mVar = this.pageGlyphIndices[i5];
            int i6 = mVar.b;
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = mVar.a[i7];
                if (i8 >= i2) {
                    break;
                }
                if (i8 >= i) {
                    for (int i9 = 0; i9 < 20; i9 += 5) {
                        fArr3[(i7 * 20) + 2 + i9] = f;
                    }
                }
            }
        }
    }

    public ka getColor() {
        return this.color;
    }

    public void setColor(ka kaVar) {
        this.color.a(kaVar);
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.color.a(f, f2, f3, f4);
    }

    public void draw(Batch batch) {
        a<TextureRegion> regions = this.font.getRegions();
        int length = this.pageVertices.length;
        for (int i = 0; i < length; i++) {
            if (this.idx[i] > 0) {
                batch.draw(regions.a(i).getTexture(), this.pageVertices[i], 0, this.idx[i]);
            }
        }
    }

    public void draw(Batch batch, int i, int i2) {
        if (this.pageVertices.length == 1) {
            batch.draw(this.font.getRegion().getTexture(), this.pageVertices[0], i * 20, (i2 - i) * 20);
            return;
        }
        a<TextureRegion> regions = this.font.getRegions();
        int length = this.pageVertices.length;
        for (int i3 = 0; i3 < length; i3++) {
            m mVar = this.pageGlyphIndices[i3];
            int i4 = mVar.b;
            int i5 = 0;
            int i6 = -1;
            for (int i7 = 0; i7 < i4; i7++) {
                int b = mVar.b(i7);
                if (b >= i2) {
                    break;
                }
                if (i6 == -1 && b >= i) {
                    i6 = i7;
                }
                if (b >= i) {
                    i5++;
                }
            }
            if (i6 != -1 && i5 != 0) {
                batch.draw(regions.a(i3).getTexture(), this.pageVertices[i3], i6 * 20, i5 * 20);
            }
        }
    }

    public void draw(Batch batch, float f) {
        if (f == 1.0f) {
            draw(batch);
            return;
        }
        ka color = getColor();
        float f2 = color.M;
        color.M *= f;
        setColors(color);
        draw(batch);
        color.M = f2;
        setColors(color);
    }

    public void clear() {
        this.x = 0.0f;
        this.y = 0.0f;
        aa.a((a) this.pooledLayouts, true);
        this.pooledLayouts.d();
        this.layouts.d();
        int length = this.idx.length;
        for (int i = 0; i < length; i++) {
            m[] mVarArr = this.pageGlyphIndices;
            if (mVarArr != null) {
                mVarArr[i].b();
            }
            this.idx[i] = 0;
        }
    }

    private void requireGlyphs(GlyphLayout glyphLayout) {
        if (this.pageVertices.length == 1) {
            int i = glyphLayout.runs.b;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                i2 += glyphLayout.runs.a(i3).glyphs.b;
            }
            requirePageGlyphs(0, i2);
            return;
        }
        int[] iArr = this.tempGlyphCount;
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = 0;
        }
        int i5 = glyphLayout.runs.b;
        for (int i6 = 0; i6 < i5; i6++) {
            a<BitmapFont.Glyph> aVar = glyphLayout.runs.a(i6).glyphs;
            int i7 = aVar.b;
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = aVar.a(i8).page;
                iArr[i9] = iArr[i9] + 1;
            }
        }
        int length2 = iArr.length;
        for (int i10 = 0; i10 < length2; i10++) {
            requirePageGlyphs(i10, iArr[i10]);
        }
    }

    private void requirePageGlyphs(int i, int i2) {
        m[] mVarArr = this.pageGlyphIndices;
        if (mVarArr != null && i2 > mVarArr[i].a.length) {
            m[] mVarArr2 = this.pageGlyphIndices;
            mVarArr2[i].d(i2 - mVarArr2[i].a.length);
        }
        int[] iArr = this.idx;
        int i3 = iArr[i] + (i2 * 20);
        float[][] fArr = this.pageVertices;
        float[] fArr2 = fArr[i];
        if (fArr2 == null) {
            fArr[i] = new float[i3];
        } else if (fArr2.length < i3) {
            float[] fArr3 = new float[i3];
            System.arraycopy(fArr2, 0, fArr3, 0, iArr[i]);
            this.pageVertices[i] = fArr3;
        }
    }

    private void addToCache(GlyphLayout glyphLayout, float f, float f2) {
        int i;
        int i2 = this.font.regions.b;
        float[][] fArr = this.pageVertices;
        if (fArr.length < i2) {
            float[][] fArr2 = new float[i2];
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            this.pageVertices = fArr2;
            int[] iArr = new int[i2];
            int[] iArr2 = this.idx;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            this.idx = iArr;
            m[] mVarArr = new m[i2];
            m[] mVarArr2 = this.pageGlyphIndices;
            if (mVarArr2 != null) {
                i = mVarArr2.length;
                System.arraycopy(mVarArr2, 0, mVarArr, 0, mVarArr2.length);
            } else {
                i = 0;
            }
            while (i < i2) {
                mVarArr[i] = new m();
                i++;
            }
            this.pageGlyphIndices = mVarArr;
            this.tempGlyphCount = new int[i2];
        }
        this.layouts.a((a<GlyphLayout>) glyphLayout);
        requireGlyphs(glyphLayout);
        int i3 = glyphLayout.runs.b;
        for (int i4 = 0; i4 < i3; i4++) {
            GlyphLayout.GlyphRun a = glyphLayout.runs.a(i4);
            a<BitmapFont.Glyph> aVar = a.glyphs;
            h hVar = a.xAdvances;
            float b = a.color.b();
            float f3 = a.y + f2;
            int i5 = aVar.b;
            float f4 = a.x + f;
            for (int i6 = 0; i6 < i5; i6++) {
                f4 += hVar.a(i6);
                addGlyph(aVar.a(i6), f4, f3, b);
            }
        }
        this.currentTint = ka.f;
    }

    private void addGlyph(BitmapFont.Glyph glyph, float f, float f2, float f3) {
        float f4 = this.font.data.scaleX;
        float f5 = this.font.data.scaleY;
        float f6 = f + (glyph.xoffset * f4);
        float f7 = f2 + (glyph.yoffset * f5);
        float f8 = glyph.width * f4;
        float f9 = glyph.height * f5;
        float f10 = glyph.u;
        float f11 = glyph.u2;
        float f12 = glyph.v;
        float f13 = glyph.v2;
        if (this.integer) {
            f6 = Math.round(f6);
            f7 = Math.round(f7);
            f8 = Math.round(f8);
            f9 = Math.round(f9);
        }
        float f14 = f8 + f6;
        float f15 = f9 + f7;
        int i = glyph.page;
        int[] iArr = this.idx;
        int i2 = iArr[i];
        iArr[i] = iArr[i] + 20;
        m[] mVarArr = this.pageGlyphIndices;
        if (mVarArr != null) {
            m mVar = mVarArr[i];
            int i3 = this.glyphCount;
            this.glyphCount = i3 + 1;
            mVar.a(i3);
        }
        float[] fArr = this.pageVertices[i];
        int i4 = i2 + 1;
        fArr[i2] = f6;
        int i5 = i4 + 1;
        fArr[i4] = f7;
        int i6 = i5 + 1;
        fArr[i5] = f3;
        int i7 = i6 + 1;
        fArr[i6] = f10;
        int i8 = i7 + 1;
        fArr[i7] = f12;
        int i9 = i8 + 1;
        fArr[i8] = f6;
        int i10 = i9 + 1;
        fArr[i9] = f15;
        int i11 = i10 + 1;
        fArr[i10] = f3;
        int i12 = i11 + 1;
        fArr[i11] = f10;
        int i13 = i12 + 1;
        fArr[i12] = f13;
        int i14 = i13 + 1;
        fArr[i13] = f14;
        int i15 = i14 + 1;
        fArr[i14] = f15;
        int i16 = i15 + 1;
        fArr[i15] = f3;
        int i17 = i16 + 1;
        fArr[i16] = f11;
        int i18 = i17 + 1;
        fArr[i17] = f13;
        int i19 = i18 + 1;
        fArr[i18] = f14;
        int i20 = i19 + 1;
        fArr[i19] = f7;
        int i21 = i20 + 1;
        fArr[i20] = f3;
        fArr[i21] = f11;
        fArr[i21 + 1] = f12;
    }

    public GlyphLayout setText(CharSequence charSequence, float f, float f2) {
        clear();
        return addText(charSequence, f, f2, 0, charSequence.length(), 0.0f, 8, false);
    }

    public GlyphLayout setText(CharSequence charSequence, float f, float f2, float f3, int i, boolean z) {
        clear();
        return addText(charSequence, f, f2, 0, charSequence.length(), f3, i, z);
    }

    public GlyphLayout setText(CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z) {
        clear();
        return addText(charSequence, f, f2, i, i2, f3, i3, z);
    }

    public GlyphLayout setText(CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z, String str) {
        clear();
        return addText(charSequence, f, f2, i, i2, f3, i3, z, str);
    }

    public void setText(GlyphLayout glyphLayout, float f, float f2) {
        clear();
        addText(glyphLayout, f, f2);
    }

    public GlyphLayout addText(CharSequence charSequence, float f, float f2) {
        return addText(charSequence, f, f2, 0, charSequence.length(), 0.0f, 8, false, null);
    }

    public GlyphLayout addText(CharSequence charSequence, float f, float f2, float f3, int i, boolean z) {
        return addText(charSequence, f, f2, 0, charSequence.length(), f3, i, z, null);
    }

    public GlyphLayout addText(CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z) {
        return addText(charSequence, f, f2, i, i2, f3, i3, z, null);
    }

    public GlyphLayout addText(CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z, String str) {
        GlyphLayout glyphLayout = (GlyphLayout) aa.b(GlyphLayout.class);
        this.pooledLayouts.a((a<GlyphLayout>) glyphLayout);
        glyphLayout.setText(this.font, charSequence, i, i2, this.color, f3, i3, z, str);
        addText(glyphLayout, f, f2);
        return glyphLayout;
    }

    public void addText(GlyphLayout glyphLayout, float f, float f2) {
        addToCache(glyphLayout, f, f2 + this.font.data.ascent);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public BitmapFont getFont() {
        return this.font;
    }

    public void setUseIntegerPositions(boolean z) {
        this.integer = z;
    }

    public boolean usesIntegerPositions() {
        return this.integer;
    }

    public float[] getVertices() {
        return getVertices(0);
    }

    public float[] getVertices(int i) {
        return this.pageVertices[i];
    }

    public int getVertexCount(int i) {
        return this.idx[i];
    }

    public a<GlyphLayout> getLayouts() {
        return this.layouts;
    }
}
