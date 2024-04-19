package com.xiaopeng.speech.protocol.node.phone;

import android.text.TextUtils;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import defpackage.aaf;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PhoneNode extends xa<a> {
    private volatile String d;
    private volatile String e;
    private List<aag> f;
    private volatile int g;

    @SpeechAnnotation
    public void onQuerySyncBluetooth(String str, String str2) {
        xu a = wz.b().j().a("phone.get.bluetooth.status", (String) null);
        xu a2 = wz.b().j().a("phone.get.contact.sync.status", (String) null);
        abb abbVar = new abb();
        abbVar.a("联系人");
        abbVar.b("phone");
        abbVar.b("deviceId", this.d);
        if (a != null) {
            abbVar.b("phone_bluetooth", String.valueOf(a.a()));
        }
        if (a2 != null) {
            abbVar.b("phone_sync", String.valueOf(a2.b()));
        }
        wz.b().c().a(new xh("native://phone.query.bluetooth.sync").a(abbVar));
    }

    @SpeechAnnotation
    public void onQueryContacts(String str, String str2) {
        aag c = aag.c(str2);
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str, c);
            }
        }
    }

    @SpeechAnnotation
    public void onQueryDetailPhoneInfo(String str, String str2) {
        JSONArray optJSONArray;
        try {
            this.e = str2;
            JSONObject jSONObject = new JSONObject(str2);
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("content") && (optJSONArray = jSONObject.optJSONArray("content")) != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        aaf.a aVar = new aaf.a();
                        aVar.c(optJSONObject.optString("title"));
                        if (optJSONObject.has("subTitle") && !TextUtils.isEmpty(optJSONObject.optString("subTitle"))) {
                            aVar.a(optJSONObject.optString("subTitle"));
                        }
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("extra");
                        if (optJSONObject2 != null) {
                            aVar.b(optJSONObject2.optString(Constants.ID));
                        }
                        arrayList.add(aVar);
                    }
                }
            }
            Object[] a = this.b.a();
            if (a != null) {
                for (Object obj : a) {
                    ((a) obj).a(arrayList);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    @com.xiaopeng.speech.annotation.SpeechAnnotation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onOut(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            r7 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3b
            r0.<init>(r8)     // Catch: org.json.JSONException -> L3b
            java.lang.String r8 = "phone"
            java.lang.String r8 = r0.optString(r8)     // Catch: org.json.JSONException -> L3b
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch: org.json.JSONException -> L3b
            if (r1 != 0) goto L17
            aag r7 = defpackage.aag.c(r8)     // Catch: org.json.JSONException -> L3b
            goto L43
        L17:
            aag r8 = new aag     // Catch: org.json.JSONException -> L3b
            r8.<init>()     // Catch: org.json.JSONException -> L3b
            java.lang.String r7 = "name"
            java.lang.String r7 = r0.optString(r7)     // Catch: org.json.JSONException -> L39
            r8.d(r7)     // Catch: org.json.JSONException -> L39
            java.lang.String r7 = "number"
            java.lang.String r7 = r0.optString(r7)     // Catch: org.json.JSONException -> L39
            r8.e(r7)     // Catch: org.json.JSONException -> L39
            java.lang.String r7 = "id"
            java.lang.String r7 = r0.optString(r7)     // Catch: org.json.JSONException -> L39
            r8.b(r7)     // Catch: org.json.JSONException -> L39
            r7 = r8
            goto L43
        L39:
            r7 = move-exception
            goto L3f
        L3b:
            r8 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L3f:
            r7.printStackTrace()
            r7 = r8
        L43:
            if (r7 != 0) goto L4b
            java.lang.String r7 = "phoneBean == null"
            defpackage.xx.c(r6, r7)
            return
        L4b:
            xy<T> r8 = r6.b
            java.lang.Object[] r8 = r8.a()
            if (r8 == 0) goto L6d
            r0 = 0
        L54:
            int r1 = r8.length
            if (r0 >= r1) goto L6d
            r1 = r8[r0]
            com.xiaopeng.speech.protocol.node.phone.a r1 = (com.xiaopeng.speech.protocol.node.phone.a) r1
            java.lang.String r2 = r7.c()
            java.lang.String r3 = r7.d()
            java.lang.String r4 = r7.b()
            r1.a(r2, r3, r4)
            int r0 = r0 + 1
            goto L54
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.protocol.node.phone.PhoneNode.onOut(java.lang.String, java.lang.String):void");
    }

    @SpeechAnnotation
    public void onPhoneSelectOut(String str, String str2) {
        aag aagVar;
        int optInt;
        try {
            optInt = new JSONObject(str2).optInt("select_num");
        } catch (JSONException e) {
            e.printStackTrace();
            aagVar = null;
        }
        if (this.f != null && this.f.size() > 0) {
            if (optInt > 0 && optInt <= this.f.size()) {
                aagVar = this.f.get(optInt - 1);
                if (aagVar == null) {
                    xx.c(this, "phoneBean == null");
                    return;
                }
                Object[] a = this.b.a();
                if (a != null) {
                    for (Object obj : a) {
                        ((a) obj).a(aagVar.c(), aagVar.d(), aagVar.b());
                        wz.b().d().c("好的，正在呼叫 " + aagVar.c());
                    }
                    return;
                }
                return;
            }
            wz.b().d().c("您的选择已经超出当前列表范围了哦");
            xx.c(this, "select_num is  == " + optInt);
            return;
        }
        xx.c(this, "phoneBeanList == null");
    }

    @SpeechAnnotation
    public void onInAccept(String str, String str2) {
        wz.b().i().b(true);
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e();
            }
        }
    }

    @SpeechAnnotation
    public void onInReject(String str, String str2) {
        wz.b().i().b(true);
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f();
            }
        }
    }

    @SpeechAnnotation
    public void onRedialSupport(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    @SpeechAnnotation
    public void onRedial(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    @SpeechAnnotation
    public void onCallbackSupport(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    @SpeechAnnotation
    public void onCallback(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }

    @SpeechAnnotation
    public void onOutCustomerservice(String str, String str2) {
        String str3 = "";
        try {
            str3 = new JSONObject(str2).optString("number");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str3);
            }
        }
    }

    @SpeechAnnotation
    public void onOutHelp(String str, String str2) {
        String str3 = "";
        try {
            str3 = new JSONObject(str2).optString("number");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(str3);
            }
        }
    }

    @SpeechAnnotation
    public void onQueryBluetooth(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g();
            }
        }
    }

    @SpeechAnnotation
    public void onSyncContactResult(String str, String str2) {
        Object[] a = this.b.a();
        this.g = Integer.valueOf(str2).intValue();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(this.g);
            }
        }
    }
}
