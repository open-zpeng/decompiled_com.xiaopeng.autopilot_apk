package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import com.xiaopeng.xui.view.XViewDelegate;
import com.xiaopeng.xui.vui.VuiView;
/* loaded from: classes.dex */
public class XViewPager extends ii implements VuiView {
    protected XViewDelegate mXViewDelegate;

    public XViewPager(Context context) {
        super(context);
    }

    public XViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mXViewDelegate = XViewDelegate.create(this, attributeSet);
        initVui(this, attributeSet);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate != null) {
            xViewDelegate.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ii, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate != null) {
            xViewDelegate.onAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ii, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate != null) {
            xViewDelegate.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        setVuiVisibility(this, i);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        updateVui(this, abv.UPDATE_VIEW);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        updateVui(this, abv.UPDATE_VIEW);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        releaseVui();
    }
}
