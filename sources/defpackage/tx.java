package defpackage;

import android.util.Log;
import com.xiaopeng.autopilot.base.i;
/* compiled from: ParkingStateMachinePresenter.java */
/* renamed from: tx  reason: default package */
/* loaded from: classes.dex */
public class tx implements tp {
    @Override // defpackage.tp
    public void a(Boolean bool, Boolean bool2, Boolean bool3) {
        i.d a = i.a(i.o.class);
        if (a != null) {
            i.o.a d = ((i.o) a).d();
            d.a = bool != null ? bool.booleanValue() : d.a;
            d.b = bool2 != null ? bool2.booleanValue() : d.b;
            d.c = bool3 != null ? bool3.booleanValue() : d.c;
            Log.i("ParkingStateMachinePresenter", "StateMachine.CurrentRenderState:\t" + d.toString());
            return;
        }
        i.o.a aVar = new i.o.a(bool != null ? bool.booleanValue() : false, bool2 != null ? bool2.booleanValue() : false, bool3 != null ? bool3.booleanValue() : false);
        i.a(i.o.class, aVar);
        Log.i("ParkingStateMachinePresenter", "StateMachine.CurrentRenderState: new\t" + aVar.toString());
    }
}
