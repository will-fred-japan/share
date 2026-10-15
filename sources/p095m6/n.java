package p095m6;

import android.bluetooth.BluetoothGatt;
import java.util.HashMap;

/* JADX INFO: compiled from: GattSessionRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f20470a = new HashMap();

    /* JADX INFO: compiled from: GattSessionRegistry.java */
    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f20472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BluetoothGatt f20473c;

        public a(String str, BluetoothGatt bluetoothGatt, long j) {
            this.f20471a = str;
            this.f20473c = bluetoothGatt;
            this.f20472b = j;
        }
    }

    public final void a(String str, BluetoothGatt bluetoothGatt, long j) {
        this.f20470a.put(str, new a(str, bluetoothGatt, j));
    }

    public final a b(String str, BluetoothGatt bluetoothGatt) {
        a aVar = (a) this.f20470a.get(str);
        if (aVar == null || aVar.f20473c != bluetoothGatt) {
            return null;
        }
        return aVar;
    }
}
