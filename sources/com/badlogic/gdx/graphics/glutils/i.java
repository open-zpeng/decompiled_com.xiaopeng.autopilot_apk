package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.math.Matrix4;
/* compiled from: ImmediateModeRenderer20.java */
/* loaded from: classes.dex */
public class i implements h {
    private int a;
    private int b;
    private int c;
    private final int d;
    private int e;
    private final kj f;
    private q g;
    private boolean h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final Matrix4 n;
    private final float[] o;
    private final String[] p;

    public i(int i, boolean z, boolean z2, int i2) {
        this(i, z, z2, i2, a(z, z2, i2));
        this.h = true;
    }

    public i(int i, boolean z, boolean z2, int i2, q qVar) {
        this.n = new Matrix4();
        this.d = i;
        this.i = i2;
        this.g = qVar;
        this.f = new kj(false, i, 0, b(z, z2, i2));
        this.o = new float[i * (this.f.f().a / 4)];
        this.j = this.f.f().a / 4;
        this.k = this.f.a(8) != null ? this.f.a(8).e / 4 : 0;
        this.l = this.f.a(4) != null ? this.f.a(4).e / 4 : 0;
        this.m = this.f.a(16) != null ? this.f.a(16).e / 4 : 0;
        this.p = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            String[] strArr = this.p;
            strArr[i3] = "u_sampler" + i3;
        }
    }

    private ks[] b(boolean z, boolean z2, int i) {
        com.badlogic.gdx.utils.a aVar = new com.badlogic.gdx.utils.a();
        aVar.a((com.badlogic.gdx.utils.a) new ks(1, 3, "a_position"));
        if (z) {
            aVar.a((com.badlogic.gdx.utils.a) new ks(8, 3, "a_normal"));
        }
        if (z2) {
            aVar.a((com.badlogic.gdx.utils.a) new ks(4, 4, "a_color"));
        }
        for (int i2 = 0; i2 < i; i2++) {
            aVar.a((com.badlogic.gdx.utils.a) new ks(16, 2, "a_texCoord" + i2));
        }
        ks[] ksVarArr = new ks[aVar.b];
        for (int i3 = 0; i3 < aVar.b; i3++) {
            ksVarArr[i3] = (ks) aVar.a(i3);
        }
        return ksVarArr;
    }

    @Override // com.badlogic.gdx.graphics.glutils.h
    public void a(Matrix4 matrix4, int i) {
        this.n.a(matrix4);
        this.a = i;
    }

    @Override // com.badlogic.gdx.graphics.glutils.h
    public void a(float f, float f2, float f3, float f4) {
        this.o[this.b + this.l] = ka.b(f, f2, f3, f4);
    }

    @Override // com.badlogic.gdx.graphics.glutils.h
    public void a(float f) {
        this.o[this.b + this.l] = f;
    }

    @Override // com.badlogic.gdx.graphics.glutils.h
    public void a(float f, float f2, float f3) {
        int i = this.b;
        float[] fArr = this.o;
        fArr[i] = f;
        fArr[i + 1] = f2;
        fArr[i + 2] = f3;
        this.c = 0;
        this.b = i + this.j;
        this.e++;
    }

    public void e() {
        if (this.e == 0) {
            return;
        }
        this.g.d();
        this.g.a("u_projModelView", this.n);
        for (int i = 0; i < this.i; i++) {
            this.g.a(this.p[i], i);
        }
        this.f.a(this.o, 0, this.b);
        this.f.a(this.g, this.a);
        this.g.e();
        this.c = 0;
        this.b = 0;
        this.e = 0;
    }

    @Override // com.badlogic.gdx.graphics.glutils.h
    public void a() {
        e();
    }

    @Override // com.badlogic.gdx.graphics.glutils.h
    public int b() {
        return this.e;
    }

    @Override // com.badlogic.gdx.graphics.glutils.h
    public int c() {
        return this.d;
    }

    @Override // com.badlogic.gdx.graphics.glutils.h
    public void d() {
        q qVar;
        if (this.h && (qVar = this.g) != null) {
            qVar.dispose();
        }
        this.f.dispose();
    }

    private static String c(boolean z, boolean z2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("attribute vec4 a_position;\n");
        sb.append(z ? "attribute vec3 a_normal;\n" : "");
        sb.append(z2 ? "attribute vec4 a_color;\n" : "");
        String sb2 = sb.toString();
        String str = sb2;
        for (int i2 = 0; i2 < i; i2++) {
            str = str + "attribute vec2 a_texCoord" + i2 + ";\n";
        }
        String str2 = str + "uniform mat4 u_projModelView;\n";
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(z2 ? "varying vec4 v_col;\n" : "");
        String sb4 = sb3.toString();
        for (int i3 = 0; i3 < i; i3++) {
            sb4 = sb4 + "varying vec2 v_tex" + i3 + ";\n";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        sb5.append("void main() {\n   gl_Position = u_projModelView * a_position;\n");
        sb5.append(z2 ? "   v_col = a_color;\n" : "");
        String sb6 = sb5.toString();
        for (int i4 = 0; i4 < i; i4++) {
            sb6 = sb6 + "   v_tex" + i4 + " = a_texCoord" + i4 + ";\n";
        }
        return (sb6 + "   gl_PointSize = 1.0;\n") + "}\n";
    }

    private static String d(boolean z, boolean z2, int i) {
        String str = z2 ? "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_col;\n" : "#ifdef GL_ES\nprecision mediump float;\n#endif\n";
        for (int i2 = 0; i2 < i; i2++) {
            str = (str + "varying vec2 v_tex" + i2 + ";\n") + "uniform sampler2D u_sampler" + i2 + ";\n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("void main() {\n   gl_FragColor = ");
        sb.append(z2 ? "v_col" : "vec4(1, 1, 1, 1)");
        String sb2 = sb.toString();
        if (i > 0) {
            sb2 = sb2 + " * ";
        }
        for (int i3 = 0; i3 < i; i3++) {
            sb2 = i3 == i - 1 ? sb2 + " texture2D(u_sampler" + i3 + ",  v_tex" + i3 + ")" : sb2 + " texture2D(u_sampler" + i3 + ",  v_tex" + i3 + ") *";
        }
        return sb2 + ";\n}";
    }

    public static q a(boolean z, boolean z2, int i) {
        return new q(c(z, z2, i), d(z, z2, i));
    }
}
