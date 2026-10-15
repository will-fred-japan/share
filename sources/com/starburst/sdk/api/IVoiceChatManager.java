package com.starburst.sdk.api;

import com.starburst.sdk.req.VcSpeaker;
import com.starburst.sdk.req.VoiceChatStartConfig;

/* JADX INFO: loaded from: classes.dex */
public interface IVoiceChatManager {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int ERROR_CODE_SPEAKER_NOT_SET = 1005;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ERROR_CODE_SPEAKER_NOT_SET = 1005;

        private Companion() {
        }
    }

    public static final class DefaultImpls {
        public static void requestByText(IVoiceChatManager iVoiceChatManager, String str, boolean z8, VoiceChatStartConfig voiceChatStartConfig) {
            iVoiceChatManager.requestByText(str, z8);
        }
    }

    public interface IBluetoothDeviceController {
        void setStopNeedInterrupt(boolean z8);

        void startVoiceChat();

        void startVoiceChat(VoiceChatStartConfig voiceChatStartConfig);

        void stopVoiceChat(int i9);

        void syncPlayTtsToDevice(int i9);

        void syncStopPlayTtsToDevice(int i9);
    }

    void audioPlayEnd();

    void audioPlayStart();

    void fireImageData(byte[] bArr);

    void forceCloseSocket();

    IBluetoothDeviceController getBluetoothDeviceHandler();

    void getOpeningRemarks();

    void getOpeningRemarks(VoiceChatStartConfig voiceChatStartConfig);

    VcSpeaker getVcSpeaker();

    void getVcSpeakerList(ISpeakerListCallback iSpeakerListCallback);

    void interrupt();

    void interruptAndStartVoiceChat();

    void interruptAndStartVoiceChat(VoiceChatStartConfig voiceChatStartConfig);

    void prepareUploadImage();

    void recognizeImageByText(String str, byte[] bArr);

    void recognizeImageByText(String str, byte[] bArr, boolean z8);

    void removeVoiceChatCallback(IVoiceChatCallback iVoiceChatCallback);

    void requestByText(String str, boolean z8);

    void requestByText(String str, boolean z8, VoiceChatStartConfig voiceChatStartConfig);

    void resetTextConversationContext();

    void setMultiTurnEnabled(boolean z8);

    void setTtsSampleRate(int i9);

    void setTtsSpeed(float f6);

    void setVcSpeaker(VcSpeaker vcSpeaker);

    void setVoiceChatAudioFileSaveEnabled(boolean z8);

    void setVoiceChatCallback(IVoiceChatCallback iVoiceChatCallback);

    void startVoiceChat();

    void startVoiceChat(VoiceChatStartConfig voiceChatStartConfig);

    void stop();

    void stopVoiceChat();

    void synthesizeTts(String str);

    void useDefaultDialogType();

    void useMultiModalDialogType();
}
