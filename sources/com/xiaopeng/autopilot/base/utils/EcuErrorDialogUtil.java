package com.xiaopeng.autopilot.base.utils;

import android.content.DialogInterface;
import android.util.Log;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
/* loaded from: classes.dex */
public class EcuErrorDialogUtil {
    private static final String TAG = "EcuErrorDialogUtil";
    private static XDialog xDialog;

    public static boolean showDialog() {
        if (d.f()) {
            return false;
        }
        XDialog xDialog2 = xDialog;
        if (xDialog2 == null || !xDialog2.getDialog().isShowing()) {
            xDialog = new XDialog(a.g());
            xDialog.getDialog().setCanceledOnTouchOutside(false);
            xDialog.getDialog().getWindow().setType(2047);
            xDialog.setTitleVisibility(true);
            xDialog.setCloseVisibility(false);
            xDialog.setTitle(h.i.scu_error_title);
            xDialog.setMessage(h.i.scu_error_tip);
            xDialog.setPositiveButton(a.g().getString(h.i.scu_error_dialog_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.base.utils.EcuErrorDialogUtil.1
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog3, int i) {
                    Log.i(EcuErrorDialogUtil.TAG, "xDialog click ok, close window");
                    if (((i.x) i.a(i.x.class)).d().booleanValue()) {
                        IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.action.ACTION_EXIT_SUPER_PARK");
                    } else {
                        IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.scu.ACTION_EXIT_AUTO_PARK");
                    }
                }
            });
            xDialog.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.autopilot.base.utils.EcuErrorDialogUtil.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    XDialog unused = EcuErrorDialogUtil.xDialog = null;
                }
            });
            xDialog.show();
            return true;
        }
        return true;
    }

    public static boolean hideDialog() {
        XDialog xDialog2;
        if (d.f() || (xDialog2 = xDialog) == null || !xDialog2.getDialog().isShowing()) {
            return false;
        }
        Log.i(TAG, " close window， xDialog dismiss");
        xDialog.dismiss();
        return true;
    }
}
