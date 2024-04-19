package defpackage;

import com.badlogic.gdx.graphics.glutils.o;
import com.badlogic.gdx.utils.g;
import defpackage.km;
import defpackage.ko;
import defpackage.kr;
/* compiled from: GLTexture.java */
/* renamed from: ki  reason: default package */
/* loaded from: classes.dex */
public abstract class ki implements g {
    protected int glHandle;
    public final int glTarget;
    protected ko.a magFilter;
    protected ko.a minFilter;
    protected ko.b uWrap;
    protected ko.b vWrap;

    public abstract int getDepth();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isManaged();

    protected abstract void reload();

    public ki(int i) {
        this(i, io.g.glGenTexture());
    }

    public ki(int i, int i2) {
        this.minFilter = ko.a.Nearest;
        this.magFilter = ko.a.Nearest;
        this.uWrap = ko.b.ClampToEdge;
        this.vWrap = ko.b.ClampToEdge;
        this.glTarget = i;
        this.glHandle = i2;
    }

    public void bind() {
        io.g.glBindTexture(this.glTarget, this.glHandle);
    }

    public void bind(int i) {
        io.g.glActiveTexture(i + 33984);
        io.g.glBindTexture(this.glTarget, this.glHandle);
    }

    public ko.a getMinFilter() {
        return this.minFilter;
    }

    public ko.a getMagFilter() {
        return this.magFilter;
    }

    public ko.b getUWrap() {
        return this.uWrap;
    }

    public ko.b getVWrap() {
        return this.vWrap;
    }

    public int getTextureObjectHandle() {
        return this.glHandle;
    }

    public void unsafeSetWrap(ko.b bVar, ko.b bVar2) {
        unsafeSetWrap(bVar, bVar2, false);
    }

    public void unsafeSetWrap(ko.b bVar, ko.b bVar2, boolean z) {
        if (bVar != null && (z || this.uWrap != bVar)) {
            io.g.glTexParameteri(this.glTarget, 10242, bVar.getGLEnum());
            this.uWrap = bVar;
        }
        if (bVar2 != null) {
            if (z || this.vWrap != bVar2) {
                io.g.glTexParameteri(this.glTarget, 10243, bVar2.getGLEnum());
                this.vWrap = bVar2;
            }
        }
    }

    public void setWrap(ko.b bVar, ko.b bVar2) {
        this.uWrap = bVar;
        this.vWrap = bVar2;
        bind();
        io.g.glTexParameteri(this.glTarget, 10242, bVar.getGLEnum());
        io.g.glTexParameteri(this.glTarget, 10243, bVar2.getGLEnum());
    }

    public void unsafeSetFilter(ko.a aVar, ko.a aVar2) {
        unsafeSetFilter(aVar, aVar2, false);
    }

    public void unsafeSetFilter(ko.a aVar, ko.a aVar2, boolean z) {
        if (aVar != null && (z || this.minFilter != aVar)) {
            io.g.glTexParameteri(this.glTarget, 10241, aVar.getGLEnum());
            this.minFilter = aVar;
        }
        if (aVar2 != null) {
            if (z || this.magFilter != aVar2) {
                io.g.glTexParameteri(this.glTarget, 10240, aVar2.getGLEnum());
                this.magFilter = aVar2;
            }
        }
    }

    public void setFilter(ko.a aVar, ko.a aVar2) {
        this.minFilter = aVar;
        this.magFilter = aVar2;
        bind();
        io.g.glTexParameteri(this.glTarget, 10241, aVar.getGLEnum());
        io.g.glTexParameteri(this.glTarget, 10240, aVar2.getGLEnum());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void delete() {
        if (this.glHandle != 0) {
            io.g.glDeleteTexture(this.glHandle);
            this.glHandle = 0;
        }
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        delete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void uploadImageData(int i, kr krVar) {
        uploadImageData(i, krVar, 0);
    }

    public static void uploadImageData(int i, kr krVar, int i2) {
        if (krVar == null) {
            return;
        }
        if (!krVar.a()) {
            krVar.b();
        }
        if (krVar.g() == kr.b.Custom) {
            krVar.a(i);
            return;
        }
        km h = krVar.h();
        boolean i3 = krVar.i();
        if (krVar.j() != h.h()) {
            km kmVar = new km(h.b(), h.c(), krVar.j());
            kmVar.a(km.a.None);
            kmVar.a(h, 0, 0, 0, 0, h.b(), h.c());
            if (krVar.i()) {
                h.dispose();
            }
            h = kmVar;
            i3 = true;
        }
        io.g.glPixelStorei(3317, 1);
        if (krVar.k()) {
            o.a(i, h, h.b(), h.c());
        } else {
            io.g.glTexImage2D(i, i2, h.e(), h.b(), h.c(), 0, h.d(), h.f(), h.g());
        }
        if (i3) {
            h.dispose();
        }
    }
}
