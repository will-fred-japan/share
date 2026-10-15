package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import p181x0.a;
import p181x0.c;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVarM = remoteActionCompat.f7061a;
        if (aVar.h(1)) {
            cVarM = aVar.m();
        }
        remoteActionCompat.f7061a = (IconCompat) cVarM;
        CharSequence charSequenceG = remoteActionCompat.f7062b;
        if (aVar.h(2)) {
            charSequenceG = aVar.g();
        }
        remoteActionCompat.f7062b = charSequenceG;
        CharSequence charSequenceG2 = remoteActionCompat.f7063c;
        if (aVar.h(3)) {
            charSequenceG2 = aVar.g();
        }
        remoteActionCompat.f7063c = charSequenceG2;
        Parcelable parcelableK = remoteActionCompat.f7064d;
        if (aVar.h(4)) {
            parcelableK = aVar.k();
        }
        remoteActionCompat.f7064d = (PendingIntent) parcelableK;
        boolean zE = remoteActionCompat.f7065e;
        if (aVar.h(5)) {
            zE = aVar.e();
        }
        remoteActionCompat.f7065e = zE;
        boolean zE2 = remoteActionCompat.f7066f;
        if (aVar.h(6)) {
            zE2 = aVar.e();
        }
        remoteActionCompat.f7066f = zE2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f7061a;
        aVar.n(1);
        aVar.v(iconCompat);
        CharSequence charSequence = remoteActionCompat.f7062b;
        aVar.n(2);
        aVar.q(charSequence);
        CharSequence charSequence2 = remoteActionCompat.f7063c;
        aVar.n(3);
        aVar.q(charSequence2);
        PendingIntent pendingIntent = remoteActionCompat.f7064d;
        aVar.n(4);
        aVar.t(pendingIntent);
        boolean z8 = remoteActionCompat.f7065e;
        aVar.n(5);
        aVar.o(z8);
        boolean z9 = remoteActionCompat.f7066f;
        aVar.n(6);
        aVar.o(z9);
    }
}
