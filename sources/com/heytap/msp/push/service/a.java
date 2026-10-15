package com.heytap.msp.push.service;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.d.e;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.EnhanceDataMessage;

/* JADX INFO: loaded from: classes.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14414a = "EnhanceDataMessageParser";

    @Override // com.heytap.mcssdk.d.e
    public BaseMode a(Context context, int i9, Intent intent) {
        if (intent == null) {
            com.heytap.mcssdk.utils.e.d(f14414a, "Intent is null, cannot parse message");
            return null;
        }
        if (i9 != 4117) {
            com.heytap.mcssdk.utils.e.d(f14414a, "Message type mismatch, expected: 4117, got: " + i9);
            return null;
        }
        try {
            com.heytap.mcssdk.utils.e.b(f14414a, "Parsing enhanced data message, type: " + i9);
            EnhanceDataMessage enhanceDataMessage = new EnhanceDataMessage(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14288e)), com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f14286c)), com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")), i9);
            com.heytap.mcssdk.utils.e.b(f14414a, "Successfully parsed enhanced data message: " + enhanceDataMessage.getMessageID());
            return enhanceDataMessage;
        } catch (Exception e9) {
            com.heytap.mcssdk.utils.e.e(f14414a, "Error parsing enhanced data message: " + e9.getMessage());
            return null;
        }
    }
}
