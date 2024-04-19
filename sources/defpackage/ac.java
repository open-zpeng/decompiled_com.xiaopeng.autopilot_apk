package defpackage;

import defpackage.ad;
import java.util.HashMap;
import java.util.Map;
/* compiled from: FastSafeIterableMap.java */
/* renamed from: ac  reason: default package */
/* loaded from: classes.dex */
public class ac<K, V> extends ad<K, V> {
    private HashMap<K, ad.c<K, V>> b = new HashMap<>();

    @Override // defpackage.ad
    protected ad.c<K, V> a(K k) {
        return this.b.get(k);
    }

    @Override // defpackage.ad
    public V a(K k, V v) {
        ad.c<K, V> a = a(k);
        if (a != null) {
            return a.b;
        }
        this.b.put(k, b(k, v));
        return null;
    }

    @Override // defpackage.ad
    public V b(K k) {
        V v = (V) super.b(k);
        this.b.remove(k);
        return v;
    }

    public boolean c(K k) {
        return this.b.containsKey(k);
    }

    public Map.Entry<K, V> d(K k) {
        if (c(k)) {
            return this.b.get(k).d;
        }
        return null;
    }
}
