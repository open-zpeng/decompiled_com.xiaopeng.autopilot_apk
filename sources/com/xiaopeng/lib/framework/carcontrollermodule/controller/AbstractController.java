package com.xiaopeng.lib.framework.carcontrollermodule.controller;

import android.car.Car;
import android.car.hardware.CarPropertyValue;
import android.util.Log;
import com.xiaopeng.lib.framework.carcontrollermodule.CarControllerModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IError;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IEventMsg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.c;
/* loaded from: classes.dex */
public abstract class AbstractController {
    private static final String TAG = "AbstractController";
    protected Car mCarApiClient;
    protected HashMap<Integer, Class<? extends IError>> mPropertyErrorMap = new HashMap<>();
    protected HashMap<Integer, Class<? extends IEventMsg>> mPropertyTypeMap = new HashMap<>();
    protected ConcurrentHashMap<Integer, CarPropertyValue> mCarPropertyMap = new ConcurrentHashMap<>();

    public abstract void initCarManager(Car car);

    public abstract void initPropertyTypeMap();

    public AbstractController(Car car) {
        initCarManager(car);
        initPropertyTypeMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postEventBusMsg(Class<? extends IEventMsg> cls, CarPropertyValue carPropertyValue) {
        int[] iArr;
        if (cls == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" postEventBusMsg");
            stringBuffer.append(", propertyId = ");
            stringBuffer.append(carPropertyValue.getPropertyId());
            stringBuffer.append(", hexPropertyId = ");
            stringBuffer.append(Integer.toHexString(carPropertyValue.getPropertyId()));
            Log.i(getClass().getSimpleName(), stringBuffer.toString() + ", id not put in mPropertyTypeMap");
        } else if (cls != null) {
            try {
                synchronized (cls) {
                    Object value = carPropertyValue.getValue();
                    Class<?> cls2 = value.getClass();
                    if (cls2 == Integer[].class) {
                        Integer[] numArr = (Integer[]) value;
                        int length = numArr.length;
                        int[] iArr2 = new int[length];
                        for (int i = 0; i < length; i++) {
                            iArr2[i] = numArr[i] == null ? 0 : numArr[i].intValue();
                        }
                        cls2 = iArr2.getClass();
                        iArr = iArr2;
                    } else if (cls2 == Float[].class) {
                        Float[] fArr = (Float[]) value;
                        int length2 = fArr.length;
                        float[] fArr2 = new float[length2];
                        for (int i2 = 0; i2 < length2; i2++) {
                            fArr2[i2] = fArr[i2] == null ? 0.0f : fArr[i2].floatValue();
                        }
                        cls2 = fArr2.getClass();
                        iArr = fArr2;
                    } else {
                        iArr = value;
                    }
                    IEventMsg newInstance = cls.newInstance();
                    newInstance.setData(iArr);
                    c.a().e(newInstance);
                    if (CarControllerModuleEntry.sPrintLog) {
                        Object obj = null;
                        if (cls2 == int[].class) {
                            obj = Arrays.toString((int[]) iArr);
                        } else if (cls2 == float[].class) {
                            obj = Arrays.toString((float[]) iArr);
                        }
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(" postEventBusMsg");
                        stringBuffer2.append(", msg = ");
                        stringBuffer2.append(cls.getSimpleName());
                        stringBuffer2.append(", propertyId = ");
                        stringBuffer2.append(carPropertyValue.getPropertyId());
                        stringBuffer2.append(", hexPropertyId = ");
                        stringBuffer2.append(Integer.toHexString(carPropertyValue.getPropertyId()));
                        stringBuffer2.append(", value = ");
                        if (obj == null) {
                            obj = iArr;
                        }
                        stringBuffer2.append(obj);
                        Log.v(getClass().getSimpleName(), stringBuffer2.toString());
                    }
                }
            } catch (IllegalAccessException e) {
                Log.e(getClass().getSimpleName(), "eventClass.newInstance() occur IllegalAccessException " + e);
            } catch (InstantiationException e2) {
                Log.e(getClass().getSimpleName(), "eventClass.newInstance() occur InstantiationException " + e2);
            }
        }
    }

    private Integer convertPropertyId(Class<? extends IEventMsg> cls) {
        for (Map.Entry<Integer, Class<? extends IEventMsg>> entry : this.mPropertyTypeMap.entrySet()) {
            if (cls.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    private List<Integer> convertPropertyList(List<Class<? extends IEventMsg>> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Class<? extends IEventMsg> cls : list) {
                Integer convertPropertyId = convertPropertyId(cls);
                if (convertPropertyId != null) {
                    arrayList.add(convertPropertyId);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Integer> convertRegisterPropertyList(List<Class<? extends IEventMsg>> list) {
        List<Integer> convertPropertyList = convertPropertyList(list);
        HashMap<Integer, Class<? extends IEventMsg>> convertPropertyMap = convertPropertyMap(list);
        String simpleName = getClass().getSimpleName();
        Log.d(simpleName, "register msgMap ：\n" + Arrays.toString(convertPropertyMap.entrySet().toArray()));
        return convertPropertyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Integer> convertUnregisterPropertyList(List<Class<? extends IEventMsg>> list) {
        List<Integer> convertPropertyList = convertPropertyList(list);
        HashMap<Integer, Class<? extends IEventMsg>> convertPropertyMap = convertPropertyMap(list);
        String simpleName = getClass().getSimpleName();
        Log.d(simpleName, "unregister msgMap ：\n" + Arrays.toString(convertPropertyMap.entrySet().toArray()));
        return convertPropertyList;
    }

    private HashMap<Integer, Class<? extends IEventMsg>> convertPropertyMap(List<Class<? extends IEventMsg>> list) {
        HashMap<Integer, Class<? extends IEventMsg>> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (Class<? extends IEventMsg> cls : list) {
                Integer convertPropertyId = convertPropertyId(cls);
                if (convertPropertyId != null) {
                    hashMap.put(convertPropertyId, cls);
                }
            }
        }
        return hashMap;
    }

    private HashMap<String, Class<? extends IEventMsg>> convertHalMap(List<Class<? extends IEventMsg>> list) {
        HashMap<String, Class<? extends IEventMsg>> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (Class<? extends IEventMsg> cls : list) {
                Integer convertPropertyId = convertPropertyId(cls);
                if (convertPropertyId != null) {
                    hashMap.put(Integer.toHexString(convertPropertyId.intValue()), cls);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postErrorEventBusMsg(Class<? extends IEventMsg> cls, int i) {
        if (cls == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" postErrorEventBusMsg");
            String simpleName = getClass().getSimpleName();
            Log.i(simpleName, stringBuffer.toString() + ", id not put in mPropertyTypeMap");
            return;
        }
        try {
            Class<?> cls2 = Class.forName(cls.getName() + "$Error");
            if (cls2 != null) {
                IError iError = (IError) cls2.newInstance();
                iError.setCode(i);
                c.a().e(iError);
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(" postErrorEventBusMsg");
                stringBuffer2.append(", msg = ");
                stringBuffer2.append(cls2.getSimpleName());
                stringBuffer2.append(", errorCode = ");
                stringBuffer2.append(i);
                Log.v(getClass().getSimpleName(), stringBuffer2.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.e(getClass().getSimpleName(), e.getMessage());
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            Log.e(getClass().getSimpleName(), e2.getMessage());
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            Log.e(getClass().getSimpleName(), e3.getMessage());
        }
    }
}
