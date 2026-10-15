package p169v6;

import android.media.MediaFormat;
import p146s6.b;
import p146s6.c;
import q6.e;

/* JADX INFO: compiled from: FlacFormat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f21933a = {8000, 11025, 22050, 44100, 48000};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21934b = "audio/flac";

    @Override // p169v6.e
    public final c d(String str) {
        if (str != null) {
            return new b(str);
        }
        throw new IllegalArgumentException("Path not provided. Stream is not supported.");
    }

    @Override // p169v6.e
    public final MediaFormat f(e eVar) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f21934b);
        mediaFormat.setInteger("sample-rate", e.i(this.f21933a, eVar.f21010c));
        mediaFormat.setInteger("channel-count", eVar.f21022p);
        mediaFormat.setInteger("bitrate", 0);
        mediaFormat.setInteger("flac-compression-level", 8);
        return mediaFormat;
    }

    @Override // p169v6.e
    public final String g() {
        return this.f21934b;
    }

    @Override // p169v6.e
    public final boolean h() {
        return false;
    }
}
