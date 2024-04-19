package defpackage;

import com.xiaopeng.libconfig.settings.SettingsUtil;
/* compiled from: VuiFeedbackType.java */
/* renamed from: abs  reason: default package */
/* loaded from: classes.dex */
public enum abs {
    SOUND(SettingsUtil.PAGE_SOUND),
    TTS("Tts");
    
    private String a;

    abs(String str) {
        this.a = str;
    }

    public String getType() {
        return this.a;
    }
}
