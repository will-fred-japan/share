package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: IntentSenderRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentSender f5801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f5802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5804d;

    /* JADX INFO: compiled from: IntentSenderRequest.kt */
    public static final class a implements Parcelable.Creator<IntentSenderRequest> {
        @Override // android.os.Parcelable.Creator
        public final IntentSenderRequest createFromParcel(Parcel inParcel) {
            k.e(inParcel, "inParcel");
            Parcelable parcelable = inParcel.readParcelable(IntentSender.class.getClassLoader());
            k.b(parcelable);
            return new IntentSenderRequest((IntentSender) parcelable, (Intent) inParcel.readParcelable(Intent.class.getClassLoader()), inParcel.readInt(), inParcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final IntentSenderRequest[] newArray(int i9) {
            return new IntentSenderRequest[i9];
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i9, int i10) {
        this.f5801a = intentSender;
        this.f5802b = intent;
        this.f5803c = i9;
        this.f5804d = i10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i9) {
        k.e(dest, "dest");
        dest.writeParcelable(this.f5801a, i9);
        dest.writeParcelable(this.f5802b, i9);
        dest.writeInt(this.f5803c);
        dest.writeInt(this.f5804d);
    }
}
