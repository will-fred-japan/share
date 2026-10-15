package com.engagelab.privates.push.api;

import com.engagelab.privates.common.log.MTCommonLog;

/* JADX INFO: loaded from: classes.dex */
public class MTPushCollectControl {
    private static final String TAG = "MTPushCollectControl";
    private boolean gaid = true;

    public interface Type {
        public static final String AID = "aid";
        public static final String GAID = "gaid";
    }

    @Deprecated
    public boolean getAid() {
        return false;
    }

    public boolean getGaid() {
        return this.gaid;
    }

    @Deprecated
    public void setAid(boolean z8) {
        MTCommonLog.w(TAG, "setAid is deprecated and has no effect: Android ID is no longer collected.");
    }

    public void setGaid(boolean z8) {
        this.gaid = z8;
    }
}
