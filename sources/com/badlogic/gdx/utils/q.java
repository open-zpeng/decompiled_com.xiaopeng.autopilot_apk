package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.r;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: JsonValue.java */
/* loaded from: classes.dex */
public class q implements Iterable<q> {
    public String a;
    public q b;
    public q c;
    public q d;
    public q e;
    public int f;
    private c g;
    private String h;
    private double i;
    private long j;

    /* compiled from: JsonValue.java */
    /* loaded from: classes.dex */
    public static class b {
        public r.b a;
        public int b;
        public boolean c;
    }

    /* compiled from: JsonValue.java */
    /* loaded from: classes.dex */
    public enum c {
        object,
        array,
        stringValue,
        doubleValue,
        longValue,
        booleanValue,
        nullValue
    }

    public q(c cVar) {
        this.g = cVar;
    }

    public q(String str) {
        f(str);
    }

    public q(double d) {
        a(d, (String) null);
    }

    public q(long j) {
        a(j, (String) null);
    }

    public q(double d, String str) {
        a(d, str);
    }

    public q(long j, String str) {
        a(j, str);
    }

    public q(boolean z) {
        a(z);
    }

    public q a(int i) {
        q qVar = this.b;
        while (qVar != null && i > 0) {
            i--;
            qVar = qVar.c;
        }
        return qVar;
    }

    public q a(String str) {
        q qVar = this.b;
        while (qVar != null) {
            String str2 = qVar.a;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                break;
            }
            qVar = qVar.c;
        }
        return qVar;
    }

    public boolean b(String str) {
        return a(str) != null;
    }

    public q c(String str) {
        q qVar = this.b;
        while (qVar != null) {
            String str2 = qVar.a;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                break;
            }
            qVar = qVar.c;
        }
        if (qVar != null) {
            return qVar;
        }
        throw new IllegalArgumentException("Child not found with name: " + str);
    }

    public String a() {
        switch (this.g) {
            case stringValue:
                return this.h;
            case doubleValue:
                String str = this.h;
                return str != null ? str : Double.toString(this.i);
            case longValue:
                String str2 = this.h;
                return str2 != null ? str2 : Long.toString(this.j);
            case booleanValue:
                return this.j != 0 ? "true" : "false";
            case nullValue:
                return null;
            default:
                throw new IllegalStateException("Value cannot be converted to string: " + this.g);
        }
    }

    public float b() {
        switch (this.g) {
            case stringValue:
                return Float.parseFloat(this.h);
            case doubleValue:
                return (float) this.i;
            case longValue:
                return (float) this.j;
            case booleanValue:
                return this.j != 0 ? 1.0f : 0.0f;
            default:
                throw new IllegalStateException("Value cannot be converted to float: " + this.g);
        }
    }

    public double c() {
        switch (this.g) {
            case stringValue:
                return Double.parseDouble(this.h);
            case doubleValue:
                return this.i;
            case longValue:
                return this.j;
            case booleanValue:
                return this.j != 0 ? 1.0d : 0.0d;
            default:
                throw new IllegalStateException("Value cannot be converted to double: " + this.g);
        }
    }

    public long d() {
        switch (this.g) {
            case stringValue:
                return Long.parseLong(this.h);
            case doubleValue:
                return (long) this.i;
            case longValue:
                return this.j;
            case booleanValue:
                return this.j != 0 ? 1L : 0L;
            default:
                throw new IllegalStateException("Value cannot be converted to long: " + this.g);
        }
    }

    public int e() {
        switch (this.g) {
            case stringValue:
                return Integer.parseInt(this.h);
            case doubleValue:
                return (int) this.i;
            case longValue:
                return (int) this.j;
            case booleanValue:
                return this.j != 0 ? 1 : 0;
            default:
                throw new IllegalStateException("Value cannot be converted to int: " + this.g);
        }
    }

    public boolean f() {
        switch (this.g) {
            case stringValue:
                return this.h.equalsIgnoreCase("true");
            case doubleValue:
                return this.i != 0.0d;
            case longValue:
                return this.j != 0;
            case booleanValue:
                return this.j != 0;
            default:
                throw new IllegalStateException("Value cannot be converted to boolean: " + this.g);
        }
    }

    public byte g() {
        switch (this.g) {
            case stringValue:
                return Byte.parseByte(this.h);
            case doubleValue:
                return (byte) this.i;
            case longValue:
                return (byte) this.j;
            case booleanValue:
                return this.j != 0 ? (byte) 1 : (byte) 0;
            default:
                throw new IllegalStateException("Value cannot be converted to byte: " + this.g);
        }
    }

    public short h() {
        switch (this.g) {
            case stringValue:
                return Short.parseShort(this.h);
            case doubleValue:
                return (short) this.i;
            case longValue:
                return (short) this.j;
            case booleanValue:
                return this.j != 0 ? (short) 1 : (short) 0;
            default:
                throw new IllegalStateException("Value cannot be converted to short: " + this.g);
        }
    }

    public float[] i() {
        float parseFloat;
        if (this.g != c.array) {
            throw new IllegalStateException("Value is not an array: " + this.g);
        }
        float[] fArr = new float[this.f];
        int i = 0;
        q qVar = this.b;
        while (qVar != null) {
            switch (qVar.g) {
                case stringValue:
                    parseFloat = Float.parseFloat(qVar.h);
                    break;
                case doubleValue:
                    parseFloat = (float) qVar.i;
                    break;
                case longValue:
                    parseFloat = (float) qVar.j;
                    break;
                case booleanValue:
                    if (qVar.j == 0) {
                        parseFloat = 0.0f;
                        break;
                    } else {
                        parseFloat = 1.0f;
                        break;
                    }
                default:
                    throw new IllegalStateException("Value cannot be converted to float: " + qVar.g);
            }
            fArr[i] = parseFloat;
            qVar = qVar.c;
            i++;
        }
        return fArr;
    }

    public short[] j() {
        short parseShort;
        if (this.g != c.array) {
            throw new IllegalStateException("Value is not an array: " + this.g);
        }
        short[] sArr = new short[this.f];
        q qVar = this.b;
        int i = 0;
        while (qVar != null) {
            switch (qVar.g) {
                case stringValue:
                    parseShort = Short.parseShort(qVar.h);
                    break;
                case doubleValue:
                    parseShort = (short) qVar.i;
                    break;
                case longValue:
                    parseShort = (short) qVar.j;
                    break;
                case booleanValue:
                    if (qVar.j == 0) {
                        parseShort = 0;
                        break;
                    } else {
                        parseShort = 1;
                        break;
                    }
                default:
                    throw new IllegalStateException("Value cannot be converted to short: " + qVar.g);
            }
            sArr[i] = parseShort;
            qVar = qVar.c;
            i++;
        }
        return sArr;
    }

    public String a(String str, String str2) {
        q a2 = a(str);
        return (a2 == null || !a2.s() || a2.r()) ? str2 : a2.a();
    }

    public float a(String str, float f) {
        q a2 = a(str);
        return (a2 == null || !a2.s() || a2.r()) ? f : a2.b();
    }

    public String d(String str) {
        q a2 = a(str);
        if (a2 == null) {
            throw new IllegalArgumentException("Named value not found: " + str);
        }
        return a2.a();
    }

    public float b(int i) {
        q a2 = a(i);
        if (a2 == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.a);
        }
        return a2.b();
    }

    public short c(int i) {
        q a2 = a(i);
        if (a2 == null) {
            throw new IllegalArgumentException("Indexed value not found: " + this.a);
        }
        return a2.h();
    }

    public boolean k() {
        return this.g == c.array;
    }

    public boolean l() {
        return this.g == c.object;
    }

    public boolean m() {
        return this.g == c.stringValue;
    }

    public boolean n() {
        return this.g == c.doubleValue || this.g == c.longValue;
    }

    public boolean o() {
        return this.g == c.doubleValue;
    }

    public boolean p() {
        return this.g == c.longValue;
    }

    public boolean q() {
        return this.g == c.booleanValue;
    }

    public boolean r() {
        return this.g == c.nullValue;
    }

    public boolean s() {
        switch (this.g) {
            case stringValue:
            case doubleValue:
            case longValue:
            case booleanValue:
            case nullValue:
                return true;
            default:
                return false;
        }
    }

    public String t() {
        return this.a;
    }

    public void e(String str) {
        this.a = str;
    }

    public void f(String str) {
        this.h = str;
        this.g = str == null ? c.nullValue : c.stringValue;
    }

    public void a(double d, String str) {
        this.i = d;
        this.j = (long) d;
        this.h = str;
        this.g = c.doubleValue;
    }

    public void a(long j, String str) {
        this.j = j;
        this.i = j;
        this.h = str;
        this.g = c.longValue;
    }

    public void a(boolean z) {
        this.j = z ? 1L : 0L;
        this.g = c.booleanValue;
    }

    public String toString() {
        String str;
        if (s()) {
            if (this.a == null) {
                return a();
            }
            return this.a + ": " + a();
        }
        StringBuilder sb = new StringBuilder();
        if (this.a == null) {
            str = "";
        } else {
            str = this.a + ": ";
        }
        sb.append(str);
        sb.append(a(r.b.minimal, 0));
        return sb.toString();
    }

    public String a(r.b bVar, int i) {
        b bVar2 = new b();
        bVar2.a = bVar;
        bVar2.b = i;
        return a(bVar2);
    }

    public String a(b bVar) {
        al alVar = new al((int) IInputController.KEYCODE_BACK_BUTTON);
        a(this, alVar, 0, bVar);
        return alVar.toString();
    }

    private void a(q qVar, al alVar, int i, b bVar) {
        r.b bVar2 = bVar.a;
        if (qVar.l()) {
            if (qVar.b == null) {
                alVar.c("{}");
                return;
            }
            boolean z = !a(qVar);
            int length = alVar.length();
            loop0: while (true) {
                alVar.c(z ? "{\n" : "{ ");
                for (q qVar2 = qVar.b; qVar2 != null; qVar2 = qVar2.c) {
                    if (z) {
                        a(i, alVar);
                    }
                    alVar.c(bVar2.quoteName(qVar2.a));
                    alVar.c(": ");
                    a(qVar2, alVar, i + 1, bVar);
                    if ((!z || bVar2 != r.b.minimal) && qVar2.c != null) {
                        alVar.append(',');
                    }
                    alVar.append(z ? '\n' : ' ');
                    if (z || alVar.length() - length <= bVar.b) {
                    }
                }
                alVar.a(length);
                z = true;
            }
            if (z) {
                a(i - 1, alVar);
            }
            alVar.append('}');
        } else if (qVar.k()) {
            if (qVar.b == null) {
                alVar.c("[]");
                return;
            }
            boolean z2 = !a(qVar);
            boolean z3 = bVar.c || !b(qVar);
            int length2 = alVar.length();
            loop2: while (true) {
                alVar.c(z2 ? "[\n" : "[ ");
                for (q qVar3 = qVar.b; qVar3 != null; qVar3 = qVar3.c) {
                    if (z2) {
                        a(i, alVar);
                    }
                    a(qVar3, alVar, i + 1, bVar);
                    if ((!z2 || bVar2 != r.b.minimal) && qVar3.c != null) {
                        alVar.append(',');
                    }
                    alVar.append(z2 ? '\n' : ' ');
                    if (!z3 || z2 || alVar.length() - length2 <= bVar.b) {
                    }
                }
                alVar.a(length2);
                z2 = true;
            }
            if (z2) {
                a(i - 1, alVar);
            }
            alVar.append(']');
        } else if (qVar.m()) {
            alVar.c(bVar2.quoteValue(qVar.a()));
        } else if (qVar.o()) {
            double c2 = qVar.c();
            double d = qVar.d();
            if (c2 == d) {
                c2 = d;
            }
            alVar.a(c2);
        } else if (qVar.p()) {
            alVar.a(qVar.d());
        } else if (qVar.q()) {
            alVar.a(qVar.f());
        } else if (qVar.r()) {
            alVar.c("null");
        } else {
            throw new af("Unknown object type: " + qVar);
        }
    }

    private static boolean a(q qVar) {
        for (q qVar2 = qVar.b; qVar2 != null; qVar2 = qVar2.c) {
            if (qVar2.l() || qVar2.k()) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(q qVar) {
        for (q qVar2 = qVar.b; qVar2 != null; qVar2 = qVar2.c) {
            if (!qVar2.n()) {
                return false;
            }
        }
        return true;
    }

    private static void a(int i, al alVar) {
        for (int i2 = 0; i2 < i; i2++) {
            alVar.append('\t');
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: u */
    public a iterator() {
        return new a();
    }

    /* compiled from: JsonValue.java */
    /* loaded from: classes.dex */
    public class a implements Iterable<q>, Iterator<q> {
        q a;
        q b;

        @Override // java.lang.Iterable
        public Iterator<q> iterator() {
            return this;
        }

        public a() {
            this.a = q.this.b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != null;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public q next() {
            this.b = this.a;
            q qVar = this.b;
            if (qVar == null) {
                throw new NoSuchElementException();
            }
            this.a = qVar.c;
            return this.b;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.b.d == null) {
                q.this.b = this.b.c;
                if (q.this.b != null) {
                    q.this.b.d = null;
                }
            } else {
                this.b.d.c = this.b.c;
                if (this.b.c != null) {
                    this.b.c.d = this.b.d;
                }
            }
            q qVar = q.this;
            qVar.f--;
        }
    }

    public String v() {
        String str;
        q qVar = this.e;
        if (qVar == null) {
            return this.g == c.array ? "[]" : this.g == c.object ? "{}" : "";
        }
        if (qVar.g == c.array) {
            str = "[]";
            int i = 0;
            q qVar2 = this.e.b;
            while (true) {
                if (qVar2 == null) {
                    break;
                } else if (qVar2 != this) {
                    qVar2 = qVar2.c;
                    i++;
                } else {
                    str = "[" + i + "]";
                    break;
                }
            }
        } else if (this.a.indexOf(46) != -1) {
            str = ".\"" + this.a.replace("\"", "\\\"") + "\"";
        } else {
            str = '.' + this.a;
        }
        return this.e.v() + str;
    }
}
