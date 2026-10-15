package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final RectF f6655l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public static final ConcurrentHashMap<String, Method> f6656m = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6657a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6658b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6659c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6660d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f6661e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f6662f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6663g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextPaint f6664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f6665i;
    public final Context j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f6666k;

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static final class a {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i9, int i10, TextView textView, TextPaint textPaint, d dVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i9);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i10 == -1) {
                i10 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i10);
            try {
                dVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static class b extends d {
        @Override // androidx.appcompat.widget.r.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) r.e(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static class c extends b {
        @Override // androidx.appcompat.widget.r.b, androidx.appcompat.widget.r.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.r.d
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static class d {
        public void a(StaticLayout.Builder builder, TextView textView) {
            throw null;
        }

        public boolean b(TextView textView) {
            return ((Boolean) r.e(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public r(TextView textView) {
        this.f6665i = textView;
        this.j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6666k = new c();
        } else {
            this.f6666k = new b();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i9 : iArr) {
                if (i9 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i9)) < 0) {
                    arrayList.add(Integer.valueOf(i9));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i10 = 0; i10 < size; i10++) {
                    iArr2[i10] = ((Integer) arrayList.get(i10)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap<String, Method> concurrentHashMap = f6656m;
            Method declaredMethod = concurrentHashMap.get(str);
            if (declaredMethod != null || (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) == null) {
                return declaredMethod;
            }
            declaredMethod.setAccessible(true);
            concurrentHashMap.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e9) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e9);
            return null;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static <T> T e(Object obj, String str, T t) {
        try {
            return (T) d(str).invoke(obj, new Object[0]);
        } catch (Exception e9) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e9);
            return t;
        }
    }

    public final void a() {
        if (f()) {
            if (this.f6658b) {
                if (this.f6665i.getMeasuredHeight() <= 0 || this.f6665i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f6666k.b(this.f6665i) ? 1048576 : (this.f6665i.getMeasuredWidth() - this.f6665i.getTotalPaddingLeft()) - this.f6665i.getTotalPaddingRight();
                int height = (this.f6665i.getHeight() - this.f6665i.getCompoundPaddingBottom()) - this.f6665i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f6655l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fC = c(rectF);
                        if (fC != this.f6665i.getTextSize()) {
                            g(0, fC);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.f6658b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence transformation;
        int length = this.f6662f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i9 = length - 1;
        int i10 = 0;
        int i11 = 1;
        while (i11 <= i9) {
            int i12 = (i11 + i9) / 2;
            int i13 = this.f6662f[i12];
            TextView textView = this.f6665i;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            CharSequence charSequence = (transformationMethod == null || (transformation = transformationMethod.getTransformation(text, textView)) == null) ? text : transformation;
            int maxLines = textView.getMaxLines();
            TextPaint textPaint = this.f6664h;
            if (textPaint == null) {
                this.f6664h = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.f6664h.set(textView.getPaint());
            this.f6664h.setTextSize(i13);
            StaticLayout staticLayoutA = a.a(charSequence, (Layout.Alignment) e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines, this.f6665i, this.f6664h, this.f6666k);
            if ((maxLines == -1 || (staticLayoutA.getLineCount() <= maxLines && staticLayoutA.getLineEnd(staticLayoutA.getLineCount() - 1) == charSequence.length())) && staticLayoutA.getHeight() <= rectF.bottom) {
                int i14 = i12 + 1;
                i10 = i11;
                i11 = i14;
            } else {
                i10 = i12 - 1;
                i9 = i10;
            }
        }
        return this.f6662f[i10];
    }

    public final boolean f() {
        return j() && this.f6657a != 0;
    }

    public final void g(int i9, float f6) {
        Context context = this.j;
        float fApplyDimension = TypedValue.applyDimension(i9, f6, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.f6665i;
        if (fApplyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(fApplyDimension);
            boolean zIsInLayout = textView.isInLayout();
            if (textView.getLayout() != null) {
                this.f6658b = false;
                try {
                    Method methodD = d("nullLayouts");
                    if (methodD != null) {
                        methodD.invoke(textView, new Object[0]);
                    }
                } catch (Exception e9) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e9);
                }
                if (zIsInLayout) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean h() {
        if (j() && this.f6657a == 1) {
            if (!this.f6663g || this.f6662f.length == 0) {
                int iFloor = ((int) Math.floor((this.f6661e - this.f6660d) / this.f6659c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i9 = 0; i9 < iFloor; i9++) {
                    iArr[i9] = Math.round((i9 * this.f6659c) + this.f6660d);
                }
                this.f6662f = b(iArr);
            }
            this.f6658b = true;
        } else {
            this.f6658b = false;
        }
        return this.f6658b;
    }

    public final boolean i() {
        int[] iArr = this.f6662f;
        int length = iArr.length;
        boolean z8 = length > 0;
        this.f6663g = z8;
        if (z8) {
            this.f6657a = 1;
            this.f6660d = iArr[0];
            this.f6661e = iArr[length - 1];
            this.f6659c = -1.0f;
        }
        return z8;
    }

    public final boolean j() {
        return !(this.f6665i instanceof AppCompatEditText);
    }

    public final void k(float f6, float f9, float f10) {
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f6 + "px) is less or equal to (0px)");
        }
        if (f9 <= f6) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f9 + "px) is less or equal to minimum auto-size text size (" + f6 + "px)");
        }
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f10 + "px) is less or equal to (0px)");
        }
        this.f6657a = 1;
        this.f6660d = f6;
        this.f6661e = f9;
        this.f6659c = f10;
        this.f6663g = false;
    }
}
