package com.xiaopeng.autopilot.base;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* compiled from: TaskDispatcher.java */
/* loaded from: classes.dex */
public class j implements rm {
    protected Map<Integer, Queue> a;
    protected float b = 0.0f;
    protected int c = 0;
    protected int d = 0;

    public Map a() {
        if (this.a == null) {
            this.a = new HashMap();
        }
        return this.a;
    }

    public Queue<Runnable> a(int i) {
        Object obj = a().get(Integer.valueOf(i));
        Queue<Runnable> queue = obj != null ? (Queue) obj : null;
        if (queue == null) {
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            a().put(Integer.valueOf(i), concurrentLinkedQueue);
            return concurrentLinkedQueue;
        }
        return queue;
    }

    @Override // defpackage.rm
    public void a(Runnable runnable, int i) {
        if (runnable == null) {
            Log.w("TaskDispatcher", "runnable is null ！！！");
            return;
        }
        a(i).add(runnable);
        Log.i("TaskDispatcher", "push runnable" + runnable.toString() + "\tinto sence:\t" + i);
    }

    @Override // defpackage.rm
    public void b(int i) {
        Queue<Runnable> a;
        if (io.a.getGraphics().getFramesPerSecond() <= 35 || (a = a(i)) == null || a.size() <= 0) {
            return;
        }
        while (true) {
            Runnable poll = a.poll();
            if (poll == null) {
                return;
            }
            Log.i("TaskDispatcher", "execute runnable:\t" + poll.toString() + "\tin sence:\t" + i);
            io.a.postRunnable(poll);
        }
    }

    @Override // defpackage.rm
    public void b() {
        this.c += io.a.getGraphics().getFramesPerSecond();
        this.b += io.a.getGraphics().getDeltaTime();
        this.d++;
        if (this.b > 3.0f) {
            float f = this.c / this.d;
            Log.i("TaskDispatcher", "avg FPS is:\t" + f);
            if (f > 35 && this.a.size() > 0) {
                for (Integer num : this.a.keySet()) {
                    Queue queue = this.a.get(num);
                    if (queue != null && queue.size() > 0) {
                        while (true) {
                            Runnable runnable = (Runnable) queue.poll();
                            if (runnable != null) {
                                Log.i("TaskDispatcher", "execute runnable:\t" + runnable.toString() + "\t on free ");
                                io.a.postRunnable(runnable);
                            }
                        }
                    }
                }
            }
            this.b = 0.0f;
            this.c = 0;
            this.d = 0;
        }
    }

    @Override // defpackage.rm
    public boolean c() {
        Map<Integer, Queue> map = this.a;
        boolean z = true;
        if (map != null && map.size() > 0) {
            for (Integer num : this.a.keySet()) {
                Queue queue = this.a.get(num);
                if (queue != null && queue.size() > 0) {
                    z = false;
                }
            }
        }
        return z;
    }
}
