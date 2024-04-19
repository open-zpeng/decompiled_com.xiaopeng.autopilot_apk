package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.badlogic.gdx.utils.z;
import defpackage.ip;
import defpackage.iq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class AndroidInput implements View.OnKeyListener, View.OnTouchListener, iq {
    public static final int NUM_TOUCHES = 20;
    public static final int SUPPORTED_KEYS = 260;
    private SensorEventListener accelerometerListener;
    final ij app;
    private SensorEventListener compassListener;
    private final AndroidApplicationConfiguration config;
    final Context context;
    private SensorEventListener gyroscopeListener;
    private Handler handle;
    final boolean hasMultitouch;
    boolean keyboardAvailable;
    private SensorManager manager;
    protected final iq.a nativeOrientation;
    private final AndroidOnscreenKeyboard onscreenKeyboard;
    private it processor;
    private SensorEventListener rotationVectorListener;
    private int sleepTime;
    protected final AndroidTouchHandler touchHandler;
    protected final Vibrator vibrator;
    z<KeyEvent> usedKeyEvents = new z<KeyEvent>(16, 1000) { // from class: com.badlogic.gdx.backends.android.AndroidInput.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.badlogic.gdx.utils.z
        public KeyEvent newObject() {
            return new KeyEvent();
        }
    };
    z<TouchEvent> usedTouchEvents = new z<TouchEvent>(16, 1000) { // from class: com.badlogic.gdx.backends.android.AndroidInput.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.badlogic.gdx.utils.z
        public TouchEvent newObject() {
            return new TouchEvent();
        }
    };
    ArrayList<View.OnKeyListener> keyListeners = new ArrayList<>();
    ArrayList<KeyEvent> keyEvents = new ArrayList<>();
    ArrayList<TouchEvent> touchEvents = new ArrayList<>();
    int[] touchX = new int[20];
    int[] touchY = new int[20];
    int[] deltaX = new int[20];
    int[] deltaY = new int[20];
    boolean[] touched = new boolean[20];
    int[] button = new int[20];
    int[] realId = new int[20];
    float[] pressure = new float[20];
    private int keyCount = 0;
    private boolean[] keys = new boolean[SUPPORTED_KEYS];
    private boolean keyJustPressed = false;
    private boolean[] justPressedKeys = new boolean[SUPPORTED_KEYS];
    public boolean accelerometerAvailable = false;
    protected final float[] accelerometerValues = new float[3];
    public boolean gyroscopeAvailable = false;
    protected final float[] gyroscopeValues = new float[3];
    private String text = null;
    private iq.c textListener = null;
    private boolean catchBack = false;
    private boolean catchMenu = false;
    private boolean compassAvailable = false;
    private boolean rotationVectorAvailable = false;
    protected final float[] magneticFieldValues = new float[3];
    protected final float[] rotationVectorValues = new float[3];
    private float azimuth = 0.0f;
    private float pitch = 0.0f;
    private float roll = 0.0f;
    private float inclination = 0.0f;
    private boolean justTouched = false;
    private long currentEventTimeStamp = System.nanoTime();
    boolean requestFocus = true;
    final float[] R = new float[9];
    final float[] orientation = new float[3];

    public boolean isCursorCatched() {
        return false;
    }

    public void setCursorCatched(boolean z) {
    }

    public void setCursorPosition(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class KeyEvent {
        static final int KEY_DOWN = 0;
        static final int KEY_TYPED = 2;
        static final int KEY_UP = 1;
        char keyChar;
        int keyCode;
        long timeStamp;
        int type;

        KeyEvent() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TouchEvent {
        static final int TOUCH_DOWN = 0;
        static final int TOUCH_DRAGGED = 2;
        static final int TOUCH_MOVED = 4;
        static final int TOUCH_SCROLLED = 3;
        static final int TOUCH_UP = 1;
        int button;
        int pointer;
        int scrollAmount;
        long timeStamp;
        int type;
        int x;
        int y;

        TouchEvent() {
        }
    }

    public AndroidInput(ij ijVar, Context context, Object obj, AndroidApplicationConfiguration androidApplicationConfiguration) {
        int i = 0;
        this.sleepTime = 0;
        if (obj instanceof View) {
            View view = (View) obj;
            view.setOnKeyListener(this);
            view.setOnTouchListener(this);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        }
        this.config = androidApplicationConfiguration;
        this.onscreenKeyboard = new AndroidOnscreenKeyboard(context, new Handler(), this);
        while (true) {
            int[] iArr = this.realId;
            if (i >= iArr.length) {
                break;
            }
            iArr[i] = -1;
            i++;
        }
        this.handle = new Handler();
        this.app = ijVar;
        this.context = context;
        this.sleepTime = androidApplicationConfiguration.touchSleepTime;
        this.touchHandler = new AndroidMultiTouchHandler();
        this.hasMultitouch = this.touchHandler.supportsMultitouch(context);
        this.vibrator = (Vibrator) context.getSystemService("vibrator");
        int rotation = getRotation();
        ip.b displayMode = this.app.getGraphics().getDisplayMode();
        if (((rotation == 0 || rotation == 180) && displayMode.width >= displayMode.height) || ((rotation == 90 || rotation == 270) && displayMode.width <= displayMode.height)) {
            this.nativeOrientation = iq.a.Landscape;
        } else {
            this.nativeOrientation = iq.a.Portrait;
        }
    }

    public float getAccelerometerX() {
        return this.accelerometerValues[0];
    }

    public float getAccelerometerY() {
        return this.accelerometerValues[1];
    }

    public float getAccelerometerZ() {
        return this.accelerometerValues[2];
    }

    public float getGyroscopeX() {
        return this.gyroscopeValues[0];
    }

    public float getGyroscopeY() {
        return this.gyroscopeValues[1];
    }

    public float getGyroscopeZ() {
        return this.gyroscopeValues[2];
    }

    /* renamed from: com.badlogic.gdx.backends.android.AndroidInput$3  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String val$hint;
        final /* synthetic */ iq.c val$listener;
        final /* synthetic */ String val$text;
        final /* synthetic */ String val$title;

        AnonymousClass3(String str, String str2, String str3, iq.c cVar) {
            this.val$title = str;
            this.val$hint = str2;
            this.val$text = str3;
            this.val$listener = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertDialog.Builder builder = new AlertDialog.Builder(AndroidInput.this.context);
            builder.setTitle(this.val$title);
            final EditText editText = new EditText(AndroidInput.this.context);
            editText.setHint(this.val$hint);
            editText.setText(this.val$text);
            editText.setSingleLine();
            builder.setView(editText);
            builder.setPositiveButton(AndroidInput.this.context.getString(17039370), new DialogInterface.OnClickListener() { // from class: com.badlogic.gdx.backends.android.AndroidInput.3.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    io.a.postRunnable(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidInput.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3.this.val$listener.a(editText.getText().toString());
                        }
                    });
                }
            });
            builder.setNegativeButton(AndroidInput.this.context.getString(17039360), new DialogInterface.OnClickListener() { // from class: com.badlogic.gdx.backends.android.AndroidInput.3.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    io.a.postRunnable(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidInput.3.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3.this.val$listener.a();
                        }
                    });
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.badlogic.gdx.backends.android.AndroidInput.3.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    io.a.postRunnable(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidInput.3.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass3.this.val$listener.a();
                        }
                    });
                }
            });
            builder.show();
        }
    }

    public void getTextInput(iq.c cVar, String str, String str2, String str3) {
        this.handle.post(new AnonymousClass3(str, str3, str2, cVar));
    }

    @Override // defpackage.iq
    public int getX() {
        int i;
        synchronized (this) {
            i = this.touchX[0];
        }
        return i;
    }

    @Override // defpackage.iq
    public int getY() {
        int i;
        synchronized (this) {
            i = this.touchY[0];
        }
        return i;
    }

    public int getX(int i) {
        int i2;
        synchronized (this) {
            i2 = this.touchX[i];
        }
        return i2;
    }

    public int getY(int i) {
        int i2;
        synchronized (this) {
            i2 = this.touchY[i];
        }
        return i2;
    }

    @Override // defpackage.iq
    public boolean isTouched(int i) {
        boolean z;
        synchronized (this) {
            z = this.touched[i];
        }
        return z;
    }

    public float getPressure() {
        return getPressure(0);
    }

    public float getPressure(int i) {
        return this.pressure[i];
    }

    public synchronized boolean isKeyPressed(int i) {
        if (i == -1) {
            return this.keyCount > 0;
        } else if (i < 0 || i >= 260) {
            return false;
        } else {
            return this.keys[i];
        }
    }

    public synchronized boolean isKeyJustPressed(int i) {
        if (i == -1) {
            return this.keyJustPressed;
        } else if (i < 0 || i >= 260) {
            return false;
        } else {
            return this.justPressedKeys[i];
        }
    }

    @Override // defpackage.iq
    public boolean isTouched() {
        synchronized (this) {
            if (this.hasMultitouch) {
                for (int i = 0; i < 20; i++) {
                    if (this.touched[i]) {
                        return true;
                    }
                }
            }
            return this.touched[0];
        }
    }

    @Override // defpackage.iq
    public void setInputProcessor(it itVar) {
        synchronized (this) {
            this.processor = itVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processEvents() {
        synchronized (this) {
            this.justTouched = false;
            if (this.keyJustPressed) {
                this.keyJustPressed = false;
                for (int i = 0; i < this.justPressedKeys.length; i++) {
                    this.justPressedKeys[i] = false;
                }
            }
            if (this.processor != null) {
                it itVar = this.processor;
                int size = this.keyEvents.size();
                for (int i2 = 0; i2 < size; i2++) {
                    KeyEvent keyEvent = this.keyEvents.get(i2);
                    this.currentEventTimeStamp = keyEvent.timeStamp;
                    switch (keyEvent.type) {
                        case 0:
                            itVar.a(keyEvent.keyCode);
                            this.keyJustPressed = true;
                            this.justPressedKeys[keyEvent.keyCode] = true;
                            break;
                        case 1:
                            itVar.b(keyEvent.keyCode);
                            break;
                        case 2:
                            itVar.a(keyEvent.keyChar);
                            break;
                    }
                    this.usedKeyEvents.free(keyEvent);
                }
                int size2 = this.touchEvents.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    TouchEvent touchEvent = this.touchEvents.get(i3);
                    this.currentEventTimeStamp = touchEvent.timeStamp;
                    switch (touchEvent.type) {
                        case 0:
                            itVar.a(touchEvent.x, touchEvent.y, touchEvent.pointer, touchEvent.button);
                            this.justTouched = true;
                            break;
                        case 1:
                            itVar.b(touchEvent.x, touchEvent.y, touchEvent.pointer, touchEvent.button);
                            break;
                        case 2:
                            itVar.a(touchEvent.x, touchEvent.y, touchEvent.pointer);
                            break;
                        case 3:
                            itVar.c(touchEvent.scrollAmount);
                            break;
                        case 4:
                            itVar.b(touchEvent.x, touchEvent.y);
                            break;
                    }
                    this.usedTouchEvents.free(touchEvent);
                }
            } else {
                int size3 = this.touchEvents.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    TouchEvent touchEvent2 = this.touchEvents.get(i4);
                    if (touchEvent2.type == 0) {
                        this.justTouched = true;
                    }
                    this.usedTouchEvents.free(touchEvent2);
                }
                int size4 = this.keyEvents.size();
                for (int i5 = 0; i5 < size4; i5++) {
                    this.usedKeyEvents.free(this.keyEvents.get(i5));
                }
            }
            if (this.touchEvents.isEmpty()) {
                for (int i6 = 0; i6 < this.deltaX.length; i6++) {
                    this.deltaX[0] = 0;
                    this.deltaY[0] = 0;
                }
            }
            this.keyEvents.clear();
            this.touchEvents.clear();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.requestFocus && view != null) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            this.requestFocus = false;
        }
        this.touchHandler.onTouch(motionEvent, this);
        int i = this.sleepTime;
        if (i != 0) {
            try {
                Thread.sleep(i);
            } catch (InterruptedException unused) {
            }
        }
        return true;
    }

    public void onTap(int i, int i2) {
        postTap(i, i2);
    }

    public void onDrop(int i, int i2) {
        postTap(i, i2);
    }

    protected void postTap(int i, int i2) {
        synchronized (this) {
            TouchEvent obtain = this.usedTouchEvents.obtain();
            obtain.timeStamp = System.nanoTime();
            obtain.pointer = 0;
            obtain.x = i;
            obtain.y = i2;
            obtain.type = 0;
            this.touchEvents.add(obtain);
            TouchEvent obtain2 = this.usedTouchEvents.obtain();
            obtain2.timeStamp = System.nanoTime();
            obtain2.pointer = 0;
            obtain2.x = i;
            obtain2.y = i2;
            obtain2.type = 1;
            this.touchEvents.add(obtain2);
        }
        io.a.getGraphics().requestRendering();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, android.view.KeyEvent keyEvent) {
        int size = this.keyListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.keyListeners.get(i2).onKey(view, i, keyEvent)) {
                return true;
            }
        }
        synchronized (this) {
            if (keyEvent.getKeyCode() == 0 && keyEvent.getAction() == 2) {
                String characters = keyEvent.getCharacters();
                for (int i3 = 0; i3 < characters.length(); i3++) {
                    KeyEvent obtain = this.usedKeyEvents.obtain();
                    obtain.timeStamp = System.nanoTime();
                    obtain.keyCode = 0;
                    obtain.keyChar = characters.charAt(i3);
                    obtain.type = 2;
                    this.keyEvents.add(obtain);
                }
                return false;
            }
            char unicodeChar = (char) keyEvent.getUnicodeChar();
            if (i == 67) {
                unicodeChar = '\b';
            }
            if (keyEvent.getKeyCode() >= 0 && keyEvent.getKeyCode() < 260) {
                switch (keyEvent.getAction()) {
                    case 0:
                        KeyEvent obtain2 = this.usedKeyEvents.obtain();
                        obtain2.timeStamp = System.nanoTime();
                        obtain2.keyChar = (char) 0;
                        obtain2.keyCode = keyEvent.getKeyCode();
                        obtain2.type = 0;
                        if (i == 4 && keyEvent.isAltPressed()) {
                            obtain2.keyCode = 255;
                            i = 255;
                        }
                        this.keyEvents.add(obtain2);
                        if (!this.keys[obtain2.keyCode]) {
                            this.keyCount++;
                            this.keys[obtain2.keyCode] = true;
                            break;
                        }
                        break;
                    case 1:
                        long nanoTime = System.nanoTime();
                        KeyEvent obtain3 = this.usedKeyEvents.obtain();
                        obtain3.timeStamp = nanoTime;
                        obtain3.keyChar = (char) 0;
                        obtain3.keyCode = keyEvent.getKeyCode();
                        obtain3.type = 1;
                        if (i == 4 && keyEvent.isAltPressed()) {
                            obtain3.keyCode = 255;
                            i = 255;
                        }
                        this.keyEvents.add(obtain3);
                        KeyEvent obtain4 = this.usedKeyEvents.obtain();
                        obtain4.timeStamp = nanoTime;
                        obtain4.keyChar = unicodeChar;
                        obtain4.keyCode = 0;
                        obtain4.type = 2;
                        this.keyEvents.add(obtain4);
                        if (i == 255) {
                            if (this.keys[255]) {
                                this.keyCount--;
                                this.keys[255] = false;
                                break;
                            }
                        } else if (this.keys[keyEvent.getKeyCode()]) {
                            this.keyCount--;
                            this.keys[keyEvent.getKeyCode()] = false;
                            break;
                        }
                        break;
                }
                this.app.getGraphics().requestRendering();
                if (i == 255) {
                    return true;
                }
                if (this.catchBack && i == 4) {
                    return true;
                }
                return this.catchMenu && i == 82;
            }
            return false;
        }
    }

    public void setOnscreenKeyboardVisible(final boolean z) {
        this.handle.post(new Runnable() { // from class: com.badlogic.gdx.backends.android.AndroidInput.4
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) AndroidInput.this.context.getSystemService("input_method");
                if (z) {
                    View view = ((AndroidGraphics) AndroidInput.this.app.getGraphics()).getView();
                    view.setFocusable(true);
                    view.setFocusableInTouchMode(true);
                    inputMethodManager.showSoftInput(((AndroidGraphics) AndroidInput.this.app.getGraphics()).getView(), 0);
                    return;
                }
                inputMethodManager.hideSoftInputFromWindow(((AndroidGraphics) AndroidInput.this.app.getGraphics()).getView().getWindowToken(), 0);
            }
        });
    }

    public void setCatchBackKey(boolean z) {
        this.catchBack = z;
    }

    public boolean isCatchBackKey() {
        return this.catchBack;
    }

    public void setCatchMenuKey(boolean z) {
        this.catchMenu = z;
    }

    public boolean isCatchMenuKey() {
        return this.catchMenu;
    }

    public void vibrate(int i) {
        this.vibrator.vibrate(i);
    }

    public void vibrate(long[] jArr, int i) {
        this.vibrator.vibrate(jArr, i);
    }

    public void cancelVibrate() {
        this.vibrator.cancel();
    }

    public boolean justTouched() {
        return this.justTouched;
    }

    public boolean isButtonPressed(int i) {
        synchronized (this) {
            boolean z = true;
            if (this.hasMultitouch) {
                for (int i2 = 0; i2 < 20; i2++) {
                    if (this.touched[i2] && this.button[i2] == i) {
                        return true;
                    }
                }
            }
            if (!this.touched[0] || this.button[0] != i) {
                z = false;
            }
            return z;
        }
    }

    private void updateOrientation() {
        if (this.rotationVectorAvailable) {
            SensorManager.getRotationMatrixFromVector(this.R, this.rotationVectorValues);
        } else if (!SensorManager.getRotationMatrix(this.R, null, this.accelerometerValues, this.magneticFieldValues)) {
            return;
        }
        SensorManager.getOrientation(this.R, this.orientation);
        this.azimuth = (float) Math.toDegrees(this.orientation[0]);
        this.pitch = (float) Math.toDegrees(this.orientation[1]);
        this.roll = (float) Math.toDegrees(this.orientation[2]);
    }

    public void getRotationMatrix(float[] fArr) {
        if (this.rotationVectorAvailable) {
            SensorManager.getRotationMatrixFromVector(fArr, this.rotationVectorValues);
        } else {
            SensorManager.getRotationMatrix(fArr, null, this.accelerometerValues, this.magneticFieldValues);
        }
    }

    public float getAzimuth() {
        if (this.compassAvailable || this.rotationVectorAvailable) {
            updateOrientation();
            return this.azimuth;
        }
        return 0.0f;
    }

    public float getPitch() {
        if (this.compassAvailable || this.rotationVectorAvailable) {
            updateOrientation();
            return this.pitch;
        }
        return 0.0f;
    }

    public float getRoll() {
        if (this.compassAvailable || this.rotationVectorAvailable) {
            updateOrientation();
            return this.roll;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerSensorListeners() {
        if (this.config.useAccelerometer) {
            this.manager = (SensorManager) this.context.getSystemService("sensor");
            if (this.manager.getSensorList(1).isEmpty()) {
                this.accelerometerAvailable = false;
            } else {
                this.accelerometerListener = new SensorListener();
                this.accelerometerAvailable = this.manager.registerListener(this.accelerometerListener, this.manager.getSensorList(1).get(0), this.config.sensorDelay);
            }
        } else {
            this.accelerometerAvailable = false;
        }
        if (this.config.useGyroscope) {
            this.manager = (SensorManager) this.context.getSystemService("sensor");
            if (this.manager.getSensorList(4).isEmpty()) {
                this.gyroscopeAvailable = false;
            } else {
                this.gyroscopeListener = new SensorListener();
                this.gyroscopeAvailable = this.manager.registerListener(this.gyroscopeListener, this.manager.getSensorList(4).get(0), this.config.sensorDelay);
            }
        } else {
            this.gyroscopeAvailable = false;
        }
        this.rotationVectorAvailable = false;
        if (this.config.useRotationVectorSensor) {
            if (this.manager == null) {
                this.manager = (SensorManager) this.context.getSystemService("sensor");
            }
            List<Sensor> sensorList = this.manager.getSensorList(11);
            if (!sensorList.isEmpty()) {
                this.rotationVectorListener = new SensorListener();
                Iterator<Sensor> it = sensorList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Sensor next = it.next();
                    if (next.getVendor().equals("Google Inc.") && next.getVersion() == 3) {
                        this.rotationVectorAvailable = this.manager.registerListener(this.rotationVectorListener, next, this.config.sensorDelay);
                        break;
                    }
                }
                if (!this.rotationVectorAvailable) {
                    this.rotationVectorAvailable = this.manager.registerListener(this.rotationVectorListener, sensorList.get(0), this.config.sensorDelay);
                }
            }
        }
        if (this.config.useCompass && !this.rotationVectorAvailable) {
            if (this.manager == null) {
                this.manager = (SensorManager) this.context.getSystemService("sensor");
            }
            Sensor defaultSensor = this.manager.getDefaultSensor(2);
            if (defaultSensor != null) {
                this.compassAvailable = this.accelerometerAvailable;
                if (this.compassAvailable) {
                    this.compassListener = new SensorListener();
                    this.compassAvailable = this.manager.registerListener(this.compassListener, defaultSensor, this.config.sensorDelay);
                }
            } else {
                this.compassAvailable = false;
            }
        } else {
            this.compassAvailable = false;
        }
        io.a.log("AndroidInput", "sensor listener setup");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterSensorListeners() {
        SensorManager sensorManager = this.manager;
        if (sensorManager != null) {
            SensorEventListener sensorEventListener = this.accelerometerListener;
            if (sensorEventListener != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.accelerometerListener = null;
            }
            SensorEventListener sensorEventListener2 = this.gyroscopeListener;
            if (sensorEventListener2 != null) {
                this.manager.unregisterListener(sensorEventListener2);
                this.gyroscopeListener = null;
            }
            SensorEventListener sensorEventListener3 = this.rotationVectorListener;
            if (sensorEventListener3 != null) {
                this.manager.unregisterListener(sensorEventListener3);
                this.rotationVectorListener = null;
            }
            SensorEventListener sensorEventListener4 = this.compassListener;
            if (sensorEventListener4 != null) {
                this.manager.unregisterListener(sensorEventListener4);
                this.compassListener = null;
            }
            this.manager = null;
        }
        io.a.log("AndroidInput", "sensor listener tear down");
    }

    public it getInputProcessor() {
        return this.processor;
    }

    public boolean isPeripheralAvailable(iq.b bVar) {
        Vibrator vibrator;
        if (bVar == iq.b.Accelerometer) {
            return this.accelerometerAvailable;
        }
        if (bVar == iq.b.Gyroscope) {
            return this.gyroscopeAvailable;
        }
        if (bVar == iq.b.Compass) {
            return this.compassAvailable;
        }
        if (bVar == iq.b.HardwareKeyboard) {
            return this.keyboardAvailable;
        }
        if (bVar == iq.b.OnscreenKeyboard) {
            return true;
        }
        return bVar == iq.b.Vibrator ? (Build.VERSION.SDK_INT < 11 || (vibrator = this.vibrator) == null) ? this.vibrator != null : vibrator.hasVibrator() : bVar == iq.b.MultitouchScreen ? this.hasMultitouch : bVar == iq.b.RotationVector ? this.rotationVectorAvailable : bVar == iq.b.Pressure;
    }

    public int getFreePointerIndex() {
        int length = this.realId.length;
        for (int i = 0; i < length; i++) {
            if (this.realId[i] == -1) {
                return i;
            }
        }
        this.realId = resize(this.realId);
        this.touchX = resize(this.touchX);
        this.touchY = resize(this.touchY);
        this.deltaX = resize(this.deltaX);
        this.deltaY = resize(this.deltaY);
        this.touched = resize(this.touched);
        this.button = resize(this.button);
        return length;
    }

    private int[] resize(int[] iArr) {
        int[] iArr2 = new int[iArr.length + 2];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    private boolean[] resize(boolean[] zArr) {
        boolean[] zArr2 = new boolean[zArr.length + 2];
        System.arraycopy(zArr, 0, zArr2, 0, zArr.length);
        return zArr2;
    }

    public int lookUpPointerIndex(int i) {
        int length = this.realId.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.realId[i2] == i) {
                return i2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(i3 + ":" + this.realId[i3] + " ");
        }
        io.a.log("AndroidInput", "Pointer ID lookup failed: " + i + ", " + sb.toString());
        return -1;
    }

    public int getRotation() {
        int rotation;
        Context context = this.context;
        if (context instanceof Activity) {
            rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        } else {
            rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        }
        switch (rotation) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return 0;
        }
    }

    public iq.a getNativeOrientation() {
        return this.nativeOrientation;
    }

    public int getDeltaX() {
        return this.deltaX[0];
    }

    public int getDeltaX(int i) {
        return this.deltaX[i];
    }

    public int getDeltaY() {
        return this.deltaY[0];
    }

    public int getDeltaY(int i) {
        return this.deltaY[i];
    }

    @Override // defpackage.iq
    public long getCurrentEventTime() {
        return this.currentEventTimeStamp;
    }

    public void addKeyListener(View.OnKeyListener onKeyListener) {
        this.keyListeners.add(onKeyListener);
    }

    public void onPause() {
        unregisterSensorListeners();
        Arrays.fill(this.realId, -1);
        Arrays.fill(this.touched, false);
    }

    public void onResume() {
        registerSensorListeners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SensorListener implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public SensorListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                if (AndroidInput.this.nativeOrientation == iq.a.Portrait) {
                    System.arraycopy(sensorEvent.values, 0, AndroidInput.this.accelerometerValues, 0, AndroidInput.this.accelerometerValues.length);
                } else {
                    AndroidInput.this.accelerometerValues[0] = sensorEvent.values[1];
                    AndroidInput.this.accelerometerValues[1] = -sensorEvent.values[0];
                    AndroidInput.this.accelerometerValues[2] = sensorEvent.values[2];
                }
            }
            if (sensorEvent.sensor.getType() == 2) {
                System.arraycopy(sensorEvent.values, 0, AndroidInput.this.magneticFieldValues, 0, AndroidInput.this.magneticFieldValues.length);
            }
            if (sensorEvent.sensor.getType() == 4) {
                if (AndroidInput.this.nativeOrientation == iq.a.Portrait) {
                    System.arraycopy(sensorEvent.values, 0, AndroidInput.this.gyroscopeValues, 0, AndroidInput.this.gyroscopeValues.length);
                } else {
                    AndroidInput.this.gyroscopeValues[0] = sensorEvent.values[1];
                    AndroidInput.this.gyroscopeValues[1] = -sensorEvent.values[0];
                    AndroidInput.this.gyroscopeValues[2] = sensorEvent.values[2];
                }
            }
            if (sensorEvent.sensor.getType() == 11) {
                if (AndroidInput.this.nativeOrientation == iq.a.Portrait) {
                    System.arraycopy(sensorEvent.values, 0, AndroidInput.this.rotationVectorValues, 0, AndroidInput.this.rotationVectorValues.length);
                    return;
                }
                AndroidInput.this.rotationVectorValues[0] = sensorEvent.values[1];
                AndroidInput.this.rotationVectorValues[1] = -sensorEvent.values[0];
                AndroidInput.this.rotationVectorValues[2] = sensorEvent.values[2];
            }
        }
    }
}
