package defpackage;

import com.xiaopeng.autopilot.base.c;
import com.xiaopeng.autopilot.parking.view.g3d.l;
/* compiled from: RadarCalculator.java */
/* renamed from: uk  reason: default package */
/* loaded from: classes.dex */
public class uk {
    private static long a;
    private static long b;

    public static float a(float f) {
        return (f * 1.0f) / 70.0f;
    }

    public static l[] a(l[] lVarArr) {
        try {
            float[] frontRadarData = c.a().b().getFrontRadarData();
            int[] frontRadarLevel = c.a().d().getFrontRadarLevel();
            int[] frontRadarFaultSt = c.a().d().getFrontRadarFaultSt();
            int scuFrontMinDistance = c.a().d().getScuFrontMinDistance();
            lVarArr[0].a(new vb(frontRadarData));
            lVarArr[0].a(frontRadarLevel);
            lVarArr[0].b(frontRadarFaultSt);
            lVarArr[0].a(scuFrontMinDistance);
            lVarArr[0].a(true);
        } catch (Exception e) {
            if (System.currentTimeMillis() - a > 10000) {
                a = System.currentTimeMillis();
                e.printStackTrace();
            }
        }
        try {
            float[] tailRadarData = c.a().b().getTailRadarData();
            int[] tailRadarLevel = c.a().d().getTailRadarLevel();
            int[] tailRadarFaultSt = c.a().d().getTailRadarFaultSt();
            int scuRearMinDistance = c.a().d().getScuRearMinDistance();
            lVarArr[1].a(new vb(tailRadarData));
            lVarArr[1].a(tailRadarLevel);
            lVarArr[1].b(tailRadarFaultSt);
            lVarArr[1].a(scuRearMinDistance);
        } catch (Exception e2) {
            if (System.currentTimeMillis() - b > 10000) {
                b = System.currentTimeMillis();
                e2.printStackTrace();
            }
        }
        return lVarArr;
    }
}
