package defpackage;
/* compiled from: MathHelper.java */
/* renamed from: acr  reason: default package */
/* loaded from: classes.dex */
public class acr {
    public static boolean a(float f, float f2) {
        float abs = Math.abs(f - f2);
        return abs <= 1.0E-10f || abs <= Math.max(Math.abs(f), Math.abs(f2)) * 1.1920929E-7f;
    }
}
