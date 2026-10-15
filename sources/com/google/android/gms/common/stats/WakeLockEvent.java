package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import p003a5.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f12612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f12613i;
    public final long j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f12614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f12615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f12616m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f12617n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f12618o;

    public WakeLockEvent(int i9, long j, int i10, String str, int i11, ArrayList arrayList, String str2, long j8, int i12, String str3, String str4, float f6, long j9, String str5, boolean z8) {
        this.f12605a = i9;
        this.f12606b = j;
        this.f12607c = i10;
        this.f12608d = str;
        this.f12609e = str3;
        this.f12610f = str5;
        this.f12611g = i11;
        this.f12612h = arrayList;
        this.f12613i = str2;
        this.j = j8;
        this.f12614k = i12;
        this.f12615l = str4;
        this.f12616m = f6;
        this.f12617n = j9;
        this.f12618o = z8;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int d() {
        return this.f12607c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long e() {
        return this.f12606b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String j() {
        ArrayList arrayList = this.f12612h;
        String strJoin = arrayList == null ? "" : TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList);
        StringBuilder sb = new StringBuilder("\t");
        sb.append(this.f12608d);
        sb.append("\t");
        sb.append(this.f12611g);
        sb.append("\t");
        sb.append(strJoin);
        sb.append("\t");
        sb.append(this.f12614k);
        sb.append("\t");
        String str = this.f12609e;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append("\t");
        String str2 = this.f12615l;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append("\t");
        sb.append(this.f12616m);
        sb.append("\t");
        String str3 = this.f12610f;
        sb.append(str3 != null ? str3 : "");
        sb.append("\t");
        sb.append(this.f12618o);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        p199z2.b.W(parcel, 1, 4);
        parcel.writeInt(this.f12605a);
        p199z2.b.W(parcel, 2, 8);
        parcel.writeLong(this.f12606b);
        p199z2.b.Q(parcel, 4, this.f12608d);
        p199z2.b.W(parcel, 5, 4);
        parcel.writeInt(this.f12611g);
        p199z2.b.R(parcel, 6, this.f12612h);
        p199z2.b.W(parcel, 8, 8);
        parcel.writeLong(this.j);
        p199z2.b.Q(parcel, 10, this.f12609e);
        p199z2.b.W(parcel, 11, 4);
        parcel.writeInt(this.f12607c);
        p199z2.b.Q(parcel, 12, this.f12613i);
        p199z2.b.Q(parcel, 13, this.f12615l);
        p199z2.b.W(parcel, 14, 4);
        parcel.writeInt(this.f12614k);
        p199z2.b.W(parcel, 15, 4);
        parcel.writeFloat(this.f12616m);
        p199z2.b.W(parcel, 16, 8);
        parcel.writeLong(this.f12617n);
        p199z2.b.Q(parcel, 17, this.f12610f);
        p199z2.b.W(parcel, 18, 4);
        parcel.writeInt(this.f12618o ? 1 : 0);
        p199z2.b.V(parcel, iU);
    }
}
