package com.xiaopeng.speech.protocol.node.music;

import com.xiaopeng.speech.annotation.SpeechAnnotation;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MusicNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlay(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayLoopSingle(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a("single");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayLoopAll(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a("order");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayLoopRandom(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a("random");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSearch(String str, String str2) {
        zq b = zq.b(str2);
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str, b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPause(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onResume(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPrev(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onNext(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onStop(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayBlueTooth(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSupportPlayModeChange(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onAudioBookPlay(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onMusicListPlay(String str, String str2) {
        Object[] a = this.b.a();
        if (yu.a(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("from") && "dui_xp".equals(jSONObject.optString("from"))) {
                    xx.b("MusicNode", "is from dui_xp");
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        for (Object obj : a) {
            ((a) obj).d(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTwelveNovelPlay(String str, String str2) {
        String str3;
        try {
            str3 = new JSONObject(str2).optString("param");
        } catch (JSONException e) {
            e.printStackTrace();
            str3 = null;
        }
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e(str3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onControlCollect(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onAudioBookSubscribe(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSoundEffectStereo(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSoundEffectLive(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSoundEffectVocal(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSoundEffectSuperbass(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onDelCollect(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayCollect(String str, String str2) {
        Object[] a = this.b.a();
        zp a2 = zp.a(str2);
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlaySimilar(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onCancelPlaySimilar(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPlayHistoryList(String str, String str2) {
        Object[] a = this.b.a();
        zp a2 = zp.a(str2);
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(a2);
            }
        }
    }

    @SpeechAnnotation
    public void onMusicForward(String str, String str2) {
        try {
            Object[] a = this.b.a();
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
    public void onMusicBackward(String str, String str2) {
        try {
            Object[] a = this.b.a();
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
    public void onMusicSettime(String str, String str2) {
        try {
            Object[] a = this.b.a();
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

    @SpeechAnnotation
    public void onMusicSpeedUp(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).q();
            }
        }
    }

    @SpeechAnnotation
    public void onMusicSpeedDown(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).r();
            }
        }
    }

    @SpeechAnnotation
    public void onMusicSpeedSet(String str, String str2) {
        try {
            Object[] a = this.b.a();
            float floatValue = BigDecimal.valueOf(new JSONObject(str2).optDouble("value")).floatValue();
            if (a != null) {
                for (Object obj : a) {
                    ((a) obj).a(floatValue);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SpeechAnnotation
    public void onMusicNewsPlay(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).s();
            }
        }
    }

    @SpeechAnnotation
    public void onMusicDailyrecPlay(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).t();
            }
        }
    }

    @SpeechAnnotation
    public void onPlayUsb(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).u();
            }
        }
    }
}
