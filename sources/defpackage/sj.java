package defpackage;
/* compiled from: DogEntity.java */
/* renamed from: sj  reason: default package */
/* loaded from: classes.dex */
public class sj extends sl {
    public sj() {
        this.J = "model/dog/dog.g3db";
        this.b = "mat_shadow_dog";
    }

    @Override // defpackage.sl
    public void a(float f) {
        ko f2;
        if (j()) {
            if (f == 1.0f) {
                f2 = Y.an().f("model/dog/dog_map_red.jpg");
            } else {
                f2 = Y.an().f("model/dog/dog_map.jpg");
            }
            this.L.b("mat_dog").a(ln.a(f2));
        }
    }
}
