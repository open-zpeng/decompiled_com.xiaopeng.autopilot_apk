package defpackage;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.af;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.o;
import com.badlogic.gdx.utils.q;
import com.badlogic.gdx.utils.v;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import defpackage.oz;
import defpackage.pb;
import defpackage.pe;
import defpackage.pf;
import defpackage.pg;
import defpackage.ph;
import defpackage.pi;
import defpackage.pj;
import defpackage.pk;
import defpackage.pm;
import defpackage.pn;
import defpackage.pp;
import defpackage.pq;
import defpackage.pr;
import defpackage.pu;
import defpackage.pv;
import defpackage.pz;
/* compiled from: Skin.java */
/* renamed from: pl  reason: default package */
/* loaded from: classes.dex */
public class pl implements g {
    private static final Class[] d = {BitmapFont.class, ka.class, a.class, qi.class, ql.class, qm.class, qn.class, oz.a.class, pb.a.class, pe.a.class, pf.a.class, pg.a.class, ph.a.class, pi.a.class, pj.a.class, pk.b.class, pm.a.class, pn.a.class, pp.a.class, pq.b.class, pr.a.class, pu.a.class, pv.b.class, pz.a.class};
    TextureAtlas b;
    v<Class, v<String, Object>> a = new v<>();
    private final v<String, Class> c = new v<>(d.length);

    /* compiled from: Skin.java */
    /* renamed from: pl$a */
    /* loaded from: classes.dex */
    public static class a {
    }

    public pl() {
        Class[] clsArr;
        for (Class cls : d) {
            this.c.a((v<String, Class>) cls.getSimpleName(), (String) cls);
        }
    }

    public pl(TextureAtlas textureAtlas) {
        Class[] clsArr;
        for (Class cls : d) {
            this.c.a((v<String, Class>) cls.getSimpleName(), (String) cls);
        }
        this.b = textureAtlas;
        a(textureAtlas);
    }

    public void a(jy jyVar) {
        try {
            b(jyVar).a(pl.class, jyVar);
        } catch (af e) {
            throw new af("Error reading file: " + jyVar, e);
        }
    }

    public void a(TextureAtlas textureAtlas) {
        com.badlogic.gdx.utils.a<TextureAtlas.AtlasRegion> regions = textureAtlas.getRegions();
        int i = regions.b;
        for (int i2 = 0; i2 < i; i2++) {
            TextureAtlas.AtlasRegion a2 = regions.a(i2);
            String str = a2.name;
            if (a2.index != -1) {
                str = str + "_" + a2.index;
            }
            a(str, a2, TextureRegion.class);
        }
    }

    public void a(String str, Object obj) {
        a(str, obj, obj.getClass());
    }

    public void a(String str, Object obj, Class cls) {
        if (str == null) {
            throw new IllegalArgumentException("name cannot be null.");
        }
        if (obj == null) {
            throw new IllegalArgumentException("resource cannot be null.");
        }
        v<String, Object> a2 = this.a.a((v<Class, v<String, Object>>) cls);
        if (a2 == null) {
            a2 = new v<>((cls == TextureRegion.class || cls == qf.class || cls == Sprite.class) ? IRadioController.TEF663x_PCHANNEL : 64);
            this.a.a((v<Class, v<String, Object>>) cls, (Class) a2);
        }
        a2.a((v<String, Object>) str, (String) obj);
    }

    public <T> T a(String str, Class<T> cls) {
        if (str != null) {
            if (cls == null) {
                throw new IllegalArgumentException("type cannot be null.");
            }
            if (cls == qf.class) {
                return (T) e(str);
            }
            if (cls == TextureRegion.class) {
                return (T) a(str);
            }
            if (cls == NinePatch.class) {
                return (T) c(str);
            }
            if (cls == Sprite.class) {
                return (T) d(str);
            }
            v<String, Object> a2 = this.a.a((v<Class, v<String, Object>>) cls);
            if (a2 == null) {
                throw new k("No " + cls.getName() + " registered with name: " + str);
            }
            T t = (T) a2.a((v<String, Object>) str);
            if (t != null) {
                return t;
            }
            throw new k("No " + cls.getName() + " registered with name: " + str);
        }
        throw new IllegalArgumentException("name cannot be null.");
    }

    public <T> T b(String str, Class<T> cls) {
        if (str != null) {
            if (cls == null) {
                throw new IllegalArgumentException("type cannot be null.");
            }
            v<String, Object> a2 = this.a.a((v<Class, v<String, Object>>) cls);
            if (a2 == null) {
                return null;
            }
            return (T) a2.a((v<String, Object>) str);
        }
        throw new IllegalArgumentException("name cannot be null.");
    }

    public TextureRegion a(String str) {
        TextureRegion textureRegion = (TextureRegion) b(str, TextureRegion.class);
        if (textureRegion != null) {
            return textureRegion;
        }
        ko koVar = (ko) b(str, ko.class);
        if (koVar == null) {
            throw new k("No TextureRegion or Texture registered with name: " + str);
        }
        TextureRegion textureRegion2 = new TextureRegion(koVar);
        a(str, textureRegion2, TextureRegion.class);
        return textureRegion2;
    }

    public com.badlogic.gdx.utils.a<TextureRegion> b(String str) {
        TextureRegion textureRegion = (TextureRegion) b(str + "_0", TextureRegion.class);
        if (textureRegion != null) {
            com.badlogic.gdx.utils.a<TextureRegion> aVar = new com.badlogic.gdx.utils.a<>();
            int i = 1;
            while (textureRegion != null) {
                aVar.a((com.badlogic.gdx.utils.a<TextureRegion>) textureRegion);
                textureRegion = (TextureRegion) b(str + "_" + i, TextureRegion.class);
                i++;
            }
            return aVar;
        }
        return null;
    }

    public NinePatch c(String str) {
        int[] iArr;
        NinePatch ninePatch = (NinePatch) b(str, NinePatch.class);
        if (ninePatch != null) {
            return ninePatch;
        }
        try {
            TextureRegion a2 = a(str);
            if ((a2 instanceof TextureAtlas.AtlasRegion) && (iArr = ((TextureAtlas.AtlasRegion) a2).splits) != null) {
                ninePatch = new NinePatch(a2, iArr[0], iArr[1], iArr[2], iArr[3]);
                int[] iArr2 = ((TextureAtlas.AtlasRegion) a2).pads;
                if (iArr2 != null) {
                    ninePatch.setPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
                }
            }
            if (ninePatch == null) {
                ninePatch = new NinePatch(a2);
            }
            a(str, ninePatch, NinePatch.class);
            return ninePatch;
        } catch (k unused) {
            throw new k("No NinePatch, TextureRegion, or Texture registered with name: " + str);
        }
    }

    public Sprite d(String str) {
        Sprite sprite = (Sprite) b(str, Sprite.class);
        if (sprite != null) {
            return sprite;
        }
        try {
            TextureRegion a2 = a(str);
            if (a2 instanceof TextureAtlas.AtlasRegion) {
                TextureAtlas.AtlasRegion atlasRegion = (TextureAtlas.AtlasRegion) a2;
                if (atlasRegion.rotate || atlasRegion.packedWidth != atlasRegion.originalWidth || atlasRegion.packedHeight != atlasRegion.originalHeight) {
                    sprite = new TextureAtlas.AtlasSprite(atlasRegion);
                }
            }
            if (sprite == null) {
                sprite = new Sprite(a2);
            }
            a(str, sprite, Sprite.class);
            return sprite;
        } catch (k unused) {
            throw new k("No NinePatch, TextureRegion, or Texture registered with name: " + str);
        }
    }

    public qf e(String str) {
        qf qfVar;
        qf qfVar2 = (qf) b(str, qf.class);
        if (qfVar2 != null) {
            return qfVar2;
        }
        try {
            TextureRegion a2 = a(str);
            if (a2 instanceof TextureAtlas.AtlasRegion) {
                TextureAtlas.AtlasRegion atlasRegion = (TextureAtlas.AtlasRegion) a2;
                if (atlasRegion.splits != null) {
                    qfVar2 = new qi(c(str));
                } else if (atlasRegion.rotate || atlasRegion.packedWidth != atlasRegion.originalWidth || atlasRegion.packedHeight != atlasRegion.originalHeight) {
                    qfVar2 = new ql(d(str));
                }
            }
            if (qfVar2 == null) {
                qfVar2 = new qm(a2);
            }
        } catch (k unused) {
        }
        if (qfVar2 == null) {
            NinePatch ninePatch = (NinePatch) b(str, NinePatch.class);
            if (ninePatch != null) {
                qfVar = new qi(ninePatch);
            } else {
                Sprite sprite = (Sprite) b(str, Sprite.class);
                if (sprite != null) {
                    qfVar = new ql(sprite);
                } else {
                    throw new k("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                }
            }
        } else {
            qfVar = qfVar2;
        }
        if (qfVar instanceof qb) {
            ((qb) qfVar).a(str);
        }
        a(str, qfVar, qf.class);
        return qfVar;
    }

    public qf a(String str, ka kaVar) {
        return a(e(str), kaVar);
    }

    public qf a(qf qfVar, ka kaVar) {
        qf a2;
        if (qfVar instanceof qm) {
            a2 = ((qm) qfVar).a(kaVar);
        } else if (qfVar instanceof qi) {
            a2 = ((qi) qfVar).a(kaVar);
        } else if (qfVar instanceof ql) {
            a2 = ((ql) qfVar).a(kaVar);
        } else {
            throw new k("Unable to copy, unknown drawable type: " + qfVar.getClass());
        }
        if (a2 instanceof qb) {
            qb qbVar = (qb) a2;
            if (qfVar instanceof qb) {
                qbVar.a(((qb) qfVar).g() + " (" + kaVar + ")");
            } else {
                qbVar.a(" (" + kaVar + ")");
            }
        }
        return a2;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        TextureAtlas textureAtlas = this.b;
        if (textureAtlas != null) {
            textureAtlas.dispose();
        }
        v.e<v<String, Object>> it = this.a.d().iterator();
        while (it.hasNext()) {
            v.e<Object> it2 = it.next().d().iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (next instanceof g) {
                    ((g) next).dispose();
                }
            }
        }
    }

    protected o b(final jy jyVar) {
        o oVar = new o() { // from class: pl.1
            @Override // com.badlogic.gdx.utils.o
            public <T> T a(Class<T> cls, Class cls2, q qVar) {
                if (qVar.m() && !qu.a(CharSequence.class, cls)) {
                    return (T) pl.this.a(qVar.a(), (Class<Object>) cls);
                }
                return (T) super.a(cls, cls2, qVar);
            }

            @Override // com.badlogic.gdx.utils.o
            protected boolean a(Class cls, String str) {
                return str.equals("parent");
            }

            @Override // com.badlogic.gdx.utils.o
            public void a(Object obj, q qVar) {
                if (qVar.b("parent")) {
                    String str = (String) a("parent", String.class, qVar);
                    Class<?> cls = obj.getClass();
                    do {
                        try {
                            a(pl.this.a(str, (Class<Object>) cls), obj);
                        } catch (k unused) {
                            cls = cls.getSuperclass();
                            if (cls == Object.class) {
                                af afVar = new af("Unable to find parent resource with name: " + str);
                                afVar.a(qVar.b.v());
                                throw afVar;
                            }
                        }
                    } while (cls == Object.class);
                    af afVar2 = new af("Unable to find parent resource with name: " + str);
                    afVar2.a(qVar.b.v());
                    throw afVar2;
                }
                super.a(obj, qVar);
            }
        };
        oVar.b((String) null);
        oVar.a(false);
        oVar.a(pl.class, (o.d) new o.b<pl>() { // from class: pl.2
            @Override // com.badlogic.gdx.utils.o.d
            /* renamed from: a */
            public pl b(o oVar2, q qVar, Class cls) {
                for (q qVar2 = qVar.b; qVar2 != null; qVar2 = qVar2.c) {
                    try {
                        Class a2 = oVar2.a(qVar2.t());
                        if (a2 == null) {
                            a2 = qu.a(qVar2.t());
                        }
                        a(oVar2, a2, qVar2);
                    } catch (qx e) {
                        throw new af(e);
                    }
                }
                return this;
            }

            private void a(o oVar2, Class cls, q qVar) {
                Class cls2 = cls == a.class ? qf.class : cls;
                for (q qVar2 = qVar.b; qVar2 != null; qVar2 = qVar2.c) {
                    Object a2 = oVar2.a((Class<Object>) cls, qVar2);
                    if (a2 != null) {
                        try {
                            pl.this.a(qVar2.a, a2, cls2);
                            if (cls2 != qf.class && qu.a(qf.class, cls2)) {
                                pl.this.a(qVar2.a, a2, qf.class);
                            }
                        } catch (Exception e) {
                            throw new af("Error reading " + qu.a(cls) + ": " + qVar2.a, e);
                        }
                    }
                }
            }
        });
        oVar.a(BitmapFont.class, (o.d) new o.b<BitmapFont>() { // from class: pl.3
            @Override // com.badlogic.gdx.utils.o.d
            /* renamed from: a */
            public BitmapFont b(o oVar2, q qVar, Class cls) {
                BitmapFont bitmapFont;
                String str = (String) oVar2.a("file", String.class, qVar);
                int intValue = ((Integer) oVar2.a("scaledSize", (Class<Class>) Integer.TYPE, (Class) (-1), qVar)).intValue();
                Boolean bool = (Boolean) oVar2.a("flip", (Class<Class>) Boolean.class, (Class) false, qVar);
                Boolean bool2 = (Boolean) oVar2.a("markupEnabled", (Class<Class>) Boolean.class, (Class) false, qVar);
                jy child = jyVar.parent().child(str);
                if (!child.exists()) {
                    child = io.e.internal(str);
                }
                if (!child.exists()) {
                    throw new af("Font file not found: " + child);
                }
                String nameWithoutExtension = child.nameWithoutExtension();
                try {
                    com.badlogic.gdx.utils.a<TextureRegion> b = this.b(nameWithoutExtension);
                    if (b != null) {
                        bitmapFont = new BitmapFont(new BitmapFont.BitmapFontData(child, bool.booleanValue()), b, true);
                    } else {
                        TextureRegion textureRegion = (TextureRegion) this.b(nameWithoutExtension, TextureRegion.class);
                        if (textureRegion != null) {
                            bitmapFont = new BitmapFont(child, textureRegion, bool.booleanValue());
                        } else {
                            jy parent = child.parent();
                            jy child2 = parent.child(nameWithoutExtension + ".png");
                            if (child2.exists()) {
                                bitmapFont = new BitmapFont(child, child2, bool.booleanValue());
                            } else {
                                bitmapFont = new BitmapFont(child, bool.booleanValue());
                            }
                        }
                    }
                    bitmapFont.getData().markupEnabled = bool2.booleanValue();
                    if (intValue != -1) {
                        bitmapFont.getData().setScale(intValue / bitmapFont.getCapHeight());
                    }
                    return bitmapFont;
                } catch (RuntimeException e) {
                    throw new af("Error loading bitmap font: " + child, e);
                }
            }
        });
        oVar.a(ka.class, (o.d) new o.b<ka>() { // from class: pl.4
            @Override // com.badlogic.gdx.utils.o.d
            /* renamed from: a */
            public ka b(o oVar2, q qVar, Class cls) {
                if (qVar.m()) {
                    return (ka) pl.this.a(qVar.a(), (Class<Object>) ka.class);
                }
                String str = (String) oVar2.a("hex", (Class<Class>) String.class, (Class) null, qVar);
                if (str != null) {
                    return ka.a(str);
                }
                return new ka(((Float) oVar2.a("r", (Class<Class>) Float.TYPE, (Class) Float.valueOf(0.0f), qVar)).floatValue(), ((Float) oVar2.a("g", (Class<Class>) Float.TYPE, (Class) Float.valueOf(0.0f), qVar)).floatValue(), ((Float) oVar2.a("b", (Class<Class>) Float.TYPE, (Class) Float.valueOf(0.0f), qVar)).floatValue(), ((Float) oVar2.a("a", (Class<Class>) Float.TYPE, (Class) Float.valueOf(1.0f), qVar)).floatValue());
            }
        });
        oVar.a(a.class, (o.d) new o.b() { // from class: pl.5
            @Override // com.badlogic.gdx.utils.o.d
            public Object b(o oVar2, q qVar, Class cls) {
                String str = (String) oVar2.a("name", String.class, qVar);
                ka kaVar = (ka) oVar2.a("color", ka.class, qVar);
                qf a2 = pl.this.a(str, kaVar);
                if (a2 instanceof qb) {
                    ((qb) a2).a(qVar.a + " (" + str + ", " + kaVar + ")");
                }
                return a2;
            }
        });
        v.a<String, Class> it = this.c.iterator();
        while (it.hasNext()) {
            v.b next = it.next();
            oVar.a((String) next.a, (Class) next.b);
        }
        return oVar;
    }
}
