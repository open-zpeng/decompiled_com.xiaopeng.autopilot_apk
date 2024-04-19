package defpackage;

import com.badlogic.gdx.utils.z;
/* compiled from: Event.java */
/* renamed from: ol  reason: default package */
/* loaded from: classes.dex */
public class ol implements z.a {
    private oq a;
    private ok b;
    private ok c;
    private boolean d;
    private boolean e = true;
    private boolean f;
    private boolean g;
    private boolean h;

    public void a() {
        this.f = true;
    }

    @Override // com.badlogic.gdx.utils.z.a
    public void reset() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = false;
    }

    public ok b() {
        return this.b;
    }

    public void a(ok okVar) {
        this.b = okVar;
    }

    public ok c() {
        return this.c;
    }

    public void b(ok okVar) {
        this.c = okVar;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.h;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(oq oqVar) {
        this.a = oqVar;
    }

    public oq h() {
        return this.a;
    }
}
