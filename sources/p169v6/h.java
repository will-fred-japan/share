package p169v6;

import android.media.MediaFormat;
import p146s6.c;
import p146s6.f;
import q6.e;

/* JADX INFO: compiled from: WaveFormat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21939a = "audio/raw";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21940b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21941c;

    @Override // p169v6.e
    public final c d(String str) {
        if (str != null) {
            return new f(str, this.f21941c);
        }
        throw new IllegalArgumentException("Path not provided. Stream is not supported.");
    }

    @Override // p169v6.e
    public final MediaFormat f(e eVar) {
        int i9 = eVar.f21022p;
        this.f21941c = (i9 * 16) / 8;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f21939a);
        mediaFormat.setInteger("sample-rate", eVar.f21010c);
        mediaFormat.setInteger("channel-count", i9);
        mediaFormat.setInteger("x-frame-size-in-bytes", this.f21941c);
        return mediaFormat;
    }

    @Override // p169v6.e
    public final String g() {
        return this.f21939a;
    }

    @Override // p169v6.e
    public final boolean h() {
        return this.f21940b;
    }
}
