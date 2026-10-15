package g8;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import java.util.Objects;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: AudioContextAndroid.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f18979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f18980f;

    public a(int i9, int i10, int i11, int i12, boolean z8, boolean z9) {
        this.f18975a = z8;
        this.f18976b = z9;
        this.f18977c = i9;
        this.f18978d = i10;
        this.f18979e = i11;
        this.f18980f = i12;
    }

    public static a b(a aVar) {
        boolean z8 = aVar.f18975a;
        boolean z9 = aVar.f18976b;
        int i9 = aVar.f18977c;
        int i10 = aVar.f18978d;
        int i11 = aVar.f18979e;
        int i12 = aVar.f18980f;
        aVar.getClass();
        return new a(i9, i10, i11, i12, z8, z9);
    }

    public final AudioAttributes a() {
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(this.f18978d).setContentType(this.f18977c).build();
        k.d(audioAttributesBuild, "build(...)");
        return audioAttributesBuild;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f18975a == aVar.f18975a && this.f18976b == aVar.f18976b && this.f18977c == aVar.f18977c && this.f18978d == aVar.f18978d && this.f18979e == aVar.f18979e && this.f18980f == aVar.f18980f;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f18975a), Boolean.valueOf(this.f18976b), Integer.valueOf(this.f18977c), Integer.valueOf(this.f18978d), Integer.valueOf(this.f18979e), Integer.valueOf(this.f18980f));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AudioContextAndroid(isSpeakerphoneOn=");
        sb.append(this.f18975a);
        sb.append(", stayAwake=");
        sb.append(this.f18976b);
        sb.append(", contentType=");
        sb.append(this.f18977c);
        sb.append(", usageType=");
        sb.append(this.f18978d);
        sb.append(", audioFocus=");
        sb.append(this.f18979e);
        sb.append(", audioMode=");
        return H2.a.a(sb, this.f18980f, ')');
    }

    @SuppressLint({"InlinedApi"})
    public a() {
        this(2, 1, 1, 0, false, false);
    }
}
