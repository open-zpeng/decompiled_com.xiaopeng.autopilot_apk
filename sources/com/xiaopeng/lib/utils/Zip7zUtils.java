package com.xiaopeng.lib.utils;

import com.google.protobuf.CodedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes.dex */
public class Zip7zUtils {
    public static void zip7z(String str, String str2) {
        File file;
        aft aftVar;
        aft aftVar2 = null;
        try {
            try {
                File file2 = new File(str2);
                file = new File(str);
                aftVar = new aft(file2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            if (file.isDirectory()) {
                zip7zDirectory(file, aftVar, "");
            } else {
                zip7zFile(file, aftVar, "");
            }
            FileUtils.closeQuietly(aftVar);
        } catch (IOException e2) {
            e = e2;
            aftVar2 = aftVar;
            System.out.println(e.toString());
            FileUtils.closeQuietly(aftVar2);
        } catch (Throwable th2) {
            th = th2;
            aftVar2 = aftVar;
            FileUtils.closeQuietly(aftVar2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void zip7zFile(File file, aft aftVar, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(file.getName());
            aftVar.a((aff) aftVar.a(file, sb.toString()));
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            BufferedInputStream bufferedInputStream3 = sb;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                bufferedInputStream3 = null;
                aftVar.a(bArr, 0, read);
            }
            FileUtils.closeQuietly(bufferedInputStream);
            bufferedInputStream2 = bufferedInputStream3;
            if (aftVar == null) {
                return;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(bufferedInputStream2);
            bufferedInputStream2 = bufferedInputStream2;
            if (aftVar == null) {
                return;
            }
            aftVar.a();
        } catch (IOException e4) {
            e = e4;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(bufferedInputStream2);
            bufferedInputStream2 = bufferedInputStream2;
            if (aftVar == null) {
                return;
            }
            aftVar.a();
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeQuietly(bufferedInputStream);
            if (aftVar != null) {
                aftVar.a();
            }
            throw th;
        }
        aftVar.a();
    }

    private static void zip7zDirectory(File file, aft aftVar, String str) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                zip7zDirectory(file2, aftVar, str + file2.getName() + "/");
            } else {
                zip7zFile(file2, aftVar, str);
            }
        }
    }
}
