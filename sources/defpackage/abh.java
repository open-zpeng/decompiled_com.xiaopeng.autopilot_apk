package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.protobuf.InvalidProtocolBufferException;
import com.xiaopeng.sr.bean.ApMapBean;
import defpackage.ahz;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XpuDataParser.java */
/* renamed from: abh  reason: default package */
/* loaded from: classes.dex */
public class abh {
    private HandlerThread a;
    private Handler b;
    private abi c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private float j;
    private float k;
    private float l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private long w;
    private long x;
    private ApMapBean y;
    private int z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: XpuDataParser.java */
    /* renamed from: abh$b */
    /* loaded from: classes.dex */
    public static class b {
        private static final abh a = new abh();
    }

    public static abh a() {
        return b.a;
    }

    private abh() {
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1.0f;
        this.k = -1.0f;
        this.l = -1.0f;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1L;
        this.x = -1L;
        this.y = new ApMapBean();
        this.z = -1;
        b();
    }

    public void b() {
        this.a = new HandlerThread("sDataExecThread", 10);
        this.a.start();
        this.b = new a(this.a.getLooper());
    }

    public void a(abi abiVar) {
        this.c = abiVar;
    }

    public void a(byte[] bArr) {
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.what = 0;
        obtainMessage.obj = bArr;
        this.b.sendMessage(obtainMessage);
    }

    public void b(byte[] bArr) {
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = bArr;
        this.b.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(byte[] bArr) {
        Log.d("XpuDataParser", "execEventData: b length = " + bArr.length);
        try {
            ahz.a a2 = ahz.a.a(bArr);
            int e = a2.e();
            Log.d("XpuDataParser", "execEventData time = " + e);
            if (a2.c()) {
                Log.d("XpuDataParser", "hasApTrajectoryData");
                this.c.onAllGuildlineChange(a2.d());
            }
            if (a2.a()) {
                Log.d("XpuDataParser", "hasVenueMap");
                this.c.onMapMessage(a2.b());
            }
        } catch (InvalidProtocolBufferException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x026e, code lost:
        if (r28.r != r3) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02b6, code lost:
        if (r3 == r28.r) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0396, code lost:
        if (r28.t != r3) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0399  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(byte[] r29) {
        /*
            Method dump skipped, instructions count: 1071
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.abh.d(byte[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: XpuDataParser.java */
    /* renamed from: abh$a */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            switch (message.what) {
                case 0:
                    abh.this.c(bArr);
                    return;
                case 1:
                    abh.this.d(bArr);
                    return;
                default:
                    return;
            }
        }
    }
}
