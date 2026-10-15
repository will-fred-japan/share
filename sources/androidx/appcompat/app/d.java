package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: AlertController.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertController f5944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertController.b f5945b;

    public d(AlertController.b bVar, AlertController alertController) {
        this.f5945b = bVar;
        this.f5944a = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i9, long j) {
        AlertController.b bVar = this.f5945b;
        DialogInterface.OnClickListener onClickListener = bVar.f5850n;
        AlertController alertController = this.f5944a;
        onClickListener.onClick(alertController.f5812b, i9);
        if (bVar.f5851o) {
            return;
        }
        alertController.f5812b.dismiss();
    }
}
