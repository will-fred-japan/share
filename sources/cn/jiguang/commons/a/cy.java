package cn.jiguang.commons.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class cy extends Binder implements cz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cx f9857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9858b = true;

    public cy(cx cxVar, boolean z8) {
        this.f9857a = cxVar;
        attachInterface(this, jr.a(cx.f9849b));
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
        if (i9 != 2) {
            if (i9 != 1598968902) {
                return super.onTransact(i9, parcel, parcel2, i10);
            }
            parcel2.writeString(jr.a(cx.f9849b));
            return true;
        }
        parcel.enforceInterface(jr.a(cx.f9849b));
        int i11 = parcel.readInt();
        Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
        if (i11 == 0 && bundle != null && this.f9858b) {
            String string = bundle.getString(jr.a(cx.f9852e));
            if (!TextUtils.isEmpty(string)) {
                this.f9857a.f9854g = string;
                ee.a("IDUtils", "get oaid from callback: " + this.f9857a.f9854g);
            }
        }
        this.f9857a.f9855h.countDown();
        parcel2.writeNoException();
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
