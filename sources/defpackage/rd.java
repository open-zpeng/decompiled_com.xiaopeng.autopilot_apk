package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.smart.SmartManager;
/* compiled from: ParkingSpeechHelper.java */
/* renamed from: rd  reason: default package */
/* loaded from: classes.dex */
public class rd {
    private static rd i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private SmartManager t;
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private UtteranceProgressListener v = new UtteranceProgressListener() { // from class: rd.1
        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(String str) {
            Log.i("ParkingSpeechHelper", "onStart.s = " + str);
            if (str.equals(rd.this.j)) {
                rd.this.a = true;
            } else if (str.equals(rd.this.k)) {
                rd.this.b = true;
            } else if (str.equals(rd.this.r)) {
                rd.this.c = true;
            } else if (str.equals(rd.this.l)) {
                rd.this.d = true;
            } else if (str.equals(rd.this.m)) {
                rd.this.e = true;
            } else if (str.equals(rd.this.o)) {
                rd.this.f = true;
            } else if (str.equals(rd.this.p)) {
                rd.this.g = true;
            } else if (str.equals(rd.this.q)) {
                rd.this.h = true;
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(String str) {
            Log.i("ParkingSpeechHelper", "onDone.s = " + str);
            if (str.equals(rd.this.j)) {
                rd.this.a = false;
            } else if (str.equals(rd.this.k)) {
                rd.this.b = false;
            } else if (str.equals(rd.this.r)) {
                rd.this.c = false;
            } else if (str.equals(rd.this.l)) {
                rd.this.d = false;
            } else if (str.equals(rd.this.m)) {
                rd.this.e = false;
            } else if (str.equals(rd.this.o)) {
                rd.this.f = false;
            } else if (str.equals(rd.this.p)) {
                rd.this.g = false;
            } else if (str.equals(rd.this.q)) {
                rd.this.h = false;
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(String str) {
            Log.i("ParkingSpeechHelper", "onError.s = " + str);
            if (str.equals(rd.this.j)) {
                rd.this.a = false;
            } else if (str.equals(rd.this.k)) {
                rd.this.b = false;
            } else if (str.equals(rd.this.r)) {
                rd.this.c = false;
            } else if (str.equals(rd.this.l)) {
                rd.this.d = false;
            } else if (str.equals(rd.this.m)) {
                rd.this.e = false;
            } else if (str.equals(rd.this.o)) {
                rd.this.f = false;
            } else if (str.equals(rd.this.p)) {
                rd.this.g = false;
            } else if (str.equals(rd.this.q)) {
                rd.this.h = false;
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStop(String str, boolean z) {
            Log.i("ParkingSpeechHelper", "onStop.s = " + str);
            if (str.equals(rd.this.j)) {
                rd.this.a = false;
            } else if (str.equals(rd.this.k)) {
                rd.this.b = false;
            } else if (str.equals(rd.this.r)) {
                rd.this.c = false;
            } else if (str.equals(rd.this.l)) {
                rd.this.d = false;
            } else if (str.equals(rd.this.m)) {
                rd.this.e = false;
            } else if (str.equals(rd.this.o)) {
                rd.this.f = false;
            } else if (str.equals(rd.this.p)) {
                rd.this.g = false;
            } else if (str.equals(rd.this.q)) {
                rd.this.h = false;
            }
        }
    };
    private TextToSpeech s = new TextToSpeech(com.xiaopeng.autopilot.base.a.g(), new TextToSpeech.OnInitListener() { // from class: rd.2
        @Override // android.speech.tts.TextToSpeech.OnInitListener
        public void onInit(int i2) {
            Log.i("ParkingSpeechHelper", "TextToSpeech.onInit.status = " + i2);
        }
    });
    private XUIManager u = XUIManager.createXUIManager(com.xiaopeng.autopilot.base.a.g(), new ServiceConnection() { // from class: rd.3
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("ParkingSpeechHelper", "onServiceConnected!");
            try {
                rd.this.t = (SmartManager) rd.this.u.getXUIServiceManager("smart");
                rd.this.t.registerCommonListener(new a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("ParkingSpeechHelper", "onServiceDisconnected");
        }
    });

    /* compiled from: ParkingSpeechHelper.java */
    /* renamed from: rd$a */
    /* loaded from: classes.dex */
    private class a implements SmartManager.SmartCommonEventListener {
        public void onCommonEvent(int i, int i2, int i3) {
        }

        private a() {
        }

        public void onSpeechTtsEvent(int i, String str) {
            Log.d("ParkingSpeechHelper", "onSpeechTtsEvent type1=" + i + ", s=" + str);
            switch (i) {
                case 0:
                    if (str.equals(rd.this.j)) {
                        rd.this.a = true;
                        return;
                    } else if (str.equals(rd.this.k)) {
                        rd.this.b = true;
                        return;
                    } else if (str.equals(rd.this.r)) {
                        rd.this.c = true;
                        return;
                    } else if (str.equals(rd.this.l)) {
                        rd.this.d = true;
                        return;
                    } else if (str.equals(rd.this.m)) {
                        rd.this.e = true;
                        return;
                    } else if (str.equals(rd.this.o)) {
                        rd.this.f = true;
                        return;
                    } else if (str.equals(rd.this.p)) {
                        rd.this.g = true;
                        return;
                    } else if (str.equals(rd.this.q)) {
                        rd.this.h = true;
                        return;
                    } else {
                        return;
                    }
                case 1:
                    if (str.equals(rd.this.j)) {
                        rd.this.a = false;
                        return;
                    } else if (str.equals(rd.this.k)) {
                        rd.this.b = false;
                        return;
                    } else if (str.equals(rd.this.r)) {
                        rd.this.c = false;
                        return;
                    } else if (str.equals(rd.this.l)) {
                        rd.this.d = false;
                        return;
                    } else if (str.equals(rd.this.m)) {
                        rd.this.e = false;
                        return;
                    } else if (str.equals(rd.this.o)) {
                        rd.this.f = false;
                        return;
                    } else if (str.equals(rd.this.p)) {
                        rd.this.g = false;
                        return;
                    } else if (str.equals(rd.this.q)) {
                        rd.this.h = false;
                        return;
                    } else {
                        return;
                    }
                case 2:
                    if (str.equals(rd.this.j)) {
                        rd.this.a = false;
                        return;
                    } else if (str.equals(rd.this.k)) {
                        rd.this.b = false;
                        return;
                    } else if (str.equals(rd.this.r)) {
                        rd.this.c = false;
                        return;
                    } else if (str.equals(rd.this.l)) {
                        rd.this.d = false;
                        return;
                    } else if (str.equals(rd.this.m)) {
                        rd.this.e = false;
                        return;
                    } else if (str.equals(rd.this.o)) {
                        rd.this.f = false;
                        return;
                    } else if (str.equals(rd.this.p)) {
                        rd.this.g = false;
                        return;
                    } else if (str.equals(rd.this.q)) {
                        rd.this.h = false;
                        return;
                    } else {
                        return;
                    }
                case 3:
                    if (str.equals(rd.this.j)) {
                        rd.this.a = false;
                        return;
                    } else if (str.equals(rd.this.k)) {
                        rd.this.b = false;
                        return;
                    } else if (str.equals(rd.this.r)) {
                        rd.this.c = false;
                        return;
                    } else if (str.equals(rd.this.l)) {
                        rd.this.d = false;
                        return;
                    } else if (str.equals(rd.this.m)) {
                        rd.this.e = false;
                        return;
                    } else if (str.equals(rd.this.o)) {
                        rd.this.f = false;
                        return;
                    } else if (str.equals(rd.this.p)) {
                        rd.this.g = false;
                        return;
                    } else if (str.equals(rd.this.q)) {
                        rd.this.h = false;
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private rd() {
        this.u.connect();
    }

    public static rd a() {
        if (i == null) {
            i = new rd();
        }
        return i;
    }

    public boolean b() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public String a(String str) {
        return a(str, false);
    }

    public String a(String str, boolean z) {
        Log.i("ParkingSpeechHelper", "speak.tts = " + str + "," + this.a + "," + this.c);
        String str2 = this.k;
        if (str2 != null && str2.equals(str) && z) {
            Log.i("ParkingSpeechHelper", "speek.tts = " + str + " skip");
            return this.k;
        }
        this.k = str;
        if (this.a && !this.c) {
            try {
                this.t.stopAllSpeech();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            wz.b().d().a(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.b = true;
        try {
            this.k = this.t.speakByInstant(str, false);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return this.k;
    }

    public String b(String str) {
        Log.i("ParkingSpeechHelper", "speakByTextToSpeech.tts = " + str + "," + this.a + "," + this.c);
        this.k = str;
        if (this.a && !this.c) {
            this.s.stop();
        }
        try {
            wz.b().d().a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = true;
        Bundle bundle = new Bundle();
        bundle.putInt("priority", 3);
        return String.valueOf(this.s.speak(str, 1, bundle, this.k));
    }

    public String c(String str) {
        Log.i("ParkingSpeechHelper", "speakTraining.tts = " + str + "," + this.d + "," + this.f);
        if (this.f || this.d) {
            try {
                this.t.stopAllSpeech();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            wz.b().d().a(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.l = str;
        this.d = true;
        try {
            this.l = this.t.speakByInstant(str, false);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return this.l;
    }

    public String d(String str) {
        Log.i("ParkingSpeechHelper", "speakTrainingFlush.tts = " + str + "," + this.n + "," + this.m + "," + this.e);
        if (this.e && str.equals(this.n)) {
            return str;
        }
        try {
            wz.b().d().a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.m = str;
        this.n = str;
        this.e = true;
        try {
            this.m = this.t.speakByInstant(str, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.m;
    }

    public String e(String str) {
        Log.i("ParkingSpeechHelper", "speakTrainingAPReady.tts = " + str + "," + this.f);
        try {
            wz.b().d().a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.o = str;
        this.f = true;
        try {
            this.o = this.t.speakByInstant(str, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.o;
    }

    public String f(String str) {
        Log.i("ParkingSpeechHelper", "speakTrainingFinish.tts = " + str + "," + this.g);
        try {
            wz.b().d().a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.p = str;
        this.g = true;
        try {
            this.p = this.t.speakByInstant(str, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.p;
    }

    public String g(String str) {
        Log.i("ParkingSpeechHelper", "speak.tts = " + str);
        this.q = str;
        try {
            wz.b().d().a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h = true;
        try {
            this.q = this.t.speakByInstant(str, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.q;
    }

    public String h(String str) {
        Log.i("ParkingSpeechHelper", "speakFlush.tts = " + str + "," + this.c);
        this.r = str;
        this.c = true;
        try {
            wz.b().d().a(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.r = this.t.speakByInstant(str, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.r;
    }

    public void i(String str) {
        Log.i("ParkingSpeechHelper", "speechSlotOccupy.tts = " + str + "," + this.a);
        this.j = str;
        if (this.a) {
            return;
        }
        if (this.b) {
            try {
                this.t.stopAllSpeech();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            wz.b().d().a(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.a = true;
        try {
            this.j = this.t.speakByInstant(str, true);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void e() {
        Log.i("ParkingSpeechHelper", "stop.mIsSpeakingTrainingFinishInvalidate = " + this.g + "," + this.f);
        if (this.g || this.f) {
            try {
                this.t.stopAllSpeech();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
