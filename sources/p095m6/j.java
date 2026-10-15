package p095m6;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import java.util.ArrayList;
import p147s7.o;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f20453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f20454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f20455d;

    public /* synthetic */ j(g.e eVar, BluetoothGatt bluetoothGatt, int i9, int i10) {
        this.f20452a = i10;
        this.f20453b = eVar;
        this.f20454c = bluetoothGatt;
        this.f20455d = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent intent;
        switch (this.f20452a) {
            case 0:
                ((g.e) this.f20453b).onServicesDiscovered((BluetoothGatt) this.f20454c, this.f20455d);
                break;
            case 1:
                ((g.e) this.f20453b).onReliableWriteCompleted((BluetoothGatt) this.f20454c, this.f20455d);
                break;
            default:
                o oVar = (o) this.f20453b;
                oVar.getClass();
                if (this.f20455d == -1 && (intent = (Intent) this.f20454c) != null) {
                    ArrayList<o.b> arrayListE = oVar.e(intent, false);
                    if (arrayListE != null) {
                        oVar.g(arrayListE);
                    } else {
                        oVar.b("no_valid_image_uri", "Cannot find the selected image.");
                    }
                } else {
                    oVar.d(null);
                }
                break;
        }
    }

    public /* synthetic */ j(o oVar, int i9, Intent intent) {
        this.f20452a = 2;
        this.f20453b = oVar;
        this.f20455d = i9;
        this.f20454c = intent;
    }
}
