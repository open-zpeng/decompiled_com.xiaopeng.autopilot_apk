package com.badlogic.gdx.graphics.glutils;

import defpackage.ij;
import defpackage.km;
/* compiled from: MipMapGenerator.java */
/* loaded from: classes.dex */
public class o {
    private static boolean a = true;

    public static void a(int i, km kmVar, int i2, int i3) {
        if (!a) {
            c(i, kmVar, i2, i3);
        } else if (io.a.getType() == ij.a.Android || io.a.getType() == ij.a.WebGL || io.a.getType() == ij.a.iOS) {
            a(i, kmVar);
        } else {
            b(i, kmVar, i2, i3);
        }
    }

    private static void a(int i, km kmVar) {
        io.g.glTexImage2D(i, 0, kmVar.e(), kmVar.b(), kmVar.c(), 0, kmVar.d(), kmVar.f(), kmVar.g());
        io.h.glGenerateMipmap(i);
    }

    private static void b(int i, km kmVar, int i2, int i3) {
        if (io.b.supportsExtension("GL_ARB_framebuffer_object") || io.b.supportsExtension("GL_EXT_framebuffer_object") || io.i != null) {
            io.g.glTexImage2D(i, 0, kmVar.e(), kmVar.b(), kmVar.c(), 0, kmVar.d(), kmVar.f(), kmVar.g());
            io.h.glGenerateMipmap(i);
            return;
        }
        c(i, kmVar, i2, i3);
    }

    private static void c(int i, km kmVar, int i2, int i3) {
        io.g.glTexImage2D(i, 0, kmVar.e(), kmVar.b(), kmVar.c(), 0, kmVar.d(), kmVar.f(), kmVar.g());
        if (io.h == null && i2 != i3) {
            throw new com.badlogic.gdx.utils.k("texture width and height must be square when using mipmapping.");
        }
        int b = kmVar.b() / 2;
        int c = kmVar.c() / 2;
        int i4 = 1;
        km kmVar2 = kmVar;
        while (b > 0 && c > 0) {
            km kmVar3 = new km(b, c, kmVar2.h());
            kmVar3.a(km.a.None);
            kmVar3.a(kmVar2, 0, 0, kmVar2.b(), kmVar2.c(), 0, 0, b, c);
            if (i4 > 1) {
                kmVar2.dispose();
            }
            kmVar2 = kmVar3;
            io.g.glTexImage2D(i, i4, kmVar3.e(), kmVar3.b(), kmVar3.c(), 0, kmVar3.d(), kmVar3.f(), kmVar3.g());
            b = kmVar2.b() / 2;
            c = kmVar2.c() / 2;
            i4++;
        }
    }
}
