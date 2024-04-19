package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.b;
import androidx.constraintlayout.widget.j;
import com.xiaopeng.libtheme.ThemeManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: KeyCycle.java */
/* renamed from: di  reason: default package */
/* loaded from: classes.dex */
public class di extends dg {
    private String g = null;
    private int h = 0;
    private int i = -1;
    private String j = null;
    private float k = Float.NaN;
    private float l = 0.0f;
    private float m = 0.0f;
    private float n = Float.NaN;
    private int o = -1;
    private float p = Float.NaN;
    private float q = Float.NaN;
    private float r = Float.NaN;
    private float s = Float.NaN;
    private float t = Float.NaN;
    private float u = Float.NaN;
    private float v = Float.NaN;
    private float w = Float.NaN;
    private float x = Float.NaN;
    private float y = Float.NaN;
    private float z = Float.NaN;

    public di() {
        this.e = 4;
        this.f = new HashMap<>();
    }

    @Override // defpackage.dg
    public void a(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, j.b.KeyCycle));
    }

    @Override // defpackage.dg
    public void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.p)) {
            hashSet.add(ThemeManager.AttributeSet.ALPHA);
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.x)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.y)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.z)) {
            hashSet.add("translationZ");
        }
        if (this.f.size() > 0) {
            Iterator<String> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public void c(HashMap<String, cz> hashMap) {
        cz czVar;
        cz czVar2;
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                b bVar = this.f.get(str.substring(7));
                if (bVar != null && bVar.a() == b.a.FLOAT_TYPE && (czVar = hashMap.get(str)) != null) {
                    czVar.a(this.b, this.i, this.j, this.o, this.k, this.l, this.m, bVar.d(), bVar);
                }
            } else {
                float b = b(str);
                if (!Float.isNaN(b) && (czVar2 = hashMap.get(str)) != null) {
                    czVar2.a(this.b, this.i, this.j, this.o, this.k, this.l, this.m, b);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public float b(String str) {
        char c;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals(ThemeManager.AttributeSet.ALPHA)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return this.p;
            case 1:
                return this.q;
            case 2:
                return this.r;
            case 3:
                return this.t;
            case 4:
                return this.u;
            case 5:
                return this.s;
            case 6:
                return this.v;
            case 7:
                return this.w;
            case '\b':
                return this.x;
            case '\t':
                return this.y;
            case '\n':
                return this.z;
            case 11:
                return this.l;
            case '\f':
                return this.m;
            case '\r':
                return this.n;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    @Override // defpackage.dg
    public void a(HashMap<String, da> hashMap) {
        dd.a("KeyCycle", "add " + hashMap.size() + " values", 2);
        for (String str : hashMap.keySet()) {
            da daVar = hashMap.get(str);
            if (daVar != null) {
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
                            c = '\b';
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            c = 7;
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
                            c = 5;
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals(ThemeManager.AttributeSet.ALPHA)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            c = '\f';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        daVar.a(this.b, this.p);
                        continue;
                    case 1:
                        daVar.a(this.b, this.q);
                        continue;
                    case 2:
                        daVar.a(this.b, this.r);
                        continue;
                    case 3:
                        daVar.a(this.b, this.t);
                        continue;
                    case 4:
                        daVar.a(this.b, this.u);
                        continue;
                    case 5:
                        daVar.a(this.b, this.s);
                        continue;
                    case 6:
                        daVar.a(this.b, this.v);
                        continue;
                    case 7:
                        daVar.a(this.b, this.w);
                        continue;
                    case '\b':
                        daVar.a(this.b, this.x);
                        continue;
                    case '\t':
                        daVar.a(this.b, this.y);
                        continue;
                    case '\n':
                        daVar.a(this.b, this.z);
                        continue;
                    case 11:
                        daVar.a(this.b, this.l);
                        continue;
                    case '\f':
                        daVar.a(this.b, this.m);
                        continue;
                    case '\r':
                        daVar.a(this.b, this.n);
                        continue;
                    default:
                        if (!str.startsWith("CUSTOM")) {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
    }

    /* compiled from: KeyCycle.java */
    /* renamed from: di$a */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a = new SparseIntArray();

        static {
            a.append(j.b.KeyCycle_motionTarget, 1);
            a.append(j.b.KeyCycle_framePosition, 2);
            a.append(j.b.KeyCycle_transitionEasing, 3);
            a.append(j.b.KeyCycle_curveFit, 4);
            a.append(j.b.KeyCycle_waveShape, 5);
            a.append(j.b.KeyCycle_wavePeriod, 6);
            a.append(j.b.KeyCycle_waveOffset, 7);
            a.append(j.b.KeyCycle_waveVariesBy, 8);
            a.append(j.b.KeyCycle_android_alpha, 9);
            a.append(j.b.KeyCycle_android_elevation, 10);
            a.append(j.b.KeyCycle_android_rotation, 11);
            a.append(j.b.KeyCycle_android_rotationX, 12);
            a.append(j.b.KeyCycle_android_rotationY, 13);
            a.append(j.b.KeyCycle_transitionPathRotate, 14);
            a.append(j.b.KeyCycle_android_scaleX, 15);
            a.append(j.b.KeyCycle_android_scaleY, 16);
            a.append(j.b.KeyCycle_android_translationX, 17);
            a.append(j.b.KeyCycle_android_translationY, 18);
            a.append(j.b.KeyCycle_android_translationZ, 19);
            a.append(j.b.KeyCycle_motionProgress, 20);
            a.append(j.b.KeyCycle_wavePhase, 21);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(di diVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        if (dt.a) {
                            diVar.c = typedArray.getResourceId(index, diVar.c);
                            if (diVar.c == -1) {
                                diVar.d = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            diVar.d = typedArray.getString(index);
                            break;
                        } else {
                            diVar.c = typedArray.getResourceId(index, diVar.c);
                            break;
                        }
                    case 2:
                        diVar.b = typedArray.getInt(index, diVar.b);
                        break;
                    case 3:
                        diVar.g = typedArray.getString(index);
                        break;
                    case 4:
                        diVar.h = typedArray.getInteger(index, diVar.h);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            diVar.j = typedArray.getString(index);
                            diVar.i = 7;
                            break;
                        } else {
                            diVar.i = typedArray.getInt(index, diVar.i);
                            break;
                        }
                    case 6:
                        diVar.k = typedArray.getFloat(index, diVar.k);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            diVar.l = typedArray.getDimension(index, diVar.l);
                            break;
                        } else {
                            diVar.l = typedArray.getFloat(index, diVar.l);
                            break;
                        }
                    case 8:
                        diVar.o = typedArray.getInt(index, diVar.o);
                        break;
                    case 9:
                        diVar.p = typedArray.getFloat(index, diVar.p);
                        break;
                    case 10:
                        diVar.q = typedArray.getDimension(index, diVar.q);
                        break;
                    case 11:
                        diVar.r = typedArray.getFloat(index, diVar.r);
                        break;
                    case 12:
                        diVar.t = typedArray.getFloat(index, diVar.t);
                        break;
                    case 13:
                        diVar.u = typedArray.getFloat(index, diVar.u);
                        break;
                    case 14:
                        diVar.s = typedArray.getFloat(index, diVar.s);
                        break;
                    case 15:
                        diVar.v = typedArray.getFloat(index, diVar.v);
                        break;
                    case 16:
                        diVar.w = typedArray.getFloat(index, diVar.w);
                        break;
                    case 17:
                        diVar.x = typedArray.getDimension(index, diVar.x);
                        break;
                    case 18:
                        diVar.y = typedArray.getDimension(index, diVar.y);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT >= 21) {
                            diVar.z = typedArray.getDimension(index, diVar.z);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        diVar.n = typedArray.getFloat(index, diVar.n);
                        break;
                    case 21:
                        diVar.m = typedArray.getFloat(index, diVar.m) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                }
            }
        }
    }

    @Override // defpackage.dg
    public dg a(dg dgVar) {
        super.a(dgVar);
        di diVar = (di) dgVar;
        this.g = diVar.g;
        this.h = diVar.h;
        this.i = diVar.i;
        this.j = diVar.j;
        this.k = diVar.k;
        this.l = diVar.l;
        this.m = diVar.m;
        this.n = diVar.n;
        this.o = diVar.o;
        this.p = diVar.p;
        this.q = diVar.q;
        this.r = diVar.r;
        this.s = diVar.s;
        this.t = diVar.t;
        this.u = diVar.u;
        this.v = diVar.v;
        this.w = diVar.w;
        this.x = diVar.x;
        this.y = diVar.y;
        this.z = diVar.z;
        return this;
    }

    @Override // defpackage.dg
    /* renamed from: a */
    public dg clone() {
        return new di().a((dg) this);
    }
}
