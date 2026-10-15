package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ak extends ah {
    public static final Parcelable.Creator<ak> CREATOR = new al();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f9666a;

    private ak(Parcel parcel) {
        super(parcel);
        this.f9666a = parcel.createStringArray();
    }

    public static ak a(int i9) {
        Locale locale = Locale.ENGLISH;
        return new ak(defpackage.f.b(i9, "/proc/", "/stat"));
    }

    public final char b() {
        return this.f9666a[2].charAt(0);
    }

    public final int c() {
        return Integer.parseInt(this.f9666a[7]);
    }

    public final long d() {
        return Long.parseLong(this.f9666a[13]);
    }

    public final long e() {
        return Long.parseLong(this.f9666a[14]);
    }

    public final long f() {
        return Long.parseLong(this.f9666a[15]);
    }

    public final long g() {
        return Long.parseLong(this.f9666a[16]);
    }

    public final long h() {
        return Long.parseLong(this.f9666a[17]);
    }

    public final long i() {
        return Long.parseLong(this.f9666a[19]);
    }

    public final long j() {
        return Long.parseLong(this.f9666a[21]);
    }

    public final long k() {
        return Long.parseLong(this.f9666a[22]);
    }

    public final int l() {
        return Integer.parseInt(this.f9666a[39]);
    }

    public final int m() {
        return Integer.parseInt(this.f9666a[40]);
    }

    @Override // cn.jiguang.commons.a.ah, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        parcel.writeStringArray(this.f9666a);
    }

    public /* synthetic */ ak(Parcel parcel, byte b9) {
        this(parcel);
    }

    private ak(String str) {
        super(str);
        this.f9666a = this.f9659b.split("\\s+");
    }

    public final String a() {
        return this.f9666a[1].replace("(", "").replace(")", "");
    }
}
