package com.google.android.gms.internal.location;

import R7.i;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.k;
import p056h5.B;
import p056h5.D;
import p056h5.E;
import p056h5.F;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new F();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final D f12637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zze f12638f;

    static {
        Process.myUid();
        Process.myPid();
    }

    public zze(int i9, String packageName, String str, String str2, ArrayList arrayList, zze zzeVar) {
        k.e(packageName, "packageName");
        if (zzeVar != null && zzeVar.f12638f != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f12633a = i9;
        this.f12634b = packageName;
        this.f12635c = str;
        if (str2 == null) {
            str2 = zzeVar != null ? zzeVar.f12636d : null;
        }
        this.f12636d = str2;
        List list = arrayList;
        if (arrayList == null) {
            D d9 = zzeVar != null ? zzeVar.f12637e : null;
            list = d9;
            if (d9 == null) {
                B b9 = D.f19051b;
                E e9 = E.f19052e;
                k.d(e9, "of(...)");
                list = e9;
            }
        }
        D dO = D.o(list);
        k.d(dO, "copyOf(...)");
        this.f12637e = dO;
        this.f12638f = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return this.f12633a == zzeVar.f12633a && k.a(this.f12634b, zzeVar.f12634b) && k.a(this.f12635c, zzeVar.f12635c) && k.a(this.f12636d, zzeVar.f12636d) && k.a(this.f12638f, zzeVar.f12638f) && k.a(this.f12637e, zzeVar.f12637e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12633a), this.f12634b, this.f12635c, this.f12636d, this.f12638f});
    }

    public final String toString() {
        String str = this.f12634b;
        int length = str.length() + 18;
        String str2 = this.f12635c;
        StringBuilder sb = new StringBuilder(length + (str2 != null ? str2.length() : 0));
        sb.append(this.f12633a);
        sb.append("/");
        sb.append(str);
        if (str2 != null) {
            sb.append("[");
            if (i.N(str2, str, false)) {
                sb.append((CharSequence) str2, str.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        String str3 = this.f12636d;
        if (str3 != null) {
            sb.append("/");
            sb.append(Integer.toHexString(str3.hashCode()));
        }
        String string = sb.toString();
        k.d(string, "toString(...)");
        return string;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i9) {
        k.e(dest, "dest");
        int iU = b.U(dest, 20293);
        b.W(dest, 1, 4);
        dest.writeInt(this.f12633a);
        b.Q(dest, 3, this.f12634b);
        b.Q(dest, 4, this.f12635c);
        b.Q(dest, 6, this.f12636d);
        b.P(dest, 7, this.f12638f, i9);
        b.T(dest, 8, this.f12637e);
        b.V(dest, iU);
    }
}
