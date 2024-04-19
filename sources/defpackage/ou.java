package defpackage;

import com.badlogic.gdx.utils.a;
/* compiled from: ParallelAction.java */
/* renamed from: ou  reason: default package */
/* loaded from: classes.dex */
public class ou extends oj {
    a<oj> c = new a<>(4);
    private boolean d;

    @Override // defpackage.oj
    public void a() {
        this.d = false;
        a<oj> aVar = this.c;
        int i = aVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            aVar.a(i2).a();
        }
    }

    @Override // defpackage.oj, com.badlogic.gdx.utils.z.a
    public void reset() {
        super.reset();
        this.c.d();
    }

    public void a(oj ojVar) {
        this.c.a((a<oj>) ojVar);
        if (this.a != null) {
            ojVar.a(this.a);
        }
    }

    @Override // defpackage.oj
    public void a(ok okVar) {
        a<oj> aVar = this.c;
        int i = aVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            aVar.a(i2).a(okVar);
        }
        super.a(okVar);
    }

    @Override // defpackage.oj
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(super.toString());
        sb.append('(');
        a<oj> aVar = this.c;
        int i = aVar.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(aVar.a(i2));
        }
        sb.append(')');
        return sb.toString();
    }
}
