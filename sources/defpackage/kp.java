package defpackage;

import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.k;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TextureArray.java */
/* renamed from: kp  reason: default package */
/* loaded from: classes.dex */
public class kp extends ki {
    static final Map<ij, a<kp>> a = new HashMap();
    private kq b;

    private void a(kq kqVar) {
        if (this.b != null && kqVar.g() != this.b.g()) {
            throw new k("New data must have the same managed status as the old data");
        }
        this.b = kqVar;
        bind();
        io.i.glTexImage3D(35866, 0, kqVar.h(), kqVar.d(), kqVar.e(), kqVar.f(), 0, kqVar.h(), kqVar.i(), null);
        if (!kqVar.a()) {
            kqVar.b();
        }
        kqVar.c();
        setFilter(this.minFilter, this.magFilter);
        setWrap(this.uWrap, this.vWrap);
        io.g.glBindTexture(this.glTarget, 0);
    }

    @Override // defpackage.ki
    public int getWidth() {
        return this.b.d();
    }

    @Override // defpackage.ki
    public int getHeight() {
        return this.b.e();
    }

    @Override // defpackage.ki
    public int getDepth() {
        return this.b.f();
    }

    @Override // defpackage.ki
    public boolean isManaged() {
        return this.b.g();
    }

    @Override // defpackage.ki
    protected void reload() {
        if (!isManaged()) {
            throw new k("Tried to reload an unmanaged TextureArray");
        }
        this.glHandle = io.g.glGenTexture();
        a(this.b);
    }

    public static void a(ij ijVar) {
        a.remove(ijVar);
    }

    public static void b(ij ijVar) {
        a<kp> aVar = a.get(ijVar);
        if (aVar == null) {
            return;
        }
        for (int i = 0; i < aVar.b; i++) {
            aVar.a(i).reload();
        }
    }
}
