package P;

import android.os.LocaleList;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

/* JADX INFO: compiled from: LocaleListCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f3600b = new d(new f(new LocaleList(new Locale[0])));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f3601a;

    public d(f fVar) {
        this.f3601a = fVar;
    }

    public static d a(String str) {
        if (str == null || str.isEmpty()) {
            return f3600b;
        }
        String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP, -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i9 = 0; i9 < length; i9++) {
            localeArr[i9] = Locale.forLanguageTag(strArrSplit[i9]);
        }
        return new d(new f(new LocaleList(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f3601a.equals(((d) obj).f3601a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3601a.f3602a.hashCode();
    }

    public final String toString() {
        return this.f3601a.f3602a.toString();
    }
}
