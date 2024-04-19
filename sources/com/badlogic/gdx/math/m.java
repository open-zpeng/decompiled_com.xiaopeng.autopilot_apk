package com.badlogic.gdx.math;

import java.util.Random;
/* compiled from: RandomXS128.java */
/* loaded from: classes.dex */
public class m extends Random {
    private long a;
    private long b;

    private static final long b(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    public m() {
        setSeed(new Random().nextLong());
    }

    @Override // java.util.Random
    public long nextLong() {
        long j = this.a;
        long j2 = this.b;
        this.a = j2;
        long j3 = j ^ (j << 23);
        long j4 = ((j3 >>> 17) ^ (j3 ^ j2)) ^ (j2 >>> 26);
        this.b = j4;
        return j4 + j2;
    }

    @Override // java.util.Random
    protected final int next(int i) {
        return (int) (nextLong() & ((1 << i) - 1));
    }

    @Override // java.util.Random
    public int nextInt() {
        return (int) nextLong();
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return (int) a(i);
    }

    public long a(long j) {
        long nextLong;
        long j2;
        if (j > 0) {
            do {
                nextLong = nextLong() >>> 1;
                j2 = nextLong % j;
            } while ((nextLong - j2) + (j - 1) < 0);
            return j2;
        }
        throw new IllegalArgumentException("n must be positive");
    }

    @Override // java.util.Random
    public double nextDouble() {
        return (nextLong() >>> 11) * 1.1102230246251565E-16d;
    }

    @Override // java.util.Random
    public float nextFloat() {
        return (float) ((nextLong() >>> 40) * 5.9604644775390625E-8d);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return (nextLong() & 1) != 0;
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        int length = bArr.length;
        while (length != 0) {
            int i = length < 8 ? length : 8;
            long nextLong = nextLong();
            while (true) {
                int i2 = i - 1;
                if (i != 0) {
                    length--;
                    bArr[length] = (byte) nextLong;
                    nextLong >>= 8;
                    i = i2;
                }
            }
        }
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (j == 0) {
            j = Long.MIN_VALUE;
        }
        long b = b(j);
        a(b, b(b));
    }

    public void a(long j, long j2) {
        this.a = j;
        this.b = j2;
    }
}
