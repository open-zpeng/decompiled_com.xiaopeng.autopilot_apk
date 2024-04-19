package com.xiaopeng.autopilot.base.utils;

import android.media.MediaPlayer;
import com.xiaopeng.autopilot.base.h;
/* loaded from: classes.dex */
public class MediaPlayerUtils {
    public static void setVolume(MediaPlayer mediaPlayer, float f, float f2) {
        mediaPlayer.setVolume(f, f2);
    }

    public static void playSelectParklot(SoundPlayer soundPlayer) {
        soundPlayer.play(h.C0050h.sound_select_parklot);
    }
}
