package androidx.viewpager2.widget;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Parcelable f8441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8442d;

    public interface a {
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i9) {
        throw null;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i9) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        RecyclerView.d adapter;
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i9 = ((SavedState) parcelable).f8443a;
            throw null;
        }
        super.dispatchRestoreInstanceState(sparseArray);
        if (this.f8440b == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        if (this.f8441c != null) {
            if (adapter instanceof p198z0.a) {
                ((p198z0.a) adapter).a();
            }
            this.f8441c = null;
        }
        this.f8439a = Math.max(0, Math.min(this.f8440b, adapter.a() - 1));
        this.f8440b = -1;
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        throw null;
    }

    public RecyclerView.d getAdapter() {
        throw null;
    }

    public int getCurrentItem() {
        return this.f8439a;
    }

    public int getItemDecorationCount() {
        throw null;
    }

    public int getOffscreenPageLimit() {
        return this.f8442d;
    }

    public int getOrientation() {
        throw null;
    }

    public int getPageSize() {
        if (getOrientation() == 0) {
            throw null;
        }
        throw null;
    }

    public int getScrollState() {
        throw null;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        throw null;
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        measureChild(null, i9, i10);
        throw null;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8440b = savedState.f8444b;
        this.f8441c = savedState.f8445c;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        new SavedState(super.onSaveInstanceState());
        throw null;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i9, Bundle bundle) {
        throw null;
    }

    public void setAdapter(RecyclerView.d dVar) {
        throw null;
    }

    public void setCurrentItem(int i9) {
        throw null;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i9) {
        super.setLayoutDirection(i9);
        throw null;
    }

    public void setOffscreenPageLimit(int i9) {
        if (i9 < 1 && i9 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f8442d = i9;
        throw null;
    }

    public void setOrientation(int i9) {
        throw null;
    }

    public void setPageTransformer(a aVar) {
        if (aVar == null) {
            throw null;
        }
        throw null;
    }

    public void setUserInputEnabled(boolean z8) {
        throw null;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Parcelable f8445c;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeInt(this.f8443a);
            parcel.writeInt(this.f8444b);
            parcel.writeParcelable(this.f8445c, i9);
        }

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState(parcel, null);
                savedState.f8443a = parcel.readInt();
                savedState.f8444b = parcel.readInt();
                savedState.f8445c = parcel.readParcelable(null);
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i9) {
                return new SavedState[i9];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState(parcel, classLoader);
                savedState.f8443a = parcel.readInt();
                savedState.f8444b = parcel.readInt();
                savedState.f8445c = parcel.readParcelable(classLoader);
                return savedState;
            }
        }
    }
}
