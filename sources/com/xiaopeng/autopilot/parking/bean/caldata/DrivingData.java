package com.xiaopeng.autopilot.parking.bean.caldata;

import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DrivingData {
    private static final String TAG = "DrivingData";
    private static DrivingData _instance;
    public float ARR_CCP1_y1;
    public float ARR_CCP1_y2;
    public int ARR_DIR_CCP;
    public int ARR_NUM_CCP;
    public int AVM_Slot_Type;
    public float A_ARR_CCP1_x1;
    public float A_ARR_CCP1_x2;
    public int BCM_DriverDroorLockSt;
    public float CDU_SCU_GPS_ALtitude;
    public float CDU_SCU_GPS_Accuracy;
    public float CDU_SCU_GPS_LONG_itude;
    public float CDU_SCU_GPS_Latitude;
    public int CDU_Slot_Type;
    public float EPS_SAS_SteeringAngle;
    public float SCU_Locat_CurSpd;
    public float SCU_Locat_S;
    public float SCU_Locat_theta;
    public float SCU_Locat_theta_pitch;
    public float SCU_Locat_theta_roll;
    public float SCU_Locat_x;
    public float SCU_Locat_y;
    public float SCU_ParkingPt_NearFront_X;
    public float SCU_ParkingPt_NearFront_Y;
    public float SCU_ParkingPt_NearRear_X;
    public float SCU_ParkingPt_NearRear_Y;
    public int VCU_CurrentGearLev;
    public String gsv_info = "";
    public String occurs_time;
    public int power_Model;

    public void setA_ARR_CCP1_x1(float f) {
        this.A_ARR_CCP1_x1 = f;
    }

    public void setARR_CCP1_y1(float f) {
        this.ARR_CCP1_y1 = f;
    }

    public void setA_ARR_CCP1_x2(float f) {
        this.A_ARR_CCP1_x2 = f;
    }

    public void setARR_CCP1_y2(float f) {
        this.ARR_CCP1_y2 = f;
    }

    public void setARR_DIR_CCP(int i) {
        this.ARR_DIR_CCP = i;
    }

    public void setARR_NUM_CCP(int i) {
        this.ARR_NUM_CCP = i;
    }

    public String getGsv_info() {
        return this.gsv_info;
    }

    public void setGsv_info(String str) {
        this.gsv_info = str;
    }

    public void setGSV_info(GpsStatus gpsStatus) {
        if (gpsStatus != null) {
            Iterable<GpsSatellite> satellites = gpsStatus.getSatellites();
            if (satellites != null) {
                ArrayList arrayList = new ArrayList();
                for (GpsSatellite gpsSatellite : satellites) {
                    int prn = gpsSatellite.getPrn();
                    float elevation = gpsSatellite.getElevation();
                    float azimuth = gpsSatellite.getAzimuth();
                    float snr = gpsSatellite.getSnr();
                    GSV gsv = new GSV();
                    gsv.svid = prn + "";
                    gsv.elv = elevation;
                    gsv.az = azimuth;
                    gsv.cno = snr;
                    arrayList.add(gsv);
                }
                if (arrayList.size() > 0) {
                    this.gsv_info = new GsonBuilder().create().toJson(arrayList);
                    return;
                }
                return;
            }
            this.gsv_info = "";
            return;
        }
        this.gsv_info = "";
    }

    public void setGsv_info(GnssStatus gnssStatus) {
        if (gnssStatus != null) {
            int satelliteCount = gnssStatus.getSatelliteCount();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < satelliteCount; i++) {
                int constellationType = gnssStatus.getConstellationType(i);
                if (constellationType == 1 || constellationType == 5) {
                    int svid = gnssStatus.getSvid(i);
                    float elevationDegrees = gnssStatus.getElevationDegrees(i);
                    float azimuthDegrees = gnssStatus.getAzimuthDegrees(i);
                    float cn0DbHz = gnssStatus.getCn0DbHz(i);
                    GSV gsv = new GSV();
                    gsv.svid = svid + "";
                    gsv.elv = elevationDegrees;
                    gsv.az = azimuthDegrees;
                    gsv.cno = cn0DbHz;
                    arrayList.add(gsv);
                }
            }
            if (arrayList.size() > 0) {
                this.gsv_info = new GsonBuilder().create().toJson(arrayList);
            } else {
                this.gsv_info = "";
            }
        }
    }

    public DrivingData(float f) {
        this.SCU_Locat_x = f;
    }

    public void setVCU_CurrentGearLev(int i) {
        this.VCU_CurrentGearLev = i;
    }

    public void setEPS_SAS_SteeringAngle(float f) {
        this.EPS_SAS_SteeringAngle = f;
    }

    public void setBCM_DriverDroorLockSt(int i) {
        this.BCM_DriverDroorLockSt = i;
    }

    public void setCDU_SCU_GPS_LONG_itude(float f) {
        this.CDU_SCU_GPS_LONG_itude = f;
    }

    public void setCDU_SCU_GPS_ALtitude(float f) {
        this.CDU_SCU_GPS_ALtitude = f;
    }

    public void setCDU_SCU_GPS_Accuracy(float f) {
        this.CDU_SCU_GPS_Accuracy = f;
    }

    public void setTime(String str) {
        this.occurs_time = str;
    }

    public void setSCU_Locat_x(float f) {
        this.SCU_Locat_x = f;
    }

    public void setSCU_Locat_y(float f) {
        this.SCU_Locat_y = f;
    }

    public void setSCU_Locat_theta(float f) {
        this.SCU_Locat_theta = f;
    }

    public void setSCU_Locat_S(float f) {
        this.SCU_Locat_S = f;
    }

    public void setSCU_Locat_CurSpd(float f) {
        this.SCU_Locat_CurSpd = f;
    }

    public void setSCU_Locat_theta_roll(float f) {
        this.SCU_Locat_theta_roll = f;
    }

    public void setSCU_Locat_theta_pitch(float f) {
        this.SCU_Locat_theta_pitch = f;
    }

    private void setSCU_ParkingPt_NearRear_X(float f) {
        this.SCU_ParkingPt_NearRear_X = f;
    }

    private void setSCU_ParkingPt_NearRear_Y(float f) {
        this.SCU_ParkingPt_NearRear_Y = f;
    }

    private void setSCU_ParkingPt_NearFront_X(float f) {
        this.SCU_ParkingPt_NearFront_X = f;
    }

    private void setSCU_ParkingPt_NearFront_Y(float f) {
        this.SCU_ParkingPt_NearFront_Y = f;
    }

    public void setCDU_SCU_GPS_Latitude(float f) {
        this.CDU_SCU_GPS_Latitude = f;
    }

    private void setAVM_Slot_Type(int i) {
        this.AVM_Slot_Type = i;
    }

    private void setCDU_Slot_Type(int i) {
        this.CDU_Slot_Type = i;
    }

    private DrivingData() {
    }

    public static DrivingData getInstance() {
        if (_instance == null) {
            _instance = new DrivingData();
        }
        return _instance;
    }

    public String toString() {
        return "DrivingData{SCU_Locat_x=" + this.SCU_Locat_x + ", SCU_Locat_y=" + this.SCU_Locat_y + ", SCU_Locat_theta=" + this.SCU_Locat_theta + ", SCU_Locat_S=" + this.SCU_Locat_S + ", SCU_Locat_CurSpd=" + this.SCU_Locat_CurSpd + ", SCU_Locat_theta_roll=" + this.SCU_Locat_theta_roll + ", SCU_Locat_theta_pitch=" + this.SCU_Locat_theta_pitch + ", SCU_ParkingPt_NearRear_X=" + this.SCU_ParkingPt_NearRear_X + ", SCU_ParkingPt_NearRear_Y=" + this.SCU_ParkingPt_NearRear_Y + ", SCU_ParkingPt_NearFront_X=" + this.SCU_ParkingPt_NearFront_X + ", SCU_ParkingPt_NearFront_Y=" + this.SCU_ParkingPt_NearFront_Y + ", AVM_Slot_Type=" + this.AVM_Slot_Type + ", CDU_Slot_Type=" + this.CDU_Slot_Type + ", VCU_CurrentGearLev=" + this.VCU_CurrentGearLev + ", EPS_SAS_SteeringAngle=" + this.EPS_SAS_SteeringAngle + ", BCM_DriverDroorLockSt=" + this.BCM_DriverDroorLockSt + ", CDU_SCU_GPS_LONG_itude=" + this.CDU_SCU_GPS_LONG_itude + ", CDU_SCU_GPS_Latitude=" + this.CDU_SCU_GPS_Latitude + ", CDU_SCU_GPS_ALtitude=" + this.CDU_SCU_GPS_ALtitude + ", CDU_SCU_GPS_Accuracy=" + this.CDU_SCU_GPS_Accuracy + ", occurs_time=" + this.occurs_time + '}';
    }

    public void setPowerModel(int i) {
        this.power_Model = i;
    }

    private void init(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, int i, int i2, int i3, float f12, int i4, int i5, float f13, float f14, float f15, float f16, String str) {
        this.SCU_Locat_x = f;
        this.SCU_Locat_y = f2;
        this.SCU_Locat_theta = f3;
        this.SCU_Locat_S = f4;
        this.SCU_Locat_CurSpd = f5;
        this.SCU_Locat_theta_roll = f6;
        this.SCU_Locat_theta_pitch = f7;
        this.SCU_ParkingPt_NearRear_X = f8;
        this.SCU_ParkingPt_NearRear_Y = f9;
        this.SCU_ParkingPt_NearFront_X = f10;
        this.SCU_ParkingPt_NearFront_Y = f11;
        this.AVM_Slot_Type = i;
        this.CDU_Slot_Type = i2;
        this.VCU_CurrentGearLev = i3;
        this.EPS_SAS_SteeringAngle = f12;
        this.BCM_DriverDroorLockSt = i4;
        this.power_Model = i5;
        this.CDU_SCU_GPS_LONG_itude = f13;
        this.CDU_SCU_GPS_Latitude = f14;
        this.CDU_SCU_GPS_ALtitude = f15;
        this.CDU_SCU_GPS_Accuracy = f16;
        this.occurs_time = str;
    }

    private float calculateEx(float f, float f2) {
        return this.SCU_ParkingPt_NearRear_X + ((float) (f * Math.cos(f2)));
    }

    private float calcuateleY(float f, float f2) {
        return this.SCU_ParkingPt_NearRear_Y + ((float) (f * Math.sin(f2)));
    }

    public synchronized void syncParkingPtNFData(int i, int i2, float f, float f2, float f3, float f4) {
        setCDU_Slot_Type(i2);
        setAVM_Slot_Type(i);
        setSCU_ParkingPt_NearRear_X(f);
        setSCU_ParkingPt_NearRear_Y(f2);
        setSCU_ParkingPt_NearFront_X(f3);
        setSCU_ParkingPt_NearFront_Y(f4);
    }

    /* loaded from: classes.dex */
    public class GSV {
        public float az;
        public float cno;
        public float elv;
        public String svid;

        public GSV() {
        }
    }
}
