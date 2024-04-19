package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: VuiAction.java */
/* renamed from: abq  reason: default package */
/* loaded from: classes.dex */
public enum abq {
    CLICK("Click"),
    SETVALUE("SetValue"),
    SCROLLBYX("ScrollByX"),
    SCROLLBYY("ScrollByY"),
    SETCHECK("SetCheck"),
    ITEMCLICK("ItemClick"),
    SELECTTAB("SelectTab"),
    SCROLLTO("ScrollTo"),
    SETSELECTED("SetSelected");
    
    private String a;

    abq(String str) {
        this.a = str;
    }

    public String getName() {
        return this.a;
    }

    public static List<String> getVuiActionList() {
        ArrayList arrayList = new ArrayList();
        for (abq abqVar : values()) {
            arrayList.add(abqVar.getName());
        }
        return arrayList;
    }
}
