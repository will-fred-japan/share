package Q4;

import android.content.DialogInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Z extends LifecycleCallback implements DialogInterface.OnCancelListener {
    public abstract void b(ConnectionResult connectionResult, int i9);
}
