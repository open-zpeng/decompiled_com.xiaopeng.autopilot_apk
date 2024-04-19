package defpackage;

import com.badlogic.gdx.utils.a;
import defpackage.iz;
/* compiled from: AssetLoader.java */
/* renamed from: jd  reason: default package */
/* loaded from: classes.dex */
public abstract class jd<T, P extends iz<T>> {
    private jh resolver;

    public abstract a<ix> getDependencies(String str, jy jyVar, P p);

    public jd(jh jhVar) {
        this.resolver = jhVar;
    }

    public jy resolve(String str) {
        return this.resolver.a(str);
    }
}
