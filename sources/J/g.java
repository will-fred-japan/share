package J;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourcesCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f2623a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<b, SparseArray<a>> f2624b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2625c = new Object();

    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f2626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f2627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2628c;

        public a(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f2626a = colorStateList;
            this.f2627b = configuration;
            this.f2628c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f2629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f2630b;

        public b(Resources resources, Resources.Theme theme) {
            this.f2629a = resources;
            this.f2630b = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (this.f2629a.equals(bVar.f2629a) && Objects.equals(this.f2630b, bVar.f2630b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(this.f2629a, this.f2630b);
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static abstract class c {
        public final void a(final int i9) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: J.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2631a.b(i9);
                }
            });
        }

        public abstract void b(int i9);

        public abstract void c(Typeface typeface);
    }

    public static Typeface a(Context context, int i9) {
        if (context.isRestricted()) {
            return null;
        }
        return b(context, i9, new TypedValue(), 0, null, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c9  */
    public static Typeface b(Context context, int i9, TypedValue typedValue, int i10, c cVar, boolean z8, boolean z9) {
        Resources resources = context.getResources();
        resources.getValue(i9, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i9) + "\" (" + Integer.toHexString(i9) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        Typeface typefaceA = null;
        if (string.startsWith("res/")) {
            int i11 = typedValue.assetCookie;
            p155u.f<String, Typeface> fVar = K.d.f2751b;
            Typeface typefaceA2 = fVar.a(K.d.b(resources, i9, string, i11, i10));
            if (typefaceA2 != null) {
                if (cVar != null) {
                    new Handler(Looper.getMainLooper()).post(new G6.b(3, cVar, typefaceA2));
                }
                typefaceA = typefaceA2;
            } else if (!z9) {
                try {
                    if (string.toLowerCase().endsWith(".xml")) {
                        e.a aVarA = e.a(resources.getXml(i9), resources);
                        if (aVarA == null) {
                            Log.e("ResourcesCompat", "Failed to find font-family tag");
                            if (cVar != null) {
                                cVar.a(-3);
                            }
                        } else {
                            typefaceA = K.d.a(context, aVarA, resources, i9, string, typedValue.assetCookie, i10, cVar, z8);
                        }
                    } else {
                        int i12 = typedValue.assetCookie;
                        Typeface typefaceD = K.d.f2750a.d(context, resources, i9, string, i10);
                        if (typefaceD != null) {
                            fVar.b(K.d.b(resources, i9, string, i12, i10), typefaceD);
                        }
                        if (cVar != null) {
                            if (typefaceD != null) {
                                new Handler(Looper.getMainLooper()).post(new G6.b(3, cVar, typefaceD));
                            } else {
                                cVar.a(-3);
                            }
                        }
                        typefaceA = typefaceD;
                    }
                } catch (IOException e9) {
                    Log.e("ResourcesCompat", "Failed to read xml resource ".concat(string), e9);
                    if (cVar != null) {
                        cVar.a(-3);
                    }
                } catch (XmlPullParserException e10) {
                    Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), e10);
                    if (cVar != null) {
                        cVar.a(-3);
                    }
                }
            }
        } else if (cVar != null) {
            cVar.a(-3);
        }
        if (typefaceA != null || cVar != null || z9) {
            return typefaceA;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i9) + " could not be retrieved.");
    }
}
