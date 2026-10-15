package S4;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class N implements Parcelable.Creator {
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(getServiceRequest.f12505a);
        p199z2.b.W(parcel, 2, 4);
        parcel.writeInt(getServiceRequest.f12506b);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(getServiceRequest.f12507c);
        p199z2.b.Q(parcel, 4, getServiceRequest.f12508d);
        p199z2.b.N(parcel, 5, getServiceRequest.f12509e);
        p199z2.b.S(parcel, 6, getServiceRequest.f12510f, i9);
        p199z2.b.M(parcel, 7, getServiceRequest.f12511g);
        p199z2.b.P(parcel, 8, getServiceRequest.f12512h, i9);
        p199z2.b.S(parcel, 10, getServiceRequest.f12513i, i9);
        p199z2.b.S(parcel, 11, getServiceRequest.j, i9);
        p199z2.b.W(parcel, 12, 4);
        parcel.writeInt(getServiceRequest.f12514k ? 1 : 0);
        p199z2.b.W(parcel, 13, 4);
        parcel.writeInt(getServiceRequest.f12515l);
        boolean z8 = getServiceRequest.f12516m;
        p199z2.b.W(parcel, 14, 4);
        parcel.writeInt(z8 ? 1 : 0);
        p199z2.b.Q(parcel, 15, getServiceRequest.f12517n);
        p199z2.b.V(parcel, iU);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = T4.a.s(parcel);
        Scope[] scopeArr = GetServiceRequest.f12503o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f12504p;
        Feature[] featureArr2 = featureArr;
        String strF = null;
        IBinder iBinderM = null;
        Account account = null;
        String strF2 = null;
        int iN = 0;
        int iN2 = 0;
        int iN3 = 0;
        boolean zK = false;
        int iN4 = 0;
        boolean zK2 = false;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            switch ((char) i9) {
                case 1:
                    iN = T4.a.n(parcel, i9);
                    break;
                case 2:
                    iN2 = T4.a.n(parcel, i9);
                    break;
                case 3:
                    iN3 = T4.a.n(parcel, i9);
                    break;
                case 4:
                    strF = T4.a.f(parcel, i9);
                    break;
                case 5:
                    iBinderM = T4.a.m(parcel, i9);
                    break;
                case 6:
                    scopeArr = (Scope[]) T4.a.h(parcel, i9, Scope.CREATOR);
                    break;
                case 7:
                    bundle = T4.a.b(parcel, i9);
                    break;
                case '\b':
                    account = (Account) T4.a.e(parcel, i9, Account.CREATOR);
                    break;
                case '\t':
                default:
                    T4.a.r(parcel, i9);
                    break;
                case '\n':
                    featureArr = (Feature[]) T4.a.h(parcel, i9, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) T4.a.h(parcel, i9, Feature.CREATOR);
                    break;
                case '\f':
                    zK = T4.a.k(parcel, i9);
                    break;
                case '\r':
                    iN4 = T4.a.n(parcel, i9);
                    break;
                case 14:
                    zK2 = T4.a.k(parcel, i9);
                    break;
                case 15:
                    strF2 = T4.a.f(parcel, i9);
                    break;
            }
        }
        T4.a.j(parcel, iS);
        return new GetServiceRequest(iN, iN2, iN3, strF, iBinderM, scopeArr, bundle, account, featureArr, featureArr2, zK, iN4, zK2, strF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new GetServiceRequest[i9];
    }
}
