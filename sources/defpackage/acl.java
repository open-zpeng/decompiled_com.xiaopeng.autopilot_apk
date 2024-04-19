package defpackage;

import com.badlogic.gdx.graphics.glutils.c;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.g;
/* compiled from: CustomerDirectionalShadowLight.java */
/* renamed from: acl  reason: default package */
/* loaded from: classes.dex */
public class acl extends lq implements g, ls {
    protected c c;
    protected jz d;
    protected no e;

    @Override // defpackage.ls
    public Matrix4 a() {
        return this.d.f;
    }

    @Override // defpackage.ls
    public no b() {
        this.e.a = this.c.a();
        return this.e;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.dispose();
        }
        this.c = null;
    }
}
