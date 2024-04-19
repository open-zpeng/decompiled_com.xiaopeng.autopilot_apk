package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
/* compiled from: NinePatchDrawable.java */
/* renamed from: qi  reason: default package */
/* loaded from: classes.dex */
public class qi extends qb implements qo {
    private NinePatch a;

    public qi() {
    }

    public qi(NinePatch ninePatch) {
        a(ninePatch);
    }

    public qi(qi qiVar) {
        super(qiVar);
        this.a = qiVar.a;
    }

    @Override // defpackage.qb, defpackage.qf
    public void a(Batch batch, float f, float f2, float f3, float f4) {
        this.a.draw(batch, f, f2, f3, f4);
    }

    @Override // defpackage.qo
    public void a(Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.a.draw(batch, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    public void a(NinePatch ninePatch) {
        this.a = ninePatch;
        e(ninePatch.getTotalWidth());
        f(ninePatch.getTotalHeight());
        c(ninePatch.getPadTop());
        b(ninePatch.getPadRight());
        d(ninePatch.getPadBottom());
        a(ninePatch.getPadLeft());
    }

    public NinePatch h() {
        return this.a;
    }

    public qi a(ka kaVar) {
        qi qiVar = new qi(this);
        qiVar.a = new NinePatch(qiVar.h(), kaVar);
        return qiVar;
    }
}
