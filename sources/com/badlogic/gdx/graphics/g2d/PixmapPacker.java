package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.p;
import com.badlogic.gdx.math.n;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.g;
import com.badlogic.gdx.utils.w;
import com.badlogic.gdx.utils.x;
import defpackage.km;
import defpackage.ko;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PixmapPacker implements g {
    int alphaThreshold;
    private ka c;
    boolean disposed;
    boolean duplicateBorder;
    PackStrategy packStrategy;
    boolean packToTexture;
    int padding;
    km.c pageFormat;
    int pageHeight;
    int pageWidth;
    final a<Page> pages;
    boolean stripWhitespaceX;
    boolean stripWhitespaceY;
    ka transparentColor;

    /* loaded from: classes.dex */
    public interface PackStrategy {
        Page pack(PixmapPacker pixmapPacker, String str, n nVar);

        void sort(a<km> aVar);
    }

    public PixmapPacker(int i, int i2, km.c cVar, int i3, boolean z) {
        this(i, i2, cVar, i3, z, false, false, new GuillotineStrategy());
    }

    public PixmapPacker(int i, int i2, km.c cVar, int i3, boolean z, PackStrategy packStrategy) {
        this(i, i2, cVar, i3, z, false, false, packStrategy);
    }

    public PixmapPacker(int i, int i2, km.c cVar, int i3, boolean z, boolean z2, boolean z3, PackStrategy packStrategy) {
        this.transparentColor = new ka(0.0f, 0.0f, 0.0f, 0.0f);
        this.pages = new a<>();
        this.c = new ka();
        this.pageWidth = i;
        this.pageHeight = i2;
        this.pageFormat = cVar;
        this.padding = i3;
        this.duplicateBorder = z;
        this.stripWhitespaceX = z2;
        this.stripWhitespaceY = z3;
        this.packStrategy = packStrategy;
    }

    public void sort(a<km> aVar) {
        this.packStrategy.sort(aVar);
    }

    public synchronized n pack(km kmVar) {
        return pack(null, kmVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x02c2, code lost:
        throw new com.badlogic.gdx.utils.k("Page size too small for pixmap.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.badlogic.gdx.math.n pack(java.lang.String r28, defpackage.km r29) {
        /*
            Method dump skipped, instructions count: 733
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.PixmapPacker.pack(java.lang.String, km):com.badlogic.gdx.math.n");
    }

    public a<Page> getPages() {
        return this.pages;
    }

    public synchronized n getRect(String str) {
        Iterator<Page> it = this.pages.iterator();
        while (it.hasNext()) {
            PixmapPackerRectangle a = it.next().rects.a((x<String, PixmapPackerRectangle>) str);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public synchronized Page getPage(String str) {
        Iterator<Page> it = this.pages.iterator();
        while (it.hasNext()) {
            Page next = it.next();
            if (next.rects.a((x<String, PixmapPackerRectangle>) str) != null) {
                return next;
            }
        }
        return null;
    }

    public synchronized int getPageIndex(String str) {
        for (int i = 0; i < this.pages.b; i++) {
            if (this.pages.a(i).rects.a((x<String, PixmapPackerRectangle>) str) != null) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public synchronized void dispose() {
        Iterator<Page> it = this.pages.iterator();
        while (it.hasNext()) {
            Page next = it.next();
            if (next.texture == null) {
                next.image.dispose();
            }
        }
        this.disposed = true;
    }

    public synchronized TextureAtlas generateTextureAtlas(ko.a aVar, ko.a aVar2, boolean z) {
        TextureAtlas textureAtlas;
        textureAtlas = new TextureAtlas();
        updateTextureAtlas(textureAtlas, aVar, aVar2, z);
        return textureAtlas;
    }

    public synchronized void updateTextureAtlas(TextureAtlas textureAtlas, ko.a aVar, ko.a aVar2, boolean z) {
        updatePageTextures(aVar, aVar2, z);
        Iterator<Page> it = this.pages.iterator();
        while (it.hasNext()) {
            Page next = it.next();
            if (next.addedRects.b > 0) {
                Iterator<String> it2 = next.addedRects.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    PixmapPackerRectangle a = next.rects.a((x<String, PixmapPackerRectangle>) next2);
                    TextureAtlas.AtlasRegion atlasRegion = new TextureAtlas.AtlasRegion(next.texture, (int) a.x, (int) a.y, (int) a.width, (int) a.height);
                    if (a.splits != null) {
                        atlasRegion.splits = a.splits;
                        atlasRegion.pads = a.pads;
                    }
                    atlasRegion.name = next2;
                    atlasRegion.index = -1;
                    atlasRegion.offsetX = a.offsetX;
                    atlasRegion.offsetY = (int) ((a.originalHeight - a.height) - a.offsetY);
                    atlasRegion.originalWidth = a.originalWidth;
                    atlasRegion.originalHeight = a.originalHeight;
                    textureAtlas.getRegions().a((a<TextureAtlas.AtlasRegion>) atlasRegion);
                }
                next.addedRects.d();
                textureAtlas.getTextures().a((w<ko>) next.texture);
            }
        }
    }

    public synchronized void updateTextureRegions(a<TextureRegion> aVar, ko.a aVar2, ko.a aVar3, boolean z) {
        updatePageTextures(aVar2, aVar3, z);
        while (aVar.b < this.pages.b) {
            aVar.a((a<TextureRegion>) new TextureRegion(this.pages.a(aVar.b).texture));
        }
    }

    public synchronized void updatePageTextures(ko.a aVar, ko.a aVar2, boolean z) {
        Iterator<Page> it = this.pages.iterator();
        while (it.hasNext()) {
            it.next().updateTexture(aVar, aVar2, z);
        }
    }

    public int getPageWidth() {
        return this.pageWidth;
    }

    public void setPageWidth(int i) {
        this.pageWidth = i;
    }

    public int getPageHeight() {
        return this.pageHeight;
    }

    public void setPageHeight(int i) {
        this.pageHeight = i;
    }

    public km.c getPageFormat() {
        return this.pageFormat;
    }

    public void setPageFormat(km.c cVar) {
        this.pageFormat = cVar;
    }

    public int getPadding() {
        return this.padding;
    }

    public void setPadding(int i) {
        this.padding = i;
    }

    public boolean getDuplicateBorder() {
        return this.duplicateBorder;
    }

    public void setDuplicateBorder(boolean z) {
        this.duplicateBorder = z;
    }

    public boolean getPackToTexture() {
        return this.packToTexture;
    }

    public void setPackToTexture(boolean z) {
        this.packToTexture = z;
    }

    /* loaded from: classes.dex */
    public static class Page {
        boolean dirty;
        km image;
        ko texture;
        x<String, PixmapPackerRectangle> rects = new x<>();
        final a<String> addedRects = new a<>();

        public Page(PixmapPacker pixmapPacker) {
            this.image = new km(pixmapPacker.pageWidth, pixmapPacker.pageHeight, pixmapPacker.pageFormat);
            this.image.a(pixmapPacker.getTransparentColor());
            this.image.a();
        }

        public km getPixmap() {
            return this.image;
        }

        public x<String, PixmapPackerRectangle> getRects() {
            return this.rects;
        }

        public ko getTexture() {
            return this.texture;
        }

        public boolean updateTexture(ko.a aVar, ko.a aVar2, boolean z) {
            ko koVar = this.texture;
            if (koVar != null) {
                if (!this.dirty) {
                    return false;
                }
                koVar.load(koVar.getTextureData());
            } else {
                km kmVar = this.image;
                this.texture = new ko(new p(kmVar, kmVar.h(), z, false, true)) { // from class: com.badlogic.gdx.graphics.g2d.PixmapPacker.Page.1
                    @Override // defpackage.ko, defpackage.ki, com.badlogic.gdx.utils.g, defpackage.ik
                    public void dispose() {
                        super.dispose();
                        Page.this.image.dispose();
                    }
                };
                this.texture.setFilter(aVar, aVar2);
            }
            this.dirty = false;
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class GuillotineStrategy implements PackStrategy {
        Comparator<km> comparator;

        @Override // com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy
        public void sort(a<km> aVar) {
            if (this.comparator == null) {
                this.comparator = new Comparator<km>() { // from class: com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy.1
                    @Override // java.util.Comparator
                    public int compare(km kmVar, km kmVar2) {
                        return Math.max(kmVar.b(), kmVar.c()) - Math.max(kmVar2.b(), kmVar2.c());
                    }
                };
            }
            aVar.a(this.comparator);
        }

        @Override // com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy
        public Page pack(PixmapPacker pixmapPacker, String str, n nVar) {
            GuillotinePage guillotinePage;
            if (pixmapPacker.pages.b == 0) {
                guillotinePage = new GuillotinePage(pixmapPacker);
                pixmapPacker.pages.a((a<Page>) guillotinePage);
            } else {
                guillotinePage = (GuillotinePage) pixmapPacker.pages.b();
            }
            float f = pixmapPacker.padding;
            nVar.width += f;
            nVar.height += f;
            Node insert = insert(guillotinePage.root, nVar);
            if (insert == null) {
                guillotinePage = new GuillotinePage(pixmapPacker);
                pixmapPacker.pages.a((a<Page>) guillotinePage);
                insert = insert(guillotinePage.root, nVar);
            }
            insert.full = true;
            nVar.set(insert.rect.x, insert.rect.y, insert.rect.width - f, insert.rect.height - f);
            return guillotinePage;
        }

        private Node insert(Node node, n nVar) {
            if (!node.full && node.leftChild != null && node.rightChild != null) {
                Node insert = insert(node.leftChild, nVar);
                return insert == null ? insert(node.rightChild, nVar) : insert;
            } else if (node.full) {
                return null;
            } else {
                if (node.rect.width == nVar.width && node.rect.height == nVar.height) {
                    return node;
                }
                if (node.rect.width < nVar.width || node.rect.height < nVar.height) {
                    return null;
                }
                node.leftChild = new Node();
                node.rightChild = new Node();
                if (((int) node.rect.width) - ((int) nVar.width) > ((int) node.rect.height) - ((int) nVar.height)) {
                    node.leftChild.rect.x = node.rect.x;
                    node.leftChild.rect.y = node.rect.y;
                    node.leftChild.rect.width = nVar.width;
                    node.leftChild.rect.height = node.rect.height;
                    node.rightChild.rect.x = node.rect.x + nVar.width;
                    node.rightChild.rect.y = node.rect.y;
                    node.rightChild.rect.width = node.rect.width - nVar.width;
                    node.rightChild.rect.height = node.rect.height;
                } else {
                    node.leftChild.rect.x = node.rect.x;
                    node.leftChild.rect.y = node.rect.y;
                    node.leftChild.rect.width = node.rect.width;
                    node.leftChild.rect.height = nVar.height;
                    node.rightChild.rect.x = node.rect.x;
                    node.rightChild.rect.y = node.rect.y + nVar.height;
                    node.rightChild.rect.width = node.rect.width;
                    node.rightChild.rect.height = node.rect.height - nVar.height;
                }
                return insert(node.leftChild, nVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class Node {
            public boolean full;
            public Node leftChild;
            public final n rect = new n();
            public Node rightChild;

            Node() {
            }
        }

        /* loaded from: classes.dex */
        static class GuillotinePage extends Page {
            Node root;

            public GuillotinePage(PixmapPacker pixmapPacker) {
                super(pixmapPacker);
                this.root = new Node();
                this.root.rect.x = pixmapPacker.padding;
                this.root.rect.y = pixmapPacker.padding;
                this.root.rect.width = pixmapPacker.pageWidth - (pixmapPacker.padding * 2);
                this.root.rect.height = pixmapPacker.pageHeight - (pixmapPacker.padding * 2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SkylineStrategy implements PackStrategy {
        Comparator<km> comparator;

        @Override // com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy
        public void sort(a<km> aVar) {
            if (this.comparator == null) {
                this.comparator = new Comparator<km>() { // from class: com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy.1
                    @Override // java.util.Comparator
                    public int compare(km kmVar, km kmVar2) {
                        return kmVar.c() - kmVar2.c();
                    }
                };
            }
            aVar.a(this.comparator);
        }

        @Override // com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy
        public Page pack(PixmapPacker pixmapPacker, String str, n nVar) {
            int i = pixmapPacker.padding;
            int i2 = i * 2;
            int i3 = pixmapPacker.pageWidth - i2;
            int i4 = pixmapPacker.pageHeight - i2;
            int i5 = ((int) nVar.width) + i;
            int i6 = ((int) nVar.height) + i;
            int i7 = pixmapPacker.pages.b;
            for (int i8 = 0; i8 < i7; i8++) {
                SkylinePage skylinePage = (SkylinePage) pixmapPacker.pages.a(i8);
                int i9 = skylinePage.rows.b - 1;
                SkylinePage.Row row = null;
                for (int i10 = 0; i10 < i9; i10++) {
                    SkylinePage.Row a = skylinePage.rows.a(i10);
                    if (a.x + i5 < i3 && a.y + i6 < i4 && i6 <= a.height && (row == null || a.height < row.height)) {
                        row = a;
                    }
                }
                if (row == null) {
                    SkylinePage.Row b = skylinePage.rows.b();
                    if (b.y + i6 >= i4) {
                        continue;
                    } else if (b.x + i5 < i3) {
                        b.height = Math.max(b.height, i6);
                        row = b;
                    } else if (b.y + b.height + i6 < i4) {
                        row = new SkylinePage.Row();
                        row.y = b.y + b.height;
                        row.height = i6;
                        skylinePage.rows.a((a<SkylinePage.Row>) row);
                    }
                }
                if (row != null) {
                    nVar.x = row.x;
                    nVar.y = row.y;
                    row.x += i5;
                    return skylinePage;
                }
            }
            SkylinePage skylinePage2 = new SkylinePage(pixmapPacker);
            pixmapPacker.pages.a((a<Page>) skylinePage2);
            SkylinePage.Row row2 = new SkylinePage.Row();
            row2.x = i5 + i;
            row2.y = i;
            row2.height = i6;
            skylinePage2.rows.a((a<SkylinePage.Row>) row2);
            float f = i;
            nVar.x = f;
            nVar.y = f;
            return skylinePage2;
        }

        /* loaded from: classes.dex */
        static class SkylinePage extends Page {
            a<Row> rows;

            public SkylinePage(PixmapPacker pixmapPacker) {
                super(pixmapPacker);
                this.rows = new a<>();
            }

            /* loaded from: classes.dex */
            static class Row {
                int height;
                int x;
                int y;

                Row() {
                }
            }
        }
    }

    public ka getTransparentColor() {
        return this.transparentColor;
    }

    public void setTransparentColor(ka kaVar) {
        this.transparentColor.a(kaVar);
    }

    private int[] getSplits(km kmVar) {
        int b;
        int c;
        int splitPoint = getSplitPoint(kmVar, 1, 0, true, true);
        int splitPoint2 = getSplitPoint(kmVar, splitPoint, 0, false, true);
        int splitPoint3 = getSplitPoint(kmVar, 0, 1, true, false);
        int splitPoint4 = getSplitPoint(kmVar, 0, splitPoint3, false, false);
        getSplitPoint(kmVar, splitPoint2 + 1, 0, true, true);
        getSplitPoint(kmVar, 0, splitPoint4 + 1, true, false);
        if (splitPoint == 0 && splitPoint2 == 0 && splitPoint3 == 0 && splitPoint4 == 0) {
            return null;
        }
        if (splitPoint != 0) {
            splitPoint--;
            b = (kmVar.b() - 2) - (splitPoint2 - 1);
        } else {
            b = kmVar.b() - 2;
        }
        if (splitPoint3 != 0) {
            splitPoint3--;
            c = (kmVar.c() - 2) - (splitPoint4 - 1);
        } else {
            c = kmVar.c() - 2;
        }
        return new int[]{splitPoint, b, splitPoint3, c};
    }

    private int[] getPads(km kmVar, int[] iArr) {
        int b;
        int c = kmVar.c() - 1;
        int b2 = kmVar.b() - 1;
        int splitPoint = getSplitPoint(kmVar, 1, c, true, true);
        int splitPoint2 = getSplitPoint(kmVar, b2, 1, true, false);
        int splitPoint3 = splitPoint != 0 ? getSplitPoint(kmVar, splitPoint + 1, c, false, true) : 0;
        int splitPoint4 = splitPoint2 != 0 ? getSplitPoint(kmVar, b2, splitPoint2 + 1, false, false) : 0;
        getSplitPoint(kmVar, splitPoint3 + 1, c, true, true);
        getSplitPoint(kmVar, b2, splitPoint4 + 1, true, false);
        if (splitPoint == 0 && splitPoint3 == 0 && splitPoint2 == 0 && splitPoint4 == 0) {
            return null;
        }
        int i = -1;
        if (splitPoint == 0 && splitPoint3 == 0) {
            b = -1;
            splitPoint = -1;
        } else if (splitPoint > 0) {
            splitPoint--;
            b = (kmVar.b() - 2) - (splitPoint3 - 1);
        } else {
            b = kmVar.b() - 2;
        }
        if (splitPoint2 == 0 && splitPoint4 == 0) {
            splitPoint2 = -1;
        } else if (splitPoint2 > 0) {
            splitPoint2--;
            i = (kmVar.c() - 2) - (splitPoint4 - 1);
        } else {
            i = kmVar.c() - 2;
        }
        int[] iArr2 = {splitPoint, b, splitPoint2, i};
        if (iArr == null || !Arrays.equals(iArr2, iArr)) {
            return iArr2;
        }
        return null;
    }

    private int getSplitPoint(km kmVar, int i, int i2, boolean z, boolean z2) {
        int[] iArr = new int[4];
        int b = z2 ? kmVar.b() : kmVar.c();
        int i3 = z ? 255 : 0;
        for (int i4 = z2 ? i : i2; i4 != b; i4++) {
            if (z2) {
                i = i4;
            } else {
                i2 = i4;
            }
            this.c.a(kmVar.a(i, i2));
            iArr[0] = (int) (this.c.J * 255.0f);
            iArr[1] = (int) (this.c.K * 255.0f);
            iArr[2] = (int) (this.c.L * 255.0f);
            iArr[3] = (int) (this.c.M * 255.0f);
            if (iArr[3] == i3) {
                return i4;
            }
            if (!z && (iArr[0] != 0 || iArr[1] != 0 || iArr[2] != 0 || iArr[3] != 255)) {
                PrintStream printStream = System.out;
                printStream.println(i + "  " + i2 + " " + iArr + " ");
            }
        }
        return 0;
    }

    /* loaded from: classes.dex */
    public static class PixmapPackerRectangle extends n {
        int offsetX;
        int offsetY;
        int originalHeight;
        int originalWidth;
        int[] pads;
        int[] splits;

        PixmapPackerRectangle(int i, int i2, int i3, int i4) {
            super(i, i2, i3, i4);
            this.offsetX = 0;
            this.offsetY = 0;
            this.originalWidth = i3;
            this.originalHeight = i4;
        }

        PixmapPackerRectangle(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            super(i, i2, i3, i4);
            this.offsetX = i5;
            this.offsetY = i6;
            this.originalWidth = i7;
            this.originalHeight = i8;
        }
    }
}
