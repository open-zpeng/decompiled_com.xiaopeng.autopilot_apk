package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.utils.v;
import com.badlogic.gdx.utils.x;
import defpackage.ko;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PixmapPackerIO {

    /* loaded from: classes.dex */
    public static class SaveParameters {
        public ImageFormat format = ImageFormat.PNG;
        public ko.a minFilter = ko.a.Nearest;
        public ko.a magFilter = ko.a.Nearest;
    }

    /* loaded from: classes.dex */
    public enum ImageFormat {
        CIM(".cim"),
        PNG(".png");
        
        private final String extension;

        public String getExtension() {
            return this.extension;
        }

        ImageFormat(String str) {
            this.extension = str;
        }
    }

    public void save(jy jyVar, PixmapPacker pixmapPacker) throws IOException {
        save(jyVar, pixmapPacker, new SaveParameters());
    }

    public void save(jy jyVar, PixmapPacker pixmapPacker, SaveParameters saveParameters) throws IOException {
        Writer writer = jyVar.writer(false);
        Iterator<PixmapPacker.Page> it = pixmapPacker.pages.iterator();
        int i = 0;
        while (it.hasNext()) {
            PixmapPacker.Page next = it.next();
            if (next.rects.a > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(jyVar.nameWithoutExtension());
                sb.append("_");
                i++;
                sb.append(i);
                sb.append(saveParameters.format.getExtension());
                jy sibling = jyVar.sibling(sb.toString());
                switch (saveParameters.format) {
                    case CIM:
                        kn.a(sibling, next.image);
                        break;
                    case PNG:
                        kn.b(sibling, next.image);
                        break;
                }
                writer.write("\n");
                writer.write(sibling.name() + "\n");
                writer.write("size: " + next.image.b() + "," + next.image.c() + "\n");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("format: ");
                sb2.append(pixmapPacker.pageFormat.name());
                sb2.append("\n");
                writer.write(sb2.toString());
                writer.write("filter: " + saveParameters.minFilter.name() + "," + saveParameters.magFilter.name() + "\n");
                writer.write("repeat: none\n");
                v.c<String> it2 = next.rects.e().iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    writer.write(next2 + "\n");
                    PixmapPacker.PixmapPackerRectangle a = next.rects.a((x<String, PixmapPacker.PixmapPackerRectangle>) next2);
                    writer.write("  rotate: false\n");
                    writer.write("  xy: " + ((int) a.x) + "," + ((int) a.y) + "\n");
                    writer.write("  size: " + ((int) a.width) + "," + ((int) a.height) + "\n");
                    if (a.splits != null) {
                        writer.write("  split: " + a.splits[0] + ", " + a.splits[1] + ", " + a.splits[2] + ", " + a.splits[3] + "\n");
                        if (a.pads != null) {
                            writer.write("  pad: " + a.pads[0] + ", " + a.pads[1] + ", " + a.pads[2] + ", " + a.pads[3] + "\n");
                        }
                    }
                    writer.write("  orig: " + a.originalWidth + ", " + a.originalHeight + "\n");
                    writer.write("  offset: " + a.offsetX + ", " + ((int) ((((float) a.originalHeight) - a.height) - ((float) a.offsetY))) + "\n");
                    writer.write("  index: -1\n");
                }
            }
        }
        writer.close();
    }
}
