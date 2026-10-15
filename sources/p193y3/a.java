package p193y3;

import android.app.Application;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import p184x3.b;

/* JADX INFO: compiled from: AssistStatImp.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f22372f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A3.a f22373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C3.a f22374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B3.a f22375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p200z3.a f22376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p184x3.a f22377e;

    public a(Application application) {
        p184x3.a aVar = p184x3.a.f22276b;
        Context applicationContext = application.getApplicationContext();
        this.f22377e = aVar;
        A3.a aVar2 = new A3.a(applicationContext, this);
        aVar2.f1448e = false;
        aVar2.f1449f = 0;
        aVar2.f1450g = 0.0f;
        aVar2.f1451h = 0L;
        aVar2.f1446c = (PowerManager) applicationContext.getSystemService("power");
        aVar2.f1447d = (BatteryManager) applicationContext.getSystemService("batterymanager");
        this.f22373a = aVar2;
        C3.a aVar3 = new C3.a(applicationContext, this);
        aVar3.f1801c = (PowerManager) applicationContext.getSystemService("power");
        this.f22374b = aVar3;
        B3.a aVar4 = new B3.a(applicationContext, this);
        aVar4.f1727c = false;
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new HashMap();
        new HashMap();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new HashMap();
        new HashMap();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.f22375c = aVar4;
        p200z3.a aVar5 = new p200z3.a();
        aVar5.f22498b = false;
        aVar5.f22497a = this;
        this.f22376d = aVar5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public final b a() {
        PowerManager powerManager;
        b bVar = new b();
        String str = p199z2.b.f22480k;
        if (str == null) {
            Method method = D3.b.f1910a;
            if (method == null) {
                str = "";
            } else {
                try {
                    str = (String) method.invoke(null, "ro.board.platform", "");
                } catch (IllegalAccessException e9) {
                    e9.printStackTrace();
                    str = "";
                } catch (IllegalArgumentException e10) {
                    e10.printStackTrace();
                    str = "";
                } catch (InvocationTargetException e11) {
                    e11.printStackTrace();
                    str = "";
                }
            }
            p199z2.b.f22480k = str;
        }
        bVar.f22278a = str;
        A3.a aVar = this.f22373a;
        aVar.c();
        bVar.f22279b = aVar.f1448e;
        aVar.c();
        bVar.f22280c = aVar.f1449f;
        C3.a aVar2 = this.f22374b;
        aVar2.getClass();
        bVar.f22281d = (Build.VERSION.SDK_INT < 29 || (powerManager = aVar2.f1801c) == null) ? -1 : powerManager.getCurrentThermalStatus();
        A3.a aVar3 = this.f22373a;
        aVar3.getClass();
        PowerManager powerManager2 = aVar3.f1446c;
        bVar.f22282e = powerManager2 != null ? powerManager2.isPowerSaveMode() : -1;
        aVar.c();
        bVar.f22283f = aVar.f1450g;
        ((a) this.f22375c.f5348b).f22377e.getClass();
        return bVar;
    }
}
