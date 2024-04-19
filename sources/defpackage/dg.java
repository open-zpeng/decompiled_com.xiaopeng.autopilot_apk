package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.b;
import java.util.HashMap;
import java.util.HashSet;
/* compiled from: Key.java */
/* renamed from: dg  reason: default package */
/* loaded from: classes.dex */
public abstract class dg {
    public static int a = -1;
    int b;
    int c;
    String d;
    protected int e;
    HashMap<String, b> f;

    @Override // 
    /* renamed from: a */
    public abstract dg clone();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Context context, AttributeSet attributeSet);

    public abstract void a(HashMap<String, da> hashMap);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(HashSet<String> hashSet);

    public void b(HashMap<String, Integer> hashMap) {
    }

    public dg() {
        int i = a;
        this.b = i;
        this.c = i;
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        String str2 = this.d;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public dg a(dg dgVar) {
        this.b = dgVar.b;
        this.c = dgVar.c;
        this.d = dgVar.d;
        this.e = dgVar.e;
        this.f = dgVar.f;
        return this;
    }

    public dg a(int i) {
        this.c = i;
        return this;
    }
}
