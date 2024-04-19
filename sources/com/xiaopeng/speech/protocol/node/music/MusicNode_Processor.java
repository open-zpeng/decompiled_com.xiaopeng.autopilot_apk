package com.xiaopeng.speech.protocol.node.music;

import com.xiaopeng.speech.annotation.ICommandProcessor;
/* loaded from: classes.dex */
public class MusicNode_Processor implements ICommandProcessor {
    private MusicNode a;

    public MusicNode_Processor(MusicNode musicNode) {
        this.a = musicNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public void a(String str, String str2) {
        char c;
        switch (str.hashCode()) {
            case -2013000544:
                if (str.equals("command://music.control.loop.all")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -2002174621:
                if (str.equals("command://music.speed.set")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case -1938308159:
                if (str.equals("command://music.speed.down")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case -1829687228:
                if (str.equals("native://music.playmode.support")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1728394409:
                if (str.equals("command://music.settime")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case -1627989588:
                if (str.equals("command://music.list.play")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1425904452:
                if (str.equals("command://music.control.next")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1425838851:
                if (str.equals("command://music.control.play")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1425832964:
                if (str.equals("command://music.control.prev")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1425741365:
                if (str.equals("command://music.control.stop")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1353272389:
                if (str.equals("command://music.backward")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case -1311512198:
                if (str.equals("command://music.speed.up")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case -1292964230:
                if (str.equals("command://music.control.sim.cancel")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -1251639987:
                if (str.equals("command://music.control.pause")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1236424121:
                if (str.equals("command://music.control.collect.cancel")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case -782232511:
                if (str.equals("command://music.control.playlist.history.play")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case -679814637:
                if (str.equals("command://music.dailyrec.play")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case -496865250:
                if (str.equals("command://music.soundeffect.stereo")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -447517996:
                if (str.equals("command://music.control.bluetooth.play.random")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -362899903:
                if (str.equals("command://music.control.collect.play")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -151956081:
                if (str.equals("command://music.soundeffect.vocal")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -102819689:
                if (str.equals("command://music.news.play")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case -96514067:
                if (str.equals("command://music.forward")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case -89098164:
                if (str.equals("command://music.control.random")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -85238858:
                if (str.equals("command://music.control.resume")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -28153286:
                if (str.equals("command://music.1212.novel.play")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 554746164:
                if (str.equals("native://music.search")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 899591924:
                if (str.equals("command://music.soundeffect.superbass")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1260718851:
                if (str.equals("command://music.audiobook.subscribe")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1313205723:
                if (str.equals("command://music.audiobook.play")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 1504460481:
                if (str.equals("command://music.control.collect")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1616575982:
                if (str.equals("command://music.control.sim")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 1657363090:
                if (str.equals("command://music.soundeffect.live")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1841863913:
                if (str.equals("command://music.control.loop.single")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1903252755:
                if (str.equals("command://music.control.play.usb")) {
                    c = '\"';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.a.onPlay(str, str2);
                return;
            case 1:
                this.a.onPlayLoopSingle(str, str2);
                return;
            case 2:
                this.a.onPlayLoopAll(str, str2);
                return;
            case 3:
                this.a.onPlayLoopRandom(str, str2);
                return;
            case 4:
                this.a.onSearch(str, str2);
                return;
            case 5:
                this.a.onPause(str, str2);
                return;
            case 6:
                this.a.onResume(str, str2);
                return;
            case 7:
                this.a.onPrev(str, str2);
                return;
            case '\b':
                this.a.onNext(str, str2);
                return;
            case '\t':
                this.a.onStop(str, str2);
                return;
            case '\n':
                this.a.onPlayBlueTooth(str, str2);
                return;
            case 11:
                this.a.onSupportPlayModeChange(str, str2);
                return;
            case '\f':
                this.a.onAudioBookPlay(str, str2);
                return;
            case '\r':
                this.a.onMusicListPlay(str, str2);
                return;
            case 14:
                this.a.onTwelveNovelPlay(str, str2);
                return;
            case 15:
                this.a.onControlCollect(str, str2);
                return;
            case 16:
                this.a.onAudioBookSubscribe(str, str2);
                return;
            case 17:
                this.a.onSoundEffectStereo(str, str2);
                return;
            case 18:
                this.a.onSoundEffectLive(str, str2);
                return;
            case 19:
                this.a.onSoundEffectVocal(str, str2);
                return;
            case 20:
                this.a.onSoundEffectSuperbass(str, str2);
                return;
            case 21:
                this.a.onDelCollect(str, str2);
                return;
            case 22:
                this.a.onPlayCollect(str, str2);
                return;
            case 23:
                this.a.onPlaySimilar(str, str2);
                return;
            case 24:
                this.a.onCancelPlaySimilar(str, str2);
                return;
            case 25:
                this.a.onPlayHistoryList(str, str2);
                return;
            case 26:
                this.a.onMusicForward(str, str2);
                return;
            case 27:
                this.a.onMusicBackward(str, str2);
                return;
            case 28:
                this.a.onMusicSettime(str, str2);
                return;
            case 29:
                this.a.onMusicSpeedUp(str, str2);
                return;
            case 30:
                this.a.onMusicSpeedDown(str, str2);
                return;
            case 31:
                this.a.onMusicSpeedSet(str, str2);
                return;
            case ' ':
                this.a.onMusicNewsPlay(str, str2);
                return;
            case '!':
                this.a.onMusicDailyrecPlay(str, str2);
                return;
            case '\"':
                this.a.onPlayUsb(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.speech.annotation.ICommandProcessor
    public String[] a() {
        return new String[]{"command://music.control.play", "command://music.control.loop.single", "command://music.control.loop.all", "command://music.control.random", "native://music.search", "command://music.control.pause", "command://music.control.resume", "command://music.control.prev", "command://music.control.next", "command://music.control.stop", "command://music.control.bluetooth.play.random", "native://music.playmode.support", "command://music.audiobook.play", "command://music.list.play", "command://music.1212.novel.play", "command://music.control.collect", "command://music.audiobook.subscribe", "command://music.soundeffect.stereo", "command://music.soundeffect.live", "command://music.soundeffect.vocal", "command://music.soundeffect.superbass", "command://music.control.collect.cancel", "command://music.control.collect.play", "command://music.control.sim", "command://music.control.sim.cancel", "command://music.control.playlist.history.play", "command://music.forward", "command://music.backward", "command://music.settime", "command://music.speed.up", "command://music.speed.down", "command://music.speed.set", "command://music.news.play", "command://music.dailyrec.play", "command://music.control.play.usb"};
    }
}
