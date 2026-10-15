package J6;

import com.bytedance.starburst.vad.StarburstVad;
import com.starburst.sdk.api.IVadProcessor;
import com.starburst.sdk.api.VadConfig;
import com.starburst.sdk.api.VadState;
import com.starburst.sdk.core.auth.AuthApiImpl;

/* JADX INFO: loaded from: classes.dex */
public final class d implements IVadProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StarburstVad f2736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final short[] f2737b = new short[480];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f2738c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2739d;

    public d(VadConfig vadConfig) {
        if (!AuthApiImpl.isAuthSuccess()) {
            throw new IllegalStateException("SDK authentication is required before using VAD");
        }
        VadConfig vadConfig2 = new VadConfig(vadConfig);
        this.f2736a = new StarburstVad(new StarburstVad.Config(vadConfig2.silenceThreshold, vadConfig2.energyThreshold, vadConfig2.minSpeechMs, vadConfig2.silenceDetectMs, vadConfig2.resetSilenceMs, vadConfig2.endSilenceMs, vadConfig2.longSpeechEndSilenceMs));
    }

    @Override // com.starburst.sdk.api.IVadProcessor, java.lang.AutoCloseable
    public final void close() {
        if (this.f2739d) {
            return;
        }
        this.f2739d = true;
        this.f2736a.close();
    }

    @Override // com.starburst.sdk.api.IVadProcessor
    public final VadState process(byte[] bArr, int i9, int i10) {
        short[] sArr;
        if (this.f2739d) {
            throw new IllegalStateException("VAD processor is closed");
        }
        if (!AuthApiImpl.isAuthSuccess()) {
            throw new IllegalStateException("SDK authentication is required before using VAD");
        }
        if (bArr == null || i9 < 0 || i10 != 960 || i9 > bArr.length - i10) {
            throw new IllegalArgumentException("VAD requires one complete 30 ms PCM16LE frame (960 bytes)");
        }
        int i11 = 0;
        while (true) {
            sArr = this.f2737b;
            if (i11 >= sArr.length) {
                break;
            }
            int i12 = (i11 * 2) + i9;
            sArr[i11] = (short) ((bArr[i12 + 1] << 8) | (bArr[i12] & 255));
            i11++;
        }
        StarburstVad.Result resultProcess = this.f2736a.process(sArr);
        int i13 = resultProcess.state;
        boolean z8 = i13 == 1;
        boolean z9 = i13 == 2;
        boolean z10 = resultProcess.trailingSilence;
        e eVar = this.f2738c;
        if (z9) {
            eVar.f2740a = false;
            eVar.f2741b = false;
            return VadState.END;
        }
        if (z8) {
            eVar.f2741b = true;
        }
        if (!eVar.f2741b || !z10 || eVar.f2740a) {
            return z8 ? VadState.SPEECH : VadState.SILENCE;
        }
        eVar.f2740a = true;
        return VadState.PREFETCH;
    }

    @Override // com.starburst.sdk.api.IVadProcessor
    public final void reset() {
        if (this.f2739d) {
            throw new IllegalStateException("VAD processor is closed");
        }
        if (!AuthApiImpl.isAuthSuccess()) {
            throw new IllegalStateException("SDK authentication is required before using VAD");
        }
        this.f2736a.reset();
        e eVar = this.f2738c;
        eVar.f2740a = false;
        eVar.f2741b = false;
    }
}
