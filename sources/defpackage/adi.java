package defpackage;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
/* compiled from: CompositeException.java */
/* renamed from: adi  reason: default package */
/* loaded from: classes.dex */
public final class adi extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private final List<Throwable> a;
    private final String b;
    private Throwable c;

    public adi(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public adi(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof adi) {
                    linkedHashSet.addAll(((adi) th).a());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        arrayList.addAll(linkedHashSet);
        this.a = Collections.unmodifiableList(arrayList);
        this.b = this.a.size() + " exceptions occurred. ";
    }

    public List<Throwable> a() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.c == null) {
            a aVar = new a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.a.iterator();
            a aVar2 = aVar;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : b(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        aVar2.initCause(next);
                    } catch (Throwable unused) {
                    }
                    aVar2 = a(aVar2);
                }
            }
            this.c = aVar;
        }
        return this.c;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(new d(printWriter));
    }

    private void a(b bVar) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.a) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            a(sb, th, "\t");
            i++;
        }
        bVar.a(sb.toString());
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompositeException.java */
    /* renamed from: adi$b */
    /* loaded from: classes.dex */
    public static abstract class b {
        abstract void a(Object obj);

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompositeException.java */
    /* renamed from: adi$c */
    /* loaded from: classes.dex */
    public static final class c extends b {
        private final PrintStream a;

        c(PrintStream printStream) {
            this.a = printStream;
        }

        @Override // defpackage.adi.b
        void a(Object obj) {
            this.a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: adi$d */
    /* loaded from: classes.dex */
    static final class d extends b {
        private final PrintWriter a;

        d(PrintWriter printWriter) {
            this.a = printWriter;
        }

        @Override // defpackage.adi.b
        void a(Object obj) {
            this.a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: adi$a */
    /* loaded from: classes.dex */
    static final class a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }

        a() {
        }
    }

    private List<Throwable> b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause == null || cause == th) {
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return arrayList;
    }

    Throwable a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.c == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }
}
