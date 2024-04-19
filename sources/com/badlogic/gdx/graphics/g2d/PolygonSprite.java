package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.h;
import com.badlogic.gdx.math.n;
/* loaded from: classes.dex */
public class PolygonSprite {
    private boolean dirty;
    private float height;
    private float originX;
    private float originY;
    PolygonRegion region;
    private float rotation;
    private float[] vertices;
    private float width;
    private float x;
    private float y;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private n bounds = new n();
    private final ka color = new ka(1.0f, 1.0f, 1.0f, 1.0f);

    public PolygonSprite(PolygonRegion polygonRegion) {
        setRegion(polygonRegion);
        setSize(polygonRegion.region.regionWidth, polygonRegion.region.regionHeight);
        setOrigin(this.width / 2.0f, this.height / 2.0f);
    }

    public PolygonSprite(PolygonSprite polygonSprite) {
        set(polygonSprite);
    }

    public void set(PolygonSprite polygonSprite) {
        if (polygonSprite == null) {
            throw new IllegalArgumentException("sprite cannot be null.");
        }
        setRegion(polygonSprite.region);
        this.x = polygonSprite.x;
        this.y = polygonSprite.y;
        this.width = polygonSprite.width;
        this.height = polygonSprite.height;
        this.originX = polygonSprite.originX;
        this.originY = polygonSprite.originY;
        this.rotation = polygonSprite.rotation;
        this.scaleX = polygonSprite.scaleX;
        this.scaleY = polygonSprite.scaleY;
        this.color.a(polygonSprite.color);
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
        this.dirty = true;
    }

    public void setSize(float f, float f2) {
        this.width = f;
        this.height = f2;
        this.dirty = true;
    }

    public void setPosition(float f, float f2) {
        translate(f - this.x, f2 - this.y);
    }

    public void setX(float f) {
        translateX(f - this.x);
    }

    public void setY(float f) {
        translateY(f - this.y);
    }

    public void translateX(float f) {
        this.x += f;
        if (this.dirty) {
            return;
        }
        float[] fArr = this.vertices;
        for (int i = 0; i < fArr.length; i += 5) {
            fArr[i] = fArr[i] + f;
        }
    }

    public void translateY(float f) {
        this.y += f;
        if (this.dirty) {
            return;
        }
        float[] fArr = this.vertices;
        for (int i = 1; i < fArr.length; i += 5) {
            fArr[i] = fArr[i] + f;
        }
    }

    public void translate(float f, float f2) {
        this.x += f;
        this.y += f2;
        if (this.dirty) {
            return;
        }
        float[] fArr = this.vertices;
        for (int i = 0; i < fArr.length; i += 5) {
            fArr[i] = fArr[i] + f;
            int i2 = i + 1;
            fArr[i2] = fArr[i2] + f2;
        }
    }

    public void setColor(ka kaVar) {
        this.color.a(kaVar);
        float b = kaVar.b();
        float[] fArr = this.vertices;
        for (int i = 2; i < fArr.length; i += 5) {
            fArr[i] = b;
        }
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.color.a(f, f2, f3, f4);
        float b = this.color.b();
        float[] fArr = this.vertices;
        for (int i = 2; i < fArr.length; i += 5) {
            fArr[i] = b;
        }
    }

    public void setOrigin(float f, float f2) {
        this.originX = f;
        this.originY = f2;
        this.dirty = true;
    }

    public void setRotation(float f) {
        this.rotation = f;
        this.dirty = true;
    }

    public void rotate(float f) {
        this.rotation += f;
        this.dirty = true;
    }

    public void setScale(float f) {
        this.scaleX = f;
        this.scaleY = f;
        this.dirty = true;
    }

    public void setScale(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
        this.dirty = true;
    }

    public void scale(float f) {
        this.scaleX += f;
        this.scaleY += f;
        this.dirty = true;
    }

    public float[] getVertices() {
        if (this.dirty) {
            int i = 0;
            this.dirty = false;
            float f = this.originX;
            float f2 = this.originY;
            float f3 = this.scaleX;
            float f4 = this.scaleY;
            PolygonRegion polygonRegion = this.region;
            float[] fArr = this.vertices;
            float[] fArr2 = polygonRegion.vertices;
            float f5 = this.x + f;
            float f6 = this.y + f2;
            float regionWidth = this.width / polygonRegion.region.getRegionWidth();
            float regionHeight = this.height / polygonRegion.region.getRegionHeight();
            float d = h.d(this.rotation);
            float c = h.c(this.rotation);
            int length = fArr2.length;
            int i2 = 0;
            while (i < length) {
                float f7 = ((fArr2[i] * regionWidth) - f) * f3;
                float f8 = ((fArr2[i + 1] * regionHeight) - f2) * f4;
                fArr[i2] = ((d * f7) - (c * f8)) + f5;
                fArr[i2 + 1] = (f7 * c) + (f8 * d) + f6;
                i += 2;
                i2 += 5;
            }
            return fArr;
        }
        return this.vertices;
    }

    public n getBoundingRectangle() {
        float[] vertices = getVertices();
        float f = vertices[0];
        float f2 = vertices[1];
        float f3 = vertices[0];
        float f4 = vertices[1];
        for (int i = 5; i < vertices.length; i += 5) {
            float f5 = vertices[i];
            float f6 = vertices[i + 1];
            if (f > f5) {
                f = f5;
            }
            if (f3 < f5) {
                f3 = f5;
            }
            if (f2 > f6) {
                f2 = f6;
            }
            if (f4 < f6) {
                f4 = f6;
            }
        }
        n nVar = this.bounds;
        nVar.x = f;
        nVar.y = f2;
        nVar.width = f3 - f;
        nVar.height = f4 - f2;
        return nVar;
    }

    public void draw(PolygonSpriteBatch polygonSpriteBatch) {
        PolygonRegion polygonRegion = this.region;
        polygonSpriteBatch.draw(polygonRegion.region.texture, getVertices(), 0, this.vertices.length, polygonRegion.triangles, 0, polygonRegion.triangles.length);
    }

    public void draw(PolygonSpriteBatch polygonSpriteBatch, float f) {
        ka color = getColor();
        float f2 = color.M;
        color.M *= f;
        setColor(color);
        draw(polygonSpriteBatch);
        color.M = f2;
        setColor(color);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getOriginX() {
        return this.originX;
    }

    public float getOriginY() {
        return this.originY;
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public ka getColor() {
        return this.color;
    }

    public ka getPackedColor() {
        ka.a(this.color, this.vertices[2]);
        return this.color;
    }

    public void setRegion(PolygonRegion polygonRegion) {
        this.region = polygonRegion;
        float[] fArr = polygonRegion.vertices;
        float[] fArr2 = polygonRegion.textureCoords;
        int length = (fArr.length / 2) * 5;
        float[] fArr3 = this.vertices;
        if (fArr3 == null || fArr3.length != length) {
            this.vertices = new float[length];
        }
        float b = this.color.b();
        float[] fArr4 = this.vertices;
        int i = 0;
        for (int i2 = 2; i2 < length; i2 += 5) {
            fArr4[i2] = b;
            fArr4[i2 + 1] = fArr2[i];
            fArr4[i2 + 2] = fArr2[i + 1];
            i += 2;
        }
        this.dirty = true;
    }

    public PolygonRegion getRegion() {
        return this.region;
    }
}
