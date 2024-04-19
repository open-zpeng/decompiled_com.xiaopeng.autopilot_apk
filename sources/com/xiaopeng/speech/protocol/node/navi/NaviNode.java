package com.xiaopeng.speech.protocol.node.navi;

import android.text.TextUtils;
import com.xiaopeng.speech.annotation.SpeechAnnotation;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NaviNode extends xa<a> {
    private boolean d;

    @SpeechAnnotation
    public void onControlClose(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a();
            }
        }
    }

    @SpeechAnnotation
    public void onMapZoomIn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b();
            }
        }
    }

    @SpeechAnnotation
    public void onMapZoomOut(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).c();
            }
        }
    }

    @SpeechAnnotation
    public void onOpenTraffic(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).d();
            }
        }
    }

    @SpeechAnnotation
    public void onCloseTraffic(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).e();
            }
        }
    }

    @SpeechAnnotation
    public void onControlOverviewOpen(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).f();
            }
        }
    }

    @SpeechAnnotation
    public void onControlOverviewClose(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).g();
            }
        }
    }

    @SpeechAnnotation
    public void onMapOverview(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).h();
            }
        }
    }

    @SpeechAnnotation
    public void onControlFavoriteOpen(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).i();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSettingsOpen(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).j();
            }
        }
    }

    @SpeechAnnotation
    public void onControlChargeOpen(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).k();
            }
        }
    }

    @SpeechAnnotation
    public void onControlChargeClose(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).l();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveAvoidCongestion(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).m();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveAvoidCongestionOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).n();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveAvoidCharge(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).o();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveAvoidChargeOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).p();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveHighwayFirstOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).t();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveAvoidControls(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).u();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveAvoidControlsOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).v();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveRadarRoute(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).w();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveRadarRouteOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).x();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSpeechSuperSimple(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).z();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSpeechGeneral(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).B();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSpeechEye(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).D();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSpeechEyeOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).E();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSmartScale(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).F();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSmartScaleOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).G();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSecurityRemind(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).H();
            }
        }
    }

    @SpeechAnnotation
    public void onControlRoadAhead(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).J();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveHighwayNo(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).q();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveHighwayNoOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).r();
            }
        }
    }

    @SpeechAnnotation
    public void onDriveHighwayFirst(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).s();
            }
        }
    }

    @SpeechAnnotation
    public void onNavigatingGet(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).y();
            }
        }
    }

    @SpeechAnnotation
    public void onPoiSearch(String str, String str2) {
        zz a = zz.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a);
            }
        }
    }

    @SpeechAnnotation
    public void onControlSecurityRemindOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).I();
            }
        }
    }

    @SpeechAnnotation
    public void onMapEnterFindPath(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).Q();
            }
        }
    }

    @SpeechAnnotation
    public void onMapExitFindPath(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).R();
            }
        }
    }

    @SpeechAnnotation
    public void onSearchClose(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).S();
            }
        }
    }

    @SpeechAnnotation
    public void onMainRoad(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).T();
            }
        }
    }

    @SpeechAnnotation
    public void onSideRoad(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).U();
            }
        }
    }

    @SpeechAnnotation
    public void onControlFavoriteClose(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).V();
            }
        }
    }

    @SpeechAnnotation
    public void onControlRoadAheadOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).K();
            }
        }
    }

    @SpeechAnnotation
    public void onMapZoominMax(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).W();
            }
        }
    }

    @SpeechAnnotation
    public void onMapZoomoutMin(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).X();
            }
        }
    }

    @SpeechAnnotation
    public void onNearbySearch(String str, String str2) {
        zu a = zu.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a);
            }
        }
    }

    @SpeechAnnotation
    public void onAddressGet(String str, String str2) {
        zr a = zr.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a);
            }
        }
        this.d = false;
    }

    @SpeechAnnotation
    public void onAddressPendingRoute(String str, String str2) {
        xx.b(this, "pending route");
        this.d = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    @com.xiaopeng.speech.annotation.SpeechAnnotation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAddressSet(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            zr r9 = new zr
            r9.<init>()
            r0 = 0
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3f
            r2.<init>(r10)     // Catch: org.json.JSONException -> L3f
            java.lang.String r10 = "addressType"
            java.lang.String r10 = r2.optString(r10)     // Catch: org.json.JSONException -> L3f
            r9.b(r10)     // Catch: org.json.JSONException -> L3f
            java.lang.String r10 = "poi"
            java.lang.String r10 = r2.optString(r10)     // Catch: org.json.JSONException -> L3f
            zw r10 = defpackage.zw.a(r10)     // Catch: org.json.JSONException -> L3f
            java.lang.String r3 = "pref"
            java.lang.String r3 = r2.optString(r3)     // Catch: org.json.JSONException -> L3c
            java.lang.String r4 = "type"
            java.lang.String r0 = r2.optString(r4)     // Catch: org.json.JSONException -> L3a
            java.lang.String r4 = "naviType"
            int r4 = r2.optInt(r4)     // Catch: org.json.JSONException -> L3a
            java.lang.String r5 = "routeSelectRef"
            int r2 = r2.optInt(r5)     // Catch: org.json.JSONException -> L38
            goto L47
        L38:
            r2 = move-exception
            goto L43
        L3a:
            r2 = move-exception
            goto L42
        L3c:
            r2 = move-exception
            r3 = r0
            goto L42
        L3f:
            r2 = move-exception
            r10 = r0
            r3 = r10
        L42:
            r4 = r1
        L43:
            r2.printStackTrace()
            r2 = r1
        L47:
            xy<T> r5 = r8.b
            java.lang.Object[] r5 = r5.a()
            if (r5 == 0) goto L5d
            r6 = r1
        L50:
            int r7 = r5.length
            if (r6 >= r7) goto L5d
            r7 = r5[r6]
            com.xiaopeng.speech.protocol.node.navi.a r7 = (com.xiaopeng.speech.protocol.node.navi.a) r7
            r7.a(r9, r10)
            int r6 = r6 + 1
            goto L50
        L5d:
            boolean r9 = r8.d
            if (r9 == 0) goto L6f
            aac r9 = new aac
            r9.<init>(r10, r3, r0)
            r9.a(r4)
            r9.b(r2)
            r8.a(r9)
        L6f:
            r8.d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.speech.protocol.node.navi.NaviNode.onAddressSet(java.lang.String, java.lang.String):void");
    }

    @SpeechAnnotation
    public void onControlStart(String str, String str2) {
        int i;
        zw zwVar;
        String str3;
        int i2;
        String str4 = null;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            zwVar = zw.a(jSONObject.optString("poi"));
            try {
                str3 = jSONObject.optString("pref");
                try {
                    str4 = jSONObject.optString("type");
                    i = jSONObject.optInt("naviType");
                    try {
                        i2 = jSONObject.optInt("routeSelectRef");
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        i2 = 0;
                        aac aacVar = new aac(zwVar, str3, str4);
                        aacVar.a(i);
                        aacVar.b(i2);
                        xx.a("NaviNode", "StartNaviBean = %s", aacVar.toString());
                        a(aacVar);
                    }
                } catch (JSONException e2) {
                    e = e2;
                    i = 0;
                }
            } catch (JSONException e3) {
                e = e3;
                i = 0;
                str3 = null;
            }
        } catch (JSONException e4) {
            e = e4;
            i = 0;
            zwVar = null;
            str3 = null;
        }
        aac aacVar2 = new aac(zwVar, str3, str4);
        aacVar2.a(i);
        aacVar2.b(i2);
        xx.a("NaviNode", "StartNaviBean = %s", aacVar2.toString());
        a(aacVar2);
    }

    private void a(aac aacVar) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(aacVar);
            }
        }
    }

    @SpeechAnnotation
    public void onControlSpeechSimple(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).A();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSpeechDetail(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).C();
            }
        }
    }

    @SpeechAnnotation
    public void onControlDisPlayNorth(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).L();
            }
        }
    }

    @SpeechAnnotation
    public void onControlDisPlayCar(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).M();
            }
        }
    }

    @SpeechAnnotation
    public void onControlDisplay3D(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).N();
            }
        }
    }

    @SpeechAnnotation
    public void onControlVolOn(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            z = jSONObject.optBoolean("pullUpNavi", false);
            i = jSONObject.has("mode") ? jSONObject.optInt("mode") : 0;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(z, i);
            }
        }
    }

    @SpeechAnnotation
    public void onControlVolOff(String str, String str2) {
        int i;
        Object[] a = this.b.a();
        boolean z = true;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            z = jSONObject.optBoolean("pullUpNavi", false);
            i = jSONObject.has("mode") ? jSONObject.optInt("mode") : 0;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).b(z, i);
            }
        }
    }

    @SpeechAnnotation
    public void onRouteNearbySearch(String str, String str2) {
        zu a = zu.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).b(a);
            }
        }
    }

    @SpeechAnnotation
    public void onParkingSelect(String str, String str2) {
        aaa a = aaa.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a);
            }
        }
    }

    @SpeechAnnotation
    public void onConfirmOk(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).O();
            }
        }
    }

    @SpeechAnnotation
    public void onConfirmCancel(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).P();
            }
        }
    }

    @SpeechAnnotation
    public void onRouteSelect(String str, String str2) {
        aab a = aab.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a);
            }
        }
    }

    @SpeechAnnotation
    public void onSelectParkingCount(String str, String str2) {
        aaa a = aaa.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).b(a);
            }
        }
    }

    @SpeechAnnotation
    public void onSelectRouteCount(String str, String str2) {
        aab a = aab.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).b(a);
            }
        }
    }

    @SpeechAnnotation
    public void onWaypointSearch(String str, String str2) {
        aae a = aae.a(str2);
        Object[] a2 = this.b.a();
        if (a2 != null) {
            for (Object obj : a2) {
                ((a) obj).a(a);
            }
        }
    }

    @SpeechAnnotation
    public void onControlWaypointStart(String str, String str2) {
        Object[] a = this.b.a();
        zv a2 = zv.a(str2);
        xx.a("NaviNode, pathBean =%s", a2 == null ? "data is null" : a2.toString());
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).a(a2);
            }
        }
    }

    @SpeechAnnotation
    public void onControlOpenSmallMap(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).Y();
            }
        }
    }

    @SpeechAnnotation
    public void onControlCloseSmallMap(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).Z();
            }
        }
    }

    @SpeechAnnotation
    public void onControlOpenRibbonMap(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).aa();
            }
        }
    }

    @SpeechAnnotation
    public void onControlCloseRibbonMap(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).ab();
            }
        }
    }

    @SpeechAnnotation
    public void onControlHistory(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).ac();
            }
        }
    }

    @SpeechAnnotation
    public void onGetSettingsInfo(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).ad();
            }
        }
    }

    @SpeechAnnotation
    public void onControlParkRecommendOn(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).ae();
            }
        }
    }

    @SpeechAnnotation
    public void onControlParkRecommendOff(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).af();
            }
        }
    }

    @SpeechAnnotation
    public void onSetScaleLevel(String str, String str2) {
        Object[] a = this.b.a();
        if (a == null || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("level")) {
                int i = jSONObject.getInt("level");
                for (Object obj : a) {
                    ((a) obj).a(i);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SpeechAnnotation
    public void onAlertsPreferenceSet(String str, String str2) {
        Object[] a = this.b.a();
        if (a == null || TextUtils.isEmpty(str2)) {
            return;
        }
        zt a2 = zt.a(str2);
        for (Object obj : a) {
            ((a) obj).a(a2);
        }
    }

    @SpeechAnnotation
    public void onAvoidRouteSet(String str, String str2) {
        Object[] a = this.b.a();
        if (a == null || TextUtils.isEmpty(str2)) {
            return;
        }
        zt a2 = zt.a(str2);
        for (Object obj : a) {
            ((a) obj).b(a2);
        }
    }

    @SpeechAnnotation
    public void onAutoRerouteBetterRoute(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).ag();
            }
        }
    }

    @SpeechAnnotation
    public void onAutoRerouteAskFirst(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).ah();
            }
        }
    }

    @SpeechAnnotation
    public void onAutoRerouteNever(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).ai();
            }
        }
    }

    @SpeechAnnotation
    public void onMapShowSet(String str, String str2) {
        Object[] a = this.b.a();
        if (a == null || TextUtils.isEmpty(str2)) {
            return;
        }
        zt a2 = zt.a(str2);
        for (Object obj : a) {
            ((a) obj).c(a2);
        }
    }

    @SpeechAnnotation
    public void onPoiDetailsFavoriteAdd(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).aj();
            }
        }
    }

    @SpeechAnnotation
    public void onPoiDetailsFavoriteDel(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).ak();
            }
        }
    }

    @SpeechAnnotation
    public void onControlSettingsCLose(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).al();
            }
        }
    }

    @SpeechAnnotation
    public void onControlHistoryCLose(String str, String str2) {
        Object[] a = this.b.a();
        if (a != null) {
            for (Object obj : a) {
                ((a) obj).am();
            }
        }
    }
}
