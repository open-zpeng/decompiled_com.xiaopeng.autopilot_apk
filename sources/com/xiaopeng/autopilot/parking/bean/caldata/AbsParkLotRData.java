package com.xiaopeng.autopilot.parking.bean.caldata;
/* loaded from: classes.dex */
public abstract class AbsParkLotRData {
    public static final int SLOT_TAG_CAN_HIGHT_FRONT = 10;
    public static final int SLOT_TAG_CAN_HIGHT_REAR = 0;
    public static final int SLOT_TAG_CAN_HIGHT_REAR_FRONT = 2;
    public static final int SLOT_TAG_CAN_LOW_FRONT = 11;
    public static final int SLOT_TAG_CAN_LOW_REAR = 1;
    public static final int SLOT_TAG_CAN_LOW_REAR_FRONT = 3;
    public static final int SLOT_TAG_CAN_NARROW_FRONT = 14;
    public static final int SLOT_TAG_CAN_NARROW_REAR = 4;
    public static final int SLOT_TAG_CAN_NARROW_REAR_FRONT = 5;
    public static final int SLOT_TAG_DEFAULT = -1;
    public static final int SLOT_TAG_FREE_HIGHT_FRONT = 12;
    public static final int SLOT_TAG_FREE_HIGHT_REAR = 2;
    public static final int SLOT_TAG_FREE_HIGHT_REAR_FRONT = 4;
    public static final int SLOT_TAG_FREE_LOW_FRONT = 13;
    public static final int SLOT_TAG_FREE_LOW_REAR = 3;
    public static final int SLOT_TAG_FREE_LOW_REAR_FRONT = 5;
    public static final int SLOT_TAG_FREE_NARROW_FRONT = 16;
    public static final int SLOT_TAG_FREE_NARROW_REAR = 6;
    public static final int SLOT_TAG_FREE_NARROW_REAR_FRONT = 7;
    public static final int SLOT_TAG_UNFREE = 0;
    public static final int SLOT_TAG_UNKNOW = 1;

    public static boolean isCanH(int i) {
        return i == 0 || i == 2 || i == 10;
    }

    public static boolean isCanL(int i) {
        return i == 1 || i == 3 || i == 11;
    }

    public static boolean isCanN(int i) {
        return i == 4 || i == 5 || i == 14;
    }

    public static boolean isItemHightConfidence(int i) {
        return i == 2 || i == 4 || i == 12;
    }

    public static boolean isItemLowConfidence(int i) {
        return i == 3 || i == 5 || i == 13;
    }

    public static boolean isItemNarrow(int i) {
        return i == 6 || i == 7 || i == 16;
    }

    public static boolean isItemRear(int i) {
        return i == 2 || i == 3 || i == 6;
    }

    public static boolean isItemRearFront(int i) {
        return i == 4 || i == 5 || i == 7;
    }

    public static boolean isItemUnfree(int i) {
        return i == 0;
    }

    public static boolean isItemUnknow(int i) {
        return i == 1;
    }

    public static boolean isOnlySupportFront(int i) {
        return i == 12 || i == 13 || i == 16;
    }

    public static boolean isOnlySupportRear(int i) {
        return i == 2 || i == 6;
    }

    public static boolean isSupportFront(int i) {
        return isOnlySupportFront(i) || isItemRearFront(i);
    }
}
