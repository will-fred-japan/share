package com.google.android.gms.common.data;

import R4.b;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f12481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f12482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CursorWindow[] f12483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f12485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f12486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12487h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f12488i = true;

    static {
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i9, String[] strArr, CursorWindow[] cursorWindowArr, int i10, Bundle bundle) {
        this.f12480a = i9;
        this.f12481b = strArr;
        this.f12483d = cursorWindowArr;
        this.f12484e = i10;
        this.f12485f = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            try {
                if (!this.f12487h) {
                    this.f12487h = true;
                    int i9 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.f12483d;
                        if (i9 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i9].close();
                        i9++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() throws Throwable {
        boolean z8;
        try {
            if (this.f12488i && this.f12483d.length > 0) {
                synchronized (this) {
                    z8 = this.f12487h;
                }
                if (!z8) {
                    close();
                    Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = p199z2.b.U(parcel, 20293);
        String[] strArr = this.f12481b;
        if (strArr != null) {
            int iU2 = p199z2.b.U(parcel, 1);
            parcel.writeStringArray(strArr);
            p199z2.b.V(parcel, iU2);
        }
        p199z2.b.S(parcel, 2, this.f12483d, i9);
        p199z2.b.W(parcel, 3, 4);
        parcel.writeInt(this.f12484e);
        p199z2.b.M(parcel, 4, this.f12485f);
        p199z2.b.W(parcel, 1000, 4);
        parcel.writeInt(this.f12480a);
        p199z2.b.V(parcel, iU);
        if ((i9 & 1) != 0) {
            close();
        }
    }
}
