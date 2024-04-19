package defpackage;

import java.util.concurrent.Executor;
/* compiled from: ArchTaskExecutor.java */
/* renamed from: z  reason: default package */
/* loaded from: classes.dex */
public class z extends ab {
    private static volatile z a;
    private static final Executor d = new Executor() { // from class: z.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            z.a().b(runnable);
        }
    };
    private static final Executor e = new Executor() { // from class: z.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            z.a().a(runnable);
        }
    };
    private ab c = new aa();
    private ab b = this.c;

    private z() {
    }

    public static z a() {
        if (a != null) {
            return a;
        }
        synchronized (z.class) {
            if (a == null) {
                a = new z();
            }
        }
        return a;
    }

    @Override // defpackage.ab
    public void a(Runnable runnable) {
        this.b.a(runnable);
    }

    @Override // defpackage.ab
    public void b(Runnable runnable) {
        this.b.b(runnable);
    }

    @Override // defpackage.ab
    public boolean b() {
        return this.b.b();
    }
}
