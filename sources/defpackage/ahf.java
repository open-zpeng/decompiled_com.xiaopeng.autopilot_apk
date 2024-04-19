package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
/* renamed from: ahf  reason: default package */
/* loaded from: classes.dex */
class ahf {
    static final int[] a = new int[IRadioController.TEF663x_PCHANNEL];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) != 0 ? (i2 >>> 1) ^ (-306674912) : i2 >>> 1;
            }
            a[i] = i2;
        }
    }
}
