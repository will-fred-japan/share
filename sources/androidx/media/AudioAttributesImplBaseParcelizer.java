package androidx.media;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(p181x0.a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f7792a = aVar.j(audioAttributesImplBase.f7792a, 1);
        audioAttributesImplBase.f7793b = aVar.j(audioAttributesImplBase.f7793b, 2);
        audioAttributesImplBase.f7794c = aVar.j(audioAttributesImplBase.f7794c, 3);
        audioAttributesImplBase.f7795d = aVar.j(audioAttributesImplBase.f7795d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, p181x0.a aVar) {
        aVar.getClass();
        aVar.s(audioAttributesImplBase.f7792a, 1);
        aVar.s(audioAttributesImplBase.f7793b, 2);
        aVar.s(audioAttributesImplBase.f7794c, 3);
        aVar.s(audioAttributesImplBase.f7795d, 4);
    }
}
