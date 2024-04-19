package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: Field.java */
/* renamed from: qw  reason: default package */
/* loaded from: classes.dex */
public final class qw {
    private final Field a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qw(Field field) {
        this.a = field;
    }

    public String a() {
        return this.a.getName();
    }

    public Class b() {
        return this.a.getType();
    }

    public Class c() {
        return this.a.getDeclaringClass();
    }

    public boolean d() {
        return this.a.isAccessible();
    }

    public void a(boolean z) {
        this.a.setAccessible(z);
    }

    public boolean e() {
        return Modifier.isStatic(this.a.getModifiers());
    }

    public boolean f() {
        return Modifier.isTransient(this.a.getModifiers());
    }

    public boolean g() {
        return this.a.isSynthetic();
    }

    public Class a(int i) {
        Type genericType = this.a.getGenericType();
        if (genericType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
            if (actualTypeArguments.length - 1 >= i) {
                Type type = actualTypeArguments[i];
                if (type instanceof Class) {
                    return (Class) type;
                }
                if (type instanceof ParameterizedType) {
                    return (Class) ((ParameterizedType) type).getRawType();
                }
                if (type instanceof GenericArrayType) {
                    Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
                    if (genericComponentType instanceof Class) {
                        return qt.a((Class) genericComponentType, 0).getClass();
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public boolean a(Class<? extends Annotation> cls) {
        return this.a.isAnnotationPresent(cls);
    }

    public Object a(Object obj) throws qx {
        try {
            return this.a.get(obj);
        } catch (IllegalAccessException e) {
            throw new qx("Illegal access to field: " + a(), e);
        } catch (IllegalArgumentException e2) {
            throw new qx("Object is not an instance of " + c(), e2);
        }
    }

    public void a(Object obj, Object obj2) throws qx {
        try {
            this.a.set(obj, obj2);
        } catch (IllegalAccessException e) {
            throw new qx("Illegal access to field: " + a(), e);
        } catch (IllegalArgumentException e2) {
            throw new qx("Argument not valid for field: " + a(), e2);
        }
    }
}
