package defpackage;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
/* compiled from: CounterFactory.java */
/* renamed from: vm  reason: default package */
/* loaded from: classes.dex */
public class vm implements ICounterFactory {
    private vm() {
    }

    /* compiled from: CounterFactory.java */
    /* renamed from: vm$a */
    /* loaded from: classes.dex */
    private static final class a {
        private static final vm a = new vm();
    }

    public static vm a() {
        return a.a;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createHourlyCounter(Context context, String str) {
        return new vn(context, str, 3600000L);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createDailyCounter(Context context, String str) {
        return new vn(context, str, 86400000L);
    }
}
