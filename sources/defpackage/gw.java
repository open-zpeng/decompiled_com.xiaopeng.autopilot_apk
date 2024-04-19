package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
/* compiled from: AccessibilityClickableSpanCompat.java */
/* renamed from: gw  reason: default package */
/* loaded from: classes.dex */
public final class gw extends ClickableSpan {
    private final int a;
    private final gy b;
    private final int c;

    public gw(int i, gy gyVar, int i2) {
        this.a = i;
        this.b = gyVar;
        this.c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.a(this.c, bundle);
    }
}
