package defpackage;

import com.badlogic.gdx.utils.l;
import java.util.Locale;
/* compiled from: I18NBundleLoader.java */
/* renamed from: ji  reason: default package */
/* loaded from: classes.dex */
public class ji extends je<l, a> {
    l a;

    @Override // defpackage.jd
    /* renamed from: a */
    public com.badlogic.gdx.utils.a<ix> getDependencies(String str, jy jyVar, a aVar) {
        return null;
    }

    public ji(jh jhVar) {
        super(jhVar);
    }

    @Override // defpackage.je
    public void a(jb jbVar, String str, jy jyVar, a aVar) {
        Locale locale;
        String str2 = null;
        this.a = null;
        if (aVar == null) {
            locale = Locale.getDefault();
        } else {
            locale = aVar.a == null ? Locale.getDefault() : aVar.a;
            str2 = aVar.b;
        }
        if (str2 == null) {
            this.a = l.a(jyVar, locale);
        } else {
            this.a = l.a(jyVar, locale, str2);
        }
    }

    @Override // defpackage.je
    public l b(jb jbVar, String str, jy jyVar, a aVar) {
        l lVar = this.a;
        this.a = null;
        return lVar;
    }

    /* compiled from: I18NBundleLoader.java */
    /* renamed from: ji$a */
    /* loaded from: classes.dex */
    public static class a extends iz<l> {
        public final Locale a;
        public final String b;

        public a() {
            this(null, null);
        }

        public a(Locale locale, String str) {
            this.a = locale;
            this.b = str;
        }
    }
}
