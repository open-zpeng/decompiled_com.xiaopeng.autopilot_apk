package com.xiaopeng.speech.protocol.node.context;

import android.text.TextUtils;
import com.xiaopeng.lib.utils.config.CommonConfig;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ContextNode extends xa<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onInputText(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onOutputText(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onTipsText(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetCustom(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetText(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetList(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetListFocus(String str, String str2) {
        Object[] a;
        try {
            yy a2 = yy.a(new JSONObject(str2));
            if (a2 == null || (a = this.b.a()) == null) {
                return;
            }
            for (Object obj : a) {
                ((a) obj).a(a2.a, a2.b);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetMedia(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).h(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetRecommend(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).i(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetSearch(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).j(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onExpression(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).k(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onSayWelcome(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).l(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetScroll(String str, String str2) {
        Object[] a;
        try {
            yy a2 = yy.a(new JSONObject(str2));
            if (a2 == null || (a = this.b.a()) == null) {
                return;
            }
            for (Object obj : a) {
                xx.b("onWidgetScroll", "onWidgetScroll data:" + str2);
                ((a) obj).b(a2.a, a2.b);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetListSelect(String str, String str2) {
        Object[] a;
        try {
            yy a2 = yy.a(new JSONObject(str2));
            if (a2 == null || (a = this.b.a()) == null) {
                return;
            }
            for (int i = 0; i < a.length; i++) {
                xx.b("onWidgetListSelect", "onWidgetListSelect data:" + str2);
                if (TextUtils.isEmpty(a2.c)) {
                    ((a) a[i]).c(a2.a, a2.b);
                } else {
                    ((a) a[i]).a(a2.a, a2.b, a2.c);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetCancel(String str, String str2) {
        try {
            Object[] a = this.b.a();
            if (a != null) {
                for (Object obj : a) {
                    String str3 = null;
                    String str4 = "force";
                    if (str2 != null) {
                        JSONObject jSONObject = new JSONObject(str2);
                        String optString = jSONObject.optString("widgetId");
                        str4 = jSONObject.optString("cancel");
                        str3 = optString;
                    }
                    ((a) obj).a(str3, str4);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPageNext(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPagePrev(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPageTopping(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onPageSetLow(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetListCancelFocus(String str, String str2) {
        Object[] a;
        try {
            yy a2 = yy.a(new JSONObject(str2));
            if (a2 == null || (a = this.b.a()) == null) {
                return;
            }
            for (Object obj : a) {
                ((a) obj).d(a2.a, a2.b);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScript(String str, String str2) {
        String str3;
        try {
            Object[] a = this.b.a();
            String str4 = "";
            if (str2 != null) {
                JSONObject jSONObject = new JSONObject(str2);
                str3 = jSONObject.optString("domain");
                str4 = jSONObject.optString("scriptId");
            } else {
                str3 = "";
            }
            if (a == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return;
            }
            for (Object obj : a) {
                ((a) obj).b(str3, str4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onScriptStatus(String str, String str2) {
        String str3;
        try {
            Object[] a = this.b.a();
            String str4 = "";
            if (str2 != null) {
                JSONObject jSONObject = new JSONObject(str2);
                str3 = jSONObject.optString(CommonConfig.KEY_VALUE_STATUS);
                str4 = jSONObject.optString("scriptId");
            } else {
                str3 = "";
            }
            if (a == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return;
            }
            for (Object obj : a) {
                ((a) obj).c(str4, str3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onExitRecommendCard(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetListFold(String str, String str2) {
        try {
            Object[] a = this.b.a();
            if (a == null || str2 == null) {
                return;
            }
            yy a2 = yy.a(new JSONObject(str2));
            for (Object obj : a) {
                ((a) obj).d(a2.a, a2.c);
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetListExpend(String str, String str2) {
        try {
            Object[] a = this.b.a();
            if (a == null || str2 == null) {
                return;
            }
            yy a2 = yy.a(new JSONObject(str2));
            for (Object obj : a) {
                ((a) obj).e(a2.a, a2.c);
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onWidgetListStopCountdown(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f();
            }
        }
    }
}
