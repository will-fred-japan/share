package p185x4;

import com.heytap.mcssdk.constant.a;
import java.util.Map;

/* JADX INFO: compiled from: LocationOptions.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f22328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f22331d;

    public l(f fVar, long j, long j8, boolean z8) {
        this.f22328a = fVar;
        this.f22329b = j;
        this.f22330c = j8;
        this.f22331d = z8;
    }

    public static l a(Map<String, Object> map) {
        f fVar = f.f22312e;
        if (map == null) {
            return new l(fVar, 0L, a.f14256r, false);
        }
        Integer num = (Integer) map.get("accuracy");
        Integer num2 = (Integer) map.get("distanceFilter");
        Integer num3 = (Integer) map.get("timeInterval");
        Boolean bool = (Boolean) map.get("useMSLAltitude");
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue == 0) {
                fVar = f.f22308a;
            } else if (iIntValue == 1) {
                fVar = f.f22309b;
            } else if (iIntValue == 2) {
                fVar = f.f22310c;
            } else if (iIntValue == 3) {
                fVar = f.f22311d;
            } else if (iIntValue == 5) {
                fVar = f.f22313f;
            }
        }
        return new l(fVar, num2 != null ? num2.intValue() : 0L, num3 != null ? num3.intValue() : a.f14256r, bool != null && bool.booleanValue());
    }
}
