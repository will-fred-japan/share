package androidx.appcompat.app;

import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: AppCompatDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5953a = new c(new d());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5954b = -100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static P.d f5955c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static P.d f5956d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f5957e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f5958f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p155u.b<WeakReference<i>> f5959g = new p155u.b<>(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f5960h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f5961i = new Object();

    /* JADX INFO: compiled from: AppCompatDelegate.java */
    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegate.java */
    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegate.java */
    public static class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f5962a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayDeque f5963b = new ArrayDeque();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f5964c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Runnable f5965d;

        public c(d dVar) {
            this.f5964c = dVar;
        }

        public final void a() {
            synchronized (this.f5962a) {
                try {
                    Runnable runnable = (Runnable) this.f5963b.poll();
                    this.f5965d = runnable;
                    if (runnable != null) {
                        this.f5964c.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            synchronized (this.f5962a) {
                try {
                    this.f5963b.add(new G6.b(8, this, runnable));
                    if (this.f5965d == null) {
                        a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegate.java */
    public static class d implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    public static boolean m(Context context) {
        if (f5957e == null) {
            try {
                int i9 = AppLocalesMetadataHolderService.f5942a;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AppLocalesMetadataHolderService.class), AppLocalesMetadataHolderService.a.a() | 128).metaData;
                if (bundle != null) {
                    f5957e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f5957e = Boolean.FALSE;
            }
        }
        return f5957e.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void u(AppCompatDelegateImpl appCompatDelegateImpl) {
        synchronized (f5960h) {
            try {
                p155u.b<WeakReference<i>> bVar = f5959g;
                bVar.getClass();
                u.b.a aVar = new u.b.a();
                while (aVar.hasNext()) {
                    i iVar = (i) ((WeakReference) aVar.next()).get();
                    if (iVar == appCompatDelegateImpl || iVar == null) {
                        aVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void B(CharSequence charSequence);

    public abstract p089m.a C(p089m.a.InterfaceC0228a interfaceC0228a);

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public abstract <T extends View> T e(int i9);

    public Context f() {
        return null;
    }

    public abstract AppCompatDelegateImpl.b g();

    public int h() {
        return -100;
    }

    public abstract MenuInflater i();

    public abstract androidx.appcompat.app.a j();

    public abstract void k();

    public abstract void l();

    public abstract void n(Configuration configuration);

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract boolean v(int i9);

    public abstract void w(int i9);

    public abstract void x(View view);

    public abstract void y(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void z(Toolbar toolbar);

    public void A(int i9) {
    }

    public Context d(Context context) {
        return context;
    }
}
