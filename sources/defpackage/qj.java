package defpackage;

import com.badlogic.gdx.graphics.glutils.g;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
/* compiled from: ScissorStack.java */
/* renamed from: qj  reason: default package */
/* loaded from: classes.dex */
public class qj {
    private static a<n> c = new a<>();
    static p a = new p();
    static final n b = new n();

    public static boolean a(n nVar) {
        b(nVar);
        if (c.b == 0) {
            if (nVar.width < 1.0f || nVar.height < 1.0f) {
                return false;
            }
            io.g.glEnable(3089);
        } else {
            a<n> aVar = c;
            n a2 = aVar.a(aVar.b - 1);
            float max = Math.max(a2.x, nVar.x);
            float min = Math.min(a2.x + a2.width, nVar.x + nVar.width) - max;
            if (min < 1.0f) {
                return false;
            }
            float max2 = Math.max(a2.y, nVar.y);
            float min2 = Math.min(a2.y + a2.height, nVar.y + nVar.height) - max2;
            if (min2 < 1.0f) {
                return false;
            }
            nVar.x = max;
            nVar.y = max2;
            nVar.width = min;
            nVar.height = Math.max(1.0f, min2);
        }
        c.a((a<n>) nVar);
        g.a((int) nVar.x, (int) nVar.y, (int) nVar.width, (int) nVar.height);
        return true;
    }

    public static n a() {
        n a2 = c.a();
        if (c.b == 0) {
            io.g.glDisable(3089);
        } else {
            n b2 = c.b();
            g.a((int) b2.x, (int) b2.y, (int) b2.width, (int) b2.height);
        }
        return a2;
    }

    private static void b(n nVar) {
        nVar.x = Math.round(nVar.x);
        nVar.y = Math.round(nVar.y);
        nVar.width = Math.round(nVar.width);
        nVar.height = Math.round(nVar.height);
        if (nVar.width < 0.0f) {
            nVar.width = -nVar.width;
            nVar.x -= nVar.width;
        }
        if (nVar.height < 0.0f) {
            nVar.height = -nVar.height;
            nVar.y -= nVar.height;
        }
    }

    public static void a(jz jzVar, float f, float f2, float f3, float f4, Matrix4 matrix4, n nVar, n nVar2) {
        a.a(nVar.x, nVar.y, 0.0f);
        a.a(matrix4);
        jzVar.b(a, f, f2, f3, f4);
        nVar2.x = a.a;
        nVar2.y = a.b;
        a.a(nVar.x + nVar.width, nVar.y + nVar.height, 0.0f);
        a.a(matrix4);
        jzVar.b(a, f, f2, f3, f4);
        nVar2.width = a.a - nVar2.x;
        nVar2.height = a.b - nVar2.y;
    }
}
