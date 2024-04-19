package defpackage;

import com.xiaopeng.speech.annotation.IQueryProcessor;
import defpackage.ws;
/* compiled from: SpeechQuery.java */
/* renamed from: xb  reason: default package */
/* loaded from: classes.dex */
public abstract class xb<T> extends ws.a {
    private boolean b = false;
    protected IQueryProcessor a = a((ws) this);

    protected void b() {
    }

    protected void c() {
    }

    public void a(boolean z) {
        this.b = z;
        if (this.b) {
            b();
        } else {
            c();
        }
    }

    public boolean a() {
        return this.b;
    }

    @Override // defpackage.ws
    public xu a(String str, String str2) {
        xu xuVar = xu.a;
        if (this.a != null) {
            xu b = b(str, str2);
            xx.b("SpeechQuery", "dataApi = " + str + ",param data =" + str2 + ", query result value = " + b.toString());
            return b;
        }
        return xuVar;
    }

    private xu b(String str, String str2) {
        try {
            return new xu(this.a.a(str, str2));
        } catch (Exception e) {
            xx.a(this, "performCommand error ", e);
            return xu.a;
        }
    }

    public String[] d() {
        IQueryProcessor iQueryProcessor = this.a;
        if (iQueryProcessor != null) {
            return iQueryProcessor.a();
        }
        return null;
    }

    private IQueryProcessor a(ws wsVar) {
        String str = wsVar.getClass().getName() + "_Processor";
        try {
            return (IQueryProcessor) Class.forName(str).getConstructor(wsVar.getClass()).newInstance(wsVar);
        } catch (Exception e) {
            e.printStackTrace();
            xx.a(this, String.format("bind %s error", str), e);
            return null;
        }
    }
}
