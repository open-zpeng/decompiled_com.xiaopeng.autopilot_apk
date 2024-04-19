package defpackage;

import com.badlogic.gdx.utils.a;
import java.util.Iterator;
/* compiled from: SpotLightsAttribute.java */
/* renamed from: lm  reason: default package */
/* loaded from: classes.dex */
public class lm extends ku {
    public static final long b = b("spotLights");
    public final a<lt> c;

    public lm() {
        super(b);
        this.c = new a<>(1);
    }

    public lm(lm lmVar) {
        this();
        this.c.a(lmVar.c);
    }

    @Override // defpackage.ku
    /* renamed from: b */
    public lm a() {
        return new lm(this);
    }

    @Override // defpackage.ku
    public int hashCode() {
        int hashCode = super.hashCode();
        Iterator<lt> it = this.c.iterator();
        while (it.hasNext()) {
            lt next = it.next();
            hashCode = (hashCode * 1237) + (next == null ? 0 : next.hashCode());
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
