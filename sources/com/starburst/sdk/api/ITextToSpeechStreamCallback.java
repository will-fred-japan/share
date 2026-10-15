package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface ITextToSpeechStreamCallback {

    public static final class DefaultImpls {
        public static /* synthetic */ void onStatus$default(ITextToSpeechStreamCallback iTextToSpeechStreamCallback, String str, String str2, String str3, int i9, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onStatus");
            }
            if ((i9 & 4) != 0) {
                str3 = null;
            }
            iTextToSpeechStreamCallback.onStatus(str, str2, str3);
        }
    }

    void onAudioChunk(String str, byte[] bArr, boolean z8);

    void onCompleted(String str);

    void onError(int i9, String str);

    void onStatus(String str, String str2, String str3);
}
