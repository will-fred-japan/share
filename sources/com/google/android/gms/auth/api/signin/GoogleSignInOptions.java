package com.google.android.gms.auth.api.signin;

import M4.b;
import P4.a;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements a.c, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f12438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Account f12439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f12443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f12444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f12445i;
    public final String j;

    static {
        Scope scope = new Scope(1, "profile");
        new Scope(1, "email");
        Scope scope2 = new Scope(1, "openid");
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        Scope scope4 = new Scope(1, "https://www.googleapis.com/auth/games");
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(scope4) && hashSet.contains(scope3)) {
            hashSet.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(scope4) && hashSet2.contains(scope3)) {
            hashSet2.remove(scope3);
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new b();
    }

    public GoogleSignInOptions(int i9, ArrayList arrayList, Account account, boolean z8, boolean z9, boolean z10, String str, String str2, HashMap map, String str3) {
        this.f12437a = i9;
        this.f12438b = arrayList;
        this.f12439c = account;
        this.f12440d = z8;
        this.f12441e = z9;
        this.f12442f = z10;
        this.f12443g = str;
        this.f12444h = str2;
        this.f12445i = new ArrayList(map.values());
        this.j = str3;
    }

    public final boolean equals(Object obj) {
        String str = this.f12443g;
        ArrayList arrayList = this.f12438b;
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            ArrayList arrayList2 = googleSignInOptions.f12438b;
            String str2 = googleSignInOptions.f12443g;
            Account account = googleSignInOptions.f12439c;
            if (this.f12445i.isEmpty() && googleSignInOptions.f12445i.isEmpty() && arrayList.size() == new ArrayList(arrayList2).size() && arrayList.containsAll(new ArrayList(arrayList2))) {
                Account account2 = this.f12439c;
                if (account2 == null) {
                    if (account != null) {
                        return false;
                    }
                } else if (!account2.equals(account)) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        return false;
                    }
                } else if (!str.equals(str2)) {
                    return false;
                }
                return this.f12442f == googleSignInOptions.f12442f && this.f12440d == googleSignInOptions.f12440d && this.f12441e == googleSignInOptions.f12441e && TextUtils.equals(this.j, googleSignInOptions.j);
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f12438b;
        int size = arrayList2.size();
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.add(((Scope) arrayList2.get(i9)).f12464b);
        }
        Collections.sort(arrayList);
        int iHashCode = arrayList.hashCode() + (1 * 31);
        Account account = this.f12439c;
        int iHashCode2 = (iHashCode * 31) + (account == null ? 0 : account.hashCode());
        String str = this.f12443g;
        int iHashCode3 = (((((((iHashCode2 * 31) + (str == null ? 0 : str.hashCode())) * 31) + (this.f12442f ? 1 : 0)) * 31) + (this.f12440d ? 1 : 0)) * 31) + (this.f12441e ? 1 : 0);
        String str2 = this.j;
        return (iHashCode3 * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12437a);
        p199z2.b.T(parcel, 2, new ArrayList(this.f12438b));
        p199z2.b.P(parcel, 3, this.f12439c, i9);
        p199z2.b.W(parcel, 4, 4);
        parcel.writeInt(this.f12440d ? 1 : 0);
        p199z2.b.W(parcel, 5, 4);
        parcel.writeInt(this.f12441e ? 1 : 0);
        p199z2.b.W(parcel, 6, 4);
        parcel.writeInt(this.f12442f ? 1 : 0);
        p199z2.b.Q(parcel, 7, this.f12443g);
        p199z2.b.Q(parcel, 8, this.f12444h);
        p199z2.b.T(parcel, 9, this.f12445i);
        p199z2.b.Q(parcel, 10, this.j);
        p199z2.b.V(parcel, iU);
    }
}
