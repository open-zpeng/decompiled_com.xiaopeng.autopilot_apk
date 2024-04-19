package defpackage;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.UserHandle;
import com.xiaopeng.lib.utils.config.RemoteControlConfig;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import defpackage.wu;
import java.util.Random;
/* compiled from: ConnectManager.java */
/* renamed from: wn  reason: default package */
/* loaded from: classes.dex */
public class wn extends BroadcastReceiver implements ServiceConnection {
    private volatile wu b;
    private Context c;
    private xz e;
    private xy<a> d = new xy<>();
    private Runnable f = new Runnable() { // from class: wn.5
        @Override // java.lang.Runnable
        public void run() {
            wn.this.b();
        }
    };
    private Random a = new Random();

    /* compiled from: ConnectManager.java */
    /* renamed from: wn$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(wu wuVar);
    }

    public wn(Context context) {
        this.c = context;
    }

    public void a(xz xzVar) {
        this.a = new Random();
        this.e = xzVar;
    }

    public void a() {
        if (this.c == null) {
            return;
        }
        xx.b("ConnectManager", "registerReceiver");
        this.c.registerReceiver(this, new IntentFilter("carspeechservice.SpeechServer.Start"));
    }

    public void b() {
        this.e.a(new Runnable() { // from class: wn.1
            @Override // java.lang.Runnable
            public void run() {
                xx.a("connect ");
                if (wn.this.b != null) {
                    xx.a("connected,return");
                    return;
                }
                Intent intent = new Intent("carspeechservice.SpeechServer");
                intent.setPackage(IpcConfig.App.SPEECH_PACKAGE);
                wn.this.c.bindServiceAsUser(intent, wn.this, 1, UserHandle.CURRENT);
            }
        });
    }

    public void a(a aVar) {
        this.d.a(aVar);
    }

    private void a(IBinder iBinder) {
        xx.a("queryBinder");
        this.b = wu.a.a(iBinder);
        if (this.b == null) {
            xx.b("mSpeechEngine == null");
        } else {
            this.e.a(new Runnable() { // from class: wn.2
                @Override // java.lang.Runnable
                public void run() {
                    Object[] a2 = wn.this.d.a();
                    if (a2 != null) {
                        for (Object obj : a2) {
                            if (wn.this.b != null) {
                                ((a) obj).a(wn.this.b);
                            }
                        }
                    }
                    ze.c().a();
                }
            });
        }
    }

    private void c() {
        xx.b("SpeechProxy binderDied");
        this.b = null;
        this.e.a(new Runnable() { // from class: wn.3
            @Override // java.lang.Runnable
            public void run() {
                Object[] a2 = wn.this.d.a();
                if (a2 != null) {
                    for (Object obj : a2) {
                        ((a) obj).a();
                    }
                }
                ze.c().b();
                wn.this.d();
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        c();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("carspeechservice.SpeechServer.Start")) {
            xx.a("onReceive SPEECH_SERVER_ACTION_START");
            if (this.b == null) {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.e.a(new Runnable() { // from class: wn.4
            @Override // java.lang.Runnable
            public void run() {
                long a2 = wn.this.a(1500, RemoteControlConfig.SERVICE_TYPE_TRANSPORT_MODE_BEGIN);
                wn.this.e.removeCallbacks(wn.this.f);
                wn.this.e.postDelayed(wn.this.f, a2);
                xx.b(this, "reconnect delay:%d", Long.valueOf(a2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(int i, int i2) {
        return i >= i2 ? i : (int) ((this.a.nextFloat() * (i2 - i)) + i);
    }
}
