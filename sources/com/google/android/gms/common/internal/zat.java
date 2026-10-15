package com.google.android.gms.common.internal;

import S4.C0388t;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new C0388t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Account f12537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GoogleSignInAccount f12539d;

    public zat(int i9, Account account, int i10, GoogleSignInAccount googleSignInAccount) {
        this.f12536a = i9;
        this.f12537b = account;
        this.f12538c = i10;
        this.f12539d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12536a);
        p199z2.b.P(parcel, 2, this.f12537b, i9);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(this.f12538c);
        p199z2.b.P(parcel, 4, this.f12539d, i9);
        p199z2.b.V(parcel, iU);
    }
}
