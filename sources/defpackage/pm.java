package defpackage;

import defpackage.pi;
/* compiled from: Slider.java */
/* renamed from: pm  reason: default package */
/* loaded from: classes.dex */
public class pm extends pi {
    int o;
    boolean p;

    /* compiled from: Slider.java */
    /* renamed from: pm$a */
    /* loaded from: classes.dex */
    public static class a extends pi.a {
        public qf i;
        public qf j;
    }

    @Override // defpackage.pi
    /* renamed from: H */
    public a C() {
        return (a) super.C();
    }

    @Override // defpackage.pi
    protected qf G() {
        a C = C();
        return (!this.n || C.d == null) ? (!K() || C.j == null) ? (!this.p || C.i == null) ? C.c : C.i : C.j : C.d;
    }

    public boolean K() {
        return this.o != -1;
    }
}
