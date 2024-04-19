package defpackage;

import com.badlogic.gdx.math.o;
import com.badlogic.gdx.utils.ae;
/* compiled from: ScalingViewport.java */
/* renamed from: qy  reason: default package */
/* loaded from: classes.dex */
public class qy extends qz {
    private ae a;

    public qy(ae aeVar, float f, float f2, jz jzVar) {
        this.a = aeVar;
        a(f, f2);
        a(jzVar);
    }

    @Override // defpackage.qz
    public void a(int i, int i2, boolean z) {
        o apply = this.a.apply(b(), c(), i, i2);
        int round = Math.round(apply.d);
        int round2 = Math.round(apply.e);
        a((i - round) / 2, (i2 - round2) / 2, round, round2);
        a(z);
    }
}
