package defpackage;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
/* compiled from: Base.java */
/* renamed from: a  reason: default package */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a$b */
    /* loaded from: classes.dex */
    public interface b extends MessageLiteOrBuilder {
    }

    /* renamed from: a$d */
    /* loaded from: classes.dex */
    public interface d extends MessageLiteOrBuilder {
    }

    /* renamed from: a$f */
    /* loaded from: classes.dex */
    public interface f extends MessageLiteOrBuilder {
    }

    /* renamed from: a$h */
    /* loaded from: classes.dex */
    public interface h extends MessageLiteOrBuilder {
    }

    /* renamed from: a$j */
    /* loaded from: classes.dex */
    public interface j extends MessageLiteOrBuilder {
    }

    /* renamed from: a$l */
    /* loaded from: classes.dex */
    public interface l extends MessageLiteOrBuilder {
    }

    /* compiled from: Base.java */
    /* renamed from: a$e */
    /* loaded from: classes.dex */
    public static final class e extends GeneratedMessageLite<e, C0003a> implements f {
        private static final e d = new e();
        private static volatile Parser<e> e;
        private float a;
        private float b;
        private float c;

        private e() {
        }

        public float a() {
            return this.a;
        }

        public float b() {
            return this.b;
        }

        public float c() {
            return this.c;
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

        /* compiled from: Base.java */
        /* renamed from: a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0003a extends GeneratedMessageLite.Builder<e, C0003a> implements f {
            private C0003a() {
                super(e.d);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new e();
                case IS_INITIALIZED:
                    return d;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new C0003a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    e eVar = (e) obj2;
                    this.a = visitor.visitFloat(this.a != 0.0f, this.a, eVar.a != 0.0f, eVar.a);
                    this.b = visitor.visitFloat(this.b != 0.0f, this.b, eVar.b != 0.0f, eVar.b);
                    this.c = visitor.visitFloat(this.c != 0.0f, this.c, eVar.c != 0.0f, eVar.c);
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
                        synchronized (e.class) {
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

        public static e d() {
            return d;
        }

        public static Parser<e> e() {
            return d.getParserForType();
        }
    }

    /* compiled from: Base.java */
    /* renamed from: a$g */
    /* loaded from: classes.dex */
    public static final class g extends GeneratedMessageLite<g, C0004a> implements h {
        private static final g d = new g();
        private static volatile Parser<g> e;
        private float a;
        private float b;
        private float c;

        private g() {
        }

        public float a() {
            return this.a;
        }

        public float b() {
            return this.b;
        }

        public float c() {
            return this.c;
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

        /* compiled from: Base.java */
        /* renamed from: a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0004a extends GeneratedMessageLite.Builder<g, C0004a> implements h {
            private C0004a() {
                super(g.d);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new g();
                case IS_INITIALIZED:
                    return d;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new C0004a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    g gVar = (g) obj2;
                    this.a = visitor.visitFloat(this.a != 0.0f, this.a, gVar.a != 0.0f, gVar.a);
                    this.b = visitor.visitFloat(this.b != 0.0f, this.b, gVar.b != 0.0f, gVar.b);
                    this.c = visitor.visitFloat(this.c != 0.0f, this.c, gVar.c != 0.0f, gVar.c);
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
                        synchronized (g.class) {
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

        public static g d() {
            return d;
        }

        public static Parser<g> e() {
            return d.getParserForType();
        }
    }

    /* compiled from: Base.java */
    /* renamed from: a$i */
    /* loaded from: classes.dex */
    public static final class i extends GeneratedMessageLite<i, C0005a> implements j {
        private static final i d = new i();
        private static volatile Parser<i> e;
        private float a;
        private float b;
        private float c;

        private i() {
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

        /* compiled from: Base.java */
        /* renamed from: a$i$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0005a extends GeneratedMessageLite.Builder<i, C0005a> implements j {
            private C0005a() {
                super(i.d);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new i();
                case IS_INITIALIZED:
                    return d;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new C0005a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    i iVar = (i) obj2;
                    this.a = visitor.visitFloat(this.a != 0.0f, this.a, iVar.a != 0.0f, iVar.a);
                    this.b = visitor.visitFloat(this.b != 0.0f, this.b, iVar.b != 0.0f, iVar.b);
                    this.c = visitor.visitFloat(this.c != 0.0f, this.c, iVar.c != 0.0f, iVar.c);
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
                        synchronized (i.class) {
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

        public static i a() {
            return d;
        }

        public static Parser<i> b() {
            return d.getParserForType();
        }
    }

    /* compiled from: Base.java */
    /* renamed from: a$c */
    /* loaded from: classes.dex */
    public static final class c extends GeneratedMessageLite<c, C0002a> implements d {
        private static final c i = new c();
        private static volatile Parser<c> j;
        private e a;
        private g b;
        private float c;
        private float d;
        private float e;
        private int f;
        private int g;
        private C0000a h;

        private c() {
        }

        public e a() {
            e eVar = this.a;
            return eVar == null ? e.d() : eVar;
        }

        public g b() {
            g gVar = this.b;
            return gVar == null ? g.d() : gVar;
        }

        public float c() {
            return this.c;
        }

        public float d() {
            return this.d;
        }

        public float e() {
            return this.e;
        }

        public int f() {
            return this.g;
        }

        public C0000a g() {
            C0000a c0000a = this.h;
            return c0000a == null ? C0000a.c() : c0000a;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.a != null) {
                codedOutputStream.writeMessage(1, a());
            }
            if (this.b != null) {
                codedOutputStream.writeMessage(2, b());
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
            int i2 = this.f;
            if (i2 != 0) {
                codedOutputStream.writeInt32(6, i2);
            }
            int i3 = this.g;
            if (i3 != 0) {
                codedOutputStream.writeInt32(7, i3);
            }
            if (this.h != null) {
                codedOutputStream.writeMessage(8, g());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int computeMessageSize = this.a != null ? 0 + CodedOutputStream.computeMessageSize(1, a()) : 0;
            if (this.b != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, b());
            }
            float f = this.c;
            if (f != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(3, f);
            }
            float f2 = this.d;
            if (f2 != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(4, f2);
            }
            float f3 = this.e;
            if (f3 != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(5, f3);
            }
            int i3 = this.f;
            if (i3 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(6, i3);
            }
            int i4 = this.g;
            if (i4 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(7, i4);
            }
            if (this.h != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(8, g());
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }

        /* compiled from: Base.java */
        /* renamed from: a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0002a extends GeneratedMessageLite.Builder<c, C0002a> implements d {
            private C0002a() {
                super(c.i);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new c();
                case IS_INITIALIZED:
                    return i;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new C0002a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    c cVar = (c) obj2;
                    this.a = (e) visitor.visitMessage(this.a, cVar.a);
                    this.b = (g) visitor.visitMessage(this.b, cVar.b);
                    this.c = visitor.visitFloat(this.c != 0.0f, this.c, cVar.c != 0.0f, cVar.c);
                    this.d = visitor.visitFloat(this.d != 0.0f, this.d, cVar.d != 0.0f, cVar.d);
                    this.e = visitor.visitFloat(this.e != 0.0f, this.e, cVar.e != 0.0f, cVar.e);
                    this.f = visitor.visitInt(this.f != 0, this.f, cVar.f != 0, cVar.f);
                    this.g = visitor.visitInt(this.g != 0, this.g, cVar.g != 0, cVar.g);
                    this.h = (C0000a) visitor.visitMessage(this.h, cVar.h);
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
                                e.C0003a builder = this.a != null ? this.a.toBuilder() : null;
                                this.a = (e) codedInputStream.readMessage(e.e(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((e.C0003a) this.a);
                                    this.a = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                g.C0004a builder2 = this.b != null ? this.b.toBuilder() : null;
                                this.b = (g) codedInputStream.readMessage(g.e(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((g.C0004a) this.b);
                                    this.b = builder2.buildPartial();
                                }
                            } else if (readTag == 29) {
                                this.c = codedInputStream.readFloat();
                            } else if (readTag == 37) {
                                this.d = codedInputStream.readFloat();
                            } else if (readTag == 45) {
                                this.e = codedInputStream.readFloat();
                            } else if (readTag == 48) {
                                this.f = codedInputStream.readInt32();
                            } else if (readTag == 56) {
                                this.g = codedInputStream.readInt32();
                            } else if (readTag != 66) {
                                if (!codedInputStream.skipField(readTag)) {
                                    r1 = true;
                                }
                            } else {
                                C0000a.C0001a builder3 = this.h != null ? this.h.toBuilder() : null;
                                this.h = (C0000a) codedInputStream.readMessage(C0000a.d(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom((C0000a.C0001a) this.h);
                                    this.h = builder3.buildPartial();
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
                    if (j == null) {
                        synchronized (c.class) {
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

        public static c h() {
            return i;
        }

        public static Parser<c> i() {
            return i.getParserForType();
        }
    }

    /* compiled from: Base.java */
    /* renamed from: a$k */
    /* loaded from: classes.dex */
    public static final class k extends GeneratedMessageLite<k, C0006a> implements l {
        private static final k p = new k();
        private static volatile Parser<k> q;
        private e a;
        private e b;
        private e c;
        private e d;
        private int e;
        private int f;
        private e g;
        private int h;
        private int i;
        private int j;
        private float k;
        private float l;
        private float m;
        private int n;
        private int o;

        private k() {
        }

        public e a() {
            e eVar = this.a;
            return eVar == null ? e.d() : eVar;
        }

        public e b() {
            e eVar = this.b;
            return eVar == null ? e.d() : eVar;
        }

        public e c() {
            e eVar = this.c;
            return eVar == null ? e.d() : eVar;
        }

        public e d() {
            e eVar = this.d;
            return eVar == null ? e.d() : eVar;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public e g() {
            e eVar = this.g;
            return eVar == null ? e.d() : eVar;
        }

        public int h() {
            return this.h;
        }

        public int i() {
            return this.i;
        }

        public int j() {
            return this.j;
        }

        public float k() {
            return this.k;
        }

        public float l() {
            return this.l;
        }

        public float m() {
            return this.m;
        }

        public int n() {
            return this.n;
        }

        public int o() {
            return this.o;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.a != null) {
                codedOutputStream.writeMessage(1, a());
            }
            if (this.b != null) {
                codedOutputStream.writeMessage(2, b());
            }
            if (this.c != null) {
                codedOutputStream.writeMessage(3, c());
            }
            if (this.d != null) {
                codedOutputStream.writeMessage(4, d());
            }
            int i = this.e;
            if (i != 0) {
                codedOutputStream.writeInt32(5, i);
            }
            int i2 = this.f;
            if (i2 != 0) {
                codedOutputStream.writeInt32(6, i2);
            }
            if (this.g != null) {
                codedOutputStream.writeMessage(7, g());
            }
            int i3 = this.h;
            if (i3 != 0) {
                codedOutputStream.writeInt32(8, i3);
            }
            int i4 = this.i;
            if (i4 != 0) {
                codedOutputStream.writeInt32(9, i4);
            }
            int i5 = this.j;
            if (i5 != 0) {
                codedOutputStream.writeInt32(10, i5);
            }
            float f = this.k;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(11, f);
            }
            float f2 = this.l;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(12, f2);
            }
            float f3 = this.m;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(13, f3);
            }
            int i6 = this.n;
            if (i6 != 0) {
                codedOutputStream.writeInt32(14, i6);
            }
            int i7 = this.o;
            if (i7 != 0) {
                codedOutputStream.writeInt32(15, i7);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.a != null ? 0 + CodedOutputStream.computeMessageSize(1, a()) : 0;
            if (this.b != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, b());
            }
            if (this.c != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, c());
            }
            if (this.d != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, d());
            }
            int i2 = this.e;
            if (i2 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(5, i2);
            }
            int i3 = this.f;
            if (i3 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(6, i3);
            }
            if (this.g != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(7, g());
            }
            int i4 = this.h;
            if (i4 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(8, i4);
            }
            int i5 = this.i;
            if (i5 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(9, i5);
            }
            int i6 = this.j;
            if (i6 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(10, i6);
            }
            float f = this.k;
            if (f != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(11, f);
            }
            float f2 = this.l;
            if (f2 != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(12, f2);
            }
            float f3 = this.m;
            if (f3 != 0.0f) {
                computeMessageSize += CodedOutputStream.computeFloatSize(13, f3);
            }
            int i7 = this.n;
            if (i7 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(14, i7);
            }
            int i8 = this.o;
            if (i8 != 0) {
                computeMessageSize += CodedOutputStream.computeInt32Size(15, i8);
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }

        /* compiled from: Base.java */
        /* renamed from: a$k$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0006a extends GeneratedMessageLite.Builder<k, C0006a> implements l {
            private C0006a() {
                super(k.p);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new k();
                case IS_INITIALIZED:
                    return p;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new C0006a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    k kVar = (k) obj2;
                    this.a = (e) visitor.visitMessage(this.a, kVar.a);
                    this.b = (e) visitor.visitMessage(this.b, kVar.b);
                    this.c = (e) visitor.visitMessage(this.c, kVar.c);
                    this.d = (e) visitor.visitMessage(this.d, kVar.d);
                    this.e = visitor.visitInt(this.e != 0, this.e, kVar.e != 0, kVar.e);
                    this.f = visitor.visitInt(this.f != 0, this.f, kVar.f != 0, kVar.f);
                    this.g = (e) visitor.visitMessage(this.g, kVar.g);
                    this.h = visitor.visitInt(this.h != 0, this.h, kVar.h != 0, kVar.h);
                    this.i = visitor.visitInt(this.i != 0, this.i, kVar.i != 0, kVar.i);
                    this.j = visitor.visitInt(this.j != 0, this.j, kVar.j != 0, kVar.j);
                    this.k = visitor.visitFloat(this.k != 0.0f, this.k, kVar.k != 0.0f, kVar.k);
                    this.l = visitor.visitFloat(this.l != 0.0f, this.l, kVar.l != 0.0f, kVar.l);
                    this.m = visitor.visitFloat(this.m != 0.0f, this.m, kVar.m != 0.0f, kVar.m);
                    this.n = visitor.visitInt(this.n != 0, this.n, kVar.n != 0, kVar.n);
                    this.o = visitor.visitInt(this.o != 0, this.o, kVar.o != 0, kVar.o);
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
                                case 10:
                                    e.C0003a builder = this.a != null ? this.a.toBuilder() : null;
                                    this.a = (e) codedInputStream.readMessage(e.e(), extensionRegistryLite);
                                    if (builder == null) {
                                        break;
                                    } else {
                                        builder.mergeFrom((e.C0003a) this.a);
                                        this.a = builder.buildPartial();
                                        break;
                                    }
                                case 18:
                                    e.C0003a builder2 = this.b != null ? this.b.toBuilder() : null;
                                    this.b = (e) codedInputStream.readMessage(e.e(), extensionRegistryLite);
                                    if (builder2 == null) {
                                        break;
                                    } else {
                                        builder2.mergeFrom((e.C0003a) this.b);
                                        this.b = builder2.buildPartial();
                                        break;
                                    }
                                case 26:
                                    e.C0003a builder3 = this.c != null ? this.c.toBuilder() : null;
                                    this.c = (e) codedInputStream.readMessage(e.e(), extensionRegistryLite);
                                    if (builder3 == null) {
                                        break;
                                    } else {
                                        builder3.mergeFrom((e.C0003a) this.c);
                                        this.c = builder3.buildPartial();
                                        break;
                                    }
                                case 34:
                                    e.C0003a builder4 = this.d != null ? this.d.toBuilder() : null;
                                    this.d = (e) codedInputStream.readMessage(e.e(), extensionRegistryLite);
                                    if (builder4 == null) {
                                        break;
                                    } else {
                                        builder4.mergeFrom((e.C0003a) this.d);
                                        this.d = builder4.buildPartial();
                                        break;
                                    }
                                case 40:
                                    this.e = codedInputStream.readInt32();
                                    break;
                                case 48:
                                    this.f = codedInputStream.readInt32();
                                    break;
                                case 58:
                                    e.C0003a builder5 = this.g != null ? this.g.toBuilder() : null;
                                    this.g = (e) codedInputStream.readMessage(e.e(), extensionRegistryLite);
                                    if (builder5 == null) {
                                        break;
                                    } else {
                                        builder5.mergeFrom((e.C0003a) this.g);
                                        this.g = builder5.buildPartial();
                                        break;
                                    }
                                case 64:
                                    this.h = codedInputStream.readInt32();
                                    break;
                                case 72:
                                    this.i = codedInputStream.readInt32();
                                    break;
                                case 80:
                                    this.j = codedInputStream.readInt32();
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
                                case 112:
                                    this.n = codedInputStream.readInt32();
                                    break;
                                case 120:
                                    this.o = codedInputStream.readInt32();
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
                    if (q == null) {
                        synchronized (k.class) {
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

        public static Parser<k> p() {
            return p.getParserForType();
        }
    }

    /* compiled from: Base.java */
    /* renamed from: a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0000a extends GeneratedMessageLite<C0000a, C0001a> implements b {
        private static final C0000a c = new C0000a();
        private static volatile Parser<C0000a> d;
        private int a;
        private int b;

        private C0000a() {
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
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
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        /* compiled from: Base.java */
        /* renamed from: a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0001a extends GeneratedMessageLite.Builder<C0000a, C0001a> implements b {
            private C0001a() {
                super(C0000a.c);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new C0000a();
                case IS_INITIALIZED:
                    return c;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new C0001a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    C0000a c0000a = (C0000a) obj2;
                    this.a = visitor.visitInt(this.a != 0, this.a, c0000a.a != 0, c0000a.a);
                    this.b = visitor.visitInt(this.b != 0, this.b, c0000a.b != 0, c0000a.b);
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
                        synchronized (C0000a.class) {
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

        public static C0000a c() {
            return c;
        }

        public static Parser<C0000a> d() {
            return c.getParserForType();
        }
    }
}
