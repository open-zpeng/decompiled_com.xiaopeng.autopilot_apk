package defpackage;

import android.os.IBinder;
/* compiled from: DisableInfoBean.java */
/* renamed from: xs  reason: default package */
/* loaded from: classes.dex */
public class xs extends xr {
    private IBinder a;
    private int b;
    private String c;
    private String d;
    private int e;

    public xs(IBinder iBinder, int i, String str, String str2, int i2) {
        this.a = iBinder;
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = i2;
    }

    public IBinder b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public String toString() {
        return "DisableInfoBean{binder=" + this.a + ", type=" + this.b + ", byWho='" + this.c + "', info='" + this.d + "', notifyType=" + this.e + '}';
    }
}
