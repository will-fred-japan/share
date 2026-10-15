package S4;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: renamed from: S4.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0388t implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        Account account = null;
        int iN = 0;
        int iN2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                iN = T4.a.n(parcel, i9);
            } else if (c5 == 2) {
                account = (Account) T4.a.e(parcel, i9, Account.CREATOR);
            } else if (c5 == 3) {
                iN2 = T4.a.n(parcel, i9);
            } else if (c5 != 4) {
                T4.a.r(parcel, i9);
            } else {
                googleSignInAccount = (GoogleSignInAccount) T4.a.e(parcel, i9, GoogleSignInAccount.CREATOR);
            }
        }
        T4.a.j(parcel, iS);
        return new zat(iN, account, iN2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new zat[i9];
    }
}
