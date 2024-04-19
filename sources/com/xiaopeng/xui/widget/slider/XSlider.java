package com.xiaopeng.xui.widget.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.xui.utils.XLogUtils;
import com.xiaopeng.xui.vui.floatinglayer.VuiFloatingLayerManager;
import defpackage.acu;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XSlider extends AbsSlider {
    private static final String TAG = "XSlider";
    private ProgressChangeListener progressChangeListener;
    private SliderProgressListener sliderProgressListener;

    /* loaded from: classes.dex */
    public interface ProgressChangeListener {
        void onProgressChanged(XSlider xSlider, float f, String str, boolean z);
    }

    /* loaded from: classes.dex */
    public interface SliderProgressListener {
        void onProgressChanged(XSlider xSlider, float f, String str);

        void onStartTrackingTouch(XSlider xSlider);

        void onStopTrackingTouch(XSlider xSlider);
    }

    public XSlider(Context context) {
        this(context, null);
    }

    public XSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XSlider(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, acu.k.XSlider);
    }

    public XSlider(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    ViewGroup isInScrollContainer = isInScrollContainer();
                    boolean z2 = (isInScrollContainer != null && isInScrollContainer.canScrollVertically(1)) || (isInScrollContainer != null && isInScrollContainer.canScrollVertically(-1));
                    if (!(getOrientation() != 0 ? !((isInScrollContainer != null && isInScrollContainer.canScrollHorizontally(-1)) || (isInScrollContainer != null && isInScrollContainer.canScrollHorizontally(1))) : !z2)) {
                        this.mTouchDownX = motionEvent.getX();
                        this.mTouchDownY = motionEvent.getY();
                        break;
                    } else {
                        this.mIsDragging = true;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        SliderProgressListener sliderProgressListener = this.sliderProgressListener;
                        if (sliderProgressListener != null) {
                            sliderProgressListener.onStartTrackingTouch(this);
                        }
                        this.mProgressViewLength = calculateIndicatorFromTouch(motionEvent);
                        notifyChildren(true, false);
                        invalidateAll();
                        break;
                    }
                    break;
                case 1:
                    if (this.mIsDragging) {
                        this.mIsDragging = false;
                    } else {
                        SliderProgressListener sliderProgressListener2 = this.sliderProgressListener;
                        if (sliderProgressListener2 != null) {
                            sliderProgressListener2.onStartTrackingTouch(this);
                        }
                    }
                    this.mProgressViewLength = calculateIndicatorFromTouch(motionEvent);
                    stickIndicator();
                    notifyChildren(true, true);
                    getParent().requestDisallowInterceptTouchEvent(false);
                    SliderProgressListener sliderProgressListener3 = this.sliderProgressListener;
                    if (sliderProgressListener3 != null) {
                        sliderProgressListener3.onStopTrackingTouch(this);
                    }
                    invalidateAll();
                    break;
                case 2:
                    if (this.mIsDragging) {
                        this.mProgressViewLength = calculateIndicatorFromTouch(motionEvent);
                        notifyChildren(true, false);
                        invalidateAll();
                        break;
                    } else {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (getOrientation() == 0) {
                            z = Math.abs(x - this.mTouchDownX) > this.mScaledTouchSlop;
                        } else {
                            z = Math.abs(y - this.mTouchDownY) > this.mScaledTouchSlop;
                        }
                        if (z) {
                            this.mIsDragging = true;
                            SliderProgressListener sliderProgressListener4 = this.sliderProgressListener;
                            if (sliderProgressListener4 != null) {
                                sliderProgressListener4.onStartTrackingTouch(this);
                            }
                            this.mProgressViewLength = calculateIndicatorFromTouch(motionEvent);
                            getParent().requestDisallowInterceptTouchEvent(true);
                            notifyChildren(true, false);
                            invalidateAll();
                            break;
                        }
                    }
                    break;
                case 3:
                    if (this.mIsDragging) {
                        this.mIsDragging = false;
                    }
                    invalidateAll();
                    break;
            }
            return true;
        }
        return true;
    }

    private float calculateIndicatorFromTouch(MotionEvent motionEvent) {
        return getOrientation() == 0 ? motionEvent.getX() : getHeight() - motionEvent.getY();
    }

    private void notifyChildren(boolean z, boolean z2) {
        float filterValidValue = filterValidValue();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            SlideLineView slideLineView = (SlideLineView) getChildAt(i);
            if (slideLineView.getX() + (slideLineView.getWidth() / 2.0f) <= filterValidValue()) {
                if (!slideLineView.isSelect()) {
                    slideLineView.setSelect(true);
                }
            } else {
                slideLineView.setSelect(false);
            }
        }
        if (z) {
            this.indicatorValue = ((filterValidValue - 16.0f) / this.workableTotalLength) * (this.endIndex - this.startIndex);
            float down = ((float) down(this.indicatorValue, this.decimal)) + this.startIndex;
            if (this.sliderProgressListener != null) {
                if ((z2 || down >= Math.min(this.currentUpdateIndex + this.accuracy, this.endIndex) || down <= Math.max(this.currentUpdateIndex - this.accuracy, this.startIndex)) && this.currentUpdateIndex != down) {
                    this.sliderProgressListener.onProgressChanged(this, down, this.unit);
                    this.currentUpdateIndex = down;
                    updateVui(this);
                }
            }
        }
    }

    private static double down(double d, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        return BigDecimal.valueOf(d).setScale(i, RoundingMode.DOWN).doubleValue();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider
    public float getIndicatorValue() {
        return (((float) down(this.indicatorValue, this.decimal)) + this.startIndex) * this.mStep;
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider
    public void setAccuracy(float f) {
        this.accuracy = f;
    }

    public void setSliderProgressListener(SliderProgressListener sliderProgressListener) {
        this.sliderProgressListener = sliderProgressListener;
    }

    public void setProgressChangeListener(ProgressChangeListener progressChangeListener) {
        this.progressChangeListener = progressChangeListener;
    }

    public void setCurrentIndex(int i) {
        setCurrentIndex(i, false);
    }

    public void setCurrentIndex(final int i, final boolean z) {
        post(new Runnable() { // from class: com.xiaopeng.xui.widget.slider.-$$Lambda$XSlider$6nRMnQGFhZSAnHXSTyWZZ5qLEF4
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.lambda$setCurrentIndex$0(XSlider.this, i, z);
            }
        });
    }

    public static /* synthetic */ void lambda$setCurrentIndex$0(XSlider xSlider, int i, boolean z) {
        ProgressChangeListener progressChangeListener;
        XLogUtils.i(TAG, "setCurrentIndex:" + i + ", fromUser:" + z);
        xSlider.mProgressViewLength = ((((float) (i - xSlider.startIndex)) / ((float) (xSlider.endIndex - xSlider.startIndex))) * ((float) xSlider.workableTotalLength)) + 16.0f;
        xSlider.indicatorValue = (float) (i - xSlider.startIndex);
        xSlider.invalidate();
        xSlider.notifyChildren(false, false);
        xSlider.currentUpdateIndex = (float) i;
        if (xSlider.indicatorDrawable != null) {
            xSlider.indicatorDrawable.updateCenter(xSlider.filterValidValue(), xSlider.getPopString(), xSlider.isNight, xSlider.getSliderLength());
        }
        if (z && (progressChangeListener = xSlider.progressChangeListener) != null) {
            progressChangeListener.onProgressChanged(xSlider, xSlider.indicatorValue + xSlider.startIndex, xSlider.unit, true);
        }
        if (xSlider.getVuiValue() == null || ((Float) xSlider.getVuiValue()).floatValue() != xSlider.getIndicatorValue()) {
            xSlider.updateVui(xSlider);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (!z) {
            this.mIsDragging = false;
        }
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setEnabled(z);
        }
        setAlphaByEnable(z);
        invalidate();
    }

    public void setStartIndex(int i) {
        if (i == this.endIndex) {
            throw new RuntimeException("startIndex = endIndex!!!");
        }
        this.startIndex = i;
        post(new Runnable() { // from class: com.xiaopeng.xui.widget.slider.-$$Lambda$XSlider$Xz60DHZ7J60ywvILqd--vaYYV3k
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.lambda$setStartIndex$1(XSlider.this);
            }
        });
    }

    public static /* synthetic */ void lambda$setStartIndex$1(XSlider xSlider) {
        if (xSlider.indicatorDrawable != null) {
            xSlider.indicatorDrawable.updateCenter(xSlider.filterValidValue(), xSlider.getPopString(), xSlider.isNight, xSlider.getSliderLength());
        }
        xSlider.invalidate();
    }

    public void setEndIndex(int i) {
        if (this.startIndex == i) {
            throw new RuntimeException("startIndex = endIndex!!!");
        }
        this.endIndex = i;
        post(new Runnable() { // from class: com.xiaopeng.xui.widget.slider.-$$Lambda$XSlider$kB2KeMUVNgZs-Tjtgxuk4WuttL4
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.this.invalidate();
            }
        });
    }

    public void setInitIndex(int i) {
        if (i > this.endIndex) {
            this.initIndex = this.endIndex;
        } else if (i < this.startIndex) {
            this.initIndex = this.startIndex;
        } else {
            this.initIndex = i;
            this.indicatorValue = i - this.startIndex;
            invalidate();
        }
    }

    public abx onBuildVuiElement(String str, abl ablVar) {
        try {
            setVuiValue(Float.valueOf(getIndicatorValue()));
        } catch (JSONException unused) {
        }
        if (getVuiProps() != null && getVuiProps().has("customSetProps") && getVuiProps().getBoolean("customSetProps")) {
            return null;
        }
        JSONObject vuiProps = getVuiProps();
        if (vuiProps == null) {
            vuiProps = new JSONObject();
        }
        vuiProps.put("minValue", this.startIndex);
        vuiProps.put("maxValue", this.endIndex);
        vuiProps.put("interval", (int) Math.ceil((this.endIndex - this.startIndex) / 10.0d));
        setVuiProps(vuiProps);
        return null;
    }

    @Override // defpackage.abn
    public boolean onVuiElementEvent(View view, aby abyVar) {
        Double d;
        int round;
        logD("slider onVuiElementEvent");
        if (view == null || (d = (Double) abyVar.a(abyVar)) == null) {
            return false;
        }
        if (this.mStep == 1) {
            round = (int) Math.ceil(d.doubleValue());
        } else {
            round = (int) Math.round(d.doubleValue() / this.mStep);
        }
        if (round < this.startIndex || round > this.endIndex) {
            return true;
        }
        setCurrentIndex(round, true);
        post(new Runnable() { // from class: com.xiaopeng.xui.widget.slider.-$$Lambda$G7bSwaFjR6szpZX2DzaD1OrXsng
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.this.showVuiFloating();
            }
        });
        return true;
    }

    public void showVuiFloating() {
        int heightExIndicator = (int) ((getHeightExIndicator() / 2.0f) - (getSliderThickness() / 2));
        int sliderLength = ((int) (getOrientation() == 1 ? getSliderLength() - getProgressViewLength() : getProgressViewLength())) - (getSliderLength() / 2);
        int i = getOrientation() == 1 ? sliderLength : heightExIndicator;
        if (getOrientation() != 1) {
            heightExIndicator = sliderLength;
        }
        VuiFloatingLayerManager.show(this, heightExIndicator, i);
    }
}
