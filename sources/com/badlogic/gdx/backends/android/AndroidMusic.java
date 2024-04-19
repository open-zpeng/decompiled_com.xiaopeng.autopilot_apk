package com.badlogic.gdx.backends.android;

import android.media.MediaPlayer;
import defpackage.jw;
import java.io.IOException;
/* loaded from: classes.dex */
public class AndroidMusic implements MediaPlayer.OnCompletionListener, jw {
    private final AndroidAudio audio;
    private MediaPlayer player;
    private boolean isPrepared = true;
    protected boolean wasPlaying = false;
    private float volume = 1.0f;
    protected jw.a onCompletionListener = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidMusic(AndroidAudio androidAudio, MediaPlayer mediaPlayer) {
        this.audio = androidAudio;
        this.player = mediaPlayer;
        this.player.setOnCompletionListener(this);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.media.MediaPlayer, jw$a] */
    @Override // com.badlogic.gdx.utils.g, defpackage.ik
    public void dispose() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return;
        }
        try {
            try {
                mediaPlayer.release();
                this.player = null;
                this.onCompletionListener = null;
                synchronized (this.audio.musics) {
                    this.audio.musics.remove(this);
                }
            } finally {
                io.a.log("AndroidMusic", "error while disposing AndroidMusic instance, non-fatal");
            }
        } catch (Throwable th) {
            this.player = null;
            this.onCompletionListener = null;
            synchronized (this.audio.musics) {
                this.audio.musics.remove(this);
                throw th;
            }
        }
    }

    public boolean isLooping() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            return mediaPlayer.isLooping();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            return mediaPlayer.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void pause() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                this.player.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.wasPlaying = false;
    }

    public void play() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (mediaPlayer.isPlaying()) {
                return;
            }
            try {
                if (!this.isPrepared) {
                    this.player.prepare();
                    this.isPrepared = true;
                }
                this.player.start();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setLooping(z);
    }

    public void setVolume(float f) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setVolume(f, f);
        this.volume = f;
    }

    public float getVolume() {
        return this.volume;
    }

    public void setPan(float f, float f2) {
        float f3;
        float f4;
        if (this.player == null) {
            return;
        }
        if (f < 0.0f) {
            f4 = f2 * (1.0f - Math.abs(f));
            f3 = f2;
        } else if (f > 0.0f) {
            f3 = f2 * (1.0f - Math.abs(f));
            f4 = f2;
        } else {
            f3 = f2;
            f4 = f3;
        }
        this.player.setVolume(f3, f4);
        this.volume = f2;
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return;
        }
        if (this.isPrepared) {
            mediaPlayer.seekTo(0);
        }
        this.player.stop();
        this.isPrepared = false;
    }

    public void setPosition(float f) {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (!this.isPrepared) {
                mediaPlayer.prepare();
                this.isPrepared = true;
            }
            this.player.seekTo((int) (f * 1000.0f));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public float getPosition() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return 0.0f;
        }
        return mediaPlayer.getCurrentPosition() / 1000.0f;
    }

    public float getDuration() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return 0.0f;
        }
        return mediaPlayer.getDuration() / 1000.0f;
    }

    public void setOnCompletionListener(jw.a aVar) {
        this.onCompletionListener = aVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.onCompletionListener != null) {
            io.a.postRunnable(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidMusic.1
                @Override // java.lang.Runnable
                public void run() {
                    AndroidMusic.this.onCompletionListener.a(AndroidMusic.this);
                }
            });
        }
    }
}
