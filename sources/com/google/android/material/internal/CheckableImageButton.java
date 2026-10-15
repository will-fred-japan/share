package com.google.android.material.internal;

import T.G;
import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.datepicker.m;
import com.starburst.sdk.core.opus.OpusCodecConfig;

/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f13439g = {R.attr.state_checked};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13442f;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f13443c;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i9) {
                return new SavedState[i9];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13443c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeInt(this.f13443c ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, cn.ikaile.ruoshui.client.R.attr.imageButtonStyle);
        this.f13441e = true;
        this.f13442f = true;
        G.m(this, new m(1, this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f13440d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        return this.f13440d ? View.mergeDrawableStates(super.onCreateDrawableState(i9 + 1), f13439g) : super.onCreateDrawableState(i9);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f7147a);
        setChecked(savedState.f13443c);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13443c = this.f13440d;
        return savedState;
    }

    public void setCheckable(boolean z8) {
        if (this.f13441e != z8) {
            this.f13441e = z8;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z8) {
        if (!this.f13441e || this.f13440d == z8) {
            return;
        }
        this.f13440d = z8;
        refreshDrawableState();
        sendAccessibilityEvent(OpusCodecConfig.APPLICATION_VOIP);
    }

    public void setPressable(boolean z8) {
        this.f13442f = z8;
    }

    @Override // android.view.View
    public void setPressed(boolean z8) {
        if (this.f13442f) {
            super.setPressed(z8);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f13440d);
    }
}
