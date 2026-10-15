package androidx.appcompat.app;

import G.C0315f;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import cn.jiguang.commons.a.A;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f5952b;

    public /* synthetic */ h(Context context, int i9) {
        this.f5951a = i9;
        this.f5952b = context;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        P.d dVar;
        Object systemService;
        Context contextF;
        switch (this.f5951a) {
            case 0:
                int i9 = Build.VERSION.SDK_INT;
                if (i9 >= 33) {
                    Context context = this.f5952b;
                    ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (i9 >= 33) {
                            p155u.b<WeakReference<i>> bVar = i.f5959g;
                            bVar.getClass();
                            u.b.a aVar = new u.b.a();
                            while (true) {
                                if (aVar.hasNext()) {
                                    i iVar = (i) ((WeakReference) aVar.next()).get();
                                    if (iVar != null && (contextF = iVar.f()) != null) {
                                        systemService = contextF.getSystemService("locale");
                                    }
                                } else {
                                    systemService = null;
                                }
                            }
                            if (systemService != null) {
                                dVar = new P.d(new P.f(i.b.a(systemService)));
                            } else {
                                dVar = P.d.f3600b;
                            }
                        } else {
                            dVar = i.f5955c;
                            if (dVar == null) {
                                dVar = P.d.f3600b;
                            }
                        }
                        if (dVar.f3601a.f3602a.isEmpty()) {
                            String strB = C0315f.b(context);
                            Object systemService2 = context.getSystemService("locale");
                            if (systemService2 != null) {
                                i.b.b(systemService2, i.a.a(strB));
                            }
                        }
                        context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                    }
                }
                i.f5958f = true;
                break;
            default:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new A(this.f5952b, 1));
                break;
        }
    }
}
