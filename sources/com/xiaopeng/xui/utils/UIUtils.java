package com.xiaopeng.xui.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.autopilot.base.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes.dex */
public class UIUtils {
    private static final String VIEW_ATTR_VALUE_SPLIT = "/";

    public static boolean isRtl() {
        return isRtl(Locale.getDefault());
    }

    private static boolean isRtl(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == 1 || directionality == 2;
    }

    public static int getStatusBarHeight() {
        try {
            return a.g().getResources().getDimensionPixelSize(a.g().getResources().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception e) {
            Log.d("UIUtils", "e: " + e.getMessage());
            return 0;
        }
    }

    public static int getStatusBarBottomHeight() {
        try {
            return a.g().getResources().getDimensionPixelSize(a.g().getResources().getIdentifier("status_bar_bottom_height", "dimen", "android"));
        } catch (Exception e) {
            Log.d("UIUtils", "e: " + e.getMessage());
            return 0;
        }
    }

    public static View[] findViewsByType(ViewGroup viewGroup, Class cls) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (cls.isInstance(childAt)) {
                arrayList.add(childAt);
            } else if (childAt instanceof ViewGroup) {
                arrayList.addAll(Arrays.asList(findViewsByType((ViewGroup) childAt, cls)));
            }
        }
        return (View[]) arrayList.toArray(new View[arrayList.size()]);
    }

    public static int getResourceId(Context context, String str) {
        if (str.contains(VIEW_ATTR_VALUE_SPLIT)) {
            String substring = str.substring(1, str.indexOf(VIEW_ATTR_VALUE_SPLIT));
            return context.getResources().getIdentifier(str.substring(str.indexOf(VIEW_ATTR_VALUE_SPLIT) + 1), substring, context.getPackageName());
        }
        return -1;
    }

    public static float getFontScale() {
        return a.g().getResources().getDisplayMetrics().scaledDensity;
    }
}
