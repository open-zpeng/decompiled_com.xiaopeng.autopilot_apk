package com.badlogic.gdx.backends.android;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.badlogic.gdx.backends.android.ZipResourceFile;
import com.badlogic.gdx.utils.k;
import defpackage.in;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class AndroidZipFileHandle extends AndroidFileHandle {
    private AssetFileDescriptor assetFd;
    private ZipResourceFile expansionFile;
    private String path;

    public AndroidZipFileHandle(String str) {
        super((AssetManager) null, str, in.a.Internal);
        initialize();
    }

    public AndroidZipFileHandle(File file, in.a aVar) {
        super((AssetManager) null, file, aVar);
        initialize();
    }

    private void initialize() {
        this.path = this.file.getPath().replace('\\', '/');
        this.expansionFile = ((AndroidFiles) io.e).getExpansionFile();
        this.assetFd = this.expansionFile.getAssetFileDescriptor(getPath());
        if (isDirectory()) {
            this.path += "/";
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle
    public AssetFileDescriptor getAssetFileDescriptor() throws IOException {
        return this.assetFd;
    }

    private String getPath() {
        return this.path;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public InputStream read() {
        try {
            return this.expansionFile.getInputStream(getPath());
        } catch (IOException e) {
            throw new k("Error reading file: " + this.file + " (ZipResourceFile)", e);
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public jy child(String str) {
        if (this.file.getPath().length() == 0) {
            return new AndroidZipFileHandle(new File(str), this.type);
        }
        return new AndroidZipFileHandle(new File(this.file, str), this.type);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public jy sibling(String str) {
        if (this.file.getPath().length() == 0) {
            throw new k("Cannot get the sibling of the root.");
        }
        return io.e.getFileHandle(new File(this.file.getParent(), str).getPath(), this.type);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public jy parent() {
        File parentFile = this.file.getParentFile();
        if (parentFile == null) {
            parentFile = new File("");
        }
        return new AndroidZipFileHandle(parentFile.getPath());
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public jy[] list() {
        ZipResourceFile.ZipEntryRO[] entriesAt = this.expansionFile.getEntriesAt(getPath());
        jy[] jyVarArr = new jy[entriesAt.length];
        int length = jyVarArr.length;
        for (int i = 0; i < length; i++) {
            jyVarArr[i] = new AndroidZipFileHandle(entriesAt[i].mFileName);
        }
        return jyVarArr;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public jy[] list(FileFilter fileFilter) {
        ZipResourceFile.ZipEntryRO[] entriesAt = this.expansionFile.getEntriesAt(getPath());
        jy[] jyVarArr = new jy[entriesAt.length];
        int length = jyVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            AndroidZipFileHandle androidZipFileHandle = new AndroidZipFileHandle(entriesAt[i2].mFileName);
            if (fileFilter.accept(androidZipFileHandle.file())) {
                jyVarArr[i] = androidZipFileHandle;
                i++;
            }
        }
        if (i < entriesAt.length) {
            jy[] jyVarArr2 = new jy[i];
            System.arraycopy(jyVarArr, 0, jyVarArr2, 0, i);
            return jyVarArr2;
        }
        return jyVarArr;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public jy[] list(FilenameFilter filenameFilter) {
        ZipResourceFile.ZipEntryRO[] entriesAt = this.expansionFile.getEntriesAt(getPath());
        jy[] jyVarArr = new jy[entriesAt.length];
        int length = jyVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            String str = entriesAt[i2].mFileName;
            if (filenameFilter.accept(this.file, str)) {
                jyVarArr[i] = new AndroidZipFileHandle(str);
                i++;
            }
        }
        if (i < entriesAt.length) {
            jy[] jyVarArr2 = new jy[i];
            System.arraycopy(jyVarArr, 0, jyVarArr2, 0, i);
            return jyVarArr2;
        }
        return jyVarArr;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public jy[] list(String str) {
        ZipResourceFile.ZipEntryRO[] entriesAt = this.expansionFile.getEntriesAt(getPath());
        jy[] jyVarArr = new jy[entriesAt.length];
        int length = jyVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            String str2 = entriesAt[i2].mFileName;
            if (str2.endsWith(str)) {
                jyVarArr[i] = new AndroidZipFileHandle(str2);
                i++;
            }
        }
        if (i < entriesAt.length) {
            jy[] jyVarArr2 = new jy[i];
            System.arraycopy(jyVarArr, 0, jyVarArr2, 0, i);
            return jyVarArr2;
        }
        return jyVarArr;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public boolean isDirectory() {
        return this.assetFd == null;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public long length() {
        AssetFileDescriptor assetFileDescriptor = this.assetFd;
        if (assetFileDescriptor != null) {
            return assetFileDescriptor.getLength();
        }
        return 0L;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidFileHandle, defpackage.jy
    public boolean exists() {
        return (this.assetFd == null && this.expansionFile.getEntriesAt(getPath()).length == 0) ? false : true;
    }
}
