package p169v6;

import android.media.MediaFormat;
import p146s6.d;
import q6.e;

/* JADX INFO: compiled from: AmrWbFormat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f21931a = {6600, 8850, 12650, 14250, 15850, 18250, 19850, 23050, 23850};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21932b = "audio/amr-wb";

    @Override // p169v6.e
    public final p146s6.c d(String str) {
        if (str != null) {
            return new d(2, str, false);
        }
        throw new IllegalArgumentException("Path not provided. Stream is not supported.");
    }

    @Override // p169v6.e
    public final MediaFormat f(e eVar) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f21932b);
        mediaFormat.setInteger("sample-rate", 16000);
        mediaFormat.setInteger("channel-count", 1);
        mediaFormat.setInteger("bitrate", e.i(this.f21931a, eVar.f21009b));
        return mediaFormat;
    }

    @Override // p169v6.e
    public final String g() {
        return this.f21932b;
    }

    @Override // p169v6.e
    public final boolean h() {
        return false;
    }
}
