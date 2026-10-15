package q6;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import p096m7.j;

/* JADX INFO: compiled from: RecordConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AudioDeviceInfo f21011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f21012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f21013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f21014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f21015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q6.a f21016i;
    public final boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f21017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f21018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f21019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f21020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f21021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f21022p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f21023q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f21024r;

    /* JADX INFO: compiled from: RecordConfig.kt */
    public static final class a {
        /* JADX WARN: Code duplicated, block: B:47:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:8:0x002b  */
        public static e a(j jVar, Context context) {
            int i9;
            int i10;
            int i11;
            q6.a aVar;
            Object next;
            AudioDeviceInfo audioDeviceInfo;
            k.e(context, "context");
            Map map = (Map) jVar.a("androidConfig");
            Object obj = map != null ? map.get("audioSource") : null;
            if (k.a(obj, "defaultSource")) {
                i10 = 0;
            } else if (k.a(obj, "mic")) {
                i10 = 1;
            } else if (k.a(obj, "voiceUplink")) {
                i10 = 2;
            } else if (k.a(obj, "voiceDownlink")) {
                i10 = 3;
            } else if (k.a(obj, "voiceCall")) {
                i10 = 4;
            } else if (k.a(obj, "camcorder")) {
                i10 = 5;
            } else if (k.a(obj, "voiceRecognition")) {
                i10 = 6;
            } else {
                if (k.a(obj, "voiceCommunication")) {
                    i9 = 7;
                } else if (k.a(obj, "remoteSubMix")) {
                    i9 = 8;
                } else if (k.a(obj, "unprocessed")) {
                    i9 = 9;
                } else if (!k.a(obj, "voicePerformance") || Build.VERSION.SDK_INT < 29) {
                    i10 = 0;
                } else {
                    i9 = 10;
                }
                i10 = i9;
            }
            Object obj2 = map != null ? map.get("audioManagerMode") : null;
            if (k.a(obj2, "modeNormal")) {
                i11 = 0;
            } else if (k.a(obj2, "modeRingtone")) {
                i11 = 1;
            } else if (k.a(obj2, "modeInCall")) {
                i11 = 2;
            } else if (k.a(obj2, "modeInCommunication")) {
                i11 = 3;
            } else if (k.a(obj2, "modeCallScreening")) {
                if (Build.VERSION.SDK_INT >= 30) {
                    i11 = 4;
                } else {
                    i11 = 0;
                }
            } else if (k.a(obj2, "modeCallRedirect")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    i11 = 5;
                } else {
                    i11 = 0;
                }
            } else if (!k.a(obj2, "modeCommunicationRedirect") || Build.VERSION.SDK_INT < 33) {
                i11 = 0;
            } else {
                i11 = 6;
            }
            Map map2 = (Map) (map != null ? map.get("service") : null);
            if (map2 != null) {
                Object obj3 = map2.get("title");
                k.c(obj3, "null cannot be cast to non-null type kotlin.String");
                aVar = new q6.a((String) obj3, (String) map2.get("content"));
            } else {
                aVar = null;
            }
            String str = (String) jVar.a("path");
            Object objA = jVar.a("encoder");
            if (objA == null) {
                objA = "aacLc";
            }
            String str2 = (String) objA;
            Object objA2 = jVar.a("bitRate");
            if (objA2 == null) {
                objA2 = 128000;
            }
            int iIntValue = ((Number) objA2).intValue();
            Object objA3 = jVar.a("sampleRate");
            if (objA3 == null) {
                objA3 = 44100;
            }
            int iIntValue2 = ((Number) objA3).intValue();
            Object objA4 = jVar.a("numChannels");
            if (objA4 == null) {
                objA4 = 2;
            }
            int iIntValue3 = ((Number) objA4).intValue();
            Map map3 = (Map) jVar.a("device");
            if (map3 == null) {
                audioDeviceInfo = null;
            } else {
                Object systemService = context.getSystemService("audio");
                k.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                AudioDeviceInfo[] devices = ((AudioManager) systemService).getDevices(1);
                k.b(devices);
                List listA = y7.f.a(devices);
                ArrayList arrayList = new ArrayList();
                for (Object obj4 : listA) {
                    AudioDeviceInfo audioDeviceInfo2 = (AudioDeviceInfo) obj4;
                    if (audioDeviceInfo2.isSource() && audioDeviceInfo2.getType() != 18 && audioDeviceInfo2.getType() != 25 && audioDeviceInfo2.getType() != 28) {
                        arrayList.add(obj4);
                    }
                }
                Iterator it = arrayList.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!k.a(String.valueOf(((AudioDeviceInfo) next).getId()), map3.get("id")));
                audioDeviceInfo = (AudioDeviceInfo) next;
            }
            Object objA5 = jVar.a("autoGain");
            Boolean bool = Boolean.FALSE;
            if (objA5 == null) {
                objA5 = bool;
            }
            boolean zBooleanValue = ((Boolean) objA5).booleanValue();
            Object objA6 = jVar.a("echoCancel");
            if (objA6 == null) {
                objA6 = bool;
            }
            boolean zBooleanValue2 = ((Boolean) objA6).booleanValue();
            Object objA7 = jVar.a("noiseSuppress");
            if (objA7 == null) {
                objA7 = bool;
            }
            boolean zBooleanValue3 = ((Boolean) objA7).booleanValue();
            Boolean bool2 = (Boolean) (map != null ? map.get("useLegacy") : null);
            if (bool2 == null) {
                bool2 = bool;
            }
            boolean zBooleanValue4 = bool2.booleanValue();
            Boolean bool3 = (Boolean) (map != null ? map.get("muteAudio") : null);
            if (bool3 == null) {
                bool3 = bool;
            }
            boolean zBooleanValue5 = bool3.booleanValue();
            Boolean bool4 = (Boolean) (map != null ? map.get("manageBluetooth") : null);
            Boolean bool5 = Boolean.TRUE;
            if (bool4 == null) {
                bool4 = bool5;
            }
            boolean zBooleanValue6 = bool4.booleanValue();
            Boolean bool6 = (Boolean) (map != null ? map.get("speakerphone") : null);
            if (bool6 != null) {
                bool = bool6;
            }
            boolean zBooleanValue7 = bool.booleanValue();
            Object objA8 = jVar.a("audioInterruption");
            c cVar = c.f20998a;
            if (objA8 == null) {
                objA8 = 1;
            }
            return new e(str, str2, iIntValue, iIntValue2, iIntValue3, audioDeviceInfo, zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, aVar, zBooleanValue5, zBooleanValue6, i10, zBooleanValue7, i11, ((Number) objA8).intValue(), (Integer) jVar.a("streamBufferSize"));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:54:0x00bb  */
    public e(String str, String str2, int i9, int i10, int i11, AudioDeviceInfo audioDeviceInfo, boolean z8, boolean z9, boolean z10, boolean z11, q6.a aVar, boolean z12, boolean z13, int i12, boolean z14, int i13, int i14, Integer num) {
        b bVar;
        this.f21008a = str;
        this.f21009b = i9;
        this.f21010c = i10;
        this.f21011d = audioDeviceInfo;
        this.f21012e = z8;
        this.f21013f = z9;
        this.f21014g = z10;
        this.f21015h = z11;
        this.f21016i = aVar;
        this.j = z12;
        this.f21017k = z13;
        this.f21018l = i12;
        this.f21019m = z14;
        this.f21020n = i13;
        this.f21021o = num;
        i11 = 1 >= i11 ? 1 : i11;
        this.f21022p = 2 <= i11 ? 2 : i11;
        c cVar = i14 != 0 ? (i14 == 1 || i14 != 2) ? c.f20999b : c.f21000c : c.f20998a;
        this.f21023q = cVar;
        switch (str2) {
            case "aacEld":
                bVar = b.f20990b;
                break;
            case "pcm16bits":
                bVar = b.f20995g;
                break;
            case "wav":
                bVar = b.f20997i;
                break;
            case "flac":
                bVar = b.f20994f;
                break;
            case "opus":
                bVar = b.f20996h;
                break;
            case "aacHe":
                bVar = b.f20991c;
                break;
            case "aacLc":
                bVar = b.f20989a;
                break;
            case "amrNb":
                bVar = b.f20992d;
                break;
            case "amrWb":
                bVar = b.f20993e;
                break;
            default:
                bVar = b.f20989a;
                break;
        }
        this.f21024r = bVar;
    }
}
