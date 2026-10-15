package cn.ikaile.ruoshui.client;

import R3.b;
import R3.c;
import R3.d;
import R3.h;
import T3.f;
import Z6.e;
import android.util.Log;
import cn.ikaile.ruoshui.client.foreground.TaskForegroundService;
import io.flutter.embedding.engine.a;
import p096m7.l;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f8787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f8788g;

    @Override // Z6.e, Z6.f.b
    public final void a() {
        h hVar = this.f8788g;
        if (hVar != null) {
            hVar.a();
            this.f8788g = null;
        }
    }

    @Override // Z6.e, Z6.f.b
    public final void b(a aVar) {
        super.b(aVar);
        this.f8788g = new h(this, aVar);
        this.f8787f = new f(this);
        d dVar = new d(this);
        p013b7.a aVar2 = aVar.f19409c;
        new l(aVar2.f8599e, "roselink/app_market").b(new c(0, dVar));
        R3.f fVar = new R3.f(this);
        b7.a.d dVar2 = aVar2.f8599e;
        new l(dVar2, "cn.ikaile.ruoshui.client/minimize").b(new R3.e(0, fVar));
        new l(dVar2, "cn.ikaile.ruoshui.client/android_system").b(new R3.a(0, new b(new V3.a(this), this.f8787f)));
        Log.d("RoseLinkAndroidSystem", "cn.ikaile.ruoshui.client/android_system registered");
    }

    @Override // Z6.e, android.app.Activity
    public final void onDestroy() {
        h hVar = this.f8788g;
        if (hVar != null) {
            hVar.a();
            this.f8788g = null;
        }
        f fVar = this.f8787f;
        if (fVar != null) {
            fVar.f4496b.removeCallbacksAndMessages(null);
            fVar.n();
            fVar.f4499e = null;
            fVar.f4501g = false;
            fVar.f4502h = false;
            fVar.g(false);
            this.f8787f = null;
        }
        super.onDestroy();
    }

    @Override // Z6.e, android.app.Activity
    public final void onStart() {
        super.onStart();
        h hVar = this.f8788g;
        if (hVar == null || hVar.f4007f) {
            return;
        }
        if (hVar.f4006e == TaskForegroundService.f8794d) {
            TaskForegroundService.f8795e = true;
        }
    }

    @Override // Z6.e, android.app.Activity
    public final void onStop() {
        h hVar = this.f8788g;
        if (hVar != null && !hVar.f4007f) {
            if (hVar.f4006e == TaskForegroundService.f8794d) {
                TaskForegroundService.f8795e = false;
            }
        }
        super.onStop();
    }
}
