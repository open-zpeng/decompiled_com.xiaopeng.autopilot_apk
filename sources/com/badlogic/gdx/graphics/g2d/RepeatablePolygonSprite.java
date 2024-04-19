package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.c;
import com.badlogic.gdx.math.g;
import com.badlogic.gdx.math.k;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.a;
/* loaded from: classes.dex */
public class RepeatablePolygonSprite {
    private int cols;
    private float density;
    private float gridHeight;
    private float gridWidth;
    private TextureRegion region;
    private int rows;
    private boolean dirty = true;
    private a<float[]> parts = new a<>();
    private a<float[]> vertices = new a<>();
    private a<short[]> indices = new a<>();
    public float x = 0.0f;
    public float y = 0.0f;
    private ka color = ka.a;
    private o offset = new o();

    public void setPolygon(TextureRegion textureRegion, float[] fArr) {
        setPolygon(textureRegion, fArr, -1.0f);
    }

    public void setPolygon(TextureRegion textureRegion, float[] fArr, float f) {
        this.region = textureRegion;
        k kVar = new k(offset(fArr));
        k kVar2 = new k();
        k kVar3 = new k();
        c cVar = new c();
        n c = kVar.c();
        float width = f == -1.0f ? c.getWidth() / textureRegion.getRegionWidth() : f;
        this.cols = (int) Math.ceil(width);
        this.gridWidth = c.getWidth() / width;
        this.gridHeight = (textureRegion.getRegionHeight() / textureRegion.getRegionWidth()) * this.gridWidth;
        this.rows = (int) Math.ceil(c.getHeight() / this.gridHeight);
        for (int i = 0; i < this.cols; i++) {
            int i2 = 0;
            while (i2 < this.rows) {
                float f2 = i;
                float f3 = this.gridWidth;
                float f4 = i2;
                float f5 = this.gridHeight;
                i2++;
                float f6 = i2;
                float f7 = i + 1;
                kVar2.a(new float[]{f2 * f3, f4 * f5, f2 * f3, f6 * f5, f7 * f3, f6 * f5, f7 * f3, f4 * f5});
                g.a(kVar, kVar2, kVar3);
                float[] a = kVar3.a();
                if (a.length > 0) {
                    this.parts.a((a<float[]>) snapToGrid(a));
                    this.indices.a((a<short[]>) cVar.a(a).b());
                } else {
                    this.parts.a((a<float[]>) null);
                }
            }
        }
        buildVertices();
    }

    private float[] snapToGrid(float[] fArr) {
        for (int i = 0; i < fArr.length; i += 2) {
            float f = (fArr[i] / this.gridWidth) % 1.0f;
            int i2 = i + 1;
            float f2 = (fArr[i2] / this.gridHeight) % 1.0f;
            if (f > 0.99f || f < 0.01f) {
                float f3 = this.gridWidth;
                fArr[i] = f3 * Math.round(fArr[i] / f3);
            }
            if (f2 > 0.99f || f2 < 0.01f) {
                float f4 = this.gridHeight;
                fArr[i2] = f4 * Math.round(fArr[i2] / f4);
            }
        }
        return fArr;
    }

    private float[] offset(float[] fArr) {
        this.offset.a(fArr[0], fArr[1]);
        for (int i = 0; i < fArr.length - 1; i += 2) {
            if (this.offset.d > fArr[i]) {
                this.offset.d = fArr[i];
            }
            int i2 = i + 1;
            if (this.offset.e > fArr[i2]) {
                this.offset.e = fArr[i2];
            }
        }
        for (int i3 = 0; i3 < fArr.length; i3 += 2) {
            fArr[i3] = fArr[i3] - this.offset.d;
            int i4 = i3 + 1;
            fArr[i4] = fArr[i4] - this.offset.e;
        }
        return fArr;
    }

    private void buildVertices() {
        this.vertices.d();
        for (int i = 0; i < this.parts.b; i++) {
            float[] a = this.parts.a(i);
            if (a != null) {
                float[] fArr = new float[(a.length * 5) / 2];
                int i2 = this.rows;
                int i3 = i / i2;
                int i4 = i % i2;
                int i5 = 0;
                int i6 = 0;
                while (i5 < a.length) {
                    int i7 = i6 + 1;
                    fArr[i6] = a[i5] + this.offset.d + this.x;
                    int i8 = i7 + 1;
                    int i9 = i5 + 1;
                    fArr[i7] = a[i9] + this.offset.e + this.y;
                    int i10 = i8 + 1;
                    fArr[i8] = this.color.b();
                    float f = a[i5];
                    float f2 = this.gridWidth;
                    float f3 = (f % f2) / f2;
                    float f4 = a[i9];
                    float f5 = this.gridHeight;
                    float f6 = (f4 % f5) / f5;
                    if (a[i5] == i3 * f2) {
                        f3 = 0.0f;
                    }
                    if (a[i5] == (i3 + 1) * this.gridWidth) {
                        f3 = 1.0f;
                    }
                    float f7 = a[i9] == ((float) i4) * this.gridHeight ? 0.0f : f6;
                    if (a[i9] == (i4 + 1) * this.gridHeight) {
                        f7 = 1.0f;
                    }
                    float u = this.region.getU() + ((this.region.getU2() - this.region.getU()) * f3);
                    float v = this.region.getV() + ((this.region.getV2() - this.region.getV()) * f7);
                    int i11 = i10 + 1;
                    fArr[i10] = u;
                    fArr[i11] = v;
                    i5 += 2;
                    i6 = i11 + 1;
                }
                this.vertices.a((a<float[]>) fArr);
            }
        }
        this.dirty = false;
    }

    public void draw(PolygonSpriteBatch polygonSpriteBatch) {
        if (this.dirty) {
            buildVertices();
        }
        for (int i = 0; i < this.vertices.b; i++) {
            polygonSpriteBatch.draw(this.region.getTexture(), this.vertices.a(i), 0, this.vertices.a(i).length, this.indices.a(i), 0, this.indices.a(i).length);
        }
    }

    public void setColor(ka kaVar) {
        this.color = kaVar;
        this.dirty = true;
    }

    public void setPosition(float f, float f2) {
        this.x = f;
        this.y = f2;
        this.dirty = true;
    }
}
