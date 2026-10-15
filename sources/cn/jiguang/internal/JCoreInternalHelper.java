package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import cn.jiguang.av.b;
import cn.jiguang.av.d;
import cn.jiguang.aw.c;
import defpackage.f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class JCoreInternalHelper {
    private static final String TAG = "JCoreInternalHelper";
    private static JCoreHelperAction jCoreHelperAction;
    private AtomicReference<JCoreHelperAction> localJCoreHelperAction;
    private long startId;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final JCoreInternalHelper f10569a = new JCoreInternalHelper();
    }

    private JCoreInternalHelper() {
        this.localJCoreHelperAction = new AtomicReference<>();
        this.startId = 0L;
    }

    private Bundle addStartId(Context context, int i9, Bundle bundle) {
        if (i9 != 2) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (Throwable unused) {
                }
            }
            bundle.putLong("jg_time_start_id", getStartId());
        }
        return bundle;
    }

    public static JCoreInternalHelper getInstance() {
        return a.f10569a;
    }

    public Object commonMethod(final Context context, final String str, final Object obj) {
        JCoreHelperAction jCoreHelperAction2 = jCoreHelperAction;
        if (jCoreHelperAction2 != null) {
            return jCoreHelperAction2.onCommonMethod(context, str, obj);
        }
        d.a("NORMAL_TASK", new b("JCoreInternalHelper#commonMethod") { // from class: cn.jiguang.internal.JCoreInternalHelper.3
            @Override // cn.jiguang.av.b
            public void a() {
                try {
                    JCoreInternalHelper.this.initLoad(context);
                    JCoreInternalHelper.jCoreHelperAction.onCommonMethod(context, str, obj);
                } catch (Throwable th) {
                    f.l("commonMethod e:", JCoreInternalHelper.TAG, th);
                }
            }
        });
        return null;
    }

    public Bundle directHandle(final Context context, final String str, final String str2, final Bundle bundle) {
        d.a("DYNAMIC_LOAD_TASK", new b("JCoreInternalHelper#directHandle") { // from class: cn.jiguang.internal.JCoreInternalHelper.2
            @Override // cn.jiguang.av.b
            public void a() {
                JCoreHelperAction jCoreHelperAction2;
                Context context2;
                String str3;
                String str4;
                Bundle bundle2;
                try {
                    if (JCoreInternalHelper.jCoreHelperAction != null) {
                        jCoreHelperAction2 = JCoreInternalHelper.jCoreHelperAction;
                        context2 = context;
                        str3 = str;
                        str4 = str2;
                        bundle2 = bundle;
                    } else {
                        JCoreInternalHelper.this.initLoad(context);
                        jCoreHelperAction2 = JCoreInternalHelper.jCoreHelperAction;
                        context2 = context;
                        str3 = str;
                        str4 = str2;
                        bundle2 = bundle;
                    }
                    jCoreHelperAction2.directHandle(context2, str3, str4, bundle2);
                } catch (Throwable th) {
                    f.l("directHandle e:", JCoreInternalHelper.TAG, th);
                }
            }
        });
        return new Bundle();
    }

    public long getStartId() {
        if (this.startId == 0) {
            this.startId = SystemClock.elapsedRealtime();
        }
        return this.startId;
    }

    public synchronized void initLoad(Context context) {
        if (jCoreHelperAction != null) {
            return;
        }
        if (context == null) {
            return;
        }
        try {
            cn.jiguang.dy.b.a().a(context, 1);
        } catch (Throwable th) {
            cn.jiguang.x.f.c(TAG, "load d y failed :" + th.getMessage());
        }
        if (jCoreHelperAction == null) {
            cn.jiguang.x.f.c(TAG, "load action by local");
            jCoreHelperAction = new cn.jiguang.c.b();
        }
    }

    public Object onEvent(final Context context, final String str, final int i9, boolean z8, final String str2, Bundle bundle, final Object... objArr) {
        Bundle bundleAddStartId = addStartId(context, i9, bundle);
        if (z8) {
            final Bundle bundleB = c.b(bundleAddStartId);
            d.a("DYNAMIC_LOAD_TASK", new b("JCoreInternalHelper#onEvent") { // from class: cn.jiguang.internal.JCoreInternalHelper.1
                @Override // cn.jiguang.av.b
                public void a() {
                    try {
                        JCoreInternalHelper.this.initLoad(context);
                        JCoreInternalHelper.jCoreHelperAction.onEvent(context, str, i9, str2, bundleB, objArr);
                    } catch (Throwable th) {
                        f.l("onEvent e:", JCoreInternalHelper.TAG, th);
                    }
                }
            }, !cn.jiguang.c.b.f9575a.contains(Integer.valueOf(i9)));
            return null;
        }
        JCoreHelperAction jCoreHelperAction2 = jCoreHelperAction;
        if (jCoreHelperAction2 != null) {
            return jCoreHelperAction2.onEvent(context, str, i9, str2, bundleAddStartId, objArr);
        }
        JCoreHelperAction bVar = this.localJCoreHelperAction.get();
        if (bVar == null) {
            bVar = new cn.jiguang.c.b();
            this.localJCoreHelperAction.set(bVar);
        }
        return bVar.onEvent(context, str, i9, str2, bundleAddStartId, objArr);
    }

    public void setStartId(Context context) {
        if (this.startId == 0) {
            this.startId = SystemClock.elapsedRealtime();
        }
    }
}
