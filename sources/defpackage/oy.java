package defpackage;

import com.badlogic.gdx.math.f;
/* compiled from: TemporalAction.java */
/* renamed from: oy  reason: default package */
/* loaded from: classes.dex */
public abstract class oy extends oj {
    private float c;
    private float d;
    private f e;
    private boolean f;
    private boolean g;
    private boolean h;

    @Override // defpackage.oj
    public void a() {
        this.d = 0.0f;
        this.g = false;
        this.h = false;
    }

    @Override // defpackage.oj, com.badlogic.gdx.utils.z.a
    public void reset() {
        super.reset();
        this.f = false;
        this.e = null;
    }

    public void b(float f) {
        this.c = f;
    }

    public void a(f fVar) {
        this.e = fVar;
    }
}
