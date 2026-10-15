package androidx.preference;

import J.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CharSequence[] f7860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f7861i;

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7862a;

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
            this.f7862a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeString(this.f7862a);
        }
    }

    public static final class a implements Preference.a<ListPreference> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f7863a;

        @Override // androidx.preference.Preference.a
        public final CharSequence a(Preference preference) {
            ListPreference listPreference = (ListPreference) preference;
            listPreference.getClass();
            if (TextUtils.isEmpty(null)) {
                return listPreference.f7865a.getString(R.string.not_set);
            }
            return null;
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.preference.a.f7882d, i9, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.f7860h = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        if (typedArrayObtainStyledAttributes.getTextArray(3) == null) {
            typedArrayObtainStyledAttributes.getTextArray(1);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(4, typedArrayObtainStyledAttributes.getBoolean(4, false))) {
            if (a.f7863a == null) {
                a.f7863a = new a();
            }
            this.f7871g = a.f7863a;
            b();
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.preference.a.f7884f, i9, 0);
        String string = typedArrayObtainStyledAttributes2.getString(33);
        this.f7861i = string == null ? typedArrayObtainStyledAttributes2.getString(7) : string;
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final CharSequence a() {
        Preference.a aVar = this.f7871g;
        if (aVar != null) {
            return aVar.a(this);
        }
        CharSequence charSequenceA = super.a();
        String str = this.f7861i;
        if (str != null) {
            String str2 = String.format(str, "");
            if (!TextUtils.equals(str2, charSequenceA)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceA;
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i9) {
        return typedArray.getString(i9);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
