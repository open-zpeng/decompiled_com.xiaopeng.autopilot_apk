package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import com.badlogic.gdx.utils.k;
import defpackage.in;
import java.io.IOException;
/* loaded from: classes.dex */
public class AndroidFiles implements in {
    protected final AssetManager assets;
    private ZipResourceFile expansionFile;
    protected final String localpath;
    protected final String sdcard;

    public boolean isLocalStorageAvailable() {
        return true;
    }

    public AndroidFiles(AssetManager assetManager) {
        this.sdcard = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        this.expansionFile = null;
        this.assets = assetManager;
        this.localpath = this.sdcard;
    }

    public AndroidFiles(AssetManager assetManager, String str) {
        this.sdcard = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        this.expansionFile = null;
        this.assets = assetManager;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        this.localpath = str;
    }

    @Override // defpackage.in
    public jy getFileHandle(String str, in.a aVar) {
        AndroidFileHandle androidFileHandle = new AndroidFileHandle(aVar == in.a.Internal ? this.assets : null, str, aVar);
        return (this.expansionFile == null || aVar != in.a.Internal) ? androidFileHandle : getZipFileHandleIfExists(androidFileHandle, str);
    }

    private jy getZipFileHandleIfExists(jy jyVar, String str) {
        try {
            this.assets.open(str).close();
            return jyVar;
        } catch (Exception unused) {
            AndroidZipFileHandle androidZipFileHandle = new AndroidZipFileHandle(str);
            return (androidZipFileHandle.isDirectory() && !androidZipFileHandle.exists()) ? jyVar : androidZipFileHandle;
        }
    }

    @Override // defpackage.in
    public jy classpath(String str) {
        return new AndroidFileHandle((AssetManager) null, str, in.a.Classpath);
    }

    @Override // defpackage.in
    public jy internal(String str) {
        AndroidFileHandle androidFileHandle = new AndroidFileHandle(this.assets, str, in.a.Internal);
        return this.expansionFile != null ? getZipFileHandleIfExists(androidFileHandle, str) : androidFileHandle;
    }

    public jy external(String str) {
        return new AndroidFileHandle((AssetManager) null, str, in.a.External);
    }

    public jy absolute(String str) {
        return new AndroidFileHandle((AssetManager) null, str, in.a.Absolute);
    }

    public jy local(String str) {
        return new AndroidFileHandle((AssetManager) null, str, in.a.Local);
    }

    @Override // defpackage.in
    public String getExternalStoragePath() {
        return this.sdcard;
    }

    public boolean isExternalStorageAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    @Override // defpackage.in
    public String getLocalStoragePath() {
        return this.localpath;
    }

    public boolean setAPKExpansion(int i, int i2) {
        Context baseContext;
        try {
            if (io.a instanceof Activity) {
                baseContext = ((Activity) io.a).getBaseContext();
            } else if (io.a instanceof Fragment) {
                baseContext = ((Fragment) io.a).getActivity().getBaseContext();
            } else {
                throw new k("APK expansion not supported for application type");
            }
            this.expansionFile = APKExpansionSupport.getAPKExpansionZipFile(baseContext, i, i2);
            return this.expansionFile != null;
        } catch (IOException unused) {
            throw new k("APK expansion main version " + i + " or patch version " + i2 + " couldn't be opened!");
        }
    }

    public ZipResourceFile getExpansionFile() {
        return this.expansionFile;
    }
}
