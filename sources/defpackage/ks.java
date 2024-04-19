package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
/* compiled from: VertexAttribute.java */
/* renamed from: ks  reason: default package */
/* loaded from: classes.dex */
public final class ks {
    public final int a;
    public final int b;
    public final boolean c;
    public final int d;
    public int e;
    public String f;
    public int g;
    private final int h;

    public ks(int i, int i2, String str) {
        this(i, i2, str, 0);
    }

    public ks(int i, int i2, String str, int i3) {
        this(i, i2, i == 4 ? 5121 : 5126, i == 4, str, i3);
    }

    public ks(int i, int i2, int i3, boolean z, String str) {
        this(i, i2, i3, z, str, 0);
    }

    public ks(int i, int i2, int i3, boolean z, String str, int i4) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.c = z;
        this.f = str;
        this.g = i4;
        this.h = Integer.numberOfTrailingZeros(i);
    }

    public static ks a() {
        return new ks(1, 3, "a_position");
    }

    public static ks a(int i) {
        return new ks(16, 2, "a_texCoord" + i, i);
    }

    public static ks b() {
        return new ks(8, 3, "a_normal");
    }

    public static ks c() {
        return new ks(4, 4, 5121, true, "a_color");
    }

    public static ks d() {
        return new ks(2, 4, 5126, false, "a_color");
    }

    public static ks e() {
        return new ks(128, 3, "a_tangent");
    }

    public static ks f() {
        return new ks(IRadioController.TEF663x_PCHANNEL, 3, "a_binormal");
    }

    public static ks b(int i) {
        return new ks(64, 2, "a_boneWeight" + i, i);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ks) {
            return a((ks) obj);
        }
        return false;
    }

    public boolean a(ks ksVar) {
        return ksVar != null && this.a == ksVar.a && this.b == ksVar.b && this.d == ksVar.d && this.c == ksVar.c && this.f.equals(ksVar.f) && this.g == ksVar.g;
    }

    public int g() {
        return (this.h << 8) + (this.g & 255);
    }

    public int h() {
        int i = this.d;
        if (i == 5126 || i == 5132) {
            return this.b * 4;
        }
        switch (i) {
            case 5120:
            case 5121:
                return this.b;
            case 5122:
            case 5123:
                return this.b * 2;
            default:
                return 0;
        }
    }

    public int hashCode() {
        return (((g() * 541) + this.b) * 541) + this.f.hashCode();
    }
}
