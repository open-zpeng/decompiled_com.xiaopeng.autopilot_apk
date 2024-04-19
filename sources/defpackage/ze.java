package defpackage;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AsrToTextNode.java */
/* renamed from: ze  reason: default package */
/* loaded from: classes.dex */
public class ze {
    private xp b;
    private zd c;
    private String a = "AsrToTextNode";
    private String d = null;
    private boolean e = false;
    private final xo f = new xo() { // from class: ze.1
        boolean a = false;
        String b = "";
    };

    /* compiled from: AsrToTextNode.java */
    /* renamed from: ze$a */
    /* loaded from: classes.dex */
    private static class a {
        static final ze a = new ze();
    }

    public void a() {
        String str = this.a;
        xx.b(str, "onConnect:" + this.c);
        if (this.c != null) {
            d();
        }
    }

    public void b() {
        String str = this.a;
        xx.b(str, "onDisconnect:" + this.e + ",mListener:" + this.c);
        if (this.e) {
            this.b = null;
            this.e = false;
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("messageCode", "501");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.c.a(jSONObject.toString());
            }
        }
    }

    public static ze c() {
        return a.a;
    }

    private xp d() {
        if (this.b == null) {
            this.b = wz.b().k();
            if (TextUtils.isEmpty(this.d) || this.d.equals("null")) {
                this.b.a("otp_audio_save_path", (String) null);
                this.b.a("otp_keep_audio_record", true);
                this.b.a("otp_enable_punct", true);
                this.b.a("otp_asr_buffer", false);
                this.b.a("otp_audio_format", 1);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.d);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject.opt(next);
                        if (opt instanceof Integer) {
                            this.b.a(next, ((Integer) opt).intValue());
                        } else if (opt instanceof Boolean) {
                            this.b.a(next, ((Boolean) opt).booleanValue());
                        } else if (opt instanceof String) {
                            this.b.a(next, (String) opt);
                        }
                    }
                } catch (JSONException e) {
                    e.fillInStackTrace();
                }
            }
        }
        return this.b;
    }
}
