package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Keep;
import java.util.HashMap;
@Keep
/* loaded from: classes.dex */
public class ManifestHelper {
    public static HashMap<String, Pair<IBinder, String>> mapping = new HashMap<>();

    static {
        Pair<IBinder, String> pair = new Pair<>(new ParkingSpeechObserver_Stub(), ParkingSpeechObserver_Manifest.toJsonManifest());
        for (String str : ParkingSpeechObserver_Manifest.getKey()) {
            mapping.put(str, pair);
        }
    }
}
