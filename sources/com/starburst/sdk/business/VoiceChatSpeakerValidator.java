package com.starburst.sdk.business;

import R7.l;
import com.starburst.sdk.req.VcSpeaker;

/* JADX INFO: loaded from: classes.dex */
public final class VoiceChatSpeakerValidator {
    public static final VoiceChatSpeakerValidator INSTANCE = new VoiceChatSpeakerValidator();

    private VoiceChatSpeakerValidator() {
    }

    public final boolean isConfigured(VcSpeaker vcSpeaker) {
        if (vcSpeaker == null) {
            return false;
        }
        String id = vcSpeaker.getId();
        if (id != null && !l.V(id)) {
            return true;
        }
        String role = vcSpeaker.getRole();
        return (role == null || l.V(role)) ? false : true;
    }
}
