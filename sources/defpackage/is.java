package defpackage;

import com.badlogic.gdx.utils.ai;
/* compiled from: InputMultiplexer.java */
/* renamed from: is  reason: default package */
/* loaded from: classes.dex */
public class is implements it {
    private ai<it> a = new ai<>(4);

    public is() {
    }

    public is(it... itVarArr) {
        this.a.a(itVarArr);
    }

    @Override // defpackage.it
    public boolean a(int i) {
        it[] f = this.a.f();
        try {
            int i2 = this.a.b;
            for (int i3 = 0; i3 < i2; i3++) {
                if (f[i3].a(i)) {
                    this.a.g();
                    return true;
                }
            }
            return false;
        } finally {
            this.a.g();
        }
    }

    @Override // defpackage.it
    public boolean b(int i) {
        it[] f = this.a.f();
        try {
            int i2 = this.a.b;
            for (int i3 = 0; i3 < i2; i3++) {
                if (f[i3].b(i)) {
                    this.a.g();
                    return true;
                }
            }
            return false;
        } finally {
            this.a.g();
        }
    }

    @Override // defpackage.it
    public boolean a(char c) {
        it[] f = this.a.f();
        try {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                if (f[i2].a(c)) {
                    this.a.g();
                    return true;
                }
            }
            return false;
        } finally {
            this.a.g();
        }
    }

    @Override // defpackage.it
    public boolean a(int i, int i2, int i3, int i4) {
        it[] f = this.a.f();
        try {
            int i5 = this.a.b;
            for (int i6 = 0; i6 < i5; i6++) {
                if (f[i6].a(i, i2, i3, i4)) {
                    this.a.g();
                    return true;
                }
            }
            return false;
        } finally {
            this.a.g();
        }
    }

    @Override // defpackage.it
    public boolean b(int i, int i2, int i3, int i4) {
        it[] f = this.a.f();
        try {
            int i5 = this.a.b;
            for (int i6 = 0; i6 < i5; i6++) {
                if (f[i6].b(i, i2, i3, i4)) {
                    this.a.g();
                    return true;
                }
            }
            return false;
        } finally {
            this.a.g();
        }
    }

    @Override // defpackage.it
    public boolean a(int i, int i2, int i3) {
        it[] f = this.a.f();
        try {
            int i4 = this.a.b;
            for (int i5 = 0; i5 < i4; i5++) {
                if (f[i5].a(i, i2, i3)) {
                    this.a.g();
                    return true;
                }
            }
            return false;
        } finally {
            this.a.g();
        }
    }

    @Override // defpackage.it
    public boolean b(int i, int i2) {
        it[] f = this.a.f();
        try {
            int i3 = this.a.b;
            for (int i4 = 0; i4 < i3; i4++) {
                if (f[i4].b(i, i2)) {
                    this.a.g();
                    return true;
                }
            }
            return false;
        } finally {
            this.a.g();
        }
    }

    @Override // defpackage.it
    public boolean c(int i) {
        it[] f = this.a.f();
        try {
            int i2 = this.a.b;
            for (int i3 = 0; i3 < i2; i3++) {
                if (f[i3].c(i)) {
                    this.a.g();
                    return true;
                }
            }
            return false;
        } finally {
            this.a.g();
        }
    }
}
