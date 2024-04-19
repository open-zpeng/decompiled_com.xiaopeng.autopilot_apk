package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/* compiled from: TextureRegionDrawable.java */
/* renamed from: qm  reason: default package */
/* loaded from: classes.dex */
public class qm extends qb implements qo {
    private TextureRegion a;

    public qm() {
    }

    public qm(TextureRegion textureRegion) {
        a(textureRegion);
    }

    public qm(qm qmVar) {
        super(qmVar);
        a(qmVar.a);
    }

    @Override // defpackage.qb, defpackage.qf
    public void a(Batch batch, float f, float f2, float f3, float f4) {
        batch.draw(this.a, f, f2, f3, f4);
    }

    @Override // defpackage.qo
    public void a(Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        batch.draw(this.a, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    public void a(TextureRegion textureRegion) {
        this.a = textureRegion;
        if (textureRegion != null) {
            e(textureRegion.getRegionWidth());
            f(textureRegion.getRegionHeight());
        }
    }

    public TextureRegion h() {
        return this.a;
    }

    public qf a(ka kaVar) {
        Sprite sprite;
        TextureRegion textureRegion = this.a;
        if (textureRegion instanceof TextureAtlas.AtlasRegion) {
            sprite = new TextureAtlas.AtlasSprite((TextureAtlas.AtlasRegion) textureRegion);
        } else {
            sprite = new Sprite(textureRegion);
        }
        sprite.setColor(kaVar);
        sprite.setSize(e(), f());
        ql qlVar = new ql(sprite);
        qlVar.a(a());
        qlVar.b(b());
        qlVar.c(c());
        qlVar.d(d());
        return qlVar;
    }
}
