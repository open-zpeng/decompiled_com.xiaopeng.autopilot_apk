package defpackage;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import java.util.List;
/* compiled from: StatEventHelper.java */
/* renamed from: vs  reason: default package */
/* loaded from: classes.dex */
public class vs {
    private static volatile vs a;
    private vq b;

    private vs(Context context) {
        this.b = new vt(context);
    }

    public static void a(Context context) {
        a = new vs(context);
    }

    public static vs a() {
        if (a == null) {
            throw new IllegalStateException("has not init the StatEventHeler");
        }
        return a;
    }

    public void a(IStatEvent iStatEvent) {
        this.b.a(iStatEvent);
    }

    public void a(IMoleEvent iMoleEvent) {
        this.b.a(iMoleEvent);
    }

    public void a(String str) {
        this.b.a(str);
    }

    public void a(String str, String str2) {
        this.b.a(str, str2);
    }

    public void a(IStatEvent iStatEvent, List<String> list) {
        this.b.a(iStatEvent, list);
    }

    public void a(List<String> list) {
        this.b.a(list);
    }

    public String b() {
        return this.b.a();
    }

    public void b(String str, String str2) {
        this.b.b(str, str2);
    }
}
