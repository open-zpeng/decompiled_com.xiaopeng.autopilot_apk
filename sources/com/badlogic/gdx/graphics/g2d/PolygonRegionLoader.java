package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.math.c;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.ak;
import com.badlogic.gdx.utils.k;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.io.BufferedReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class PolygonRegionLoader extends jq<PolygonRegion, PolygonRegionParameters> {
    private PolygonRegionParameters defaultParameters;
    private c triangulator;

    /* loaded from: classes.dex */
    public static class PolygonRegionParameters extends iz<PolygonRegion> {
        public String texturePrefix = "i ";
        public int readerBuffer = 1024;
        public String[] textureExtensions = {"png", "PNG", "jpeg", "JPEG", "jpg", "JPG", "cim", "CIM", "etc1", "ETC1", "ktx", "KTX", "zktx", "ZKTX"};
    }

    public PolygonRegionLoader() {
        this(new jt());
    }

    public PolygonRegionLoader(jh jhVar) {
        super(jhVar);
        this.defaultParameters = new PolygonRegionParameters();
        this.triangulator = new c();
    }

    @Override // defpackage.jq
    public PolygonRegion load(jb jbVar, String str, jy jyVar, PolygonRegionParameters polygonRegionParameters) {
        return load(new TextureRegion((ko) jbVar.a(jbVar.e(str).c())), jyVar);
    }

    @Override // defpackage.jd
    public a<ix> getDependencies(String str, jy jyVar, PolygonRegionParameters polygonRegionParameters) {
        String str2;
        String[] strArr;
        if (polygonRegionParameters == null) {
            polygonRegionParameters = this.defaultParameters;
        }
        try {
            BufferedReader reader = jyVar.reader(polygonRegionParameters.readerBuffer);
            while (true) {
                String readLine = reader.readLine();
                if (readLine != null) {
                    if (readLine.startsWith(polygonRegionParameters.texturePrefix)) {
                        str2 = readLine.substring(polygonRegionParameters.texturePrefix.length());
                        break;
                    }
                } else {
                    str2 = null;
                    break;
                }
            }
            reader.close();
            if (str2 == null && polygonRegionParameters.textureExtensions != null) {
                for (String str3 : polygonRegionParameters.textureExtensions) {
                    jy sibling = jyVar.sibling(jyVar.nameWithoutExtension().concat("." + str3));
                    if (sibling.exists()) {
                        str2 = sibling.name();
                    }
                }
            }
            if (str2 != null) {
                a<ix> aVar = new a<>(1);
                aVar.a((a<ix>) new ix(jyVar.sibling(str2), ko.class));
                return aVar;
            }
            return null;
        } catch (IOException e) {
            throw new k("Error reading " + str, e);
        }
    }

    public PolygonRegion load(TextureRegion textureRegion, jy jyVar) {
        String readLine;
        BufferedReader reader = jyVar.reader(IRadioController.TEF663x_PCHANNEL);
        do {
            try {
                try {
                    readLine = reader.readLine();
                    if (readLine == null) {
                        ak.a(reader);
                        throw new k("Polygon shape not found: " + jyVar);
                    }
                } catch (IOException e) {
                    throw new k("Error reading polygon shape file: " + jyVar, e);
                }
            } finally {
                ak.a(reader);
            }
        } while (!readLine.startsWith("s"));
        String[] split = readLine.substring(1).trim().split(",");
        float[] fArr = new float[split.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr[i] = Float.parseFloat(split[i]);
        }
        return new PolygonRegion(textureRegion, fArr, this.triangulator.a(fArr).b());
    }
}
