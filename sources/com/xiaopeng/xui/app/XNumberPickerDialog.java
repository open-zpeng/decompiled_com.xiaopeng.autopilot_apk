package com.xiaopeng.xui.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.widget.XNumberPicker;
import defpackage.acu;
/* loaded from: classes.dex */
public class XNumberPickerDialog extends XDialog implements XDialogInterface.OnClickListener, XNumberPicker.OnValueChangeListener {
    private final XNumberPicker mNumberPicker;
    private OnXNumberSetListener mNumberSetListener;

    /* loaded from: classes.dex */
    public interface OnXNumberSetListener {
        void onXNumberSet(XNumberPicker xNumberPicker, CharSequence charSequence);
    }

    @Override // com.xiaopeng.xui.widget.XNumberPicker.OnValueChangeListener
    public void onValueChange(XNumberPicker xNumberPicker, int i, int i2) {
    }

    public XNumberPickerDialog(Context context, String[] strArr) {
        this(context, 0, strArr);
    }

    public XNumberPickerDialog(Context context, int i, String[] strArr) {
        super(context, resolveDialogTheme(context, i));
        View inflate = LayoutInflater.from(context).inflate(acu.i.x_number_picker, getContentView(), false);
        setCustomView(inflate, false);
        setPositiveButton(" ", this);
        setNegativeButton(" ", this);
        this.mNumberPicker = (XNumberPicker) inflate.findViewById(acu.g.x_number_picker);
        if (strArr != null) {
            this.mNumberPicker.setMinValue(1);
            this.mNumberPicker.setMaxValue(strArr.length);
            this.mNumberPicker.setDisplayedValues(strArr);
        }
        this.mNumberPicker.setOnValueChangedListener(this);
    }

    private static int resolveDialogTheme(Context context, int i) {
        return i == 0 ? acu.k.XDialogView_Large : i;
    }

    @Override // com.xiaopeng.xui.app.XDialog
    @Deprecated
    public XDialog setNegativeButton(CharSequence charSequence, XDialogInterface.OnClickListener onClickListener) {
        return super.setNegativeButton(charSequence, this);
    }

    @Override // com.xiaopeng.xui.app.XDialog
    @Deprecated
    public XDialog setPositiveButton(CharSequence charSequence, XDialogInterface.OnClickListener onClickListener) {
        return super.setPositiveButton(charSequence, this);
    }

    public void setNegativeButtonText(String str) {
        setNegativeButton(str, this);
    }

    public void setPositiveButtonText(String str) {
        setPositiveButton(str, this);
    }

    public XNumberPicker getXNumberPicker() {
        return this.mNumberPicker;
    }

    public void setXNumberSetListener(OnXNumberSetListener onXNumberSetListener) {
        this.mNumberSetListener = onXNumberSetListener;
    }

    @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
    public void onClick(XDialog xDialog, int i) {
        switch (i) {
            case -2:
                super.getDialog().cancel();
                this.mNumberPicker.setValue(2);
                return;
            case -1:
                OnXNumberSetListener onXNumberSetListener = this.mNumberSetListener;
                if (onXNumberSetListener != null) {
                    XNumberPicker xNumberPicker = this.mNumberPicker;
                    onXNumberSetListener.onXNumberSet(xNumberPicker, xNumberPicker.getDisplayedValueForCurrentSelection());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
