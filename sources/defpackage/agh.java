package defpackage;

import java.util.Map;
import java.util.logging.Level;
import org.greenrobot.eventbus.g;
/* compiled from: ExceptionToResourceMapping.java */
/* renamed from: agh  reason: default package */
/* loaded from: classes.dex */
public class agh {
    public final Map<Class<? extends Throwable>, Integer> a;

    public Integer a(Throwable th) {
        int i = 20;
        Throwable th2 = th;
        do {
            Integer b = b(th2);
            if (b == null) {
                th2 = th2.getCause();
                i--;
                if (i <= 0 || th2 == th) {
                    break;
                }
            } else {
                return b;
            }
        } while (th2 != null);
        g.a.a().a(Level.FINE, "No specific message resource ID found for " + th);
        return null;
    }

    protected Integer b(Throwable th) {
        Class<?> cls = th.getClass();
        Integer num = this.a.get(cls);
        if (num == null) {
            Class<? extends Throwable> cls2 = null;
            for (Map.Entry<Class<? extends Throwable>, Integer> entry : this.a.entrySet()) {
                Class<? extends Throwable> key = entry.getKey();
                if (key.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(key))) {
                    num = entry.getValue();
                    cls2 = key;
                }
            }
        }
        return num;
    }
}
