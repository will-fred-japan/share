package p169v6;

import O7.g;
import O7.h;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.util.Log;
import android.util.Range;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C0621a;
import kotlin.jvm.internal.k;
import p146s6.c;
import p161u6.a;
import p161u6.b;
import p178w6.d;
import y7.i;
import y7.s;

/* JADX INFO: compiled from: Format.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static int i(int[] values, int i9) {
        k.e(values, "values");
        int iAbs = Math.abs(values[0] - i9);
        int length = values.length;
        int i10 = 0;
        for (int i11 = 1; i11 < length; i11++) {
            int iAbs2 = Math.abs(values[i11] - i9);
            if (iAbs2 < iAbs) {
                i10 = i11;
                iAbs = iAbs2;
            }
        }
        if (i9 != values[i10]) {
            h hVar = new h(0, values.length - 1, 1);
            ArrayList arrayList = new ArrayList(i.E(hVar));
            Iterator<Integer> it = hVar.iterator();
            while (((g) it).f3590c) {
                arrayList.add(Integer.valueOf(values[((s) it).a()]));
            }
            Log.d("e", "Available values: " + arrayList);
            Log.d("e", "Adjusted to: " + values[i10]);
        }
        return values[i10];
    }

    public final boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities, q6.e eVar, MediaFormat mediaFormat) {
        if (codecCapabilities.isFormatSupported(mediaFormat)) {
            return true;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities != null) {
            Range<Integer> bitrateRange = audioCapabilities.getBitrateRange();
            k.d(bitrateRange, "getBitrateRange(...)");
            int iIntValue = ((Number) bitrateRange.getLower()).intValue();
            int iIntValue2 = eVar.f21009b;
            if (iIntValue > iIntValue2) {
                Object lower = bitrateRange.getLower();
                k.d(lower, "getLower(...)");
                iIntValue2 = ((Number) lower).intValue();
            } else if (((Number) bitrateRange.getUpper()).intValue() < iIntValue2) {
                Object upper = bitrateRange.getUpper();
                k.d(upper, "getUpper(...)");
                iIntValue2 = ((Number) upper).intValue();
            }
            mediaFormat.setInteger("bitrate", iIntValue2);
            if (audioCapabilities.getSupportedSampleRates() != null) {
                int[] supportedSampleRates = audioCapabilities.getSupportedSampleRates();
                k.d(supportedSampleRates, "getSupportedSampleRates(...)");
                c(mediaFormat, i(supportedSampleRates, eVar.f21010c));
            }
            b(mediaFormat, i(new int[]{1, audioCapabilities.getMaxInputChannelCount()}, eVar.f21022p));
        }
        return codecCapabilities.isFormatSupported(mediaFormat);
    }

    public void b(MediaFormat format, int i9) {
        k.e(format, "format");
        format.setInteger("channel-mask", i9);
    }

    public void c(MediaFormat format, int i9) {
        k.e(format, "format");
        format.setInteger("sample-rate", i9);
    }

    public abstract c d(String str);

    public final p188x7.e<a, MediaFormat> e(q6.e eVar, d dVar) throws Exception {
        String name;
        MediaFormat mediaFormatF = f(eVar);
        if (h()) {
            return new p188x7.e<>(new p161u6.c(eVar, this, mediaFormatF, dVar), mediaFormatF);
        }
        C0621a c0621aC = p011b4.h.C(new MediaCodecList(0).getCodecInfos());
        while (true) {
            if (!c0621aC.hasNext()) {
                name = null;
                break;
            }
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) c0621aC.next();
            if (mediaCodecInfo.isEncoder()) {
                try {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(g());
                    if (capabilitiesForType != null && a(capabilitiesForType, eVar, mediaFormatF)) {
                        name = mediaCodecInfo.getName();
                        break;
                    }
                } catch (IllegalArgumentException unused) {
                    continue;
                }
            }
        }
        String str = name;
        if (str != null) {
            return new p188x7.e<>(new b(eVar, this, mediaFormatF, dVar, str), mediaFormatF);
        }
        throw new Exception("No codec found for given config " + mediaFormatF + ". You should try with other values.");
    }

    public abstract MediaFormat f(q6.e eVar);

    public abstract String g();

    public abstract boolean h();
}
