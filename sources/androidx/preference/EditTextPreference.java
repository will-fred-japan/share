package androidx.preference;

import J.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7858a;

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
            this.f7858a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeString(this.f7858a);
        }
    }

    public static final class a implements Preference.a<EditTextPreference> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f7859a;

        @Override // androidx.preference.Preference.a
        public final CharSequence a(Preference preference) {
            EditTextPreference editTextPreference = (EditTextPreference) preference;
            editTextPreference.getClass();
            if (TextUtils.isEmpty(null)) {
                return editTextPreference.f7865a.getString(R.string.not_set);
            }
            return null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EditTextPreference(Context context, AttributeSet attributeSet) {
        int iA = k.a(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle);
        super(context, attributeSet, iA);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.preference.a.f7881c, iA, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(0, typedArrayObtainStyledAttributes.getBoolean(0, false))) {
            if (a.f7859a == null) {
                a.f7859a = new a();
            }
            this.f7871g = a.f7859a;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i9) {
        return typedArray.getString(i9);
    }
}
