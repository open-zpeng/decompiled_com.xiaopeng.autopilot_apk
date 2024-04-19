package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import defpackage.eg;
import defpackage.fi;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: TypefaceCompatApi29Impl.java */
/* renamed from: et  reason: default package */
/* loaded from: classes.dex */
public class et extends eu {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.eu
    public fi.b a(fi.b[] bVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.eu
    public Typeface a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // defpackage.eu
    public Typeface a(Context context, CancellationSignal cancellationSignal, fi.b[] bVarArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = bVarArr.length;
            FontFamily.Builder builder = null;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i2 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
                }
                fi.b bVar = bVarArr[i2];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(bVar.a(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor != null) {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(bVar.c());
                        if (!bVar.d()) {
                            i3 = 0;
                        }
                        Font build = weight.setSlant(i3).setTtcIndex(bVar.b()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                        if (openFileDescriptor == null) {
                            i2++;
                        }
                    } catch (Throwable th) {
                        if (openFileDescriptor != null) {
                            try {
                                openFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                        break;
                    }
                } else if (openFileDescriptor == null) {
                    i2++;
                }
                openFileDescriptor.close();
                i2++;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // defpackage.eu
    public Typeface a(Context context, eg.b bVar, Resources resources, int i) {
        try {
            eg.c[] a = bVar.a();
            int length = a.length;
            FontFamily.Builder builder = null;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i2 >= length) {
                    break;
                }
                eg.c cVar = a[i2];
                try {
                    Font.Builder weight = new Font.Builder(resources, cVar.f()).setWeight(cVar.b());
                    if (!cVar.c()) {
                        i3 = 0;
                    }
                    Font build = weight.setSlant(i3).setTtcIndex(cVar.e()).setFontVariationSettings(cVar.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i2++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // defpackage.eu
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
