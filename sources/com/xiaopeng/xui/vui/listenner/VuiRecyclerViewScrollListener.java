package com.xiaopeng.xui.vui.listenner;

import androidx.recyclerview.widget.j;
import com.xiaopeng.xui.vui.VuiRecyclerView;
/* loaded from: classes.dex */
public class VuiRecyclerViewScrollListener extends j.n {
    private VuiRecyclerView mVuiRecycleView;

    public VuiRecyclerViewScrollListener(VuiRecyclerView vuiRecyclerView) {
        this.mVuiRecycleView = null;
        this.mVuiRecycleView = vuiRecyclerView;
    }

    @Override // androidx.recyclerview.widget.j.n
    public void onScrollStateChanged(j jVar, int i) {
        VuiRecyclerView vuiRecyclerView;
        super.onScrollStateChanged(jVar, i);
        if (i != 0 || (vuiRecyclerView = this.mVuiRecycleView) == null) {
            return;
        }
        vuiRecyclerView.updateVuiScene();
    }
}
