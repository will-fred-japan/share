package V6;

import android.content.Intent;
import dev.fluttercommunity.plus.share.SharePlusPendingIntent;
import java.util.concurrent.atomic.AtomicBoolean;
import p096m7.k;
import p096m7.n;

/* JADX INFO: compiled from: ShareSuccessManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f4902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f4903b;

    @Override // p096m7.n
    public final boolean onActivityResult(int i9, int i10, Intent intent) {
        k kVar;
        if (i9 != 22643) {
            return false;
        }
        String str = SharePlusPendingIntent.f18539a;
        if (this.f4903b.compareAndSet(false, true) && (kVar = this.f4902a) != null) {
            kVar.success(str);
            this.f4902a = null;
        }
        return true;
    }
}
