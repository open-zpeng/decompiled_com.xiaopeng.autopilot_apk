package com.xiaopeng.speech.protocol.node.controlcard;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
/* loaded from: classes.dex */
public class ControlCardNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showAcTempCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw a2 = yw.a(str2);
            for (Object obj : a) {
                ((a) obj).a(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showAcDriverTempCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw a2 = yw.a(str2);
            for (Object obj : a) {
                ((a) obj).b(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showAcPassengerTempCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw a2 = yw.a(str2);
            for (Object obj : a) {
                ((a) obj).c(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showAcWindCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw b = yw.b(str2);
            for (Object obj : a) {
                ((a) obj).d(b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showAtmosphereBrightnessCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw c = yw.c(str2);
            for (Object obj : a) {
                ((a) obj).e(c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showAtmosphereBrightnessColorCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw d = yw.d(str2);
            for (Object obj : a) {
                ((a) obj).f(d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showAcSeatHeatingDriverCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw e = yw.e(str2);
            for (Object obj : a) {
                ((a) obj).g(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showAcSeatHeatingPassengerCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw e = yw.e(str2);
            for (Object obj : a) {
                ((a) obj).h(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showAcSeatVentilateDriverCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw f = yw.f(str2);
            for (Object obj : a) {
                ((a) obj).i(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showSystemScreenBrightnessCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw g = yw.g(str2);
            for (Object obj : a) {
                ((a) obj).j(g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void showSystemIcmBrightnessCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            yw h = yw.h(str2);
            for (Object obj : a) {
                ((a) obj).k(h);
            }
        }
    }
}
