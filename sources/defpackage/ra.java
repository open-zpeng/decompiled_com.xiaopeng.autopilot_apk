package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.autopilot.base.i;
import com.xiaopeng.xui.app.XDialog;
import com.xiaopeng.xui.app.XDialogInterface;
/* compiled from: NavStartPointInstructionDialog.java */
/* renamed from: ra  reason: default package */
/* loaded from: classes.dex */
public class ra {
    private XDialog a;

    public ra(Context context) {
        if (this.a == null) {
            this.a = new XDialog(context, h.j.XDialogNavActivateInstruction);
        }
        this.a.setCustomView(h.f.dialog_view_nav_instruction);
        this.a.setTitle(h.i.nav_start_point_instruction_title);
        this.a.getDialog().getWindow().setType(2047);
        this.a.setPositiveButton(h.i.nav_start_point_instruction_ok_btn);
        this.a.setCloseVisibility(true);
        this.a.setCanceledOnTouchOutside(false);
        this.a.setPositiveButtonListener(new XDialogInterface.OnClickListener() { // from class: ra.1
            @Override // com.xiaopeng.xui.app.XDialogInterface.OnClickListener
            public void onClick(XDialog xDialog, int i) {
                ra.this.a.dismiss();
                abg.a().b();
                re.a().i();
            }
        });
        this.a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ra.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                i.a(i.ah.class, true);
            }
        });
        this.a.setOnCloseListener(new XDialogInterface.OnCloseListener() { // from class: ra.3
            @Override // com.xiaopeng.xui.app.XDialogInterface.OnCloseListener
            public boolean onClose(XDialog xDialog) {
                i.a(i.ah.class, true);
                return false;
            }
        });
    }

    public void a() {
        XDialog xDialog = this.a;
        if (xDialog != null) {
            xDialog.show();
        }
    }

    public void b() {
        XDialog xDialog = this.a;
        if (xDialog != null) {
            xDialog.dismiss();
        }
    }

    public boolean c() {
        XDialog xDialog = this.a;
        if (xDialog != null) {
            return xDialog.isShowing();
        }
        return false;
    }
}
