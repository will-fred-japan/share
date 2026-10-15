package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class CoreComponentFactory extends AppComponentFactory {

    public interface a {
        Object a();
    }

    public static <T> T a(T t) {
        T t6;
        return (!(t instanceof a) || (t6 = (T) ((a) t).a()) == null) ? t : t6;
    }

    public final Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) {
        return (Activity) a(super.instantiateActivity(classLoader, str, intent));
    }

    public final Application instantiateApplication(ClassLoader classLoader, String str) {
        return (Application) a(super.instantiateApplication(classLoader, str));
    }

    public final ContentProvider instantiateProvider(ClassLoader classLoader, String str) {
        return (ContentProvider) a(super.instantiateProvider(classLoader, str));
    }

    public final BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) {
        return (BroadcastReceiver) a(super.instantiateReceiver(classLoader, str, intent));
    }

    public final Service instantiateService(ClassLoader classLoader, String str, Intent intent) {
        return (Service) a(super.instantiateService(classLoader, str, intent));
    }
}
