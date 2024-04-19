package defpackage;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
/* compiled from: Coders.java */
/* renamed from: afl  reason: default package */
/* loaded from: classes.dex */
class afl {
    private static final Map<afr, afk> a = new HashMap<afr, afk>() { // from class: afl.1
        private static final long serialVersionUID = 1664829131806520867L;

        {
            put(afr.COPY, new c());
            put(afr.LZMA, new e());
            put(afr.LZMA2, new afo());
            put(afr.DEFLATE, new d());
            put(afr.BZIP2, new b());
            put(afr.AES256SHA256, new afg());
            put(afr.BCJ_X86_FILTER, new a(new aha()));
            put(afr.BCJ_PPC_FILTER, new a(new agv()));
            put(afr.BCJ_IA64_FILTER, new a(new ags()));
            put(afr.BCJ_ARM_FILTER, new a(new agk()));
            put(afr.BCJ_ARM_THUMB_FILTER, new a(new agl()));
            put(afr.BCJ_SPARC_FILTER, new a(new agw()));
            put(afr.DELTA_FILTER, new afm());
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static afk a(afr afrVar) {
        return a.get(afrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputStream a(OutputStream outputStream, afr afrVar, Object obj) throws IOException {
        afk a2 = a(afrVar);
        if (a2 == null) {
            throw new IOException("Unsupported compression method " + afrVar);
        }
        return a2.a(outputStream, obj);
    }

    /* compiled from: Coders.java */
    /* renamed from: afl$c */
    /* loaded from: classes.dex */
    static class c extends afk {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // defpackage.afk
        public OutputStream a(OutputStream outputStream, Object obj) {
            return outputStream;
        }

        c() {
            super(new Class[0]);
        }
    }

    /* compiled from: Coders.java */
    /* renamed from: afl$e */
    /* loaded from: classes.dex */
    static class e extends afk {
        e() {
            super(new Class[0]);
        }
    }

    /* compiled from: Coders.java */
    /* renamed from: afl$a */
    /* loaded from: classes.dex */
    static class a extends afk {
        private final agp a;

        a(agp agpVar) {
            super(new Class[0]);
            this.a = agpVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // defpackage.afk
        public OutputStream a(OutputStream outputStream, Object obj) {
            return new FilterOutputStream(this.a.a(new agr(outputStream))) { // from class: afl.a.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
                public void flush() {
                }
            };
        }
    }

    /* compiled from: Coders.java */
    /* renamed from: afl$d */
    /* loaded from: classes.dex */
    static class d extends afk {
        d() {
            super(Number.class);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // defpackage.afk
        public OutputStream a(OutputStream outputStream, Object obj) {
            final Deflater deflater = new Deflater(a(obj, 9), true);
            final DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream, deflater);
            return new OutputStream() { // from class: afl.d.1
                @Override // java.io.OutputStream
                public void write(int i) throws IOException {
                    deflaterOutputStream.write(i);
                }

                @Override // java.io.OutputStream
                public void write(byte[] bArr) throws IOException {
                    deflaterOutputStream.write(bArr);
                }

                @Override // java.io.OutputStream
                public void write(byte[] bArr, int i, int i2) throws IOException {
                    deflaterOutputStream.write(bArr, i, i2);
                }

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    try {
                        deflaterOutputStream.close();
                    } finally {
                        deflater.end();
                    }
                }
            };
        }
    }

    /* compiled from: Coders.java */
    /* renamed from: afl$b */
    /* loaded from: classes.dex */
    static class b extends afk {
        b() {
            super(Number.class);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // defpackage.afk
        public OutputStream a(OutputStream outputStream, Object obj) throws IOException {
            return new afw(outputStream, a(obj, 9));
        }
    }
}
