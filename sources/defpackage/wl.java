package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
/* compiled from: UILooperObserver.java */
/* renamed from: wl  reason: default package */
/* loaded from: classes.dex */
public class wl implements Printer {
    private long a = 0;
    private long b = 0;
    private wg c;

    public wl(wg wgVar) {
        this.c = wgVar;
        a();
    }

    private void a() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: wl.1
            /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x007e A[Catch: InvocationTargetException -> 0x009b, IllegalAccessException -> 0x00a7, TryCatch #9 {IllegalAccessException -> 0x00a7, InvocationTargetException -> 0x009b, blocks: (B:37:0x0073, B:40:0x007e, B:42:0x008c, B:44:0x0095, B:43:0x0092), top: B:53:0x0073 }] */
            /* JADX WARN: Removed duplicated region for block: B:61:0x007d A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r9 = this;
                    android.os.Looper r0 = android.os.Looper.getMainLooper()
                    r1 = 0
                    r2 = 1
                    r3 = 0
                    java.lang.Class r4 = r0.getClass()     // Catch: java.lang.IllegalAccessException -> L39 java.lang.NoSuchMethodException -> L40 java.lang.NoSuchFieldException -> L47
                    java.lang.String r5 = "mQueue"
                    java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch: java.lang.IllegalAccessException -> L39 java.lang.NoSuchMethodException -> L40 java.lang.NoSuchFieldException -> L47
                    r4.setAccessible(r2)     // Catch: java.lang.IllegalAccessException -> L39 java.lang.NoSuchMethodException -> L40 java.lang.NoSuchFieldException -> L47
                    java.lang.Object r0 = r4.get(r0)     // Catch: java.lang.IllegalAccessException -> L39 java.lang.NoSuchMethodException -> L40 java.lang.NoSuchFieldException -> L47
                    android.os.MessageQueue r0 = (android.os.MessageQueue) r0     // Catch: java.lang.IllegalAccessException -> L39 java.lang.NoSuchMethodException -> L40 java.lang.NoSuchFieldException -> L47
                    java.lang.Class r4 = r0.getClass()     // Catch: java.lang.IllegalAccessException -> L30 java.lang.NoSuchMethodException -> L33 java.lang.NoSuchFieldException -> L36
                    java.lang.String r5 = "next"
                    java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch: java.lang.IllegalAccessException -> L30 java.lang.NoSuchMethodException -> L33 java.lang.NoSuchFieldException -> L36
                    java.lang.reflect.Method r4 = r4.getDeclaredMethod(r5, r6)     // Catch: java.lang.IllegalAccessException -> L30 java.lang.NoSuchMethodException -> L33 java.lang.NoSuchFieldException -> L36
                    r4.setAccessible(r2)     // Catch: java.lang.IllegalAccessException -> L2a java.lang.NoSuchMethodException -> L2c java.lang.NoSuchFieldException -> L2e
                    goto L4d
                L2a:
                    r5 = move-exception
                    goto L3c
                L2c:
                    r5 = move-exception
                    goto L43
                L2e:
                    r5 = move-exception
                    goto L4a
                L30:
                    r5 = move-exception
                    r4 = r1
                    goto L3c
                L33:
                    r5 = move-exception
                    r4 = r1
                    goto L43
                L36:
                    r5 = move-exception
                    r4 = r1
                    goto L4a
                L39:
                    r5 = move-exception
                    r0 = r1
                    r4 = r0
                L3c:
                    r5.printStackTrace()
                    goto L4d
                L40:
                    r5 = move-exception
                    r0 = r1
                    r4 = r0
                L43:
                    r5.printStackTrace()
                    goto L4d
                L47:
                    r5 = move-exception
                    r0 = r1
                    r4 = r0
                L4a:
                    r5.printStackTrace()
                L4d:
                    android.os.Binder.clearCallingIdentity()
                    int r5 = android.os.Build.VERSION.SDK_INT
                    r6 = 21
                    if (r5 < r6) goto L72
                    android.os.Message r5 = android.os.Message.obtain()
                    java.lang.Class r6 = r5.getClass()     // Catch: java.lang.NoSuchMethodException -> L67
                    java.lang.String r7 = "recycleUnchecked"
                    java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch: java.lang.NoSuchMethodException -> L67
                    java.lang.reflect.Method r1 = r6.getDeclaredMethod(r7, r8)     // Catch: java.lang.NoSuchMethodException -> L67
                    goto L6b
                L67:
                    r6 = move-exception
                    r6.printStackTrace()
                L6b:
                    r1.setAccessible(r2)
                    r5.recycle()
                    goto L73
                L72:
                    r2 = r3
                L73:
                    java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    java.lang.Object r5 = r4.invoke(r0, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    android.os.Message r5 = (android.os.Message) r5     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    if (r5 != 0) goto L7e
                    return
                L7e:
                    wl r6 = defpackage.wl.this     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    defpackage.wl.a(r6)     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    android.os.Handler r6 = r5.getTarget()     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    r6.dispatchMessage(r5)     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    if (r2 == 0) goto L92
                    java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    r1.invoke(r5, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    goto L95
                L92:
                    r5.recycle()     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                L95:
                    wl r5 = defpackage.wl.this     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    defpackage.wl.b(r5)     // Catch: java.lang.reflect.InvocationTargetException -> L9b java.lang.IllegalAccessException -> La7
                    goto L73
                L9b:
                    r0 = move-exception
                    r0.printStackTrace()
                    java.lang.String r0 = "UILooperObserver"
                    java.lang.String r1 = "lib_Bughunter InvocationTargetException"
                    android.util.Log.e(r0, r1)
                    goto Lb2
                La7:
                    r0 = move-exception
                    r0.printStackTrace()
                    java.lang.String r0 = "UILooperObserver"
                    java.lang.String r1 = "lib_Bughunter IllegalAccessException"
                    android.util.Log.e(r0, r1)
                Lb2:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.wl.AnonymousClass1.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.a = SystemClock.uptimeMillis();
        this.b = SystemClock.currentThreadTimeMillis();
        this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.a;
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - this.b;
            this.c.b();
            if (uptimeMillis > wj.a) {
                this.c.a(uptimeMillis >= 5000, uptimeMillis, currentThreadTimeMillis);
            }
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (str.startsWith(">>>>> Dispatching to")) {
            b();
        } else if (str.startsWith("<<<<< Finished to")) {
            c();
        }
    }
}
