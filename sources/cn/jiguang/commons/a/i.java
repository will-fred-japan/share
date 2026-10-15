package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class i implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new j();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10179d;

    public i(int i9) {
        this.f10179d = i9;
        this.f10178c = a(i9);
    }

    private static String a(int i9) throws IOException {
        String strTrim;
        try {
            Locale locale = Locale.ENGLISH;
            strTrim = ah.b("/proc/" + i9 + "/cmdline").trim();
        } catch (IOException unused) {
            strTrim = null;
        }
        if (!TextUtils.isEmpty(strTrim)) {
            return strTrim;
        }
        try {
            return ak.a(i9).a();
        } catch (Throwable unused2) {
            Locale locale2 = Locale.ENGLISH;
            throw new IOException(defpackage.f.b(i9, "Error reading /proc/", "/stat"));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.f10178c);
        parcel.writeInt(this.f10179d);
    }

    public i(Parcel parcel) {
        this.f10178c = parcel.readString();
        this.f10179d = parcel.readInt();
    }

    public final String a(String str) {
        Locale locale = Locale.ENGLISH;
        return ah.b("/proc/" + this.f10179d + "/" + str);
    }
}
