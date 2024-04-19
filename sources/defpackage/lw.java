package defpackage;

import com.badlogic.gdx.math.l;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.h;
import com.google.protobuf.CodedOutputStream;
import defpackage.jj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
/* compiled from: ObjLoader.java */
/* renamed from: lw  reason: default package */
/* loaded from: classes.dex */
public class lw extends jj<b> {
    public static boolean c = false;
    final h d;
    final h e;
    final h f;
    final com.badlogic.gdx.utils.a<a> g;

    /* compiled from: ObjLoader.java */
    /* renamed from: lw$b */
    /* loaded from: classes.dex */
    public static class b extends jj.a {
        public boolean b;
    }

    public lw() {
        this(null);
    }

    public lw(jh jhVar) {
        super(jhVar);
        this.d = new h(300);
        this.e = new h(300);
        this.f = new h(200);
        this.g = new com.badlogic.gdx.utils.a<>(10);
    }

    @Override // defpackage.jj
    public me a(jy jyVar, b bVar) {
        return a(jyVar, bVar != null && bVar.b);
    }

    protected me a(jy jyVar, boolean z) {
        int i;
        int i2;
        char charAt;
        if (c) {
            io.a.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
        }
        lv lvVar = new lv();
        a aVar = new a("default");
        this.g.a((com.badlogic.gdx.utils.a<a>) aVar);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jyVar.read()), CodedOutputStream.DEFAULT_BUFFER_SIZE);
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                i = 3;
                i2 = 2;
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split("\\s+");
                if (split.length < 1) {
                    break;
                } else if (split[0].length() != 0 && (charAt = split[0].toLowerCase().charAt(0)) != '#') {
                    if (charAt == 'v') {
                        if (split[0].length() == 1) {
                            this.d.a(Float.parseFloat(split[1]));
                            this.d.a(Float.parseFloat(split[2]));
                            this.d.a(Float.parseFloat(split[3]));
                        } else if (split[0].charAt(1) == 'n') {
                            this.e.a(Float.parseFloat(split[1]));
                            this.e.a(Float.parseFloat(split[2]));
                            this.e.a(Float.parseFloat(split[3]));
                        } else if (split[0].charAt(1) == 't') {
                            this.f.a(Float.parseFloat(split[1]));
                            this.f.a(z ? 1.0f - Float.parseFloat(split[2]) : Float.parseFloat(split[2]));
                        }
                    } else if (charAt == 'f') {
                        com.badlogic.gdx.utils.a<Integer> aVar2 = aVar.c;
                        int i3 = 1;
                        while (i3 < split.length - 2) {
                            String[] split2 = split[1].split("/");
                            aVar2.a((com.badlogic.gdx.utils.a<Integer>) Integer.valueOf(a(split2[0], this.d.b)));
                            if (split2.length > 2) {
                                if (i3 == 1) {
                                    aVar.e = true;
                                }
                                aVar2.a((com.badlogic.gdx.utils.a<Integer>) Integer.valueOf(a(split2[2], this.e.b)));
                            }
                            if (split2.length > 1 && split2[1].length() > 0) {
                                if (i3 == 1) {
                                    aVar.f = true;
                                }
                                aVar2.a((com.badlogic.gdx.utils.a<Integer>) Integer.valueOf(a(split2[1], this.f.b)));
                            }
                            int i4 = i3 + 1;
                            String[] split3 = split[i4].split("/");
                            aVar2.a((com.badlogic.gdx.utils.a<Integer>) Integer.valueOf(a(split3[0], this.d.b)));
                            if (split3.length > 2) {
                                aVar2.a((com.badlogic.gdx.utils.a<Integer>) Integer.valueOf(a(split3[2], this.e.b)));
                            }
                            if (split3.length > 1 && split3[1].length() > 0) {
                                aVar2.a((com.badlogic.gdx.utils.a<Integer>) Integer.valueOf(a(split3[1], this.f.b)));
                            }
                            int i5 = i4 + 1;
                            String[] split4 = split[i5].split("/");
                            aVar2.a((com.badlogic.gdx.utils.a<Integer>) Integer.valueOf(a(split4[0], this.d.b)));
                            if (split4.length > 2) {
                                aVar2.a((com.badlogic.gdx.utils.a<Integer>) Integer.valueOf(a(split4[2], this.e.b)));
                            }
                            if (split4.length > 1 && split4[1].length() > 0) {
                                aVar2.a((com.badlogic.gdx.utils.a<Integer>) Integer.valueOf(a(split4[1], this.f.b)));
                            }
                            aVar.d++;
                            i3 = i5 - 1;
                        }
                    } else {
                        if (charAt != 'o' && charAt != 'g') {
                            if (split[0].equals("mtllib")) {
                                lvVar.a(jyVar.parent().child(split[1]));
                            } else if (split[0].equals("usemtl")) {
                                if (split.length == 1) {
                                    aVar.b = "default";
                                } else {
                                    aVar.b = split[1].replace('.', '_');
                                }
                            }
                        }
                        if (split.length > 1) {
                            aVar = a(split[1]);
                        } else {
                            aVar = a("default");
                        }
                    }
                }
            } catch (IOException unused) {
                return null;
            }
        }
        bufferedReader.close();
        int i6 = 0;
        while (i6 < this.g.b) {
            if (this.g.a(i6).d < 1) {
                this.g.b(i6);
                i6--;
            }
            i6++;
        }
        if (this.g.b < 1) {
            return null;
        }
        int i7 = this.g.b;
        me meVar = new me();
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            a a2 = this.g.a(i8);
            com.badlogic.gdx.utils.a<Integer> aVar3 = a2.c;
            int i10 = aVar3.b;
            int i11 = a2.d;
            boolean z2 = a2.e;
            boolean z3 = a2.f;
            int i12 = i11 * i;
            float[] fArr = new float[i12 * ((z2 ? i : 0) + 3 + (z3 ? i2 : 0))];
            int i13 = 0;
            int i14 = 0;
            while (i13 < i10) {
                int i15 = i13 + 1;
                int intValue = aVar3.a(i13).intValue() * i;
                int i16 = i14 + 1;
                int i17 = i7;
                int i18 = intValue + 1;
                fArr[i14] = this.d.a(intValue);
                int i19 = i16 + 1;
                int i20 = i10;
                int i21 = i18 + 1;
                fArr[i16] = this.d.a(i18);
                int i22 = i19 + 1;
                fArr[i19] = this.d.a(i21);
                if (z2) {
                    int i23 = i15 + 1;
                    int intValue2 = aVar3.a(i15).intValue() * 3;
                    int i24 = i22 + 1;
                    int i25 = intValue2 + 1;
                    fArr[i22] = this.e.a(intValue2);
                    int i26 = i24 + 1;
                    fArr[i24] = this.e.a(i25);
                    fArr[i26] = this.e.a(i25 + 1);
                    i15 = i23;
                    i22 = i26 + 1;
                }
                if (z3) {
                    int i27 = i15 + 1;
                    int intValue3 = aVar3.a(i15).intValue() * 2;
                    int i28 = i22 + 1;
                    fArr[i22] = this.f.a(intValue3);
                    i22 = i28 + 1;
                    fArr[i28] = this.f.a(intValue3 + 1);
                    i13 = i27;
                } else {
                    i13 = i15;
                }
                i10 = i20;
                i = 3;
                i14 = i22;
                i7 = i17;
            }
            int i29 = i7;
            if (i12 >= 32767) {
                i12 = 0;
            }
            short[] sArr = new short[i12];
            if (i12 > 0) {
                for (int i30 = 0; i30 < i12; i30++) {
                    sArr[i30] = (short) i30;
                }
            }
            com.badlogic.gdx.utils.a aVar4 = new com.badlogic.gdx.utils.a();
            aVar4.a((com.badlogic.gdx.utils.a) new ks(1, 3, "a_position"));
            if (z2) {
                aVar4.a((com.badlogic.gdx.utils.a) new ks(8, 3, "a_normal"));
            }
            if (z3) {
                aVar4.a((com.badlogic.gdx.utils.a) new ks(16, 2, "a_texCoord0"));
            }
            i9++;
            String num = Integer.toString(i9);
            String str = "default".equals(a2.a) ? "node" + num : a2.a;
            String str2 = "default".equals(a2.a) ? "mesh" + num : a2.a;
            String str3 = "default".equals(a2.a) ? "part" + num : a2.a;
            mi miVar = new mi();
            miVar.a = str;
            miVar.e = str2;
            miVar.d = new p(1.0f, 1.0f, 1.0f);
            miVar.b = new p();
            miVar.c = new l();
            ml mlVar = new ml();
            mlVar.b = str3;
            mlVar.a = a2.b;
            miVar.f = new ml[]{mlVar};
            mh mhVar = new mh();
            mhVar.a = str3;
            mhVar.b = sArr;
            mhVar.c = 4;
            mg mgVar = new mg();
            mgVar.a = str2;
            mgVar.b = (ks[]) aVar4.a(ks.class);
            mgVar.c = fArr;
            mgVar.d = new mh[]{mhVar};
            meVar.e.a((com.badlogic.gdx.utils.a<mi>) miVar);
            meVar.c.a((com.badlogic.gdx.utils.a<mg>) mgVar);
            meVar.d.a((com.badlogic.gdx.utils.a<mf>) lvVar.a(a2.b));
            i8++;
            i7 = i29;
            i = 3;
            i2 = 2;
        }
        if (this.d.b > 0) {
            this.d.b();
        }
        if (this.e.b > 0) {
            this.e.b();
        }
        if (this.f.b > 0) {
            this.f.b();
        }
        if (this.g.b > 0) {
            this.g.d();
        }
        return meVar;
    }

    private a a(String str) {
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.a.equals(str)) {
                return next;
            }
        }
        a aVar = new a(str);
        this.g.a((com.badlogic.gdx.utils.a<a>) aVar);
        return aVar;
    }

    private int a(String str, int i) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int parseInt = Integer.parseInt(str);
        return parseInt < 0 ? i + parseInt : parseInt - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ObjLoader.java */
    /* renamed from: lw$a */
    /* loaded from: classes.dex */
    public class a {
        final String a;
        boolean e;
        boolean f;
        com.badlogic.gdx.utils.a<Integer> c = new com.badlogic.gdx.utils.a<>(200);
        int d = 0;
        kx g = new kx("");
        String b = "default";

        a(String str) {
            this.a = str;
        }
    }
}
