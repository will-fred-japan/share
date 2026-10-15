package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertController;
import java.util.Objects;
import p056h5.C0598e;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SuppressLint({"ResourceType"})
    public static final int[] f6342i = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0492d f6343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0502n f6345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f6346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f6348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f6350h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6351a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState(parcel);
                savedState.f6351a = parcel.readByte() != 0;
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i9) {
                return new SavedState[i9];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeByte(this.f6351a ? (byte) 1 : (byte) 0);
        }
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            if (!appCompatSpinner.getInternalPopup().b()) {
                appCompatSpinner.f6348f.l(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
            }
            ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    public static final class b {
        public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (Objects.equals(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    public class c implements f, DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.e f6353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f6354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f6355c;

        public c() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final boolean b() {
            androidx.appcompat.app.e eVar = this.f6353a;
            if (eVar != null) {
                return eVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void dismiss() {
            androidx.appcompat.app.e eVar = this.f6353a;
            if (eVar != null) {
                eVar.dismiss();
                this.f6353a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final Drawable e() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void f(CharSequence charSequence) {
            this.f6355c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void h(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void i(int i9) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void j(int i9) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void k(int i9) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void l(int i9, int i10) {
            if (this.f6354b == null) {
                return;
            }
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            androidx.appcompat.app.e.a aVar = new androidx.appcompat.app.e.a(appCompatSpinner.getPopupContext());
            CharSequence charSequence = this.f6355c;
            AlertController.b bVar = aVar.f5947a;
            if (charSequence != null) {
                bVar.f5841d = charSequence;
            }
            d dVar = this.f6354b;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            bVar.f5849m = dVar;
            bVar.f5850n = this;
            bVar.f5852p = selectedItemPosition;
            bVar.f5851o = true;
            androidx.appcompat.app.e eVarA = aVar.a();
            this.f6353a = eVarA;
            AlertController.RecycleListView recycleListView = eVarA.f5946g.f5816f;
            recycleListView.setTextDirection(i9);
            recycleListView.setTextAlignment(i10);
            this.f6353a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final int m() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final CharSequence o() {
            return this.f6355c;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i9) {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            appCompatSpinner.setSelection(i9);
            if (appCompatSpinner.getOnItemClickListener() != null) {
                appCompatSpinner.performItemClick(null, i9, this.f6354b.getItemId(i9));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void p(ListAdapter listAdapter) {
            this.f6354b = (d) listAdapter;
        }
    }

    public static class d implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SpinnerAdapter f6357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ListAdapter f6358b;

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f6358b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.f6357a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i9, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f6357a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i9, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i9) {
            SpinnerAdapter spinnerAdapter = this.f6357a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i9);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i9) {
            SpinnerAdapter spinnerAdapter = this.f6357a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i9);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int i9) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int i9, View view, ViewGroup viewGroup) {
            return getDropDownView(i9, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f6357a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i9) {
            ListAdapter listAdapter = this.f6358b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i9);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f6357a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f6357a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class e extends z implements f {

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public CharSequence f6359C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public d f6360D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public final Rect f6361E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f6362F;

        public class a implements AdapterView.OnItemClickListener {
            public a() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i9, long j) {
                e eVar = e.this;
                AppCompatSpinner.this.setSelection(i9);
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                if (appCompatSpinner.getOnItemClickListener() != null) {
                    appCompatSpinner.performItemClick(view, i9, eVar.f6360D.getItemId(i9));
                }
                eVar.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                e eVar = e.this;
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                eVar.getClass();
                if (!appCompatSpinner.isAttachedToWindow() || !appCompatSpinner.getGlobalVisibleRect(eVar.f6361E)) {
                    eVar.dismiss();
                } else {
                    eVar.s();
                    eVar.d();
                }
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f6366a;

            public c(b bVar) {
                this.f6366a = bVar;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f6366a);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i9) {
            super(context, attributeSet, i9);
            this.f6361E = new Rect();
            this.f6721o = AppCompatSpinner.this;
            this.f6730y = true;
            this.f6731z.setFocusable(true);
            this.f6722p = new a();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void f(CharSequence charSequence) {
            this.f6359C = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void j(int i9) {
            this.f6362F = i9;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final void l(int i9, int i10) {
            ViewTreeObserver viewTreeObserver;
            C0498j c0498j = this.f6731z;
            boolean zIsShowing = c0498j.isShowing();
            s();
            this.f6731z.setInputMethodMode(2);
            d();
            v vVar = this.f6710c;
            vVar.setChoiceMode(1);
            vVar.setTextDirection(i9);
            vVar.setTextAlignment(i10);
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            v vVar2 = this.f6710c;
            if (c0498j.isShowing() && vVar2 != null) {
                vVar2.setListSelectionHidden(false);
                vVar2.setSelection(selectedItemPosition);
                if (vVar2.getChoiceMode() != 0) {
                    vVar2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (zIsShowing || (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            this.f6731z.setOnDismissListener(new c(bVar));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.f
        public final CharSequence o() {
            return this.f6359C;
        }

        @Override // androidx.appcompat.widget.z, androidx.appcompat.widget.AppCompatSpinner.f
        public final void p(ListAdapter listAdapter) {
            super.p(listAdapter);
            this.f6360D = (d) listAdapter;
        }

        public final void s() {
            int i9;
            C0498j c0498j = this.f6731z;
            Drawable background = c0498j.getBackground();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            if (background != null) {
                background.getPadding(appCompatSpinner.f6350h);
                boolean z8 = Q.f6464a;
                int layoutDirection = appCompatSpinner.getLayoutDirection();
                Rect rect = appCompatSpinner.f6350h;
                i9 = layoutDirection == 1 ? rect.right : -rect.left;
            } else {
                Rect rect2 = appCompatSpinner.f6350h;
                rect2.right = 0;
                rect2.left = 0;
                i9 = 0;
            }
            int paddingLeft = appCompatSpinner.getPaddingLeft();
            int paddingRight = appCompatSpinner.getPaddingRight();
            int width = appCompatSpinner.getWidth();
            int i10 = appCompatSpinner.f6349g;
            if (i10 == -2) {
                int iA = appCompatSpinner.a(this.f6360D, c0498j.getBackground());
                int i11 = appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = appCompatSpinner.f6350h;
                int i12 = (i11 - rect3.left) - rect3.right;
                if (iA > i12) {
                    iA = i12;
                }
                r(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i10 == -1) {
                r((width - paddingLeft) - paddingRight);
            } else {
                r(i10);
            }
            boolean z9 = Q.f6464a;
            this.f6713f = appCompatSpinner.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f6712e) - this.f6362F) + i9 : paddingLeft + this.f6362F + i9;
        }
    }

    public interface f {
        boolean b();

        int c();

        void dismiss();

        Drawable e();

        void f(CharSequence charSequence);

        void h(Drawable drawable);

        void i(int i9);

        void j(int i9);

        void k(int i9);

        void l(int i9, int i10);

        int m();

        CharSequence o();

        void p(ListAdapter listAdapter);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    /* JADX WARN: Code duplicated, block: B:29:0x0096  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d0  */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i9) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] textArray;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, i9);
        this.f6350h = new Rect();
        F.a(getContext(), this);
        int[] iArr = p059i.a.f19192u;
        K kE = K.e(context, attributeSet, iArr, i9);
        this.f6343a = new C0492d(this);
        TypedArray typedArray = kE.f6420b;
        int resourceId = typedArray.getResourceId(4, 0);
        if (resourceId != 0) {
            this.f6344b = new p089m.c(context, resourceId);
        } else {
            this.f6344b = context;
        }
        int i10 = -1;
        TypedArray typedArray2 = null;
        try {
            try {
                typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6342i, i9, 0);
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(0)) {
                        i10 = typedArrayObtainStyledAttributes.getInt(0, 0);
                    }
                } catch (Exception e9) {
                    e = e9;
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                    if (typedArrayObtainStyledAttributes != null) {
                    }
                    if (i10 != 0) {
                        c cVar = new c();
                        this.f6348f = cVar;
                        cVar.f6355c = typedArray.getString(2);
                    } else if (i10 == 1) {
                        e eVar = new e(this.f6344b, attributeSet, i9);
                        K kE2 = K.e(this.f6344b, attributeSet, iArr, i9);
                        this.f6349g = kE2.f6420b.getLayoutDimension(3, -2);
                        eVar.h(kE2.b(1));
                        eVar.f6359C = typedArray.getString(2);
                        kE2.f();
                        this.f6348f = eVar;
                        this.f6345c = new C0502n(this, this, eVar);
                    }
                    textArray = typedArray.getTextArray(0);
                    if (textArray != null) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
                        arrayAdapter.setDropDownViewResource(cn.ikaile.ruoshui.client.R.layout.support_simple_spinner_dropdown_item);
                        setAdapter((SpinnerAdapter) arrayAdapter);
                    }
                    kE.f();
                    this.f6347e = true;
                    spinnerAdapter = this.f6346d;
                    if (spinnerAdapter != null) {
                        setAdapter(spinnerAdapter);
                        this.f6346d = null;
                    }
                    this.f6343a.d(attributeSet, i9);
                }
            } catch (Throwable th) {
                th = th;
                typedArray2 = typedArrayObtainStyledAttributes;
                if (typedArray2 != null) {
                    typedArray2.recycle();
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            typedArrayObtainStyledAttributes = null;
        } catch (Throwable th2) {
            th = th2;
            if (typedArray2 != null) {
                typedArray2.recycle();
            }
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (i10 != 0) {
            c cVar2 = new c();
            this.f6348f = cVar2;
            cVar2.f6355c = typedArray.getString(2);
        } else if (i10 == 1) {
            e eVar2 = new e(this.f6344b, attributeSet, i9);
            K kE3 = K.e(this.f6344b, attributeSet, iArr, i9);
            this.f6349g = kE3.f6420b.getLayoutDimension(3, -2);
            eVar2.h(kE3.b(1));
            eVar2.f6359C = typedArray.getString(2);
            kE3.f();
            this.f6348f = eVar2;
            this.f6345c = new C0502n(this, this, eVar2);
        }
        textArray = typedArray.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
            arrayAdapter2.setDropDownViewResource(cn.ikaile.ruoshui.client.R.layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter2);
        }
        kE.f();
        this.f6347e = true;
        spinnerAdapter = this.f6346d;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f6346d = null;
        }
        this.f6343a.d(attributeSet, i9);
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i9 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.f6350h;
        drawable.getPadding(rect);
        return rect.left + rect.right + iMax2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0492d c0492d = this.f6343a;
        if (c0492d != null) {
            c0492d.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        f fVar = this.f6348f;
        return fVar != null ? fVar.c() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        f fVar = this.f6348f;
        return fVar != null ? fVar.m() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f6348f != null ? this.f6349g : super.getDropDownWidth();
    }

    public final f getInternalPopup() {
        return this.f6348f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        f fVar = this.f6348f;
        return fVar != null ? fVar.e() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f6344b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        f fVar = this.f6348f;
        return fVar != null ? fVar.o() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0492d c0492d = this.f6343a;
        if (c0492d != null) {
            return c0492d.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0492d c0492d = this.f6343a;
        if (c0492d != null) {
            return c0492d.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.f6348f;
        if (fVar == null || !fVar.b()) {
            return;
        }
        fVar.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (this.f6348f == null || View.MeasureSpec.getMode(i9) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i9)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f6351a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new a());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.f6348f;
        savedState.f6351a = fVar != null && fVar.b();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0502n c0502n = this.f6345c;
        if (c0502n == null || !c0502n.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        f fVar = this.f6348f;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.b()) {
            return true;
        }
        this.f6348f.l(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0492d c0492d = this.f6343a;
        if (c0492d != null) {
            c0492d.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        C0492d c0492d = this.f6343a;
        if (c0492d != null) {
            c0492d.f(i9);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i9) {
        f fVar = this.f6348f;
        if (fVar == null) {
            super.setDropDownHorizontalOffset(i9);
        } else {
            fVar.j(i9);
            fVar.k(i9);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i9) {
        f fVar = this.f6348f;
        if (fVar != null) {
            fVar.i(i9);
        } else {
            super.setDropDownVerticalOffset(i9);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i9) {
        if (this.f6348f != null) {
            this.f6349g = i9;
        } else {
            super.setDropDownWidth(i9);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.f6348f;
        if (fVar != null) {
            fVar.h(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i9) {
        setPopupBackgroundDrawable(C0598e.v(getPopupContext(), i9));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        f fVar = this.f6348f;
        if (fVar != null) {
            fVar.f(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0492d c0492d = this.f6343a;
        if (c0492d != null) {
            c0492d.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0492d c0492d = this.f6343a;
        if (c0492d != null) {
            c0492d.i(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f6347e) {
            this.f6346d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        f fVar = this.f6348f;
        if (fVar != null) {
            Context context = this.f6344b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            d dVar = new d();
            dVar.f6357a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                dVar.f6358b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    b.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof G) {
                    G g4 = (G) spinnerAdapter;
                    if (g4.getDropDownViewTheme() == null) {
                        g4.a();
                    }
                }
            }
            fVar.p(dVar);
        }
    }
}
