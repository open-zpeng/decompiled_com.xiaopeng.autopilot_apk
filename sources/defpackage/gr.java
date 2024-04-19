package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* renamed from: gr  reason: default package */
/* loaded from: classes.dex */
public final class gr {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gr(View view) {
        this.d = new WeakReference<>(view);
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: gr$a */
    /* loaded from: classes.dex */
    static class a implements gs {
        gr a;
        boolean b;

        a(gr grVar) {
            this.a = grVar;
        }

        @Override // defpackage.gs
        public void a(View view) {
            this.b = false;
            if (this.a.c > -1) {
                view.setLayerType(2, null);
            }
            if (this.a.a != null) {
                Runnable runnable = this.a.a;
                this.a.a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            gs gsVar = tag instanceof gs ? (gs) tag : null;
            if (gsVar != null) {
                gsVar.a(view);
            }
        }

        @Override // defpackage.gs
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            if (this.a.c > -1) {
                view.setLayerType(this.a.c, null);
                this.a.c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                if (this.a.b != null) {
                    Runnable runnable = this.a.b;
                    this.a.b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                gs gsVar = tag instanceof gs ? (gs) tag : null;
                if (gsVar != null) {
                    gsVar.b(view);
                }
                this.b = true;
            }
        }

        @Override // defpackage.gs
        public void c(View view) {
            Object tag = view.getTag(2113929216);
            gs gsVar = tag instanceof gs ? (gs) tag : null;
            if (gsVar != null) {
                gsVar.c(view);
            }
        }
    }

    public gr a(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public gr a(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public gr b(float f) {
        View view = this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public long a() {
        View view = this.d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public gr a(Interpolator interpolator) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public gr b(long j) {
        View view = this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public gr a(gs gsVar) {
        View view = this.d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, gsVar);
            } else {
                view.setTag(2113929216, gsVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(final View view, final gs gsVar) {
        if (gsVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: gr.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    gsVar.c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    gsVar.b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    gsVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public gr a(final gu guVar) {
        final View view = this.d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(guVar != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: gr.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    guVar.a(view);
                }
            } : null);
        }
        return this;
    }
}
