package com.google.android.gms.location;

import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p071j5.n;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class SleepClassifyEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new n();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12756i;

    public SleepClassifyEvent(int i9, int i10, int i11, int i12, int i13, int i14, int i15, boolean z8, int i16) {
        this.f12748a = i9;
        this.f12749b = i10;
        this.f12750c = i11;
        this.f12751d = i12;
        this.f12752e = i13;
        this.f12753f = i14;
        this.f12754g = i15;
        this.f12755h = z8;
        this.f12756i = i16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        return this.f12748a == sleepClassifyEvent.f12748a && this.f12749b == sleepClassifyEvent.f12749b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f12748a), Integer.valueOf(this.f12749b)});
    }

    public final String toString() {
        int i9 = this.f12748a;
        int length = String.valueOf(i9).length();
        int i10 = this.f12749b;
        int length2 = String.valueOf(i10).length();
        int i11 = this.f12750c;
        int length3 = String.valueOf(i11).length();
        int i12 = this.f12751d;
        StringBuilder sb = new StringBuilder(length + 6 + length2 + 8 + length3 + 7 + String.valueOf(i12).length());
        sb.append(i9);
        sb.append(" Conf:");
        sb.append(i10);
        sb.append(" Motion:");
        sb.append(i11);
        sb.append(" Light:");
        sb.append(i12);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12748a);
        b.W(parcel, 2, 4);
        parcel.writeInt(this.f12749b);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12750c);
        b.W(parcel, 4, 4);
        parcel.writeInt(this.f12751d);
        b.W(parcel, 5, 4);
        parcel.writeInt(this.f12752e);
        b.W(parcel, 6, 4);
        parcel.writeInt(this.f12753f);
        b.W(parcel, 7, 4);
        parcel.writeInt(this.f12754g);
        b.W(parcel, 8, 4);
        parcel.writeInt(this.f12755h ? 1 : 0);
        b.W(parcel, 9, 4);
        parcel.writeInt(this.f12756i);
        b.V(parcel, iU);
    }
}
