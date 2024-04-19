package com.badlogic.gdx.backends.android;

import android.content.SharedPreferences;
import android.os.Build;
import java.util.Map;
/* loaded from: classes.dex */
public class AndroidPreferences implements iw {
    SharedPreferences.Editor editor;
    SharedPreferences sharedPrefs;

    public AndroidPreferences(SharedPreferences sharedPreferences) {
        this.sharedPrefs = sharedPreferences;
    }

    public iw putBoolean(String str, boolean z) {
        edit();
        this.editor.putBoolean(str, z);
        return this;
    }

    public iw putInteger(String str, int i) {
        edit();
        this.editor.putInt(str, i);
        return this;
    }

    public iw putLong(String str, long j) {
        edit();
        this.editor.putLong(str, j);
        return this;
    }

    public iw putFloat(String str, float f) {
        edit();
        this.editor.putFloat(str, f);
        return this;
    }

    public iw putString(String str, String str2) {
        edit();
        this.editor.putString(str, str2);
        return this;
    }

    public iw put(Map<String, ?> map) {
        edit();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (entry.getValue() instanceof Boolean) {
                putBoolean(entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
            if (entry.getValue() instanceof Integer) {
                putInteger(entry.getKey(), ((Integer) entry.getValue()).intValue());
            }
            if (entry.getValue() instanceof Long) {
                putLong(entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            if (entry.getValue() instanceof String) {
                putString(entry.getKey(), (String) entry.getValue());
            }
            if (entry.getValue() instanceof Float) {
                putFloat(entry.getKey(), ((Float) entry.getValue()).floatValue());
            }
        }
        return this;
    }

    public boolean getBoolean(String str) {
        return this.sharedPrefs.getBoolean(str, false);
    }

    public int getInteger(String str) {
        return this.sharedPrefs.getInt(str, 0);
    }

    public long getLong(String str) {
        return this.sharedPrefs.getLong(str, 0L);
    }

    public float getFloat(String str) {
        return this.sharedPrefs.getFloat(str, 0.0f);
    }

    public String getString(String str) {
        return this.sharedPrefs.getString(str, "");
    }

    public boolean getBoolean(String str, boolean z) {
        return this.sharedPrefs.getBoolean(str, z);
    }

    public int getInteger(String str, int i) {
        return this.sharedPrefs.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.sharedPrefs.getLong(str, j);
    }

    public float getFloat(String str, float f) {
        return this.sharedPrefs.getFloat(str, f);
    }

    public String getString(String str, String str2) {
        return this.sharedPrefs.getString(str, str2);
    }

    public Map<String, ?> get() {
        return this.sharedPrefs.getAll();
    }

    public boolean contains(String str) {
        return this.sharedPrefs.contains(str);
    }

    public void clear() {
        edit();
        this.editor.clear();
    }

    public void flush() {
        if (this.editor != null) {
            if (Build.VERSION.SDK_INT >= 9) {
                this.editor.apply();
            } else {
                this.editor.commit();
            }
            this.editor = null;
        }
    }

    public void remove(String str) {
        edit();
        this.editor.remove(str);
    }

    private void edit() {
        if (this.editor == null) {
            this.editor = this.sharedPrefs.edit();
        }
    }
}
