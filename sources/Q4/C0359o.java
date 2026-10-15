package Q4;

import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: Q4.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0359o {
    public static <ResultT> void a(Status status, ResultT resultt, p094m5.f<ResultT> fVar) {
        if (status.f12468a <= 0) {
            fVar.a(resultt);
        } else {
            fVar.f20355a.c(status.f12470c != null ? new P4.g(status) : new P4.b(status));
        }
    }
}
