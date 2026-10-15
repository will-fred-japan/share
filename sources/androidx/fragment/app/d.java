package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.InterfaceC0546l;
import androidx.lifecycle.InterfaceC0548n;

/* JADX INFO: compiled from: Fragment.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements InterfaceC0546l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f7615a;

    public d(Fragment fragment) {
        this.f7615a = fragment;
    }

    @Override // androidx.lifecycle.InterfaceC0546l
    public final void d(InterfaceC0548n interfaceC0548n, AbstractC0544j.a aVar) {
        View view;
        if (aVar != AbstractC0544j.a.ON_STOP || (view = this.f7615a.f7447F) == null) {
            return;
        }
        view.cancelPendingInputEvents();
    }
}
