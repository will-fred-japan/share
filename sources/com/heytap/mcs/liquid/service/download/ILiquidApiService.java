package com.heytap.mcs.liquid.service.download;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.heytap.mcs.liquid.model.ActionInfo;
import com.heytap.mcs.liquid.model.SeedingRequest;
import com.heytap.mcs.liquid.service.download.result.ILiquidBatchCallback;
import com.heytap.mcs.liquid.service.download.result.ILiquidCallback;
import com.heytap.mcs.liquid.service.download.result.IPackageAuthCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ILiquidApiService extends IInterface {

    public static abstract class Stub extends Binder implements ILiquidApiService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f14195a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f14196b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f14197c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f14198d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f14199e = "com.heytap.mcs.liquid.service.download.ILiquidApiService";

        public static class a implements ILiquidApiService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static ILiquidApiService f14200a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f14201b;

            public a(IBinder iBinder) {
                this.f14201b = iBinder;
            }

            public String a() {
                return Stub.f14199e;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f14201b;
            }

            @Override // com.heytap.mcs.liquid.service.download.ILiquidApiService
            public List<String> a(String str) {
                List<String> listCreateStringArrayList;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.f14199e);
                    parcelObtain.writeString(str);
                    if (this.f14201b.transact(3, parcelObtain, parcelObtain2, 0) || Stub.a() == null) {
                        parcelObtain2.readException();
                        listCreateStringArrayList = parcelObtain2.createStringArrayList();
                    } else {
                        listCreateStringArrayList = Stub.a().a(str);
                    }
                    return listCreateStringArrayList;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.mcs.liquid.service.download.ILiquidApiService
            public void a(String str, int i9, String str2, String str3, String str4, int i10, String str5, ActionInfo actionInfo, ActionInfo actionInfo2, int i11, ILiquidCallback iLiquidCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.f14199e);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i9);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str5);
                    if (actionInfo != null) {
                        parcelObtain.writeInt(1);
                        actionInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (actionInfo2 != null) {
                        parcelObtain.writeInt(1);
                        actionInfo2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeStrongBinder(iLiquidCallback != null ? iLiquidCallback.asBinder() : null);
                    try {
                        if (this.f14201b.transact(1, parcelObtain, parcelObtain2, 0) || Stub.a() == null) {
                            parcelObtain2.readException();
                        } else {
                            Stub.a().a(str, i9, str2, str3, str4, i10, str5, actionInfo, actionInfo2, i11, iLiquidCallback);
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.heytap.mcs.liquid.service.download.ILiquidApiService
            public void a(String str, IPackageAuthCallback iPackageAuthCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.f14199e);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iPackageAuthCallback != null ? iPackageAuthCallback.asBinder() : null);
                    if (this.f14201b.transact(4, parcelObtain, parcelObtain2, 0) || Stub.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.a().a(str, iPackageAuthCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.heytap.mcs.liquid.service.download.ILiquidApiService
            public void a(List<SeedingRequest> list, ILiquidBatchCallback iLiquidBatchCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.f14199e);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeStrongBinder(iLiquidBatchCallback != null ? iLiquidBatchCallback.asBinder() : null);
                    if (this.f14201b.transact(2, parcelObtain, parcelObtain2, 0) || Stub.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.a().a(list, iLiquidBatchCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, f14199e);
        }

        public static ILiquidApiService a() {
            return a.f14200a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            if (i9 == 1) {
                parcel.enforceInterface(f14199e);
                a(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? ActionInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? ActionInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), ILiquidCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i9 == 2) {
                parcel.enforceInterface(f14199e);
                a(parcel.createTypedArrayList(SeedingRequest.CREATOR), ILiquidBatchCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i9 == 3) {
                parcel.enforceInterface(f14199e);
                List<String> listA = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStringList(listA);
                return true;
            }
            if (i9 != 4) {
                if (i9 != 1598968902) {
                    return super.onTransact(i9, parcel, parcel2, i10);
                }
                parcel2.writeString(f14199e);
                return true;
            }
            parcel.enforceInterface(f14199e);
            a(parcel.readString(), IPackageAuthCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static ILiquidApiService a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f14199e);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILiquidApiService)) ? new a(iBinder) : (ILiquidApiService) iInterfaceQueryLocalInterface;
        }

        public static boolean a(ILiquidApiService iLiquidApiService) {
            if (a.f14200a != null || iLiquidApiService == null) {
                return false;
            }
            a.f14200a = iLiquidApiService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class a implements ILiquidApiService {
        @Override // com.heytap.mcs.liquid.service.download.ILiquidApiService
        public List<String> a(String str) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.heytap.mcs.liquid.service.download.ILiquidApiService
        public void a(String str, int i9, String str2, String str3, String str4, int i10, String str5, ActionInfo actionInfo, ActionInfo actionInfo2, int i11, ILiquidCallback iLiquidCallback) {
        }

        @Override // com.heytap.mcs.liquid.service.download.ILiquidApiService
        public void a(String str, IPackageAuthCallback iPackageAuthCallback) {
        }

        @Override // com.heytap.mcs.liquid.service.download.ILiquidApiService
        public void a(List<SeedingRequest> list, ILiquidBatchCallback iLiquidBatchCallback) {
        }
    }

    List<String> a(String str);

    void a(String str, int i9, String str2, String str3, String str4, int i10, String str5, ActionInfo actionInfo, ActionInfo actionInfo2, int i11, ILiquidCallback iLiquidCallback);

    void a(String str, IPackageAuthCallback iPackageAuthCallback);

    void a(List<SeedingRequest> list, ILiquidBatchCallback iLiquidBatchCallback);
}
