package defpackage;

import com.xiaopeng.autopilot.x.protocol.bean.gson.TrainingMapObjects;
import com.xiaopeng.sr.bean.ApMapBean;
import defpackage.ahz;
import defpackage.b;
import java.util.List;
/* compiled from: XpuMessageListener.java */
/* renamed from: abi  reason: default package */
/* loaded from: classes.dex */
public interface abi {
    void onAllGuildlineChange(b.o oVar);

    void onApFailReason(int i);

    void onApMapStateChange(ApMapBean apMapBean);

    void onArrow(int i);

    void onBDistancePercent(float f, float f2);

    void onDrivingDataMessage(b.C0040b c0040b);

    void onGlobalTrajectoryIndex(int i);

    void onHDMapCallBack(int i, int i2);

    void onMapMessage(ahz.c cVar);

    void onMapPoseState(int i);

    void onRemainDistance(float f);

    void onSilentFavoriteState(int i, long j);

    void onStartNavMapReset();

    void onStartNavStateChange(int i);

    void onStartNavTipsChange(int i, float f, float f2, int i2);

    void onStatusIndicate(int i);

    void onTips(int i, int i2);

    void onTrainingMapObjects(TrainingMapObjects trainingMapObjects);

    void onTrainingParkSlotChange(List<b.w> list);

    void onTrainingTips(int i, int i2, int[] iArr);

    void onVoice(int i);
}
