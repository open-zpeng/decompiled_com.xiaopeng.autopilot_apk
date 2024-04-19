package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import defpackage.fi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontProvider.java */
/* renamed from: ff  reason: default package */
/* loaded from: classes.dex */
public class ff {
    private static final Comparator<byte[]> a = new Comparator<byte[]>() { // from class: ff.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static fi.a a(Context context, fg fgVar, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo a2 = a(context.getPackageManager(), fgVar, context.getResources());
        if (a2 == null) {
            return fi.a.a(1, null);
        }
        return fi.a.a(0, a(context, fgVar, a2.authority, cancellationSignal));
    }

    static ProviderInfo a(PackageManager packageManager, fg fgVar, Resources resources) throws PackageManager.NameNotFoundException {
        String a2 = fgVar.a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + a2);
        } else if (!resolveContentProvider.packageName.equals(fgVar.b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + a2 + ", but package was not " + fgVar.b());
        } else {
            List<byte[]> a3 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a3, a);
            List<List<byte[]>> a4 = a(fgVar, resources);
            for (int i = 0; i < a4.size(); i++) {
                ArrayList arrayList = new ArrayList(a4.get(i));
                Collections.sort(arrayList, a);
                if (a(a3, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    static fi.b[] a(Context context, fg fgVar, String str, CancellationSignal cancellationSignal) {
        int i;
        int i2;
        Uri withAppendedId;
        boolean z;
        int i3;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            int i4 = 0;
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, strArr, "query = ?", new String[]{fgVar.c()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(build, strArr, "query = ?", new String[]{fgVar.c()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i5 = columnIndex != -1 ? cursor.getInt(columnIndex) : i4;
                    int i6 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : i4;
                    if (columnIndex3 == -1) {
                        i2 = i5;
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        i2 = i5;
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    int i7 = columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400;
                    if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                        z = false;
                        i3 = i2;
                    } else {
                        i3 = i2;
                        z = true;
                    }
                    arrayList2.add(fi.b.a(withAppendedId, i6, i7, z, i3));
                    i4 = 0;
                }
                arrayList = arrayList2;
            }
            if (cursor != null) {
                cursor.close();
                i = 0;
            } else {
                i = 0;
            }
            return (fi.b[]) arrayList.toArray(new fi.b[i]);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static List<List<byte[]>> a(fg fgVar, Resources resources) {
        if (fgVar.d() != null) {
            return fgVar.d();
        }
        return eg.a(resources, fgVar.e());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }
}
