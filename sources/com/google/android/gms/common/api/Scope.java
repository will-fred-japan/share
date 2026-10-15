package com.google.android.gms.common.api;

import P4.k;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12464b;

    public Scope(int i9, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("scopeUri must not be null or empty");
        }
        this.f12463a = i9;
        this.f12464b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f12464b.equals(((Scope) obj).f12464b);
    }

    public final int hashCode() {
        return this.f12464b.hashCode();
    }

    public final String toString() {
        return this.f12464b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12463a);
        b.Q(parcel, 2, this.f12464b);
        b.V(parcel, iU);
    }
}
