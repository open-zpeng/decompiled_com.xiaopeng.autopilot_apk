package defpackage;

import java.nio.Buffer;
import java.nio.IntBuffer;
/* compiled from: GL30.java */
/* renamed from: kh  reason: default package */
/* loaded from: classes.dex */
public interface kh extends kg {
    void glBindVertexArray(int i);

    void glDeleteVertexArrays(int i, IntBuffer intBuffer);

    void glDrawBuffers(int i, IntBuffer intBuffer);

    void glGenVertexArrays(int i, IntBuffer intBuffer);

    void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Buffer buffer);

    @Override // defpackage.kg
    @Deprecated
    void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, Buffer buffer);
}
