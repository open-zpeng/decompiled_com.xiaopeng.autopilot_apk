package defpackage;

import android.content.Context;
import android.content.Intent;
import defpackage.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ActivityResultContracts.java */
/* renamed from: h  reason: default package */
/* loaded from: classes.dex */
public final class h {

    /* compiled from: ActivityResultContracts.java */
    /* renamed from: h$b */
    /* loaded from: classes.dex */
    public static final class b extends g<Intent, androidx.activity.result.a> {
        @Override // defpackage.g
        public Intent a(Context context, Intent intent) {
            return intent;
        }

        @Override // defpackage.g
        /* renamed from: b */
        public androidx.activity.result.a a(int i, Intent intent) {
            return new androidx.activity.result.a(i, intent);
        }
    }

    /* compiled from: ActivityResultContracts.java */
    /* renamed from: h$a */
    /* loaded from: classes.dex */
    public static final class a extends g<String[], Map<String, Boolean>> {
        @Override // defpackage.g
        public Intent a(Context context, String[] strArr) {
            return a(strArr);
        }

        @Override // defpackage.g
        public g.a<Map<String, Boolean>> b(Context context, String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return new g.a<>(Collections.emptyMap());
            }
            ao aoVar = new ao();
            boolean z = true;
            for (String str : strArr) {
                boolean z2 = ea.a(context, str) == 0;
                aoVar.put(str, Boolean.valueOf(z2));
                if (!z2) {
                    z = false;
                }
            }
            if (z) {
                return new g.a<>(aoVar);
            }
            return null;
        }

        @Override // defpackage.g
        /* renamed from: b */
        public Map<String, Boolean> a(int i, Intent intent) {
            if (i != -1) {
                return Collections.emptyMap();
            }
            if (intent == null) {
                return Collections.emptyMap();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            int length = stringArrayExtra.length;
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(stringArrayExtra[i2], Boolean.valueOf(intArrayExtra[i2] == 0));
            }
            return hashMap;
        }

        static Intent a(String[] strArr) {
            return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        }
    }
}
