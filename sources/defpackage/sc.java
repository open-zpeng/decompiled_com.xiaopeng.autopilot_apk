package defpackage;

import com.badlogic.gdx.math.p;
/* compiled from: RoadPathPoint.java */
/* renamed from: sc  reason: default package */
/* loaded from: classes.dex */
public class sc {
    private p a;
    private float b;
    private float c;
    private int d;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private int h = 0;
    private int i = -99;
    private int j = -99;
    private int k = 0;
    private boolean l = false;
    private int m = 0;

    public int a() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public int b() {
        return this.k;
    }

    public void b(int i) {
        this.k = i;
    }

    public int c() {
        return this.i;
    }

    public void c(int i) {
        this.i = i;
    }

    public void d(int i) {
        this.j = i;
    }

    public void e(int i) {
        this.h = i;
    }

    public boolean d() {
        int i = this.h;
        return i == 1 || i == 2;
    }

    public boolean e() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean f() {
        return this.g;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public int g() {
        return this.d;
    }

    public p h() {
        return this.a;
    }

    public float i() {
        return this.b;
    }

    public float j() {
        return this.c;
    }

    public sc(p pVar, float f, float f2, int i) {
        this.a = pVar;
        this.b = f;
        this.c = f2;
        this.d = i;
    }
}
