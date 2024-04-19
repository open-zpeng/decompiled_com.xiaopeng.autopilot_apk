package defpackage;
/* compiled from: VuiUpdateType.java */
/* renamed from: abv  reason: default package */
/* loaded from: classes.dex */
public enum abv {
    UPDATE_VIEW("view"),
    UPDATE_VIEW_ATTRIBUTE("attribute");
    
    private String a;

    abv(String str) {
        this.a = str;
    }

    public String getType() {
        return this.a;
    }
}
