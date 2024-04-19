package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.t;
import java.io.Serializable;
/* compiled from: Circle.java */
/* loaded from: classes.dex */
public class b implements Serializable {
    public float a;
    public float b;
    public float c;

    public void a(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    public boolean a(float f, float f2) {
        float f3 = this.a - f;
        float f4 = this.b - f2;
        float f5 = (f3 * f3) + (f4 * f4);
        float f6 = this.c;
        return f5 <= f6 * f6;
    }

    public String toString() {
        return this.a + "," + this.b + "," + this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c;
    }

    public int hashCode() {
        return ((((t.b(this.c) + 41) * 41) + t.b(this.a)) * 41) + t.b(this.b);
    }
}
