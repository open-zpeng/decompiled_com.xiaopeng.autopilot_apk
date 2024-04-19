package defpackage;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import defpackage.a;
import defpackage.b;
import java.io.IOException;
import java.util.List;
/* compiled from: WMDisplayMap.java */
/* renamed from: ahz  reason: default package */
/* loaded from: classes.dex */
public final class ahz {

    /* renamed from: ahz$b */
    /* loaded from: classes.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* renamed from: ahz$d */
    /* loaded from: classes.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* compiled from: WMDisplayMap.java */
    /* renamed from: ahz$c */
    /* loaded from: classes.dex */
    public static final class c extends GeneratedMessageLite<c, a> implements d {
        private static final c k = new c();
        private static volatile Parser<c> l;
        private int a;
        private aj b;
        private Internal.ProtobufList<v> c = emptyProtobufList();
        private Internal.ProtobufList<l> d = emptyProtobufList();
        private Internal.ProtobufList<n> e = emptyProtobufList();
        private Internal.ProtobufList<ab> f = emptyProtobufList();
        private Internal.ProtobufList<af> g = emptyProtobufList();
        private Internal.ProtobufList<p> h = emptyProtobufList();
        private Internal.ProtobufList<h> i = emptyProtobufList();
        private Internal.ProtobufList<j> j = emptyProtobufList();

        /* renamed from: ahz$c$aa */
        /* loaded from: classes.dex */
        public interface aa extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$ac */
        /* loaded from: classes.dex */
        public interface ac extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$ae */
        /* loaded from: classes.dex */
        public interface ae extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$ag */
        /* loaded from: classes.dex */
        public interface ag extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$ai */
        /* loaded from: classes.dex */
        public interface ai extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$ak */
        /* loaded from: classes.dex */
        public interface ak extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$am */
        /* loaded from: classes.dex */
        public interface am extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0010c extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$e */
        /* loaded from: classes.dex */
        public interface e extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$g */
        /* loaded from: classes.dex */
        public interface g extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$i */
        /* loaded from: classes.dex */
        public interface i extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$k */
        /* loaded from: classes.dex */
        public interface k extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$m */
        /* loaded from: classes.dex */
        public interface m extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$o */
        /* loaded from: classes.dex */
        public interface o extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$q */
        /* loaded from: classes.dex */
        public interface q extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$s */
        /* loaded from: classes.dex */
        public interface s extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$u */
        /* loaded from: classes.dex */
        public interface u extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$w */
        /* loaded from: classes.dex */
        public interface w extends MessageLiteOrBuilder {
        }

        /* renamed from: ahz$c$y */
        /* loaded from: classes.dex */
        public interface y extends MessageLiteOrBuilder {
        }

        private c() {
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$h */
        /* loaded from: classes.dex */
        public static final class h extends GeneratedMessageLite<h, a> implements i {
            private static final h e = new h();
            private static volatile Parser<h> f;
            private int a;
            private int b;
            private float c;
            private float d;

            private h() {
            }

            public int a() {
                return this.b;
            }

            public float b() {
                return this.c;
            }

            public float c() {
                return this.d;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputStream.writeInt32(2, i2);
                }
                float f2 = this.c;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(3, f2);
                }
                float f3 = this.d;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(4, f3);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
                int i3 = this.b;
                if (i3 != 0) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
                }
                float f2 = this.c;
                if (f2 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(3, f2);
                }
                float f3 = this.d;
                if (f3 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(4, f3);
                }
                this.memoizedSerializedSize = computeInt32Size;
                return computeInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$h$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<h, a> implements i {
                private a() {
                    super(h.e);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new h();
                    case IS_INITIALIZED:
                        return e;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        h hVar = (h) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, hVar.a != 0, hVar.a);
                        this.b = visitor.visitInt(this.b != 0, this.b, hVar.b != 0, hVar.b);
                        this.c = visitor.visitFloat(this.c != 0.0f, this.c, hVar.c != 0.0f, hVar.c);
                        this.d = visitor.visitFloat(this.d != 0.0f, this.d, hVar.d != 0.0f, hVar.d);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag == 0) {
                                    r1 = true;
                                } else if (readTag == 8) {
                                    this.a = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.b = codedInputStream.readInt32();
                                } else if (readTag == 29) {
                                    this.c = codedInputStream.readFloat();
                                } else if (readTag != 37) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                                } else {
                                    this.d = codedInputStream.readFloat();
                                }
                            } catch (InvalidProtocolBufferException e2) {
                                throw new RuntimeException(e2.setUnfinishedMessage(this));
                            } catch (IOException e3) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (f == null) {
                            synchronized (h.class) {
                                if (f == null) {
                                    f = new GeneratedMessageLite.DefaultInstanceBasedParser(e);
                                }
                            }
                        }
                        return f;
                    default:
                        throw new UnsupportedOperationException();
                }
                return e;
            }

            static {
                e.makeImmutable();
            }

            public static Parser<h> d() {
                return e.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$al */
        /* loaded from: classes.dex */
        public static final class al extends GeneratedMessageLite<al, a> implements am {
            private static final al k = new al();
            private static volatile Parser<al> l;
            private int a;
            private int b;
            private float c;
            private float d;
            private float e;
            private float f;
            private float g;
            private float h;
            private int i;
            private int j;

            private al() {
            }

            public float a() {
                return this.c;
            }

            public float b() {
                return this.d;
            }

            public float c() {
                return this.e;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputStream.writeUInt32(2, i2);
                }
                float f = this.c;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(3, f);
                }
                float f2 = this.d;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(4, f2);
                }
                float f3 = this.e;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(5, f3);
                }
                float f4 = this.f;
                if (f4 != 0.0f) {
                    codedOutputStream.writeFloat(6, f4);
                }
                float f5 = this.g;
                if (f5 != 0.0f) {
                    codedOutputStream.writeFloat(7, f5);
                }
                float f6 = this.h;
                if (f6 != 0.0f) {
                    codedOutputStream.writeFloat(8, f6);
                }
                int i3 = this.i;
                if (i3 != 0) {
                    codedOutputStream.writeSInt32(9, i3);
                }
                int i4 = this.j;
                if (i4 != 0) {
                    codedOutputStream.writeInt32(10, i4);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
                int i3 = this.b;
                if (i3 != 0) {
                    computeInt32Size += CodedOutputStream.computeUInt32Size(2, i3);
                }
                float f = this.c;
                if (f != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(3, f);
                }
                float f2 = this.d;
                if (f2 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(4, f2);
                }
                float f3 = this.e;
                if (f3 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(5, f3);
                }
                float f4 = this.f;
                if (f4 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(6, f4);
                }
                float f5 = this.g;
                if (f5 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(7, f5);
                }
                float f6 = this.h;
                if (f6 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(8, f6);
                }
                int i4 = this.i;
                if (i4 != 0) {
                    computeInt32Size += CodedOutputStream.computeSInt32Size(9, i4);
                }
                int i5 = this.j;
                if (i5 != 0) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(10, i5);
                }
                this.memoizedSerializedSize = computeInt32Size;
                return computeInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$al$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<al, a> implements am {
                private a() {
                    super(al.k);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new al();
                    case IS_INITIALIZED:
                        return k;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        al alVar = (al) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, alVar.a != 0, alVar.a);
                        this.b = visitor.visitInt(this.b != 0, this.b, alVar.b != 0, alVar.b);
                        this.c = visitor.visitFloat(this.c != 0.0f, this.c, alVar.c != 0.0f, alVar.c);
                        this.d = visitor.visitFloat(this.d != 0.0f, this.d, alVar.d != 0.0f, alVar.d);
                        this.e = visitor.visitFloat(this.e != 0.0f, this.e, alVar.e != 0.0f, alVar.e);
                        this.f = visitor.visitFloat(this.f != 0.0f, this.f, alVar.f != 0.0f, alVar.f);
                        this.g = visitor.visitFloat(this.g != 0.0f, this.g, alVar.g != 0.0f, alVar.g);
                        this.h = visitor.visitFloat(this.h != 0.0f, this.h, alVar.h != 0.0f, alVar.h);
                        this.i = visitor.visitInt(this.i != 0, this.i, alVar.i != 0, alVar.i);
                        this.j = visitor.visitInt(this.j != 0, this.j, alVar.j != 0, alVar.j);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        r1 = true;
                                        break;
                                    case 8:
                                        this.a = codedInputStream.readInt32();
                                        break;
                                    case 16:
                                        this.b = codedInputStream.readUInt32();
                                        break;
                                    case 29:
                                        this.c = codedInputStream.readFloat();
                                        break;
                                    case 37:
                                        this.d = codedInputStream.readFloat();
                                        break;
                                    case 45:
                                        this.e = codedInputStream.readFloat();
                                        break;
                                    case 53:
                                        this.f = codedInputStream.readFloat();
                                        break;
                                    case 61:
                                        this.g = codedInputStream.readFloat();
                                        break;
                                    case 69:
                                        this.h = codedInputStream.readFloat();
                                        break;
                                    case 72:
                                        this.i = codedInputStream.readSInt32();
                                        break;
                                    case 80:
                                        this.j = codedInputStream.readInt32();
                                        break;
                                    default:
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (l == null) {
                            synchronized (al.class) {
                                if (l == null) {
                                    l = new GeneratedMessageLite.DefaultInstanceBasedParser(k);
                                }
                            }
                        }
                        return l;
                    default:
                        throw new UnsupportedOperationException();
                }
                return k;
            }

            static {
                k.makeImmutable();
            }

            public static Parser<al> d() {
                return k.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$f */
        /* loaded from: classes.dex */
        public static final class f extends GeneratedMessageLite<f, a> implements g {
            private static final f i = new f();
            private static volatile Parser<f> j;
            private int a;
            private float b;
            private int c;
            private int d;
            private int e;
            private int f;
            private int g;
            private int h;

            private f() {
            }

            public int a() {
                return this.h;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i2 = this.a;
                if (i2 != 0) {
                    codedOutputStream.writeInt32(1, i2);
                }
                float f = this.b;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(2, f);
                }
                int i3 = this.c;
                if (i3 != 0) {
                    codedOutputStream.writeUInt32(3, i3);
                }
                int i4 = this.d;
                if (i4 != 0) {
                    codedOutputStream.writeUInt32(4, i4);
                }
                int i5 = this.e;
                if (i5 != 0) {
                    codedOutputStream.writeUInt32(5, i5);
                }
                int i6 = this.f;
                if (i6 != 0) {
                    codedOutputStream.writeUInt32(6, i6);
                }
                int i7 = this.g;
                if (i7 != 0) {
                    codedOutputStream.writeUInt32(7, i7);
                }
                int i8 = this.h;
                if (i8 != 0) {
                    codedOutputStream.writeInt32(8, i8);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = this.a;
                int computeInt32Size = i3 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i3) : 0;
                float f = this.b;
                if (f != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(2, f);
                }
                int i4 = this.c;
                if (i4 != 0) {
                    computeInt32Size += CodedOutputStream.computeUInt32Size(3, i4);
                }
                int i5 = this.d;
                if (i5 != 0) {
                    computeInt32Size += CodedOutputStream.computeUInt32Size(4, i5);
                }
                int i6 = this.e;
                if (i6 != 0) {
                    computeInt32Size += CodedOutputStream.computeUInt32Size(5, i6);
                }
                int i7 = this.f;
                if (i7 != 0) {
                    computeInt32Size += CodedOutputStream.computeUInt32Size(6, i7);
                }
                int i8 = this.g;
                if (i8 != 0) {
                    computeInt32Size += CodedOutputStream.computeUInt32Size(7, i8);
                }
                int i9 = this.h;
                if (i9 != 0) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(8, i9);
                }
                this.memoizedSerializedSize = computeInt32Size;
                return computeInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$f$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<f, a> implements g {
                private a() {
                    super(f.i);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new f();
                    case IS_INITIALIZED:
                        return i;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        f fVar = (f) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, fVar.a != 0, fVar.a);
                        this.b = visitor.visitFloat(this.b != 0.0f, this.b, fVar.b != 0.0f, fVar.b);
                        this.c = visitor.visitInt(this.c != 0, this.c, fVar.c != 0, fVar.c);
                        this.d = visitor.visitInt(this.d != 0, this.d, fVar.d != 0, fVar.d);
                        this.e = visitor.visitInt(this.e != 0, this.e, fVar.e != 0, fVar.e);
                        this.f = visitor.visitInt(this.f != 0, this.f, fVar.f != 0, fVar.f);
                        this.g = visitor.visitInt(this.g != 0, this.g, fVar.g != 0, fVar.g);
                        this.h = visitor.visitInt(this.h != 0, this.h, fVar.h != 0, fVar.h);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag == 0) {
                                    r1 = true;
                                } else if (readTag == 8) {
                                    this.a = codedInputStream.readInt32();
                                } else if (readTag == 21) {
                                    this.b = codedInputStream.readFloat();
                                } else if (readTag == 24) {
                                    this.c = codedInputStream.readUInt32();
                                } else if (readTag == 32) {
                                    this.d = codedInputStream.readUInt32();
                                } else if (readTag == 40) {
                                    this.e = codedInputStream.readUInt32();
                                } else if (readTag == 48) {
                                    this.f = codedInputStream.readUInt32();
                                } else if (readTag == 56) {
                                    this.g = codedInputStream.readUInt32();
                                } else if (readTag != 64) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                                } else {
                                    this.h = codedInputStream.readInt32();
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (j == null) {
                            synchronized (f.class) {
                                if (j == null) {
                                    j = new GeneratedMessageLite.DefaultInstanceBasedParser(i);
                                }
                            }
                        }
                        return j;
                    default:
                        throw new UnsupportedOperationException();
                }
                return i;
            }

            static {
                i.makeImmutable();
            }

            public static f b() {
                return i;
            }

            public static Parser<f> c() {
                return i.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$ah */
        /* loaded from: classes.dex */
        public static final class ah extends GeneratedMessageLite<ah, a> implements ai {
            private static final ah c = new ah();
            private static volatile Parser<ah> d;
            private int a;
            private long b;

            private ah() {
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                long j = this.b;
                if (j != 0) {
                    codedOutputStream.writeInt64(2, j);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
                long j = this.b;
                if (j != 0) {
                    computeInt32Size += CodedOutputStream.computeInt64Size(2, j);
                }
                this.memoizedSerializedSize = computeInt32Size;
                return computeInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$ah$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<ah, a> implements ai {
                private a() {
                    super(ah.c);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new ah();
                    case IS_INITIALIZED:
                        return c;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        ah ahVar = (ah) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, ahVar.a != 0, ahVar.a);
                        this.b = visitor.visitLong(this.b != 0, this.b, ahVar.b != 0, ahVar.b);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag == 0) {
                                    z = true;
                                } else if (readTag == 8) {
                                    this.a = codedInputStream.readInt32();
                                } else if (readTag != 16) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        z = true;
                                    }
                                } else {
                                    this.b = codedInputStream.readInt64();
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (d == null) {
                            synchronized (ah.class) {
                                if (d == null) {
                                    d = new GeneratedMessageLite.DefaultInstanceBasedParser(c);
                                }
                            }
                        }
                        return d;
                    default:
                        throw new UnsupportedOperationException();
                }
                return c;
            }

            static {
                c.makeImmutable();
            }

            public static ah a() {
                return c;
            }

            public static Parser<ah> b() {
                return c.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$ab */
        /* loaded from: classes.dex */
        public static final class ab extends GeneratedMessageLite<ab, a> implements ac {
            private static final ab x = new ab();
            private static volatile Parser<ab> y;
            private int a;
            private int b;
            private int c;
            private int d;
            private float e;
            private float f;
            private float g;
            private float h;
            private float i;
            private float j;
            private float k;
            private float l;
            private float m;
            private float n;
            private float o;
            private int p;
            private float q;
            private float r;
            private float s;
            private int t;
            private ah u;
            private f v;
            private a.C0000a w;

            private ab() {
            }

            public int a() {
                return this.a;
            }

            public int b() {
                return this.c;
            }

            public float c() {
                return this.f;
            }

            public float d() {
                return this.g;
            }

            public float e() {
                return this.h;
            }

            public float f() {
                return this.q;
            }

            public ah g() {
                ah ahVar = this.u;
                return ahVar == null ? ah.a() : ahVar;
            }

            public f h() {
                f fVar = this.v;
                return fVar == null ? f.b() : fVar;
            }

            public a.C0000a i() {
                a.C0000a c0000a = this.w;
                return c0000a == null ? a.C0000a.c() : c0000a;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputStream.writeUInt32(2, i2);
                }
                int i3 = this.c;
                if (i3 != 0) {
                    codedOutputStream.writeSInt32(3, i3);
                }
                int i4 = this.d;
                if (i4 != 0) {
                    codedOutputStream.writeUInt32(4, i4);
                }
                float f = this.e;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(5, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(6, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(7, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    codedOutputStream.writeFloat(8, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    codedOutputStream.writeFloat(9, f5);
                }
                float f6 = this.j;
                if (f6 != 0.0f) {
                    codedOutputStream.writeFloat(10, f6);
                }
                float f7 = this.k;
                if (f7 != 0.0f) {
                    codedOutputStream.writeFloat(11, f7);
                }
                float f8 = this.l;
                if (f8 != 0.0f) {
                    codedOutputStream.writeFloat(12, f8);
                }
                float f9 = this.m;
                if (f9 != 0.0f) {
                    codedOutputStream.writeFloat(13, f9);
                }
                float f10 = this.n;
                if (f10 != 0.0f) {
                    codedOutputStream.writeFloat(14, f10);
                }
                float f11 = this.o;
                if (f11 != 0.0f) {
                    codedOutputStream.writeFloat(15, f11);
                }
                int i5 = this.p;
                if (i5 != 0) {
                    codedOutputStream.writeInt32(16, i5);
                }
                float f12 = this.q;
                if (f12 != 0.0f) {
                    codedOutputStream.writeFloat(17, f12);
                }
                float f13 = this.r;
                if (f13 != 0.0f) {
                    codedOutputStream.writeFloat(18, f13);
                }
                float f14 = this.s;
                if (f14 != 0.0f) {
                    codedOutputStream.writeFloat(19, f14);
                }
                int i6 = this.t;
                if (i6 != 0) {
                    codedOutputStream.writeSInt32(20, i6);
                }
                if (this.u != null) {
                    codedOutputStream.writeMessage(21, g());
                }
                if (this.v != null) {
                    codedOutputStream.writeMessage(22, h());
                }
                if (this.w != null) {
                    codedOutputStream.writeMessage(23, i());
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeUInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeUInt32Size(1, i2) : 0;
                int i3 = this.b;
                if (i3 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(2, i3);
                }
                int i4 = this.c;
                if (i4 != 0) {
                    computeUInt32Size += CodedOutputStream.computeSInt32Size(3, i4);
                }
                int i5 = this.d;
                if (i5 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(4, i5);
                }
                float f = this.e;
                if (f != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(5, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(6, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(7, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(8, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(9, f5);
                }
                float f6 = this.j;
                if (f6 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(10, f6);
                }
                float f7 = this.k;
                if (f7 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(11, f7);
                }
                float f8 = this.l;
                if (f8 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(12, f8);
                }
                float f9 = this.m;
                if (f9 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(13, f9);
                }
                float f10 = this.n;
                if (f10 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(14, f10);
                }
                float f11 = this.o;
                if (f11 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(15, f11);
                }
                int i6 = this.p;
                if (i6 != 0) {
                    computeUInt32Size += CodedOutputStream.computeInt32Size(16, i6);
                }
                float f12 = this.q;
                if (f12 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(17, f12);
                }
                float f13 = this.r;
                if (f13 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(18, f13);
                }
                float f14 = this.s;
                if (f14 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(19, f14);
                }
                int i7 = this.t;
                if (i7 != 0) {
                    computeUInt32Size += CodedOutputStream.computeSInt32Size(20, i7);
                }
                if (this.u != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(21, g());
                }
                if (this.v != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(22, h());
                }
                if (this.w != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(23, i());
                }
                this.memoizedSerializedSize = computeUInt32Size;
                return computeUInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$ab$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<ab, a> implements ac {
                private a() {
                    super(ab.x);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new ab();
                    case IS_INITIALIZED:
                        return x;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        ab abVar = (ab) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, abVar.a != 0, abVar.a);
                        this.b = visitor.visitInt(this.b != 0, this.b, abVar.b != 0, abVar.b);
                        this.c = visitor.visitInt(this.c != 0, this.c, abVar.c != 0, abVar.c);
                        this.d = visitor.visitInt(this.d != 0, this.d, abVar.d != 0, abVar.d);
                        this.e = visitor.visitFloat(this.e != 0.0f, this.e, abVar.e != 0.0f, abVar.e);
                        this.f = visitor.visitFloat(this.f != 0.0f, this.f, abVar.f != 0.0f, abVar.f);
                        this.g = visitor.visitFloat(this.g != 0.0f, this.g, abVar.g != 0.0f, abVar.g);
                        this.h = visitor.visitFloat(this.h != 0.0f, this.h, abVar.h != 0.0f, abVar.h);
                        this.i = visitor.visitFloat(this.i != 0.0f, this.i, abVar.i != 0.0f, abVar.i);
                        this.j = visitor.visitFloat(this.j != 0.0f, this.j, abVar.j != 0.0f, abVar.j);
                        this.k = visitor.visitFloat(this.k != 0.0f, this.k, abVar.k != 0.0f, abVar.k);
                        this.l = visitor.visitFloat(this.l != 0.0f, this.l, abVar.l != 0.0f, abVar.l);
                        this.m = visitor.visitFloat(this.m != 0.0f, this.m, abVar.m != 0.0f, abVar.m);
                        this.n = visitor.visitFloat(this.n != 0.0f, this.n, abVar.n != 0.0f, abVar.n);
                        this.o = visitor.visitFloat(this.o != 0.0f, this.o, abVar.o != 0.0f, abVar.o);
                        this.p = visitor.visitInt(this.p != 0, this.p, abVar.p != 0, abVar.p);
                        this.q = visitor.visitFloat(this.q != 0.0f, this.q, abVar.q != 0.0f, abVar.q);
                        this.r = visitor.visitFloat(this.r != 0.0f, this.r, abVar.r != 0.0f, abVar.r);
                        this.s = visitor.visitFloat(this.s != 0.0f, this.s, abVar.s != 0.0f, abVar.s);
                        this.t = visitor.visitInt(this.t != 0, this.t, abVar.t != 0, abVar.t);
                        this.u = (ah) visitor.visitMessage(this.u, abVar.u);
                        this.v = (f) visitor.visitMessage(this.v, abVar.v);
                        this.w = (a.C0000a) visitor.visitMessage(this.w, abVar.w);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        r1 = true;
                                        break;
                                    case 8:
                                        this.a = codedInputStream.readUInt32();
                                        break;
                                    case 16:
                                        this.b = codedInputStream.readUInt32();
                                        break;
                                    case 24:
                                        this.c = codedInputStream.readSInt32();
                                        break;
                                    case 32:
                                        this.d = codedInputStream.readUInt32();
                                        break;
                                    case 45:
                                        this.e = codedInputStream.readFloat();
                                        break;
                                    case 53:
                                        this.f = codedInputStream.readFloat();
                                        break;
                                    case 61:
                                        this.g = codedInputStream.readFloat();
                                        break;
                                    case 69:
                                        this.h = codedInputStream.readFloat();
                                        break;
                                    case 77:
                                        this.i = codedInputStream.readFloat();
                                        break;
                                    case 85:
                                        this.j = codedInputStream.readFloat();
                                        break;
                                    case 93:
                                        this.k = codedInputStream.readFloat();
                                        break;
                                    case 101:
                                        this.l = codedInputStream.readFloat();
                                        break;
                                    case 109:
                                        this.m = codedInputStream.readFloat();
                                        break;
                                    case 117:
                                        this.n = codedInputStream.readFloat();
                                        break;
                                    case 125:
                                        this.o = codedInputStream.readFloat();
                                        break;
                                    case 128:
                                        this.p = codedInputStream.readInt32();
                                        break;
                                    case 141:
                                        this.q = codedInputStream.readFloat();
                                        break;
                                    case 149:
                                        this.r = codedInputStream.readFloat();
                                        break;
                                    case 157:
                                        this.s = codedInputStream.readFloat();
                                        break;
                                    case 160:
                                        this.t = codedInputStream.readSInt32();
                                        break;
                                    case 170:
                                        ah.a builder = this.u != null ? this.u.toBuilder() : null;
                                        this.u = (ah) codedInputStream.readMessage(ah.b(), extensionRegistryLite);
                                        if (builder == null) {
                                            break;
                                        } else {
                                            builder.mergeFrom((ah.a) this.u);
                                            this.u = builder.buildPartial();
                                            break;
                                        }
                                    case 178:
                                        f.a builder2 = this.v != null ? this.v.toBuilder() : null;
                                        this.v = (f) codedInputStream.readMessage(f.c(), extensionRegistryLite);
                                        if (builder2 == null) {
                                            break;
                                        } else {
                                            builder2.mergeFrom((f.a) this.v);
                                            this.v = builder2.buildPartial();
                                            break;
                                        }
                                    case 186:
                                        a.C0000a.C0001a builder3 = this.w != null ? this.w.toBuilder() : null;
                                        this.w = (a.C0000a) codedInputStream.readMessage(a.C0000a.d(), extensionRegistryLite);
                                        if (builder3 == null) {
                                            break;
                                        } else {
                                            builder3.mergeFrom((a.C0000a.C0001a) this.w);
                                            this.w = builder3.buildPartial();
                                            break;
                                        }
                                    default:
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (y == null) {
                            synchronized (ab.class) {
                                if (y == null) {
                                    y = new GeneratedMessageLite.DefaultInstanceBasedParser(x);
                                }
                            }
                        }
                        return y;
                    default:
                        throw new UnsupportedOperationException();
                }
                return x;
            }

            static {
                x.makeImmutable();
            }

            public static Parser<ab> j() {
                return x.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$af */
        /* loaded from: classes.dex */
        public static final class af extends GeneratedMessageLite<af, a> implements ag {
            private static final af p = new af();
            private static volatile Parser<af> q;
            private int a;
            private int b;
            private int c;
            private int d;
            private float e;
            private float f;
            private float g;
            private float h;
            private float i;
            private float j;
            private float k;
            private float l;
            private int m;
            private float n;
            private ah o;

            private af() {
            }

            public ah a() {
                ah ahVar = this.o;
                return ahVar == null ? ah.a() : ahVar;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputStream.writeUInt32(2, i2);
                }
                int i3 = this.c;
                if (i3 != 0) {
                    codedOutputStream.writeSInt32(3, i3);
                }
                int i4 = this.d;
                if (i4 != 0) {
                    codedOutputStream.writeUInt32(4, i4);
                }
                float f = this.e;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(5, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(6, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(7, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    codedOutputStream.writeFloat(8, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    codedOutputStream.writeFloat(9, f5);
                }
                float f6 = this.j;
                if (f6 != 0.0f) {
                    codedOutputStream.writeFloat(10, f6);
                }
                float f7 = this.k;
                if (f7 != 0.0f) {
                    codedOutputStream.writeFloat(11, f7);
                }
                float f8 = this.l;
                if (f8 != 0.0f) {
                    codedOutputStream.writeFloat(12, f8);
                }
                int i5 = this.m;
                if (i5 != 0) {
                    codedOutputStream.writeInt32(13, i5);
                }
                float f9 = this.n;
                if (f9 != 0.0f) {
                    codedOutputStream.writeFloat(14, f9);
                }
                if (this.o != null) {
                    codedOutputStream.writeMessage(15, a());
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeUInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeUInt32Size(1, i2) : 0;
                int i3 = this.b;
                if (i3 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(2, i3);
                }
                int i4 = this.c;
                if (i4 != 0) {
                    computeUInt32Size += CodedOutputStream.computeSInt32Size(3, i4);
                }
                int i5 = this.d;
                if (i5 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(4, i5);
                }
                float f = this.e;
                if (f != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(5, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(6, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(7, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(8, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(9, f5);
                }
                float f6 = this.j;
                if (f6 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(10, f6);
                }
                float f7 = this.k;
                if (f7 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(11, f7);
                }
                float f8 = this.l;
                if (f8 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(12, f8);
                }
                int i6 = this.m;
                if (i6 != 0) {
                    computeUInt32Size += CodedOutputStream.computeInt32Size(13, i6);
                }
                float f9 = this.n;
                if (f9 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(14, f9);
                }
                if (this.o != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(15, a());
                }
                this.memoizedSerializedSize = computeUInt32Size;
                return computeUInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$af$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<af, a> implements ag {
                private a() {
                    super(af.p);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new af();
                    case IS_INITIALIZED:
                        return p;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        af afVar = (af) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, afVar.a != 0, afVar.a);
                        this.b = visitor.visitInt(this.b != 0, this.b, afVar.b != 0, afVar.b);
                        this.c = visitor.visitInt(this.c != 0, this.c, afVar.c != 0, afVar.c);
                        this.d = visitor.visitInt(this.d != 0, this.d, afVar.d != 0, afVar.d);
                        this.e = visitor.visitFloat(this.e != 0.0f, this.e, afVar.e != 0.0f, afVar.e);
                        this.f = visitor.visitFloat(this.f != 0.0f, this.f, afVar.f != 0.0f, afVar.f);
                        this.g = visitor.visitFloat(this.g != 0.0f, this.g, afVar.g != 0.0f, afVar.g);
                        this.h = visitor.visitFloat(this.h != 0.0f, this.h, afVar.h != 0.0f, afVar.h);
                        this.i = visitor.visitFloat(this.i != 0.0f, this.i, afVar.i != 0.0f, afVar.i);
                        this.j = visitor.visitFloat(this.j != 0.0f, this.j, afVar.j != 0.0f, afVar.j);
                        this.k = visitor.visitFloat(this.k != 0.0f, this.k, afVar.k != 0.0f, afVar.k);
                        this.l = visitor.visitFloat(this.l != 0.0f, this.l, afVar.l != 0.0f, afVar.l);
                        this.m = visitor.visitInt(this.m != 0, this.m, afVar.m != 0, afVar.m);
                        this.n = visitor.visitFloat(this.n != 0.0f, this.n, afVar.n != 0.0f, afVar.n);
                        this.o = (ah) visitor.visitMessage(this.o, afVar.o);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        r1 = true;
                                        break;
                                    case 8:
                                        this.a = codedInputStream.readUInt32();
                                        break;
                                    case 16:
                                        this.b = codedInputStream.readUInt32();
                                        break;
                                    case 24:
                                        this.c = codedInputStream.readSInt32();
                                        break;
                                    case 32:
                                        this.d = codedInputStream.readUInt32();
                                        break;
                                    case 45:
                                        this.e = codedInputStream.readFloat();
                                        break;
                                    case 53:
                                        this.f = codedInputStream.readFloat();
                                        break;
                                    case 61:
                                        this.g = codedInputStream.readFloat();
                                        break;
                                    case 69:
                                        this.h = codedInputStream.readFloat();
                                        break;
                                    case 77:
                                        this.i = codedInputStream.readFloat();
                                        break;
                                    case 85:
                                        this.j = codedInputStream.readFloat();
                                        break;
                                    case 93:
                                        this.k = codedInputStream.readFloat();
                                        break;
                                    case 101:
                                        this.l = codedInputStream.readFloat();
                                        break;
                                    case 104:
                                        this.m = codedInputStream.readInt32();
                                        break;
                                    case 117:
                                        this.n = codedInputStream.readFloat();
                                        break;
                                    case 122:
                                        ah.a builder = this.o != null ? this.o.toBuilder() : null;
                                        this.o = (ah) codedInputStream.readMessage(ah.b(), extensionRegistryLite);
                                        if (builder == null) {
                                            break;
                                        } else {
                                            builder.mergeFrom((ah.a) this.o);
                                            this.o = builder.buildPartial();
                                            break;
                                        }
                                    default:
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (q == null) {
                            synchronized (af.class) {
                                if (q == null) {
                                    q = new GeneratedMessageLite.DefaultInstanceBasedParser(p);
                                }
                            }
                        }
                        return q;
                    default:
                        throw new UnsupportedOperationException();
                }
                return p;
            }

            static {
                p.makeImmutable();
            }

            public static Parser<af> b() {
                return p.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$r */
        /* loaded from: classes.dex */
        public static final class r extends GeneratedMessageLite<r, a> implements s {
            private static final r c = new r();
            private static volatile Parser<r> d;
            private int a;
            private long b;

            private r() {
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                long j = this.b;
                if (j != 0) {
                    codedOutputStream.writeInt64(2, j);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeUInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeUInt32Size(1, i2) : 0;
                long j = this.b;
                if (j != 0) {
                    computeUInt32Size += CodedOutputStream.computeInt64Size(2, j);
                }
                this.memoizedSerializedSize = computeUInt32Size;
                return computeUInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$r$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<r, a> implements s {
                private a() {
                    super(r.c);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new r();
                    case IS_INITIALIZED:
                        return c;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        r rVar = (r) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, rVar.a != 0, rVar.a);
                        this.b = visitor.visitLong(this.b != 0, this.b, rVar.b != 0, rVar.b);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag == 0) {
                                    z = true;
                                } else if (readTag == 8) {
                                    this.a = codedInputStream.readUInt32();
                                } else if (readTag != 16) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        z = true;
                                    }
                                } else {
                                    this.b = codedInputStream.readInt64();
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (d == null) {
                            synchronized (r.class) {
                                if (d == null) {
                                    d = new GeneratedMessageLite.DefaultInstanceBasedParser(c);
                                }
                            }
                        }
                        return d;
                    default:
                        throw new UnsupportedOperationException();
                }
                return c;
            }

            static {
                c.makeImmutable();
            }

            public static r a() {
                return c;
            }

            public static Parser<r> b() {
                return c.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$aj */
        /* loaded from: classes.dex */
        public static final class aj extends GeneratedMessageLite<aj, a> implements ak {
            private static final aj l = new aj();
            private static volatile Parser<aj> m;
            private int a;
            private int b;
            private double c;
            private double d;
            private double e;
            private double f;
            private double g;
            private double h;
            private int i;
            private ah j;
            private r k;

            private aj() {
            }

            public int a() {
                return this.a;
            }

            public ah b() {
                ah ahVar = this.j;
                return ahVar == null ? ah.a() : ahVar;
            }

            public r c() {
                r rVar = this.k;
                return rVar == null ? r.a() : rVar;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputStream.writeSInt32(2, i2);
                }
                double d = this.c;
                if (d != 0.0d) {
                    codedOutputStream.writeDouble(3, d);
                }
                double d2 = this.d;
                if (d2 != 0.0d) {
                    codedOutputStream.writeDouble(4, d2);
                }
                double d3 = this.e;
                if (d3 != 0.0d) {
                    codedOutputStream.writeDouble(5, d3);
                }
                double d4 = this.f;
                if (d4 != 0.0d) {
                    codedOutputStream.writeDouble(6, d4);
                }
                double d5 = this.g;
                if (d5 != 0.0d) {
                    codedOutputStream.writeDouble(7, d5);
                }
                double d6 = this.h;
                if (d6 != 0.0d) {
                    codedOutputStream.writeDouble(8, d6);
                }
                int i3 = this.i;
                if (i3 != 0) {
                    codedOutputStream.writeUInt32(9, i3);
                }
                if (this.j != null) {
                    codedOutputStream.writeMessage(10, b());
                }
                if (this.k != null) {
                    codedOutputStream.writeMessage(11, c());
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeUInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeUInt32Size(1, i2) : 0;
                int i3 = this.b;
                if (i3 != 0) {
                    computeUInt32Size += CodedOutputStream.computeSInt32Size(2, i3);
                }
                double d = this.c;
                if (d != 0.0d) {
                    computeUInt32Size += CodedOutputStream.computeDoubleSize(3, d);
                }
                double d2 = this.d;
                if (d2 != 0.0d) {
                    computeUInt32Size += CodedOutputStream.computeDoubleSize(4, d2);
                }
                double d3 = this.e;
                if (d3 != 0.0d) {
                    computeUInt32Size += CodedOutputStream.computeDoubleSize(5, d3);
                }
                double d4 = this.f;
                if (d4 != 0.0d) {
                    computeUInt32Size += CodedOutputStream.computeDoubleSize(6, d4);
                }
                double d5 = this.g;
                if (d5 != 0.0d) {
                    computeUInt32Size += CodedOutputStream.computeDoubleSize(7, d5);
                }
                double d6 = this.h;
                if (d6 != 0.0d) {
                    computeUInt32Size += CodedOutputStream.computeDoubleSize(8, d6);
                }
                int i4 = this.i;
                if (i4 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(9, i4);
                }
                if (this.j != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(10, b());
                }
                if (this.k != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(11, c());
                }
                this.memoizedSerializedSize = computeUInt32Size;
                return computeUInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$aj$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<aj, a> implements ak {
                private a() {
                    super(aj.l);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new aj();
                    case IS_INITIALIZED:
                        return l;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        aj ajVar = (aj) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, ajVar.a != 0, ajVar.a);
                        this.b = visitor.visitInt(this.b != 0, this.b, ajVar.b != 0, ajVar.b);
                        this.c = visitor.visitDouble(this.c != 0.0d, this.c, ajVar.c != 0.0d, ajVar.c);
                        this.d = visitor.visitDouble(this.d != 0.0d, this.d, ajVar.d != 0.0d, ajVar.d);
                        this.e = visitor.visitDouble(this.e != 0.0d, this.e, ajVar.e != 0.0d, ajVar.e);
                        this.f = visitor.visitDouble(this.f != 0.0d, this.f, ajVar.f != 0.0d, ajVar.f);
                        this.g = visitor.visitDouble(this.g != 0.0d, this.g, ajVar.g != 0.0d, ajVar.g);
                        this.h = visitor.visitDouble(this.h != 0.0d, this.h, ajVar.h != 0.0d, ajVar.h);
                        this.i = visitor.visitInt(this.i != 0, this.i, ajVar.i != 0, ajVar.i);
                        this.j = (ah) visitor.visitMessage(this.j, ajVar.j);
                        this.k = (r) visitor.visitMessage(this.k, ajVar.k);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                try {
                                    int readTag = codedInputStream.readTag();
                                    switch (readTag) {
                                        case 0:
                                            r1 = true;
                                            break;
                                        case 8:
                                            this.a = codedInputStream.readUInt32();
                                            break;
                                        case 16:
                                            this.b = codedInputStream.readSInt32();
                                            break;
                                        case 25:
                                            this.c = codedInputStream.readDouble();
                                            break;
                                        case 33:
                                            this.d = codedInputStream.readDouble();
                                            break;
                                        case 41:
                                            this.e = codedInputStream.readDouble();
                                            break;
                                        case 49:
                                            this.f = codedInputStream.readDouble();
                                            break;
                                        case 57:
                                            this.g = codedInputStream.readDouble();
                                            break;
                                        case 65:
                                            this.h = codedInputStream.readDouble();
                                            break;
                                        case 72:
                                            this.i = codedInputStream.readUInt32();
                                            break;
                                        case 82:
                                            ah.a builder = this.j != null ? this.j.toBuilder() : null;
                                            this.j = (ah) codedInputStream.readMessage(ah.b(), extensionRegistryLite);
                                            if (builder == null) {
                                                break;
                                            } else {
                                                builder.mergeFrom((ah.a) this.j);
                                                this.j = builder.buildPartial();
                                                break;
                                            }
                                        case 90:
                                            r.a builder2 = this.k != null ? this.k.toBuilder() : null;
                                            this.k = (r) codedInputStream.readMessage(r.b(), extensionRegistryLite);
                                            if (builder2 == null) {
                                                break;
                                            } else {
                                                builder2.mergeFrom((r.a) this.k);
                                                this.k = builder2.buildPartial();
                                                break;
                                            }
                                        default:
                                            if (!codedInputStream.skipField(readTag)) {
                                                r1 = true;
                                                break;
                                            } else {
                                                break;
                                            }
                                    }
                                } catch (IOException e) {
                                    throw new RuntimeException(new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this));
                                }
                            } catch (InvalidProtocolBufferException e2) {
                                throw new RuntimeException(e2.setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (m == null) {
                            synchronized (aj.class) {
                                if (m == null) {
                                    m = new GeneratedMessageLite.DefaultInstanceBasedParser(l);
                                }
                            }
                        }
                        return m;
                    default:
                        throw new UnsupportedOperationException();
                }
                return l;
            }

            static {
                l.makeImmutable();
            }

            public static aj d() {
                return l;
            }

            public static Parser<aj> e() {
                return l.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$t */
        /* loaded from: classes.dex */
        public static final class t extends GeneratedMessageLite<t, a> implements u {
            private static final t c = new t();
            private static volatile Parser<t> d;
            private int a;
            private int b;

            private t() {
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputStream.writeInt32(2, i2);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeUInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeUInt32Size(1, i2) : 0;
                int i3 = this.b;
                if (i3 != 0) {
                    computeUInt32Size += CodedOutputStream.computeInt32Size(2, i3);
                }
                this.memoizedSerializedSize = computeUInt32Size;
                return computeUInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$t$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<t, a> implements u {
                private a() {
                    super(t.c);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new t();
                    case IS_INITIALIZED:
                        return c;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        t tVar = (t) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, tVar.a != 0, tVar.a);
                        this.b = visitor.visitInt(this.b != 0, this.b, tVar.b != 0, tVar.b);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag == 0) {
                                    r1 = true;
                                } else if (readTag == 8) {
                                    this.a = codedInputStream.readUInt32();
                                } else if (readTag != 16) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                                } else {
                                    this.b = codedInputStream.readInt32();
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (d == null) {
                            synchronized (t.class) {
                                if (d == null) {
                                    d = new GeneratedMessageLite.DefaultInstanceBasedParser(c);
                                }
                            }
                        }
                        return d;
                    default:
                        throw new UnsupportedOperationException();
                }
                return c;
            }

            static {
                c.makeImmutable();
            }

            public static Parser<t> a() {
                return c.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$ad */
        /* loaded from: classes.dex */
        public static final class ad extends GeneratedMessageLite<ad, a> implements ae {
            private static final ad f = new ad();
            private static volatile Parser<ad> g;
            private float a;
            private float b;
            private float c;
            private float d;
            private int e;

            private ad() {
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                float f2 = this.a;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(1, f2);
                }
                float f3 = this.b;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(2, f3);
                }
                float f4 = this.c;
                if (f4 != 0.0f) {
                    codedOutputStream.writeFloat(3, f4);
                }
                float f5 = this.d;
                if (f5 != 0.0f) {
                    codedOutputStream.writeFloat(4, f5);
                }
                int i = this.e;
                if (i != 0) {
                    codedOutputStream.writeUInt32(5, i);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                float f2 = this.a;
                int computeFloatSize = f2 != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f2) : 0;
                float f3 = this.b;
                if (f3 != 0.0f) {
                    computeFloatSize += CodedOutputStream.computeFloatSize(2, f3);
                }
                float f4 = this.c;
                if (f4 != 0.0f) {
                    computeFloatSize += CodedOutputStream.computeFloatSize(3, f4);
                }
                float f5 = this.d;
                if (f5 != 0.0f) {
                    computeFloatSize += CodedOutputStream.computeFloatSize(4, f5);
                }
                int i2 = this.e;
                if (i2 != 0) {
                    computeFloatSize += CodedOutputStream.computeUInt32Size(5, i2);
                }
                this.memoizedSerializedSize = computeFloatSize;
                return computeFloatSize;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$ad$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<ad, a> implements ae {
                private a() {
                    super(ad.f);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new ad();
                    case IS_INITIALIZED:
                        return f;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        ad adVar = (ad) obj2;
                        this.a = visitor.visitFloat(this.a != 0.0f, this.a, adVar.a != 0.0f, adVar.a);
                        this.b = visitor.visitFloat(this.b != 0.0f, this.b, adVar.b != 0.0f, adVar.b);
                        this.c = visitor.visitFloat(this.c != 0.0f, this.c, adVar.c != 0.0f, adVar.c);
                        this.d = visitor.visitFloat(this.d != 0.0f, this.d, adVar.d != 0.0f, adVar.d);
                        this.e = visitor.visitInt(this.e != 0, this.e, adVar.e != 0, adVar.e);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag == 0) {
                                    r1 = true;
                                } else if (readTag == 13) {
                                    this.a = codedInputStream.readFloat();
                                } else if (readTag == 21) {
                                    this.b = codedInputStream.readFloat();
                                } else if (readTag == 29) {
                                    this.c = codedInputStream.readFloat();
                                } else if (readTag == 37) {
                                    this.d = codedInputStream.readFloat();
                                } else if (readTag != 40) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                                } else {
                                    this.e = codedInputStream.readUInt32();
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (g == null) {
                            synchronized (ad.class) {
                                if (g == null) {
                                    g = new GeneratedMessageLite.DefaultInstanceBasedParser(f);
                                }
                            }
                        }
                        return g;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f;
            }

            static {
                f.makeImmutable();
            }

            public static ad a() {
                return f;
            }

            public static Parser<ad> b() {
                return f.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$p */
        /* loaded from: classes.dex */
        public static final class p extends GeneratedMessageLite<p, a> implements q {
            private static final p p = new p();
            private static volatile Parser<p> q;
            private int a;
            private int b;
            private int c;
            private int d;
            private float e;
            private float f;
            private float g;
            private float h;
            private float i;
            private float j;
            private float k;
            private float l;
            private int m;
            private float n;
            private ah o;

            private p() {
            }

            public ah a() {
                ah ahVar = this.o;
                return ahVar == null ? ah.a() : ahVar;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputStream.writeUInt32(2, i2);
                }
                int i3 = this.c;
                if (i3 != 0) {
                    codedOutputStream.writeSInt32(3, i3);
                }
                int i4 = this.d;
                if (i4 != 0) {
                    codedOutputStream.writeUInt32(4, i4);
                }
                float f = this.e;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(5, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(6, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(7, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    codedOutputStream.writeFloat(8, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    codedOutputStream.writeFloat(9, f5);
                }
                float f6 = this.j;
                if (f6 != 0.0f) {
                    codedOutputStream.writeFloat(10, f6);
                }
                float f7 = this.k;
                if (f7 != 0.0f) {
                    codedOutputStream.writeFloat(11, f7);
                }
                float f8 = this.l;
                if (f8 != 0.0f) {
                    codedOutputStream.writeFloat(12, f8);
                }
                int i5 = this.m;
                if (i5 != 0) {
                    codedOutputStream.writeInt32(13, i5);
                }
                float f9 = this.n;
                if (f9 != 0.0f) {
                    codedOutputStream.writeFloat(14, f9);
                }
                if (this.o != null) {
                    codedOutputStream.writeMessage(15, a());
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeUInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeUInt32Size(1, i2) : 0;
                int i3 = this.b;
                if (i3 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(2, i3);
                }
                int i4 = this.c;
                if (i4 != 0) {
                    computeUInt32Size += CodedOutputStream.computeSInt32Size(3, i4);
                }
                int i5 = this.d;
                if (i5 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(4, i5);
                }
                float f = this.e;
                if (f != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(5, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(6, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(7, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(8, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(9, f5);
                }
                float f6 = this.j;
                if (f6 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(10, f6);
                }
                float f7 = this.k;
                if (f7 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(11, f7);
                }
                float f8 = this.l;
                if (f8 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(12, f8);
                }
                int i6 = this.m;
                if (i6 != 0) {
                    computeUInt32Size += CodedOutputStream.computeInt32Size(13, i6);
                }
                float f9 = this.n;
                if (f9 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(14, f9);
                }
                if (this.o != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(15, a());
                }
                this.memoizedSerializedSize = computeUInt32Size;
                return computeUInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$p$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<p, a> implements q {
                private a() {
                    super(p.p);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new p();
                    case IS_INITIALIZED:
                        return p;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        p pVar = (p) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, pVar.a != 0, pVar.a);
                        this.b = visitor.visitInt(this.b != 0, this.b, pVar.b != 0, pVar.b);
                        this.c = visitor.visitInt(this.c != 0, this.c, pVar.c != 0, pVar.c);
                        this.d = visitor.visitInt(this.d != 0, this.d, pVar.d != 0, pVar.d);
                        this.e = visitor.visitFloat(this.e != 0.0f, this.e, pVar.e != 0.0f, pVar.e);
                        this.f = visitor.visitFloat(this.f != 0.0f, this.f, pVar.f != 0.0f, pVar.f);
                        this.g = visitor.visitFloat(this.g != 0.0f, this.g, pVar.g != 0.0f, pVar.g);
                        this.h = visitor.visitFloat(this.h != 0.0f, this.h, pVar.h != 0.0f, pVar.h);
                        this.i = visitor.visitFloat(this.i != 0.0f, this.i, pVar.i != 0.0f, pVar.i);
                        this.j = visitor.visitFloat(this.j != 0.0f, this.j, pVar.j != 0.0f, pVar.j);
                        this.k = visitor.visitFloat(this.k != 0.0f, this.k, pVar.k != 0.0f, pVar.k);
                        this.l = visitor.visitFloat(this.l != 0.0f, this.l, pVar.l != 0.0f, pVar.l);
                        this.m = visitor.visitInt(this.m != 0, this.m, pVar.m != 0, pVar.m);
                        this.n = visitor.visitFloat(this.n != 0.0f, this.n, pVar.n != 0.0f, pVar.n);
                        this.o = (ah) visitor.visitMessage(this.o, pVar.o);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        r1 = true;
                                        break;
                                    case 8:
                                        this.a = codedInputStream.readUInt32();
                                        break;
                                    case 16:
                                        this.b = codedInputStream.readUInt32();
                                        break;
                                    case 24:
                                        this.c = codedInputStream.readSInt32();
                                        break;
                                    case 32:
                                        this.d = codedInputStream.readUInt32();
                                        break;
                                    case 45:
                                        this.e = codedInputStream.readFloat();
                                        break;
                                    case 53:
                                        this.f = codedInputStream.readFloat();
                                        break;
                                    case 61:
                                        this.g = codedInputStream.readFloat();
                                        break;
                                    case 69:
                                        this.h = codedInputStream.readFloat();
                                        break;
                                    case 77:
                                        this.i = codedInputStream.readFloat();
                                        break;
                                    case 85:
                                        this.j = codedInputStream.readFloat();
                                        break;
                                    case 93:
                                        this.k = codedInputStream.readFloat();
                                        break;
                                    case 101:
                                        this.l = codedInputStream.readFloat();
                                        break;
                                    case 104:
                                        this.m = codedInputStream.readInt32();
                                        break;
                                    case 117:
                                        this.n = codedInputStream.readFloat();
                                        break;
                                    case 122:
                                        ah.a builder = this.o != null ? this.o.toBuilder() : null;
                                        this.o = (ah) codedInputStream.readMessage(ah.b(), extensionRegistryLite);
                                        if (builder == null) {
                                            break;
                                        } else {
                                            builder.mergeFrom((ah.a) this.o);
                                            this.o = builder.buildPartial();
                                            break;
                                        }
                                    default:
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (q == null) {
                            synchronized (p.class) {
                                if (q == null) {
                                    q = new GeneratedMessageLite.DefaultInstanceBasedParser(p);
                                }
                            }
                        }
                        return q;
                    default:
                        throw new UnsupportedOperationException();
                }
                return p;
            }

            static {
                p.makeImmutable();
            }

            public static Parser<p> b() {
                return p.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$v */
        /* loaded from: classes.dex */
        public static final class v extends GeneratedMessageLite<v, a> implements w {
            private static final v k = new v();
            private static volatile Parser<v> l;
            private int a;
            private int c;
            private int d;
            private int h;
            private float i;
            private boolean j;
            private Internal.ProtobufList<al> b = emptyProtobufList();
            private Internal.IntList e = emptyIntList();
            private Internal.IntList f = emptyIntList();
            private Internal.IntList g = emptyIntList();

            private v() {
            }

            public List<al> a() {
                return this.b;
            }

            public List<Integer> b() {
                return this.e;
            }

            public List<Integer> c() {
                return this.f;
            }

            public List<Integer> d() {
                return this.g;
            }

            public boolean e() {
                return this.j;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                for (int i = 0; i < this.b.size(); i++) {
                    codedOutputStream.writeMessage(1, this.b.get(i));
                }
                int i2 = this.c;
                if (i2 != 0) {
                    codedOutputStream.writeUInt32(2, i2);
                }
                int i3 = this.d;
                if (i3 != 0) {
                    codedOutputStream.writeUInt32(3, i3);
                }
                for (int i4 = 0; i4 < this.e.size(); i4++) {
                    codedOutputStream.writeUInt32(4, this.e.getInt(i4));
                }
                for (int i5 = 0; i5 < this.f.size(); i5++) {
                    codedOutputStream.writeUInt32(5, this.f.getInt(i5));
                }
                for (int i6 = 0; i6 < this.g.size(); i6++) {
                    codedOutputStream.writeUInt32(6, this.g.getInt(i6));
                }
                int i7 = this.h;
                if (i7 != 0) {
                    codedOutputStream.writeUInt32(7, i7);
                }
                float f = this.i;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(8, f);
                }
                boolean z = this.j;
                if (z) {
                    codedOutputStream.writeBool(9, z);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.b.size(); i3++) {
                    i2 += CodedOutputStream.computeMessageSize(1, this.b.get(i3));
                }
                int i4 = this.c;
                if (i4 != 0) {
                    i2 += CodedOutputStream.computeUInt32Size(2, i4);
                }
                int i5 = this.d;
                if (i5 != 0) {
                    i2 += CodedOutputStream.computeUInt32Size(3, i5);
                }
                int i6 = 0;
                for (int i7 = 0; i7 < this.e.size(); i7++) {
                    i6 += CodedOutputStream.computeUInt32SizeNoTag(this.e.getInt(i7));
                }
                int size = i2 + i6 + (b().size() * 1);
                int i8 = 0;
                for (int i9 = 0; i9 < this.f.size(); i9++) {
                    i8 += CodedOutputStream.computeUInt32SizeNoTag(this.f.getInt(i9));
                }
                int size2 = size + i8 + (c().size() * 1);
                int i10 = 0;
                for (int i11 = 0; i11 < this.g.size(); i11++) {
                    i10 += CodedOutputStream.computeUInt32SizeNoTag(this.g.getInt(i11));
                }
                int size3 = size2 + i10 + (d().size() * 1);
                int i12 = this.h;
                if (i12 != 0) {
                    size3 += CodedOutputStream.computeUInt32Size(7, i12);
                }
                float f = this.i;
                if (f != 0.0f) {
                    size3 += CodedOutputStream.computeFloatSize(8, f);
                }
                boolean z = this.j;
                if (z) {
                    size3 += CodedOutputStream.computeBoolSize(9, z);
                }
                this.memoizedSerializedSize = size3;
                return size3;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$v$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<v, a> implements w {
                private a() {
                    super(v.k);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new v();
                    case IS_INITIALIZED:
                        return k;
                    case MAKE_IMMUTABLE:
                        this.b.makeImmutable();
                        this.e.makeImmutable();
                        this.f.makeImmutable();
                        this.g.makeImmutable();
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        v vVar = (v) obj2;
                        this.b = visitor.visitList(this.b, vVar.b);
                        this.c = visitor.visitInt(this.c != 0, this.c, vVar.c != 0, vVar.c);
                        this.d = visitor.visitInt(this.d != 0, this.d, vVar.d != 0, vVar.d);
                        this.e = visitor.visitIntList(this.e, vVar.e);
                        this.f = visitor.visitIntList(this.f, vVar.f);
                        this.g = visitor.visitIntList(this.g, vVar.g);
                        this.h = visitor.visitInt(this.h != 0, this.h, vVar.h != 0, vVar.h);
                        this.i = visitor.visitFloat(this.i != 0.0f, this.i, vVar.i != 0.0f, vVar.i);
                        boolean z = this.j;
                        boolean z2 = vVar.j;
                        this.j = visitor.visitBoolean(z, z, z2, z2);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.a |= vVar.a;
                        }
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        r1 = true;
                                        break;
                                    case 10:
                                        if (!this.b.isModifiable()) {
                                            this.b = GeneratedMessageLite.mutableCopy(this.b);
                                        }
                                        this.b.add(codedInputStream.readMessage(al.d(), extensionRegistryLite));
                                        break;
                                    case 16:
                                        this.c = codedInputStream.readUInt32();
                                        break;
                                    case 24:
                                        this.d = codedInputStream.readUInt32();
                                        break;
                                    case 32:
                                        if (!this.e.isModifiable()) {
                                            this.e = GeneratedMessageLite.mutableCopy(this.e);
                                        }
                                        this.e.addInt(codedInputStream.readUInt32());
                                        break;
                                    case 34:
                                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!this.e.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.e = GeneratedMessageLite.mutableCopy(this.e);
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.e.addInt(codedInputStream.readUInt32());
                                        }
                                        codedInputStream.popLimit(pushLimit);
                                        break;
                                    case 40:
                                        if (!this.f.isModifiable()) {
                                            this.f = GeneratedMessageLite.mutableCopy(this.f);
                                        }
                                        this.f.addInt(codedInputStream.readUInt32());
                                        break;
                                    case 42:
                                        int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!this.f.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.f = GeneratedMessageLite.mutableCopy(this.f);
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.f.addInt(codedInputStream.readUInt32());
                                        }
                                        codedInputStream.popLimit(pushLimit2);
                                        break;
                                    case 48:
                                        if (!this.g.isModifiable()) {
                                            this.g = GeneratedMessageLite.mutableCopy(this.g);
                                        }
                                        this.g.addInt(codedInputStream.readUInt32());
                                        break;
                                    case 50:
                                        int pushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!this.g.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.g = GeneratedMessageLite.mutableCopy(this.g);
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.g.addInt(codedInputStream.readUInt32());
                                        }
                                        codedInputStream.popLimit(pushLimit3);
                                        break;
                                    case 56:
                                        this.h = codedInputStream.readUInt32();
                                        break;
                                    case 69:
                                        this.i = codedInputStream.readFloat();
                                        break;
                                    case 72:
                                        this.j = codedInputStream.readBool();
                                        break;
                                    default:
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (l == null) {
                            synchronized (v.class) {
                                if (l == null) {
                                    l = new GeneratedMessageLite.DefaultInstanceBasedParser(k);
                                }
                            }
                        }
                        return l;
                    default:
                        throw new UnsupportedOperationException();
                }
                return k;
            }

            static {
                k.makeImmutable();
            }

            public static Parser<v> f() {
                return k.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$l */
        /* loaded from: classes.dex */
        public static final class l extends GeneratedMessageLite<l, a> implements m {
            private static final l o = new l();
            private static volatile Parser<l> p;
            private int a;
            private int b;
            private Internal.ProtobufList<t> c = emptyProtobufList();
            private int d;
            private float e;
            private float f;
            private float g;
            private float h;
            private float i;
            private float j;
            private ad k;
            private ah l;
            private int m;
            private int n;

            private l() {
            }

            public ad a() {
                ad adVar = this.k;
                return adVar == null ? ad.a() : adVar;
            }

            public ah b() {
                ah ahVar = this.l;
                return ahVar == null ? ah.a() : ahVar;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.b;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    codedOutputStream.writeMessage(2, this.c.get(i2));
                }
                int i3 = this.d;
                if (i3 != 0) {
                    codedOutputStream.writeUInt32(3, i3);
                }
                float f = this.e;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(4, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(5, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(6, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    codedOutputStream.writeFloat(7, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    codedOutputStream.writeFloat(8, f5);
                }
                float f6 = this.j;
                if (f6 != 0.0f) {
                    codedOutputStream.writeFloat(9, f6);
                }
                if (this.k != null) {
                    codedOutputStream.writeMessage(10, a());
                }
                if (this.l != null) {
                    codedOutputStream.writeMessage(11, b());
                }
                int i4 = this.m;
                if (i4 != 0) {
                    codedOutputStream.writeUInt32(12, i4);
                }
                int i5 = this.n;
                if (i5 != 0) {
                    codedOutputStream.writeUInt32(13, i5);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.b;
                int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
                for (int i3 = 0; i3 < this.c.size(); i3++) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(2, this.c.get(i3));
                }
                int i4 = this.d;
                if (i4 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(3, i4);
                }
                float f = this.e;
                if (f != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(4, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(5, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(6, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(7, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(8, f5);
                }
                float f6 = this.j;
                if (f6 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(9, f6);
                }
                if (this.k != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(10, a());
                }
                if (this.l != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(11, b());
                }
                int i5 = this.m;
                if (i5 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(12, i5);
                }
                int i6 = this.n;
                if (i6 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(13, i6);
                }
                this.memoizedSerializedSize = computeUInt32Size;
                return computeUInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$l$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<l, a> implements m {
                private a() {
                    super(l.o);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new l();
                    case IS_INITIALIZED:
                        return o;
                    case MAKE_IMMUTABLE:
                        this.c.makeImmutable();
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        l lVar = (l) obj2;
                        this.b = visitor.visitInt(this.b != 0, this.b, lVar.b != 0, lVar.b);
                        this.c = visitor.visitList(this.c, lVar.c);
                        this.d = visitor.visitInt(this.d != 0, this.d, lVar.d != 0, lVar.d);
                        this.e = visitor.visitFloat(this.e != 0.0f, this.e, lVar.e != 0.0f, lVar.e);
                        this.f = visitor.visitFloat(this.f != 0.0f, this.f, lVar.f != 0.0f, lVar.f);
                        this.g = visitor.visitFloat(this.g != 0.0f, this.g, lVar.g != 0.0f, lVar.g);
                        this.h = visitor.visitFloat(this.h != 0.0f, this.h, lVar.h != 0.0f, lVar.h);
                        this.i = visitor.visitFloat(this.i != 0.0f, this.i, lVar.i != 0.0f, lVar.i);
                        this.j = visitor.visitFloat(this.j != 0.0f, this.j, lVar.j != 0.0f, lVar.j);
                        this.k = (ad) visitor.visitMessage(this.k, lVar.k);
                        this.l = (ah) visitor.visitMessage(this.l, lVar.l);
                        this.m = visitor.visitInt(this.m != 0, this.m, lVar.m != 0, lVar.m);
                        this.n = visitor.visitInt(this.n != 0, this.n, lVar.n != 0, lVar.n);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.a |= lVar.a;
                        }
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        r1 = true;
                                        break;
                                    case 8:
                                        this.b = codedInputStream.readUInt32();
                                        break;
                                    case 18:
                                        if (!this.c.isModifiable()) {
                                            this.c = GeneratedMessageLite.mutableCopy(this.c);
                                        }
                                        this.c.add(codedInputStream.readMessage(t.a(), extensionRegistryLite));
                                        break;
                                    case 24:
                                        this.d = codedInputStream.readUInt32();
                                        break;
                                    case 37:
                                        this.e = codedInputStream.readFloat();
                                        break;
                                    case 45:
                                        this.f = codedInputStream.readFloat();
                                        break;
                                    case 53:
                                        this.g = codedInputStream.readFloat();
                                        break;
                                    case 61:
                                        this.h = codedInputStream.readFloat();
                                        break;
                                    case 69:
                                        this.i = codedInputStream.readFloat();
                                        break;
                                    case 77:
                                        this.j = codedInputStream.readFloat();
                                        break;
                                    case 82:
                                        ad.a builder = this.k != null ? this.k.toBuilder() : null;
                                        this.k = (ad) codedInputStream.readMessage(ad.b(), extensionRegistryLite);
                                        if (builder == null) {
                                            break;
                                        } else {
                                            builder.mergeFrom((ad.a) this.k);
                                            this.k = builder.buildPartial();
                                            break;
                                        }
                                    case 90:
                                        ah.a builder2 = this.l != null ? this.l.toBuilder() : null;
                                        this.l = (ah) codedInputStream.readMessage(ah.b(), extensionRegistryLite);
                                        if (builder2 == null) {
                                            break;
                                        } else {
                                            builder2.mergeFrom((ah.a) this.l);
                                            this.l = builder2.buildPartial();
                                            break;
                                        }
                                    case 96:
                                        this.m = codedInputStream.readUInt32();
                                        break;
                                    case 104:
                                        this.n = codedInputStream.readUInt32();
                                        break;
                                    default:
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (p == null) {
                            synchronized (l.class) {
                                if (p == null) {
                                    p = new GeneratedMessageLite.DefaultInstanceBasedParser(o);
                                }
                            }
                        }
                        return p;
                    default:
                        throw new UnsupportedOperationException();
                }
                return o;
            }

            static {
                o.makeImmutable();
            }

            public static Parser<l> c() {
                return o.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$n */
        /* loaded from: classes.dex */
        public static final class n extends GeneratedMessageLite<n, a> implements o {
            private static final n q = new n();
            private static volatile Parser<n> r;
            private int a;
            private int b;
            private int c;
            private int d;
            private float e;
            private float f;
            private float g;
            private float h;
            private float i;
            private int j;
            private int k;
            private float l;
            private ah m;
            private a.C0000a n;
            private x o;
            private x p;

            private n() {
            }

            public int a() {
                return this.c;
            }

            public float b() {
                return this.f;
            }

            public float c() {
                return this.g;
            }

            public float d() {
                return this.h;
            }

            public int e() {
                return this.j;
            }

            public float f() {
                return this.l;
            }

            public ah g() {
                ah ahVar = this.m;
                return ahVar == null ? ah.a() : ahVar;
            }

            public a.C0000a h() {
                a.C0000a c0000a = this.n;
                return c0000a == null ? a.C0000a.c() : c0000a;
            }

            public x i() {
                x xVar = this.o;
                return xVar == null ? x.a() : xVar;
            }

            public x j() {
                x xVar = this.p;
                return xVar == null ? x.a() : xVar;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputStream.writeUInt32(2, i2);
                }
                int i3 = this.c;
                if (i3 != 0) {
                    codedOutputStream.writeSInt32(3, i3);
                }
                int i4 = this.d;
                if (i4 != 0) {
                    codedOutputStream.writeUInt32(4, i4);
                }
                float f = this.e;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(5, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(6, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(7, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    codedOutputStream.writeFloat(8, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    codedOutputStream.writeFloat(9, f5);
                }
                int i5 = this.j;
                if (i5 != 0) {
                    codedOutputStream.writeSInt32(10, i5);
                }
                int i6 = this.k;
                if (i6 != 0) {
                    codedOutputStream.writeInt32(11, i6);
                }
                float f6 = this.l;
                if (f6 != 0.0f) {
                    codedOutputStream.writeFloat(12, f6);
                }
                if (this.m != null) {
                    codedOutputStream.writeMessage(13, g());
                }
                if (this.n != null) {
                    codedOutputStream.writeMessage(14, h());
                }
                if (this.o != null) {
                    codedOutputStream.writeMessage(15, i());
                }
                if (this.p != null) {
                    codedOutputStream.writeMessage(16, j());
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeUInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeUInt32Size(1, i2) : 0;
                int i3 = this.b;
                if (i3 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(2, i3);
                }
                int i4 = this.c;
                if (i4 != 0) {
                    computeUInt32Size += CodedOutputStream.computeSInt32Size(3, i4);
                }
                int i5 = this.d;
                if (i5 != 0) {
                    computeUInt32Size += CodedOutputStream.computeUInt32Size(4, i5);
                }
                float f = this.e;
                if (f != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(5, f);
                }
                float f2 = this.f;
                if (f2 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(6, f2);
                }
                float f3 = this.g;
                if (f3 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(7, f3);
                }
                float f4 = this.h;
                if (f4 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(8, f4);
                }
                float f5 = this.i;
                if (f5 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(9, f5);
                }
                int i6 = this.j;
                if (i6 != 0) {
                    computeUInt32Size += CodedOutputStream.computeSInt32Size(10, i6);
                }
                int i7 = this.k;
                if (i7 != 0) {
                    computeUInt32Size += CodedOutputStream.computeInt32Size(11, i7);
                }
                float f6 = this.l;
                if (f6 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(12, f6);
                }
                if (this.m != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(13, g());
                }
                if (this.n != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(14, h());
                }
                if (this.o != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(15, i());
                }
                if (this.p != null) {
                    computeUInt32Size += CodedOutputStream.computeMessageSize(16, j());
                }
                this.memoizedSerializedSize = computeUInt32Size;
                return computeUInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$n$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<n, a> implements o {
                private a() {
                    super(n.q);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new n();
                    case IS_INITIALIZED:
                        return q;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        n nVar = (n) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, nVar.a != 0, nVar.a);
                        this.b = visitor.visitInt(this.b != 0, this.b, nVar.b != 0, nVar.b);
                        this.c = visitor.visitInt(this.c != 0, this.c, nVar.c != 0, nVar.c);
                        this.d = visitor.visitInt(this.d != 0, this.d, nVar.d != 0, nVar.d);
                        this.e = visitor.visitFloat(this.e != 0.0f, this.e, nVar.e != 0.0f, nVar.e);
                        this.f = visitor.visitFloat(this.f != 0.0f, this.f, nVar.f != 0.0f, nVar.f);
                        this.g = visitor.visitFloat(this.g != 0.0f, this.g, nVar.g != 0.0f, nVar.g);
                        this.h = visitor.visitFloat(this.h != 0.0f, this.h, nVar.h != 0.0f, nVar.h);
                        this.i = visitor.visitFloat(this.i != 0.0f, this.i, nVar.i != 0.0f, nVar.i);
                        this.j = visitor.visitInt(this.j != 0, this.j, nVar.j != 0, nVar.j);
                        this.k = visitor.visitInt(this.k != 0, this.k, nVar.k != 0, nVar.k);
                        this.l = visitor.visitFloat(this.l != 0.0f, this.l, nVar.l != 0.0f, nVar.l);
                        this.m = (ah) visitor.visitMessage(this.m, nVar.m);
                        this.n = (a.C0000a) visitor.visitMessage(this.n, nVar.n);
                        this.o = (x) visitor.visitMessage(this.o, nVar.o);
                        this.p = (x) visitor.visitMessage(this.p, nVar.p);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        r1 = true;
                                        break;
                                    case 8:
                                        this.a = codedInputStream.readUInt32();
                                        break;
                                    case 16:
                                        this.b = codedInputStream.readUInt32();
                                        break;
                                    case 24:
                                        this.c = codedInputStream.readSInt32();
                                        break;
                                    case 32:
                                        this.d = codedInputStream.readUInt32();
                                        break;
                                    case 45:
                                        this.e = codedInputStream.readFloat();
                                        break;
                                    case 53:
                                        this.f = codedInputStream.readFloat();
                                        break;
                                    case 61:
                                        this.g = codedInputStream.readFloat();
                                        break;
                                    case 69:
                                        this.h = codedInputStream.readFloat();
                                        break;
                                    case 77:
                                        this.i = codedInputStream.readFloat();
                                        break;
                                    case 80:
                                        this.j = codedInputStream.readSInt32();
                                        break;
                                    case 88:
                                        this.k = codedInputStream.readInt32();
                                        break;
                                    case 101:
                                        this.l = codedInputStream.readFloat();
                                        break;
                                    case 106:
                                        ah.a builder = this.m != null ? this.m.toBuilder() : null;
                                        this.m = (ah) codedInputStream.readMessage(ah.b(), extensionRegistryLite);
                                        if (builder == null) {
                                            break;
                                        } else {
                                            builder.mergeFrom((ah.a) this.m);
                                            this.m = builder.buildPartial();
                                            break;
                                        }
                                    case 114:
                                        a.C0000a.C0001a builder2 = this.n != null ? this.n.toBuilder() : null;
                                        this.n = (a.C0000a) codedInputStream.readMessage(a.C0000a.d(), extensionRegistryLite);
                                        if (builder2 == null) {
                                            break;
                                        } else {
                                            builder2.mergeFrom((a.C0000a.C0001a) this.n);
                                            this.n = builder2.buildPartial();
                                            break;
                                        }
                                    case 122:
                                        x.a builder3 = this.o != null ? this.o.toBuilder() : null;
                                        this.o = (x) codedInputStream.readMessage(x.b(), extensionRegistryLite);
                                        if (builder3 == null) {
                                            break;
                                        } else {
                                            builder3.mergeFrom((x.a) this.o);
                                            this.o = builder3.buildPartial();
                                            break;
                                        }
                                    case 130:
                                        x.a builder4 = this.p != null ? this.p.toBuilder() : null;
                                        this.p = (x) codedInputStream.readMessage(x.b(), extensionRegistryLite);
                                        if (builder4 == null) {
                                            break;
                                        } else {
                                            builder4.mergeFrom((x.a) this.p);
                                            this.p = builder4.buildPartial();
                                            break;
                                        }
                                    default:
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (r == null) {
                            synchronized (n.class) {
                                if (r == null) {
                                    r = new GeneratedMessageLite.DefaultInstanceBasedParser(q);
                                }
                            }
                        }
                        return r;
                    default:
                        throw new UnsupportedOperationException();
                }
                return q;
            }

            static {
                q.makeImmutable();
            }

            public static Parser<n> k() {
                return q.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$x */
        /* loaded from: classes.dex */
        public static final class x extends GeneratedMessageLite<x, a> implements y {
            private static final x d = new x();
            private static volatile Parser<x> e;
            private float a;
            private float b;
            private float c;

            private x() {
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                float f = this.a;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(1, f);
                }
                float f2 = this.b;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(2, f2);
                }
                float f3 = this.c;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(3, f3);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                float f = this.a;
                int computeFloatSize = f != 0.0f ? 0 + CodedOutputStream.computeFloatSize(1, f) : 0;
                float f2 = this.b;
                if (f2 != 0.0f) {
                    computeFloatSize += CodedOutputStream.computeFloatSize(2, f2);
                }
                float f3 = this.c;
                if (f3 != 0.0f) {
                    computeFloatSize += CodedOutputStream.computeFloatSize(3, f3);
                }
                this.memoizedSerializedSize = computeFloatSize;
                return computeFloatSize;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$x$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<x, a> implements y {
                private a() {
                    super(x.d);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new x();
                    case IS_INITIALIZED:
                        return d;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        x xVar = (x) obj2;
                        this.a = visitor.visitFloat(this.a != 0.0f, this.a, xVar.a != 0.0f, xVar.a);
                        this.b = visitor.visitFloat(this.b != 0.0f, this.b, xVar.b != 0.0f, xVar.b);
                        this.c = visitor.visitFloat(this.c != 0.0f, this.c, xVar.c != 0.0f, xVar.c);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag == 0) {
                                    r1 = true;
                                } else if (readTag == 13) {
                                    this.a = codedInputStream.readFloat();
                                } else if (readTag == 21) {
                                    this.b = codedInputStream.readFloat();
                                } else if (readTag != 29) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                                } else {
                                    this.c = codedInputStream.readFloat();
                                }
                            } catch (InvalidProtocolBufferException e2) {
                                throw new RuntimeException(e2.setUnfinishedMessage(this));
                            } catch (IOException e3) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (e == null) {
                            synchronized (x.class) {
                                if (e == null) {
                                    e = new GeneratedMessageLite.DefaultInstanceBasedParser(d);
                                }
                            }
                        }
                        return e;
                    default:
                        throw new UnsupportedOperationException();
                }
                return d;
            }

            static {
                d.makeImmutable();
            }

            public static x a() {
                return d;
            }

            public static Parser<x> b() {
                return d.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$z */
        /* loaded from: classes.dex */
        public static final class z extends GeneratedMessageLite<z, a> implements aa {
            private static final z e = new z();
            private static volatile Parser<z> f;
            private int a;
            private float b;
            private float c;
            private float d;

            private z() {
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.a;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                float f2 = this.b;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(2, f2);
                }
                float f3 = this.c;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(3, f3);
                }
                float f4 = this.d;
                if (f4 != 0.0f) {
                    codedOutputStream.writeFloat(4, f4);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.a;
                int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
                float f2 = this.b;
                if (f2 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(2, f2);
                }
                float f3 = this.c;
                if (f3 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(3, f3);
                }
                float f4 = this.d;
                if (f4 != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(4, f4);
                }
                this.memoizedSerializedSize = computeInt32Size;
                return computeInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$z$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<z, a> implements aa {
                private a() {
                    super(z.e);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new z();
                    case IS_INITIALIZED:
                        return e;
                    case MAKE_IMMUTABLE:
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        z zVar = (z) obj2;
                        this.a = visitor.visitInt(this.a != 0, this.a, zVar.a != 0, zVar.a);
                        this.b = visitor.visitFloat(this.b != 0.0f, this.b, zVar.b != 0.0f, zVar.b);
                        this.c = visitor.visitFloat(this.c != 0.0f, this.c, zVar.c != 0.0f, zVar.c);
                        this.d = visitor.visitFloat(this.d != 0.0f, this.d, zVar.d != 0.0f, zVar.d);
                        GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag == 0) {
                                    r1 = true;
                                } else if (readTag == 8) {
                                    this.a = codedInputStream.readInt32();
                                } else if (readTag == 21) {
                                    this.b = codedInputStream.readFloat();
                                } else if (readTag == 29) {
                                    this.c = codedInputStream.readFloat();
                                } else if (readTag != 37) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                                } else {
                                    this.d = codedInputStream.readFloat();
                                }
                            } catch (InvalidProtocolBufferException e2) {
                                throw new RuntimeException(e2.setUnfinishedMessage(this));
                            } catch (IOException e3) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (f == null) {
                            synchronized (z.class) {
                                if (f == null) {
                                    f = new GeneratedMessageLite.DefaultInstanceBasedParser(e);
                                }
                            }
                        }
                        return f;
                    default:
                        throw new UnsupportedOperationException();
                }
                return e;
            }

            static {
                e.makeImmutable();
            }

            public static Parser<z> a() {
                return e.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$d */
        /* loaded from: classes.dex */
        public static final class d extends GeneratedMessageLite<d, a> implements e {
            private static final d h = new d();
            private static volatile Parser<d> i;
            private int a;
            private int b;
            private int c;
            private int d;
            private float e;
            private Internal.IntList f = emptyIntList();
            private int g;

            private d() {
            }

            public List<Integer> a() {
                return this.f;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputStream.writeInt32(1, i2);
                }
                int i3 = this.c;
                if (i3 != 0) {
                    codedOutputStream.writeInt32(2, i3);
                }
                int i4 = this.d;
                if (i4 != 0) {
                    codedOutputStream.writeInt32(3, i4);
                }
                float f = this.e;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(4, f);
                }
                for (int i5 = 0; i5 < this.f.size(); i5++) {
                    codedOutputStream.writeInt32(5, this.f.getInt(i5));
                }
                int i6 = this.g;
                if (i6 != 0) {
                    codedOutputStream.writeInt32(6, i6);
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i2 = this.memoizedSerializedSize;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = this.b;
                int computeInt32Size = i3 != 0 ? CodedOutputStream.computeInt32Size(1, i3) + 0 : 0;
                int i4 = this.c;
                if (i4 != 0) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, i4);
                }
                int i5 = this.d;
                if (i5 != 0) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(3, i5);
                }
                float f = this.e;
                if (f != 0.0f) {
                    computeInt32Size += CodedOutputStream.computeFloatSize(4, f);
                }
                int i6 = 0;
                for (int i7 = 0; i7 < this.f.size(); i7++) {
                    i6 += CodedOutputStream.computeInt32SizeNoTag(this.f.getInt(i7));
                }
                int size = computeInt32Size + i6 + (a().size() * 1);
                int i8 = this.g;
                if (i8 != 0) {
                    size += CodedOutputStream.computeInt32Size(6, i8);
                }
                this.memoizedSerializedSize = size;
                return size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$d$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<d, a> implements e {
                private a() {
                    super(d.h);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new d();
                    case IS_INITIALIZED:
                        return h;
                    case MAKE_IMMUTABLE:
                        this.f.makeImmutable();
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        d dVar = (d) obj2;
                        this.b = visitor.visitInt(this.b != 0, this.b, dVar.b != 0, dVar.b);
                        this.c = visitor.visitInt(this.c != 0, this.c, dVar.c != 0, dVar.c);
                        this.d = visitor.visitInt(this.d != 0, this.d, dVar.d != 0, dVar.d);
                        this.e = visitor.visitFloat(this.e != 0.0f, this.e, dVar.e != 0.0f, dVar.e);
                        this.f = visitor.visitIntList(this.f, dVar.f);
                        this.g = visitor.visitInt(this.g != 0, this.g, dVar.g != 0, dVar.g);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.a |= dVar.a;
                        }
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag == 0) {
                                    r1 = true;
                                } else if (readTag == 8) {
                                    this.b = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.c = codedInputStream.readInt32();
                                } else if (readTag == 24) {
                                    this.d = codedInputStream.readInt32();
                                } else if (readTag == 37) {
                                    this.e = codedInputStream.readFloat();
                                } else if (readTag == 40) {
                                    if (!this.f.isModifiable()) {
                                        this.f = GeneratedMessageLite.mutableCopy(this.f);
                                    }
                                    this.f.addInt(codedInputStream.readInt32());
                                } else if (readTag == 42) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.f.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.f = GeneratedMessageLite.mutableCopy(this.f);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.f.addInt(codedInputStream.readInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag != 48) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                                } else {
                                    this.g = codedInputStream.readInt32();
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (i == null) {
                            synchronized (d.class) {
                                if (i == null) {
                                    i = new GeneratedMessageLite.DefaultInstanceBasedParser(h);
                                }
                            }
                        }
                        return i;
                    default:
                        throw new UnsupportedOperationException();
                }
                return h;
            }

            static {
                h.makeImmutable();
            }

            public static Parser<d> b() {
                return h.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$b */
        /* loaded from: classes.dex */
        public static final class b extends GeneratedMessageLite<b, a> implements InterfaceC0010c {
            private static final b f = new b();
            private static volatile Parser<b> g;
            private int a;
            private int b;
            private int c;
            private int d;
            private Internal.ProtobufList<x> e = emptyProtobufList();

            private b() {
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.b;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                int i2 = this.c;
                if (i2 != 0) {
                    codedOutputStream.writeInt32(2, i2);
                }
                int i3 = this.d;
                if (i3 != 0) {
                    codedOutputStream.writeInt32(3, i3);
                }
                for (int i4 = 0; i4 < this.e.size(); i4++) {
                    codedOutputStream.writeMessage(4, this.e.get(i4));
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.b;
                int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
                int i3 = this.c;
                if (i3 != 0) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
                }
                int i4 = this.d;
                if (i4 != 0) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
                }
                for (int i5 = 0; i5 < this.e.size(); i5++) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(4, this.e.get(i5));
                }
                this.memoizedSerializedSize = computeInt32Size;
                return computeInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$b$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<b, a> implements InterfaceC0010c {
                private a() {
                    super(b.f);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new b();
                    case IS_INITIALIZED:
                        return f;
                    case MAKE_IMMUTABLE:
                        this.e.makeImmutable();
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        b bVar = (b) obj2;
                        this.b = visitor.visitInt(this.b != 0, this.b, bVar.b != 0, bVar.b);
                        this.c = visitor.visitInt(this.c != 0, this.c, bVar.c != 0, bVar.c);
                        this.d = visitor.visitInt(this.d != 0, this.d, bVar.d != 0, bVar.d);
                        this.e = visitor.visitList(this.e, bVar.e);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.a |= bVar.a;
                        }
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                try {
                                    int readTag = codedInputStream.readTag();
                                    if (readTag == 0) {
                                        r1 = true;
                                    } else if (readTag == 8) {
                                        this.b = codedInputStream.readInt32();
                                    } else if (readTag == 16) {
                                        this.c = codedInputStream.readInt32();
                                    } else if (readTag == 24) {
                                        this.d = codedInputStream.readInt32();
                                    } else if (readTag != 34) {
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                        }
                                    } else {
                                        if (!this.e.isModifiable()) {
                                            this.e = GeneratedMessageLite.mutableCopy(this.e);
                                        }
                                        this.e.add(codedInputStream.readMessage(x.b(), extensionRegistryLite));
                                    }
                                } catch (InvalidProtocolBufferException e) {
                                    throw new RuntimeException(e.setUnfinishedMessage(this));
                                }
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (g == null) {
                            synchronized (b.class) {
                                if (g == null) {
                                    g = new GeneratedMessageLite.DefaultInstanceBasedParser(f);
                                }
                            }
                        }
                        return g;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f;
            }

            static {
                f.makeImmutable();
            }

            public static Parser<b> a() {
                return f.getParserForType();
            }
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$j */
        /* loaded from: classes.dex */
        public static final class j extends GeneratedMessageLite<j, a> implements k {
            private static final j f = new j();
            private static volatile Parser<j> g;
            private int a;
            private int b;
            private Internal.ProtobufList<z> c = emptyProtobufList();
            private Internal.ProtobufList<d> d = emptyProtobufList();
            private Internal.ProtobufList<b> e = emptyProtobufList();

            private j() {
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.b;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    codedOutputStream.writeMessage(2, this.c.get(i2));
                }
                for (int i3 = 0; i3 < this.d.size(); i3++) {
                    codedOutputStream.writeMessage(3, this.d.get(i3));
                }
                for (int i4 = 0; i4 < this.e.size(); i4++) {
                    codedOutputStream.writeMessage(4, this.e.get(i4));
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.b;
                int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
                for (int i3 = 0; i3 < this.c.size(); i3++) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(2, this.c.get(i3));
                }
                for (int i4 = 0; i4 < this.d.size(); i4++) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(3, this.d.get(i4));
                }
                for (int i5 = 0; i5 < this.e.size(); i5++) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(4, this.e.get(i5));
                }
                this.memoizedSerializedSize = computeInt32Size;
                return computeInt32Size;
            }

            /* compiled from: WMDisplayMap.java */
            /* renamed from: ahz$c$j$a */
            /* loaded from: classes.dex */
            public static final class a extends GeneratedMessageLite.Builder<j, a> implements k {
                private a() {
                    super(j.f);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (methodToInvoke) {
                    case NEW_MUTABLE_INSTANCE:
                        return new j();
                    case IS_INITIALIZED:
                        return f;
                    case MAKE_IMMUTABLE:
                        this.c.makeImmutable();
                        this.d.makeImmutable();
                        this.e.makeImmutable();
                        return null;
                    case NEW_BUILDER:
                        return new a();
                    case VISIT:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        j jVar = (j) obj2;
                        this.b = visitor.visitInt(this.b != 0, this.b, jVar.b != 0, jVar.b);
                        this.c = visitor.visitList(this.c, jVar.c);
                        this.d = visitor.visitList(this.d, jVar.d);
                        this.e = visitor.visitList(this.e, jVar.e);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.a |= jVar.a;
                        }
                        return this;
                    case MERGE_FROM_STREAM:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!r1) {
                            try {
                                try {
                                    int readTag = codedInputStream.readTag();
                                    if (readTag == 0) {
                                        r1 = true;
                                    } else if (readTag == 8) {
                                        this.b = codedInputStream.readInt32();
                                    } else if (readTag == 18) {
                                        if (!this.c.isModifiable()) {
                                            this.c = GeneratedMessageLite.mutableCopy(this.c);
                                        }
                                        this.c.add(codedInputStream.readMessage(z.a(), extensionRegistryLite));
                                    } else if (readTag == 26) {
                                        if (!this.d.isModifiable()) {
                                            this.d = GeneratedMessageLite.mutableCopy(this.d);
                                        }
                                        this.d.add(codedInputStream.readMessage(d.b(), extensionRegistryLite));
                                    } else if (readTag != 34) {
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                        }
                                    } else {
                                        if (!this.e.isModifiable()) {
                                            this.e = GeneratedMessageLite.mutableCopy(this.e);
                                        }
                                        this.e.add(codedInputStream.readMessage(b.a(), extensionRegistryLite));
                                    }
                                } catch (InvalidProtocolBufferException e) {
                                    throw new RuntimeException(e.setUnfinishedMessage(this));
                                }
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        }
                        break;
                    case GET_DEFAULT_INSTANCE:
                        break;
                    case GET_PARSER:
                        if (g == null) {
                            synchronized (j.class) {
                                if (g == null) {
                                    g = new GeneratedMessageLite.DefaultInstanceBasedParser(f);
                                }
                            }
                        }
                        return g;
                    default:
                        throw new UnsupportedOperationException();
                }
                return f;
            }

            static {
                f.makeImmutable();
            }

            public static Parser<j> a() {
                return f.getParserForType();
            }
        }

        public aj a() {
            aj ajVar = this.b;
            return ajVar == null ? aj.d() : ajVar;
        }

        public List<v> b() {
            return this.c;
        }

        public List<n> c() {
            return this.e;
        }

        public List<ab> d() {
            return this.f;
        }

        public List<p> e() {
            return this.h;
        }

        public List<h> f() {
            return this.i;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.b != null) {
                codedOutputStream.writeMessage(1, a());
            }
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                codedOutputStream.writeMessage(2, this.c.get(i2));
            }
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                codedOutputStream.writeMessage(3, this.d.get(i3));
            }
            for (int i4 = 0; i4 < this.e.size(); i4++) {
                codedOutputStream.writeMessage(4, this.e.get(i4));
            }
            for (int i5 = 0; i5 < this.f.size(); i5++) {
                codedOutputStream.writeMessage(5, this.f.get(i5));
            }
            for (int i6 = 0; i6 < this.g.size(); i6++) {
                codedOutputStream.writeMessage(6, this.g.get(i6));
            }
            for (int i7 = 0; i7 < this.h.size(); i7++) {
                codedOutputStream.writeMessage(7, this.h.get(i7));
            }
            for (int i8 = 0; i8 < this.i.size(); i8++) {
                codedOutputStream.writeMessage(8, this.i.get(i8));
            }
            for (int i9 = 0; i9 < this.j.size(); i9++) {
                codedOutputStream.writeMessage(9, this.j.get(i9));
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = this.b != null ? CodedOutputStream.computeMessageSize(1, a()) + 0 : 0;
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.c.get(i3));
            }
            for (int i4 = 0; i4 < this.d.size(); i4++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, this.d.get(i4));
            }
            for (int i5 = 0; i5 < this.e.size(); i5++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, this.e.get(i5));
            }
            for (int i6 = 0; i6 < this.f.size(); i6++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(5, this.f.get(i6));
            }
            for (int i7 = 0; i7 < this.g.size(); i7++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(6, this.g.get(i7));
            }
            for (int i8 = 0; i8 < this.h.size(); i8++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(7, this.h.get(i8));
            }
            for (int i9 = 0; i9 < this.i.size(); i9++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(8, this.i.get(i9));
            }
            for (int i10 = 0; i10 < this.j.size(); i10++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(9, this.j.get(i10));
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$c$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<c, a> implements d {
            private a() {
                super(c.k);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new c();
                case IS_INITIALIZED:
                    return k;
                case MAKE_IMMUTABLE:
                    this.c.makeImmutable();
                    this.d.makeImmutable();
                    this.e.makeImmutable();
                    this.f.makeImmutable();
                    this.g.makeImmutable();
                    this.h.makeImmutable();
                    this.i.makeImmutable();
                    this.j.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    c cVar = (c) obj2;
                    this.b = (aj) visitor.visitMessage(this.b, cVar.b);
                    this.c = visitor.visitList(this.c, cVar.c);
                    this.d = visitor.visitList(this.d, cVar.d);
                    this.e = visitor.visitList(this.e, cVar.e);
                    this.f = visitor.visitList(this.f, cVar.f);
                    this.g = visitor.visitList(this.g, cVar.g);
                    this.h = visitor.visitList(this.h, cVar.h);
                    this.i = visitor.visitList(this.i, cVar.i);
                    this.j = visitor.visitList(this.j, cVar.j);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= cVar.a;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z2 = false;
                    while (!z2) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag == 0) {
                                z2 = true;
                            } else if (readTag == 10) {
                                aj.a builder = this.b != null ? this.b.toBuilder() : null;
                                this.b = (aj) codedInputStream.readMessage(aj.e(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((aj.a) this.b);
                                    this.b = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                if (!this.c.isModifiable()) {
                                    this.c = GeneratedMessageLite.mutableCopy(this.c);
                                }
                                this.c.add(codedInputStream.readMessage(v.f(), extensionRegistryLite));
                            } else if (readTag == 26) {
                                if (!this.d.isModifiable()) {
                                    this.d = GeneratedMessageLite.mutableCopy(this.d);
                                }
                                this.d.add(codedInputStream.readMessage(l.c(), extensionRegistryLite));
                            } else if (readTag == 34) {
                                if (!this.e.isModifiable()) {
                                    this.e = GeneratedMessageLite.mutableCopy(this.e);
                                }
                                this.e.add(codedInputStream.readMessage(n.k(), extensionRegistryLite));
                            } else if (readTag == 42) {
                                if (!this.f.isModifiable()) {
                                    this.f = GeneratedMessageLite.mutableCopy(this.f);
                                }
                                this.f.add(codedInputStream.readMessage(ab.j(), extensionRegistryLite));
                            } else if (readTag == 50) {
                                if (!this.g.isModifiable()) {
                                    this.g = GeneratedMessageLite.mutableCopy(this.g);
                                }
                                this.g.add(codedInputStream.readMessage(af.b(), extensionRegistryLite));
                            } else if (readTag == 58) {
                                if (!this.h.isModifiable()) {
                                    this.h = GeneratedMessageLite.mutableCopy(this.h);
                                }
                                this.h.add(codedInputStream.readMessage(p.b(), extensionRegistryLite));
                            } else if (readTag == 66) {
                                if (!this.i.isModifiable()) {
                                    this.i = GeneratedMessageLite.mutableCopy(this.i);
                                }
                                this.i.add(codedInputStream.readMessage(h.d(), extensionRegistryLite));
                            } else if (readTag != 74) {
                                if (!codedInputStream.skipField(readTag)) {
                                    z2 = true;
                                }
                            } else {
                                if (!this.j.isModifiable()) {
                                    this.j = GeneratedMessageLite.mutableCopy(this.j);
                                }
                                this.j.add(codedInputStream.readMessage(j.a(), extensionRegistryLite));
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case GET_DEFAULT_INSTANCE:
                    break;
                case GET_PARSER:
                    if (l == null) {
                        synchronized (c.class) {
                            if (l == null) {
                                l = new GeneratedMessageLite.DefaultInstanceBasedParser(k);
                            }
                        }
                    }
                    return l;
                default:
                    throw new UnsupportedOperationException();
            }
            return k;
        }

        static {
            k.makeImmutable();
        }

        public static c g() {
            return k;
        }

        public static Parser<c> h() {
            return k.getParserForType();
        }
    }

    /* compiled from: WMDisplayMap.java */
    /* renamed from: ahz$a */
    /* loaded from: classes.dex */
    public static final class a extends GeneratedMessageLite<a, C0009a> implements b {
        private static final a e = new a();
        private static volatile Parser<a> f;
        private c a;
        private b.o b;
        private int c;
        private int d;

        private a() {
        }

        public boolean a() {
            return this.a != null;
        }

        public c b() {
            c cVar = this.a;
            return cVar == null ? c.g() : cVar;
        }

        public boolean c() {
            return this.b != null;
        }

        public b.o d() {
            b.o oVar = this.b;
            return oVar == null ? b.o.e() : oVar;
        }

        public int e() {
            return this.c;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.a != null) {
                codedOutputStream.writeMessage(1, b());
            }
            if (this.b != null) {
                codedOutputStream.writeMessage(2, d());
            }
            int i = this.c;
            if (i != 0) {
                codedOutputStream.writeUInt32(3, i);
            }
            int i2 = this.d;
            if (i2 != 0) {
                codedOutputStream.writeInt32(4, i2);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.a != null ? 0 + CodedOutputStream.computeMessageSize(1, b()) : 0;
            if (this.b != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, d());
            }
            int i2 = this.c;
            if (i2 != 0) {
                computeMessageSize += CodedOutputStream.computeUInt32Size(3, i2);
            }
            int i3 = this.d;
            if (i3 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(4, i3);
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }

        public static a a(byte[] bArr) throws InvalidProtocolBufferException {
            return (a) GeneratedMessageLite.parseFrom(e, bArr);
        }

        /* compiled from: WMDisplayMap.java */
        /* renamed from: ahz$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0009a extends GeneratedMessageLite.Builder<a, C0009a> implements b {
            private C0009a() {
                super(a.e);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new a();
                case IS_INITIALIZED:
                    return e;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new C0009a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    a aVar = (a) obj2;
                    this.a = (c) visitor.visitMessage(this.a, aVar.a);
                    this.b = (b.o) visitor.visitMessage(this.b, aVar.b);
                    this.c = visitor.visitInt(this.c != 0, this.c, aVar.c != 0, aVar.c);
                    this.d = visitor.visitInt(this.d != 0, this.d, aVar.d != 0, aVar.d);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!r1) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag == 0) {
                                r1 = true;
                            } else if (readTag == 10) {
                                c.a builder = this.a != null ? this.a.toBuilder() : null;
                                this.a = (c) codedInputStream.readMessage(c.h(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((c.a) this.a);
                                    this.a = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                b.o.C0041b builder2 = this.b != null ? this.b.toBuilder() : null;
                                this.b = (b.o) codedInputStream.readMessage(b.o.f(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((b.o.C0041b) this.b);
                                    this.b = builder2.buildPartial();
                                }
                            } else if (readTag == 24) {
                                this.c = codedInputStream.readUInt32();
                            } else if (readTag != 32) {
                                if (!codedInputStream.skipField(readTag)) {
                                    r1 = true;
                                }
                            } else {
                                this.d = codedInputStream.readInt32();
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        } catch (IOException e3) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case GET_DEFAULT_INSTANCE:
                    break;
                case GET_PARSER:
                    if (f == null) {
                        synchronized (a.class) {
                            if (f == null) {
                                f = new GeneratedMessageLite.DefaultInstanceBasedParser(e);
                            }
                        }
                    }
                    return f;
                default:
                    throw new UnsupportedOperationException();
            }
            return e;
        }

        static {
            e.makeImmutable();
        }
    }
}
