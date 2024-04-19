package com.badlogic.gdx.backends.android;

import android.media.AudioManager;
import android.media.SoundPool;
import com.badlogic.gdx.utils.m;
/* loaded from: classes.dex */
final class AndroidSound implements jx {
    final AudioManager manager;
    final int soundId;
    final SoundPool soundPool;
    final m streamIds = new m(8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidSound(SoundPool soundPool, AudioManager audioManager, int i) {
        this.soundPool = soundPool;
        this.manager = audioManager;
        this.soundId = i;
    }

    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        this.soundPool.unload(this.soundId);
    }

    public long play() {
        return play(1.0f);
    }

    public long play(float f) {
        if (this.streamIds.b == 8) {
            this.streamIds.a();
        }
        int play = this.soundPool.play(this.soundId, f, f, 1, 0, 1.0f);
        if (play == 0) {
            return -1L;
        }
        this.streamIds.b(0, play);
        return play;
    }

    public void stop() {
        int i = this.streamIds.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.soundPool.stop(this.streamIds.b(i2));
        }
    }

    public void stop(long j) {
        this.soundPool.stop((int) j);
    }

    public void pause() {
        this.soundPool.autoPause();
    }

    public void pause(long j) {
        this.soundPool.pause((int) j);
    }

    public void resume() {
        this.soundPool.autoResume();
    }

    public void resume(long j) {
        this.soundPool.resume((int) j);
    }

    public void setPitch(long j, float f) {
        this.soundPool.setRate((int) j, f);
    }

    public void setVolume(long j, float f) {
        this.soundPool.setVolume((int) j, f, f);
    }

    public long loop() {
        return loop(1.0f);
    }

    public long loop(float f) {
        if (this.streamIds.b == 8) {
            this.streamIds.a();
        }
        int play = this.soundPool.play(this.soundId, f, f, 1, -1, 1.0f);
        if (play == 0) {
            return -1L;
        }
        this.streamIds.b(0, play);
        return play;
    }

    public void setLooping(long j, boolean z) {
        this.soundPool.setLoop((int) j, z ? -1 : 0);
    }

    public void setPan(long j, float f, float f2) {
        float f3;
        if (f < 0.0f) {
            f3 = f2 * (1.0f - Math.abs(f));
        } else if (f > 0.0f) {
            f2 *= 1.0f - Math.abs(f);
            f3 = f2;
        } else {
            f3 = f2;
        }
        this.soundPool.setVolume((int) j, f2, f3);
    }

    public long play(float f, float f2, float f3) {
        float f4;
        float f5;
        if (this.streamIds.b == 8) {
            this.streamIds.a();
        }
        if (f3 < 0.0f) {
            f4 = f;
            f5 = f * (1.0f - Math.abs(f3));
        } else if (f3 > 0.0f) {
            f5 = f;
            f4 = f * (1.0f - Math.abs(f3));
        } else {
            f4 = f;
            f5 = f4;
        }
        int play = this.soundPool.play(this.soundId, f4, f5, 1, 0, f2);
        if (play == 0) {
            return -1L;
        }
        this.streamIds.b(0, play);
        return play;
    }

    public long loop(float f, float f2, float f3) {
        float f4;
        float f5;
        if (this.streamIds.b == 8) {
            this.streamIds.a();
        }
        if (f3 < 0.0f) {
            f4 = f;
            f5 = f * (1.0f - Math.abs(f3));
        } else if (f3 > 0.0f) {
            f5 = f;
            f4 = f * (1.0f - Math.abs(f3));
        } else {
            f4 = f;
            f5 = f4;
        }
        int play = this.soundPool.play(this.soundId, f4, f5, 1, -1, f2);
        if (play == 0) {
            return -1L;
        }
        this.streamIds.b(0, play);
        return play;
    }
}
