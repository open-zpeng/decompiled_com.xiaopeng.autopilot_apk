package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.af;
/* compiled from: CardView.java */
/* renamed from: ag  reason: default package */
/* loaded from: classes.dex */
public class ag extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {16842801};
    private static final al IMPL;
    private final ak mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new ai();
        } else if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new ah();
        } else {
            IMPL = new aj();
        }
        IMPL.a();
    }

    public ag(Context context) {
        this(context, null);
    }

    public ag(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, af.a.cardViewStyle);
    }

    public ag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int color;
        ColorStateList valueOf;
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new ak() { // from class: ag.1
            private Drawable b;

            @Override // defpackage.ak
            public void a(Drawable drawable) {
                this.b = drawable;
                ag.this.setBackgroundDrawable(drawable);
            }

            @Override // defpackage.ak
            public boolean a() {
                return ag.this.getUseCompatPadding();
            }

            @Override // defpackage.ak
            public boolean b() {
                return ag.this.getPreventCornerOverlap();
            }

            @Override // defpackage.ak
            public void a(int i2, int i3, int i4, int i5) {
                ag.this.mShadowBounds.set(i2, i3, i4, i5);
                ag agVar = ag.this;
                ag.super.setPadding(i2 + agVar.mContentPadding.left, i3 + ag.this.mContentPadding.top, i4 + ag.this.mContentPadding.right, i5 + ag.this.mContentPadding.bottom);
            }

            @Override // defpackage.ak
            public void a(int i2, int i3) {
                if (i2 > ag.this.mUserSetMinWidth) {
                    ag.super.setMinimumWidth(i2);
                }
                if (i3 > ag.this.mUserSetMinHeight) {
                    ag.super.setMinimumHeight(i3);
                }
            }

            @Override // defpackage.ak
            public Drawable c() {
                return this.b;
            }

            @Override // defpackage.ak
            public View d() {
                return ag.this;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, af.e.CardView, i, af.d.CardView);
        if (obtainStyledAttributes.hasValue(af.e.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(af.e.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(af.b.cardview_light_background);
            } else {
                color = getResources().getColor(af.b.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        float dimension = obtainStyledAttributes.getDimension(af.e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(af.e.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(af.e.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(af.e.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(af.e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(af.e.CardView_contentPadding, 0);
        this.mContentPadding.left = obtainStyledAttributes.getDimensionPixelSize(af.e.CardView_contentPaddingLeft, dimensionPixelSize);
        this.mContentPadding.top = obtainStyledAttributes.getDimensionPixelSize(af.e.CardView_contentPaddingTop, dimensionPixelSize);
        this.mContentPadding.right = obtainStyledAttributes.getDimensionPixelSize(af.e.CardView_contentPaddingRight, dimensionPixelSize);
        this.mContentPadding.bottom = obtainStyledAttributes.getDimensionPixelSize(af.e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(af.e.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(af.e.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        IMPL.a(this.mCardViewDelegate, context, valueOf, dimension, dimension2, f);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.g(this.mCardViewDelegate);
        }
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.f(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(IMPL instanceof ai)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(IMPL.b(this.mCardViewDelegate)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(IMPL.c(this.mCardViewDelegate)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        IMPL.a(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        IMPL.a(this.mCardViewDelegate, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.i(this.mCardViewDelegate);
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public void setRadius(float f) {
        IMPL.a(this.mCardViewDelegate, f);
    }

    public float getRadius() {
        return IMPL.d(this.mCardViewDelegate);
    }

    public void setCardElevation(float f) {
        IMPL.c(this.mCardViewDelegate, f);
    }

    public float getCardElevation() {
        return IMPL.e(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.b(this.mCardViewDelegate, f);
    }

    public float getMaxCardElevation() {
        return IMPL.a(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.h(this.mCardViewDelegate);
        }
    }
}
