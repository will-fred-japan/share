package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f7874i;

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7877c;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i9) {
                return new SavedState[i9];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f7875a = parcel.readInt();
            this.f7876b = parcel.readInt();
            this.f7877c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeInt(this.f7875a);
            parcel.writeInt(this.f7876b);
            parcel.writeInt(this.f7877c);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f7887i, R.attr.seekBarPreferenceStyle, 0);
        int i9 = typedArrayObtainStyledAttributes.getInt(3, 0);
        int i10 = typedArrayObtainStyledAttributes.getInt(1, 100);
        i10 = i10 < i9 ? i9 : i10;
        if (i10 != this.f7873h) {
            this.f7873h = i10;
        }
        int i11 = typedArrayObtainStyledAttributes.getInt(4, 0);
        if (i11 != this.f7874i) {
            this.f7874i = Math.min(this.f7873h - i9, Math.abs(i11));
        }
        typedArrayObtainStyledAttributes.getBoolean(2, true);
        typedArrayObtainStyledAttributes.getBoolean(5, false);
        typedArrayObtainStyledAttributes.getBoolean(6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i9) {
        return Integer.valueOf(typedArray.getInt(i9, 0));
    }
}
