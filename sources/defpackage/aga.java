package defpackage;

import android.util.Log;
import java.util.logging.Level;
import org.greenrobot.eventbus.g;
/* compiled from: AndroidLogger.java */
/* renamed from: aga  reason: default package */
/* loaded from: classes.dex */
public class aga implements g {
    private static final boolean a;
    private final String b;

    static {
        boolean z = false;
        try {
            if (Class.forName("android.util.Log") != null) {
                z = true;
            }
        } catch (ClassNotFoundException unused) {
        }
        a = z;
    }

    public static boolean a() {
        return a;
    }

    public aga(String str) {
        this.b = str;
    }

    @Override // org.greenrobot.eventbus.g
    public void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(a(level), this.b, str);
        }
    }

    @Override // org.greenrobot.eventbus.g
    public void a(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int a2 = a(level);
            String str2 = this.b;
            Log.println(a2, str2, str + "\n" + Log.getStackTraceString(th));
        }
    }

    private int a(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        } else if (intValue < 900) {
            return 4;
        } else {
            return intValue < 1000 ? 5 : 6;
        }
    }
}
