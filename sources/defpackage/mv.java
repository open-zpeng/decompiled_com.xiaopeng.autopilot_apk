package defpackage;

import defpackage.ms;
/* compiled from: ParticleControllerRenderer.java */
/* renamed from: mv  reason: default package */
/* loaded from: classes.dex */
public abstract class mv<D, T extends ms<D>> extends mo {
    protected T k;

    public abstract boolean b(ms<?> msVar);

    protected mv() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(ms<?> msVar) {
        if (b(msVar)) {
            this.k = msVar;
            return true;
        }
        return false;
    }
}
