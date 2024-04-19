package com.xiaopeng.speech.protocol.node.system;

import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SystemNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenBrightnessUp(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenBrightnessMax(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenBrightnessDown(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenBrightnessMin(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onThemeModeAuto(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onThemeModeDay(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onThemeModeNight(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenModeClean(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWifiOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWifiOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onBluetoothOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onBluetoothOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeUp(String str, String str2) {
        za a = za.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeSet(String str, String str2) {
        za a = za.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).c(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeDown(String str, String str2) {
        za a = za.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).b(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeMax(String str, String str2) {
        Object[] a = this.b.a();
        String str3 = "3";
        try {
            str3 = new JSONObject(str2).optString("stream_type", "3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(Integer.valueOf(aal.a(str3) ? str3 : "3").intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeMin(String str, String str2) {
        Object[] a = this.b.a();
        String str3 = "3";
        try {
            str3 = new JSONObject(str2).optString("stream_type", "3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(Integer.valueOf(Integer.valueOf(aal.a(str3) ? str3 : "3").intValue()).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeMute(String str, String str2) {
        Object[] a = this.b.a();
        String str3 = "3";
        try {
            str3 = new JSONObject(str2).optString("stream_type", "3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c(Integer.valueOf(aal.a(str3) ? str3 : "3").intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeUnmute(String str, String str2) {
        Object[] a = this.b.a();
        String str3 = "3";
        try {
            str3 = new JSONObject(str2).optString("stream_type", "3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d(Integer.valueOf(aal.a(str3) ? str3 : "3").intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeResume(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onBrightnessUpPercent(String str, String str2) {
        yv a = yv.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenBrightnessSetPercent(String str, String str2) {
        yv a = yv.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).b(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onBrightnessSet(String str, String str2) {
        yv a = yv.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).h(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onIcmBrightnessSet(String str, String str2) {
        yv a = yv.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).g(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onIcmBrightnessUp(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onIcmBrightnessMax(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onIcmBrightnessDown(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onIcmBrightnessMin(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onOpenSettingPage(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onOpenWifiPage(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onBrightnessDownPercent(String str, String str2) {
        yv a = yv.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).c(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onIcmBrightnessUpPercent(String str, String str2) {
        yv a = yv.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).d(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onIcmBrightnessSetPercent(String str, String str2) {
        yv a = yv.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).e(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onIcmBrightnessDownPercent(String str, String str2) {
        yv a = yv.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).f(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).u();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenBrightnessStop(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenBrightnessAutoOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).w();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScreenBrightnessAutoOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).x();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeNotificationMax(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeNotificationMin(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeNotificationMedium(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).z();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeNotificationUp(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).B();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onVolumeNotificationDown(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSoundEffectField(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        try {
            i = new JSONObject(str2).optInt("direction");
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSoundEffectMode(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        try {
            i = new JSONObject(str2).optInt("mode");
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).i(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSoundEffectScene(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        try {
            i = new JSONObject(str2).optInt("scene");
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSoundEffectStyle(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        try {
            i = new JSONObject(str2).optInt(ThemeManager.AttributeSet.STYLE);
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).h(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onHeadsetMode(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        try {
            i = new JSONObject(str2).optInt("mode");
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e(i);
            }
        }
    }
}
