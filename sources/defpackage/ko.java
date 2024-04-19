package defpackage;

import com.badlogic.gdx.graphics.glutils.p;
import com.badlogic.gdx.utils.k;
import defpackage.iz;
import defpackage.js;
import defpackage.km;
import defpackage.kr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* compiled from: Texture.java */
/* renamed from: ko  reason: default package */
/* loaded from: classes.dex */
public class ko extends ki {
    private static jb assetManager;
    static final Map<ij, com.badlogic.gdx.utils.a<ko>> managedTextures = new HashMap();
    kr data;

    @Override // defpackage.ki
    public int getDepth() {
        return 0;
    }

    /* compiled from: Texture.java */
    /* renamed from: ko$a */
    /* loaded from: classes.dex */
    public enum a {
        Nearest(9728),
        Linear(9729),
        MipMap(9987),
        MipMapNearestNearest(9984),
        MipMapLinearNearest(9985),
        MipMapNearestLinear(9986),
        MipMapLinearLinear(9987);
        
        final int a;

        a(int i) {
            this.a = i;
        }

        public boolean isMipMap() {
            int i = this.a;
            return (i == 9728 || i == 9729) ? false : true;
        }

        public int getGLEnum() {
            return this.a;
        }
    }

    /* compiled from: Texture.java */
    /* renamed from: ko$b */
    /* loaded from: classes.dex */
    public enum b {
        MirroredRepeat(33648),
        ClampToEdge(33071),
        Repeat(10497);
        
        final int a;

        b(int i) {
            this.a = i;
        }

        public int getGLEnum() {
            return this.a;
        }
    }

    public ko(String str) {
        this(io.e.internal(str));
    }

    public ko(jy jyVar) {
        this(jyVar, (km.c) null, false);
    }

    public ko(jy jyVar, boolean z) {
        this(jyVar, (km.c) null, z);
    }

    public ko(jy jyVar, km.c cVar, boolean z) {
        this(kr.a.a(jyVar, cVar, z));
    }

    public ko(km kmVar) {
        this(new p(kmVar, null, false, false));
    }

    public ko(km kmVar, boolean z) {
        this(new p(kmVar, null, z, false));
    }

    public ko(km kmVar, km.c cVar, boolean z) {
        this(new p(kmVar, cVar, z, false));
    }

    public ko(int i, int i2, km.c cVar) {
        this(new p(new km(i, i2, cVar), null, false, true));
    }

    public ko(kr krVar) {
        this(3553, io.g.glGenTexture(), krVar);
    }

    protected ko(int i, int i2, kr krVar) {
        super(i, i2);
        load(krVar);
        if (krVar.f()) {
            addManagedTexture(io.a, this);
        }
    }

    public void load(kr krVar) {
        if (this.data != null && krVar.f() != this.data.f()) {
            throw new k("New data must have the same managed status as the old data");
        }
        this.data = krVar;
        if (!krVar.a()) {
            krVar.b();
        }
        bind();
        uploadImageData(3553, krVar);
        unsafeSetFilter(this.minFilter, this.magFilter, true);
        unsafeSetWrap(this.uWrap, this.vWrap, true);
        io.g.glBindTexture(this.glTarget, 0);
    }

    @Override // defpackage.ki
    protected void reload() {
        if (!isManaged()) {
            throw new k("Tried to reload unmanaged Texture");
        }
        this.glHandle = io.g.glGenTexture();
        load(this.data);
    }

    public void draw(km kmVar, int i, int i2) {
        if (this.data.f()) {
            throw new k("can't draw to a managed texture");
        }
        bind();
        io.g.glTexSubImage2D(this.glTarget, 0, i, i2, kmVar.b(), kmVar.c(), kmVar.d(), kmVar.f(), kmVar.g());
    }

    @Override // defpackage.ki
    public int getWidth() {
        return this.data.d();
    }

    @Override // defpackage.ki
    public int getHeight() {
        return this.data.e();
    }

    public kr getTextureData() {
        return this.data;
    }

    @Override // defpackage.ki
    public boolean isManaged() {
        return this.data.f();
    }

    @Override // defpackage.ki, com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        if (this.glHandle == 0) {
            return;
        }
        delete();
        if (!this.data.f() || managedTextures.get(io.a) == null) {
            return;
        }
        managedTextures.get(io.a).c(this, true);
    }

    public String toString() {
        kr krVar = this.data;
        return krVar instanceof com.badlogic.gdx.graphics.glutils.b ? krVar.toString() : super.toString();
    }

    private static void addManagedTexture(ij ijVar, ko koVar) {
        com.badlogic.gdx.utils.a<ko> aVar = managedTextures.get(ijVar);
        if (aVar == null) {
            aVar = new com.badlogic.gdx.utils.a<>();
        }
        aVar.a((com.badlogic.gdx.utils.a<ko>) koVar);
        managedTextures.put(ijVar, aVar);
    }

    public static void clearAllTextures(ij ijVar) {
        managedTextures.remove(ijVar);
    }

    public static void invalidateAllTextures(ij ijVar) {
        com.badlogic.gdx.utils.a<ko> aVar = managedTextures.get(ijVar);
        if (aVar == null) {
            return;
        }
        jb jbVar = assetManager;
        if (jbVar == null) {
            for (int i = 0; i < aVar.b; i++) {
                aVar.a(i).reload();
            }
            return;
        }
        jbVar.b();
        com.badlogic.gdx.utils.a<? extends ko> aVar2 = new com.badlogic.gdx.utils.a<>(aVar);
        Iterator<? extends ko> it = aVar2.iterator();
        while (it.hasNext()) {
            ko next = it.next();
            String a2 = assetManager.a((jb) next);
            if (a2 == null) {
                next.reload();
            } else {
                final int d = assetManager.d(a2);
                assetManager.a(a2, 0);
                next.glHandle = 0;
                js.b bVar = new js.b();
                bVar.d = next.getTextureData();
                bVar.e = next.getMinFilter();
                bVar.f = next.getMagFilter();
                bVar.g = next.getUWrap();
                bVar.h = next.getVWrap();
                bVar.b = next.data.k();
                bVar.c = next;
                bVar.loadedCallback = new iz.a() { // from class: ko.1
                    @Override // defpackage.iz.a
                    public void a(jb jbVar2, String str, Class cls) {
                        jbVar2.a(str, d);
                    }
                };
                assetManager.b(a2);
                next.glHandle = io.g.glGenTexture();
                assetManager.a(a2, ko.class, (iz) bVar);
            }
        }
        aVar.d();
        aVar.a(aVar2);
    }

    public static void setAssetManager(jb jbVar) {
        assetManager = jbVar;
    }

    public static String getManagedStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Managed textures/app: { ");
        for (ij ijVar : managedTextures.keySet()) {
            sb.append(managedTextures.get(ijVar).b);
            sb.append(" ");
        }
        sb.append("}");
        return sb.toString();
    }

    public static int getNumManagedTextures() {
        return managedTextures.get(io.a).b;
    }
}
