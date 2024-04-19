package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import defpackage.eg;
import defpackage.fi;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: TypefaceCompatApi24Impl.java */
/* renamed from: eq  reason: default package */
/* loaded from: classes.dex */
class eq extends eu {
    private static final Class<?> a;
    private static final Constructor<?> b;
    private static final Method c;
    private static final Method d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        b = constructor;
        a = cls;
        c = method2;
        d = method;
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static Object b() {
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // defpackage.eu
    public Typeface a(Context context, CancellationSignal cancellationSignal, fi.b[] bVarArr, int i) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        au auVar = new au();
        for (fi.b bVar : bVarArr) {
            Uri a2 = bVar.a();
            ByteBuffer byteBuffer = (ByteBuffer) auVar.get(a2);
            if (byteBuffer == null) {
                byteBuffer = ev.a(context, cancellationSignal, a2);
                auVar.put(a2, byteBuffer);
            }
            if (byteBuffer == null || !a(b2, byteBuffer, bVar.b(), bVar.c(), bVar.d())) {
                return null;
            }
        }
        Typeface a3 = a(b2);
        if (a3 == null) {
            return null;
        }
        return Typeface.create(a3, i);
    }

    @Override // defpackage.eu
    public Typeface a(Context context, eg.b bVar, Resources resources, int i) {
        eg.c[] a2;
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (eg.c cVar : bVar.a()) {
            ByteBuffer a3 = ev.a(context, resources, cVar.f());
            if (a3 == null || !a(b2, a3, cVar.e(), cVar.b(), cVar.c())) {
                return null;
            }
        }
        return a(b2);
    }
}
