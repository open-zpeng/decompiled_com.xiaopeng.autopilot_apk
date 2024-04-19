package defpackage;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: KeyFrames.java */
/* renamed from: dj  reason: default package */
/* loaded from: classes.dex */
public class dj {
    static HashMap<String, Constructor<? extends dg>> a = new HashMap<>();
    private HashMap<Integer, ArrayList<dg>> b = new HashMap<>();

    static {
        try {
            a.put("KeyAttribute", dh.class.getConstructor(new Class[0]));
            a.put("KeyPosition", dk.class.getConstructor(new Class[0]));
            a.put("KeyCycle", di.class.getConstructor(new Class[0]));
            a.put("KeyTimeCycle", dm.class.getConstructor(new Class[0]));
            a.put("KeyTrigger", dn.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e) {
            Log.e("KeyFrames", "unable to load", e);
        }
    }

    public void a(dg dgVar) {
        if (!this.b.containsKey(Integer.valueOf(dgVar.c))) {
            this.b.put(Integer.valueOf(dgVar.c), new ArrayList<>());
        }
        ArrayList<dg> arrayList = this.b.get(Integer.valueOf(dgVar.c));
        if (arrayList != null) {
            arrayList.add(dgVar);
        }
    }

    public dj() {
    }

    public dj(Context context, XmlPullParser xmlPullParser) {
        dg dgVar = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType != 0) {
                    switch (eventType) {
                        case 2:
                            String name = xmlPullParser.getName();
                            if (a.containsKey(name)) {
                                try {
                                    Constructor<? extends dg> constructor = a.get(name);
                                    if (constructor != null) {
                                        dg newInstance = constructor.newInstance(new Object[0]);
                                        try {
                                            newInstance.a(context, Xml.asAttributeSet(xmlPullParser));
                                            a(newInstance);
                                            dgVar = newInstance;
                                        } catch (Exception e) {
                                            e = e;
                                            dgVar = newInstance;
                                            Log.e("KeyFrames", "unable to create ", e);
                                            eventType = xmlPullParser.next();
                                        }
                                    } else {
                                        throw new NullPointerException("Keymaker for " + name + " not found");
                                        break;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } else if (name.equalsIgnoreCase("CustomAttribute")) {
                                if (dgVar != null && dgVar.f != null) {
                                    b.a(context, xmlPullParser, dgVar.f);
                                }
                            } else if (name.equalsIgnoreCase("CustomMethod") && dgVar != null && dgVar.f != null) {
                                b.a(context, xmlPullParser, dgVar.f);
                                continue;
                            }
                            break;
                        case 3:
                            if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                                return;
                            }
                            continue;
                        default:
                            continue;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    public void a(dp dpVar) {
        ArrayList<dg> arrayList = this.b.get(-1);
        if (arrayList != null) {
            dpVar.a(arrayList);
        }
    }

    public void b(dp dpVar) {
        ArrayList<dg> arrayList = this.b.get(Integer.valueOf(dpVar.c));
        if (arrayList != null) {
            dpVar.a(arrayList);
        }
        ArrayList<dg> arrayList2 = this.b.get(-1);
        if (arrayList2 != null) {
            Iterator<dg> it = arrayList2.iterator();
            while (it.hasNext()) {
                dg next = it.next();
                if (next.a(((ConstraintLayout.a) dpVar.b.getLayoutParams()).ab)) {
                    dpVar.a(next);
                }
            }
        }
    }

    public ArrayList<dg> a(int i) {
        return this.b.get(Integer.valueOf(i));
    }
}
