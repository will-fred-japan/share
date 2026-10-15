package J;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: TypedArrayUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static int a(Context context, int i9, int i10) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i9, typedValue, true);
        return typedValue.resourceId != 0 ? i9 : i10;
    }

    public static d b(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i9) {
        d dVarA;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i9, typedValue);
            int i10 = typedValue.type;
            if (i10 >= 28 && i10 <= 31) {
                return new d(null, null, typedValue.data);
            }
            try {
                dVarA = d.a(typedArray.getResources(), typedArray.getResourceId(i9, 0), theme);
            } catch (Exception e9) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e9);
                dVarA = null;
            }
            if (dVarA != null) {
                return dVarA;
            }
        }
        return new d(null, null, 0);
    }

    public static boolean c(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray d(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
