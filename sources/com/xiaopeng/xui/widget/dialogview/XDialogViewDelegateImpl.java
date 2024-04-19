package com.xiaopeng.xui.widget.dialogview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.recyclerview.widget.j;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.xui.utils.XLogUtils;
import com.xiaopeng.xui.utils.XTouchAreaUtils;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XScrollView;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.dialogview.XCountDown;
import com.xiaopeng.xui.widget.dialogview.XDialogViewInterface;
import defpackage.acu;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class XDialogViewDelegateImpl extends XDialogViewDelegate {
    private View mCloseView;
    private ViewGroup mContentView;
    private XCountDown mCountDownHandler;
    private XDialogViewInterface.OnClickListener mItemListener;
    private XButton mNegativeButton;
    private boolean mNegativeInterceptDismiss;
    private XDialogViewInterface.OnClickListener mNegativeListener;
    private View.OnClickListener mOnClickListener;
    private XDialogViewInterface.OnCloseListener mOnCloseListener;
    private XDialogViewInterface.OnCountDownListener mOnCountDownListener;
    private XDialogViewInterface.OnDismissListener mOnDismissListener;
    private XButton mPositiveButton;
    private boolean mPositiveInterceptDismiss;
    private XDialogViewInterface.OnClickListener mPositiveListener;
    private XDialogContentView mRootView;
    private TextView mTextTitle;
    private ViewGroup mTextTitleLayout;
    private View mViewHasButtons;
    private XDialogList mXDialogList;
    private XDialogMessage mXDialogMessage;
    private XScrollView mXDialogScroll;

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public boolean onKey(int i, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XDialogViewDelegateImpl(XDialogView xDialogView, Context context, int i) {
        super(xDialogView, context, i);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.xiaopeng.xui.widget.dialogview.XDialogViewDelegateImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int id = view.getId();
                boolean z = XDialogViewDelegateImpl.this.mPositiveInterceptDismiss;
                boolean z2 = XDialogViewDelegateImpl.this.mNegativeInterceptDismiss;
                if (id == acu.g.x_dialog_button1) {
                    if (XDialogViewDelegateImpl.this.mPositiveListener == null) {
                        XDialogViewDelegateImpl.this.logs("onClick mPositiveListener is null");
                    } else {
                        XDialogViewDelegateImpl xDialogViewDelegateImpl = XDialogViewDelegateImpl.this;
                        xDialogViewDelegateImpl.logs("onClick  positiveIntercept " + z + " , mPositiveListener " + XDialogViewDelegateImpl.this.mPositiveListener);
                        XDialogViewDelegateImpl.this.mPositiveListener.onClick(XDialogViewDelegateImpl.this.mXDelegator, -1);
                        if (z) {
                            return;
                        }
                    }
                } else if (id == acu.g.x_dialog_button2) {
                    if (XDialogViewDelegateImpl.this.mNegativeListener == null) {
                        XDialogViewDelegateImpl.this.logs("onClick mNegativeListener is null");
                    } else {
                        XDialogViewDelegateImpl xDialogViewDelegateImpl2 = XDialogViewDelegateImpl.this;
                        xDialogViewDelegateImpl2.logs("onClick negativeIntercept " + z2 + " , mNegativeListener " + XDialogViewDelegateImpl.this.mNegativeListener);
                        XDialogViewDelegateImpl.this.mNegativeListener.onClick(XDialogViewDelegateImpl.this.mXDelegator, -2);
                        if (z2) {
                            return;
                        }
                    }
                } else if (id == acu.g.x_dialog_close) {
                    XDialogViewDelegateImpl.this.logs("onClick close");
                    if (XDialogViewDelegateImpl.this.mOnCloseListener != null && XDialogViewDelegateImpl.this.mOnCloseListener.onClose(XDialogViewDelegateImpl.this.mXDelegator)) {
                        XDialogViewDelegateImpl.this.logs("onClick close intercept dismiss ");
                        return;
                    }
                } else {
                    XDialogViewDelegateImpl xDialogViewDelegateImpl3 = XDialogViewDelegateImpl.this;
                    xDialogViewDelegateImpl3.logs("onClick invalid id " + id);
                }
                XDialogViewDelegateImpl.this.dismiss();
            }
        };
        init();
    }

    private void init() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes((AttributeSet) null, acu.l.XDialog);
        int dimension = (int) obtainStyledAttributes.getDimension(acu.l.XDialog_dialog_max_height, 0.0f);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(acu.l.XDialog_dialog_width, 0);
        int layoutDimension2 = obtainStyledAttributes.getLayoutDimension(acu.l.XDialog_dialog_height, 0);
        obtainStyledAttributes.recycle();
        this.mRootView = new XDialogContentView(this, this.mContext);
        this.mRootView.setMaxHeight(dimension);
        this.mRootView.setMinimumHeight(this.mContext.getResources().getDimensionPixelSize(acu.e.x_dialog_min_height));
        this.mRootView.setWidth(layoutDimension);
        this.mRootView.setHeight(layoutDimension2);
        logs("maxHeight:" + dimension + ",w:" + layoutDimension + ", h " + layoutDimension2);
        LayoutInflater.from(this.mContext).inflate(acu.i.x_dialog, this.mRootView);
        initView(this.mRootView);
    }

    private void initView(View view) {
        this.mTextTitleLayout = (ViewGroup) view.findViewById(acu.g.x_dialog_title_layout);
        this.mCloseView = view.findViewById(acu.g.x_dialog_close);
        this.mTextTitle = (TextView) view.findViewById(acu.g.x_dialog_title);
        this.mContentView = (ViewGroup) view.findViewById(acu.g.x_dialog_content);
        this.mPositiveButton = (XButton) view.findViewById(acu.g.x_dialog_button1);
        this.mNegativeButton = (XButton) view.findViewById(acu.g.x_dialog_button2);
        this.mViewHasButtons = view.findViewById(acu.g.x_dialog_has_buttons);
        this.mCloseView.setOnClickListener(this.mOnClickListener);
        this.mPositiveButton.setOnClickListener(this.mOnClickListener);
        this.mNegativeButton.setOnClickListener(this.mOnClickListener);
        this.mRootView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.xiaopeng.xui.widget.dialogview.XDialogViewDelegateImpl.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                XDialogViewDelegateImpl.this.extendTouchArea();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (XDialogViewDelegateImpl.this.mCountDownHandler != null) {
                    XDialogViewDelegateImpl.this.mCountDownHandler.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismiss() {
        XDialogViewInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this.mXDelegator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setTitle(CharSequence charSequence) {
        this.mTextTitle.setText(charSequence);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setTitle(int i) {
        this.mTextTitle.setText(i);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setIcon(int i) {
        prepareMessage();
        this.mXDialogMessage.setIcon(i);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setIcon(Drawable drawable) {
        prepareMessage();
        this.mXDialogMessage.setIcon(drawable);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setMessage(CharSequence charSequence) {
        prepareMessage();
        this.mXDialogMessage.setMessage(charSequence);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setMessage(int i) {
        prepareMessage();
        this.mXDialogMessage.setMessage(i);
    }

    private void prepareMessage() {
        if (this.mXDialogMessage == null) {
            this.mXDialogMessage = new XDialogMessage(this.mContext);
        }
        this.mContentView.removeAllViews();
        this.mContentView.addView(this.mXDialogMessage);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setCustomView(View view) {
        setCustomView(view, true);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setCustomView(View view, boolean z) {
        this.mContentView.removeAllViews();
        if (z) {
            if (this.mXDialogScroll == null) {
                this.mXDialogScroll = (XScrollView) LayoutInflater.from(this.mContext).inflate(acu.i.x_dialog_scroll, this.mContentView, false);
            }
            this.mXDialogScroll.removeAllViews();
            this.mContentView.addView(this.mXDialogScroll);
            this.mXDialogScroll.addView(view);
            return;
        }
        this.mContentView.addView(view);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setCustomView(int i) {
        setCustomView(i, true);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setCustomView(int i, boolean z) {
        setCustomView(LayoutInflater.from(getContext()).inflate(i, this.mContentView, false), z);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    @Deprecated
    public void setSingleChoiceItems(CharSequence[] charSequenceArr, int i, XDialogViewInterface.OnClickListener onClickListener) {
        if (this.mXDialogList == null) {
            this.mXDialogList = new XDialogList(getContext());
        }
        this.mContentView.removeAllViews();
        this.mContentView.addView(this.mXDialogList);
        this.mXDialogList.setSingleChoiceItems(charSequenceArr, i, new AdapterView.OnItemClickListener() { // from class: com.xiaopeng.xui.widget.dialogview.-$$Lambda$XDialogViewDelegateImpl$rRQqXOMO6vKrH5nQXK80WFX9l94
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                XDialogViewDelegateImpl.lambda$setSingleChoiceItems$0(XDialogViewDelegateImpl.this, adapterView, view, i2, j);
            }
        });
        this.mItemListener = onClickListener;
    }

    public static /* synthetic */ void lambda$setSingleChoiceItems$0(XDialogViewDelegateImpl xDialogViewDelegateImpl, AdapterView adapterView, View view, int i, long j) {
        XDialogViewInterface.OnClickListener onClickListener = xDialogViewDelegateImpl.mItemListener;
        if (onClickListener != null) {
            onClickListener.onClick(xDialogViewDelegateImpl.mXDelegator, i);
        }
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setCloseVisibility(final boolean z) {
        this.mCloseView.setVisibility(z ? 0 : 4);
        if (this.mCloseView.getWidth() > 0) {
            resetTitlePadding(z);
        } else {
            this.mCloseView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.xiaopeng.xui.widget.dialogview.XDialogViewDelegateImpl.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    XDialogViewDelegateImpl.this.mCloseView.getViewTreeObserver().removeOnPreDrawListener(this);
                    XDialogViewDelegateImpl.this.resetTitlePadding(z);
                    return true;
                }
            });
        }
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public boolean isCloseShowing() {
        return this.mCloseView.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTitlePadding(boolean z) {
        if (z) {
            int width = this.mCloseView.getWidth();
            int dimension = (int) this.mContext.getResources().getDimension(acu.e.x_dialog_close_padding);
            ViewGroup.LayoutParams layoutParams = this.mTextTitle.getLayoutParams();
            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin : 0;
            int i2 = ((dimension * 2) + width) - i;
            this.mTextTitle.setPadding(i2, 0, i2, 0);
            logs(String.format("resetTitlePadding closeWidth: %s ,closeMargin: %s ,textMargin: %s ,padding: %s", Integer.valueOf(width), Integer.valueOf(dimension), Integer.valueOf(i), Integer.valueOf(i2)));
            return;
        }
        this.mTextTitle.setPadding(0, 0, 0, 0);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    @Deprecated
    public void setTitleVisibility(boolean z) {
        setTitleBarVisibility(z);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setTitleBarVisibility(boolean z) {
        this.mTextTitleLayout.setVisibility(z ? 0 : 8);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setPositiveButton(int i) {
        if (i == 0) {
            setPositiveButton((CharSequence) null);
        } else {
            setPositiveButton(this.mContext.getText(i));
        }
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setPositiveButton(CharSequence charSequence) {
        this.mPositiveButton.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.mPositiveButton.setText(charSequence);
        resetButton();
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setPositiveButtonListener(XDialogViewInterface.OnClickListener onClickListener) {
        this.mPositiveListener = onClickListener;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setPositiveButton(int i, XDialogViewInterface.OnClickListener onClickListener) {
        setPositiveButton(i);
        setPositiveButtonListener(onClickListener);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setPositiveButton(CharSequence charSequence, XDialogViewInterface.OnClickListener onClickListener) {
        setPositiveButton(charSequence);
        setPositiveButtonListener(onClickListener);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setNegativeButton(int i) {
        if (i == 0) {
            setNegativeButton((CharSequence) null);
        } else {
            setNegativeButton(this.mContext.getText(i));
        }
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setNegativeButton(CharSequence charSequence) {
        this.mNegativeButton.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.mNegativeButton.setText(charSequence);
        resetButton();
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setNegativeButtonListener(XDialogViewInterface.OnClickListener onClickListener) {
        this.mNegativeListener = onClickListener;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setNegativeButton(int i, XDialogViewInterface.OnClickListener onClickListener) {
        setNegativeButton(i);
        setNegativeButtonListener(onClickListener);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setNegativeButton(CharSequence charSequence, XDialogViewInterface.OnClickListener onClickListener) {
        setNegativeButton(charSequence);
        setNegativeButtonListener(onClickListener);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setPositiveButtonInterceptDismiss(boolean z) {
        this.mPositiveInterceptDismiss = z;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setNegativeButtonInterceptDismiss(boolean z) {
        this.mNegativeInterceptDismiss = z;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setPositiveButtonEnable(boolean z) {
        this.mPositiveButton.setEnabled(z);
        updateVui(this.mPositiveButton, z);
    }

    private void updateVui(XButton xButton, boolean z) {
        boolean z2 = false;
        try {
            JSONObject vuiProps = xButton.getVuiProps();
            if (z) {
                if (vuiProps != null && vuiProps.has("hasFeedback")) {
                    vuiProps.remove("hasFeedback");
                    z2 = true;
                }
            } else {
                if (vuiProps == null) {
                    vuiProps = new JSONObject();
                }
                if (!vuiProps.has("hasFeedback")) {
                    vuiProps.put("hasFeedback", true);
                    z2 = true;
                }
            }
            if (z2) {
                xButton.setVuiProps(vuiProps);
                xButton.updateVui(xButton);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setNegativeButtonEnable(boolean z) {
        this.mNegativeButton.setEnabled(z);
        updateVui(this.mNegativeButton, z);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public boolean isPositiveButtonEnable() {
        XButton xButton = this.mPositiveButton;
        return xButton != null && xButton.isEnabled();
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public boolean isNegativeButtonEnable() {
        XButton xButton = this.mNegativeButton;
        return xButton != null && xButton.isEnabled();
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public boolean isPositiveButtonShowing() {
        XButton xButton = this.mPositiveButton;
        return xButton != null && xButton.getVisibility() == 0;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public boolean isNegativeButtonShowing() {
        XButton xButton = this.mNegativeButton;
        return xButton != null && xButton.getVisibility() == 0;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void startPositiveButtonCountDown(int i) {
        XCountDown xCountDown = this.mCountDownHandler;
        if (xCountDown != null) {
            xCountDown.stop();
        }
        if (this.mPositiveButton.getVisibility() != 0 || i <= 0) {
            return;
        }
        this.mCountDownHandler = new XCountDown(new XDialogCountDownHandlerCallBack(this.mPositiveButton, -1));
        this.mCountDownHandler.start(this.mPositiveButton.getText().toString(), i);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void startNegativeButtonCountDown(int i) {
        XCountDown xCountDown = this.mCountDownHandler;
        if (xCountDown != null) {
            xCountDown.stop();
        }
        if (this.mNegativeButton.getVisibility() != 0 || i <= 0) {
            return;
        }
        this.mCountDownHandler = new XCountDown(new XDialogCountDownHandlerCallBack(this.mNegativeButton, -2));
        this.mCountDownHandler.start(this.mNegativeButton.getText().toString(), i);
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setOnCloseListener(XDialogViewInterface.OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setOnCountDownListener(XDialogViewInterface.OnCountDownListener onCountDownListener) {
        this.mOnCountDownListener = onCountDownListener;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setOnDismissListener(XDialogViewInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void setThemeCallback(ThemeViewModel.OnCallback onCallback) {
        this.mRootView.setThemeCallback(onCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void extendTouchArea() {
        int[] iArr = {0, 20, 0, 0};
        XTouchAreaUtils.extendTouchArea(this.mPositiveButton, this.mRootView, iArr);
        XTouchAreaUtils.extendTouchArea(this.mNegativeButton, this.mRootView, iArr);
        int dimension = (int) this.mCloseView.getContext().getResources().getDimension(acu.e.x_dialog_close_padding);
        XTouchAreaUtils.extendTouchArea(this.mCloseView, this.mRootView, new int[]{dimension, dimension, dimension, dimension});
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public ViewGroup getContentView() {
        return this.mRootView;
    }

    private void resetButton() {
        if (this.mPositiveButton.getVisibility() == 0 || this.mNegativeButton.getVisibility() == 0) {
            this.mViewHasButtons.setVisibility(0);
        } else {
            this.mViewHasButtons.setVisibility(8);
        }
    }

    /* loaded from: classes.dex */
    private class XDialogCountDownHandlerCallBack implements XCountDown.CallBack {
        private int mBtnId;
        private TextView mButton;
        private String mString;

        XDialogCountDownHandlerCallBack(TextView textView, int i) {
            this.mButton = textView;
            this.mBtnId = i;
            this.mString = XDialogViewDelegateImpl.this.getContext().getString(acu.j.x_countdown_tips);
        }

        @Override // com.xiaopeng.xui.widget.dialogview.XCountDown.CallBack
        public void onCountDown(String str, int i, int i2) {
            this.mButton.setText(String.format(this.mString, str, Integer.valueOf(i2)));
            TextView textView = this.mButton;
            if (textView instanceof VuiView) {
                ((VuiView) textView).setVuiLabel(str);
            }
        }

        @Override // com.xiaopeng.xui.widget.dialogview.XCountDown.CallBack
        public void onCountDownOver(String str) {
            this.mButton.setText(str);
            if (XDialogViewDelegateImpl.this.mOnCountDownListener == null || !XDialogViewDelegateImpl.this.mOnCountDownListener.onCountDown(XDialogViewDelegateImpl.this.mXDelegator, this.mBtnId)) {
                XDialogViewDelegateImpl.this.mOnClickListener.onClick(this.mButton);
            } else {
                XDialogViewDelegateImpl.this.logs("onCountDown intercept onClick ");
            }
        }

        @Override // com.xiaopeng.xui.widget.dialogview.XCountDown.CallBack
        public void onCountDownStop(String str) {
            this.mButton.setText(str);
        }
    }

    @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewDelegate
    public void onBuildScenePrepare() {
        try {
            CharSequence text = ((XTextView) this.mRootView.findViewById(acu.g.x_dialog_title)).getText();
            if (text != null) {
                String charSequence = text.toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    String vuiLabel = this.mRootView.getVuiLabel();
                    if (TextUtils.isEmpty(vuiLabel)) {
                        this.mRootView.setVuiLabel(charSequence);
                    } else if (!vuiLabel.contains(charSequence)) {
                        this.mRootView.setVuiLabel(String.format("%s|%s", charSequence, vuiLabel));
                    }
                }
            }
            XImageButton xImageButton = (XImageButton) this.mRootView.findViewById(acu.g.x_dialog_close);
            if (xImageButton != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("generalAct", "System.Close");
                jSONObject.put("canVoiceControl", true);
                xImageButton.setVuiProps(jSONObject);
            }
            XButton xButton = (XButton) this.mRootView.findViewById(acu.g.x_dialog_button1);
            if (xButton.getVisibility() == 0) {
                if (this.mRootView.getContext().getString(acu.j.vui_label_confirm).equals(xButton.getText().toString())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("generalAct", "System.Confirm");
                    xButton.setVuiProps(jSONObject2);
                }
            } else {
                xButton.setVuiMode(abt.DISABLED);
            }
            XButton xButton2 = (XButton) this.mRootView.findViewById(acu.g.x_dialog_button2);
            if (xButton2.getVisibility() == 0) {
                if (this.mRootView.getContext().getString(acu.j.vui_label_cancel).equals(xButton2.getText().toString())) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("generalAct", "System.Cancel");
                    xButton2.setVuiProps(jSONObject3);
                    return;
                }
                return;
            }
            xButton2.setVuiMode(abt.DISABLED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class XDialogContentView extends XLinearLayout {
        private int mH;
        private int mMaxHeight;
        private int mW;

        public XDialogContentView(XDialogViewDelegateImpl xDialogViewDelegateImpl, Context context) {
            this(context, null);
        }

        public XDialogContentView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            setOrientation(1);
            setVuiLabel(getResources().getString(acu.j.vui_label_dialog));
        }

        public void setMaxHeight(int i) {
            this.mMaxHeight = i;
        }

        public void setWidth(int i) {
            this.mW = i;
        }

        public void setHeight(int i) {
            this.mH = i;
        }

        @Override // android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            XDialogViewDelegateImpl xDialogViewDelegateImpl = XDialogViewDelegateImpl.this;
            xDialogViewDelegateImpl.logs("hasWindowFocus " + z);
            if (this.mXViewDelegate != null) {
                this.mXViewDelegate.onWindowFocusChanged(z);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                XDialogViewDelegateImpl xDialogViewDelegateImpl = XDialogViewDelegateImpl.this;
                xDialogViewDelegateImpl.logs("onLayout-w:" + getWidth() + ",h:" + getHeight() + ", mMaxHeight " + this.mMaxHeight);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mW, 1073741824);
            int i3 = this.mH;
            if (i3 <= 0) {
                int i4 = this.mMaxHeight;
                if (i4 > 0) {
                    super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i4, j.UNDEFINED_DURATION));
                    return;
                } else {
                    super.onMeasure(makeMeasureSpec, i2);
                    return;
                }
            }
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }

        public void setThemeCallback(ThemeViewModel.OnCallback onCallback) {
            if (this.mXViewDelegate == null || this.mXViewDelegate.getThemeViewModel() == null) {
                return;
            }
            this.mXViewDelegate.getThemeViewModel().setCallback(onCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logs(String str) {
        XLogUtils.i("xpui-XDialogView", str + "--hashcode " + this.mXDelegator.hashCode());
    }
}
