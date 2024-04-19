package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.q;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: UBJsonReader.java */
/* loaded from: classes.dex */
public class aq implements c {
    public boolean a = true;

    public q a(InputStream inputStream) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            try {
                dataInputStream = new DataInputStream(inputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            q a = a(dataInputStream);
            ak.a(dataInputStream);
            return a;
        } catch (IOException e2) {
            e = e2;
            throw new af(e);
        } catch (Throwable th2) {
            th = th2;
            dataInputStream2 = dataInputStream;
            ak.a(dataInputStream2);
            throw th;
        }
    }

    @Override // com.badlogic.gdx.utils.c
    public q a(jy jyVar) {
        try {
            return a(jyVar.read(8192));
        } catch (Exception e) {
            throw new af("Error parsing file: " + jyVar, e);
        }
    }

    public q a(DataInputStream dataInputStream) throws IOException {
        try {
            return a(dataInputStream, dataInputStream.readByte());
        } finally {
            ak.a(dataInputStream);
        }
    }

    protected q a(DataInputStream dataInputStream, byte b) throws IOException {
        if (b == 91) {
            return b(dataInputStream);
        }
        if (b == 123) {
            return c(dataInputStream);
        }
        if (b == 90) {
            return new q(q.c.nullValue);
        }
        if (b == 84) {
            return new q(true);
        }
        if (b == 70) {
            return new q(false);
        }
        if (b == 66) {
            return new q(d(dataInputStream));
        }
        if (b == 85) {
            return new q(d(dataInputStream));
        }
        if (b == 105) {
            return new q(this.a ? dataInputStream.readShort() : dataInputStream.readByte());
        } else if (b == 73) {
            return new q(this.a ? dataInputStream.readInt() : dataInputStream.readShort());
        } else if (b == 108) {
            return new q(dataInputStream.readInt());
        } else {
            if (b == 76) {
                return new q(dataInputStream.readLong());
            }
            if (b == 100) {
                return new q(dataInputStream.readFloat());
            }
            if (b == 68) {
                return new q(dataInputStream.readDouble());
            }
            if (b == 115 || b == 83) {
                return new q(c(dataInputStream, b));
            }
            if (b == 97 || b == 65) {
                return b(dataInputStream, b);
            }
            if (b == 67) {
                return new q(dataInputStream.readChar());
            }
            throw new k("Unrecognized data type");
        }
    }

    protected q b(DataInputStream dataInputStream) throws IOException {
        byte b;
        q qVar = new q(q.c.array);
        byte readByte = dataInputStream.readByte();
        if (readByte == 36) {
            b = dataInputStream.readByte();
            readByte = dataInputStream.readByte();
        } else {
            b = 0;
        }
        long j = -1;
        if (readByte == 35) {
            j = a(dataInputStream, false, -1L);
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new k("Unrecognized data type");
            }
            if (i == 0) {
                return qVar;
            }
            readByte = b == 0 ? dataInputStream.readByte() : b;
        }
        q qVar2 = null;
        long j2 = 0;
        while (dataInputStream.available() > 0 && readByte != 93) {
            q a = a(dataInputStream, readByte);
            a.e = qVar;
            if (qVar2 != null) {
                a.d = qVar2;
                qVar2.c = a;
                qVar.f++;
            } else {
                qVar.b = a;
                qVar.f = 1;
            }
            if (j > 0) {
                j2++;
                if (j2 >= j) {
                    break;
                }
            }
            qVar2 = a;
            readByte = b == 0 ? dataInputStream.readByte() : b;
        }
        return qVar;
    }

    protected q c(DataInputStream dataInputStream) throws IOException {
        byte b;
        q qVar = new q(q.c.object);
        byte readByte = dataInputStream.readByte();
        if (readByte == 36) {
            b = dataInputStream.readByte();
            readByte = dataInputStream.readByte();
        } else {
            b = 0;
        }
        long j = -1;
        if (readByte == 35) {
            j = a(dataInputStream, false, -1L);
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new k("Unrecognized data type");
            }
            if (i == 0) {
                return qVar;
            }
            readByte = dataInputStream.readByte();
        }
        q qVar2 = null;
        long j2 = 0;
        while (dataInputStream.available() > 0 && readByte != 125) {
            String a = a(dataInputStream, true, readByte);
            q a2 = a(dataInputStream, b == 0 ? dataInputStream.readByte() : b);
            a2.e(a);
            a2.e = qVar;
            if (qVar2 != null) {
                a2.d = qVar2;
                qVar2.c = a2;
                qVar.f++;
            } else {
                qVar.b = a2;
                qVar.f = 1;
            }
            if (j > 0) {
                j2++;
                if (j2 >= j) {
                    break;
                }
            }
            readByte = dataInputStream.readByte();
            qVar2 = a2;
        }
        return qVar;
    }

    protected q b(DataInputStream dataInputStream, byte b) throws IOException {
        byte readByte = dataInputStream.readByte();
        long f = b == 65 ? f(dataInputStream) : d(dataInputStream);
        q qVar = new q(q.c.array);
        q qVar2 = null;
        long j = 0;
        while (j < f) {
            q a = a(dataInputStream, readByte);
            a.e = qVar;
            if (qVar2 != null) {
                qVar2.c = a;
                qVar.f++;
            } else {
                qVar.b = a;
                qVar.f = 1;
            }
            j++;
            qVar2 = a;
        }
        return qVar;
    }

    protected String c(DataInputStream dataInputStream, byte b) throws IOException {
        return a(dataInputStream, false, b);
    }

    protected String a(DataInputStream dataInputStream, boolean z, byte b) throws IOException {
        long j = -1;
        if (b == 83) {
            j = a(dataInputStream, true, -1L);
        } else if (b == 115) {
            j = d(dataInputStream);
        } else if (z) {
            j = a(dataInputStream, b, false, -1L);
        }
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            return i > 0 ? a(dataInputStream, j) : "";
        }
        throw new k("Unrecognized data type, string expected");
    }

    protected long a(DataInputStream dataInputStream, boolean z, long j) throws IOException {
        return a(dataInputStream, dataInputStream.readByte(), z, j);
    }

    protected long a(DataInputStream dataInputStream, byte b, boolean z, long j) throws IOException {
        if (b == 105) {
            return d(dataInputStream);
        }
        if (b == 73) {
            return e(dataInputStream);
        }
        if (b == 108) {
            return f(dataInputStream);
        }
        if (b == 76) {
            return dataInputStream.readLong();
        }
        return z ? ((b & 255) << 24) | ((dataInputStream.readByte() & 255) << 16) | ((dataInputStream.readByte() & 255) << 8) | (dataInputStream.readByte() & 255) : j;
    }

    protected short d(DataInputStream dataInputStream) throws IOException {
        return (short) (dataInputStream.readByte() & 255);
    }

    protected int e(DataInputStream dataInputStream) throws IOException {
        return dataInputStream.readShort() & 65535;
    }

    protected long f(DataInputStream dataInputStream) throws IOException {
        return dataInputStream.readInt() & (-1);
    }

    protected String a(DataInputStream dataInputStream, long j) throws IOException {
        byte[] bArr = new byte[(int) j];
        dataInputStream.readFully(bArr);
        return new String(bArr, "UTF-8");
    }
}
