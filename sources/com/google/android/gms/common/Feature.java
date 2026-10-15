package com.google.android.gms.common;

import O4.j;
import S4.C0375f;
import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public final int f12455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12456c;

    public Feature(String str, int i9, long j) {
        this.f12454a = str;
        this.f12455b = i9;
        this.f12456c = j;
    }

    public final long d() {
        long j = this.f12456c;
        return j == -1 ? this.f12455b : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.f12454a;
            if (((str != null && str.equals(feature.f12454a)) || (str == null && feature.f12454a == null)) && d() == feature.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12454a, Long.valueOf(d())});
    }

    public final String toString() {
        C0375f.a aVar = new C0375f.a(this);
        aVar.a(this.f12454a, MTCommonConstants.Network.KEY_NAME);
        aVar.a(Long.valueOf(d()), "version");
        return aVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.Q(parcel, 1, this.f12454a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12455b);
        long jD = d();
        b.W(parcel, 3, 8);
        parcel.writeLong(jD);
        b.V(parcel, iU);
    }

    public Feature(String str, long j) {
        this.f12454a = str;
        this.f12456c = j;
        this.f12455b = -1;
    }
}
