package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
/* compiled from: EditorInfoCompat.java */
/* renamed from: hc  reason: default package */
/* loaded from: classes.dex */
public final class hc {
    private static final String[] a = new String[0];

    private static boolean a(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    public static void a(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static String[] a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : a;
        } else if (editorInfo.extras == null) {
            return a;
        } else {
            String[] stringArray = editorInfo.extras.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
            if (stringArray == null) {
                stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
            }
            return stringArray != null ? stringArray : a;
        }
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, 0);
        } else {
            a(editorInfo, charSequence, 0);
        }
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i) {
        int i2;
        int i3;
        fp.a(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, i);
            return;
        }
        if (editorInfo.initialSelStart > editorInfo.initialSelEnd) {
            i2 = editorInfo.initialSelEnd - i;
        } else {
            i2 = editorInfo.initialSelStart - i;
        }
        if (editorInfo.initialSelStart > editorInfo.initialSelEnd) {
            i3 = editorInfo.initialSelStart - i;
        } else {
            i3 = editorInfo.initialSelEnd - i;
        }
        int length = charSequence.length();
        if (i < 0 || i2 < 0 || i3 > length) {
            b(editorInfo, null, 0, 0);
        } else if (a(editorInfo.inputType)) {
            b(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            b(editorInfo, charSequence, i2, i3);
        } else {
            a(editorInfo, charSequence, i2, i3);
        }
    }

    private static void a(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        CharSequence subSequence;
        int i3 = i2 - i;
        int i4 = i3 > 1024 ? 0 : i3;
        int i5 = 2048 - i4;
        int min = Math.min(charSequence.length() - i2, i5 - Math.min(i, (int) (i5 * 0.8d)));
        int min2 = Math.min(i, i5 - min);
        int i6 = i - min2;
        if (a(charSequence, i6, 0)) {
            i6++;
            min2--;
        }
        if (a(charSequence, (i2 + min) - 1, 1)) {
            min--;
        }
        int i7 = min2 + i4 + min;
        if (i4 != i3) {
            subSequence = TextUtils.concat(charSequence.subSequence(i6, i6 + min2), charSequence.subSequence(i2, min + i2));
        } else {
            subSequence = charSequence.subSequence(i6, i7 + i6);
        }
        int i8 = min2 + 0;
        b(editorInfo, subSequence, i8, i4 + i8);
    }

    private static boolean a(CharSequence charSequence, int i, int i2) {
        switch (i2) {
            case 0:
                return Character.isLowSurrogate(charSequence.charAt(i));
            case 1:
                return Character.isHighSurrogate(charSequence.charAt(i));
            default:
                return false;
        }
    }

    private static void b(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EditorInfoCompat.java */
    /* renamed from: hc$a */
    /* loaded from: classes.dex */
    public static class a {
        static void a(EditorInfo editorInfo, CharSequence charSequence, int i) {
            editorInfo.setInitialSurroundingSubText(charSequence, i);
        }
    }
}
