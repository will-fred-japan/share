package p169v6;

import android.media.MediaFormat;
import kotlin.jvm.internal.k;
import p146s6.c;
import p146s6.d;
import q6.b;
import q6.e;

/* JADX INFO: compiled from: AacFormat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21925a = "audio/mp4a-latm";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21926b = 44100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21927c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21928d = 2;

    @Override // p169v6.e
    public final void b(MediaFormat format, int i9) {
        k.e(format, "format");
        super.b(format, i9);
        this.f21927c = i9;
    }

    @Override // p169v6.e
    public final void c(MediaFormat format, int i9) {
        k.e(format, "format");
        super.c(format, i9);
        this.f21926b = i9;
    }

    @Override // p169v6.e
    public final c d(String str) {
        if (str != null) {
            return new d(0, str, true);
        }
        int i9 = this.f21928d;
        if (i9 == 2) {
            return new p146s6.a(this.f21926b, this.f21927c, i9);
        }
        throw new IllegalArgumentException("Stream is not supported.");
    }

    @Override // p169v6.e
    public final MediaFormat f(e eVar) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f21925a);
        mediaFormat.setInteger("sample-rate", eVar.f21010c);
        mediaFormat.setInteger("channel-count", eVar.f21022p);
        mediaFormat.setInteger("bitrate", eVar.f21009b);
        b bVar = b.f20989a;
        b bVar2 = eVar.f21024r;
        if (bVar2 == bVar) {
            mediaFormat.setInteger("aac-profile", 2);
        } else if (bVar2 == b.f20990b) {
            mediaFormat.setInteger("aac-profile", 39);
        } else if (bVar2 == b.f20991c) {
            mediaFormat.setInteger("aac-profile", 5);
        }
        this.f21926b = mediaFormat.getInteger("sample-rate");
        this.f21927c = mediaFormat.getInteger("channel-count");
        this.f21928d = mediaFormat.getInteger("aac-profile");
        return mediaFormat;
    }

    @Override // p169v6.e
    public final String g() {
        return this.f21925a;
    }

    @Override // p169v6.e
    public final boolean h() {
        return false;
    }
}
