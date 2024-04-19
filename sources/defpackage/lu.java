package defpackage;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.l;
import com.badlogic.gdx.math.o;
import com.badlogic.gdx.math.p;
import com.badlogic.gdx.utils.a;
import com.badlogic.gdx.utils.b;
import com.badlogic.gdx.utils.c;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.q;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import defpackage.jj;
import java.util.Iterator;
/* compiled from: G3dModelLoader.java */
/* renamed from: lu  reason: default package */
/* loaded from: classes.dex */
public class lu extends jj<jj.a> {
    protected final c c;
    private final l d;

    public lu(c cVar) {
        this(cVar, null);
    }

    public lu(c cVar, jh jhVar) {
        super(jhVar);
        this.d = new l();
        this.c = cVar;
    }

    @Override // defpackage.jj
    public me a(jy jyVar, jj.a aVar) {
        return b(jyVar);
    }

    public me b(jy jyVar) {
        q a = this.c.a(jyVar);
        me meVar = new me();
        q c = a.c("version");
        meVar.b[0] = c.c(0);
        meVar.b[1] = c.c(1);
        if (meVar.b[0] != 0 || meVar.b[1] != 1) {
            throw new k("Model version not supported");
        }
        meVar.a = a.a(Constants.ID, "");
        a(meVar, a);
        a(meVar, a, jyVar.parent().path());
        b(meVar, a);
        c(meVar, a);
        return meVar;
    }

    private void a(me meVar, q qVar) {
        q a = qVar.a("meshes");
        if (a != null) {
            meVar.c.c(a.f);
            for (q qVar2 = a.b; qVar2 != null; qVar2 = qVar2.c) {
                mg mgVar = new mg();
                mgVar.a = qVar2.a(Constants.ID, "");
                mgVar.b = a(qVar2.c("attributes"));
                mgVar.c = qVar2.c("vertices").i();
                q c = qVar2.c("parts");
                a aVar = new a();
                for (q qVar3 = c.b; qVar3 != null; qVar3 = qVar3.c) {
                    mh mhVar = new mh();
                    String a2 = qVar3.a(Constants.ID, (String) null);
                    if (a2 == null) {
                        throw new k("Not id given for mesh part");
                    }
                    Iterator it = aVar.iterator();
                    while (it.hasNext()) {
                        if (((mh) it.next()).a.equals(a2)) {
                            throw new k("Mesh part with id '" + a2 + "' already in defined");
                        }
                    }
                    mhVar.a = a2;
                    String a3 = qVar3.a("type", (String) null);
                    if (a3 == null) {
                        throw new k("No primitive type given for mesh part '" + a2 + "'");
                    }
                    mhVar.c = a(a3);
                    mhVar.b = qVar3.c("indices").j();
                    aVar.a((a) mhVar);
                }
                mgVar.d = (mh[]) aVar.a(mh.class);
                meVar.c.a((a<mg>) mgVar);
            }
        }
    }

    private int a(String str) {
        if (str.equals("TRIANGLES")) {
            return 4;
        }
        if (str.equals("LINES")) {
            return 1;
        }
        if (str.equals("POINTS")) {
            return 0;
        }
        if (str.equals("TRIANGLE_STRIP")) {
            return 5;
        }
        if (str.equals("LINE_STRIP")) {
            return 3;
        }
        throw new k("Unknown primitive type '" + str + "', should be one of triangle, trianglestrip, line, linestrip, lineloop or point");
    }

    private ks[] a(q qVar) {
        a aVar = new a();
        int i = 0;
        int i2 = 0;
        for (q qVar2 = qVar.b; qVar2 != null; qVar2 = qVar2.c) {
            String a = qVar2.a();
            if (a.equals("POSITION")) {
                aVar.a((a) ks.a());
            } else if (a.equals("NORMAL")) {
                aVar.a((a) ks.b());
            } else if (a.equals("COLOR")) {
                aVar.a((a) ks.d());
            } else if (a.equals("COLORPACKED")) {
                aVar.a((a) ks.c());
            } else if (a.equals("TANGENT")) {
                aVar.a((a) ks.e());
            } else if (a.equals("BINORMAL")) {
                aVar.a((a) ks.f());
            } else if (a.startsWith("TEXCOORD")) {
                aVar.a((a) ks.a(i));
                i++;
            } else if (a.startsWith("BLENDWEIGHT")) {
                aVar.a((a) ks.b(i2));
                i2++;
            } else {
                throw new k("Unknown vertex attribute '" + a + "', should be one of position, normal, uv, tangent or binormal");
            }
        }
        return (ks[]) aVar.a(ks.class);
    }

    private void a(me meVar, q qVar, String str) {
        q a = qVar.a("materials");
        if (a == null) {
            return;
        }
        meVar.d.c(a.f);
        for (q qVar2 = a.b; qVar2 != null; qVar2 = qVar2.c) {
            mf mfVar = new mf();
            String a2 = qVar2.a(Constants.ID, (String) null);
            if (a2 == null) {
                throw new k("Material needs an id.");
            }
            mfVar.a = a2;
            q a3 = qVar2.a("diffuse");
            if (a3 != null) {
                mfVar.c = b(a3);
            }
            q a4 = qVar2.a("ambient");
            if (a4 != null) {
                mfVar.b = b(a4);
            }
            q a5 = qVar2.a("emissive");
            if (a5 != null) {
                mfVar.e = b(a5);
            }
            q a6 = qVar2.a("specular");
            if (a6 != null) {
                mfVar.d = b(a6);
            }
            q a7 = qVar2.a("reflection");
            if (a7 != null) {
                mfVar.f = b(a7);
            }
            mfVar.g = qVar2.a("shininess", 0.0f);
            mfVar.h = qVar2.a("opacity", 1.0f);
            q a8 = qVar2.a("textures");
            if (a8 != null) {
                for (q qVar3 = a8.b; qVar3 != null; qVar3 = qVar3.c) {
                    mm mmVar = new mm();
                    String a9 = qVar3.a(Constants.ID, (String) null);
                    if (a9 == null) {
                        throw new k("Texture has no id.");
                    }
                    mmVar.a = a9;
                    String a10 = qVar3.a("filename", (String) null);
                    if (a10 == null) {
                        throw new k("Texture needs filename.");
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append((str.length() == 0 || str.endsWith("/")) ? "" : "/");
                    sb.append(a10);
                    mmVar.b = sb.toString();
                    mmVar.c = a(qVar3.a("uvTranslation"), 0.0f, 0.0f);
                    mmVar.d = a(qVar3.a("uvScaling"), 1.0f, 1.0f);
                    String a11 = qVar3.a("type", (String) null);
                    if (a11 == null) {
                        throw new k("Texture needs type.");
                    }
                    mmVar.e = b(a11);
                    if (mfVar.i == null) {
                        mfVar.i = new a<>();
                    }
                    mfVar.i.a((a<mm>) mmVar);
                }
                continue;
            }
            meVar.d.a((a<mf>) mfVar);
        }
    }

    private int b(String str) {
        if (str.equalsIgnoreCase("AMBIENT")) {
            return 4;
        }
        if (str.equalsIgnoreCase("BUMP")) {
            return 8;
        }
        if (str.equalsIgnoreCase("DIFFUSE")) {
            return 2;
        }
        if (str.equalsIgnoreCase("EMISSIVE")) {
            return 3;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return 1;
        }
        if (str.equalsIgnoreCase("NORMAL")) {
            return 7;
        }
        if (str.equalsIgnoreCase("REFLECTION")) {
            return 10;
        }
        if (str.equalsIgnoreCase("SHININESS")) {
            return 6;
        }
        if (str.equalsIgnoreCase("SPECULAR")) {
            return 5;
        }
        return str.equalsIgnoreCase("TRANSPARENCY") ? 9 : 0;
    }

    private ka b(q qVar) {
        if (qVar.f >= 3) {
            return new ka(qVar.b(0), qVar.b(1), qVar.b(2), 1.0f);
        }
        throw new k("Expected Color values <> than three.");
    }

    private o a(q qVar, float f, float f2) {
        if (qVar == null) {
            return new o(f, f2);
        }
        if (qVar.f == 2) {
            return new o(qVar.b(0), qVar.b(1));
        }
        throw new k("Expected Vector2 values <> than two.");
    }

    private a<mi> b(me meVar, q qVar) {
        q a = qVar.a("nodes");
        if (a != null) {
            meVar.e.c(a.f);
            for (q qVar2 = a.b; qVar2 != null; qVar2 = qVar2.c) {
                meVar.e.a((a<mi>) c(qVar2));
            }
        }
        return meVar.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v9 */
    private mi c(q qVar) {
        int i;
        int i2;
        char c;
        int i3;
        int i4;
        int i5;
        mi miVar = new mi();
        String str = null;
        String a = qVar.a(Constants.ID, (String) null);
        if (a == null) {
            throw new k("Node id missing.");
        }
        miVar.a = a;
        q a2 = qVar.a("translation");
        int i6 = 3;
        if (a2 == null || a2.f == 3) {
            char c2 = 2;
            int i7 = 0;
            boolean z = true;
            miVar.b = a2 == null ? null : new p(a2.b(0), a2.b(1), a2.b(2));
            q a3 = qVar.a("rotation");
            if (a3 == null || a3.f == 4) {
                miVar.c = a3 == null ? null : new l(a3.b(0), a3.b(1), a3.b(2), a3.b(3));
                q a4 = qVar.a("scale");
                if (a4 == null || a4.f == 3) {
                    miVar.d = a4 == null ? null : new p(a4.b(0), a4.b(1), a4.b(2));
                    String a5 = qVar.a("mesh", (String) null);
                    if (a5 != null) {
                        miVar.e = a5;
                    }
                    q a6 = qVar.a("parts");
                    if (a6 != null) {
                        miVar.f = new ml[a6.f];
                        q qVar2 = a6.b;
                        int i8 = 0;
                        while (qVar2 != null) {
                            ml mlVar = new ml();
                            String a7 = qVar2.a("meshpartid", str);
                            String a8 = qVar2.a("materialid", str);
                            if (a7 == null || a8 == null) {
                                throw new k("Node " + a + " part is missing meshPartId or materialId");
                            }
                            mlVar.a = a8;
                            mlVar.b = a7;
                            q a9 = qVar2.a("bones");
                            if (a9 != null) {
                                mlVar.c = new b<>(z, a9.f, String.class, Matrix4.class);
                                q qVar3 = a9.b;
                                ?? r9 = z;
                                while (qVar3 != null) {
                                    String a10 = qVar3.a("node", str);
                                    if (a10 == null) {
                                        throw new k("Bone node ID missing");
                                    }
                                    Matrix4 matrix4 = new Matrix4();
                                    q a11 = qVar3.a("translation");
                                    if (a11 != null && a11.f >= i6) {
                                        matrix4.e(a11.b(i7), a11.b((int) r9), a11.b(2));
                                    }
                                    q a12 = qVar3.a("rotation");
                                    if (a12 == null || a12.f < 4) {
                                        i4 = 3;
                                    } else {
                                        i4 = 3;
                                        matrix4.c(this.d.a(a12.b(i7), a12.b((int) r9), a12.b(2), a12.b(3)));
                                    }
                                    q a13 = qVar3.a("scale");
                                    if (a13 == null || a13.f < i4) {
                                        i5 = 0;
                                    } else {
                                        i5 = 0;
                                        matrix4.f(a13.b(0), a13.b(1), a13.b(2));
                                    }
                                    mlVar.c.a(a10, matrix4);
                                    qVar3 = qVar3.c;
                                    i7 = i5;
                                    i6 = i4;
                                    str = null;
                                    r9 = 1;
                                }
                                i2 = i6;
                                i3 = i7;
                                c = 2;
                            } else {
                                i2 = i6;
                                c = c2;
                                i3 = i7;
                            }
                            miVar.f[i8] = mlVar;
                            qVar2 = qVar2.c;
                            i8++;
                            i7 = i3;
                            i6 = i2;
                            c2 = c;
                            z = true;
                            str = null;
                        }
                        i = i7;
                    } else {
                        i = 0;
                    }
                    q a14 = qVar.a("children");
                    if (a14 != null) {
                        miVar.g = new mi[a14.f];
                        q qVar4 = a14.b;
                        while (qVar4 != null) {
                            miVar.g[i] = c(qVar4);
                            qVar4 = qVar4.c;
                            i++;
                        }
                    }
                    return miVar;
                }
                throw new k("Node scale incomplete");
            }
            throw new k("Node rotation incomplete");
        }
        throw new k("Node translation incomplete");
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [T, com.badlogic.gdx.math.p] */
    /* JADX WARN: Type inference failed for: r12v8, types: [T, com.badlogic.gdx.math.l] */
    /* JADX WARN: Type inference failed for: r7v34, types: [T, com.badlogic.gdx.math.p] */
    /* JADX WARN: Type inference failed for: r8v12, types: [T, com.badlogic.gdx.math.p] */
    /* JADX WARN: Type inference failed for: r8v16, types: [T, com.badlogic.gdx.math.p] */
    /* JADX WARN: Type inference failed for: r8v8, types: [T, com.badlogic.gdx.math.l] */
    private void c(me meVar, q qVar) {
        q a = qVar.a("animations");
        if (a == null) {
            return;
        }
        meVar.f.c(a.f);
        for (q qVar2 = a.b; qVar2 != null; qVar2 = qVar2.c) {
            q a2 = qVar2.a("bones");
            if (a2 != null) {
                md mdVar = new md();
                meVar.f.a((a<md>) mdVar);
                mdVar.b.c(a2.f);
                mdVar.a = qVar2.d(Constants.ID);
                for (q qVar3 = a2.b; qVar3 != null; qVar3 = qVar3.c) {
                    mj mjVar = new mj();
                    mdVar.b.a((a<mj>) mjVar);
                    mjVar.a = qVar3.d("boneId");
                    q a3 = qVar3.a("keyframes");
                    int i = 4;
                    float f = 1000.0f;
                    float f2 = 0.0f;
                    int i2 = 2;
                    int i3 = 3;
                    if (a3 != null && a3.k()) {
                        q qVar4 = a3.b;
                        while (qVar4 != null) {
                            float a4 = qVar4.a("keytime", f2) / f;
                            q a5 = qVar4.a("translation");
                            if (a5 != null && a5.f == i3) {
                                if (mjVar.b == null) {
                                    mjVar.b = new a<>();
                                }
                                mk<p> mkVar = new mk<>();
                                mkVar.a = a4;
                                mkVar.b = new p(a5.b(0), a5.b(1), a5.b(i2));
                                mjVar.b.a((a<mk<p>>) mkVar);
                            }
                            q a6 = qVar4.a("rotation");
                            if (a6 != null && a6.f == i) {
                                if (mjVar.c == null) {
                                    mjVar.c = new a<>();
                                }
                                mk<l> mkVar2 = new mk<>();
                                mkVar2.a = a4;
                                mkVar2.b = new l(a6.b(0), a6.b(1), a6.b(i2), a6.b(3));
                                mjVar.c.a((a<mk<l>>) mkVar2);
                            }
                            q a7 = qVar4.a("scale");
                            if (a7 != null && a7.f == 3) {
                                if (mjVar.d == null) {
                                    mjVar.d = new a<>();
                                }
                                mk<p> mkVar3 = new mk<>();
                                mkVar3.a = a4;
                                mkVar3.b = new p(a7.b(0), a7.b(1), a7.b(2));
                                mjVar.d.a((a<mk<p>>) mkVar3);
                            }
                            qVar4 = qVar4.c;
                            i = 4;
                            f = 1000.0f;
                            f2 = 0.0f;
                            i2 = 2;
                            i3 = 3;
                        }
                    } else {
                        q a8 = qVar3.a("translation");
                        if (a8 != null && a8.k()) {
                            mjVar.b = new a<>();
                            mjVar.b.c(a8.f);
                            for (q qVar5 = a8.b; qVar5 != null; qVar5 = qVar5.c) {
                                mk<p> mkVar4 = new mk<>();
                                mjVar.b.a((a<mk<p>>) mkVar4);
                                mkVar4.a = qVar5.a("keytime", 0.0f) / 1000.0f;
                                q a9 = qVar5.a("value");
                                if (a9 != null && a9.f >= 3) {
                                    mkVar4.b = new p(a9.b(0), a9.b(1), a9.b(2));
                                }
                            }
                        }
                        q a10 = qVar3.a("rotation");
                        if (a10 != null && a10.k()) {
                            mjVar.c = new a<>();
                            mjVar.c.c(a10.f);
                            for (q qVar6 = a10.b; qVar6 != null; qVar6 = qVar6.c) {
                                mk<l> mkVar5 = new mk<>();
                                mjVar.c.a((a<mk<l>>) mkVar5);
                                mkVar5.a = qVar6.a("keytime", 0.0f) / 1000.0f;
                                q a11 = qVar6.a("value");
                                if (a11 != null && a11.f >= 4) {
                                    mkVar5.b = new l(a11.b(0), a11.b(1), a11.b(2), a11.b(3));
                                }
                            }
                        }
                        q a12 = qVar3.a("scaling");
                        if (a12 != null && a12.k()) {
                            mjVar.d = new a<>();
                            mjVar.d.c(a12.f);
                            for (q qVar7 = a12.b; qVar7 != null; qVar7 = qVar7.c) {
                                mk<p> mkVar6 = new mk<>();
                                mjVar.d.a((a<mk<p>>) mkVar6);
                                mkVar6.a = qVar7.a("keytime", 0.0f) / 1000.0f;
                                q a13 = qVar7.a("value");
                                if (a13 != null && a13.f >= 3) {
                                    mkVar6.b = new p(a13.b(0), a13.b(1), a13.b(2));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
