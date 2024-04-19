package com.xiaopeng.xui.watchers;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class XWatcherGroup implements XWatcher {
    private final List<XWatcher> mWatchers = new ArrayList();

    public XWatcherGroup(XWatcher... xWatcherArr) {
        this.mWatchers.addAll(Arrays.asList(xWatcherArr));
    }

    @Override // com.xiaopeng.xui.watchers.XWatcher
    public void onCreate(Activity activity, Bundle bundle) {
        for (XWatcher xWatcher : this.mWatchers) {
            xWatcher.onCreate(activity, bundle);
        }
    }

    @Override // com.xiaopeng.xui.watchers.XWatcher
    public void onResume() {
        for (XWatcher xWatcher : this.mWatchers) {
            xWatcher.onResume();
        }
    }

    @Override // com.xiaopeng.xui.watchers.XWatcher
    public void onPause() {
        for (XWatcher xWatcher : this.mWatchers) {
            xWatcher.onPause();
        }
    }

    @Override // com.xiaopeng.xui.watchers.XWatcher
    public void onDestroy() {
        for (XWatcher xWatcher : this.mWatchers) {
            xWatcher.onDestroy();
        }
    }
}
