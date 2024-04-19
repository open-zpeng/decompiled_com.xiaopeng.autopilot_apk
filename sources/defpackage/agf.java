package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.d;
/* compiled from: ErrorDialogFragments.java */
/* renamed from: agf  reason: default package */
/* loaded from: classes.dex */
public class agf {
    public static int a;
    public static Class<?> b;

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int i = a;
        if (i != 0) {
            builder.setIcon(i);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void a(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        Class<?> cls = b;
        if (cls != null) {
            try {
                agg.a.a.a().d(cls.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Event cannot be constructed", e);
            }
        }
        if (!bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) || activity == null) {
            return;
        }
        activity.finish();
    }

    /* compiled from: ErrorDialogFragments.java */
    /* renamed from: agf$a */
    /* loaded from: classes.dex */
    public static class a extends d implements DialogInterface.OnClickListener {
        @Override // androidx.fragment.app.d
        public Dialog onCreateDialog(Bundle bundle) {
            return agf.a(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            agf.a(dialogInterface, i, getActivity(), getArguments());
        }
    }
}
