package K;

import Q.m;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: TypefaceCompatApi31Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends h {
    @Override // K.h
    public final Font g(m mVar) {
        Font fontD;
        Uri uri = mVar.f3681a;
        String authority = Objects.equals(uri.getScheme(), "systemfont") ? uri.getAuthority() : null;
        if (authority != null) {
            Typeface typefaceCreate = Typeface.create(authority, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                typefaceCreate = null;
            }
            if (typefaceCreate != null && (fontD = d.d(typefaceCreate)) != null) {
                String str = mVar.f3685e;
                if (TextUtils.isEmpty(str)) {
                    return fontD;
                }
                try {
                    return new Font.Builder(fontD).setFontVariationSettings(str).build();
                } catch (IOException unused) {
                    Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
                    return null;
                }
            }
        }
        return null;
    }
}
