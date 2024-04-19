package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioButton;
import defpackage.acu;
/* loaded from: classes.dex */
public class XCatalogBar extends XRadioGroup {
    private int[] mIcons;
    private String[] mNames;
    private int mOrientation;

    public XCatalogBar(Context context) {
        this(context, null);
    }

    public XCatalogBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, acu.l.XCatalogBar);
        int integer = obtainStyledAttributes.getInteger(acu.l.XCatalogBar_catalog_check_position, 0);
        int resourceId = obtainStyledAttributes.getResourceId(acu.l.XCatalogBar_catalog_text_array, 0);
        if (resourceId != 0) {
            this.mNames = getResources().getStringArray(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(acu.l.XCatalogBar_catalog_icon_array, 0);
        if (resourceId2 != 0) {
            String[] stringArray = getResources().getStringArray(resourceId2);
            if (stringArray.length > 0) {
                this.mIcons = new int[stringArray.length];
                for (int i = 0; i < stringArray.length; i++) {
                    this.mIcons[i] = getResources().getIdentifier(stringArray[i], "drawable", context.getPackageName());
                }
            }
        }
        obtainStyledAttributes.recycle();
        this.mOrientation = getResources().getConfiguration().orientation;
        init(integer);
    }

    private void init(int i) {
        LayoutInflater from = LayoutInflater.from(getContext());
        for (int i2 = 0; i2 < this.mNames.length; i2++) {
            RadioButton radioButton = (RadioButton) from.inflate(acu.i.x_catalogbar_item, (ViewGroup) this, false);
            radioButton.setText(this.mNames[i2]);
            int[] iArr = this.mIcons;
            if (i2 < iArr.length) {
                if (this.mOrientation == 1) {
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, iArr[i2], 0, 0);
                } else {
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(iArr[i2], 0, 0, 0);
                }
            }
            radioButton.setId(i2);
            addView(radioButton);
            if (i == i2) {
                radioButton.setChecked(true);
            }
        }
    }

    public void addTabItem(String str, int i) {
        addTabItem(str, i, -1);
    }

    public void addTabItem(CharSequence charSequence, int i, int i2) {
        RadioButton radioButton = (RadioButton) LayoutInflater.from(getContext()).inflate(acu.i.x_catalogbar_item, (ViewGroup) this, false);
        radioButton.setText(charSequence);
        if (this.mOrientation == 1) {
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, i, 0, 0);
        } else {
            radioButton.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        }
        radioButton.setId(getChildCount());
        addView(radioButton, i2);
    }
}
