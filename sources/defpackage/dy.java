package defpackage;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import androidx.constraintlayout.widget.k;
import defpackage.dx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ViewTransitionController.java */
/* renamed from: dy  reason: default package */
/* loaded from: classes.dex */
public class dy {
    ArrayList<dx.a> a;
    private final dt c;
    private HashSet<View> e;
    private ArrayList<dx> d = new ArrayList<>();
    private String f = "ViewTransitionController";
    ArrayList<dx.a> b = new ArrayList<>();

    public dy(dt dtVar) {
        this.c = dtVar;
    }

    public void a(dx dxVar) {
        this.d.add(dxVar);
        this.e = null;
        if (dxVar.a() == 4) {
            a(dxVar, true);
        } else if (dxVar.a() == 5) {
            a(dxVar, false);
        }
    }

    private void a(dx dxVar, View... viewArr) {
        int currentState = this.c.getCurrentState();
        if (dxVar.a == 2) {
            dxVar.a(this, this.c, currentState, null, viewArr);
        } else if (currentState == -1) {
            String str = this.f;
            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + this.c.toString());
        } else {
            e c = this.c.c(currentState);
            if (c == null) {
                return;
            }
            dxVar.a(this, this.c, currentState, c, viewArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<dx> it = this.d.iterator();
        dx dxVar = null;
        while (it.hasNext()) {
            dx next = it.next();
            if (next.d() == i) {
                for (View view : viewArr) {
                    if (next.b(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    a(next, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                dxVar = next;
            }
        }
        if (dxVar == null) {
            Log.e(this.f, " Could not find ViewTransition");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent) {
        int currentState = this.c.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.e == null) {
            this.e = new HashSet<>();
            Iterator<dx> it = this.d.iterator();
            while (it.hasNext()) {
                dx next = it.next();
                int childCount = this.c.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.c.getChildAt(i);
                    if (next.a(childAt)) {
                        childAt.getId();
                        this.e.add(childAt);
                    }
                }
            }
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList<dx.a> arrayList = this.a;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<dx.a> it2 = this.a.iterator();
            while (it2.hasNext()) {
                it2.next().a(action, x, y);
            }
        }
        switch (action) {
            case 0:
            case 1:
                e c = this.c.c(currentState);
                Iterator<dx> it3 = this.d.iterator();
                while (it3.hasNext()) {
                    dx next2 = it3.next();
                    if (next2.a(action)) {
                        Iterator<View> it4 = this.e.iterator();
                        while (it4.hasNext()) {
                            View next3 = it4.next();
                            if (next2.a(next3)) {
                                next3.getHitRect(rect);
                                if (rect.contains((int) x, (int) y)) {
                                    next2.a(this, this.c, currentState, c, next3);
                                }
                            }
                        }
                    }
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(dx.a aVar) {
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.a.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(dx.a aVar) {
        this.b.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        ArrayList<dx.a> arrayList = this.a;
        if (arrayList == null) {
            return;
        }
        Iterator<dx.a> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.a.removeAll(this.b);
        this.b.clear();
        if (this.a.isEmpty()) {
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.c.invalidate();
    }

    private void a(final dx dxVar, final boolean z) {
        final int c = dxVar.c();
        final int b = dxVar.b();
        ConstraintLayout.getSharedValues().a(dxVar.c(), new k.a() { // from class: dy.1
        });
    }
}
