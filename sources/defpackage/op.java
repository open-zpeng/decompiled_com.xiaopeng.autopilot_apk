package defpackage;

import com.badlogic.gdx.math.o;
/* compiled from: InputListener.java */
/* renamed from: op  reason: default package */
/* loaded from: classes.dex */
public class op implements om {
    private static final o a = new o();

    public void a(oo ooVar, float f, float f2, int i) {
    }

    public void a(oo ooVar, float f, float f2, int i, ok okVar) {
    }

    public boolean a(oo ooVar, char c) {
        return false;
    }

    public boolean a(oo ooVar, float f, float f2) {
        return false;
    }

    public boolean a(oo ooVar, float f, float f2, int i, int i2) {
        return false;
    }

    public boolean a(oo ooVar, int i) {
        return false;
    }

    public void b(oo ooVar, float f, float f2, int i, int i2) {
    }

    public void b(oo ooVar, float f, float f2, int i, ok okVar) {
    }

    public boolean b(oo ooVar, float f, float f2, int i) {
        return false;
    }

    public boolean b(oo ooVar, int i) {
        return false;
    }

    @Override // defpackage.om
    public boolean a(ol olVar) {
        if (olVar instanceof oo) {
            oo ooVar = (oo) olVar;
            switch (ooVar.i()) {
                case keyDown:
                    return a(ooVar, ooVar.l());
                case keyUp:
                    return b(ooVar, ooVar.l());
                case keyTyped:
                    return a(ooVar, ooVar.m());
                default:
                    ooVar.a(ooVar.c(), a);
                    switch (ooVar.i()) {
                        case touchDown:
                            return a(ooVar, a.d, a.e, ooVar.j(), ooVar.k());
                        case touchUp:
                            b(ooVar, a.d, a.e, ooVar.j(), ooVar.k());
                            return true;
                        case touchDragged:
                            a(ooVar, a.d, a.e, ooVar.j());
                            return true;
                        case mouseMoved:
                            return a(ooVar, a.d, a.e);
                        case scrolled:
                            return b(ooVar, a.d, a.e, ooVar.n());
                        case enter:
                            a(ooVar, a.d, a.e, ooVar.j(), ooVar.o());
                            return false;
                        case exit:
                            b(ooVar, a.d, a.e, ooVar.j(), ooVar.o());
                            return false;
                        default:
                            return false;
                    }
            }
        }
        return false;
    }
}
