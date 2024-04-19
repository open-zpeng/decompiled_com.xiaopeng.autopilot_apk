package defpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* renamed from: ao  reason: default package */
/* loaded from: classes.dex */
public class ao<K, V> extends au<K, V> implements Map<K, V> {
    at<K, V> a;

    public ao() {
    }

    public ao(int i) {
        super(i);
    }

    private at<K, V> b() {
        if (this.a == null) {
            this.a = new at<K, V>() { // from class: ao.1
                @Override // defpackage.at
                protected int a() {
                    return ao.this.h;
                }

                @Override // defpackage.at
                protected Object a(int i, int i2) {
                    return ao.this.g[(i << 1) + i2];
                }

                @Override // defpackage.at
                protected int a(Object obj) {
                    return ao.this.a(obj);
                }

                @Override // defpackage.at
                protected int b(Object obj) {
                    return ao.this.b(obj);
                }

                @Override // defpackage.at
                protected Map<K, V> b() {
                    return ao.this;
                }

                @Override // defpackage.at
                protected void a(K k, V v) {
                    ao.this.put(k, v);
                }

                @Override // defpackage.at
                protected V a(int i, V v) {
                    return ao.this.a(i, (int) v);
                }

                @Override // defpackage.at
                protected void a(int i) {
                    ao.this.d(i);
                }

                @Override // defpackage.at
                protected void c() {
                    ao.this.clear();
                }
            };
        }
        return this.a;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean a(Collection<?> collection) {
        return at.c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }
}
