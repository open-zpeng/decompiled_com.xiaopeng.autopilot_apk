package defpackage;
/* compiled from: PixmapLoader.java */
/* renamed from: jm  reason: default package */
/* loaded from: classes.dex */
public class jm extends je<km, a> {
    km a;

    /* compiled from: PixmapLoader.java */
    /* renamed from: jm$a */
    /* loaded from: classes.dex */
    public static class a extends iz<km> {
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        return null;
    }

    public jm(jh jhVar) {
        super(jhVar);
    }

    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, a aVar) {
        this.a = null;
        this.a = new km(jyVar);
    }

    @Override // defpackage.je
    public km b(jb jbVar, String str, jy jyVar, a aVar) {
        km kmVar = this.a;
        this.a = null;
        return kmVar;
    }
}
