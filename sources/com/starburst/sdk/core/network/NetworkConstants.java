package com.starburst.sdk.core.network;

import cn.jpush.android.local.JPushConstants;
import com.starburst.sdk.api.ServerDomainType;
import com.starburst.sdk.api.TtsStreamVersion;
import com.starburst.sdk.core.asr.a56;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkConstants {
    private static final String DOMESTIC_DOMAIN = "ainf.tis.cn-beijing.volces.com";
    private static final boolean IS_TEST_ENVIRONMENT = false;
    private static final String OVERSEAS_DOMAIN = "ainf.tis.ap-southeast-1.volces.com";
    private static volatile boolean customDomainEnabled;
    private static volatile Endpoints endpoints = createEndpoints(ServerDomainType.DOMESTIC);
    public static volatile String CUSTOM_DOMAIN = "";

    public static final class Endpoints {
        private final String asrByFileCreateSimpleUrl;
        private final String asrByFileCreateUrl;
        private final String asrByFileQuerySimpleUrl;
        private final String asrByFileQueryUrl;
        private final String asrWebSocketUrl;
        private final String chatWebSocketUrl;
        private final String deviceRegisterUrl;
        private final String feedAigcGenAsyncQueryUrl;
        private final String feedAigcGenAsyncUrl;
        private final String feedAigcGenSyncUrl;
        private final String feedContentUrl;
        private final String feedTagUrl;
        private final String guiControlWebSocketUrl;
        private final String httpBaseUrl;
        private final String imageRecognizeUrl;
        private final String llmStreamUrl;
        private final String podcastStreamUrl;
        private final String tcFeatureUrl;
        private final String textToSpeechStreamUrl;
        private final String textToSpeechStreamV2Url;
        private final String textToSpeechUrl;
        private final String tokenUrl;
        private final String uploadFileSignUrl;
        private final String voiceCloneWebSocketUrl;
        private final String webSocketBaseUrl;

        private Endpoints(String str, String str2) {
            this.httpBaseUrl = str;
            this.webSocketBaseUrl = str2;
            this.deviceRegisterUrl = a56.a56(str, "/tis/device/register");
            this.tokenUrl = a56.a56(str, "/tis/device/token/get");
            this.tcFeatureUrl = a56.a56(str, "/tis/device/get/tc/feature");
            this.llmStreamUrl = a56.a56(str, "/tis/ai/device/llm/stream");
            this.chatWebSocketUrl = a56.a56(str2, "/tis/ai/ws/audio/device/chat");
            this.asrWebSocketUrl = a56.a56(str2, "/tis/ai/ws/audio/device/asr");
            this.voiceCloneWebSocketUrl = a56.a56(str2, "/tis/ai/ws/audio/device/voiceclone");
            this.imageRecognizeUrl = a56.a56(str, "/tis/ai/multi/modal/image/recognize");
            this.feedTagUrl = a56.a56(str, "/tis/ai/interest/tag/get");
            this.feedContentUrl = a56.a56(str, "/tis/ai/interest/content/get");
            this.feedAigcGenSyncUrl = a56.a56(str, "/starburst/ai/aigc/create/sync");
            this.feedAigcGenAsyncUrl = a56.a56(str, "/starburst/ai/aigc/create/async");
            this.feedAigcGenAsyncQueryUrl = a56.a56(str, "/starburst/ai/aigc/task/query");
            this.uploadFileSignUrl = a56.a56(str, "/starburst/ai/tos/sign");
            this.asrByFileQueryUrl = a56.a56(str, "/tis/ai/audio/device/asr/byfile/query");
            this.asrByFileCreateUrl = a56.a56(str, "/tis/ai/audio/device/asr/byfile/create");
            this.asrByFileQuerySimpleUrl = a56.a56(str, "/tis/ai/audio/device/asr/byfile/query/simple");
            this.asrByFileCreateSimpleUrl = a56.a56(str, "/tis/ai/audio/device/asr/byfile/create/simple");
            this.textToSpeechUrl = a56.a56(str, "/starburst/ai/tts");
            String strA56 = a56.a56(str2, "/starburst/ai/tts/bidirection");
            this.textToSpeechStreamUrl = strA56;
            this.textToSpeechStreamV2Url = a56.a56(strA56, "/v2");
            this.guiControlWebSocketUrl = a56.a56(str2, "/starburst/ai/ws/gui/control");
            this.podcastStreamUrl = a56.a56(str, "/tis/ai/device/podcast/stream");
        }
    }

    private NetworkConstants() {
    }

    private static Endpoints createCustomEndpoints(String str) {
        String strTrimTrailingSlash = trimTrailingSlash(str.trim());
        if (strTrimTrailingSlash.startsWith(JPushConstants.HTTPS_PRE)) {
            return new Endpoints(strTrimTrailingSlash, "wss://" + strTrimTrailingSlash.substring(8));
        }
        if (strTrimTrailingSlash.startsWith(JPushConstants.HTTP_PRE)) {
            return new Endpoints(strTrimTrailingSlash, "ws://" + strTrimTrailingSlash.substring(7));
        }
        if (strTrimTrailingSlash.startsWith("wss://")) {
            return new Endpoints(JPushConstants.HTTPS_PRE + strTrimTrailingSlash.substring(6), strTrimTrailingSlash);
        }
        if (!strTrimTrailingSlash.startsWith("ws://")) {
            return new Endpoints(JPushConstants.HTTPS_PRE.concat(strTrimTrailingSlash), "wss://".concat(strTrimTrailingSlash));
        }
        return new Endpoints(JPushConstants.HTTP_PRE + strTrimTrailingSlash.substring(5), strTrimTrailingSlash);
    }

    private static Endpoints createEndpoints(ServerDomainType serverDomainType) {
        String str = serverDomainType == ServerDomainType.OVERSEAS ? OVERSEAS_DOMAIN : DOMESTIC_DOMAIN;
        return new Endpoints(JPushConstants.HTTPS_PRE.concat(str), "wss://".concat(str));
    }

    private static Endpoints currentEndpoints() {
        String strTrimTrailingSlash = CUSTOM_DOMAIN == null ? "" : trimTrailingSlash(CUSTOM_DOMAIN.trim());
        return (!customDomainEnabled || strTrimTrailingSlash.isEmpty()) ? endpoints : createCustomEndpoints(strTrimTrailingSlash);
    }

    public static String getAsrByFileCreateSimpleUrl() {
        return currentEndpoints().asrByFileCreateSimpleUrl;
    }

    public static String getAsrByFileCreateUrl() {
        return currentEndpoints().asrByFileCreateUrl;
    }

    public static String getAsrByFileQuerySimpleUrl() {
        return currentEndpoints().asrByFileQuerySimpleUrl;
    }

    public static String getAsrByFileQueryUrl() {
        return currentEndpoints().asrByFileQueryUrl;
    }

    public static String getAsrWebSocketUrl() {
        return currentEndpoints().asrWebSocketUrl;
    }

    public static String getChatWebSocketUrl() {
        return currentEndpoints().chatWebSocketUrl;
    }

    public static String getDeviceRegisterUrl() {
        return currentEndpoints().deviceRegisterUrl;
    }

    public static String getFeedAigcGenAsyncQueryUrl() {
        return currentEndpoints().feedAigcGenAsyncQueryUrl;
    }

    public static String getFeedAigcGenAsyncUrl() {
        return currentEndpoints().feedAigcGenAsyncUrl;
    }

    public static String getFeedAigcGenSyncUrl() {
        return currentEndpoints().feedAigcGenSyncUrl;
    }

    public static String getFeedContentUrl() {
        return currentEndpoints().feedContentUrl;
    }

    public static String getFeedTagUrl() {
        return currentEndpoints().feedTagUrl;
    }

    public static String getGuiControlWebSocketUrl() {
        return currentEndpoints().guiControlWebSocketUrl;
    }

    public static String getHttpBaseUrl() {
        return currentEndpoints().httpBaseUrl;
    }

    public static String getImageRecognizeUrl() {
        return currentEndpoints().imageRecognizeUrl;
    }

    public static String getLlmStreamUrl() {
        return currentEndpoints().llmStreamUrl;
    }

    public static String getPodcastStreamUrl() {
        return currentEndpoints().podcastStreamUrl;
    }

    public static String getTcFeatureUrl() {
        return currentEndpoints().tcFeatureUrl;
    }

    public static String getTextToSpeechStreamUrl() {
        return getTextToSpeechStreamUrl(TtsStreamVersion.V1);
    }

    public static String getTextToSpeechUrl() {
        return currentEndpoints().textToSpeechUrl;
    }

    public static String getTokenUrl() {
        return currentEndpoints().tokenUrl;
    }

    public static String getUploadFileSignUrl() {
        return currentEndpoints().uploadFileSignUrl;
    }

    public static String getVoiceCloneWebSocketUrl() {
        return currentEndpoints().voiceCloneWebSocketUrl;
    }

    public static String getWebSocketBaseUrl() {
        return currentEndpoints().webSocketBaseUrl;
    }

    public static void setCustomDomain(String str) {
        CUSTOM_DOMAIN = str == null ? "" : trimTrailingSlash(str.trim());
    }

    public static void setCustomDomainEnabled(boolean z8) {
        customDomainEnabled = z8;
    }

    public static synchronized void setServerDomain(ServerDomainType serverDomainType) {
        try {
            if (serverDomainType == null) {
                throw new IllegalArgumentException("ServerDomainType must not be null");
            }
            endpoints = createEndpoints(serverDomainType);
        } catch (Throwable th) {
            throw th;
        }
    }

    private static String trimTrailingSlash(String str) {
        int length = str.length();
        while (length > 0 && str.charAt(length - 1) == '/') {
            length--;
        }
        return str.substring(0, length);
    }

    public static String getTextToSpeechStreamUrl(TtsStreamVersion ttsStreamVersion) {
        Endpoints endpointsCurrentEndpoints = currentEndpoints();
        return ttsStreamVersion == TtsStreamVersion.V2 ? endpointsCurrentEndpoints.textToSpeechStreamV2Url : endpointsCurrentEndpoints.textToSpeechStreamUrl;
    }
}
