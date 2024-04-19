package defpackage;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* compiled from: SevenZArchiveEntry.java */
/* renamed from: afp  reason: default package */
/* loaded from: classes.dex */
public class afp implements aff {
    private String a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private long h;
    private long i;
    private long j;
    private boolean k;
    private int l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private long q;
    private Iterable<? extends afs> r;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public boolean b() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean c() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public Date f() {
        if (this.e) {
            return e(this.h);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public boolean g() {
        return this.f;
    }

    public Date h() {
        if (this.f) {
            return e(this.i);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public void a(Date date) {
        this.f = date != null;
        if (this.f) {
            this.i = b(date);
        }
    }

    public boolean i() {
        return this.g;
    }

    public Date j() {
        if (this.g) {
            return e(this.j);
        }
        throw new UnsupportedOperationException("The entry doesn't have this timestamp");
    }

    public boolean k() {
        return this.k;
    }

    public int l() {
        return this.l;
    }

    public void c(boolean z) {
        this.m = z;
    }

    public long m() {
        return this.n;
    }

    public void a(long j) {
        this.n = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long n() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j) {
        this.o = j;
    }

    public long o() {
        return this.p;
    }

    public void c(long j) {
        this.p = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long p() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(long j) {
        this.q = j;
    }

    public Iterable<? extends afs> q() {
        return this.r;
    }

    public static Date e(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        calendar.set(1601, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return new Date(calendar.getTimeInMillis() + (j / 10000));
    }

    public static long b(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        calendar.set(1601, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return (date.getTime() - calendar.getTimeInMillis()) * 1000 * 10;
    }
}
