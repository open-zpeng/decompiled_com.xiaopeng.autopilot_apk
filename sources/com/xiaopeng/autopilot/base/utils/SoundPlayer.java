package com.xiaopeng.autopilot.base.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.xiaopeng.autopilot.base.a;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.autopilot.base.h;
import com.xiaopeng.lib.utils.LogUtils;
import java.io.IOException;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class SoundPlayer implements AudioManager.OnAudioFocusChangeListener {
    private static final float BEEP_VOLUME = d.k;
    private static final String TAG = "SoundPlayer";
    private AudioManager mAudioManager;
    private MediaPlayer mMediaPlayer;
    private PlayRunnable mPlayRunnable;

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LazyHolder {
        static final SoundPlayer INSTANCE = new SoundPlayer();

        private LazyHolder() {
        }
    }

    public static SoundPlayer getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void init() {
        this.mPlayRunnable = new PlayRunnable();
        this.mAudioManager = (AudioManager) a.g().getSystemService("audio");
    }

    public void release() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
        this.mAudioManager = null;
        this.mPlayRunnable = null;
    }

    public void stop() {
        LogUtils.i(TAG, "stop，停止");
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void play(int i) {
        play(i, false);
    }

    private void play(int i, boolean z) {
        this.mPlayRunnable.setLooping(z);
        this.mPlayRunnable.setRawId(i);
        rh.a().b(this.mPlayRunnable);
    }

    public void playParkDisable() {
        LogUtils.i(TAG, "playParkDisable，播放");
        play(h.C0050h.sound_action_tone_disable);
    }

    public void playParkLotFound() {
        LogUtils.i(TAG, "playParkLotFound，播放");
        play(h.C0050h.sound_parklot_found);
    }

    public void playParkStart(boolean z) {
        LogUtils.i(TAG, "playParkStart，播放, isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (!re.a().h() && !d.a()) {
            play(h.C0050h.sound_action_tone_open);
        } else if (!z) {
            rd.a().a(a.g().getString(h.i.speech_park_start));
        } else {
            rd.a().a(a.g().getString(h.i.speech_park_start_out));
        }
    }

    public void playParkContinue(boolean z) {
        LogUtils.i(TAG, "playParkContinue，播放, isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (!re.a().h() && !d.a()) {
            play(h.C0050h.sound_action_tone_open);
        } else if (!z) {
            rd.a().a(a.g().getString(h.i.speech_park_continue));
        } else {
            rd.a().a(a.g().getString(h.i.speech_park_continue_out));
        }
    }

    public void playParkPause(boolean z) {
        LogUtils.i(TAG, "playParkPause，播放, isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (!re.a().h() && !d.a()) {
            play(h.C0050h.sound_park_pause);
        } else if (!z) {
            rd.a().a(a.g().getString(h.i.speech_park_pause));
        } else {
            rd.a().a(a.g().getString(h.i.speech_park_pause_out));
        }
    }

    public void playParkPauseObstacle() {
        LogUtils.i(TAG, "playParkPauseObstacle，播放, isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (re.a().h() || d.a()) {
            rd.a().a(a.g().getString(h.i.speech_park_pause_obstacle));
        } else {
            play(h.C0050h.sound_park_pause);
        }
    }

    public void playParkCancel(boolean z) {
        LogUtils.i(TAG, "playParkCancel，播放, isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (!re.a().h() && !d.a()) {
            play(h.C0050h.sound_action_tone_close);
        } else if (!z) {
            rd.a().a(a.g().getString(h.i.speech_park_exit));
        } else {
            rd.a().a(a.g().getString(h.i.speech_park_exit_out));
        }
    }

    public void playParkExit(boolean z) {
        LogUtils.i(TAG, "playParkExit，播放, isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (!re.a().h() && !d.a()) {
            play(h.C0050h.sound_action_tone_close);
        } else if (!z) {
            rd.a().a(a.g().getString(h.i.speech_park_exit));
        } else {
            rd.a().a(a.g().getString(h.i.speech_park_exit_out));
        }
    }

    public void playParkComplete(boolean z) {
        LogUtils.i(TAG, "playParkComplete，播放, isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (!re.a().h() && !d.a()) {
            play(h.C0050h.sound_action_tone_close);
        } else if (!z) {
            rd.a().a(a.g().getString(h.i.speech_park_complete), true);
        } else {
            rd.a().a(a.g().getString(h.i.speech_park_complete_out), true);
        }
    }

    public void playSlotOccupy() {
        LogUtils.i(TAG, "playSlotOccupy，播放, isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (re.a().h() || d.a()) {
            re.a().m();
        } else {
            play(h.C0050h.sound_action_unoperated);
        }
    }

    public void playHotAreaUnClickable(boolean z, String str) {
        playUnOperated(z, str);
    }

    public void playUnOperated(boolean z) {
        String string = a.g().getString(h.i.parking_click_after_stop);
        Log.i(TAG, "playUnOperated.playSound = " + z + ", tts = " + string + ",isSpeakingFlush = " + rd.a().d() + ", isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (rd.a().d()) {
            return;
        }
        rd.a().h(string);
    }

    public void playUnOperated(boolean z, String str) {
        Log.i(TAG, "playUnOperated.playSound = " + z + ", tts = " + str + ", isSpeechActived = " + re.a().h() + "，isSwitchSoundToSpeechTTS = " + d.a());
        if (!re.a().h() && !d.a()) {
            if (z) {
                play(h.C0050h.sound_action_unoperated);
                return;
            }
            return;
        }
        LogUtils.i(TAG, "isSpeakingFlush， " + rd.a().d());
        if (rd.a().d()) {
            return;
        }
        rd.a().h(str);
    }

    public void playWarning() {
        LogUtils.i(TAG, "playWarning，播放");
        play(h.C0050h.sound_warning);
    }

    public void playUnOperated() {
        LogUtils.i(TAG, "playUnOperated，播放");
        play(h.C0050h.sound_action_unoperated);
    }

    public void playSeriousWarning() {
        LogUtils.i(TAG, "playSeriousWarning，播放");
        play(h.C0050h.sound_serious_warning);
    }

    public void playActionOpenTone() {
        LogUtils.i(TAG, "playActionOpenTone，播放");
        play(h.C0050h.sound_action_tone_open);
    }

    public void playActionCloseTone() {
        LogUtils.i(TAG, "playActionCloseTone，播放");
        play(h.C0050h.sound_action_tone_close);
    }

    public void playActionDisableTone() {
        LogUtils.i(TAG, "playActionDisableTone，播放");
        play(h.C0050h.sound_action_tone_disable);
    }

    public void playDialogShow() {
        LogUtils.i(TAG, "playDialogShow，播放");
        play(h.C0050h.sound_dialog);
    }

    public void playSelectParklot() {
        LogUtils.i(TAG, "playSelectParklot，播放");
        MediaPlayerUtils.playSelectParklot(this);
    }

    public void playParkSlideWarning() {
        LogUtils.i(TAG, "playParkSlideWarning，播放， looping = true");
        play(h.C0050h.sound_serious_warning_loop, true);
    }

    static MediaPlayer getMediaPlayer(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (Build.VERSION.SDK_INT < 19) {
            return mediaPlayer;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(context, null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(newInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
            } catch (IllegalAccessException unused) {
                declaredField.setAccessible(false);
                return mediaPlayer;
            } catch (Throwable th) {
                declaredField.setAccessible(false);
                throw th;
            }
        } catch (Exception unused2) {
        }
        return mediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PlayRunnable implements Runnable {
        private int mRawId;
        private boolean mlooping;

        private PlayRunnable() {
        }

        public void setRawId(int i) {
            this.mRawId = i;
        }

        public void setLooping(boolean z) {
            this.mlooping = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (SoundPlayer.this.mMediaPlayer != null) {
                    if (SoundPlayer.this.mMediaPlayer.isPlaying()) {
                        SoundPlayer.this.mMediaPlayer.stop();
                    }
                    SoundPlayer.this.mMediaPlayer.release();
                    SoundPlayer.this.mMediaPlayer = null;
                }
                SoundPlayer.this.mMediaPlayer = new MediaPlayer();
                SoundPlayer.this.mMediaPlayer.setAudioStreamType(7);
                SoundPlayer.this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.xiaopeng.autopilot.base.utils.SoundPlayer.PlayRunnable.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        SoundPlayer.this.mAudioManager.requestAudioFocus(SoundPlayer.this, 7, 3);
                    }
                });
                SoundPlayer.this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.xiaopeng.autopilot.base.utils.SoundPlayer.PlayRunnable.2
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        SoundPlayer.this.mAudioManager.abandonAudioFocus(SoundPlayer.this);
                    }
                });
                SoundPlayer.this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.xiaopeng.autopilot.base.utils.SoundPlayer.PlayRunnable.3
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        SoundPlayer.this.mAudioManager.abandonAudioFocus(SoundPlayer.this);
                        return true;
                    }
                });
                try {
                    AssetFileDescriptor openRawResourceFd = a.g().getResources().openRawResourceFd(this.mRawId);
                    SoundPlayer.this.mMediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                    MediaPlayerUtils.setVolume(SoundPlayer.this.mMediaPlayer, SoundPlayer.BEEP_VOLUME, SoundPlayer.BEEP_VOLUME);
                    SoundPlayer.this.mMediaPlayer.setLooping(this.mlooping);
                    SoundPlayer.this.mMediaPlayer.prepare();
                    openRawResourceFd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i("initSpecifiedSound", "what happened to init sound? you need to deal it .");
                }
                SoundPlayer.this.mMediaPlayer.start();
            }
        }
    }
}
