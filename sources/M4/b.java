package M4;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        ArrayList<GoogleSignInOptionsExtensionParcelable> arrayListI = null;
        ArrayList arrayListI2 = null;
        Account account = null;
        String strF = null;
        String strF2 = null;
        String strF3 = null;
        int iN = 0;
        boolean zK = false;
        boolean zK2 = false;
        boolean zK3 = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN = T4.a.n(parcel, i9);
                    break;
                case 2:
                    arrayListI2 = T4.a.i(parcel, i9, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) T4.a.e(parcel, i9, Account.CREATOR);
                    break;
                case 4:
                    zK = T4.a.k(parcel, i9);
                    break;
                case 5:
                    zK2 = T4.a.k(parcel, i9);
                    break;
                case 6:
                    zK3 = T4.a.k(parcel, i9);
                    break;
                case 7:
                    strF = T4.a.f(parcel, i9);
                    break;
                case '\b':
                    strF2 = T4.a.f(parcel, i9);
                    break;
                case '\t':
                    arrayListI = T4.a.i(parcel, i9, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case '\n':
                    strF3 = T4.a.f(parcel, i9);
                    break;
                default:
                    T4.a.r(parcel, i9);
                    break;
            }
        }
        T4.a.j(parcel, iS);
        HashMap map = new HashMap();
        if (arrayListI != null) {
            for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : arrayListI) {
                map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.f12447b), googleSignInOptionsExtensionParcelable);
            }
        }
        return new GoogleSignInOptions(iN, arrayListI2, account, zK, zK2, zK3, strF, strF2, map, strF3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new GoogleSignInOptions[i9];
    }
}
