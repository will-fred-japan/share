package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[][] f20840a;

    public class a implements Parcelable.Creator<GifViewSavedState> {
        @Override // android.os.Parcelable.Creator
        public final GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GifViewSavedState[] newArray(int i9) {
            return new GifViewSavedState[i9];
        }
    }

    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f20840a = new long[drawableArr.length][];
        for (int i9 = 0; i9 < drawableArr.length; i9++) {
            Drawable drawable = drawableArr[i9];
            if (drawable instanceof d) {
                this.f20840a[i9] = ((d) drawable).f20849g.i();
            } else {
                this.f20840a[i9] = null;
            }
        }
    }

    public final void a(Drawable drawable, int i9) {
        long[] jArr = this.f20840a[i9];
        if (jArr == null || !(drawable instanceof d)) {
            return;
        }
        d dVar = (d) drawable;
        dVar.d(dVar.f20849g.r(jArr, dVar.f20848f));
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        super.writeToParcel(parcel, i9);
        long[][] jArr = this.f20840a;
        parcel.writeInt(jArr.length);
        for (long[] jArr2 : jArr) {
            parcel.writeLongArray(jArr2);
        }
    }

    public GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f20840a = new long[parcel.readInt()][];
        int i9 = 0;
        while (true) {
            long[][] jArr = this.f20840a;
            if (i9 >= jArr.length) {
                return;
            }
            jArr[i9] = parcel.createLongArray();
            i9++;
        }
    }
}
