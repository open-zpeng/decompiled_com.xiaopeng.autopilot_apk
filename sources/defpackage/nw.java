package defpackage;

import com.badlogic.gdx.math.d;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
/* compiled from: GLInterceptor.java */
/* renamed from: nw  reason: default package */
/* loaded from: classes.dex */
public abstract class nw implements kg {
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected final d f = new d(0);
    protected nx g;

    /* JADX INFO: Access modifiers changed from: protected */
    public nw(nx nxVar) {
        this.g = nxVar;
    }

    public static String a(int i) {
        switch (i) {
            case 1280:
                return "GL_INVALID_ENUM";
            case StorageException.REASON_DOWNLOAD_ERROR /* 1281 */:
                return "GL_INVALID_VALUE";
            case StorageException.REASON_DOWNLOAD_INCOMPLETE /* 1282 */:
                return "GL_INVALID_OPERATION";
            case 1283:
            case 1284:
            default:
                return "number " + i;
            case 1285:
                return "GL_OUT_OF_MEMORY";
            case 1286:
                return "GL_INVALID_FRAMEBUFFER_OPERATION";
        }
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public d e() {
        return this.f;
    }

    public void f() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f.a();
    }
}
