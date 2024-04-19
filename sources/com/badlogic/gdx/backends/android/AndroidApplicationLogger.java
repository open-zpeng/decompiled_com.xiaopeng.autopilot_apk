package com.badlogic.gdx.backends.android;

import android.util.Log;
/* loaded from: classes.dex */
public class AndroidApplicationLogger implements il {
    @Override // defpackage.il
    public void log(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // defpackage.il
    public void log(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    @Override // defpackage.il
    public void error(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // defpackage.il
    public void error(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    @Override // defpackage.il
    public void debug(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // defpackage.il
    public void debug(String str, String str2, Throwable th) {
        Log.d(str, str2, th);
    }
}
