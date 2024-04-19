package com.xiaopeng.speech.protocol.node.camera;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CameraNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onOverallOn(String str, String str2) {
        Object[] a = this.b.a();
        boolean z = true;
        try {
            z = new JSONObject(str2).optBoolean("isTTS", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onRearTake(String str, String str2) {
        Object[] a = this.b.a();
        boolean z = true;
        try {
            z = new JSONObject(str2).optBoolean("isTTS", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onRearRecord(String str, String str2) {
        Object[] a = this.b.a();
        boolean z = true;
        try {
            z = new JSONObject(str2).optBoolean("isTTS", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onFrontTake(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onFrontRecord(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onLeftTake(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onLeftRecord(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onRightTake(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onRightRecord(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onLeftOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onRightOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onRearOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onRearOnNew(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onFrontOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onRearOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTopOff(String str, String str2) {
        Object[] a = this.b.a();
        boolean z = true;
        try {
            z = new JSONObject(str2).optBoolean("isTTS", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTopOn(String str, String str2) {
        Object[] a = this.b.a();
        boolean z = true;
        try {
            z = new JSONObject(str2).optBoolean("isTTS", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTopTake(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTopRotateLeft(String str, String str2) {
        yx a = yx.a(str2);
        Object[] a2 = this.b.a();
        boolean z = true;
        try {
            z = new JSONObject(str2).optBoolean("isTTS", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTopRotateRight(String str, String str2) {
        yx a = yx.a(str2);
        Object[] a2 = this.b.a();
        boolean z = true;
        try {
            z = new JSONObject(str2).optBoolean("isTTS", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).b(a, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTopRotateFront(String str, String str2) {
        Object[] a = this.b.a();
        boolean z = true;
        try {
            z = new JSONObject(str2).optBoolean("isTTS", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTopRotateRear(String str, String str2) {
        Object[] a = this.b.a();
        boolean z = true;
        try {
            z = new JSONObject(str2).optBoolean("isTTS", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTransparentChassisCMD(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCameraThreeDOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCameraThreeDOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCameraTransparentChassisOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCameraTransparentChassisOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCameraPhotoalbumOpen(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).r();
            }
        }
    }
}
