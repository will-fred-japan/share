package S4;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: renamed from: S4.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0383n extends AbstractDialogInterfaceOnClickListenerC0385p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f4197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GoogleApiActivity f4198b;

    public C0383n(Intent intent, GoogleApiActivity googleApiActivity) {
        this.f4197a = intent;
        this.f4198b = googleApiActivity;
    }

    @Override // S4.AbstractDialogInterfaceOnClickListenerC0385p
    public final void a() {
        Intent intent = this.f4197a;
        if (intent != null) {
            this.f4198b.startActivityForResult(intent, 2);
        }
    }
}
