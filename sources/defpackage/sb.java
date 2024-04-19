package defpackage;

import android.util.Log;
import com.badlogic.gdx.math.p;
/* compiled from: RoadModelInstance.java */
/* renamed from: sb  reason: default package */
/* loaded from: classes.dex */
public class sb {
    public la a;
    private p b;
    private p c;
    private boolean d = false;

    public void a(boolean z) {
        this.d = z;
    }

    public sb(ky kyVar) {
        this.a = new la(kyVar);
    }

    public void a(p pVar) {
        this.b = pVar;
    }

    public void b(p pVar) {
        this.c = pVar;
    }

    public boolean c(p pVar) {
        return ((double) Math.abs(this.b.b - pVar.b)) >= 2.0d && ((double) Math.abs(this.c.b - pVar.b)) >= 2.0d;
    }

    public boolean a(p pVar, boolean z) {
        float d = this.b.d(pVar);
        float d2 = this.c.d(pVar);
        boolean z2 = true;
        if (!z && d >= 65.0f && d2 >= 65.0f) {
            z2 = false;
        }
        Log.d("RoadModelInstance", "isVisible = " + z2 + " ; cdu_pos = " + pVar + "   ;startDis = " + d + " ; endDis = " + d2);
        return z2;
    }

    public boolean b(p pVar, boolean z) {
        float d = this.b.d(pVar);
        float d2 = this.c.d(pVar);
        double abs = Math.abs(this.b.b - pVar.b);
        double abs2 = Math.abs(this.c.b - pVar.b);
        boolean z2 = true;
        if (!z && ((d >= 65.0f && d2 >= 65.0f) || (abs >= 2.0d && abs2 >= 2.0d))) {
            z2 = false;
        }
        Log.d("RoadModelInstance", "isVisible = " + z2 + " ; cdu_pos = " + pVar + "   ;startDis = " + d + " ; endDis = " + d2 + "   ;startDisY = " + abs + " ; endDisY = " + abs2);
        return z2;
    }
}
