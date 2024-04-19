package com.xiaopeng.autopilot.parking.view;

import android.content.DialogInterface;
import android.util.Log;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
/* compiled from: SilentLearnDialogUtil.java */
/* loaded from: classes.dex */
public class o {
    private static XDialog a;

    public static boolean a(final long j) {
        XDialog xDialog = a;
        if (xDialog == null || !xDialog.getDialog().isShowing()) {
            a = new XDialog(com.xiaopeng.autopilot.base.a.g());
            a.getDialog().setCanceledOnTouchOutside(false);
            a.getDialog().getWindow().setType(2047);
            a.setTitleVisibility(true);
            a.setCloseVisibility(false);
            a.setTitle(h.i.silent_learn_dialog_title);
            a.setMessage(h.i.silent_learn_dialog_content);
            a.setPositiveButton(com.xiaopeng.autopilot.base.a.g().getString(h.i.scu_error_dialog_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.o.1
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog2, int i) {
                    abg.a().a(1, j);
                }
            });
            a.setNegativeButton(com.xiaopeng.autopilot.base.a.g().getString(h.i.ignore_park), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.parking.view.o.2
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog2, int i) {
                    abg.a().a(2, j);
                }
            });
            a.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.autopilot.parking.view.o.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    XDialog unused = o.a = null;
                }
            });
            a.show();
            return true;
        }
        return true;
    }

    public static boolean b(long j) {
        XDialog xDialog = a;
        if (xDialog == null || !xDialog.getDialog().isShowing()) {
            return false;
        }
        Log.i("SilentLearnDialogUtil", " close window， xDialog dismiss");
        a.dismiss();
        return true;
    }
}
