package com.xiaopeng.autopilot.base.utils;

import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.autopilot.base.i;
/* loaded from: classes.dex */
public class NavStartGuideDialogUtil {
    private static ra mNavStartPointInstructionDialog;

    public static void showDialog() {
        if (mNavStartPointInstructionDialog == null) {
            mNavStartPointInstructionDialog = new ra(a.g().getApplicationContext());
        }
        mNavStartPointInstructionDialog.a();
        rd.a().a(a.g().getString(h.i.nav_start_point_instruction_title));
        i.a(i.ah.class, false);
    }

    public static void dissmissDialog() {
        ra raVar = mNavStartPointInstructionDialog;
        if (raVar != null) {
            raVar.b();
        }
    }

    public static boolean isDialogShown() {
        ra raVar = mNavStartPointInstructionDialog;
        if (raVar != null) {
            return raVar.c();
        }
        return false;
    }
}
