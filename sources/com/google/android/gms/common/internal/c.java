package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends p048g5.a implements b {
    @Override // com.google.android.gms.common.internal.b
    public final Account B() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f18877c);
        Parcel parcelY = y(parcelObtain, 2);
        Account account = (Account) p048g5.c.a(parcelY, Account.CREATOR);
        parcelY.recycle();
        return account;
    }
}
