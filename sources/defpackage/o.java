package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.ao;
import defpackage.l;
import defpackage.p;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateListDrawable.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: o  reason: default package */
/* loaded from: classes.dex */
public class o extends l {
    private a a;
    private boolean b;

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    o() {
        this(null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.l, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b = this.a.b(iArr);
        if (b < 0) {
            b = this.a.b(StateSet.WILD_CARD);
        }
        return a(b) || onStateChange;
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = ek.a(resources, theme, attributeSet, p.b.StateListDrawable);
        setVisible(a2.getBoolean(p.b.StateListDrawable_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    private void a(TypedArray typedArray) {
        a aVar = this.a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f |= typedArray.getChangingConfigurations();
        }
        aVar.k = typedArray.getBoolean(p.b.StateListDrawable_android_variablePadding, aVar.k);
        aVar.n = typedArray.getBoolean(p.b.StateListDrawable_android_constantSize, aVar.n);
        aVar.C = typedArray.getInt(p.b.StateListDrawable_android_enterFadeDuration, aVar.C);
        aVar.D = typedArray.getInt(p.b.StateListDrawable_android_exitFadeDuration, aVar.D);
        aVar.z = typedArray.getBoolean(p.b.StateListDrawable_android_dither, aVar.z);
    }

    private void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        a aVar = this.a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray a2 = ek.a(resources, theme, attributeSet, p.b.StateListDrawableItem);
                int resourceId = a2.getResourceId(p.b.StateListDrawableItem_android_drawable, -1);
                Drawable a3 = resourceId > 0 ? ao.a().a(context, resourceId) : null;
                a2.recycle();
                int[] a4 = a(attributeSet);
                if (a3 == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                }
                aVar.a(a4, a3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.b && super.mutate() == this) {
            this.a.a();
            this.b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.l
    /* renamed from: b */
    public a c() {
        return new a(this.a, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.l
    public void clearMutated() {
        super.clearMutated();
        this.b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateListDrawable.java */
    /* renamed from: o$a */
    /* loaded from: classes.dex */
    public static class a extends l.c {
        int[][] L;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, o oVar, Resources resources) {
            super(aVar, oVar, resources);
            if (aVar != null) {
                this.L = aVar.L;
            } else {
                this.L = new int[c()];
            }
        }

        @Override // defpackage.l.c
        void a() {
            int[][] iArr = this.L;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.L;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.L = iArr2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int[] iArr, Drawable drawable) {
            int a = a(drawable);
            this.L[a] = iArr;
            return a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int d = d();
            for (int i = 0; i < d; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new o(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new o(this, resources);
        }

        @Override // defpackage.l.c
        public void e(int i, int i2) {
            super.e(i, i2);
            int[][] iArr = new int[i2];
            System.arraycopy(this.L, 0, iArr, 0, i);
            this.L = iArr;
        }
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.l
    public void a(l.c cVar) {
        super.a(cVar);
        if (cVar instanceof a) {
            this.a = (a) cVar;
        }
    }

    o(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }
}
