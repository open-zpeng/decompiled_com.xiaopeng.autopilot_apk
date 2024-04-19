package com.badlogic.gdx.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.regex.Pattern;
/* compiled from: JsonWriter.java */
/* loaded from: classes.dex */
public class r extends Writer {
    final Writer a;
    private final com.badlogic.gdx.utils.a<a> b;
    private a c;
    private boolean d;

    public r a() throws IOException {
        if (this.d) {
            throw new IllegalStateException("Expected an object, array, or value since a name was set.");
        }
        this.b.a().a();
        this.c = this.b.b == 0 ? null : this.b.b();
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.a.write(cArr, i, i2);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        while (this.b.b > 0) {
            a();
        }
        this.a.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonWriter.java */
    /* loaded from: classes.dex */
    public class a {
        final boolean a;
        final /* synthetic */ r b;

        void a() throws IOException {
            this.b.a.write(this.a ? 93 : 125);
        }
    }

    /* compiled from: JsonWriter.java */
    /* loaded from: classes.dex */
    public enum b {
        json,
        javascript,
        minimal;
        
        private static Pattern a = Pattern.compile("^[a-zA-Z_$][a-zA-Z_$0-9]*$");
        private static Pattern b = Pattern.compile("^[^\":,}/ ][^:]*$");
        private static Pattern c = Pattern.compile("^[^\":,{\\[\\]/ ][^}\\],]*$");

        public String quoteValue(Object obj) {
            int length;
            if (obj == null) {
                return "null";
            }
            String obj2 = obj.toString();
            if ((obj instanceof Number) || (obj instanceof Boolean)) {
                return obj2;
            }
            al alVar = new al(obj2);
            alVar.a('\\', "\\\\").a('\r', "\\r").a('\n', "\\n").a('\t', "\\t");
            if (this == minimal && !obj2.equals("true") && !obj2.equals("false") && !obj2.equals("null") && !obj2.contains("//") && !obj2.contains("/*") && (length = alVar.length()) > 0 && alVar.charAt(length - 1) != ' ' && c.matcher(alVar).matches()) {
                return alVar.toString();
            }
            return '\"' + alVar.a('\"', "\\\"").toString() + '\"';
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String quoteName(java.lang.String r5) {
            /*
                r4 = this;
                com.badlogic.gdx.utils.al r0 = new com.badlogic.gdx.utils.al
                r0.<init>(r5)
                java.lang.String r1 = "\\\\"
                r2 = 92
                com.badlogic.gdx.utils.al r1 = r0.a(r2, r1)
                java.lang.String r2 = "\\r"
                r3 = 13
                com.badlogic.gdx.utils.al r1 = r1.a(r3, r2)
                java.lang.String r2 = "\\n"
                r3 = 10
                com.badlogic.gdx.utils.al r1 = r1.a(r3, r2)
                java.lang.String r2 = "\\t"
                r3 = 9
                r1.a(r3, r2)
                int[] r1 = com.badlogic.gdx.utils.r.AnonymousClass1.a
                int r2 = r4.ordinal()
                r1 = r1[r2]
                switch(r1) {
                    case 1: goto L30;
                    case 2: goto L51;
                    default: goto L2f;
                }
            L2f:
                goto L62
            L30:
                java.lang.String r1 = "//"
                boolean r1 = r5.contains(r1)
                if (r1 != 0) goto L51
                java.lang.String r1 = "/*"
                boolean r5 = r5.contains(r1)
                if (r5 != 0) goto L51
                java.util.regex.Pattern r5 = com.badlogic.gdx.utils.r.b.b
                java.util.regex.Matcher r5 = r5.matcher(r0)
                boolean r5 = r5.matches()
                if (r5 == 0) goto L51
                java.lang.String r5 = r0.toString()
                return r5
            L51:
                java.util.regex.Pattern r5 = com.badlogic.gdx.utils.r.b.a
                java.util.regex.Matcher r5 = r5.matcher(r0)
                boolean r5 = r5.matches()
                if (r5 == 0) goto L62
                java.lang.String r5 = r0.toString()
                return r5
            L62:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r1 = 34
                r5.append(r1)
                java.lang.String r2 = "\\\""
                com.badlogic.gdx.utils.al r0 = r0.a(r1, r2)
                java.lang.String r0 = r0.toString()
                r5.append(r0)
                r5.append(r1)
                java.lang.String r5 = r5.toString()
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.r.b.quoteName(java.lang.String):java.lang.String");
        }
    }
}
