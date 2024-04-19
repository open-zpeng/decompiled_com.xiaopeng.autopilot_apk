package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: WakeupReason.java */
/* renamed from: zn  reason: default package */
/* loaded from: classes.dex */
public class zn {
    public int a;
    public int b;
    public String c;

    public zn(int i, String str, int i2) {
        this.b = -1;
        this.a = i;
        this.c = str;
        this.b = i2;
    }

    public static zn a(String str) {
        char c;
        String str2 = "";
        int i = -1;
        int i2 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("reason");
            switch (optString.hashCode()) {
                case -1990314378:
                    if (optString.equals("api.startDialog")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1958887862:
                    if (optString.equals("wakeup.major")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1872304479:
                    if (optString.equals("boss.start")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -1792656369:
                    if (optString.equals("wheel.start")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1177155684:
                    if (optString.equals("wakeup.command")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 104263205:
                    if (optString.equals("music")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 282538108:
                    if (optString.equals("click.start")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 687136219:
                    if (optString.equals("api.avatarClick")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 699317398:
                    if (optString.equals("api.avatarPress")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 790870569:
                    if (optString.equals("api.sendText")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1100434848:
                    if (optString.equals("api.triggerIntent")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 1:
                    i2 = 2;
                    break;
                case 2:
                    i2 = 6;
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    i2 = 3;
                    break;
                case '\b':
                    i2 = 4;
                    break;
                case '\t':
                    i2 = 5;
                    break;
                case '\n':
                    i2 = 7;
                    break;
            }
            str2 = jSONObject.optString("sessionId");
            i = jSONObject.optInt("soundArea");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new zn(i2, str2, i);
    }
}
