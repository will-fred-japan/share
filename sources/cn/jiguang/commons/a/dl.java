package cn.jiguang.commons.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class dl implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f9889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9894f;

    public dl(IBinder iBinder) {
        this.f9889a = iBinder;
        String str = f.f10031c;
        this.f9891c = km.b("bFWKQsRzI9d+ktdqxw44MA==", str);
        this.f9892d = km.b("vWw3rdN6/HN94yy83HO8Lw==", str);
        this.f9893e = km.b("Ha7IUc4OlbRIQFpw3FJeZw==", str);
        this.f9894f = km.b("qFFOesfckPwVmbfqzGl5oBCLe9WD17E04n+Ic7C9fCw=", str);
    }

    private String a() {
        if (TextUtils.isEmpty(this.f9890b)) {
            PackageInfo packageInfoA = kg.a();
            if (packageInfoA == null) {
                ee.d("OppoAdvertisingInterface", "package get sign failed");
                return this.f9890b;
            }
            Signature[] signatureArr = packageInfoA.signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                try {
                    this.f9890b = jk.d(signatureArr[0].toByteArray());
                } catch (Throwable th) {
                    defpackage.f.n(th, new StringBuilder("package sign error: "), "OppoAdvertisingInterface");
                }
            }
        }
        return this.f9890b;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public final String a(Context context) {
        return context == null ? "" : a(context.getPackageName(), a(), this.f9891c);
    }

    private String a(String str, String str2, String str3) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(this.f9894f);
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            parcelObtain.writeString(str3);
            this.f9889a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        } catch (Throwable th) {
            try {
                ee.d("OppoAdvertisingInterface", "getIdByType error: " + th.getMessage());
                return "";
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
