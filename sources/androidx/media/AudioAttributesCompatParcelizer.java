package androidx.media;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(p181x0.a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        Object objM = audioAttributesCompat.f7789a;
        if (aVar.h(1)) {
            objM = aVar.m();
        }
        audioAttributesCompat.f7789a = (AudioAttributesImpl) objM;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, p181x0.a aVar) {
        aVar.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f7789a;
        aVar.n(1);
        aVar.v(audioAttributesImpl);
    }
}
