package defpackage;

import com.badlogic.gdx.utils.a;
import com.google.protobuf.CodedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
/* compiled from: ObjLoader.java */
/* renamed from: lv  reason: default package */
/* loaded from: classes.dex */
class lv {
    public a<mf> a = new a<>();

    public void a(jy jyVar) {
        String str = "default";
        ka kaVar = ka.a;
        ka kaVar2 = ka.a;
        if (jyVar == null || !jyVar.exists()) {
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jyVar.read()), CodedOutputStream.DEFAULT_BUFFER_SIZE);
        String str2 = null;
        float f = 0.0f;
        float f2 = 1.0f;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.length() > 0 && readLine.charAt(0) == '\t') {
                    readLine = readLine.substring(1).trim();
                }
                String[] split = readLine.split("\\s+");
                if (split[0].length() != 0 && split[0].charAt(0) != '#') {
                    String lowerCase = split[0].toLowerCase();
                    if (lowerCase.equals("newmtl")) {
                        mf mfVar = new mf();
                        mfVar.a = str;
                        mfVar.c = new ka(kaVar);
                        mfVar.d = new ka(kaVar2);
                        mfVar.h = f2;
                        mfVar.g = f;
                        if (str2 != null) {
                            mm mmVar = new mm();
                            mmVar.e = 2;
                            mmVar.b = new String(str2);
                            if (mfVar.i == null) {
                                mfVar.i = new a<>(1);
                            }
                            mfVar.i.a((a<mm>) mmVar);
                        }
                        this.a.a((a<mf>) mfVar);
                        str = split.length > 1 ? split[1].replace('.', '_') : "default";
                        kaVar = ka.a;
                        kaVar2 = ka.a;
                        f2 = 1.0f;
                        f = 0.0f;
                    } else {
                        if (!lowerCase.equals("kd") && !lowerCase.equals("ks")) {
                            if (!lowerCase.equals("tr") && !lowerCase.equals("d")) {
                                if (lowerCase.equals("ns")) {
                                    f = Float.parseFloat(split[1]);
                                } else if (lowerCase.equals("map_kd")) {
                                    str2 = jyVar.parent().child(split[1]).path();
                                }
                            }
                            f2 = Float.parseFloat(split[1]);
                        }
                        float parseFloat = Float.parseFloat(split[1]);
                        float parseFloat2 = Float.parseFloat(split[2]);
                        float parseFloat3 = Float.parseFloat(split[3]);
                        float parseFloat4 = split.length > 4 ? Float.parseFloat(split[4]) : 1.0f;
                        if (split[0].toLowerCase().equals("kd")) {
                            kaVar = new ka();
                            kaVar.a(parseFloat, parseFloat2, parseFloat3, parseFloat4);
                        } else {
                            kaVar2 = new ka();
                            kaVar2.a(parseFloat, parseFloat2, parseFloat3, parseFloat4);
                        }
                    }
                }
            } catch (IOException unused) {
                return;
            }
        }
        bufferedReader.close();
        mf mfVar2 = new mf();
        mfVar2.a = str;
        mfVar2.c = new ka(kaVar);
        mfVar2.d = new ka(kaVar2);
        mfVar2.h = f2;
        mfVar2.g = f;
        if (str2 != null) {
            mm mmVar2 = new mm();
            mmVar2.e = 2;
            mmVar2.b = new String(str2);
            if (mfVar2.i == null) {
                mfVar2.i = new a<>(1);
            }
            mfVar2.i.a((a<mm>) mmVar2);
        }
        this.a.a((a<mf>) mfVar2);
    }

    public mf a(String str) {
        Iterator<mf> it = this.a.iterator();
        while (it.hasNext()) {
            mf next = it.next();
            if (next.a.equals(str)) {
                return next;
            }
        }
        mf mfVar = new mf();
        mfVar.a = str;
        mfVar.c = new ka(ka.a);
        this.a.a((a<mf>) mfVar);
        return mfVar;
    }
}
