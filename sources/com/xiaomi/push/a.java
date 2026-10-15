package com.xiaomi.push;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {
    void a(String str);

    /* JADX INFO: renamed from: com.xiaomi.push.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0186a extends Binder implements a {
        public AbstractBinderC0186a() {
            attachInterface(this, "android.telephony.tcpka.IModemTcpKeepAliveIndCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 != 1) {
                if (i9 != 1598968902) {
                    return super.onTransact(i9, parcel, parcel2, i10);
                }
                parcel2.writeString("android.telephony.tcpka.IModemTcpKeepAliveIndCallback");
                return true;
            }
            parcel.enforceInterface("android.telephony.tcpka.IModemTcpKeepAliveIndCallback");
            a(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
