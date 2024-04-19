package com.badlogic.gdx.graphics.glutils;
/* compiled from: HdpiUtils.java */
/* loaded from: classes.dex */
public class g {
    public static void a(int i, int i2, int i3, int i4) {
        if (io.b.getWidth() != io.b.getBackBufferWidth() || io.b.getHeight() != io.b.getBackBufferHeight()) {
            io.g.glScissor(a(i), b(i2), a(i3), b(i4));
        } else {
            io.g.glScissor(i, i2, i3, i4);
        }
    }

    public static void b(int i, int i2, int i3, int i4) {
        if (io.b.getWidth() != io.b.getBackBufferWidth() || io.b.getHeight() != io.b.getBackBufferHeight()) {
            io.g.glViewport(a(i), b(i2), a(i3), b(i4));
        } else {
            io.g.glViewport(i, i2, i3, i4);
        }
    }

    public static int a(int i) {
        return (int) ((i * io.b.getBackBufferWidth()) / io.b.getWidth());
    }

    public static int b(int i) {
        return (int) ((i * io.b.getBackBufferHeight()) / io.b.getHeight());
    }
}
