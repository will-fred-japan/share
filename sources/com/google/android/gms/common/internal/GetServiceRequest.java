package com.google.android.gms.common.internal;

import S4.N;
import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new N();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope[] f12503o = new Scope[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Feature[] f12504p = new Feature[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBinder f12509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scope[] f12510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f12511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Account f12512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Feature[] f12513i;
    public Feature[] j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f12514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f12515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f12517n;

    public GetServiceRequest(int i9, int i10, int i11, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z8, int i12, boolean z9, String str2) {
        scopeArr = scopeArr == null ? f12503o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = f12504p;
        featureArr = featureArr == null ? featureArr3 : featureArr;
        featureArr2 = featureArr2 == null ? featureArr3 : featureArr2;
        this.f12505a = i9;
        this.f12506b = i10;
        this.f12507c = i11;
        if ("com.google.android.gms".equals(str)) {
            this.f12508d = "com.google.android.gms";
        } else {
            this.f12508d = str;
        }
        if (i9 < 2) {
            Account accountB = null;
            if (iBinder != null) {
                int i13 = b.a.f12535b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                b cVar = iInterfaceQueryLocalInterface instanceof b ? (b) iInterfaceQueryLocalInterface : new c(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 0);
                int i14 = a.f12534c;
                if (cVar != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            accountB = cVar.B();
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                        }
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        throw th;
                    }
                }
            }
            this.f12512h = accountB;
        } else {
            this.f12509e = iBinder;
            this.f12512h = account;
        }
        this.f12510f = scopeArr;
        this.f12511g = bundle;
        this.f12513i = featureArr;
        this.j = featureArr2;
        this.f12514k = z8;
        this.f12515l = i12;
        this.f12516m = z9;
        this.f12517n = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        N.a(this, parcel, i9);
    }
}
