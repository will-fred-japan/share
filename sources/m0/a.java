package m0;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImplApi26;
import java.util.Objects;

/* JADX INFO: compiled from: AudioFocusRequestCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AudioAttributesCompat f20309g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final I6.b f20311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f20312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AudioAttributesCompat f20313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f20314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AudioFocusRequest f20315f;

    /* JADX INFO: renamed from: m0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AudioFocusRequestCompat.java */
    public static class C0229a {
        public static AudioFocusRequest a(int i9, AudioAttributes audioAttributes, boolean z8, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            return new AudioFocusRequest.Builder(i9).setAudioAttributes(audioAttributes).setWillPauseWhenDucked(z8).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
        }
    }

    static {
        int i9 = AudioAttributesCompat.f7788b;
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setUsage(1);
        f20309g = new AudioAttributesCompat(new AudioAttributesImplApi26(builder.build()));
    }

    public a(int i9, I6.b bVar, Handler handler, AudioAttributesCompat audioAttributesCompat, boolean z8) {
        this.f20310a = i9;
        this.f20312c = handler;
        this.f20313d = audioAttributesCompat;
        this.f20314e = z8;
        this.f20311b = bVar;
        this.f20315f = C0229a.a(i9, audioAttributesCompat != null ? (AudioAttributes) audioAttributesCompat.f7789a.a() : null, z8, bVar, handler);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f20310a == aVar.f20310a && this.f20314e == aVar.f20314e && this.f20311b.equals(aVar.f20311b) && this.f20312c.equals(aVar.f20312c) && Objects.equals(this.f20313d, aVar.f20313d);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f20310a), this.f20311b, this.f20312c, this.f20313d, Boolean.valueOf(this.f20314e));
    }
}
