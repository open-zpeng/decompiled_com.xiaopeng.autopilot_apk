package defpackage;
/* compiled from: Files.java */
/* renamed from: in  reason: default package */
/* loaded from: classes.dex */
public interface in {

    /* compiled from: Files.java */
    /* renamed from: in$a */
    /* loaded from: classes.dex */
    public enum a {
        Classpath,
        Internal,
        External,
        Absolute,
        Local
    }

    jy classpath(String str);

    String getExternalStoragePath();

    jy getFileHandle(String str, a aVar);

    String getLocalStoragePath();

    jy internal(String str);
}
