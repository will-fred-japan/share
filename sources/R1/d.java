package R1;

import android.text.TextUtils;

/* JADX INFO: compiled from: LocalVersionInfo.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3981e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return TextUtils.equals(this.f3977a, dVar.f3977a) && TextUtils.equals(this.f3978b, dVar.f3978b) && TextUtils.equals(this.f3979c, dVar.f3979c) && TextUtils.equals(this.f3980d, dVar.f3980d) && TextUtils.equals(this.f3981e, dVar.f3981e);
    }

    public final int hashCode() {
        String str = this.f3977a;
        int iHashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f3978b;
        int iHashCode2 = (str2 != null ? str2.hashCode() : 0) + iHashCode;
        String str3 = this.f3979c;
        int iHashCode3 = (str3 != null ? str3.hashCode() : 0) + iHashCode2;
        String str4 = this.f3980d;
        int iHashCode4 = (str4 != null ? str4.hashCode() : 0) + iHashCode3;
        String str5 = this.f3981e;
        return (str5 != null ? str5.hashCode() : 0) + iHashCode4;
    }
}
