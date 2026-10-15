package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class am extends ah {
    public static final Parcelable.Creator<am> CREATOR = new an();

    private am(Parcel parcel) {
        super(parcel);
    }

    public final int a() {
        String strTrim;
        try {
            for (String str : this.f9659b.split("\n")) {
                if (str.startsWith("Uid" + Constants.COLON_SEPARATOR)) {
                    strTrim = str.split("Uid" + Constants.COLON_SEPARATOR)[1].trim();
                    return Integer.parseInt(strTrim.split("\\s+")[0]);
                }
            }
            strTrim = null;
            return Integer.parseInt(strTrim.split("\\s+")[0]);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public /* synthetic */ am(Parcel parcel, byte b9) {
        this(parcel);
    }

    public static am a(int i9) {
        Locale locale = Locale.ENGLISH;
        return new am(defpackage.f.b(i9, "/proc/", "/status"));
    }

    private am(String str) {
        super(str);
    }
}
