package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: TextViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: compiled from: TextViewCompat.java */
    public static class a {
        public static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        public static PrecomputedText.Params b(AppCompatTextView appCompatTextView) {
            return appCompatTextView.getTextMetricsParams();
        }

        public static void c(TextView textView, int i9) {
            textView.setFirstBaselineToTopHeight(i9);
        }
    }

    /* JADX INFO: compiled from: TextViewCompat.java */
    public static class b {
        public static void a(TextView textView, int i9, float f6) {
            textView.setLineHeight(i9, f6);
        }
    }

    /* JADX INFO: compiled from: TextViewCompat.java */
    public static class c implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f7140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f7141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Class<?> f7142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Method f7143d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7144e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7145f = false;

        public c(ActionMode.Callback callback, TextView textView) {
            this.f7140a = callback;
            this.f7141b = textView;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f7140a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f7140a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.f7140a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            String str;
            TextView textView = this.f7141b;
            Context context = textView.getContext();
            PackageManager packageManager = context.getPackageManager();
            boolean z8 = this.f7145f;
            Class cls = Integer.TYPE;
            if (!z8) {
                this.f7145f = true;
                try {
                    Class<?> cls2 = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f7142c = cls2;
                    this.f7143d = cls2.getDeclaredMethod("removeItemAt", cls);
                    this.f7144e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f7142c = null;
                    this.f7143d = null;
                    this.f7144e = false;
                }
            }
            try {
                Method declaredMethod = (this.f7144e && this.f7142c.isInstance(menu)) ? this.f7143d : menu.getClass().getDeclaredMethod("removeItemAt", cls);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (context instanceof Activity) {
                    for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), 0)) {
                        if (!context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                            ActivityInfo activityInfo = resolveInfo.activityInfo;
                            if (activityInfo.exported && ((str = activityInfo.permission) == null || context.checkSelfPermission(str) == 0)) {
                            }
                        }
                        arrayList.add(resolveInfo);
                    }
                }
                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                    ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i9);
                    MenuItem menuItemAdd = menu.add(0, 0, i9 + 100, resolveInfo2.loadLabel(packageManager));
                    Intent intentPutExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()));
                    ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
                    menuItemAdd.setIntent(intentPutExtra.setClassName(activityInfo2.packageName, activityInfo2.name)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
            return this.f7140a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static R.b.a a(AppCompatTextView appCompatTextView) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 28) {
            return new R.b.a(a.b(appCompatTextView));
        }
        TextPaint textPaint = new TextPaint(appCompatTextView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = appCompatTextView.getBreakStrategy();
        int hyphenationFrequency = appCompatTextView.getHyphenationFrequency();
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i9 < 28 || (appCompatTextView.getInputType() & 15) != 3) {
            boolean z8 = appCompatTextView.getLayoutDirection() == 1;
            switch (appCompatTextView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z8) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(a.a(DecimalFormatSymbols.getInstance(appCompatTextView.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new R.b.a(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static void b(TextView textView, int i9) {
        A1.b.J0(i9);
        if (Build.VERSION.SDK_INT >= 28) {
            a.c(textView, i9);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i9 > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), i9 + i10, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void c(TextView textView, int i9) {
        A1.b.J0(i9);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i9 > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i9 - i10);
        }
    }

    public static void d(TextView textView, int i9) {
        A1.b.J0(i9);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i9 != fontMetricsInt) {
            textView.setLineSpacing(i9 - fontMetricsInt, 1.0f);
        }
    }

    public static void e(AppCompatTextView appCompatTextView, R.b bVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            bVar.getClass();
            appCompatTextView.setText((CharSequence) null);
        } else {
            R.b.a aVarA = a(appCompatTextView);
            bVar.getClass();
            aVarA.a(null);
            throw null;
        }
    }

    public static ActionMode.Callback f(ActionMode.Callback callback) {
        return callback instanceof c ? ((c) callback).f7140a : callback;
    }

    public static ActionMode.Callback g(ActionMode.Callback callback, TextView textView) {
        return (Build.VERSION.SDK_INT > 27 || (callback instanceof c) || callback == null) ? callback : new c(callback, textView);
    }
}
