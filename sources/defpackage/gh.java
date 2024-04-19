package defpackage;

import android.view.View;
import android.view.ViewGroup;
/* compiled from: NestedScrollingParentHelper.java */
/* renamed from: gh  reason: default package */
/* loaded from: classes.dex */
public class gh {
    private int a;
    private int b;

    public gh(ViewGroup viewGroup) {
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.b = i;
        } else {
            this.a = i;
        }
    }

    public int a() {
        return this.a | this.b;
    }

    public void a(View view, int i) {
        if (i == 1) {
            this.b = 0;
        } else {
            this.a = 0;
        }
    }
}
