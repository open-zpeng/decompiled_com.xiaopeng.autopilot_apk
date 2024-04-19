package defpackage;

import android.text.TextUtils;
import com.xiaopeng.libconfig.remotecontrol.RemoteControlFeedbackConstant;
import okhttp3.internal.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: NaviPreferenceBean.java */
/* renamed from: zt  reason: default package */
/* loaded from: classes.dex */
public class zt {
    private String a;
    private int b;

    public static zt a(String str) {
        zt ztVar = new zt();
        try {
            JSONObject jSONObject = new JSONObject(str);
            ztVar.a = jSONObject.optString("mode");
            ztVar.b = jSONObject.optInt("switch");
            xx.a("NaviPreferenceBean", "fromJson, pref:" + ztVar.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ztVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b(String str) {
        char c;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        switch (str.hashCode()) {
            case -2097684128:
                if (str.equals("avoid unpaved")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1772467395:
                if (str.equals("restaurant")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case -1749203455:
                if (str.equals("avoid country border")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1722267927:
                if (str.equals("parking lot")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -1355030580:
                if (str.equals("coffee")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -1262772667:
                if (str.equals("avoid carpool")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1122290598:
                if (str.equals("eco friendly")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1077115990:
                if (str.equals("fastest")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -963579080:
                if (str.equals("ferries")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -901578142:
                if (str.equals("avoid highway")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -862547864:
                if (str.equals("tunnel")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -597819771:
                if (str.equals("charging station")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -280604405:
                if (str.equals("unpaved")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -85459550:
                if (str.equals("fast food")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 3004697:
                if (str.equals("atms")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 3565883:
                if (str.equals("toll")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 99467700:
                if (str.equals("hotel")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 292882701:
                if (str.equals("grocery")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 554307056:
                if (str.equals("carpool")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 915501581:
                if (str.equals("highway")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1157046643:
                if (str.equals("avoid tunnel")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1359855878:
                if (str.equals("avoid toll")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1514308493:
                if (str.equals("avoid ferries")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1569517558:
                if (str.equals("country border")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 100;
            case 1:
                return 101;
            case 2:
                return 200;
            case 3:
                return RemoteControlFeedbackConstant.SUCCESS_WAKE_UP;
            case 4:
                return 206;
            case 5:
                return 207;
            case 6:
                return 202;
            case 7:
                return 203;
            case '\b':
                return 204;
            case '\t':
                return 205;
            case '\n':
                return 208;
            case 11:
                return 209;
            case '\f':
                return 210;
            case '\r':
                return 211;
            case 14:
                return 212;
            case 15:
                return 213;
            case 16:
                return 300;
            case 17:
                return 301;
            case 18:
                return 302;
            case 19:
                return 303;
            case 20:
                return 304;
            case 21:
                return 305;
            case 22:
                return 306;
            case 23:
                return StatusLine.HTTP_TEMP_REDIRECT;
            default:
                return 0;
        }
    }

    public String toString() {
        return "NaviPreferenceBean{pref='" + this.a + "', enable='" + this.b + "'}";
    }
}
