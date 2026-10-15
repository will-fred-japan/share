package com.starburst.sdk.core.opus;

import H2.a;
import com.starburst.sdk.business.b89;
import com.starburst.sdk.common.utils.PcmIntensityCalculator;
import com.starburst.sdk.common.utils.PcmIntensityCallback;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseOpusDecoder implements IOpusDecoder {
    private static final float MAX_16_BIT_VALUE = 32768.0f;
    private static final String TAG = "BaseOpusDecoder";
    private DecoderStateListener decoderStateListener;
    private PcmDataListener pcmDataListener;

    public static class DecoderConfig {
        public int sampleRate = 16000;
        public int numChannels = 2;
        public int encodedFrameLength = 80;
        public int originalSamplesPerFrame = 320;
        public int bitDepth = 16;
        public int totalDataLength = -1;
    }

    public interface DecoderStateListener {
        void onDecoderError(int i9, int i10, int i11, String str);

        void onDecoderSucceeded(int i9, int i10);
    }

    public interface PcmDataListener {
        void onIntensityData(int i9, float[][] fArr);

        void onStereoData(int i9, int i10, byte[] bArr);
    }

    public void clearListeners() {
        this.pcmDataListener = null;
        this.decoderStateListener = null;
    }

    @Override // com.starburst.sdk.core.opus.IOpusDecoder
    public abstract void decode(DecoderConfig decoderConfig, int i9, int i10, byte[] bArr);

    public void fireDecoderError(int i9, int i10, int i11, String str) {
        DecoderStateListener decoderStateListener = this.decoderStateListener;
        if (decoderStateListener != null) {
            decoderStateListener.onDecoderError(i9, i10, i11, str);
        }
    }

    public void fireDecoderSuccess(int i9, int i10) {
        DecoderStateListener decoderStateListener = this.decoderStateListener;
        if (decoderStateListener != null) {
            decoderStateListener.onDecoderSucceeded(i9, i10);
        }
    }

    public void onDecodedPCMData(int i9, int i10, int i11, byte[] bArr) {
        StringBuilder sbG = a.g(i9, i10, "onDecodedPCMData channelCount=", ", requestId=", ", index=");
        sbG.append(i11);
        sbG.append(", pcmdata.length=");
        b89.a56(sbG, bArr != null ? bArr.length : 0, TAG);
        if (i9 == 1) {
            new PcmIntensityCalculator(bArr.length, new PcmIntensityCallback() { // from class: com.starburst.sdk.core.opus.BaseOpusDecoder.1
                @Override // com.starburst.sdk.common.utils.PcmIntensityCallback
                public void onPcmIntensity(int i12, float[][] fArr) {
                    if (BaseOpusDecoder.this.pcmDataListener != null) {
                        BaseOpusDecoder.this.pcmDataListener.onIntensityData(i12, fArr);
                    }
                }

                @Override // com.starburst.sdk.common.utils.PcmIntensityCallback
                public void onError(String str) {
                }
            }).processMonoPcm(bArr);
            return;
        }
        if (i9 == 2) {
            new PcmIntensityCalculator(bArr.length, new PcmIntensityCallback() { // from class: com.starburst.sdk.core.opus.BaseOpusDecoder.2
                @Override // com.starburst.sdk.common.utils.PcmIntensityCallback
                public void onPcmIntensity(int i12, float[][] fArr) {
                    if (BaseOpusDecoder.this.pcmDataListener != null) {
                        BaseOpusDecoder.this.pcmDataListener.onIntensityData(i12, fArr);
                    }
                }

                @Override // com.starburst.sdk.common.utils.PcmIntensityCallback
                public void onError(String str) {
                }
            }).processStereoPcm(bArr);
            PcmDataListener pcmDataListener = this.pcmDataListener;
            if (pcmDataListener != null) {
                pcmDataListener.onStereoData(i10, i11, bArr);
            }
        }
    }

    public void setDecoderStateListener(DecoderStateListener decoderStateListener) {
        this.decoderStateListener = decoderStateListener;
    }

    public void setPCMDataListener(PcmDataListener pcmDataListener) {
        this.pcmDataListener = pcmDataListener;
    }

    public void endSession(int i9) {
    }

    public void beginSession(DecoderConfig decoderConfig, int i9) {
    }
}
