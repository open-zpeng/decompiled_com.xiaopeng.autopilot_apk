package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.google.protobuf.CodedOutputStream;
import defpackage.wh;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: BlockHandler.java */
/* renamed from: wg  reason: default package */
/* loaded from: classes.dex */
public class wg {
    private static ExecutorService f = Executors.newFixedThreadPool(1);
    private Context a;
    private wi b;
    private wh.b c;
    private StringBuilder d = new StringBuilder((int) CodedOutputStream.DEFAULT_BUFFER_SIZE);
    private List<String> e = new ArrayList();

    public wg(Context context, wi wiVar, wh.b bVar) {
        this.a = context;
        this.b = wiVar;
        this.c = bVar;
    }

    public void a(boolean z, long... jArr) {
        if (this.c == null || Debug.isDebuggerConnected()) {
            return;
        }
        f.execute(a(this.b.e(), this.b.d(), z, jArr));
    }

    private Runnable a(final StackTraceElement[][] stackTraceElementArr, final int[] iArr, final boolean z, final long... jArr) {
        return new Runnable() { // from class: wg.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z2 = !TextUtils.isEmpty(z ? wg.this.c() : "");
                wg.this.e.clear();
                StackTraceElement[][] stackTraceElementArr2 = stackTraceElementArr;
                if (stackTraceElementArr2 != null && stackTraceElementArr2.length > 0) {
                    int i = 0;
                    for (StackTraceElement[] stackTraceElementArr3 : stackTraceElementArr2) {
                        if (stackTraceElementArr3 != null && stackTraceElementArr3.length > 0) {
                            if (wg.this.d.length() > 0) {
                                wg.this.d.delete(0, wg.this.d.length());
                            }
                            StringBuilder sb = wg.this.d;
                            sb.append("-----");
                            sb.append("main");
                            sb.append(" repeat ");
                            sb.append(iArr[i]);
                            sb.append("\n");
                            for (StackTraceElement stackTraceElement : stackTraceElementArr3) {
                                StringBuilder sb2 = wg.this.d;
                                sb2.append("\tat ");
                                sb2.append(stackTraceElement.toString());
                                sb2.append("\n");
                            }
                        }
                        wg.this.e.add(wg.this.d.toString());
                        i++;
                    }
                }
                String[] strArr = (String[]) wg.this.e.toArray(new String[0]);
                if (strArr.length == 0) {
                    return;
                }
                wg.this.c.a(strArr, z2, jArr);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) this.a.getSystemService("activity")).getProcessesInErrorState();
        if (processesInErrorState != null) {
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.condition == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(processErrorStateInfo.processName);
                    sb.append("\n");
                    sb.append(processErrorStateInfo.shortMsg);
                    sb.append("\n");
                    sb.append(processErrorStateInfo.longMsg);
                    wj.a("BlockHandler", sb.toString());
                    return sb.toString();
                }
            }
            return "";
        }
        return "";
    }

    public void a() {
        this.b.b();
    }

    public void b() {
        this.b.c();
    }
}
