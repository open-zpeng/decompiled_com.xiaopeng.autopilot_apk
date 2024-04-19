package defpackage;

import com.badlogic.gdx.utils.k;
/* compiled from: GLErrorListener.java */
/* renamed from: nv  reason: default package */
/* loaded from: classes.dex */
public interface nv {
    public static final nv a = new nv() { // from class: nv.1
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
            r0 = r1[r2].getMethodName();
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
            r2 = r2 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
            if (r2 >= r1.length) goto L14;
         */
        @Override // defpackage.nv
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(int r6) {
            /*
                r5 = this;
                r0 = 0
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Exception -> L2a
                java.lang.StackTraceElement[] r1 = r1.getStackTrace()     // Catch: java.lang.Exception -> L2a
                r2 = 0
            La:
                int r3 = r1.length     // Catch: java.lang.Exception -> L2a
                if (r2 >= r3) goto L2a
                java.lang.String r3 = "check"
                r4 = r1[r2]     // Catch: java.lang.Exception -> L2a
                java.lang.String r4 = r4.getMethodName()     // Catch: java.lang.Exception -> L2a
                boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L2a
                if (r3 == 0) goto L27
                int r2 = r2 + 1
                int r3 = r1.length     // Catch: java.lang.Exception -> L2a
                if (r2 >= r3) goto L2a
                r1 = r1[r2]     // Catch: java.lang.Exception -> L2a
                java.lang.String r0 = r1.getMethodName()     // Catch: java.lang.Exception -> L2a
                goto L2a
            L27:
                int r2 = r2 + 1
                goto La
            L2a:
                if (r0 == 0) goto L51
                ij r1 = defpackage.io.a
                java.lang.String r2 = "GLProfiler"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Error "
                r3.append(r4)
                java.lang.String r6 = defpackage.nw.a(r6)
                r3.append(r6)
                java.lang.String r6 = " from "
                r3.append(r6)
                r3.append(r0)
                java.lang.String r6 = r3.toString()
                r1.error(r2, r6)
                goto L77
            L51:
                ij r0 = defpackage.io.a
                java.lang.String r1 = "GLProfiler"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Error "
                r2.append(r3)
                java.lang.String r6 = defpackage.nw.a(r6)
                r2.append(r6)
                java.lang.String r6 = " at: "
                r2.append(r6)
                java.lang.String r6 = r2.toString()
                java.lang.Exception r2 = new java.lang.Exception
                r2.<init>()
                r0.error(r1, r6, r2)
            L77:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.nv.AnonymousClass1.a(int):void");
        }
    };
    public static final nv b = new nv() { // from class: nv.2
        @Override // defpackage.nv
        public void a(int i) {
            throw new k("GLProfiler: Got GL error " + nw.a(i));
        }
    };

    void a(int i);
}
