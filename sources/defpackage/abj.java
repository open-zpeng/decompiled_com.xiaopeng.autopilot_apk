package defpackage;

import java.util.List;
/* compiled from: Utils.java */
/* renamed from: abj  reason: default package */
/* loaded from: classes.dex */
public class abj {
    public static int[] a(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }
}
