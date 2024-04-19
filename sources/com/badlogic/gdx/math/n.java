package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.t;
import java.io.Serializable;
/* compiled from: Rectangle.java */
/* loaded from: classes.dex */
public class n implements Serializable {
    private static final long serialVersionUID = 5733252015138115702L;
    public static final n tmp = new n();
    public static final n tmp2 = new n();
    public float height;
    public float width;
    public float x;
    public float y;

    public n() {
    }

    public n(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public n(n nVar) {
        this.x = nVar.x;
        this.y = nVar.y;
        this.width = nVar.width;
        this.height = nVar.height;
    }

    public n set(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
        return this;
    }

    public float getX() {
        return this.x;
    }

    public n setX(float f) {
        this.x = f;
        return this;
    }

    public float getY() {
        return this.y;
    }

    public n setY(float f) {
        this.y = f;
        return this;
    }

    public float getWidth() {
        return this.width;
    }

    public n setWidth(float f) {
        this.width = f;
        return this;
    }

    public float getHeight() {
        return this.height;
    }

    public n setHeight(float f) {
        this.height = f;
        return this;
    }

    public o getPosition(o oVar) {
        return oVar.a(this.x, this.y);
    }

    public n setPosition(o oVar) {
        this.x = oVar.d;
        this.y = oVar.e;
        return this;
    }

    public n setPosition(float f, float f2) {
        this.x = f;
        this.y = f2;
        return this;
    }

    public n setSize(float f, float f2) {
        this.width = f;
        this.height = f2;
        return this;
    }

    public n setSize(float f) {
        this.width = f;
        this.height = f;
        return this;
    }

    public o getSize(o oVar) {
        return oVar.a(this.width, this.height);
    }

    public boolean contains(float f, float f2) {
        float f3 = this.x;
        if (f3 <= f && f3 + this.width >= f) {
            float f4 = this.y;
            if (f4 <= f2 && f4 + this.height >= f2) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(o oVar) {
        return contains(oVar.d, oVar.e);
    }

    public boolean contains(b bVar) {
        return bVar.a - bVar.c >= this.x && bVar.a + bVar.c <= this.x + this.width && bVar.b - bVar.c >= this.y && bVar.b + bVar.c <= this.y + this.height;
    }

    public boolean contains(n nVar) {
        float f = nVar.x;
        float f2 = nVar.width + f;
        float f3 = nVar.y;
        float f4 = nVar.height + f3;
        float f5 = this.x;
        if (f > f5) {
            float f6 = this.width;
            if (f < f5 + f6 && f2 > f5 && f2 < f5 + f6) {
                float f7 = this.y;
                if (f3 > f7) {
                    float f8 = this.height;
                    if (f3 < f7 + f8 && f4 > f7 && f4 < f7 + f8) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean overlaps(n nVar) {
        float f = this.x;
        float f2 = nVar.x;
        if (f < nVar.width + f2 && f + this.width > f2) {
            float f3 = this.y;
            float f4 = nVar.y;
            if (f3 < nVar.height + f4 && f3 + this.height > f4) {
                return true;
            }
        }
        return false;
    }

    public n set(n nVar) {
        this.x = nVar.x;
        this.y = nVar.y;
        this.width = nVar.width;
        this.height = nVar.height;
        return this;
    }

    public n merge(n nVar) {
        float min = Math.min(this.x, nVar.x);
        float max = Math.max(this.x + this.width, nVar.x + nVar.width);
        this.x = min;
        this.width = max - min;
        float min2 = Math.min(this.y, nVar.y);
        float max2 = Math.max(this.y + this.height, nVar.y + nVar.height);
        this.y = min2;
        this.height = max2 - min2;
        return this;
    }

    public n merge(float f, float f2) {
        float min = Math.min(this.x, f);
        float max = Math.max(this.x + this.width, f);
        this.x = min;
        this.width = max - min;
        float min2 = Math.min(this.y, f2);
        float max2 = Math.max(this.y + this.height, f2);
        this.y = min2;
        this.height = max2 - min2;
        return this;
    }

    public n merge(o oVar) {
        return merge(oVar.d, oVar.e);
    }

    public n merge(o[] oVarArr) {
        float f = this.x;
        float f2 = this.width + f;
        float f3 = this.y;
        float f4 = this.height + f3;
        for (o oVar : oVarArr) {
            f = Math.min(f, oVar.d);
            f2 = Math.max(f2, oVar.d);
            f3 = Math.min(f3, oVar.e);
            f4 = Math.max(f4, oVar.e);
        }
        this.x = f;
        this.width = f2 - f;
        this.y = f3;
        this.height = f4 - f3;
        return this;
    }

    public float getAspectRatio() {
        float f = this.height;
        if (f == 0.0f) {
            return Float.NaN;
        }
        return this.width / f;
    }

    public o getCenter(o oVar) {
        oVar.d = this.x + (this.width / 2.0f);
        oVar.e = this.y + (this.height / 2.0f);
        return oVar;
    }

    public n setCenter(float f, float f2) {
        setPosition(f - (this.width / 2.0f), f2 - (this.height / 2.0f));
        return this;
    }

    public n setCenter(o oVar) {
        setPosition(oVar.d - (this.width / 2.0f), oVar.e - (this.height / 2.0f));
        return this;
    }

    public n fitOutside(n nVar) {
        float aspectRatio = getAspectRatio();
        if (aspectRatio > nVar.getAspectRatio()) {
            float f = nVar.height;
            setSize(aspectRatio * f, f);
        } else {
            float f2 = nVar.width;
            setSize(f2, f2 / aspectRatio);
        }
        setPosition((nVar.x + (nVar.width / 2.0f)) - (this.width / 2.0f), (nVar.y + (nVar.height / 2.0f)) - (this.height / 2.0f));
        return this;
    }

    public n fitInside(n nVar) {
        float aspectRatio = getAspectRatio();
        if (aspectRatio < nVar.getAspectRatio()) {
            float f = nVar.height;
            setSize(aspectRatio * f, f);
        } else {
            float f2 = nVar.width;
            setSize(f2, f2 / aspectRatio);
        }
        setPosition((nVar.x + (nVar.width / 2.0f)) - (this.width / 2.0f), (nVar.y + (nVar.height / 2.0f)) - (this.height / 2.0f));
        return this;
    }

    public String toString() {
        return "[" + this.x + "," + this.y + "," + this.width + "," + this.height + "]";
    }

    public n fromString(String str) {
        int indexOf = str.indexOf(44, 1);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(44, i);
        int i2 = indexOf2 + 1;
        int indexOf3 = str.indexOf(44, i2);
        if (indexOf != -1 && indexOf2 != -1 && indexOf3 != -1 && str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']') {
            try {
                return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(i, indexOf2)), Float.parseFloat(str.substring(i2, indexOf3)), Float.parseFloat(str.substring(indexOf3 + 1, str.length() - 1)));
            } catch (NumberFormatException unused) {
            }
        }
        throw new com.badlogic.gdx.utils.k("Malformed Rectangle: " + str);
    }

    public float area() {
        return this.width * this.height;
    }

    public float perimeter() {
        return (this.width + this.height) * 2.0f;
    }

    public int hashCode() {
        return ((((((t.b(this.height) + 31) * 31) + t.b(this.width)) * 31) + t.b(this.x)) * 31) + t.b(this.y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            n nVar = (n) obj;
            return t.b(this.height) == t.b(nVar.height) && t.b(this.width) == t.b(nVar.width) && t.b(this.x) == t.b(nVar.x) && t.b(this.y) == t.b(nVar.y);
        }
        return false;
    }
}
