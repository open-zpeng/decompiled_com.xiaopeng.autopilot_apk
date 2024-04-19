package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.q;
import java.io.IOException;
import java.io.Reader;
/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public class p implements c {
    private static final byte[] a = b();
    private static final short[] b = c();
    private static final char[] c = d();
    private static final byte[] d = e();
    private static final byte[] e = f();
    private static final short[] f = g();
    private static final byte[] g = h();
    private static final byte[] h = i();
    private static final byte[] i = j();
    private static final byte[] j = k();
    private final a<q> k = new a<>(8);
    private final a<q> l = new a<>(8);
    private q m;
    private q n;

    public q a(Reader reader) {
        try {
            try {
                char[] cArr = new char[1024];
                int i2 = 0;
                while (true) {
                    int read = reader.read(cArr, i2, cArr.length - i2);
                    if (read == -1) {
                        return a(cArr, 0, i2);
                    }
                    if (read == 0) {
                        char[] cArr2 = new char[cArr.length * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        cArr = cArr2;
                    } else {
                        i2 += read;
                    }
                }
            } catch (IOException e2) {
                throw new af(e2);
            }
        } finally {
            ak.a(reader);
        }
    }

    @Override // com.badlogic.gdx.utils.c
    public q a(jy jyVar) {
        try {
            return a(jyVar.reader("UTF-8"));
        } catch (Exception e2) {
            throw new af("Error parsing file: " + jyVar, e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[Catch: RuntimeException -> 0x030b, TryCatch #4 {RuntimeException -> 0x030b, blocks: (B:210:0x0301, B:11:0x002d, B:13:0x003b, B:15:0x0044, B:16:0x0049, B:18:0x0059, B:19:0x005d, B:21:0x0065, B:22:0x006b, B:35:0x00b2, B:37:0x00c0, B:38:0x00ca, B:40:0x00ce, B:121:0x0196, B:123:0x019c, B:124:0x019f, B:126:0x01a5, B:128:0x01a9, B:133:0x01b9, B:140:0x01ce, B:141:0x01da, B:143:0x01de, B:145:0x01e7, B:147:0x01ed, B:148:0x01f8, B:149:0x0204, B:150:0x0210, B:152:0x0214, B:154:0x021d, B:156:0x0223, B:158:0x0230, B:159:0x023b, B:161:0x0247, B:163:0x024d, B:164:0x0256, B:166:0x025a, B:169:0x0264, B:171:0x026c, B:172:0x0275, B:174:0x027d, B:175:0x0285, B:177:0x028d, B:180:0x029a, B:195:0x02c2, B:201:0x02d8, B:198:0x02cd, B:23:0x0070, B:25:0x0076, B:27:0x007e, B:28:0x0081, B:30:0x0096, B:31:0x009b, B:33:0x00a5, B:34:0x00ac, B:216:0x0311, B:217:0x031c, B:219:0x0320, B:222:0x032d, B:224:0x0336, B:226:0x033c, B:227:0x0344, B:229:0x0348, B:232:0x0352, B:234:0x035a, B:235:0x0361, B:237:0x036a, B:238:0x0371, B:240:0x0379, B:243:0x0384, B:259:0x03aa, B:261:0x03b4, B:264:0x03be), top: B:302:0x0301 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0311 A[Catch: RuntimeException -> 0x030b, TryCatch #4 {RuntimeException -> 0x030b, blocks: (B:210:0x0301, B:11:0x002d, B:13:0x003b, B:15:0x0044, B:16:0x0049, B:18:0x0059, B:19:0x005d, B:21:0x0065, B:22:0x006b, B:35:0x00b2, B:37:0x00c0, B:38:0x00ca, B:40:0x00ce, B:121:0x0196, B:123:0x019c, B:124:0x019f, B:126:0x01a5, B:128:0x01a9, B:133:0x01b9, B:140:0x01ce, B:141:0x01da, B:143:0x01de, B:145:0x01e7, B:147:0x01ed, B:148:0x01f8, B:149:0x0204, B:150:0x0210, B:152:0x0214, B:154:0x021d, B:156:0x0223, B:158:0x0230, B:159:0x023b, B:161:0x0247, B:163:0x024d, B:164:0x0256, B:166:0x025a, B:169:0x0264, B:171:0x026c, B:172:0x0275, B:174:0x027d, B:175:0x0285, B:177:0x028d, B:180:0x029a, B:195:0x02c2, B:201:0x02d8, B:198:0x02cd, B:23:0x0070, B:25:0x0076, B:27:0x007e, B:28:0x0081, B:30:0x0096, B:31:0x009b, B:33:0x00a5, B:34:0x00ac, B:216:0x0311, B:217:0x031c, B:219:0x0320, B:222:0x032d, B:224:0x0336, B:226:0x033c, B:227:0x0344, B:229:0x0348, B:232:0x0352, B:234:0x035a, B:235:0x0361, B:237:0x036a, B:238:0x0371, B:240:0x0379, B:243:0x0384, B:259:0x03aa, B:261:0x03b4, B:264:0x03be), top: B:302:0x0301 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076 A[Catch: RuntimeException -> 0x030b, TryCatch #4 {RuntimeException -> 0x030b, blocks: (B:210:0x0301, B:11:0x002d, B:13:0x003b, B:15:0x0044, B:16:0x0049, B:18:0x0059, B:19:0x005d, B:21:0x0065, B:22:0x006b, B:35:0x00b2, B:37:0x00c0, B:38:0x00ca, B:40:0x00ce, B:121:0x0196, B:123:0x019c, B:124:0x019f, B:126:0x01a5, B:128:0x01a9, B:133:0x01b9, B:140:0x01ce, B:141:0x01da, B:143:0x01de, B:145:0x01e7, B:147:0x01ed, B:148:0x01f8, B:149:0x0204, B:150:0x0210, B:152:0x0214, B:154:0x021d, B:156:0x0223, B:158:0x0230, B:159:0x023b, B:161:0x0247, B:163:0x024d, B:164:0x0256, B:166:0x025a, B:169:0x0264, B:171:0x026c, B:172:0x0275, B:174:0x027d, B:175:0x0285, B:177:0x028d, B:180:0x029a, B:195:0x02c2, B:201:0x02d8, B:198:0x02cd, B:23:0x0070, B:25:0x0076, B:27:0x007e, B:28:0x0081, B:30:0x0096, B:31:0x009b, B:33:0x00a5, B:34:0x00ac, B:216:0x0311, B:217:0x031c, B:219:0x0320, B:222:0x032d, B:224:0x0336, B:226:0x033c, B:227:0x0344, B:229:0x0348, B:232:0x0352, B:234:0x035a, B:235:0x0361, B:237:0x036a, B:238:0x0371, B:240:0x0379, B:243:0x0384, B:259:0x03aa, B:261:0x03b4, B:264:0x03be), top: B:302:0x0301 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0301 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x02fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x02f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c0 A[Catch: RuntimeException -> 0x030b, TryCatch #4 {RuntimeException -> 0x030b, blocks: (B:210:0x0301, B:11:0x002d, B:13:0x003b, B:15:0x0044, B:16:0x0049, B:18:0x0059, B:19:0x005d, B:21:0x0065, B:22:0x006b, B:35:0x00b2, B:37:0x00c0, B:38:0x00ca, B:40:0x00ce, B:121:0x0196, B:123:0x019c, B:124:0x019f, B:126:0x01a5, B:128:0x01a9, B:133:0x01b9, B:140:0x01ce, B:141:0x01da, B:143:0x01de, B:145:0x01e7, B:147:0x01ed, B:148:0x01f8, B:149:0x0204, B:150:0x0210, B:152:0x0214, B:154:0x021d, B:156:0x0223, B:158:0x0230, B:159:0x023b, B:161:0x0247, B:163:0x024d, B:164:0x0256, B:166:0x025a, B:169:0x0264, B:171:0x026c, B:172:0x0275, B:174:0x027d, B:175:0x0285, B:177:0x028d, B:180:0x029a, B:195:0x02c2, B:201:0x02d8, B:198:0x02cd, B:23:0x0070, B:25:0x0076, B:27:0x007e, B:28:0x0081, B:30:0x0096, B:31:0x009b, B:33:0x00a5, B:34:0x00ac, B:216:0x0311, B:217:0x031c, B:219:0x0320, B:222:0x032d, B:224:0x0336, B:226:0x033c, B:227:0x0344, B:229:0x0348, B:232:0x0352, B:234:0x035a, B:235:0x0361, B:237:0x036a, B:238:0x0371, B:240:0x0379, B:243:0x0384, B:259:0x03aa, B:261:0x03b4, B:264:0x03be), top: B:302:0x0301 }] */
    /* JADX WARN: Type inference failed for: r0v53, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v62, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r17v18, types: [int] */
    /* JADX WARN: Type inference failed for: r17v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int[]] */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v18, types: [int] */
    /* JADX WARN: Type inference failed for: r7v42, types: [int] */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r9v22, types: [int] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.badlogic.gdx.utils.q a(char[] r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 1240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.p.a(char[], int, int):com.badlogic.gdx.utils.q");
    }

    private static byte[] b() {
        return new byte[]{0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 0, 7, 2, 0, 8, 2, 1, 3, 2, 1, 5};
    }

    private static short[] c() {
        return new short[]{0, 0, 11, 13, 14, 16, 25, 31, 37, 39, 50, 57, 64, 73, 74, 83, 85, 87, 96, 98, 100, 101, 103, 105, 116, 123, 130, 141, 142, 153, 155, 157, 168, 170, 172, 174, 179, 184, 184};
    }

    private static char[] d() {
        return new char[]{'\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '\"', '*', '/', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '*', '/', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', '}', '\t', '\n', '\r', ' ', ',', '/', '}', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '\"', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '\"', '*', '/', '*', '/', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', ']', '\t', '\n', '\r', ' ', ',', '/', ']', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\"', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '*', '/', '\r', ' ', '/', '\t', '\n', '\r', ' ', '/', '\t', '\n', 0};
    }

    private static byte[] e() {
        return new byte[]{0, 9, 2, 1, 2, 7, 4, 4, 2, 9, 7, 7, 7, 1, 7, 2, 2, 7, 2, 2, 1, 2, 2, 9, 7, 7, 9, 1, 9, 2, 2, 9, 2, 2, 2, 3, 3, 0, 0};
    }

    private static byte[] f() {
        return new byte[]{0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0};
    }

    private static short[] g() {
        return new short[]{0, 0, 11, 14, 16, 19, 28, 34, 40, 43, 54, 62, 70, 79, 81, 90, 93, 96, 105, 108, 111, 113, 116, 119, 130, 138, 146, 157, 159, 170, 173, 176, 187, 190, 193, 196, 201, 206, 207};
    }

    private static byte[] h() {
        return new byte[]{1, 1, 2, 3, 4, 3, 5, 3, 6, 1, 0, 7, 7, 3, 8, 3, 9, 9, 3, 11, 11, 12, 13, 14, 3, 15, 11, 10, 16, 16, 17, 18, 16, 3, 19, 19, 20, 21, 19, 3, 22, 22, 3, 21, 21, 24, 3, 25, 3, 26, 3, 27, 21, 23, 28, 29, 29, 28, 30, 31, 32, 3, 33, 34, 34, 33, 13, 35, 15, 3, 34, 34, 12, 36, 37, 3, 15, 34, 10, 16, 3, 36, 36, 12, 3, 38, 3, 3, 36, 10, 39, 39, 3, 40, 40, 3, 13, 13, 12, 3, 41, 3, 15, 13, 10, 42, 42, 3, 43, 43, 3, 28, 3, 44, 44, 3, 45, 45, 3, 47, 47, 48, 49, 50, 3, 51, 52, 53, 47, 46, 54, 55, 55, 54, 56, 57, 58, 3, 59, 60, 60, 59, 49, 61, 52, 3, 60, 60, 48, 62, 63, 3, 51, 52, 53, 60, 46, 54, 3, 62, 62, 48, 3, 64, 3, 51, 3, 53, 62, 46, 65, 65, 3, 66, 66, 3, 49, 49, 48, 3, 67, 3, 51, 52, 53, 49, 46, 68, 68, 3, 69, 69, 3, 70, 70, 3, 8, 8, 71, 8, 3, 72, 72, 73, 72, 3, 3, 3, 0};
    }

    private static byte[] i() {
        return new byte[]{35, 1, 3, 0, 4, 36, 36, 36, 36, 1, 6, 5, 13, 17, 22, 37, 7, 8, 9, 7, 8, 9, 7, 10, 20, 21, 11, 11, 11, 12, 17, 19, 37, 11, 12, 19, 14, 16, 15, 14, 12, 18, 17, 11, 9, 5, 24, 23, 27, 31, 34, 25, 38, 25, 25, 26, 31, 33, 38, 25, 26, 33, 28, 30, 29, 28, 26, 32, 31, 25, 23, 2, 36, 2};
    }

    private static byte[] j() {
        return new byte[]{13, 0, 15, 0, 0, 7, 3, 11, 1, 11, 17, 0, 20, 0, 0, 5, 1, 1, 1, 0, 0, 0, 11, 13, 15, 0, 7, 3, 1, 1, 1, 1, 23, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 11, 13, 0, 15, 0, 0, 7, 9, 3, 1, 1, 1, 1, 26, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 1, 0, 0};
    }

    private static byte[] k() {
        return new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
    }

    private void a(String str, q qVar) {
        qVar.e(str);
        q qVar2 = this.n;
        if (qVar2 == null) {
            this.n = qVar;
            this.m = qVar;
        } else if (qVar2.k() || this.n.l()) {
            q qVar3 = this.n;
            qVar.e = qVar3;
            if (qVar3.f == 0) {
                this.n.b = qVar;
            } else {
                q a2 = this.l.a();
                a2.c = qVar;
                qVar.d = a2;
            }
            this.l.a((a<q>) qVar);
            this.n.f++;
        } else {
            this.m = this.n;
        }
    }

    protected void a(String str) {
        q qVar = new q(q.c.object);
        if (this.n != null) {
            a(str, qVar);
        }
        this.k.a((a<q>) qVar);
        this.n = qVar;
    }

    protected void b(String str) {
        q qVar = new q(q.c.array);
        if (this.n != null) {
            a(str, qVar);
        }
        this.k.a((a<q>) qVar);
        this.n = qVar;
    }

    protected void a() {
        this.m = this.k.a();
        if (this.n.f > 0) {
            this.l.a();
        }
        this.n = this.k.b > 0 ? this.k.b() : null;
    }

    protected void a(String str, String str2) {
        a(str, new q(str2));
    }

    protected void a(String str, double d2, String str2) {
        a(str, new q(d2, str2));
    }

    protected void a(String str, long j2, String str2) {
        a(str, new q(j2, str2));
    }

    protected void a(String str, boolean z) {
        a(str, new q(z));
    }

    private String c(String str) {
        int length = str.length();
        al alVar = new al(length + 16);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt != '\\') {
                alVar.append(charAt);
                i2 = i3;
            } else if (i3 == length) {
                break;
            } else {
                i2 = i3 + 1;
                char charAt2 = str.charAt(i3);
                if (charAt2 == 'u') {
                    int i4 = i2 + 4;
                    alVar.b(Character.toChars(Integer.parseInt(str.substring(i2, i4), 16)));
                    i2 = i4;
                } else {
                    if (charAt2 != '\"' && charAt2 != '/' && charAt2 != '\\') {
                        if (charAt2 == 'b') {
                            charAt2 = '\b';
                        } else if (charAt2 == 'f') {
                            charAt2 = '\f';
                        } else if (charAt2 == 'n') {
                            charAt2 = '\n';
                        } else if (charAt2 == 'r') {
                            charAt2 = '\r';
                        } else if (charAt2 != 't') {
                            throw new af("Illegal escaped character: \\" + charAt2);
                        } else {
                            charAt2 = '\t';
                        }
                    }
                    alVar.append(charAt2);
                }
            }
        }
        return alVar.toString();
    }
}
