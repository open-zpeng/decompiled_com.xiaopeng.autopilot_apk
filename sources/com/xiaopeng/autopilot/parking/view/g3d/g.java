package com.xiaopeng.autopilot.parking.view.g3d;

import defpackage.rz;
import java.util.HashMap;
/* compiled from: InterferenceHelper.java */
/* loaded from: classes.dex */
public class g {
    private static HashMap<Class<? extends aci>, Float> a = new HashMap<Class<? extends aci>, Float>() { // from class: com.xiaopeng.autopilot.parking.view.g3d.g.1
        {
            put(ui.class, Float.valueOf(-0.0505f));
            put(ug.class, Float.valueOf(-0.0705f));
            put(uo.class, Float.valueOf(0.0f));
            put(un.class, Float.valueOf(0.0f));
            put(ub.class, Float.valueOf(0.2f));
            put(uf.class, Float.valueOf(-0.01f));
            put(up.class, Float.valueOf(0.1f));
            put(uv.class, Float.valueOf(0.1f));
            put(um.class, Float.valueOf(0.11f));
            put(uu.class, Float.valueOf(0.120000005f));
            put(uj.class, Float.valueOf(0.35000002f));
            put(ul.class, Float.valueOf(0.4f));
            put(c.class, Float.valueOf(0.15f));
            put(e.class, Float.valueOf(-50.0f));
            put(sl.class, Float.valueOf(0.15f));
            put(sq.class, Float.valueOf(0.15f));
            put(rz.a.class, Float.valueOf(0.1f));
        }
    };

    public static float a(Class<? extends aci> cls) {
        Float f = a.get(cls);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }
}
