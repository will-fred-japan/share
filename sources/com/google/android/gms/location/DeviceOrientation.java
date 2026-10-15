package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;
import p071j5.z;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class DeviceOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceOrientation> CREATOR = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f12701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f12702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f12703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte f12705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f12706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f12707g;

    public DeviceOrientation(float[] fArr, float f6, float f9, long j, byte b9, float f10, float f11) {
        if (!(fArr != null && fArr.length == 4)) {
            throw new IllegalArgumentException("Input attitude array should be of length 4.");
        }
        if (!((Float.isNaN(fArr[0]) || Float.isNaN(fArr[1]) || Float.isNaN(fArr[2]) || Float.isNaN(fArr[3])) ? false : true)) {
            throw new IllegalArgumentException("Input attitude cannot contain NaNs.");
        }
        if (f6 < 0.0f || f6 >= 360.0f) {
            throw new IllegalArgumentException();
        }
        if (f9 < 0.0f || f9 > 180.0f) {
            throw new IllegalArgumentException();
        }
        if (f11 < 0.0f || f11 > 180.0f) {
            throw new IllegalArgumentException();
        }
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        this.f12701a = fArr;
        this.f12702b = f6;
        this.f12703c = f9;
        this.f12706f = f10;
        this.f12707g = f11;
        this.f12704d = j;
        this.f12705e = (byte) (((byte) (((byte) (b9 | 16)) | 4)) | 8);
    }

    @Pure
    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DeviceOrientation) {
                DeviceOrientation deviceOrientation = (DeviceOrientation) obj;
                byte b9 = this.f12705e;
                boolean z8 = ((b9 & 32) != 0) == ((deviceOrientation.f12705e & 32) != 0) && ((b9 & 32) == 0 || Float.compare(this.f12706f, deviceOrientation.f12706f) == 0);
                boolean z9 = ((b9 & 64) != 0) == ((deviceOrientation.f12705e & 64) != 0) && ((b9 & 64) == 0 || Float.compare(this.f12707g, deviceOrientation.f12707g) == 0);
                if (Float.compare(this.f12702b, deviceOrientation.f12702b) != 0 || Float.compare(this.f12703c, deviceOrientation.f12703c) != 0 || !z8 || !z9 || this.f12704d != deviceOrientation.f12704d || !Arrays.equals(this.f12701a, deviceOrientation.f12701a)) {
                }
            }
            return false;
        }
        return true;
    }

    @Pure
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f12702b), Float.valueOf(this.f12703c), Float.valueOf(this.f12707g), Long.valueOf(this.f12704d), this.f12701a, Byte.valueOf(this.f12705e)});
    }

    @Pure
    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceOrientation[attitude=");
        sb.append(Arrays.toString(this.f12701a));
        sb.append(", headingDegrees=");
        sb.append(this.f12702b);
        sb.append(", headingErrorDegrees=");
        sb.append(this.f12703c);
        if ((this.f12705e & 64) != 0) {
            sb.append(", conservativeHeadingErrorDegrees=");
            sb.append(this.f12707g);
        }
        sb.append(", elapsedRealtimeNs=");
        sb.append(this.f12704d);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        float[] fArr = (float[]) this.f12701a.clone();
        int iU2 = b.U(parcel, 1);
        parcel.writeFloatArray(fArr);
        b.V(parcel, iU2);
        b.W(parcel, 4, 4);
        parcel.writeFloat(this.f12702b);
        b.W(parcel, 5, 4);
        parcel.writeFloat(this.f12703c);
        b.W(parcel, 6, 8);
        parcel.writeLong(this.f12704d);
        b.W(parcel, 7, 4);
        parcel.writeInt(this.f12705e);
        b.W(parcel, 8, 4);
        parcel.writeFloat(this.f12706f);
        b.W(parcel, 9, 4);
        parcel.writeFloat(this.f12707g);
        b.V(parcel, iU);
    }
}
