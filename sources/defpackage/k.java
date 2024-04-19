package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.ao;
import defpackage.l;
import defpackage.o;
import defpackage.p;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedStateListDrawableCompat.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: k  reason: default package */
/* loaded from: classes.dex */
public class k extends o implements androidx.core.graphics.drawable.b {
    private static final String a = "k";
    private b b;
    private f c;
    private int d;
    private int e;
    private boolean f;

    @Override // defpackage.o, defpackage.l, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // defpackage.o, defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public k() {
        this(null, null);
    }

    k(b bVar, Resources resources) {
        super(null);
        this.d = -1;
        this.e = -1;
        a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static k a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        k kVar = new k();
        kVar.b(context, resources, xmlPullParser, attributeSet, theme);
        return kVar;
    }

    @Override // defpackage.o
    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = ek.a(resources, theme, attributeSet, p.b.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(p.b.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        e();
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.c != null && (visible || z2)) {
            if (z) {
                this.c.a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // defpackage.l, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.c;
        if (fVar != null) {
            fVar.b();
            this.c = null;
            a(this.d);
            this.d = -1;
            this.e = -1;
        }
    }

    @Override // defpackage.o, defpackage.l, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int a2 = this.b.a(iArr);
        boolean z = a2 != d() && (b(a2) || a(a2));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    private boolean b(int i) {
        int d2;
        int a2;
        f aVar;
        f fVar = this.c;
        if (fVar != null) {
            if (i == this.d) {
                return true;
            }
            if (i == this.e && fVar.c()) {
                fVar.d();
                this.d = this.e;
                this.e = i;
                return true;
            }
            d2 = this.d;
            fVar.b();
        } else {
            d2 = d();
        }
        this.c = null;
        this.e = -1;
        this.d = -1;
        b bVar = this.b;
        int a3 = bVar.a(d2);
        int a4 = bVar.a(i);
        if (a4 == 0 || a3 == 0 || (a2 = bVar.a(a3, a4)) < 0) {
            return false;
        }
        boolean c2 = bVar.c(a3, a4);
        a(a2);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            aVar = new d((AnimationDrawable) current, bVar.b(a3, a4), c2);
        } else if (current instanceof ia) {
            aVar = new c((ia) current);
        } else if (!(current instanceof Animatable)) {
            return false;
        } else {
            aVar = new a((Animatable) current);
        }
        aVar.a();
        this.c = aVar;
        this.e = d2;
        this.d = i;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k$f */
    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }

        private f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k$a */
    /* loaded from: classes.dex */
    public static class a extends f {
        private final Animatable a;

        a(Animatable animatable) {
            super();
            this.a = animatable;
        }

        @Override // defpackage.k.f
        public void a() {
            this.a.start();
        }

        @Override // defpackage.k.f
        public void b() {
            this.a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k$d */
    /* loaded from: classes.dex */
    public static class d extends f {
        private final ObjectAnimator a;
        private final boolean b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(eVar.a());
            ofInt.setInterpolator(eVar);
            this.b = z2;
            this.a = ofInt;
        }

        @Override // defpackage.k.f
        public boolean c() {
            return this.b;
        }

        @Override // defpackage.k.f
        public void a() {
            this.a.start();
        }

        @Override // defpackage.k.f
        public void d() {
            this.a.reverse();
        }

        @Override // defpackage.k.f
        public void b() {
            this.a.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k$c */
    /* loaded from: classes.dex */
    public static class c extends f {
        private final ia a;

        c(ia iaVar) {
            super();
            this.a = iaVar;
        }

        @Override // defpackage.k.f
        public void a() {
            this.a.start();
        }

        @Override // defpackage.k.f
        public void b() {
            this.a.stop();
        }
    }

    private void a(TypedArray typedArray) {
        b bVar = this.b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f |= typedArray.getChangingConfigurations();
        }
        bVar.a(typedArray.getBoolean(p.b.AnimatedStateListDrawableCompat_android_variablePadding, bVar.k));
        bVar.b(typedArray.getBoolean(p.b.AnimatedStateListDrawableCompat_android_constantSize, bVar.n));
        bVar.c(typedArray.getInt(p.b.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.C));
        bVar.d(typedArray.getInt(p.b.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.D));
        setDither(typedArray.getBoolean(p.b.AnimatedStateListDrawableCompat_android_dither, bVar.z));
    }

    private void e() {
        onStateChange(getState());
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    e(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = ek.a(resources, theme, attributeSet, p.b.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(p.b.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(p.b.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(p.b.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable a3 = resourceId3 > 0 ? ao.a().a(context, resourceId3) : null;
        boolean z = a2.getBoolean(p.b.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        if (a3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                a3 = ia.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (a3 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId == -1 || resourceId2 == -1) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        } else {
            return this.b.a(resourceId, resourceId2, a3, z);
        }
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = ek.a(resources, theme, attributeSet, p.b.AnimatedStateListDrawableItem);
        int resourceId = a2.getResourceId(p.b.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a2.getResourceId(p.b.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable a3 = resourceId2 > 0 ? ao.a().a(context, resourceId2) : null;
        a2.recycle();
        int[] a4 = a(attributeSet);
        if (a3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                a3 = ig.a(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (a3 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        return this.b.a(a4, a3, resourceId);
    }

    @Override // defpackage.o, defpackage.l, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.b.a();
            this.f = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.o, defpackage.l
    /* renamed from: a */
    public b c() {
        return new b(this.b, this, null);
    }

    @Override // defpackage.o, defpackage.l
    void clearMutated() {
        super.clearMutated();
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k$b */
    /* loaded from: classes.dex */
    public static class b extends o.a {
        ar<Long> a;
        av<Integer> b;

        private static long f(int i, int i2) {
            return i2 | (i << 32);
        }

        b(b bVar, k kVar, Resources resources) {
            super(bVar, kVar, resources);
            if (bVar != null) {
                this.a = bVar.a;
                this.b = bVar.b;
                return;
            }
            this.a = new ar<>();
            this.b = new av<>();
        }

        @Override // defpackage.o.a, defpackage.l.c
        void a() {
            this.a = this.a.clone();
            this.b = this.b.clone();
        }

        int a(int i, int i2, Drawable drawable, boolean z) {
            int a = super.a(drawable);
            long f = f(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = a;
            this.a.c(f, Long.valueOf(j2 | j));
            if (z) {
                this.a.c(f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a;
        }

        int a(int[] iArr, Drawable drawable, int i) {
            int a = super.a(iArr, drawable);
            this.b.b(a, Integer.valueOf(i));
            return a;
        }

        int a(int[] iArr) {
            int b = super.b(iArr);
            return b >= 0 ? b : super.b(StateSet.WILD_CARD);
        }

        int a(int i) {
            if (i < 0) {
                return 0;
            }
            return this.b.a(i, 0).intValue();
        }

        int a(int i, int i2) {
            return (int) this.a.a(f(i, i2), -1L).longValue();
        }

        boolean b(int i, int i2) {
            return (this.a.a(f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        boolean c(int i, int i2) {
            return (this.a.a(f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // defpackage.o.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new k(this, null);
        }

        @Override // defpackage.o.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new k(this, resources);
        }
    }

    @Override // defpackage.o, defpackage.l
    void a(l.c cVar) {
        super.a(cVar);
        if (cVar instanceof b) {
            this.b = (b) cVar;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k$e */
    /* loaded from: classes.dex */
    private static class e implements TimeInterpolator {
        private int[] a;
        private int b;
        private int c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            int[] iArr = this.a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.a = new int[numberOfFrames];
            }
            int[] iArr2 = this.a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        int a() {
            return this.c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.c) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.c : 0.0f);
        }
    }
}
