package O4;

import S4.C0376g;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public class a extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlertDialog f3469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogInterface.OnCancelListener f3470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlertDialog f3471c;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f3470b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = this.f3469a;
        if (alertDialog != null) {
            return alertDialog;
        }
        setShowsDialog(false);
        if (this.f3471c == null) {
            Activity activity = getActivity();
            C0376g.e(activity);
            this.f3471c = new AlertDialog.Builder(activity).create();
        }
        return this.f3471c;
    }
}
