package defpackage;

import com.badlogic.gdx.utils.z;
/* compiled from: Action.java */
/* renamed from: oj  reason: default package */
/* loaded from: classes.dex */
public abstract class oj implements z.a {
    protected ok a;
    protected ok b;
    private z c;

    public void a() {
    }

    public void a(ok okVar) {
        z zVar;
        this.a = okVar;
        if (this.b == null) {
            b(okVar);
        }
        if (okVar != null || (zVar = this.c) == null) {
            return;
        }
        zVar.free(this);
        this.c = null;
    }

    public void b(ok okVar) {
        this.b = okVar;
    }

    @Override // com.badlogic.gdx.utils.z.a
    public void reset() {
        this.a = null;
        this.b = null;
        this.c = null;
        a();
    }

    public void a(z zVar) {
        this.c = zVar;
    }

    public String toString() {
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != -1) {
            name = name.substring(lastIndexOf + 1);
        }
        return name.endsWith("Action") ? name.substring(0, name.length() - 6) : name;
    }
}
