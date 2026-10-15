package M4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        String strF = null;
        String strF2 = null;
        String strF3 = null;
        String strF4 = null;
        Uri uri = null;
        String strF5 = null;
        String strF6 = null;
        ArrayList arrayListI = null;
        String strF7 = null;
        String strF8 = null;
        long jO = 0;
        int iN = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN = T4.a.n(parcel, i9);
                    break;
                case 2:
                    strF = T4.a.f(parcel, i9);
                    break;
                case 3:
                    strF2 = T4.a.f(parcel, i9);
                    break;
                case 4:
                    strF3 = T4.a.f(parcel, i9);
                    break;
                case 5:
                    strF4 = T4.a.f(parcel, i9);
                    break;
                case 6:
                    uri = (Uri) T4.a.e(parcel, i9, Uri.CREATOR);
                    break;
                case 7:
                    strF5 = T4.a.f(parcel, i9);
                    break;
                case '\b':
                    jO = T4.a.o(parcel, i9);
                    break;
                case '\t':
                    strF6 = T4.a.f(parcel, i9);
                    break;
                case '\n':
                    arrayListI = T4.a.i(parcel, i9, Scope.CREATOR);
                    break;
                case 11:
                    strF7 = T4.a.f(parcel, i9);
                    break;
                case '\f':
                    strF8 = T4.a.f(parcel, i9);
                    break;
                default:
                    T4.a.r(parcel, i9);
                    break;
            }
        }
        T4.a.j(parcel, iS);
        return new GoogleSignInAccount(iN, strF, strF2, strF3, strF4, uri, strF5, jO, strF6, arrayListI, strF7, strF8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new GoogleSignInAccount[i9];
    }
}
