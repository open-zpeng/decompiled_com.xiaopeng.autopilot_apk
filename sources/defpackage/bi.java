package defpackage;

import java.util.Arrays;
import java.util.HashMap;
/* compiled from: KeyCache.java */
/* renamed from: bi  reason: default package */
/* loaded from: classes.dex */
public class bi {
    HashMap<Object, HashMap<String, float[]>> a = new HashMap<>();

    public void a(Object obj, String str, int i, float f) {
        if (!this.a.containsKey(obj)) {
            HashMap<String, float[]> hashMap = new HashMap<>();
            float[] fArr = new float[i + 1];
            fArr[i] = f;
            hashMap.put(str, fArr);
            this.a.put(obj, hashMap);
            return;
        }
        HashMap<String, float[]> hashMap2 = this.a.get(obj);
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        if (!hashMap2.containsKey(str)) {
            float[] fArr2 = new float[i + 1];
            fArr2[i] = f;
            hashMap2.put(str, fArr2);
            this.a.put(obj, hashMap2);
            return;
        }
        float[] fArr3 = hashMap2.get(str);
        if (fArr3 == null) {
            fArr3 = new float[0];
        }
        if (fArr3.length <= i) {
            fArr3 = Arrays.copyOf(fArr3, i + 1);
        }
        fArr3[i] = f;
        hashMap2.put(str, fArr3);
    }

    public float a(Object obj, String str, int i) {
        HashMap<String, float[]> hashMap;
        float[] fArr;
        if (this.a.containsKey(obj) && (hashMap = this.a.get(obj)) != null && hashMap.containsKey(str) && (fArr = hashMap.get(str)) != null && fArr.length > i) {
            return fArr[i];
        }
        return Float.NaN;
    }
}
