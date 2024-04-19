package defpackage;
/* compiled from: VuiPriority.java */
/* renamed from: abu  reason: default package */
/* loaded from: classes.dex */
public enum abu {
    LEVEL1(0),
    LEVEL2(1),
    LEVEL3(2),
    LEVEL4(3);
    
    int a;

    abu(int i) {
        this.a = i;
    }

    public int getLevel() {
        return this.a;
    }
}
