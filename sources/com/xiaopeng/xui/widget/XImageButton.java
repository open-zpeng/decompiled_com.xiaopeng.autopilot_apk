package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.n;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.xui.utils.XBackgroundPaddingUtils;
import com.xiaopeng.xui.view.XViewDelegate;
import com.xiaopeng.xui.vui.VuiView;
/* loaded from: classes.dex */
public class XImageButton extends n implements VuiView {
    Rect mRectBgPadding;
    protected XViewDelegate mXViewDelegate;

    public XImageButton(Context context) {
        super(context);
    }

    public XImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mXViewDelegate = XViewDelegate.create(this, attributeSet);
        init(attributeSet);
    }

    public XImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mXViewDelegate = XViewDelegate.create(this, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        initVui(this, attributeSet);
        this.mRectBgPadding = XBackgroundPaddingUtils.backgroundPadding(this, attributeSet);
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate == null || xViewDelegate.getThemeViewModel() == null) {
            return;
        }
        this.mXViewDelegate.getThemeViewModel().setCallback(new ThemeViewModel.OnCallback() { // from class: com.xiaopeng.xui.widget.-$$Lambda$XImageButton$EupZ0mKod2YG9yQNqkISe1XuScc
            @Override // com.xiaopeng.libtheme.ThemeViewModel.OnCallback
            public final void onThemeChanged() {
                r0.post(new Runnable() { // from class: com.xiaopeng.xui.widget.-$$Lambda$XImageButton$xJZgpIAUpadxlSrzHwqmP5RqqrA
                    @Override // java.lang.Runnable
                    public final void run() {
                        XImageButton.lambda$null$0(XImageButton.this);
                    }
                });
            }
        });
    }

    public static /* synthetic */ void lambda$null$0(XImageButton xImageButton) {
        if (xImageButton.mRectBgPadding != null) {
            xImageButton.logD("XImageButton change theme reset backgroundPadding");
            xImageButton.mRectBgPadding = XBackgroundPaddingUtils.backgroundPadding(xImageButton, xImageButton.mRectBgPadding.left, xImageButton.mRectBgPadding.top, xImageButton.mRectBgPadding.right, xImageButton.mRectBgPadding.bottom);
        }
    }

    public void backgroundPadding(int i, int i2, int i3, int i4) {
        this.mRectBgPadding = XBackgroundPaddingUtils.backgroundPadding(this, i, i2, i3, i4);
    }

    @Override // androidx.appcompat.widget.n, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate == null || xViewDelegate.getThemeViewModel() == null) {
            return;
        }
        this.mXViewDelegate.getThemeViewModel().setImageResource(i);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate != null) {
            xViewDelegate.onConfigurationChanged(configuration);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate != null) {
            xViewDelegate.onAttachedToWindow();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate != null) {
            xViewDelegate.onDetachedFromWindow();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        setVuiVisibility(this, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        setVuiSelected(this, z);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        releaseVui();
    }
}
