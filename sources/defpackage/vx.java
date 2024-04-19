package defpackage;

import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: ApiMatcher.java */
/* renamed from: vx  reason: default package */
/* loaded from: classes.dex */
class vx {
    private ConcurrentHashMap<String, wa> a = new ConcurrentHashMap<>();

    public synchronized void a(wb wbVar, wa waVar) {
        wa a;
        String str = wbVar.c;
        wa a2 = a(str, waVar.a(), waVar);
        if (a2 != null) {
            a2.a("getAuthority");
        }
        if (!waVar.a().equals(waVar.b()) && (a = a(str, waVar.b(), waVar)) != null) {
            a.a("getDescription");
        }
        waVar.d();
    }

    public synchronized void a(wb wbVar) {
        wa c = c(wbVar);
        if (c != null) {
            String str = wbVar.c;
            a(str, c.a());
            if (!c.a().equals(c.b())) {
                a(str, c.b());
            }
            c.a("unpublishUri");
        }
    }

    public synchronized wa b(wb wbVar) {
        return c(wbVar);
    }

    private wa a(String str, String str2, wa waVar) {
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "@" + str2;
        }
        return this.a.put(str2, waVar);
    }

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            str2 = str + "@" + str2;
        }
        this.a.remove(str2);
    }

    private wa c(wb wbVar) {
        Set<Map.Entry<String, wa>> entrySet = this.a.entrySet();
        String str = wbVar.c;
        String str2 = !TextUtils.isEmpty(str) ? str + "@" + wbVar.a + "." : wbVar.a + ".";
        String str3 = "." + wbVar.b;
        for (Map.Entry<String, wa> entry : entrySet) {
            String key = entry.getKey();
            if (key.startsWith(str2) && key.endsWith(str3)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
