package defpackage;

import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.k;
import java.nio.IntBuffer;
/* compiled from: DefaultTextureBinder.java */
/* renamed from: nf  reason: default package */
/* loaded from: classes.dex */
public final class nf implements nn {
    private final int a;
    private final int b;
    private final int c;
    private final ki[] d;
    private final int[] e;
    private final int f;
    private boolean g;
    private int h;
    private int i;
    private final no j;
    private int k;

    public nf(int i, int i2) {
        this(i, i2, -1);
    }

    public nf(int i, int i2, int i3) {
        this(i, i2, i3, 10);
    }

    public nf(int i, int i2, int i3, int i4) {
        this.h = 0;
        this.i = 0;
        this.j = new no();
        this.k = 0;
        int min = Math.min(c(), 32);
        i3 = i3 < 0 ? min - i2 : i3;
        if (i2 < 0 || i3 < 0 || i2 + i3 > min || i4 < 1) {
            throw new k("Illegal arguments");
        }
        this.f = i;
        this.a = i2;
        this.b = i3;
        this.d = new ki[i3];
        this.c = i4;
        this.e = i == 1 ? new int[i3] : null;
    }

    private static int c() {
        IntBuffer c = BufferUtils.c(16);
        io.g.glGetIntegerv(34930, c);
        return c.get(0);
    }

    @Override // defpackage.nn
    public void a() {
        for (int i = 0; i < this.b; i++) {
            this.d[i] = null;
            int[] iArr = this.e;
            if (iArr != null) {
                iArr[i] = 0;
            }
        }
    }

    @Override // defpackage.nn
    public void b() {
        io.g.glActiveTexture(33984);
    }

    @Override // defpackage.nn
    public final int a(no noVar) {
        return a(noVar, false);
    }

    private final int a(no noVar, boolean z) {
        int a;
        ki kiVar = noVar.a;
        this.g = false;
        switch (this.f) {
            case 0:
                a = this.a + a(kiVar);
                break;
            case 1:
                a = this.a + b(kiVar);
                break;
            default:
                return -1;
        }
        if (this.g) {
            this.h++;
            if (z) {
                kiVar.bind(a);
            } else {
                io.g.glActiveTexture(33984 + a);
            }
        } else {
            this.i++;
        }
        kiVar.unsafeSetWrap(noVar.d, noVar.e);
        kiVar.unsafeSetFilter(noVar.b, noVar.c);
        return a;
    }

    private final int a(ki kiVar) {
        int i = 0;
        while (true) {
            int i2 = this.b;
            if (i < i2) {
                int i3 = (this.k + i) % i2;
                if (this.d[i3] == kiVar) {
                    this.g = true;
                    return i3;
                }
                i++;
            } else {
                this.k = (this.k + 1) % i2;
                ki[] kiVarArr = this.d;
                int i4 = this.k;
                kiVarArr[i4] = kiVar;
                kiVar.bind(this.a + i4);
                return this.k;
            }
        }
    }

    private final int b(ki kiVar) {
        int i = -1;
        int i2 = this.e[0];
        int i3 = 0;
        for (int i4 = 0; i4 < this.b; i4++) {
            if (this.d[i4] == kiVar) {
                int[] iArr = this.e;
                iArr[i4] = iArr[i4] + this.c;
                i = i4;
            } else {
                int[] iArr2 = this.e;
                if (iArr2[i4] >= 0) {
                    int i5 = iArr2[i4] - 1;
                    iArr2[i4] = i5;
                    if (i5 >= i2) {
                    }
                }
                i2 = this.e[i4];
                i3 = i4;
            }
        }
        if (i < 0) {
            this.d[i3] = kiVar;
            this.e[i3] = 100;
            kiVar.bind(this.a + i3);
            return i3;
        }
        this.g = true;
        return i;
    }
}
