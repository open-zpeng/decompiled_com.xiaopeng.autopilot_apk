package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.h;
import com.badlogic.gdx.utils.k;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
/* loaded from: classes.dex */
public class BitmapFont implements g {
    private static final int LOG2_PAGE_SIZE = 9;
    private static final int PAGES = 128;
    private static final int PAGE_SIZE = 512;
    private final BitmapFontCache cache;
    final BitmapFontData data;
    private boolean flipped;
    boolean integer;
    private boolean ownsTexture;
    a<TextureRegion> regions;

    public BitmapFont() {
        this(io.e.classpath("com/badlogic/gdx/utils/arial-15.fnt"), io.e.classpath("com/badlogic/gdx/utils/arial-15.png"), false, true);
    }

    public BitmapFont(boolean z) {
        this(io.e.classpath("com/badlogic/gdx/utils/arial-15.fnt"), io.e.classpath("com/badlogic/gdx/utils/arial-15.png"), z, true);
    }

    public BitmapFont(jy jyVar, TextureRegion textureRegion) {
        this(jyVar, textureRegion, false);
    }

    public BitmapFont(jy jyVar, TextureRegion textureRegion, boolean z) {
        this(new BitmapFontData(jyVar, z), textureRegion, true);
    }

    public BitmapFont(jy jyVar) {
        this(jyVar, false);
    }

    public BitmapFont(jy jyVar, boolean z) {
        this(new BitmapFontData(jyVar, z), (TextureRegion) null, true);
    }

    public BitmapFont(jy jyVar, jy jyVar2, boolean z) {
        this(jyVar, jyVar2, z, true);
    }

    public BitmapFont(jy jyVar, jy jyVar2, boolean z, boolean z2) {
        this(new BitmapFontData(jyVar, z), new TextureRegion(new ko(jyVar2, false)), z2);
        this.ownsTexture = true;
    }

    public BitmapFont(BitmapFontData bitmapFontData, TextureRegion textureRegion, boolean z) {
        this(bitmapFontData, textureRegion != null ? a.b(textureRegion) : null, z);
    }

    public BitmapFont(BitmapFontData bitmapFontData, a<TextureRegion> aVar, boolean z) {
        jy fileHandle;
        this.flipped = bitmapFontData.flipped;
        this.data = bitmapFontData;
        this.integer = z;
        if (aVar == null || aVar.b == 0) {
            int length = bitmapFontData.imagePaths.length;
            this.regions = new a<>(length);
            for (int i = 0; i < length; i++) {
                if (bitmapFontData.fontFile == null) {
                    fileHandle = io.e.internal(bitmapFontData.imagePaths[i]);
                } else {
                    fileHandle = io.e.getFileHandle(bitmapFontData.imagePaths[i], bitmapFontData.fontFile.type());
                }
                this.regions.a((a<TextureRegion>) new TextureRegion(new ko(fileHandle, false)));
            }
            this.ownsTexture = true;
        } else {
            this.regions = aVar;
            this.ownsTexture = false;
        }
        this.cache = newFontCache();
        load(bitmapFontData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void load(BitmapFontData bitmapFontData) {
        Glyph[][] glyphArr;
        for (Glyph[] glyphArr2 : bitmapFontData.glyphs) {
            if (glyphArr2 != null) {
                for (Glyph glyph : glyphArr2) {
                    if (glyph != null) {
                        bitmapFontData.setGlyphRegion(glyph, this.regions.a(glyph.page));
                    }
                }
            }
        }
        if (bitmapFontData.missingGlyph != null) {
            bitmapFontData.setGlyphRegion(bitmapFontData.missingGlyph, this.regions.a(bitmapFontData.missingGlyph.page));
        }
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f, float f2) {
        this.cache.clear();
        GlyphLayout addText = this.cache.addText(charSequence, f, f2);
        this.cache.draw(batch);
        return addText;
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f, float f2, float f3, int i, boolean z) {
        this.cache.clear();
        GlyphLayout addText = this.cache.addText(charSequence, f, f2, f3, i, z);
        this.cache.draw(batch);
        return addText;
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z) {
        this.cache.clear();
        GlyphLayout addText = this.cache.addText(charSequence, f, f2, i, i2, f3, i3, z);
        this.cache.draw(batch);
        return addText;
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z, String str) {
        this.cache.clear();
        GlyphLayout addText = this.cache.addText(charSequence, f, f2, i, i2, f3, i3, z, str);
        this.cache.draw(batch);
        return addText;
    }

    public void draw(Batch batch, GlyphLayout glyphLayout, float f, float f2) {
        this.cache.clear();
        this.cache.addText(glyphLayout, f, f2);
        this.cache.draw(batch);
    }

    public ka getColor() {
        return this.cache.getColor();
    }

    public void setColor(ka kaVar) {
        this.cache.getColor().a(kaVar);
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.cache.getColor().a(f, f2, f3, f4);
    }

    public float getScaleX() {
        return this.data.scaleX;
    }

    public float getScaleY() {
        return this.data.scaleY;
    }

    public TextureRegion getRegion() {
        return this.regions.c();
    }

    public a<TextureRegion> getRegions() {
        return this.regions;
    }

    public TextureRegion getRegion(int i) {
        return this.regions.a(i);
    }

    public float getLineHeight() {
        return this.data.lineHeight;
    }

    public float getSpaceXadvance() {
        return this.data.spaceXadvance;
    }

    public float getXHeight() {
        return this.data.xHeight;
    }

    public float getCapHeight() {
        return this.data.capHeight;
    }

    public float getAscent() {
        return this.data.ascent;
    }

    public float getDescent() {
        return this.data.descent;
    }

    public boolean isFlipped() {
        return this.flipped;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        if (this.ownsTexture) {
            for (int i = 0; i < this.regions.b; i++) {
                this.regions.a(i).getTexture().dispose();
            }
        }
    }

    public void setFixedWidthGlyphs(CharSequence charSequence) {
        BitmapFontData bitmapFontData = this.data;
        int length = charSequence.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Glyph glyph = bitmapFontData.getGlyph(charSequence.charAt(i2));
            if (glyph != null && glyph.xadvance > i) {
                i = glyph.xadvance;
            }
        }
        int length2 = charSequence.length();
        for (int i3 = 0; i3 < length2; i3++) {
            Glyph glyph2 = bitmapFontData.getGlyph(charSequence.charAt(i3));
            if (glyph2 != null) {
                glyph2.xoffset += Math.round((i - glyph2.xadvance) / 2);
                glyph2.xadvance = i;
                glyph2.kerning = null;
                glyph2.fixedWidth = true;
            }
        }
    }

    public void setUseIntegerPositions(boolean z) {
        this.integer = z;
        this.cache.setUseIntegerPositions(z);
    }

    public boolean usesIntegerPositions() {
        return this.integer;
    }

    public BitmapFontCache getCache() {
        return this.cache;
    }

    public BitmapFontData getData() {
        return this.data;
    }

    public boolean ownsTexture() {
        return this.ownsTexture;
    }

    public void setOwnsTexture(boolean z) {
        this.ownsTexture = z;
    }

    public BitmapFontCache newFontCache() {
        return new BitmapFontCache(this, this.integer);
    }

    public String toString() {
        return this.data.fontFile != null ? this.data.fontFile.nameWithoutExtension() : super.toString();
    }

    /* loaded from: classes.dex */
    public static class Glyph {
        public boolean fixedWidth;
        public int height;
        public int id;
        public byte[][] kerning;
        public int page = 0;
        public int srcX;
        public int srcY;
        public float u;
        public float u2;
        public float v;
        public float v2;
        public int width;
        public int xadvance;
        public int xoffset;
        public int yoffset;

        public int getKerning(char c) {
            byte[] bArr;
            byte[][] bArr2 = this.kerning;
            if (bArr2 == null || (bArr = bArr2[c >>> '\t']) == null) {
                return 0;
            }
            return bArr[c & 511];
        }

        public void setKerning(int i, int i2) {
            if (this.kerning == null) {
                this.kerning = new byte[BitmapFont.PAGES];
            }
            byte[][] bArr = this.kerning;
            int i3 = i >>> 9;
            byte[] bArr2 = bArr[i3];
            if (bArr2 == null) {
                bArr2 = new byte[512];
                bArr[i3] = bArr2;
            }
            bArr2[i & IInputController.KEYCODE_USER_DEF_BUTTON] = (byte) i2;
        }

        public String toString() {
            return Character.toString((char) this.id);
        }
    }

    static int indexOf(CharSequence charSequence, char c, int i) {
        int length = charSequence.length();
        while (i < length) {
            if (charSequence.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return length;
    }

    /* loaded from: classes.dex */
    public static class BitmapFontData {
        public float ascent;
        public float blankLineScale;
        public char[] breakChars;
        public char[] capChars;
        public float capHeight;
        public float cursorX;
        public float descent;
        public float down;
        public boolean flipped;
        public jy fontFile;
        public final Glyph[][] glyphs;
        public String[] imagePaths;
        public float lineHeight;
        public boolean markupEnabled;
        public Glyph missingGlyph;
        public float padBottom;
        public float padLeft;
        public float padRight;
        public float padTop;
        public float scaleX;
        public float scaleY;
        public float spaceXadvance;
        public char[] xChars;
        public float xHeight;

        public boolean isWhitespace(char c) {
            if (c == '\r' || c == ' ') {
                return true;
            }
            switch (c) {
                case '\t':
                case '\n':
                    return true;
                default:
                    return false;
            }
        }

        public BitmapFontData() {
            this.capHeight = 1.0f;
            this.blankLineScale = 1.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.glyphs = new Glyph[BitmapFont.PAGES];
            this.xHeight = 1.0f;
            this.xChars = new char[]{'x', 'e', 'a', 'o', 'n', 's', 'r', 'c', 'u', 'm', 'v', 'w', 'z'};
            this.capChars = new char[]{'M', 'N', 'B', 'D', 'C', 'E', 'F', 'K', 'A', 'G', 'H', 'I', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        }

        public BitmapFontData(jy jyVar, boolean z) {
            this.capHeight = 1.0f;
            this.blankLineScale = 1.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.glyphs = new Glyph[BitmapFont.PAGES];
            this.xHeight = 1.0f;
            this.xChars = new char[]{'x', 'e', 'a', 'o', 'n', 's', 'r', 'c', 'u', 'm', 'v', 'w', 'z'};
            this.capChars = new char[]{'M', 'N', 'B', 'D', 'C', 'E', 'F', 'K', 'A', 'G', 'H', 'I', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            this.fontFile = jyVar;
            this.flipped = z;
            load(jyVar, z);
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x0227 A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #3 {Exception -> 0x0389, blocks: (B:5:0x0014, B:7:0x001a, B:9:0x003b, B:11:0x006d, B:13:0x0077, B:15:0x0081, B:17:0x009a, B:19:0x00aa, B:21:0x00ae, B:23:0x00b8, B:26:0x00c8, B:28:0x00cf, B:30:0x00d5, B:32:0x00e5, B:33:0x00e9, B:36:0x00f0, B:37:0x0106, B:39:0x0108, B:40:0x011e, B:41:0x011f, B:43:0x012f, B:44:0x014f, B:45:0x0156, B:46:0x0157, B:47:0x015e, B:48:0x015f, B:49:0x0162, B:54:0x0174, B:55:0x017b, B:60:0x018a, B:62:0x0190, B:64:0x019f, B:65:0x01a3, B:66:0x01aa, B:68:0x01ae, B:69:0x01c0, B:71:0x01cd, B:74:0x01d6, B:76:0x01db, B:77:0x01df, B:79:0x01ec, B:82:0x01f5, B:84:0x01fa, B:86:0x0200, B:100:0x0224, B:89:0x0205, B:91:0x0209, B:93:0x020d, B:95:0x0211, B:98:0x0216, B:99:0x0221, B:102:0x022c, B:104:0x023d, B:101:0x0227, B:58:0x0182, B:107:0x024b, B:113:0x0275, B:115:0x0287, B:52:0x016c, B:116:0x028c, B:119:0x0296, B:121:0x02b2, B:124:0x02ba, B:126:0x0302, B:128:0x031b, B:130:0x032e, B:131:0x0331, B:133:0x0337, B:134:0x0341, B:136:0x0345, B:138:0x0349, B:127:0x030d, B:123:0x02b7, B:139:0x0357, B:140:0x035e, B:141:0x035f, B:142:0x0366, B:143:0x0367, B:144:0x036e, B:145:0x036f, B:146:0x0376, B:147:0x0377, B:148:0x037e, B:149:0x037f, B:150:0x0386), top: B:168:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:104:0x023d A[Catch: all -> 0x0387, Exception -> 0x0389, TRY_LEAVE, TryCatch #3 {Exception -> 0x0389, blocks: (B:5:0x0014, B:7:0x001a, B:9:0x003b, B:11:0x006d, B:13:0x0077, B:15:0x0081, B:17:0x009a, B:19:0x00aa, B:21:0x00ae, B:23:0x00b8, B:26:0x00c8, B:28:0x00cf, B:30:0x00d5, B:32:0x00e5, B:33:0x00e9, B:36:0x00f0, B:37:0x0106, B:39:0x0108, B:40:0x011e, B:41:0x011f, B:43:0x012f, B:44:0x014f, B:45:0x0156, B:46:0x0157, B:47:0x015e, B:48:0x015f, B:49:0x0162, B:54:0x0174, B:55:0x017b, B:60:0x018a, B:62:0x0190, B:64:0x019f, B:65:0x01a3, B:66:0x01aa, B:68:0x01ae, B:69:0x01c0, B:71:0x01cd, B:74:0x01d6, B:76:0x01db, B:77:0x01df, B:79:0x01ec, B:82:0x01f5, B:84:0x01fa, B:86:0x0200, B:100:0x0224, B:89:0x0205, B:91:0x0209, B:93:0x020d, B:95:0x0211, B:98:0x0216, B:99:0x0221, B:102:0x022c, B:104:0x023d, B:101:0x0227, B:58:0x0182, B:107:0x024b, B:113:0x0275, B:115:0x0287, B:52:0x016c, B:116:0x028c, B:119:0x0296, B:121:0x02b2, B:124:0x02ba, B:126:0x0302, B:128:0x031b, B:130:0x032e, B:131:0x0331, B:133:0x0337, B:134:0x0341, B:136:0x0345, B:138:0x0349, B:127:0x030d, B:123:0x02b7, B:139:0x0357, B:140:0x035e, B:141:0x035f, B:142:0x0366, B:143:0x0367, B:144:0x036e, B:145:0x036f, B:146:0x0376, B:147:0x0377, B:148:0x037e, B:149:0x037f, B:150:0x0386), top: B:168:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:174:0x0296 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:178:0x0294 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:194:0x0287 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:200:0x017b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00cf A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #3 {Exception -> 0x0389, blocks: (B:5:0x0014, B:7:0x001a, B:9:0x003b, B:11:0x006d, B:13:0x0077, B:15:0x0081, B:17:0x009a, B:19:0x00aa, B:21:0x00ae, B:23:0x00b8, B:26:0x00c8, B:28:0x00cf, B:30:0x00d5, B:32:0x00e5, B:33:0x00e9, B:36:0x00f0, B:37:0x0106, B:39:0x0108, B:40:0x011e, B:41:0x011f, B:43:0x012f, B:44:0x014f, B:45:0x0156, B:46:0x0157, B:47:0x015e, B:48:0x015f, B:49:0x0162, B:54:0x0174, B:55:0x017b, B:60:0x018a, B:62:0x0190, B:64:0x019f, B:65:0x01a3, B:66:0x01aa, B:68:0x01ae, B:69:0x01c0, B:71:0x01cd, B:74:0x01d6, B:76:0x01db, B:77:0x01df, B:79:0x01ec, B:82:0x01f5, B:84:0x01fa, B:86:0x0200, B:100:0x0224, B:89:0x0205, B:91:0x0209, B:93:0x020d, B:95:0x0211, B:98:0x0216, B:99:0x0221, B:102:0x022c, B:104:0x023d, B:101:0x0227, B:58:0x0182, B:107:0x024b, B:113:0x0275, B:115:0x0287, B:52:0x016c, B:116:0x028c, B:119:0x0296, B:121:0x02b2, B:124:0x02ba, B:126:0x0302, B:128:0x031b, B:130:0x032e, B:131:0x0331, B:133:0x0337, B:134:0x0341, B:136:0x0345, B:138:0x0349, B:127:0x030d, B:123:0x02b7, B:139:0x0357, B:140:0x035e, B:141:0x035f, B:142:0x0366, B:143:0x0367, B:144:0x036e, B:145:0x036f, B:146:0x0376, B:147:0x0377, B:148:0x037e, B:149:0x037f, B:150:0x0386), top: B:168:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0190 A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #3 {Exception -> 0x0389, blocks: (B:5:0x0014, B:7:0x001a, B:9:0x003b, B:11:0x006d, B:13:0x0077, B:15:0x0081, B:17:0x009a, B:19:0x00aa, B:21:0x00ae, B:23:0x00b8, B:26:0x00c8, B:28:0x00cf, B:30:0x00d5, B:32:0x00e5, B:33:0x00e9, B:36:0x00f0, B:37:0x0106, B:39:0x0108, B:40:0x011e, B:41:0x011f, B:43:0x012f, B:44:0x014f, B:45:0x0156, B:46:0x0157, B:47:0x015e, B:48:0x015f, B:49:0x0162, B:54:0x0174, B:55:0x017b, B:60:0x018a, B:62:0x0190, B:64:0x019f, B:65:0x01a3, B:66:0x01aa, B:68:0x01ae, B:69:0x01c0, B:71:0x01cd, B:74:0x01d6, B:76:0x01db, B:77:0x01df, B:79:0x01ec, B:82:0x01f5, B:84:0x01fa, B:86:0x0200, B:100:0x0224, B:89:0x0205, B:91:0x0209, B:93:0x020d, B:95:0x0211, B:98:0x0216, B:99:0x0221, B:102:0x022c, B:104:0x023d, B:101:0x0227, B:58:0x0182, B:107:0x024b, B:113:0x0275, B:115:0x0287, B:52:0x016c, B:116:0x028c, B:119:0x0296, B:121:0x02b2, B:124:0x02ba, B:126:0x0302, B:128:0x031b, B:130:0x032e, B:131:0x0331, B:133:0x0337, B:134:0x0341, B:136:0x0345, B:138:0x0349, B:127:0x030d, B:123:0x02b7, B:139:0x0357, B:140:0x035e, B:141:0x035f, B:142:0x0366, B:143:0x0367, B:144:0x036e, B:145:0x036f, B:146:0x0376, B:147:0x0377, B:148:0x037e, B:149:0x037f, B:150:0x0386), top: B:168:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01ae A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #3 {Exception -> 0x0389, blocks: (B:5:0x0014, B:7:0x001a, B:9:0x003b, B:11:0x006d, B:13:0x0077, B:15:0x0081, B:17:0x009a, B:19:0x00aa, B:21:0x00ae, B:23:0x00b8, B:26:0x00c8, B:28:0x00cf, B:30:0x00d5, B:32:0x00e5, B:33:0x00e9, B:36:0x00f0, B:37:0x0106, B:39:0x0108, B:40:0x011e, B:41:0x011f, B:43:0x012f, B:44:0x014f, B:45:0x0156, B:46:0x0157, B:47:0x015e, B:48:0x015f, B:49:0x0162, B:54:0x0174, B:55:0x017b, B:60:0x018a, B:62:0x0190, B:64:0x019f, B:65:0x01a3, B:66:0x01aa, B:68:0x01ae, B:69:0x01c0, B:71:0x01cd, B:74:0x01d6, B:76:0x01db, B:77:0x01df, B:79:0x01ec, B:82:0x01f5, B:84:0x01fa, B:86:0x0200, B:100:0x0224, B:89:0x0205, B:91:0x0209, B:93:0x020d, B:95:0x0211, B:98:0x0216, B:99:0x0221, B:102:0x022c, B:104:0x023d, B:101:0x0227, B:58:0x0182, B:107:0x024b, B:113:0x0275, B:115:0x0287, B:52:0x016c, B:116:0x028c, B:119:0x0296, B:121:0x02b2, B:124:0x02ba, B:126:0x0302, B:128:0x031b, B:130:0x032e, B:131:0x0331, B:133:0x0337, B:134:0x0341, B:136:0x0345, B:138:0x0349, B:127:0x030d, B:123:0x02b7, B:139:0x0357, B:140:0x035e, B:141:0x035f, B:142:0x0366, B:143:0x0367, B:144:0x036e, B:145:0x036f, B:146:0x0376, B:147:0x0377, B:148:0x037e, B:149:0x037f, B:150:0x0386), top: B:168:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01cd A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #3 {Exception -> 0x0389, blocks: (B:5:0x0014, B:7:0x001a, B:9:0x003b, B:11:0x006d, B:13:0x0077, B:15:0x0081, B:17:0x009a, B:19:0x00aa, B:21:0x00ae, B:23:0x00b8, B:26:0x00c8, B:28:0x00cf, B:30:0x00d5, B:32:0x00e5, B:33:0x00e9, B:36:0x00f0, B:37:0x0106, B:39:0x0108, B:40:0x011e, B:41:0x011f, B:43:0x012f, B:44:0x014f, B:45:0x0156, B:46:0x0157, B:47:0x015e, B:48:0x015f, B:49:0x0162, B:54:0x0174, B:55:0x017b, B:60:0x018a, B:62:0x0190, B:64:0x019f, B:65:0x01a3, B:66:0x01aa, B:68:0x01ae, B:69:0x01c0, B:71:0x01cd, B:74:0x01d6, B:76:0x01db, B:77:0x01df, B:79:0x01ec, B:82:0x01f5, B:84:0x01fa, B:86:0x0200, B:100:0x0224, B:89:0x0205, B:91:0x0209, B:93:0x020d, B:95:0x0211, B:98:0x0216, B:99:0x0221, B:102:0x022c, B:104:0x023d, B:101:0x0227, B:58:0x0182, B:107:0x024b, B:113:0x0275, B:115:0x0287, B:52:0x016c, B:116:0x028c, B:119:0x0296, B:121:0x02b2, B:124:0x02ba, B:126:0x0302, B:128:0x031b, B:130:0x032e, B:131:0x0331, B:133:0x0337, B:134:0x0341, B:136:0x0345, B:138:0x0349, B:127:0x030d, B:123:0x02b7, B:139:0x0357, B:140:0x035e, B:141:0x035f, B:142:0x0366, B:143:0x0367, B:144:0x036e, B:145:0x036f, B:146:0x0376, B:147:0x0377, B:148:0x037e, B:149:0x037f, B:150:0x0386), top: B:168:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01db A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #3 {Exception -> 0x0389, blocks: (B:5:0x0014, B:7:0x001a, B:9:0x003b, B:11:0x006d, B:13:0x0077, B:15:0x0081, B:17:0x009a, B:19:0x00aa, B:21:0x00ae, B:23:0x00b8, B:26:0x00c8, B:28:0x00cf, B:30:0x00d5, B:32:0x00e5, B:33:0x00e9, B:36:0x00f0, B:37:0x0106, B:39:0x0108, B:40:0x011e, B:41:0x011f, B:43:0x012f, B:44:0x014f, B:45:0x0156, B:46:0x0157, B:47:0x015e, B:48:0x015f, B:49:0x0162, B:54:0x0174, B:55:0x017b, B:60:0x018a, B:62:0x0190, B:64:0x019f, B:65:0x01a3, B:66:0x01aa, B:68:0x01ae, B:69:0x01c0, B:71:0x01cd, B:74:0x01d6, B:76:0x01db, B:77:0x01df, B:79:0x01ec, B:82:0x01f5, B:84:0x01fa, B:86:0x0200, B:100:0x0224, B:89:0x0205, B:91:0x0209, B:93:0x020d, B:95:0x0211, B:98:0x0216, B:99:0x0221, B:102:0x022c, B:104:0x023d, B:101:0x0227, B:58:0x0182, B:107:0x024b, B:113:0x0275, B:115:0x0287, B:52:0x016c, B:116:0x028c, B:119:0x0296, B:121:0x02b2, B:124:0x02ba, B:126:0x0302, B:128:0x031b, B:130:0x032e, B:131:0x0331, B:133:0x0337, B:134:0x0341, B:136:0x0345, B:138:0x0349, B:127:0x030d, B:123:0x02b7, B:139:0x0357, B:140:0x035e, B:141:0x035f, B:142:0x0366, B:143:0x0367, B:144:0x036e, B:145:0x036f, B:146:0x0376, B:147:0x0377, B:148:0x037e, B:149:0x037f, B:150:0x0386), top: B:168:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01ec A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #3 {Exception -> 0x0389, blocks: (B:5:0x0014, B:7:0x001a, B:9:0x003b, B:11:0x006d, B:13:0x0077, B:15:0x0081, B:17:0x009a, B:19:0x00aa, B:21:0x00ae, B:23:0x00b8, B:26:0x00c8, B:28:0x00cf, B:30:0x00d5, B:32:0x00e5, B:33:0x00e9, B:36:0x00f0, B:37:0x0106, B:39:0x0108, B:40:0x011e, B:41:0x011f, B:43:0x012f, B:44:0x014f, B:45:0x0156, B:46:0x0157, B:47:0x015e, B:48:0x015f, B:49:0x0162, B:54:0x0174, B:55:0x017b, B:60:0x018a, B:62:0x0190, B:64:0x019f, B:65:0x01a3, B:66:0x01aa, B:68:0x01ae, B:69:0x01c0, B:71:0x01cd, B:74:0x01d6, B:76:0x01db, B:77:0x01df, B:79:0x01ec, B:82:0x01f5, B:84:0x01fa, B:86:0x0200, B:100:0x0224, B:89:0x0205, B:91:0x0209, B:93:0x020d, B:95:0x0211, B:98:0x0216, B:99:0x0221, B:102:0x022c, B:104:0x023d, B:101:0x0227, B:58:0x0182, B:107:0x024b, B:113:0x0275, B:115:0x0287, B:52:0x016c, B:116:0x028c, B:119:0x0296, B:121:0x02b2, B:124:0x02ba, B:126:0x0302, B:128:0x031b, B:130:0x032e, B:131:0x0331, B:133:0x0337, B:134:0x0341, B:136:0x0345, B:138:0x0349, B:127:0x030d, B:123:0x02b7, B:139:0x0357, B:140:0x035e, B:141:0x035f, B:142:0x0366, B:143:0x0367, B:144:0x036e, B:145:0x036f, B:146:0x0376, B:147:0x0377, B:148:0x037e, B:149:0x037f, B:150:0x0386), top: B:168:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01fa A[Catch: all -> 0x0387, Exception -> 0x0389, TryCatch #3 {Exception -> 0x0389, blocks: (B:5:0x0014, B:7:0x001a, B:9:0x003b, B:11:0x006d, B:13:0x0077, B:15:0x0081, B:17:0x009a, B:19:0x00aa, B:21:0x00ae, B:23:0x00b8, B:26:0x00c8, B:28:0x00cf, B:30:0x00d5, B:32:0x00e5, B:33:0x00e9, B:36:0x00f0, B:37:0x0106, B:39:0x0108, B:40:0x011e, B:41:0x011f, B:43:0x012f, B:44:0x014f, B:45:0x0156, B:46:0x0157, B:47:0x015e, B:48:0x015f, B:49:0x0162, B:54:0x0174, B:55:0x017b, B:60:0x018a, B:62:0x0190, B:64:0x019f, B:65:0x01a3, B:66:0x01aa, B:68:0x01ae, B:69:0x01c0, B:71:0x01cd, B:74:0x01d6, B:76:0x01db, B:77:0x01df, B:79:0x01ec, B:82:0x01f5, B:84:0x01fa, B:86:0x0200, B:100:0x0224, B:89:0x0205, B:91:0x0209, B:93:0x020d, B:95:0x0211, B:98:0x0216, B:99:0x0221, B:102:0x022c, B:104:0x023d, B:101:0x0227, B:58:0x0182, B:107:0x024b, B:113:0x0275, B:115:0x0287, B:52:0x016c, B:116:0x028c, B:119:0x0296, B:121:0x02b2, B:124:0x02ba, B:126:0x0302, B:128:0x031b, B:130:0x032e, B:131:0x0331, B:133:0x0337, B:134:0x0341, B:136:0x0345, B:138:0x0349, B:127:0x030d, B:123:0x02b7, B:139:0x0357, B:140:0x035e, B:141:0x035f, B:142:0x0366, B:143:0x0367, B:144:0x036e, B:145:0x036f, B:146:0x0376, B:147:0x0377, B:148:0x037e, B:149:0x037f, B:150:0x0386), top: B:168:0x0014, outer: #4 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void load(defpackage.jy r13, boolean r14) {
            /*
                Method dump skipped, instructions count: 941
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData.load(jy, boolean):void");
        }

        public void setGlyphRegion(Glyph glyph, TextureRegion textureRegion) {
            float f;
            float f2;
            float f3;
            ko texture = textureRegion.getTexture();
            float width = 1.0f / texture.getWidth();
            float height = 1.0f / texture.getHeight();
            float f4 = textureRegion.u;
            float f5 = textureRegion.v;
            float regionWidth = textureRegion.getRegionWidth();
            float regionHeight = textureRegion.getRegionHeight();
            if (textureRegion instanceof TextureAtlas.AtlasRegion) {
                TextureAtlas.AtlasRegion atlasRegion = (TextureAtlas.AtlasRegion) textureRegion;
                f2 = atlasRegion.offsetX;
                f = (atlasRegion.originalHeight - atlasRegion.packedHeight) - atlasRegion.offsetY;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            float f6 = glyph.srcX;
            float f7 = glyph.srcX + glyph.width;
            float f8 = glyph.srcY;
            float f9 = glyph.srcY + glyph.height;
            if (f2 > 0.0f) {
                f6 -= f2;
                if (f6 < 0.0f) {
                    glyph.width = (int) (glyph.width + f6);
                    glyph.xoffset = (int) (glyph.xoffset - f6);
                    f6 = 0.0f;
                }
                float f10 = f7 - f2;
                if (f10 > regionWidth) {
                    glyph.width = (int) (glyph.width - (f10 - regionWidth));
                } else {
                    regionWidth = f10;
                }
            } else {
                regionWidth = f7;
            }
            if (f > 0.0f) {
                float f11 = f8 - f;
                if (f11 < 0.0f) {
                    glyph.height = (int) (glyph.height + f11);
                    if (glyph.height < 0) {
                        glyph.height = 0;
                    }
                    f8 = 0.0f;
                } else {
                    f8 = f11;
                }
                f3 = f9 - f;
                if (f3 > regionHeight) {
                    float f12 = f3 - regionHeight;
                    glyph.height = (int) (glyph.height - f12);
                    glyph.yoffset = (int) (glyph.yoffset + f12);
                    f3 = regionHeight;
                }
            } else {
                f3 = f9;
            }
            glyph.u = (f6 * width) + f4;
            glyph.u2 = f4 + (regionWidth * width);
            if (this.flipped) {
                glyph.v = (f8 * height) + f5;
                glyph.v2 = f5 + (f3 * height);
                return;
            }
            glyph.v2 = (f8 * height) + f5;
            glyph.v = f5 + (f3 * height);
        }

        public void setLineHeight(float f) {
            this.lineHeight = f * this.scaleY;
            this.down = this.flipped ? this.lineHeight : -this.lineHeight;
        }

        public void setGlyph(int i, Glyph glyph) {
            Glyph[][] glyphArr = this.glyphs;
            int i2 = i / 512;
            Glyph[] glyphArr2 = glyphArr[i2];
            if (glyphArr2 == null) {
                glyphArr2 = new Glyph[512];
                glyphArr[i2] = glyphArr2;
            }
            glyphArr2[i & IInputController.KEYCODE_USER_DEF_BUTTON] = glyph;
        }

        public Glyph getFirstGlyph() {
            Glyph[][] glyphArr;
            for (Glyph[] glyphArr2 : this.glyphs) {
                if (glyphArr2 != null) {
                    for (Glyph glyph : glyphArr2) {
                        if (glyph != null && glyph.height != 0 && glyph.width != 0) {
                            return glyph;
                        }
                    }
                    continue;
                }
            }
            throw new k("No glyphs found.");
        }

        public boolean hasGlyph(char c) {
            return (this.missingGlyph == null && getGlyph(c) == null) ? false : true;
        }

        public Glyph getGlyph(char c) {
            Glyph[] glyphArr = this.glyphs[c / 512];
            if (glyphArr != null) {
                return glyphArr[c & 511];
            }
            return null;
        }

        public void getGlyphs(GlyphLayout.GlyphRun glyphRun, CharSequence charSequence, int i, int i2, Glyph glyph) {
            boolean z = this.markupEnabled;
            float f = this.scaleX;
            Glyph glyph2 = this.missingGlyph;
            a<Glyph> aVar = glyphRun.glyphs;
            h hVar = glyphRun.xAdvances;
            int i3 = i2 - i;
            aVar.c(i3);
            hVar.b(i3 + 1);
            while (i < i2) {
                int i4 = i + 1;
                char charAt = charSequence.charAt(i);
                Glyph glyph3 = getGlyph(charAt);
                if (glyph3 == null) {
                    if (glyph2 == null) {
                        i = i4;
                    } else {
                        glyph3 = glyph2;
                    }
                }
                aVar.a((a<Glyph>) glyph3);
                if (glyph == null) {
                    hVar.a(glyph3.fixedWidth ? 0.0f : ((-glyph3.xoffset) * f) - this.padLeft);
                } else {
                    hVar.a((glyph.xadvance + glyph.getKerning(charAt)) * f);
                }
                if (z && charAt == '[' && i4 < i2 && charSequence.charAt(i4) == '[') {
                    i4++;
                }
                i = i4;
                glyph = glyph3;
            }
            if (glyph != null) {
                hVar.a(glyph.fixedWidth ? glyph.xadvance * f : ((glyph.width + glyph.xoffset) * f) - this.padRight);
            }
        }

        public int getWrapIndex(a<Glyph> aVar, int i) {
            int i2 = i - 1;
            if (isWhitespace((char) aVar.a(i2).id)) {
                return i2;
            }
            while (i2 > 0 && isWhitespace((char) aVar.a(i2).id)) {
                i2--;
            }
            while (i2 > 0) {
                char c = (char) aVar.a(i2).id;
                if (isWhitespace(c) || isBreakChar(c)) {
                    return i2 + 1;
                }
                i2--;
            }
            return 0;
        }

        public boolean isBreakChar(char c) {
            char[] cArr = this.breakChars;
            if (cArr == null) {
                return false;
            }
            for (char c2 : cArr) {
                if (c == c2) {
                    return true;
                }
            }
            return false;
        }

        public String getImagePath(int i) {
            return this.imagePaths[i];
        }

        public String[] getImagePaths() {
            return this.imagePaths;
        }

        public jy getFontFile() {
            return this.fontFile;
        }

        public void setScale(float f, float f2) {
            if (f == 0.0f) {
                throw new IllegalArgumentException("scaleX cannot be 0.");
            }
            if (f2 == 0.0f) {
                throw new IllegalArgumentException("scaleY cannot be 0.");
            }
            float f3 = f / this.scaleX;
            float f4 = f2 / this.scaleY;
            this.lineHeight *= f4;
            this.spaceXadvance *= f3;
            this.xHeight *= f4;
            this.capHeight *= f4;
            this.ascent *= f4;
            this.descent *= f4;
            this.down *= f4;
            this.padLeft *= f3;
            this.padRight *= f3;
            this.padTop *= f4;
            this.padBottom *= f4;
            this.scaleX = f;
            this.scaleY = f2;
        }

        public void setScale(float f) {
            setScale(f, f);
        }

        public void scale(float f) {
            setScale(this.scaleX + f, this.scaleY + f);
        }
    }
}
