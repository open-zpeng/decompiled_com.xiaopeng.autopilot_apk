package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: CounterImpl.java */
/* renamed from: vn  reason: default package */
/* loaded from: classes.dex */
public class vn implements Handler.Callback, ICounter {
    private final String a;
    private final long b;
    private final Map<String, AtomicInteger> c;
    private boolean d;
    private AtomicLong e;
    private Handler f;
    private final SharedPreferences g;
    private final SharedPreferences.Editor h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public vn(Context context, String str, long j) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("name can't be empty!");
        }
        this.a = str;
        this.b = j;
        this.c = new HashMap();
        this.g = PreferenceManager.getDefaultSharedPreferences(context);
        this.h = this.g.edit();
        this.e = new AtomicLong(this.g.getLong(a("time"), System.currentTimeMillis()));
        this.f = new Handler(ThreadUtils.getLooper(0), this);
        a();
        a(false);
    }

    private void a() {
        Map<String, ?> all = this.g.getAll();
        LogUtils.d("CounterImpl", "initValuesFromPref prefMap:" + all);
        for (String str : all.keySet()) {
            String b = b(str);
            if (!TextUtils.isEmpty(b) && !b.equals("time")) {
                Object obj = all.get(str);
                if (obj instanceof Integer) {
                    LogUtils.d("CounterImpl", "initValuesFromPref key:" + b + " value:" + obj);
                    this.c.put(b, new AtomicInteger(((Integer) obj).intValue()));
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            if (this.d) {
                LogUtils.d("CounterImpl", "mEditor.apply()");
            }
            this.h.apply();
        }
        return true;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public void debug(boolean z) {
        this.d = z;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str) {
        return count(str, 1);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str, int i) {
        int i2;
        int i3;
        AtomicInteger atomicInteger = this.c.get(str);
        String a = a(str);
        if (atomicInteger == null) {
            try {
                i2 = this.g.getInt(a, 0);
            } catch (ClassCastException e) {
                LogUtils.w("CounterImpl", "mPreferences.getInt(" + a + ") error!", e);
                i2 = 0;
            }
            if (this.d) {
                LogUtils.v("CounterImpl", "count " + this.a + ", load key:" + a + " from pref, value is " + i2);
            }
            AtomicInteger atomicInteger2 = new AtomicInteger(i2);
            this.c.put(str, atomicInteger2);
            atomicInteger = atomicInteger2;
        }
        i3 = atomicInteger.get() + i;
        atomicInteger.set(i3);
        this.h.putInt(a, i3);
        if (this.d) {
            LogUtils.v("CounterImpl", "count " + this.a + " " + str + ":" + i3 + ", cache is:" + this.c);
        }
        boolean z = true;
        if (!this.f.hasMessages(1)) {
            this.f.sendEmptyMessageDelayed(1, 10000L);
        }
        if (i3 != Integer.MAX_VALUE) {
            z = false;
        }
        a(z);
        return i3;
    }

    private String a(String str) {
        return this.a + "_" + str;
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.a + "_";
        if (str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return null;
    }

    private void a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        final long j = this.e.get();
        long j2 = this.b;
        if (j / j2 < currentTimeMillis / j2 || z) {
            final HashMap hashMap = new HashMap();
            for (String str : this.c.keySet()) {
                AtomicInteger atomicInteger = this.c.get(str);
                hashMap.put(str, Integer.valueOf(atomicInteger.get()));
                atomicInteger.set(0);
                this.h.putInt(a(str), 0);
            }
            ThreadUtils.post(2, new Runnable() { // from class: vn.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.i("CounterImpl", "[" + vn.this.a + " counter] send count event, name:" + vn.this.a + " values:" + hashMap);
                    IDataLog iDataLog = (IDataLog) Module.get(vi.class).get(IDataLog.class);
                    IMoleEventBuilder event = iDataLog.buildMoleEvent().setPageId("P00012").setButtonId("B001").setEvent(vn.this.a);
                    for (String str2 : hashMap.keySet()) {
                        event.setProperty(str2, (Number) hashMap.get(str2));
                    }
                    event.setProperty("time", Long.valueOf(j));
                    IMoleEvent build = event.build();
                    LogUtils.d("CounterImpl", "start sendStatData:" + build.toJson());
                    iDataLog.sendStatData(build);
                }
            });
            if (!this.f.hasMessages(1)) {
                this.f.sendEmptyMessageDelayed(1, 10000L);
            }
        }
        this.e.set(currentTimeMillis);
        this.h.putLong(a("time"), currentTimeMillis);
    }
}
