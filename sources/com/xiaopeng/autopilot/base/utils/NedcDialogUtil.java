package com.xiaopeng.autopilot.base.utils;

import android.content.DialogInterface;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
/* loaded from: classes.dex */
public class NedcDialogUtil {
    private static XDialog mNedcDialog;

    public static boolean isNedcStatusIsZero() {
        int i;
        try {
            i = CarApiUtil.getNedcSwitchStatus();
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        LogUtils.i("NedcDialogUtil", "nedcStatus = " + i);
        return i == 0;
    }

    public static boolean showDialog() {
        if (isNedcStatusIsZero() || !d.h()) {
            return false;
        }
        XDialog xDialog = mNedcDialog;
        if (xDialog == null || !xDialog.getDialog().isShowing()) {
            mNedcDialog = new XDialog(a.g());
            mNedcDialog.getDialog().getWindow().setType(2047);
            mNedcDialog.setTitleVisibility(false);
            mNedcDialog.setMessage(h.i.nedc_close_tip);
            mNedcDialog.setCloseVisibility(true);
            mNedcDialog.setPositiveButton(a.g().getString(h.i.nedc_close_dialog_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.base.utils.NedcDialogUtil.1
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog2, int i) {
                    NedcDialogUtil.mNedcDialog.dismiss();
                }
            });
            mNedcDialog.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.autopilot.base.utils.NedcDialogUtil.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    XDialog unused = NedcDialogUtil.mNedcDialog = null;
                }
            });
            mNedcDialog.show();
            return true;
        }
        return true;
    }
}
