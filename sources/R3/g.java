package R3;

import cn.ikaile.ruoshui.client.foreground.TaskForegroundService;

/* JADX INFO: compiled from: TaskForegroundChannel.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements m7.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f4001a;

    public g(h hVar) {
        this.f4001a = hVar;
    }

    @Override // m7.d.c
    public final void a(Object obj, m7.d.b.a aVar) {
        this.f4001a.f4005d = aVar;
        aVar.success(TaskForegroundService.f8793c.a());
    }

    @Override // m7.d.c
    public final void b() {
        this.f4001a.f4005d = null;
    }
}
