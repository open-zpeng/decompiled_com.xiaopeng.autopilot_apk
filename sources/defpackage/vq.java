package defpackage;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import java.util.List;
/* compiled from: AbstractStatDelegate.java */
/* renamed from: vq  reason: default package */
/* loaded from: classes.dex */
public abstract class vq {
    protected Context a;

    public abstract String a();

    public abstract void a(IMoleEvent iMoleEvent);

    public abstract void a(IStatEvent iStatEvent);

    public abstract void a(IStatEvent iStatEvent, List<String> list);

    public abstract void a(String str);

    public abstract void a(String str, String str2);

    public abstract void a(List<String> list);

    public abstract void b(String str, String str2);

    public vq(Context context) {
        this.a = context;
    }
}
