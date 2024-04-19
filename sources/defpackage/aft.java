package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
/* compiled from: SevenZOutputFile.java */
/* renamed from: aft  reason: default package */
/* loaded from: classes.dex */
public class aft implements Closeable {
    private final RandomAccessFile a;
    private afz h;
    private afz[] i;
    private final List<afp> b = new ArrayList();
    private int c = 0;
    private final CRC32 d = new CRC32();
    private final CRC32 e = new CRC32();
    private long f = 0;
    private boolean g = false;
    private Iterable<? extends afs> j = Collections.singletonList(new afs(afr.LZMA2));
    private final Map<afp, long[]> k = new HashMap();

    static /* synthetic */ long a(aft aftVar, long j) {
        long j2 = aftVar.f + j;
        aftVar.f = j2;
        return j2;
    }

    static /* synthetic */ long d(aft aftVar) {
        long j = aftVar.f;
        aftVar.f = 1 + j;
        return j;
    }

    public aft(File file) throws IOException {
        this.a = new RandomAccessFile(file, "rw");
        this.a.seek(32L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.g) {
            b();
        }
        this.a.close();
    }

    public afp a(File file, String str) throws IOException {
        afp afpVar = new afp();
        afpVar.b(file.isDirectory());
        afpVar.a(str);
        afpVar.a(new Date(file.lastModified()));
        return afpVar;
    }

    public void a(aff affVar) throws IOException {
        this.b.add((afp) affVar);
    }

    public void a() throws IOException {
        afz afzVar = this.h;
        if (afzVar != null) {
            afzVar.flush();
            this.h.close();
        }
        List<afp> list = this.b;
        afp afpVar = list.get(list.size() - 1);
        int i = 0;
        if (this.f > 0) {
            afpVar.a(true);
            this.c++;
            afpVar.c(this.h.a());
            afpVar.d(this.f);
            afpVar.a(this.d.getValue());
            afpVar.b(this.e.getValue());
            afpVar.c(true);
            afz[] afzVarArr = this.i;
            if (afzVarArr != null) {
                long[] jArr = new long[afzVarArr.length];
                while (true) {
                    afz[] afzVarArr2 = this.i;
                    if (i >= afzVarArr2.length) {
                        break;
                    }
                    jArr[i] = afzVarArr2[i].a();
                    i++;
                }
                this.k.put(afpVar, jArr);
            }
        } else {
            afpVar.a(false);
            afpVar.c(0L);
            afpVar.d(0L);
            afpVar.c(false);
        }
        this.h = null;
        this.i = null;
        this.d.reset();
        this.e.reset();
        this.f = 0L;
    }

    public void a(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            c().write(bArr, i, i2);
        }
    }

    public void b() throws IOException {
        if (this.g) {
            throw new IOException("This archive has already been finished");
        }
        this.g = true;
        long filePointer = this.a.getFilePointer();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        a(dataOutputStream);
        dataOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.a.write(byteArray);
        CRC32 crc32 = new CRC32();
        this.a.seek(0L);
        this.a.write(afq.a);
        this.a.write(0);
        this.a.write(2);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
        dataOutputStream2.writeLong(Long.reverseBytes(filePointer - 32));
        dataOutputStream2.writeLong(Long.reverseBytes(4294967295L & byteArray.length));
        crc32.reset();
        crc32.update(byteArray);
        dataOutputStream2.writeInt(Integer.reverseBytes((int) crc32.getValue()));
        dataOutputStream2.flush();
        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
        crc32.reset();
        crc32.update(byteArray2);
        this.a.writeInt(Integer.reverseBytes((int) crc32.getValue()));
        this.a.write(byteArray2);
    }

    private OutputStream c() throws IOException {
        if (this.h == null) {
            this.h = d();
        }
        return this.h;
    }

    private afz d() throws IOException {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No current 7z entry");
        }
        afz aVar = new a();
        ArrayList arrayList = new ArrayList();
        List<afp> list = this.b;
        boolean z = true;
        for (afs afsVar : a(list.get(list.size() - 1))) {
            if (!z) {
                afz afzVar = new afz(aVar);
                arrayList.add(afzVar);
                aVar = afzVar;
            }
            aVar = afl.a(aVar, afsVar.a(), afsVar.b());
            z = false;
        }
        if (!arrayList.isEmpty()) {
            this.i = (afz[]) arrayList.toArray(new afz[arrayList.size()]);
        }
        return new afz(aVar) { // from class: aft.1
            @Override // defpackage.afz, java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) throws IOException {
                super.write(i);
                aft.this.d.update(i);
            }

            @Override // defpackage.afz, java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr) throws IOException {
                super.write(bArr);
                aft.this.d.update(bArr);
            }

            @Override // defpackage.afz, java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                super.write(bArr, i, i2);
                aft.this.d.update(bArr, i, i2);
            }
        };
    }

    private Iterable<? extends afs> a(afp afpVar) {
        Iterable<? extends afs> q = afpVar.q();
        return q == null ? this.j : q;
    }

    private void a(DataOutput dataOutput) throws IOException {
        dataOutput.write(1);
        dataOutput.write(4);
        b(dataOutput);
        f(dataOutput);
        dataOutput.write(0);
    }

    private void b(DataOutput dataOutput) throws IOException {
        if (this.c > 0) {
            c(dataOutput);
            d(dataOutput);
        }
        e(dataOutput);
        dataOutput.write(0);
    }

    private void c(DataOutput dataOutput) throws IOException {
        dataOutput.write(6);
        a(dataOutput, 0L);
        a(dataOutput, this.c & 4294967295L);
        dataOutput.write(9);
        for (afp afpVar : this.b) {
            if (afpVar.b()) {
                a(dataOutput, afpVar.p());
            }
        }
        dataOutput.write(10);
        dataOutput.write(1);
        for (afp afpVar2 : this.b) {
            if (afpVar2.b()) {
                dataOutput.writeInt(Integer.reverseBytes((int) afpVar2.n()));
            }
        }
        dataOutput.write(0);
    }

    private void d(DataOutput dataOutput) throws IOException {
        dataOutput.write(7);
        dataOutput.write(11);
        a(dataOutput, this.c);
        dataOutput.write(0);
        for (afp afpVar : this.b) {
            if (afpVar.b()) {
                a(dataOutput, afpVar);
            }
        }
        dataOutput.write(12);
        for (afp afpVar2 : this.b) {
            if (afpVar2.b()) {
                long[] jArr = this.k.get(afpVar2);
                if (jArr != null) {
                    for (long j : jArr) {
                        a(dataOutput, j);
                    }
                }
                a(dataOutput, afpVar2.o());
            }
        }
        dataOutput.write(10);
        dataOutput.write(1);
        for (afp afpVar3 : this.b) {
            if (afpVar3.b()) {
                dataOutput.writeInt(Integer.reverseBytes((int) afpVar3.m()));
            }
        }
        dataOutput.write(0);
    }

    private void a(DataOutput dataOutput, afp afpVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        for (afs afsVar : a(afpVar)) {
            i2++;
            a(afsVar, byteArrayOutputStream);
        }
        a(dataOutput, i2);
        dataOutput.write(byteArrayOutputStream.toByteArray());
        while (i < i2 - 1) {
            int i3 = i + 1;
            a(dataOutput, i3);
            a(dataOutput, i);
            i = i3;
        }
    }

    private void a(afs afsVar, OutputStream outputStream) throws IOException {
        byte[] a2 = afsVar.a().a();
        byte[] b = afl.a(afsVar.a()).b(afsVar.b());
        int length = a2.length;
        if (b.length > 0) {
            length |= 32;
        }
        outputStream.write(length);
        outputStream.write(a2);
        if (b.length > 0) {
            outputStream.write(b.length);
            outputStream.write(b);
        }
    }

    private void e(DataOutput dataOutput) throws IOException {
        dataOutput.write(8);
        dataOutput.write(0);
    }

    private void f(DataOutput dataOutput) throws IOException {
        dataOutput.write(5);
        a(dataOutput, this.b.size());
        g(dataOutput);
        h(dataOutput);
        i(dataOutput);
        j(dataOutput);
        k(dataOutput);
        l(dataOutput);
        m(dataOutput);
        n(dataOutput);
        dataOutput.write(0);
    }

    private void g(DataOutput dataOutput) throws IOException {
        int i;
        boolean z;
        Iterator<afp> it = this.b.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().b()) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            dataOutput.write(14);
            BitSet bitSet = new BitSet(this.b.size());
            for (i = 0; i < this.b.size(); i++) {
                bitSet.set(i, !this.b.get(i).b());
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            a(dataOutputStream, bitSet, this.b.size());
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void h(DataOutput dataOutput) throws IOException {
        boolean z = false;
        BitSet bitSet = new BitSet(0);
        int i = 0;
        for (afp afpVar : this.b) {
            if (!afpVar.b()) {
                boolean c = afpVar.c();
                bitSet.set(i, !c);
                z |= !c;
                i++;
            }
        }
        if (z) {
            dataOutput.write(15);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            a(dataOutputStream, bitSet, i);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void i(DataOutput dataOutput) throws IOException {
        boolean z = false;
        BitSet bitSet = new BitSet(0);
        int i = 0;
        for (afp afpVar : this.b) {
            if (!afpVar.b()) {
                boolean d = afpVar.d();
                bitSet.set(i, d);
                z |= d;
                i++;
            }
        }
        if (z) {
            dataOutput.write(16);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            a(dataOutputStream, bitSet, i);
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void j(DataOutput dataOutput) throws IOException {
        dataOutput.write(17);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.write(0);
        for (afp afpVar : this.b) {
            dataOutputStream.write(afpVar.a().getBytes("UTF-16LE"));
            dataOutputStream.writeShort(0);
        }
        dataOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        a(dataOutput, byteArray.length);
        dataOutput.write(byteArray);
    }

    private void k(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (afp afpVar : this.b) {
            if (afpVar.e()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(18);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.b.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.b.size());
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    bitSet.set(i2, this.b.get(i2).e());
                }
                a(dataOutputStream, bitSet, this.b.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (afp afpVar2 : this.b) {
                if (afpVar2.e()) {
                    dataOutputStream.writeLong(Long.reverseBytes(afp.b(afpVar2.f())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void l(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (afp afpVar : this.b) {
            if (afpVar.i()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(19);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.b.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.b.size());
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    bitSet.set(i2, this.b.get(i2).i());
                }
                a(dataOutputStream, bitSet, this.b.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (afp afpVar2 : this.b) {
                if (afpVar2.i()) {
                    dataOutputStream.writeLong(Long.reverseBytes(afp.b(afpVar2.j())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void m(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (afp afpVar : this.b) {
            if (afpVar.g()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(20);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.b.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.b.size());
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    bitSet.set(i2, this.b.get(i2).g());
                }
                a(dataOutputStream, bitSet, this.b.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (afp afpVar2 : this.b) {
                if (afpVar2.g()) {
                    dataOutputStream.writeLong(Long.reverseBytes(afp.b(afpVar2.h())));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void n(DataOutput dataOutput) throws IOException {
        int i = 0;
        for (afp afpVar : this.b) {
            if (afpVar.k()) {
                i++;
            }
        }
        if (i > 0) {
            dataOutput.write(21);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (i != this.b.size()) {
                dataOutputStream.write(0);
                BitSet bitSet = new BitSet(this.b.size());
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    bitSet.set(i2, this.b.get(i2).k());
                }
                a(dataOutputStream, bitSet, this.b.size());
            } else {
                dataOutputStream.write(1);
            }
            dataOutputStream.write(0);
            for (afp afpVar2 : this.b) {
                if (afpVar2.k()) {
                    dataOutputStream.writeInt(Integer.reverseBytes(afpVar2.l()));
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(dataOutput, byteArray.length);
            dataOutput.write(byteArray);
        }
    }

    private void a(DataOutput dataOutput, long j) throws IOException {
        int i = 0;
        int i2 = 128;
        int i3 = 0;
        while (true) {
            if (i >= 8) {
                break;
            }
            int i4 = i + 1;
            if (j < (1 << (i4 * 7))) {
                i3 = (int) (i3 | (j >>> (i * 8)));
                break;
            }
            i3 |= i2;
            i2 >>>= 1;
            i = i4;
        }
        dataOutput.write(i3);
        while (i > 0) {
            dataOutput.write((int) (255 & j));
            j >>>= 8;
            i--;
        }
    }

    private void a(DataOutput dataOutput, BitSet bitSet, int i) throws IOException {
        int i2 = 7;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 |= (bitSet.get(i4) ? 1 : 0) << i2;
            i2--;
            if (i2 < 0) {
                dataOutput.write(i3);
                i2 = 7;
                i3 = 0;
            }
        }
        if (i2 != 7) {
            dataOutput.write(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SevenZOutputFile.java */
    /* renamed from: aft$a */
    /* loaded from: classes.dex */
    public class a extends OutputStream {
        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
        }

        private a() {
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            aft.this.a.write(i);
            aft.this.e.update(i);
            aft.d(aft.this);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            aft.this.a.write(bArr, i, i2);
            aft.this.e.update(bArr, i, i2);
            aft.a(aft.this, i2);
        }
    }
}
