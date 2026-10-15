package com.starburst.sdk.api;

import com.starburst.sdk.core.asr.AsrConfig;
import com.starburst.sdk.core.opus.BaseOpusDecoder;
import com.starburst.sdk.core.opus.BaseOpusEncoder;
import com.starburst.sdk.req.DeviceRecordConfig;
import com.starburst.sdk.req.LanguageType;
import com.starburst.sdk.req.TTsFormat;
import com.starburst.sdk.req.TTsType;

/* JADX INFO: loaded from: classes.dex */
public interface ISpeechProcessingManager {

    public interface IBluetoothDeviceController {
        void setCallChannelCount(int i9);

        void setDeviceTranslateLanguage(LanguageType languageType, LanguageType languageType2);

        void setOpusDecoder(BaseOpusDecoder baseOpusDecoder);

        void setOpusEncoder(BaseOpusEncoder baseOpusEncoder);

        void setTranslateLanForChannels(LanguageType languageType, LanguageType languageType2, LanguageType languageType3, LanguageType languageType4);

        void startA2DPTranslate(LanguageType languageType, LanguageType languageType2);

        void startDeviceRecord(int i9, boolean z8, LanguageType languageType, LanguageType languageType2, boolean z9, TTsFormat tTsFormat, TTsType tTsType, float f6, String str);

        void startDeviceRecord(int i9, boolean z8, LanguageType languageType, LanguageType languageType2, boolean z9, TTsFormat tTsFormat, TTsType tTsType, String str, float f6, String str2);

        void startDeviceRecord(DeviceRecordConfig deviceRecordConfig);

        void startDeviceRecorder(int i9);

        void startDeviceRecorder(int i9, String str);

        void stopA2DPTranslate();

        void stopDeviceRecorder(int i9);
    }

    void addSpeechProcessingListener(ISpeechProcessingCallback iSpeechProcessingCallback);

    void cancelSplitRequest();

    void enableSpeakerSeparate(boolean z8);

    void extracTraveInfoByText(String str, ISplitRequestCallback iSplitRequestCallback);

    IBluetoothDeviceController getBluetoothDeviceHandler();

    void removeSpeechProcessingListener(ISpeechProcessingCallback iSpeechProcessingCallback);

    void setAsrConfig(AsrConfig asrConfig);

    void setLlmTranslate(boolean z8);

    void setSpeechProcessingCallback(ISpeechProcessingCallback iSpeechProcessingCallback);

    void setTtsSampleRate(int i9);

    void setTtsSpeed(float f6);

    void startAsrByAudio(ISpeechProcessingCallback iSpeechProcessingCallback);

    void startAsrByAudio(boolean z8, LanguageType languageType, TTsFormat tTsFormat, String str, ISpeechProcessingCallback iSpeechProcessingCallback);

    void startAsrByAudio(boolean z8, LanguageType languageType, TTsFormat tTsFormat, String str, String str2, int i9, int i10, ISpeechProcessingCallback iSpeechProcessingCallback);

    void startAsrByAudio(boolean z8, LanguageType languageType, TTsFormat tTsFormat, String str, String str2, String str3, int i9, int i10, ISpeechProcessingCallback iSpeechProcessingCallback);

    void startAsrByAudio(boolean z8, TTsFormat tTsFormat, String str, ISpeechProcessingCallback iSpeechProcessingCallback);

    void startAsrByAudio(boolean z8, TTsFormat tTsFormat, String str, String str2, int i9, int i10, ISpeechProcessingCallback iSpeechProcessingCallback);

    void startTranslateByAudio(LanguageType languageType, LanguageType languageType2, ISpeechProcessingCallback iSpeechProcessingCallback);

    void startTranslateByAudio(LanguageType languageType, LanguageType languageType2, boolean z8, TTsFormat tTsFormat, String str, ISpeechProcessingCallback iSpeechProcessingCallback);

    void startTranslateByAudio(LanguageType languageType, LanguageType languageType2, boolean z8, TTsFormat tTsFormat, String str, String str2, int i9, int i10, ISpeechProcessingCallback iSpeechProcessingCallback);

    void startTranslateByAudio(LanguageType languageType, LanguageType languageType2, boolean z8, TTsFormat tTsFormat, String str, String str2, String str3, int i9, int i10, ISpeechProcessingCallback iSpeechProcessingCallback);

    void stopRecoder();

    void summaryByTextWithSplit(String str, ISplitRequestCallback iSplitRequestCallback);

    void textToSpeech(String str, String str2, String str3, float f6, String str4, String str5, ITextToSpeechCallback iTextToSpeechCallback);

    void textToSpeechByStream(String str, String str2, String str3, float f6, String str4, String str5, int i9, ITextToSpeechStreamCallback iTextToSpeechStreamCallback);

    void textToSpeechByStream(String str, String str2, String str3, float f6, String str4, String str5, int i9, TtsStreamVersion ttsStreamVersion, ITextToSpeechStreamCallback iTextToSpeechStreamCallback);

    void textToSpeechByStream(String str, String str2, String str3, float f6, String str4, String str5, ITextToSpeechStreamCallback iTextToSpeechStreamCallback);

    void textToSpeechByStream(String str, String str2, String str3, float f6, String str4, String str5, TtsStreamVersion ttsStreamVersion, ITextToSpeechStreamCallback iTextToSpeechStreamCallback);

    void translateByTextWithSplit(String str, LanguageType languageType, LanguageType languageType2, ISplitRequestCallback iSplitRequestCallback);
}
