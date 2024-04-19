package defpackage;

import com.google.gson.Gson;
/* compiled from: GlobalGsonInstance.java */
/* renamed from: vp  reason: default package */
/* loaded from: classes.dex */
public class vp {
    private Gson a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlobalGsonInstance.java */
    /* renamed from: vp$a */
    /* loaded from: classes.dex */
    public static class a {
        static final vp a = new vp();
    }

    public static vp a() {
        return a.a;
    }

    private vp() {
        this.a = new Gson();
    }

    public Gson b() {
        return this.a;
    }
}
