package defpackage;
/* compiled from: Exceptions.java */
/* renamed from: adj  reason: default package */
/* loaded from: classes.dex */
public final class adj {
    public static void a(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
