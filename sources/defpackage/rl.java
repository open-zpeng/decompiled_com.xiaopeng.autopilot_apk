package defpackage;

import android.graphics.Point;
import java.util.HashMap;
/* compiled from: IStatisService.java */
/* renamed from: rl  reason: default package */
/* loaded from: classes.dex */
public interface rl {
    void statisBrakeState(int i, int i2, int i3);

    void statisChooseParkingLot(HashMap<String, String> hashMap);

    void statisClickScreen(Point point);

    void statisEnter360Camera(int i);

    void statisEnterAutopilotMethod(String str);

    void statisEnterHelp();

    void statisExit();

    void statisGear(int i);

    void statisGoOn();

    void statisParkingError();

    void statisParkingSuccess(String str);

    void statisStartAutopilot(boolean z, boolean z2);
}
