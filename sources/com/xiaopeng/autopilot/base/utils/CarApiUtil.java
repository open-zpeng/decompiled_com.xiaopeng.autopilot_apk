package com.xiaopeng.autopilot.base.utils;

import android.hardware.Camera;
import com.xiaopeng.autopilot.base.c;
import com.xiaopeng.autopilot.base.d;
import com.xiaopeng.lib.utils.LogUtils;
/* loaded from: classes.dex */
public class CarApiUtil {
    private static final String TAG = "CarApiUtil";
    private static int sHomeId = 998;

    public static int getCameraDisplayMode() {
        return 17;
    }

    public static void setCiuVideoOutputMode(int i) {
    }

    public static void setOverlayWorkSt(int i) {
    }

    public static void startParking(Camera camera) {
    }

    public static void autoParkInByXMart(boolean z) {
        try {
            if (z) {
                c.a().d().setAutoParkInState(1);
                LogUtils.i(TAG, "CDU发送信号 = 开始泊车");
            } else {
                c.a().d().setAutoParkInState(2);
                LogUtils.i(TAG, "CDU发送信号 = 取消泊车");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void autoParkOutByXMart(boolean z) {
        try {
            if (z) {
                c.a().d().setAutoParkInState(3);
                LogUtils.i(TAG, "CDU发送信号 = 开始泊出");
            } else {
                c.a().d().setAutoParkInState(2);
                LogUtils.i(TAG, "CDU发送信号 = 取消泊出");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void autoParkOutContinueByXMart() {
        try {
            c.a().d().setAutoParkInState(4);
            LogUtils.i(TAG, "CDU发送信号 = 继续泊出");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void autoParkInContinueByXMart() {
        try {
            c.a().d().setAutoParkInState(4);
            LogUtils.i(TAG, "CDU发送信号 = 继续泊车");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendParkLotRecv(int i) {
        try {
            if (i == 0) {
                c.a().d().setParkLotRecvIndex2Scu(i);
                LogUtils.i(TAG, "CDU发送信号 = 车尾入库标记 " + i);
            } else {
                c.a().d().setParkLotRecvIndex2Scu(i);
                LogUtils.i(TAG, "CDU发送信号 = 车头入库标记 " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendParkLotChose(int i) {
        try {
            c.a().d().setParkLotChoseIndex2Scu(i);
            if (d.c()) {
                LogUtils.i(TAG, "CDU发送信号 = 选择车位序号 " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void activeSuperParkMode(boolean z) {
        try {
            if (z) {
                LogUtils.i(TAG, "CDU发送信号 = 我要激活超级泊车 ");
            } else {
                LogUtils.i(TAG, "CDU发送信号 = 我要退出超级泊车 ");
            }
            c.a().d().setSuperParkMode(z);
            if (z) {
                LogUtils.i(TAG, "CDU发送信号 = 我要激活超级泊车 success ");
            } else {
                LogUtils.i(TAG, "CDU发送信号 = 我要退出超级泊车 success ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setCameraDisplayMode(Camera camera, int i) {
        if (d.f() || camera == null) {
            return;
        }
        LogUtils.i(TAG, "组件setCameraDisplayMode：" + i);
        try {
            Camera.Parameters cmdControlParameters = camera.getCmdControlParameters();
            cmdControlParameters.setAvmDisplayMode(i);
            cmdControlParameters.setAvmOverlayWorkSt(1);
            cmdControlParameters.setAvmOutMode(0);
            cmdControlParameters.setAvmCalibration(0);
            cmdControlParameters.setAvmTransparentChassisWorkSt(1);
            camera.setCmdControlParameters(cmdControlParameters);
            LogUtils.i(TAG, "组件setCameraDisplayMode执行完毕：" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setComonHomeSlotId(int i) {
        try {
            c.a().d().setComonHomeSlotId(i);
            if (i != sHomeId) {
                LogUtils.i(TAG, "CDU发送信号 setComonHomeSlotId：" + i);
            }
            sHomeId = i;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFreeParking1Data(float f, float f2, float f3, int i, int i2, float f4, float f5) {
        try {
            c.a().d().setFreeParking1Data(f, f2, f3, i, i2, f4, f5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFreeParking2Data(float f, float f2, float f3, int i, int i2, float f4, float f5) {
        try {
            c.a().d().setFreeParking2Data(f, f2, f3, i, i2, f4, f5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getGear() {
        try {
            return c.a().e().getGearLever();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getPureDriveModeFeedback() {
        try {
            return c.a().e().getPureDriveModeFeedback();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static float getCurrentSpeed() {
        try {
            return c.a().e().getRawCarSpeed();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static int getNedcSwitchStatus() {
        try {
            int nedcSwitchStatus = c.a().h().getNedcSwitchStatus();
            LogUtils.i(TAG, "getNedcSwitchStatus：" + nedcSwitchStatus);
            return nedcSwitchStatus;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getXPilotStatus() {
        try {
            int parkByMemorySwSt = c.a().d().getParkByMemorySwSt();
            LogUtils.i(TAG, "getXPilot.Status：" + parkByMemorySwSt);
            return parkByMemorySwSt;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isApaOn() {
        try {
            return c.a().d().getAutoParkSwitch() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
