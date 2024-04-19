package defpackage;

import java.util.ArrayList;
/* compiled from: WidgetContainer.java */
/* renamed from: ch  reason: default package */
/* loaded from: classes.dex */
public class ch extends bz {
    public ArrayList<bz> aT = new ArrayList<>();

    @Override // defpackage.bz
    public void w() {
        this.aT.clear();
        super.w();
    }

    public void b(bz bzVar) {
        this.aT.add(bzVar);
        if (bzVar.A() != null) {
            ((ch) bzVar.A()).c(bzVar);
        }
        bzVar.a_(this);
    }

    public void c(bz bzVar) {
        this.aT.remove(bzVar);
        bzVar.w();
    }

    public ArrayList<bz> ah() {
        return this.aT;
    }

    public void ae() {
        ArrayList<bz> arrayList = this.aT;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bz bzVar = this.aT.get(i);
            if (bzVar instanceof ch) {
                ((ch) bzVar).ae();
            }
        }
    }

    @Override // defpackage.bz
    public void a(ay ayVar) {
        super.a(ayVar);
        int size = this.aT.size();
        for (int i = 0; i < size; i++) {
            this.aT.get(i).a(ayVar);
        }
    }

    public void ai() {
        this.aT.clear();
    }
}
