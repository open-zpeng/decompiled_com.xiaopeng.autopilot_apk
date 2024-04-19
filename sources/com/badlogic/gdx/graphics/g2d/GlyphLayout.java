package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.aa;
import com.badlogic.gdx.utils.h;
import com.badlogic.gdx.utils.z;
/* loaded from: classes.dex */
public class GlyphLayout implements z.a {
    public float height;
    public float width;
    public final a<GlyphRun> runs = new a<>();
    private final a<ka> colorStack = new a<>(4);

    public GlyphLayout() {
    }

    public GlyphLayout(BitmapFont bitmapFont, CharSequence charSequence) {
        setText(bitmapFont, charSequence);
    }

    public GlyphLayout(BitmapFont bitmapFont, CharSequence charSequence, ka kaVar, float f, int i, boolean z) {
        setText(bitmapFont, charSequence, kaVar, f, i, z);
    }

    public GlyphLayout(BitmapFont bitmapFont, CharSequence charSequence, int i, int i2, ka kaVar, float f, int i3, boolean z, String str) {
        setText(bitmapFont, charSequence, i, i2, kaVar, f, i3, z, str);
    }

    public void setText(BitmapFont bitmapFont, CharSequence charSequence) {
        setText(bitmapFont, charSequence, 0, charSequence.length(), bitmapFont.getColor(), 0.0f, 8, false, null);
    }

    public void setText(BitmapFont bitmapFont, CharSequence charSequence, ka kaVar, float f, int i, boolean z) {
        setText(bitmapFont, charSequence, 0, charSequence.length(), kaVar, f, i, z, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x039d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setText(com.badlogic.gdx.graphics.g2d.BitmapFont r30, java.lang.CharSequence r31, int r32, int r33, defpackage.ka r34, float r35, int r36, boolean r37, java.lang.String r38) {
        /*
            Method dump skipped, instructions count: 987
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.GlyphLayout.setText(com.badlogic.gdx.graphics.g2d.BitmapFont, java.lang.CharSequence, int, int, ka, float, int, boolean, java.lang.String):void");
    }

    private void truncate(BitmapFont.BitmapFontData bitmapFontData, GlyphRun glyphRun, float f, String str, int i, z<GlyphRun> zVar) {
        GlyphRun obtain = zVar.obtain();
        bitmapFontData.getGlyphs(obtain, str, 0, str.length(), null);
        float f2 = 0.0f;
        if (obtain.xAdvances.b > 0) {
            adjustLastGlyph(bitmapFontData, obtain);
            int i2 = obtain.xAdvances.b;
            float f3 = 0.0f;
            for (int i3 = 1; i3 < i2; i3++) {
                f3 += obtain.xAdvances.a(i3);
            }
            f2 = f3;
        }
        float f4 = f - f2;
        float f5 = glyphRun.x;
        int i4 = 0;
        while (true) {
            if (i4 >= glyphRun.xAdvances.b) {
                break;
            }
            float a = glyphRun.xAdvances.a(i4);
            f5 += a;
            if (f5 > f4) {
                glyphRun.width = (f5 - glyphRun.x) - a;
                break;
            }
            i4++;
        }
        if (i4 > 1) {
            glyphRun.glyphs.e(i4 - 1);
            glyphRun.xAdvances.d(i4);
            adjustLastGlyph(bitmapFontData, glyphRun);
            if (obtain.xAdvances.b > 0) {
                glyphRun.xAdvances.a(obtain.xAdvances, 1, obtain.xAdvances.b - 1);
            }
        } else {
            glyphRun.glyphs.d();
            glyphRun.xAdvances.b();
            glyphRun.xAdvances.a(obtain.xAdvances);
            if (obtain.xAdvances.b > 0) {
                glyphRun.width += obtain.xAdvances.a(0);
            }
        }
        glyphRun.glyphs.a(obtain.glyphs);
        glyphRun.width += f2;
        zVar.free(obtain);
    }

    private GlyphRun wrap(BitmapFont.BitmapFontData bitmapFontData, GlyphRun glyphRun, z<GlyphRun> zVar, int i, int i2) {
        a<BitmapFont.Glyph> aVar = glyphRun.glyphs;
        int i3 = glyphRun.glyphs.b;
        h hVar = glyphRun.xAdvances;
        int i4 = i;
        while (i4 > 0 && bitmapFontData.isWhitespace((char) aVar.a(i4 - 1).id)) {
            i4--;
        }
        while (i < i3 && bitmapFontData.isWhitespace((char) aVar.a(i).id)) {
            i++;
        }
        while (i2 < i4) {
            glyphRun.width += hVar.a(i2);
            i2++;
        }
        int i5 = i4 + 1;
        while (i2 > i5) {
            i2--;
            glyphRun.width -= hVar.a(i2);
        }
        GlyphRun glyphRun2 = null;
        if (i < i3) {
            glyphRun2 = zVar.obtain();
            glyphRun2.color.a(glyphRun.color);
            a<BitmapFont.Glyph> aVar2 = glyphRun2.glyphs;
            aVar2.a(aVar, 0, i4);
            aVar.a(0, i - 1);
            glyphRun.glyphs = aVar2;
            glyphRun2.glyphs = aVar;
            h hVar2 = glyphRun2.xAdvances;
            hVar2.a(hVar, 0, i5);
            hVar.a(1, i);
            hVar.a(0, ((-aVar.c().xoffset) * bitmapFontData.scaleX) - bitmapFontData.padLeft);
            glyphRun.xAdvances = hVar2;
            glyphRun2.xAdvances = hVar;
        } else {
            aVar.e(i4);
            hVar.d(i5);
        }
        if (i4 == 0) {
            zVar.free(glyphRun);
            this.runs.a();
        } else {
            adjustLastGlyph(bitmapFontData, glyphRun);
        }
        return glyphRun2;
    }

    private void adjustLastGlyph(BitmapFont.BitmapFontData bitmapFontData, GlyphRun glyphRun) {
        BitmapFont.Glyph b;
        if (glyphRun.glyphs.b().fixedWidth) {
            return;
        }
        float f = ((b.width + b.xoffset) * bitmapFontData.scaleX) - bitmapFontData.padRight;
        glyphRun.width += f - glyphRun.xAdvances.a();
        glyphRun.xAdvances.a(glyphRun.xAdvances.b - 1, f);
    }

    private int parseColorMarkup(CharSequence charSequence, int i, int i2, z<ka> zVar) {
        int i3;
        int i4;
        if (i == i2) {
            return -1;
        }
        char charAt = charSequence.charAt(i);
        if (charAt != '#') {
            if (charAt != '[') {
                if (charAt == ']') {
                    if (this.colorStack.b > 1) {
                        zVar.free(this.colorStack.a());
                    }
                    return 0;
                }
                for (int i5 = i + 1; i5 < i2; i5++) {
                    if (charSequence.charAt(i5) == ']') {
                        ka a = kb.a(charSequence.subSequence(i, i5).toString());
                        if (a == null) {
                            return -1;
                        }
                        ka obtain = zVar.obtain();
                        this.colorStack.a((a<ka>) obtain);
                        obtain.a(a);
                        return i5 - i;
                    }
                }
                return -1;
            }
            return -2;
        }
        int i6 = i + 1;
        int i7 = 0;
        while (true) {
            if (i6 >= i2) {
                break;
            }
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 != ']') {
                if (charAt2 >= '0' && charAt2 <= '9') {
                    i3 = i7 * 16;
                    i4 = charAt2 - '0';
                } else if (charAt2 >= 'a' && charAt2 <= 'f') {
                    i3 = i7 * 16;
                    i4 = charAt2 - 'W';
                } else if (charAt2 < 'A' || charAt2 > 'F') {
                    break;
                } else {
                    i3 = i7 * 16;
                    i4 = charAt2 - '7';
                }
                i7 = i3 + i4;
                i6++;
            } else if (i6 >= i + 2 && i6 <= i + 9) {
                int i8 = i6 - i;
                if (i8 <= 7) {
                    for (int i9 = 0; i9 < 9 - i8; i9++) {
                        i7 <<= 4;
                    }
                    i7 |= 255;
                }
                ka obtain2 = zVar.obtain();
                this.colorStack.a((a<ka>) obtain2);
                ka.a(obtain2, i7);
                return i8;
            }
        }
        return -1;
    }

    @Override // com.badlogic.gdx.utils.z.a
    public void reset() {
        aa.a(GlyphRun.class).freeAll(this.runs);
        this.runs.d();
        this.width = 0.0f;
        this.height = 0.0f;
    }

    public String toString() {
        if (this.runs.b == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(this.width);
        sb.append('x');
        sb.append(this.height);
        sb.append('\n');
        int i = this.runs.b;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(this.runs.a(i2).toString());
            sb.append('\n');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static class GlyphRun implements z.a {
        public float width;
        public float x;
        public float y;
        public a<BitmapFont.Glyph> glyphs = new a<>();
        public h xAdvances = new h();
        public final ka color = new ka();

        @Override // com.badlogic.gdx.utils.z.a
        public void reset() {
            this.glyphs.d();
            this.xAdvances.b();
            this.width = 0.0f;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(this.glyphs.b);
            a<BitmapFont.Glyph> aVar = this.glyphs;
            int i = aVar.b;
            for (int i2 = 0; i2 < i; i2++) {
                sb.append((char) aVar.a(i2).id);
            }
            sb.append(", #");
            sb.append(this.color);
            sb.append(", ");
            sb.append(this.x);
            sb.append(", ");
            sb.append(this.y);
            sb.append(", ");
            sb.append(this.width);
            return sb.toString();
        }
    }
}
