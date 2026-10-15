package com.google.android.gms.common.api;

import A.a;
import O4.b;
import Q4.C0348d;
import S4.C0376g;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;
import com.huawei.hms.adapter.internal.CommonCode;
import p041f5.h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f12461b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12462a = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i9, int i10, Intent intent) {
        super.onActivityResult(i9, i10, intent);
        if (i9 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f12462a = 0;
            setResult(i10, intent);
            if (booleanExtra) {
                C0348d c0348dF = C0348d.f(this);
                if (i10 == -1) {
                    h hVar = c0348dF.f3822m;
                    hVar.sendMessage(hVar.obtainMessage(3));
                } else if (i10 == 0) {
                    c0348dF.g(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i9 == 2) {
            this.f12462a = 0;
            setResult(i10, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f12462a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        GoogleApiActivity googleApiActivity;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f12462a = bundle.getInt(CommonCode.MapKey.HAS_RESOLUTION);
        }
        if (this.f12462a == 1) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
            return;
        }
        if (pendingIntent == null) {
            C0376g.e(num);
            b.f3473c.c(this, num.intValue(), this);
            this.f12462a = 1;
            return;
        }
        try {
            googleApiActivity = this;
            try {
                googleApiActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                googleApiActivity.f12462a = 1;
            } catch (ActivityNotFoundException e9) {
                e = e9;
                if (extras.getBoolean("notify_manager", true)) {
                    C0348d.f(this).g(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String strI = a.i("Activity not found while launching ", pendingIntent.toString(), ".");
                    if (Build.FINGERPRINT.contains("generic")) {
                        strI = strI.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", strI, e);
                }
                googleApiActivity.f12462a = 1;
                finish();
            } catch (IntentSender.SendIntentException e10) {
                e = e10;
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                finish();
            }
        } catch (ActivityNotFoundException e11) {
            e = e11;
            googleApiActivity = this;
        } catch (IntentSender.SendIntentException e12) {
            e = e12;
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(CommonCode.MapKey.HAS_RESOLUTION, this.f12462a);
        super.onSaveInstanceState(bundle);
    }
}
