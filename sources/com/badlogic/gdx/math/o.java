package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.t;
import java.io.Serializable;
/* compiled from: Vector2.java */
/* loaded from: classes.dex */
public class o implements Serializable {
    public static final o a = new o(1.0f, 0.0f);
    public static final o b = new o(0.0f, 1.0f);
    public static final o c = new o(0.0f, 0.0f);
    private static final long serialVersionUID = 913902788239530931L;
    public float d;
    public float e;

    public o() {
    }

    public o(float f, float f2) {
        this.d = f;
        this.e = f2;
    }

    public o a(o oVar) {
        this.d = oVar.d;
        this.e = oVar.e;
        return this;
    }

    public o a(float f, float f2) {
        this.d = f;
        this.e = f2;
        return this;
    }

    public o b(float f, float f2) {
        this.d -= f;
        this.e -= f2;
        return this;
    }

    public float b(o oVar) {
        float f = oVar.d - this.d;
        float f2 = oVar.e - this.e;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public String toString() {
        return "(" + this.d + "," + this.e + ")";
    }

    public int hashCode() {
        return ((t.a(this.d) + 31) * 31) + t.a(this.e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            o oVar = (o) obj;
            return t.a(this.d) == t.a(oVar.d) && t.a(this.e) == t.a(oVar.e);
        }
        return false;
    }
}
