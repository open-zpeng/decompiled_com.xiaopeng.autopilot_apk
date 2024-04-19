package com.badlogic.gdx.backends.android;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import defpackage.iq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AndroidOnscreenKeyboard implements View.OnKeyListener, View.OnTouchListener {
    final Context context;
    Dialog dialog;
    final Handler handler;
    final AndroidInput input;
    TextView textView;

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public AndroidOnscreenKeyboard(Context context, Handler handler, AndroidInput androidInput) {
        this.context = context;
        this.handler = handler;
        this.input = androidInput;
    }

    Dialog createDialog() {
        this.textView = createView(this.context);
        this.textView.setOnKeyListener(this);
        this.textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.textView.setFocusable(true);
        this.textView.setFocusableInTouchMode(true);
        TextView textView = this.textView;
        textView.setImeOptions(textView.getImeOptions() | 268435456);
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
        frameLayout.addView(this.textView);
        frameLayout.setOnTouchListener(this);
        this.dialog = new Dialog(this.context, 16973841);
        this.dialog.setContentView(frameLayout);
        return this.dialog;
    }

    public static TextView createView(Context context) {
        return new TextView(context) { // from class: com.badlogic.gdx.backends.android.AndroidOnscreenKeyboard.1
            Editable editable = new PassThroughEditable();

            @Override // android.widget.TextView
            protected boolean getDefaultEditable() {
                return true;
            }

            @Override // android.widget.TextView
            public Editable getEditableText() {
                return this.editable;
            }

            @Override // android.widget.TextView
            protected MovementMethod getDefaultMovementMethod() {
                return ArrowKeyMovementMethod.getInstance();
            }

            @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                Log.d("Test", "down keycode: " + keyEvent.getKeyCode());
                return super.onKeyDown(i, keyEvent);
            }

            @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
            public boolean onKeyUp(int i, KeyEvent keyEvent) {
                Log.d("Test", "up keycode: " + keyEvent.getKeyCode());
                return super.onKeyUp(i, keyEvent);
            }
        };
    }

    public void setVisible(boolean z) {
        Dialog dialog;
        Dialog dialog2;
        if (z && (dialog2 = this.dialog) != null) {
            dialog2.dismiss();
            this.dialog = null;
        }
        if (z && this.dialog == null && !this.input.isPeripheralAvailable(iq.b.HardwareKeyboard)) {
            this.handler.post(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidOnscreenKeyboard.2
                @Override // java.lang.Runnable
                public void run() {
                    AndroidOnscreenKeyboard androidOnscreenKeyboard = AndroidOnscreenKeyboard.this;
                    androidOnscreenKeyboard.dialog = androidOnscreenKeyboard.createDialog();
                    AndroidOnscreenKeyboard.this.dialog.show();
                    AndroidOnscreenKeyboard.this.handler.post(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidOnscreenKeyboard.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AndroidOnscreenKeyboard.this.dialog.getWindow().setSoftInputMode(32);
                            InputMethodManager inputMethodManager = (InputMethodManager) AndroidOnscreenKeyboard.this.context.getSystemService("input_method");
                            if (inputMethodManager != null) {
                                inputMethodManager.showSoftInput(AndroidOnscreenKeyboard.this.textView, 2);
                            }
                        }
                    });
                    final View findViewById = AndroidOnscreenKeyboard.this.dialog.getWindow().findViewById(16908290);
                    findViewById.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.badlogic.gdx.backends.android.AndroidOnscreenKeyboard.2.2
                        private int keyboardHeight;
                        private boolean keyboardShowing;
                        int[] screenloc = new int[2];

                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public boolean onPreDraw() {
                            findViewById.getLocationOnScreen(this.screenloc);
                            this.keyboardHeight = Math.abs(this.screenloc[1]);
                            if (this.keyboardHeight > 0) {
                                this.keyboardShowing = true;
                            }
                            if (this.keyboardHeight == 0 && this.keyboardShowing) {
                                AndroidOnscreenKeyboard.this.dialog.dismiss();
                                AndroidOnscreenKeyboard.this.dialog = null;
                            }
                            return true;
                        }
                    });
                }
            });
        } else if (z || (dialog = this.dialog) == null) {
        } else {
            dialog.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public static class PassThroughEditable implements Editable {
        @Override // java.lang.CharSequence
        public char charAt(int i) {
            Log.d("Editable", "charAt");
            return (char) 0;
        }

        @Override // java.lang.CharSequence
        public int length() {
            Log.d("Editable", "length");
            return 0;
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            Log.d("Editable", "subSequence");
            return null;
        }

        @Override // android.text.GetChars
        public void getChars(int i, int i2, char[] cArr, int i3) {
            Log.d("Editable", "getChars");
        }

        @Override // android.text.Spannable
        public void removeSpan(Object obj) {
            Log.d("Editable", "removeSpan");
        }

        @Override // android.text.Spannable
        public void setSpan(Object obj, int i, int i2, int i3) {
            Log.d("Editable", "setSpan");
        }

        @Override // android.text.Spanned
        public int getSpanEnd(Object obj) {
            Log.d("Editable", "getSpanEnd");
            return 0;
        }

        @Override // android.text.Spanned
        public int getSpanFlags(Object obj) {
            Log.d("Editable", "getSpanFlags");
            return 0;
        }

        @Override // android.text.Spanned
        public int getSpanStart(Object obj) {
            Log.d("Editable", "getSpanStart");
            return 0;
        }

        @Override // android.text.Spanned
        public <T> T[] getSpans(int i, int i2, Class<T> cls) {
            Log.d("Editable", "getSpans");
            return null;
        }

        @Override // android.text.Spanned
        public int nextSpanTransition(int i, int i2, Class cls) {
            Log.d("Editable", "nextSpanTransition");
            return 0;
        }

        @Override // android.text.Editable, java.lang.Appendable
        public Editable append(CharSequence charSequence) {
            Log.d("Editable", "append: " + ((Object) charSequence));
            return this;
        }

        @Override // android.text.Editable, java.lang.Appendable
        public Editable append(char c) {
            Log.d("Editable", "append: " + c);
            return this;
        }

        @Override // android.text.Editable, java.lang.Appendable
        public Editable append(CharSequence charSequence, int i, int i2) {
            Log.d("Editable", "append: " + ((Object) charSequence));
            return this;
        }

        @Override // android.text.Editable
        public void clear() {
            Log.d("Editable", "clear");
        }

        @Override // android.text.Editable
        public void clearSpans() {
            Log.d("Editable", "clearSpanes");
        }

        @Override // android.text.Editable
        public Editable delete(int i, int i2) {
            Log.d("Editable", "delete, " + i + ", " + i2);
            return this;
        }

        @Override // android.text.Editable
        public InputFilter[] getFilters() {
            Log.d("Editable", "getFilters");
            return new InputFilter[0];
        }

        @Override // android.text.Editable
        public Editable insert(int i, CharSequence charSequence) {
            Log.d("Editable", "insert: " + ((Object) charSequence));
            return this;
        }

        @Override // android.text.Editable
        public Editable insert(int i, CharSequence charSequence, int i2, int i3) {
            Log.d("Editable", "insert: " + ((Object) charSequence));
            return this;
        }

        @Override // android.text.Editable
        public Editable replace(int i, int i2, CharSequence charSequence) {
            Log.d("Editable", "replace: " + ((Object) charSequence));
            return this;
        }

        @Override // android.text.Editable
        public Editable replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
            Log.d("Editable", "replace: " + ((Object) charSequence));
            return this;
        }

        @Override // android.text.Editable
        public void setFilters(InputFilter[] inputFilterArr) {
            Log.d("Editable", "setFilters");
        }
    }
}
