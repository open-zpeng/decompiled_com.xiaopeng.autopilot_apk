package com.badlogic.gdx.math;

import java.io.Serializable;
/* compiled from: Plane.java */
/* loaded from: classes.dex */
public class j implements Serializable {
    private static final long serialVersionUID = -1240652082930747866L;
    public final p a;
    public float b;

    public j() {
        this.a = new p();
        this.b = 0.0f;
    }

    public j(p pVar, float f) {
        this.a = new p();
        this.b = 0.0f;
        this.a.a(pVar).d();
        this.b = f;
    }

    public void a(p pVar, p pVar2, p pVar3) {
        this.a.a(pVar).c(pVar2).e(pVar2.a - pVar3.a, pVar2.b - pVar3.b, pVar2.c - pVar3.c).d();
        this.b = -pVar.f(this.a);
    }

    public String toString() {
        return this.a.toString() + ", " + this.b;
    }
}
