package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.xiaopeng.xui.Xui;
import com.xiaopeng.xui.utils.XInputUtils;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.vui.floatinglayer.VuiFloatingLayerManager;
import com.xiaopeng.xui.vui.utils.VuiUtils;
import defpackage.acu;
/* loaded from: classes.dex */
public class XTextFields extends XTextInput implements abn, View.OnClickListener {
    private CheckStateChangeListener checkStateChangeListener;
    private Context mContext;
    private ImageButton mPassWordView;
    private boolean mPasswordCheck;
    private boolean mPasswordEnable;

    /* loaded from: classes.dex */
    public interface CheckStateChangeListener {
        void onCheckStateChanged();
    }

    public XTextFields(Context context) {
        this(context, null);
    }

    public XTextFields(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XTextFields(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public XTextFields(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, acu.l.XTextFields);
        boolean z = obtainStyledAttributes.getBoolean(acu.l.XTextFields_text_fields_password_enabled, false);
        obtainStyledAttributes.recycle();
        setPasswordEnable(z);
        this.mContext = context;
    }

    @Override // com.xiaopeng.xui.widget.XTextInput
    protected void initView() {
        LayoutInflater.from(getContext()).inflate(acu.i.x_text_fields, this);
        this.mResetView = (ImageButton) findViewById(acu.g.x_text_fields_reset);
        this.mPassWordView = (ImageButton) findViewById(acu.g.x_text_fields_pass);
        this.mEditText = (EditText) findViewById(acu.g.x_text_fields_edit);
        this.mErrorTextView = (TextView) findViewById(acu.g.x_text_fields_error);
        this.mStatusView = findViewById(acu.g.x_text_fields_line);
        this.mPassWordView.setOnClickListener(this);
        XInputUtils.ignoreHiddenInput(this.mPassWordView);
    }

    public boolean isPasswordEnable() {
        return this.mPasswordEnable;
    }

    public void setPasswordEnable(boolean z) {
        if (this.mPasswordEnable != z) {
            this.mPasswordEnable = z;
            int selectionEnd = this.mEditText.getSelectionEnd();
            this.mPassWordView.setVisibility(z ? 0 : 8);
            if (z) {
                this.mPasswordCheck = true;
                this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                this.mEditText.setTransformationMethod(null);
                this.mPasswordCheck = false;
            }
            this.mPassWordView.setSelected(this.mPasswordCheck);
            this.mEditText.setSelection(selectionEnd);
        }
    }

    public void passwordCheckToggleRequested() {
        CheckStateChangeListener checkStateChangeListener;
        if (this.mPasswordEnable) {
            int selectionEnd = this.mEditText.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.mEditText.setTransformationMethod(null);
                this.mPasswordCheck = false;
            } else {
                this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.mPasswordCheck = true;
            }
            this.mPassWordView.setSelected(this.mPasswordCheck);
            this.mEditText.setSelection(selectionEnd);
            if (!Xui.isVuiEnable() || (checkStateChangeListener = this.checkStateChangeListener) == null) {
                return;
            }
            checkStateChangeListener.onCheckStateChanged();
        }
    }

    private boolean hasPasswordTransformation() {
        return this.mEditText != null && (this.mEditText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == acu.g.x_text_fields_pass) {
            passwordCheckToggleRequested();
        }
    }

    public abx onBuildVuiElement(String str, abl ablVar) {
        if (this.mPassWordView instanceof VuiView) {
            VuiUtils.setStatefulButtonAttr((VuiView) this.mPassWordView, !this.mPasswordCheck ? 1 : 0, new String[]{this.mContext.getString(acu.j.vui_label_hide_password), this.mContext.getString(acu.j.vui_label_display_password)});
            return null;
        }
        return null;
    }

    @Override // defpackage.abn
    public boolean onVuiElementEvent(final View view, aby abyVar) {
        logD("textfields onVuiElementEvent");
        if (view == null) {
            return false;
        }
        if (view.getId() == this.mPassWordView.getId()) {
            String str = (String) abyVar.a(abyVar);
            if (!(this.mPasswordCheck && str.equals(this.mContext.getString(acu.j.vui_label_hide_password))) && (this.mPasswordCheck || !str.equals(this.mContext.getString(acu.j.vui_label_display_password)))) {
                post(new Runnable() { // from class: com.xiaopeng.xui.widget.XTextFields.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VuiFloatingLayerManager.show(view);
                        XTextFields.this.passwordCheckToggleRequested();
                    }
                });
                return true;
            }
            return true;
        }
        if (view.getVisibility() == 0 && view.isEnabled()) {
            post(new Runnable() { // from class: com.xiaopeng.xui.widget.-$$Lambda$XTextFields$ZQ-mDqZK3VUmPHHAmlRctH325y0
                @Override // java.lang.Runnable
                public final void run() {
                    VuiFloatingLayerManager.show(view);
                }
            });
        }
        return false;
    }

    public void setCheckStateChangeListener(CheckStateChangeListener checkStateChangeListener) {
        this.checkStateChangeListener = checkStateChangeListener;
    }
}
