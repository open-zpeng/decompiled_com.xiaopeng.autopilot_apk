package com.xiaopeng.xui.sound;

import android.media.AudioManager;
import com.xiaopeng.xui.Xui;
import com.xiaopeng.xui.utils.XLogUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class XSoundEffectManager {
    private static final String TAG = "xpui-XSoundManager";
    private ExecutorService mExecutorService;
    private boolean mIsDestroy;
    private ConcurrentHashMap<Integer, XSoundEffect> mPoolHashMap;
    private ConcurrentHashMap<Integer, Boolean> mReleaseMap;

    private int useAudioManager(int i) {
        switch (i) {
            case 2:
                return 17;
            case 3:
                return 16;
            case 4:
                return 15;
            case 5:
                return 14;
            default:
                return -1;
        }
    }

    /* loaded from: classes.dex */
    private static class SingletonHolder {
        private static final XSoundEffectManager INSTANCE = new XSoundEffectManager();

        private SingletonHolder() {
        }
    }

    private XSoundEffectManager() {
        this.mPoolHashMap = new ConcurrentHashMap<>();
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.mReleaseMap = new ConcurrentHashMap<>();
    }

    public static XSoundEffectManager get() {
        return SingletonHolder.INSTANCE;
    }

    public synchronized void play(int i) {
        int useAudioManager = useAudioManager(i);
        if (useAudioManager > 0) {
            XAudioManager.get().playSoundEffect(useAudioManager);
        } else {
            playLocal(i);
        }
    }

    private void playLocal(final int i) {
        this.mIsDestroy = false;
        this.mReleaseMap.put(Integer.valueOf(i), false);
        this.mExecutorService.execute(new Runnable() { // from class: com.xiaopeng.xui.sound.-$$Lambda$XSoundEffectManager$bCpQWhKM74bwPueztuwQSwNsLTs
            @Override // java.lang.Runnable
            public final void run() {
                XSoundEffectManager.lambda$playLocal$0(XSoundEffectManager.this, i);
            }
        });
    }

    public static /* synthetic */ void lambda$playLocal$0(XSoundEffectManager xSoundEffectManager, int i) {
        if (xSoundEffectManager.mIsDestroy) {
            xSoundEffectManager.log(String.format("play-not for destroy resource:%s", Integer.valueOf(i)));
            return;
        }
        Boolean bool = xSoundEffectManager.mReleaseMap.get(Integer.valueOf(i));
        if (bool != null && bool.booleanValue()) {
            xSoundEffectManager.log(String.format("play-not for release resource:%s", Integer.valueOf(i)));
            return;
        }
        System.currentTimeMillis();
        XSoundEffect xSoundEffect = xSoundEffectManager.mPoolHashMap.get(Integer.valueOf(i));
        if (xSoundEffect == null) {
            xSoundEffect = SoundEffectFactory.create(i);
            xSoundEffectManager.mPoolHashMap.put(Integer.valueOf(i), xSoundEffect);
        }
        xSoundEffect.play();
    }

    public synchronized void release(final int i) {
        this.mReleaseMap.put(Integer.valueOf(i), true);
        this.mExecutorService.execute(new Runnable() { // from class: com.xiaopeng.xui.sound.-$$Lambda$XSoundEffectManager$wIXGXmGDQzq-cwWNmTR5CyWKfoQ
            @Override // java.lang.Runnable
            public final void run() {
                XSoundEffectManager.lambda$release$1(XSoundEffectManager.this, i);
            }
        });
    }

    public static /* synthetic */ void lambda$release$1(XSoundEffectManager xSoundEffectManager, int i) {
        XSoundEffect xSoundEffect = xSoundEffectManager.mPoolHashMap.get(Integer.valueOf(i));
        if (xSoundEffect != null) {
            xSoundEffect.release();
        }
        xSoundEffectManager.log(String.format("release resource:%s", Integer.valueOf(i)));
    }

    public synchronized void destroy() {
        this.mIsDestroy = true;
        this.mExecutorService.execute(new Runnable() { // from class: com.xiaopeng.xui.sound.-$$Lambda$XSoundEffectManager$gAnWfvgV_N-93OUZ2dykrfal-MM
            @Override // java.lang.Runnable
            public final void run() {
                XSoundEffectManager.lambda$destroy$2(XSoundEffectManager.this);
            }
        });
    }

    public static /* synthetic */ void lambda$destroy$2(XSoundEffectManager xSoundEffectManager) {
        long currentTimeMillis = System.currentTimeMillis();
        for (XSoundEffect xSoundEffect : xSoundEffectManager.mPoolHashMap.values()) {
            if (xSoundEffect != null) {
                xSoundEffect.release();
            }
        }
        xSoundEffectManager.mPoolHashMap.clear();
        xSoundEffectManager.mReleaseMap.clear();
        xSoundEffectManager.log("destroy time : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public synchronized void resetResource(int i, String str, int i2) {
        resetResource(i, str, i2, 5);
    }

    public synchronized void resetResource(final int i, final String str, final int i2, final int i3) {
        this.mExecutorService.execute(new Runnable() { // from class: com.xiaopeng.xui.sound.-$$Lambda$XSoundEffectManager$zBcAqtI6-Ez0rykCABVb4QC0jtQ
            @Override // java.lang.Runnable
            public final void run() {
                XSoundEffectManager.lambda$resetResource$3(XSoundEffectManager.this, i, str, i2, i3);
            }
        });
    }

    public static /* synthetic */ void lambda$resetResource$3(XSoundEffectManager xSoundEffectManager, int i, String str, int i2, int i3) {
        SoundEffectFactory.resetResource(i, str, i2, i3);
        XSoundEffect xSoundEffect = xSoundEffectManager.mPoolHashMap.get(Integer.valueOf(i));
        if (xSoundEffect != null) {
            xSoundEffect.release();
            xSoundEffectManager.mPoolHashMap.remove(Integer.valueOf(i));
        }
        xSoundEffectManager.log(String.format("resetResource--resource:%s,path:%s,location:%s,streamType:%s", Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    public synchronized void restoreResource(final int i) {
        this.mExecutorService.execute(new Runnable() { // from class: com.xiaopeng.xui.sound.-$$Lambda$XSoundEffectManager$xVTBBr68UkEjCh3o-q9_G_PQBcY
            @Override // java.lang.Runnable
            public final void run() {
                XSoundEffectManager.lambda$restoreResource$4(XSoundEffectManager.this, i);
            }
        });
    }

    public static /* synthetic */ void lambda$restoreResource$4(XSoundEffectManager xSoundEffectManager, int i) {
        SoundEffectFactory.restoreResource(i);
        XSoundEffect xSoundEffect = xSoundEffectManager.mPoolHashMap.get(Integer.valueOf(i));
        if (xSoundEffect != null) {
            xSoundEffect.release();
            xSoundEffectManager.mPoolHashMap.remove(Integer.valueOf(i));
        }
        xSoundEffectManager.log(String.format("restoreResource resource:%s", Integer.valueOf(i)));
    }

    private void log(String str) {
        XLogUtils.d(TAG, str);
    }

    /* loaded from: classes.dex */
    public static class XAudioManager {
        public static final int FX_DEL = 14;
        public static final int FX_SWITCH_OFF = 15;
        public static final int FX_SWITCH_ON = 16;
        public static final int FX_WHEEL_SCROLL = 17;
        private AudioManager mAudioManager;

        private XAudioManager() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class SingletonHolder {
            private static final XAudioManager INSTANCE = new XAudioManager();

            private SingletonHolder() {
            }
        }

        public static XAudioManager get() {
            return SingletonHolder.INSTANCE;
        }

        private AudioManager getAudioManager() {
            if (this.mAudioManager == null) {
                this.mAudioManager = (AudioManager) Xui.getContext().getSystemService("audio");
            }
            return this.mAudioManager;
        }

        public void playSoundEffect(int i) {
            getAudioManager().playSoundEffect(i);
        }
    }
}
