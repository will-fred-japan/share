package W0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: OnePlusOaidImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class p implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f5025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f5026b = new a(1);

    /* JADX INFO: compiled from: OnePlusOaidImpl.java */
    public class a extends V0.a {
        @Override // V0.a
        public final Object a(Object[] objArr) {
            try {
                PackageInfo packageInfoB = A4.c.b(0, "com.heytap.openid", (Context) objArr[0]);
                if (packageInfoB == null) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfoB.getLongVersionCode() : (long) packageInfoB.versionCode) >= 1);
            } catch (Exception e9) {
                e9.printStackTrace();
                return Boolean.FALSE;
            }
        }
    }

    public p(t tVar) {
        this.f5025a = tVar;
    }

    @Override // W0.l
    public final l.a a(Context context) {
        t tVar = this.f5025a;
        if (tVar != null && !((Boolean) this.f5026b.b(new Object[0])).booleanValue()) {
            return tVar.a(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new s(context, intent, new b(context)).a();
        l.a aVar = new l.a();
        aVar.f5014a = str;
        return aVar;
    }

    @Override // W0.l
    public final boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Boolean bool = (Boolean) this.f5026b.b(context);
        t tVar = this.f5025a;
        return (tVar == null || bool.booleanValue()) ? bool.booleanValue() : tVar.b(context);
    }

    /* JADX INFO: compiled from: OnePlusOaidImpl.java */
    public class b implements s.b<Z0.a, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5027a;

        public b(Context context) {
            this.f5027a = context;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0066  */
        @Override // W0.s.b
        public final String a(Z0.a aVar) {
            Signature[] signatureArr;
            String string;
            Context context = this.f5027a;
            Z0.a aVar2 = aVar;
            String string2 = null;
            if (aVar2 != null) {
                p.this.getClass();
                try {
                    PackageInfo packageInfoB = A4.c.b(64, context.getPackageName(), context);
                    signatureArr = packageInfoB != null ? packageInfoB.signatures : null;
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
                if (signatureArr == null || signatureArr.length <= 0) {
                    string = null;
                } else {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] bArrDigest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b9 : bArrDigest) {
                                sb.append(Integer.toHexString((b9 & 255) | 256).substring(1, 3));
                            }
                            string = sb.toString();
                        } else {
                            string = null;
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    String packageName = context.getPackageName();
                    Z0.a.AbstractBinderC0082a.C0083a c0083a = (Z0.a.AbstractBinderC0082a.C0083a) aVar2;
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        parcelObtain.writeString(packageName);
                        parcelObtain.writeString(string);
                        parcelObtain.writeString("OUID");
                        c0083a.f5513a.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        string2 = parcelObtain2.readString();
                    } finally {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                }
            }
            return string2;
        }

        @Override // W0.s.b
        public final Z0.a a(IBinder iBinder) {
            int i9 = Z0.a.AbstractBinderC0082a.f5512a;
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof Z0.a)) {
                return (Z0.a) iInterfaceQueryLocalInterface;
            }
            Z0.a.AbstractBinderC0082a.C0083a c0083a = new Z0.a.AbstractBinderC0082a.C0083a();
            c0083a.f5513a = iBinder;
            return c0083a;
        }
    }
}
