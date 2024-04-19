package com.badlogic.gdx.backends.android;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.ClipboardManager;
import com.badlogic.gdx.utils.e;
/* loaded from: classes.dex */
public class AndroidClipboard implements e {
    private ClipboardManager clipboard;
    private android.content.ClipboardManager honeycombClipboard;

    public AndroidClipboard(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            this.clipboard = (ClipboardManager) context.getSystemService("clipboard");
        } else {
            this.honeycombClipboard = (android.content.ClipboardManager) context.getSystemService("clipboard");
        }
    }

    public String getContents() {
        CharSequence text;
        if (Build.VERSION.SDK_INT < 11) {
            if (this.clipboard.getText() == null) {
                return null;
            }
            return this.clipboard.getText().toString();
        }
        ClipData primaryClip = this.honeycombClipboard.getPrimaryClip();
        if (primaryClip == null || (text = primaryClip.getItemAt(0).getText()) == null) {
            return null;
        }
        return text.toString();
    }

    public void setContents(String str) {
        if (Build.VERSION.SDK_INT < 11) {
            this.clipboard.setText(str);
            return;
        }
        this.honeycombClipboard.setPrimaryClip(ClipData.newPlainText(str, str));
    }
}
