package com.xiaopeng.lib.utils.config;

import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.lib.utils.FileUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;
/* loaded from: classes.dex */
public final class EnvConfig {
    static final String KEY_EXPIRED_TIME = "expired_time";
    static final String KEY_MAIN_HOST = "main_host";
    static final String PER_ENV_FILE_PATH = "/sdcard/pre_env.ini";
    private static final String TAG = "EnvConfig";
    private static Properties sConfigs = new Properties();

    static {
        init();
    }

    private EnvConfig() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Properties cloneConfig() {
        Properties properties = new Properties();
        properties.putAll(sConfigs);
        return properties;
    }

    public static boolean hasKey(String str) {
        return sConfigs.containsKey(str);
    }

    public static boolean hasValidConfig() {
        return sConfigs.size() > 0 && hasKey(KEY_MAIN_HOST);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sConfigs.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setString(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        sConfigs.put(str, str2);
    }

    public static String getString(String str, String str2) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
        }
        return str2;
    }

    public static String getHostInString(String str, String str2) {
        return getString(KEY_MAIN_HOST, str, str2);
    }

    public static String getString(String str, String str2, String str3) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
        }
        return BuildInfoUtils.isLanVersion() ? str2 : str3;
    }

    public static int getInt(String str, int i) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (TextUtils.isEmpty(property)) {
                return i;
            }
            try {
                return Integer.parseInt(property);
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
        return i;
    }

    public static int getInt(String str, int i, int i2) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (!TextUtils.isEmpty(property)) {
                try {
                    return Integer.parseInt(property);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return BuildInfoUtils.isLanVersion() ? i : i2;
    }

    public static long getLong(String str, long j) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (TextUtils.isEmpty(property)) {
                return j;
            }
            try {
                return Long.parseLong(property);
            } catch (Exception e) {
                e.printStackTrace();
                return j;
            }
        }
        return j;
    }

    public static long getLong(String str, long j, long j2) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (!TextUtils.isEmpty(property)) {
                try {
                    return Long.parseLong(property);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return BuildInfoUtils.isLanVersion() ? j : j2;
    }

    public static double getDouble(String str, double d) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (TextUtils.isEmpty(property)) {
                return d;
            }
            try {
                return Double.parseDouble(property);
            } catch (Exception e) {
                e.printStackTrace();
                return d;
            }
        }
        return d;
    }

    public static double getDouble(String str, double d, double d2) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (!TextUtils.isEmpty(property)) {
                try {
                    return Double.parseDouble(property);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return BuildInfoUtils.isLanVersion() ? d : d2;
    }

    private static boolean strToBoolean(String str) {
        if ("0".equals(str)) {
            return false;
        }
        if (BuildInfoUtils.BID_WAN.equals(str)) {
            return true;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean getBoolean(String str, boolean z) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (!TextUtils.isEmpty(property)) {
                return strToBoolean(property);
            }
        }
        return z;
    }

    public static boolean getBoolean(String str, boolean z, boolean z2) {
        if (BuildInfoUtils.isDebuggableVersion()) {
            String property = sConfigs.getProperty(str);
            if (!TextUtils.isEmpty(property)) {
                return strToBoolean(property);
            }
        }
        return BuildInfoUtils.isLanVersion() ? z : z2;
    }

    private static long convertDateStringToMillis(String str) {
        try {
            String str2 = "yyyyMMdd HH:mm:ss";
            if (str.indexOf(":") < 0) {
                if (str.indexOf(" ") < 0) {
                    str2 = str.length() <= 8 ? "yyyyMMdd" : "yyyyMMddHHmmss";
                } else {
                    str2 = "yyyyMMdd HHmmss";
                }
            }
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    private static void init() {
        FileInputStream fileInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Exception e;
        File file;
        if (BuildInfoUtils.isDebuggableVersion()) {
            try {
                file = new File(PER_ENV_FILE_PATH);
            } catch (Exception e2) {
                fileInputStream = null;
                e = e2;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
                bufferedInputStream = null;
            }
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        try {
                            sConfigs.load(bufferedInputStream);
                            Log.w(TAG, "<<<< warning, load file: pre_env.ini !!!");
                            String property = sConfigs.getProperty(KEY_EXPIRED_TIME, null);
                            if (!TextUtils.isEmpty(property)) {
                                long convertDateStringToMillis = convertDateStringToMillis(property);
                                if (convertDateStringToMillis > 0 && System.currentTimeMillis() >= convertDateStringToMillis) {
                                    Log.w(TAG, "<<<< file pre_env.ini is expired!");
                                    sConfigs.clear();
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            FileUtils.closeQuietly(bufferedInputStream);
                            FileUtils.closeQuietly(fileInputStream);
                            return;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        FileUtils.closeQuietly(bufferedInputStream);
                        FileUtils.closeQuietly(fileInputStream);
                        throw th;
                    }
                } catch (Exception e4) {
                    bufferedInputStream = null;
                    e = e4;
                } catch (Throwable th4) {
                    bufferedInputStream = null;
                    th = th4;
                    FileUtils.closeQuietly(bufferedInputStream);
                    FileUtils.closeQuietly(fileInputStream);
                    throw th;
                }
                FileUtils.closeQuietly(bufferedInputStream);
                FileUtils.closeQuietly(fileInputStream);
                return;
            }
            FileUtils.closeQuietly(null);
            FileUtils.closeQuietly(null);
        }
    }
}
