package androidx.media;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7792a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7793b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7794c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7795d = -1;

    @Override // androidx.media.AudioAttributesImpl
    public final Object a() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f7793b != audioAttributesImplBase.f7793b) {
            return false;
        }
        int i9 = this.f7794c;
        int i10 = audioAttributesImplBase.f7794c;
        int iB = audioAttributesImplBase.f7795d;
        if (iB == -1) {
            iB = AudioAttributesCompat.b(i10, audioAttributesImplBase.f7792a);
        }
        if (iB == 6) {
            i10 |= 4;
        } else if (iB == 7) {
            i10 |= 1;
        }
        return i9 == (i10 & 273) && this.f7792a == audioAttributesImplBase.f7792a && this.f7795d == audioAttributesImplBase.f7795d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7793b), Integer.valueOf(this.f7794c), Integer.valueOf(this.f7792a), Integer.valueOf(this.f7795d)});
    }

    public final String toString() {
        String strI;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f7795d != -1) {
            sb.append(" stream=");
            sb.append(this.f7795d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i9 = this.f7792a;
        int i10 = AudioAttributesCompat.f7788b;
        switch (i9) {
            case 0:
                strI = "USAGE_UNKNOWN";
                break;
            case 1:
                strI = "USAGE_MEDIA";
                break;
            case 2:
                strI = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strI = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                strI = "USAGE_ALARM";
                break;
            case 5:
                strI = "USAGE_NOTIFICATION";
                break;
            case 6:
                strI = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                strI = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                strI = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                strI = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                strI = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strI = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                strI = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                strI = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                strI = "USAGE_GAME";
                break;
            case 15:
            default:
                strI = W5.e.i(i9, "unknown usage ");
                break;
            case 16:
                strI = "USAGE_ASSISTANT";
                break;
        }
        sb.append(strI);
        sb.append(" content=");
        sb.append(this.f7793b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f7794c).toUpperCase());
        return sb.toString();
    }
}
