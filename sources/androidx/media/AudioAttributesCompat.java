package androidx.media;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompat implements p181x0.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f7788b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributesImpl f7789a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public AudioAttributesCompat() {
    }

    public static int b(int i9, int i10) {
        if ((i9 & 1) == 1) {
            return 7;
        }
        if ((i9 & 4) == 4) {
            return 6;
        }
        switch (i10) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 12:
            default:
                return 3;
            case 13:
                return 1;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f7789a;
        if (audioAttributesImpl == null) {
            return audioAttributesCompat.f7789a == null;
        }
        return audioAttributesImpl.equals(audioAttributesCompat.f7789a);
    }

    public final int hashCode() {
        return this.f7789a.hashCode();
    }

    public final String toString() {
        return this.f7789a.toString();
    }

    public AudioAttributesCompat(AudioAttributesImplApi26 audioAttributesImplApi26) {
        this.f7789a = audioAttributesImplApi26;
    }
}
