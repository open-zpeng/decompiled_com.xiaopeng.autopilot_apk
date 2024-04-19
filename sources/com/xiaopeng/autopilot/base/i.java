package com.xiaopeng.autopilot.base;

import com.xiaopeng.autopilot.base.h;
import java.util.HashMap;
/* compiled from: StateMachine.java */
/* loaded from: classes.dex */
public class i {
    private static HashMap<Class<? extends d>, d> a = new HashMap<>();

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    interface v<T> {
        void a();
    }

    public static <D> void a(Class<? extends d> cls, D d2) {
        try {
            d dVar = a.get(cls);
            if (dVar == null) {
                d newInstance = cls.newInstance();
                newInstance.a(d2);
                a.put(cls, newInstance);
            } else {
                dVar.a(d2);
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    public static <S extends d> S a(Class<? extends d> cls) {
        S s2;
        S s3 = (S) a.get(cls);
        if (s3 == null) {
            try {
                s2 = (S) cls.newInstance();
            } catch (IllegalAccessException e2) {
                e = e2;
            } catch (InstantiationException e3) {
                e = e3;
            }
            try {
                a.put(cls, s2);
                return s2;
            } catch (IllegalAccessException e4) {
                e = e4;
                s3 = s2;
                e.printStackTrace();
                return s3;
            } catch (InstantiationException e5) {
                e = e5;
                s3 = s2;
                e.printStackTrace();
                return s3;
            }
        }
        return s3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static abstract class d<M> implements v {
        protected M a = c();

        protected abstract M c();

        /* JADX WARN: Multi-variable type inference failed */
        public M a(Object obj) {
            this.a = obj;
            return obj;
        }

        public M d() {
            return this.a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("key:" + getClass().getSimpleName());
            sb.append("\tvalue:" + this.a.toString());
            return sb.toString();
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class u extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer a(Object obj) {
            ((n) i.a(n.class)).a(((ac) i.a(ac.class)).d().intValue(), ((Integer) obj).intValue());
            return (Integer) super.a(obj);
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class m extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class aa extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ac extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Integer, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Integer, M] */
        /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Integer, M] */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Integer, M] */
        /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Integer, M] */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Integer, M] */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Integer, M] */
        public void a(int i) {
            if (i == 1 || i == 15 || i == 16 || i == 22 || i == 23) {
                this.a = 5;
            } else if (i == 5 || i == 35 || i == 7 || i == 10) {
                this.a = 4;
            } else if (i == 6 || i == 11) {
                this.a = 3;
            } else if (i == 4 || i == 9 || i == 13 || i == 14 || i == 26) {
                this.a = 2;
            } else if (i == 3 || i == 33 || i == 34 || i == 8 || i == 2 || i == 12) {
                this.a = 1;
            } else {
                this.a = 0;
            }
            ((n) i.a(n.class)).a(((Integer) this.a).intValue(), ((u) i.a(u.class)).d().intValue());
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class w extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ab extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class x extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class z extends d<Integer> {
        private final String[] b = com.xiaopeng.autopilot.base.a.g().getResources().getStringArray(h.a.array_toast_super_park);

        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }

        public boolean e() {
            return ((Integer) this.a).intValue() == 7;
        }

        public String f() {
            int intValue = ((Integer) this.a).intValue();
            String[] strArr = this.b;
            return (strArr == null || intValue >= strArr.length) ? "" : strArr[intValue];
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class s extends d<a> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public a c() {
            return new a(false, false);
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [com.xiaopeng.autopilot.base.i$s$a, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            if (this.a == 0) {
                this.a = new a(false, false);
                return;
            }
            ((a) this.a).b = false;
            ((a) this.a).a = false;
        }

        public void e() {
            if (this.a != 0) {
                ((a) this.a).a = true;
            }
        }

        public void f() {
            if (this.a != 0) {
                ((a) this.a).b = true;
            }
        }

        /* compiled from: StateMachine.java */
        /* loaded from: classes.dex */
        public static class a {
            public boolean a;
            public boolean b;

            public a(boolean z, boolean z2) {
                this.a = false;
                this.b = false;
                this.a = z;
                this.b = z2;
            }
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class n extends d<String> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public String c() {
            return "driving";
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = "driving";
        }

        public void a(int i, int i2) {
            switch (i) {
                case 0:
                    if (i2 == 3) {
                        a("ma_a_parking");
                        return;
                    } else {
                        a("driving");
                        return;
                    }
                case 1:
                case 2:
                case 3:
                case 4:
                    a("at_b_parking");
                    return;
                case 5:
                    a("at_a_parking");
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class af extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class au extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class av extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            a(-1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return -1;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ao extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class y extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ai extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class e extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class f extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class h extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class g extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class j extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ah extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return true;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class at extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class as extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class c extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class a extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class t extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class am extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class an extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class l extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 1;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ar extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class p extends d<Float> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Float c() {
            return Float.valueOf(0.0f);
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class o extends d<a> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public a c() {
            return new a(false, false, false);
        }

        /* compiled from: StateMachine.java */
        /* loaded from: classes.dex */
        public static class a {
            public boolean a;
            public boolean b;
            public boolean c;

            public a(boolean z, boolean z2, boolean z3) {
                this.b = false;
                this.c = false;
                this.a = z;
                this.b = z2;
                this.c = z3;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("{");
                sb.append("mAttachedToWindow:" + this.a);
                sb.append("\tmIsAssetLoaded:" + this.b);
                sb.append("\tmIsDrivingCarLoaded:" + this.c);
                sb.append("}");
                return sb.toString();
            }
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ad extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Integer, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class q extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ag extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class aq extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* renamed from: com.xiaopeng.autopilot.base.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0051i extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ap extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class b extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
        }

        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ae extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Integer, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class r extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Integer, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 1;
        }

        public static Integer e() {
            if (i.a(r.class) != null) {
                return ((r) i.a(r.class)).d();
            }
            return 1;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class aj extends d<Integer> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Integer, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Integer c() {
            return 0;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class ak extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class al extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: classes.dex */
    public static class k extends d<Boolean> {
        @Override // com.xiaopeng.autopilot.base.i.d
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, M] */
        @Override // com.xiaopeng.autopilot.base.i.v
        public void a() {
            this.a = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.xiaopeng.autopilot.base.i.d
        /* renamed from: b */
        public Boolean c() {
            return false;
        }
    }
}
