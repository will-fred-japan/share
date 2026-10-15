package com.starburst.sdk.api;

import com.starburst.sdk.core.model.VoiceChatIntent;
import com.starburst.sdk.resp.QuestionSolveResult;

/* JADX INFO: loaded from: classes.dex */
public interface IVoiceChatCallback {
    void onAsr(int i9, boolean z8, String str);

    void onAudioFileSave(String str);

    void onError(int i9, String str);

    void onIntent(VoiceChatIntent voiceChatIntent, int i9, String str);

    void onOpen();

    void onResponse(int i9, boolean z8, String str);

    void onSpeech(int i9, int i10, int i11, byte[] bArr);

    default void onStateChange(int i9, String str) {
        onStateChange(str);
    }

    void onStateChange(String str);

    void onTtsSampleRate(int i9, int i10);

    default void onImageChatResponse(int i9, QuestionSolveResult questionSolveResult) {
    }

    default void onEmotion(int i9, String str, int i10, String str2) {
    }

    default void onEmotionRaw(int i9, String str, String str2, String str3) {
    }
}
