package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/* compiled from: Constructor.java */
/* renamed from: qv  reason: default package */
/* loaded from: classes.dex */
public final class qv {
    private final Constructor a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qv(Constructor constructor) {
        this.a = constructor;
    }

    public Class a() {
        return this.a.getDeclaringClass();
    }

    public void a(boolean z) {
        this.a.setAccessible(z);
    }

    public Object a(Object... objArr) throws qx {
        try {
            return this.a.newInstance(objArr);
        } catch (IllegalAccessException e) {
            throw new qx("Could not instantiate instance of class: " + a().getName(), e);
        } catch (IllegalArgumentException e2) {
            throw new qx("Illegal argument(s) supplied to constructor for class: " + a().getName(), e2);
        } catch (InstantiationException e3) {
            throw new qx("Could not instantiate instance of class: " + a().getName(), e3);
        } catch (InvocationTargetException e4) {
            throw new qx("Exception occurred in constructor for class: " + a().getName(), e4);
        }
    }
}
