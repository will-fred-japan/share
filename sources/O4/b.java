package O4;

import Q4.InterfaceC0351g;
import S4.AbstractDialogInterfaceOnClickListenerC0385p;
import S4.C0376g;
import S4.C0382m;
import S4.C0383n;
import S4.C0384o;
import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.C0532a;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {p041f5.d.class, p041f5.e.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3472b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f3473c = new b();

    public static AlertDialog d(Activity activity, int i9, AbstractDialogInterfaceOnClickListenerC0385p abstractDialogInterfaceOnClickListenerC0385p, DialogInterface.OnCancelListener onCancelListener) {
        String string;
        if (i9 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(C0382m.b(activity, i9));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i9 == 1) {
            string = resources.getString(cn.ikaile.ruoshui.client.R.string.common_google_play_services_install_button);
        } else if (i9 != 2) {
            string = i9 != 3 ? resources.getString(R.string.ok) : resources.getString(cn.ikaile.ruoshui.client.R.string.common_google_play_services_enable_button);
        } else {
            string = resources.getString(cn.ikaile.ruoshui.client.R.string.common_google_play_services_update_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, abstractDialogInterfaceOnClickListenerC0385p);
        }
        String strC = C0382m.c(activity, i9);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", W5.e.i(i9, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof androidx.fragment.app.g) {
                FragmentManager supportFragmentManager = ((androidx.fragment.app.g) activity).getSupportFragmentManager();
                g gVar = new g();
                C0376g.f(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                gVar.f3479v0 = alertDialog;
                if (onCancelListener != null) {
                    gVar.f3480w0 = onCancelListener;
                }
                gVar.f7606s0 = false;
                gVar.f7607t0 = true;
                supportFragmentManager.getClass();
                C0532a c0532a = new C0532a(supportFragmentManager);
                c0532a.f7670o = true;
                c0532a.e(0, gVar, str, 1);
                c0532a.d(false);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        a aVar = new a();
        C0376g.f(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        aVar.f3469a = alertDialog;
        if (onCancelListener != null) {
            aVar.f3470b = onCancelListener;
        }
        aVar.show(fragmentManager, str);
    }

    @ResultIgnorabilityUnspecified
    public final void c(GoogleApiActivity googleApiActivity, int i9, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogD = d(googleApiActivity, i9, new C0383n(super.a(i9, "d", googleApiActivity), googleApiActivity), googleApiActivity2);
        if (alertDialogD == null) {
            return;
        }
        e(googleApiActivity, alertDialogD, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    @TargetApi(20)
    public final void f(Context context, int i9, PendingIntent pendingIntent) {
        int i10;
        Log.w("GoogleApiAvailability", defpackage.f.b(i9, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i9 == 18) {
            new h(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i9 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i9 == 6 ? C0382m.e(context, "common_google_play_services_resolution_required_title") : C0382m.c(context, i9);
        if (strE == null) {
            strE = context.getResources().getString(cn.ikaile.ruoshui.client.R.string.common_google_play_services_notification_ticker);
        }
        String strD = (i9 == 6 || i9 == 19) ? C0382m.d(context, "common_google_play_services_resolution_required_text", C0382m.a(context)) : C0382m.b(context, i9);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService(RemoteMessageConst.NOTIFICATION);
        C0376g.e(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        G.n nVar = new G.n(context, null);
        nVar.f2138u = true;
        nVar.c(16, true);
        nVar.f2124e = G.n.b(strE);
        G.m mVar = new G.m();
        mVar.f2110e = G.n.b(strD);
        nVar.d(mVar);
        if (b5.a.a(context)) {
            nVar.f2117G.icon = context.getApplicationInfo().icon;
            nVar.f2129k = 2;
            if (b5.a.b(context)) {
                nVar.f2121b.add(new G.k(IconCompat.e(null, "", cn.ikaile.ruoshui.client.R.drawable.common_full_open_on_phone), resources.getString(cn.ikaile.ruoshui.client.R.string.common_open_on_phone), pendingIntent, new Bundle(), null, true, 0, true, false));
            } else {
                nVar.f2126g = pendingIntent;
            }
        } else {
            nVar.f2117G.icon = R.drawable.stat_sys_warning;
            nVar.f2117G.tickerText = G.n.b(resources.getString(cn.ikaile.ruoshui.client.R.string.common_google_play_services_notification_ticker));
            nVar.f2117G.when = System.currentTimeMillis();
            nVar.f2126g = pendingIntent;
            nVar.f2125f = G.n.b(strD);
        }
        synchronized (f3472b) {
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String string = context.getResources().getString(cn.ikaile.ruoshui.client.R.string.common_google_play_services_notification_channel_name);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
        } else if (!string.contentEquals(notificationChannel.getName())) {
            notificationChannel.setName(string);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        nVar.f2112B = "com.google.android.gms.availability";
        Notification notificationA = nVar.a();
        if (i9 == 1 || i9 == 2 || i9 == 3) {
            e.f3476a.set(false);
            i10 = 10436;
        } else {
            i10 = 39789;
        }
        notificationManager.notify(i10, notificationA);
    }

    @ResultIgnorabilityUnspecified
    public final void g(Activity activity, InterfaceC0351g interfaceC0351g, int i9, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogD = d(activity, i9, new C0384o(super.a(i9, "d", activity), interfaceC0351g), onCancelListener);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
