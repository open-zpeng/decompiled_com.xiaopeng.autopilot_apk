package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ResourcesCompat.java */
/* renamed from: ej  reason: default package */
/* loaded from: classes.dex */
public final class ej {
    public static Drawable a(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: ej$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void a(int i);

        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            a(handler).post(new Runnable() { // from class: ej.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(typeface);
                }
            });
        }

        public final void a(final int i, Handler handler) {
            a(handler).post(new Runnable() { // from class: ej.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(i);
                }
            });
        }

        public static Handler a(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, aVar, null, true, false);
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i, i2, aVar, handler, z, z2);
        if (a2 == null && aVar == null && !z2) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface a(android.content.Context r14, android.content.res.Resources r15, android.util.TypedValue r16, int r17, int r18, defpackage.ej.a r19, android.os.Handler r20, boolean r21, boolean r22) {
        /*
            r0 = r15
            r1 = r16
            r4 = r17
            r5 = r18
            r9 = r19
            r10 = r20
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto Lae
            java.lang.CharSequence r1 = r1.string
            java.lang.String r11 = r1.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r11.startsWith(r1)
            r12 = -3
            r13 = 0
            if (r1 != 0) goto L25
            if (r9 == 0) goto L24
            r9.a(r12, r10)
        L24:
            return r13
        L25:
            android.graphics.Typeface r1 = defpackage.eo.a(r15, r4, r5)
            if (r1 == 0) goto L31
            if (r9 == 0) goto L30
            r9.a(r1, r10)
        L30:
            return r1
        L31:
            if (r22 == 0) goto L34
            return r13
        L34:
            java.lang.String r1 = r11.toLowerCase()     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
            if (r1 == 0) goto L68
            android.content.res.XmlResourceParser r1 = r15.getXml(r4)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
            eg$a r2 = defpackage.eg.a(r1, r15)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
            if (r2 != 0) goto L57
            java.lang.String r0 = "ResourcesCompat"
            java.lang.String r1 = "Failed to find font-family tag"
            android.util.Log.e(r0, r1)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
            if (r9 == 0) goto L56
            r9.a(r12, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
        L56:
            return r13
        L57:
            r1 = r14
            r3 = r15
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            android.graphics.Typeface r0 = defpackage.eo.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
            return r0
        L68:
            r1 = r14
            android.graphics.Typeface r0 = defpackage.eo.a(r14, r15, r4, r11, r5)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
            if (r9 == 0) goto L78
            if (r0 == 0) goto L75
            r9.a(r0, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
            goto L78
        L75:
            r9.a(r12, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L91
        L78:
            return r0
        L79:
            r0 = move-exception
            java.lang.String r1 = "ResourcesCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to read xml resource "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2, r0)
            goto La8
        L91:
            r0 = move-exception
            java.lang.String r1 = "ResourcesCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to parse xml resource "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2, r0)
        La8:
            if (r9 == 0) goto Lad
            r9.a(r12, r10)
        Lad:
            return r13
        Lae:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r15.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r17)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ej.a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, ej$a, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: ej$b */
    /* loaded from: classes.dex */
    public static final class b {
        public static void a(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                C0062b.a(theme);
            } else if (Build.VERSION.SDK_INT >= 23) {
                a.a(theme);
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: ej$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0062b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: ej$b$a */
        /* loaded from: classes.dex */
        static class a {
            private static final Object a = new Object();
            private static Method b;
            private static boolean c;

            static void a(Resources.Theme theme) {
                synchronized (a) {
                    if (!c) {
                        try {
                            b = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            b.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                        }
                        c = true;
                    }
                    if (b != null) {
                        try {
                            b.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                            b = null;
                        }
                    }
                }
            }
        }
    }
}
