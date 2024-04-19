package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import com.badlogic.gdx.utils.k;
import defpackage.in;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class AndroidAudio implements im {
    private final AudioManager manager;
    protected final List<AndroidMusic> musics = new ArrayList();
    private final SoundPool soundPool;

    public AndroidAudio(Context context, AndroidApplicationConfiguration androidApplicationConfiguration) {
        if (!androidApplicationConfiguration.disableAudio) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.soundPool = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(androidApplicationConfiguration.maxSimultaneousSounds).build();
            } else {
                this.soundPool = new SoundPool(androidApplicationConfiguration.maxSimultaneousSounds, 3, 0);
            }
            this.manager = (AudioManager) context.getSystemService("audio");
            if (context instanceof Activity) {
                ((Activity) context).setVolumeControlStream(3);
                return;
            }
            return;
        }
        this.soundPool = null;
        this.manager = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pause() {
        if (this.soundPool == null) {
            return;
        }
        synchronized (this.musics) {
            for (AndroidMusic androidMusic : this.musics) {
                if (androidMusic.isPlaying()) {
                    androidMusic.pause();
                    androidMusic.wasPlaying = true;
                } else {
                    androidMusic.wasPlaying = false;
                }
            }
        }
        this.soundPool.autoPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resume() {
        if (this.soundPool == null) {
            return;
        }
        synchronized (this.musics) {
            for (int i = 0; i < this.musics.size(); i++) {
                if (this.musics.get(i).wasPlaying) {
                    this.musics.get(i).play();
                }
            }
        }
        this.soundPool.autoResume();
    }

    public ju newAudioDevice(int i, boolean z) {
        if (this.soundPool == null) {
            throw new k("Android audio is not enabled by the application config.");
        }
        return new AndroidAudioDevice(i, z);
    }

    @Override // defpackage.im
    public jw newMusic(jy jyVar) {
        if (this.soundPool == null) {
            throw new k("Android audio is not enabled by the application config.");
        }
        AndroidFileHandle androidFileHandle = (AndroidFileHandle) jyVar;
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (androidFileHandle.type() == in.a.Internal) {
            try {
                AssetFileDescriptor assetFileDescriptor = androidFileHandle.getAssetFileDescriptor();
                mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                assetFileDescriptor.close();
                mediaPlayer.prepare();
                AndroidMusic androidMusic = new AndroidMusic(this, mediaPlayer);
                synchronized (this.musics) {
                    this.musics.add(androidMusic);
                }
                return androidMusic;
            } catch (Exception e) {
                throw new k("Error loading audio file: " + jyVar + "\nNote: Internal audio files must be placed in the assets directory.", e);
            }
        }
        try {
            mediaPlayer.setDataSource(androidFileHandle.file().getPath());
            mediaPlayer.prepare();
            AndroidMusic androidMusic2 = new AndroidMusic(this, mediaPlayer);
            synchronized (this.musics) {
                this.musics.add(androidMusic2);
            }
            return androidMusic2;
        } catch (Exception e2) {
            throw new k("Error loading audio file: " + jyVar, e2);
        }
    }

    public jw newMusic(FileDescriptor fileDescriptor) {
        if (this.soundPool == null) {
            throw new k("Android audio is not enabled by the application config.");
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(fileDescriptor);
            mediaPlayer.prepare();
            AndroidMusic androidMusic = new AndroidMusic(this, mediaPlayer);
            synchronized (this.musics) {
                this.musics.add(androidMusic);
            }
            return androidMusic;
        } catch (Exception e) {
            throw new k("Error loading audio from FileDescriptor", e);
        }
    }

    @Override // defpackage.im
    public jx newSound(jy jyVar) {
        if (this.soundPool == null) {
            throw new k("Android audio is not enabled by the application config.");
        }
        AndroidFileHandle androidFileHandle = (AndroidFileHandle) jyVar;
        if (androidFileHandle.type() == in.a.Internal) {
            try {
                AssetFileDescriptor assetFileDescriptor = androidFileHandle.getAssetFileDescriptor();
                AndroidSound androidSound = new AndroidSound(this.soundPool, this.manager, this.soundPool.load(assetFileDescriptor, 1));
                assetFileDescriptor.close();
                return androidSound;
            } catch (IOException e) {
                throw new k("Error loading audio file: " + jyVar + "\nNote: Internal audio files must be placed in the assets directory.", e);
            }
        }
        try {
            return new AndroidSound(this.soundPool, this.manager, this.soundPool.load(androidFileHandle.file().getPath(), 1));
        } catch (Exception e2) {
            throw new k("Error loading audio file: " + jyVar, e2);
        }
    }

    public jv newAudioRecorder(int i, boolean z) {
        if (this.soundPool == null) {
            throw new k("Android audio is not enabled by the application config.");
        }
        return new AndroidAudioRecorder(i, z);
    }

    public void dispose() {
        if (this.soundPool == null) {
            return;
        }
        synchronized (this.musics) {
            Iterator it = new ArrayList(this.musics).iterator();
            while (it.hasNext()) {
                ((AndroidMusic) it.next()).dispose();
            }
        }
        this.soundPool.release();
    }
}
