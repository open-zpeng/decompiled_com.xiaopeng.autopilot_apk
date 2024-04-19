package com.xiaopeng.autopilot.base.bean.eventbus;

import android.content.Context;
import android.graphics.RectF;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.lib.utils.view.UIUtils;
/* loaded from: classes.dex */
public class EventParkLotMsg {
    public int attribute;
    public int centerX;
    public int centerY;
    public RectF rect;
    public float sAngle;
    public int tag;
    public int width;
    public int x;
    public int y;

    public EventParkLotMsg(int i, int i2, int i3, int i4, float f, int i5) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.sAngle = f;
        this.tag = i4;
        this.attribute = i5;
    }

    public EventParkLotMsg(int i, int i2, int i3, int i4, float f, int i5, RectF rectF) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.sAngle = f;
        this.tag = i4;
        this.attribute = i5;
        this.rect = rectF;
    }

    public EventParkLotMsg(int i, int i2, int i3, int i4, float f, int i5, RectF rectF, int i6, int i7) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.sAngle = f;
        this.tag = i4;
        this.attribute = i5;
        this.rect = rectF;
        this.centerX = i6;
        this.centerY = i7;
    }

    public String toString() {
        return "X:" + this.x + "\tY:" + this.y + "\tAngle:" + this.sAngle + "\tWidth:" + this.width + "\ttag:" + this.tag;
    }

    public boolean isLeft() {
        float f = this.rect.left + this.rect.right + this.rect.left;
        Context applicationContext = a.g().getApplicationContext();
        return (f + this.rect.right) / 4.0f < ((float) (UIUtils.dip2px(applicationContext, applicationContext.getResources().getDimension(h.c.parking_surfaceview_width)) / 2));
    }
}
