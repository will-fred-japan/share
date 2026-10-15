package p169v6;

import android.media.MediaFormat;
import android.os.Build;
import p146s6.c;
import p146s6.d;
import q6.e;

/* JADX INFO: compiled from: OpusFormat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f21935a = {8000, 12000, 16000, 24000, 48000};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21936b = "audio/opus";

    @Override // p169v6.e
    public final c d(String str) throws IllegalAccessException {
        if (str == null) {
            throw new IllegalArgumentException("Path not provided. Stream is not supported.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return new d(4, str, false);
        }
        throw new IllegalAccessException("Opus requires min API version: 29");
    }

    @Override // p169v6.e
    public final MediaFormat f(e eVar) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f21936b);
        mediaFormat.setInteger("sample-rate", e.i(this.f21935a, eVar.f21010c));
        mediaFormat.setInteger("channel-count", eVar.f21022p);
        mediaFormat.setInteger("bitrate", eVar.f21009b);
        return mediaFormat;
    }

    @Override // p169v6.e
    public final String g() {
        return this.f21936b;
    }

    @Override // p169v6.e
    public final boolean h() {
        return false;
    }
}
