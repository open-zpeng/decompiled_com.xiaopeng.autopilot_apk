package com.xiaopeng.xui.widget.pageindicator;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import com.xiaopeng.xui.widget.XLinearLayout;
import defpackage.acu;
import defpackage.ii;
/* loaded from: classes.dex */
public abstract class XViewPagerIndicatorAbs extends XLinearLayout {
    private DataSetObserver mDataSetObserver;
    private ii.e mOnAdapterChangeListener;
    private ii.j mOnPageChangeListener;
    private ih mPagerAdapter;
    private ii mViewPager;

    public abstract void populateData(int i);

    public abstract void select(int i);

    public XViewPagerIndicatorAbs(Context context) {
        this(context, null);
    }

    public XViewPagerIndicatorAbs(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, acu.k.XPagerIndicator);
    }

    public XViewPagerIndicatorAbs(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, acu.k.XPagerIndicator);
    }

    public XViewPagerIndicatorAbs(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDataSetObserver = new DataSetObserver() { // from class: com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                XViewPagerIndicatorAbs xViewPagerIndicatorAbs = XViewPagerIndicatorAbs.this;
                xViewPagerIndicatorAbs.populateData(xViewPagerIndicatorAbs.mPagerAdapter != null ? XViewPagerIndicatorAbs.this.mPagerAdapter.a() : 0);
            }
        };
        this.mOnAdapterChangeListener = new ii.e() { // from class: com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs.2
            @Override // defpackage.ii.e
            public void onAdapterChanged(ii iiVar, ih ihVar, ih ihVar2) {
                XViewPagerIndicatorAbs.this.setAdapter(ihVar2);
            }
        };
        this.mOnPageChangeListener = new ii.j() { // from class: com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs.3
            @Override // defpackage.ii.j, defpackage.ii.f
            public void onPageSelected(int i3) {
                XViewPagerIndicatorAbs.this.select(i3);
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setOrientation(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdapter(ih ihVar) {
        if (ihVar == null) {
            return;
        }
        this.mPagerAdapter = ihVar;
        this.mPagerAdapter.a(this.mDataSetObserver);
        populateData(this.mPagerAdapter.a());
    }

    public void setupWithViewPager(ii iiVar) {
        if (iiVar == null) {
            return;
        }
        this.mViewPager = iiVar;
        setAdapter(iiVar.getAdapter());
        int currentItem = iiVar.getCurrentItem();
        if (currentItem > -1) {
            select(currentItem);
        }
        iiVar.removeOnAdapterChangeListener(this.mOnAdapterChangeListener);
        iiVar.addOnAdapterChangeListener(this.mOnAdapterChangeListener);
        iiVar.removeOnPageChangeListener(this.mOnPageChangeListener);
        iiVar.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void clear() {
        ii iiVar = this.mViewPager;
        if (iiVar != null) {
            iiVar.removeOnAdapterChangeListener(this.mOnAdapterChangeListener);
            this.mViewPager.removeOnPageChangeListener(this.mOnPageChangeListener);
            this.mViewPager = null;
        }
        ih ihVar = this.mPagerAdapter;
        if (ihVar != null) {
            try {
                ihVar.b(this.mDataSetObserver);
            } catch (Exception unused) {
            }
            this.mPagerAdapter = null;
        }
    }
}
