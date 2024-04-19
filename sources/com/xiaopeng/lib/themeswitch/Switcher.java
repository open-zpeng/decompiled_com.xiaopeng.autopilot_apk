package com.xiaopeng.lib.themeswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.xiaopeng.lib.framework.aiassistantmodule.Constants;
import com.xiaopeng.lib.themeswitch.DrawableLoader;
import com.xiaopeng.lib.themeswitch.bean.PageTheme;
import com.xiaopeng.lib.themeswitch.bean.PrePageTheme;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class Switcher {
    private static final String SUFFIX_ADAPTER_PAGE = "-_Adapter_-";
    private static final String TAG = "ThemeSwitcher";
    private static final String VIEW_ATTR_ALPHA = "alpha";
    private static final String VIEW_ATTR_BACKGROUND = "background";
    private static final String VIEW_ATTR_BUTTON = "button";
    private static final String VIEW_ATTR_DIVIDER = "divider";
    private static final String VIEW_ATTR_DRAWABLE_BOTTOM = "drawableBottom";
    private static final String VIEW_ATTR_DRAWABLE_LEFT = "drawableLeft";
    private static final String VIEW_ATTR_DRAWABLE_RIGHT = "drawableRight";
    private static final String VIEW_ATTR_DRAWABLE_TOP = "drawableTop";
    private static final String VIEW_ATTR_PROGRESS_DRAWABLE = "progressDrawable";
    private static final String VIEW_ATTR_SRC = "src";
    private static final String VIEW_ATTR_TEXT_COLOR = "textColor";
    private static final String VIEW_ATTR_TEXT_COLOR_HINT = "textColorHint";
    private static final String VIEW_ATTR_THUMB = "thumb";
    private static final String VIEW_ATTR_VALUE_DRAWABLE = "drawable";
    private static final String VIEW_ATTR_VALUE_SPLIT = "/";
    private static final AtomicInteger VIEW_FLAG = new AtomicInteger(1);
    private Context mContext;
    private int mCountOfDrawablesInPageView;
    private volatile boolean mIsSwitching;
    private boolean mKeepSwitching2Day;
    private boolean mKeepSwitching2Night;
    private OnSwitchFinishListener mOnSwitchFinishListener;
    private volatile int mPageViewCount;
    private ConcurrentHashMap<String, PrePageTheme> mPrePageViewMap = new ConcurrentHashMap<>();
    private HashMap<String, PageTheme> mPageThemeMap = new HashMap<>();
    private Set<Integer> mThemeResourceSet = new HashSet();
    private ArrayList<Runnable> mOtherRunnablesForNightUpdate = new ArrayList<>();
    private LinkedHashMap<String, ArrayList<Runnable>> mNightUpdateMap = new LinkedHashMap<>();
    private AtomicInteger mCountOfPageViewLoadedFinish = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public interface OnSwitchFinishListener {
        void onSwitchFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface OnThemeConfigureParseListener {
        void onThemeConfigureParse(PageTheme pageTheme);
    }

    public Switcher(Context context) {
        this.mContext = context;
    }

    public void addNewThemeResource(int... iArr) {
        for (int i : iArr) {
            this.mThemeResourceSet.add(Integer.valueOf(i));
        }
    }

    public void unregister(String str) {
        clearPreViewSettings(str);
        clearNightUpdateRunnableList(str);
    }

    public String newThemeNameForRepeatView(String str) {
        return str + SUFFIX_ADAPTER_PAGE + VIEW_FLAG.getAndAdd(1);
    }

    public void clearPreViewSettings(String str) {
        this.mPrePageViewMap.remove(str);
        Iterator<Map.Entry<String, PrePageTheme>> it = this.mPrePageViewMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().startsWith(str + SUFFIX_ADAPTER_PAGE)) {
                it.remove();
            }
        }
        Log.d(TAG, "unregister pageName=" + str + "  mPrePageViewMap size=" + this.mPrePageViewMap.size());
    }

    public void clearNightUpdateRunnableList(String str) {
        this.mNightUpdateMap.remove(str);
        Iterator<Map.Entry<String, ArrayList<Runnable>>> it = this.mNightUpdateMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().startsWith(str + SUFFIX_ADAPTER_PAGE)) {
                it.remove();
            }
        }
        Log.d(TAG, "unregister pageName=" + str + "  mPrePageViewMap size=" + this.mPrePageViewMap.size());
    }

    public void register(View view, String str) {
        Log.d(TAG, "register pageName=" + str);
        if (view == null) {
            return;
        }
        if (this.mPrePageViewMap.containsKey(str)) {
            str = str + SUFFIX_ADAPTER_PAGE + System.currentTimeMillis();
        }
        if (ThemeWatcher.getInstance().isNight()) {
            switchViewAttr(true, view, str);
        } else {
            storeDayPage(view, str);
        }
    }

    public void registerWithoutRepeat(View view, String str, String str2) {
        Log.d(TAG, "registerWithoutRepeat pageName=" + str + ", pageId=" + str2);
        if (view == null) {
            return;
        }
        String str3 = str + SUFFIX_ADAPTER_PAGE + str2;
        if (ThemeWatcher.getInstance().isNight()) {
            switchViewAttr(true, view, str3);
        } else {
            storeDayPage(view, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSwitching() {
        return this.mIsSwitching;
    }

    private void storeDayPage(View view, String str) {
        PrePageTheme prePageTheme = new PrePageTheme();
        prePageTheme.setRootView(view);
        this.mPrePageViewMap.put(str, prePageTheme);
    }

    public void switch2Night() {
        this.mIsSwitching = true;
        this.mKeepSwitching2Night = true;
        ThreadPoolHelper.postMainThread(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    Log.d(Switcher.TAG, "Switching2Night1");
                    Switcher.this.mPageViewCount = 0;
                    Switcher.this.mCountOfPageViewLoadedFinish.set(0);
                    synchronized (Switcher.this.mPrePageViewMap) {
                        Iterator it = Switcher.this.mPrePageViewMap.entrySet().iterator();
                        while (it.hasNext() && Switcher.this.mKeepSwitching2Night) {
                            Map.Entry entry = (Map.Entry) it.next();
                            Switcher.this.switchViewAttr(false, ((PrePageTheme) entry.getValue()).getRootView(), (String) entry.getKey());
                        }
                    }
                    Log.d(Switcher.TAG, "Switching2Night2");
                    if (Switcher.this.mPrePageViewMap.isEmpty()) {
                        Switcher.this.onSwitchFinish();
                    }
                }
            }
        });
    }

    public void switch2Day() {
        this.mIsSwitching = true;
        this.mKeepSwitching2Day = true;
        ThreadPoolHelper.postMainThread(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    Log.d(Switcher.TAG, "Switching2Day1");
                    Iterator it = Switcher.this.mPrePageViewMap.entrySet().iterator();
                    while (it.hasNext() && Switcher.this.mKeepSwitching2Day) {
                        Map.Entry entry = (Map.Entry) it.next();
                        String str = (String) entry.getKey();
                        PrePageTheme prePageTheme = (PrePageTheme) entry.getValue();
                        if (prePageTheme != null && prePageTheme.getViewList() != null) {
                            for (PrePageTheme.ThemeView themeView : prePageTheme.getViewList()) {
                                View findViewById = prePageTheme.getRootView().findViewById(themeView.getId());
                                if (findViewById == null) {
                                    Log.e(Switcher.TAG, "Can not find target view(id=" + themeView.getId() + ") to switch theme!");
                                } else {
                                    for (PrePageTheme.ThemeView.ViewAttr viewAttr : themeView.getAttrList()) {
                                        Switcher.this.doSwitch2Day(findViewById, viewAttr.getAttrName(), viewAttr.getAttrValue());
                                    }
                                }
                            }
                        }
                    }
                    Log.d(Switcher.TAG, "Switching2Day2");
                    Switcher.this.onSwitchFinish();
                }
            }
        });
    }

    private void parseThemeConfigure(final Context context, final String str, final OnThemeConfigureParseListener onThemeConfigureParseListener) {
        PageTheme pageTheme = ThemeWatcher.getInstance().getPageTheme(str);
        if (pageTheme != null) {
            onThemeConfigureParseListener.onThemeConfigureParse(pageTheme);
        } else {
            ThreadPoolHelper.postBackground(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.3
                @Override // java.lang.Runnable
                public void run() {
                    final PageTheme parseThemeConfigure = Switcher.this.parseThemeConfigure(context, str);
                    if (onThemeConfigureParseListener != null) {
                        ThreadPoolHelper.postMainThread(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                onThemeConfigureParseListener.onThemeConfigureParse(parseThemeConfigure);
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PageTheme parseThemeConfigure(Context context, String str) {
        PageTheme pageTheme = null;
        try {
            pageTheme = XmlParser.parseXMLWithPull(context.getAssets().open("theme_night.xml"), str);
            Log.d(TAG, "pageTheme=\n" + pageTheme.toString());
            return pageTheme;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "parseThemeConfigure Exception e=" + e.getMessage());
            return pageTheme;
        }
    }

    private String getThemePageName(String str) {
        return str.contains(SUFFIX_ADAPTER_PAGE) ? str.substring(0, str.indexOf(SUFFIX_ADAPTER_PAGE)) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchViewAttr(final boolean z, final View view, final String str) {
        final String themePageName = getThemePageName(str);
        if (!z) {
            this.mPageViewCount++;
        }
        PageTheme pageTheme = this.mPageThemeMap.get(themePageName);
        if (pageTheme == null) {
            Log.e(TAG, "<<<< call switchViewAttr, target pageTheme " + str + " is null, isCalledInRegisterEntry = " + z);
            if (z) {
                parseThemeConfigure(this.mContext, themePageName, new OnThemeConfigureParseListener() { // from class: com.xiaopeng.lib.themeswitch.Switcher.4
                    @Override // com.xiaopeng.lib.themeswitch.Switcher.OnThemeConfigureParseListener
                    public void onThemeConfigureParse(PageTheme pageTheme2) {
                        if (pageTheme2 != null) {
                            Switcher.this.mPageThemeMap.put(themePageName, pageTheme2);
                            Switcher.this.switchViewAttr(z, view, str, pageTheme2);
                            return;
                        }
                        Log.e(Switcher.TAG, "Parse ThemeXml error!(targetPageName=" + str + ", pageNameXml=" + themePageName + ")");
                    }
                });
                return;
            } else {
                ThreadPoolHelper.postBackground(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Switcher switcher = Switcher.this;
                        final PageTheme parseThemeConfigure = switcher.parseThemeConfigure(switcher.mContext, themePageName);
                        if (parseThemeConfigure == null) {
                            Switcher.this.checkAndResetTargetPageRunnableInfo(str);
                            Switcher.this.updateNightThemeAsync(z, str);
                            Log.e(Switcher.TAG, "Parse ThemeXml error!(targetPageName=" + str + ", pageNameXml=" + themePageName + ")");
                            return;
                        }
                        ThreadPoolHelper.postMainThread(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Log.d(Switcher.TAG, "Get PageTheme from xml.");
                                Switcher.this.mPageThemeMap.put(themePageName, parseThemeConfigure);
                                Switcher.this.switchViewAttr(z, view, str, parseThemeConfigure);
                                Switcher.this.updateNightThemeAsync(z, str);
                            }
                        });
                    }
                });
                return;
            }
        }
        Log.d(TAG, "Get PageTheme from Cache:mPageThemeMap, isCalledInRegisterEntry = " + z);
        switchViewAttr(z, view, str, pageTheme);
        updateNightThemeAsync(z, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRunnableToList(ArrayList arrayList, Runnable runnable) {
        synchronized (arrayList) {
            arrayList.add(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Runnable> checkAndResetTargetPageRunnableInfo(String str) {
        this.mCountOfDrawablesInPageView = 0;
        ArrayList<Runnable> arrayList = this.mNightUpdateMap.get(str);
        if (arrayList == null) {
            ArrayList<Runnable> arrayList2 = new ArrayList<>();
            this.mNightUpdateMap.put(str, arrayList2);
            return arrayList2;
        }
        arrayList.clear();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNightThemeAsync(boolean z, String str) {
        if (z || this.mNightUpdateMap.isEmpty()) {
            Log.d(TAG, "<<<< updateNightDrawableAsync, return, isCalledInRegisterEntry = " + z);
            return;
        }
        final int i = this.mCountOfDrawablesInPageView;
        final ArrayList<Runnable> arrayList = this.mNightUpdateMap.get(str);
        final Runnable runnable = new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.6
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : Switcher.this.mNightUpdateMap.entrySet()) {
                    ArrayList arrayList2 = (ArrayList) entry.getValue();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    arrayList2.clear();
                }
                Iterator it2 = Switcher.this.mOtherRunnablesForNightUpdate.iterator();
                while (it2.hasNext()) {
                    ((Runnable) it2.next()).run();
                }
                Switcher.this.mOtherRunnablesForNightUpdate.clear();
                Switcher.this.onSwitchFinish();
                Log.d(Switcher.TAG, "<<<< updateNightThemeAsync, switch to night mode finish!");
            }
        };
        ThreadPoolHelper.postBackground(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.7
            @Override // java.lang.Runnable
            public void run() {
                int size;
                synchronized (arrayList) {
                    size = arrayList.size();
                }
                if (i == size) {
                    if (Switcher.this.mCountOfPageViewLoadedFinish.incrementAndGet() == Switcher.this.mPageViewCount) {
                        ThreadPoolHelper.postMainThread(runnable);
                        return;
                    }
                    return;
                }
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ThreadPoolHelper.postBackground(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchViewAttr(boolean z, View view, String str, PageTheme pageTheme) {
        String str2;
        int i;
        String str3;
        boolean z2 = this.mPrePageViewMap.get(str) == null || this.mPrePageViewMap.get(str).getViewList() == null;
        if (z2) {
            PrePageTheme prePageTheme = new PrePageTheme();
            prePageTheme.setRootView(view);
            prePageTheme.setViewList(new ArrayList());
            this.mPrePageViewMap.put(str, prePageTheme);
        }
        ArrayList<Runnable> checkAndResetTargetPageRunnableInfo = checkAndResetTargetPageRunnableInfo(str);
        for (PageTheme.ThemeView themeView : pageTheme.getViewList()) {
            int identifier = this.mContext.getResources().getIdentifier(themeView.getId(), Constants.ID, this.mContext.getPackageName());
            View findViewById = view.findViewById(identifier);
            if (findViewById == null) {
                Log.e(TAG, "Can not find target view(id=" + themeView.getId() + ") to switch theme!");
            } else {
                if (z2 && this.mPrePageViewMap.get(str) != null) {
                    PrePageTheme.ThemeView themeView2 = new PrePageTheme.ThemeView();
                    themeView2.setId(identifier);
                    themeView2.setAttrList(new ArrayList());
                    this.mPrePageViewMap.get(str).getViewList().add(themeView2);
                }
                for (PageTheme.ThemeView.ViewAttr viewAttr : themeView.getAttrList()) {
                    String attrName = viewAttr.getAttrName();
                    String attrValue = viewAttr.getAttrValue();
                    if (attrValue.contains(VIEW_ATTR_VALUE_SPLIT)) {
                        String substring = attrValue.substring(1, attrValue.indexOf(VIEW_ATTR_VALUE_SPLIT));
                        i = this.mContext.getResources().getIdentifier(attrValue.substring(attrValue.indexOf(VIEW_ATTR_VALUE_SPLIT) + 1), substring, this.mContext.getPackageName());
                        str2 = substring;
                    } else {
                        str2 = attrValue;
                        i = -1;
                    }
                    Object obj = null;
                    if ("background".equals(attrName)) {
                        obj = findViewById.getBackground();
                        str3 = attrName;
                    } else if ("textColor".equals(attrName)) {
                        if (VIEW_ATTR_VALUE_DRAWABLE.equals(str2)) {
                            str3 = attrName + VIEW_ATTR_VALUE_SPLIT + VIEW_ATTR_VALUE_DRAWABLE;
                            obj = ((TextView) findViewById).getTextColors();
                        } else {
                            obj = Integer.valueOf(((TextView) findViewById).getCurrentTextColor());
                            str3 = attrName;
                        }
                    } else if ("src".equals(attrName)) {
                        obj = ((ImageView) findViewById).getDrawable();
                        str3 = attrName;
                    } else if ("alpha".equals(attrName)) {
                        obj = Float.valueOf(findViewById.getAlpha());
                        str3 = attrName;
                    } else if ("textColorHint".equals(attrName)) {
                        obj = Integer.valueOf(((TextView) findViewById).getCurrentHintTextColor());
                        str3 = attrName;
                    } else if ("thumb".equals(attrName)) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            obj = ((SeekBar) findViewById).getThumb();
                            str3 = attrName;
                        }
                        str3 = attrName;
                    } else if ("progressDrawable".equals(attrName)) {
                        obj = ((ProgressBar) findViewById).getProgressDrawable();
                        str3 = attrName;
                    } else if ("button".equals(attrName)) {
                        try {
                            Field declaredField = findViewById.getClass().getSuperclass().getDeclaredField("mButtonDrawable");
                            declaredField.setAccessible(true);
                            obj = declaredField.get(findViewById);
                            str3 = attrName;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e2) {
                            e2.printStackTrace();
                        }
                    } else if ("divider".equals(attrName)) {
                        obj = ((ListView) findViewById).getDivider();
                        str3 = attrName;
                    } else if ("drawableLeft".equals(attrName)) {
                        obj = ((TextView) findViewById).getCompoundDrawables()[0];
                        str3 = attrName;
                    } else if ("drawableTop".equals(attrName)) {
                        obj = ((TextView) findViewById).getCompoundDrawables()[1];
                        str3 = attrName;
                    } else if ("drawableRight".equals(attrName)) {
                        obj = ((TextView) findViewById).getCompoundDrawables()[2];
                        str3 = attrName;
                    } else {
                        if ("drawableBottom".equals(attrName)) {
                            obj = ((TextView) findViewById).getCompoundDrawables()[3];
                            str3 = attrName;
                        }
                        str3 = attrName;
                    }
                    if (z2) {
                        PrePageTheme.ThemeView.ViewAttr viewAttr2 = new PrePageTheme.ThemeView.ViewAttr();
                        viewAttr2.setAttrName(str3);
                        viewAttr2.setAttrValue(obj);
                        this.mPrePageViewMap.get(str).getViewList().get(this.mPrePageViewMap.get(str).getViewList().size() - 1).getAttrList().add(viewAttr2);
                    }
                    doSwitch2Night(z, checkAndResetTargetPageRunnableInfo, findViewById, attrName, str2, i);
                    findViewById = findViewById;
                }
            }
        }
    }

    private void doSwitch2Night(boolean z, final ArrayList<Runnable> arrayList, final View view, String str, final String str2, final int i) {
        if ("background".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.8
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                view.setBackgroundDrawable(drawable);
                            }
                        });
                    }
                });
                return;
            }
            view.setBackgroundResource(i);
        } else if ("textColor".equals(str)) {
            if (!z) {
                this.mOtherRunnablesForNightUpdate.add(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Switcher.VIEW_ATTR_VALUE_DRAWABLE.equals(str2)) {
                            ((TextView) view).setTextColor(j.a(Switcher.this.mContext, i));
                            return;
                        }
                        ((TextView) view).setTextColor(Switcher.this.mContext.getResources().getColor(i));
                    }
                });
            } else if (VIEW_ATTR_VALUE_DRAWABLE.equals(str2)) {
                ((TextView) view).setTextColor(j.a(this.mContext, i));
            } else {
                ((TextView) view).setTextColor(this.mContext.getResources().getColor(i));
            }
        } else if ("src".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.10
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((ImageView) view).setImageDrawable(drawable);
                            }
                        });
                    }
                });
                return;
            }
            ((ImageView) view).setImageResource(i);
        } else if ("alpha".equals(str)) {
            if (!z) {
                this.mOtherRunnablesForNightUpdate.add(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.11
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setAlpha(Float.parseFloat(str2));
                    }
                });
                return;
            }
            view.setAlpha(Float.parseFloat(str2));
        } else if ("textColorHint".equals(str)) {
            if (!z) {
                this.mOtherRunnablesForNightUpdate.add(new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.12
                    @Override // java.lang.Runnable
                    public void run() {
                        ((TextView) view).setHintTextColor(Switcher.this.mContext.getResources().getColor(i));
                    }
                });
                return;
            }
            ((TextView) view).setHintTextColor(this.mContext.getResources().getColor(i));
        } else if ("thumb".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.13
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((SeekBar) view).setThumb(drawable);
                            }
                        });
                    }
                });
                return;
            }
            ((SeekBar) view).setThumb(this.mContext.getResources().getDrawable(i));
        } else if ("progressDrawable".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.14
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((ProgressBar) view).setProgressDrawable(drawable);
                            }
                        });
                    }
                });
                return;
            }
            ((ProgressBar) view).setProgressDrawable(this.mContext.getResources().getDrawable(i));
        } else if ("button".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.15
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((CompoundButton) view).setButtonDrawable(drawable);
                            }
                        });
                    }
                });
                return;
            }
            ((CompoundButton) view).setButtonDrawable(this.mContext.getResources().getDrawable(i));
        } else if ("divider".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.16
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((ListView) view).setDivider(drawable);
                            }
                        });
                    }
                });
                return;
            }
            ((ListView) view).setDivider(this.mContext.getResources().getDrawable(i));
        } else if ("drawableLeft".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.17
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Switcher.this.setCompoundDrawables(0, view, drawable);
                            }
                        });
                    }
                });
                return;
            }
            setCompoundDrawables(0, view, this.mContext.getResources().getDrawable(i));
        } else if ("drawableTop".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.18
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.18.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Switcher.this.setCompoundDrawables(1, view, drawable);
                            }
                        });
                    }
                });
                return;
            }
            setCompoundDrawables(1, view, this.mContext.getResources().getDrawable(i));
        } else if ("drawableRight".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.19
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Switcher.this.setCompoundDrawables(2, view, drawable);
                            }
                        });
                    }
                });
                return;
            }
            setCompoundDrawables(2, view, this.mContext.getResources().getDrawable(i));
        } else if ("drawableBottom".equals(str)) {
            if (!z) {
                this.mCountOfDrawablesInPageView++;
                DrawableLoader.loadDrawableAsync(this.mContext, i, new DrawableLoader.SingleDrawableLoadCallback() { // from class: com.xiaopeng.lib.themeswitch.Switcher.20
                    @Override // com.xiaopeng.lib.themeswitch.DrawableLoader.SingleDrawableLoadCallback
                    public void onDrawableLoadFinish(final Drawable drawable) {
                        Switcher.this.addRunnableToList(arrayList, new Runnable() { // from class: com.xiaopeng.lib.themeswitch.Switcher.20.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Switcher.this.setCompoundDrawables(3, view, drawable);
                            }
                        });
                    }
                });
                return;
            }
            setCompoundDrawables(3, view, this.mContext.getResources().getDrawable(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompoundDrawables(int i, View view, Drawable drawable) {
        TextView textView = (TextView) view;
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        compoundDrawables[i] = drawable;
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSwitch2Day(View view, String str, Object obj) {
        if ("background".equals(str)) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground((Drawable) obj);
            }
        } else if ("src".equals(str)) {
            ((ImageView) view).setImageDrawable((Drawable) obj);
        } else if ("textColorHint".equals(str)) {
            ((TextView) view).setHintTextColor(((Integer) obj).intValue());
        } else if (str.startsWith("textColor")) {
            if (str.endsWith(VIEW_ATTR_VALUE_DRAWABLE)) {
                ((TextView) view).setTextColor((ColorStateList) obj);
            } else {
                ((TextView) view).setTextColor(((Integer) obj).intValue());
            }
        } else if ("alpha".equals(str)) {
            view.setAlpha(((Float) obj).floatValue());
        } else if ("thumb".equals(str)) {
            ((SeekBar) view).setThumb((Drawable) obj);
        } else if ("progressDrawable".equals(str)) {
            ((ProgressBar) view).setProgressDrawable((Drawable) obj);
        } else if ("button".equals(str)) {
            ((CompoundButton) view).setButtonDrawable((Drawable) obj);
        } else if ("divider".equals(str)) {
            ((ListView) view).setDivider((Drawable) obj);
        } else if ("drawableLeft".equals(str)) {
            setCompoundDrawables(0, view, (Drawable) obj);
        } else if ("drawableTop".equals(str)) {
            setCompoundDrawables(1, view, (Drawable) obj);
        } else if ("drawableRight".equals(str)) {
            setCompoundDrawables(2, view, (Drawable) obj);
        } else if ("drawableBottom".equals(str)) {
            setCompoundDrawables(3, view, (Drawable) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSwitchFinish() {
        Log.d(TAG, "onSwitchFinish");
        this.mIsSwitching = false;
        if (this.mOnSwitchFinishListener != null) {
            Log.d(TAG, "onSwitchFinish: notify listener.");
            this.mOnSwitchFinishListener.onSwitchFinish();
        }
    }

    public void setOnSwitchFinishListener(OnSwitchFinishListener onSwitchFinishListener) {
        this.mOnSwitchFinishListener = onSwitchFinishListener;
    }
}
