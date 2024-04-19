package defpackage;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: PagerAdapter.java */
/* renamed from: ih  reason: default package */
/* loaded from: classes.dex */
public abstract class ih {
    private final DataSetObservable a;
    private DataSetObserver b;

    public float a(int i) {
        return 1.0f;
    }

    public abstract int a();

    public int a(Object obj) {
        return -1;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    public void a(View view) {
    }

    public abstract boolean a(View view, Object obj);

    public Parcelable b() {
        return null;
    }

    @Deprecated
    public void b(View view) {
    }

    @Deprecated
    public void b(View view, int i, Object obj) {
    }

    public void a(ViewGroup viewGroup) {
        a((View) viewGroup);
    }

    public Object a(ViewGroup viewGroup, int i) {
        return a((View) viewGroup, i);
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        a((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        b((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup) {
        b((View) viewGroup);
    }

    @Deprecated
    public Object a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void a(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public void b(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.b = dataSetObserver;
        }
    }
}
