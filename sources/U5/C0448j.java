package U5;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Objects;

/* JADX INFO: renamed from: U5.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LegacyProtoParameters.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0448j extends L5.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f4716a;

    public C0448j(F f6) {
        this.f4716a = f6;
    }

    @Override // L5.n
    public final boolean a() {
        return this.f4716a.f4683b.I() != Z5.I.RAW;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0448j)) {
            return false;
        }
        F f6 = ((C0448j) obj).f4716a;
        F f9 = this.f4716a;
        if (f9.f4683b.I().equals(f6.f4683b.I())) {
            String strJ = f9.f4683b.J();
            Z5.A a3 = f6.f4683b;
            if (strJ.equals(a3.J()) && f9.f4683b.K().equals(a3.K())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        F f6 = this.f4716a;
        return Objects.hash(f6.f4683b, f6.f4682a);
    }

    public final String toString() {
        String str;
        F f6 = this.f4716a;
        String strJ = f6.f4683b.J();
        int iOrdinal = f6.f4683b.I().ordinal();
        if (iOrdinal == 1) {
            str = "TINK";
        } else if (iOrdinal == 2) {
            str = "LEGACY";
        } else if (iOrdinal != 3) {
            str = iOrdinal != 4 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "CRUNCHY";
        } else {
            str = "RAW";
        }
        return "(typeUrl=" + strJ + ", outputPrefixType=" + str + ")";
    }
}
