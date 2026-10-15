package androidx.preference;

import J.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f7867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f7868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f7870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f7871g;

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new a();

        public class a implements Parcelable.Creator<BaseSavedState> {
            @Override // android.os.Parcelable.Creator
            public final BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final BaseSavedState[] newArray(int i9) {
                return new BaseSavedState[i9];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }
    }

    public interface a<T extends Preference> {
        CharSequence a(T t);
    }

    public Preference(Context context, AttributeSet attributeSet, int i9) {
        this.f7866b = Integer.MAX_VALUE;
        this.f7865a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.preference.a.f7884f, i9, 0);
        typedArrayObtainStyledAttributes.getResourceId(23, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        String string = typedArrayObtainStyledAttributes.getString(26);
        this.f7869e = string == null ? typedArrayObtainStyledAttributes.getString(6) : string;
        CharSequence text = typedArrayObtainStyledAttributes.getText(34);
        this.f7867c = text == null ? typedArrayObtainStyledAttributes.getText(4) : text;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(33);
        this.f7868d = text2 == null ? typedArrayObtainStyledAttributes.getText(7) : text2;
        this.f7866b = typedArrayObtainStyledAttributes.getInt(28, typedArrayObtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        if (typedArrayObtainStyledAttributes.getString(22) == null) {
            typedArrayObtainStyledAttributes.getString(13);
        }
        typedArrayObtainStyledAttributes.getResourceId(27, typedArrayObtainStyledAttributes.getResourceId(3, R.layout.preference));
        typedArrayObtainStyledAttributes.getResourceId(35, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        typedArrayObtainStyledAttributes.getBoolean(21, typedArrayObtainStyledAttributes.getBoolean(2, true));
        boolean z8 = typedArrayObtainStyledAttributes.getBoolean(30, typedArrayObtainStyledAttributes.getBoolean(5, true));
        typedArrayObtainStyledAttributes.getBoolean(29, typedArrayObtainStyledAttributes.getBoolean(1, true));
        if (typedArrayObtainStyledAttributes.getString(19) == null) {
            typedArrayObtainStyledAttributes.getString(10);
        }
        typedArrayObtainStyledAttributes.getBoolean(16, typedArrayObtainStyledAttributes.getBoolean(16, z8));
        typedArrayObtainStyledAttributes.getBoolean(17, typedArrayObtainStyledAttributes.getBoolean(17, z8));
        if (typedArrayObtainStyledAttributes.hasValue(18)) {
            this.f7870f = c(typedArrayObtainStyledAttributes, 18);
        } else if (typedArrayObtainStyledAttributes.hasValue(11)) {
            this.f7870f = c(typedArrayObtainStyledAttributes, 11);
        }
        typedArrayObtainStyledAttributes.getBoolean(31, typedArrayObtainStyledAttributes.getBoolean(12, true));
        if (typedArrayObtainStyledAttributes.hasValue(32)) {
            typedArrayObtainStyledAttributes.getBoolean(32, typedArrayObtainStyledAttributes.getBoolean(14, true));
        }
        typedArrayObtainStyledAttributes.getBoolean(24, typedArrayObtainStyledAttributes.getBoolean(15, false));
        typedArrayObtainStyledAttributes.getBoolean(25, typedArrayObtainStyledAttributes.getBoolean(25, true));
        typedArrayObtainStyledAttributes.getBoolean(20, typedArrayObtainStyledAttributes.getBoolean(20, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CharSequence a() {
        a aVar = this.f7871g;
        return aVar != null ? aVar.a(this) : this.f7868d;
    }

    public Object c(TypedArray typedArray, int i9) {
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i9 = preference2.f7866b;
        int i10 = this.f7866b;
        if (i10 != i9) {
            return i10 - i9;
        }
        CharSequence charSequence = preference2.f7867c;
        CharSequence charSequence2 = this.f7867c;
        if (charSequence2 == charSequence) {
            return 0;
        }
        if (charSequence2 == null) {
            return 1;
        }
        if (charSequence == null) {
            return -1;
        }
        return charSequence2.toString().compareToIgnoreCase(charSequence.toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.f7867c;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence charSequenceA = a();
        if (!TextUtils.isEmpty(charSequenceA)) {
            sb.append(charSequenceA);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public void b() {
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.a(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
