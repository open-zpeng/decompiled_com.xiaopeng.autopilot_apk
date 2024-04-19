package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.eg;
import defpackage.fi;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
/* compiled from: TypefaceCompatApi26Impl.java */
/* renamed from: er  reason: default package */
/* loaded from: classes.dex */
public class er extends ep {
    protected final Class<?> a;
    protected final Constructor<?> b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;

    public er() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> a = a();
            constructor = a(a);
            method2 = b(a);
            method3 = c(a);
            method4 = d(a);
            method5 = e(a);
            method = f(a);
            cls = a;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.a = cls;
        this.b = constructor;
        this.c = method2;
        this.d = method3;
        this.e = method4;
        this.f = method5;
        this.g = method;
    }

    private boolean b() {
        if (this.c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.c != null;
    }

    private Object c() {
        try {
            return this.b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    protected Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean b(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void c(Object obj) {
        try {
            this.f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    @Override // defpackage.ep, defpackage.eu
    public Typeface a(Context context, eg.b bVar, Resources resources, int i) {
        eg.c[] a;
        if (!b()) {
            return super.a(context, bVar, resources, i);
        }
        Object c = c();
        if (c == null) {
            return null;
        }
        for (eg.c cVar : bVar.a()) {
            if (!a(context, c, cVar.a(), cVar.e(), cVar.b(), cVar.c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                c(c);
                return null;
            }
        }
        if (b(c)) {
            return a(c);
        }
        return null;
    }

    @Override // defpackage.ep, defpackage.eu
    public Typeface a(Context context, CancellationSignal cancellationSignal, fi.b[] bVarArr, int i) {
        Typeface a;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!b()) {
            fi.b a2 = a(bVarArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.a(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.c()).setItalic(a2.d()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> a3 = ev.a(context, bVarArr, cancellationSignal);
        Object c = c();
        if (c == null) {
            return null;
        }
        boolean z = false;
        for (fi.b bVar : bVarArr) {
            ByteBuffer byteBuffer = a3.get(bVar.a());
            if (byteBuffer != null) {
                if (!a(c, byteBuffer, bVar.b(), bVar.c(), bVar.d() ? 1 : 0)) {
                    c(c);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            c(c);
            return null;
        } else if (b(c) && (a = a(c)) != null) {
            return Typeface.create(a, i);
        } else {
            return null;
        }
    }

    @Override // defpackage.eu
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!b()) {
            return super.a(context, resources, i, str, i2);
        }
        Object c = c();
        if (c == null) {
            return null;
        }
        if (!a(context, c, str, 0, -1, -1, null)) {
            c(c);
            return null;
        } else if (b(c)) {
            return a(c);
        } else {
            return null;
        }
    }

    protected Class<?> a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> a(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    protected Method b(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method c(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method d(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    protected Method e(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method f(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
