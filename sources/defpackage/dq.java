package defpackage;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.j;
import java.util.HashMap;
/* compiled from: MotionHelper.java */
/* renamed from: dq  reason: default package */
/* loaded from: classes.dex */
public class dq extends c implements dr {
    protected View[] a;
    private boolean j;
    private boolean k;
    private float l;

    public void a(Canvas canvas) {
    }

    public void a(View view, float f) {
    }

    public void a(dt dtVar) {
    }

    @Override // defpackage.dt.g
    public void a(dt dtVar, int i) {
    }

    @Override // defpackage.dt.g
    public void a(dt dtVar, int i, int i2) {
    }

    @Override // defpackage.dt.g
    public void a(dt dtVar, int i, int i2, float f) {
    }

    @Override // defpackage.dt.g
    public void a(dt dtVar, int i, boolean z, float f) {
    }

    public void a(dt dtVar, HashMap<View, dp> hashMap) {
    }

    public void b(Canvas canvas) {
    }

    public boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.c
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.b.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == j.b.MotionHelper_onShow) {
                    this.j = obtainStyledAttributes.getBoolean(index, this.j);
                } else if (index == j.b.MotionHelper_onHide) {
                    this.k = obtainStyledAttributes.getBoolean(index, this.k);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean a() {
        return this.j;
    }

    public boolean b() {
        return this.k;
    }

    public float getProgress() {
        return this.l;
    }

    public void setProgress(float f) {
        this.l = f;
        int i = 0;
        if (this.c > 0) {
            this.a = d((ConstraintLayout) getParent());
            while (i < this.c) {
                a(this.a[i], f);
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof dq)) {
                a(childAt, f);
            }
            i++;
        }
    }
}
