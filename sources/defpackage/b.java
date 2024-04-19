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
import java.io.IOException;
import java.util.List;
/* compiled from: WMDisplayRealtime.java */
/* renamed from: b  reason: default package */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b$ab */
    /* loaded from: classes.dex */
    public interface ab extends MessageLiteOrBuilder {
    }

    /* renamed from: b$c */
    /* loaded from: classes.dex */
    public interface c extends MessageLiteOrBuilder {
    }

    /* renamed from: b$e */
    /* loaded from: classes.dex */
    public interface e extends MessageLiteOrBuilder {
    }

    /* renamed from: b$g */
    /* loaded from: classes.dex */
    public interface g extends MessageLiteOrBuilder {
    }

    /* renamed from: b$i */
    /* loaded from: classes.dex */
    public interface i extends MessageLiteOrBuilder {
    }

    /* renamed from: b$k */
    /* loaded from: classes.dex */
    public interface k extends MessageLiteOrBuilder {
    }

    /* renamed from: b$n */
    /* loaded from: classes.dex */
    public interface n extends MessageLiteOrBuilder {
    }

    /* renamed from: b$p */
    /* loaded from: classes.dex */
    public interface p extends MessageLiteOrBuilder {
    }

    /* renamed from: b$r */
    /* loaded from: classes.dex */
    public interface r extends MessageLiteOrBuilder {
    }

    /* renamed from: b$t */
    /* loaded from: classes.dex */
    public interface t extends MessageLiteOrBuilder {
    }

    /* renamed from: b$v */
    /* loaded from: classes.dex */
    public interface v extends MessageLiteOrBuilder {
    }

    /* renamed from: b$x */
    /* loaded from: classes.dex */
    public interface x extends MessageLiteOrBuilder {
    }

    /* renamed from: b$z */
    /* loaded from: classes.dex */
    public interface z extends MessageLiteOrBuilder {
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$l */
    /* loaded from: classes.dex */
    public enum l implements Internal.EnumLite {
        OBJ_TYPE_UNKNOWN(0),
        OBJ_TYPE_PERSON(1),
        OBJ_TYPE_ANIMAL(2),
        OBJ_TYPE_SEDAN(3),
        OBJ_TYPE_SUV(4),
        OBJ_TYPE_VAN(5),
        OBJ_TYPE_BICYCLE(6),
        OBJ_TYPE_TRICYCLE(7),
        OBJ_TYPE_MOTORCYCLE(8),
        OBJ_TYPE_TRUCK(9),
        OBJ_TYPE_BUS(10),
        OBJ_TYPE_PICKUP(11),
        UNRECOGNIZED(-1);
        
        public static final int OBJ_TYPE_ANIMAL_VALUE = 2;
        public static final int OBJ_TYPE_BICYCLE_VALUE = 6;
        public static final int OBJ_TYPE_BUS_VALUE = 10;
        public static final int OBJ_TYPE_MOTORCYCLE_VALUE = 8;
        public static final int OBJ_TYPE_PERSON_VALUE = 1;
        public static final int OBJ_TYPE_PICKUP_VALUE = 11;
        public static final int OBJ_TYPE_SEDAN_VALUE = 3;
        public static final int OBJ_TYPE_SUV_VALUE = 4;
        public static final int OBJ_TYPE_TRICYCLE_VALUE = 7;
        public static final int OBJ_TYPE_TRUCK_VALUE = 9;
        public static final int OBJ_TYPE_UNKNOWN_VALUE = 0;
        public static final int OBJ_TYPE_VAN_VALUE = 5;
        private static final Internal.EnumLiteMap<l> a = new Internal.EnumLiteMap<l>() { // from class: b.l.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public l findValueByNumber(int i) {
                return l.forNumber(i);
            }
        };
        private final int b;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.b;
        }

        @Deprecated
        public static l valueOf(int i) {
            return forNumber(i);
        }

        public static l forNumber(int i) {
            switch (i) {
                case 0:
                    return OBJ_TYPE_UNKNOWN;
                case 1:
                    return OBJ_TYPE_PERSON;
                case 2:
                    return OBJ_TYPE_ANIMAL;
                case 3:
                    return OBJ_TYPE_SEDAN;
                case 4:
                    return OBJ_TYPE_SUV;
                case 5:
                    return OBJ_TYPE_VAN;
                case 6:
                    return OBJ_TYPE_BICYCLE;
                case 7:
                    return OBJ_TYPE_TRICYCLE;
                case 8:
                    return OBJ_TYPE_MOTORCYCLE;
                case 9:
                    return OBJ_TYPE_TRUCK;
                case 10:
                    return OBJ_TYPE_BUS;
                case 11:
                    return OBJ_TYPE_PICKUP;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<l> internalGetValueMap() {
            return a;
        }

        l(int i) {
            this.b = i;
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$a */
    /* loaded from: classes.dex */
    public enum a implements Internal.EnumLite {
        kWheelStopper(0),
        kPillar(1),
        kWall(2),
        kCurb(3),
        kDoor(4),
        kHydrantBox(5),
        kHydrant(6),
        kBollardPost(7),
        kTrafficCone(8),
        kSpeedBump(9),
        kDrainage(10),
        kEntrance(11),
        kBarrierGate(12),
        kUnknown(13),
        UNRECOGNIZED(-1);
        
        private static final Internal.EnumLiteMap<a> a = new Internal.EnumLiteMap<a>() { // from class: b.a.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public a findValueByNumber(int i) {
                return a.forNumber(i);
            }
        };
        public static final int kBarrierGate_VALUE = 12;
        public static final int kBollardPost_VALUE = 7;
        public static final int kCurb_VALUE = 3;
        public static final int kDoor_VALUE = 4;
        public static final int kDrainage_VALUE = 10;
        public static final int kEntrance_VALUE = 11;
        public static final int kHydrantBox_VALUE = 5;
        public static final int kHydrant_VALUE = 6;
        public static final int kPillar_VALUE = 1;
        public static final int kSpeedBump_VALUE = 9;
        public static final int kTrafficCone_VALUE = 8;
        public static final int kUnknown_VALUE = 13;
        public static final int kWall_VALUE = 2;
        public static final int kWheelStopper_VALUE = 0;
        private final int b;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.b;
        }

        @Deprecated
        public static a valueOf(int i) {
            return forNumber(i);
        }

        public static a forNumber(int i) {
            switch (i) {
                case 0:
                    return kWheelStopper;
                case 1:
                    return kPillar;
                case 2:
                    return kWall;
                case 3:
                    return kCurb;
                case 4:
                    return kDoor;
                case 5:
                    return kHydrantBox;
                case 6:
                    return kHydrant;
                case 7:
                    return kBollardPost;
                case 8:
                    return kTrafficCone;
                case 9:
                    return kSpeedBump;
                case 10:
                    return kDrainage;
                case 11:
                    return kEntrance;
                case 12:
                    return kBarrierGate;
                case 13:
                    return kUnknown;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<a> internalGetValueMap() {
            return a;
        }

        a(int i) {
            this.b = i;
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$y */
    /* loaded from: classes.dex */
    public static final class y extends GeneratedMessageLite<y, a> implements z {
        private static final y h = new y();
        private static volatile Parser<y> i;
        private int a;
        private Internal.FloatList b = emptyFloatList();
        private int c;
        private a.i d;
        private int e;
        private int f;
        private int g;

        private y() {
        }

        public List<Float> a() {
            return this.b;
        }

        public a.i b() {
            a.i iVar = this.d;
            return iVar == null ? a.i.a() : iVar;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                codedOutputStream.writeFloat(1, this.b.getFloat(i2));
            }
            int i3 = this.c;
            if (i3 != 0) {
                codedOutputStream.writeInt32(2, i3);
            }
            if (this.d != null) {
                codedOutputStream.writeMessage(3, b());
            }
            int i4 = this.e;
            if (i4 != 0) {
                codedOutputStream.writeInt32(4, i4);
            }
            int i5 = this.f;
            if (i5 != 0) {
                codedOutputStream.writeInt32(5, i5);
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
            int size = (a().size() * 4) + 0 + (a().size() * 1);
            int i3 = this.c;
            if (i3 != 0) {
                size += CodedOutputStream.computeInt32Size(2, i3);
            }
            if (this.d != null) {
                size += CodedOutputStream.computeMessageSize(3, b());
            }
            int i4 = this.e;
            if (i4 != 0) {
                size += CodedOutputStream.computeInt32Size(4, i4);
            }
            int i5 = this.f;
            if (i5 != 0) {
                size += CodedOutputStream.computeInt32Size(5, i5);
            }
            int i6 = this.g;
            if (i6 != 0) {
                size += CodedOutputStream.computeInt32Size(6, i6);
            }
            this.memoizedSerializedSize = size;
            return size;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$y$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<y, a> implements z {
            private a() {
                super(y.h);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Type inference failed for: r7v65, types: [com.google.protobuf.Internal$FloatList] */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new y();
                case IS_INITIALIZED:
                    return h;
                case MAKE_IMMUTABLE:
                    this.b.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    y yVar = (y) obj2;
                    this.b = visitor.visitFloatList(this.b, yVar.b);
                    this.c = visitor.visitInt(this.c != 0, this.c, yVar.c != 0, yVar.c);
                    this.d = (a.i) visitor.visitMessage(this.d, yVar.d);
                    this.e = visitor.visitInt(this.e != 0, this.e, yVar.e != 0, yVar.e);
                    this.f = visitor.visitInt(this.f != 0, this.f, yVar.f != 0, yVar.f);
                    this.g = visitor.visitInt(this.g != 0, this.g, yVar.g != 0, yVar.g);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= yVar.a;
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
                            } else if (readTag == 10) {
                                int readRawVarint32 = codedInputStream.readRawVarint32();
                                int pushLimit = codedInputStream.pushLimit(readRawVarint32);
                                if (!this.b.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.b = this.b.mutableCopyWithCapacity(this.b.size() + (readRawVarint32 / 4));
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.b.addFloat(codedInputStream.readFloat());
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 13) {
                                if (!this.b.isModifiable()) {
                                    this.b = GeneratedMessageLite.mutableCopy(this.b);
                                }
                                this.b.addFloat(codedInputStream.readFloat());
                            } else if (readTag == 16) {
                                this.c = codedInputStream.readInt32();
                            } else if (readTag == 26) {
                                a.i.C0005a builder = this.d != null ? this.d.toBuilder() : null;
                                this.d = (a.i) codedInputStream.readMessage(a.i.b(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((a.i.C0005a) this.d);
                                    this.d = builder.buildPartial();
                                }
                            } else if (readTag == 32) {
                                this.e = codedInputStream.readInt32();
                            } else if (readTag == 40) {
                                this.f = codedInputStream.readInt32();
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
                        synchronized (y.class) {
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

        public static Parser<y> c() {
            return h.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$m */
    /* loaded from: classes.dex */
    public static final class m extends GeneratedMessageLite<m, a> implements n {
        private static final m n = new m();
        private static volatile Parser<m> o;
        private float a;
        private a.e b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private float j;
        private int k;
        private a.C0000a l;
        private int m;

        private m() {
        }

        public a.e a() {
            a.e eVar = this.b;
            return eVar == null ? a.e.d() : eVar;
        }

        public float b() {
            return this.f;
        }

        public float c() {
            return this.g;
        }

        public a.C0000a d() {
            a.C0000a c0000a = this.l;
            return c0000a == null ? a.C0000a.c() : c0000a;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            float f = this.a;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(1, f);
            }
            if (this.b != null) {
                codedOutputStream.writeMessage(2, a());
            }
            float f2 = this.c;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(3, f2);
            }
            float f3 = this.d;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(4, f3);
            }
            float f4 = this.e;
            if (f4 != 0.0f) {
                codedOutputStream.writeFloat(5, f4);
            }
            float f5 = this.f;
            if (f5 != 0.0f) {
                codedOutputStream.writeFloat(6, f5);
            }
            float f6 = this.g;
            if (f6 != 0.0f) {
                codedOutputStream.writeFloat(7, f6);
            }
            float f7 = this.h;
            if (f7 != 0.0f) {
                codedOutputStream.writeFloat(8, f7);
            }
            float f8 = this.i;
            if (f8 != 0.0f) {
                codedOutputStream.writeFloat(9, f8);
            }
            float f9 = this.j;
            if (f9 != 0.0f) {
                codedOutputStream.writeFloat(10, f9);
            }
            int i = this.k;
            if (i != 0) {
                codedOutputStream.writeUInt32(11, i);
            }
            if (this.l != null) {
                codedOutputStream.writeMessage(12, d());
            }
            int i2 = this.m;
            if (i2 != 0) {
                codedOutputStream.writeInt32(13, i2);
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
            if (this.b != null) {
                computeFloatSize += CodedOutputStream.computeMessageSize(2, a());
            }
            float f2 = this.c;
            if (f2 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(3, f2);
            }
            float f3 = this.d;
            if (f3 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(4, f3);
            }
            float f4 = this.e;
            if (f4 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(5, f4);
            }
            float f5 = this.f;
            if (f5 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(6, f5);
            }
            float f6 = this.g;
            if (f6 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(7, f6);
            }
            float f7 = this.h;
            if (f7 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(8, f7);
            }
            float f8 = this.i;
            if (f8 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(9, f8);
            }
            float f9 = this.j;
            if (f9 != 0.0f) {
                computeFloatSize += CodedOutputStream.computeFloatSize(10, f9);
            }
            int i2 = this.k;
            if (i2 != 0) {
                computeFloatSize += CodedOutputStream.computeUInt32Size(11, i2);
            }
            if (this.l != null) {
                computeFloatSize += CodedOutputStream.computeMessageSize(12, d());
            }
            int i3 = this.m;
            if (i3 != 0) {
                computeFloatSize += CodedOutputStream.computeInt32Size(13, i3);
            }
            this.memoizedSerializedSize = computeFloatSize;
            return computeFloatSize;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$m$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<m, a> implements n {
            private a() {
                super(m.n);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new m();
                case IS_INITIALIZED:
                    return n;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    m mVar = (m) obj2;
                    this.a = visitor.visitFloat(this.a != 0.0f, this.a, mVar.a != 0.0f, mVar.a);
                    this.b = (a.e) visitor.visitMessage(this.b, mVar.b);
                    this.c = visitor.visitFloat(this.c != 0.0f, this.c, mVar.c != 0.0f, mVar.c);
                    this.d = visitor.visitFloat(this.d != 0.0f, this.d, mVar.d != 0.0f, mVar.d);
                    this.e = visitor.visitFloat(this.e != 0.0f, this.e, mVar.e != 0.0f, mVar.e);
                    this.f = visitor.visitFloat(this.f != 0.0f, this.f, mVar.f != 0.0f, mVar.f);
                    this.g = visitor.visitFloat(this.g != 0.0f, this.g, mVar.g != 0.0f, mVar.g);
                    this.h = visitor.visitFloat(this.h != 0.0f, this.h, mVar.h != 0.0f, mVar.h);
                    this.i = visitor.visitFloat(this.i != 0.0f, this.i, mVar.i != 0.0f, mVar.i);
                    this.j = visitor.visitFloat(this.j != 0.0f, this.j, mVar.j != 0.0f, mVar.j);
                    this.k = visitor.visitInt(this.k != 0, this.k, mVar.k != 0, mVar.k);
                    this.l = (a.C0000a) visitor.visitMessage(this.l, mVar.l);
                    this.m = visitor.visitInt(this.m != 0, this.m, mVar.m != 0, mVar.m);
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
                                case 13:
                                    this.a = codedInputStream.readFloat();
                                    break;
                                case 18:
                                    a.e.C0003a builder = this.b != null ? this.b.toBuilder() : null;
                                    this.b = (a.e) codedInputStream.readMessage(a.e.e(), extensionRegistryLite);
                                    if (builder == null) {
                                        break;
                                    } else {
                                        builder.mergeFrom((a.e.C0003a) this.b);
                                        this.b = builder.buildPartial();
                                        break;
                                    }
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
                                case 77:
                                    this.i = codedInputStream.readFloat();
                                    break;
                                case 85:
                                    this.j = codedInputStream.readFloat();
                                    break;
                                case 88:
                                    this.k = codedInputStream.readUInt32();
                                    break;
                                case 98:
                                    a.C0000a.C0001a builder2 = this.l != null ? this.l.toBuilder() : null;
                                    this.l = (a.C0000a) codedInputStream.readMessage(a.C0000a.d(), extensionRegistryLite);
                                    if (builder2 == null) {
                                        break;
                                    } else {
                                        builder2.mergeFrom((a.C0000a.C0001a) this.l);
                                        this.l = builder2.buildPartial();
                                        break;
                                    }
                                case 104:
                                    this.m = codedInputStream.readInt32();
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
                    if (o == null) {
                        synchronized (m.class) {
                            if (o == null) {
                                o = new GeneratedMessageLite.DefaultInstanceBasedParser(n);
                            }
                        }
                    }
                    return o;
                default:
                    throw new UnsupportedOperationException();
            }
            return n;
        }

        static {
            n.makeImmutable();
        }

        public static Parser<m> e() {
            return n.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$h */
    /* loaded from: classes.dex */
    public static final class h extends GeneratedMessageLite<h, a> implements i {
        private static final h d = new h();
        private static volatile Parser<h> e;
        private int a;
        private int b;
        private Internal.ProtobufList<m> c = emptyProtobufList();

        private h() {
        }

        public int a() {
            return this.c.size();
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
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$h$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<h, a> implements i {
            private a() {
                super(h.d);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new h();
                case IS_INITIALIZED:
                    return d;
                case MAKE_IMMUTABLE:
                    this.c.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    h hVar = (h) obj2;
                    this.b = visitor.visitInt(this.b != 0, this.b, hVar.b != 0, hVar.b);
                    this.c = visitor.visitList(this.c, hVar.c);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= hVar.a;
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
                                } else if (readTag != 18) {
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                                } else {
                                    if (!this.c.isModifiable()) {
                                        this.c = GeneratedMessageLite.mutableCopy(this.c);
                                    }
                                    this.c.add(codedInputStream.readMessage(m.e(), extensionRegistryLite));
                                }
                            } catch (IOException e2) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                            }
                        } catch (InvalidProtocolBufferException e3) {
                            throw new RuntimeException(e3.setUnfinishedMessage(this));
                        }
                    }
                    break;
                case GET_DEFAULT_INSTANCE:
                    break;
                case GET_PARSER:
                    if (e == null) {
                        synchronized (h.class) {
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

        public static Parser<h> b() {
            return d.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$d */
    /* loaded from: classes.dex */
    public static final class d extends GeneratedMessageLite<d, a> implements e {
        private static final d g = new d();
        private static volatile Parser<d> h;
        private int a;
        private a.i b;
        private int c;
        private a.g d;
        private a.e e;
        private int f;

        private d() {
        }

        public a.i a() {
            a.i iVar = this.b;
            return iVar == null ? a.i.a() : iVar;
        }

        public l b() {
            l forNumber = l.forNumber(this.c);
            return forNumber == null ? l.UNRECOGNIZED : forNumber;
        }

        public a.g c() {
            a.g gVar = this.d;
            return gVar == null ? a.g.d() : gVar;
        }

        public a.e d() {
            a.e eVar = this.e;
            return eVar == null ? a.e.d() : eVar;
        }

        public int e() {
            return this.f;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.a;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (this.b != null) {
                codedOutputStream.writeMessage(2, a());
            }
            if (this.c != l.OBJ_TYPE_UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(3, this.c);
            }
            if (this.d != null) {
                codedOutputStream.writeMessage(4, c());
            }
            if (this.e != null) {
                codedOutputStream.writeMessage(5, d());
            }
            int i2 = this.f;
            if (i2 != 0) {
                codedOutputStream.writeInt32(6, i2);
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
            if (this.b != null) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(2, a());
            }
            if (this.c != l.OBJ_TYPE_UNKNOWN.getNumber()) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(3, this.c);
            }
            if (this.d != null) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(4, c());
            }
            if (this.e != null) {
                computeUInt32Size += CodedOutputStream.computeMessageSize(5, d());
            }
            int i3 = this.f;
            if (i3 != 0) {
                computeUInt32Size += CodedOutputStream.computeInt32Size(6, i3);
            }
            this.memoizedSerializedSize = computeUInt32Size;
            return computeUInt32Size;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$d$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<d, a> implements e {
            private a() {
                super(d.g);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new d();
                case IS_INITIALIZED:
                    return g;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    d dVar = (d) obj2;
                    this.a = visitor.visitInt(this.a != 0, this.a, dVar.a != 0, dVar.a);
                    this.b = (a.i) visitor.visitMessage(this.b, dVar.b);
                    this.c = visitor.visitInt(this.c != 0, this.c, dVar.c != 0, dVar.c);
                    this.d = (a.g) visitor.visitMessage(this.d, dVar.d);
                    this.e = (a.e) visitor.visitMessage(this.e, dVar.e);
                    this.f = visitor.visitInt(this.f != 0, this.f, dVar.f != 0, dVar.f);
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
                            } else if (readTag == 18) {
                                a.i.C0005a builder = this.b != null ? this.b.toBuilder() : null;
                                this.b = (a.i) codedInputStream.readMessage(a.i.b(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((a.i.C0005a) this.b);
                                    this.b = builder.buildPartial();
                                }
                            } else if (readTag == 24) {
                                this.c = codedInputStream.readEnum();
                            } else if (readTag == 34) {
                                a.g.C0004a builder2 = this.d != null ? this.d.toBuilder() : null;
                                this.d = (a.g) codedInputStream.readMessage(a.g.e(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((a.g.C0004a) this.d);
                                    this.d = builder2.buildPartial();
                                }
                            } else if (readTag == 42) {
                                a.e.C0003a builder3 = this.e != null ? this.e.toBuilder() : null;
                                this.e = (a.e) codedInputStream.readMessage(a.e.e(), extensionRegistryLite);
                                if (builder3 != null) {
                                    builder3.mergeFrom((a.e.C0003a) this.e);
                                    this.e = builder3.buildPartial();
                                }
                            } else if (readTag != 48) {
                                if (!codedInputStream.skipField(readTag)) {
                                    r1 = true;
                                }
                            } else {
                                this.f = codedInputStream.readInt32();
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
                    if (h == null) {
                        synchronized (d.class) {
                            if (h == null) {
                                h = new GeneratedMessageLite.DefaultInstanceBasedParser(g);
                            }
                        }
                    }
                    return h;
                default:
                    throw new UnsupportedOperationException();
            }
            return g;
        }

        static {
            g.makeImmutable();
        }

        public static Parser<d> f() {
            return g.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$o */
    /* loaded from: classes.dex */
    public static final class o extends GeneratedMessageLite<o, C0041b> implements p {
        private static final o e = new o();
        private static volatile Parser<o> f;
        private int a;
        private int b;
        private int c;
        private Internal.ProtobufList<m> d = emptyProtobufList();

        private o() {
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$o$a */
        /* loaded from: classes.dex */
        public enum a implements Internal.EnumLite {
            ApTraj_TYPE_UNKNOWN(0),
            ApTraj_TYPE_B(1),
            ApTraj_TYPE_real_ap_plan(2),
            ApTraj_TYPE_global(3),
            UNRECOGNIZED(-1);
            
            public static final int ApTraj_TYPE_B_VALUE = 1;
            public static final int ApTraj_TYPE_UNKNOWN_VALUE = 0;
            public static final int ApTraj_TYPE_global_VALUE = 3;
            public static final int ApTraj_TYPE_real_ap_plan_VALUE = 2;
            private static final Internal.EnumLiteMap<a> a = new Internal.EnumLiteMap<a>() { // from class: b.o.a.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public a findValueByNumber(int i) {
                    return a.forNumber(i);
                }
            };
            private final int b;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.b;
            }

            @Deprecated
            public static a valueOf(int i) {
                return forNumber(i);
            }

            public static a forNumber(int i) {
                switch (i) {
                    case 0:
                        return ApTraj_TYPE_UNKNOWN;
                    case 1:
                        return ApTraj_TYPE_B;
                    case 2:
                        return ApTraj_TYPE_real_ap_plan;
                    case 3:
                        return ApTraj_TYPE_global;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<a> internalGetValueMap() {
                return a;
            }

            a(int i) {
                this.b = i;
            }
        }

        public int a() {
            return this.c;
        }

        public List<m> b() {
            return this.d;
        }

        public List<? extends n> c() {
            return this.d;
        }

        public int d() {
            return this.d.size();
        }

        public m a(int i) {
            return this.d.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.b;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            if (this.c != a.ApTraj_TYPE_UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(2, this.c);
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                codedOutputStream.writeMessage(3, this.d.get(i2));
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
            if (this.c != a.ApTraj_TYPE_UNKNOWN.getNumber()) {
                computeInt32Size += CodedOutputStream.computeEnumSize(2, this.c);
            }
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                computeInt32Size += CodedOutputStream.computeMessageSize(3, this.d.get(i3));
            }
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$o$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0041b extends GeneratedMessageLite.Builder<o, C0041b> implements p {
            private C0041b() {
                super(o.e);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new o();
                case IS_INITIALIZED:
                    return e;
                case MAKE_IMMUTABLE:
                    this.d.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new C0041b();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    o oVar = (o) obj2;
                    this.b = visitor.visitInt(this.b != 0, this.b, oVar.b != 0, oVar.b);
                    this.c = visitor.visitInt(this.c != 0, this.c, oVar.c != 0, oVar.c);
                    this.d = visitor.visitList(this.d, oVar.d);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= oVar.a;
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
                                this.c = codedInputStream.readEnum();
                            } else if (readTag != 26) {
                                if (!codedInputStream.skipField(readTag)) {
                                    r1 = true;
                                }
                            } else {
                                if (!this.d.isModifiable()) {
                                    this.d = GeneratedMessageLite.mutableCopy(this.d);
                                }
                                this.d.add(codedInputStream.readMessage(m.e(), extensionRegistryLite));
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
                        synchronized (o.class) {
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

        public static o e() {
            return e;
        }

        public static Parser<o> f() {
            return e.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$u */
    /* loaded from: classes.dex */
    public static final class u extends GeneratedMessageLite<u, a> implements v {
        private static final u c = new u();
        private static volatile Parser<u> d;
        private float a;
        private float b;

        private u() {
        }

        public float a() {
            return this.a;
        }

        public float b() {
            return this.b;
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
            this.memoizedSerializedSize = computeFloatSize;
            return computeFloatSize;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$u$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<u, a> implements v {
            private a() {
                super(u.c);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new u();
                case IS_INITIALIZED:
                    return c;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    u uVar = (u) obj2;
                    this.a = visitor.visitFloat(this.a != 0.0f, this.a, uVar.a != 0.0f, uVar.a);
                    this.b = visitor.visitFloat(this.b != 0.0f, this.b, uVar.b != 0.0f, uVar.b);
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
                            } else if (readTag != 21) {
                                if (!codedInputStream.skipField(readTag)) {
                                    r1 = true;
                                }
                            } else {
                                this.b = codedInputStream.readFloat();
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
                        synchronized (u.class) {
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

        public static u c() {
            return c;
        }

        public static Parser<u> d() {
            return c.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$f */
    /* loaded from: classes.dex */
    public static final class f extends GeneratedMessageLite<f, a> implements g {
        private static final f w = new f();
        private static volatile Parser<f> x;
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private float h;
        private u i;
        private int j;
        private int k;
        private int l;
        private int m;
        private long n;
        private int o;
        private int p;
        private int q;
        private int r;
        private Internal.IntList s = emptyIntList();
        private int t;
        private int u;
        private long v;

        private f() {
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public int e() {
            return this.f;
        }

        public int f() {
            return this.g;
        }

        public float g() {
            return this.h;
        }

        public u h() {
            u uVar = this.i;
            return uVar == null ? u.c() : uVar;
        }

        public int i() {
            return this.j;
        }

        public int j() {
            return this.k;
        }

        public int k() {
            return this.l;
        }

        public int l() {
            return this.m;
        }

        public long m() {
            return this.n;
        }

        public int n() {
            return this.o;
        }

        public int o() {
            return this.p;
        }

        public int p() {
            return this.q;
        }

        public int q() {
            return this.r;
        }

        public List<Integer> r() {
            return this.s;
        }

        public int s() {
            return this.t;
        }

        public int t() {
            return this.u;
        }

        public long u() {
            return this.v;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
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
            int i4 = this.e;
            if (i4 != 0) {
                codedOutputStream.writeInt32(4, i4);
            }
            int i5 = this.f;
            if (i5 != 0) {
                codedOutputStream.writeInt32(5, i5);
            }
            int i6 = this.g;
            if (i6 != 0) {
                codedOutputStream.writeInt32(6, i6);
            }
            float f = this.h;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(7, f);
            }
            if (this.i != null) {
                codedOutputStream.writeMessage(8, h());
            }
            int i7 = this.j;
            if (i7 != 0) {
                codedOutputStream.writeInt32(9, i7);
            }
            int i8 = this.k;
            if (i8 != 0) {
                codedOutputStream.writeInt32(10, i8);
            }
            int i9 = this.l;
            if (i9 != 0) {
                codedOutputStream.writeInt32(11, i9);
            }
            int i10 = this.m;
            if (i10 != 0) {
                codedOutputStream.writeInt32(12, i10);
            }
            long j = this.n;
            if (j != 0) {
                codedOutputStream.writeUInt64(13, j);
            }
            int i11 = this.o;
            if (i11 != 0) {
                codedOutputStream.writeInt32(14, i11);
            }
            int i12 = this.p;
            if (i12 != 0) {
                codedOutputStream.writeInt32(15, i12);
            }
            int i13 = this.q;
            if (i13 != 0) {
                codedOutputStream.writeInt32(16, i13);
            }
            int i14 = this.r;
            if (i14 != 0) {
                codedOutputStream.writeInt32(17, i14);
            }
            for (int i15 = 0; i15 < this.s.size(); i15++) {
                codedOutputStream.writeInt32(18, this.s.getInt(i15));
            }
            int i16 = this.t;
            if (i16 != 0) {
                codedOutputStream.writeInt32(19, i16);
            }
            int i17 = this.u;
            if (i17 != 0) {
                codedOutputStream.writeInt32(20, i17);
            }
            long j2 = this.v;
            if (j2 != 0) {
                codedOutputStream.writeUInt64(21, j2);
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
            int i5 = this.e;
            if (i5 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, i5);
            }
            int i6 = this.f;
            if (i6 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, i6);
            }
            int i7 = this.g;
            if (i7 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(6, i7);
            }
            float f = this.h;
            if (f != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(7, f);
            }
            if (this.i != null) {
                computeInt32Size += CodedOutputStream.computeMessageSize(8, h());
            }
            int i8 = this.j;
            if (i8 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(9, i8);
            }
            int i9 = this.k;
            if (i9 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(10, i9);
            }
            int i10 = this.l;
            if (i10 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(11, i10);
            }
            int i11 = this.m;
            if (i11 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(12, i11);
            }
            long j = this.n;
            if (j != 0) {
                computeInt32Size += CodedOutputStream.computeUInt64Size(13, j);
            }
            int i12 = this.o;
            if (i12 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(14, i12);
            }
            int i13 = this.p;
            if (i13 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(15, i13);
            }
            int i14 = this.q;
            if (i14 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(16, i14);
            }
            int i15 = this.r;
            if (i15 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(17, i15);
            }
            int i16 = 0;
            for (int i17 = 0; i17 < this.s.size(); i17++) {
                i16 += CodedOutputStream.computeInt32SizeNoTag(this.s.getInt(i17));
            }
            int size = computeInt32Size + i16 + (r().size() * 2);
            int i18 = this.t;
            if (i18 != 0) {
                size += CodedOutputStream.computeInt32Size(19, i18);
            }
            int i19 = this.u;
            if (i19 != 0) {
                size += CodedOutputStream.computeInt32Size(20, i19);
            }
            long j2 = this.v;
            if (j2 != 0) {
                size += CodedOutputStream.computeUInt64Size(21, j2);
            }
            this.memoizedSerializedSize = size;
            return size;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$f$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<f, a> implements g {
            private a() {
                super(f.w);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new f();
                case IS_INITIALIZED:
                    return w;
                case MAKE_IMMUTABLE:
                    this.s.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    f fVar = (f) obj2;
                    this.b = visitor.visitInt(this.b != 0, this.b, fVar.b != 0, fVar.b);
                    this.c = visitor.visitInt(this.c != 0, this.c, fVar.c != 0, fVar.c);
                    this.d = visitor.visitInt(this.d != 0, this.d, fVar.d != 0, fVar.d);
                    this.e = visitor.visitInt(this.e != 0, this.e, fVar.e != 0, fVar.e);
                    this.f = visitor.visitInt(this.f != 0, this.f, fVar.f != 0, fVar.f);
                    this.g = visitor.visitInt(this.g != 0, this.g, fVar.g != 0, fVar.g);
                    this.h = visitor.visitFloat(this.h != 0.0f, this.h, fVar.h != 0.0f, fVar.h);
                    this.i = (u) visitor.visitMessage(this.i, fVar.i);
                    this.j = visitor.visitInt(this.j != 0, this.j, fVar.j != 0, fVar.j);
                    this.k = visitor.visitInt(this.k != 0, this.k, fVar.k != 0, fVar.k);
                    this.l = visitor.visitInt(this.l != 0, this.l, fVar.l != 0, fVar.l);
                    this.m = visitor.visitInt(this.m != 0, this.m, fVar.m != 0, fVar.m);
                    this.n = visitor.visitLong(this.n != 0, this.n, fVar.n != 0, fVar.n);
                    this.o = visitor.visitInt(this.o != 0, this.o, fVar.o != 0, fVar.o);
                    this.p = visitor.visitInt(this.p != 0, this.p, fVar.p != 0, fVar.p);
                    this.q = visitor.visitInt(this.q != 0, this.q, fVar.q != 0, fVar.q);
                    this.r = visitor.visitInt(this.r != 0, this.r, fVar.r != 0, fVar.r);
                    this.s = visitor.visitIntList(this.s, fVar.s);
                    this.t = visitor.visitInt(this.t != 0, this.t, fVar.t != 0, fVar.t);
                    this.u = visitor.visitInt(this.u != 0, this.u, fVar.u != 0, fVar.u);
                    this.v = visitor.visitLong(this.v != 0, this.v, fVar.v != 0, fVar.v);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= fVar.a;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.b = codedInputStream.readInt32();
                                    break;
                                case 16:
                                    this.c = codedInputStream.readInt32();
                                    break;
                                case 24:
                                    this.d = codedInputStream.readInt32();
                                    break;
                                case 32:
                                    this.e = codedInputStream.readInt32();
                                    break;
                                case 40:
                                    this.f = codedInputStream.readInt32();
                                    break;
                                case 48:
                                    this.g = codedInputStream.readInt32();
                                    break;
                                case 61:
                                    this.h = codedInputStream.readFloat();
                                    break;
                                case 66:
                                    u.a builder = this.i != null ? this.i.toBuilder() : null;
                                    this.i = (u) codedInputStream.readMessage(u.d(), extensionRegistryLite);
                                    if (builder == null) {
                                        break;
                                    } else {
                                        builder.mergeFrom((u.a) this.i);
                                        this.i = builder.buildPartial();
                                        break;
                                    }
                                case 72:
                                    this.j = codedInputStream.readInt32();
                                    break;
                                case 80:
                                    this.k = codedInputStream.readInt32();
                                    break;
                                case 88:
                                    this.l = codedInputStream.readInt32();
                                    break;
                                case 96:
                                    this.m = codedInputStream.readInt32();
                                    break;
                                case 104:
                                    this.n = codedInputStream.readUInt64();
                                    break;
                                case 112:
                                    this.o = codedInputStream.readInt32();
                                    break;
                                case 120:
                                    this.p = codedInputStream.readInt32();
                                    break;
                                case 128:
                                    this.q = codedInputStream.readInt32();
                                    break;
                                case 136:
                                    this.r = codedInputStream.readInt32();
                                    break;
                                case 144:
                                    if (!this.s.isModifiable()) {
                                        this.s = GeneratedMessageLite.mutableCopy(this.s);
                                    }
                                    this.s.addInt(codedInputStream.readInt32());
                                    break;
                                case 146:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.s.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.s = GeneratedMessageLite.mutableCopy(this.s);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.s.addInt(codedInputStream.readInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    break;
                                case 152:
                                    this.t = codedInputStream.readInt32();
                                    break;
                                case 160:
                                    this.u = codedInputStream.readInt32();
                                    break;
                                case 168:
                                    this.v = codedInputStream.readUInt64();
                                    break;
                                default:
                                    if (!codedInputStream.skipField(readTag)) {
                                        z = true;
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
                    if (x == null) {
                        synchronized (f.class) {
                            if (x == null) {
                                x = new GeneratedMessageLite.DefaultInstanceBasedParser(w);
                            }
                        }
                    }
                    return x;
                default:
                    throw new UnsupportedOperationException();
            }
            return w;
        }

        static {
            w.makeImmutable();
        }

        public static f v() {
            return w;
        }

        public static Parser<f> w() {
            return w.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$j */
    /* loaded from: classes.dex */
    public static final class j extends GeneratedMessageLite<j, a> implements k {
        private static final j f = new j();
        private static volatile Parser<j> g;
        private int a;
        private int b;
        private float c;
        private float d;
        private int e;

        private j() {
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public float c() {
            return this.c;
        }

        public float d() {
            return this.d;
        }

        public int e() {
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
            int i3 = this.e;
            if (i3 != 0) {
                codedOutputStream.writeInt32(5, i3);
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
            int i4 = this.e;
            if (i4 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(5, i4);
            }
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$j$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<j, a> implements k {
            private a() {
                super(j.f);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new j();
                case IS_INITIALIZED:
                    return f;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    j jVar = (j) obj2;
                    this.a = visitor.visitInt(this.a != 0, this.a, jVar.a != 0, jVar.a);
                    this.b = visitor.visitInt(this.b != 0, this.b, jVar.b != 0, jVar.b);
                    this.c = visitor.visitFloat(this.c != 0.0f, this.c, jVar.c != 0.0f, jVar.c);
                    this.d = visitor.visitFloat(this.d != 0.0f, this.d, jVar.d != 0.0f, jVar.d);
                    this.e = visitor.visitInt(this.e != 0, this.e, jVar.e != 0, jVar.e);
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
                            } else if (readTag == 37) {
                                this.d = codedInputStream.readFloat();
                            } else if (readTag != 40) {
                                if (!codedInputStream.skipField(readTag)) {
                                    r1 = true;
                                }
                            } else {
                                this.e = codedInputStream.readInt32();
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

        public static j f() {
            return f;
        }

        public static Parser<j> g() {
            return f.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$aa */
    /* loaded from: classes.dex */
    public static final class aa extends GeneratedMessageLite<aa, a> implements ab {
        private static final aa g = new aa();
        private static volatile Parser<aa> h;
        private int a;
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;

        private aa() {
        }

        public int a() {
            return this.a;
        }

        public float b() {
            return this.b;
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

        public float f() {
            return this.f;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.a;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            float f = this.b;
            if (f != 0.0f) {
                codedOutputStream.writeFloat(2, f);
            }
            float f2 = this.c;
            if (f2 != 0.0f) {
                codedOutputStream.writeFloat(3, f2);
            }
            float f3 = this.d;
            if (f3 != 0.0f) {
                codedOutputStream.writeFloat(4, f3);
            }
            float f4 = this.e;
            if (f4 != 0.0f) {
                codedOutputStream.writeFloat(5, f4);
            }
            float f5 = this.f;
            if (f5 != 0.0f) {
                codedOutputStream.writeFloat(6, f5);
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
            float f = this.b;
            if (f != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(2, f);
            }
            float f2 = this.c;
            if (f2 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(3, f2);
            }
            float f3 = this.d;
            if (f3 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(4, f3);
            }
            float f4 = this.e;
            if (f4 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(5, f4);
            }
            float f5 = this.f;
            if (f5 != 0.0f) {
                computeInt32Size += CodedOutputStream.computeFloatSize(6, f5);
            }
            this.memoizedSerializedSize = computeInt32Size;
            return computeInt32Size;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$aa$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<aa, a> implements ab {
            private a() {
                super(aa.g);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new aa();
                case IS_INITIALIZED:
                    return g;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    aa aaVar = (aa) obj2;
                    this.a = visitor.visitInt(this.a != 0, this.a, aaVar.a != 0, aaVar.a);
                    this.b = visitor.visitFloat(this.b != 0.0f, this.b, aaVar.b != 0.0f, aaVar.b);
                    this.c = visitor.visitFloat(this.c != 0.0f, this.c, aaVar.c != 0.0f, aaVar.c);
                    this.d = visitor.visitFloat(this.d != 0.0f, this.d, aaVar.d != 0.0f, aaVar.d);
                    this.e = visitor.visitFloat(this.e != 0.0f, this.e, aaVar.e != 0.0f, aaVar.e);
                    this.f = visitor.visitFloat(this.f != 0.0f, this.f, aaVar.f != 0.0f, aaVar.f);
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
                            } else if (readTag == 37) {
                                this.d = codedInputStream.readFloat();
                            } else if (readTag == 45) {
                                this.e = codedInputStream.readFloat();
                            } else if (readTag != 53) {
                                if (!codedInputStream.skipField(readTag)) {
                                    r1 = true;
                                }
                            } else {
                                this.f = codedInputStream.readFloat();
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
                    if (h == null) {
                        synchronized (aa.class) {
                            if (h == null) {
                                h = new GeneratedMessageLite.DefaultInstanceBasedParser(g);
                            }
                        }
                    }
                    return h;
                default:
                    throw new UnsupportedOperationException();
            }
            return g;
        }

        static {
            g.makeImmutable();
        }

        public static Parser<aa> g() {
            return g.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$w */
    /* loaded from: classes.dex */
    public static final class w extends GeneratedMessageLite<w, a> implements x {
        private static final w c = new w();
        private static volatile Parser<w> d;
        private int a;
        private int b;

        private w() {
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

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$w$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<w, a> implements x {
            private a() {
                super(w.c);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new w();
                case IS_INITIALIZED:
                    return c;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    w wVar = (w) obj2;
                    this.a = visitor.visitInt(this.a != 0, this.a, wVar.a != 0, wVar.a);
                    this.b = visitor.visitInt(this.b != 0, this.b, wVar.b != 0, wVar.b);
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
                        synchronized (w.class) {
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

        public static Parser<w> c() {
            return c.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$s */
    /* loaded from: classes.dex */
    public static final class s extends GeneratedMessageLite<s, a> implements t {
        private static final s c = new s();
        private static volatile Parser<s> d;
        private a.e a;
        private boolean b;

        private s() {
        }

        public a.e a() {
            a.e eVar = this.a;
            return eVar == null ? a.e.d() : eVar;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.a != null) {
                codedOutputStream.writeMessage(1, a());
            }
            boolean z = this.b;
            if (z) {
                codedOutputStream.writeBool(2, z);
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.a != null ? 0 + CodedOutputStream.computeMessageSize(1, a()) : 0;
            boolean z = this.b;
            if (z) {
                computeMessageSize += CodedOutputStream.computeBoolSize(2, z);
            }
            this.memoizedSerializedSize = computeMessageSize;
            return computeMessageSize;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$s$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<s, a> implements t {
            private a() {
                super(s.c);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new s();
                case IS_INITIALIZED:
                    return c;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    s sVar = (s) obj2;
                    this.a = (a.e) visitor.visitMessage(this.a, sVar.a);
                    boolean z = this.b;
                    boolean z2 = sVar.b;
                    this.b = visitor.visitBoolean(z, z, z2, z2);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z3 = false;
                    while (!z3) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag == 0) {
                                z3 = true;
                            } else if (readTag == 10) {
                                a.e.C0003a builder = this.a != null ? this.a.toBuilder() : null;
                                this.a = (a.e) codedInputStream.readMessage(a.e.e(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((a.e.C0003a) this.a);
                                    this.a = builder.buildPartial();
                                }
                            } else if (readTag != 16) {
                                if (!codedInputStream.skipField(readTag)) {
                                    z3 = true;
                                }
                            } else {
                                this.b = codedInputStream.readBool();
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
                        synchronized (s.class) {
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

        public static Parser<s> b() {
            return c.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$q */
    /* loaded from: classes.dex */
    public static final class q extends GeneratedMessageLite<q, a> implements r {
        private static final q j = new q();
        private static volatile Parser<q> k;
        private int a;
        private int b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private Internal.FloatList g = emptyFloatList();
        private Internal.DoubleList h = emptyDoubleList();
        private Internal.ProtobufList<s> i = emptyProtobufList();

        private q() {
        }

        public int a() {
            return this.b;
        }

        public a b() {
            a forNumber = a.forNumber(this.c);
            return forNumber == null ? a.UNRECOGNIZED : forNumber;
        }

        public List<Float> c() {
            return this.g;
        }

        public List<Double> d() {
            return this.h;
        }

        public double a(int i) {
            return this.h.getDouble(i);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            int i = this.b;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (this.c != a.kWheelStopper.getNumber()) {
                codedOutputStream.writeEnum(2, this.c);
            }
            boolean z = this.d;
            if (z) {
                codedOutputStream.writeBool(3, z);
            }
            boolean z2 = this.e;
            if (z2) {
                codedOutputStream.writeBool(4, z2);
            }
            boolean z3 = this.f;
            if (z3) {
                codedOutputStream.writeBool(5, z3);
            }
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                codedOutputStream.writeFloat(6, this.g.getFloat(i2));
            }
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                codedOutputStream.writeDouble(7, this.h.getDouble(i3));
            }
            for (int i4 = 0; i4 < this.i.size(); i4++) {
                codedOutputStream.writeMessage(8, this.i.get(i4));
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
            if (this.c != a.kWheelStopper.getNumber()) {
                computeUInt32Size += CodedOutputStream.computeEnumSize(2, this.c);
            }
            boolean z = this.d;
            if (z) {
                computeUInt32Size += CodedOutputStream.computeBoolSize(3, z);
            }
            boolean z2 = this.e;
            if (z2) {
                computeUInt32Size += CodedOutputStream.computeBoolSize(4, z2);
            }
            boolean z3 = this.f;
            if (z3) {
                computeUInt32Size += CodedOutputStream.computeBoolSize(5, z3);
            }
            int size = computeUInt32Size + (c().size() * 4) + (c().size() * 1) + (d().size() * 8) + (d().size() * 1);
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                size += CodedOutputStream.computeMessageSize(8, this.i.get(i3));
            }
            this.memoizedSerializedSize = size;
            return size;
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$q$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<q, a> implements r {
            private a() {
                super(q.j);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v52, types: [com.google.protobuf.Internal$DoubleList] */
        /* JADX WARN: Type inference failed for: r6v67, types: [com.google.protobuf.Internal$FloatList] */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new q();
                case IS_INITIALIZED:
                    return j;
                case MAKE_IMMUTABLE:
                    this.g.makeImmutable();
                    this.h.makeImmutable();
                    this.i.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    q qVar = (q) obj2;
                    this.b = visitor.visitInt(this.b != 0, this.b, qVar.b != 0, qVar.b);
                    this.c = visitor.visitInt(this.c != 0, this.c, qVar.c != 0, qVar.c);
                    boolean z = this.d;
                    boolean z2 = qVar.d;
                    this.d = visitor.visitBoolean(z, z, z2, z2);
                    boolean z3 = this.e;
                    boolean z4 = qVar.e;
                    this.e = visitor.visitBoolean(z3, z3, z4, z4);
                    boolean z5 = this.f;
                    boolean z6 = qVar.f;
                    this.f = visitor.visitBoolean(z5, z5, z6, z6);
                    this.g = visitor.visitFloatList(this.g, qVar.g);
                    this.h = visitor.visitDoubleList(this.h, qVar.h);
                    this.i = visitor.visitList(this.i, qVar.i);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= qVar.a;
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
                                this.b = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.c = codedInputStream.readEnum();
                            } else if (readTag == 24) {
                                this.d = codedInputStream.readBool();
                            } else if (readTag == 32) {
                                this.e = codedInputStream.readBool();
                            } else if (readTag == 40) {
                                this.f = codedInputStream.readBool();
                            } else if (readTag == 50) {
                                int readRawVarint32 = codedInputStream.readRawVarint32();
                                int pushLimit = codedInputStream.pushLimit(readRawVarint32);
                                if (!this.g.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.g = this.g.mutableCopyWithCapacity(this.g.size() + (readRawVarint32 / 4));
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.g.addFloat(codedInputStream.readFloat());
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 53) {
                                if (!this.g.isModifiable()) {
                                    this.g = GeneratedMessageLite.mutableCopy(this.g);
                                }
                                this.g.addFloat(codedInputStream.readFloat());
                            } else if (readTag != 66) {
                                switch (readTag) {
                                    case 57:
                                        if (!this.h.isModifiable()) {
                                            this.h = GeneratedMessageLite.mutableCopy(this.h);
                                        }
                                        this.h.addDouble(codedInputStream.readDouble());
                                        continue;
                                    case 58:
                                        int readRawVarint322 = codedInputStream.readRawVarint32();
                                        int pushLimit2 = codedInputStream.pushLimit(readRawVarint322);
                                        if (!this.h.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.h = this.h.mutableCopyWithCapacity(this.h.size() + (readRawVarint322 / 8));
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.h.addDouble(codedInputStream.readDouble());
                                        }
                                        codedInputStream.popLimit(pushLimit2);
                                        continue;
                                    default:
                                        if (!codedInputStream.skipField(readTag)) {
                                            r1 = true;
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                            } else {
                                if (!this.i.isModifiable()) {
                                    this.i = GeneratedMessageLite.mutableCopy(this.i);
                                }
                                this.i.add(codedInputStream.readMessage(s.b(), extensionRegistryLite));
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
                    if (k == null) {
                        synchronized (q.class) {
                            if (k == null) {
                                k = new GeneratedMessageLite.DefaultInstanceBasedParser(j);
                            }
                        }
                    }
                    return k;
                default:
                    throw new UnsupportedOperationException();
            }
            return j;
        }

        static {
            j.makeImmutable();
        }

        public static Parser<q> e() {
            return j.getParserForType();
        }
    }

    /* compiled from: WMDisplayRealtime.java */
    /* renamed from: b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0040b extends GeneratedMessageLite<C0040b, a> implements c {
        private static final C0040b o = new C0040b();
        private static volatile Parser<C0040b> p;
        private int a;
        private a.c b;
        private f i;
        private j n;
        private Internal.ProtobufList<a.k> c = emptyProtobufList();
        private Internal.ProtobufList<y> d = emptyProtobufList();
        private Internal.ProtobufList<h> e = emptyProtobufList();
        private Internal.IntList f = emptyIntList();
        private Internal.ProtobufList<o> g = emptyProtobufList();
        private Internal.ProtobufList<d> h = emptyProtobufList();
        private Internal.ProtobufList<a.k> j = emptyProtobufList();
        private Internal.ProtobufList<aa> k = emptyProtobufList();
        private Internal.ProtobufList<w> l = emptyProtobufList();
        private Internal.ProtobufList<q> m = emptyProtobufList();

        private C0040b() {
        }

        public a.c a() {
            a.c cVar = this.b;
            return cVar == null ? a.c.h() : cVar;
        }

        public List<a.k> b() {
            return this.c;
        }

        public List<h> c() {
            return this.e;
        }

        public List<Integer> d() {
            return this.f;
        }

        public List<o> e() {
            return this.g;
        }

        public List<d> f() {
            return this.h;
        }

        public boolean g() {
            return this.i != null;
        }

        public f h() {
            f fVar = this.i;
            return fVar == null ? f.v() : fVar;
        }

        public List<a.k> i() {
            return this.j;
        }

        public List<aa> j() {
            return this.k;
        }

        public List<w> k() {
            return this.l;
        }

        public int l() {
            return this.l.size();
        }

        public List<q> m() {
            return this.m;
        }

        public boolean n() {
            return this.n != null;
        }

        public j o() {
            j jVar = this.n;
            return jVar == null ? j.f() : jVar;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (this.b != null) {
                codedOutputStream.writeMessage(1, a());
            }
            for (int i = 0; i < this.c.size(); i++) {
                codedOutputStream.writeMessage(2, this.c.get(i));
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                codedOutputStream.writeMessage(3, this.d.get(i2));
            }
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                codedOutputStream.writeMessage(4, this.e.get(i3));
            }
            for (int i4 = 0; i4 < this.f.size(); i4++) {
                codedOutputStream.writeInt32(5, this.f.getInt(i4));
            }
            for (int i5 = 0; i5 < this.g.size(); i5++) {
                codedOutputStream.writeMessage(6, this.g.get(i5));
            }
            for (int i6 = 0; i6 < this.h.size(); i6++) {
                codedOutputStream.writeMessage(7, this.h.get(i6));
            }
            if (this.i != null) {
                codedOutputStream.writeMessage(8, h());
            }
            for (int i7 = 0; i7 < this.j.size(); i7++) {
                codedOutputStream.writeMessage(9, this.j.get(i7));
            }
            for (int i8 = 0; i8 < this.k.size(); i8++) {
                codedOutputStream.writeMessage(10, this.k.get(i8));
            }
            for (int i9 = 0; i9 < this.l.size(); i9++) {
                codedOutputStream.writeMessage(11, this.l.get(i9));
            }
            for (int i10 = 0; i10 < this.m.size(); i10++) {
                codedOutputStream.writeMessage(12, this.m.get(i10));
            }
            if (this.n != null) {
                codedOutputStream.writeMessage(13, o());
            }
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.b != null ? CodedOutputStream.computeMessageSize(1, a()) + 0 : 0;
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.c.get(i2));
            }
            for (int i3 = 0; i3 < this.d.size(); i3++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, this.d.get(i3));
            }
            for (int i4 = 0; i4 < this.e.size(); i4++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, this.e.get(i4));
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.f.size(); i6++) {
                i5 += CodedOutputStream.computeInt32SizeNoTag(this.f.getInt(i6));
            }
            int size = computeMessageSize + i5 + (d().size() * 1);
            for (int i7 = 0; i7 < this.g.size(); i7++) {
                size += CodedOutputStream.computeMessageSize(6, this.g.get(i7));
            }
            for (int i8 = 0; i8 < this.h.size(); i8++) {
                size += CodedOutputStream.computeMessageSize(7, this.h.get(i8));
            }
            if (this.i != null) {
                size += CodedOutputStream.computeMessageSize(8, h());
            }
            for (int i9 = 0; i9 < this.j.size(); i9++) {
                size += CodedOutputStream.computeMessageSize(9, this.j.get(i9));
            }
            for (int i10 = 0; i10 < this.k.size(); i10++) {
                size += CodedOutputStream.computeMessageSize(10, this.k.get(i10));
            }
            for (int i11 = 0; i11 < this.l.size(); i11++) {
                size += CodedOutputStream.computeMessageSize(11, this.l.get(i11));
            }
            for (int i12 = 0; i12 < this.m.size(); i12++) {
                size += CodedOutputStream.computeMessageSize(12, this.m.get(i12));
            }
            if (this.n != null) {
                size += CodedOutputStream.computeMessageSize(13, o());
            }
            this.memoizedSerializedSize = size;
            return size;
        }

        public static C0040b a(byte[] bArr) throws InvalidProtocolBufferException {
            return (C0040b) GeneratedMessageLite.parseFrom(o, bArr);
        }

        /* compiled from: WMDisplayRealtime.java */
        /* renamed from: b$b$a */
        /* loaded from: classes.dex */
        public static final class a extends GeneratedMessageLite.Builder<C0040b, a> implements c {
            private a() {
                super(C0040b.o);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new C0040b();
                case IS_INITIALIZED:
                    return o;
                case MAKE_IMMUTABLE:
                    this.c.makeImmutable();
                    this.d.makeImmutable();
                    this.e.makeImmutable();
                    this.f.makeImmutable();
                    this.g.makeImmutable();
                    this.h.makeImmutable();
                    this.j.makeImmutable();
                    this.k.makeImmutable();
                    this.l.makeImmutable();
                    this.m.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new a();
                case VISIT:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    C0040b c0040b = (C0040b) obj2;
                    this.b = (a.c) visitor.visitMessage(this.b, c0040b.b);
                    this.c = visitor.visitList(this.c, c0040b.c);
                    this.d = visitor.visitList(this.d, c0040b.d);
                    this.e = visitor.visitList(this.e, c0040b.e);
                    this.f = visitor.visitIntList(this.f, c0040b.f);
                    this.g = visitor.visitList(this.g, c0040b.g);
                    this.h = visitor.visitList(this.h, c0040b.h);
                    this.i = (f) visitor.visitMessage(this.i, c0040b.i);
                    this.j = visitor.visitList(this.j, c0040b.j);
                    this.k = visitor.visitList(this.k, c0040b.k);
                    this.l = visitor.visitList(this.l, c0040b.l);
                    this.m = visitor.visitList(this.m, c0040b.m);
                    this.n = (j) visitor.visitMessage(this.n, c0040b.n);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.a |= c0040b.a;
                    }
                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    a.c.C0002a builder = this.b != null ? this.b.toBuilder() : null;
                                    this.b = (a.c) codedInputStream.readMessage(a.c.i(), extensionRegistryLite);
                                    if (builder == null) {
                                        break;
                                    } else {
                                        builder.mergeFrom((a.c.C0002a) this.b);
                                        this.b = builder.buildPartial();
                                        break;
                                    }
                                case 18:
                                    if (!this.c.isModifiable()) {
                                        this.c = GeneratedMessageLite.mutableCopy(this.c);
                                    }
                                    this.c.add(codedInputStream.readMessage(a.k.p(), extensionRegistryLite));
                                    break;
                                case 26:
                                    if (!this.d.isModifiable()) {
                                        this.d = GeneratedMessageLite.mutableCopy(this.d);
                                    }
                                    this.d.add(codedInputStream.readMessage(y.c(), extensionRegistryLite));
                                    break;
                                case 34:
                                    if (!this.e.isModifiable()) {
                                        this.e = GeneratedMessageLite.mutableCopy(this.e);
                                    }
                                    this.e.add(codedInputStream.readMessage(h.b(), extensionRegistryLite));
                                    break;
                                case 40:
                                    if (!this.f.isModifiable()) {
                                        this.f = GeneratedMessageLite.mutableCopy(this.f);
                                    }
                                    this.f.addInt(codedInputStream.readInt32());
                                    break;
                                case 42:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.f.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.f = GeneratedMessageLite.mutableCopy(this.f);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.f.addInt(codedInputStream.readInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    break;
                                case 50:
                                    if (!this.g.isModifiable()) {
                                        this.g = GeneratedMessageLite.mutableCopy(this.g);
                                    }
                                    this.g.add(codedInputStream.readMessage(o.f(), extensionRegistryLite));
                                    break;
                                case 58:
                                    if (!this.h.isModifiable()) {
                                        this.h = GeneratedMessageLite.mutableCopy(this.h);
                                    }
                                    this.h.add(codedInputStream.readMessage(d.f(), extensionRegistryLite));
                                    break;
                                case 66:
                                    f.a builder2 = this.i != null ? this.i.toBuilder() : null;
                                    this.i = (f) codedInputStream.readMessage(f.w(), extensionRegistryLite);
                                    if (builder2 == null) {
                                        break;
                                    } else {
                                        builder2.mergeFrom((f.a) this.i);
                                        this.i = builder2.buildPartial();
                                        break;
                                    }
                                case 74:
                                    if (!this.j.isModifiable()) {
                                        this.j = GeneratedMessageLite.mutableCopy(this.j);
                                    }
                                    this.j.add(codedInputStream.readMessage(a.k.p(), extensionRegistryLite));
                                    break;
                                case 82:
                                    if (!this.k.isModifiable()) {
                                        this.k = GeneratedMessageLite.mutableCopy(this.k);
                                    }
                                    this.k.add(codedInputStream.readMessage(aa.g(), extensionRegistryLite));
                                    break;
                                case 90:
                                    if (!this.l.isModifiable()) {
                                        this.l = GeneratedMessageLite.mutableCopy(this.l);
                                    }
                                    this.l.add(codedInputStream.readMessage(w.c(), extensionRegistryLite));
                                    break;
                                case 98:
                                    if (!this.m.isModifiable()) {
                                        this.m = GeneratedMessageLite.mutableCopy(this.m);
                                    }
                                    this.m.add(codedInputStream.readMessage(q.e(), extensionRegistryLite));
                                    break;
                                case 106:
                                    j.a builder3 = this.n != null ? this.n.toBuilder() : null;
                                    this.n = (j) codedInputStream.readMessage(j.g(), extensionRegistryLite);
                                    if (builder3 == null) {
                                        break;
                                    } else {
                                        builder3.mergeFrom((j.a) this.n);
                                        this.n = builder3.buildPartial();
                                        break;
                                    }
                                default:
                                    if (!codedInputStream.skipField(readTag)) {
                                        z = true;
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
                        synchronized (C0040b.class) {
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
    }
}
