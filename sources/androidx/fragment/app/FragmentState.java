package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f7565i;
    public final boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f7566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f7567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f7568m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7569n;

    public class a implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        public final FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentState[] newArray(int i9) {
            return new FragmentState[i9];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f7557a = fragment.getClass().getName();
        this.f7558b = fragment.f7464e;
        this.f7559c = fragment.f7472n;
        this.f7560d = fragment.f7480w;
        this.f7561e = fragment.f7481x;
        this.f7562f = fragment.f7482y;
        this.f7563g = fragment.f7443B;
        this.f7564h = fragment.f7470l;
        this.f7565i = fragment.f7442A;
        this.j = fragment.f7483z;
        this.f7566k = fragment.f7454M.ordinal();
        this.f7567l = fragment.f7467h;
        this.f7568m = fragment.f7468i;
        this.f7569n = fragment.f7449H;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f7557a);
        sb.append(" (");
        sb.append(this.f7558b);
        sb.append(")}:");
        if (this.f7559c) {
            sb.append(" fromLayout");
        }
        int i9 = this.f7561e;
        if (i9 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i9));
        }
        String str = this.f7562f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f7563g) {
            sb.append(" retainInstance");
        }
        if (this.f7564h) {
            sb.append(" removing");
        }
        if (this.f7565i) {
            sb.append(" detached");
        }
        if (this.j) {
            sb.append(" hidden");
        }
        String str2 = this.f7567l;
        if (str2 != null) {
            sb.append(" targetWho=");
            sb.append(str2);
            sb.append(" targetRequestCode=");
            sb.append(this.f7568m);
        }
        if (this.f7569n) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f7557a);
        parcel.writeString(this.f7558b);
        parcel.writeInt(this.f7559c ? 1 : 0);
        parcel.writeInt(this.f7560d);
        parcel.writeInt(this.f7561e);
        parcel.writeString(this.f7562f);
        parcel.writeInt(this.f7563g ? 1 : 0);
        parcel.writeInt(this.f7564h ? 1 : 0);
        parcel.writeInt(this.f7565i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.f7566k);
        parcel.writeString(this.f7567l);
        parcel.writeInt(this.f7568m);
        parcel.writeInt(this.f7569n ? 1 : 0);
    }

    public FragmentState(Parcel parcel) {
        this.f7557a = parcel.readString();
        this.f7558b = parcel.readString();
        this.f7559c = parcel.readInt() != 0;
        this.f7560d = parcel.readInt();
        this.f7561e = parcel.readInt();
        this.f7562f = parcel.readString();
        this.f7563g = parcel.readInt() != 0;
        this.f7564h = parcel.readInt() != 0;
        this.f7565i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.f7566k = parcel.readInt();
        this.f7567l = parcel.readString();
        this.f7568m = parcel.readInt();
        this.f7569n = parcel.readInt() != 0;
    }
}
