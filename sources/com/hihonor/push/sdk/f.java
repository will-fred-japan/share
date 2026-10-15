package com.hihonor.push.sdk;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import com.hihonor.push.sdk.common.ResponseHeader;

/* JADX INFO: loaded from: classes.dex */
public interface f extends IInterface {

    public static abstract class a extends Binder implements f {
        public a() {
            attachInterface(this, "com.hihonor.push.framework.aidl.IPushCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) throws IllegalAccessException, InstantiationException {
            if (i9 != 1) {
                if (i9 != 1598968902) {
                    return super.onTransact(i9, parcel, parcel2, i10);
                }
                parcel2.writeString("com.hihonor.push.framework.aidl.IPushCallback");
                return true;
            }
            parcel.enforceInterface("com.hihonor.push.framework.aidl.IPushCallback");
            d dVarCreateFromParcel = parcel.readInt() != 0 ? d.CREATOR.createFromParcel(parcel) : null;
            p0 p0Var = (p0) this;
            Log.i("IPCCallback", "onResult parse start.");
            Bundle bundle = dVarCreateFromParcel.f14470b;
            Bundle bundle2 = dVarCreateFromParcel.f14471c;
            ResponseHeader responseHeader = new ResponseHeader();
            h.a(bundle, responseHeader);
            Object obj = p0Var.f14548a;
            if (obj instanceof e) {
                h.a(bundle2, (e) obj);
            }
            q0 q0Var = p0Var.f14549b;
            j jVar = new j(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
            Object obj2 = p0Var.f14548a;
            j0.b bVar = (j0.b) q0Var;
            bVar.getClass();
            j0 j0Var = j0.f14504c;
            i1<?> i1Var = bVar.f14515a;
            j0Var.getClass();
            Log.i("HonorApiManager", "sendResolveResult start");
            Handler handler = j0Var.f14505a;
            handler.sendMessage(handler.obtainMessage(2, i1Var));
            bVar.f14515a.b(jVar, obj2);
            Log.i("IPCCallback", "onResult parse end.");
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
