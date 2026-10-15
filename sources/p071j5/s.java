package p071j5;

import S4.C0376g;
import T4.a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = a.s(parcel);
        ArrayList arrayListI = null;
        boolean z8 = false;
        Bundle bundleB = null;
        int iN = 0;
        long jO = 0;
        long jO2 = 0;
        while (parcel.dataPosition() < iS) {
            int i9 = parcel.readInt();
            char c5 = (char) i9;
            if (c5 == 1) {
                arrayListI = a.i(parcel, i9, DetectedActivity.CREATOR);
            } else if (c5 == 2) {
                jO = a.o(parcel, i9);
            } else if (c5 == 3) {
                jO2 = a.o(parcel, i9);
            } else if (c5 == 4) {
                iN = a.n(parcel, i9);
            } else if (c5 != 5) {
                a.r(parcel, i9);
            } else {
                bundleB = a.b(parcel, i9);
            }
        }
        a.j(parcel, iS);
        ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult();
        C0376g.a("Must have at least 1 detected activity", (arrayListI == null || arrayListI.isEmpty()) ? false : true);
        if (jO > 0 && jO2 > 0) {
            z8 = true;
        }
        C0376g.a("Must set times", z8);
        activityRecognitionResult.f12674a = arrayListI;
        activityRecognitionResult.f12675b = jO;
        activityRecognitionResult.f12676c = jO2;
        activityRecognitionResult.f12677d = iN;
        activityRecognitionResult.f12678e = bundleB;
        return activityRecognitionResult;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i9) {
        return new ActivityRecognitionResult[i9];
    }
}
