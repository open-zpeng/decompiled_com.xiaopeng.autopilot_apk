package com.badlogic.gdx.utils;
/* compiled from: Scaling.java */
/* loaded from: classes.dex */
public enum ae {
    fit,
    fill,
    fillX,
    fillY,
    stretch,
    stretchX,
    stretchY,
    none;
    
    private static final com.badlogic.gdx.math.o a = new com.badlogic.gdx.math.o();

    public com.badlogic.gdx.math.o apply(float f, float f2, float f3, float f4) {
        switch (this) {
            case fit:
                float f5 = f4 / f3 > f2 / f ? f3 / f : f4 / f2;
                com.badlogic.gdx.math.o oVar = a;
                oVar.d = f * f5;
                oVar.e = f2 * f5;
                break;
            case fill:
                float f6 = f4 / f3 < f2 / f ? f3 / f : f4 / f2;
                com.badlogic.gdx.math.o oVar2 = a;
                oVar2.d = f * f6;
                oVar2.e = f2 * f6;
                break;
            case fillX:
                float f7 = f3 / f;
                com.badlogic.gdx.math.o oVar3 = a;
                oVar3.d = f * f7;
                oVar3.e = f2 * f7;
                break;
            case fillY:
                float f8 = f4 / f2;
                com.badlogic.gdx.math.o oVar4 = a;
                oVar4.d = f * f8;
                oVar4.e = f2 * f8;
                break;
            case stretch:
                com.badlogic.gdx.math.o oVar5 = a;
                oVar5.d = f3;
                oVar5.e = f4;
                break;
            case stretchX:
                com.badlogic.gdx.math.o oVar6 = a;
                oVar6.d = f3;
                oVar6.e = f2;
                break;
            case stretchY:
                com.badlogic.gdx.math.o oVar7 = a;
                oVar7.d = f;
                oVar7.e = f4;
                break;
            case none:
                com.badlogic.gdx.math.o oVar8 = a;
                oVar8.d = f;
                oVar8.e = f2;
                break;
        }
        return a;
    }
}
