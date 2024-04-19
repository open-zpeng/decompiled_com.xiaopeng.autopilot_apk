package defpackage;
/* compiled from: IntAttribute.java */
/* renamed from: lk  reason: default package */
/* loaded from: classes.dex */
public class lk extends ku {
    public static final long b = b("cullface");
    public int c;

    public lk(long j, int i) {
        super(j);
        this.c = i;
    }

    @Override // defpackage.ku
    public ku a() {
        return new lk(this.a, this.c);
    }

    @Override // defpackage.ku
    public int hashCode() {
        return (super.hashCode() * 983) + this.c;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ku kuVar) {
        return this.a != kuVar.a ? (int) (this.a - kuVar.a) : this.c - ((lk) kuVar).c;
    }
}
