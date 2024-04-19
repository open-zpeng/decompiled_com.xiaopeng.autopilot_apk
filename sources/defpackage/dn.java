package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.b;
import androidx.constraintlayout.widget.j;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
/* compiled from: KeyTrigger.java */
/* renamed from: dn  reason: default package */
/* loaded from: classes.dex */
public class dn extends dg {
    private float z;
    private int n = -1;
    private String o = null;
    private int p = a;
    private String q = null;
    private String r = null;
    private int s = a;
    private int t = a;
    private View u = null;
    float g = 0.1f;
    private boolean v = true;
    private boolean w = true;
    private boolean x = true;
    private float y = Float.NaN;
    private boolean A = false;
    int h = a;
    int i = a;
    int j = a;
    RectF k = new RectF();
    RectF l = new RectF();
    HashMap<String, Method> m = new HashMap<>();

    @Override // defpackage.dg
    public void a(HashMap<String, da> hashMap) {
    }

    @Override // defpackage.dg
    public void a(HashSet<String> hashSet) {
    }

    public dn() {
        this.e = 5;
        this.f = new HashMap<>();
    }

    @Override // defpackage.dg
    public void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, j.b.KeyTrigger), context);
    }

    private void a(RectF rectF, View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    public void a(float f, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.t != a) {
            if (this.u == null) {
                this.u = ((ViewGroup) view.getParent()).findViewById(this.t);
            }
            a(this.k, this.u, this.A);
            a(this.l, view, this.A);
            if (this.k.intersect(this.l)) {
                if (this.v) {
                    this.v = false;
                    z = true;
                } else {
                    z = false;
                }
                if (this.x) {
                    this.x = false;
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.w = true;
                z5 = z6;
                z4 = false;
            } else {
                if (this.v) {
                    z = false;
                } else {
                    this.v = true;
                    z = true;
                }
                if (this.w) {
                    this.w = false;
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.x = true;
                z5 = false;
            }
            boolean z7 = z5;
            z2 = z4;
            z3 = z7;
        } else {
            if (this.v) {
                float f2 = this.y;
                if ((f - f2) * (this.z - f2) < 0.0f) {
                    this.v = false;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                if (Math.abs(f - this.y) > this.g) {
                    this.v = true;
                }
                z = false;
            }
            if (this.w) {
                float f3 = this.y;
                float f4 = f - f3;
                if ((this.z - f3) * f4 >= 0.0f || f4 >= 0.0f) {
                    z2 = false;
                } else {
                    this.w = false;
                    z2 = true;
                }
            } else {
                if (Math.abs(f - this.y) > this.g) {
                    this.w = true;
                }
                z2 = false;
            }
            if (this.x) {
                float f5 = this.y;
                float f6 = f - f5;
                if ((this.z - f5) * f6 >= 0.0f || f6 <= 0.0f) {
                    z3 = false;
                } else {
                    this.x = false;
                    z3 = true;
                }
            } else {
                if (Math.abs(f - this.y) > this.g) {
                    this.x = true;
                }
                z3 = false;
            }
        }
        this.z = f;
        if (z2 || z || z3) {
            ((dt) view.getParent()).a(this.s, z3, f);
        }
        View findViewById = this.p == a ? view : ((dt) view.getParent()).findViewById(this.p);
        if (z2) {
            String str = this.q;
            if (str != null) {
                a(str, findViewById);
            }
            if (this.h != a) {
                ((dt) view.getParent()).a(this.h, findViewById);
            }
        }
        if (z3) {
            String str2 = this.r;
            if (str2 != null) {
                a(str2, findViewById);
            }
            if (this.i != a) {
                ((dt) view.getParent()).a(this.i, findViewById);
            }
        }
        if (z) {
            String str3 = this.o;
            if (str3 != null) {
                a(str3, findViewById);
            }
            if (this.j != a) {
                ((dt) view.getParent()).a(this.j, findViewById);
            }
        }
    }

    private void a(String str, View view) {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(".")) {
            b(str, view);
            return;
        }
        if (this.m.containsKey(str)) {
            method = this.m.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = view.getClass().getMethod(str, new Class[0]);
                this.m.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.m.put(str, null);
                Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + dd.a(view));
                return;
            }
        }
        try {
            method.invoke(view, new Object[0]);
        } catch (Exception unused2) {
            Log.e("KeyTrigger", "Exception in call \"" + this.o + "\"on class " + view.getClass().getSimpleName() + " " + dd.a(view));
        }
    }

    private void b(String str, View view) {
        boolean z = str.length() == 1;
        if (!z) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z || lowerCase.matches(str)) {
                b bVar = this.f.get(str2);
                if (bVar != null) {
                    bVar.a(view);
                }
            }
        }
    }

    /* compiled from: KeyTrigger.java */
    /* renamed from: dn$a */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a = new SparseIntArray();

        static {
            a.append(j.b.KeyTrigger_framePosition, 8);
            a.append(j.b.KeyTrigger_onCross, 4);
            a.append(j.b.KeyTrigger_onNegativeCross, 1);
            a.append(j.b.KeyTrigger_onPositiveCross, 2);
            a.append(j.b.KeyTrigger_motionTarget, 7);
            a.append(j.b.KeyTrigger_triggerId, 6);
            a.append(j.b.KeyTrigger_triggerSlack, 5);
            a.append(j.b.KeyTrigger_motion_triggerOnCollision, 9);
            a.append(j.b.KeyTrigger_motion_postLayoutCollision, 10);
            a.append(j.b.KeyTrigger_triggerReceiver, 11);
            a.append(j.b.KeyTrigger_viewTransitionOnCross, 12);
            a.append(j.b.KeyTrigger_viewTransitionOnNegativeCross, 13);
            a.append(j.b.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void a(dn dnVar, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (a.get(index)) {
                    case 1:
                        dnVar.q = typedArray.getString(index);
                        break;
                    case 2:
                        dnVar.r = typedArray.getString(index);
                        break;
                    case 3:
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                    case 4:
                        dnVar.o = typedArray.getString(index);
                        break;
                    case 5:
                        dnVar.g = typedArray.getFloat(index, dnVar.g);
                        break;
                    case 6:
                        dnVar.s = typedArray.getResourceId(index, dnVar.s);
                        break;
                    case 7:
                        if (dt.a) {
                            dnVar.c = typedArray.getResourceId(index, dnVar.c);
                            if (dnVar.c == -1) {
                                dnVar.d = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            dnVar.d = typedArray.getString(index);
                            break;
                        } else {
                            dnVar.c = typedArray.getResourceId(index, dnVar.c);
                            break;
                        }
                    case 8:
                        dnVar.b = typedArray.getInteger(index, dnVar.b);
                        dnVar.y = (dnVar.b + 0.5f) / 100.0f;
                        break;
                    case 9:
                        dnVar.t = typedArray.getResourceId(index, dnVar.t);
                        break;
                    case 10:
                        dnVar.A = typedArray.getBoolean(index, dnVar.A);
                        break;
                    case 11:
                        dnVar.p = typedArray.getResourceId(index, dnVar.p);
                        break;
                    case 12:
                        dnVar.j = typedArray.getResourceId(index, dnVar.j);
                        break;
                    case 13:
                        dnVar.h = typedArray.getResourceId(index, dnVar.h);
                        break;
                    case 14:
                        dnVar.i = typedArray.getResourceId(index, dnVar.i);
                        break;
                }
            }
        }
    }

    @Override // defpackage.dg
    public dg a(dg dgVar) {
        super.a(dgVar);
        dn dnVar = (dn) dgVar;
        this.n = dnVar.n;
        this.o = dnVar.o;
        this.p = dnVar.p;
        this.q = dnVar.q;
        this.r = dnVar.r;
        this.s = dnVar.s;
        this.t = dnVar.t;
        this.u = dnVar.u;
        this.g = dnVar.g;
        this.v = dnVar.v;
        this.w = dnVar.w;
        this.x = dnVar.x;
        this.y = dnVar.y;
        this.z = dnVar.z;
        this.A = dnVar.A;
        this.k = dnVar.k;
        this.l = dnVar.l;
        this.m = dnVar.m;
        return this;
    }

    @Override // defpackage.dg
    /* renamed from: a */
    public dg clone() {
        return new dn().a((dg) this);
    }
}
