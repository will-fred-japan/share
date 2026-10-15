package com.huawei.hms.common.webserverpic;

import H2.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class WebServerPic {
    public static final Parcelable.Creator<WebServerPic> CREATOR = new WebServerPicCreator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f14993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14995c;

    public WebServerPic(Uri uri, int i9, int i10) {
        this.f14993a = uri;
        this.f14994b = i9;
        this.f14995c = i10;
        if (uri == null) {
            throw new IllegalArgumentException("url is not able to be null");
        }
        if (i9 < 0 || i10 < 0) {
            throw new IllegalArgumentException("width and height should be positive or 0");
        }
    }

    public final int getHeight() {
        return this.f14995c;
    }

    public final Uri getUrl() {
        return this.f14993a;
    }

    public final int getWidth() {
        return this.f14994b;
    }

    public final String toString() {
        Locale locale = Locale.ENGLISH;
        int i9 = this.f14994b;
        int i10 = this.f14995c;
        String string = this.f14993a.toString();
        StringBuilder sbG = a.g(i9, i10, "Image ", "x", " ");
        sbG.append(string);
        return sbG.toString();
    }

    public final void writeToParcel(Parcel parcel, int i9) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUrl(), i9, false);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public WebServerPic(Uri uri) {
        this(uri, 0, 0);
    }
}
