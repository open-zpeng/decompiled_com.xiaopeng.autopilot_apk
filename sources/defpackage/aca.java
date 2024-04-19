package defpackage;

import android.util.Log;
import defpackage.km;
/* compiled from: AssetManagerExt.java */
/* renamed from: aca  reason: default package */
/* loaded from: classes.dex */
public class aca extends jb {
    @Override // defpackage.jb
    public <T> void a(String str, Class<T> cls, T t) {
        super.a(str, (Class<Class<T>>) cls, (Class<T>) t);
    }

    public ko f(String str) {
        System.currentTimeMillis();
        try {
            return (ko) a(str);
        } catch (Exception unused) {
            Log.i("AssetManagerExt", str + "\tdo not loaded ,need create!");
            ko koVar = new ko(io.e.internal(str));
            a(str, (Class<Class>) ko.class, (Class) koVar);
            return koVar;
        }
    }

    public ko a(String str, km.c cVar, boolean z) {
        System.currentTimeMillis();
        try {
            return (ko) a(str);
        } catch (Exception unused) {
            Log.i("AssetManagerExt", str + "\tdo not loaded ,need create!");
            ko koVar = new ko(io.e.internal(str), cVar, z);
            a(str, (Class<Class>) ko.class, (Class) koVar);
            return koVar;
        }
    }
}
