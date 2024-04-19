package defpackage;
/* compiled from: Application.java */
/* renamed from: ij  reason: default package */
/* loaded from: classes.dex */
public interface ij {

    /* compiled from: Application.java */
    /* renamed from: ij$a */
    /* loaded from: classes.dex */
    public enum a {
        Android,
        Desktop,
        HeadlessDesktop,
        Applet,
        WebGL,
        iOS
    }

    void addLifecycleListener(iu iuVar);

    void debug(String str, String str2);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th);

    ik getApplicationListener();

    ip getGraphics();

    a getType();

    void log(String str, String str2);

    void log(String str, String str2, Throwable th);

    void postRunnable(Runnable runnable);

    void removeLifecycleListener(iu iuVar);
}
