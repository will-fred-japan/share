package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f7426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f7427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f7428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f7429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f7434i;
    public final int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CharSequence f7435k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<String> f7436l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<String> f7437m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7438n;

    public class a implements Parcelable.Creator<BackStackRecordState> {
        @Override // android.os.Parcelable.Creator
        public final BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BackStackRecordState[] newArray(int i9) {
            return new BackStackRecordState[i9];
        }
    }

    public BackStackRecordState(C0532a c0532a) {
        int size = c0532a.f7657a.size();
        this.f7426a = new int[size * 6];
        if (!c0532a.f7663g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f7427b = new ArrayList<>(size);
        this.f7428c = new int[size];
        this.f7429d = new int[size];
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            x.a aVar = c0532a.f7657a.get(i10);
            int i11 = i9 + 1;
            this.f7426a[i9] = aVar.f7671a;
            ArrayList<String> arrayList = this.f7427b;
            Fragment fragment = aVar.f7672b;
            arrayList.add(fragment != null ? fragment.f7464e : null);
            int[] iArr = this.f7426a;
            iArr[i11] = aVar.f7673c ? 1 : 0;
            iArr[i9 + 2] = aVar.f7674d;
            iArr[i9 + 3] = aVar.f7675e;
            int i12 = i9 + 5;
            iArr[i9 + 4] = aVar.f7676f;
            i9 += 6;
            iArr[i12] = aVar.f7677g;
            this.f7428c[i10] = aVar.f7678h.ordinal();
            this.f7429d[i10] = aVar.f7679i.ordinal();
        }
        this.f7430e = c0532a.f7662f;
        this.f7431f = c0532a.f7664h;
        this.f7432g = c0532a.f7574r;
        this.f7433h = c0532a.f7665i;
        this.f7434i = c0532a.j;
        this.j = c0532a.f7666k;
        this.f7435k = c0532a.f7667l;
        this.f7436l = c0532a.f7668m;
        this.f7437m = c0532a.f7669n;
        this.f7438n = c0532a.f7670o;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeIntArray(this.f7426a);
        parcel.writeStringList(this.f7427b);
        parcel.writeIntArray(this.f7428c);
        parcel.writeIntArray(this.f7429d);
        parcel.writeInt(this.f7430e);
        parcel.writeString(this.f7431f);
        parcel.writeInt(this.f7432g);
        parcel.writeInt(this.f7433h);
        TextUtils.writeToParcel(this.f7434i, parcel, 0);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.f7435k, parcel, 0);
        parcel.writeStringList(this.f7436l);
        parcel.writeStringList(this.f7437m);
        parcel.writeInt(this.f7438n ? 1 : 0);
    }

    public BackStackRecordState(Parcel parcel) {
        this.f7426a = parcel.createIntArray();
        this.f7427b = parcel.createStringArrayList();
        this.f7428c = parcel.createIntArray();
        this.f7429d = parcel.createIntArray();
        this.f7430e = parcel.readInt();
        this.f7431f = parcel.readString();
        this.f7432g = parcel.readInt();
        this.f7433h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f7434i = (CharSequence) creator.createFromParcel(parcel);
        this.j = parcel.readInt();
        this.f7435k = (CharSequence) creator.createFromParcel(parcel);
        this.f7436l = parcel.createStringArrayList();
        this.f7437m = parcel.createStringArrayList();
        this.f7438n = parcel.readInt() != 0;
    }
}
