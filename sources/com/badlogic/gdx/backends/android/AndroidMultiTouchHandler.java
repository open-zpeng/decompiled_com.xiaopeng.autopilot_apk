package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import com.badlogic.gdx.backends.android.AndroidInput;
/* loaded from: classes.dex */
public class AndroidMultiTouchHandler implements AndroidTouchHandler {
    private int toGdxButton(int i) {
        if (i == 0 || i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        return i == 16 ? 4 : -1;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidTouchHandler
    public void onTouch(MotionEvent motionEvent, AndroidInput androidInput) {
        int gdxButton;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int action = motionEvent.getAction() & 255;
        int action2 = (motionEvent.getAction() & 65280) >> 8;
        int pointerId = motionEvent.getPointerId(action2);
        long nanoTime = System.nanoTime();
        synchronized (androidInput) {
            int i9 = 20;
            try {
                switch (action) {
                    case 0:
                    case 5:
                        int freePointerIndex = androidInput.getFreePointerIndex();
                        if (freePointerIndex >= 20) {
                            break;
                        } else {
                            androidInput.realId[freePointerIndex] = pointerId;
                            int x = (int) motionEvent.getX(action2);
                            int y = (int) motionEvent.getY(action2);
                            if (Build.VERSION.SDK_INT >= 14) {
                                try {
                                    gdxButton = toGdxButton(motionEvent.getButtonState());
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            } else {
                                gdxButton = 0;
                            }
                            if (gdxButton != -1) {
                                i = gdxButton;
                                i2 = x;
                                i3 = y;
                                postTouchEvent(androidInput, 0, x, y, freePointerIndex, i, nanoTime);
                            } else {
                                i = gdxButton;
                                i2 = x;
                                i3 = y;
                            }
                            androidInput.touchX[freePointerIndex] = i2;
                            androidInput.touchY[freePointerIndex] = i3;
                            androidInput.deltaX[freePointerIndex] = 0;
                            androidInput.deltaY[freePointerIndex] = 0;
                            int i10 = i;
                            androidInput.touched[freePointerIndex] = i10 != -1;
                            androidInput.button[freePointerIndex] = i10;
                            androidInput.pressure[freePointerIndex] = motionEvent.getPressure(action2);
                            break;
                        }
                    case 1:
                    case 4:
                    case 6:
                        int lookUpPointerIndex = androidInput.lookUpPointerIndex(pointerId);
                        if (lookUpPointerIndex != -1 && lookUpPointerIndex < 20) {
                            androidInput.realId[lookUpPointerIndex] = -1;
                            int x2 = (int) motionEvent.getX(action2);
                            int y2 = (int) motionEvent.getY(action2);
                            int i11 = androidInput.button[lookUpPointerIndex];
                            if (i11 != -1) {
                                i4 = x2;
                                postTouchEvent(androidInput, 1, x2, y2, lookUpPointerIndex, i11, nanoTime);
                            } else {
                                i4 = x2;
                            }
                            androidInput.touchX[lookUpPointerIndex] = i4;
                            androidInput.touchY[lookUpPointerIndex] = y2;
                            androidInput.deltaX[lookUpPointerIndex] = 0;
                            androidInput.deltaY[lookUpPointerIndex] = 0;
                            androidInput.touched[lookUpPointerIndex] = false;
                            androidInput.button[lookUpPointerIndex] = 0;
                            androidInput.pressure[lookUpPointerIndex] = 0.0f;
                            break;
                        }
                        break;
                    case 2:
                        int pointerCount = motionEvent.getPointerCount();
                        int i12 = 0;
                        while (i12 < pointerCount) {
                            int pointerId2 = motionEvent.getPointerId(i12);
                            int x3 = (int) motionEvent.getX(i12);
                            int y3 = (int) motionEvent.getY(i12);
                            int lookUpPointerIndex2 = androidInput.lookUpPointerIndex(pointerId2);
                            if (lookUpPointerIndex2 == -1) {
                                i7 = i12;
                            } else if (lookUpPointerIndex2 >= i9) {
                                break;
                            } else {
                                int i13 = androidInput.button[lookUpPointerIndex2];
                                if (i13 != -1) {
                                    i5 = lookUpPointerIndex2;
                                    i6 = y3;
                                    i7 = i12;
                                    i8 = x3;
                                    postTouchEvent(androidInput, 2, x3, y3, lookUpPointerIndex2, i13, nanoTime);
                                } else {
                                    i5 = lookUpPointerIndex2;
                                    i6 = y3;
                                    i7 = i12;
                                    i8 = x3;
                                    postTouchEvent(androidInput, 4, i8, i6, lookUpPointerIndex2, 0, nanoTime);
                                }
                                androidInput.deltaX[i5] = i8 - androidInput.touchX[i5];
                                androidInput.deltaY[i5] = i6 - androidInput.touchY[i5];
                                androidInput.touchX[i5] = i8;
                                androidInput.touchY[i5] = i6;
                                androidInput.pressure[i5] = motionEvent.getPressure(i7);
                            }
                            i12 = i7 + 1;
                            i9 = 20;
                        }
                        break;
                    case 3:
                        for (int i14 = 0; i14 < androidInput.realId.length; i14++) {
                            androidInput.realId[i14] = -1;
                            androidInput.touchX[i14] = 0;
                            androidInput.touchY[i14] = 0;
                            androidInput.deltaX[i14] = 0;
                            androidInput.deltaY[i14] = 0;
                            androidInput.touched[i14] = false;
                            androidInput.button[i14] = 0;
                            androidInput.pressure[i14] = 0.0f;
                        }
                        break;
                }
                io.a.getGraphics().requestRendering();
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private void logAction(int i, int i2) {
        String str;
        if (i == 0) {
            str = "DOWN";
        } else if (i == 5) {
            str = "POINTER DOWN";
        } else if (i == 1) {
            str = "UP";
        } else if (i == 6) {
            str = "POINTER UP";
        } else if (i == 4) {
            str = "OUTSIDE";
        } else if (i == 3) {
            str = "CANCEL";
        } else if (i == 2) {
            str = "MOVE";
        } else {
            str = "UNKNOWN (" + i + ")";
        }
        io.a.log("AndroidMultiTouchHandler", "action " + str + ", Android pointer id: " + i2);
    }

    private void postTouchEvent(AndroidInput androidInput, int i, int i2, int i3, int i4, int i5, long j) {
        AndroidInput.TouchEvent obtain = androidInput.usedTouchEvents.obtain();
        obtain.timeStamp = j;
        obtain.pointer = i4;
        obtain.x = i2;
        obtain.y = i3;
        obtain.type = i;
        obtain.button = i5;
        androidInput.touchEvents.add(obtain);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidTouchHandler
    public boolean supportsMultitouch(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch");
    }
}
