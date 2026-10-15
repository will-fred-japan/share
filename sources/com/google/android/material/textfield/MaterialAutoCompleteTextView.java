package com.google.android.material.textfield;

import T.G;
import T.L;
import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.z;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f13747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AccessibilityManager f13748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f13749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f13751i;
    public ColorStateList j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f13753l;

    public class a<T> extends ArrayAdapter<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ColorStateList f13754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ColorStateList f13755b;

        public a(Context context, int i9, String[] strArr) {
            super(context, i9, strArr);
            b();
        }

        public final void b() {
            ColorStateList colorStateList;
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            ColorStateList colorStateList2 = materialAutoCompleteTextView.f13753l;
            ColorStateList colorStateList3 = null;
            if (colorStateList2 != null) {
                int[] iArr = {R.attr.state_pressed};
                colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
            } else {
                colorStateList = null;
            }
            this.f13755b = colorStateList;
            if (materialAutoCompleteTextView.f13752k != 0 && materialAutoCompleteTextView.f13753l != null) {
                int[] iArr2 = {R.attr.state_hovered, -16842919};
                int[] iArr3 = {R.attr.state_selected, -16842919};
                colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{K.a.c(materialAutoCompleteTextView.f13753l.getColorForState(iArr3, 0), materialAutoCompleteTextView.f13752k), K.a.c(materialAutoCompleteTextView.f13753l.getColorForState(iArr2, 0), materialAutoCompleteTextView.f13752k), materialAutoCompleteTextView.f13752k});
            }
            this.f13754a = colorStateList3;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final View getView(int i9, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i9, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
                Drawable rippleDrawable = null;
                if (materialAutoCompleteTextView.getText().toString().contentEquals(textView.getText()) && materialAutoCompleteTextView.f13752k != 0) {
                    ColorDrawable colorDrawable = new ColorDrawable(materialAutoCompleteTextView.f13752k);
                    if (this.f13755b != null) {
                        colorDrawable.setTintList(this.f13754a);
                        rippleDrawable = new RippleDrawable(this.f13755b, colorDrawable, null);
                    } else {
                        rippleDrawable = colorDrawable;
                    }
                }
                WeakHashMap<View, L> weakHashMap = G.f4313a;
                textView.setBackground(rippleDrawable);
            }
            return view2;
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(K5.a.a(context, attributeSet, cn.ikaile.ruoshui.client.R.attr.autoCompleteTextViewStyle, 0), attributeSet, 0);
        this.f13749g = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = com.google.android.material.internal.h.d(context2, attributeSet, p103n5.a.f20600m, cn.ikaile.ruoshui.client.R.attr.autoCompleteTextViewStyle, 2131886879, new int[0]);
        if (typedArrayD.hasValue(0) && typedArrayD.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f13750h = typedArrayD.getResourceId(3, cn.ikaile.ruoshui.client.R.layout.mtrl_auto_complete_simple_item);
        this.f13751i = typedArrayD.getDimensionPixelOffset(1, cn.ikaile.ruoshui.client.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (typedArrayD.hasValue(2)) {
            this.j = ColorStateList.valueOf(typedArrayD.getColor(2, 0));
        }
        this.f13752k = typedArrayD.getColor(4, 0);
        this.f13753l = E5.c.a(context2, typedArrayD, 5);
        this.f13748f = (AccessibilityManager) context2.getSystemService("accessibility");
        z zVar = new z(context2, null, cn.ikaile.ruoshui.client.R.attr.listPopupWindowStyle);
        this.f13747e = zVar;
        zVar.f6730y = true;
        zVar.f6731z.setFocusable(true);
        zVar.f6721o = this;
        zVar.f6731z.setInputMethodMode(2);
        zVar.p(getAdapter());
        zVar.f6722p = new o(this);
        if (typedArrayD.hasValue(6)) {
            setSimpleItems(typedArrayD.getResourceId(6, 0));
        }
        typedArrayD.recycle();
    }

    public static void a(MaterialAutoCompleteTextView materialAutoCompleteTextView, Object obj) {
        materialAutoCompleteTextView.setText(materialAutoCompleteTextView.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean c() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f13748f;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16)) == null) {
            return false;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
            if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        if (c()) {
            this.f13747e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.j;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutB = b();
        return (textInputLayoutB == null || !textInputLayoutB.f13768E) ? super.getHint() : textInputLayoutB.getHint();
    }

    public float getPopupElevation() {
        return this.f13751i;
    }

    public int getSimpleItemSelectedColor() {
        return this.f13752k;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f13753l;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null && textInputLayoutB.f13768E && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals(MTPushConstants.Manufacturer.MEIZU)) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13747e.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (View.MeasureSpec.getMode(i9) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout textInputLayoutB = b();
            int measuredWidth2 = 0;
            if (adapter != null && textInputLayoutB != null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                z zVar = this.f13747e;
                int iMin = Math.min(adapter.getCount(), Math.max(0, !zVar.f6731z.isShowing() ? -1 : zVar.f6710c.getSelectedItemPosition()) + 15);
                View view = null;
                int iMax = 0;
                for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
                    int itemViewType = adapter.getItemViewType(iMax2);
                    if (itemViewType != measuredWidth2) {
                        view = null;
                        measuredWidth2 = itemViewType;
                    }
                    view = adapter.getView(iMax2, view, textInputLayoutB);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                Drawable background = zVar.f6731z.getBackground();
                if (background != null) {
                    Rect rect = this.f13749g;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutB.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i9)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z8) {
        if (c()) {
            return;
        }
        super.onWindowFocusChanged(z8);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f13747e.p(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        z zVar = this.f13747e;
        if (zVar != null) {
            zVar.h(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i9) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i9));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof H5.h) {
            ((H5.h) dropDownBackground).k(this.j);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f13747e.f6723q = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i9) {
        super.setRawInputType(i9);
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null) {
            textInputLayoutB.s();
        }
    }

    public void setSimpleItemSelectedColor(int i9) {
        this.f13752k = i9;
        if (getAdapter() instanceof a) {
            ((a) getAdapter()).b();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f13753l = colorStateList;
        if (getAdapter() instanceof a) {
            ((a) getAdapter()).b();
        }
    }

    public void setSimpleItems(int i9) {
        setSimpleItems(getResources().getStringArray(i9));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if (c()) {
            this.f13747e.d();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new a(getContext(), this.f13750h, strArr));
    }
}
