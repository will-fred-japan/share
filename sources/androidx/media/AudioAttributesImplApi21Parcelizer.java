package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(p181x0.a aVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        Parcelable parcelableK = audioAttributesImplApi21.f7790a;
        if (aVar.h(1)) {
            parcelableK = aVar.k();
        }
        audioAttributesImplApi21.f7790a = (AudioAttributes) parcelableK;
        audioAttributesImplApi21.f7791b = aVar.j(audioAttributesImplApi21.f7791b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, p181x0.a aVar) {
        aVar.getClass();
        AudioAttributes audioAttributes = audioAttributesImplApi21.f7790a;
        aVar.n(1);
        aVar.t(audioAttributes);
        aVar.s(audioAttributesImplApi21.f7791b, 2);
    }
}
