package com.xiaopeng.xui.widget.quicksidebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.xui.sound.XSoundEffectManager;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.view.XViewDelegate;
import com.xiaopeng.xui.view.font.XFontScaleHelper;
import com.xiaopeng.xui.widget.quicksidebar.listener.OnQuickSideBarTouchListener;
import defpackage.acu;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class XQuickSideBarView extends XView implements XViewDelegate.onFontScaleChangeCallback {
    private OnQuickSideBarTouchListener listener;
    private boolean mAlwaysHighlight;
    private int mChoose;
    private int mHeight;
    private boolean mIsTouchMove;
    private float mItemHeight;
    private final float mItemStartY;
    private float mItemWidth;
    private List<String> mLetters;
    private Paint mPaint;
    private int mTextColor;
    private int mTextColorChoose;
    private float mTextSize;
    private float mTextSizeChoose;
    private int mWidth;

    @Override // com.xiaopeng.xui.view.XViewDelegate.onFontScaleChangeCallback
    public void onFontScaleChanged() {
    }

    public XQuickSideBarView(Context context) {
        this(context, null);
    }

    public XQuickSideBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XQuickSideBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChoose = -1;
        this.mPaint = new Paint();
        this.mItemStartY = 14.0f;
        this.mIsTouchMove = false;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mLetters = Arrays.asList(context.getResources().getStringArray(acu.b.x_quick_side_bar_letters));
        initDefaultColor();
        this.mTextSize = context.getResources().getDimensionPixelSize(acu.e.x_sidebar_textsize);
        this.mTextSizeChoose = context.getResources().getDimensionPixelSize(acu.e.x_sidebar_choose_textsize);
        this.mItemHeight = context.getResources().getDimension(acu.e.x_sidebar_item_height);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, acu.l.XQuickSideBarView);
            this.mTextColor = obtainStyledAttributes.getColor(acu.l.XQuickSideBarView_sidebarTextColor, this.mTextColor);
            this.mTextColorChoose = obtainStyledAttributes.getColor(acu.l.XQuickSideBarView_sidebarTextColorChoose, this.mTextColorChoose);
            this.mTextSize = obtainStyledAttributes.getDimension(acu.l.XQuickSideBarView_sidebarTextSize, this.mTextSize);
            this.mTextSizeChoose = obtainStyledAttributes.getDimension(acu.l.XQuickSideBarView_sidebarTextSizeChoose, this.mTextSizeChoose);
            this.mAlwaysHighlight = obtainStyledAttributes.getBoolean(acu.l.XQuickSideBarView_sidebarHighlight, false);
            final XFontScaleHelper create = XFontScaleHelper.create(obtainStyledAttributes, acu.l.XQuickSideBarView_sidebarTextSize, acu.e.x_sidebar_textsize);
            final XFontScaleHelper create2 = XFontScaleHelper.create(obtainStyledAttributes, acu.l.XQuickSideBarView_sidebarTextSizeChoose, acu.e.x_sidebar_choose_textsize);
            if (this.mXViewDelegate != null) {
                this.mXViewDelegate.setFontScaleChangeCallback(new XViewDelegate.onFontScaleChangeCallback() { // from class: com.xiaopeng.xui.widget.quicksidebar.-$$Lambda$XQuickSideBarView$1ZB34fs1FOEgdHSSURf-ptiofIs
                    @Override // com.xiaopeng.xui.view.XViewDelegate.onFontScaleChangeCallback
                    public final void onFontScaleChanged() {
                        XQuickSideBarView.lambda$init$0(XQuickSideBarView.this, create, create2);
                    }
                });
            }
            this.mItemHeight = obtainStyledAttributes.getDimension(acu.l.XQuickSideBarView_sidebarItemHeight, this.mItemHeight);
            obtainStyledAttributes.recycle();
        }
        if (this.mXViewDelegate != null && this.mXViewDelegate.getThemeViewModel() != null) {
            this.mXViewDelegate.getThemeViewModel().setCallback(new ThemeViewModel.OnCallback() { // from class: com.xiaopeng.xui.widget.quicksidebar.-$$Lambda$XQuickSideBarView$wKv8A9QBMc1F3uP8mqZVN01Nvxo
                @Override // com.xiaopeng.libtheme.ThemeViewModel.OnCallback
                public final void onThemeChanged() {
                    XQuickSideBarView.lambda$init$1(XQuickSideBarView.this);
                }
            });
        }
        setSoundEffectsEnabled(false);
    }

    public static /* synthetic */ void lambda$init$0(XQuickSideBarView xQuickSideBarView, XFontScaleHelper xFontScaleHelper, XFontScaleHelper xFontScaleHelper2) {
        if (xFontScaleHelper != null) {
            xQuickSideBarView.mTextSize = xFontScaleHelper.getCurrentFontSize(xQuickSideBarView.getResources().getDisplayMetrics());
        }
        if (xFontScaleHelper2 != null) {
            xQuickSideBarView.mTextSizeChoose = xFontScaleHelper2.getCurrentFontSize(xQuickSideBarView.getResources().getDisplayMetrics());
        }
        xQuickSideBarView.invalidate();
    }

    public static /* synthetic */ void lambda$init$1(XQuickSideBarView xQuickSideBarView) {
        xQuickSideBarView.initDefaultColor();
        xQuickSideBarView.invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mHeight = getMeasuredHeight();
        this.mWidth = getMeasuredWidth();
        float size = this.mHeight / this.mLetters.size();
        float f = this.mItemHeight;
        if (f <= size) {
            size = f;
        }
        this.mItemHeight = size;
        this.mItemWidth = this.mItemHeight;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (i < this.mLetters.size()) {
            Paint paint = new Paint();
            if (i == this.mChoose) {
                this.mPaint.setTextSize(this.mTextSizeChoose);
                this.mPaint.setColor(this.mTextColorChoose);
                paint.setColor(getColor(acu.d.x_side_bar_item_choose_bg_color));
            } else {
                this.mPaint.setTextSize(this.mTextSize);
                this.mPaint.setColor(this.mTextColor);
                paint.setColor(getColor(acu.d.x_side_bar_item_bg_color));
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            float f = this.mItemWidth;
            float f2 = (this.mWidth - f) / 2.0f;
            float f3 = this.mItemHeight;
            int i2 = i + 1;
            RectF rectF = new RectF(f2, (i * f3) + 14.0f, f + f2, (i2 * f3) + 14.0f);
            canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            this.mPaint.setFakeBoldText(true);
            this.mPaint.setTypeface(Typeface.create(getResources().getString(acu.j.x_font_typeface_medium), 0));
            Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
            canvas.drawText(this.mLetters.get(i), rectF.centerX(), rectF.centerY() + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.mPaint);
            this.mPaint.reset();
            i = i2;
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.mChoose;
        int i2 = (int) ((y - 14.0f) / this.mItemHeight);
        switch (action) {
            case 0:
            case 2:
                this.mIsTouchMove = true;
                if (i != i2 && i2 >= 0 && i2 < this.mLetters.size()) {
                    this.mChoose = i2;
                    invalidate();
                    XSoundEffectManager.get().play(2);
                    OnQuickSideBarTouchListener onQuickSideBarTouchListener = this.listener;
                    if (onQuickSideBarTouchListener != null) {
                        onQuickSideBarTouchListener.onLetterTouched(true);
                        this.listener.onLetterScrolling(this.mLetters.get(i2), this.mChoose);
                        break;
                    }
                }
                break;
            case 1:
                this.mIsTouchMove = false;
                this.mChoose = -1;
                OnQuickSideBarTouchListener onQuickSideBarTouchListener2 = this.listener;
                if (onQuickSideBarTouchListener2 != null) {
                    onQuickSideBarTouchListener2.onLetterTouched(false);
                }
                if (!this.mAlwaysHighlight) {
                    invalidate();
                    break;
                }
                break;
            case 3:
                this.mIsTouchMove = false;
                XSoundEffectManager.get().release(2);
                OnQuickSideBarTouchListener onQuickSideBarTouchListener3 = this.listener;
                if (onQuickSideBarTouchListener3 != null) {
                    onQuickSideBarTouchListener3.onLetterTouched(false);
                }
                this.mChoose = -1;
                invalidate();
                break;
        }
        return true;
    }

    public OnQuickSideBarTouchListener getListener() {
        return this.listener;
    }

    public void setOnQuickSideBarTouchListener(OnQuickSideBarTouchListener onQuickSideBarTouchListener) {
        this.listener = onQuickSideBarTouchListener;
    }

    public List<String> getLetters() {
        return this.mLetters;
    }

    public void setLetters(List<String> list) {
        this.mLetters = list;
        invalidate();
    }

    private void initDefaultColor() {
        this.mTextColor = getColor(acu.d.x_theme_text_03);
        this.mTextColorChoose = getColor(acu.d.x_side_bar_text_choose_color);
    }

    private int getColor(int i) {
        return getResources().getColor(i, getContext().getTheme());
    }

    public void setSideBarHighLight(String str) {
        setSideBarHighLight(str, false);
    }

    public void setSideBarHighLight(String str, boolean z) {
        int indexOf;
        if (this.mAlwaysHighlight && !this.mIsTouchMove) {
            logD("setSideBarHighLight");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!z) {
                indexOf = this.mLetters.indexOf(str.toUpperCase());
            } else {
                indexOf = this.mLetters.indexOf(str);
            }
            if (indexOf < 0 || this.mChoose == indexOf) {
                return;
            }
            this.mChoose = indexOf;
            invalidate();
        }
    }

    private void setSideBarHighLight(int i) {
        if (this.mAlwaysHighlight && !this.mIsTouchMove) {
            int size = this.mLetters.size();
            if (i < 0 || i >= size || this.mChoose == i) {
                return;
            }
            this.mChoose = i;
            invalidate();
        }
    }
}
