package K6;

import com.starburst.sdk.core.feed.a2dp.IA2dpCallback;
import com.starburst.sdk.core.feed.a2dp.SecondA2dpManager;
import p049g6.o;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2830e;

    public /* synthetic */ a(Object obj, String str, String str2, Object obj2, int i9) {
        this.f2826a = i9;
        this.f2829d = obj;
        this.f2827b = str;
        this.f2828c = str2;
        this.f2830e = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2826a) {
            case 0:
                ((SecondA2dpManager) this.f2829d).lambda$a2dpPlayStart$0(this.f2827b, this.f2828c, (IA2dpCallback) this.f2830e);
                break;
            default:
                ((o.a) this.f2829d).f18965a.error(this.f2827b, this.f2828c, this.f2830e);
                break;
        }
    }
}
