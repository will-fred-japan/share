package S4;

import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class T extends p048g5.a implements y {
    @Override // S4.y
    public final int J() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f18877c);
        Parcel parcelY = y(parcelObtain, 2);
        int i9 = parcelY.readInt();
        parcelY.recycle();
        return i9;
    }

    @Override // S4.y
    public final p035e5.a k() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f18877c);
        Parcel parcelY = y(parcelObtain, 1);
        p035e5.a aVarP = p035e5.a.AbstractBinderC0196a.P(parcelY.readStrongBinder());
        parcelY.recycle();
        return aVarP;
    }
}
