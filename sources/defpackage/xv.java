package defpackage;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
/* compiled from: AsyncRunner.java */
/* renamed from: xv  reason: default package */
/* loaded from: classes.dex */
public abstract class xv<IFunc> {
    protected xz b;
    protected String a = "AsyncRunner";
    private Queue<IFunc> c = new ArrayBlockingQueue(100);

    protected abstract boolean a();

    protected abstract <R> R b(IFunc ifunc);

    public xv(String str) {
        this.a += "-" + str;
    }

    public void a(xz xzVar) {
        this.b = xzVar;
    }

    public void a(IFunc ifunc) {
        a(ifunc, null);
    }

    public synchronized <R> R a(IFunc ifunc, R r) {
        if (a()) {
            if (this.c.size() > 0) {
                this.c.offer(ifunc);
                b();
                xx.b(this.a, "can run offer fun");
            } else {
                return (R) b(ifunc);
            }
        } else {
            this.c.offer(ifunc);
            xx.b(this.a, "offer fun");
        }
        return r;
    }

    public void b() {
        xx.b(this.a, "fetchAll fun:%d", Integer.valueOf(this.c.size()));
        xz xzVar = this.b;
        if (xzVar != null) {
            xzVar.post(new Runnable() { // from class: xv.1
                @Override // java.lang.Runnable
                public void run() {
                    xv.this.c();
                }
            });
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        while (this.c.size() > 0) {
            IFunc poll = this.c.poll();
            if (a() && poll != null) {
                b(poll);
            }
        }
    }
}
