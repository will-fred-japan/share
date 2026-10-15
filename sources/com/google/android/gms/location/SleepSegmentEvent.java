package com.google.android.gms.location;

import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p071j5.o;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class SleepSegmentEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12761e;

    public SleepSegmentEvent(long j, long j8, int i9, int i10, int i11) {
        C0376g.a("endTimeMillis must be greater than or equal to startTimeMillis", j <= j8);
        this.f12757a = j;
        this.f12758b = j8;
        this.f12759c = i9;
        this.f12760d = i10;
        this.f12761e = i11;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.f12757a == sleepSegmentEvent.f12757a && this.f12758b == sleepSegmentEvent.f12758b && this.f12759c == sleepSegmentEvent.f12759c && this.f12760d == sleepSegmentEvent.f12760d && this.f12761e == sleepSegmentEvent.f12761e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f12757a), Long.valueOf(this.f12758b), Integer.valueOf(this.f12759c)});
    }

    public final String toString() {
        long j = this.f12757a;
        int length = String.valueOf(j).length();
        long j8 = this.f12758b;
        int length2 = String.valueOf(j8).length();
        int i9 = this.f12759c;
        StringBuilder sb = new StringBuilder(length + 24 + length2 + 9 + String.valueOf(i9).length());
        sb.append("startMillis=");
        sb.append(j);
        sb.append(", endMillis=");
        sb.append(j8);
        sb.append(", status=");
        sb.append(i9);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        C0376g.e(parcel);
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 8);
        parcel.writeLong(this.f12757a);
        b.W(parcel, 2, 8);
        parcel.writeLong(this.f12758b);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12759c);
        b.W(parcel, 4, 4);
        parcel.writeInt(this.f12760d);
        b.W(parcel, 5, 4);
        parcel.writeInt(this.f12761e);
        b.V(parcel, iU);
    }
}
