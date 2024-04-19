package defpackage;

import java.util.ArrayList;
/* compiled from: CompositeDisposable.java */
/* renamed from: add  reason: default package */
/* loaded from: classes.dex */
public final class add implements ade, adv {
    afb<ade> a;
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
            afb<ade> afbVar = this.a;
            this.a = null;
            a(afbVar);
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
                    afb<ade> afbVar = this.a;
                    if (afbVar == null) {
                        afbVar = new afb<>();
                        this.a = afbVar;
                    }
                    afbVar.a((afb<ade>) adeVar);
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
            afb<ade> afbVar = this.a;
            if (afbVar != null && afbVar.b(adeVar)) {
                return true;
            }
            return false;
        }
    }

    void a(afb<ade> afbVar) {
        Object[] b;
        if (afbVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : afbVar.b()) {
            if (obj instanceof ade) {
                try {
                    ((ade) obj).dispose();
                } catch (Throwable th) {
                    adj.a(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
