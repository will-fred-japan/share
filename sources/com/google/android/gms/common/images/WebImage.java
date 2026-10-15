package com.google.android.gms.common.images;

import S4.C0375f;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Locale;
import p199z2.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f12491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12493d;

    public WebImage(int i9, Uri uri, int i10, int i11) {
        this.f12490a = i9;
        this.f12491b = uri;
        this.f12492c = i10;
        this.f12493d = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (C0375f.a(this.f12491b, webImage.f12491b) && this.f12492c == webImage.f12492c && this.f12493d == webImage.f12493d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12491b, Integer.valueOf(this.f12492c), Integer.valueOf(this.f12493d)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        return "Image " + this.f12492c + "x" + this.f12493d + " " + this.f12491b.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        int iU = b.U(parcel, 20293);
        b.W(parcel, 1, 4);
        parcel.writeInt(this.f12490a);
        b.P(parcel, 2, this.f12491b, i9);
        b.W(parcel, 3, 4);
        parcel.writeInt(this.f12492c);
        b.W(parcel, 4, 4);
        parcel.writeInt(this.f12493d);
        b.V(parcel, iU);
    }
}
