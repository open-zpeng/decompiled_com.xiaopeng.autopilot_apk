package defpackage;

import java.lang.reflect.Array;
import java.util.Arrays;
/* compiled from: StepCurve.java */
/* renamed from: bq  reason: default package */
/* loaded from: classes.dex */
public class bq extends bh {
    bl d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(String str) {
        this.b = str;
        double[] dArr = new double[this.b.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i = 0;
        while (indexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        this.d = a(Arrays.copyOf(dArr, i + 1));
    }

    private static bl a(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, length, 1);
        double[] dArr3 = new double[length];
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            int i2 = i + length2;
            dArr2[i2][0] = d2;
            double d3 = i * d;
            dArr3[i2] = d3;
            if (i > 0) {
                int i3 = (length2 * 2) + i;
                dArr2[i3][0] = d2 + 1.0d;
                dArr3[i3] = d3 + 1.0d;
                int i4 = i - 1;
                dArr2[i4][0] = (d2 - 1.0d) - d;
                dArr3[i4] = (d3 - 1.0d) - d;
            }
        }
        bl blVar = new bl(dArr3, dArr2);
        System.out.println(" 0 " + blVar.a(0.0d, 0));
        System.out.println(" 1 " + blVar.a(1.0d, 0));
        return blVar;
    }

    @Override // defpackage.bh
    public double b(double d) {
        return this.d.b(d, 0);
    }

    @Override // defpackage.bh
    public double a(double d) {
        return this.d.a(d, 0);
    }
}
