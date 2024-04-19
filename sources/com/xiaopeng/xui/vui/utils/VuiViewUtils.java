package com.xiaopeng.xui.vui.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XCheckBox;
import com.xiaopeng.xui.widget.XEditText;
import com.xiaopeng.xui.widget.XGroupHeader;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XProgressBar;
import com.xiaopeng.xui.widget.XRadioButton;
import com.xiaopeng.xui.widget.XRadioGroup;
import com.xiaopeng.xui.widget.XRecyclerView;
import com.xiaopeng.xui.widget.XScrollView;
import com.xiaopeng.xui.widget.XSeekBar;
import com.xiaopeng.xui.widget.XSegmented;
import com.xiaopeng.xui.widget.XSwitch;
import com.xiaopeng.xui.widget.XTabLayout;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.XViewPager;
import com.xiaopeng.xui.widget.slider.XSlider;
import com.xiaopeng.xui.widget.timepicker.XTimePicker;
/* loaded from: classes.dex */
public class VuiViewUtils {
    static Handler mHandler;
    static HandlerThread mThread = new HandlerThread("VuiUpdate");

    public static abr getElementType(Object obj) {
        if (obj instanceof XImageView) {
            return abr.IMAGEVIEW;
        }
        if (obj instanceof XImageButton) {
            return abr.IMAGEBUTTON;
        }
        if (obj instanceof XButton) {
            return abr.BUTTON;
        }
        if (obj instanceof XTextView) {
            return abr.TEXTVIEW;
        }
        if (obj instanceof XRadioButton) {
            return abr.RADIOBUTTON;
        }
        if (obj instanceof XCheckBox) {
            return abr.CHECKBOX;
        }
        if (obj instanceof XSwitch) {
            return abr.SWITCH;
        }
        if (obj instanceof XRecyclerView) {
            return abr.RECYCLEVIEW;
        }
        if (obj instanceof XProgressBar) {
            return abr.PROGRESSBAR;
        }
        if (obj instanceof XScrollView) {
            return abr.SCROLLVIEW;
        }
        if (obj instanceof XSlider) {
            return abr.XSLIDER;
        }
        if (obj instanceof XTabLayout) {
            return abr.XTABLAYOUT;
        }
        if (obj instanceof XSegmented) {
            return abr.XTABLAYOUT;
        }
        if (obj instanceof XRadioGroup) {
            return abr.RADIOGROUP;
        }
        if (obj instanceof XEditText) {
            return abr.EDITTEXT;
        }
        if (obj instanceof XGroupHeader) {
            return abr.XGROUPHEADER;
        }
        if (obj instanceof XSeekBar) {
            return abr.SEEKBAR;
        }
        if (obj instanceof XTimePicker) {
            return abr.TIMEPICKER;
        }
        if (obj instanceof XViewPager) {
            return abr.VIEWPAGER;
        }
        if (obj instanceof ViewGroup) {
            return abr.GROUP;
        }
        return abr.UNKNOWN;
    }

    public static void updateVui(final abm abmVar, final View view, final abv abvVar) {
        try {
            if (mHandler == null) {
                mThread.start();
                mHandler = new Handler(mThread.getLooper());
            }
            if (mHandler != null) {
                mHandler.post(new Runnable() { // from class: com.xiaopeng.xui.vui.utils.VuiViewUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View view2;
                        abm abmVar2 = abm.this;
                        if (abmVar2 == null || (view2 = view) == null) {
                            return;
                        }
                        abmVar2.onVuiElementChaned(view2, abvVar);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
