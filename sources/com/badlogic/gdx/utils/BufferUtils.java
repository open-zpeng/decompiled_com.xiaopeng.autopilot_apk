package com.badlogic.gdx.utils;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/* loaded from: classes.dex */
public final class BufferUtils {
    static a<ByteBuffer> a = new a<>();
    static int b = 0;

    private static native void copyJni(float[] fArr, Buffer buffer, int i, int i2);

    private static native void freeMemory(ByteBuffer byteBuffer);

    private static native ByteBuffer newDisposableByteBuffer(int i);

    public static void a(float[] fArr, Buffer buffer, int i, int i2) {
        if (buffer instanceof ByteBuffer) {
            buffer.limit(i << 2);
        } else if (buffer instanceof FloatBuffer) {
            buffer.limit(i);
        }
        copyJni(fArr, buffer, i, i2);
        buffer.position(0);
    }

    public static FloatBuffer a(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asFloatBuffer();
    }

    public static ByteBuffer b(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect;
    }

    public static IntBuffer c(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asIntBuffer();
    }

    public static void a(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        synchronized (a) {
            if (!a.c(byteBuffer, true)) {
                throw new IllegalArgumentException("buffer not allocated with newUnsafeByteBuffer or already disposed");
            }
        }
        b -= capacity;
        freeMemory(byteBuffer);
    }

    public static ByteBuffer d(int i) {
        ByteBuffer newDisposableByteBuffer = newDisposableByteBuffer(i);
        newDisposableByteBuffer.order(ByteOrder.nativeOrder());
        b += i;
        synchronized (a) {
            a.a((a<ByteBuffer>) newDisposableByteBuffer);
        }
        return newDisposableByteBuffer;
    }
}
