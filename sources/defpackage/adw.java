package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: DisposableHelper.java */
/* renamed from: adw  reason: default package */
/* loaded from: classes.dex */
public enum adw implements ade {
    DISPOSED;

    @Override // defpackage.ade
    public void dispose() {
    }

    @Override // defpackage.ade
    public boolean isDisposed() {
        return true;
    }

    public static boolean isDisposed(ade adeVar) {
        return adeVar == DISPOSED;
    }

    public static boolean set(AtomicReference<ade> atomicReference, ade adeVar) {
        ade adeVar2;
        do {
            adeVar2 = atomicReference.get();
            if (adeVar2 == DISPOSED) {
                if (adeVar != null) {
                    adeVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(adeVar2, adeVar));
        if (adeVar2 != null) {
            adeVar2.dispose();
            return true;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<ade> atomicReference, ade adeVar) {
        aeb.a(adeVar, "d is null");
        if (atomicReference.compareAndSet(null, adeVar)) {
            return true;
        }
        adeVar.dispose();
        if (atomicReference.get() != DISPOSED) {
            reportDisposableSet();
            return false;
        }
        return false;
    }

    public static boolean replace(AtomicReference<ade> atomicReference, ade adeVar) {
        ade adeVar2;
        do {
            adeVar2 = atomicReference.get();
            if (adeVar2 == DISPOSED) {
                if (adeVar != null) {
                    adeVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(adeVar2, adeVar));
        return true;
    }

    public static boolean dispose(AtomicReference<ade> atomicReference) {
        ade andSet;
        ade adeVar = atomicReference.get();
        adw adwVar = DISPOSED;
        if (adeVar == adwVar || (andSet = atomicReference.getAndSet(adwVar)) == adwVar) {
            return false;
        }
        if (andSet != null) {
            andSet.dispose();
            return true;
        }
        return true;
    }

    public static boolean validate(ade adeVar, ade adeVar2) {
        if (adeVar2 == null) {
            afd.a(new NullPointerException("next is null"));
            return false;
        } else if (adeVar != null) {
            adeVar2.dispose();
            reportDisposableSet();
            return false;
        } else {
            return true;
        }
    }

    public static void reportDisposableSet() {
        afd.a(new adm("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<ade> atomicReference, ade adeVar) {
        if (atomicReference.compareAndSet(null, adeVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            adeVar.dispose();
            return false;
        }
        return false;
    }
}
