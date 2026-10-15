package com.starburst.sdk.core.asr;

import android.text.TextUtils;
import com.starburst.sdk.req.VoiceChatStartConfig;

/* JADX INFO: loaded from: classes.dex */
public class AsrConfig {
    public int endWindowSize = VoiceChatStartConfig.DEFAULT_END_WINDOW_SIZE;
    public boolean enableSpeakerSeparate = false;
    public int ttsSampleRate = 16000;
    public boolean llmTranslate = false;
    public float ttsSpeed = 1.0f;
    public boolean onlyDispatchDefinite = false;

    public boolean shouldDispatch(Boolean bool, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zEquals = Boolean.TRUE.equals(bool);
        if (this.onlyDispatchDefinite) {
            return zEquals;
        }
        if (zEquals) {
            return true;
        }
        if (str2 == null) {
            str2 = "";
        }
        return !str.equals(str2);
    }
}
