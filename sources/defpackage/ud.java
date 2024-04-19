package defpackage;

import android.util.Log;
/* compiled from: CarEntityPool.java */
/* renamed from: ud  reason: default package */
/* loaded from: classes.dex */
public class ud extends acq<uj> {
    public ud(int i, int i2) {
        super(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.acq
    /* renamed from: a */
    public uj b() {
        Log.i("CarEntityPool", "new Object");
        return new uj("model/entity/jiaoche.g3db");
    }
}
