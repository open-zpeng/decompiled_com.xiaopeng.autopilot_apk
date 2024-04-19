package com.xiaopeng.autopilot.base.utils;

import android.content.DialogInterface;
import android.util.Log;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
import com.xiaopeng.xui.app.XToast;
/* loaded from: classes.dex */
public class SpeechActiveLearnDialogUtil {
    private static final String TAG = "SpeechActiveLearnDialogUtil";
    private static XDialog xDialog;

    public static boolean showDialog() {
        XDialog xDialog2 = xDialog;
        if (xDialog2 == null || !xDialog2.getDialog().isShowing()) {
            xDialog = new XDialog(a.g());
            xDialog.getDialog().setCanceledOnTouchOutside(false);
            xDialog.getDialog().getWindow().setType(2047);
            xDialog.setTitleVisibility(true);
            xDialog.setCloseVisibility(false);
            xDialog.setMessage(h.i.speech_learning_dialog_message);
            xDialog.setPositiveButton(a.g().getString(h.i.speech_learning_dialog_confirm), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.base.utils.SpeechActiveLearnDialogUtil.1
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog3, int i) {
                    Log.i(SpeechActiveLearnDialogUtil.TAG, "mLearnBtn.mTrainingConfirmDialog.startTraining.click");
                    int intValue = ((i.at) i.a(i.at.class)).d().intValue();
                    int intValue2 = ((i.at) i.a(i.at.class)).d().intValue();
                    Log.i(SpeechActiveLearnDialogUtil.TAG, "mLearnBtn.trainingConfirmTips = " + intValue2);
                    if (intValue2 == 15 || intValue == 4) {
                        IntentUtil.startAutopilotService(a.g(), "com.xiaopeng.speech.ACTION_SPEECH_ACTIVE_TRAINING_PARK");
                        xDialog3.dismiss();
                    } else if (intValue2 == 0) {
                        XToast.show(h.i.speech_learning_status_out_of_park);
                        rd.a().a(a.g().getString(h.i.speech_learning_status_out_of_park));
                    } else if (intValue2 == 1) {
                        XToast.show(h.i.speech_learning_status_up_down);
                        rd.a().a(a.g().getString(h.i.speech_learning_status_up_down));
                    } else if (intValue2 == 2) {
                        XToast.show(h.i.speech_learning_status_with_r);
                        rd.a().a(a.g().getString(h.i.speech_learning_status_with_r));
                    } else if (intValue == 25) {
                        XToast.show(h.i.speech_learning_status_error_click);
                        rd.a().a(a.g().getString(h.i.speech_learning_status_error_click));
                    } else {
                        XToast.show(h.i.speech_learning_status_other);
                        rd.a().a(a.g().getString(h.i.speech_learning_status_other));
                    }
                }
            });
            xDialog.setNegativeButton(a.g().getString(h.i.speech_learning_dialog_cancel), new XDialogInterface.OnClickListener() { // from class: com.xiaopeng.autopilot.base.utils.SpeechActiveLearnDialogUtil.2
                @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
                public void onClick(XDialog xDialog3, int i) {
                }
            });
            xDialog.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.autopilot.base.utils.SpeechActiveLearnDialogUtil.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    XDialog unused = SpeechActiveLearnDialogUtil.xDialog = null;
                }
            });
            xDialog.show();
            return true;
        }
        return true;
    }

    public static boolean hideDialog() {
        XDialog xDialog2 = xDialog;
        if (xDialog2 == null || !xDialog2.getDialog().isShowing()) {
            return false;
        }
        Log.i(TAG, " close window， xDialog dismiss");
        xDialog.dismiss();
        return true;
    }
}
