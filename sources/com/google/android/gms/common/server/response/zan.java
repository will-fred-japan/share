package com.google.android.gms.common.server.response;

import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new Z4.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f12603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12604c;

    public zan(int i9, String str, ArrayList arrayList) {
        this.f12602a = i9;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            zal zalVar = (zal) arrayList.get(i10);
            String str2 = zalVar.f12597b;
            HashMap map2 = new HashMap();
            ArrayList arrayList2 = zalVar.f12598c;
            C0376g.e(arrayList2);
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                zam zamVar = (zam) arrayList2.get(i11);
                map2.put(zamVar.f12600b, zamVar.f12601c);
            }
            map.put(str2, map2);
        }
        this.f12603b = map;
        C0376g.e(str);
        this.f12604c = str;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Map map3 = (Map) map.get((String) it.next());
            Iterator it2 = map3.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse.Field) map3.get((String) it2.next())).j = this;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        HashMap map = this.f12603b;
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map2 = (Map) map.get(str);
            for (String str2 : map2.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map2.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12602a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f12603b;
        for (String str : map.keySet()) {
            arrayList.add(new zal(str, (Map) map.get(str)));
        }
        p199z2.b.T(parcel, 2, arrayList);
        p199z2.b.Q(parcel, 3, this.f12604c);
        p199z2.b.V(parcel, iU);
    }
}
