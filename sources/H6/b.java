package H6;

import android.os.Handler;
import com.bytedance.apm.alog.IALogActiveUploadCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import p096m7.k;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements IALogActiveUploadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f2519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Handler f2520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f2521c;

    public /* synthetic */ b(AtomicBoolean atomicBoolean, Handler handler, k kVar) {
        this.f2519a = atomicBoolean;
        this.f2520b = handler;
        this.f2521c = kVar;
    }

    @Override // com.bytedance.apm.alog.IALogActiveUploadCallback
    public final void onCallback(boolean z8, JSONObject jSONObject) {
        if (this.f2519a.compareAndSet(false, true)) {
            this.f2520b.post(new c(this.f2521c, z8, 0));
        }
    }
}
