package defpackage;

import android.content.Context;
import android.os.SystemClock;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: MoleEvent.java */
/* renamed from: vk  reason: default package */
/* loaded from: classes.dex */
public class vk implements IMoleEvent {
    private Map<String, Object> a = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public vk(Context context) {
        this.a.put(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.a.put(IStatEvent.CUSTOM_MODULE_VERSION, vl.a(context));
        this.a.put(IStatEvent.CUSTOM_NETWORK, vl.b(context));
        this.a.put(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
        this.a.put(IStatEvent.CUSTOM_DEVICE_MCUVER, vl.a());
        this.a.put(IStatEvent.CUSTOM_UID, Long.valueOf(SystemPropertyUtil.getAccountUid()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.a.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Number number) {
        if (str == null || number == null) {
            return;
        }
        this.a.put(str, number);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Boolean bool) {
        if (str == null || bool == null) {
            return;
        }
        this.a.put(str, bool);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Character ch) {
        if (str == null || ch == null) {
            return;
        }
        this.a.put(str, ch);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent
    public String toJson() {
        return vp.a().b().toJson(this.a, new TypeToken<Map<String, Object>>() { // from class: vk.1
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (!this.a.containsKey("page_id")) {
            throw new IllegalArgumentException("Please call setPageId() first");
        }
        if (!this.a.containsKey("button_id")) {
            throw new IllegalArgumentException("Please call setButtonId() first");
        }
        if (!this.a.containsKey(IStatEvent.CUSTOM_MODULE)) {
            throw new IllegalArgumentException("Please call setModule() first");
        }
    }
}
