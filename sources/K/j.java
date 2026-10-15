package K;

import Q.m;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TypefaceCompatBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    public j() {
        new ConcurrentHashMap();
    }

    public Typeface a(Context context, J.e.b bVar, Resources resources, int i9) {
        throw null;
    }

    public Typeface b(Context context, m[] mVarArr, int i9) {
        throw null;
    }

    public Typeface c(Context context, List list, int i9) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface d(Context context, Resources resources, int i9, String str, int i10) {
        File fileC = k.c(context);
        if (fileC == null) {
            return null;
        }
        try {
            if (k.a(fileC, resources, i9)) {
                return Typeface.createFromFile(fileC.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileC.delete();
        }
    }
}
