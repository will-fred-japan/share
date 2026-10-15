package g8;

import K7.p;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h8.i;
import h8.k;
import h8.m;
import h8.n;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.j;
import p096m7.l;
import y7.u;

/* JADX INFO: compiled from: AudioplayersPlugin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements p042f7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f18981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f18982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p096m7.c f18983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f18984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, n> f18985e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g8.a f18986f = new g8.a();

    /* JADX INFO: compiled from: AudioplayersPlugin.kt */
    public /* synthetic */ class a extends j implements p<p096m7.j, l.d, p188x7.k> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:222:0x037a A[Catch: Exception -> 0x00d5, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d5, blocks: (B:20:0x0077, B:24:0x0088, B:27:0x0092, B:32:0x00b5, B:34:0x00b9, B:36:0x00bf, B:38:0x00c3, B:41:0x00c8, B:210:0x0351, B:42:0x00cd, B:43:0x00d4, B:30:0x009d, B:46:0x00d8, B:49:0x00e2, B:50:0x00eb, B:53:0x00f5, B:55:0x00ff, B:56:0x0109, B:57:0x0110, B:58:0x0111, B:61:0x011b, B:63:0x0122, B:64:0x0127, B:65:0x0131, B:68:0x013b, B:69:0x0140, B:72:0x014a, B:74:0x0154, B:76:0x015c, B:78:0x0165, B:79:0x016a, B:80:0x016f, B:81:0x0170, B:82:0x0177, B:83:0x0178, B:86:0x0182, B:88:0x018c, B:91:0x0199, B:93:0x019f, B:95:0x01a3, B:96:0x01aa, B:97:0x01b1, B:98:0x01b2, B:101:0x01bc, B:102:0x01c1, B:105:0x01cb, B:107:0x01cf, B:109:0x01d3, B:110:0x01d7, B:111:0x01dc, B:114:0x01e6, B:115:0x01eb, B:118:0x01f5, B:120:0x01ff, B:122:0x0207, B:124:0x020b, B:127:0x0212, B:129:0x0216, B:131:0x021a, B:132:0x021e, B:133:0x0225, B:134:0x0226, B:137:0x0230, B:139:0x023a, B:141:0x0244, B:142:0x0248, B:145:0x0253, B:146:0x025a, B:147:0x0261, B:148:0x0262, B:151:0x026c, B:153:0x0276, B:156:0x0283, B:158:0x0289, B:160:0x028d, B:161:0x0292, B:162:0x0299, B:163:0x029a, B:166:0x02a4, B:168:0x02a8, B:170:0x02ac, B:172:0x02b2, B:174:0x02bc, B:175:0x02c4, B:177:0x02c8, B:178:0x02cd, B:181:0x02d7, B:183:0x02df, B:184:0x02e4, B:185:0x02e9, B:186:0x02ea, B:189:0x02f4, B:191:0x02fe, B:194:0x030a, B:196:0x0310, B:198:0x0314, B:199:0x031a, B:200:0x0321, B:201:0x0322, B:204:0x032b, B:209:0x034e, B:211:0x0359, B:212:0x0360, B:207:0x0336, B:213:0x0361, B:216:0x036a, B:218:0x036e, B:220:0x0372, B:221:0x0376, B:222:0x037a), top: B:231:0x0077, inners: #0 }] */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // K7.p
        public final p188x7.k invoke(p096m7.j jVar, l.d dVar) {
            i iVar;
            i iVar2;
            i iVar3;
            i iVar4;
            i iVar5;
            i iVar6;
            i iVar7;
            p096m7.j p8 = jVar;
            l.d p9 = dVar;
            kotlin.jvm.internal.k.e(p8, "p0");
            kotlin.jvm.internal.k.e(p9, "p1");
            b bVar = (b) this.receiver;
            bVar.getClass();
            String str = (String) p8.a("playerId");
            if (str != null) {
                String str2 = p8.f20496a;
                boolean zA = kotlin.jvm.internal.k.a(str2, "create");
                ConcurrentHashMap<String, n> concurrentHashMap = bVar.f18985e;
                Object currentPosition = null;
                e eVarValueOf = null;
                duration = null;
                Object duration = null;
                d dVarValueOf = null;
                currentPosition = null;
                if (zA) {
                    p096m7.c cVar = bVar.f18983c;
                    if (cVar == null) {
                        kotlin.jvm.internal.k.i("binaryMessenger");
                        throw null;
                    }
                    c cVar2 = new c(new p096m7.d(cVar, "xyz.luan/audioplayers/events/".concat(str)));
                    g8.a aVarB = g8.a.b(bVar.f18986f);
                    k kVar = bVar.f18984d;
                    if (kVar == null) {
                        kotlin.jvm.internal.k.i("soundPoolManager");
                        throw null;
                    }
                    concurrentHashMap.put(str, new n(bVar, cVar2, aVarB, kVar));
                    p9.success(1);
                } else {
                    n nVar = concurrentHashMap.get(str);
                    if (nVar == null) {
                        throw new IllegalStateException("Player has not yet been created or has already been disposed.");
                    }
                    if (str2 != null) {
                        try {
                            int iHashCode = str2.hashCode();
                            c cVar3 = nVar.f19159b;
                            switch (iHashCode) {
                                case -1757019252:
                                    if (!str2.equals("getCurrentPosition")) {
                                        p9.notImplemented();
                                    } else {
                                        if (nVar.f19169m && (iVar = nVar.f19162e) != null) {
                                            currentPosition = iVar.getCurrentPosition();
                                        }
                                        p9.success(currentPosition);
                                    }
                                    break;
                                case -1722943962:
                                    if (!str2.equals("setPlayerMode")) {
                                        p9.notImplemented();
                                    } else {
                                        String str3 = (String) p8.a("playerMode");
                                        if (str3 != null) {
                                            dVarValueOf = d.valueOf(p027d5.a.B((String) y7.n.N(R7.l.a0(str3, new char[]{'.'}))));
                                        }
                                        if (dVarValueOf == null) {
                                            throw new IllegalStateException("playerMode is required");
                                        }
                                        nVar.g(dVarValueOf);
                                        p9.success(1);
                                    }
                                    break;
                                case -1660487654:
                                    if (!str2.equals("setBalance")) {
                                        p9.notImplemented();
                                    } else {
                                        Double d9 = (Double) p8.a("balance");
                                        if (d9 == null) {
                                            throw new IllegalStateException("balance is required");
                                        }
                                        float fDoubleValue = (float) d9.doubleValue();
                                        if (nVar.f19165h != fDoubleValue) {
                                            nVar.f19165h = fDoubleValue;
                                            if (!nVar.f19168l && (iVar2 = nVar.f19162e) != null) {
                                                n.j(iVar2, nVar.f19164g, fDoubleValue);
                                            }
                                        }
                                        p9.success(1);
                                    }
                                    break;
                                case -1630329231:
                                    if (!str2.equals("emitLog")) {
                                        p9.notImplemented();
                                    } else {
                                        String str4 = (String) p8.a("message");
                                        if (str4 == null) {
                                            throw new IllegalStateException("message is required");
                                        }
                                        nVar.c(str4);
                                        p9.success(1);
                                    }
                                    break;
                                case -934426579:
                                    if (!str2.equals("resume")) {
                                        p9.notImplemented();
                                    } else {
                                        if (!nVar.f19170n && !nVar.f19168l) {
                                            nVar.f19170n = true;
                                            if (nVar.f19162e == null) {
                                                i iVarB = nVar.b();
                                                nVar.f19162e = iVarB;
                                                i8.c cVar4 = nVar.f19163f;
                                                if (cVar4 != null) {
                                                    iVarB.b(cVar4);
                                                    nVar.a(iVarB);
                                                }
                                            } else if (nVar.f19169m) {
                                                nVar.f();
                                            }
                                        }
                                        p9.success(1);
                                    }
                                    break;
                                case -402284771:
                                    if (!str2.equals("setPlaybackRate")) {
                                        p9.notImplemented();
                                    } else {
                                        Double d10 = (Double) p8.a("playbackRate");
                                        if (d10 == null) {
                                            throw new IllegalStateException("playbackRate is required");
                                        }
                                        float fDoubleValue2 = (float) d10.doubleValue();
                                        if (nVar.f19166i != fDoubleValue2) {
                                            nVar.f19166i = fDoubleValue2;
                                            if (nVar.f19170n && (iVar3 = nVar.f19162e) != null) {
                                                iVar3.e(fDoubleValue2);
                                            }
                                        }
                                        p9.success(1);
                                    }
                                    break;
                                case -159032046:
                                    if (!str2.equals("setSourceUrl")) {
                                        p9.notImplemented();
                                    } else {
                                        String str5 = (String) p8.a(RemoteMessageConst.Notification.URL);
                                        if (str5 == null) {
                                            throw new IllegalStateException("url is required");
                                        }
                                        Boolean bool = (Boolean) p8.a("isLocal");
                                        try {
                                            nVar.i(new i8.d(str5, bool != null ? bool.booleanValue() : false));
                                            p9.success(1);
                                        } catch (FileNotFoundException e9) {
                                            p9.error("AndroidAudioError", "Failed to set source. For troubleshooting, see: https://github.com/bluefireteam/audioplayers/blob/main/troubleshooting.md", e9);
                                        }
                                    }
                                    break;
                                case 3526264:
                                    if (!str2.equals("seek")) {
                                        p9.notImplemented();
                                    } else {
                                        Integer num = (Integer) p8.a("position");
                                        if (num == null) {
                                            throw new IllegalStateException("position is required");
                                        }
                                        int iIntValue = num.intValue();
                                        if (nVar.f19169m && ((iVar4 = nVar.f19162e) == null || !iVar4.d())) {
                                            i iVar8 = nVar.f19162e;
                                            if (iVar8 != null) {
                                                iVar8.seekTo(iIntValue);
                                            }
                                            iIntValue = -1;
                                        }
                                        nVar.f19171o = iIntValue;
                                        p9.success(1);
                                    }
                                    break;
                                case 3540994:
                                    if (!str2.equals("stop")) {
                                        p9.notImplemented();
                                    } else {
                                        nVar.k();
                                        p9.success(1);
                                    }
                                    break;
                                case 85887754:
                                    if (!str2.equals("getDuration")) {
                                        p9.notImplemented();
                                    } else {
                                        if (nVar.f19169m && (iVar5 = nVar.f19162e) != null) {
                                            duration = iVar5.getDuration();
                                        }
                                        p9.success(duration);
                                    }
                                    break;
                                case 106440182:
                                    if (!str2.equals("pause")) {
                                        p9.notImplemented();
                                    } else {
                                        nVar.d();
                                        p9.success(1);
                                    }
                                    break;
                                case 670514716:
                                    if (!str2.equals("setVolume")) {
                                        p9.notImplemented();
                                    } else {
                                        Double d11 = (Double) p8.a("volume");
                                        if (d11 == null) {
                                            throw new IllegalStateException("volume is required");
                                        }
                                        float fDoubleValue3 = (float) d11.doubleValue();
                                        if (nVar.f19164g != fDoubleValue3) {
                                            nVar.f19164g = fDoubleValue3;
                                            if (!nVar.f19168l && (iVar6 = nVar.f19162e) != null) {
                                                n.j(iVar6, fDoubleValue3, nVar.f19165h);
                                            }
                                        }
                                        p9.success(1);
                                    }
                                    break;
                                case 910310901:
                                    if (!str2.equals("emitError")) {
                                        p9.notImplemented();
                                    } else {
                                        String str6 = (String) p8.a("code");
                                        if (str6 == null) {
                                            throw new IllegalStateException("code is required");
                                        }
                                        String str7 = (String) p8.a("message");
                                        if (str7 == null) {
                                            throw new IllegalStateException("message is required");
                                        }
                                        nVar.f19158a.getClass();
                                        m7.d.b.a aVar = cVar3.f18988b;
                                        if (aVar != null) {
                                            aVar.b(str6, str7, null);
                                        }
                                        p9.success(1);
                                    }
                                    break;
                                case 1090594823:
                                    if (!str2.equals("release")) {
                                        p9.notImplemented();
                                    } else {
                                        nVar.e();
                                        p9.success(1);
                                    }
                                    break;
                                case 1671767583:
                                    if (!str2.equals("dispose")) {
                                        p9.notImplemented();
                                    } else {
                                        nVar.e();
                                        m7.d.b.a aVar2 = cVar3.f18988b;
                                        if (aVar2 != null) {
                                            aVar2.a();
                                            cVar3.f18988b = null;
                                        }
                                        cVar3.f18987a.a(null);
                                        concurrentHashMap.remove(str);
                                        p9.success(1);
                                    }
                                    break;
                                case 1771699022:
                                    if (!str2.equals("setSourceBytes")) {
                                        p9.notImplemented();
                                    } else {
                                        byte[] bArr = (byte[]) p8.a("bytes");
                                        if (bArr == null) {
                                            throw new IllegalStateException("bytes are required");
                                        }
                                        nVar.i(new i8.b(bArr));
                                        p9.success(1);
                                    }
                                    break;
                                case 1902436987:
                                    if (!str2.equals("setAudioContext")) {
                                        p9.notImplemented();
                                    } else {
                                        nVar.l(p027d5.a.l(p8));
                                        p9.success(1);
                                    }
                                    break;
                                case 2096116872:
                                    if (!str2.equals("setReleaseMode")) {
                                        p9.notImplemented();
                                    } else {
                                        String str8 = (String) p8.a("releaseMode");
                                        if (str8 != null) {
                                            eVarValueOf = e.valueOf(p027d5.a.B((String) y7.n.N(R7.l.a0(str8, new char[]{'.'}))));
                                        }
                                        if (eVarValueOf == null) {
                                            throw new IllegalStateException("releaseMode is required");
                                        }
                                        if (nVar.j != eVarValueOf) {
                                            nVar.j = eVarValueOf;
                                            if (!nVar.f19168l && (iVar7 = nVar.f19162e) != null) {
                                                iVar7.a(eVarValueOf == e.f18992b);
                                            }
                                        }
                                        p9.success(1);
                                    }
                                    break;
                                default:
                                    p9.notImplemented();
                                    break;
                            }
                        } catch (Exception e10) {
                            p9.error("AndroidAudioError", e10.getMessage(), e10);
                        }
                    } else {
                        p9.notImplemented();
                    }
                }
            }
            return p188x7.k.f22364a;
        }
    }

    /* JADX INFO: renamed from: g8.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AudioplayersPlugin.kt */
    public /* synthetic */ class C0204b extends j implements p<p096m7.j, l.d, p188x7.k> {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:49:0x00e8  */
        @Override // K7.p
        public final p188x7.k invoke(p096m7.j jVar, l.d dVar) {
            p096m7.j p8 = jVar;
            l.d p9 = dVar;
            kotlin.jvm.internal.k.e(p8, "p0");
            kotlin.jvm.internal.k.e(p9, "p1");
            b bVar = (b) this.receiver;
            bVar.getClass();
            String str = p8.f20496a;
            if (str != null) {
                switch (str) {
                    case "emitLog":
                        String str2 = (String) p8.a("message");
                        if (str2 == null) {
                            throw new IllegalStateException("message is required");
                        }
                        bVar.b(str2);
                        p9.success(1);
                        break;
                    case "init":
                        ConcurrentHashMap<String, n> concurrentHashMap = bVar.f18985e;
                        Collection<n> collectionValues = concurrentHashMap.values();
                        kotlin.jvm.internal.k.d(collectionValues, "<get-values>(...)");
                        for (n nVar : collectionValues) {
                            nVar.e();
                            c cVar = nVar.f19159b;
                            m7.d.b.a aVar = cVar.f18988b;
                            if (aVar != null) {
                                aVar.a();
                                cVar.f18988b = null;
                            }
                            cVar.f18987a.a(null);
                        }
                        concurrentHashMap.clear();
                        p9.success(1);
                        break;
                    case "emitError":
                        String str3 = (String) p8.a("code");
                        if (str3 == null) {
                            throw new IllegalStateException("code is required");
                        }
                        String str4 = (String) p8.a("message");
                        if (str4 == null) {
                            throw new IllegalStateException("message is required");
                        }
                        c cVar2 = bVar.f18981a;
                        if (cVar2 == null) {
                            kotlin.jvm.internal.k.i("globalEvents");
                            throw null;
                        }
                        m7.d.b.a aVar2 = cVar2.f18988b;
                        if (aVar2 != null) {
                            aVar2.b(str3, str4, null);
                        }
                        p9.success(1);
                        break;
                    case "setAudioContext":
                        AudioManager audioManagerA = bVar.a();
                        audioManagerA.setMode(bVar.f18986f.f18980f);
                        audioManagerA.setSpeakerphoneOn(bVar.f18986f.f18975a);
                        bVar.f18986f = p027d5.a.l(p8);
                        p9.success(1);
                        break;
                    default:
                        p9.notImplemented();
                        break;
                }
            } else {
                p9.notImplemented();
            }
            return p188x7.k.f22364a;
        }
    }

    public static void c(n player, boolean z8) {
        kotlin.jvm.internal.k.e(player, "player");
        player.f19159b.c("audio.onPrepared", u.C(new p188x7.e("value", Boolean.valueOf(z8))));
    }

    public final AudioManager a() {
        Context context = this.f18982b;
        if (context == null) {
            kotlin.jvm.internal.k.i("context");
            throw null;
        }
        Object systemService = context.getApplicationContext().getSystemService("audio");
        kotlin.jvm.internal.k.c(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    public final void b(String message) {
        kotlin.jvm.internal.k.e(message, "message");
        c cVar = this.f18981a;
        if (cVar != null) {
            cVar.c("audio.onLog", u.C(new p188x7.e("value", message)));
        } else {
            kotlin.jvm.internal.k.i("globalEvents");
            throw null;
        }
    }

    @Override // p042f7.a
    public final void onAttachedToEngine(f7.a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        this.f18982b = binding.f18711a;
        p096m7.c cVar = binding.f18713c;
        this.f18983c = cVar;
        this.f18984d = new k(this);
        new l(cVar, "xyz.luan/audioplayers").b(new R3.c(6, this));
        new l(cVar, "xyz.luan/audioplayers.global").b(new R3.e(10, this));
        this.f18981a = new c(new p096m7.d(cVar, "xyz.luan/audioplayers.global/events"));
    }

    @Override // p042f7.a
    public final void onDetachedFromEngine(f7.a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        ConcurrentHashMap<String, n> concurrentHashMap = this.f18985e;
        Collection<n> collectionValues = concurrentHashMap.values();
        kotlin.jvm.internal.k.d(collectionValues, "<get-values>(...)");
        for (n nVar : collectionValues) {
            nVar.e();
            c cVar = nVar.f19159b;
            m7.d.b.a aVar = cVar.f18988b;
            if (aVar != null) {
                aVar.a();
                cVar.f18988b = null;
            }
            cVar.f18987a.a(null);
        }
        concurrentHashMap.clear();
        k kVar = this.f18984d;
        if (kVar == null) {
            kotlin.jvm.internal.k.i("soundPoolManager");
            throw null;
        }
        HashMap<AudioAttributes, m> map = kVar.f19136b;
        Iterator<Map.Entry<AudioAttributes, m>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            m value = it.next().getValue();
            value.f19155a.release();
            value.f19156b.clear();
            value.f19157c.clear();
        }
        map.clear();
        c cVar2 = this.f18981a;
        if (cVar2 == null) {
            kotlin.jvm.internal.k.i("globalEvents");
            throw null;
        }
        m7.d.b.a aVar2 = cVar2.f18988b;
        if (aVar2 != null) {
            aVar2.a();
            cVar2.f18988b = null;
        }
        cVar2.f18987a.a(null);
    }
}
