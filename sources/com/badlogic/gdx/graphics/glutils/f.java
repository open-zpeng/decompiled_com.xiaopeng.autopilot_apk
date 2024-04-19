package com.badlogic.gdx.graphics.glutils;

import defpackage.ij;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: GLVersion.java */
/* loaded from: classes.dex */
public class f {
    private int a;
    private int b;
    private int c;
    private final String d;
    private final String e;
    private final a f;
    private final String g = "GLVersion";

    /* compiled from: GLVersion.java */
    /* loaded from: classes.dex */
    public enum a {
        OpenGL,
        GLES,
        WebGL,
        NONE
    }

    public f(ij.a aVar, String str, String str2, String str3) {
        if (aVar == ij.a.Android) {
            this.f = a.GLES;
        } else if (aVar == ij.a.iOS) {
            this.f = a.GLES;
        } else if (aVar == ij.a.Desktop) {
            this.f = a.OpenGL;
        } else if (aVar == ij.a.Applet) {
            this.f = a.OpenGL;
        } else if (aVar == ij.a.WebGL) {
            this.f = a.WebGL;
        } else {
            this.f = a.NONE;
        }
        if (this.f == a.GLES) {
            a("OpenGL ES (\\d(\\.\\d){0,2})", str);
        } else if (this.f == a.WebGL) {
            a("WebGL (\\d(\\.\\d){0,2})", str);
        } else if (this.f == a.OpenGL) {
            a("(\\d(\\.\\d){0,2})", str);
        } else {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            str2 = "";
            str3 = "";
        }
        this.d = str2;
        this.e = str3;
    }

    private void a(String str, String str2) {
        Matcher matcher = Pattern.compile(str).matcher(str2);
        if (matcher.find()) {
            String[] split = matcher.group(1).split("\\.");
            this.a = a(split[0], 2);
            this.b = split.length < 2 ? 0 : a(split[1], 0);
            this.c = split.length >= 3 ? a(split[2], 0) : 0;
            return;
        }
        ij ijVar = io.a;
        ijVar.log("GLVersion", "Invalid version string: " + str2);
        this.a = 2;
        this.b = 0;
        this.c = 0;
    }

    private int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            ij ijVar = io.a;
            ijVar.error("LibGDX GL", "Error parsing number: " + str + ", assuming: " + i);
            return i;
        }
    }

    public int a() {
        return this.a;
    }
}
