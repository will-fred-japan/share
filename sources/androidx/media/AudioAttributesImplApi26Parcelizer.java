package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(p181x0.a aVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        Parcelable parcelableK = audioAttributesImplApi26.f7790a;
        if (aVar.h(1)) {
            parcelableK = aVar.k();
        }
        audioAttributesImplApi26.f7790a = (AudioAttributes) parcelableK;
        audioAttributesImplApi26.f7791b = aVar.j(audioAttributesImplApi26.f7791b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, p181x0.a aVar) {
        aVar.getClass();
        AudioAttributes audioAttributes = audioAttributesImplApi26.f7790a;
        aVar.n(1);
        aVar.t(audioAttributes);
        aVar.s(audioAttributesImplApi26.f7791b, 2);
    }
}
