package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
/* compiled from: OneShotPreDrawListener.java */
/* renamed from: gl  reason: default package */
/* loaded from: classes.dex */
public final class gl implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;

    private gl(View view, Runnable runnable) {
        this.a = view;
        this.b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static gl a(View view, Runnable runnable) {
        if (view != null) {
            if (runnable == null) {
                throw new NullPointerException("runnable == null");
            }
            gl glVar = new gl(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(glVar);
            view.addOnAttachStateChangeListener(glVar);
            return glVar;
        }
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    public void a() {
        if (this.b.isAlive()) {
            this.b.removeOnPreDrawListener(this);
        } else {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
