package androidx.media;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f7790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7791b = -1;

    public AudioAttributesImplApi21() {
    }

    @Override // androidx.media.AudioAttributesImpl
    public final Object a() {
        return this.f7790a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f7790a.equals(((AudioAttributesImplApi21) obj).f7790a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7790a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f7790a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this.f7790a = audioAttributes;
    }
}
