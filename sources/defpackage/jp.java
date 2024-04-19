package defpackage;
/* compiled from: SoundLoader.java */
/* renamed from: jp  reason: default package */
/* loaded from: classes.dex */
public class jp extends je<jx, a> {
    private jx a;

    /* compiled from: SoundLoader.java */
    /* renamed from: jp$a */
    /* loaded from: classes.dex */
    public static class a extends iz<jx> {
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        return null;
    }

    public jp(jh jhVar) {
        super(jhVar);
    }

    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, a aVar) {
        this.a = io.c.newSound(jyVar);
    }

    @Override // defpackage.je
    public jx b(jb jbVar, String str, jy jyVar, a aVar) {
        jx jxVar = this.a;
        this.a = null;
        return jxVar;
    }
}
