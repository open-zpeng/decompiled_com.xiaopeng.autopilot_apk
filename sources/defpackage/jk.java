package defpackage;
/* compiled from: MusicLoader.java */
/* renamed from: jk  reason: default package */
/* loaded from: classes.dex */
public class jk extends je<jw, a> {
    private jw a;

    /* compiled from: MusicLoader.java */
    /* renamed from: jk$a */
    /* loaded from: classes.dex */
    public static class a extends iz<jw> {
    }

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        return null;
    }

    public jk(jh jhVar) {
        super(jhVar);
    }

    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, a aVar) {
        this.a = io.c.newMusic(jyVar);
    }

    @Override // defpackage.je
    public jw b(jb jbVar, String str, jy jyVar, a aVar) {
        jw jwVar = this.a;
        this.a = null;
        return jwVar;
    }
}
