package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.b;
/* compiled from: NodePart.java */
/* renamed from: mc  reason: default package */
/* loaded from: classes.dex */
public class mc {
    public ly a;
    public kx b;
    public b<lz, Matrix4> c;
    public Matrix4[] d;
    public boolean e = true;

    public mc() {
    }

    public mc(ly lyVar, kx kxVar) {
        this.a = lyVar;
        this.b = kxVar;
    }

    public lb a(lb lbVar) {
        lbVar.c = this.b;
        lbVar.b.a(this.a);
        lbVar.e = this.d;
        return lbVar;
    }

    public mc a() {
        return new mc().a(this);
    }

    protected mc a(mc mcVar) {
        this.a = new ly(mcVar.a);
        this.b = mcVar.b;
        this.e = mcVar.e;
        b<lz, Matrix4> bVar = mcVar.c;
        if (bVar == null) {
            this.c = null;
            this.d = null;
        } else {
            b<lz, Matrix4> bVar2 = this.c;
            if (bVar2 == null) {
                this.c = new b<>(true, bVar.c, lz.class, Matrix4.class);
            } else {
                bVar2.a();
            }
            this.c.a(mcVar.c);
            Matrix4[] matrix4Arr = this.d;
            if (matrix4Arr == null || matrix4Arr.length != this.c.c) {
                this.d = new Matrix4[this.c.c];
            }
            int i = 0;
            while (true) {
                Matrix4[] matrix4Arr2 = this.d;
                if (i >= matrix4Arr2.length) {
                    break;
                }
                if (matrix4Arr2[i] == null) {
                    matrix4Arr2[i] = new Matrix4();
                }
                i++;
            }
        }
        return this;
    }
}
