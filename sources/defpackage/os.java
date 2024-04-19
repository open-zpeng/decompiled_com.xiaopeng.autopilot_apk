package defpackage;

import com.badlogic.gdx.math.f;
import com.badlogic.gdx.utils.aa;
import com.badlogic.gdx.utils.z;
/* compiled from: Actions.java */
/* renamed from: os  reason: default package */
/* loaded from: classes.dex */
public class os {
    public static <T extends oj> T a(Class<T> cls) {
        z a = aa.a((Class) cls);
        T t = (T) a.obtain();
        t.a(a);
        return t;
    }

    public static ow a(float f, float f2, float f3, f fVar) {
        ow owVar = (ow) a(ow.class);
        owVar.a(f, f2);
        owVar.b(f3);
        owVar.a(fVar);
        return owVar;
    }

    public static ot a(float f, float f2, f fVar) {
        ot otVar = (ot) a(ot.class);
        otVar.a(f);
        otVar.b(f2);
        otVar.a(fVar);
        return otVar;
    }

    public static ot a(float f, f fVar) {
        ot otVar = (ot) a(ot.class);
        otVar.a(0.0f);
        otVar.b(f);
        otVar.a(fVar);
        return otVar;
    }

    public static ov a() {
        return (ov) a(ov.class);
    }

    public static ox a(oj ojVar, oj ojVar2) {
        ox oxVar = (ox) a(ox.class);
        oxVar.a(ojVar);
        oxVar.a(ojVar2);
        return oxVar;
    }

    public static ou b(oj ojVar, oj ojVar2) {
        ou ouVar = (ou) a(ou.class);
        ouVar.a(ojVar);
        ouVar.a(ojVar2);
        return ouVar;
    }
}
