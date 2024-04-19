package com.xiaopeng.speech.protocol.node.media;

import android.text.TextUtils;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MediaNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlay(String str, String str2) {
        try {
            Object[] a = this.b.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String optString = new JSONObject(str2).optString("value");
            if (a != null) {
                for (Object obj : a) {
                    ((a) obj).a(optString);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayLoopSingle(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b("single");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayLoopAll(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b("order");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayLoopRandom(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b("random");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPause(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onResume(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPrev(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onNext(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onStop(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onControlCollect(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCancelCollect(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g();
            }
        }
    }

    @SpeechAnnotation
    public void onForward(String str, String str2) {
        try {
            Object[] a = this.b.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            int optInt = new JSONObject(str2).optInt("value");
            if (a != null) {
                for (Object obj : a) {
                    ((a) obj).a(optInt);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SpeechAnnotation
    public void onBackward(String str, String str2) {
        try {
            Object[] a = this.b.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            int optInt = new JSONObject(str2).optInt("value");
            if (a != null) {
                for (Object obj : a) {
                    ((a) obj).b(optInt);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SpeechAnnotation
    public void onSettime(String str, String str2) {
        try {
            Object[] a = this.b.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            int optInt = new JSONObject(str2).optInt("value");
            if (a != null) {
                for (Object obj : a) {
                    ((a) obj).c(optInt);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
