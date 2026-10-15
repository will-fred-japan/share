package i8;

import android.media.MediaPlayer;
import defpackage.f;
import h8.l;
import java.io.IOException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: UrlSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19321b;

    public d(String str, boolean z8) {
        this.f19320a = str;
        this.f19321b = z8;
    }

    @Override // i8.c
    public final void a(MediaPlayer mediaPlayer) throws IOException {
        k.e(mediaPlayer, "mediaPlayer");
        mediaPlayer.setDataSource(this.f19320a);
    }

    @Override // i8.c
    public final void b(l soundPoolPlayer) throws Throwable {
        k.e(soundPoolPlayer, "soundPoolPlayer");
        soundPoolPlayer.release();
        soundPoolPlayer.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.a(this.f19320a, dVar.f19320a) && this.f19321b == dVar.f19321b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f19321b) + (this.f19320a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UrlSource(url=");
        sb.append(this.f19320a);
        sb.append(", isLocal=");
        return f.g(sb, this.f19321b, ')');
    }
}
