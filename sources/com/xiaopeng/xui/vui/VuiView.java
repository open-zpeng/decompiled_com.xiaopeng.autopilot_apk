package com.xiaopeng.xui.vui;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.xiaopeng.xui.Xui;
import com.xiaopeng.xui.utils.XLogUtils;
import com.xiaopeng.xui.utils.XuiUtils;
import com.xiaopeng.xui.vui.utils.VuiCommonUtils;
import com.xiaopeng.xui.vui.utils.VuiViewUtils;
import defpackage.acu;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface VuiView {
    public static final SparseArray<XAttr> msMap = new SparseArray<>();

    default void initVui(View view, AttributeSet attributeSet) {
        if (!Xui.isVuiEnable() || view == null || attributeSet == null) {
            return;
        }
        XAttr xAttr = new XAttr();
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, acu.l.vui);
        xAttr.vuiAction = obtainStyledAttributes.getString(acu.l.vui_vuiAction);
        xAttr.vuiElementType = VuiCommonUtils.getElementType(obtainStyledAttributes.getInteger(acu.l.vui_vuiElementType, -1));
        if (xAttr.vuiElementType == abr.UNKNOWN) {
            xAttr.vuiElementType = VuiViewUtils.getElementType(view);
        }
        xAttr.vuiPosition = Integer.valueOf(obtainStyledAttributes.getInteger(acu.l.vui_vuiPosition, -1));
        xAttr.vuiFatherElementId = obtainStyledAttributes.getString(acu.l.vui_vuiFatherElementId);
        xAttr.vuiLabel = obtainStyledAttributes.getString(acu.l.vui_vuiLabel);
        xAttr.vuiFatherLabel = obtainStyledAttributes.getString(acu.l.vui_vuiFatherLabel);
        xAttr.vuiElementId = obtainStyledAttributes.getString(acu.l.vui_vuiElementId);
        xAttr.vuiLayoutLoadable = obtainStyledAttributes.getBoolean(acu.l.vui_vuiLayoutLoadable, false);
        xAttr.vuiMode = VuiCommonUtils.getVuiMode(obtainStyledAttributes.getInteger(acu.l.vui_vuiMode, 4));
        xAttr.vuiBizId = obtainStyledAttributes.getString(acu.l.vui_vuiBizId);
        xAttr.vuiPriority = VuiCommonUtils.getViewLeveByPriority(obtainStyledAttributes.getInt(acu.l.vui_vuiPriority, 2));
        xAttr.vuiFeedbackType = VuiCommonUtils.getFeedbackType(obtainStyledAttributes.getInteger(acu.l.vui_vuiFeedbackType, 1));
        xAttr.vuiDisableHitEffect = obtainStyledAttributes.getBoolean(acu.l.vui_vuiDisableHitEffect, false);
        xAttr.vuiEnableViewVuiMode = obtainStyledAttributes.getBoolean(acu.l.vui_vuiEnableViewVuiMode, false);
        obtainStyledAttributes.recycle();
        xAttr.mVuiVisibility = view.getVisibility();
        xAttr.mVuiSelected = view.isSelected();
        synchronized (msMap) {
            msMap.put(hashCode(), xAttr);
        }
    }

    default XAttr checkVuiExit() {
        XAttr xAttr;
        synchronized (msMap) {
            xAttr = msMap.get(hashCode());
        }
        if (xAttr == null) {
            logD("xAttr is null");
            xAttr = new XAttr();
            if (xAttr.vuiElementType == abr.UNKNOWN) {
                xAttr.vuiElementType = VuiViewUtils.getElementType(this);
            }
            synchronized (msMap) {
                msMap.put(hashCode(), xAttr);
            }
        }
        return xAttr;
    }

    default boolean isVuiLayoutLoadable() {
        return checkVuiExit().vuiLayoutLoadable;
    }

    default void setVuiLayoutLoadable(boolean z) {
        checkVuiExit().vuiLayoutLoadable = z;
    }

    default abu getVuiPriority() {
        return checkVuiExit().vuiPriority;
    }

    default void setVuiPriority(abu abuVar) {
        checkVuiExit().vuiPriority = abuVar;
    }

    default String getVuiAction() {
        return checkVuiExit().vuiAction;
    }

    default void setVuiAction(String str) {
        checkVuiExit().vuiAction = str;
    }

    default abr getVuiElementType() {
        return checkVuiExit().vuiElementType;
    }

    default void setVuiElementType(abr abrVar) {
        checkVuiExit().vuiElementType = abrVar;
    }

    default String getVuiFatherElementId() {
        return checkVuiExit().vuiFatherElementId;
    }

    default void setVuiFatherElementId(String str) {
        checkVuiExit().vuiFatherElementId = str;
    }

    default String getVuiFatherLabel() {
        return checkVuiExit().vuiFatherLabel;
    }

    default void setVuiFatherLabel(String str) {
        checkVuiExit().vuiFatherLabel = str;
    }

    default String getVuiLabel() {
        return checkVuiExit().vuiLabel;
    }

    default void setVuiLabel(String str) {
        checkVuiExit().vuiLabel = str;
        if (isVuiLayoutLoadable() && (this instanceof View)) {
            updateVui((View) this);
        }
    }

    default String getVuiElementId() {
        return checkVuiExit().vuiElementId;
    }

    default void setVuiElementId(String str) {
        checkVuiExit().vuiElementId = str;
    }

    default void setVuiPosition(int i) {
        checkVuiExit().vuiPosition = Integer.valueOf(i);
    }

    default int getVuiPosition() {
        return checkVuiExit().vuiPosition.intValue();
    }

    default void releaseVui() {
        synchronized (msMap) {
            msMap.remove(hashCode());
        }
    }

    default abs getVuiFeedbackType() {
        return checkVuiExit().vuiFeedbackType;
    }

    default void setVuiFeedbackType(abs absVar) {
        checkVuiExit().vuiFeedbackType = absVar;
    }

    default boolean isPerformVuiAction() {
        return checkVuiExit().performVuiAction;
    }

    default void setPerformVuiAction(boolean z) {
        checkVuiExit().performVuiAction = z;
    }

    default void setVuiProps(JSONObject jSONObject) {
        checkVuiExit().vuiProps = jSONObject;
    }

    default JSONObject getVuiProps() {
        return checkVuiExit().vuiProps;
    }

    default abt getVuiMode() {
        return checkVuiExit().vuiMode;
    }

    default void setVuiMode(abt abtVar) {
        checkVuiExit().vuiMode = abtVar;
    }

    default void setVuiBizId(String str) {
        checkVuiExit().vuiBizId = str;
    }

    default String getVuiBizId() {
        return checkVuiExit().vuiBizId;
    }

    default void setVuiDisableHitEffect(boolean z) {
        checkVuiExit().vuiDisableHitEffect = z;
    }

    default boolean getVuiDisableHitEffect() {
        XAttr checkVuiExit = checkVuiExit();
        if (checkVuiExit.vuiDisableHitEffect || !(abq.SCROLLBYY.getName().equals(checkVuiExit.vuiAction) || abq.SCROLLBYX.getName().equals(checkVuiExit.vuiAction))) {
            return checkVuiExit.vuiDisableHitEffect;
        }
        return true;
    }

    default void enableViewVuiMode(boolean z) {
        checkVuiExit().vuiEnableViewVuiMode = z;
    }

    default boolean isVuiModeEnabled() {
        return checkVuiExit().vuiEnableViewVuiMode;
    }

    default void setVuiValue(Object obj) {
        checkVuiExit().vuiValue = obj;
    }

    default void setVuiValue(Object obj, View view) {
        checkVuiExit().vuiValue = obj;
        if (!abr.STATEFULBUTTON.getType().equals(getVuiElementType().getType()) || view == null) {
            return;
        }
        updateVui(view);
    }

    default Object getVuiValue() {
        return checkVuiExit().vuiValue;
    }

    default void setVuiElementChangedListener(abm abmVar) {
        checkVuiExit().mVuiElementChangedListener = new WeakReference(abmVar);
    }

    default abm getVuiElementChangedListener() {
        XAttr checkVuiExit = checkVuiExit();
        if (checkVuiExit.mVuiElementChangedListener != null) {
            synchronized (msMap) {
                if (checkVuiExit.mVuiElementChangedListener != null) {
                    return (abm) checkVuiExit.mVuiElementChangedListener.get();
                }
                return null;
            }
        }
        return null;
    }

    default void setVuiVisibility(View view, int i) {
        XAttr checkVuiExit = checkVuiExit();
        if (checkVuiExit.mVuiVisibility != i) {
            if (XLogUtils.isLogLevelEnabled(2)) {
                logD("setVuiVisibility; xAttr.mVuiVisibility : " + XuiUtils.formatVisibility(checkVuiExit.mVuiVisibility) + ",visibility " + XuiUtils.formatVisibility(i));
            }
            checkVuiExit.mVuiVisibility = i;
            try {
                JSONObject vuiProps = getVuiProps();
                if (vuiProps != null && vuiProps.has("canVoiceControl")) {
                    if (vuiProps.getBoolean("canVoiceControl")) {
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateVui(view);
        }
    }

    default void setVuiSelected(View view, boolean z) {
        XAttr checkVuiExit = checkVuiExit();
        if (checkVuiExit.mVuiSelected != z) {
            checkVuiExit.mVuiSelected = z;
            String type = getVuiElementType().getType();
            if (abr.CHECKBOX.getType().equals(type) || abr.SWITCH.getType().equals(type) || abr.RADIOBUTTON.getType().equals(type)) {
                updateVui(view);
            }
        }
    }

    default void updateVui(View view) {
        updateVui(view, abv.UPDATE_VIEW_ATTRIBUTE);
    }

    default void updateVui(View view, abv abvVar) {
        abm vuiElementChangedListener = getVuiElementChangedListener();
        if (vuiElementChangedListener != null) {
            VuiViewUtils.updateVui(vuiElementChangedListener, view, abvVar);
        } else if (XLogUtils.isLogLevelEnabled(2)) {
            logD("listener is null");
        }
    }

    default void logD(String str) {
        XLogUtils.d("xpui", "%s %s hashCode:%s", getClass().getSimpleName(), str, Integer.valueOf(hashCode()));
    }

    default void logI(String str) {
        XLogUtils.i("xpui", "%s %s hashCode:%s", getClass().getSimpleName(), str, Integer.valueOf(hashCode()));
    }

    /* loaded from: classes.dex */
    public static class XAttr {
        private volatile WeakReference<abm> mVuiElementChangedListener;
        private int mVuiVisibility;
        private boolean performVuiAction;
        private String vuiAction;
        private String vuiBizId;
        private boolean vuiDisableHitEffect;
        private String vuiElementId;
        private String vuiFatherElementId;
        private String vuiFatherLabel;
        private abs vuiFeedbackType;
        private String vuiLabel;
        private boolean vuiLayoutLoadable;
        private Object vuiValue;
        private boolean mVuiSelected = false;
        private abr vuiElementType = VuiCommonUtils.getElementType(-1);
        private Integer vuiPosition = -1;
        private abt vuiMode = abt.NORMAL;
        private boolean vuiEnableViewVuiMode = false;
        private abu vuiPriority = VuiCommonUtils.getViewLeveByPriority(2);
        private JSONObject vuiProps = null;

        XAttr() {
        }
    }
}
