package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/* compiled from: TiledDrawable.java */
/* renamed from: qn  reason: default package */
/* loaded from: classes.dex */
public class qn extends qm {
    private static final ka a = new ka();
    private final ka b;

    public qn() {
        this.b = new ka(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public qn(qm qmVar) {
        super(qmVar);
        this.b = new ka(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override // defpackage.qm, defpackage.qb, defpackage.qf
    public void a(Batch batch, float f, float f2, float f3, float f4) {
        float f5;
        ka color = batch.getColor();
        a.a(color);
        batch.setColor(color.b(this.b));
        TextureRegion h = h();
        float regionWidth = h.getRegionWidth();
        float regionHeight = h.getRegionHeight();
        int i = (int) (f3 / regionWidth);
        int i2 = (int) (f4 / regionHeight);
        float f6 = f3 - (i * regionWidth);
        float f7 = f4 - (i2 * regionHeight);
        float f8 = f;
        float f9 = f2;
        int i3 = 0;
        while (i3 < i) {
            float f10 = f2;
            for (int i4 = 0; i4 < i2; i4++) {
                batch.draw(h, f8, f10, regionWidth, regionHeight);
                f10 += regionHeight;
            }
            f8 += regionWidth;
            i3++;
            f9 = f10;
        }
        ko texture = h.getTexture();
        float u = h.getU();
        float v2 = h.getV2();
        if (f6 > 0.0f) {
            float width = u + (f6 / texture.getWidth());
            float v = h.getV();
            f5 = f2;
            int i5 = 0;
            while (i5 < i2) {
                batch.draw(texture, f8, f5, f6, regionHeight, u, v2, width, v);
                f5 += regionHeight;
                i5++;
                i2 = i2;
            }
            if (f7 > 0.0f) {
                batch.draw(texture, f8, f5, f6, f7, u, v2, width, v2 - (f7 / texture.getHeight()));
            }
        } else {
            f5 = f9;
        }
        if (f7 > 0.0f) {
            float u2 = h.getU2();
            float height = v2 - (f7 / texture.getHeight());
            float f11 = f;
            for (int i6 = 0; i6 < i; i6++) {
                batch.draw(texture, f11, f5, regionWidth, f7, u, v2, u2, height);
                f11 += regionWidth;
            }
        }
        batch.setColor(a);
    }

    @Override // defpackage.qm, defpackage.qo
    public void a(Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.qm
    /* renamed from: b */
    public qn a(ka kaVar) {
        qn qnVar = new qn(this);
        qnVar.b.a(kaVar);
        qnVar.a(a());
        qnVar.b(b());
        qnVar.c(c());
        qnVar.d(d());
        return qnVar;
    }
}
