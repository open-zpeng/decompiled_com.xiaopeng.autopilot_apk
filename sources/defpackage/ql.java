package defpackage;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/* compiled from: SpriteDrawable.java */
/* renamed from: ql  reason: default package */
/* loaded from: classes.dex */
public class ql extends qb implements qo {
    private static final ka a = new ka();
    private Sprite b;

    public ql() {
    }

    public ql(Sprite sprite) {
        a(sprite);
    }

    @Override // defpackage.qb, defpackage.qf
    public void a(Batch batch, float f, float f2, float f3, float f4) {
        ka color = this.b.getColor();
        a.a(color);
        this.b.setColor(color.b(batch.getColor()));
        this.b.setRotation(0.0f);
        this.b.setScale(1.0f, 1.0f);
        this.b.setBounds(f, f2, f3, f4);
        this.b.draw(batch);
        this.b.setColor(a);
    }

    @Override // defpackage.qo
    public void a(Batch batch, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        ka color = this.b.getColor();
        a.a(color);
        this.b.setColor(color.b(batch.getColor()));
        this.b.setOrigin(f3, f4);
        this.b.setRotation(f9);
        this.b.setScale(f7, f8);
        this.b.setBounds(f, f2, f5, f6);
        this.b.draw(batch);
        this.b.setColor(a);
    }

    public void a(Sprite sprite) {
        this.b = sprite;
        e(sprite.getWidth());
        f(sprite.getHeight());
    }

    public ql a(ka kaVar) {
        Sprite sprite;
        Sprite sprite2 = this.b;
        if (sprite2 instanceof TextureAtlas.AtlasSprite) {
            sprite = new TextureAtlas.AtlasSprite((TextureAtlas.AtlasSprite) sprite2);
        } else {
            sprite = new Sprite(sprite2);
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
