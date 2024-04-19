package defpackage;

import com.badlogic.gdx.utils.v;
import defpackage.iv;
import java.io.IOException;
import java.net.HttpURLConnection;
/* compiled from: NetJavaImpl.java */
/* renamed from: oc  reason: default package */
/* loaded from: classes.dex */
public class oc {
    private final qp c = new qp(1);
    final v<iv.a, HttpURLConnection> a = new v<>();
    final v<iv.a, iv.c> b = new v<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NetJavaImpl.java */
    /* renamed from: oc$a */
    /* loaded from: classes.dex */
    public static class a implements iv.b {
        private final HttpURLConnection a;
        private ob b;

        public a(HttpURLConnection httpURLConnection) throws IOException {
            this.a = httpURLConnection;
            try {
                this.b = new ob(httpURLConnection.getResponseCode());
            } catch (IOException unused) {
                this.b = new ob(-1);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2 A[Catch: Exception -> 0x00d5, LOOP:0: B:23:0x009c->B:25:0x00a2, LOOP_END, TryCatch #0 {Exception -> 0x00d5, blocks: (B:6:0x0011, B:8:0x001d, B:10:0x0025, B:12:0x002d, B:13:0x003e, B:15:0x0060, B:17:0x0070, B:22:0x007d, B:23:0x009c, B:25:0x00a2, B:26:0x00b8, B:14:0x0057), top: B:35:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(final defpackage.iv.a r9, final defpackage.iv.c r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.c()
            if (r0 != 0) goto L11
            com.badlogic.gdx.utils.k r9 = new com.badlogic.gdx.utils.k
            java.lang.String r0 = "can't process a HTTP request without URL set"
            r9.<init>(r0)
            r10.a(r9)
            return
        L11:
            java.lang.String r0 = r9.b()     // Catch: java.lang.Exception -> Ld5
            java.lang.String r1 = "GET"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> Ld5
            if (r1 == 0) goto L57
            java.lang.String r1 = ""
            java.lang.String r2 = r9.d()     // Catch: java.lang.Exception -> Ld5
            if (r2 == 0) goto L3e
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Exception -> Ld5
            if (r3 != 0) goto L3e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld5
            r1.<init>()     // Catch: java.lang.Exception -> Ld5
            java.lang.String r3 = "?"
            r1.append(r3)     // Catch: java.lang.Exception -> Ld5
            r1.append(r2)     // Catch: java.lang.Exception -> Ld5
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Ld5
        L3e:
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Exception -> Ld5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld5
            r3.<init>()     // Catch: java.lang.Exception -> Ld5
            java.lang.String r4 = r9.c()     // Catch: java.lang.Exception -> Ld5
            r3.append(r4)     // Catch: java.lang.Exception -> Ld5
            r3.append(r1)     // Catch: java.lang.Exception -> Ld5
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Exception -> Ld5
            r2.<init>(r1)     // Catch: java.lang.Exception -> Ld5
            goto L60
        L57:
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Exception -> Ld5
            java.lang.String r1 = r9.c()     // Catch: java.lang.Exception -> Ld5
            r2.<init>(r1)     // Catch: java.lang.Exception -> Ld5
        L60:
            java.net.URLConnection r1 = r2.openConnection()     // Catch: java.lang.Exception -> Ld5
            r6 = r1
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Exception -> Ld5
            java.lang.String r1 = "POST"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> Ld5
            r2 = 1
            if (r1 != 0) goto L7c
            java.lang.String r1 = "PUT"
            boolean r1 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> Ld5
            if (r1 == 0) goto L79
            goto L7c
        L79:
            r1 = 0
            r4 = r1
            goto L7d
        L7c:
            r4 = r2
        L7d:
            r6.setDoOutput(r4)     // Catch: java.lang.Exception -> Ld5
            r6.setDoInput(r2)     // Catch: java.lang.Exception -> Ld5
            r6.setRequestMethod(r0)     // Catch: java.lang.Exception -> Ld5
            boolean r0 = r9.g()     // Catch: java.lang.Exception -> Ld5
            java.net.HttpURLConnection.setFollowRedirects(r0)     // Catch: java.lang.Exception -> Ld5
            r8.a(r9, r10, r6)     // Catch: java.lang.Exception -> Ld5
            java.util.Map r0 = r9.f()     // Catch: java.lang.Exception -> Ld5
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Exception -> Ld5
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Ld5
        L9c:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> Ld5
            if (r1 == 0) goto Lb8
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> Ld5
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Exception -> Ld5
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Exception -> Ld5
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> Ld5
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Exception -> Ld5
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Ld5
            r6.addRequestProperty(r2, r1)     // Catch: java.lang.Exception -> Ld5
            goto L9c
        Lb8:
            int r0 = r9.a()     // Catch: java.lang.Exception -> Ld5
            r6.setConnectTimeout(r0)     // Catch: java.lang.Exception -> Ld5
            int r0 = r9.a()     // Catch: java.lang.Exception -> Ld5
            r6.setReadTimeout(r0)     // Catch: java.lang.Exception -> Ld5
            qp r0 = r8.c     // Catch: java.lang.Exception -> Ld5
            oc$1 r1 = new oc$1     // Catch: java.lang.Exception -> Ld5
            r2 = r1
            r3 = r8
            r5 = r9
            r7 = r10
            r2.<init>()     // Catch: java.lang.Exception -> Ld5
            r0.a(r1)     // Catch: java.lang.Exception -> Ld5
            return
        Ld5:
            r0 = move-exception
            r10.a(r0)     // Catch: java.lang.Throwable -> Ldd
            r8.b(r9)
            return
        Ldd:
            r10 = move-exception
            r8.b(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oc.a(iv$a, iv$c):void");
    }

    public void a(iv.a aVar) {
        iv.c c = c(aVar);
        if (c != null) {
            c.a();
            b(aVar);
        }
    }

    synchronized void b(iv.a aVar) {
        this.a.b((v<iv.a, HttpURLConnection>) aVar);
        this.b.b((v<iv.a, iv.c>) aVar);
    }

    synchronized void a(iv.a aVar, iv.c cVar, HttpURLConnection httpURLConnection) {
        this.a.a((v<iv.a, HttpURLConnection>) aVar, (iv.a) httpURLConnection);
        this.b.a((v<iv.a, iv.c>) aVar, (iv.a) cVar);
    }

    synchronized iv.c c(iv.a aVar) {
        return this.b.a((v<iv.a, iv.c>) aVar);
    }
}
