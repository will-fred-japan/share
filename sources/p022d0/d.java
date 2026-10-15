package p022d0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.AbstractC0544j;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0548n;

/* JADX INFO: compiled from: EmojiCompatInitializer.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0544j f18451a;

    public d(EmojiCompatInitializer emojiCompatInitializer, AbstractC0544j abstractC0544j) {
        this.f18451a = abstractC0544j;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void a(InterfaceC0548n interfaceC0548n) {
        (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new EmojiCompatInitializer.c(), 500L);
        this.f18451a.c(this);
    }
}
