package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.w;
import com.xiaopeng.xui.view.XViewDelegate;
import com.xiaopeng.xui.vui.VuiView;
import com.xiaopeng.xui.vui.floatinglayer.VuiFloatingLayerManager;
/* loaded from: classes.dex */
public class XSeekBar extends w implements abn, VuiView {
    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener;
    protected XViewDelegate mXViewDelegate;

    public abx onBuildVuiElement(String str, abl ablVar) {
        return null;
    }

    public XSeekBar(Context context) {
        super(context);
        init();
    }

    public XSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mXViewDelegate = XViewDelegate.create(this, attributeSet);
        init();
        initVui(this, attributeSet);
    }

    public XSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mXViewDelegate = XViewDelegate.create(this, attributeSet, i, 0);
        init();
        initVui(this, attributeSet);
    }

    private void init() {
        super.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.xiaopeng.xui.widget.XSeekBar.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (XSeekBar.this.mOnSeekBarChangeListener != null) {
                    XSeekBar.this.mOnSeekBarChangeListener.onProgressChanged(seekBar, i, z);
                }
                XSeekBar xSeekBar = XSeekBar.this;
                xSeekBar.updateVui(xSeekBar);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (XSeekBar.this.mOnSeekBarChangeListener != null) {
                    XSeekBar.this.mOnSeekBarChangeListener.onStartTrackingTouch(seekBar);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (XSeekBar.this.mOnSeekBarChangeListener != null) {
                    XSeekBar.this.mOnSeekBarChangeListener.onStopTrackingTouch(seekBar);
                }
            }
        });
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.mOnSeekBarChangeListener = onSeekBarChangeListener;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate != null) {
            xViewDelegate.onConfigurationChanged(configuration);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate != null) {
            xViewDelegate.onAttachedToWindow();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XViewDelegate xViewDelegate = this.mXViewDelegate;
        if (xViewDelegate != null) {
            xViewDelegate.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        setVuiVisibility(this, i);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        releaseVui();
    }

    @Override // defpackage.abn
    public boolean onVuiElementEvent(final View view, aby abyVar) {
        final Double d;
        logD("SeekBar onVuiElementEvent");
        if (view == null || (d = (Double) abyVar.a(abyVar)) == null) {
            return false;
        }
        post(new Runnable() { // from class: com.xiaopeng.xui.widget.-$$Lambda$XSeekBar$TblhEJ8EWsLpzlro7gSK773Zaig
            @Override // java.lang.Runnable
            public final void run() {
                XSeekBar.lambda$onVuiElementEvent$0(XSeekBar.this, d, view);
            }
        });
        return true;
    }

    public static /* synthetic */ void lambda$onVuiElementEvent$0(XSeekBar xSeekBar, Double d, View view) {
        if (d.doubleValue() >= 0.0d && d.doubleValue() <= 100.0d) {
            xSeekBar.setProgress(d.intValue());
        }
        VuiFloatingLayerManager.show(view, (int) ((((xSeekBar.getProgress() * 1.0f) / xSeekBar.getMax()) - 0.5d) * xSeekBar.getWidth()), 0);
    }
}
