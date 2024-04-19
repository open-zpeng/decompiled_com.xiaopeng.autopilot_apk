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
/* compiled from: KeyAttributes.java */
/* renamed from: dh  reason: default package */
/* loaded from: classes.dex */
public class dh extends dg {
    private String g;
    private int h = -1;
    private boolean i = false;
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
    private float u = Float.NaN;
    private float v = Float.NaN;
    private float w = Float.NaN;

    public dh() {
        this.e = 1;
        this.f = new HashMap<>();
    }

    @Override // defpackage.dg
    public void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, j.b.KeyAttribute));
    }

    @Override // defpackage.dg
    public void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.j)) {
            hashSet.add(ThemeManager.AttributeSet.ALPHA);
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.w)) {
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
        if (!Float.isNaN(this.j)) {
            hashMap.put(ThemeManager.AttributeSet.ALPHA, Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.k)) {
            hashMap.put("elevation", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.l)) {
            hashMap.put("rotation", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.m)) {
            hashMap.put("rotationX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put("rotationY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("transformPivotX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.p)) {
            hashMap.put("transformPivotY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.t)) {
            hashMap.put("translationX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.u)) {
            hashMap.put("translationY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.v)) {
            hashMap.put("translationZ", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.q)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("scaleX", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.s)) {
            hashMap.put("scaleY", Integer.valueOf(this.h));
        }
        if (!Float.isNaN(this.w)) {
            hashMap.put("progress", Integer.valueOf(this.h));
        }
        if (this.f.size() > 0) {
            Iterator<String> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.h));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r1.equals("transitionPathRotate") != false) goto L15;
     */
    @Override // defpackage.dg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.HashMap<java.lang.String, defpackage.da> r7) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dh.a(java.util.HashMap):void");
    }

    /* compiled from: KeyAttributes.java */
    /* renamed from: dh$a */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a = new SparseIntArray();

        static {
            a.append(j.b.KeyAttribute_android_alpha, 1);
            a.append(j.b.KeyAttribute_android_elevation, 2);
            a.append(j.b.KeyAttribute_android_rotation, 4);
            a.append(j.b.KeyAttribute_android_rotationX, 5);
            a.append(j.b.KeyAttribute_android_rotationY, 6);
            a.append(j.b.KeyAttribute_android_transformPivotX, 19);
            a.append(j.b.KeyAttribute_android_transformPivotY, 20);
            a.append(j.b.KeyAttribute_android_scaleX, 7);
            a.append(j.b.KeyAttribute_transitionPathRotate, 8);
            a.append(j.b.KeyAttribute_transitionEasing, 9);
            a.append(j.b.KeyAttribute_motionTarget, 10);
            a.append(j.b.KeyAttribute_framePosition, 12);
            a.append(j.b.KeyAttribute_curveFit, 13);
            a.append(j.b.KeyAttribute_android_scaleY, 14);
            a.append(j.b.KeyAttribute_android_translationX, 15);
            a.append(j.b.KeyAttribute_android_translationY, 16);
            a.append(j.b.KeyAttribute_android_translationZ, 17);
            a.append(j.b.KeyAttribute_motionProgress, 18);
        }

        public static void a(dh dhVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        dhVar.j = typedArray.getFloat(index, dhVar.j);
                        break;
                    case 2:
                        dhVar.k = typedArray.getDimension(index, dhVar.k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                    case 4:
                        dhVar.l = typedArray.getFloat(index, dhVar.l);
                        break;
                    case 5:
                        dhVar.m = typedArray.getFloat(index, dhVar.m);
                        break;
                    case 6:
                        dhVar.n = typedArray.getFloat(index, dhVar.n);
                        break;
                    case 7:
                        dhVar.r = typedArray.getFloat(index, dhVar.r);
                        break;
                    case 8:
                        dhVar.q = typedArray.getFloat(index, dhVar.q);
                        break;
                    case 9:
                        dhVar.g = typedArray.getString(index);
                        break;
                    case 10:
                        if (dt.a) {
                            dhVar.c = typedArray.getResourceId(index, dhVar.c);
                            if (dhVar.c == -1) {
                                dhVar.d = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            dhVar.d = typedArray.getString(index);
                            break;
                        } else {
                            dhVar.c = typedArray.getResourceId(index, dhVar.c);
                            break;
                        }
                    case 12:
                        dhVar.b = typedArray.getInt(index, dhVar.b);
                        break;
                    case 13:
                        dhVar.h = typedArray.getInteger(index, dhVar.h);
                        break;
                    case 14:
                        dhVar.s = typedArray.getFloat(index, dhVar.s);
                        break;
                    case 15:
                        dhVar.t = typedArray.getDimension(index, dhVar.t);
                        break;
                    case 16:
                        dhVar.u = typedArray.getDimension(index, dhVar.u);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            dhVar.v = typedArray.getDimension(index, dhVar.v);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        dhVar.w = typedArray.getFloat(index, dhVar.w);
                        break;
                    case 19:
                        dhVar.o = typedArray.getDimension(index, dhVar.o);
                        break;
                    case 20:
                        dhVar.p = typedArray.getDimension(index, dhVar.p);
                        break;
                }
            }
        }
    }

    @Override // defpackage.dg
    public dg a(dg dgVar) {
        super.a(dgVar);
        dh dhVar = (dh) dgVar;
        this.h = dhVar.h;
        this.i = dhVar.i;
        this.j = dhVar.j;
        this.k = dhVar.k;
        this.l = dhVar.l;
        this.m = dhVar.m;
        this.n = dhVar.n;
        this.o = dhVar.o;
        this.p = dhVar.p;
        this.q = dhVar.q;
        this.r = dhVar.r;
        this.s = dhVar.s;
        this.t = dhVar.t;
        this.u = dhVar.u;
        this.v = dhVar.v;
        this.w = dhVar.w;
        return this;
    }

    @Override // defpackage.dg
    /* renamed from: a */
    public dg clone() {
        return new dh().a((dg) this);
    }
}
