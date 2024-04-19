package com.badlogic.gdx.utils;

import com.google.protobuf.CodedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* compiled from: SharedLibraryLoader.java */
/* loaded from: classes.dex */
public class ag {
    public static boolean a;
    public static boolean b;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static boolean f = System.getProperty("os.arch").startsWith("arm");
    public static boolean g;
    public static String h;
    private static final HashSet<String> i;
    private String j;

    static {
        a = System.getProperty("os.name").contains("Windows");
        b = System.getProperty("os.name").contains("Linux");
        c = System.getProperty("os.name").contains("Mac");
        d = false;
        e = false;
        g = System.getProperty("os.arch").equals("amd64") || System.getProperty("os.arch").equals("x86_64");
        h = System.getProperty("sun.arch.abi") != null ? System.getProperty("sun.arch.abi") : "";
        boolean equals = "iOS".equals(System.getProperty("moe.platform.name"));
        String property = System.getProperty("java.runtime.name");
        if (property != null && property.contains("Android Runtime")) {
            e = true;
            a = false;
            b = false;
            c = false;
            g = false;
        }
        if (equals || (!e && !a && !b && !c)) {
            d = true;
            e = false;
            a = false;
            b = false;
            c = false;
            g = false;
        }
        i = new HashSet<>();
    }

    public String a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
            } catch (Exception unused) {
            } catch (Throwable th) {
                ak.a(inputStream);
                throw th;
            }
        }
        ak.a(inputStream);
        return Long.toString(crc32.getValue(), 16);
    }

    public String a(String str) {
        String str2;
        if (a) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(g ? "64.dll" : ".dll");
            return sb.toString();
        } else if (!b) {
            if (c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("lib");
                sb2.append(str);
                sb2.append(g ? "64.dylib" : ".dylib");
                return sb2.toString();
            }
            return str;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("lib");
            sb3.append(str);
            if (f) {
                str2 = "arm" + h;
            } else {
                str2 = "";
            }
            sb3.append(str2);
            sb3.append(g ? "64.so" : ".so");
            return sb3.toString();
        }
    }

    public void b(String str) {
        if (d) {
            return;
        }
        synchronized (ag.class) {
            if (d(str)) {
                return;
            }
            String a2 = a(str);
            if (e) {
                System.loadLibrary(a2);
            } else {
                f(a2);
            }
            c(str);
        }
    }

    private InputStream e(String str) {
        String str2 = this.j;
        if (str2 == null) {
            InputStream resourceAsStream = ag.class.getResourceAsStream("/" + str);
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            throw new k("Unable to read file for extraction: " + str);
        }
        try {
            ZipFile zipFile = new ZipFile(str2);
            ZipEntry entry = zipFile.getEntry(str);
            if (entry == null) {
                throw new k("Couldn't find '" + str + "' in JAR: " + this.j);
            }
            return zipFile.getInputStream(entry);
        } catch (IOException e2) {
            throw new k("Error reading '" + str + "' in JAR: " + this.j, e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0035 A[EDGE_INSN: B:50:0x0035->B:17:0x0035 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.io.File a(java.lang.String r7, java.lang.String r8, java.io.File r9) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r9.exists()
            r1 = 0
            if (r0 == 0) goto L11
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L11
            r0.<init>(r9)     // Catch: java.io.FileNotFoundException -> L11
            java.lang.String r0 = r6.a(r0)     // Catch: java.io.FileNotFoundException -> L11
            goto L12
        L11:
            r0 = r1
        L12:
            if (r0 == 0) goto L1a
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L3b
        L1a:
            java.io.InputStream r8 = r6.e(r7)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            java.io.File r0 = r9.getParentFile()     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L50
            r0.mkdirs()     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L50
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L50
            r0.<init>(r9)     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L50
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
        L2e:
            int r2 = r8.read(r1)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            r3 = -1
            if (r2 != r3) goto L3c
            com.badlogic.gdx.utils.ak.a(r8)
            com.badlogic.gdx.utils.ak.a(r0)
        L3b:
            return r9
        L3c:
            r3 = 0
            r0.write(r1, r3, r2)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            goto L2e
        L41:
            r7 = move-exception
            r1 = r8
            r8 = r0
            goto L7f
        L45:
            r1 = move-exception
            r5 = r1
            r1 = r8
            r8 = r0
            r0 = r5
            goto L5b
        L4b:
            r7 = move-exception
            r5 = r1
            r1 = r8
            r8 = r5
            goto L7f
        L50:
            r0 = move-exception
            r5 = r1
            r1 = r8
            r8 = r5
            goto L5b
        L55:
            r7 = move-exception
            r8 = r1
            goto L7f
        L58:
            r8 = move-exception
            r0 = r8
            r8 = r1
        L5b:
            com.badlogic.gdx.utils.k r2 = new com.badlogic.gdx.utils.k     // Catch: java.lang.Throwable -> L7e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r3.<init>()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r4 = "Error extracting file: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L7e
            r3.append(r7)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r7 = "\nTo: "
            r3.append(r7)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r7 = r9.getAbsolutePath()     // Catch: java.lang.Throwable -> L7e
            r3.append(r7)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L7e
            r2.<init>(r7, r0)     // Catch: java.lang.Throwable -> L7e
            throw r2     // Catch: java.lang.Throwable -> L7e
        L7e:
            r7 = move-exception
        L7f:
            com.badlogic.gdx.utils.ak.a(r1)
            com.badlogic.gdx.utils.ak.a(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.ag.a(java.lang.String, java.lang.String, java.io.File):java.io.File");
    }

    private void f(String str) {
        String a2 = a(e(str));
        String name = new File(str).getName();
        Throwable b2 = b(str, a2, new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + a2, name));
        if (b2 == null) {
            return;
        }
        try {
            File createTempFile = File.createTempFile(a2, null);
            if (createTempFile.delete()) {
                if (b(str, a2, createTempFile) == null) {
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        if (b(str, a2, new File(System.getProperty("user.home") + "/.libgdx/" + a2, name)) == null) {
            return;
        }
        if (b(str, a2, new File(".temp/" + a2, name)) == null) {
            return;
        }
        File file = new File(System.getProperty("java.library.path"), str);
        if (file.exists()) {
            System.load(file.getAbsolutePath());
            return;
        }
        throw new k(b2);
    }

    private Throwable b(String str, String str2, File file) {
        try {
            System.load(a(str, str2, file).getAbsolutePath());
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    public static synchronized void c(String str) {
        synchronized (ag.class) {
            i.add(str);
        }
    }

    public static synchronized boolean d(String str) {
        boolean contains;
        synchronized (ag.class) {
            contains = i.contains(str);
        }
        return contains;
    }
}
