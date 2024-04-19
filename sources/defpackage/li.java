package defpackage;

import com.badlogic.gdx.utils.a;
import java.util.Iterator;
/* compiled from: DirectionalLightsAttribute.java */
/* renamed from: li  reason: default package */
/* loaded from: classes.dex */
public class li extends ku {
    public static final long b = b("directionalLights");
    public final a<lq> c;

    public li() {
        super(b);
        this.c = new a<>(1);
    }

    public li(li liVar) {
        this();
        this.c.a(liVar.c);
    }

    @Override // defpackage.ku
    /* renamed from: b */
    public li a() {
        return new li(this);
    }

    @Override // defpackage.ku
    public int hashCode() {
        int hashCode = super.hashCode();
        Iterator<lq> it = this.c.iterator();
        while (it.hasNext()) {
            lq next = it.next();
            hashCode = (hashCode * 1229) + (next == null ? 0 : next.hashCode());
        }
        return hashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ku kuVar) {
        if (this.a != kuVar.a) {
            return this.a < kuVar.a ? -1 : 1;
        }
        return 0;
    }
}
