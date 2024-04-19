package defpackage;

import android.util.Log;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.parking.view.n;
import com.xiaopeng.xui.app.XDialogPure;
import com.xiaopeng.xui.widget.dialogview.XDialogView;
import com.xiaopeng.xui.widget.dialogview.XDialogViewInterface;
/* compiled from: ShareMapDialogUtil.java */
/* renamed from: ua  reason: default package */
/* loaded from: classes.dex */
public class ua {
    private static XDialogPure a;

    public static boolean a(n.a aVar) {
        XDialogPure xDialogPure = a;
        if (xDialogPure == null || !xDialogPure.getDialog().isShowing()) {
            n nVar = new n(a.g().getApplicationContext(), false, aVar);
            nVar.setOnCloseListener(new XDialogViewInterface.OnCloseListener() { // from class: ua.1
                @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnCloseListener
                public boolean onClose(XDialogView xDialogView) {
                    ua.a.dismiss();
                    return false;
                }
            });
            a = new XDialogPure(a.g());
            a.getDialog().setCanceledOnTouchOutside(false);
            a.getDialog().getWindow().setType(2047);
            a.setContentView(nVar);
            a.show();
            return true;
        }
        return true;
    }

    public static boolean b(n.a aVar) {
        XDialogPure xDialogPure = a;
        if (xDialogPure == null || !xDialogPure.getDialog().isShowing()) {
            n nVar = new n(a.g().getApplicationContext(), true, aVar);
            nVar.setOnCloseListener(new XDialogViewInterface.OnCloseListener() { // from class: ua.2
                @Override // com.xiaopeng.xui.widget.dialogview.XDialogViewInterface.OnCloseListener
                public boolean onClose(XDialogView xDialogView) {
                    ua.a.dismiss();
                    return false;
                }
            });
            a = new XDialogPure(a.g());
            a.getDialog().setCanceledOnTouchOutside(false);
            a.getDialog().getWindow().setType(2047);
            a.setContentView(nVar);
            a.show();
            return true;
        }
        return true;
    }

    public static boolean a(long j) {
        XDialogPure xDialogPure = a;
        if (xDialogPure == null || !xDialogPure.getDialog().isShowing()) {
            return false;
        }
        Log.i("SilentLearnDialogUtil", " close window， xDialog dismiss");
        a.dismiss();
        return true;
    }
}
