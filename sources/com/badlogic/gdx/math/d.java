package com.badlogic.gdx.math;
/* compiled from: FloatCounter.java */
/* loaded from: classes.dex */
public class d {
    public int a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public final q h;

    public d(int i) {
        this.h = i > 1 ? new q(i) : null;
        a();
    }

    public void a(float f) {
        this.f = f;
        this.b += f;
        this.a++;
        this.e = this.b / this.a;
        q qVar = this.h;
        if (qVar != null) {
            qVar.a(f);
            this.g = this.h.c();
        } else {
            this.g = this.f;
        }
        q qVar2 = this.h;
        if (qVar2 == null || qVar2.a()) {
            float f2 = this.g;
            if (f2 < this.c) {
                this.c = f2;
            }
            float f3 = this.g;
            if (f3 > this.d) {
                this.d = f3;
            }
        }
    }

    public void a() {
        this.a = 0;
        this.b = 0.0f;
        this.c = Float.MAX_VALUE;
        this.d = Float.MIN_VALUE;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        q qVar = this.h;
        if (qVar != null) {
            qVar.b();
        }
    }
}
