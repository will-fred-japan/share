package p169v6;

import android.media.MediaFormat;
import p146s6.c;
import p146s6.d;
import q6.e;

/* JADX INFO: compiled from: AmrNbFormat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f21929a = {4750, 5150, 5900, 6700, 7400, 7950, 10200, 12200};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21930b = "audio/3gpp";

    @Override // p169v6.e
    public final c d(String str) {
        if (str != null) {
            return new d(2, str, false);
        }
        throw new IllegalArgumentException("Path not provided. Stream is not supported.");
    }

    @Override // p169v6.e
    public final MediaFormat f(e eVar) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f21930b);
        mediaFormat.setInteger("sample-rate", 8000);
        mediaFormat.setInteger("channel-count", 1);
        mediaFormat.setInteger("bitrate", e.i(this.f21929a, eVar.f21009b));
        return mediaFormat;
    }

    @Override // p169v6.e
    public final String g() {
        return this.f21930b;
    }

    @Override // p169v6.e
    public final boolean h() {
        return false;
    }
}
