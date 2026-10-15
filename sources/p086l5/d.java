package p086l5;

import Q.a;
import Q4.O;
import android.os.Parcel;
import com.google.android.gms.signin.internal.zak;
import p041f5.b;
import p041f5.c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d extends b {
    @Override // p041f5.b
    public final boolean O(int i9, Parcel parcel, Parcel parcel2) {
        switch (i9) {
            case 3:
                c.b(parcel);
                break;
            case 4:
                c.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                c.b(parcel);
                break;
            case 7:
                c.b(parcel);
                break;
            case 8:
                zak zakVar = (zak) c.a(parcel, zak.CREATOR);
                c.b(parcel);
                O o2 = (O) this;
                o2.f3780b.post(new a(o2, zakVar, 1, false));
                break;
            case 9:
                c.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
