package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: renamed from: androidx.appcompat.widget.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0504p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f6636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public I f6637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public I f6638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public I f6639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public I f6640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public I f6641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public I f6642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public I f6643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r f6644i;
    public int j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6645k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f6646l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6647m;

    /* JADX INFO: renamed from: androidx.appcompat.widget.p$b */
    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    public static class b {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.p$c */
    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    public static class c {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i9, int i10, int i11, int i12) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i9, i10, i11, i12);
        }

        public static void c(TextView textView, int[] iArr, int i9) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i9);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.p$d */
    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    public static class d {
        public static Typeface a(Typeface typeface, int i9, boolean z8) {
            return Typeface.create(typeface, i9, z8);
        }
    }

    public C0504p(TextView textView) {
        this.f6636a = textView;
        this.f6644i = new r(textView);
    }

    public static I c(Context context, C0495g c0495g, int i9) {
        ColorStateList colorStateListF;
        synchronized (c0495g) {
            colorStateListF = c0495g.f6612a.f(context, i9);
        }
        if (colorStateListF == null) {
            return null;
        }
        I i10 = new I();
        i10.f6418d = true;
        i10.f6415a = colorStateListF;
        return i10;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i9 >= 30) {
            V.a.C0061a.a(editorInfo, text);
            return;
        }
        text.getClass();
        if (i9 >= 30) {
            V.a.C0061a.a(editorInfo, text);
            return;
        }
        int i10 = editorInfo.initialSelStart;
        int i11 = editorInfo.initialSelEnd;
        int i12 = i10 > i11 ? i11 : i10;
        if (i10 <= i11) {
            i10 = i11;
        }
        int length = text.length();
        if (i12 < 0 || i10 > length) {
            V.a.a(editorInfo, null, 0, 0);
            return;
        }
        int i13 = editorInfo.inputType & 4095;
        if (i13 == 129 || i13 == 225 || i13 == 18) {
            V.a.a(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            V.a.a(editorInfo, text, i12, i10);
            return;
        }
        int i14 = i10 - i12;
        int i15 = i14 > 1024 ? 0 : i14;
        int length2 = text.length() - i10;
        int i16 = OpusCodecConfig.APPLICATION_VOIP - i15;
        int iMin = Math.min(length2, i16 - Math.min(i12, (int) (((double) i16) * 0.8d)));
        int iMin2 = Math.min(i12, i16 - iMin);
        int i17 = i12 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i17))) {
            i17++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i10 + iMin) - 1))) {
            iMin--;
        }
        int i18 = iMin2 + i15;
        V.a.a(editorInfo, i15 != i14 ? TextUtils.concat(text.subSequence(i17, i17 + iMin2), text.subSequence(i10, iMin + i10)) : text.subSequence(i17, i18 + iMin + i17), iMin2, i18);
    }

    public final void a(Drawable drawable, I i9) {
        if (drawable == null || i9 == null) {
            return;
        }
        C0495g.e(drawable, i9, this.f6636a.getDrawableState());
    }

    public final void b() {
        I i9 = this.f6637b;
        TextView textView = this.f6636a;
        if (i9 != null || this.f6638c != null || this.f6639d != null || this.f6640e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f6637b);
            a(compoundDrawables[1], this.f6638c);
            a(compoundDrawables[2], this.f6639d);
            a(compoundDrawables[3], this.f6640e);
        }
        if (this.f6641f == null && this.f6642g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f6641f);
        a(compoundDrawablesRelative[2], this.f6642g);
    }

    public final ColorStateList d() {
        I i9 = this.f6643h;
        if (i9 != null) {
            return i9.f6415a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        I i9 = this.f6643h;
        if (i9 != null) {
            return i9.f6416b;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:226:0x038c  */
    /* JADX WARN: Code duplicated, block: B:228:0x0391  */
    /* JADX WARN: Code duplicated, block: B:231:0x0398 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:232:0x039a  */
    /* JADX WARN: Code duplicated, block: B:234:0x039f  */
    /* JADX WARN: Code duplicated, block: B:236:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:238:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:241:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    public final void f(AttributeSet attributeSet, int i9) {
        boolean z8;
        boolean z9;
        String string;
        String string2;
        float dimensionPixelSize;
        int i10;
        ColorStateList colorStateList;
        int resourceId;
        int i11;
        int resourceId2;
        TextView textView = this.f6636a;
        Context context = textView.getContext();
        C0495g c0495gA = C0495g.a();
        int[] iArr = p059i.a.f19181h;
        K kE = K.e(context, attributeSet, iArr, i9);
        T.G.l(textView, textView.getContext(), iArr, attributeSet, kE.f6420b, i9);
        TypedArray typedArray = kE.f6420b;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.f6637b = c(context, c0495gA, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.f6638c = c(context, c0495gA, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.f6639d = c(context, c0495gA, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.f6640e = c(context, c0495gA, typedArray.getResourceId(2, 0));
        }
        if (typedArray.hasValue(5)) {
            this.f6641f = c(context, c0495gA, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.f6642g = c(context, c0495gA, typedArray.getResourceId(6, 0));
        }
        kE.f();
        boolean z10 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = p059i.a.f19194w;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            K k7 = new K(context, typedArrayObtainStyledAttributes);
            if (z10 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z8 = false;
                z9 = false;
            } else {
                z9 = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z8 = true;
            }
            n(context, k7);
            string2 = typedArrayObtainStyledAttributes.hasValue(15) ? typedArrayObtainStyledAttributes.getString(15) : null;
            string = typedArrayObtainStyledAttributes.hasValue(13) ? typedArrayObtainStyledAttributes.getString(13) : null;
            k7.f();
        } else {
            z8 = false;
            z9 = false;
            string = null;
            string2 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i9, 0);
        K k8 = new K(context, typedArrayObtainStyledAttributes2);
        if (!z10 && typedArrayObtainStyledAttributes2.hasValue(14)) {
            z9 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z8 = true;
        }
        boolean z11 = z9;
        int i12 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (i12 >= 28 && typedArrayObtainStyledAttributes2.hasValue(0) && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, k8);
        k8.f();
        if (!z10 && z8) {
            textView.setAllCaps(z11);
        }
        Typeface typeface = this.f6646l;
        if (typeface != null) {
            if (this.f6645k == -1) {
                textView.setTypeface(typeface, this.j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            c.d(textView, string);
        }
        if (string2 != null) {
            b.b(textView, b.a(string2));
        }
        int[] iArr3 = p059i.a.f19182i;
        r rVar = this.f6644i;
        Context context2 = rVar.j;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i9, 0);
        TextView textView2 = rVar.f6665i;
        T.G.l(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i9);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            rVar.f6657a = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes3.hasValue(3) && (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i13 = 0; i13 < length; i13++) {
                    iArr4[i13] = typedArrayObtainTypedArray.getDimensionPixelSize(i13, -1);
                }
                rVar.f6662f = r.b(iArr4);
                rVar.i();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!rVar.j()) {
            rVar.f6657a = 0;
        } else if (rVar.f6657a == 1) {
            if (!rVar.f6663g) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i11 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i11 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i11, 112.0f, displayMetrics);
                }
                float f6 = dimension3;
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                rVar.k(dimension2, f6, dimension);
            }
            rVar.h();
        }
        if (Q.f6466c && rVar.f6657a != 0) {
            int[] iArr5 = rVar.f6662f;
            if (iArr5.length > 0) {
                if (c.a(textView) != -1.0f) {
                    c.b(textView, Math.round(rVar.f6660d), Math.round(rVar.f6661e), Math.round(rVar.f6659c), 0);
                } else {
                    c.c(textView, iArr5, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawableB = resourceId4 != -1 ? c0495gA.b(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawableB2 = resourceId5 != -1 ? c0495gA.b(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawableB3 = resourceId6 != -1 ? c0495gA.b(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawableB4 = resourceId7 != -1 ? c0495gA.b(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawableB5 = resourceId8 != -1 ? c0495gA.b(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawableB6 = resourceId9 != -1 ? c0495gA.b(context, resourceId9) : null;
        if (drawableB5 != null || drawableB6 != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (drawableB5 == null) {
                drawableB5 = compoundDrawablesRelative[0];
            }
            if (drawableB2 == null) {
                drawableB2 = compoundDrawablesRelative[1];
            }
            if (drawableB6 == null) {
                drawableB6 = compoundDrawablesRelative[2];
            }
            if (drawableB4 == null) {
                drawableB4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableB5, drawableB2, drawableB6, drawableB4);
        } else if (drawableB != null || drawableB2 != null || drawableB3 != null || drawableB4 != null) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative2[0];
            if (drawable == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawableB == null) {
                    drawableB = compoundDrawables[0];
                }
                if (drawableB2 == null) {
                    drawableB2 = compoundDrawables[1];
                }
                if (drawableB3 == null) {
                    drawableB3 = compoundDrawables[2];
                }
                if (drawableB4 == null) {
                    drawableB4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableB, drawableB2, drawableB3, drawableB4);
            } else {
                if (drawableB2 == null) {
                    drawableB2 = compoundDrawablesRelative2[1];
                }
                if (drawableB4 == null) {
                    drawableB4 = compoundDrawablesRelative2[3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawableB2, compoundDrawablesRelative2[2], drawableB4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = I.a.b(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            textView.setCompoundDrawableTintList(colorStateList);
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            textView.setCompoundDrawableTintMode(u.c(typedArrayObtainStyledAttributes4.getInt(12, -1), null));
        }
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, -1);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, -1);
        if (typedArrayObtainStyledAttributes4.hasValue(19)) {
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes4.peekValue(19);
            if (typedValuePeekValue == null || typedValuePeekValue.type != 5) {
                dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, -1);
            } else {
                int i14 = typedValuePeekValue.data;
                i10 = i14 & 15;
                dimensionPixelSize = TypedValue.complexToFloat(i14);
            }
            typedArrayObtainStyledAttributes4.recycle();
            if (dimensionPixelSize2 != -1) {
                androidx.core.widget.d.b(textView, dimensionPixelSize2);
            }
            if (dimensionPixelSize3 != -1) {
                androidx.core.widget.d.c(textView, dimensionPixelSize3);
            }
            if (dimensionPixelSize != -1.0f) {
                if (i10 == -1) {
                    androidx.core.widget.d.d(textView, (int) dimensionPixelSize);
                } else if (Build.VERSION.SDK_INT >= 34) {
                    androidx.core.widget.d.b.a(textView, i10, dimensionPixelSize);
                } else {
                    androidx.core.widget.d.d(textView, Math.round(TypedValue.applyDimension(i10, dimensionPixelSize, textView.getResources().getDisplayMetrics())));
                }
            }
        }
        dimensionPixelSize = -1.0f;
        i10 = -1;
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize2 != -1) {
            androidx.core.widget.d.b(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            androidx.core.widget.d.c(textView, dimensionPixelSize3);
        }
        if (dimensionPixelSize != -1.0f) {
            if (i10 == -1) {
                androidx.core.widget.d.d(textView, (int) dimensionPixelSize);
            } else if (Build.VERSION.SDK_INT >= 34) {
                androidx.core.widget.d.b.a(textView, i10, dimensionPixelSize);
            } else {
                androidx.core.widget.d.d(textView, Math.round(TypedValue.applyDimension(i10, dimensionPixelSize, textView.getResources().getDisplayMetrics())));
            }
        }
    }

    public final void g(Context context, int i9) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i9, p059i.a.f19194w);
        K k7 = new K(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.f6636a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, k7);
        if (typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            c.d(textView, string);
        }
        k7.f();
        Typeface typeface = this.f6646l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.j);
        }
    }

    public final void i(int i9, int i10, int i11, int i12) {
        r rVar = this.f6644i;
        if (rVar.j()) {
            DisplayMetrics displayMetrics = rVar.j.getResources().getDisplayMetrics();
            rVar.k(TypedValue.applyDimension(i12, i9, displayMetrics), TypedValue.applyDimension(i12, i10, displayMetrics), TypedValue.applyDimension(i12, i11, displayMetrics));
            if (rVar.h()) {
                rVar.a();
            }
        }
    }

    public final void j(int[] iArr, int i9) {
        r rVar = this.f6644i;
        if (rVar.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i9 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = rVar.j.getResources().getDisplayMetrics();
                    for (int i10 = 0; i10 < length; i10++) {
                        iArrCopyOf[i10] = Math.round(TypedValue.applyDimension(i9, iArr[i10], displayMetrics));
                    }
                }
                rVar.f6662f = r.b(iArrCopyOf);
                if (!rVar.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                rVar.f6663g = false;
            }
            if (rVar.h()) {
                rVar.a();
            }
        }
    }

    public final void k(int i9) {
        r rVar = this.f6644i;
        if (rVar.j()) {
            if (i9 == 0) {
                rVar.f6657a = 0;
                rVar.f6660d = -1.0f;
                rVar.f6661e = -1.0f;
                rVar.f6659c = -1.0f;
                rVar.f6662f = new int[0];
                rVar.f6658b = false;
                return;
            }
            if (i9 != 1) {
                throw new IllegalArgumentException(W5.e.i(i9, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = rVar.j.getResources().getDisplayMetrics();
            rVar.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (rVar.h()) {
                rVar.a();
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        if (this.f6643h == null) {
            this.f6643h = new I();
        }
        I i9 = this.f6643h;
        i9.f6415a = colorStateList;
        i9.f6418d = colorStateList != null;
        this.f6637b = i9;
        this.f6638c = i9;
        this.f6639d = i9;
        this.f6640e = i9;
        this.f6641f = i9;
        this.f6642g = i9;
    }

    public final void m(PorterDuff.Mode mode) {
        if (this.f6643h == null) {
            this.f6643h = new I();
        }
        I i9 = this.f6643h;
        i9.f6416b = mode;
        i9.f6417c = mode != null;
        this.f6637b = i9;
        this.f6638c = i9;
        this.f6639d = i9;
        this.f6640e = i9;
        this.f6641f = i9;
        this.f6642g = i9;
    }

    public final void n(Context context, K k7) {
        String string;
        int i9 = this.j;
        TypedArray typedArray = k7.f6420b;
        this.j = typedArray.getInt(2, i9);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            int i11 = typedArray.getInt(11, -1);
            this.f6645k = i11;
            if (i11 != -1) {
                this.j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f6647m = false;
                int i12 = typedArray.getInt(1, 1);
                if (i12 == 1) {
                    this.f6646l = Typeface.SANS_SERIF;
                    return;
                } else if (i12 == 2) {
                    this.f6646l = Typeface.SERIF;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    this.f6646l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f6646l = null;
        int i13 = typedArray.hasValue(12) ? 12 : 10;
        int i14 = this.f6645k;
        int i15 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceD = k7.d(i13, this.j, new a(i14, i15, new WeakReference(this.f6636a)));
                if (typefaceD != null) {
                    if (i10 < 28 || this.f6645k == -1) {
                        this.f6646l = typefaceD;
                    } else {
                        this.f6646l = d.a(Typeface.create(typefaceD, 0), this.f6645k, (this.j & 2) != 0);
                    }
                }
                this.f6647m = this.f6646l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f6646l != null || (string = typedArray.getString(i13)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f6645k == -1) {
            this.f6646l = Typeface.create(string, this.j);
        } else {
            this.f6646l = d.a(Typeface.create(string, 0), this.f6645k, (this.j & 2) != 0);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.p$a */
    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    public class a extends J.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f6650c;

        public a(int i9, int i10, WeakReference weakReference) {
            this.f6648a = i9;
            this.f6649b = i10;
            this.f6650c = weakReference;
        }

        @Override // J.g.c
        public final void c(Typeface typeface) {
            int i9;
            if (Build.VERSION.SDK_INT >= 28 && (i9 = this.f6648a) != -1) {
                typeface = d.a(typeface, i9, (this.f6649b & 2) != 0);
            }
            C0504p c0504p = C0504p.this;
            if (c0504p.f6647m) {
                c0504p.f6646l = typeface;
                TextView textView = (TextView) this.f6650c.get();
                if (textView != null) {
                    if (textView.isAttachedToWindow()) {
                        textView.post(new RunnableC0505q(textView, typeface, c0504p.j));
                    } else {
                        textView.setTypeface(typeface, c0504p.j);
                    }
                }
            }
        }

        @Override // J.g.c
        public final void b(int i9) {
        }
    }
}
