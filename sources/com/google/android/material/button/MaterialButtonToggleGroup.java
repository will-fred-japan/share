package com.google.android.material.button;

import H5.l;
import T.C0414a;
import T.G;
import T.L;
import U.f;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.internal.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f13044k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f13046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<d> f13047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f13048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer[] f13049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13052h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13053i;
    public HashSet j;

    public class a implements Comparator<MaterialButton> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            MaterialButton materialButton3 = materialButton;
            MaterialButton materialButton4 = materialButton2;
            int iCompareTo = Boolean.valueOf(materialButton3.f13040o).compareTo(Boolean.valueOf(materialButton4.f13040o));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton3)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton4)));
        }
    }

    public class b extends C0414a {
        public b() {
        }

        @Override // T.C0414a
        public final void d(View view, f fVar) {
            int i9;
            this.f4401a.onInitializeAccessibilityNodeInfo(view, fVar.f4577a);
            int i10 = MaterialButtonToggleGroup.f13044k;
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (view instanceof MaterialButton) {
                i9 = 0;
                for (int i11 = 0; i11 < materialButtonToggleGroup.getChildCount(); i11++) {
                    if (materialButtonToggleGroup.getChildAt(i11) != view) {
                        if ((materialButtonToggleGroup.getChildAt(i11) instanceof MaterialButton) && materialButtonToggleGroup.c(i11)) {
                            i9++;
                        }
                    }
                }
                i9 = -1;
            } else {
                i9 = -1;
            }
            fVar.h(f.g.a(0, 1, i9, 1, ((MaterialButton) view).f13040o));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final H5.a f13056e = new H5.a(0.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final H5.d f13057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final H5.d f13058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final H5.d f13059c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final H5.d f13060d;

        public c(H5.d dVar, H5.d dVar2, H5.d dVar3, H5.d dVar4) {
            this.f13057a = dVar;
            this.f13058b = dVar3;
            this.f13059c = dVar4;
            this.f13060d = dVar2;
        }
    }

    public interface d {
        void a();
    }

    public class e implements MaterialButton.b {
        public e() {
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(K5.a.a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.f13045a = new ArrayList();
        this.f13046b = new e();
        this.f13047c = new LinkedHashSet<>();
        this.f13048d = new a();
        this.f13050f = false;
        this.j = new HashSet();
        TypedArray typedArrayD = h.d(getContext(), attributeSet, p103n5.a.f20602o, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(typedArrayD.getBoolean(3, false));
        this.f13053i = typedArrayD.getResourceId(1, -1);
        this.f13052h = typedArrayD.getBoolean(2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayD.getBoolean(0, true));
        typedArrayD.recycle();
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        setImportantForAccessibility(1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            if (c(i9)) {
                return i9;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof MaterialButton) && c(i10)) {
                i9++;
            }
        }
        return i9;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            materialButton.setId(View.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f13046b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i9 = firstVisibleChildIndex + 1; i9 < getChildCount(); i9++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i9);
            int iMin = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i9 - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(-iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i9, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        b(materialButton.getId(), materialButton.f13040o);
        l shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f13045a.add(new c(shapeAppearanceModel.f2463e, shapeAppearanceModel.f2466h, shapeAppearanceModel.f2464f, shapeAppearanceModel.f2465g));
        materialButton.setEnabled(isEnabled());
        G.m(materialButton, new b());
    }

    public final void b(int i9, boolean z8) {
        if (i9 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i9);
            return;
        }
        HashSet hashSet = new HashSet(this.j);
        if (z8 && !hashSet.contains(Integer.valueOf(i9))) {
            if (this.f13051g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i9));
        } else {
            if (z8 || !hashSet.contains(Integer.valueOf(i9))) {
                return;
            }
            if (!this.f13052h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i9));
            }
        }
        d(hashSet);
    }

    public final boolean c(int i9) {
        return getChildAt(i9).getVisibility() != 8;
    }

    public final void d(Set<Integer> set) {
        HashSet hashSet = this.j;
        this.j = new HashSet(set);
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            int id = ((MaterialButton) getChildAt(i9)).getId();
            boolean zContains = set.contains(Integer.valueOf(id));
            View viewFindViewById = findViewById(id);
            if (viewFindViewById instanceof MaterialButton) {
                this.f13050f = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.f13050f = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator<d> it = this.f13047c.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f13048d);
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            treeMap.put((MaterialButton) getChildAt(i9), Integer.valueOf(i9));
        }
        this.f13049e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        c cVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i9 = 0; i9 < childCount; i9++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i9);
            if (materialButton.getVisibility() != 8) {
                l.a aVarE = materialButton.getShapeAppearanceModel().e();
                c cVar2 = (c) this.f13045a.get(i9);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z8 = getOrientation() == 0;
                    H5.a aVar = c.f13056e;
                    if (i9 == firstVisibleChildIndex) {
                        cVar = z8 ? com.google.android.material.internal.l.c(this) ? new c(aVar, aVar, cVar2.f13058b, cVar2.f13059c) : new c(cVar2.f13057a, cVar2.f13060d, aVar, aVar) : new c(cVar2.f13057a, aVar, cVar2.f13058b, aVar);
                    } else if (i9 != lastVisibleChildIndex) {
                        cVar2 = null;
                    } else if (z8) {
                        cVar = com.google.android.material.internal.l.c(this) ? new c(cVar2.f13057a, cVar2.f13060d, aVar, aVar) : new c(aVar, aVar, cVar2.f13058b, cVar2.f13059c);
                    } else {
                        cVar = new c(aVar, cVar2.f13060d, aVar, cVar2.f13059c);
                    }
                    cVar2 = cVar;
                }
                if (cVar2 == null) {
                    aVarE.f2474e = new H5.a(0.0f);
                    aVarE.f2475f = new H5.a(0.0f);
                    aVarE.f2476g = new H5.a(0.0f);
                    aVarE.f2477h = new H5.a(0.0f);
                } else {
                    aVarE.f2474e = cVar2.f13057a;
                    aVarE.f2477h = cVar2.f13060d;
                    aVarE.f2475f = cVar2.f13058b;
                    aVarE.f2476g = cVar2.f13059c;
                }
                materialButton.setShapeAppearanceModel(aVarE.a());
            }
        }
    }

    public int getCheckedButtonId() {
        if (!this.f13051g || this.j.isEmpty()) {
            return -1;
        }
        return ((Integer) this.j.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            int id = ((MaterialButton) getChildAt(i9)).getId();
            if (this.j.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i9, int i10) {
        Integer[] numArr = this.f13049e;
        if (numArr != null && i10 < numArr.length) {
            return numArr[i10].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i10;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i9 = this.f13053i;
        if (i9 != -1) {
            d(Collections.singleton(Integer.valueOf(i9)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.f13051g ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        e();
        a();
        super.onMeasure(i9, i10);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f13045a.remove(iIndexOfChild);
        }
        e();
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z8) {
        super.setEnabled(z8);
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            ((MaterialButton) getChildAt(i9)).setEnabled(z8);
        }
    }

    public void setSelectionRequired(boolean z8) {
        this.f13052h = z8;
    }

    public void setSingleSelection(boolean z8) {
        if (this.f13051g != z8) {
            this.f13051g = z8;
            d(new HashSet());
        }
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            ((MaterialButton) getChildAt(i9)).setA11yClassName((this.f13051g ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    public void setSingleSelection(int i9) {
        setSingleSelection(getResources().getBoolean(i9));
    }
}
