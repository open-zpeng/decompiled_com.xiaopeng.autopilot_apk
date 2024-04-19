package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.j;
import com.xiaopeng.libtheme.ThemeManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: KeyTimeCycle.java */
/* renamed from: dm  reason: default package */
/* loaded from: classes.dex */
public class dm extends dg {
    private String g;
    private int h = -1;
    private float i = Float.NaN;
    private float j = Float.NaN;
    private float k = Float.NaN;
    private float l = Float.NaN;
    private float m = Float.NaN;
    private float n = Float.NaN;
    private float o = Float.NaN;
    private float p = Float.NaN;
    private float q = Float.NaN;
    private float r = Float.NaN;
    private float s = Float.NaN;
    private float t = Float.NaN;
    private int u = 0;
    private String v = null;
    private float w = Float.NaN;
    private float x = 0.0f;

    public dm() {
        this.e = 3;
        this.f = new HashMap<>();
    }

    @Override // defpackage.dg
    public void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, j.b.KeyTimeCycle));
    }

    @Override // defpackage.dg
    public void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.i)) {
            hashSet.add(ThemeManager.AttributeSet.ALPHA);
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("progress");
        }
        if (this.f.size() > 0) {
            Iterator<String> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // defpackage.dg
    public void b(HashMap<String, Integer> hashMap) {
        if (this.h == -1) {
            return;
        }
        if (!Float.isNaN(this.i)) {
            hashMap.put(ThemeManager.AttributeSet.ALPHA, Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.j)) {
            hashMap.put("elevation", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.k)) {
            hashMap.put("rotation", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.l)) {
            hashMap.put("rotationX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.m)) {
            hashMap.put("rotationY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.q)) {
            hashMap.put("translationX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("translationY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.s)) {
            hashMap.put("translationZ", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("scaleX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("scaleY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.t)) {
            hashMap.put("progress", Integer.valueOf(this.h));
        }
        if (this.f.size() > 0) {
            Iterator<String> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.h));
            }
        }
    }

    @Override // defpackage.dg
    public void a(HashMap<String, da> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
        if (r1.equals("scaleY") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(java.util.HashMap<java.lang.String, defpackage.dc> r11) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dm.c(java.util.HashMap):void");
    }

    /* compiled from: KeyTimeCycle.java */
    /* renamed from: dm$a */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a = new SparseIntArray();

        static {
            a.append(j.b.KeyTimeCycle_android_alpha, 1);
            a.append(j.b.KeyTimeCycle_android_elevation, 2);
            a.append(j.b.KeyTimeCycle_android_rotation, 4);
            a.append(j.b.KeyTimeCycle_android_rotationX, 5);
            a.append(j.b.KeyTimeCycle_android_rotationY, 6);
            a.append(j.b.KeyTimeCycle_android_scaleX, 7);
            a.append(j.b.KeyTimeCycle_transitionPathRotate, 8);
            a.append(j.b.KeyTimeCycle_transitionEasing, 9);
            a.append(j.b.KeyTimeCycle_motionTarget, 10);
            a.append(j.b.KeyTimeCycle_framePosition, 12);
            a.append(j.b.KeyTimeCycle_curveFit, 13);
            a.append(j.b.KeyTimeCycle_android_scaleY, 14);
            a.append(j.b.KeyTimeCycle_android_translationX, 15);
            a.append(j.b.KeyTimeCycle_android_translationY, 16);
            a.append(j.b.KeyTimeCycle_android_translationZ, 17);
            a.append(j.b.KeyTimeCycle_motionProgress, 18);
            a.append(j.b.KeyTimeCycle_wavePeriod, 20);
            a.append(j.b.KeyTimeCycle_waveOffset, 21);
            a.append(j.b.KeyTimeCycle_waveShape, 19);
        }

        public static void a(dm dmVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        dmVar.i = typedArray.getFloat(index, dmVar.i);
                        break;
                    case 2:
                        dmVar.j = typedArray.getDimension(index, dmVar.j);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                    case 4:
                        dmVar.k = typedArray.getFloat(index, dmVar.k);
                        break;
                    case 5:
                        dmVar.l = typedArray.getFloat(index, dmVar.l);
                        break;
                    case 6:
                        dmVar.m = typedArray.getFloat(index, dmVar.m);
                        break;
                    case 7:
                        dmVar.o = typedArray.getFloat(index, dmVar.o);
                        break;
                    case 8:
                        dmVar.n = typedArray.getFloat(index, dmVar.n);
                        break;
                    case 9:
                        dmVar.g = typedArray.getString(index);
                        break;
                    case 10:
                        if (dt.a) {
                            dmVar.c = typedArray.getResourceId(index, dmVar.c);
                            if (dmVar.c == -1) {
                                dmVar.d = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            dmVar.d = typedArray.getString(index);
                            break;
                        } else {
                            dmVar.c = typedArray.getResourceId(index, dmVar.c);
                            break;
                        }
                    case 12:
                        dmVar.b = typedArray.getInt(index, dmVar.b);
                        break;
                    case 13:
                        dmVar.h = typedArray.getInteger(index, dmVar.h);
                        break;
                    case 14:
                        dmVar.p = typedArray.getFloat(index, dmVar.p);
                        break;
                    case 15:
                        dmVar.q = typedArray.getDimension(index, dmVar.q);
                        break;
                    case 16:
                        dmVar.r = typedArray.getDimension(index, dmVar.r);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            dmVar.s = typedArray.getDimension(index, dmVar.s);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        dmVar.t = typedArray.getFloat(index, dmVar.t);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            dmVar.v = typedArray.getString(index);
                            dmVar.u = 7;
                            break;
                        } else {
                            dmVar.u = typedArray.getInt(index, dmVar.u);
                            break;
                        }
                    case 20:
                        dmVar.w = typedArray.getFloat(index, dmVar.w);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            dmVar.x = typedArray.getDimension(index, dmVar.x);
                            break;
                        } else {
                            dmVar.x = typedArray.getFloat(index, dmVar.x);
                            break;
                        }
                }
            }
        }
    }

    @Override // defpackage.dg
    public dg a(dg dgVar) {
        super.a(dgVar);
        dm dmVar = (dm) dgVar;
        this.g = dmVar.g;
        this.h = dmVar.h;
        this.u = dmVar.u;
        this.w = dmVar.w;
        this.x = dmVar.x;
        this.t = dmVar.t;
        this.i = dmVar.i;
        this.j = dmVar.j;
        this.k = dmVar.k;
        this.n = dmVar.n;
        this.l = dmVar.l;
        this.m = dmVar.m;
        this.o = dmVar.o;
        this.p = dmVar.p;
        this.q = dmVar.q;
        this.r = dmVar.r;
        this.s = dmVar.s;
        return this;
    }

    @Override // defpackage.dg
    /* renamed from: a */
    public dg clone() {
        return new dm().a((dg) this);
    }
}
