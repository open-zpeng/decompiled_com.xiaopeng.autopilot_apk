package com.badlogic.gdx.utils;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
/* compiled from: SerializationException.java */
/* loaded from: classes.dex */
public class af extends RuntimeException {
    private al a;

    public af() {
    }

    public af(String str, Throwable th) {
        super(str, th);
    }

    public af(String str) {
        super(str);
    }

    public af(Throwable th) {
        super("", th);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.a == null) {
            return super.getMessage();
        }
        al alVar = new al((int) IInputController.KEYCODE_BACK_BUTTON);
        alVar.c(super.getMessage());
        if (alVar.length() > 0) {
            alVar.append('\n');
        }
        alVar.c("Serialization trace:");
        alVar.a(this.a);
        return alVar.toString();
    }

    public void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("info cannot be null.");
        }
        if (this.a == null) {
            this.a = new al((int) IInputController.KEYCODE_BACK_BUTTON);
        }
        this.a.append('\n');
        this.a.c(str);
    }
}
