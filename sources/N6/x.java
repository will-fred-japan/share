package N6;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import java.io.Serializable;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3439d;

    public /* synthetic */ x(int i9, Object obj, Object obj2, int i10) {
        this.f3436a = i10;
        this.f3438c = obj;
        this.f3437b = i9;
        this.f3439d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3436a) {
            case 0:
                p188x7.e eVar = new p188x7.e("code", Integer.valueOf(this.f3437b));
                String str = (String) this.f3439d;
                if (str == null) {
                    str = "";
                }
                ((C0338i) this.f3438c).success(y7.u.D(eVar, new p188x7.e("message", str), new p188x7.e("taskId", null)));
                break;
            case 1:
                ((e.h.f) this.f3438c).a(this.f3437b, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f3439d));
                break;
            case 2:
                ((androidx.profileinstaller.b) this.f3438c).f7893b.a(this.f3437b, (Serializable) this.f3439d);
                break;
            default:
                ((p130r.l) this.f3438c).onGreatestScrollPercentageIncreased(this.f3437b, (Bundle) this.f3439d);
                break;
        }
    }

    public /* synthetic */ x(androidx.profileinstaller.b bVar, int i9, Serializable serializable) {
        this.f3436a = 2;
        this.f3438c = bVar;
        this.f3437b = i9;
        this.f3439d = serializable;
    }
}
