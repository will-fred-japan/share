package p173w1;

import okhttp3.Call;
import okhttp3.EventListener;
import p061i1.g;

/* JADX INFO: compiled from: OkHttpEventFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements EventListener.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventListener.Factory f22041a;

    public a(EventListener.Factory factory) {
        this.f22041a = factory;
    }

    @Override // okhttp3.EventListener.Factory
    public final EventListener create(Call call) {
        EventListener.Factory factory = this.f22041a;
        EventListener eventListenerCreate = factory != null ? factory.create(call) : null;
        b bVar = new b();
        bVar.f22045d = true;
        bVar.f22056p = new StringBuilder();
        bVar.f22042a = eventListenerCreate;
        bVar.f22043b = new c();
        if (!g.b().a()) {
            bVar.f22045d = false;
        }
        return bVar;
    }
}
