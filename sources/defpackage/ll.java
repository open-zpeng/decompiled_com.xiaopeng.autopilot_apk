package defpackage;

import com.badlogic.gdx.utils.a;
import java.util.Iterator;
/* compiled from: PointLightsAttribute.java */
/* renamed from: ll  reason: default package */
/* loaded from: classes.dex */
public class ll extends ku {
    public static final long b = b("pointLights");
    public final a<lr> c;

    public ll() {
        super(b);
        this.c = new a<>(1);
    }

    public ll(ll llVar) {
        this();
        this.c.a(llVar.c);
    }

    @Override // defpackage.ku
    /* renamed from: b */
    public ll a() {
        return new ll(this);
    }

    @Override // defpackage.ku
    public int hashCode() {
        int hashCode = super.hashCode();
        Iterator<lr> it = this.c.iterator();
        while (it.hasNext()) {
            lr next = it.next();
            hashCode = (hashCode * 1231) + (next == null ? 0 : next.hashCode());
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
