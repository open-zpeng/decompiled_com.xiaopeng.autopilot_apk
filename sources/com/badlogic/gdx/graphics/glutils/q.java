package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.v;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/* compiled from: ShaderProgram.java */
/* loaded from: classes.dex */
public class q implements com.badlogic.gdx.utils.g {
    public static boolean a = true;
    public static String b = "";
    public static String c = "";
    private boolean i;
    private String[] m;
    private String[] q;
    private int r;
    private int s;
    private int t;
    private final FloatBuffer u;
    private final String v;
    private final String w;
    private boolean x;
    private static final com.badlogic.gdx.utils.v<ij, com.badlogic.gdx.utils.a<q>> g = new com.badlogic.gdx.utils.v<>();
    static final IntBuffer d = BufferUtils.c(1);
    private String h = "";
    private final com.badlogic.gdx.utils.u<String> j = new com.badlogic.gdx.utils.u<>();
    private final com.badlogic.gdx.utils.u<String> k = new com.badlogic.gdx.utils.u<>();
    private final com.badlogic.gdx.utils.u<String> l = new com.badlogic.gdx.utils.u<>();
    private final com.badlogic.gdx.utils.u<String> n = new com.badlogic.gdx.utils.u<>();
    private final com.badlogic.gdx.utils.u<String> o = new com.badlogic.gdx.utils.u<>();
    private final com.badlogic.gdx.utils.u<String> p = new com.badlogic.gdx.utils.u<>();
    private int y = 0;
    IntBuffer e = BufferUtils.c(1);
    IntBuffer f = BufferUtils.c(1);

    public q(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("vertex shader must not be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("fragment shader must not be null");
        }
        String str3 = b;
        if (str3 != null && str3.length() > 0) {
            str = b + str;
        }
        String str4 = c;
        if (str4 != null && str4.length() > 0) {
            str2 = c + str2;
        }
        this.v = str;
        this.w = str2;
        this.u = BufferUtils.a(16);
        a(str, str2);
        if (c()) {
            i();
            h();
            a(io.a, this);
        }
    }

    private void a(String str, String str2) {
        this.s = a(35633, str);
        this.t = a(35632, str2);
        if (this.s == -1 || this.t == -1) {
            this.i = false;
            return;
        }
        this.r = c(a());
        if (this.r == -1) {
            this.i = false;
        } else {
            this.i = true;
        }
    }

    private int a(int i, String str) {
        kg kgVar = io.h;
        IntBuffer c2 = BufferUtils.c(1);
        int glCreateShader = kgVar.glCreateShader(i);
        if (glCreateShader == 0) {
            return -1;
        }
        kgVar.glShaderSource(glCreateShader, str);
        kgVar.glCompileShader(glCreateShader);
        kgVar.glGetShaderiv(glCreateShader, 35713, c2);
        if (c2.get(0) == 0) {
            String glGetShaderInfoLog = kgVar.glGetShaderInfoLog(glCreateShader);
            StringBuilder sb = new StringBuilder();
            sb.append(this.h);
            sb.append(i == 35633 ? "Vertex shader\n" : "Fragment shader:\n");
            this.h = sb.toString();
            this.h += glGetShaderInfoLog;
            return -1;
        }
        return glCreateShader;
    }

    protected int a() {
        int glCreateProgram = io.h.glCreateProgram();
        if (glCreateProgram != 0) {
            return glCreateProgram;
        }
        return -1;
    }

    private int c(int i) {
        kg kgVar = io.h;
        if (i == -1) {
            return -1;
        }
        kgVar.glAttachShader(i, this.s);
        kgVar.glAttachShader(i, this.t);
        kgVar.glLinkProgram(i);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
        allocateDirect.order(ByteOrder.nativeOrder());
        IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
        kgVar.glGetProgramiv(i, 35714, asIntBuffer);
        if (asIntBuffer.get(0) == 0) {
            this.h = io.h.glGetProgramInfoLog(i);
            return -1;
        }
        return i;
    }

    public String b() {
        if (this.i) {
            this.h = io.h.glGetProgramInfoLog(this.r);
            return this.h;
        }
        return this.h;
    }

    public boolean c() {
        return this.i;
    }

    private int c(String str) {
        kg kgVar = io.h;
        int b2 = this.n.b(str, -2);
        if (b2 == -2) {
            int glGetAttribLocation = kgVar.glGetAttribLocation(this.r, str);
            this.n.a(str, glGetAttribLocation);
            return glGetAttribLocation;
        }
        return b2;
    }

    private int d(String str) {
        return a(str, a);
    }

    public int a(String str, boolean z) {
        kg kgVar = io.h;
        int b2 = this.j.b(str, -2);
        if (b2 == -2) {
            b2 = kgVar.glGetUniformLocation(this.r, str);
            if (b2 == -1 && z) {
                throw new IllegalArgumentException("no uniform with name '" + str + "' in shader");
            }
            this.j.a(str, b2);
        }
        return b2;
    }

    public void a(String str, int i) {
        kg kgVar = io.h;
        g();
        kgVar.glUniform1i(d(str), i);
    }

    public void a(int i, int i2) {
        kg kgVar = io.h;
        g();
        kgVar.glUniform1i(i, i2);
    }

    public void a(String str, float f) {
        kg kgVar = io.h;
        g();
        kgVar.glUniform1f(d(str), f);
    }

    public void a(int i, float f) {
        kg kgVar = io.h;
        g();
        kgVar.glUniform1f(i, f);
    }

    public void a(int i, float f, float f2) {
        kg kgVar = io.h;
        g();
        kgVar.glUniform2f(i, f, f2);
    }

    public void a(int i, float f, float f2, float f3) {
        kg kgVar = io.h;
        g();
        kgVar.glUniform3f(i, f, f2, f3);
    }

    public void a(int i, float f, float f2, float f3, float f4) {
        kg kgVar = io.h;
        g();
        kgVar.glUniform4f(i, f, f2, f3, f4);
    }

    public void a(int i, float[] fArr, int i2, int i3) {
        kg kgVar = io.h;
        g();
        kgVar.glUniform3fv(i, i3 / 3, fArr, i2);
    }

    public void a(String str, Matrix4 matrix4) {
        a(str, matrix4, false);
    }

    public void a(String str, Matrix4 matrix4, boolean z) {
        a(d(str), matrix4, z);
    }

    public void a(int i, Matrix4 matrix4) {
        a(i, matrix4, false);
    }

    public void a(int i, Matrix4 matrix4, boolean z) {
        kg kgVar = io.h;
        g();
        kgVar.glUniformMatrix4fv(i, 1, z, matrix4.a, 0);
    }

    public void a(int i, com.badlogic.gdx.math.i iVar) {
        a(i, iVar, false);
    }

    public void a(int i, com.badlogic.gdx.math.i iVar, boolean z) {
        kg kgVar = io.h;
        g();
        kgVar.glUniformMatrix3fv(i, 1, z, iVar.a, 0);
    }

    public void b(int i, float[] fArr, int i2, int i3) {
        kg kgVar = io.h;
        g();
        kgVar.glUniformMatrix4fv(i, i3 / 16, false, fArr, i2);
    }

    public void a(int i, com.badlogic.gdx.math.p pVar) {
        a(i, pVar.a, pVar.b, pVar.c);
    }

    public void a(int i, ka kaVar) {
        a(i, kaVar.J, kaVar.K, kaVar.L, kaVar.M);
    }

    public void a(int i, int i2, int i3, boolean z, int i4, Buffer buffer) {
        kg kgVar = io.h;
        g();
        kgVar.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
    }

    public void a(int i, int i2, int i3, boolean z, int i4, int i5) {
        kg kgVar = io.h;
        g();
        kgVar.glVertexAttribPointer(i, i2, i3, z, i4, i5);
    }

    public void d() {
        kg kgVar = io.h;
        g();
        kgVar.glUseProgram(this.r);
    }

    public void e() {
        io.h.glUseProgram(0);
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        kg kgVar = io.h;
        kgVar.glUseProgram(0);
        kgVar.glDeleteShader(this.s);
        kgVar.glDeleteShader(this.t);
        kgVar.glDeleteProgram(this.r);
        if (g.a((com.badlogic.gdx.utils.v<ij, com.badlogic.gdx.utils.a<q>>) io.a) != null) {
            g.a((com.badlogic.gdx.utils.v<ij, com.badlogic.gdx.utils.a<q>>) io.a).c(this, true);
        }
    }

    public void a(String str) {
        kg kgVar = io.h;
        g();
        int c2 = c(str);
        if (c2 == -1) {
            return;
        }
        kgVar.glDisableVertexAttribArray(c2);
    }

    public void a(int i) {
        kg kgVar = io.h;
        g();
        kgVar.glDisableVertexAttribArray(i);
    }

    public void b(int i) {
        kg kgVar = io.h;
        g();
        kgVar.glEnableVertexAttribArray(i);
    }

    private void g() {
        if (this.x) {
            a(this.v, this.w);
            this.x = false;
        }
    }

    private void a(ij ijVar, q qVar) {
        com.badlogic.gdx.utils.a<q> a2 = g.a((com.badlogic.gdx.utils.v<ij, com.badlogic.gdx.utils.a<q>>) ijVar);
        if (a2 == null) {
            a2 = new com.badlogic.gdx.utils.a<>();
        }
        a2.a((com.badlogic.gdx.utils.a<q>) qVar);
        g.a((com.badlogic.gdx.utils.v<ij, com.badlogic.gdx.utils.a<q>>) ijVar, (ij) a2);
    }

    public static void a(ij ijVar) {
        com.badlogic.gdx.utils.a<q> a2;
        if (io.h == null || (a2 = g.a((com.badlogic.gdx.utils.v<ij, com.badlogic.gdx.utils.a<q>>) ijVar)) == null) {
            return;
        }
        for (int i = 0; i < a2.b; i++) {
            a2.a(i).x = true;
            a2.a(i).g();
        }
    }

    public static void b(ij ijVar) {
        g.b((com.badlogic.gdx.utils.v<ij, com.badlogic.gdx.utils.a<q>>) ijVar);
    }

    public static String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("Managed shaders/app: { ");
        v.c<ij> it = g.e().iterator();
        while (it.hasNext()) {
            sb.append(g.a((com.badlogic.gdx.utils.v<ij, com.badlogic.gdx.utils.a<q>>) it.next()).b);
            sb.append(" ");
        }
        sb.append("}");
        return sb.toString();
    }

    private void h() {
        this.e.clear();
        io.h.glGetProgramiv(this.r, 35718, this.e);
        int i = this.e.get(0);
        this.m = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.e.clear();
            this.e.put(0, 1);
            this.f.clear();
            String glGetActiveUniform = io.h.glGetActiveUniform(this.r, i2, this.e, this.f);
            this.j.a(glGetActiveUniform, io.h.glGetUniformLocation(this.r, glGetActiveUniform));
            this.k.a(glGetActiveUniform, this.f.get(0));
            this.l.a(glGetActiveUniform, this.e.get(0));
            this.m[i2] = glGetActiveUniform;
        }
    }

    private void i() {
        this.e.clear();
        io.h.glGetProgramiv(this.r, 35721, this.e);
        int i = this.e.get(0);
        this.q = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.e.clear();
            this.e.put(0, 1);
            this.f.clear();
            String glGetActiveAttrib = io.h.glGetActiveAttrib(this.r, i2, this.e, this.f);
            this.n.a(glGetActiveAttrib, io.h.glGetAttribLocation(this.r, glGetActiveAttrib));
            this.o.a(glGetActiveAttrib, this.f.get(0));
            this.p.a(glGetActiveAttrib, this.e.get(0));
            this.q[i2] = glGetActiveAttrib;
        }
    }

    public int b(String str) {
        return this.n.b(str, -1);
    }
}
