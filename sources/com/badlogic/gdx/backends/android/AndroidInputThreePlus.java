package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AndroidInputThreePlus extends AndroidInput implements View.OnGenericMotionListener {
    ArrayList<View.OnGenericMotionListener> genericMotionListeners;
    private final AndroidMouseHandler mouseHandler;

    public AndroidInputThreePlus(ij ijVar, Context context, Object obj, AndroidApplicationConfiguration androidApplicationConfiguration) {
        super(ijVar, context, obj, androidApplicationConfiguration);
        this.genericMotionListeners = new ArrayList<>();
        if (obj instanceof View) {
            ((View) obj).setOnGenericMotionListener(this);
        }
        this.mouseHandler = new AndroidMouseHandler();
    }

    @Override // android.view.View.OnGenericMotionListener
    public boolean onGenericMotion(View view, MotionEvent motionEvent) {
        if (this.mouseHandler.onGenericMotion(motionEvent, this)) {
            return true;
        }
        int size = this.genericMotionListeners.size();
        for (int i = 0; i < size; i++) {
            if (this.genericMotionListeners.get(i).onGenericMotion(view, motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void addGenericMotionListener(View.OnGenericMotionListener onGenericMotionListener) {
        this.genericMotionListeners.add(onGenericMotionListener);
    }
}
