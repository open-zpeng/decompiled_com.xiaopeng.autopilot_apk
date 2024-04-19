package defpackage;

import com.badlogic.gdx.utils.o;
import com.badlogic.gdx.utils.q;
/* compiled from: Emitter.java */
/* renamed from: mt  reason: default package */
/* loaded from: classes.dex */
public abstract class mt extends mo implements o.c {
    public int k;
    public int l = 4;

    @Override // defpackage.mo, com.badlogic.gdx.utils.o.c
    public void a(o oVar, q qVar) {
        this.k = ((Integer) oVar.a("minParticleCount", Integer.TYPE, qVar)).intValue();
        this.l = ((Integer) oVar.a("maxParticleCount", Integer.TYPE, qVar)).intValue();
    }
}
