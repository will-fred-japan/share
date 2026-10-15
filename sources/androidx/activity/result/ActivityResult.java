package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ActivityResult.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f5800b;

    /* JADX INFO: compiled from: ActivityResult.kt */
    public static final class a implements Parcelable.Creator<ActivityResult> {
        @Override // android.os.Parcelable.Creator
        public final ActivityResult createFromParcel(Parcel parcel) {
            k.e(parcel, "parcel");
            return new ActivityResult(parcel.readInt(), parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityResult[] newArray(int i9) {
            return new ActivityResult[i9];
        }
    }

    public ActivityResult(int i9, Intent intent) {
        this.f5799a = i9;
        this.f5800b = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String strValueOf;
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i9 = this.f5799a;
        if (i9 != -1) {
            strValueOf = i9 != 0 ? String.valueOf(i9) : "RESULT_CANCELED";
        } else {
            strValueOf = "RESULT_OK";
        }
        sb.append(strValueOf);
        sb.append(", data=");
        sb.append(this.f5800b);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i9) {
        k.e(dest, "dest");
        dest.writeInt(this.f5799a);
        Intent intent = this.f5800b;
        dest.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(dest, i9);
        }
    }
}
