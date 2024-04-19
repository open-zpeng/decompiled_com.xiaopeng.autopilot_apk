package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
/* compiled from: InputConnectionCompat.java */
/* renamed from: hd  reason: default package */
/* loaded from: classes.dex */
public final class hd {

    /* compiled from: InputConnectionCompat.java */
    /* renamed from: hd$a */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(he heVar, int i, Bundle bundle);
    }

    static boolean a(String str, Bundle bundle, a aVar) {
        boolean z;
        ResultReceiver resultReceiver;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            z = false;
        } else if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            return false;
        } else {
            z = true;
        }
        try {
            resultReceiver = (ResultReceiver) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER");
            try {
                Uri uri = (Uri) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI");
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION");
                boolean a2 = (uri == null || clipDescription == null) ? false : aVar.a(new he(uri, clipDescription, (Uri) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI")), bundle.getInt(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"), (Bundle) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"));
                if (resultReceiver != null) {
                    resultReceiver.send(a2 ? 1 : 0, null);
                }
                return a2;
            } catch (Throwable th) {
                th = th;
                if (resultReceiver != null) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            resultReceiver = null;
        }
    }

    public static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, final a aVar) {
        if (inputConnection != null) {
            if (editorInfo != null) {
                if (aVar == null) {
                    throw new IllegalArgumentException("onCommitContentListener must be non-null");
                }
                if (Build.VERSION.SDK_INT >= 25) {
                    return new InputConnectionWrapper(inputConnection, false) { // from class: hd.1
                        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                        public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
                            if (aVar.a(he.a(inputContentInfo), i, bundle)) {
                                return true;
                            }
                            return super.commitContent(inputContentInfo, i, bundle);
                        }
                    };
                }
                return hc.a(editorInfo).length == 0 ? inputConnection : new InputConnectionWrapper(inputConnection, false) { // from class: hd.2
                    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                    public boolean performPrivateCommand(String str, Bundle bundle) {
                        if (hd.a(str, bundle, aVar)) {
                            return true;
                        }
                        return super.performPrivateCommand(str, bundle);
                    }
                };
            }
            throw new IllegalArgumentException("editorInfo must be non-null");
        }
        throw new IllegalArgumentException("inputConnection must be non-null");
    }
}
