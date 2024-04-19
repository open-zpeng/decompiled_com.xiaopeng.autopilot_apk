package com.xiaopeng.xui.vui;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.xiaopeng.xui.Xui;
import com.xiaopeng.xui.utils.XLogUtils;
import com.xiaopeng.xui.vui.floatinglayer.VuiFloatingLayerManager;
import java.util.List;
/* loaded from: classes.dex */
public abstract class VuiViewScene implements abp, IVuiViewScene {
    private View mRootView;
    private abp mVuiSceneListener;
    private abo mVuiEngine = null;
    private String mSceneId = "";
    private abn mVuiElementListener = null;
    private List<Integer> customViewIds = null;
    private Handler mHandler = new Handler();
    private View.OnAttachStateChangeListener mOnAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.xiaopeng.xui.vui.VuiViewScene.1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (Xui.isVuiEnable()) {
                VuiViewScene.this.createVuiScene();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (Xui.isVuiEnable()) {
                VuiViewScene.this.destroyVuiScene();
            }
        }
    };
    abm mListener = new abm() { // from class: com.xiaopeng.xui.vui.-$$Lambda$VuiViewScene$fMN-de5p1vs7FdZitmAMU4qRLqY
        @Override // defpackage.abm
        public final void onVuiElementChaned(View view, abv abvVar) {
            VuiViewScene.lambda$new$1(VuiViewScene.this, view, abvVar);
        }
    };
    private boolean isUseNewProtocol = false;

    protected abstract void onBuildScenePrepare();

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVuiView(View view) {
        log("initVui");
        if (Xui.isVuiEnable()) {
            View view2 = this.mRootView;
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
            }
            this.mRootView = view;
            view.addOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
        }
    }

    public void onVuiEvent(View view, aby abyVar) {
        log("VuiViewScene onVuiEvent");
        if (view == null) {
            return;
        }
        abn abnVar = this.mVuiElementListener;
        if (abnVar != null) {
            abnVar.onVuiElementEvent(view, abyVar);
        } else {
            VuiFloatingLayerManager.show(view);
        }
    }

    public boolean onInterceptVuiEvent(View view, aby abyVar) {
        log("onInterceptVuiEvent");
        if (view == null) {
            return false;
        }
        abn abnVar = this.mVuiElementListener;
        if (abnVar != null) {
            return abnVar.onVuiElementEvent(view, abyVar);
        }
        VuiFloatingLayerManager.show(view);
        return false;
    }

    public void onBuildScene() {
        this.mHandler.post(new Runnable() { // from class: com.xiaopeng.xui.vui.-$$Lambda$VuiViewScene$bhRg6IeHfpBu4ffKtyCCDOAoC1Q
            @Override // java.lang.Runnable
            public final void run() {
                VuiViewScene.lambda$onBuildScene$0(VuiViewScene.this);
            }
        });
    }

    public static /* synthetic */ void lambda$onBuildScene$0(VuiViewScene vuiViewScene) {
        abo aboVar = vuiViewScene.mVuiEngine;
        String str = vuiViewScene.mSceneId;
        View view = vuiViewScene.mRootView;
        if (aboVar == null || str == null || view == null) {
            return;
        }
        int vuiDisplayLocation = vuiViewScene.getVuiDisplayLocation();
        vuiViewScene.log("onBuildScene:" + vuiDisplayLocation);
        vuiViewScene.onBuildScenePrepare();
        aboVar.a(str, view, vuiViewScene.customViewIds, vuiViewScene.mVuiElementListener, String.valueOf(vuiDisplayLocation), vuiViewScene);
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void setVuiSceneId(String str) {
        this.mSceneId = str;
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void setVuiEngine(abo aboVar) {
        this.mVuiEngine = aboVar;
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void setVuiElementListener(abn abnVar) {
        this.mVuiElementListener = abnVar;
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void setCustomViewIdList(List<Integer> list) {
        this.customViewIds = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createVuiScene() {
        abo aboVar = this.mVuiEngine;
        String str = this.mSceneId;
        View view = this.mRootView;
        if (aboVar == null || str == null || view == null) {
            return;
        }
        log("createVuiScene");
        try {
            if (this.isUseNewProtocol) {
                aboVar.a(str, view, this, this.mListener);
            } else {
                aboVar.a(str, view, this);
            }
        } catch (AbstractMethodError unused) {
            aboVar.a(str, view, this);
        }
        aboVar.a(str, String.valueOf(getVuiDisplayLocation()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyVuiScene() {
        if (this.mVuiEngine != null && this.mSceneId != null) {
            log("destroyVuiScene");
            this.mVuiEngine.a(this.mSceneId, String.valueOf(getVuiDisplayLocation()), this);
            this.mVuiEngine.a(this.mSceneId, this);
            this.mVuiEngine = null;
        }
        if (this.mVuiElementListener != null) {
            this.mVuiElementListener = null;
        }
        if (this.mVuiSceneListener != null) {
            this.mVuiSceneListener = null;
        }
    }

    private void log(String str) {
        XLogUtils.d("VuiViewScene", " mSceneId " + this.mSceneId + "  " + str + " hashcode " + hashCode() + " name " + getClass().getSimpleName());
    }

    public static /* synthetic */ void lambda$new$1(VuiViewScene vuiViewScene, View view, abv abvVar) {
        abo aboVar = vuiViewScene.mVuiEngine;
        String str = vuiViewScene.mSceneId;
        if (aboVar == null || TextUtils.isEmpty(str) || view == null) {
            return;
        }
        if (abv.UPDATE_VIEW.equals(abvVar)) {
            aboVar.a(str, view);
        } else {
            aboVar.b(str, view);
        }
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void initVuiScene(String str, abo aboVar) {
        this.mSceneId = str;
        this.mVuiEngine = aboVar;
        this.isUseNewProtocol = true;
    }

    @Override // com.xiaopeng.xui.vui.IVuiViewScene
    public void initVuiScene(String str, abo aboVar, abp abpVar) {
        this.mSceneId = str;
        this.mVuiEngine = aboVar;
        this.isUseNewProtocol = true;
        this.mVuiSceneListener = abpVar;
    }

    @Override // defpackage.abp
    public void onVuiStateChanged() {
        abp abpVar = this.mVuiSceneListener;
        if (abpVar != null) {
            abpVar.onVuiStateChanged();
        }
    }
}
