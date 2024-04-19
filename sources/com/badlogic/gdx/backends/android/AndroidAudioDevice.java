package com.badlogic.gdx.backends.android;

import android.media.AudioTrack;
/* loaded from: classes.dex */
class AndroidAudioDevice implements ju {
    private short[] buffer = new short[1024];
    private final boolean isMono;
    private final int latency;
    private final AudioTrack track;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidAudioDevice(int i, boolean z) {
        this.isMono = z;
        int minBufferSize = AudioTrack.getMinBufferSize(i, z ? 4 : 12, 2);
        this.track = new AudioTrack(3, i, z ? 4 : 12, 2, minBufferSize, 1);
        this.track.play();
        this.latency = minBufferSize / (z ? 1 : 2);
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.track.stop();
        this.track.release();
    }

    public boolean isMono() {
        return this.isMono;
    }

    public void writeSamples(short[] sArr, int i, int i2) {
        int write = this.track.write(sArr, i, i2);
        while (write != i2) {
            write += this.track.write(sArr, i + write, i2 - write);
        }
    }

    public void writeSamples(float[] fArr, int i, int i2) {
        if (this.buffer.length < fArr.length) {
            this.buffer = new short[fArr.length];
        }
        int i3 = i + i2;
        int i4 = 0;
        while (i < i3) {
            float f = fArr[i];
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -1.0f) {
                f = -1.0f;
            }
            this.buffer[i4] = (short) (f * 32767.0f);
            i++;
            i4++;
        }
        int write = this.track.write(this.buffer, 0, i2);
        while (write != i2) {
            write += this.track.write(this.buffer, write, i2 - write);
        }
    }

    public int getLatency() {
        return this.latency;
    }

    public void setVolume(float f) {
        this.track.setStereoVolume(f, f);
    }
}
