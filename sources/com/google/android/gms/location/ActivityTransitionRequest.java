package com.google.android.gms.location;

import D2.a;
import S4.C0375f;
import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import p071j5.v;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new v();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12684e = new a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f12687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12688d;

    public ActivityTransitionRequest(ArrayList arrayList, String str, ArrayList arrayList2, String str2) {
        C0376g.f(arrayList, "transitions can't be null");
        C0376g.a("transitions can't be empty.", !arrayList.isEmpty());
        TreeSet treeSet = new TreeSet(f12684e);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ActivityTransition activityTransition = (ActivityTransition) it.next();
            C0376g.a(String.format("Found duplicated transition: %s.", activityTransition), treeSet.add(activityTransition));
        }
        this.f12685a = Collections.unmodifiableList(arrayList);
        this.f12686b = str;
        this.f12687c = arrayList2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList2);
        this.f12688d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (C0375f.a(this.f12685a, activityTransitionRequest.f12685a) && C0375f.a(this.f12686b, activityTransitionRequest.f12686b) && C0375f.a(this.f12688d, activityTransitionRequest.f12688d) && C0375f.a(this.f12687c, activityTransitionRequest.f12687c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f12685a.hashCode() * 31;
        String str = this.f12686b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.f12687c;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f12688d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f12685a);
        String strValueOf2 = String.valueOf(this.f12687c);
        int length = strValueOf.length();
        String str = this.f12686b;
        int length2 = String.valueOf(str).length();
        int length3 = strValueOf2.length();
        String str2 = this.f12688d;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 12 + length3 + 18 + String.valueOf(str2).length() + 1);
        H2.a.j(sb, "ActivityTransitionRequest [mTransitions=", strValueOf, ", mTag='", str);
        H2.a.j(sb, "', mClients=", strValueOf2, ", mAttributionTag=", str2);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.T(parcel, 1, this.f12685a);
        b.Q(parcel, 2, this.f12686b);
        b.T(parcel, 3, this.f12687c);
        b.Q(parcel, 4, this.f12688d);
        b.V(parcel, iU);
    }
}
