package com.badlogic.gdx.utils;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* compiled from: I18NBundle.java */
/* loaded from: classes.dex */
public class l {
    private static final Locale a = new Locale("", "", "");
    private static boolean b = false;
    private static boolean c = true;
    private l d;
    private Locale e;
    private v<String, String> f;
    private am g;

    public static l a(jy jyVar, Locale locale) {
        return b(jyVar, locale, "UTF-8");
    }

    public static l a(jy jyVar, Locale locale, String str) {
        return b(jyVar, locale, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0081, code lost:
        throw new java.util.MissingResourceException("Can't find bundle for base file handle " + r9.path() + ", locale " + r10, r9 + "_" + r10, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.badlogic.gdx.utils.l b(defpackage.jy r9, java.util.Locale r10, java.lang.String r11) {
        /*
            if (r9 == 0) goto L84
            if (r10 == 0) goto L84
            if (r11 == 0) goto L84
            r0 = 0
            r1 = r0
            r0 = r10
        L9:
            java.util.List r2 = a(r0)
            r3 = 0
            com.badlogic.gdx.utils.l r4 = a(r9, r11, r2, r3, r1)
            if (r4 == 0) goto L3e
            java.util.Locale r5 = r4.a()
            java.util.Locale r6 = com.badlogic.gdx.utils.l.a
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L44
            boolean r7 = r5.equals(r10)
            if (r7 == 0) goto L27
            goto L44
        L27:
            int r7 = r2.size()
            r8 = 1
            if (r7 != r8) goto L39
            java.lang.Object r2 = r2.get(r3)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L39
            goto L44
        L39:
            if (r6 == 0) goto L3e
            if (r1 != 0) goto L3e
            r1 = r4
        L3e:
            java.util.Locale r0 = b(r0)
            if (r0 != 0) goto L9
        L44:
            if (r4 != 0) goto L82
            if (r1 == 0) goto L49
            goto L83
        L49:
            java.util.MissingResourceException r11 = new java.util.MissingResourceException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Can't find bundle for base file handle "
            r0.append(r1)
            java.lang.String r1 = r9.path()
            r0.append(r1)
            java.lang.String r1 = ", locale "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            java.lang.String r9 = "_"
            r1.append(r9)
            r1.append(r10)
            java.lang.String r9 = r1.toString()
            java.lang.String r10 = ""
            r11.<init>(r0, r9, r10)
            throw r11
        L82:
            r1 = r4
        L83:
            return r1
        L84:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.l.b(jy, java.util.Locale, java.lang.String):com.badlogic.gdx.utils.l");
    }

    private static List<Locale> a(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        ArrayList arrayList = new ArrayList(4);
        if (variant.length() > 0) {
            arrayList.add(locale);
        }
        if (country.length() > 0) {
            arrayList.add(arrayList.isEmpty() ? locale : new Locale(language, country));
        }
        if (language.length() > 0) {
            if (!arrayList.isEmpty()) {
                locale = new Locale(language);
            }
            arrayList.add(locale);
        }
        arrayList.add(a);
        return arrayList;
    }

    private static Locale b(Locale locale) {
        Locale locale2 = Locale.getDefault();
        if (locale.equals(locale2)) {
            return null;
        }
        return locale2;
    }

    private static l a(jy jyVar, String str, List<Locale> list, int i, l lVar) {
        l lVar2;
        Locale locale = list.get(i);
        if (i != list.size() - 1) {
            lVar2 = a(jyVar, str, list, i + 1, lVar);
        } else if (lVar != null && locale.equals(a)) {
            return lVar;
        } else {
            lVar2 = null;
        }
        l a2 = a(jyVar, str, locale);
        if (a2 != null) {
            a2.d = lVar2;
            return a2;
        }
        return lVar2;
    }

    private static l a(jy jyVar, String str, Locale locale) {
        l lVar;
        Reader reader = null;
        try {
            try {
                jy b2 = b(jyVar, locale);
                if (a(b2)) {
                    lVar = new l();
                    reader = b2.reader(str);
                    lVar.a(reader);
                } else {
                    lVar = null;
                }
                if (lVar != null) {
                    lVar.c(locale);
                }
                return lVar;
            } catch (IOException e) {
                throw new k(e);
            }
        } finally {
            ak.a(reader);
        }
    }

    private static boolean a(jy jyVar) {
        try {
            jyVar.read().close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    protected void a(Reader reader) throws IOException {
        this.f = new v<>();
        ab.a(this.f, reader);
    }

    private static jy b(jy jyVar, Locale locale) {
        al alVar = new al(jyVar.name());
        if (!locale.equals(a)) {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            boolean equals = "".equals(language);
            boolean equals2 = "".equals(country);
            boolean equals3 = "".equals(variant);
            if (!equals || !equals2 || !equals3) {
                alVar.append('_');
                if (!equals3) {
                    alVar.c(language).append('_').c(country).append('_').c(variant);
                } else if (!equals2) {
                    alVar.c(language).append('_').c(country);
                } else {
                    alVar.c(language);
                }
            }
        }
        return jyVar.sibling(alVar.c(".properties").toString());
    }

    public Locale a() {
        return this.e;
    }

    private void c(Locale locale) {
        this.e = locale;
        this.g = new am(locale, !b);
    }
}
