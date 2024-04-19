package com.xiaopeng.speech.protocol.node.autoparking;

import android.os.Binder;
import android.os.IBinder;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import com.xiaopeng.speech.protocol.node.dialog.DialogNode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AutoParkingNode extends xa<a> {
    private IBinder d = new Binder();
    private volatile boolean e = false;

    private void h() {
    }

    public AutoParkingNode() {
        wz.b().l().a(DialogNode.class, new com.xiaopeng.speech.protocol.node.dialog.a() { // from class: com.xiaopeng.speech.protocol.node.autoparking.AutoParkingNode.1
            @Override // com.xiaopeng.speech.protocol.node.dialog.a, com.xiaopeng.speech.protocol.node.dialog.b
            public void a(zm zmVar) {
                super.a(zmVar);
                if ("voice".equals(zmVar.a) || "wheel".equals(zmVar.a)) {
                    AutoParkingNode.this.onExit("", "");
                }
            }
        });
    }

    public void a(String str, boolean z) {
        String str2;
        String str3;
        String str4;
        if (z) {
            try {
                str2 = new JSONObject().put("tts", str).put("isLocalSkill", true).put("command", "command://autoparking.park.start#native://autoparking.park.carport.count#command://autoparking.find.parking.space.continue#command://autoparking.find.parking.space.exit").toString();
            } catch (JSONException e) {
                e.printStackTrace();
                str2 = "";
            }
            str3 = "沿途泊车";
            str4 = "沿途找车位";
        } else {
            try {
                str2 = new JSONObject().put("tts", str).put("isLocalSkill", true).put("command", "command://autoparking.park.start#native://autoparking.park.carport.count#command://autoparking.exit").toString();
                str3 = "自动泊车";
                str4 = "离线自动泊车";
            } catch (JSONException e2) {
                e2.printStackTrace();
                str2 = "";
                str3 = "自动泊车";
                str4 = "离线自动泊车";
            }
        }
        g();
        wz.b().g().a(this.d, str4, str3, "找到车位", str2);
    }

    public void b(boolean z) {
        wz.b().e().a(this.d, z);
    }

    public void e() {
        wz.b().e().c(this.d);
        wz.b().e().e(this.d);
        wz.b().f().b("autoParking");
        wz.b().f().b("parkingAlongTheWay");
    }

    public void f() {
        wz.b().e().d(this.d);
        wz.b().e().f(this.d);
    }

    public void g() {
        h();
        this.e = false;
        wz.b().e().b("auto_park");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onActivate(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onExit(String str, String str2) {
        h();
        this.e = false;
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onParkStart(String str, String str2) {
        h();
        this.e = false;
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onParkCarportCount(String str, String str2) {
        zf a = zf.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).b(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SpeechAnnotation
    public void onMemoryParkingStart(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e();
            }
        }
    }
}
