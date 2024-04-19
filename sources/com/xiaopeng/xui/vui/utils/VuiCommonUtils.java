package com.xiaopeng.xui.vui.utils;
/* loaded from: classes.dex */
public class VuiCommonUtils {
    public static abu getViewLeveByPriority(int i) {
        switch (i) {
            case 0:
                return abu.LEVEL1;
            case 1:
                return abu.LEVEL2;
            case 2:
                return abu.LEVEL3;
            case 3:
                return abu.LEVEL4;
            default:
                return abu.LEVEL3;
        }
    }

    public static abt getVuiMode(int i) {
        switch (i) {
            case 1:
                return abt.DISABLED;
            case 2:
                return abt.SILENT;
            case 3:
                return abt.UNDERSTOOD;
            default:
                return abt.NORMAL;
        }
    }

    public static abs getFeedbackType(int i) {
        switch (i) {
            case 1:
                return abs.SOUND;
            case 2:
                return abs.TTS;
            default:
                return abs.SOUND;
        }
    }

    public static abr getElementType(int i) {
        switch (i) {
            case 1:
                return abr.BUTTON;
            case 2:
                return abr.LISTVIEW;
            case 3:
                return abr.CHECKBOX;
            case 4:
                return abr.RADIOBUTTON;
            case 5:
                return abr.RADIOGROUP;
            case 6:
                return abr.GROUP;
            case 7:
                return abr.EDITTEXT;
            case 8:
                return abr.PROGRESSBAR;
            case 9:
                return abr.SEEKBAR;
            case 10:
                return abr.TABHOST;
            case 11:
                return abr.SEARCHVIEW;
            case 12:
                return abr.RATINGBAR;
            case 13:
                return abr.IMAGEBUTTON;
            case 14:
                return abr.IMAGEVIEW;
            case 15:
                return abr.SCROLLVIEW;
            case 16:
                return abr.TEXTVIEW;
            case 17:
                return abr.RECYCLEVIEW;
            case 18:
                return abr.SWITCH;
            case 19:
                return abr.CUSTOM;
            case 20:
                return abr.XSLIDER;
            case 21:
                return abr.XTABLAYOUT;
            case 22:
                return abr.XGROUPHEADER;
            default:
                return abr.UNKNOWN;
        }
    }
}
