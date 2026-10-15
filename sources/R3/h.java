package R3;

import android.app.NotificationManager;
import android.content.Context;
import cn.ikaile.ruoshui.client.MainActivity;
import cn.ikaile.ruoshui.client.foreground.TaskForegroundService;
import p096m7.l;

/* JADX INFO: compiled from: TaskForegroundChannel.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f4003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p096m7.d f4004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m7.d.b.a f4005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4007f;

    public h(MainActivity mainActivity, io.flutter.embedding.engine.a aVar) {
        Context applicationContext = mainActivity.getApplicationContext();
        this.f4002a = applicationContext;
        l lVar = new l(aVar.f19409c.f8599e, "roselink/task_foreground");
        this.f4003b = lVar;
        p096m7.d dVar = new p096m7.d(aVar.f19409c.f8599e, "roselink/task_foreground_events");
        this.f4004c = dVar;
        a aVar2 = new a(1, this);
        TaskForegroundService.d(applicationContext, TaskForegroundService.f8794d);
        TaskForegroundService.f8793c = new S3.b();
        TaskForegroundService.f8796f = aVar2;
        ((NotificationManager) applicationContext.getSystemService(NotificationManager.class)).cancel(7401);
        ((NotificationManager) applicationContext.getSystemService(NotificationManager.class)).deleteNotificationChannel("roselink_active_tasks");
        this.f4006e = TaskForegroundService.f8794d;
        dVar.a(new g(this));
        lVar.b(new c(1, this));
    }

    public final void a() {
        if (this.f4007f) {
            return;
        }
        this.f4007f = true;
        TaskForegroundService.d(this.f4002a, this.f4006e);
        this.f4003b.b(null);
        this.f4004c.a(null);
        this.f4005d = null;
    }
}
