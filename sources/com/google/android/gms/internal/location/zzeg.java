package com.google.android.gms.internal.location;

import S4.C0375f;
import S4.C0376g;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import android.util.Log;
import b5.c;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import p011b4.h;
import p056h5.t;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzeg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeg> CREATOR = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocationRequest f12644a;

    /* JADX WARN: Code duplicated, block: B:100:0x0162  */
    /* JADX WARN: Code duplicated, block: B:102:0x0166  */
    /* JADX WARN: Code duplicated, block: B:107:0x0174  */
    /* JADX WARN: Code duplicated, block: B:108:0x0176  */
    /* JADX WARN: Code duplicated, block: B:110:0x017a  */
    /* JADX WARN: Code duplicated, block: B:111:0x017d  */
    /* JADX WARN: Code duplicated, block: B:114:0x018b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0136 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00de  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:71:0x010b  */
    /* JADX WARN: Code duplicated, block: B:73:0x010f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0122  */
    /* JADX WARN: Code duplicated, block: B:86:0x013f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0147  */
    /* JADX WARN: Code duplicated, block: B:90:0x014a  */
    /* JADX WARN: Code duplicated, block: B:92:0x014e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0150  */
    /* JADX WARN: Code duplicated, block: B:95:0x0154  */
    /* JADX WARN: Code duplicated, block: B:98:0x015e  */
    public zzeg(LocationRequest locationRequest, ArrayList arrayList, boolean z8, boolean z9, boolean z10, boolean z11, long j) {
        long j8;
        int i9;
        boolean z12;
        int i10;
        int i11;
        boolean z13;
        int i12;
        zze zzeVar;
        float f6;
        long j9;
        WorkSource workSource;
        boolean z14;
        long jMin;
        boolean z15;
        WorkSource workSource2;
        Iterator it;
        ClientIdentity clientIdentity;
        int i13;
        Method method;
        Method method2;
        int i14 = locationRequest.f12722a;
        long j10 = locationRequest.f12723b;
        C0376g.a("intervalMillis must be greater than or equal to 0", j10 >= 0);
        h.I(i14);
        long j11 = locationRequest.f12724c;
        C0376g.a("minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL", j11 == -1 || j11 >= 0);
        long j12 = locationRequest.f12725d;
        C0376g.a("maxUpdateDelayMillis must be greater than or equal to 0", j12 >= 0);
        long j13 = locationRequest.f12726e;
        C0376g.a("durationMillis must be greater than 0", j13 > 0);
        int i15 = locationRequest.f12727f;
        C0376g.a("maxUpdates must be greater than 0", i15 > 0);
        float f9 = locationRequest.f12728g;
        C0376g.a("minUpdateDistanceMeters must be greater than or equal to 0", f9 >= 0.0f);
        boolean z16 = locationRequest.f12729h;
        long j14 = locationRequest.f12730i;
        C0376g.a("maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE", j14 == -1 || j14 >= 0);
        int i16 = locationRequest.j;
        if (i16 != 0) {
            j8 = j13;
            if (i16 != 1) {
                if (i16 == 2) {
                    z12 = true;
                    i9 = 2;
                } else {
                    i9 = i16;
                    z12 = false;
                }
            }
            C0376g.b(z12, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i9));
            i10 = locationRequest.f12731k;
            if (i10 == 0 && i10 != 1) {
                if (i10 == 2) {
                    i11 = 2;
                } else {
                    i11 = i10;
                    z13 = false;
                }
                i12 = i10;
                C0376g.b(z13, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i11));
                zzeVar = locationRequest.f12734n;
                if (zzeVar == null && zzeVar.f12638f != null) {
                    throw new IllegalArgumentException();
                }
                if (arrayList != null) {
                    if (arrayList.isEmpty()) {
                        workSource = null;
                    } else {
                        workSource2 = new WorkSource();
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            clientIdentity = (ClientIdentity) it.next();
                            Iterator it2 = it;
                            i13 = clientIdentity.f12495a;
                            method = c.f8591b;
                            float f10 = f9;
                            long j15 = j14;
                            if (method != null) {
                                String str = clientIdentity.f12496b;
                                try {
                                    method.invoke(workSource2, Integer.valueOf(i13), str == null ? "" : str);
                                } catch (Exception e9) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e9);
                                }
                            } else {
                                method2 = c.f8590a;
                                if (method2 != null) {
                                    try {
                                        method2.invoke(workSource2, Integer.valueOf(i13));
                                    } catch (Exception e10) {
                                        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
                                    }
                                }
                            }
                            it = it2;
                            f9 = f10;
                            j14 = j15;
                        }
                        workSource = workSource2;
                    }
                    f6 = f9;
                    j9 = j14;
                } else {
                    f6 = f9;
                    j9 = j14;
                    workSource = locationRequest.f12733m;
                }
                i16 = z8 ? 1 : i16;
                i12 = z9 ? 2 : i12;
                if (z10) {
                    z14 = true;
                } else {
                    z14 = locationRequest.f12732l;
                }
                z16 = z11 ? true : z16;
                if (j != Long.MAX_VALUE) {
                    if (j != -1 || j >= 0) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    C0376g.a("maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE", z15);
                    j9 = j;
                }
                if (j11 == -1) {
                    jMin = j10;
                } else if (i14 == 105) {
                    jMin = j11;
                } else {
                    jMin = Math.min(j11, j10);
                }
                this.f12644a = new LocationRequest(i14, j10, jMin, Math.max(j12, j10), Long.MAX_VALUE, j8, i15, f6, z16, j9 == -1 ? j10 : j9, i16, i12, z14, new WorkSource(workSource), null);
            }
            i11 = i10;
            z13 = true;
            i12 = i10;
            C0376g.b(z13, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i11));
            zzeVar = locationRequest.f12734n;
            if (zzeVar == null) {
            }
            if (arrayList != null) {
                if (arrayList.isEmpty()) {
                    workSource = null;
                } else {
                    workSource2 = new WorkSource();
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        clientIdentity = (ClientIdentity) it.next();
                        Iterator it3 = it;
                        i13 = clientIdentity.f12495a;
                        method = c.f8591b;
                        float f11 = f9;
                        long j16 = j14;
                        if (method != null) {
                            String str2 = clientIdentity.f12496b;
                            method.invoke(workSource2, Integer.valueOf(i13), str2 == null ? "" : str2);
                        } else {
                            method2 = c.f8590a;
                            if (method2 != null) {
                                method2.invoke(workSource2, Integer.valueOf(i13));
                            }
                        }
                        it = it3;
                        f9 = f11;
                        j14 = j16;
                    }
                    workSource = workSource2;
                }
                f6 = f9;
                j9 = j14;
            } else {
                f6 = f9;
                j9 = j14;
                workSource = locationRequest.f12733m;
            }
            if (z8) {
            }
            if (z9) {
            }
            if (z10) {
                z14 = true;
            } else {
                z14 = locationRequest.f12732l;
            }
            if (z11) {
            }
            if (j != Long.MAX_VALUE) {
                if (j != -1) {
                    z15 = true;
                } else {
                    z15 = true;
                }
                C0376g.a("maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE", z15);
                j9 = j;
            }
            if (j11 == -1) {
                jMin = j10;
            } else if (i14 == 105) {
                jMin = j11;
            } else {
                jMin = Math.min(j11, j10);
            }
            this.f12644a = new LocationRequest(i14, j10, jMin, Math.max(j12, j10), Long.MAX_VALUE, j8, i15, f6, z16, j9 == -1 ? j10 : j9, i16, i12, z14, new WorkSource(workSource), null);
        }
        j8 = j13;
        i9 = i16;
        z12 = true;
        C0376g.b(z12, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i9));
        i10 = locationRequest.f12731k;
        if (i10 == 0) {
            i11 = i10;
            z13 = true;
        } else {
            i11 = i10;
            z13 = true;
        }
        i12 = i10;
        C0376g.b(z13, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i11));
        zzeVar = locationRequest.f12734n;
        if (zzeVar == null) {
        }
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                workSource = null;
            } else {
                workSource2 = new WorkSource();
                it = arrayList.iterator();
                while (it.hasNext()) {
                    clientIdentity = (ClientIdentity) it.next();
                    Iterator it4 = it;
                    i13 = clientIdentity.f12495a;
                    method = c.f8591b;
                    float f12 = f9;
                    long j17 = j14;
                    if (method != null) {
                        String str3 = clientIdentity.f12496b;
                        method.invoke(workSource2, Integer.valueOf(i13), str3 == null ? "" : str3);
                    } else {
                        method2 = c.f8590a;
                        if (method2 != null) {
                            method2.invoke(workSource2, Integer.valueOf(i13));
                        }
                    }
                    it = it4;
                    f9 = f12;
                    j14 = j17;
                }
                workSource = workSource2;
            }
            f6 = f9;
            j9 = j14;
        } else {
            f6 = f9;
            j9 = j14;
            workSource = locationRequest.f12733m;
        }
        if (z8) {
        }
        if (z9) {
        }
        if (z10) {
            z14 = true;
        } else {
            z14 = locationRequest.f12732l;
        }
        if (z11) {
        }
        if (j != Long.MAX_VALUE) {
            if (j != -1) {
                z15 = true;
            } else {
                z15 = true;
            }
            C0376g.a("maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE", z15);
            j9 = j;
        }
        if (j11 == -1) {
            jMin = j10;
        } else if (i14 == 105) {
            jMin = j11;
        } else {
            jMin = Math.min(j11, j10);
        }
        this.f12644a = new LocationRequest(i14, j10, jMin, Math.max(j12, j10), Long.MAX_VALUE, j8, i15, f6, z16, j9 == -1 ? j10 : j9, i16, i12, z14, new WorkSource(workSource), null);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzeg) {
            return C0375f.a(this.f12644a, ((zzeg) obj).f12644a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12644a.hashCode();
    }

    public final String toString() {
        return this.f12644a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.P(parcel, 1, this.f12644a, i9);
        b.V(parcel, iU);
    }
}
