package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* compiled from: ClassReflection.java */
/* renamed from: qu  reason: default package */
/* loaded from: classes.dex */
public final class qu {
    public static Class a(String str) throws qx {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new qx("Class not found: " + str, e);
        }
    }

    public static String a(Class cls) {
        return cls.getSimpleName();
    }

    public static boolean a(Class cls, Class cls2) {
        return cls.isAssignableFrom(cls2);
    }

    public static boolean b(Class cls) {
        return cls.isMemberClass();
    }

    public static boolean c(Class cls) {
        return Modifier.isStatic(cls.getModifiers());
    }

    public static <T> T d(Class<T> cls) throws qx {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new qx("Could not instantiate instance of class: " + cls.getName(), e);
        } catch (InstantiationException e2) {
            throw new qx("Could not instantiate instance of class: " + cls.getName(), e2);
        }
    }

    public static qv a(Class cls, Class... clsArr) throws qx {
        try {
            return new qv(cls.getConstructor(clsArr));
        } catch (NoSuchMethodException e) {
            throw new qx("Constructor not found for class: " + cls.getName(), e);
        } catch (SecurityException e2) {
            throw new qx("Security violation occurred while getting constructor for class: '" + cls.getName() + "'.", e2);
        }
    }

    public static qv b(Class cls, Class... clsArr) throws qx {
        try {
            return new qv(cls.getDeclaredConstructor(clsArr));
        } catch (NoSuchMethodException e) {
            throw new qx("Constructor not found for class: " + cls.getName(), e);
        } catch (SecurityException e2) {
            throw new qx("Security violation while getting constructor for class: " + cls.getName(), e2);
        }
    }

    public static qw[] e(Class cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        qw[] qwVarArr = new qw[declaredFields.length];
        int length = declaredFields.length;
        for (int i = 0; i < length; i++) {
            qwVarArr[i] = new qw(declaredFields[i]);
        }
        return qwVarArr;
    }
}
