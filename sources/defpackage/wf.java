package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: StackTraceCollector.java */
/* renamed from: wf  reason: default package */
/* loaded from: classes.dex */
public class wf implements wi {
    private long a;
    private volatile a b;
    private ArrayList<StackTraceElement[]> c;
    private int[] d;
    private StackTraceElement[] e;
    private Thread f;
    private int g;
    private volatile boolean h;

    public wf(long j) {
        this.a = j;
        HandlerThread handlerThread = new HandlerThread("StackTraceCollector");
        handlerThread.setPriority(10);
        handlerThread.start();
        this.b = new a(handlerThread.getLooper());
        this.g = 3;
        this.c = new ArrayList<>(this.g);
        this.d = new int[this.g];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        synchronized (this.c) {
            if (!this.c.isEmpty()) {
                this.e = null;
                this.c.clear();
                Arrays.fill(this.d, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        synchronized (this.c) {
            int size = this.c.size() - 1;
            this.d[size] = this.d[size] + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.obj = this;
        obtainMessage.what = i;
        this.b.sendMessageDelayed(obtainMessage, this.a);
    }

    public boolean a() {
        return this.h;
    }

    @Override // defpackage.wi
    public void b() {
        this.h = true;
        a(54);
    }

    @Override // defpackage.wi
    public void c() {
        this.h = false;
        this.b.removeMessages(54);
        this.b.removeMessages(55);
    }

    @Override // defpackage.wi
    public int[] d() {
        int[] copyOf;
        synchronized (this.c) {
            copyOf = Arrays.copyOf(this.d, this.d.length);
        }
        return copyOf;
    }

    @Override // defpackage.wi
    public StackTraceElement[][] e() {
        StackTraceElement[][] stackTraceElementArr;
        synchronized (this.c) {
            stackTraceElementArr = (StackTraceElement[][]) this.c.toArray((StackTraceElement[][]) Array.newInstance(StackTraceElement.class, 0, 0));
        }
        return stackTraceElementArr;
    }

    public void a(StackTraceElement[] stackTraceElementArr) {
        synchronized (this.c) {
            this.e = stackTraceElementArr;
            if (this.c.size() >= this.g) {
                int i = this.g - 1;
                int i2 = this.d[i];
                int i3 = i;
                for (int i4 = i - 1; i4 >= 1; i4--) {
                    if (i2 > this.d[i4]) {
                        i2 = this.d[i4];
                        i3 = i4;
                    }
                }
                this.c.remove(i3);
                while (i3 < i) {
                    int i5 = i3 + 1;
                    this.d[i3] = this.d[i5];
                    i3 = i5;
                }
                this.d[i] = 0;
            }
            this.c.add(stackTraceElementArr);
            this.d[this.c.size() - 1] = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StackTraceCollector.java */
    /* renamed from: wf$a */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 54 || message.what == 55) {
                if (message.what == 54) {
                    wf.this.f();
                }
                StackTraceElement[] h = wf.this.h();
                if (wf.b(h, wf.this.e)) {
                    wf.this.g();
                } else {
                    wf.this.a(h);
                }
                if (wf.this.a()) {
                    wf.this.a(55);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StackTraceElement[] h() {
        if (this.f == null) {
            this.f = Looper.getMainLooper().getThread();
        }
        return this.f.getStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int length;
        if (stackTraceElementArr == null || stackTraceElementArr2 == null || (length = stackTraceElementArr.length) != stackTraceElementArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!stackTraceElementArr[i].equals(stackTraceElementArr2[i])) {
                return false;
            }
        }
        return true;
    }
}
