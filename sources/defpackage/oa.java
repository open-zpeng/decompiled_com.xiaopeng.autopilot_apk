package defpackage;

import com.badlogic.gdx.math.p;
import java.io.Serializable;
/* compiled from: Ray.java */
/* renamed from: oa  reason: default package */
/* loaded from: classes.dex */
public class oa implements Serializable {
    static p c = new p();
    private static final long serialVersionUID = -620692054835390878L;
    public final p a = new p();
    public final p b = new p();

    public oa() {
    }

    public oa(p pVar, p pVar2) {
        this.a.a(pVar);
        this.b.a(pVar2).d();
    }

    public String toString() {
        return "ray [" + this.a + ":" + this.b + "]";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        oa oaVar = (oa) obj;
        return this.b.equals(oaVar.b) && this.a.equals(oaVar.a);
    }

    public int hashCode() {
        return ((this.b.hashCode() + 73) * 73) + this.a.hashCode();
    }
}
