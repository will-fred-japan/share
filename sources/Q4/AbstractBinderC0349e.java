package Q4;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import p056h5.BinderC0603j;

/* JADX INFO: renamed from: Q4.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0349e extends p041f5.b {
    @Override // p041f5.b
    public final boolean O(int i9, Parcel parcel, Parcel parcel2) {
        if (i9 != 1) {
            return false;
        }
        Status status = (Status) p041f5.c.a(parcel, Status.CREATOR);
        p041f5.c.b(parcel);
        BinderC0603j binderC0603j = (BinderC0603j) this;
        C0359o.a(status, binderC0603j.f19070a, binderC0603j.f19071b);
        return true;
    }
}
