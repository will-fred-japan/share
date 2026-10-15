package O4;

import S4.y;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends p048g5.b implements y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f3485c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3486b;

    public n(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData", 0);
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.f3486b = Arrays.hashCode(bArr);
    }

    public static byte[] P(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e9) {
            throw new AssertionError(e9);
        }
    }

    @Override // S4.y
    public final int J() {
        return this.f3486b;
    }

    public abstract byte[] Q();

    public final boolean equals(Object obj) {
        p035e5.a aVarK;
        if (obj != null && (obj instanceof y)) {
            try {
                y yVar = (y) obj;
                if (yVar.J() == this.f3486b && (aVarK = yVar.k()) != null) {
                    return Arrays.equals(Q(), (byte[]) p035e5.b.Q(aVarK));
                }
            } catch (RemoteException e9) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e9);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3486b;
    }

    @Override // S4.y
    public final p035e5.a k() {
        return new p035e5.b(Q());
    }

    @Override // p048g5.b
    public final boolean y(int i9, Parcel parcel, Parcel parcel2) {
        if (i9 != 1) {
            if (i9 != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.f3486b);
            return true;
        }
        IInterface iInterfaceK = k();
        parcel2.writeNoException();
        int i10 = p048g5.c.f18879a;
        parcel2.writeStrongBinder((p048g5.b) iInterfaceK);
        return true;
    }
}
