package N6;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;

/* JADX INFO: renamed from: N6.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0340k implements K7.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0344o f3349b;

    public /* synthetic */ C0340k(C0344o c0344o, int i9) {
        this.f3348a = i9;
        this.f3349b = c0344o;
    }

    @Override // K7.l
    public final Object invoke(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        switch (this.f3348a) {
            case 0:
                kotlin.jvm.internal.k.e(entry, "<destruct>");
                Object key = entry.getKey();
                return key + ContainerUtils.KEY_VALUE_DELIMITER + this.f3349b.o(entry.getValue(), key != null ? key.toString() : null);
            default:
                kotlin.jvm.internal.k.e(entry, "<destruct>");
                Object key2 = entry.getKey();
                return key2 + ContainerUtils.KEY_VALUE_DELIMITER + this.f3349b.o(entry.getValue(), key2 != null ? key2.toString() : null);
        }
    }
}
