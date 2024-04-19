package defpackage;

import com.badlogic.gdx.utils.ak;
import com.badlogic.gdx.utils.k;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import defpackage.in;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/* compiled from: FileHandle.java */
/* renamed from: jy  reason: default package */
/* loaded from: classes.dex */
public class jy {
    protected File file;
    protected in.a type;

    protected jy() {
    }

    public jy(String str) {
        this.file = new File(str);
        this.type = in.a.Absolute;
    }

    public jy(File file) {
        this.file = file;
        this.type = in.a.Absolute;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public jy(String str, in.a aVar) {
        this.type = aVar;
        this.file = new File(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public jy(File file, in.a aVar) {
        this.file = file;
        this.type = aVar;
    }

    public String path() {
        return this.file.getPath().replace('\\', '/');
    }

    public String name() {
        return this.file.getName();
    }

    public String extension() {
        String name = this.file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
    }

    public String nameWithoutExtension() {
        String name = this.file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }

    public String pathWithoutExtension() {
        String replace = this.file.getPath().replace('\\', '/');
        int lastIndexOf = replace.lastIndexOf(46);
        return lastIndexOf == -1 ? replace : replace.substring(0, lastIndexOf);
    }

    public in.a type() {
        return this.type;
    }

    public File file() {
        return this.type == in.a.External ? new File(io.e.getExternalStoragePath(), this.file.getPath()) : this.file;
    }

    public InputStream read() {
        if (this.type == in.a.Classpath || ((this.type == in.a.Internal && !file().exists()) || (this.type == in.a.Local && !file().exists()))) {
            InputStream resourceAsStream = jy.class.getResourceAsStream("/" + this.file.getPath().replace('\\', '/'));
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            throw new k("File not found: " + this.file + " (" + this.type + ")");
        }
        try {
            return new FileInputStream(file());
        } catch (Exception e) {
            if (file().isDirectory()) {
                throw new k("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", e);
            }
            throw new k("Error reading file: " + this.file + " (" + this.type + ")", e);
        }
    }

    public BufferedInputStream read(int i) {
        return new BufferedInputStream(read(), i);
    }

    public Reader reader() {
        return new InputStreamReader(read());
    }

    public Reader reader(String str) {
        InputStream read = read();
        try {
            return new InputStreamReader(read, str);
        } catch (UnsupportedEncodingException e) {
            ak.a(read);
            throw new k("Error reading file: " + this, e);
        }
    }

    public BufferedReader reader(int i) {
        return new BufferedReader(new InputStreamReader(read()), i);
    }

    public BufferedReader reader(int i, String str) {
        try {
            return new BufferedReader(new InputStreamReader(read(), str), i);
        } catch (UnsupportedEncodingException e) {
            throw new k("Error reading file: " + this, e);
        }
    }

    public String readString() {
        return readString(null);
    }

    public String readString(String str) {
        StringBuilder sb = new StringBuilder(estimateLength());
        InputStreamReader inputStreamReader = null;
        try {
            try {
                if (str == null) {
                    inputStreamReader = new InputStreamReader(read());
                } else {
                    inputStreamReader = new InputStreamReader(read(), str);
                }
                char[] cArr = new char[IRadioController.TEF663x_PCHANNEL];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                    } else {
                        ak.a(inputStreamReader);
                        return sb.toString();
                    }
                }
            } catch (IOException e) {
                throw new k("Error reading layout file: " + this, e);
            }
        } catch (Throwable th) {
            ak.a(inputStreamReader);
            throw th;
        }
    }

    public byte[] readBytes() {
        InputStream read = read();
        try {
            try {
                return ak.a(read, estimateLength());
            } catch (IOException e) {
                throw new k("Error reading file: " + this, e);
            }
        } finally {
            ak.a(read);
        }
    }

    private int estimateLength() {
        int length = (int) length();
        return length != 0 ? length : IInputController.KEYCODE_BACK_BUTTON;
    }

    public int readBytes(byte[] bArr, int i, int i2) {
        InputStream read = read();
        int i3 = 0;
        while (true) {
            try {
                try {
                    int read2 = read.read(bArr, i + i3, i2 - i3);
                    if (read2 <= 0) {
                        ak.a(read);
                        return i3 - i;
                    }
                    i3 += read2;
                } catch (IOException e) {
                    throw new k("Error reading file: " + this, e);
                }
            } catch (Throwable th) {
                ak.a(read);
                throw th;
            }
        }
    }

    public ByteBuffer map() {
        return map(FileChannel.MapMode.READ_ONLY);
    }

    public ByteBuffer map(FileChannel.MapMode mapMode) {
        RandomAccessFile randomAccessFile;
        if (this.type == in.a.Classpath) {
            throw new k("Cannot map a classpath file: " + this);
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(this.file, mapMode == FileChannel.MapMode.READ_ONLY ? "r" : "rw");
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            MappedByteBuffer map = randomAccessFile.getChannel().map(mapMode, 0L, this.file.length());
            map.order(ByteOrder.nativeOrder());
            ak.a(randomAccessFile);
            return map;
        } catch (Exception e2) {
            e = e2;
            randomAccessFile2 = randomAccessFile;
            throw new k("Error memory mapping file: " + this + " (" + this.type + ")", e);
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            ak.a(randomAccessFile2);
            throw th;
        }
    }

    public OutputStream write(boolean z) {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot write to a classpath file: " + this.file);
        } else if (this.type == in.a.Internal) {
            throw new k("Cannot write to an internal file: " + this.file);
        } else {
            parent().mkdirs();
            try {
                return new FileOutputStream(file(), z);
            } catch (Exception e) {
                if (file().isDirectory()) {
                    throw new k("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", e);
                }
                throw new k("Error writing file: " + this.file + " (" + this.type + ")", e);
            }
        }
    }

    public OutputStream write(boolean z, int i) {
        return new BufferedOutputStream(write(z), i);
    }

    public void write(InputStream inputStream, boolean z) {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = write(z);
                ak.a(inputStream, outputStream);
            } catch (Exception e) {
                throw new k("Error stream writing to file: " + this.file + " (" + this.type + ")", e);
            }
        } finally {
            ak.a(inputStream);
            ak.a(outputStream);
        }
    }

    public Writer writer(boolean z) {
        return writer(z, null);
    }

    public Writer writer(boolean z, String str) {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot write to a classpath file: " + this.file);
        } else if (this.type == in.a.Internal) {
            throw new k("Cannot write to an internal file: " + this.file);
        } else {
            parent().mkdirs();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file(), z);
                if (str == null) {
                    return new OutputStreamWriter(fileOutputStream);
                }
                return new OutputStreamWriter(fileOutputStream, str);
            } catch (IOException e) {
                if (file().isDirectory()) {
                    throw new k("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", e);
                }
                throw new k("Error writing file: " + this.file + " (" + this.type + ")", e);
            }
        }
    }

    public void writeString(String str, boolean z) {
        writeString(str, z, null);
    }

    public void writeString(String str, boolean z, String str2) {
        Writer writer = null;
        try {
            try {
                writer = writer(z, str2);
                writer.write(str);
            } catch (Exception e) {
                throw new k("Error writing file: " + this.file + " (" + this.type + ")", e);
            }
        } finally {
            ak.a(writer);
        }
    }

    public void writeBytes(byte[] bArr, boolean z) {
        OutputStream write = write(z);
        try {
            try {
                write.write(bArr);
            } catch (IOException e) {
                throw new k("Error writing file: " + this.file + " (" + this.type + ")", e);
            }
        } finally {
            ak.a(write);
        }
    }

    public void writeBytes(byte[] bArr, int i, int i2, boolean z) {
        OutputStream write = write(z);
        try {
            try {
                write.write(bArr, i, i2);
            } catch (IOException e) {
                throw new k("Error writing file: " + this.file + " (" + this.type + ")", e);
            }
        } finally {
            ak.a(write);
        }
    }

    public jy[] list() {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot list a classpath directory: " + this.file);
        }
        String[] list = file().list();
        if (list == null) {
            return new jy[0];
        }
        jy[] jyVarArr = new jy[list.length];
        int length = list.length;
        for (int i = 0; i < length; i++) {
            jyVarArr[i] = child(list[i]);
        }
        return jyVarArr;
    }

    public jy[] list(FileFilter fileFilter) {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot list a classpath directory: " + this.file);
        }
        String[] list = file().list();
        if (list == null) {
            return new jy[0];
        }
        jy[] jyVarArr = new jy[list.length];
        int i = 0;
        for (String str : list) {
            jy child = child(str);
            if (fileFilter.accept(child.file())) {
                jyVarArr[i] = child;
                i++;
            }
        }
        if (i < list.length) {
            jy[] jyVarArr2 = new jy[i];
            System.arraycopy(jyVarArr, 0, jyVarArr2, 0, i);
            return jyVarArr2;
        }
        return jyVarArr;
    }

    public jy[] list(FilenameFilter filenameFilter) {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot list a classpath directory: " + this.file);
        }
        File file = file();
        String[] list = file.list();
        if (list == null) {
            return new jy[0];
        }
        jy[] jyVarArr = new jy[list.length];
        int i = 0;
        for (String str : list) {
            if (filenameFilter.accept(file, str)) {
                jyVarArr[i] = child(str);
                i++;
            }
        }
        if (i < list.length) {
            jy[] jyVarArr2 = new jy[i];
            System.arraycopy(jyVarArr, 0, jyVarArr2, 0, i);
            return jyVarArr2;
        }
        return jyVarArr;
    }

    public jy[] list(String str) {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot list a classpath directory: " + this.file);
        }
        String[] list = file().list();
        if (list == null) {
            return new jy[0];
        }
        jy[] jyVarArr = new jy[list.length];
        int i = 0;
        for (String str2 : list) {
            if (str2.endsWith(str)) {
                jyVarArr[i] = child(str2);
                i++;
            }
        }
        if (i < list.length) {
            jy[] jyVarArr2 = new jy[i];
            System.arraycopy(jyVarArr, 0, jyVarArr2, 0, i);
            return jyVarArr2;
        }
        return jyVarArr;
    }

    public boolean isDirectory() {
        if (this.type == in.a.Classpath) {
            return false;
        }
        return file().isDirectory();
    }

    public jy child(String str) {
        return this.file.getPath().length() == 0 ? new jy(new File(str), this.type) : new jy(new File(this.file, str), this.type);
    }

    public jy sibling(String str) {
        if (this.file.getPath().length() == 0) {
            throw new k("Cannot get the sibling of the root.");
        }
        return new jy(new File(this.file.getParent(), str), this.type);
    }

    public jy parent() {
        File parentFile = this.file.getParentFile();
        if (parentFile == null) {
            if (this.type == in.a.Absolute) {
                parentFile = new File("/");
            } else {
                parentFile = new File("");
            }
        }
        return new jy(parentFile, this.type);
    }

    public void mkdirs() {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot mkdirs with a classpath file: " + this.file);
        } else if (this.type == in.a.Internal) {
            throw new k("Cannot mkdirs with an internal file: " + this.file);
        } else {
            file().mkdirs();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean exists() {
        switch (this.type) {
            case Internal:
                if (file().exists()) {
                    return true;
                }
                break;
            case Classpath:
                break;
            default:
                return file().exists();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(this.file.getPath().replace('\\', '/'));
        return jy.class.getResource(sb.toString()) != null;
    }

    public boolean delete() {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot delete a classpath file: " + this.file);
        } else if (this.type == in.a.Internal) {
            throw new k("Cannot delete an internal file: " + this.file);
        } else {
            return file().delete();
        }
    }

    public boolean deleteDirectory() {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot delete a classpath file: " + this.file);
        } else if (this.type == in.a.Internal) {
            throw new k("Cannot delete an internal file: " + this.file);
        } else {
            return deleteDirectory(file());
        }
    }

    public void emptyDirectory() {
        emptyDirectory(false);
    }

    public void emptyDirectory(boolean z) {
        if (this.type == in.a.Classpath) {
            throw new k("Cannot delete a classpath file: " + this.file);
        } else if (this.type == in.a.Internal) {
            throw new k("Cannot delete an internal file: " + this.file);
        } else {
            emptyDirectory(file(), z);
        }
    }

    public void copyTo(jy jyVar) {
        if (!isDirectory()) {
            if (jyVar.isDirectory()) {
                jyVar = jyVar.child(name());
            }
            copyFile(this, jyVar);
            return;
        }
        if (jyVar.exists()) {
            if (!jyVar.isDirectory()) {
                throw new k("Destination exists but is not a directory: " + jyVar);
            }
        } else {
            jyVar.mkdirs();
            if (!jyVar.isDirectory()) {
                throw new k("Destination directory cannot be created: " + jyVar);
            }
        }
        copyDirectory(this, jyVar.child(name()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void moveTo(jy jyVar) {
        switch (this.type) {
            case Internal:
                throw new k("Cannot move an internal file: " + this.file);
            case Classpath:
                throw new k("Cannot move a classpath file: " + this.file);
            case Absolute:
            case External:
                if (file().renameTo(jyVar.file())) {
                    return;
                }
                break;
        }
        copyTo(jyVar);
        delete();
        if (exists() && isDirectory()) {
            deleteDirectory();
        }
    }

    public long length() {
        if (this.type == in.a.Classpath || (this.type == in.a.Internal && !this.file.exists())) {
            InputStream read = read();
            try {
                long available = read.available();
                ak.a(read);
                return available;
            } catch (Exception unused) {
                ak.a(read);
                return 0L;
            } catch (Throwable th) {
                ak.a(read);
                throw th;
            }
        }
        return file().length();
    }

    public long lastModified() {
        return file().lastModified();
    }

    public boolean equals(Object obj) {
        if (obj instanceof jy) {
            jy jyVar = (jy) obj;
            return this.type == jyVar.type && path().equals(jyVar.path());
        }
        return false;
    }

    public int hashCode() {
        return ((37 + this.type.hashCode()) * 67) + path().hashCode();
    }

    public String toString() {
        return this.file.getPath().replace('\\', '/');
    }

    public static jy tempFile(String str) {
        try {
            return new jy(File.createTempFile(str, null));
        } catch (IOException e) {
            throw new k("Unable to create temp file.", e);
        }
    }

    public static jy tempDirectory(String str) {
        try {
            File createTempFile = File.createTempFile(str, null);
            if (!createTempFile.delete()) {
                throw new IOException("Unable to delete temp file: " + createTempFile);
            } else if (!createTempFile.mkdir()) {
                throw new IOException("Unable to create temp directory: " + createTempFile);
            } else {
                return new jy(createTempFile);
            }
        } catch (IOException e) {
            throw new k("Unable to create temp file.", e);
        }
    }

    private static void emptyDirectory(File file, boolean z) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        int length = listFiles.length;
        for (int i = 0; i < length; i++) {
            if (!listFiles[i].isDirectory()) {
                listFiles[i].delete();
            } else if (z) {
                emptyDirectory(listFiles[i], true);
            } else {
                deleteDirectory(listFiles[i]);
            }
        }
    }

    private static boolean deleteDirectory(File file) {
        emptyDirectory(file, false);
        return file.delete();
    }

    private static void copyFile(jy jyVar, jy jyVar2) {
        try {
            jyVar2.write(jyVar.read(), false);
        } catch (Exception e) {
            throw new k("Error copying source file: " + jyVar.file + " (" + jyVar.type + ")\nTo destination: " + jyVar2.file + " (" + jyVar2.type + ")", e);
        }
    }

    private static void copyDirectory(jy jyVar, jy jyVar2) {
        jy[] list;
        jyVar2.mkdirs();
        for (jy jyVar3 : jyVar.list()) {
            jy child = jyVar2.child(jyVar3.name());
            if (jyVar3.isDirectory()) {
                copyDirectory(jyVar3, child);
            } else {
                copyFile(jyVar3, child);
            }
        }
    }
}
