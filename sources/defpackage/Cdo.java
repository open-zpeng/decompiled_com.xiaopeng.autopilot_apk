package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.b;
import androidx.constraintlayout.widget.e;
import com.xiaopeng.libtheme.ThemeManager;
import defpackage.da;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MotionConstrainedPoint.java */
/* renamed from: do  reason: invalid class name and default package */
/* loaded from: classes.dex */
public class Cdo implements Comparable<Cdo> {
    static String[] d = {"position", "x", "y", "width", "height", "pathRotate"};
    private float A;
    int b;
    private bh u;
    private float w;
    private float x;
    private float y;
    private float z;
    private float i = 1.0f;
    int a = 0;
    private boolean j = false;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    public float c = 0.0f;
    private float n = 1.0f;
    private float o = 1.0f;
    private float p = Float.NaN;
    private float q = Float.NaN;
    private float r = 0.0f;
    private float s = 0.0f;
    private float t = 0.0f;
    private int v = 0;
    private float B = Float.NaN;
    private float C = Float.NaN;
    private int D = -1;
    LinkedHashMap<String, b> e = new LinkedHashMap<>();
    int f = 0;
    double[] g = new double[18];
    double[] h = new double[18];

    private boolean a(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Cdo cdo, HashSet<String> hashSet) {
        if (a(this.i, cdo.i)) {
            hashSet.add(ThemeManager.AttributeSet.ALPHA);
        }
        if (a(this.k, cdo.k)) {
            hashSet.add("elevation");
        }
        int i = this.b;
        int i2 = cdo.b;
        if (i != i2 && this.a == 0 && (i == 0 || i2 == 0)) {
            hashSet.add(ThemeManager.AttributeSet.ALPHA);
        }
        if (a(this.l, cdo.l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.B) || !Float.isNaN(cdo.B)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.C) || !Float.isNaN(cdo.C)) {
            hashSet.add("progress");
        }
        if (a(this.m, cdo.m)) {
            hashSet.add("rotationX");
        }
        if (a(this.c, cdo.c)) {
            hashSet.add("rotationY");
        }
        if (a(this.p, cdo.p)) {
            hashSet.add("transformPivotX");
        }
        if (a(this.q, cdo.q)) {
            hashSet.add("transformPivotY");
        }
        if (a(this.n, cdo.n)) {
            hashSet.add("scaleX");
        }
        if (a(this.o, cdo.o)) {
            hashSet.add("scaleY");
        }
        if (a(this.r, cdo.r)) {
            hashSet.add("translationX");
        }
        if (a(this.s, cdo.s)) {
            hashSet.add("translationY");
        }
        if (a(this.t, cdo.t)) {
            hashSet.add("translationZ");
        }
    }

    void a(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.A = f4;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cdo cdo) {
        return Float.compare(this.w, cdo.w);
    }

    public void a(View view) {
        this.b = view.getVisibility();
        this.i = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.j = false;
        if (Build.VERSION.SDK_INT >= 21) {
            this.k = view.getElevation();
        }
        this.l = view.getRotation();
        this.m = view.getRotationX();
        this.c = view.getRotationY();
        this.n = view.getScaleX();
        this.o = view.getScaleY();
        this.p = view.getPivotX();
        this.q = view.getPivotY();
        this.r = view.getTranslationX();
        this.s = view.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21) {
            this.t = view.getTranslationZ();
        }
    }

    public void a(e.a aVar) {
        this.a = aVar.c.c;
        this.b = aVar.c.b;
        this.i = (aVar.c.b == 0 || this.a != 0) ? aVar.c.d : 0.0f;
        this.j = aVar.f.m;
        this.k = aVar.f.n;
        this.l = aVar.f.b;
        this.m = aVar.f.c;
        this.c = aVar.f.d;
        this.n = aVar.f.e;
        this.o = aVar.f.f;
        this.p = aVar.f.g;
        this.q = aVar.f.h;
        this.r = aVar.f.j;
        this.s = aVar.f.k;
        this.t = aVar.f.l;
        this.u = bh.a(aVar.d.d);
        this.B = aVar.d.i;
        this.v = aVar.d.f;
        this.D = aVar.d.b;
        this.C = aVar.c.e;
        for (String str : aVar.g.keySet()) {
            b bVar = aVar.g.get(str);
            if (bVar.b()) {
                this.e.put(str, bVar);
            }
        }
    }

    public void a(HashMap<String, da> hashMap, int i) {
        for (String str : hashMap.keySet()) {
            da daVar = hashMap.get(str);
            char c = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c = 5;
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c = 6;
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c = 2;
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c = 1;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c = 7;
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals(ThemeManager.AttributeSet.ALPHA)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    daVar.a(i, Float.isNaN(this.i) ? 1.0f : this.i);
                    break;
                case 1:
                    daVar.a(i, Float.isNaN(this.k) ? 0.0f : this.k);
                    break;
                case 2:
                    daVar.a(i, Float.isNaN(this.l) ? 0.0f : this.l);
                    break;
                case 3:
                    daVar.a(i, Float.isNaN(this.m) ? 0.0f : this.m);
                    break;
                case 4:
                    daVar.a(i, Float.isNaN(this.c) ? 0.0f : this.c);
                    break;
                case 5:
                    daVar.a(i, Float.isNaN(this.p) ? 0.0f : this.p);
                    break;
                case 6:
                    daVar.a(i, Float.isNaN(this.q) ? 0.0f : this.q);
                    break;
                case 7:
                    daVar.a(i, Float.isNaN(this.B) ? 0.0f : this.B);
                    break;
                case '\b':
                    daVar.a(i, Float.isNaN(this.C) ? 0.0f : this.C);
                    break;
                case '\t':
                    daVar.a(i, Float.isNaN(this.n) ? 1.0f : this.n);
                    break;
                case '\n':
                    daVar.a(i, Float.isNaN(this.o) ? 1.0f : this.o);
                    break;
                case 11:
                    daVar.a(i, Float.isNaN(this.r) ? 0.0f : this.r);
                    break;
                case '\f':
                    daVar.a(i, Float.isNaN(this.s) ? 0.0f : this.s);
                    break;
                case '\r':
                    daVar.a(i, Float.isNaN(this.t) ? 0.0f : this.t);
                    break;
                default:
                    if (!str.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    } else {
                        String str2 = str.split(",")[1];
                        if (this.e.containsKey(str2)) {
                            b bVar = this.e.get(str2);
                            if (daVar instanceof da.b) {
                                ((da.b) daVar).a(i, bVar);
                                break;
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i + ", value" + bVar.d() + daVar);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
            }
        }
    }

    public void b(View view) {
        a(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        a(view);
    }

    public void a(Rect rect, View view, int i, float f) {
        a(rect.left, rect.top, rect.width(), rect.height());
        a(view);
        this.p = Float.NaN;
        this.q = Float.NaN;
        switch (i) {
            case 1:
                this.l = f - 90.0f;
                return;
            case 2:
                this.l = f + 90.0f;
                return;
            default:
                return;
        }
    }

    public void a(Rect rect, e eVar, int i, int i2) {
        a(rect.left, rect.top, rect.width(), rect.height());
        a(eVar.a(i2));
        switch (i) {
            case 1:
            case 3:
                this.l -= 90.0f;
                return;
            case 2:
            case 4:
                this.l += 90.0f;
                float f = this.l;
                if (f > 180.0f) {
                    this.l = f - 360.0f;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
