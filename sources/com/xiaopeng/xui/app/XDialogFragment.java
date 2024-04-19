package com.xiaopeng.xui.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.d;
import com.xiaopeng.xui.Xui;
import com.xiaopeng.xui.theme.XThemeManager;
import com.xiaopeng.xui.utils.XDialogUtils;
import com.xiaopeng.xui.widget.dialogview.XDialogView;
import com.xiaopeng.xui.widget.dialogview.XDialogViewInterface;
import defpackage.acu;
/* loaded from: classes.dex */
public abstract class XDialogFragment extends d {
    private static final String TAG = "XDialogFragment";
    protected XDialogView mXDialogView;

    protected abstract XDialogView onCreateDialogView(Context context);

    @Override // androidx.fragment.app.e
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        XDialogView onCreateDialogView = onCreateDialogView(getContext());
        if (onCreateDialogView != null) {
            this.mXDialogView = onCreateDialogView;
            this.mXDialogView.setOnDismissListener(new XDialogViewInterface.OnDismissListener() { // from class: com.xiaopeng.xui.app.-$$Lambda$XDialogFragment$x5B-nKf3XZWM7G-iAeQ2siL8JDY
                @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnDismissListener
                public final void onDismiss(XDialogView xDialogView) {
                    XDialogFragment.this.dismiss();
                }
            });
            if (isFullScreen()) {
                XDialogUtils.requestFullScreen(getDialog());
            }
            return this.mXDialogView.getContentView();
        }
        return null;
    }

    protected boolean isFullScreen() {
        return Xui.isDialogFullScreen();
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return acu.k.XAppTheme_XDialog;
    }

    @Override // androidx.fragment.app.e, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getDialog() == null || getDialog().getWindow() == null) {
            return;
        }
        XThemeManager.setWindowBackgroundResource(configuration, getDialog().getWindow(), acu.f.x_bg_dialog);
    }
}
