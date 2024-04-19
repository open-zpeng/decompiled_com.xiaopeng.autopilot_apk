package com.xiaopeng.autopilot.parking.bean.candata;
/* loaded from: classes.dex */
public class LocatData {
    public float SCU_LocatState;
    public float SCU_Locat_S;
    public float SCU_Locat_theta;
    public float SCU_Locat_theta_pitch;
    public float SCU_Locat_theta_roll;
    public float SCU_Locat_x;
    public float SCU_Locat_y;
    public float SCU_VehLocationMsgCounter;
    public float SCU_Veh_Movement;
    public float SCU_Veh_Speed;

    public LocatData(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.SCU_Locat_x = fArr[0];
        this.SCU_Locat_y = fArr[1];
        this.SCU_VehLocationMsgCounter = fArr[2];
        this.SCU_LocatState = fArr[3];
        this.SCU_Locat_theta = fArr[4];
        this.SCU_Locat_S = fArr[5];
        this.SCU_Locat_theta_roll = fArr[6];
        this.SCU_Locat_theta_pitch = fArr[7];
        this.SCU_Veh_Speed = fArr[8];
        this.SCU_Veh_Movement = fArr[9];
    }

    public String toString() {
        return "LocatData{SCU_Locat_x=" + this.SCU_Locat_x + ", SCU_Locat_y=" + this.SCU_Locat_y + ", SCU_VehLocationMsgCounter=" + this.SCU_VehLocationMsgCounter + ", SCU_LocatState=" + this.SCU_LocatState + ", SCU_Locat_theta=" + this.SCU_Locat_theta + ", SCU_Locat_S=" + this.SCU_Locat_S + ", SCU_Locat_theta_roll=" + this.SCU_Locat_theta_roll + ", SCU_Locat_theta_pitch=" + this.SCU_Locat_theta_pitch + ", SCU_Veh_Speed=" + this.SCU_Veh_Speed + ", SCU_Veh_Movement=" + this.SCU_Veh_Movement + '}';
    }
}
