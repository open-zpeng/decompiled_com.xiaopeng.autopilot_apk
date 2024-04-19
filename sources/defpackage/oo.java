package defpackage;

import com.badlogic.gdx.math.o;
/* compiled from: InputEvent.java */
/* renamed from: oo  reason: default package */
/* loaded from: classes.dex */
public class oo extends ol {
    private a a;
    private float b;
    private float c;
    private int d;
    private int e;
    private int f;
    private int g;
    private char h;
    private ok i;

    /* compiled from: InputEvent.java */
    /* renamed from: oo$a */
    /* loaded from: classes.dex */
    public enum a {
        touchDown,
        touchUp,
        touchDragged,
        mouseMoved,
        enter,
        exit,
        scrolled,
        keyDown,
        keyUp,
        keyTyped
    }

    @Override // defpackage.ol, com.badlogic.gdx.utils.z.a
    public void reset() {
        super.reset();
        this.i = null;
        this.e = -1;
    }

    public void a(float f) {
        this.b = f;
    }

    public void b(float f) {
        this.c = f;
    }

    public a i() {
        return this.a;
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public int j() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int k() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public int l() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public char m() {
        return this.h;
    }

    public void a(char c) {
        this.h = c;
    }

    public int n() {
        return this.g;
    }

    public void d(int i) {
        this.g = i;
    }

    public ok o() {
        return this.i;
    }

    public o a(ok okVar, o oVar) {
        oVar.a(this.b, this.c);
        okVar.a(oVar);
        return oVar;
    }

    public String toString() {
        return this.a.toString();
    }
}
