package defpackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* compiled from: ListCompositeDisposable.java */
/* renamed from: ady  reason: default package */
/* loaded from: classes.dex */
public final class ady implements ade, adv {
    List<ade> a;
    volatile boolean b;

    @Override // defpackage.ade
    public void dispose() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            List<ade> list = this.a;
            this.a = null;
            a(list);
        }
    }

    @Override // defpackage.ade
    public boolean isDisposed() {
        return this.b;
    }

    @Override // defpackage.adv
    public boolean a(ade adeVar) {
        aeb.a(adeVar, "d is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    List list = this.a;
                    if (list == null) {
                        list = new LinkedList();
                        this.a = list;
                    }
                    list.add(adeVar);
                    return true;
                }
            }
        }
        adeVar.dispose();
        return false;
    }

    @Override // defpackage.adv
    public boolean b(ade adeVar) {
        if (c(adeVar)) {
            adeVar.dispose();
            return true;
        }
        return false;
    }

    @Override // defpackage.adv
    public boolean c(ade adeVar) {
        aeb.a(adeVar, "Disposable item is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            if (this.b) {
                return false;
            }
            List<ade> list = this.a;
            if (list != null && list.remove(adeVar)) {
                return true;
            }
            return false;
        }
    }

    void a(List<ade> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (ade adeVar : list) {
            try {
                adeVar.dispose();
            } catch (Throwable th) {
                adj.a(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw afa.a((Throwable) arrayList.get(0));
            }
            throw new adi(arrayList);
        }
    }
}
