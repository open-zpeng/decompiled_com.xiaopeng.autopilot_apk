package com.xiaopeng.speech.protocol.node.social;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SocialNode extends xa<a> {
    @SpeechAnnotation
    public void onSocialMotorcadeOpen(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    @SpeechAnnotation
    public void onSocialMotorcadeClose(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    @SpeechAnnotation
    public void onSocialGrabMic(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    @SpeechAnnotation
    public void onSocialGrabMicCancel(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }

    @SpeechAnnotation
    public void onSocialCreateTopic(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e();
            }
        }
    }

    @SpeechAnnotation
    public void onSocialReplyTopic(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f();
            }
        }
    }

    @SpeechAnnotation
    public void onSocialQuitChat(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g();
            }
        }
    }

    @SpeechAnnotation
    public void onSocialConfirm(String str, String str2) {
        Object[] a = this.b.a();
        String str3 = "";
        try {
            str3 = new JSONObject(str2).optString("intent");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str3);
            }
        }
    }

    @SpeechAnnotation
    public void onSocialCancel(String str, String str2) {
        Object[] a = this.b.a();
        String str3 = "";
        try {
            str3 = new JSONObject(str2).optString("intent");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(str3);
            }
        }
    }

    @SpeechAnnotation
    public void onVoiceButtonClick(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).h();
            }
        }
    }

    @SpeechAnnotation
    public void onBackButtonClick(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).i();
            }
        }
    }
}
