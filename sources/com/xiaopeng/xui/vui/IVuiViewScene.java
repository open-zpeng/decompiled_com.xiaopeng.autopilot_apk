package com.xiaopeng.xui.vui;

import java.util.List;
/* loaded from: classes.dex */
public interface IVuiViewScene {
    default int getVuiDisplayLocation() {
        return 0;
    }

    default void initVuiScene(String str, abo aboVar) {
    }

    default void initVuiScene(String str, abo aboVar, abp abpVar) {
    }

    default void setCustomViewIdList(List<Integer> list) {
    }

    default void setVuiElementListener(abn abnVar) {
    }

    default void setVuiEngine(abo aboVar) {
    }

    default void setVuiSceneId(String str) {
    }
}
