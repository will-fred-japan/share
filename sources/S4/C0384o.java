package S4;

import Q4.InterfaceC0351g;
import android.content.Intent;

/* JADX INFO: renamed from: S4.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0384o extends AbstractDialogInterfaceOnClickListenerC0385p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f4199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4200b;

    public C0384o(Intent intent, InterfaceC0351g interfaceC0351g) {
        this.f4199a = intent;
        this.f4200b = interfaceC0351g;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [Q4.g, java.lang.Object] */
    @Override // S4.AbstractDialogInterfaceOnClickListenerC0385p
    public final void a() {
        Intent intent = this.f4199a;
        if (intent != null) {
            this.f4200b.a(intent, 2);
        }
    }
}
