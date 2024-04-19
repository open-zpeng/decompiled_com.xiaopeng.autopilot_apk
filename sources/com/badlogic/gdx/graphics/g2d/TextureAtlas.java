package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ak;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.v;
import com.badlogic.gdx.utils.w;
import defpackage.km;
import defpackage.ko;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TextureAtlas implements g {
    private final a<AtlasRegion> regions;
    private final w<ko> textures;
    static final String[] tuple = new String[4];
    static final Comparator<TextureAtlasData.Region> indexComparator = new Comparator<TextureAtlasData.Region>() { // from class: com.badlogic.gdx.graphics.g2d.TextureAtlas.1
        @Override // java.util.Comparator
        public int compare(TextureAtlasData.Region region, TextureAtlasData.Region region2) {
            int i = region.index;
            if (i == -1) {
                i = Integer.MAX_VALUE;
            }
            int i2 = region2.index;
            if (i2 == -1) {
                i2 = Integer.MAX_VALUE;
            }
            return i - i2;
        }
    };

    /* loaded from: classes.dex */
    public static class TextureAtlasData {
        final a<Page> pages = new a<>();
        final a<Region> regions = new a<>();

        /* loaded from: classes.dex */
        public static class Region {
            public boolean flip;
            public int height;
            public int index;
            public int left;
            public String name;
            public float offsetX;
            public float offsetY;
            public int originalHeight;
            public int originalWidth;
            public int[] pads;
            public Page page;
            public boolean rotate;
            public int[] splits;
            public int top;
            public int width;
        }

        /* loaded from: classes.dex */
        public static class Page {
            public final km.c format;
            public final float height;
            public final ko.a magFilter;
            public final ko.a minFilter;
            public ko texture;
            public final jy textureFile;
            public final ko.b uWrap;
            public final boolean useMipMaps;
            public final ko.b vWrap;
            public final float width;

            public Page(jy jyVar, float f, float f2, boolean z, km.c cVar, ko.a aVar, ko.a aVar2, ko.b bVar, ko.b bVar2) {
                this.width = f;
                this.height = f2;
                this.textureFile = jyVar;
                this.useMipMaps = z;
                this.format = cVar;
                this.minFilter = aVar;
                this.magFilter = aVar2;
                this.uWrap = bVar;
                this.vWrap = bVar2;
            }
        }

        public TextureAtlasData(jy jyVar, jy jyVar2, boolean z) {
            float f;
            float f2;
            ko.b bVar;
            ko.b bVar2;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jyVar.read()), 64);
            Page page = null;
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (readLine.trim().length() == 0) {
                                page = null;
                            } else if (page == null) {
                                jy child = jyVar2.child(readLine);
                                if (TextureAtlas.readTuple(bufferedReader) == 2) {
                                    TextureAtlas.readTuple(bufferedReader);
                                    f = Integer.parseInt(TextureAtlas.tuple[0]);
                                    f2 = Integer.parseInt(TextureAtlas.tuple[1]);
                                } else {
                                    f = 0.0f;
                                    f2 = 0.0f;
                                }
                                km.c valueOf = km.c.valueOf(TextureAtlas.tuple[0]);
                                TextureAtlas.readTuple(bufferedReader);
                                ko.a valueOf2 = ko.a.valueOf(TextureAtlas.tuple[0]);
                                ko.a valueOf3 = ko.a.valueOf(TextureAtlas.tuple[1]);
                                String readValue = TextureAtlas.readValue(bufferedReader);
                                ko.b bVar3 = ko.b.ClampToEdge;
                                ko.b bVar4 = ko.b.ClampToEdge;
                                if (readValue.equals("x")) {
                                    bVar = ko.b.Repeat;
                                    bVar2 = bVar4;
                                } else if (readValue.equals("y")) {
                                    bVar2 = ko.b.Repeat;
                                    bVar = bVar3;
                                } else if (readValue.equals("xy")) {
                                    bVar = ko.b.Repeat;
                                    bVar2 = ko.b.Repeat;
                                } else {
                                    bVar = bVar3;
                                    bVar2 = bVar4;
                                }
                                page = new Page(child, f, f2, valueOf2.isMipMap(), valueOf, valueOf2, valueOf3, bVar, bVar2);
                                this.pages.a((a<Page>) page);
                            } else {
                                boolean booleanValue = Boolean.valueOf(TextureAtlas.readValue(bufferedReader)).booleanValue();
                                TextureAtlas.readTuple(bufferedReader);
                                int parseInt = Integer.parseInt(TextureAtlas.tuple[0]);
                                int parseInt2 = Integer.parseInt(TextureAtlas.tuple[1]);
                                TextureAtlas.readTuple(bufferedReader);
                                int parseInt3 = Integer.parseInt(TextureAtlas.tuple[0]);
                                int parseInt4 = Integer.parseInt(TextureAtlas.tuple[1]);
                                Region region = new Region();
                                region.page = page;
                                region.left = parseInt;
                                region.top = parseInt2;
                                region.width = parseInt3;
                                region.height = parseInt4;
                                region.name = readLine;
                                region.rotate = booleanValue;
                                if (TextureAtlas.readTuple(bufferedReader) == 4) {
                                    region.splits = new int[]{Integer.parseInt(TextureAtlas.tuple[0]), Integer.parseInt(TextureAtlas.tuple[1]), Integer.parseInt(TextureAtlas.tuple[2]), Integer.parseInt(TextureAtlas.tuple[3])};
                                    if (TextureAtlas.readTuple(bufferedReader) == 4) {
                                        region.pads = new int[]{Integer.parseInt(TextureAtlas.tuple[0]), Integer.parseInt(TextureAtlas.tuple[1]), Integer.parseInt(TextureAtlas.tuple[2]), Integer.parseInt(TextureAtlas.tuple[3])};
                                        TextureAtlas.readTuple(bufferedReader);
                                    }
                                }
                                region.originalWidth = Integer.parseInt(TextureAtlas.tuple[0]);
                                region.originalHeight = Integer.parseInt(TextureAtlas.tuple[1]);
                                TextureAtlas.readTuple(bufferedReader);
                                region.offsetX = Integer.parseInt(TextureAtlas.tuple[0]);
                                region.offsetY = Integer.parseInt(TextureAtlas.tuple[1]);
                                region.index = Integer.parseInt(TextureAtlas.readValue(bufferedReader));
                                if (z) {
                                    region.flip = true;
                                }
                                this.regions.a((a<Region>) region);
                            }
                        } else {
                            ak.a(bufferedReader);
                            this.regions.a(TextureAtlas.indexComparator);
                            return;
                        }
                    } catch (Exception e) {
                        throw new k("Error reading pack file: " + jyVar, e);
                    }
                } catch (Throwable th) {
                    ak.a(bufferedReader);
                    throw th;
                }
            }
        }

        public a<Page> getPages() {
            return this.pages;
        }

        public a<Region> getRegions() {
            return this.regions;
        }
    }

    public TextureAtlas() {
        this.textures = new w<>(4);
        this.regions = new a<>();
    }

    public TextureAtlas(String str) {
        this(io.e.internal(str));
    }

    public TextureAtlas(jy jyVar) {
        this(jyVar, jyVar.parent());
    }

    public TextureAtlas(jy jyVar, boolean z) {
        this(jyVar, jyVar.parent(), z);
    }

    public TextureAtlas(jy jyVar, jy jyVar2) {
        this(jyVar, jyVar2, false);
    }

    public TextureAtlas(jy jyVar, jy jyVar2, boolean z) {
        this(new TextureAtlasData(jyVar, jyVar2, z));
    }

    public TextureAtlas(TextureAtlasData textureAtlasData) {
        this.textures = new w<>(4);
        this.regions = new a<>();
        if (textureAtlasData != null) {
            load(textureAtlasData);
        }
    }

    private void load(TextureAtlasData textureAtlasData) {
        ko koVar;
        v vVar = new v();
        Iterator<TextureAtlasData.Page> it = textureAtlasData.pages.iterator();
        while (it.hasNext()) {
            TextureAtlasData.Page next = it.next();
            if (next.texture == null) {
                koVar = new ko(next.textureFile, next.format, next.useMipMaps);
                koVar.setFilter(next.minFilter, next.magFilter);
                koVar.setWrap(next.uWrap, next.vWrap);
            } else {
                koVar = next.texture;
                koVar.setFilter(next.minFilter, next.magFilter);
                koVar.setWrap(next.uWrap, next.vWrap);
            }
            this.textures.a((w<ko>) koVar);
            vVar.a((v) next, (TextureAtlasData.Page) koVar);
        }
        Iterator<TextureAtlasData.Region> it2 = textureAtlasData.regions.iterator();
        while (it2.hasNext()) {
            TextureAtlasData.Region next2 = it2.next();
            int i = next2.width;
            int i2 = next2.height;
            AtlasRegion atlasRegion = new AtlasRegion((ko) vVar.a((v) next2.page), next2.left, next2.top, next2.rotate ? i2 : i, next2.rotate ? i : i2);
            atlasRegion.index = next2.index;
            atlasRegion.name = next2.name;
            atlasRegion.offsetX = next2.offsetX;
            atlasRegion.offsetY = next2.offsetY;
            atlasRegion.originalHeight = next2.originalHeight;
            atlasRegion.originalWidth = next2.originalWidth;
            atlasRegion.rotate = next2.rotate;
            atlasRegion.splits = next2.splits;
            atlasRegion.pads = next2.pads;
            if (next2.flip) {
                atlasRegion.flip(false, true);
            }
            this.regions.a((a<AtlasRegion>) atlasRegion);
        }
    }

    public AtlasRegion addRegion(String str, ko koVar, int i, int i2, int i3, int i4) {
        this.textures.a((w<ko>) koVar);
        AtlasRegion atlasRegion = new AtlasRegion(koVar, i, i2, i3, i4);
        atlasRegion.name = str;
        atlasRegion.originalWidth = i3;
        atlasRegion.originalHeight = i4;
        atlasRegion.index = -1;
        this.regions.a((a<AtlasRegion>) atlasRegion);
        return atlasRegion;
    }

    public AtlasRegion addRegion(String str, TextureRegion textureRegion) {
        return addRegion(str, textureRegion.texture, textureRegion.getRegionX(), textureRegion.getRegionY(), textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    public a<AtlasRegion> getRegions() {
        return this.regions;
    }

    public AtlasRegion findRegion(String str) {
        int i = this.regions.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.regions.a(i2).name.equals(str)) {
                return this.regions.a(i2);
            }
        }
        return null;
    }

    public AtlasRegion findRegion(String str, int i) {
        int i2 = this.regions.b;
        for (int i3 = 0; i3 < i2; i3++) {
            AtlasRegion a = this.regions.a(i3);
            if (a.name.equals(str) && a.index == i) {
                return a;
            }
        }
        return null;
    }

    public a<AtlasRegion> findRegions(String str) {
        a<AtlasRegion> aVar = new a<>(AtlasRegion.class);
        int i = this.regions.b;
        for (int i2 = 0; i2 < i; i2++) {
            AtlasRegion a = this.regions.a(i2);
            if (a.name.equals(str)) {
                aVar.a((a<AtlasRegion>) new AtlasRegion(a));
            }
        }
        return aVar;
    }

    public a<Sprite> createSprites() {
        a<Sprite> aVar = new a<>(true, this.regions.b, Sprite.class);
        int i = this.regions.b;
        for (int i2 = 0; i2 < i; i2++) {
            aVar.a((a<Sprite>) newSprite(this.regions.a(i2)));
        }
        return aVar;
    }

    public Sprite createSprite(String str) {
        int i = this.regions.b;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.regions.a(i2).name.equals(str)) {
                return newSprite(this.regions.a(i2));
            }
        }
        return null;
    }

    public Sprite createSprite(String str, int i) {
        int i2 = this.regions.b;
        for (int i3 = 0; i3 < i2; i3++) {
            AtlasRegion a = this.regions.a(i3);
            if (a.name.equals(str) && a.index == i) {
                return newSprite(this.regions.a(i3));
            }
        }
        return null;
    }

    public a<Sprite> createSprites(String str) {
        a<Sprite> aVar = new a<>(Sprite.class);
        int i = this.regions.b;
        for (int i2 = 0; i2 < i; i2++) {
            AtlasRegion a = this.regions.a(i2);
            if (a.name.equals(str)) {
                aVar.a((a<Sprite>) newSprite(a));
            }
        }
        return aVar;
    }

    private Sprite newSprite(AtlasRegion atlasRegion) {
        if (atlasRegion.packedWidth == atlasRegion.originalWidth && atlasRegion.packedHeight == atlasRegion.originalHeight) {
            if (atlasRegion.rotate) {
                Sprite sprite = new Sprite(atlasRegion);
                sprite.setBounds(0.0f, 0.0f, atlasRegion.getRegionHeight(), atlasRegion.getRegionWidth());
                sprite.rotate90(true);
                return sprite;
            }
            return new Sprite(atlasRegion);
        }
        return new AtlasSprite(atlasRegion);
    }

    public NinePatch createPatch(String str) {
        int i = this.regions.b;
        for (int i2 = 0; i2 < i; i2++) {
            AtlasRegion a = this.regions.a(i2);
            if (a.name.equals(str)) {
                int[] iArr = a.splits;
                if (iArr == null) {
                    throw new IllegalArgumentException("Region does not have ninepatch splits: " + str);
                }
                NinePatch ninePatch = new NinePatch(a, iArr[0], iArr[1], iArr[2], iArr[3]);
                if (a.pads != null) {
                    ninePatch.setPadding(a.pads[0], a.pads[1], a.pads[2], a.pads[3]);
                }
                return ninePatch;
            }
        }
        return null;
    }

    public w<ko> getTextures() {
        return this.textures;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        w.a<ko> it = this.textures.iterator();
        while (it.hasNext()) {
            it.next().dispose();
        }
        this.textures.a();
    }

    static String readValue(BufferedReader bufferedReader) throws IOException {
        String readLine = bufferedReader.readLine();
        int indexOf = readLine.indexOf(58);
        if (indexOf == -1) {
            throw new k("Invalid line: " + readLine);
        }
        return readLine.substring(indexOf + 1).trim();
    }

    static int readTuple(BufferedReader bufferedReader) throws IOException {
        int indexOf;
        String readLine = bufferedReader.readLine();
        int indexOf2 = readLine.indexOf(58);
        if (indexOf2 == -1) {
            throw new k("Invalid line: " + readLine);
        }
        int i = indexOf2 + 1;
        int i2 = 0;
        while (i2 < 3 && (indexOf = readLine.indexOf(44, i)) != -1) {
            tuple[i2] = readLine.substring(i, indexOf).trim();
            i = indexOf + 1;
            i2++;
        }
        tuple[i2] = readLine.substring(i).trim();
        return i2 + 1;
    }

    /* loaded from: classes.dex */
    public static class AtlasRegion extends TextureRegion {
        public int index;
        public String name;
        public float offsetX;
        public float offsetY;
        public int originalHeight;
        public int originalWidth;
        public int packedHeight;
        public int packedWidth;
        public int[] pads;
        public boolean rotate;
        public int[] splits;

        public AtlasRegion(ko koVar, int i, int i2, int i3, int i4) {
            super(koVar, i, i2, i3, i4);
            this.originalWidth = i3;
            this.originalHeight = i4;
            this.packedWidth = i3;
            this.packedHeight = i4;
        }

        public AtlasRegion(AtlasRegion atlasRegion) {
            setRegion(atlasRegion);
            this.index = atlasRegion.index;
            this.name = atlasRegion.name;
            this.offsetX = atlasRegion.offsetX;
            this.offsetY = atlasRegion.offsetY;
            this.packedWidth = atlasRegion.packedWidth;
            this.packedHeight = atlasRegion.packedHeight;
            this.originalWidth = atlasRegion.originalWidth;
            this.originalHeight = atlasRegion.originalHeight;
            this.rotate = atlasRegion.rotate;
            this.splits = atlasRegion.splits;
        }

        @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
        public void flip(boolean z, boolean z2) {
            super.flip(z, z2);
            if (z) {
                this.offsetX = (this.originalWidth - this.offsetX) - getRotatedPackedWidth();
            }
            if (z2) {
                this.offsetY = (this.originalHeight - this.offsetY) - getRotatedPackedHeight();
            }
        }

        public float getRotatedPackedWidth() {
            return this.rotate ? this.packedHeight : this.packedWidth;
        }

        public float getRotatedPackedHeight() {
            return this.rotate ? this.packedWidth : this.packedHeight;
        }

        public String toString() {
            return this.name;
        }
    }

    /* loaded from: classes.dex */
    public static class AtlasSprite extends Sprite {
        float originalOffsetX;
        float originalOffsetY;
        final AtlasRegion region;

        public AtlasSprite(AtlasRegion atlasRegion) {
            this.region = new AtlasRegion(atlasRegion);
            this.originalOffsetX = atlasRegion.offsetX;
            this.originalOffsetY = atlasRegion.offsetY;
            setRegion(atlasRegion);
            setOrigin(atlasRegion.originalWidth / 2.0f, atlasRegion.originalHeight / 2.0f);
            int regionWidth = atlasRegion.getRegionWidth();
            int regionHeight = atlasRegion.getRegionHeight();
            if (atlasRegion.rotate) {
                super.rotate90(true);
                super.setBounds(atlasRegion.offsetX, atlasRegion.offsetY, regionHeight, regionWidth);
            } else {
                super.setBounds(atlasRegion.offsetX, atlasRegion.offsetY, regionWidth, regionHeight);
            }
            setColor(1.0f, 1.0f, 1.0f, 1.0f);
        }

        public AtlasSprite(AtlasSprite atlasSprite) {
            this.region = atlasSprite.region;
            this.originalOffsetX = atlasSprite.originalOffsetX;
            this.originalOffsetY = atlasSprite.originalOffsetY;
            set(atlasSprite);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setPosition(float f, float f2) {
            super.setPosition(f + this.region.offsetX, f2 + this.region.offsetY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setX(float f) {
            super.setX(f + this.region.offsetX);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setY(float f) {
            super.setY(f + this.region.offsetY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setBounds(float f, float f2, float f3, float f4) {
            float f5 = f3 / this.region.originalWidth;
            float f6 = f4 / this.region.originalHeight;
            AtlasRegion atlasRegion = this.region;
            atlasRegion.offsetX = this.originalOffsetX * f5;
            atlasRegion.offsetY = this.originalOffsetY * f6;
            super.setBounds(f + this.region.offsetX, f2 + this.region.offsetY, (atlasRegion.rotate ? this.region.packedHeight : this.region.packedWidth) * f5, (this.region.rotate ? this.region.packedWidth : this.region.packedHeight) * f6);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setSize(float f, float f2) {
            setBounds(getX(), getY(), f, f2);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setOrigin(float f, float f2) {
            super.setOrigin(f - this.region.offsetX, f2 - this.region.offsetY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void setOriginCenter() {
            super.setOrigin((this.width / 2.0f) - this.region.offsetX, (this.height / 2.0f) - this.region.offsetY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite, com.badlogic.gdx.graphics.g2d.TextureRegion
        public void flip(boolean z, boolean z2) {
            if (this.region.rotate) {
                super.flip(z2, z);
            } else {
                super.flip(z, z2);
            }
            float originX = getOriginX();
            float originY = getOriginY();
            float f = this.region.offsetX;
            float f2 = this.region.offsetY;
            float widthRatio = getWidthRatio();
            float heightRatio = getHeightRatio();
            AtlasRegion atlasRegion = this.region;
            atlasRegion.offsetX = this.originalOffsetX;
            atlasRegion.offsetY = this.originalOffsetY;
            atlasRegion.flip(z, z2);
            this.originalOffsetX = this.region.offsetX;
            this.originalOffsetY = this.region.offsetY;
            this.region.offsetX *= widthRatio;
            this.region.offsetY *= heightRatio;
            translate(this.region.offsetX - f, this.region.offsetY - f2);
            setOrigin(originX, originY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public void rotate90(boolean z) {
            super.rotate90(z);
            float originX = getOriginX();
            float originY = getOriginY();
            float f = this.region.offsetX;
            float f2 = this.region.offsetY;
            float widthRatio = getWidthRatio();
            float heightRatio = getHeightRatio();
            if (z) {
                AtlasRegion atlasRegion = this.region;
                atlasRegion.offsetX = f2;
                atlasRegion.offsetY = ((atlasRegion.originalHeight * heightRatio) - f) - (this.region.packedWidth * widthRatio);
            } else {
                AtlasRegion atlasRegion2 = this.region;
                atlasRegion2.offsetX = ((atlasRegion2.originalWidth * widthRatio) - f2) - (this.region.packedHeight * heightRatio);
                this.region.offsetY = f;
            }
            translate(this.region.offsetX - f, this.region.offsetY - f2);
            setOrigin(originX, originY);
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getX() {
            return super.getX() - this.region.offsetX;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getY() {
            return super.getY() - this.region.offsetY;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getOriginX() {
            return super.getOriginX() + this.region.offsetX;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getOriginY() {
            return super.getOriginY() + this.region.offsetY;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getWidth() {
            return (super.getWidth() / this.region.getRotatedPackedWidth()) * this.region.originalWidth;
        }

        @Override // com.badlogic.gdx.graphics.g2d.Sprite
        public float getHeight() {
            return (super.getHeight() / this.region.getRotatedPackedHeight()) * this.region.originalHeight;
        }

        public float getWidthRatio() {
            return super.getWidth() / this.region.getRotatedPackedWidth();
        }

        public float getHeightRatio() {
            return super.getHeight() / this.region.getRotatedPackedHeight();
        }

        public AtlasRegion getAtlasRegion() {
            return this.region;
        }

        public String toString() {
            return this.region.toString();
        }
    }
}
