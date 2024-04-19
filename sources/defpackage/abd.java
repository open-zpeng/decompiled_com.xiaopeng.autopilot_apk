package defpackage;

import com.xiaopeng.lib.utils.config.CommonConfig;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
/* compiled from: SupportWidget.java */
/* renamed from: abd  reason: default package */
/* loaded from: classes.dex */
public class abd extends abc {
    public abd() {
        super("custom");
    }

    public abd a(boolean z) {
        return (abd) super.c(CommonConfig.KEY_VALUE_STATUS, z ? BuildInfoUtils.BID_WAN : "0");
    }

    public abd a(String str) {
        return (abd) super.c("tts", str);
    }
}
