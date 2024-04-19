package defpackage;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.autopilot.base.bean.ShareMapSaveBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: SharedPreferenceHelper.java */
/* renamed from: rf  reason: default package */
/* loaded from: classes.dex */
public class rf {
    private static volatile rf b;
    private Context a;
    private List<ShareMapSaveBean> c = new ArrayList();

    private rf(Context context) {
        this.a = context.getApplicationContext();
        f();
    }

    public static rf a(Context context) {
        if (b == null) {
            synchronized (rf.class) {
                if (b == null) {
                    b = new rf(context);
                }
            }
        }
        return b;
    }

    public int a() {
        return this.a.getSharedPreferences("pref_autopilot", 0).getInt("reversing_avm_type", 17);
    }

    public void a(int i) {
        this.a.getSharedPreferences("pref_autopilot", 0).edit().putInt("reversing_avm_type", i).apply();
    }

    public void a(boolean z) {
        this.a.getSharedPreferences("pref_autopilot", 0).edit().putBoolean("share_is_igon", z).commit();
    }

    public boolean b() {
        return this.a.getSharedPreferences("pref_autopilot", 0).getBoolean("share_is_igon", true);
    }

    public void b(boolean z) {
        this.a.getSharedPreferences("pref_autopilot", 0).edit().putBoolean("ai_card_tts", z).commit();
    }

    public boolean c() {
        return this.a.getSharedPreferences("pref_autopilot", 0).getBoolean("ai_card_tts", true);
    }

    public void c(boolean z) {
        this.a.getSharedPreferences("pref_autopilot", 0).edit().putBoolean("auto_pilot_can_debug", z).commit();
    }

    public boolean d() {
        return this.a.getSharedPreferences("pref_autopilot", 0).getBoolean("auto_pilot_can_debug", false);
    }

    public void d(boolean z) {
        this.a.getSharedPreferences("pref_autopilot", 0).edit().putBoolean("auto_pilot_user_agreement", z).commit();
    }

    public boolean e() {
        return this.a.getSharedPreferences("pref_autopilot", 0).getBoolean("auto_pilot_user_agreement", false);
    }

    public void a(long j, boolean z) {
        Log.d("SharedPreferenceHelper", "setShareMapState mapId = " + j + " ; share = " + z);
        if (z) {
            ShareMapSaveBean shareMapSaveBean = new ShareMapSaveBean(j, z);
            Log.d("SharedPreferenceHelper", "setShareMapState add = " + j);
            this.c.add(shareMapSaveBean);
        } else {
            Iterator<ShareMapSaveBean> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ShareMapSaveBean next = it.next();
                if (next.getMapId() == j) {
                    Log.d("SharedPreferenceHelper", "setShareMapState remove = " + j);
                    this.c.remove(next);
                    break;
                }
            }
        }
        this.a.getSharedPreferences("pref_autopilot", 0).edit().putString("auto_pilot_share_map", new Gson().toJson(this.c)).commit();
    }

    public boolean a(long j) {
        for (ShareMapSaveBean shareMapSaveBean : this.c) {
            if (shareMapSaveBean.getMapId() == j) {
                Log.d("SharedPreferenceHelper", "mapIsShare true mapId = " + j);
                return shareMapSaveBean.isShared();
            }
        }
        Log.d("SharedPreferenceHelper", "mapIsShare false mapId = " + j);
        return false;
    }

    private void f() {
        String string = this.a.getSharedPreferences("pref_autopilot", 0).getString("auto_pilot_share_map", null);
        if (string != null) {
            this.c = (List) new Gson().fromJson(string, new TypeToken<List<ShareMapSaveBean>>() { // from class: rf.1
            }.getType());
        }
    }
}
