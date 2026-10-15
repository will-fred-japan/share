package S4;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;

/* JADX INFO: renamed from: S4.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDialogInterfaceOnClickListenerC0385p implements DialogInterface.OnClickListener {
    public abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e9) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e9);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
