package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.util.Arrays;
import java.util.List;
/* compiled from: StatMqttDelegate.java */
/* renamed from: vt  reason: default package */
/* loaded from: classes.dex */
public class vt extends vq implements Handler.Callback {
    private Handler b;

    public vt(Context context) {
        super(context);
        vr.a().a(context);
        HandlerThread handlerThread = new HandlerThread("StatMqttDelegate", 10);
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper(), this);
    }

    @Override // defpackage.vq
    public void a(final IStatEvent iStatEvent) {
        ThreadUtils.post(0, new Runnable() { // from class: vt.1
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.d("StatMqttDelegate", "uploadCdu stat:" + iStatEvent.toString());
                vt.this.b(iStatEvent.toJson());
            }
        });
    }

    @Override // defpackage.vq
    public void a(final IMoleEvent iMoleEvent) {
        ThreadUtils.post(0, new Runnable() { // from class: vt.2
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.d("StatMqttDelegate", "uploadCdu mole:" + iMoleEvent.toString());
                vt.this.b(iMoleEvent.toJson());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (!vr.a().b()) {
            this.b.sendMessageDelayed(Message.obtain(this.b, 2, str), 1000L);
            return;
        }
        this.b.sendMessage(Message.obtain(this.b, 2, str));
    }

    @Override // defpackage.vq
    public void a(String str) {
        if (!vr.a().b()) {
            this.b.sendMessageDelayed(Message.obtain(this.b, 1, str), 1000L);
            return;
        }
        this.b.sendMessage(Message.obtain(this.b, 1, str));
    }

    @Override // defpackage.vq
    public void a(String str, String str2) {
        List asList = Arrays.asList(str, str2);
        if (!vr.a().b()) {
            this.b.sendMessageDelayed(Message.obtain(this.b, 3, asList), 1000L);
        } else {
            this.b.sendMessage(Message.obtain(this.b, 3, asList));
        }
    }

    @Override // defpackage.vq
    public void b(String str, String str2) {
        List asList = Arrays.asList(str, str2);
        if (!vr.a().b()) {
            this.b.sendMessageDelayed(Message.obtain(this.b, 6, asList), 1000L);
        } else {
            this.b.sendMessage(Message.obtain(this.b, 6, asList));
        }
    }

    @Override // defpackage.vq
    public void a(IStatEvent iStatEvent, List<String> list) {
        a aVar = new a((vl) iStatEvent, list);
        if (!vr.a().b()) {
            this.b.sendMessageDelayed(Message.obtain(this.b, 4, aVar), 1000L);
            return;
        }
        this.b.sendMessage(Message.obtain(this.b, 4, aVar));
    }

    @Override // defpackage.vq
    public void a(List<String> list) {
        if (!vr.a().b()) {
            this.b.sendMessageDelayed(Message.obtain(this.b, 5, list), 1000L);
            return;
        }
        this.b.sendMessage(Message.obtain(this.b, 5, list));
    }

    @Override // defpackage.vq
    public String a() {
        return vr.a().c();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                vr.a().b((String) message.obj);
                break;
            case 2:
                vr.a().a((String) message.obj);
                break;
            case 3:
                List list = (List) message.obj;
                vr.a().b((String) list.get(0), (String) list.get(1));
                break;
            case 4:
                a aVar = (a) message.obj;
                vr.a().a(aVar.a, aVar.b);
                break;
            case 5:
                vr.a().a((List) message.obj);
                break;
            case 6:
                List list2 = (List) message.obj;
                vr.a().a((String) list2.get(0), (String) list2.get(1));
                break;
        }
        return true;
    }

    /* compiled from: StatMqttDelegate.java */
    /* renamed from: vt$a */
    /* loaded from: classes.dex */
    private class a {
        vl a;
        List<String> b;

        public a(vl vlVar, List<String> list) {
            this.a = vlVar;
            this.b = list;
        }
    }
}
