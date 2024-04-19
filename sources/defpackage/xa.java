package defpackage;

import android.os.Handler;
import com.xiaopeng.speech.annotation.ICommandProcessor;
import defpackage.yd;
/* compiled from: SpeechNode.java */
/* renamed from: xa  reason: default package */
/* loaded from: classes.dex */
public abstract class xa<T> extends yd.a {
    protected Handler c;
    private boolean d = false;
    protected xy<T> b = new xy<>();
    protected ICommandProcessor a = a((yd) this);

    protected void b() {
    }

    protected void c() {
    }

    public void a(boolean z) {
        this.d = z;
        if (this.d) {
            b();
        } else {
            c();
        }
    }

    public boolean a() {
        return this.d;
    }

    public void a(Handler handler) {
        this.c = handler;
    }

    public void a(T t) {
        this.b.a(t);
    }

    @Override // defpackage.yd
    public void a(final String str, final String str2) {
        if (this.a != null) {
            Handler handler = this.c;
            if (handler != null) {
                handler.post(new Runnable() { // from class: xa.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xa.this.b(str, str2);
                    }
                });
            } else {
                b(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        if (!"jarvis.dm.listening".equals(str) && !"jarvis.dm.wait".equals(str)) {
            xx.b(this, "performCommand, command = " + str + ", data = " + str2);
        }
        try {
            this.a.a(str, str2);
        } catch (Exception e) {
            xx.a(this, "performCommand error ", e);
        }
    }

    public String[] d() {
        ICommandProcessor iCommandProcessor = this.a;
        if (iCommandProcessor != null) {
            return iCommandProcessor.a();
        }
        return null;
    }

    private ICommandProcessor a(yd ydVar) {
        String str = ydVar.getClass().getName() + "_Processor";
        try {
            return (ICommandProcessor) Class.forName(str).getConstructor(ydVar.getClass()).newInstance(ydVar);
        } catch (Exception e) {
            e.printStackTrace();
            xx.a(this, String.format("bind %s error", str), e);
            return null;
        }
    }
}
