package m0;

import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* JADX INFO: compiled from: AudioManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static int a(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
        return audioManager.abandonAudioFocusRequest(audioFocusRequest);
    }

    public static int b(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
        return audioManager.requestAudioFocus(audioFocusRequest);
    }
}
