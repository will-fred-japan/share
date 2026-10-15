package K;

import Q.m;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.exception.AGCServerException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: TypefaceCompatApi29Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends j {
    public static Font e(FontFamily fontFamily, int i9) {
        FontStyle fontStyle = new FontStyle((i9 & 1) != 0 ? 700 : AGCServerException.AUTHENTICATION_INVALID, (i9 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iH = h(fontStyle, font.getStyle());
        for (int i10 = 1; i10 < fontFamily.getSize(); i10++) {
            Font font2 = fontFamily.getFont(i10);
            int iH2 = h(fontStyle, font2.getStyle());
            if (iH2 < iH) {
                font = font2;
                iH = iH2;
            }
        }
        return font;
    }

    public static int h(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // K.j
    public final Typeface a(Context context, J.e.b bVar, Resources resources, int i9) {
        try {
            FontFamily.Builder builder = null;
            for (J.e.c cVar : bVar.f2610a) {
                try {
                    Font fontBuild = new Font.Builder(resources, cVar.f2616f).setWeight(cVar.f2612b).setSlant(cVar.f2613c ? 1 : 0).setTtcIndex(cVar.f2615e).setFontVariationSettings(cVar.f2614d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(e(fontFamilyBuild, i9).getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            return null;
        }
    }

    @Override // K.j
    public final Typeface b(Context context, m[] mVarArr, int i9) {
        try {
            FontFamily fontFamilyF = f(mVarArr, context.getContentResolver());
            if (fontFamilyF == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyF).setStyle(e(fontFamilyF, i9).getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            return null;
        }
    }

    @Override // K.j
    public final Typeface c(Context context, List list, int i9) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyF = f((m[]) list.get(0), contentResolver);
            if (fontFamilyF == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyF);
            for (int i10 = 1; i10 < list.size(); i10++) {
                FontFamily fontFamilyF2 = f((m[]) list.get(i10), contentResolver);
                if (fontFamilyF2 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyF2);
                }
            }
            return customFallbackBuilder.setStyle(e(fontFamilyF, i9).getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            return null;
        }
    }

    @Override // K.j
    public final Typeface d(Context context, Resources resources, int i9, String str, int i10) {
        try {
            Font fontBuild = new Font.Builder(resources, i9).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            return null;
        }
    }

    public final FontFamily f(m[] mVarArr, ContentResolver contentResolver) {
        Font fontBuild;
        FontFamily.Builder builder = null;
        for (m mVar : mVarArr) {
            if (Objects.equals(mVar.f3681a.getScheme(), "systemfont")) {
                fontBuild = g(mVar);
            } else {
                try {
                    Uri uri = mVar.f3681a;
                    String str = mVar.f3685e;
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        fontBuild = null;
                    } else {
                        try {
                            Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(mVar.f3683c).setSlant(mVar.f3684d ? 1 : 0).setTtcIndex(mVar.f3682b);
                            if (!TextUtils.isEmpty(str)) {
                                ttcIndex.setFontVariationSettings(str);
                            }
                            fontBuild = ttcIndex.build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                } catch (IOException e9) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
                }
            }
            if (fontBuild != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font g(m mVar) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }
}
