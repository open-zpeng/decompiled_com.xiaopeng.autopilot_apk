package com.badlogic.gdx.backends.android;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.badlogic.gdx.utils.ak;
import com.badlogic.gdx.utils.k;
import defpackage.in;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/* loaded from: classes.dex */
public class AndroidFileHandle extends jy {
    private final AssetManager assets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidFileHandle(AssetManager assetManager, String str, in.a aVar) {
        super(str.replace('\\', '/'), aVar);
        this.assets = assetManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidFileHandle(AssetManager assetManager, File file, in.a aVar) {
        super(file, aVar);
        this.assets = assetManager;
    }

    @Override // defpackage.jy
    public jy child(String str) {
        String replace = str.replace('\\', '/');
        return this.file.getPath().length() == 0 ? new AndroidFileHandle(this.assets, new File(replace), this.type) : new AndroidFileHandle(this.assets, new File(this.file, replace), this.type);
    }

    @Override // defpackage.jy
    public jy sibling(String str) {
        String replace = str.replace('\\', '/');
        if (this.file.getPath().length() == 0) {
            throw new k("Cannot get the sibling of the root.");
        }
        return io.e.getFileHandle(new File(this.file.getParent(), replace).getPath(), this.type);
    }

    @Override // defpackage.jy
    public jy parent() {
        File parentFile = this.file.getParentFile();
        if (parentFile == null) {
            if (this.type == in.a.Absolute) {
                parentFile = new File("/");
            } else {
                parentFile = new File("");
            }
        }
        return new AndroidFileHandle(this.assets, parentFile, this.type);
    }

    @Override // defpackage.jy
    public InputStream read() {
        if (this.type == in.a.Internal) {
            try {
                return this.assets.open(this.file.getPath());
            } catch (IOException e) {
                throw new k("Error reading file: " + this.file + " (" + this.type + ")", e);
            }
        }
        return super.read();
    }

    @Override // defpackage.jy
    public ByteBuffer map(FileChannel.MapMode mapMode) {
        long startOffset;
        long declaredLength;
        FileInputStream fileInputStream;
        if (this.type == in.a.Internal) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor();
                    startOffset = assetFileDescriptor.getStartOffset();
                    declaredLength = assetFileDescriptor.getDeclaredLength();
                    fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                MappedByteBuffer map = fileInputStream.getChannel().map(mapMode, startOffset, declaredLength);
                map.order(ByteOrder.nativeOrder());
                ak.a(fileInputStream);
                return map;
            } catch (Exception e2) {
                e = e2;
                throw new k("Error memory mapping file: " + this + " (" + this.type + ")", e);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                ak.a(fileInputStream2);
                throw th;
            }
        }
        return super.map(mapMode);
    }

    @Override // defpackage.jy
    public jy[] list() {
        if (this.type == in.a.Internal) {
            try {
                String[] list = this.assets.list(this.file.getPath());
                jy[] jyVarArr = new jy[list.length];
                int length = jyVarArr.length;
                for (int i = 0; i < length; i++) {
                    jyVarArr[i] = new AndroidFileHandle(this.assets, new File(this.file, list[i]), this.type);
                }
                return jyVarArr;
            } catch (Exception e) {
                throw new k("Error listing children: " + this.file + " (" + this.type + ")", e);
            }
        }
        return super.list();
    }

    @Override // defpackage.jy
    public jy[] list(FileFilter fileFilter) {
        if (this.type == in.a.Internal) {
            try {
                String[] list = this.assets.list(this.file.getPath());
                jy[] jyVarArr = new jy[list.length];
                int length = jyVarArr.length;
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    AndroidFileHandle androidFileHandle = new AndroidFileHandle(this.assets, new File(this.file, list[i2]), this.type);
                    if (fileFilter.accept(androidFileHandle.file())) {
                        jyVarArr[i] = androidFileHandle;
                        i++;
                    }
                }
                if (i < list.length) {
                    jy[] jyVarArr2 = new jy[i];
                    System.arraycopy(jyVarArr, 0, jyVarArr2, 0, i);
                    return jyVarArr2;
                }
                return jyVarArr;
            } catch (Exception e) {
                throw new k("Error listing children: " + this.file + " (" + this.type + ")", e);
            }
        }
        return super.list(fileFilter);
    }

    @Override // defpackage.jy
    public jy[] list(FilenameFilter filenameFilter) {
        if (this.type == in.a.Internal) {
            try {
                String[] list = this.assets.list(this.file.getPath());
                jy[] jyVarArr = new jy[list.length];
                int length = jyVarArr.length;
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    String str = list[i2];
                    if (filenameFilter.accept(this.file, str)) {
                        jyVarArr[i] = new AndroidFileHandle(this.assets, new File(this.file, str), this.type);
                        i++;
                    }
                }
                if (i < list.length) {
                    jy[] jyVarArr2 = new jy[i];
                    System.arraycopy(jyVarArr, 0, jyVarArr2, 0, i);
                    return jyVarArr2;
                }
                return jyVarArr;
            } catch (Exception e) {
                throw new k("Error listing children: " + this.file + " (" + this.type + ")", e);
            }
        }
        return super.list(filenameFilter);
    }

    @Override // defpackage.jy
    public jy[] list(String str) {
        if (this.type == in.a.Internal) {
            try {
                String[] list = this.assets.list(this.file.getPath());
                jy[] jyVarArr = new jy[list.length];
                int length = jyVarArr.length;
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    String str2 = list[i2];
                    if (str2.endsWith(str)) {
                        jyVarArr[i] = new AndroidFileHandle(this.assets, new File(this.file, str2), this.type);
                        i++;
                    }
                }
                if (i < list.length) {
                    jy[] jyVarArr2 = new jy[i];
                    System.arraycopy(jyVarArr, 0, jyVarArr2, 0, i);
                    return jyVarArr2;
                }
                return jyVarArr;
            } catch (Exception e) {
                throw new k("Error listing children: " + this.file + " (" + this.type + ")", e);
            }
        }
        return super.list(str);
    }

    @Override // defpackage.jy
    public boolean isDirectory() {
        if (this.type == in.a.Internal) {
            try {
                return this.assets.list(this.file.getPath()).length > 0;
            } catch (IOException unused) {
                return false;
            }
        }
        return super.isDirectory();
    }

    @Override // defpackage.jy
    public boolean exists() {
        if (this.type == in.a.Internal) {
            String path = this.file.getPath();
            try {
                this.assets.open(path).close();
                return true;
            } catch (Exception unused) {
                try {
                    return this.assets.list(path).length > 0;
                } catch (Exception unused2) {
                    return false;
                }
            }
        }
        return super.exists();
    }

    @Override // defpackage.jy
    public long length() {
        if (this.type == in.a.Internal) {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                assetFileDescriptor = this.assets.openFd(this.file.getPath());
                long length = assetFileDescriptor.getLength();
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException unused) {
                    }
                }
                return length;
            } catch (IOException unused2) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        return super.length();
    }

    @Override // defpackage.jy
    public long lastModified() {
        return super.lastModified();
    }

    @Override // defpackage.jy
    public File file() {
        return this.type == in.a.Local ? new File(io.e.getLocalStoragePath(), this.file.getPath()) : super.file();
    }

    public AssetFileDescriptor getAssetFileDescriptor() throws IOException {
        AssetManager assetManager = this.assets;
        if (assetManager != null) {
            return assetManager.openFd(path());
        }
        return null;
    }
}
