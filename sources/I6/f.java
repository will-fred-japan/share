package I6;

import B0.C0296j;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MicrophoneInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.KeyEvent;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioAttributesImplApi26;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p096m7.j;
import p096m7.k;
import p096m7.l;

/* JADX INFO: compiled from: AndroidAudioManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements l.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f2582b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f2583a;

    /* JADX INFO: compiled from: AndroidAudioManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList f2584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m0.a f2585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f2586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e f2587d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Context f2588e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AudioManager f2589f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c f2590g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<AudioDeviceInfo> f2591h;

        public final boolean a() {
            Context context;
            Context context2 = this.f2588e;
            if (context2 == null) {
                return false;
            }
            d dVar = this.f2586c;
            if (dVar != null) {
                context2.unregisterReceiver(dVar);
                this.f2586c = null;
            }
            e eVar = this.f2587d;
            if (eVar != null && (context = this.f2588e) != null) {
                context.unregisterReceiver(eVar);
                this.f2587d = null;
            }
            m0.a aVar = this.f2585b;
            if (aVar != null) {
                AudioManager audioManager = this.f2589f;
                if (audioManager == null) {
                    throw new IllegalArgumentException("AudioManager must not be null");
                }
                int iA = m0.b.a(audioManager, aVar.f20315f);
                this.f2585b = null;
                if (iA != 1) {
                    return false;
                }
            }
            return true;
        }

        public final void b(Map map) {
            Object obj = map.get("downTime");
            long jLongValue = ((obj == null || (obj instanceof Long)) ? (Long) obj : Long.valueOf(((Integer) obj).intValue())).longValue();
            Object obj2 = map.get("eventTime");
            this.f2589f.dispatchMediaKeyEvent(new KeyEvent(jLongValue, ((obj2 == null || (obj2 instanceof Long)) ? (Long) obj2 : Long.valueOf(((Integer) obj2).intValue())).longValue(), ((Integer) map.get("action")).intValue(), ((Integer) map.get("keyCode")).intValue(), ((Integer) map.get("repeatCount")).intValue(), ((Integer) map.get("metaState")).intValue(), ((Integer) map.get("deviceId")).intValue(), ((Integer) map.get("scanCode")).intValue(), ((Integer) map.get("flags")).intValue(), ((Integer) map.get("source")).intValue()));
        }

        @TargetApi(23)
        public final ArrayList c(int i9) {
            f.e(23);
            ArrayList arrayList = new ArrayList();
            for (AudioDeviceInfo audioDeviceInfo : this.f2589f.getDevices(i9)) {
                arrayList.add(f.d("id", Integer.valueOf(audioDeviceInfo.getId()), "productName", audioDeviceInfo.getProductName(), "address", Build.VERSION.SDK_INT >= 28 ? audioDeviceInfo.getAddress() : null, "isSource", Boolean.valueOf(audioDeviceInfo.isSource()), "isSink", Boolean.valueOf(audioDeviceInfo.isSink()), "sampleRates", f.c(audioDeviceInfo.getSampleRates()), "channelMasks", f.c(audioDeviceInfo.getChannelMasks()), "channelIndexMasks", f.c(audioDeviceInfo.getChannelIndexMasks()), "channelCounts", f.c(audioDeviceInfo.getChannelCounts()), "encodings", f.c(audioDeviceInfo.getEncodings()), "type", Integer.valueOf(audioDeviceInfo.getType())));
            }
            return arrayList;
        }

        @TargetApi(28)
        public final ArrayList d() {
            f.e(28);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f2589f.getMicrophones().iterator();
            while (it.hasNext()) {
                MicrophoneInfo microphoneInfoI = C0296j.i(it.next());
                ArrayList arrayList2 = new ArrayList();
                for (Pair pair : microphoneInfoI.getFrequencyResponse()) {
                    arrayList2.add(new ArrayList(Arrays.asList(Double.valueOf(((Float) pair.first).floatValue()), Double.valueOf(((Float) pair.second).floatValue()))));
                }
                ArrayList arrayList3 = new ArrayList();
                for (Pair pair2 : microphoneInfoI.getChannelMapping()) {
                    arrayList3.add(new ArrayList(Arrays.asList((Integer) pair2.first, (Integer) pair2.second)));
                }
                arrayList.add(f.d(com.heytap.mcssdk.constant.b.f14292i, microphoneInfoI.getDescription(), "id", Integer.valueOf(microphoneInfoI.getId()), "type", Integer.valueOf(microphoneInfoI.getType()), "address", microphoneInfoI.getAddress(), "location", Integer.valueOf(microphoneInfoI.getLocation()), "group", Integer.valueOf(microphoneInfoI.getGroup()), "indexInTheGroup", Integer.valueOf(microphoneInfoI.getIndexInTheGroup()), "position", f.a(microphoneInfoI.getPosition()), "orientation", f.a(microphoneInfoI.getOrientation()), "frequencyResponse", arrayList2, "channelMapping", arrayList3, "sensitivity", Float.valueOf(microphoneInfoI.getSensitivity()), "maxSpl", Float.valueOf(microphoneInfoI.getMaxSpl()), "minSpl", Float.valueOf(microphoneInfoI.getMinSpl()), "directionality", Integer.valueOf(microphoneInfoI.getDirectionality())));
            }
            return arrayList;
        }

        public final void e(String str, Object... objArr) {
            for (f fVar : this.f2584a) {
                fVar.f2583a.a(str, new ArrayList(Arrays.asList(objArr)), null);
            }
        }

        public final boolean f(List<?> list) {
            if (this.f2585b != null) {
                return true;
            }
            Map map = (Map) list.get(0);
            int iIntValue = ((Integer) map.get("gainType")).intValue();
            AudioAttributesCompat audioAttributesCompat = m0.a.f20309g;
            if (iIntValue != 1 && iIntValue != 2 && iIntValue != 3 && iIntValue != 4) {
                throw new IllegalArgumentException(W5.e.i(iIntValue, "Illegal audio focus gain type "));
            }
            b bVar = new b(0, this);
            Handler handler = new Handler(Looper.getMainLooper());
            if (map.get("audioAttributes") != null) {
                Map map2 = (Map) map.get("audioAttributes");
                int i9 = AudioAttributesCompat.f7788b;
                AudioAttributes.Builder builder = new AudioAttributes.Builder();
                if (map2.get("contentType") != null) {
                    builder.setContentType(((Integer) map2.get("contentType")).intValue());
                }
                if (map2.get("flags") != null) {
                    builder.setFlags(((Integer) map2.get("flags")).intValue());
                }
                if (map2.get("usage") != null) {
                    builder.setUsage(((Integer) map2.get("usage")).intValue());
                }
                audioAttributesCompat = new AudioAttributesCompat(new AudioAttributesImplApi26(builder.build()));
            }
            m0.a aVar = new m0.a(iIntValue, bVar, handler, audioAttributesCompat, map.get("willPauseWhenDucked") != null ? ((Boolean) map.get("willPauseWhenDucked")).booleanValue() : false);
            this.f2585b = aVar;
            AudioManager audioManager = this.f2589f;
            if (audioManager == null) {
                throw new IllegalArgumentException("AudioManager must not be null");
            }
            boolean z8 = m0.b.b(audioManager, aVar.f20315f) == 1;
            if (z8) {
                if (this.f2586c == null) {
                    d dVar = new d(this);
                    this.f2586c = dVar;
                    I.a.c(this.f2588e, dVar, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
                }
                if (this.f2587d == null) {
                    e eVar = new e(this);
                    this.f2587d = eVar;
                    I.a.c(this.f2588e, eVar, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
                }
            }
            return z8;
        }
    }

    @TargetApi(28)
    public static ArrayList<Double> a(MicrophoneInfo.Coordinate3F coordinate3F) {
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(Double.valueOf(coordinate3F.x));
        arrayList.add(Double.valueOf(coordinate3F.y));
        arrayList.add(Double.valueOf(coordinate3F.z));
        return arrayList;
    }

    @TargetApi(23)
    public static HashMap b(AudioDeviceInfo audioDeviceInfo) {
        return d("id", Integer.valueOf(audioDeviceInfo.getId()), "productName", audioDeviceInfo.getProductName(), "address", Build.VERSION.SDK_INT >= 28 ? audioDeviceInfo.getAddress() : null, "isSource", Boolean.valueOf(audioDeviceInfo.isSource()), "isSink", Boolean.valueOf(audioDeviceInfo.isSink()), "sampleRates", audioDeviceInfo.getSampleRates(), "channelMasks", audioDeviceInfo.getChannelMasks(), "channelIndexMasks", audioDeviceInfo.getChannelIndexMasks(), "channelCounts", audioDeviceInfo.getChannelCounts(), "encodings", audioDeviceInfo.getEncodings(), "type", Integer.valueOf(audioDeviceInfo.getType()));
    }

    public static ArrayList<Integer> c(int[] iArr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i9 : iArr) {
            arrayList.add(Integer.valueOf(i9));
        }
        return arrayList;
    }

    public static HashMap d(Object... objArr) {
        HashMap map = new HashMap();
        for (int i9 = 0; i9 < objArr.length; i9 += 2) {
            map.put((String) objArr[i9], objArr[i9 + 1]);
        }
        return map;
    }

    public static void e(int i9) {
        if (Build.VERSION.SDK_INT < i9) {
            throw new RuntimeException(W5.e.i(i9, "Requires API level "));
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0210  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // m7.l.c
    public final void onMethodCall(j jVar, l.d dVar) {
        byte b9;
        try {
            List<?> list = (List) jVar.f20497b;
            String str = jVar.f20496a;
            boolean communicationDevice = false;
            switch (str.hashCode()) {
                case -1758921066:
                    if (str.equals("getCommunicationDevice")) {
                        b9 = 17;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1698305881:
                    if (str.equals("getDevices")) {
                        b9 = 40;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1679670739:
                    if (str.equals("isMicrophoneMute")) {
                        b9 = 29;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1582239800:
                    if (str.equals("getStreamMaxVolume")) {
                        b9 = 8;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1562927400:
                    if (str.equals("isSpeakerphoneOn")) {
                        b9 = 20;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1524320654:
                    if (str.equals("isHapticPlaybackSupported")) {
                        b9 = 42;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1504647535:
                    if (str.equals("requestAudioFocus")) {
                        b9 = 0;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1413157019:
                    if (str.equals("setMicrophoneMute")) {
                        b9 = 28;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1296413680:
                    if (str.equals("setSpeakerphoneOn")) {
                        b9 = 19;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1285190630:
                    if (str.equals("isBluetoothScoOn")) {
                        b9 = 27;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1197068311:
                    if (str.equals("adjustStreamVolume")) {
                        b9 = 4;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1091382445:
                    if (str.equals("getMicrophones")) {
                        b9 = 41;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1079290158:
                    if (str.equals("setAllowedCapturePolicy")) {
                        b9 = 21;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -1018676910:
                    if (str.equals("setBluetoothScoOn")) {
                        b9 = 26;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -809761226:
                    if (str.equals("getStreamMinVolume")) {
                        b9 = 9;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -763512583:
                    if (str.equals("loadSoundEffects")) {
                        b9 = 37;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -694417919:
                    if (str.equals("isMusicActive")) {
                        b9 = 32;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -580980717:
                    if (str.equals("startBluetoothSco")) {
                        b9 = 24;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -445792758:
                    if (str.equals("setCommunicationDevice")) {
                        b9 = 16;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -380792370:
                    if (str.equals("getStreamVolumeDb")) {
                        b9 = 11;
                    } else {
                        b9 = -1;
                    }
                    break;
                case -75324903:
                    if (str.equals("getMode")) {
                        b9 = 31;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 152385829:
                    if (str.equals("dispatchMediaKeyEvent")) {
                        b9 = 2;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 160987616:
                    if (str.equals("getParameters")) {
                        b9 = 35;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 186762163:
                    if (str.equals("stopBluetoothSco")) {
                        b9 = 25;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 276698416:
                    if (str.equals("getStreamVolume")) {
                        b9 = 10;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 469094495:
                    if (str.equals("isBluetoothScoAvailableOffCall")) {
                        b9 = 23;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 623794710:
                    if (str.equals("getRingerMode")) {
                        b9 = 7;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 935118828:
                    if (str.equals("setParameters")) {
                        b9 = 34;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 954131337:
                    if (str.equals("adjustVolume")) {
                        b9 = 5;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 976310915:
                    if (str.equals("isStreamMute")) {
                        b9 = 14;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1084758859:
                    if (str.equals("getProperty")) {
                        b9 = 39;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1163405254:
                    if (str.equals("getAllowedCapturePolicy")) {
                        b9 = AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1187450940:
                    if (str.equals("setStreamVolume")) {
                        b9 = 13;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1241312831:
                    if (str.equals("clearCommunicationDevice")) {
                        b9 = 18;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1258134830:
                    if (str.equals("adjustSuggestedStreamVolume")) {
                        b9 = 6;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1357290231:
                    if (str.equals("abandonAudioFocus")) {
                        b9 = 1;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1378317714:
                    if (str.equals("unloadSoundEffects")) {
                        b9 = 38;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1397925922:
                    if (str.equals("setRingerMode")) {
                        b9 = 12;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1504508844:
                    if (str.equals("playSoundEffect")) {
                        b9 = 36;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1570996442:
                    if (str.equals("getAvailableCommunicationDevices")) {
                        b9 = 15;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1984784677:
                    if (str.equals("setMode")) {
                        b9 = 30;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 1986792688:
                    if (str.equals("isVolumeFixed")) {
                        b9 = 3;
                    } else {
                        b9 = -1;
                    }
                    break;
                case 2093966320:
                    if (str.equals("generateAudioSessionId")) {
                        b9 = 33;
                    } else {
                        b9 = -1;
                    }
                    break;
                default:
                    b9 = -1;
                    break;
            }
            switch (b9) {
                case 0:
                    ((k) dVar).success(Boolean.valueOf(f2582b.f(list)));
                    break;
                case 1:
                    ((k) dVar).success(Boolean.valueOf(f2582b.a()));
                    break;
                case 2:
                    f2582b.b((Map) list.get(0));
                    ((k) dVar).success(null);
                    break;
                case 3:
                    a aVar = f2582b;
                    aVar.getClass();
                    e(21);
                    ((k) dVar).success(Boolean.valueOf(aVar.f2589f.isVolumeFixed()));
                    break;
                case 4:
                    f2582b.f2589f.adjustStreamVolume(((Integer) list.get(0)).intValue(), ((Integer) list.get(1)).intValue(), ((Integer) list.get(2)).intValue());
                    ((k) dVar).success(null);
                    break;
                case 5:
                    f2582b.f2589f.adjustVolume(((Integer) list.get(0)).intValue(), ((Integer) list.get(1)).intValue());
                    ((k) dVar).success(null);
                    break;
                case 6:
                    f2582b.f2589f.adjustSuggestedStreamVolume(((Integer) list.get(0)).intValue(), ((Integer) list.get(1)).intValue(), ((Integer) list.get(2)).intValue());
                    ((k) dVar).success(null);
                    break;
                case 7:
                    ((k) dVar).success(Integer.valueOf(f2582b.f2589f.getRingerMode()));
                    break;
                case 8:
                    ((k) dVar).success(Integer.valueOf(f2582b.f2589f.getStreamMaxVolume(((Integer) list.get(0)).intValue())));
                    break;
                case 9:
                    a aVar2 = f2582b;
                    int iIntValue = ((Integer) list.get(0)).intValue();
                    aVar2.getClass();
                    e(28);
                    ((k) dVar).success(Integer.valueOf(aVar2.f2589f.getStreamMinVolume(iIntValue)));
                    break;
                case 10:
                    ((k) dVar).success(Integer.valueOf(f2582b.f2589f.getStreamVolume(((Integer) list.get(0)).intValue())));
                    break;
                case 11:
                    a aVar3 = f2582b;
                    int iIntValue2 = ((Integer) list.get(0)).intValue();
                    int iIntValue3 = ((Integer) list.get(1)).intValue();
                    int iIntValue4 = ((Integer) list.get(2)).intValue();
                    aVar3.getClass();
                    e(28);
                    ((k) dVar).success(Float.valueOf(aVar3.f2589f.getStreamVolumeDb(iIntValue2, iIntValue3, iIntValue4)));
                    break;
                case 12:
                    f2582b.f2589f.setRingerMode(((Integer) list.get(0)).intValue());
                    ((k) dVar).success(null);
                    break;
                case 13:
                    f2582b.f2589f.setStreamVolume(((Integer) list.get(0)).intValue(), ((Integer) list.get(1)).intValue(), ((Integer) list.get(2)).intValue());
                    ((k) dVar).success(null);
                    break;
                case 14:
                    a aVar4 = f2582b;
                    int iIntValue5 = ((Integer) list.get(0)).intValue();
                    aVar4.getClass();
                    e(23);
                    ((k) dVar).success(Boolean.valueOf(aVar4.f2589f.isStreamMute(iIntValue5)));
                    break;
                case 15:
                    a aVar5 = f2582b;
                    aVar5.getClass();
                    e(31);
                    aVar5.f2591h = aVar5.f2589f.getAvailableCommunicationDevices();
                    ArrayList arrayList = new ArrayList();
                    Iterator<AudioDeviceInfo> it = aVar5.f2591h.iterator();
                    while (it.hasNext()) {
                        arrayList.add(b(it.next()));
                    }
                    ((k) dVar).success(arrayList);
                    break;
                case 16:
                    a aVar6 = f2582b;
                    Integer num = (Integer) list.get(0);
                    aVar6.getClass();
                    e(31);
                    for (AudioDeviceInfo audioDeviceInfo : aVar6.f2591h) {
                        if (audioDeviceInfo.getId() == num.intValue()) {
                            communicationDevice = aVar6.f2589f.setCommunicationDevice(audioDeviceInfo);
                            ((k) dVar).success(Boolean.valueOf(communicationDevice));
                            break;
                        }
                    }
                    ((k) dVar).success(Boolean.valueOf(communicationDevice));
                    break;
                case 17:
                    a aVar7 = f2582b;
                    aVar7.getClass();
                    e(31);
                    ((k) dVar).success(b(aVar7.f2589f.getCommunicationDevice()));
                    break;
                case 18:
                    a aVar8 = f2582b;
                    aVar8.getClass();
                    e(31);
                    aVar8.f2589f.clearCommunicationDevice();
                    ((k) dVar).success(null);
                    break;
                case 19:
                    f2582b.f2589f.setSpeakerphoneOn(((Boolean) list.get(0)).booleanValue());
                    ((k) dVar).success(null);
                    break;
                case 20:
                    ((k) dVar).success(Boolean.valueOf(f2582b.f2589f.isSpeakerphoneOn()));
                    break;
                case 21:
                    a aVar9 = f2582b;
                    int iIntValue6 = ((Integer) list.get(0)).intValue();
                    aVar9.getClass();
                    e(29);
                    aVar9.f2589f.setAllowedCapturePolicy(iIntValue6);
                    ((k) dVar).success(null);
                    break;
                case 22:
                    a aVar10 = f2582b;
                    aVar10.getClass();
                    e(29);
                    ((k) dVar).success(Integer.valueOf(aVar10.f2589f.getAllowedCapturePolicy()));
                    break;
                case 23:
                    ((k) dVar).success(Boolean.valueOf(f2582b.f2589f.isBluetoothScoAvailableOffCall()));
                    break;
                case 24:
                    f2582b.f2589f.startBluetoothSco();
                    ((k) dVar).success(null);
                    break;
                case 25:
                    f2582b.f2589f.stopBluetoothSco();
                    ((k) dVar).success(null);
                    break;
                case 26:
                    f2582b.f2589f.setBluetoothScoOn(((Boolean) list.get(0)).booleanValue());
                    ((k) dVar).success(null);
                    break;
                case 27:
                    ((k) dVar).success(Boolean.valueOf(f2582b.f2589f.isBluetoothScoOn()));
                    break;
                case 28:
                    f2582b.f2589f.setMicrophoneMute(((Boolean) list.get(0)).booleanValue());
                    ((k) dVar).success(null);
                    break;
                case 29:
                    ((k) dVar).success(Boolean.valueOf(f2582b.f2589f.isMicrophoneMute()));
                    break;
                case 30:
                    f2582b.f2589f.setMode(((Integer) list.get(0)).intValue());
                    ((k) dVar).success(null);
                    break;
                case 31:
                    ((k) dVar).success(Integer.valueOf(f2582b.f2589f.getMode()));
                    break;
                case 32:
                    ((k) dVar).success(Boolean.valueOf(f2582b.f2589f.isMusicActive()));
                    break;
                case 33:
                    a aVar11 = f2582b;
                    aVar11.getClass();
                    e(21);
                    ((k) dVar).success(Integer.valueOf(aVar11.f2589f.generateAudioSessionId()));
                    break;
                case 34:
                    f2582b.f2589f.setParameters((String) list.get(0));
                    ((k) dVar).success(null);
                    break;
                case 35:
                    ((k) dVar).success(f2582b.f2589f.getParameters((String) list.get(0)));
                    break;
                case 36:
                    a aVar12 = f2582b;
                    int iIntValue7 = ((Integer) list.get(0)).intValue();
                    Double d9 = (Double) list.get(1);
                    if (d9 != null) {
                        aVar12.f2589f.playSoundEffect(iIntValue7, (float) d9.doubleValue());
                    } else {
                        aVar12.f2589f.playSoundEffect(iIntValue7);
                    }
                    ((k) dVar).success(null);
                    break;
                case 37:
                    f2582b.f2589f.loadSoundEffects();
                    ((k) dVar).success(null);
                    break;
                case 38:
                    f2582b.f2589f.unloadSoundEffects();
                    ((k) dVar).success(null);
                    break;
                case 39:
                    ((k) dVar).success(f2582b.f2589f.getProperty((String) list.get(0)));
                    break;
                case 40:
                    ((k) dVar).success(f2582b.c(((Integer) list.get(0)).intValue()));
                    break;
                case 41:
                    ((k) dVar).success(f2582b.d());
                    break;
                case 42:
                    f2582b.getClass();
                    e(29);
                    ((k) dVar).success(Boolean.valueOf(AudioManager.isHapticPlaybackSupported()));
                    break;
                default:
                    ((k) dVar).notImplemented();
                    break;
            }
        } catch (Exception e9) {
            e9.printStackTrace();
            ((k) dVar).error("Error: " + e9, null, null);
        }
    }
}
