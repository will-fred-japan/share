package com.starburst.sdk.common.utils;

/* JADX INFO: loaded from: classes.dex */
public class PcmIntensityCalculator {
    private static final float MAX_16_BIT_VALUE = 32768.0f;
    private final PcmIntensityCallback callback;
    private final int targetSampleCount;

    public PcmIntensityCalculator(int i9, PcmIntensityCallback pcmIntensityCallback) {
        this.callback = pcmIntensityCallback;
        this.targetSampleCount = i9;
    }

    private float[] calculateMonoIntensity(byte[] bArr) {
        int length = bArr.length / 2;
        float[] fArr = new float[length];
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 * 2;
            fArr[i9] = Math.abs((int) ((short) ((bArr[i10] & 255) | (bArr[i10 + 1] << 8)))) / MAX_16_BIT_VALUE;
        }
        return fArr;
    }

    private float[][] calculateStereoIntensity(byte[] bArr) {
        int length = bArr.length / 4;
        float[] fArr = new float[length];
        float[] fArr2 = new float[length];
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 * 4;
            short s8 = (short) ((bArr[i10 + 1] << 8) | (bArr[i10] & 255));
            short s9 = (short) ((bArr[i10 + 2] & 255) | (bArr[i10 + 3] << 8));
            fArr[i9] = Math.abs((int) s8) / MAX_16_BIT_VALUE;
            fArr2[i9] = Math.abs((int) s9) / MAX_16_BIT_VALUE;
        }
        return new float[][]{fArr, fArr2};
    }

    private float[] downSampleIntensities(float[] fArr, int i9) {
        if (fArr.length <= i9) {
            return fArr;
        }
        float[] fArr2 = new float[i9];
        float length = fArr.length / i9;
        int i10 = 0;
        while (i10 < i9) {
            int i11 = i10 + 1;
            int iMin = (int) Math.min(i11 * length, fArr.length);
            float f6 = 0.0f;
            for (int i12 = (int) (i10 * length); i12 < iMin; i12++) {
                float f9 = fArr[i12];
                if (f9 > f6) {
                    f6 = f9;
                }
            }
            fArr2[i10] = f6;
            i10 = i11;
        }
        return fArr2;
    }

    public void processMonoPcm(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            this.callback.onError("单声道PCM数据无效");
        } else {
            this.callback.onPcmIntensity(1, new float[][]{downSampleIntensities(calculateMonoIntensity(bArr), this.targetSampleCount)});
        }
    }

    public void processStereoPcm(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            this.callback.onError("立体声PCM数据无效");
            return;
        }
        float[][] fArrCalculateStereoIntensity = calculateStereoIntensity(bArr);
        this.callback.onPcmIntensity(2, new float[][]{downSampleIntensities(fArrCalculateStereoIntensity[0], this.targetSampleCount), downSampleIntensities(fArrCalculateStereoIntensity[1], this.targetSampleCount)});
    }

    public PcmIntensityCalculator(PcmIntensityCallback pcmIntensityCallback) {
        this(300, pcmIntensityCallback);
    }
}
