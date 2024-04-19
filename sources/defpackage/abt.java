package defpackage;
/* compiled from: VuiMode.java */
/* renamed from: abt  reason: default package */
/* loaded from: classes.dex */
public enum abt {
    DISABLED("Disabled"),
    SILENT("Silent"),
    UNDERSTOOD("Understood"),
    NORMAL("Normal");
    
    String a;

    abt(String str) {
        this.a = str;
    }

    public String getName() {
        return this.a;
    }
}
