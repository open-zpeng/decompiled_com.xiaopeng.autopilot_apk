package defpackage;
/* compiled from: Input.java */
/* renamed from: iq  reason: default package */
/* loaded from: classes.dex */
public interface iq {

    /* compiled from: Input.java */
    /* renamed from: iq$a */
    /* loaded from: classes.dex */
    public enum a {
        Landscape,
        Portrait
    }

    /* compiled from: Input.java */
    /* renamed from: iq$b */
    /* loaded from: classes.dex */
    public enum b {
        HardwareKeyboard,
        OnscreenKeyboard,
        MultitouchScreen,
        Accelerometer,
        Compass,
        Vibrator,
        Gyroscope,
        RotationVector,
        Pressure
    }

    /* compiled from: Input.java */
    /* renamed from: iq$c */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void a(String str);
    }

    long getCurrentEventTime();

    int getX();

    int getY();

    boolean isTouched();

    boolean isTouched(int i);

    void setInputProcessor(it itVar);
}
