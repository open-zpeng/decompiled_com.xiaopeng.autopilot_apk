package com.badlogic.gdx.utils;
/* compiled from: Timer.java */
/* loaded from: classes.dex */
public class ap {
    static final Object a = new Object();
    static b b;
    final com.badlogic.gdx.utils.a<a> c = new com.badlogic.gdx.utils.a<>(false, 8);

    public static ap a() {
        ap apVar;
        synchronized (a) {
            b c = c();
            if (c.c == null) {
                c.c = new ap();
            }
            apVar = c.c;
        }
        return apVar;
    }

    private static b c() {
        b bVar;
        synchronized (a) {
            if (b == null || b.a != io.e) {
                if (b != null) {
                    b.dispose();
                }
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    public ap() {
        b();
    }

    public a a(a aVar, float f) {
        return a(aVar, f, 0.0f, 0);
    }

    public a a(a aVar, float f, float f2) {
        return a(aVar, f, f2, -1);
    }

    public a a(a aVar, float f, float f2, int i) {
        synchronized (this) {
            synchronized (aVar) {
                if (aVar.g != null) {
                    throw new IllegalArgumentException("The same task may not be scheduled twice.");
                }
                aVar.g = this;
                aVar.d = (System.nanoTime() / 1000000) + (f * 1000.0f);
                aVar.e = f2 * 1000.0f;
                aVar.f = i;
                this.c.a((com.badlogic.gdx.utils.a<a>) aVar);
            }
        }
        synchronized (a) {
            a.notifyAll();
        }
        return aVar;
    }

    public void b() {
        synchronized (a) {
            com.badlogic.gdx.utils.a<ap> aVar = c().b;
            if (aVar.a((com.badlogic.gdx.utils.a<ap>) this, true)) {
                return;
            }
            aVar.a((com.badlogic.gdx.utils.a<ap>) this);
            a.notifyAll();
        }
    }

    synchronized long a(long j, long j2) {
        int i = 0;
        int i2 = this.c.b;
        while (i < i2) {
            a a2 = this.c.a(i);
            synchronized (a2) {
                if (a2.d > j) {
                    j2 = Math.min(j2, a2.d - j);
                } else {
                    if (a2.f == 0) {
                        a2.g = null;
                        this.c.b(i);
                        i--;
                        i2--;
                    } else {
                        a2.d = a2.e + j;
                        j2 = Math.min(j2, a2.e);
                        if (a2.f > 0) {
                            a2.f--;
                        }
                    }
                    a2.c.postRunnable(a2);
                }
            }
            i++;
        }
        return j2;
    }

    public synchronized void a(long j) {
        int i = this.c.b;
        for (int i2 = 0; i2 < i; i2++) {
            a a2 = this.c.a(i2);
            synchronized (a2) {
                a2.d += j;
            }
        }
    }

    public static a b(a aVar, float f) {
        return a().a(aVar, f);
    }

    public static a b(a aVar, float f, float f2) {
        return a().a(aVar, f, f2);
    }

    /* compiled from: Timer.java */
    /* loaded from: classes.dex */
    public static abstract class a implements Runnable {
        final ij c = io.a;
        long d;
        long e;
        int f;
        volatile ap g;

        @Override // java.lang.Runnable
        public abstract void run();

        public a() {
            if (this.c == null) {
                throw new IllegalStateException("Gdx.app not available.");
            }
        }

        public void a() {
            ap apVar = this.g;
            if (apVar != null) {
                synchronized (apVar) {
                    synchronized (this) {
                        this.d = 0L;
                        this.g = null;
                        apVar.c.c(this, true);
                    }
                }
                return;
            }
            synchronized (this) {
                this.d = 0L;
                this.g = null;
            }
        }

        public boolean b() {
            return this.g != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Timer.java */
    /* loaded from: classes.dex */
    public static class b implements iu, Runnable {
        ap c;
        private long d;
        final com.badlogic.gdx.utils.a<ap> b = new com.badlogic.gdx.utils.a<>(1);
        final in a = io.e;

        public b() {
            io.a.addLifecycleListener(this);
            resume();
            Thread thread = new Thread(this, "Timer");
            thread.setDaemon(true);
            thread.start();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                synchronized (ap.a) {
                    if (ap.b != this || this.a != io.e) {
                        break;
                    }
                    long j = 5000;
                    if (this.d == 0) {
                        long nanoTime = System.nanoTime() / 1000000;
                        int i = this.b.b;
                        for (int i2 = 0; i2 < i; i2++) {
                            j = this.b.a(i2).a(nanoTime, j);
                        }
                    }
                    if (ap.b != this || this.a != io.e) {
                        break;
                    } else if (j > 0) {
                        try {
                            ap.a.wait(j);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
            dispose();
        }

        @Override // defpackage.iu
        public void resume() {
            synchronized (ap.a) {
                long nanoTime = (System.nanoTime() / 1000000) - this.d;
                int i = this.b.b;
                for (int i2 = 0; i2 < i; i2++) {
                    this.b.a(i2).a(nanoTime);
                }
                this.d = 0L;
                ap.a.notifyAll();
            }
        }

        @Override // defpackage.iu
        public void pause() {
            synchronized (ap.a) {
                this.d = System.nanoTime() / 1000000;
                ap.a.notifyAll();
            }
        }

        @Override // defpackage.iu
        public void dispose() {
            synchronized (ap.a) {
                if (ap.b == this) {
                    ap.b = null;
                }
                this.b.d();
                ap.a.notifyAll();
            }
            io.a.removeLifecycleListener(this);
        }
    }
}
