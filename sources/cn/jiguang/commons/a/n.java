package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class n extends ah {
    public static final Parcelable.Creator<n> CREATOR = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<p> f10394a;

    private n(Parcel parcel) {
        super(parcel);
        this.f10394a = parcel.createTypedArrayList(p.CREATOR);
    }

    public static n a(int i9) {
        Locale locale = Locale.ENGLISH;
        return new n(defpackage.f.b(i9, "/proc/", "/cgroup"));
    }

    @Override // cn.jiguang.commons.a.ah, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        parcel.writeTypedList(this.f10394a);
    }

    public /* synthetic */ n(Parcel parcel, byte b9) {
        this(parcel);
    }

    private n(String str) {
        super(str);
        String[] strArrSplit = this.f9659b.split("\n");
        this.f10394a = new ArrayList<>();
        for (String str2 : strArrSplit) {
            try {
                this.f10394a.add(new p(str2));
            } catch (Throwable unused) {
            }
        }
    }

    public final p a(String str) {
        for (p pVar : this.f10394a) {
            for (String str2 : pVar.f10396b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (str2.equals(str)) {
                    return pVar;
                }
            }
        }
        return null;
    }
}
