package com.xiaopeng.datalog.bean;

import androidx.annotation.Keep;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.lib.utils.info.DeviceInfoUtils;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class LogEvent {
    private String dbcVer;
    private String device;
    private String iccid;
    private String model;
    private List<Object> msg;
    private int packageId;
    private int ref;
    private String sid;
    private String sysVer;
    private long t;
    private long uid;
    private int v = 3;
    private int vid;
    private String vin;

    private LogEvent() {
    }

    public String getDevice() {
        return this.device;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String str) {
        this.vin = str;
    }

    public int getVid() {
        return this.vid;
    }

    public void setVid(int i) {
        this.vid = i;
    }

    public String getSysVer() {
        return this.sysVer;
    }

    public void setSysVer(String str) {
        this.sysVer = str;
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public long getUid() {
        return this.uid;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public long getT() {
        return this.t;
    }

    public void setT(long j) {
        this.t = j;
    }

    public int getRef() {
        return this.ref;
    }

    public void setRef(int i) {
        this.ref = i;
    }

    public void setV(int i) {
        this.v = i;
    }

    public int getV() {
        return this.v;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public void setPackageId(int i) {
        this.packageId = i;
    }

    public List<Object> getMsg() {
        return this.msg;
    }

    public void setMsg(List<Object> list) {
        this.msg = list;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getDbcVer() {
        return this.dbcVer;
    }

    public void setDbcVer(String str) {
        this.dbcVer = str;
    }

    public String getIccid() {
        return this.iccid;
    }

    public void setIccid(String str) {
        this.iccid = str;
    }

    public static LogEvent create(a aVar) {
        LogEvent logEvent = new LogEvent();
        logEvent.setDevice(SystemPropertyUtil.getHardwareId());
        logEvent.setVin(SystemPropertyUtil.getVIN());
        logEvent.setSysVer(getSystemVersion());
        logEvent.setSid(SystemPropertyUtil.getSoftwareId());
        logEvent.setUid(SystemPropertyUtil.getAccountUid());
        logEvent.setT(System.currentTimeMillis());
        logEvent.setRef(aVar.getRefType());
        logEvent.setModel(DeviceInfoUtils.getProductModel());
        logEvent.setDbcVer(SystemPropertyUtil.getDBCVersion());
        logEvent.setIccid(SystemPropertyUtil.getIccid());
        return logEvent;
    }

    /* loaded from: classes.dex */
    public enum a {
        CAN(2),
        CDU(1);
        
        private int a;

        a(int i) {
            this.a = i;
        }

        public int getRefType() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        XMART_ROM(1),
        XMART_APP(2),
        XMART_THIRD_APP(3),
        ANDROID_APP(4);
        
        private int a;

        b(int i) {
            this.a = i;
        }

        public int getSrcType() {
            return this.a;
        }

        public static b from(int i) {
            switch (i) {
                case 1:
                    return XMART_ROM;
                case 2:
                    return XMART_APP;
                case 3:
                    return XMART_THIRD_APP;
                case 4:
                    return ANDROID_APP;
                default:
                    throw new IllegalArgumentException("Invalid arg:" + i);
            }
        }
    }

    public static b from(int i) {
        switch (i) {
            case 1:
                return b.XMART_ROM;
            case 2:
                return b.XMART_APP;
            case 3:
                return b.XMART_THIRD_APP;
            case 4:
                return b.ANDROID_APP;
            default:
                throw new IllegalArgumentException("invalid type " + i + ", must be [1, 4]");
        }
    }

    public static String getSystemVersion() {
        String[] split = SystemPropertyUtil.getSoftwareId().split("_");
        return split.length > 1 ? split[1] : BuildInfoUtils.UNKNOWN;
    }
}
