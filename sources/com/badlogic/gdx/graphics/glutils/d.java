package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import defpackage.ij;
import defpackage.ki;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* compiled from: GLFrameBuffer.java */
/* loaded from: classes.dex */
public abstract class d<T extends ki> implements com.badlogic.gdx.utils.g {
    protected static int c;
    protected com.badlogic.gdx.utils.a<T> b = new com.badlogic.gdx.utils.a<>();
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected boolean i;
    protected boolean j;
    protected c<? extends d<T>> k;
    protected static final Map<ij, com.badlogic.gdx.utils.a<d>> a = new HashMap();
    protected static boolean d = false;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: GLFrameBuffer.java */
    /* loaded from: classes.dex */
    public static class a {
        int a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: GLFrameBuffer.java */
    /* loaded from: classes.dex */
    public static abstract class c<U extends d<? extends ki>> {
        protected int a;
        protected int b;
        protected com.badlogic.gdx.utils.a<b> c;
        protected a d;
        protected a e;
        protected a f;
        protected boolean g;
        protected boolean h;
        protected boolean i;
    }

    protected abstract void a(T t);

    protected abstract T b(b bVar);

    protected abstract void b(T t);

    d() {
    }

    public T a() {
        return this.b.c();
    }

    protected void b() {
        int i;
        kg kgVar = io.h;
        d();
        if (!d) {
            d = true;
            if (io.a.getType() == ij.a.iOS) {
                IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                kgVar.glGetIntegerv(36006, asIntBuffer);
                c = asIntBuffer.get(0);
            } else {
                c = 0;
            }
        }
        this.e = kgVar.glGenFramebuffer();
        kgVar.glBindFramebuffer(36160, this.e);
        int i2 = this.k.a;
        int i3 = this.k.b;
        if (this.k.h) {
            this.f = kgVar.glGenRenderbuffer();
            kgVar.glBindRenderbuffer(36161, this.f);
            kgVar.glRenderbufferStorage(36161, this.k.e.a, i2, i3);
        }
        if (this.k.g) {
            this.g = kgVar.glGenRenderbuffer();
            kgVar.glBindRenderbuffer(36161, this.g);
            kgVar.glRenderbufferStorage(36161, this.k.d.a, i2, i3);
        }
        if (this.k.i) {
            this.h = kgVar.glGenRenderbuffer();
            kgVar.glBindRenderbuffer(36161, this.h);
            kgVar.glRenderbufferStorage(36161, this.k.f.a, i2, i3);
        }
        this.j = this.k.c.b > 1;
        if (this.j) {
            Iterator<b> it = this.k.c.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                b next = it.next();
                T b2 = b(next);
                this.b.a((com.badlogic.gdx.utils.a<T>) b2);
                if (next.a()) {
                    kgVar.glFramebufferTexture2D(36160, i4 + 36064, 3553, b2.getTextureObjectHandle(), 0);
                    i4++;
                } else if (next.e) {
                    kgVar.glFramebufferTexture2D(36160, 36096, 3553, b2.getTextureObjectHandle(), 0);
                } else if (next.f) {
                    kgVar.glFramebufferTexture2D(36160, 36128, 3553, b2.getTextureObjectHandle(), 0);
                }
            }
            i = i4;
        } else {
            T b3 = b(this.k.c.c());
            this.b.a((com.badlogic.gdx.utils.a<T>) b3);
            kgVar.glBindTexture(b3.glTarget, b3.getTextureObjectHandle());
            i = 0;
        }
        if (this.j) {
            IntBuffer c2 = BufferUtils.c(i);
            for (int i5 = 0; i5 < i; i5++) {
                c2.put(i5 + 36064);
            }
            c2.position(0);
            io.i.glDrawBuffers(i, c2);
        } else {
            a((d<T>) this.b.c());
        }
        if (this.k.h) {
            kgVar.glFramebufferRenderbuffer(36160, 36096, 36161, this.f);
        }
        if (this.k.g) {
            kgVar.glFramebufferRenderbuffer(36160, 36128, 36161, this.g);
        }
        if (this.k.i) {
            kgVar.glFramebufferRenderbuffer(36160, 33306, 36161, this.h);
        }
        kgVar.glBindRenderbuffer(36161, 0);
        Iterator<T> it2 = this.b.iterator();
        while (it2.hasNext()) {
            kgVar.glBindTexture(it2.next().glTarget, 0);
        }
        int glCheckFramebufferStatus = kgVar.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus == 36061 && this.k.h && this.k.g && (io.b.supportsExtension("GL_OES_packed_depth_stencil") || io.b.supportsExtension("GL_EXT_packed_depth_stencil"))) {
            if (this.k.h) {
                kgVar.glDeleteRenderbuffer(this.f);
                this.f = 0;
            }
            if (this.k.g) {
                kgVar.glDeleteRenderbuffer(this.g);
                this.g = 0;
            }
            if (this.k.i) {
                kgVar.glDeleteRenderbuffer(this.h);
                this.h = 0;
            }
            this.h = kgVar.glGenRenderbuffer();
            this.i = true;
            kgVar.glBindRenderbuffer(36161, this.h);
            kgVar.glRenderbufferStorage(36161, 35056, i2, i3);
            kgVar.glBindRenderbuffer(36161, 0);
            kgVar.glFramebufferRenderbuffer(36160, 36096, 36161, this.h);
            kgVar.glFramebufferRenderbuffer(36160, 36128, 36161, this.h);
            glCheckFramebufferStatus = kgVar.glCheckFramebufferStatus(36160);
        }
        kgVar.glBindFramebuffer(36160, c);
        if (glCheckFramebufferStatus != 36053) {
            Iterator<T> it3 = this.b.iterator();
            while (it3.hasNext()) {
                b((d<T>) it3.next());
            }
            if (this.i) {
                kgVar.glDeleteBuffer(this.h);
            } else {
                if (this.k.h) {
                    kgVar.glDeleteRenderbuffer(this.f);
                }
                if (this.k.g) {
                    kgVar.glDeleteRenderbuffer(this.g);
                }
            }
            kgVar.glDeleteFramebuffer(this.e);
            if (glCheckFramebufferStatus == 36054) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
            }
            if (glCheckFramebufferStatus == 36057) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
            }
            if (glCheckFramebufferStatus == 36055) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
            }
            if (glCheckFramebufferStatus == 36061) {
                throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
            }
            throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + glCheckFramebufferStatus);
        }
        a(io.a, this);
    }

    private void d() {
        if (io.b.isGL30Available()) {
            return;
        }
        if (this.k.i) {
            throw new com.badlogic.gdx.utils.k("Packed Stencil/Render render buffers are not available on GLES 2.0");
        }
        if (this.k.c.b > 1) {
            throw new com.badlogic.gdx.utils.k("Multiple render targets not available on GLES 2.0");
        }
        Iterator<b> it = this.k.c.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.e) {
                throw new com.badlogic.gdx.utils.k("Depth texture FrameBuffer Attachment not available on GLES 2.0");
            }
            if (next.f) {
                throw new com.badlogic.gdx.utils.k("Stencil texture FrameBuffer Attachment not available on GLES 2.0");
            }
            if (next.d && !io.b.supportsExtension("OES_texture_float")) {
                throw new com.badlogic.gdx.utils.k("Float texture FrameBuffer Attachment not available on GLES 2.0");
            }
        }
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        kg kgVar = io.h;
        Iterator<T> it = this.b.iterator();
        while (it.hasNext()) {
            b((d<T>) it.next());
        }
        if (this.i) {
            kgVar.glDeleteRenderbuffer(this.h);
        } else {
            if (this.k.h) {
                kgVar.glDeleteRenderbuffer(this.f);
            }
            if (this.k.g) {
                kgVar.glDeleteRenderbuffer(this.g);
            }
        }
        kgVar.glDeleteFramebuffer(this.e);
        if (a.get(io.a) != null) {
            a.get(io.a).c(this, true);
        }
    }

    private static void a(ij ijVar, d dVar) {
        com.badlogic.gdx.utils.a<d> aVar = a.get(ijVar);
        if (aVar == null) {
            aVar = new com.badlogic.gdx.utils.a<>();
        }
        aVar.a((com.badlogic.gdx.utils.a<d>) dVar);
        a.put(ijVar, aVar);
    }

    public static void a(ij ijVar) {
        com.badlogic.gdx.utils.a<d> aVar;
        if (io.h == null || (aVar = a.get(ijVar)) == null) {
            return;
        }
        for (int i = 0; i < aVar.b; i++) {
            aVar.a(i).b();
        }
    }

    public static void b(ij ijVar) {
        a.remove(ijVar);
    }

    public static StringBuilder a(StringBuilder sb) {
        sb.append("Managed buffers/app: { ");
        for (ij ijVar : a.keySet()) {
            sb.append(a.get(ijVar).b);
            sb.append(" ");
        }
        sb.append("}");
        return sb;
    }

    public static String c() {
        return a(new StringBuilder()).toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: GLFrameBuffer.java */
    /* loaded from: classes.dex */
    public static class b {
        int a;
        int b;
        int c;
        boolean d;
        boolean e;
        boolean f;

        public boolean a() {
            return (this.e || this.f) ? false : true;
        }
    }
}
