package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.e;
import androidx.constraintlayout.widget.j;
import androidx.constraintlayout.widget.l;
import com.google.protobuf.CodedOutputStream;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import defpackage.dt;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: MotionScene.java */
/* renamed from: dv  reason: default package */
/* loaded from: classes.dex */
public class dv {
    final dy c;
    float d;
    float e;
    private final dt f;
    private MotionEvent q;
    private dt.d t;
    private boolean u;
    l a = null;
    a b = null;
    private boolean g = false;
    private ArrayList<a> h = new ArrayList<>();
    private a i = null;
    private ArrayList<a> j = new ArrayList<>();
    private SparseArray<e> k = new SparseArray<>();
    private HashMap<String, Integer> l = new HashMap<>();
    private SparseIntArray m = new SparseIntArray();
    private boolean n = false;
    private int o = 400;
    private int p = 0;
    private boolean r = false;
    private boolean s = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        int i3;
        int i4;
        l lVar = this.a;
        if (lVar != null) {
            i3 = lVar.a(i, -1, -1);
            if (i3 == -1) {
                i3 = i;
            }
            i4 = this.a.a(i2, -1, -1);
            if (i4 == -1) {
                i4 = i2;
            }
        } else {
            i3 = i;
            i4 = i2;
        }
        a aVar = this.b;
        if (aVar != null && aVar.c == i2 && this.b.d == i) {
            return;
        }
        Iterator<a> it = this.h.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if ((next.c == i4 && next.d == i3) || (next.c == i2 && next.d == i)) {
                this.b = next;
                a aVar2 = this.b;
                if (aVar2 == null || aVar2.l == null) {
                    return;
                }
                this.b.l.a(this.u);
                return;
            }
        }
        a aVar3 = this.i;
        Iterator<a> it2 = this.j.iterator();
        while (it2.hasNext()) {
            a next2 = it2.next();
            if (next2.c == i2) {
                aVar3 = next2;
            }
        }
        a aVar4 = new a(this, aVar3);
        aVar4.d = i3;
        aVar4.c = i4;
        if (i3 != -1) {
            this.h.add(aVar4);
        }
        this.b = aVar4;
    }

    public void a(a aVar) {
        this.b = aVar;
        a aVar2 = this.b;
        if (aVar2 == null || aVar2.l == null) {
            return;
        }
        this.b.l.a(this.u);
    }

    private int e(int i) {
        int a2;
        l lVar = this.a;
        return (lVar == null || (a2 = lVar.a(i, -1, -1)) == -1) ? i : a2;
    }

    public List<a> a(int i) {
        int e = e(i);
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.h.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.d == e || next.c == e) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void a(dt dtVar, int i) {
        Iterator<a> it = this.h.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m.size() > 0) {
                Iterator it2 = next.m.iterator();
                while (it2.hasNext()) {
                    ((a.View$OnClickListenerC0061a) it2.next()).a(dtVar);
                }
            }
        }
        Iterator<a> it3 = this.j.iterator();
        while (it3.hasNext()) {
            a next2 = it3.next();
            if (next2.m.size() > 0) {
                Iterator it4 = next2.m.iterator();
                while (it4.hasNext()) {
                    ((a.View$OnClickListenerC0061a) it4.next()).a(dtVar);
                }
            }
        }
        Iterator<a> it5 = this.h.iterator();
        while (it5.hasNext()) {
            a next3 = it5.next();
            if (next3.m.size() > 0) {
                Iterator it6 = next3.m.iterator();
                while (it6.hasNext()) {
                    ((a.View$OnClickListenerC0061a) it6.next()).a(dtVar, i, next3);
                }
            }
        }
        Iterator<a> it7 = this.j.iterator();
        while (it7.hasNext()) {
            a next4 = it7.next();
            if (next4.m.size() > 0) {
                Iterator it8 = next4.m.iterator();
                while (it8.hasNext()) {
                    ((a.View$OnClickListenerC0061a) it8.next()).a(dtVar, i, next4);
                }
            }
        }
    }

    public a a(int i, float f, float f2, MotionEvent motionEvent) {
        if (i != -1) {
            List<a> a2 = a(i);
            float f3 = 0.0f;
            a aVar = null;
            RectF rectF = new RectF();
            for (a aVar2 : a2) {
                if (!aVar2.o && aVar2.l != null) {
                    aVar2.l.a(this.u);
                    RectF a3 = aVar2.l.a(this.f, rectF);
                    if (a3 == null || motionEvent == null || a3.contains(motionEvent.getX(), motionEvent.getY())) {
                        RectF b = aVar2.l.b(this.f, rectF);
                        if (b == null || motionEvent == null || b.contains(motionEvent.getX(), motionEvent.getY())) {
                            float f4 = aVar2.l.f(f, f2);
                            if (aVar2.l.c && motionEvent != null) {
                                float x = motionEvent.getX() - aVar2.l.a;
                                float y = motionEvent.getY() - aVar2.l.b;
                                f4 = ((float) (Math.atan2(f2 + y, f + x) - Math.atan2(x, y))) * 10.0f;
                            }
                            float f5 = aVar2.c == i ? f4 * (-1.0f) : f4 * 1.1f;
                            if (f5 > f3) {
                                aVar = aVar2;
                                f3 = f5;
                            }
                        }
                    }
                }
            }
            return aVar;
        }
        return this.b;
    }

    public ArrayList<a> a() {
        return this.h;
    }

    public a b(int i) {
        Iterator<a> it = this.h.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.a == i) {
                return next;
            }
        }
        return null;
    }

    public int[] b() {
        int[] iArr = new int[this.k.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = this.k.keyAt(i);
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(dt dtVar, int i) {
        a aVar;
        if (t() || this.g) {
            return false;
        }
        Iterator<a> it = this.h.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.n != 0 && ((aVar = this.b) != next || !aVar.c(2))) {
                if (i == next.d && (next.n == 4 || next.n == 2)) {
                    dtVar.setState(dt.h.FINISHED);
                    dtVar.setTransition(next);
                    if (next.n == 4) {
                        dtVar.c();
                        dtVar.setState(dt.h.SETUP);
                        dtVar.setState(dt.h.MOVING);
                    } else {
                        dtVar.setProgress(1.0f);
                        dtVar.b(true);
                        dtVar.setState(dt.h.SETUP);
                        dtVar.setState(dt.h.MOVING);
                        dtVar.setState(dt.h.FINISHED);
                        dtVar.d();
                    }
                    return true;
                } else if (i == next.c && (next.n == 3 || next.n == 1)) {
                    dtVar.setState(dt.h.FINISHED);
                    dtVar.setTransition(next);
                    if (next.n == 3) {
                        dtVar.b();
                        dtVar.setState(dt.h.SETUP);
                        dtVar.setState(dt.h.MOVING);
                    } else {
                        dtVar.setProgress(0.0f);
                        dtVar.b(true);
                        dtVar.setState(dt.h.SETUP);
                        dtVar.setState(dt.h.MOVING);
                        dtVar.setState(dt.h.FINISHED);
                        dtVar.d();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean t() {
        return this.t != null;
    }

    public void a(boolean z) {
        this.u = z;
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return;
        }
        this.b.l.a(this.u);
    }

    public void a(int i, View... viewArr) {
        this.c.a(i, viewArr);
    }

    /* compiled from: MotionScene.java */
    /* renamed from: dv$a */
    /* loaded from: classes.dex */
    public static class a {
        private int a;
        private boolean b;
        private int c;
        private int d;
        private int e;
        private String f;
        private int g;
        private int h;
        private float i;
        private final dv j;
        private ArrayList<dj> k;
        private dw l;
        private ArrayList<View$OnClickListenerC0061a> m;
        private int n;
        private boolean o;
        private int p;
        private int q;
        private int r;

        public int a() {
            return this.q;
        }

        public void a(Context context, XmlPullParser xmlPullParser) {
            this.m.add(new View$OnClickListenerC0061a(context, this, xmlPullParser));
        }

        public int b() {
            return this.n;
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public void a(int i) {
            this.h = Math.max(i, 8);
        }

        public void a(dj djVar) {
            this.k.add(djVar);
        }

        public dw e() {
            return this.l;
        }

        public void b(int i) {
            this.p = i;
        }

        public boolean f() {
            return !this.o;
        }

        public boolean c(int i) {
            return (i & this.r) != 0;
        }

        /* compiled from: MotionScene.java */
        /* renamed from: dv$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class View$OnClickListenerC0061a implements View.OnClickListener {
            int a;
            int b;
            private final a c;

            public View$OnClickListenerC0061a(Context context, a aVar, XmlPullParser xmlPullParser) {
                this.a = -1;
                this.b = 17;
                this.c = aVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j.b.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == j.b.OnClick_targetId) {
                        this.a = obtainStyledAttributes.getResourceId(index, this.a);
                    } else if (index == j.b.OnClick_clickAction) {
                        this.b = obtainStyledAttributes.getInt(index, this.b);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void a(dt dtVar, int i, a aVar) {
                int i2 = this.a;
                View view = dtVar;
                if (i2 != -1) {
                    view = dtVar.findViewById(i2);
                }
                if (view != null) {
                    int i3 = aVar.d;
                    int i4 = aVar.c;
                    if (i3 == -1) {
                        view.setOnClickListener(this);
                        return;
                    }
                    boolean z = true;
                    boolean z2 = ((this.b & 1) != 0 && i == i3) | ((this.b & 1) != 0 && i == i3) | ((this.b & IRadioController.TEF663x_PCHANNEL) != 0 && i == i3) | ((this.b & 16) != 0 && i == i4);
                    if ((this.b & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 0 || i != i4) {
                        z = false;
                    }
                    if (z2 || z) {
                        view.setOnClickListener(this);
                        return;
                    }
                    return;
                }
                Log.e("MotionScene", "OnClick could not find id " + this.a);
            }

            public void a(dt dtVar) {
                int i = this.a;
                if (i == -1) {
                    return;
                }
                View findViewById = dtVar.findViewById(i);
                if (findViewById == null) {
                    Log.e("MotionScene", " (*)  could not find id " + this.a);
                    return;
                }
                findViewById.setOnClickListener(null);
            }

            boolean a(a aVar, dt dtVar) {
                a aVar2 = this.c;
                if (aVar2 == aVar) {
                    return true;
                }
                int i = aVar2.c;
                int i2 = this.c.d;
                return i2 == -1 ? dtVar.f != i : dtVar.f == i2 || dtVar.f == i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dt dtVar = this.c.j.f;
                if (dtVar.h()) {
                    if (this.c.d != -1) {
                        a aVar = this.c.j.b;
                        int i = this.b;
                        boolean z = ((i & 1) == 0 && (i & IRadioController.TEF663x_PCHANNEL) == 0) ? false : true;
                        int i2 = this.b;
                        boolean z2 = ((i2 & 16) == 0 && (i2 & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 0) ? false : true;
                        if (z && z2) {
                            a aVar2 = this.c.j.b;
                            a aVar3 = this.c;
                            if (aVar2 != aVar3) {
                                dtVar.setTransition(aVar3);
                            }
                            if (dtVar.getCurrentState() == dtVar.getEndState() || dtVar.getProgress() > 0.5f) {
                                z = false;
                            } else {
                                z2 = false;
                            }
                        }
                        if (a(aVar, dtVar)) {
                            if (z && (this.b & 1) != 0) {
                                dtVar.setTransition(this.c);
                                dtVar.c();
                                return;
                            } else if (z2 && (this.b & 16) != 0) {
                                dtVar.setTransition(this.c);
                                dtVar.b();
                                return;
                            } else if (z && (this.b & IRadioController.TEF663x_PCHANNEL) != 0) {
                                dtVar.setTransition(this.c);
                                dtVar.setProgress(1.0f);
                                return;
                            } else if (!z2 || (this.b & CodedOutputStream.DEFAULT_BUFFER_SIZE) == 0) {
                                return;
                            } else {
                                dtVar.setTransition(this.c);
                                dtVar.setProgress(0.0f);
                                return;
                            }
                        }
                        return;
                    }
                    int currentState = dtVar.getCurrentState();
                    if (currentState == -1) {
                        dtVar.b(this.c.c);
                        return;
                    }
                    a aVar4 = new a(this.c.j, this.c);
                    aVar4.d = currentState;
                    aVar4.c = this.c.c;
                    dtVar.setTransition(aVar4);
                    dtVar.c();
                }
            }
        }

        a(dv dvVar, a aVar) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList<>();
            this.l = null;
            this.m = new ArrayList<>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.j = dvVar;
            this.h = dvVar.o;
            if (aVar != null) {
                this.p = aVar.p;
                this.e = aVar.e;
                this.f = aVar.f;
                this.g = aVar.g;
                this.h = aVar.h;
                this.k = aVar.k;
                this.i = aVar.i;
                this.q = aVar.q;
            }
        }

        public a(int i, dv dvVar, int i2, int i3) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList<>();
            this.l = null;
            this.m = new ArrayList<>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.a = i;
            this.j = dvVar;
            this.d = i2;
            this.c = i3;
            this.h = dvVar.o;
            this.q = dvVar.p;
        }

        a(dv dvVar, Context context, XmlPullParser xmlPullParser) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList<>();
            this.l = null;
            this.m = new ArrayList<>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.h = dvVar.o;
            this.q = dvVar.p;
            this.j = dvVar;
            a(dvVar, context, Xml.asAttributeSet(xmlPullParser));
        }

        public void a(int i, String str, int i2) {
            this.e = i;
            this.f = str;
            this.g = i2;
        }

        private void a(dv dvVar, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.b.Transition);
            a(dvVar, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        private void a(dv dvVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == j.b.Transition_constraintSetEnd) {
                    this.c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        e eVar = new e();
                        eVar.b(context, this.c);
                        dvVar.k.append(this.c, eVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.c = dvVar.b(context, this.c);
                    }
                } else if (index == j.b.Transition_constraintSetStart) {
                    this.d = typedArray.getResourceId(index, this.d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.d);
                    if ("layout".equals(resourceTypeName2)) {
                        e eVar2 = new e();
                        eVar2.b(context, this.d);
                        dvVar.k.append(this.d, eVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.d = dvVar.b(context, this.d);
                    }
                } else if (index == j.b.Transition_motionInterpolator) {
                    TypedValue peekValue = typedArray.peekValue(index);
                    if (peekValue.type == 1) {
                        this.g = typedArray.getResourceId(index, -1);
                        if (this.g != -1) {
                            this.e = -2;
                        }
                    } else if (peekValue.type == 3) {
                        this.f = typedArray.getString(index);
                        String str = this.f;
                        if (str != null) {
                            if (str.indexOf("/") > 0) {
                                this.g = typedArray.getResourceId(index, -1);
                                this.e = -2;
                            } else {
                                this.e = -1;
                            }
                        }
                    } else {
                        this.e = typedArray.getInteger(index, this.e);
                    }
                } else if (index == j.b.Transition_duration) {
                    this.h = typedArray.getInt(index, this.h);
                    if (this.h < 8) {
                        this.h = 8;
                    }
                } else if (index == j.b.Transition_staggered) {
                    this.i = typedArray.getFloat(index, this.i);
                } else if (index == j.b.Transition_autoTransition) {
                    this.n = typedArray.getInteger(index, this.n);
                } else if (index == j.b.Transition_android_id) {
                    this.a = typedArray.getResourceId(index, this.a);
                } else if (index == j.b.Transition_transitionDisable) {
                    this.o = typedArray.getBoolean(index, this.o);
                } else if (index == j.b.Transition_pathMotionArc) {
                    this.p = typedArray.getInteger(index, -1);
                } else if (index == j.b.Transition_layoutDuringTransition) {
                    this.q = typedArray.getInteger(index, 0);
                } else if (index == j.b.Transition_transitionFlags) {
                    this.r = typedArray.getInteger(index, 0);
                }
            }
            if (this.d == -1) {
                this.b = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(Context context, dt dtVar, int i) {
        this.f = dtVar;
        this.c = new dy(dtVar);
        a(context, i);
        this.k.put(j.a.motion_base, new e());
        this.l.put("motion_base", Integer.valueOf(j.a.motion_base));
    }

    private void a(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        a aVar = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else {
                    switch (eventType) {
                        case 2:
                            String name = xml.getName();
                            if (this.n) {
                                System.out.println("parsing = " + name);
                            }
                            switch (name.hashCode()) {
                                case -1349929691:
                                    if (name.equals("ConstraintSet")) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1239391468:
                                    if (name.equals("KeyFrameSet")) {
                                        c = '\b';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -687739768:
                                    if (name.equals("Include")) {
                                        c = 7;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 61998586:
                                    if (name.equals("ViewTransition")) {
                                        c = '\t';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 269306229:
                                    if (name.equals("Transition")) {
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 312750793:
                                    if (name.equals("OnClick")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 327855227:
                                    if (name.equals("OnSwipe")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 793277014:
                                    if (name.equals("MotionScene")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1382829617:
                                    if (name.equals("StateSet")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1942574248:
                                    if (name.equals("include")) {
                                        c = 6;
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
                                    a(context, xml);
                                    continue;
                                case 1:
                                    ArrayList<a> arrayList = this.h;
                                    a aVar2 = new a(this, context, xml);
                                    arrayList.add(aVar2);
                                    if (this.b == null && !aVar2.b) {
                                        this.b = aVar2;
                                        if (this.b != null && this.b.l != null) {
                                            this.b.l.a(this.u);
                                        }
                                    }
                                    if (aVar2.b) {
                                        if (aVar2.c == -1) {
                                            this.i = aVar2;
                                        } else {
                                            this.j.add(aVar2);
                                        }
                                        this.h.remove(aVar2);
                                    }
                                    aVar = aVar2;
                                    continue;
                                case 2:
                                    if (aVar == null) {
                                        Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i) + ".xml:" + xml.getLineNumber() + ")");
                                    }
                                    if (aVar != null) {
                                        aVar.l = new dw(context, this.f, xml);
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 3:
                                    if (aVar != null) {
                                        aVar.a(context, xml);
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 4:
                                    this.a = new l(context, xml);
                                    continue;
                                case 5:
                                    c(context, xml);
                                    continue;
                                case 6:
                                case 7:
                                    b(context, xml);
                                    continue;
                                case '\b':
                                    dj djVar = new dj(context, xml);
                                    if (aVar != null) {
                                        aVar.k.add(djVar);
                                        break;
                                    } else {
                                        continue;
                                    }
                                case '\t':
                                    this.c.a(new dx(context, xml));
                                    continue;
                                default:
                                    continue;
                                    continue;
                            }
                        case 3:
                            continue;
                        default:
                            continue;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j.b.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == j.b.MotionScene_defaultDuration) {
                this.o = obtainStyledAttributes.getInt(index, this.o);
                if (this.o < 8) {
                    this.o = 8;
                }
            } else if (index == j.b.MotionScene_layoutDuringTransition) {
                this.p = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private int a(Context context, String str) {
        int i;
        if (str.contains("/")) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), Constants.ID, context.getPackageName());
            if (this.n) {
                System.out.println("id getMap res = " + i);
            }
        } else {
            i = -1;
        }
        if (i == -1) {
            if (str != null && str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
            return i;
        }
        return i;
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j.b.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == j.b.include_constraintSet) {
                b(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return c(context, xml);
                }
            }
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (r8.equals("deriveConstraintsFrom") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int c(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.e r0 = new androidx.constraintlayout.widget.e
            r0.<init>()
            r1 = 0
            r0.a(r1)
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = r1
            r5 = r3
            r6 = r5
        L11:
            r7 = 1
            if (r4 >= r2) goto L91
            java.lang.String r8 = r15.getAttributeName(r4)
            java.lang.String r9 = r15.getAttributeValue(r4)
            boolean r10 = r13.n
            if (r10 == 0) goto L36
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "id string = "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
        L36:
            int r10 = r8.hashCode()
            r11 = -1995929160(0xffffffff890889b8, float:-1.643516E-33)
            if (r10 == r11) goto L5c
            r11 = -1496482599(0xffffffffa6cd7cd9, float:-1.4258573E-15)
            if (r10 == r11) goto L53
            r7 = 3355(0xd1b, float:4.701E-42)
            if (r10 == r7) goto L49
            goto L66
        L49:
            java.lang.String r7 = "id"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L66
            r7 = r1
            goto L67
        L53:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L66
            goto L67
        L5c:
            java.lang.String r7 = "ConstraintRotate"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L66
            r7 = 2
            goto L67
        L66:
            r7 = r3
        L67:
            switch(r7) {
                case 0: goto L77;
                case 1: goto L72;
                case 2: goto L6b;
                default: goto L6a;
            }
        L6a:
            goto L8e
        L6b:
            int r7 = java.lang.Integer.parseInt(r9)
            r0.c = r7
            goto L8e
        L72:
            int r6 = r13.a(r14, r9)
            goto L8e
        L77:
            int r5 = r13.a(r14, r9)
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r13.l
            java.lang.String r8 = a(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r7.put(r8, r9)
            java.lang.String r7 = defpackage.dd.a(r14, r5)
            r0.a = r7
        L8e:
            int r4 = r4 + 1
            goto L11
        L91:
            if (r5 == r3) goto Lab
            dt r1 = r13.f
            int r1 = r1.l
            if (r1 == 0) goto L9c
            r0.b(r7)
        L9c:
            r0.a(r14, r15)
            if (r6 == r3) goto La6
            android.util.SparseIntArray r14 = r13.m
            r14.put(r5, r6)
        La6:
            android.util.SparseArray<androidx.constraintlayout.widget.e> r14 = r13.k
            r14.put(r5, r0)
        Lab:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dv.c(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e c(int i) {
        return a(i, -1, -1);
    }

    e a(int i, int i2, int i3) {
        int a2;
        if (this.n) {
            PrintStream printStream = System.out;
            printStream.println("id " + i);
            PrintStream printStream2 = System.out;
            printStream2.println("size " + this.k.size());
        }
        l lVar = this.a;
        if (lVar != null && (a2 = lVar.a(i, i2, i3)) != -1) {
            i = a2;
        }
        if (this.k.get(i) == null) {
            Log.e("MotionScene", "Warning could not find ConstraintSet id/" + dd.a(this.f.getContext(), i) + " In MotionScene");
            SparseArray<e> sparseArray = this.k;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.k.get(i);
    }

    public void a(int i, e eVar) {
        this.k.put(i, eVar);
    }

    public void a(dp dpVar) {
        a aVar = this.b;
        if (aVar != null) {
            Iterator it = aVar.k.iterator();
            while (it.hasNext()) {
                ((dj) it.next()).b(dpVar);
            }
            return;
        }
        a aVar2 = this.i;
        if (aVar2 != null) {
            Iterator it2 = aVar2.k.iterator();
            while (it2.hasNext()) {
                ((dj) it2.next()).b(dpVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        Iterator<a> it = this.h.iterator();
        while (it.hasNext()) {
            if (it.next().l != null) {
                return true;
            }
        }
        a aVar = this.b;
        return (aVar == null || aVar.l == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent, int i, dt dtVar) {
        dt.d dVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.t == null) {
            this.t = this.f.a();
        }
        this.t.a(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.d = motionEvent.getRawX();
                this.e = motionEvent.getRawY();
                this.q = motionEvent;
                this.r = false;
                if (this.b.l != null) {
                    RectF b = this.b.l.b(this.f, rectF);
                    if (b == null || b.contains(this.q.getX(), this.q.getY())) {
                        RectF a2 = this.b.l.a(this.f, rectF);
                        if (a2 != null && !a2.contains(this.q.getX(), this.q.getY())) {
                            this.s = true;
                        } else {
                            this.s = false;
                        }
                        this.b.l.b(this.d, this.e);
                        return;
                    }
                    this.q = null;
                    this.r = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.r) {
                float rawY = motionEvent.getRawY() - this.e;
                float rawX = motionEvent.getRawX() - this.d;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.q) == null) {
                    return;
                }
                a a3 = a(i, rawX, rawY, motionEvent2);
                if (a3 != null) {
                    dtVar.setTransition(a3);
                    RectF a4 = this.b.l.a(this.f, rectF);
                    if (a4 != null && !a4.contains(this.q.getX(), this.q.getY())) {
                        z = true;
                    }
                    this.s = z;
                    this.b.l.a(this.d, this.e);
                }
            }
        }
        if (this.r) {
            return;
        }
        a aVar = this.b;
        if (aVar != null && aVar.l != null && !this.s) {
            this.b.l.b(motionEvent, this.t, i, this);
        }
        this.d = motionEvent.getRawX();
        this.e = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (dVar = this.t) == null) {
            return;
        }
        dVar.a();
        this.t = null;
        if (dtVar.f != -1) {
            b(dtVar, dtVar.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float f2) {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return;
        }
        this.b.l.e(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f, float f2) {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return;
        }
        this.b.l.d(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c(float f, float f2) {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return 0.0f;
        }
        return this.b.l.c(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        a aVar = this.b;
        if (aVar == null) {
            return -1;
        }
        return aVar.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        a aVar = this.b;
        if (aVar == null) {
            return -1;
        }
        return aVar.c;
    }

    public Interpolator f() {
        switch (this.b.e) {
            case -2:
                return AnimationUtils.loadInterpolator(this.f.getContext(), this.b.g);
            case -1:
                final bh a2 = bh.a(this.b.f);
                return new Interpolator() { // from class: dv.1
                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f) {
                        return (float) a2.a(f);
                    }
                };
            case 0:
                return new AccelerateDecelerateInterpolator();
            case 1:
                return new AccelerateInterpolator();
            case 2:
                return new DecelerateInterpolator();
            case 3:
                return null;
            case 4:
                return new BounceInterpolator();
            case 5:
                return new OvershootInterpolator();
            case 6:
                return new AnticipateInterpolator();
            default:
                return null;
        }
    }

    public int g() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.h;
        }
        return this.o;
    }

    public void d(int i) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(i);
        } else {
            this.o = i;
        }
    }

    public int h() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.p;
        }
        return -1;
    }

    public float i() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.i;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return 0.0f;
        }
        return this.b.l.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return 0.0f;
        }
        return this.b.l.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return 0.0f;
        }
        return this.b.l.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float m() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return 0.0f;
        }
        return this.b.l.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return 0.0f;
        }
        return this.b.l.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float o() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return 0.0f;
        }
        return this.b.l.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return 0;
        }
        return this.b.l.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return 0;
        }
        return this.b.l.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return;
        }
        this.b.l.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        a aVar = this.b;
        if (aVar == null || aVar.l == null) {
            return false;
        }
        return this.b.l.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(dt dtVar) {
        for (int i = 0; i < this.k.size(); i++) {
            int keyAt = this.k.keyAt(i);
            if (f(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            a(keyAt, dtVar);
        }
    }

    private boolean f(int i) {
        int i2 = this.m.get(i);
        int size = this.m.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.m.get(i2);
            size = i3;
        }
        return false;
    }

    private void a(int i, dt dtVar) {
        e eVar = this.k.get(i);
        eVar.b = eVar.a;
        int i2 = this.m.get(i);
        if (i2 > 0) {
            a(i2, dtVar);
            e eVar2 = this.k.get(i2);
            if (eVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + dd.a(this.f.getContext(), i2));
                return;
            }
            eVar.b += "/" + eVar2.b;
            eVar.a(eVar2);
        } else {
            eVar.b += "  layout";
            eVar.a(dtVar);
        }
        eVar.b(eVar);
    }

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }
}
