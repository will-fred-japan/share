package com.hihonor.push.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f14488a = 0;

        /* JADX INFO: renamed from: com.hihonor.push.sdk.g$a$a, reason: collision with other inner class name */
        public static class C0161a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f14489a;

            public C0161a(IBinder iBinder) {
                this.f14489a = iBinder;
            }

            @Override // com.hihonor.push.sdk.g
            public void a(d dVar, f fVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.push.framework.aidl.IPushInvoke");
                    parcelObtain.writeInt(1);
                    parcelObtain.writeString(dVar.f14469a);
                    parcelObtain.writeBundle(dVar.f14470b);
                    parcelObtain.writeBundle(dVar.f14471c);
                    parcelObtain.writeStrongBinder(fVar != null ? (f.a) fVar : null);
                    if (!this.f14489a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i9 = a.f14488a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14489a;
            }
        }
    }

    void a(d dVar, f fVar);
}
