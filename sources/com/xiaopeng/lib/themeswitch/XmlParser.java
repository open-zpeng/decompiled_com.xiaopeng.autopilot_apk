package com.xiaopeng.lib.themeswitch;
/* loaded from: classes.dex */
public class XmlParser {
    private static final String TAG = "ThemeXmlParser";

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cd, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.xiaopeng.lib.themeswitch.bean.PageTheme parseXMLWithPull(java.io.InputStream r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "ThemeXmlParser"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "parseXMLWithPull: target="
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            r0 = 0
            org.xmlpull.v1.XmlPullParserFactory r1 = org.xmlpull.v1.XmlPullParserFactory.newInstance()     // Catch: java.lang.Exception -> Ld3
            org.xmlpull.v1.XmlPullParser r1 = r1.newPullParser()     // Catch: java.lang.Exception -> Ld3
            java.lang.String r2 = "utf-8"
            r1.setInput(r8, r2)     // Catch: java.lang.Exception -> Ld3
            int r8 = r1.getEventType()     // Catch: java.lang.Exception -> Ld3
            com.xiaopeng.lib.themeswitch.bean.PageTheme r2 = new com.xiaopeng.lib.themeswitch.bean.PageTheme     // Catch: java.lang.Exception -> Ld3
            r2.<init>()     // Catch: java.lang.Exception -> Ld3
            r3 = 0
            r4 = r3
        L2f:
            r5 = 1
            if (r8 == r5) goto Ld7
            if (r3 == 0) goto L35
            return r2
        L35:
            java.lang.String r6 = r1.getName()     // Catch: java.lang.Exception -> Ld3
            switch(r8) {
                case 2: goto L4f;
                case 3: goto L3e;
                default: goto L3c;
            }     // Catch: java.lang.Exception -> Ld3
        L3c:
            goto Lcd
        L3e:
            java.lang.String r8 = "page"
            java.lang.String r6 = r6.toLowerCase()     // Catch: java.lang.Exception -> Ld3
            boolean r8 = r8.equals(r6)     // Catch: java.lang.Exception -> Ld3
            if (r8 == 0) goto Lcd
            if (r4 == 0) goto Lcd
            r3 = r5
            goto Lcd
        L4f:
            java.lang.String r8 = "page"
            java.lang.String r7 = r6.toLowerCase()     // Catch: java.lang.Exception -> Ld3
            boolean r8 = r8.equals(r7)     // Catch: java.lang.Exception -> Ld3
            if (r8 == 0) goto L74
            java.lang.String r8 = "name"
            java.lang.String r8 = r1.getAttributeValue(r0, r8)     // Catch: java.lang.Exception -> Ld3
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Exception -> Ld3
            if (r8 == 0) goto L74
            r2.setPageName(r9)     // Catch: java.lang.Exception -> Ld3
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld3
            r8.<init>()     // Catch: java.lang.Exception -> Ld3
            r2.setViewList(r8)     // Catch: java.lang.Exception -> Ld3
            r4 = r5
            goto Lcd
        L74:
            java.lang.String r8 = "view"
            java.lang.String r7 = r6.toLowerCase()     // Catch: java.lang.Exception -> Ld3
            boolean r8 = r8.equals(r7)     // Catch: java.lang.Exception -> Ld3
            if (r8 == 0) goto La0
            if (r4 == 0) goto La0
            com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView r8 = new com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView     // Catch: java.lang.Exception -> Ld3
            r8.<init>()     // Catch: java.lang.Exception -> Ld3
            java.lang.String r5 = "id"
            java.lang.String r5 = r1.getAttributeValue(r0, r5)     // Catch: java.lang.Exception -> Ld3
            r8.setId(r5)     // Catch: java.lang.Exception -> Ld3
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld3
            r5.<init>()     // Catch: java.lang.Exception -> Ld3
            r8.setAttrList(r5)     // Catch: java.lang.Exception -> Ld3
            java.util.List r5 = r2.getViewList()     // Catch: java.lang.Exception -> Ld3
            r5.add(r8)     // Catch: java.lang.Exception -> Ld3
            goto Lcd
        La0:
            if (r4 == 0) goto Lcd
            com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView$ViewAttr r8 = new com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView$ViewAttr     // Catch: java.lang.Exception -> Ld3
            r8.<init>()     // Catch: java.lang.Exception -> Ld3
            r8.setAttrName(r6)     // Catch: java.lang.Exception -> Ld3
            java.lang.String r6 = "value"
            java.lang.String r6 = r1.getAttributeValue(r0, r6)     // Catch: java.lang.Exception -> Ld3
            r8.setAttrValue(r6)     // Catch: java.lang.Exception -> Ld3
            java.util.List r6 = r2.getViewList()     // Catch: java.lang.Exception -> Ld3
            java.util.List r7 = r2.getViewList()     // Catch: java.lang.Exception -> Ld3
            int r7 = r7.size()     // Catch: java.lang.Exception -> Ld3
            int r7 = r7 - r5
            java.lang.Object r5 = r6.get(r7)     // Catch: java.lang.Exception -> Ld3
            com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView r5 = (com.xiaopeng.lib.themeswitch.bean.PageTheme.ThemeView) r5     // Catch: java.lang.Exception -> Ld3
            java.util.List r5 = r5.getAttrList()     // Catch: java.lang.Exception -> Ld3
            r5.add(r8)     // Catch: java.lang.Exception -> Ld3
        Lcd:
            int r8 = r1.next()     // Catch: java.lang.Exception -> Ld3
            goto L2f
        Ld3:
            r8 = move-exception
            r8.printStackTrace()
        Ld7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.lib.themeswitch.XmlParser.parseXMLWithPull(java.io.InputStream, java.lang.String):com.xiaopeng.lib.themeswitch.bean.PageTheme");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ca, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, com.xiaopeng.lib.themeswitch.bean.PageTheme> parseXMLWithPull(java.io.InputStream r7) {
        /*
            java.lang.String r0 = "ThemeXmlParser"
            java.lang.String r1 = "parseXMLWithPull: target=all"
            android.util.Log.d(r0, r1)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            org.xmlpull.v1.XmlPullParserFactory r1 = org.xmlpull.v1.XmlPullParserFactory.newInstance()     // Catch: java.lang.Exception -> Ld0
            org.xmlpull.v1.XmlPullParser r1 = r1.newPullParser()     // Catch: java.lang.Exception -> Ld0
            java.lang.String r2 = "utf-8"
            r1.setInput(r7, r2)     // Catch: java.lang.Exception -> Ld0
            int r7 = r1.getEventType()     // Catch: java.lang.Exception -> Ld0
            r2 = 0
            r3 = r2
        L1f:
            r4 = 1
            if (r7 == r4) goto Ld0
            java.lang.String r5 = r1.getName()     // Catch: java.lang.Exception -> Ld0
            switch(r7) {
                case 2: goto L42;
                case 3: goto L2b;
                default: goto L29;
            }     // Catch: java.lang.Exception -> Ld0
        L29:
            goto Lca
        L2b:
            java.lang.String r7 = "page"
            java.lang.String r4 = r5.toLowerCase()     // Catch: java.lang.Exception -> Ld0
            boolean r7 = r7.equals(r4)     // Catch: java.lang.Exception -> Ld0
            if (r7 == 0) goto Lca
            if (r3 == 0) goto Lca
            java.lang.String r7 = r3.getPageName()     // Catch: java.lang.Exception -> Ld0
            r0.put(r7, r3)     // Catch: java.lang.Exception -> Ld0
            goto Lca
        L42:
            java.lang.String r7 = "page"
            java.lang.String r6 = r5.toLowerCase()     // Catch: java.lang.Exception -> Ld0
            boolean r7 = r7.equals(r6)     // Catch: java.lang.Exception -> Ld0
            if (r7 == 0) goto L71
            java.lang.String r7 = "name"
            java.lang.String r7 = r1.getAttributeValue(r2, r7)     // Catch: java.lang.Exception -> Ld0
            if (r3 == 0) goto L60
            java.lang.String r4 = r3.getPageName()     // Catch: java.lang.Exception -> Ld0
            boolean r4 = android.text.TextUtils.equals(r7, r4)     // Catch: java.lang.Exception -> Ld0
            if (r4 != 0) goto Lca
        L60:
            com.xiaopeng.lib.themeswitch.bean.PageTheme r3 = new com.xiaopeng.lib.themeswitch.bean.PageTheme     // Catch: java.lang.Exception -> Ld0
            r3.<init>()     // Catch: java.lang.Exception -> Ld0
            r3.setPageName(r7)     // Catch: java.lang.Exception -> Ld0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld0
            r7.<init>()     // Catch: java.lang.Exception -> Ld0
            r3.setViewList(r7)     // Catch: java.lang.Exception -> Ld0
            goto Lca
        L71:
            java.lang.String r7 = "view"
            java.lang.String r6 = r5.toLowerCase()     // Catch: java.lang.Exception -> Ld0
            boolean r7 = r7.equals(r6)     // Catch: java.lang.Exception -> Ld0
            if (r7 == 0) goto L9d
            com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView r7 = new com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView     // Catch: java.lang.Exception -> Ld0
            r7.<init>()     // Catch: java.lang.Exception -> Ld0
            java.lang.String r4 = "id"
            java.lang.String r4 = r1.getAttributeValue(r2, r4)     // Catch: java.lang.Exception -> Ld0
            r7.setId(r4)     // Catch: java.lang.Exception -> Ld0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld0
            r4.<init>()     // Catch: java.lang.Exception -> Ld0
            r7.setAttrList(r4)     // Catch: java.lang.Exception -> Ld0
            if (r3 == 0) goto Lca
            java.util.List r4 = r3.getViewList()     // Catch: java.lang.Exception -> Ld0
            r4.add(r7)     // Catch: java.lang.Exception -> Ld0
            goto Lca
        L9d:
            com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView$ViewAttr r7 = new com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView$ViewAttr     // Catch: java.lang.Exception -> Ld0
            r7.<init>()     // Catch: java.lang.Exception -> Ld0
            r7.setAttrName(r5)     // Catch: java.lang.Exception -> Ld0
            java.lang.String r5 = "value"
            java.lang.String r5 = r1.getAttributeValue(r2, r5)     // Catch: java.lang.Exception -> Ld0
            r7.setAttrValue(r5)     // Catch: java.lang.Exception -> Ld0
            if (r3 == 0) goto Lca
            java.util.List r5 = r3.getViewList()     // Catch: java.lang.Exception -> Ld0
            java.util.List r6 = r3.getViewList()     // Catch: java.lang.Exception -> Ld0
            int r6 = r6.size()     // Catch: java.lang.Exception -> Ld0
            int r6 = r6 - r4
            java.lang.Object r4 = r5.get(r6)     // Catch: java.lang.Exception -> Ld0
            com.xiaopeng.lib.themeswitch.bean.PageTheme$ThemeView r4 = (com.xiaopeng.lib.themeswitch.bean.PageTheme.ThemeView) r4     // Catch: java.lang.Exception -> Ld0
            java.util.List r4 = r4.getAttrList()     // Catch: java.lang.Exception -> Ld0
            r4.add(r7)     // Catch: java.lang.Exception -> Ld0
        Lca:
            int r7 = r1.next()     // Catch: java.lang.Exception -> Ld0
            goto L1f
        Ld0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.lib.themeswitch.XmlParser.parseXMLWithPull(java.io.InputStream):java.util.Map");
    }
}
