package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import defpackage.aia;
/* compiled from: SimpleSlider.java */
/* renamed from: aib  reason: default package */
/* loaded from: classes.dex */
public class aib extends View {
    private static final int MAX_LEVEL = 10000;
    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;
    private static final int NO_ALPHA = 255;
    public static final int TOUCH_MODE_SEEK = 1;
    public static final int TOUCH_MODE_SLIDE = 0;
    private float mDisabledAlpha;
    private boolean mEnabled;
    private int mMax;
    private boolean mMaxInitialized;
    private int mMin;
    private boolean mMinInitialized;
    private a mOnSlideChangeListener;
    private int mProgress;
    private Drawable mProgressDrawable;
    private int mProgressDrawableRes;
    private int mScaledTouchSlop;
    private float mSlideScale;
    private Drawable mTickMark;
    private boolean mTickMarkAll;
    private float mTickMarkPadding;
    private boolean mTickMarkProgressEnd;
    private int mTickMarkRes;
    private d mTouchEventHandler;
    protected int mTouchMode;

    /* compiled from: SimpleSlider.java */
    /* renamed from: aib$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(aib aibVar);

        void a(aib aibVar, int i, boolean z);

        void b(aib aibVar);
    }

    /* compiled from: SimpleSlider.java */
    /* renamed from: aib$d */
    /* loaded from: classes.dex */
    public interface d {
        boolean a(aib aibVar, MotionEvent motionEvent);
    }

    public aib(Context context) {
        this(context, null);
    }

    public aib(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, aia.a.SimpleSlider);
    }

    public aib(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, aia.a.SimpleSlider);
    }

    public aib(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mProgress = 0;
        this.mMin = 0;
        this.mMax = 100;
        this.mMaxInitialized = false;
        this.mMinInitialized = false;
        this.mSlideScale = 1.0f;
        this.mProgressDrawableRes = -1;
        this.mTickMarkRes = -1;
        this.mTickMarkAll = false;
        this.mTickMarkPadding = 0.0f;
        this.mTickMarkProgressEnd = false;
        this.mTouchMode = 0;
        this.mEnabled = true;
        init(context, attributeSet, i, i2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setEnabled(this.mEnabled);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aia.b.SimpleSlider, i, i2);
        this.mProgressDrawableRes = obtainStyledAttributes.getResourceId(aia.b.SimpleSlider_android_progressDrawable, this.mProgressDrawableRes);
        setProgressDrawable(obtainStyledAttributes.getDrawable(aia.b.SimpleSlider_android_progressDrawable));
        this.mTickMarkRes = obtainStyledAttributes.getResourceId(aia.b.SimpleSlider_android_tickMark, this.mTickMarkRes);
        setTickMark(obtainStyledAttributes.getDrawable(aia.b.SimpleSlider_android_tickMark));
        this.mTickMarkAll = obtainStyledAttributes.getBoolean(aia.b.SimpleSlider_ss_tickMarkAll, this.mTickMarkAll);
        this.mTickMarkPadding = obtainStyledAttributes.getDimension(aia.b.SimpleSlider_ss_tickMark_padding, this.mTickMarkPadding);
        this.mTickMarkProgressEnd = obtainStyledAttributes.getBoolean(aia.b.SimpleSlider_ss_tickMark_ProgressEnd, this.mTickMarkProgressEnd);
        this.mSlideScale = obtainStyledAttributes.getFloat(aia.b.SimpleSlider_ss_slideScale, this.mSlideScale);
        this.mEnabled = obtainStyledAttributes.getBoolean(aia.b.SimpleSlider_android_enabled, this.mEnabled);
        this.mDisabledAlpha = obtainStyledAttributes.getFloat(aia.b.SimpleSlider_android_disabledAlpha, 0.36f);
        setMin(obtainStyledAttributes.getInt(aia.b.SimpleSlider_android_min, this.mMin));
        setMax(obtainStyledAttributes.getInt(aia.b.SimpleSlider_android_max, this.mMax));
        setProgress(obtainStyledAttributes.getInt(aia.b.SimpleSlider_android_progress, this.mProgress));
        this.mTouchMode = obtainStyledAttributes.getInt(aia.b.SimpleSlider_ss_touchMode, this.mTouchMode);
        this.mTouchEventHandler = generateTouchEventHandler(this.mTouchMode);
        obtainStyledAttributes.recycle();
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    protected d generateTouchEventHandler(int i) {
        if (i == 1) {
            return new b();
        }
        return new c();
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    int getScaledTouchSlop() {
        return this.mScaledTouchSlop;
    }

    public void setTouchEventHandler(d dVar) {
        this.mTouchEventHandler = dVar;
    }

    public void refreshVisual() {
        if (this.mProgressDrawableRes != -1) {
            setProgressDrawable(getContext().getDrawable(this.mProgressDrawableRes));
        }
        if (this.mTickMarkRes != -1) {
            setTickMark(getContext().getDrawable(this.mTickMarkRes));
        }
        int range = getRange();
        setVisualProgress(range > 0 ? (getProgress() - getMin()) / range : 0.0f);
    }

    public int getMin() {
        return this.mMin;
    }

    public void setMin(int i) {
        int i2;
        if (this.mMaxInitialized && i > (i2 = this.mMax)) {
            i = i2;
        }
        this.mMinInitialized = true;
        if (this.mMaxInitialized && i != this.mMin) {
            this.mMin = i;
            postInvalidate();
            if (this.mProgress < i) {
                this.mProgress = i;
            }
            setProgress(this.mProgress);
            return;
        }
        this.mMin = i;
    }

    public int getMax() {
        return this.mMax;
    }

    public void setMax(int i) {
        int i2;
        if (this.mMinInitialized && i < (i2 = this.mMin)) {
            i = i2;
        }
        this.mMaxInitialized = true;
        if (this.mMinInitialized && i != this.mMax) {
            this.mMax = i;
            postInvalidate();
            if (this.mProgress > i) {
                this.mProgress = i;
            }
            setProgress(this.mProgress);
            return;
        }
        this.mMax = i;
    }

    public int getRange() {
        return this.mMax - this.mMin;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setOnSlideChangeListener(a aVar) {
        this.mOnSlideChangeListener = aVar;
    }

    public void setProgress(int i) {
        setProgressInternal(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgressInternal(int i, boolean z) {
        int limitProgress = limitProgress(i);
        this.mProgress = limitProgress;
        int i2 = this.mMax;
        int i3 = this.mMin;
        int i4 = i2 - i3;
        setVisualProgress(i4 > 0 ? (limitProgress - i3) / i4 : 0.0f);
        a aVar = this.mOnSlideChangeListener;
        if (aVar != null) {
            aVar.a(this, limitProgress, z);
        }
    }

    public float getSlideScale() {
        return this.mSlideScale;
    }

    public void setSlideScale(float f) {
        this.mSlideScale = f;
    }

    public void setProgressDrawable(Drawable drawable) {
        Drawable drawable2 = this.mProgressDrawable;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.mProgressDrawable);
            }
            this.mProgressDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                drawable.setLayoutDirection(getLayoutDirection());
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                updateDrawableBounds(getWidth(), getHeight());
                updateDrawableState();
            }
        }
    }

    public void setTickMark(Drawable drawable) {
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setLayoutDirection(getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
        invalidate();
    }

    public Drawable getTickMark() {
        return this.mTickMark;
    }

    private void updateDrawableBounds(int i, int i2) {
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, paddingRight, paddingTop);
        }
    }

    private void updateDrawableState() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mProgressDrawable;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    protected void setVisualProgress(float f) {
        Drawable drawable = this.mProgressDrawable;
        if ((drawable instanceof LayerDrawable) && (drawable = ((LayerDrawable) drawable).findDrawableByLayerId(16908301)) == null) {
            drawable = this.mProgressDrawable;
        }
        if (drawable != null) {
            drawable.setLevel((int) (f * 10000.0f));
        } else {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        Drawable drawable = this.mProgressDrawable;
        int i = NO_ALPHA;
        if (drawable != null) {
            drawable.setAlpha(isEnabled() ? NO_ALPHA : (int) (this.mDisabledAlpha * 255.0f));
        }
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            if (!isEnabled()) {
                i = (int) (this.mDisabledAlpha * 255.0f);
            }
            drawable2.setAlpha(i);
        }
        super.drawableStateChanged();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mProgressDrawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        setPressed(true);
                        break;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            setPressed(false);
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            d dVar = this.mTouchEventHandler;
            if (dVar != null) {
                return dVar.a(this, motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateDrawableBounds(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        drawTickMarks(canvas);
    }

    protected void drawTickMarks(Canvas canvas) {
        Drawable tickMark = getTickMark();
        if (tickMark != null) {
            int max = getMax() - getMin();
            if (max > 1) {
                int intrinsicWidth = tickMark.getIntrinsicWidth();
                int intrinsicHeight = tickMark.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                tickMark.setBounds(-i, -i2, i, i2);
                float width = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mTickMarkPadding * 2.0f)) / max;
                int save = canvas.save();
                canvas.translate(getPaddingLeft(), getHeight() >> 1);
                canvas.translate(this.mTickMarkPadding + width, 0.0f);
                for (int i3 = 1; i3 < max && (this.mTickMarkAll || ((!this.mTickMarkProgressEnd || i3 <= this.mProgress) && (this.mTickMarkProgressEnd || i3 < this.mProgress))); i3++) {
                    tickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected void onStartTrackingTouch() {
        a aVar = this.mOnSlideChangeListener;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    protected void onStopTrackingTouch() {
        a aVar = this.mOnSlideChangeListener;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    private int limitProgress(int i) {
        return Math.min(this.mMax, Math.max(i, this.mMin));
    }

    public boolean isInScrollingContainer() {
        for (ViewParent parent = getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: SimpleSlider.java */
    /* renamed from: aib$c */
    /* loaded from: classes.dex */
    public static class c implements d {
        private aib a;
        private float b;
        private int c;
        private boolean d;

        @Override // defpackage.aib.d
        public boolean a(aib aibVar, MotionEvent motionEvent) {
            this.a = aibVar;
            return a(motionEvent);
        }

        private boolean a(MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.b = motionEvent.getX();
                    break;
                case 1:
                case 3:
                    if (this.d) {
                        this.a.onStopTrackingTouch();
                        this.d = false;
                        break;
                    }
                    break;
                case 2:
                    if (this.d) {
                        b(motionEvent);
                        break;
                    } else if (Math.abs(motionEvent.getX() - this.b) > this.a.getScaledTouchSlop()) {
                        this.c = this.a.getProgress();
                        this.d = true;
                        this.a.onStartTrackingTouch();
                        b(motionEvent);
                        this.a.attemptClaimDrag();
                        break;
                    }
                    break;
            }
            return true;
        }

        private void b(MotionEvent motionEvent) {
            this.a.setProgressInternal(Math.round(this.c + ((Math.round(motionEvent.getX() - this.b) / ((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight())) * this.a.getSlideScale() * (this.a.getMax() - this.a.getMin())) + this.a.getMin()), true);
        }
    }

    /* compiled from: SimpleSlider.java */
    /* renamed from: aib$b */
    /* loaded from: classes.dex */
    public static class b implements d {
        private aib a;
        private float b;
        private boolean c;

        @Override // defpackage.aib.d
        public boolean a(aib aibVar, MotionEvent motionEvent) {
            this.a = aibVar;
            return a(motionEvent);
        }

        private boolean a(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.a.isInScrollingContainer()) {
                        this.b = motionEvent.getX();
                        return true;
                    }
                    a();
                    b(motionEvent);
                    this.a.attemptClaimDrag();
                    return true;
                case 1:
                    if (this.c) {
                        b(motionEvent);
                        b();
                        return true;
                    }
                    a();
                    b(motionEvent);
                    b();
                    return true;
                case 2:
                    if (this.c) {
                        b(motionEvent);
                        return true;
                    } else if (Math.abs(motionEvent.getX() - this.b) > this.a.getScaledTouchSlop()) {
                        a();
                        b(motionEvent);
                        this.a.attemptClaimDrag();
                        return true;
                    } else {
                        return true;
                    }
                case 3:
                    if (this.c) {
                        b();
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }

        private void a() {
            this.c = true;
            this.a.onStartTrackingTouch();
        }

        private void b() {
            this.c = false;
            this.a.onStopTrackingTouch();
        }

        private void b(MotionEvent motionEvent) {
            this.a.setProgressInternal(Math.round(((Math.round(motionEvent.getX()) / ((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight())) * (this.a.getMax() - this.a.getMin())) + this.a.getMin() + 0.0f), true);
        }
    }
}
