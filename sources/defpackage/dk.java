package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.j;
import java.util.HashMap;
/* compiled from: KeyPosition.java */
/* renamed from: dk  reason: default package */
/* loaded from: classes.dex */
public class dk extends dl {
    String g = null;
    int h = a;
    int i = 0;
    float j = Float.NaN;
    float k = Float.NaN;
    float l = Float.NaN;
    float m = Float.NaN;
    float n = Float.NaN;
    float o = Float.NaN;
    int p = 0;
    private float r = Float.NaN;
    private float s = Float.NaN;

    @Override // defpackage.dg
    public void a(HashMap<String, da> hashMap) {
    }

    public dk() {
        this.e = 2;
    }

    @Override // defpackage.dg
    public void a(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, j.b.KeyPosition));
    }

    /* compiled from: KeyPosition.java */
    /* renamed from: dk$a */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a = new SparseIntArray();

        static {
            a.append(j.b.KeyPosition_motionTarget, 1);
            a.append(j.b.KeyPosition_framePosition, 2);
            a.append(j.b.KeyPosition_transitionEasing, 3);
            a.append(j.b.KeyPosition_curveFit, 4);
            a.append(j.b.KeyPosition_drawPath, 5);
            a.append(j.b.KeyPosition_percentX, 6);
            a.append(j.b.KeyPosition_percentY, 7);
            a.append(j.b.KeyPosition_keyPositionType, 9);
            a.append(j.b.KeyPosition_sizePercent, 8);
            a.append(j.b.KeyPosition_percentWidth, 11);
            a.append(j.b.KeyPosition_percentHeight, 12);
            a.append(j.b.KeyPosition_pathMotionArc, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(dk dkVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        if (dt.a) {
                            dkVar.c = typedArray.getResourceId(index, dkVar.c);
                            if (dkVar.c == -1) {
                                dkVar.d = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            dkVar.d = typedArray.getString(index);
                            break;
                        } else {
                            dkVar.c = typedArray.getResourceId(index, dkVar.c);
                            break;
                        }
                    case 2:
                        dkVar.b = typedArray.getInt(index, dkVar.b);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            dkVar.g = typedArray.getString(index);
                            break;
                        } else {
                            dkVar.g = bh.c[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        dkVar.q = typedArray.getInteger(index, dkVar.q);
                        break;
                    case 5:
                        dkVar.i = typedArray.getInt(index, dkVar.i);
                        break;
                    case 6:
                        dkVar.l = typedArray.getFloat(index, dkVar.l);
                        break;
                    case 7:
                        dkVar.m = typedArray.getFloat(index, dkVar.m);
                        break;
                    case 8:
                        float f = typedArray.getFloat(index, dkVar.k);
                        dkVar.j = f;
                        dkVar.k = f;
                        break;
                    case 9:
                        dkVar.p = typedArray.getInt(index, dkVar.p);
                        break;
                    case 10:
                        dkVar.h = typedArray.getInt(index, dkVar.h);
                        break;
                    case 11:
                        dkVar.j = typedArray.getFloat(index, dkVar.j);
                        break;
                    case 12:
                        dkVar.k = typedArray.getFloat(index, dkVar.k);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                }
            }
            if (dkVar.b == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    @Override // defpackage.dg
    public dg a(dg dgVar) {
        super.a(dgVar);
        dk dkVar = (dk) dgVar;
        this.g = dkVar.g;
        this.h = dkVar.h;
        this.i = dkVar.i;
        this.j = dkVar.j;
        this.k = Float.NaN;
        this.l = dkVar.l;
        this.m = dkVar.m;
        this.n = dkVar.n;
        this.o = dkVar.o;
        this.r = dkVar.r;
        this.s = dkVar.s;
        return this;
    }

    @Override // defpackage.dg
    /* renamed from: a */
    public dg clone() {
        return new dk().a(this);
    }
}
