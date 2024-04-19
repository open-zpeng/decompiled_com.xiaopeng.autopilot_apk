package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
/* compiled from: Caton.java */
/* renamed from: wh  reason: default package */
/* loaded from: classes.dex */
public class wh {
    static c a = c.LOOPER;
    private static volatile wh b;

    /* compiled from: Caton.java */
    /* renamed from: wh$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(String[] strArr, boolean z, long... jArr);
    }

    private wh(Context context, long j, long j2, c cVar, boolean z, b bVar) {
        long min = Math.min(Math.max(j, 200L), 400L);
        long min2 = Math.min(Math.max(j2, 200L), 400L);
        wj.b = z;
        wj.a = min;
        wg wgVar = new wg(context, new wf(min2), bVar);
        if (cVar == c.LOOPER) {
            new wl(wgVar);
        } else if (cVar == c.FRAME) {
            if (Build.VERSION.SDK_INT >= 16) {
                Choreographer.getInstance().postFrameCallback(new wk(context, wgVar));
                return;
            }
            new wl(wgVar);
        }
    }

    public static void a(a aVar) {
        if (b == null) {
            synchronized (wh.class) {
                if (b == null) {
                    b = aVar.a();
                }
            }
        }
    }

    /* compiled from: Caton.java */
    /* renamed from: wh$a */
    /* loaded from: classes.dex */
    public static class a {
        private Context c;
        private b f;
        private long a = 3000;
        private long b = 1000;
        private c d = wh.a;
        private boolean e = true;

        public a(Context context) {
            this.c = context;
        }

        public a a(long j) {
            this.a = j;
            return this;
        }

        public a b(long j) {
            this.b = j;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar;
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public a a(b bVar) {
            this.f = bVar;
            return this;
        }

        wh a() {
            return new wh(this.c, this.a, this.b, this.d, this.e, this.f);
        }
    }

    /* compiled from: Caton.java */
    /* renamed from: wh$c */
    /* loaded from: classes.dex */
    public enum c {
        LOOPER(0),
        FRAME(1);
        
        int a;

        c(int i) {
            this.a = i;
        }
    }
}
