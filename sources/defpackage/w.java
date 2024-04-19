package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ag;
import androidx.appcompat.widget.ay;
import com.google.protobuf.CodedOutputStream;
import defpackage.i;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: SupportMenuInflater.java */
/* renamed from: w  reason: default package */
/* loaded from: classes.dex */
public class w extends MenuInflater {
    static final Class<?>[] a = {Context.class};
    static final Class<?>[] b = a;
    final Object[] c;
    final Object[] d;
    Context e;
    private Object f;

    public w(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
        this.d = this.c;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof ew)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.e.getResources().getLayout(i);
                    a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r4 = r11;
        r6 = null;
        r11 = false;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r11 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        switch(r4) {
            case 1: goto L55;
            case 2: goto L39;
            case 3: goto L10;
            default: goto L59;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        r4 = r9.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r5 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r4.equals(r6) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        r6 = null;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r4.equals("group") == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
        if (r4.equals("item") == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r0.d() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
        if (r0.a == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
        if (r0.a.c() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
        r0.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
        if (r4.equals("menu") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
        if (r5 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0094, code lost:
        r4 = r9.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009e, code lost:
        if (r4.equals("group") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
        r0.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:
        if (r4.equals("item") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ac, code lost:
        r0.b(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b6, code lost:
        if (r4.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b8, code lost:
        a(r9, r10, r0.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c0, code lost:
        r5 = true;
        r6 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ca, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cb, code lost:
        r4 = r9.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d1, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.view.Menu r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = this;
            w$b r0 = new w$b
            r0.<init>(r11)
            int r11 = r9.getEventType()
        L9:
            r1 = 2
            r2 = 1
            if (r11 != r1) goto L35
            java.lang.String r11 = r9.getName()
            java.lang.String r1 = "menu"
            boolean r1 = r11.equals(r1)
            if (r1 == 0) goto L1e
            int r11 = r9.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r10.append(r0)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L35:
            int r11 = r9.next()
            if (r11 != r2) goto L9
        L3b:
            r1 = 0
            r3 = 0
            r4 = r11
            r6 = r1
            r11 = r3
            r5 = r11
        L41:
            if (r11 != 0) goto Ld1
            switch(r4) {
                case 1: goto Lc3;
                case 2: goto L91;
                case 3: goto L48;
                default: goto L46;
            }
        L46:
            goto Lcb
        L48:
            java.lang.String r4 = r9.getName()
            if (r5 == 0) goto L58
            boolean r7 = r4.equals(r6)
            if (r7 == 0) goto L58
            r6 = r1
            r5 = r3
            goto Lcb
        L58:
            java.lang.String r7 = "group"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L65
            r0.a()
            goto Lcb
        L65:
            java.lang.String r7 = "item"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L87
            boolean r4 = r0.d()
            if (r4 != 0) goto Lcb
            fr r4 = r0.a
            if (r4 == 0) goto L83
            fr r4 = r0.a
            boolean r4 = r4.c()
            if (r4 == 0) goto L83
            r0.c()
            goto Lcb
        L83:
            r0.b()
            goto Lcb
        L87:
            java.lang.String r7 = "menu"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto Lcb
            r11 = r2
            goto Lcb
        L91:
            if (r5 == 0) goto L94
            goto Lcb
        L94:
            java.lang.String r4 = r9.getName()
            java.lang.String r7 = "group"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto La4
            r0.a(r10)
            goto Lcb
        La4:
            java.lang.String r7 = "item"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto Lb0
            r0.b(r10)
            goto Lcb
        Lb0:
            java.lang.String r7 = "menu"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto Lc0
            android.view.SubMenu r4 = r0.c()
            r8.a(r9, r10, r4)
            goto Lcb
        Lc0:
            r5 = r2
            r6 = r4
            goto Lcb
        Lc3:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.String r10 = "Unexpected end of document"
            r9.<init>(r10)
            throw r9
        Lcb:
            int r4 = r9.next()
            goto L41
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object a() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* renamed from: w$a */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] a = {MenuItem.class};
        private Object b;
        private Method c;

        public a(Object obj, String str) {
            this.b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.b, menuItem)).booleanValue();
                }
                this.c.invoke(this.b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* renamed from: w$b */
    /* loaded from: classes.dex */
    public class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;
        fr a;
        private Menu c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.c = menu;
            a();
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = w.this.e.obtainStyledAttributes(attributeSet, i.j.MenuGroup);
            this.d = obtainStyledAttributes.getResourceId(i.j.MenuGroup_android_id, 0);
            this.e = obtainStyledAttributes.getInt(i.j.MenuGroup_android_menuCategory, 0);
            this.f = obtainStyledAttributes.getInt(i.j.MenuGroup_android_orderInCategory, 0);
            this.g = obtainStyledAttributes.getInt(i.j.MenuGroup_android_checkableBehavior, 0);
            this.h = obtainStyledAttributes.getBoolean(i.j.MenuGroup_android_visible, true);
            this.i = obtainStyledAttributes.getBoolean(i.j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            ay a = ay.a(w.this.e, attributeSet, i.j.MenuItem);
            this.k = a.g(i.j.MenuItem_android_id, 0);
            this.l = (a.a(i.j.MenuItem_android_menuCategory, this.e) & (-65536)) | (a.a(i.j.MenuItem_android_orderInCategory, this.f) & 65535);
            this.m = a.c(i.j.MenuItem_android_title);
            this.n = a.c(i.j.MenuItem_android_titleCondensed);
            this.o = a.g(i.j.MenuItem_android_icon, 0);
            this.p = a(a.d(i.j.MenuItem_android_alphabeticShortcut));
            this.q = a.a(i.j.MenuItem_alphabeticModifiers, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            this.r = a(a.d(i.j.MenuItem_android_numericShortcut));
            this.s = a.a(i.j.MenuItem_numericModifiers, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            if (a.g(i.j.MenuItem_android_checkable)) {
                this.t = a.a(i.j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.t = this.g;
            }
            this.u = a.a(i.j.MenuItem_android_checked, false);
            this.v = a.a(i.j.MenuItem_android_visible, this.h);
            this.w = a.a(i.j.MenuItem_android_enabled, this.i);
            this.x = a.a(i.j.MenuItem_showAsAction, -1);
            this.B = a.d(i.j.MenuItem_android_onClick);
            this.y = a.g(i.j.MenuItem_actionLayout, 0);
            this.z = a.d(i.j.MenuItem_actionViewClass);
            this.A = a.d(i.j.MenuItem_actionProviderClass);
            boolean z = this.A != null;
            if (z && this.y == 0 && this.z == null) {
                this.a = (fr) a(this.A, w.b, w.this.d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.a = null;
            }
            this.C = a.c(i.j.MenuItem_contentDescription);
            this.D = a.c(i.j.MenuItem_tooltipText);
            if (a.g(i.j.MenuItem_iconTintMode)) {
                this.F = ag.a(a.a(i.j.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (a.g(i.j.MenuItem_iconTint)) {
                this.E = a.e(i.j.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            a.b();
            this.j = false;
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            int i = this.x;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.B != null) {
                if (w.this.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(w.this.a(), this.B));
            }
            if (this.t >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).a(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).a(true);
                }
            }
            String str = this.z;
            if (str != null) {
                menuItem.setActionView((View) a(str, w.a, w.this.c));
                z = true;
            }
            int i2 = this.y;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            fr frVar = this.a;
            if (frVar != null) {
                fy.a(menuItem, frVar);
            }
            fy.a(menuItem, this.C);
            fy.b(menuItem, this.D);
            fy.b(menuItem, this.p, this.q);
            fy.a(menuItem, this.r, this.s);
            PorterDuff.Mode mode = this.F;
            if (mode != null) {
                fy.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.E;
            if (colorStateList != null) {
                fy.a(menuItem, colorStateList);
            }
        }

        public void b() {
            this.j = true;
            a(this.c.add(this.d, this.k, this.l, this.m));
        }

        public SubMenu c() {
            this.j = true;
            SubMenu addSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.j;
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, w.this.e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
