package p169v6;

import android.media.MediaFormat;
import p146s6.c;
import p146s6.e;

/* JADX INFO: compiled from: PcmFormat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21937a = "audio/raw";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21938b = true;

    @Override // p169v6.e
    public final c d(String str) {
        return new e(str);
    }

    @Override // p169v6.e
    public final MediaFormat f(q6.e eVar) {
        int i9 = eVar.f21022p;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f21937a);
        mediaFormat.setInteger("sample-rate", eVar.f21010c);
        mediaFormat.setInteger("channel-count", i9);
        mediaFormat.setInteger("x-frame-size-in-bytes", (i9 * 16) / 8);
        return mediaFormat;
    }

    @Override // p169v6.e
    public final String g() {
        return this.f21937a;
    }

    @Override // p169v6.e
    public final boolean h() {
        return this.f21938b;
    }
}
