package com.google.android.gms.auth.api.signin;

import M4.a;
import S4.C0376g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f12430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f12431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f12432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f12433i;
    public final ArrayList j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f12434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f12435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashSet f12436m = new HashSet();

    public GoogleSignInAccount(int i9, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.f12425a = i9;
        this.f12426b = str;
        this.f12427c = str2;
        this.f12428d = str3;
        this.f12429e = str4;
        this.f12430f = uri;
        this.f12431g = str5;
        this.f12432h = j;
        this.f12433i = str6;
        this.j = arrayList;
        this.f12434k = str7;
        this.f12435l = str8;
    }

    public static GoogleSignInAccount e(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i9 = 0; i9 < length; i9++) {
            hashSet.add(new Scope(1, jSONArray.getString(i9)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        C0376g.d(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.f12431g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final HashSet d() {
        HashSet hashSet = new HashSet(this.j);
        hashSet.addAll(this.f12436m);
        return hashSet;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f12433i.equals(this.f12433i) && googleSignInAccount.d().equals(d());
    }

    public final int hashCode() {
        return ((this.f12433i.hashCode() + 527) * 31) + d().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12425a);
        b.Q(parcel, 2, this.f12426b);
        b.Q(parcel, 3, this.f12427c);
        b.Q(parcel, 4, this.f12428d);
        b.Q(parcel, 5, this.f12429e);
        b.P(parcel, 6, this.f12430f, i9);
        b.Q(parcel, 7, this.f12431g);
        b.W(parcel, 8, 8);
        parcel.writeLong(this.f12432h);
        b.Q(parcel, 9, this.f12433i);
        b.T(parcel, 10, this.j);
        b.Q(parcel, 11, this.f12434k);
        b.Q(parcel, 12, this.f12435l);
        b.V(parcel, iU);
    }
}
