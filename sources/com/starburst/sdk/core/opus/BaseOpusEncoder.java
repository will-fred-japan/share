package com.starburst.sdk.core.opus;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseOpusEncoder implements IOpusEncoder {
    private OpusDataListener opusDataListener;
    private OpusFileListener opusFileListener;

    public interface OpusDataListener {
        void onOpusDataError(String str, int i9, String str2);

        void onOpusDataSuccess(String str, byte[] bArr);
    }

    public interface OpusFileListener {
        void onOpusFileError(String str, int i9, String str2);

        void onOpusFileSuccess(String str, String str2);
    }

    public void clearListeners() {
        this.opusDataListener = null;
        this.opusFileListener = null;
    }

    public EncoderSession createSession(OpusCodecConfig opusCodecConfig) {
        throw new UnsupportedOperationException("Encoder sessions are not implemented");
    }

    public void notifyOpusDataError(String str, int i9, String str2) {
        OpusDataListener opusDataListener = this.opusDataListener;
        if (opusDataListener != null) {
            opusDataListener.onOpusDataError(str, i9, str2);
        }
    }

    public void notifyOpusDataSuccess(String str, byte[] bArr) {
        OpusDataListener opusDataListener = this.opusDataListener;
        if (opusDataListener != null) {
            opusDataListener.onOpusDataSuccess(str, bArr);
        }
    }

    public void notifyOpusFileError(String str, int i9, String str2) {
        OpusFileListener opusFileListener = this.opusFileListener;
        if (opusFileListener != null) {
            opusFileListener.onOpusFileError(str, i9, str2);
        }
    }

    public void notifyOpusFileSuccess(String str, String str2) {
        OpusFileListener opusFileListener = this.opusFileListener;
        if (opusFileListener != null) {
            opusFileListener.onOpusFileSuccess(str, str2);
        }
    }

    public void setOpusDataListener(OpusDataListener opusDataListener) {
        this.opusDataListener = opusDataListener;
    }

    public void setOpusFileListener(OpusFileListener opusFileListener) {
        this.opusFileListener = opusFileListener;
    }

    public interface EncoderSession {
        byte[] encode(byte[] bArr);

        void release();

        default void reset() {
        }
    }

    @Override // com.starburst.sdk.core.opus.IOpusEncoder
    public void encode(String str, byte[] bArr) {
    }

    @Override // com.starburst.sdk.core.opus.IOpusEncoder
    public void encodeFile(String str, String str2, String str3) {
    }
}
