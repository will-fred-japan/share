package T4;

import W5.e;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: T4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static class C0056a extends RuntimeException {
        public C0056a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static BigDecimal a(Parcel parcel, int i9) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i10 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iQ);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i10);
    }

    public static Bundle b(Parcel parcel, int i9) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iQ);
        return bundle;
    }

    public static byte[] c(Parcel parcel, int i9) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iQ);
        return bArrCreateByteArray;
    }

    public static int[] d(Parcel parcel, int i9) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iQ);
        return iArrCreateIntArray;
    }

    public static <T extends Parcelable> T e(Parcel parcel, int i9, Parcelable.Creator<T> creator) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iQ);
        return tCreateFromParcel;
    }

    public static String f(Parcel parcel, int i9) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iQ);
        return string;
    }

    public static ArrayList<String> g(Parcel parcel, int i9) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iQ);
        return arrayListCreateStringArrayList;
    }

    public static <T> T[] h(Parcel parcel, int i9, Parcelable.Creator<T> creator) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iQ);
        return tArr;
    }

    public static <T> ArrayList<T> i(Parcel parcel, int i9, Parcelable.Creator<T> creator) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iQ);
        return arrayListCreateTypedArrayList;
    }

    public static void j(Parcel parcel, int i9) {
        if (parcel.dataPosition() != i9) {
            throw new C0056a(e.i(i9, "Overread allowed size end="), parcel);
        }
    }

    public static boolean k(Parcel parcel, int i9) {
        t(parcel, i9, 4);
        return parcel.readInt() != 0;
    }

    public static float l(Parcel parcel, int i9) {
        t(parcel, i9, 4);
        return parcel.readFloat();
    }

    public static IBinder m(Parcel parcel, int i9) {
        int iQ = q(parcel, i9);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iQ);
        return strongBinder;
    }

    public static int n(Parcel parcel, int i9) {
        t(parcel, i9, 4);
        return parcel.readInt();
    }

    public static long o(Parcel parcel, int i9) {
        t(parcel, i9, 8);
        return parcel.readLong();
    }

    public static Long p(Parcel parcel, int i9) {
        int iQ = q(parcel, i9);
        if (iQ == 0) {
            return null;
        }
        if (iQ == 8) {
            return Long.valueOf(parcel.readLong());
        }
        throw new C0056a("Expected size 8 got " + iQ + " (0x" + Integer.toHexString(iQ) + ")", parcel);
    }

    public static int q(Parcel parcel, int i9) {
        return (i9 & (-65536)) != -65536 ? (char) (i9 >> 16) : parcel.readInt();
    }

    public static void r(Parcel parcel, int i9) {
        parcel.setDataPosition(parcel.dataPosition() + q(parcel, i9));
    }

    public static int s(Parcel parcel) {
        int i9 = parcel.readInt();
        int iQ = q(parcel, i9);
        char c5 = (char) i9;
        int iDataPosition = parcel.dataPosition();
        if (c5 != 20293) {
            throw new C0056a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i9))), parcel);
        }
        int i10 = iQ + iDataPosition;
        if (i10 < iDataPosition || i10 > parcel.dataSize()) {
            throw new C0056a(e.h(iDataPosition, i10, "Size read is invalid start=", " end="), parcel);
        }
        return i10;
    }

    public static void t(Parcel parcel, int i9, int i10) {
        int iQ = q(parcel, i9);
        if (iQ == i10) {
            return;
        }
        throw new C0056a(A.a.j(H2.a.g(i10, iQ, "Expected size ", " got ", " (0x"), Integer.toHexString(iQ), ")"), parcel);
    }
}
