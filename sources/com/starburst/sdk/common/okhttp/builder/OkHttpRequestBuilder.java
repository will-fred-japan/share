package com.starburst.sdk.common.okhttp.builder;

import com.starburst.sdk.common.okhttp.builder.OkHttpRequestBuilder;
import com.starburst.sdk.common.okhttp.request.RequestCall;
import com.starburst.sdk.core.auth.AliAgentImpl;
import com.starburst.sdk.core.recorder.BaseAudioRecorder;
import com.starburst.sdk.resp.AuthInfoRes;
import com.starburst.sdk.utils.j;
import com.starburst.sdk.utils.k;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class OkHttpRequestBuilder<T extends OkHttpRequestBuilder> {
    protected Map<String, String> headers;
    protected int id;
    protected Map<String, String> params;
    protected Object tag;
    protected String url;

    public T addCommonHeaders(AuthInfoRes authInfoRes) {
        addHeader("appId", authInfoRes.getAppId());
        addHeader("token", authInfoRes.getToken());
        addHeader("productKey", authInfoRes.getProductKey());
        addHeader("deviceName", authInfoRes.getDeviceName());
        addHeader("timestamp", AliAgentImpl.sGetSignTimestamp);
        addHeader("sign", authInfoRes.getBusinessSign());
        addHeader("signMethod", AuthInfoRes.DEFAULT_SIGN_METHOD);
        return this;
    }

    public T addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new LinkedHashMap();
        }
        this.headers.put(str, str2);
        return this;
    }

    public T addPpeHeadersIfNeeded() {
        String str = this.url;
        HashMap<String, String> map = k.f16469a;
        String str2 = null;
        if (str != null && str.length() != 0) {
            if (k.b(str, "/tis/device/register") || k.b(str, "/tis/device/token/get")) {
                str2 = "auth";
            } else if (k.b(str, "/tis/device/get/tc/feature")) {
                str2 = "feature";
            } else if (k.b(str, "/tis/ai/ws/audio/device/asr")) {
                str2 = BaseAudioRecorder.SCENARIO_ASR;
            } else if (k.b(str, "/tis/ai/ws/audio/device/chat")) {
                str2 = "voice_chat";
            } else if (k.b(str, "/tis/ai/ws/audio/device/voiceclone")) {
                str2 = "voice_clone";
            } else if (k.b(str, "/starburst/ai/tts/bidirection") || k.b(str, "/starburst/ai/tts")) {
                str2 = "text_to_speech";
            } else if (k.b(str, "/tis/ai/device/llm/stream")) {
                str2 = "llm_stream";
            } else if (k.b(str, "/starburst/ai/tos/sign") || k.b(str, "/tis/ai/multi/modal/image/recognize")) {
                str2 = "no_ppe";
            } else if (k.b(str, "/tis/ai/audio/device/asr/byfile/")) {
                str2 = "file";
            } else if (k.b(str, "/tis/ai/interest/")) {
                str2 = "feed";
            } else if (k.b(str, "/starburst/ai/aigc/")) {
                str2 = "aigc";
            } else if (k.b(str, "/tis/ai/device/podcast/stream")) {
                str2 = "podcast";
            } else if (k.b(str, "/starburst/ai/ws/gui/control")) {
                str2 = "gui_control";
            }
        }
        return (T) addPpeHeadersIfNeeded(str2);
    }

    public abstract RequestCall build();

    public T headers(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public T id(int i9) {
        this.id = i9;
        return this;
    }

    public T tag(Object obj) {
        this.tag = obj;
        return this;
    }

    public T url(String str) {
        this.url = str;
        return this;
    }

    public T addPpeHeadersIfNeeded(String str) {
        HashMap<String, String> mapC = k.c(str);
        j.f("OkHttpRequestBuilder", "addPpeHeadersIfNeeded link=" + str + ", config=" + mapC);
        if (mapC != null && !mapC.isEmpty()) {
            for (Map.Entry<String, String> entry : mapC.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    addHeader(key, value);
                    j.f("OkHttpRequestBuilder", "addHeader link=" + str + ", " + key + "==>" + value);
                }
            }
        }
        return this;
    }
}
