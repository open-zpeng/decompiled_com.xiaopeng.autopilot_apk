package com.xiaopeng.xui.widget.toggle;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import com.xiaopeng.xui.view.XViewDelegate;
import com.xiaopeng.xui.view.font.XFontScaleHelper;
import defpackage.acu;
@Deprecated
/* loaded from: classes.dex */
public class XTextToggle extends XToggleLayout {
    private CheckedTextView mContentTextView;
    private int mDrawableStartResId;
    private int mTextColorResId;
    private CharSequence mTextOff;
    private CharSequence mTextOn;

    public XTextToggle(Context context) {
        this(context, null);
    }

    public XTextToggle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, acu.k.XToggleLayout_Fill_TextToggle);
    }

    public XTextToggle(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, acu.k.XToggleLayout_Fill_TextToggle);
    }

    public XTextToggle(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, acu.l.XTextToggle, i, i2);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(acu.l.XTextToggle_android_textSize, 15);
        final XFontScaleHelper create = XFontScaleHelper.create(obtainStyledAttributes, acu.l.XTextToggle_android_textSize);
        if (create != null && this.mXViewDelegate != null) {
            this.mXViewDelegate.setFontScaleChangeCallback(new XViewDelegate.onFontScaleChangeCallback() { // from class: com.xiaopeng.xui.widget.toggle.-$$Lambda$XTextToggle$i_pFBXkvhpm2MTmIiwcFb8dK81E
                @Override // com.xiaopeng.xui.view.XViewDelegate.onFontScaleChangeCallback
                public final void onFontScaleChanged() {
                    create.refreshTextSize(XTextToggle.this.mContentTextView);
                }
            });
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(acu.l.XTextToggle_android_textColor);
        this.mTextColorResId = obtainStyledAttributes.getResourceId(acu.l.XTextToggle_android_textColor, 0);
        this.mContentTextView = new CheckedTextView(context);
        this.mContentTextView.setTextColor(colorStateList);
        this.mContentTextView.setTextSize(0, dimensionPixelSize);
        this.mContentTextView.setGravity(16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.mContentTextView, layoutParams);
        Drawable drawable = obtainStyledAttributes.getDrawable(acu.l.XTextToggle_android_drawableStart);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(acu.l.XTextToggle_android_drawablePadding, 0);
        if (drawable != null) {
            this.mContentTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mContentTextView.setCompoundDrawablePadding(dimensionPixelSize2);
        }
        this.mDrawableStartResId = obtainStyledAttributes.getResourceId(acu.l.XTextToggle_android_drawableStart, 0);
        this.mTextOn = obtainStyledAttributes.getText(acu.l.XTextToggle_android_textOn);
        this.mTextOff = obtainStyledAttributes.getText(acu.l.XTextToggle_android_textOff);
        syncTextState();
        obtainStyledAttributes.recycle();
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public void setTextOn(CharSequence charSequence) {
        this.mTextOn = charSequence;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public void setTextOff(CharSequence charSequence) {
        this.mTextOff = charSequence;
    }

    @Override // com.xiaopeng.xui.widget.toggle.XToggleLayout, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        syncTextState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.toggle.XToggleLayout
    public void updateThemeResource() {
        if (this.mTextColorResId != 0) {
            this.mContentTextView.setTextColor(getContext().getColorStateList(this.mTextColorResId));
        }
        if (this.mDrawableStartResId != 0) {
            this.mContentTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(getContext().getDrawable(this.mDrawableStartResId), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        super.updateThemeResource();
    }

    private void syncTextState() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean isChecked = isChecked();
        if (isChecked && (charSequence2 = this.mTextOn) != null) {
            setText(charSequence2);
        } else if (isChecked || (charSequence = this.mTextOff) == null) {
        } else {
            setText(charSequence);
        }
    }

    public void setText(CharSequence charSequence) {
        CheckedTextView checkedTextView = this.mContentTextView;
        if (checkedTextView != null) {
            checkedTextView.setText(charSequence);
        }
    }
}
