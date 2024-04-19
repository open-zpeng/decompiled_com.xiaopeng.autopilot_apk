package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.utils.k;
import defpackage.ko;
/* loaded from: classes.dex */
public class NinePatch {
    public static final int BOTTOM_CENTER = 7;
    public static final int BOTTOM_LEFT = 6;
    public static final int BOTTOM_RIGHT = 8;
    public static final int MIDDLE_CENTER = 4;
    public static final int MIDDLE_LEFT = 3;
    public static final int MIDDLE_RIGHT = 5;
    public static final int TOP_CENTER = 1;
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 2;
    private static final ka tmpDrawColor = new ka();
    private int bottomCenter;
    private float bottomHeight;
    private int bottomLeft;
    private int bottomRight;
    private final ka color;
    private int idx;
    private float leftWidth;
    private int middleCenter;
    private float middleHeight;
    private int middleLeft;
    private int middleRight;
    private float middleWidth;
    private float padBottom;
    private float padLeft;
    private float padRight;
    private float padTop;
    private float rightWidth;
    private ko texture;
    private int topCenter;
    private float topHeight;
    private int topLeft;
    private int topRight;
    private float[] vertices;

    public NinePatch(ko koVar, int i, int i2, int i3, int i4) {
        this(new TextureRegion(koVar), i, i2, i3, i4);
    }

    public NinePatch(TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        this.bottomLeft = -1;
        this.bottomCenter = -1;
        this.bottomRight = -1;
        this.middleLeft = -1;
        this.middleCenter = -1;
        this.middleRight = -1;
        this.topLeft = -1;
        this.topCenter = -1;
        this.topRight = -1;
        this.vertices = new float[180];
        this.color = new ka(ka.a);
        this.padLeft = -1.0f;
        this.padRight = -1.0f;
        this.padTop = -1.0f;
        this.padBottom = -1.0f;
        if (textureRegion == null) {
            throw new IllegalArgumentException("region cannot be null.");
        }
        int regionWidth = (textureRegion.getRegionWidth() - i) - i2;
        int regionHeight = (textureRegion.getRegionHeight() - i3) - i4;
        TextureRegion[] textureRegionArr = new TextureRegion[9];
        if (i3 > 0) {
            if (i > 0) {
                textureRegionArr[0] = new TextureRegion(textureRegion, 0, 0, i, i3);
            }
            if (regionWidth > 0) {
                textureRegionArr[1] = new TextureRegion(textureRegion, i, 0, regionWidth, i3);
            }
            if (i2 > 0) {
                textureRegionArr[2] = new TextureRegion(textureRegion, i + regionWidth, 0, i2, i3);
            }
        }
        if (regionHeight > 0) {
            if (i > 0) {
                textureRegionArr[3] = new TextureRegion(textureRegion, 0, i3, i, regionHeight);
            }
            if (regionWidth > 0) {
                textureRegionArr[4] = new TextureRegion(textureRegion, i, i3, regionWidth, regionHeight);
            }
            if (i2 > 0) {
                textureRegionArr[5] = new TextureRegion(textureRegion, i + regionWidth, i3, i2, regionHeight);
            }
        }
        if (i4 > 0) {
            if (i > 0) {
                textureRegionArr[6] = new TextureRegion(textureRegion, 0, i3 + regionHeight, i, i4);
            }
            if (regionWidth > 0) {
                textureRegionArr[7] = new TextureRegion(textureRegion, i, i3 + regionHeight, regionWidth, i4);
            }
            if (i2 > 0) {
                textureRegionArr[8] = new TextureRegion(textureRegion, i + regionWidth, i3 + regionHeight, i2, i4);
            }
        }
        if (i == 0 && regionWidth == 0) {
            textureRegionArr[1] = textureRegionArr[2];
            textureRegionArr[4] = textureRegionArr[5];
            textureRegionArr[7] = textureRegionArr[8];
            textureRegionArr[2] = null;
            textureRegionArr[5] = null;
            textureRegionArr[8] = null;
        }
        if (i3 == 0 && regionHeight == 0) {
            textureRegionArr[3] = textureRegionArr[6];
            textureRegionArr[4] = textureRegionArr[7];
            textureRegionArr[5] = textureRegionArr[8];
            textureRegionArr[6] = null;
            textureRegionArr[7] = null;
            textureRegionArr[8] = null;
        }
        load(textureRegionArr);
    }

    public NinePatch(ko koVar, ka kaVar) {
        this(koVar);
        setColor(kaVar);
    }

    public NinePatch(ko koVar) {
        this(new TextureRegion(koVar));
    }

    public NinePatch(TextureRegion textureRegion, ka kaVar) {
        this(textureRegion);
        setColor(kaVar);
    }

    public NinePatch(TextureRegion textureRegion) {
        this.bottomLeft = -1;
        this.bottomCenter = -1;
        this.bottomRight = -1;
        this.middleLeft = -1;
        this.middleCenter = -1;
        this.middleRight = -1;
        this.topLeft = -1;
        this.topCenter = -1;
        this.topRight = -1;
        this.vertices = new float[180];
        this.color = new ka(ka.a);
        this.padLeft = -1.0f;
        this.padRight = -1.0f;
        this.padTop = -1.0f;
        this.padBottom = -1.0f;
        load(new TextureRegion[]{null, null, null, null, textureRegion, null, null, null, null});
    }

    public NinePatch(TextureRegion... textureRegionArr) {
        this.bottomLeft = -1;
        this.bottomCenter = -1;
        this.bottomRight = -1;
        this.middleLeft = -1;
        this.middleCenter = -1;
        this.middleRight = -1;
        this.topLeft = -1;
        this.topCenter = -1;
        this.topRight = -1;
        this.vertices = new float[180];
        this.color = new ka(ka.a);
        this.padLeft = -1.0f;
        this.padRight = -1.0f;
        this.padTop = -1.0f;
        this.padBottom = -1.0f;
        if (textureRegionArr == null || textureRegionArr.length != 9) {
            throw new IllegalArgumentException("NinePatch needs nine TextureRegions");
        }
        load(textureRegionArr);
        float leftWidth = getLeftWidth();
        if ((textureRegionArr[0] != null && textureRegionArr[0].getRegionWidth() != leftWidth) || ((textureRegionArr[3] != null && textureRegionArr[3].getRegionWidth() != leftWidth) || (textureRegionArr[6] != null && textureRegionArr[6].getRegionWidth() != leftWidth))) {
            throw new k("Left side patches must have the same width");
        }
        float rightWidth = getRightWidth();
        if ((textureRegionArr[2] != null && textureRegionArr[2].getRegionWidth() != rightWidth) || ((textureRegionArr[5] != null && textureRegionArr[5].getRegionWidth() != rightWidth) || (textureRegionArr[8] != null && textureRegionArr[8].getRegionWidth() != rightWidth))) {
            throw new k("Right side patches must have the same width");
        }
        float bottomHeight = getBottomHeight();
        if ((textureRegionArr[6] != null && textureRegionArr[6].getRegionHeight() != bottomHeight) || ((textureRegionArr[7] != null && textureRegionArr[7].getRegionHeight() != bottomHeight) || (textureRegionArr[8] != null && textureRegionArr[8].getRegionHeight() != bottomHeight))) {
            throw new k("Bottom side patches must have the same height");
        }
        float topHeight = getTopHeight();
        if ((textureRegionArr[0] != null && textureRegionArr[0].getRegionHeight() != topHeight) || ((textureRegionArr[1] != null && textureRegionArr[1].getRegionHeight() != topHeight) || (textureRegionArr[2] != null && textureRegionArr[2].getRegionHeight() != topHeight))) {
            throw new k("Top side patches must have the same height");
        }
    }

    public NinePatch(NinePatch ninePatch) {
        this(ninePatch, ninePatch.color);
    }

    public NinePatch(NinePatch ninePatch, ka kaVar) {
        this.bottomLeft = -1;
        this.bottomCenter = -1;
        this.bottomRight = -1;
        this.middleLeft = -1;
        this.middleCenter = -1;
        this.middleRight = -1;
        this.topLeft = -1;
        this.topCenter = -1;
        this.topRight = -1;
        this.vertices = new float[180];
        this.color = new ka(ka.a);
        this.padLeft = -1.0f;
        this.padRight = -1.0f;
        this.padTop = -1.0f;
        this.padBottom = -1.0f;
        this.texture = ninePatch.texture;
        this.bottomLeft = ninePatch.bottomLeft;
        this.bottomCenter = ninePatch.bottomCenter;
        this.bottomRight = ninePatch.bottomRight;
        this.middleLeft = ninePatch.middleLeft;
        this.middleCenter = ninePatch.middleCenter;
        this.middleRight = ninePatch.middleRight;
        this.topLeft = ninePatch.topLeft;
        this.topCenter = ninePatch.topCenter;
        this.topRight = ninePatch.topRight;
        this.leftWidth = ninePatch.leftWidth;
        this.rightWidth = ninePatch.rightWidth;
        this.middleWidth = ninePatch.middleWidth;
        this.middleHeight = ninePatch.middleHeight;
        this.topHeight = ninePatch.topHeight;
        this.bottomHeight = ninePatch.bottomHeight;
        this.padLeft = ninePatch.padLeft;
        this.padTop = ninePatch.padTop;
        this.padBottom = ninePatch.padBottom;
        this.padRight = ninePatch.padRight;
        this.vertices = new float[ninePatch.vertices.length];
        float[] fArr = ninePatch.vertices;
        System.arraycopy(fArr, 0, this.vertices, 0, fArr.length);
        this.idx = ninePatch.idx;
        this.color.a(kaVar);
    }

    private void load(TextureRegion[] textureRegionArr) {
        float f = ka.f;
        if (textureRegionArr[6] != null) {
            this.bottomLeft = add(textureRegionArr[6], f, false, false);
            this.leftWidth = textureRegionArr[6].getRegionWidth();
            this.bottomHeight = textureRegionArr[6].getRegionHeight();
        }
        if (textureRegionArr[7] != null) {
            this.bottomCenter = add(textureRegionArr[7], f, true, false);
            this.middleWidth = Math.max(this.middleWidth, textureRegionArr[7].getRegionWidth());
            this.bottomHeight = Math.max(this.bottomHeight, textureRegionArr[7].getRegionHeight());
        }
        if (textureRegionArr[8] != null) {
            this.bottomRight = add(textureRegionArr[8], f, false, false);
            this.rightWidth = Math.max(this.rightWidth, textureRegionArr[8].getRegionWidth());
            this.bottomHeight = Math.max(this.bottomHeight, textureRegionArr[8].getRegionHeight());
        }
        if (textureRegionArr[3] != null) {
            this.middleLeft = add(textureRegionArr[3], f, false, true);
            this.leftWidth = Math.max(this.leftWidth, textureRegionArr[3].getRegionWidth());
            this.middleHeight = Math.max(this.middleHeight, textureRegionArr[3].getRegionHeight());
        }
        if (textureRegionArr[4] != null) {
            this.middleCenter = add(textureRegionArr[4], f, true, true);
            this.middleWidth = Math.max(this.middleWidth, textureRegionArr[4].getRegionWidth());
            this.middleHeight = Math.max(this.middleHeight, textureRegionArr[4].getRegionHeight());
        }
        if (textureRegionArr[5] != null) {
            this.middleRight = add(textureRegionArr[5], f, false, true);
            this.rightWidth = Math.max(this.rightWidth, textureRegionArr[5].getRegionWidth());
            this.middleHeight = Math.max(this.middleHeight, textureRegionArr[5].getRegionHeight());
        }
        if (textureRegionArr[0] != null) {
            this.topLeft = add(textureRegionArr[0], f, false, false);
            this.leftWidth = Math.max(this.leftWidth, textureRegionArr[0].getRegionWidth());
            this.topHeight = Math.max(this.topHeight, textureRegionArr[0].getRegionHeight());
        }
        if (textureRegionArr[1] != null) {
            this.topCenter = add(textureRegionArr[1], f, true, false);
            this.middleWidth = Math.max(this.middleWidth, textureRegionArr[1].getRegionWidth());
            this.topHeight = Math.max(this.topHeight, textureRegionArr[1].getRegionHeight());
        }
        if (textureRegionArr[2] != null) {
            this.topRight = add(textureRegionArr[2], f, false, false);
            this.rightWidth = Math.max(this.rightWidth, textureRegionArr[2].getRegionWidth());
            this.topHeight = Math.max(this.topHeight, textureRegionArr[2].getRegionHeight());
        }
        int i = this.idx;
        float[] fArr = this.vertices;
        if (i < fArr.length) {
            float[] fArr2 = new float[i];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.vertices = fArr2;
        }
    }

    private int add(TextureRegion textureRegion, float f, boolean z, boolean z2) {
        ko koVar = this.texture;
        if (koVar == null) {
            this.texture = textureRegion.getTexture();
        } else if (koVar != textureRegion.getTexture()) {
            throw new IllegalArgumentException("All regions must be from the same texture.");
        }
        float f2 = textureRegion.u;
        float f3 = textureRegion.v2;
        float f4 = textureRegion.u2;
        float f5 = textureRegion.v;
        if (this.texture.getMagFilter() == ko.a.Linear || this.texture.getMinFilter() == ko.a.Linear) {
            if (z) {
                float width = 0.5f / this.texture.getWidth();
                f2 += width;
                f4 -= width;
            }
            if (z2) {
                float height = 0.5f / this.texture.getHeight();
                f3 -= height;
                f5 += height;
            }
        }
        float[] fArr = this.vertices;
        int i = this.idx;
        fArr[i + 2] = f;
        fArr[i + 3] = f2;
        fArr[i + 4] = f3;
        fArr[i + 7] = f;
        fArr[i + 8] = f2;
        fArr[i + 9] = f5;
        fArr[i + 12] = f;
        fArr[i + 13] = f4;
        fArr[i + 14] = f5;
        fArr[i + 17] = f;
        fArr[i + 18] = f4;
        fArr[i + 19] = f3;
        this.idx = i + 20;
        return this.idx - 20;
    }

    private void set(int i, float f, float f2, float f3, float f4, float f5) {
        float f6 = f3 + f;
        float f7 = f4 + f2;
        float[] fArr = this.vertices;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f5;
        fArr[i + 5] = f;
        fArr[i + 6] = f7;
        fArr[i + 7] = f5;
        fArr[i + 10] = f6;
        fArr[i + 11] = f7;
        fArr[i + 12] = f5;
        fArr[i + 15] = f6;
        fArr[i + 16] = f2;
        fArr[i + 17] = f5;
    }

    private void prepareVertices(Batch batch, float f, float f2, float f3, float f4) {
        float f5 = f + this.leftWidth;
        float f6 = f + f3;
        float f7 = f6 - this.rightWidth;
        float f8 = f2 + this.bottomHeight;
        float f9 = f2 + f4;
        float f10 = f9 - this.topHeight;
        float b = tmpDrawColor.a(this.color).b(batch.getColor()).b();
        int i = this.bottomLeft;
        if (i != -1) {
            set(i, f, f2, f5 - f, f8 - f2, b);
        }
        int i2 = this.bottomCenter;
        if (i2 != -1) {
            set(i2, f5, f2, f7 - f5, f8 - f2, b);
        }
        int i3 = this.bottomRight;
        if (i3 != -1) {
            set(i3, f7, f2, f6 - f7, f8 - f2, b);
        }
        int i4 = this.middleLeft;
        if (i4 != -1) {
            set(i4, f, f8, f5 - f, f10 - f8, b);
        }
        int i5 = this.middleCenter;
        if (i5 != -1) {
            set(i5, f5, f8, f7 - f5, f10 - f8, b);
        }
        int i6 = this.middleRight;
        if (i6 != -1) {
            set(i6, f7, f8, f6 - f7, f10 - f8, b);
        }
        int i7 = this.topLeft;
        if (i7 != -1) {
            set(i7, f, f10, f5 - f, f9 - f10, b);
        }
        int i8 = this.topCenter;
        if (i8 != -1) {
            set(i8, f5, f10, f7 - f5, f9 - f10, b);
        }
        int i9 = this.topRight;
        if (i9 != -1) {
            set(i9, f7, f10, f6 - f7, f9 - f10, b);
        }
    }

    public void draw(Batch batch, float f, float f2, float f3, float f4) {
        prepareVertices(batch, f, f2, f3, f4);
        batch.draw(this.texture, this.vertices, 0, this.idx);
    }

    public void draw(Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        prepareVertices(batch, f, f2, f5, f6);
        float f10 = f + f3;
        float f11 = f2 + f4;
        int i = this.idx;
        float[] fArr = this.vertices;
        if (f9 != 0.0f) {
            for (int i2 = 0; i2 < i; i2 += 5) {
                float f12 = (fArr[i2] - f10) * f7;
                int i3 = i2 + 1;
                float f13 = (fArr[i3] - f11) * f8;
                float d = h.d(f9);
                float c = h.c(f9);
                fArr[i2] = ((d * f12) - (c * f13)) + f10;
                fArr[i3] = (c * f12) + (d * f13) + f11;
            }
        } else if (f7 != 1.0f || f8 != 1.0f) {
            for (int i4 = 0; i4 < i; i4 += 5) {
                fArr[i4] = ((fArr[i4] - f10) * f7) + f10;
                int i5 = i4 + 1;
                fArr[i5] = ((fArr[i5] - f11) * f8) + f11;
            }
        }
        batch.draw(this.texture, fArr, 0, i);
    }

    public void setColor(ka kaVar) {
        this.color.a(kaVar);
    }

    public ka getColor() {
        return this.color;
    }

    public float getLeftWidth() {
        return this.leftWidth;
    }

    public void setLeftWidth(float f) {
        this.leftWidth = f;
    }

    public float getRightWidth() {
        return this.rightWidth;
    }

    public void setRightWidth(float f) {
        this.rightWidth = f;
    }

    public float getTopHeight() {
        return this.topHeight;
    }

    public void setTopHeight(float f) {
        this.topHeight = f;
    }

    public float getBottomHeight() {
        return this.bottomHeight;
    }

    public void setBottomHeight(float f) {
        this.bottomHeight = f;
    }

    public float getMiddleWidth() {
        return this.middleWidth;
    }

    public void setMiddleWidth(float f) {
        this.middleWidth = f;
    }

    public float getMiddleHeight() {
        return this.middleHeight;
    }

    public void setMiddleHeight(float f) {
        this.middleHeight = f;
    }

    public float getTotalWidth() {
        return this.leftWidth + this.middleWidth + this.rightWidth;
    }

    public float getTotalHeight() {
        return this.topHeight + this.middleHeight + this.bottomHeight;
    }

    public void setPadding(float f, float f2, float f3, float f4) {
        this.padLeft = f;
        this.padRight = f2;
        this.padTop = f3;
        this.padBottom = f4;
    }

    public float getPadLeft() {
        float f = this.padLeft;
        return f == -1.0f ? getLeftWidth() : f;
    }

    public void setPadLeft(float f) {
        this.padLeft = f;
    }

    public float getPadRight() {
        float f = this.padRight;
        return f == -1.0f ? getRightWidth() : f;
    }

    public void setPadRight(float f) {
        this.padRight = f;
    }

    public float getPadTop() {
        float f = this.padTop;
        return f == -1.0f ? getTopHeight() : f;
    }

    public void setPadTop(float f) {
        this.padTop = f;
    }

    public float getPadBottom() {
        float f = this.padBottom;
        return f == -1.0f ? getBottomHeight() : f;
    }

    public void setPadBottom(float f) {
        this.padBottom = f;
    }

    public void scale(float f, float f2) {
        this.leftWidth *= f;
        this.rightWidth *= f;
        this.topHeight *= f2;
        this.bottomHeight *= f2;
        this.middleWidth *= f;
        this.middleHeight *= f2;
        float f3 = this.padLeft;
        if (f3 != -1.0f) {
            this.padLeft = f3 * f;
        }
        float f4 = this.padRight;
        if (f4 != -1.0f) {
            this.padRight = f4 * f;
        }
        float f5 = this.padTop;
        if (f5 != -1.0f) {
            this.padTop = f5 * f2;
        }
        float f6 = this.padBottom;
        if (f6 != -1.0f) {
            this.padBottom = f6 * f2;
        }
    }

    public ko getTexture() {
        return this.texture;
    }
}
